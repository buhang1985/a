package iih.pmp.pay.util.wxvalidate;

import java.util.HashMap;
import java.util.Map;

import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ord.d.OrdStatusEnum;
import iih.pmp.pay.ordqryrstdto.d.OrdQryRstDTO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.BizStatusEnum;
import iih.pmp.pay.s.bp.WXPayBP;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.WXPayAppUtils;
import iih.pmp.pay.util.WXParamUtils.WXCommonRntParamCode;
import iih.pmp.pay.util.wxerrorcode.WXQueryErrorcode;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

public class WXPayValidateBP {
	private WXPayBP wxpaybp;
	WXPayAppUtils utils = new WXPayAppUtils();
	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();

	/**
	 * 统一下单、刷卡支付，判断是否可以再次支付
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> isOrdcanPay_new(OrdReqDTO dto, OrdQryRstDTO rst) throws BizException {
		// StringBuilder sb=new StringBuilder();
		FArrayList2 fa = this.HandlerOrdValidate(dto, rst);
		Map<String, Object> resultMap = (Map<String, Object>) fa.get(1);
		boolean flag = (boolean) fa.get(0);
		OrdDO[] ords = null;
		if (flag) {
			if (fa.size() <= 2) {
				return resultMap;
			}
		}
		if (flag) {
			ords = (OrdDO[]) fa.get(2);
			flag = validateOrd(ords[0], dto, rst);
		}
		if (flag) {
			flag = this.validateTrade(ords[0], dto, rst);
		}
		// 更新订单状态
		if (ords != null && ords.length == 1)
			ords = pmputils.getOrdCudService().update(ords);
		if (flag) {
			resultMap.put("orddo", ords[0]);
		} else {
			resultMap.put("flag", flag);
		}
		return resultMap;
	}

	@SuppressWarnings("unchecked")
	public FArrayList2 HandlerOrdValidate(OrdReqDTO dto, OrdQryRstDTO rst) throws BizException {

		FArrayList2 fa = new FArrayList2();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		boolean flag = false;
		OrdDO[] ords = pmputils.getOrdRService().findByAttrValString(OrdDO.ORD_NO, dto.getOrd_no());
		// 如果订单不存在，则可以刷卡支付
		if (ords == null || ords.length == 0) {
			flag = true;
			resultMap.put("flag", flag);
			fa.add(flag);
			fa.add(resultMap);
			return fa;
		}
		if (ords.length > 1) {
			flag = false;
			resultMap.put("flag", flag);
			rst.setErr_code_des(pmputils.getOrdErrMsg(dto, "对应多条订单记录"));
			fa.add(flag);
			fa.add(resultMap);
			return fa;
		} else if (!ords[0].getSd_chl().equals(PmpPayConst.WXPAY_CHANNEL_CODE)) {
			flag = false;
			resultMap.put("flag", flag);
			rst.setErr_code_des(pmputils.getOrdErrMsg(dto, "该订单已用支付宝支付，不可以再使用微信支付"));
			fa.add(flag);
			fa.add(resultMap);
			return fa;
		} else {
			flag = true;
		}
		resultMap.put("flag", flag);
		fa.add(flag);
		fa.add(resultMap);
		fa.add(ords);
		return fa;
	}

	public boolean validateOrd(OrdDO ordDO, OrdReqDTO dto, OrdQryRstDTO rst) throws BizException {
		boolean flag = false;
		if (ordDO.getOrd_status().equals(OrdStatusEnum.PAID)) {
			// 已支付，不可以再次支付
			// sb.append( PmpPayAppUtils.getOrdErrMsg(dto.getOrd_no(), "已支付"));
			TradeDO[] tras = pmputils.getTradeRService().find(
					" id_ord='" + ordDO.getId_ord() + "' and trade_status=" + TradeStatusEnum.PAY_SUCCESS, null,
					FBoolean.FALSE);
			if (tras == null || tras.length == 0) {
				utils.updateOrdStatus(ordDO, OrdStatusEnum.UNKNOWN);
				flag = true;
			} else {
				flag = this.queryWxTrade(tras[0], ordDO, rst);
				if (!flag) {
					rst.setTrade_no(tras[0].getTrade_no());
					rst.setTradetime(tras[0].getDt_req());
				}
			}

		} else if (OrdStatusEnum.FAIL.equals(ordDO.getOrd_status())
				|| OrdStatusEnum.UNKNOWN.equals(ordDO.getOrd_status())
				|| OrdStatusEnum.WAIT_TO_PAY.equals(ordDO.getOrd_status())) {
			// 支付失败，可以再次支付 失败原因有可能是系统超时，也属于状态未知，也需要重新校验
			flag = true;
		}
		return flag;
	}

	private boolean validateTrade(OrdDO ordDO, OrdReqDTO dto, OrdQryRstDTO rst) throws BizException {
		boolean flag = true;
		TradeDO[] tras = pmputils.getTradeDO8ord(ordDO);
		if (tras != null && tras.length > 0) {
			flag = false;
			// 查询交易表订单当前状态 todo
			for (TradeDO t : tras) {
				flag = this.tradevalidate(t, ordDO, dto, rst);
				if (!flag) {
					rst.setTrade_no(t.getTrade_no());
					rst.setTradetime(t.getDt_req());
					break;
				}
			}
			pmputils.getTradeCUDService().save(tras);
		}
		return flag;
	}

	/**
	 * 校验交易状态
	 * 
	 * @param t
	 * @param ordDO
	 * @param dto
	 * @param sb
	 * @return 布尔值，用来判断是否可以继续生成交易
	 * @throws BizException
	 */
	public boolean tradevalidate(TradeDO t, OrdDO ordDO, OrdReqDTO dto, OrdQryRstDTO rst) throws BizException {

		boolean flag = this.isTradecanpayagin(t, ordDO, rst);

		if (flag && (!(t.getTrade_status().equals(TradeStatusEnum.CLOSED)
				|| t.getTrade_status().equals(TradeStatusEnum.PAY_FAIL)
				|| t.getTrade_status().equals(TradeStatusEnum.REVOKED)))) {
			flag = this.queryWxTrade(t, ordDO, rst);
		}

		return flag;

	}

