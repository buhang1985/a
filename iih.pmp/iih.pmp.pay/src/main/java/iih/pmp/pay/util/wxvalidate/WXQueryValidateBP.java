package iih.pmp.pay.util.wxvalidate;

import java.util.Map;

import iih.pmp.pay.ord.d.OrdDO;
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
import wxpay.sdk.WXPayUtil;
import xap.mw.core.data.BizException;

public class WXQueryValidateBP {
	WXPayValidateBP bp = new WXPayValidateBP();
	WXPayBP paybp = new WXPayBP();
	WXPayAppUtils utils = new WXPayAppUtils();
	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();

	/**
	 * 查询订单状态，刷卡支付时，有轮询机制
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public OrdDO[] getOrdsInfo_new(OrdReqDTO dto, OrdQryRstDTO rst) throws BizException {

		boolean flag = false;
//		OrdDO[] ords = pmputils.getOrdRService().find(
//				" ord_no='" + dto.getOrd_no() + "' and id_emp_op='"
//						+ pmputils.getId_Stuff(dto.getId_user_req())
//						+ "'", null, FBoolean.FALSE);

		OrdDO[] ords = pmputils.getOrdRService().findByAttrValString(OrdDO.ORD_NO, dto.getOrd_no());

		// 如果订单不存在，则可以刷卡支付
		if (ords == null || ords.length == 0 || ords.length > 1)
			return null;
		flag = bp.validateOrd(ords[0], dto, rst);
		if (flag) {
			flag = this.queryTrade(dto, ords[0], rst);
		}

		// 更新订单状态
		OrdDO ords2 = utils.updateOrdStatus(ords[0]);

		return new OrdDO[] { ords2 };
	}

	private boolean queryTrade(OrdReqDTO dto, OrdDO ordDO, OrdQryRstDTO rst) throws BizException {

		boolean flag = false;
		TradeDO[] tras = pmputils.getTradeDO8ord(ordDO);
		if (tras != null && tras.length > 0) {
			// 查询交易表订单当前状态 todo
			for (TradeDO t : tras) {
				flag = bp.tradevalidate(t, ordDO, dto, rst);

				// 如果交易是条码支付并且是支付中状态则轮询
				if (ordDO.getSd_scene().equals(PmpPayConst.BARCODEPAY_SCENE_CODE)
						&& (t.getTrade_status() == TradeStatusEnum.PAY_WAIT)) {
					flag = this.handleMicroTradeStade(t, ordDO, flag);
				}

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
	 * 刷卡支付轮询查询订单状态
	 * 
	 * @param t
	 * @param ordDO
	 * @param flag
	 * @return
	 */
	private boolean handleMicroTradeStade(TradeDO t, OrdDO ordDO, boolean flag) {

		return this.doquerypost(t, ordDO);
	}

	/**
	 * 刷卡支付轮询查询状态
	 * 
	 * @param t
	 * @param o
	 * @return
	 */
	private boolean doquerypost(TradeDO t, OrdDO o) {
		int remainingTimeMs = 15 * 1000;
		int connectTimeoutMs = 2000;
		long startTimestampMs = 0;
		Map<String, String> lastResult = null;
//		Exception lastException = null;
//		String lastState = null;
		boolean flag = false;
		while (true) {
			startTimestampMs = WXPayUtil.getCurrentTimestampMs();
			int readTimeoutMs = remainingTimeMs - connectTimeoutMs;
			if (readTimeoutMs > 1000) {
				try {
					lastResult = paybp.orderQuery(t.getTrade_no(), connectTimeoutMs, readTimeoutMs);

					String returnCode = lastResult.get(WXCommonRntParamCode.RETURN_CODE);
					if (returnCode.equals(WXCommonRntParamCode.SUCCESS)) {
						String resultCode = lastResult.get(WXCommonRntParamCode.RESULT_CODE);
						if (resultCode.equals(WXCommonRntParamCode.SUCCESS)) {
							String trade_state = lastResult.get(WXCommonRntParamCode.TRADE_STATE);
//							lastState = trade_state;
//							StringBuilder sb = new StringBuilder();
							String total_fee = lastResult.get(WXCommonRntParamCode.TOTAL_FEE);
							OrdQryRstDTO rst = new OrdQryRstDTO();
							rst.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
							flag = bp.HandleTradeState(trade_state, t, o, rst, total_fee);

							if (rst.getBiz_status() == BizStatusEnum.BIZ_SUCCESS
									&& !(trade_state.equals("USERPAYING"))) {
								break;
							}
						} else {
							break;
						}

					} else {
						break;
					}
					// 状态是支付中、支付失败、查询失败，继续轮询
					remainingTimeMs = remainingTimeMs - (int) (WXPayUtil.getCurrentTimestampMs() - startTimestampMs);
					startTimestampMs = WXPayUtil.getCurrentTimestampMs();
					if (remainingTimeMs <= 100) {
						break;
					} else {
						if (remainingTimeMs > 5 * 1000) {
							Thread.sleep(5 * 1000);
						} else {
							Thread.sleep(1 * 1000);
						}
						remainingTimeMs = remainingTimeMs
								- (int) (WXPayUtil.getCurrentTimestampMs() - startTimestampMs);
						continue;
					}
				} catch (Exception ex) {
					lastResult = null;
//					lastException = ex;
					break;
				}
			} else {
				break;
			}
		}
		return flag;
	}

	public OrdDO getOrdsInfo8Trade(OrdReqDTO dto, TradeDO t) throws BizException {

//		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		OrdDO ords = pmputils.getOrdRService().findById(t.getId_ord());

		// 如果订单不存在，则可以刷卡支付
		if (ords == null)
			return null;
		// flag = bp.validateOrd(ords, dto, sb);
		if (flag) {
			// flag = this.queryTrade(dto, ords, sb);
		}
		// 更新订单状态
		OrdDO ords2 = utils.updateOrdStatus(ords);

		return ords2;
	}
}
