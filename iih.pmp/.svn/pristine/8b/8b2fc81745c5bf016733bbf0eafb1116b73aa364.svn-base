package iih.pmp.pay.cmbc.s.bp;

import java.util.HashMap;
import java.util.Map;

import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ord.d.OrdStatusEnum;
import iih.pmp.pay.ordqryrstdto.d.OrdQryRstDTO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.BizStatusEnum;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.WXPayAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

public class CmbcPayValidator {
	CmbcPayBP paybp;
	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();
	WXPayAppUtils utils = new WXPayAppUtils();

	public CmbcPayValidator() {
		paybp = new CmbcPayBP();
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> isOrdcanPay(OrdReqDTO dto, OrdQryRstDTO rst) throws BizException {
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
			rst.setErr_code_des(pmputils.getOrdErrMsg(dto,"对应多条订单记录"));
			fa.add(flag);
			fa.add(resultMap);
			return fa;
		} else if (!ords[0].getSd_chl().equals(PmpPayConst.CMBC_CHANNEL_CODE)) {
			flag = false;
			resultMap.put("flag", flag);
			rst.setErr_code_des(pmputils.getOrdErrMsg(dto, "该订单已用支付宝或微信支付，不可以再使用民生银行支付"));
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
			// sb.append( pmputils.getOrdErrMsg(dto.getOrd_no(), "已支付"));
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
					rst.setBankorderno(tras[0].getBankorderno());
					rst.setTrade_no_chl(tras[0].getTrade_no_chl());
					rst.setBanktradeno(tras[0].getBanktradeno());
					rst.setMch_order_no(tras[0].getSd_ord());
					rst.setAmount(tras[0].getAmount());
				}
				pmputils.getTradeCUDService().save(tras);
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
					rst.setAmount(t.getAmount());
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

		Map<String, String> r = paybp.orderQuery((ordDO.getCode()), t.getTrade_no());
		if (r != null && "S".equals(r.get("gateReturnType"))) {
//			if (WXCommonRntParamCode.SUCCESS.equals(r
//					.get(WXCommonRntParamCode.RESULT_CODE))) {

			String trade_state = r.get("tradeStatus");
			String total_fee = r.get("amount");
			flag = this.HandleTradeState(trade_state, t, ordDO, rst, total_fee, r);

		} else {
			// todo 查询失败的情况
			flag = false;
			rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
			rst.setErr_code_des("民生银行后台查询失败！");
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
	public boolean HandleTradeState(String trade_state, TradeDO t, OrdDO o, OrdQryRstDTO rst, String totalfee,
			Map<String, String> r) throws BizException {
		boolean flag = false;
		if ("S".equals(trade_state)) {
			// 支付成功

			flag = false;
			utils.updateTradeStatusnew(t, TradeStatusEnum.PAY_SUCCESS, totalfee);
			utils.updateOrdStatus2(o, OrdStatusEnum.PAID, "0");
			HandleRefund(t, totalfee, o, rst);
			setNOVal(t, r.get("bankTradeNo"), r.get("centerSeqId"), r.get("bankOrderNo"));
			rst.setErr_code_des(pmputils.getOrdErrMsg(o.getOrd_no(), "已支付！金额：" + t.getAmount() + " 元!"));

		} else if ("E".equals(trade_state)) {
			// 支付失败(其他原因，如银行返回失败)
			flag = true;
			int state = TradeStatusEnum.PAY_FAIL;
			utils.updateTradeStatusnew(t, state);
			utils.updateOrdStatus(o, OrdStatusEnum.FAIL);
		} else if (trade_state.equals("R")) {
			// 未支付
			flag = false;
			utils.updateTradeStatusnew(t, TradeStatusEnum.NOTPAY);
			utils.updateOrdStatus(o, OrdStatusEnum.FAIL);
			rst.setErr_code_des(pmputils.getOrdErrMsg(o.getOrd_no(), "订单下单状态未知，请刷新界面！"));
		}

		return flag;
	}

	private void HandleRefund(TradeDO t, String totalfee, OrdDO o, OrdQryRstDTO rst) throws BizException {
		TradeDO[] tras = pmputils.getTradeRService().find(
				TradeDO.TRADE_NO_REL + " = '" + t.getTrade_no() + "' and eu_direct=" + PmpPayConst.TRADE_DIRECT_REFUND,
				"dt_req", FBoolean.FALSE);
		if (tras != null && tras.length > 0) {
			FDouble total = new FDouble(0);
			for (TradeDO tradeDO : tras) {
				if (TradeStatusEnum.REFUND_SUCCESS.equals(tradeDO.getTrade_status())
						|| TradeStatusEnum.TRADE_UNKNOWN.equals(tradeDO.getTrade_status())) {
					Map<String, String> r = paybp.orderQuery((o.getCode()), tradeDO.getTrade_no());
					if (r != null && "S".equals(r.get("gateReturnType"))) {
						String status = r.get("tradeStatus");
						String amount = r.get("amount");
						if ("S".equals(status)) {
							FDouble refund_f = pmputils.fenToYuan(amount);
							total = total.add(refund_f);
							setNOVal(tradeDO, r.get("bankTradeNo"), r.get("centerSeqId"), r.get("bankOrderNo"),
									refund_f);
							utils.updateTradeStatusnew(tradeDO, TradeStatusEnum.REFUND_SUCCESS);
						} else if ("E".equals(status)) {
							utils.updateTradeStatusnew(tradeDO, TradeStatusEnum.REFUND_FAIL);
						} else if ("R".equals(status)) {
							utils.updateTradeStatusnew(tradeDO, TradeStatusEnum.TRADE_UNKNOWN);
						}
					} else {
						rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
						rst.setErr_code_des("民生银行后台退款查询失败！");
						if (TradeStatusEnum.REFUND_SUCCESS.equals(tradeDO.getTrade_status())) {
							total = total.add(tradeDO.getAmount());
						}

					}
				}
			}
//			FDouble fee = pmputils.fenToYuan(totalfee);
			utils.updateOrdStatus(o, OrdStatusEnum.PAID, total, null);
			pmputils.getTradeCUDService().save(tras);
		}
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
			// sb.append(pmputils.getOrdErrMsg(o.getOrd_no(), "已支付"));
			// flag = false;
			// utils.updateOrdStatus(o, OrdStatusEnum.PAID);
		} else if (t.getTrade_status().equals(TradeStatusEnum.TURN_REFUND)) {
			// sb.append(pmputils.getOrdErrMsg(o.getOrd_no(), "转入退款"));
			// flag = false;
			// utils.updateOrdStatus(o, OrdStatusEnum.PAID);
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

	private void setNOVal(TradeDO t, String Banktradeno, String Trade_no_chl, String bandorderno) {
		if (!Banktradeno.equals(t.getBanktradeno())
				|| (Trade_no_chl != null && !Trade_no_chl.equals(t.getTrade_no_chl()))
				|| (bandorderno != null && !bandorderno.equals(t.getBankorderno()))) {
			t.setBanktradeno(Banktradeno);
			t.setTrade_no_chl(Trade_no_chl);
			t.setBankorderno(bandorderno);
			t.setStatus(DOStatus.UPDATED);
		}
	}

	private void setNOVal(TradeDO t, String Banktradeno, String Trade_no_chl, String bandorderno, FDouble fee) {
		if (!Banktradeno.equals(t.getBanktradeno())
				|| (Trade_no_chl != null && !Trade_no_chl.equals(t.getTrade_no_chl()))
				|| (bandorderno != null && !bandorderno.equals(t.getBankorderno()))
				|| !pmputils.isFDoubleEq(t.getAmount(), fee)) {
			t.setBanktradeno(Banktradeno);
			t.setTrade_no_chl(Trade_no_chl);
			t.setBankorderno(bandorderno);
			t.setAmount(fee);
			t.setStatus(DOStatus.UPDATED);
		}
	}

}
