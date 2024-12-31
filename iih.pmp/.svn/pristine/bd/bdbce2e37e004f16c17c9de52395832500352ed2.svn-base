package iih.pmp.pay.web.pay;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.demo.trade.config.Configs;
import com.alipay.demo.trade.model.builder.AlipayTradeQueryRequestBuilder;
import com.alipay.demo.trade.model.result.AlipayF2FQueryResult;
import com.alipay.demo.trade.service.AlipayTradeService;
import com.alipay.demo.trade.service.impl.AlipayTradeServiceImpl;

import iih.pmp.pay.i.IPmpPayOperatorService;
import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ord.d.OrdStatusEnum;
import iih.pmp.pay.ord.i.IOrdCudService;
import iih.pmp.pay.ord.i.IOrdRService;
import iih.pmp.pay.ordqryrstdto.d.OrdQryRstDTO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.trade.i.ITradeCudService;
import iih.pmp.pay.trade.i.ITradeRService;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayAppUtils;
import iih.pmp.pay.web.pay.bp.WXPayNotifyAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 支付宝订单创建异步通知处理servlet
 * 
 * @author hehuan
 *
 */
@WebServlet("/AlipayPayNotifyHandler")
public class AlipayPayNotifyHandler extends HttpServlet {
	PmpPayAppUtils pmputils = new PmpPayAppUtils();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String message = "success";

		Map<String, String> params = new HashMap<String, String>();
		Enumeration<String> paramNames = req.getParameterNames();

		while (paramNames.hasMoreElements()) {
			String parameterName = paramNames.nextElement();
			params.put(parameterName, req.getParameter(parameterName));
		}

		boolean signVerified = false;
		try {
			// 对返回串进行签名校验
			signVerified = AlipaySignature.rsaCheckV1(params, Configs.getAlipayPublicKey(), "UTF-8",
					Configs.getSignType());
		} catch (AlipayApiException e) {
			message = "failed";
		}

		if (signVerified) {
			// 校验APPID
			if (!Configs.getAppid().equals(params.get("app_id"))) {
				message = "failed";
			} else {
				// 校验关联交易的金额与返回串内的金额是否一致
				String tradeNo = params.get("out_trade_no");
				FDouble amt = new FDouble(params.get("total_amount"));
				ITradeRService service = ServiceFinder.find(ITradeRService.class);
				try {
					TradeDO trade = service.findByAttrValString(TradeDO.TRADE_NO, tradeNo)[0];
					OrdDO ord = WXPayNotifyAppUtils.getOrdRService().findById(trade.getId_ord());
					OrdReqDTO dto = new OrdReqDTO();
					dto.setSd_chl(ord.getSd_chl());
					dto.setOrd_no(ord.getOrd_no());
					dto.setId_user_req(ord.getId_emp_op());
					OrdQryRstDTO[] rst = ServiceFinder.find(IPmpPayOperatorService.class).pmpquery(dto);
					if (!amt.equals(trade.getAmount())) {
						message = "failed";
					}
				} catch (Exception e) {
					message = "failed";
				}
			}
		} else {
			message = "failed";
		}

		String tradeNo = params.get("out_trade_no");
		TradeDO t = findTrade(tradeNo);
		OrdDO o = findOrd(t);

		// 如果校验不通过，调用一次查询接口尝试确定支付结果，如果返回确定结果（成功或失败），则回写数据
		if ("failed".equals(message)) {
			AlipayTradeService service;
			try {
				service = new AlipayTradeServiceImpl.ClientBuilder().build();
				AlipayTradeQueryRequestBuilder builder = new AlipayTradeQueryRequestBuilder().setOutTradeNo(tradeNo);
				AlipayF2FQueryResult result = service.queryTradeResult(builder);
				writeBackTradeAfterQuery(result, t);
				writeBackOrdAfterQuery(result, o);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AlipayApiException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			// 校验通过则直接回写数据
			String status = params.get("trade_status");
			if ("TRADE_SUCCESS".equals(status)) {
				writeBackTrade(params, t);
				writeBackOrd(params, o);
			}
		}

		// 向支付宝服务器回复消息完成回调
		reply(resp, message);
	}

