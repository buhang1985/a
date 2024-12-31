package iih.pmp.pay.s.bp;

import java.text.SimpleDateFormat;

import org.apache.commons.lang.exception.ExceptionUtils;

import com.alipay.api.AlipayApiException;
import com.alipay.demo.trade.model.TradeStatus;
import com.alipay.demo.trade.model.builder.AlipayTradeRefundRequestBuilder;
import com.alipay.demo.trade.model.result.AlipayF2FRefundResult;
import com.alipay.demo.trade.service.AlipayTradeService;
import com.alipay.demo.trade.service.impl.AlipayTradeServiceImpl;

import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ord.i.IOrdCudService;
import iih.pmp.pay.ord.i.IOrdRService;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.BizStatusEnum;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.trade.i.ITradeCudService;
import iih.pmp.pay.trade.i.ITradeRService;
import iih.pmp.pay.utils.PmpAliPayLogUtils;

import com.alipay.demo.trade.utils.AlipayConfigInitUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class AlipayRefundBP {

	/**
	 * 支付宝退款
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

		OrdRstDTO rst = new OrdRstDTO();
		if (dto.getTrade_no() == null) {
			rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
			rst.setMsg("交易未创建");
			return rst;
		}

		trade = findTrade(dto.getTrade_no());
		tradeNo = trade.getTrade_no();

		// 组装接口入参
		AlipayTradeRefundRequestBuilder builder = new AlipayTradeRefundRequestBuilder();
		builder.setOutTradeNo(trade.getTrade_no_rel());
		builder.setRefundAmount(dto.getAmount().toString());
		builder.setRefundReason(dto.getSubject());
		builder.setOutRequestNo(tradeNo);
		builder.setStoreId("1");

		// 调用接口
		AlipayF2FRefundResult result;
		try {
			result = service.tradeRefund(builder);
		} catch (AlipayApiException e) {
			PmpAliPayLogUtils.logExAndTitle(e, "支付宝退款异常");
			String msg = String.format("支付宝退款异常,异常信息:%s", ExceptionUtils.getFullStackTrace(e));
			throw new BizException(msg);
		}

		// 根据接口回写数据
		writeBackTrade(result, trade);
		writeBackOrd(result, trade);

		// 根据调用结果组装返回dto
		switch (result.getTradeStatus()) {
		case SUCCESS:
			rst.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
			rst.setTrade_no(trade.getTrade_no());
			rst.setTrade_no_chl(trade.getTrade_no_chl());
			rst.setMsg("退款成功");
			break;

		case FAILED:
			rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
			rst.setTrade_no(trade.getTrade_no());
			rst.setMsg("退款失败");
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

	private void writeBackTrade(AlipayF2FRefundResult rst, TradeDO t) throws BizException {
		ITradeCudService service = ServiceFinder.find(ITradeCudService.class);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		if (TradeStatus.SUCCESS == rst.getTradeStatus()) {
			t.setTrade_status(TradeStatusEnum.REFUND_SUCCESS);
			t.setTrade_no_chl(rst.getResponse().getTradeNo());
			t.setDt_finish(new FDateTime(sdf.format(rst.getResponse().getGmtRefundPay())));
			t.setBuyer_user_id(rst.getResponse().getBuyerUserId());
			t.setBuyer_logon_id(rst.getResponse().getBuyerLogonId());
			t.setStatus(DOStatus.UPDATED);
		} else if (TradeStatus.FAILED == rst.getTradeStatus()) {
			t.setTrade_status(TradeStatusEnum.REFUND_FAIL);
			// t.setDt_finish(PmpPayAppUtils.getServerDateTime());
			t.setStatus(DOStatus.UPDATED);
		}

		service.save(new TradeDO[] { t });
	}

	private void writeBackOrd(AlipayF2FRefundResult rst, TradeDO t) throws BizException {
		IOrdCudService service = ServiceFinder.find(IOrdCudService.class);

		OrdDO o = findOrd(t);

		if (TradeStatus.SUCCESS == rst.getTradeStatus()) {
			double d = o.getAmount().getDouble() - new FDouble(rst.getResponse().getRefundFee()).getDouble();
			o.setAmount_bk(new FDouble(d));
			o.setStatus(DOStatus.UPDATED);
		}

		service.save(new OrdDO[] { o });
	}

	private OrdDO findOrd(TradeDO t) throws BizException {
		IOrdRService service = ServiceFinder.find(IOrdRService.class);

		return service.findById(t.getId_ord());
	}

	private TradeDO findTrade(String tradeNo) throws BizException {
		ITradeRService service = ServiceFinder.find(ITradeRService.class);

		TradeDO[] rst = service.findByAttrValString(TradeDO.TRADE_NO, tradeNo);

		if (ArrayUtil.isEmpty(rst))
			return null;
		else
			return rst[0];
	}

}
