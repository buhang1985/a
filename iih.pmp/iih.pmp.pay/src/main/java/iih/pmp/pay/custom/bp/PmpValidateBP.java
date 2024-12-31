package iih.pmp.pay.custom.bp;

import java.util.HashMap;
import java.util.Map;

import iih.pmp.pay.custom.i.IPmpDataconvert;
import iih.pmp.pay.custom.i.IPmpSdk;
import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ord.d.OrdStatusEnum;
import iih.pmp.pay.ordqryrstdto.d.OrdQryRstDTO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.BizStatusEnum;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayBaseCost;
import iih.pmp.pay.util.WXPayAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

public class PmpValidateBP {

	PmpPayBP paybp;
	IPmpDataconvert dataconvert;
	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();
	WXPayAppUtils utils = new WXPayAppUtils();

	public PmpValidateBP(IPmpSdk pay1, IPmpDataconvert dataconvert1) {
		paybp = new PmpPayBP(pay1, dataconvert1);
		dataconvert = dataconvert1;
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

			ords = (OrdDO[]) fa.get(2);
			// 校验订单是否已支付
			flag = validateOrd(ords[0], dto, rst);
		}
		if (flag) {
			// 校验是否有已支付，或状态未知的交易数据
			flag = this.validateTrade(ords[0], dto, rst);
		}
		// 更新订单状态
		if (ords != null && ords.length == 1)
			ords = pmputils.getOrdCudService().update(ords);