	/**
	 * 从微信后台查询数据
	 * 
	 * @param t
	 * @param ordDO
	 * @param sb
	 * @return
	 * @throws BizException
	 */
	private boolean queryWxTrade(TradeDO t, OrdDO ordDO, OrdQryRstDTO rst) throws BizException {

		boolean flag = false;

		Map<String, String> r = this.getWXPayBP().doOrderQuery(t.getTrade_no());
		if (r != null && WXCommonRntParamCode.SUCCESS.equals(r.get(WXCommonRntParamCode.RETURN_CODE))) {
			if (WXCommonRntParamCode.SUCCESS.equals(r.get(WXCommonRntParamCode.RESULT_CODE))) {

				String trade_state = r.get(WXCommonRntParamCode.TRADE_STATE);
				String total_fee = r.get(WXCommonRntParamCode.TOTAL_FEE);
				flag = this.HandleTradeState(trade_state, t, ordDO, rst, total_fee);

			} else {
				// todo 查询失败的情况
				if (TradeStatusEnum.PAY_FAIL
						.equals(WXQueryErrorcode.getTradeFailStatus(r.get(WXCommonRntParamCode.ERR_CODE)))) {
					flag = true;
					utils.updateTradeStatusnew(t, TradeStatusEnum.PAY_FAIL);
					utils.updateOrdStatus(ordDO, OrdStatusEnum.FAIL);
				} else if (TradeStatusEnum.TRADE_UNKNOWN
						.equals(WXQueryErrorcode.getTradeFailStatus(r.get(WXCommonRntParamCode.ERR_CODE)))) {
					flag = false;
					rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
					rst.setErr_code(r.get(WXCommonRntParamCode.ERR_CODE));
					rst.setErr_code_des(pmputils.getOrdErrMsg(ordDO.getOrd_no(), WXQueryErrorcode.getErrorCode(
							r.get(WXCommonRntParamCode.ERR_CODE), r.get(WXCommonRntParamCode.ERR_CODE_DES))));
				}
			}
		} else {
			flag = false;
			rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
			rst.setErr_code_des("微信后台查询失败！");
		}

		return flag;
	}

	/**
	 * 判断是否可以重新生成交易
	 * 
	 * @param t
	 * @param o
	 * @param sb
	 * @return
	 * @throws BizException
	 */
	public boolean isTradecanpayagin(TradeDO t, OrdDO o, OrdQryRstDTO rst) throws BizException {
		boolean flag = true;
		if (t.getTrade_status().equals(TradeStatusEnum.PAY_SUCCESS)) {
			flag = this.queryWxTrade(t, o, rst);
			// sb.append(PmpPayAppUtils.getOrdErrMsg(o.getOrd_no(), "已支付"));
			// flag = false;
			// WXPayAppUtils.updateOrdStatus(o, OrdStatusEnum.PAID);
		} else if (t.getTrade_status().equals(TradeStatusEnum.TURN_REFUND)) {
			// sb.append(PmpPayAppUtils.getOrdErrMsg(o.getOrd_no(), "转入退款"));
			// flag = false;
			// WXPayAppUtils.updateOrdStatus(o, OrdStatusEnum.PAID);
			flag = true;
		} else if (t.getTrade_status().equals(TradeStatusEnum.CLOSED)) {
			flag = true;
			utils.updateOrdStatus(o, OrdStatusEnum.FAIL);
		} else if (t.getTrade_status().equals(TradeStatusEnum.NOTPAY)) {
			flag = true;
			utils.updateOrdStatus(o, OrdStatusEnum.WAIT_TO_PAY);
		} else if (t.getTrade_status().equals(TradeStatusEnum.REFUND_SUCCESS)) {
			rst.setErr_code_des(pmputils.getOrdErrMsg(o.getOrd_no(), "已退款"));
			flag = false;
		} else if (t.getTrade_status().equals(TradeStatusEnum.PAY_WAIT)) {
			flag = true;
			utils.updateOrdStatus(o, OrdStatusEnum.WAIT_TO_PAY);
		} else if (t.getTrade_status().equals(TradeStatusEnum.REVOKED)) {
			flag = true;
			utils.updateOrdStatus(o, OrdStatusEnum.FAIL);
		} else if (t.getTrade_status().equals(TradeStatusEnum.TRADE_UNKNOWN)) {
			flag = true;
		} else if (t.getTrade_status().equals(TradeStatusEnum.PAY_FAIL)) {
			flag = true;
			utils.updateOrdStatus(o, OrdStatusEnum.FAIL);
		}
		return flag;
	}