	private void reply(HttpServletResponse resp, String message) throws IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print(message);
		out.flush();
		out.close();
	}

	private OrdDO findOrd(TradeDO t) {
		IOrdRService service = ServiceFinder.find(IOrdRService.class);

		try {
			return service.findById(t.getId_ord());
		} catch (Exception e) {
			return null;
		}
	}

	private TradeDO findTrade(String tradeNo) {
		ITradeRService service = ServiceFinder.find(ITradeRService.class);

		try {
			return service.findByAttrValString(TradeDO.TRADE_NO, tradeNo)[0];
		} catch (Exception e) {
			return null;
		}
	}

	private void writeBackTradeAfterQuery(AlipayF2FQueryResult rst, TradeDO trade) {
		ITradeCudService service = ServiceFinder.find(ITradeCudService.class);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		if (trade != null) {
			switch (rst.getTradeStatus()) {
			case SUCCESS:
				trade.setTrade_status(TradeStatusEnum.PAY_SUCCESS);
				trade.setTrade_no_chl(rst.getResponse().getTradeNo());
				trade.setDt_finish(new FDateTime(sdf.format(rst.getResponse().getSendPayDate())));
				trade.setBuyer_user_id(rst.getResponse().getBuyerUserId());
				trade.setBuyer_logon_id(rst.getResponse().getBuyerLogonId());
				trade.setStatus(DOStatus.UPDATED);
				break;

			case FAILED:
				trade.setTrade_status(TradeStatusEnum.PAY_FAIL);
				trade.setDt_finish(new PmpPayAppBaseUtils().getServerDateTime());
				trade.setStatus(DOStatus.UPDATED);
				break;

			case UNKNOWN:
				trade.setTrade_status(TradeStatusEnum.TRADE_UNKNOWN);
				trade.setStatus(DOStatus.UPDATED);
				break;
			}

			try {
				service.save(new TradeDO[] { trade });
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void writeBackOrdAfterQuery(AlipayF2FQueryResult rst, OrdDO o) {
		IOrdCudService service = ServiceFinder.find(IOrdCudService.class);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		if (o != null) {
			switch (rst.getTradeStatus()) {
			case SUCCESS:
				o.setOrd_status(OrdStatusEnum.PAID);
				o.setDt_pay(new FDateTime(sdf.format(rst.getResponse().getSendPayDate())));
				o.setStatus(DOStatus.UPDATED);
				break;

			case FAILED:
				o.setOrd_status(OrdStatusEnum.FAIL);
				o.setStatus(DOStatus.UPDATED);
				break;

			case UNKNOWN:
				o.setOrd_status(OrdStatusEnum.UNKNOWN);
				o.setStatus(DOStatus.UPDATED);
				break;
			}

			try {
				service.save(new OrdDO[] { o });
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void writeBackTrade(Map<String, String> params, TradeDO t) {
		ITradeCudService service = ServiceFinder.find(ITradeCudService.class);

		if (t != null) {
			t.setTrade_status(TradeStatusEnum.PAY_SUCCESS);
			t.setTrade_no_chl(params.get("trade_no"));
			t.setDt_finish(new FDateTime(params.get("gmt_payment")));
			t.setBuyer_user_id(params.get("buyer_id"));
			t.setBuyer_logon_id(params.get("buyer_logon_id"));
			t.setStatus(DOStatus.UPDATED);
		}

		try {
			service.save(new TradeDO[] { t });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void writeBackOrd(Map<String, String> params, OrdDO o) {
		IOrdCudService service = ServiceFinder.find(IOrdCudService.class);

		if (o != null) {
			o.setOrd_status(OrdStatusEnum.PAID);
			o.setDt_pay(new FDateTime(params.get("gmt_payment")));
			o.setStatus(DOStatus.UPDATED);
		}

		try {
			service.save(new OrdDO[] { o });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
