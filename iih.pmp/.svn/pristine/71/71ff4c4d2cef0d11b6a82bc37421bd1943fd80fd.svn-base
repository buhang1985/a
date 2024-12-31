package iih.pmp.pay.s.bp;

import org.apache.commons.lang.exception.ExceptionUtils;

import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipayTradeCancelResponse;
import com.alipay.demo.trade.config.Constants;
import com.alipay.demo.trade.model.builder.AlipayTradeCancelRequestBuilder;
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
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.utils.PmpAliPayLogUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class AlipayCancelBP {
	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();

	/**
	 * 支付宝订单撤销
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public OrdRstDTO exec(OrdReqDTO dto) throws BizException {

		if (!AlipayConfigInitUtil.LoadConfig())
			throw new BizException("支付宝环境配置文件加载失败");

		AlipayTradeService service = new AlipayTradeServiceImpl.ClientBuilder().build();

		// 撤销前校验订单状态，只有等待支付和未知的订单才可撤销
		OrdDO o = findOrd(dto);
		OrdRstDTO rst = new OrdRstDTO();
		if (o == null) {
			rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
			rst.setMsg("撤销拒绝： 原订单不存在");
		} else if (o.getOrd_status() == OrdStatusEnum.PAID || o.getOrd_status() == OrdStatusEnum.FAIL) {
			rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
			rst.setMsg("撤销拒绝： 原订单状态错误");
		} else if (o.getOrd_status() == OrdStatusEnum.UNKNOWN) {
			// 对于未知订单先调用撤销接口，再根据返回结果回写数据，组装结果dto
			AlipayTradeCancelRequestBuilder builder = new AlipayTradeCancelRequestBuilder();
			TradeDO t = findUnconfirmPayTrade(o);
			builder.setOutTradeNo(t.getTrade_no());
			AlipayTradeCancelResponse result;
			try {
				result = service.cancelPayResult(builder);
			} catch (AlipayApiException e) {
				PmpAliPayLogUtils.logExAndTitle(e, "支付宝订单撤销异常");
				String msg = String.format("支付宝订单撤销异常,异常信息:%s", ExceptionUtils.getFullStackTrace(e));
				throw new BizException(msg);
			}
			writeBackTradeAfterCancel(result, t);
			writeBackOrdAfterCancel(result, o);

			if (Constants.SUCCESS.equals(result.getCode())) {
				rst.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
				rst.setMsg("撤销成功");
			} else {
				rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
				rst.setMsg("撤销失败");
			}
		} else {
			// 对于等待支付的订单则直接将库内数据记为失败
			TradeDO t = findUnconfirmPayTrade(o);
			writeBackTradeAfterCancelWhenWait(t);
			writeBackOrdAfterCancelWhenWait(o);

			rst.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
			rst.setMsg("撤销成功");
		}

		return rst;
	}

	private OrdDO findOrd(OrdReqDTO dto) throws BizException {

		OrdDO[] rst;
		IOrdRService service = ServiceFinder.find(IOrdRService.class);
		rst = service.findByAttrValString(OrdDO.ORD_NO, dto.getOrd_no());

		return ArrayUtil.isEmpty(rst) ? null : rst[0];
	}

	private TradeDO findUnconfirmPayTrade(OrdDO o) throws BizException {

		ITradeRService service = ServiceFinder.find(ITradeRService.class);
		// 根据订单获取未知状态支付交易记录，此记录每个订单只有一条
		String whereSql = TradeDO.ID_ORD + " = '" + o.getPkVal() + "' and " + TradeDO.EU_DIRECT + " = "
				+ PmpPayConst.TRADE_DIRECT_PAY + " and " + TradeDO.TRADE_STATUS + " <> " + TradeStatusEnum.PAY_FAIL;
		TradeDO[] rst = service.find(whereSql, "", FBoolean.FALSE);
		return ArrayUtil.isEmpty(rst) ? null : rst[0];
	}

	private void writeBackTradeAfterCancel(AlipayTradeCancelResponse rst, TradeDO trade) throws BizException {
		ITradeCudService service = ServiceFinder.find(ITradeCudService.class);

		if (trade != null) {
			if (Constants.SUCCESS.equals(rst.getCode())) {
				trade.setTrade_status(TradeStatusEnum.PAY_FAIL);
				trade.setDt_finish(pmputils.getServerDateTime());
				trade.setStatus(DOStatus.UPDATED);
			} else {
				trade.setTrade_status(TradeStatusEnum.TRADE_UNKNOWN);
				trade.setStatus(DOStatus.UPDATED);
			}

			service.save(new TradeDO[] { trade });
		}
	}

	private void writeBackTradeAfterCancelWhenWait(TradeDO trade) throws BizException {
		ITradeCudService service = ServiceFinder.find(ITradeCudService.class);

		if (trade != null) {
			trade.setTrade_status(TradeStatusEnum.PAY_FAIL);
			trade.setDt_finish(pmputils.getServerDateTime());
			trade.setStatus(DOStatus.UPDATED);

			service.save(new TradeDO[] { trade });
		}
	}

	private void writeBackOrdAfterCancel(AlipayTradeCancelResponse rst, OrdDO o) throws BizException {
		IOrdCudService service = ServiceFinder.find(IOrdCudService.class);

		if (o != null) {
			if (Constants.SUCCESS.equals(rst.getCode())) {
				o.setOrd_status(OrdStatusEnum.FAIL);
				o.setStatus(DOStatus.UPDATED);
			} else {
				o.setOrd_status(OrdStatusEnum.UNKNOWN);
				o.setStatus(DOStatus.UPDATED);
			}

			service.save(new OrdDO[] { o });
		}
	}

	private void writeBackOrdAfterCancelWhenWait(OrdDO o) throws BizException {
		IOrdCudService service = ServiceFinder.find(IOrdCudService.class);

		if (o != null) {
			o.setOrd_status(OrdStatusEnum.FAIL);
			o.setStatus(DOStatus.UPDATED);

			service.save(new OrdDO[] { o });
		}
	}
}
