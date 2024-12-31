package iih.pmp.pay.util.wxvalidate;

import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.s.bp.WXPayBP;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.WXPayAppUtils;
import iih.pmp.pay.util.WXParamUtils.RFQueryRNTParamConst;
import iih.pmp.pay.util.WXParamUtils.WXCommonRntParamCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;

public class WXRefundValidateBP {
	WXPayAppUtils utils=new WXPayAppUtils();
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	private WXPayBP wxpaybp;
	public final String errcode = "errcode";

	public Map<String, Object> isTradecanReFund(OrdReqDTO dto)
			throws BizException {
		Map<String, Object> rnt = new HashMap<>();
		TradeDO[] tras = pmputils.getRefundTradeDO8ord(dto);
		rnt = isTradecanReFund_old(dto, tras);
		return rnt;
	}


	/**
	 * 退款校验
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	private Map<String, Object> isTradecanReFund_old(OrdReqDTO dto,
			TradeDO[] tras) throws BizException {
		// 如果申请退款失败，继续用相同的退款单号申请退款
		boolean flag = false;
		StringBuilder sb = new StringBuilder();
		List<TradeDO> tralist = new ArrayList<>();
		Map<String, Object> rnt = new HashMap<>();
		if (tras != null && tras.length > 0) {
			for (TradeDO t : tras) {
				// todo 需要查询退款
				flag = this.validaterefundtrade(t, dto, sb, tralist);
				if (flag == false)
					break;
			}
			pmputils.getTradeCUDService().save(tras);

			if (flag && tralist.size() > 0) {
				// 存在多笔失败交易，返回第一笔
				rnt.put("tradedo", tralist.get(0));
			} else {
				rnt.put(errcode, sb.toString());
			}
		} else {
			flag = true;
		}
		rnt.put("flag", flag);
		return rnt;
	}

	private boolean validaterefundtrade(TradeDO t, OrdReqDTO dto,
			StringBuilder sb, List<TradeDO> tralist) throws BizException {
		boolean flag = false;
		if (TradeStatusEnum.REFUND_SUCCESS.equals(t.getTrade_status())) {
			flag = this.wxrefundquery(t, dto, sb, tralist);

		} else if (TradeStatusEnum.REFUND_FAIL.equals(t.getTrade_status())) {
			flag = true;
			tralist.add(t);

		} else if (TradeStatusEnum.CLOSED.equals(t.getTrade_status())) {
			flag = true;
		} else if (t.getTrade_status().equals(TradeStatusEnum.REFUNDING)
				|| TradeStatusEnum.TRADE_UNKNOWN.equals(t.getTrade_status())) {
			// todo 需要查询退款
			flag = this.wxrefundquery(t, dto, sb, tralist);

		}

		return flag;

	}

	private boolean wxrefundquery(TradeDO t, OrdReqDTO dto, StringBuilder sb,
			List<TradeDO> tralist) throws BizException {
		boolean flag = false;
		Map<String, String> r = this.getWXPayBP()
				.doRefundQuery(t.getTrade_no());
		if (r != null
				&& WXCommonRntParamCode.SUCCESS.equals(r
						.get(WXCommonRntParamCode.RETURN_CODE))) {
			if (WXCommonRntParamCode.SUCCESS.equals(r
					.get(WXCommonRntParamCode.RESULT_CODE))) {
				Map<String, String> m = utils.HandleRntParam(r);
				String status = RFQueryRNTParamConst.REFUND_STATUS;
				if (!m.containsKey(status)) {
					status = m.get(utils.getStatusName(m));
				}
				if ("SUCCESS".equals(status)) {
					flag = false;
					updateTradeStatusnew(t, TradeStatusEnum.REFUND_SUCCESS);
					sb.append(this.getOrdErrMsg(dto, "已退款"));

				} else if ("REFUNDCLOSE".equals(status)) {
					// todo 退款已关闭是否可以用同样的单号继续退款？？？？
					flag = true;
					updateTradeStatusnew(t, TradeStatusEnum.CLOSED);
				} else if ("PROCESSING".equals(status)) {
					flag = false;
					updateTradeStatusnew(t, TradeStatusEnum.REFUNDING);
					sb.append(this.getOrdErrMsg(dto, "退款中"));

				} else if ("CHANGE".equals(status)) {
					flag = true;
					updateTradeStatusnew(t, TradeStatusEnum.REFUND_FAIL);
					tralist.add(t);
				}
			} else if (r.get(WXCommonRntParamCode.ERR_CODE).equals(
					"REFUNDNOTEXIST")) {
				flag = true;
				updateTradeStatusnew(t, TradeStatusEnum.REFUND_FAIL);
				sb.append(this.getOrdErrMsg(dto,
						r.get(WXCommonRntParamCode.ERR_CODE_DES)));

			} else {
				flag = false;

			}

		} else {
			flag = false;

		}
		return flag;
	}

	private void updateTradeStatusnew(TradeDO t, int tradestatus)
			throws BizException {
		if (!t.getTrade_status().equals(tradestatus)) {
			t.setTrade_status(tradestatus);
			t.setStatus(DOStatus.UPDATED);
		//	PmpPayAppUtils.getTradeCUDService().update(new TradeDO[] { t });
		}
	}

	private WXPayBP getWXPayBP() {
		if (this.wxpaybp == null)
			this.wxpaybp = new WXPayBP();
		return this.wxpaybp;
	}

	private String getOrdErrMsg(OrdReqDTO o, String msg) {
		return "订单已存在，用户ID:" + o.getId_user_req()
				+ ",订单号：" + o.getOrd_no() + ",退款单号： " + o.getRefund_req_no()
				+ "," + msg;
	}
	
	/**
	 * 对账时使用
	 * @param dto
	 * @param tra
	 * @return
	 * @throws BizException
	 */
		public Map<String, Object> isTradecanReFund8trade(OrdReqDTO dto, TradeDO tra)
				throws BizException {
			Map<String, Object> rnt = new HashMap<>();

			rnt = isTradecanReFund_old(dto, new TradeDO[] { tra });
			return rnt;
		}

}
