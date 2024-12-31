package iih.pmp.pay.s.bp;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

import org.apache.commons.lang.exception.ExceptionUtils;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeCreateRequest;
import com.alipay.api.response.AlipayTradeCreateResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.demo.trade.config.Configs;
import com.alipay.demo.trade.config.Constants;
import com.alipay.demo.trade.model.TradeStatus;
import com.alipay.demo.trade.model.builder.AlipayTradePrecreateRequestBuilder;
import com.alipay.demo.trade.model.result.AlipayF2FPrecreateResult;
import com.alipay.demo.trade.service.AlipayTradeService;
import com.alipay.demo.trade.service.impl.AlipayTradeServiceImpl;

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
import com.alipay.demo.trade.utils.AlipayConfigInitUtil;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayAppUtils;
import iih.pmp.pay.utils.PmpAliPayLogUtils;

public class AlipayPayCreateBP {
	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();

	/**
	 * 支付宝订单创建（适用于扫码支付和生活号支付）
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

		// 根据支付场景编码判定后续处理（调用接口，回写数据 以及组装返回dto）
		if (PmpPayConst.SCANPAY_SCENE_CODE.equals(dto.getSd_scene())) {
			AlipayTradePrecreateRequestBuilder builder = new AlipayTradePrecreateRequestBuilder();
			builder.setOutTradeNo(tradeNo);
			builder.setSubject(dto.getSubject());
			builder.setTotalAmount(dto.getAmount().toString());
			builder.setBody(dto.getBody());
			builder.setStoreId("1");
			builder.setTimeoutExpress("120m");
			builder.setNotifyUrl("http://59.108.125.241:8089/pmp/AlipayPayNotifyHandler");

			AlipayF2FPrecreateResult result;
			try {
				result = service.tradePrecreate(builder);
			} catch (AlipayApiException e) {
				PmpAliPayLogUtils.logExAndTitle(e, "扫码支付预下单异常");
				String msg = String.format("扫码支付预下单异常,异常信息:%s", ExceptionUtils.getFullStackTrace(e));
				throw new BizException(msg);
			}

			// 如果接口返回成功，则订单和交易数据回写为成功；否则一律计为失败
			writeBackTrade(result, trade);
			writeBackOrd(result, ord);

			switch (result.getTradeStatus()) {
			case SUCCESS:
				rst.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
				rst.setMsg("扫码支付预下单成功");
				AlipayTradePrecreateResponse response = result.getResponse();
				// 返回扫码支付必须的支付2维码
				rst.setQr_code(PmpPayAppUtils.getQRCodeImge(response.getQrCode()));
				break;

			case FAILED:
				rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
				rst.setTrade_no(trade.getTrade_no());
				rst.setMsg("扫码支付预下单失败");
				break;

			case UNKNOWN:
				rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
				rst.setTrade_no(trade.getTrade_no());
				rst.setMsg("系统异常，扫码支付预下单失败");
				break;

			default:
				rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
				rst.setMsg("系统异常");
				break;
			}
		} else if (PmpPayConst.PUBLICPAU_SCENE_CODE.equals(dto.getSd_scene())) {
			AlipayTradeCreateResponse result = wapPayCreate(tradeNo, dto);

			// 如果接口返回成功，则订单和交易数据回写为成功；否则一律计为失败
			writeBackTrade(result, trade);
			writeBackOrd(result, ord);

			if (result == null) {
				rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
				rst.setMsg("系统异常，JSAPI支付下单失败");
			} else if (Constants.SUCCESS.equals(result.getCode())) {
				rst.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
				rst.setMsg("JSAPI支付下单成功");
				// 返回JSAPI支付必须的交易号
				rst.setTrade_no(result.getOutTradeNo());
				rst.setTrade_no_chl(result.getTradeNo());
			} else {
				rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
				rst.setMsg("JSAPI支付下单失败");
				rst.setTrade_no(result.getOutTradeNo());
			}
		} else {
			rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
			rst.setMsg("支付场景错误");
		}

		return rst;
	}

	private void writeBackTrade(AlipayF2FPrecreateResult rst, TradeDO t) throws BizException {
		ITradeCudService service = ServiceFinder.find(ITradeCudService.class);

		if (TradeStatus.SUCCESS == rst.getTradeStatus()) {
			t.setTrade_status(TradeStatusEnum.PAY_WAIT);
			t.setQr_code(rst.getResponse().getQrCode());
			t.setStatus(DOStatus.UPDATED);
		} else {
			t.setTrade_status(TradeStatusEnum.PAY_FAIL);
			// t.setDt_finish(pmputils.getServerDateTime());
			t.setStatus(DOStatus.UPDATED);
		}

		service.save(new TradeDO[] { t });
	}

	private void writeBackTrade(AlipayTradeCreateResponse rst, TradeDO t) throws BizException {
		ITradeCudService service = ServiceFinder.find(ITradeCudService.class);

		if (rst != null) {
			if (Constants.SUCCESS.equals(rst.getCode())) {
				t.setTrade_status(TradeStatusEnum.PAY_WAIT);
				t.setStatus(DOStatus.UPDATED);
			} else {
				t.setTrade_status(TradeStatusEnum.PAY_FAIL);
				// t.setDt_finish(pmputils.getServerDateTime());
				t.setStatus(DOStatus.UPDATED);
			}

			service.save(new TradeDO[] { t });
		}
	}

	private void writeBackOrd(AlipayF2FPrecreateResult rst, OrdDO o) throws BizException {
		IOrdCudService service = ServiceFinder.find(IOrdCudService.class);

		if (TradeStatus.SUCCESS == rst.getTradeStatus()) {
			o.setOrd_status(OrdStatusEnum.WAIT_TO_PAY);
			o.setStatus(DOStatus.UPDATED);
		} else {
			o.setOrd_status(OrdStatusEnum.FAIL);
			o.setStatus(DOStatus.UPDATED);
		}

		service.save(new OrdDO[] { o });
	}

	private void writeBackOrd(AlipayTradeCreateResponse rst, OrdDO o) throws BizException {
		IOrdCudService service = ServiceFinder.find(IOrdCudService.class);

		if (rst != null) {
			if (Constants.SUCCESS.equals(rst.getCode())) {
				o.setOrd_status(OrdStatusEnum.WAIT_TO_PAY);
				o.setStatus(DOStatus.UPDATED);
			} else {
				o.setOrd_status(OrdStatusEnum.FAIL);
				o.setStatus(DOStatus.UPDATED);
			}

			service.save(new OrdDO[] { o });
		}
	}

	private AlipayTradeCreateResponse wapPayCreate(String tradeNo, OrdReqDTO dto) {
		AlipayClient alipayClient = new DefaultAlipayClient(Configs.getOpenApiDomain(), Configs.getAppid(),
				Configs.getPrivateKey(), "json", "utf-8", Configs.getAlipayPublicKey(), Configs.getSignType());

		AlipayTradeCreateRequest request = new AlipayTradeCreateRequest();
		request.setNotifyUrl("http://caralho.free.ngrok.cc/pmp/payNotifyHandler");
		request.setBizContent("{" + "\"out_trade_no\":\"" + tradeNo + "\"," + "\"total_amount\":"
				+ dto.getAmount().toString() + "," + "\"subject\":\"" + dto.getSubject() + "\"," + "\"body\":\""
				+ dto.getBody() + "\"," + "\"buyer_id\":\"" + dto.getBuyer_id() + "\"," + "\"store_id\":\"1\","
				+ "\"timeout_express\":\"90m\"" + "}");

		try {
			return (AlipayTradeCreateResponse) alipayClient.execute(request);
		} catch (AlipayApiException e) {
			return null;
		}
	}

	private TradeDO findTrade(String tradeNo) throws BizException {
		ITradeRService service = ServiceFinder.find(ITradeRService.class);

		TradeDO[] trades = service.findByAttrValString(TradeDO.TRADE_NO, tradeNo);

		return trades[0];
	}

	private OrdDO findOrd(TradeDO t) throws BizException {
		IOrdRService service = ServiceFinder.find(IOrdRService.class);

		return service.findById(t.getId_ord());
	}
}