	/**
	 * 根据交易状态，回写tradedo和orddo的状态
	 * 
	 * @param trade_state
	 * @param t
	 * @param o
	 * @param sb
	 * @return
	 * @throws BizException
	 */
	public boolean HandleTradeState(String trade_state, TradeDO t, OrdDO o, OrdQryRstDTO rst, String totalfee)
			throws BizException {
		boolean flag = false;
		if ("SUCCESS".equals(trade_state)) {
			// 支付成功
			rst.setErr_code_des(pmputils.getOrdErrMsg(o.getOrd_no(), "已支付"));
			flag = false;
			utils.updateTradeStatusnew(t, TradeStatusEnum.PAY_SUCCESS, totalfee);
			utils.updateOrdStatus2(o, OrdStatusEnum.PAID, "0");

		} else if ("REFUND".equals(trade_state)) {
			// 转入退款

			flag = this.isRefund(t, o, rst, totalfee);

		} else if ("CLOSED".equals(trade_state)) {
			// 已关闭
			flag = true;
			utils.updateTradeStatusnew(t, TradeStatusEnum.CLOSED);
			utils.updateOrdStatus(o, OrdStatusEnum.FAIL);

		} else if ("REVOKED".equals(trade_state)) {
			// 已撤销（刷卡支付）
			flag = true;
			utils.updateTradeStatusnew(t, TradeStatusEnum.REVOKED);
			utils.updateOrdStatus(o, OrdStatusEnum.FAIL);

		} else if ("USERPAYING".equals(trade_state)) {
			// 用户支付中
			flag = false;
			rst.setErr_code_des(pmputils.getOrdErrMsg(o.getOrd_no(), "已支付中，请调用查询接口！"));
			utils.updateTradeStatusnew(t, TradeStatusEnum.PAY_WAIT);
			utils.updateOrdStatus(o, OrdStatusEnum.WAIT_TO_PAY);

		} else if ("PAYERROR".equals(trade_state)) {
			// 支付失败(其他原因，如银行返回失败)
			flag = true;
			int state = TradeStatusEnum.PAY_FAIL;
			utils.updateTradeStatusnew(t, state);
			utils.updateOrdStatus(o, OrdStatusEnum.FAIL);
		} else if (trade_state.equals("NOTPAY")) {
			// 未支付
			flag = true;
			utils.updateTradeStatusnew(t, TradeStatusEnum.NOTPAY);
			utils.updateOrdStatus(o, OrdStatusEnum.FAIL);
		}

		return flag;
	}

	private WXPayBP getWXPayBP() {
		if (this.wxpaybp == null)
			this.wxpaybp = new WXPayBP();
		return this.wxpaybp;
	}

	private boolean isRefund(TradeDO t, OrdDO o, OrdQryRstDTO rst, String totalfee) throws BizException {
		Map<String, String> r = this.getWXPayBP().doRefundQuery8trade(t.getTrade_no());
		boolean flag = false;
		if (r != null && WXCommonRntParamCode.SUCCESS.equals(r.get(WXCommonRntParamCode.RETURN_CODE))) {
			if (WXCommonRntParamCode.SUCCESS.equals(r.get(WXCommonRntParamCode.RESULT_CODE))) {
				String refund_fee = r.get("refund_fee");
				String status = r.get(utils.getStatusName(r));
				if ("SUCCESS".equals(status)) {
					FDouble fee = pmputils.fenToYuan(refund_fee);
					FDouble total = pmputils.fenToYuan(totalfee);
					if (pmputils.isFDoubleEq(fee, total)) {
						flag = true;
						utils.updateTradeStatusnew(t, TradeStatusEnum.TURN_REFUND, totalfee);
						utils.updateOrdStatus(o, OrdStatusEnum.FAIL);
					} else {
						flag = false;
						rst.setErr_code_des(pmputils.getOrdErrMsg(o.getOrd_no(), "已支付"));
						utils.updateTradeStatusnew(t, TradeStatusEnum.PAY_SUCCESS, totalfee);
						utils.updateOrdStatus2(o, OrdStatusEnum.PAID, refund_fee);

					}
				}

			} else {
				rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
				rst.setErr_code(r.get(WXCommonRntParamCode.ERR_CODE));
				rst.setErr_code_des(r.get(WXCommonRntParamCode.ERR_CODE_DES));

			}

		} else {

			rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
			rst.setErr_code_des("查询微信后台失败！");
		}

		return flag;
	}

}
