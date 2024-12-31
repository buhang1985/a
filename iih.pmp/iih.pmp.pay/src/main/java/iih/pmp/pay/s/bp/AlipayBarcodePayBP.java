package iih.pmp.pay.s.bp;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

import org.apache.commons.lang.exception.ExceptionUtils;

import com.alipay.api.AlipayApiException;
import com.alipay.demo.trade.model.TradeStatus;
import com.alipay.demo.trade.model.builder.AlipayTradePayRequestBuilder;
import com.alipay.demo.trade.model.result.AlipayF2FPayResult;
import com.alipay.demo.trade.service.AlipayTradeService;
import com.alipay.demo.trade.service.impl.AlipayTradeServiceImpl;
import com.alipay.demo.trade.utils.AlipayConfigInitUtil;

import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ord.d.OrdStatusEnum;
import iih.pmp.pay.ord.i.IOrdCudService;
import iih.pmp.pay.ord.i.IOrdRService;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.BizStatusEnum;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.trade.i.ITradeCudService;
import iih.pmp.pay.trade.i.ITradeRService;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.utils.PmpAliPayLogUtils;

public class AlipayBarcodePayBP {
	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();

	/**
	 * 支付宝条码支付
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public OrdRstDTO exec(OrdReqDTO dto) throws BizException {
		if (!AlipayConfigInitUtil.LoadConfig())
			throw new BizException("支付宝环境配置文件加载失败");

		AlipayTradeService service = new AlipayTradeServiceImpl.ClientBuilder().build();

		String tradeNo;
		TradeDO trade;
		OrdDO ord;

		OrdRstDTO rst = new OrdRstDTO();

		if (dto.getTrade_no() == null) {
			rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
			rst.setMsg("交易未创建");
			return rst;
		}

		tradeNo = dto.getTrade_no();

		trade = findTrade(tradeNo);
		ord = findOrd(trade);

		// 组装接口入参
		AlipayTradePayRequestBuilder builder = new AlipayTradePayRequestBuilder();
		builder.setOutTradeNo(tradeNo);
		builder.setSubject(dto.getSubject());
		builder.setTotalAmount(dto.getAmount().toString());
		builder.setAuthCode(dto.getAuth_code());
		builder.setBody(dto.getBody());
		builder.setStoreId("1");

		// 调用接口
		AlipayF2FPayResult result;
		try {
			result = service.tradePay(builder);
		} catch (AlipayApiException e) {
			PmpAliPayLogUtils.logExAndTitle(e, "支付宝条码支付异常");
			String msg = String.format("支付宝条码支付异常,异常信息:%s", ExceptionUtils.getFullStackTrace(e));
			throw new BizException(msg);
		}

		// 根据调用结果回写数据
		writeBackTrade(result, trade);
		writeBackOrd(result, ord);

		// 根据调用结果组装返回dto
		switch (result.getTradeStatus()) {
		case SUCCESS:
			rst.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
			rst.setTrade_no(trade.getTrade_no());
			rst.setTrade_no_chl(trade.getTrade_no_chl());
			rst.setMsg("支付成功");
			break;

		case FAILED:
			rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
			rst.setTrade_no(trade.getTrade_no());
			rst.setMsg("支付失败");
			break;

		case UNKNOWN:
			rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
			rst.setTrade_no(trade.getTrade_no());
			rst.setMsg("系统异常，交易状态未知");
			break;

		default:
			rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
			rst.setMsg("交易返回异常");
			break;
		}

		return rst;
	}

	private OrdDO findOrd(TradeDO t) throws BizException {
		IOrdRService service = ServiceFinder.find(IOrdRService.class);

		return service.findById(t.getId_ord());
	}

	private void writeBackTrade(AlipayF2FPayResult rst, TradeDO t) throws BizException {
		ITradeCudService service = ServiceFinder.find(ITradeCudService.class);
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		if (TradeStatus.SUCCESS == rst.getTradeStatus()) {
			t.setTrade_status(TradeStatusEnum.PAY_SUCCESS);
			t.setTrade_no_chl(rst.getResponse().getTradeNo());
			// t.setDt_finish(new FDateTime(sdf.format(rst.getResponse().getGmtPayment())));
			t.setDt_finish(pmputils.getServerDateTime());
			t.setBuyer_user_id(rst.getResponse().getBuyerUserId());
			t.setBuyer_logon_id(rst.getResponse().getBuyerLogonId());
			t.setStatus(DOStatus.UPDATED);
		} else if (TradeStatus.FAILED == rst.getTradeStatus()) {
			t.setTrade_status(TradeStatusEnum.PAY_FAIL);
			// t.setDt_finish(pmputils.getServerDateTime());
			t.setStatus(DOStatus.UPDATED);
		}

		service.save(new TradeDO[] { t });
	}

	private void writeBackOrd(AlipayF2FPayResult rst, OrdDO o) throws BizException {
		IOrdCudService service = ServiceFinder.find(IOrdCudService.class);
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		if (TradeStatus.SUCCESS == rst.getTradeStatus()) {
			o.setOrd_status(OrdStatusEnum.PAID);
			// o.setDt_pay(new FDateTime(sdf.format(rst.getResponse().getGmtPayment())));
			o.setDt_pay(pmputils.getServerDateTime());
			o.setStatus(DOStatus.UPDATED);
		} else if (TradeStatus.FAILED == rst.getTradeStatus()) {
			o.setOrd_status(OrdStatusEnum.FAIL);
			o.setStatus(DOStatus.UPDATED);
		}

		service.save(new OrdDO[] { o });
	}

	private TradeDO findTrade(String tradeNo) throws BizException {
		ITradeRService service = ServiceFinder.find(ITradeRService.class);

		TradeDO[] trades = service.findByAttrValString(TradeDO.TRADE_NO, tradeNo);

		return trades[0];
	}

}