		resultMap.put(PmpPayBaseCost.PMP_FLAG, flag);
		if (flag) {
			resultMap.put(PmpPayBaseCost.PMP_ORD, ords[0]);
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
			resultMap.put(PmpPayBaseCost.PMP_FLAG, flag);
			fa.add(flag);
			fa.add(resultMap);
			return fa;
		}
		if (ords.length > 1) {
			flag = false;
			resultMap.put(PmpPayBaseCost.PMP_FLAG, flag);
			rst.setErr_code_des(pmputils.getOrdErrMsg(dto, "对应多条订单记录"));
			fa.add(flag);
			fa.add(resultMap);
			return fa;
		} else if (!ords[0].getSd_chl().equals(dto.getSd_chl())) {
			flag = false;
			resultMap.put(PmpPayBaseCost.PMP_FLAG, flag);
			rst.setErr_code_des(pmputils.getOrdErrMsg(dto, "支付渠道变更，请重新下单！"));
			fa.add(flag);
			fa.add(resultMap);
			return fa;
		} else {
			flag = true;
		}
		resultMap.put(PmpPayBaseCost.PMP_FLAG, flag);
		fa.add(flag);
		fa.add(resultMap);
		fa.add(ords);
		return fa;
	}

	public boolean validateOrd(OrdDO ordDO, OrdReqDTO dto, OrdQryRstDTO rst) throws BizException {
		boolean flag = false;
		if (ordDO.getOrd_status().equals(OrdStatusEnum.PAID)) {
			// 已支付，不可以再次支付
			TradeDO[] tras = pmputils.getTradeRService().find(
					" id_ord='" + ordDO.getId_ord() + "' and trade_status=" + TradeStatusEnum.PAY_SUCCESS, null,
					FBoolean.FALSE);
			if (tras == null || tras.length == 0) {
				utils.updateOrdStatus(ordDO, OrdStatusEnum.PAID, ordDO.getAmount(), null);
				this.setRstData8Ord(rst, ordDO);
				rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
				rst.setErr_code_des("订单已全额退款！");
				rst.setTrade_status(TradeStatusEnum.PAY_FAIL);
				flag = false;

			} else {
				flag = this.queryWxTrade(tras[0], ordDO, rst, dto);
				if (!flag) {
					this.setRstData(rst, tras[0], ordDO);
					// 交易未知,不修改订单和交易状态
					utils.updateTradeStatusnew(tras[0], TradeStatusEnum.PAY_SUCCESS);
					utils.updateOrdStatus(ordDO, OrdStatusEnum.PAID);
				}
				if (flag) {
					// 交易由成功变成失败,设置订单可退款金额为零,并且不可再退款或支付
					utils.updateTradeStatusnew(tras[0], TradeStatusEnum.PAY_SUCCESS);
					utils.updateOrdStatus(ordDO, OrdStatusEnum.PAID, ordDO.getAmount(), null);
					this.setRstData(rst, tras[0], ordDO);
					flag = false;
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
					this.setRstData(rst, t, ordDO);
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

		boolean flag = this.isTradecanpayagin(t, ordDO, rst, dto);

		if (flag && (!(TradeStatusEnum.CLOSED.equals(t.getTrade_status())
				|| TradeStatusEnum.PAY_FAIL.equals(t.getTrade_status())
				|| TradeStatusEnum.REVOKED.equals(t.getTrade_status())))) {
			flag = this.queryWxTrade(t, ordDO, rst, dto);
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
	private boolean queryWxTrade(TradeDO t, OrdDO ordDO, OrdQryRstDTO rst, OrdReqDTO dto) throws BizException {

		boolean flag = false;

		Map<String, String> r1 = paybp.doquery(t, ordDO);
		if (r1 != null) {
			// 查询结果转换
			Map<String, String> r = this.dataconvert.QueryRntConvert(r1);
			if (PmpPayConst.PMP_SUCCESS.equals(r.get(PmpPayConst.PMP_RESULT))) {
				String trade_state = r.get(PmpPayConst.PMP_TRADE_STATUS);
				String total_fee = r.get(PmpPayConst.PMP_AMOUNT);
				flag = this.HandleTradeState(trade_state, t, ordDO, rst, total_fee, r, dto);
			} else {
				// todo 查询失败的情况
				flag = false;
				rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
				rst.setErr_code_des("第三方后台查询失败！" + r.get(PmpPayConst.PMP_ERR_MSG));
			}

		} else {
			// todo 查询失败的情况
			flag = false;
			rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
			rst.setErr_code_des("第三方后台查询失败！");
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
			Map<String, String> r, OrdReqDTO dto) throws BizException {
		boolean flag = false;
		if (PmpPayConst.PMP_SUCCESS.equals(trade_state)) {
			// 支付成功

			flag = false;
			utils.updateTradeStatusnew(t, TradeStatusEnum.PAY_SUCCESS, pmputils.strToYuan(totalfee));
			utils.updateOrdStatus(o, OrdStatusEnum.PAID, new FDouble(0), t.getTradetype());
			HandleRefund(t, totalfee, o, rst, dto);
			OrdRstDTO rnt = new OrdRstDTO();
			pmputils.setTradeAndRntVal(t, r, pmputils.strToYuan(totalfee), rnt);
			rst.setErr_code_des(pmputils.getOrdErrMsg(o.getOrd_no(), "已支付！金额：" + t.getAmount() + " 元!"));
			rst.setBankno(r.get(PmpPayConst.PMP_BANKNO));

		} else if (PmpPayConst.PMP_ERROR.equals(trade_state)) {
			// 支付失败(其他原因，如银行返回失败)
			flag = true;
			int state = TradeStatusEnum.PAY_FAIL;
			utils.updateTradeStatusnew(t, state);
			utils.updateOrdStatus(o, OrdStatusEnum.FAIL);
			pmputils.setOrdNotExistErrCode(t, r.get(PmpPayConst.PMP_ERR_CODE));
			rst.setErr_code_des(r.get(PmpPayConst.PMP_ERR_MSG));
		} else if (PmpPayConst.PMP_USERPAYING.equals(trade_state)) {
			// 支付中
			flag = false;
			utils.updateTradeStatusnew(t, TradeStatusEnum.PAY_WAIT);
			utils.updateOrdStatus(o, OrdStatusEnum.WAIT_TO_PAY);
			rst.setErr_code_des(pmputils.getOrdErrMsg(o.getOrd_no(), "支付中，请输入支付密码！"));
		} else if (PmpPayConst.PMP_UNKNOW.equals(trade_state)) {
			flag = false;
			utils.updateTradeStatusnew(t, TradeStatusEnum.TRADE_UNKNOWN);
			utils.updateOrdStatus(o, OrdStatusEnum.UNKNOWN);
//			String errmsg=r.get(PmpPayConst.PMP_ERR_MSG)+pmputils.getOrdErrMsg(o.getOrd_no(), "订单下单状态未知，请刷新界面！");
			String errmsg = r.get(PmpPayConst.PMP_ERR_MSG) + "订单下单状态未知";
			rst.setErr_code_des(errmsg);
		}

		return flag;
	}

	private void HandleRefund(TradeDO tr, String totalfee, OrdDO o, OrdQryRstDTO rst, OrdReqDTO dto)
			throws BizException {
		TradeDO[] tras = pmputils.getTradeRService().find(
				TradeDO.TRADE_NO_REL + " = '" + tr.getTrade_no() + "' and eu_direct=" + PmpPayConst.TRADE_DIRECT_REFUND,
				"dt_req", FBoolean.FALSE);
		if (tras != null && tras.length > 0) {
			FDouble total = new FDouble(0);
			for (TradeDO tradeDO : tras) {
				if (TradeStatusEnum.REFUND_SUCCESS.equals(tradeDO.getTrade_status())) {
					total = total.add(tradeDO.getAmount());
				} else if (TradeStatusEnum.TRADE_UNKNOWN.equals(tradeDO.getTrade_status())) {
					Map<String, String> r1 = paybp.dorefundquery(tradeDO, o, tr);
					if (r1 != null) {
						Map<String, String> r = this.dataconvert.RefundQueryRntConvert(r1);
						if (PmpPayConst.PMP_SUCCESS.equals(r.get(PmpPayConst.PMP_RESULT))) {
							String status = r.get(PmpPayConst.PMP_TRADE_STATUS);
							String amount = r.get(PmpPayConst.PMP_AMOUNT);
							if (PmpPayConst.PMP_SUCCESS.equals(status)) {
								FDouble refund_f = pmputils.strToYuan(amount);
								if (refund_f == null) {
									refund_f = tradeDO.getAmount();
								}
								total = total.add(refund_f);
								OrdRstDTO rnt = new OrdRstDTO();
								pmputils.setTradeAndRntVal(tradeDO, r, refund_f, rnt);
								utils.updateTradeStatusnew(tradeDO, TradeStatusEnum.REFUND_SUCCESS);
							} else if (PmpPayConst.PMP_ERROR.equals(status)) {
								utils.updateTradeStatusnew(tradeDO, TradeStatusEnum.REFUND_FAIL);
								pmputils.setOrdNotExistErrCode(tradeDO, r.get(PmpPayConst.PMP_ERR_CODE));
							} else if (PmpPayConst.PMP_UNKNOW.equals(status)) {
								if (TradeStatusEnum.REFUND_SUCCESS.equals(tradeDO.getTrade_status())) {
									total = total.add(tradeDO.getAmount());
								}
							}
						} else {
							// 查询失败
							rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
							rst.setErr_code_des(r.get(PmpPayConst.PMP_ERR_MSG));
							if (TradeStatusEnum.REFUND_SUCCESS.equals(tradeDO.getTrade_status())) {
								total = total.add(tradeDO.getAmount());
							}
						}
					} else {
						// 查询失败
						rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
						rst.setErr_code_des("第三方后台退款查询失败！");
						if (TradeStatusEnum.REFUND_SUCCESS.equals(tradeDO.getTrade_status())) {
							total = total.add(tradeDO.getAmount());
						}
					}
				}
			}
//			FDouble fee = pmputils.strToYuan(totalfee);
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
	 * @return flag是否参与下一步查询
	 * @throws BizException
	 */
	public boolean isTradecanpayagin(TradeDO t, OrdDO o, OrdQryRstDTO rst, OrdReqDTO dto) throws BizException {
		boolean flag = true;
		if (t.getTrade_status().equals(TradeStatusEnum.PAY_SUCCESS)) {
			flag = this.queryWxTrade(t, o, rst, dto);
			if (flag) {
				// 交易金额由成功变成失败，设置订单可退款金额为0，并且不可再退款
				utils.updateTradeStatusnew(t, TradeStatusEnum.PAY_SUCCESS);
				utils.updateOrdStatus(o, OrdStatusEnum.PAID, o.getAmount(), null);
				flag = false;
			} else {
				// 交易未知,不修改订单和交易状态
				utils.updateTradeStatusnew(t, TradeStatusEnum.PAY_SUCCESS);
				utils.updateOrdStatus(o, OrdStatusEnum.PAID);
			}
		} else if (t.getTrade_status().equals(TradeStatusEnum.CLOSED)) {
			flag = true;
			utils.updateOrdStatus(o, OrdStatusEnum.FAIL);
		} else if (t.getTrade_status().equals(TradeStatusEnum.REVOKED)) {
			flag = true;
			utils.updateOrdStatus(o, OrdStatusEnum.FAIL);
		} else if (t.getTrade_status().equals(TradeStatusEnum.PAY_FAIL)) {
			flag = true;
			utils.updateOrdStatus(o, OrdStatusEnum.FAIL);
		} else {
			flag = true;
		}
		return flag;
	}

	private void setRstData(OrdQryRstDTO rst, TradeDO t, OrdDO o) {
		rst.setTrade_no(t.getTrade_no());
		rst.setTradetime(t.getDt_req());
		rst.setBankorderno(t.getBankorderno());
		rst.setTrade_no_chl(t.getTrade_no_chl());
		rst.setBanktradeno(t.getBanktradeno());
		rst.setMch_order_no(t.getSd_ord());
		rst.setAmount(t.getAmount());
		rst.setTradetype(t.getTradetype());
		rst.setTrade_status(t.getTrade_status());
		rst.setAmount_bk(o.getAmount_bk());
		rst.setOrd_status(o.getOrd_status());
	}

	private void setRstData8Ord(OrdQryRstDTO rst, OrdDO o) {
		rst.setMch_order_no(o.getCode());
		rst.setAmount(o.getAmount());
		rst.setTradetype(o.getTradetype());
		rst.setAmount_bk(o.getAmount_bk());
		rst.setOrd_status(o.getOrd_status());
	}

}
