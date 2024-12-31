package iih.pmp.pay.custom.bp;

import java.net.SocketTimeoutException;
import java.util.Map;

import org.springframework.transaction.TransactionStatus;

import iih.pmp.pay.custom.i.IPmpDataconvert;
import iih.pmp.pay.custom.i.IPmpSdk;
import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ord.d.OrdStatusEnum;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.BizStatusEnum;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayAppUtils;
import iih.pmp.pay.util.WXPayAppUtils;
import iih.pmp.pay.utils.PmpPayLogUtils;
import iih.pmp.pay.utils.PmpWxPayLogUtils;
import iih.pmp.yxpaySDK.bp.YxPayUtils;
import wxpay.sdk.WXPayUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDouble;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;

public class PmpPayBP {

	IPmpSdk pay;
	IPmpDataconvert dataconvert;
	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();
	WXPayAppUtils utils = new WXPayAppUtils();

	public PmpPayBP(IPmpSdk pay1, IPmpDataconvert dataconvert1) {
		pay = pay1;
		dataconvert = dataconvert1;
	}

	public OrdRstDTO dobarcodepay(Map<String, Object> data, TradeDO tra, OrdDO ord, OrdReqDTO dto) throws BizException {
		Map<String, String> rst1 = pay.doScanPay(data);
		OrdRstDTO rnt = new OrdRstDTO();
		if (rst1 != null) {
			Map<String, String> rst = dataconvert.BarcodeRntConvert(rst1);
			if (PmpPayConst.PMP_SUCCESS.equals(rst.get(PmpPayConst.PMP_RESULT))) {
				String trade_status = rst.get(PmpPayConst.PMP_TRADE_STATUS);
				if (PmpPayConst.PMP_SUCCESS.equals(trade_status)) {
					String total_fee = rst.get(PmpPayConst.PMP_AMOUNT);
					rnt.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
					tra.setTrade_status(TradeStatusEnum.PAY_SUCCESS);
					tra.setDt_finish(pmputils.getServerDateTime());
					pmputils.setTradeAndRntVal(tra, rst, pmputils.strToYuan(total_fee), rnt);
					ord.setDt_pay(pmputils.getServerDateTime());
					ord.setTradetype(tra.getTradetype());
					ord.setOrd_status(OrdStatusEnum.PAID);
				} else if (PmpPayConst.PMP_ERROR.equals(trade_status)) {
					rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
					rnt.setErr_code(rst.get(PmpPayConst.PMP_ERR_CODE));
					rnt.setErr_code_des(rst.get(PmpPayConst.PMP_ERR_MSG));
					tra.setTrade_status(TradeStatusEnum.PAY_FAIL);
					tra.setErr_code(rst.get(PmpPayConst.PMP_ERR_CODE));
					ord.setOrd_status(OrdStatusEnum.FAIL);
				} else {
					handlePayUnknow(tra, ord, dto, rst, rnt);
				}

			} else {

				handlePayUnknow(tra, ord, dto, rst, rnt);
			}
			// 更新交易和订单
			if (rst.get(PmpPayConst.PMP_TRADE_CHL_NO) != null) {
				tra.setTrade_no_chl(rst.get(PmpPayConst.PMP_TRADE_CHL_NO));
			}
			updateOrdAndTrade(tra, ord);
		} else {
			rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
//			handlePayUnknow(  tra,  ord,  dto, null, rnt );
		}
		setRntVal(rnt, tra, ord);
		return rnt;
	}

	public OrdRstDTO doqrcodepay(Map<String, Object> data, TradeDO tra, OrdDO ord, OrdReqDTO dto) throws BizException {
		Map<String, String> rst1 = pay.doQRCODEPay(data);
		OrdRstDTO rnt = new OrdRstDTO();
		if (rst1 != null) {
			Map<String, String> rst = dataconvert.QrcodeRntConvert(rst1);
			if (PmpPayConst.PMP_SUCCESS.equals(rst.get(PmpPayConst.PMP_RESULT))) {
				String trade_status = rst.get(PmpPayConst.PMP_TRADE_STATUS);
				if (PmpPayConst.PMP_SUCCESS.equals(trade_status)) {
					rnt.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
					rnt.setPrepay_id(rst.get(PmpPayConst.PMP__PREPAY_ID));
					String code_url = rst.get(PmpPayConst.PMP__QR_CODE);
					tra.setQr_code(code_url);
					rnt.setQr_code(PmpPayAppUtils.getQRCodeImge(code_url));
					tra.setTrade_status(TradeStatusEnum.TRADE_UNKNOWN);
					ord.setOrd_status(OrdStatusEnum.UNKNOWN);
				} else {
					rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
					rnt.setErr_code(rst.get(PmpPayConst.PMP_ERR_CODE));
					rnt.setErr_code_des(rst.get(PmpPayConst.PMP_ERR_MSG));
					tra.setTrade_status(TradeStatusEnum.PAY_FAIL);
					tra.setErr_code(rst.get(PmpPayConst.PMP_ERR_CODE));
					ord.setOrd_status(OrdStatusEnum.FAIL);
				}
			} else {
				rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
				rnt.setErr_code(rst.get(PmpPayConst.PMP_ERR_CODE));
				rnt.setErr_code_des(rst.get(PmpPayConst.PMP_ERR_MSG));
				tra.setTrade_status(TradeStatusEnum.PAY_FAIL);
				tra.setErr_code(rst.get(PmpPayConst.PMP_ERR_CODE));
				ord.setOrd_status(OrdStatusEnum.FAIL);
			}
		} else {
			rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
			tra.setTrade_status(TradeStatusEnum.PAY_FAIL);
			ord.setOrd_status(OrdStatusEnum.FAIL);
		}
		updateOrdAndTrade(tra, ord);
		setRntVal(rnt, tra, ord);
		return rnt;
	}

	/**
	 * 支付结果未知调用查询
	 * 
	 * @param tra
	 * @param ord
	 * @param dto
	 * @param rst
	 * @param rnt
	 * @throws BizException
	 */
	private void handlePayUnknow(TradeDO tra, OrdDO ord, OrdReqDTO dto, Map<String, String> rst, OrdRstDTO rnt)
			throws BizException {
		rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
		if (rst != null) {
			rnt.setErr_code(rst.get(PmpPayConst.PMP_ERR_CODE));
			rnt.setErr_code_des(rst.get(PmpPayConst.PMP_ERR_MSG));
			tra.setErr_code(rst.get(PmpPayConst.PMP_ERR_CODE));
		}
		Map<String, String> m = this.tradequery(tra, ord, dto);
		this.HandleQueryRst(tra, m, rnt, ord);
	}

	/**
	 * 查询
	 * 
	 * @param t
	 * @return
	 * @throws BizException
	 */
	public Map<String, String> doquery(TradeDO t, OrdDO ord) throws BizException {
		Map<String, Object> data = dataconvert.getQueryParam(ord, t);
		return pay.doQuery(data);

	}

	/**
	 * 退款查询
	 * 
	 * @param t
	 * @return
	 * @throws BizException
	 */
	public Map<String, String> dorefundquery(TradeDO t, OrdDO ord, TradeDO paidtra) throws BizException {
		PmpPayLogUtils.info("[1]PMP_PmpPayBP_dorefundquery,退款查询入参: "+" t信息: "+(t==null?"t为null":t.serializeJson())+" ,ord信息: "+(ord==null?"ord为null":ord.serializeJson())+" ,paidtra信息: "+(paidtra==null?"paidtra为null":paidtra.serializeJson()));
		Map<String, Object> data = dataconvert.getRefundQueryParam(ord, t, paidtra);
		PmpPayLogUtils.info("[2]PMP_PmpPayBP_dorefundquery,参数组装: "+(data==null?"data is null":YxPayUtils.m2json(data))+" ,入参: "+" t信息: "+(t==null?"t为null":t.serializeJson())+" ,ord信息: "+(ord==null?"ord为null":ord.serializeJson())+" ,paidtra信息: "+(paidtra==null?"paidtra为null":paidtra.serializeJson()));
		return pay.dorefundquery(data);
	}

	private Map<String, String> tradequery(TradeDO tra, OrdDO ord, OrdReqDTO dto) throws BizException {
		Map<String, String> m = this.doquery(tra, ord);
		return m;
	}

	private void HandleQueryRst(TradeDO tra, Map<String, String> mr, OrdRstDTO rnt, OrdDO ord) throws BizException {
		if (mr != null) {
			Map<String, String> m = dataconvert.QueryRntConvert(mr);
			if (PmpPayConst.PMP_SUCCESS.equals(m.get(PmpPayConst.PMP_RESULT))) {
				String trade_state = m.get(PmpPayConst.PMP_TRADE_STATUS);
				String total_fee = m.get(PmpPayConst.PMP_AMOUNT);
				if (PmpPayConst.PMP_SUCCESS.equals(trade_state)) {
					// 支付成功
					tra.setDt_finish(pmputils.getServerDateTime());
					rnt.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
					rnt.setAmount(pmputils.strToYuan(total_fee));
					tra.setTrade_status(TradeStatusEnum.PAY_SUCCESS);
					pmputils.setTradeAndRntVal(tra, m, pmputils.strToYuan(total_fee), rnt);
					utils.updateOrdStatus(ord, OrdStatusEnum.PAID, new FDouble(0), tra.getTradetype());
				} else if (PmpPayConst.PMP_ERROR.equals(trade_state)) {
					// 支付失败(其他原因，如银行返回失败)
					tra.setTrade_status(TradeStatusEnum.PAY_FAIL);
					utils.updateOrdStatus(ord, OrdStatusEnum.FAIL);
					pmputils.setOrdNotExistErrCode(tra, PmpPayConst.PMP_ERR_CODE);
				} else if (PmpPayConst.PMP_USERPAYING.equals(trade_state)) {
					// 用户支付中
					tra.setTrade_status(TradeStatusEnum.PAY_WAIT);
					utils.updateOrdStatus(ord, OrdStatusEnum.WAIT_TO_PAY);
				} else if (trade_state.equals(PmpPayConst.PMP_UNKNOW)) {
					tra.setTrade_status(TradeStatusEnum.TRADE_UNKNOWN);
					utils.updateOrdStatus(ord, OrdStatusEnum.UNKNOWN);
				}
			}

		}
	}

	private void updateOrdAndTrade(TradeDO tra, OrdDO ord) throws BizException {
		tra.setStatus(DOStatus.UPDATED);
		pmputils.getTradeCUDService().update(new TradeDO[] { tra });

		ord.setStatus(DOStatus.UPDATED);
		pmputils.getOrdCudService().update(new OrdDO[] { ord });
	}

	public OrdRstDTO refund(Map<String, Object> data, TradeDO tra, OrdDO ord, OrdReqDTO dto, TradeDO paidtra)
			throws BizException{
		PmpPayLogUtils.info("[1]PMP_PmpPayBP_refund,入参: "+(data==null?"data为null":YxPayUtils.m2json(data))+" ,tra信息: "+(tra==null?"tra为null":tra.serializeJson())+" ,ord信息: "+(ord==null?"ord为null":ord.serializeJson())+" ,OrdReqDTO信息: "+(dto==null?"dto为null":dto.serializeJson())+" ,paidtra信息: "+(paidtra==null?"paidtra为null":paidtra.serializeJson()));
		OrdRstDTO rnt = new OrdRstDTO();
		Map<String, String> r1 = pay.refund(data);
		PmpPayLogUtils.info("[2]PMP_PmpPayBP_refund,调用sdk退款结果: "+(r1==null?"r1为null":YxPayUtils.m2json2(r1))+" ,入参: "+(data==null?"data为null":YxPayUtils.m2json(data))+" ,tra信息: "+(tra==null?"tra为null":tra.serializeJson())+" ,ord信息: "+(ord==null?"ord为null":ord.serializeJson())+" ,OrdReqDTO信息: "+(dto==null?"dto为null":dto.serializeJson())+" ,paidtra信息: "+(paidtra==null?"paidtra为null":paidtra.serializeJson()));
		if (r1 != null) {
			Map<String, String> r = dataconvert.RefundRntConvert(r1);
			PmpPayLogUtils.info("[3]PMP_PmpPayBP_refund,退款返回参数: "+(r==null?"r为null":YxPayUtils.m2json2(r))+" ,入参: "+(data==null?"data为null":YxPayUtils.m2json(data))+" ,tra信息: "+(tra==null?"tra为null":tra.serializeJson())+" ,ord信息: "+(ord==null?"ord为null":ord.serializeJson())+" ,OrdReqDTO信息: "+(dto==null?"dto为null":dto.serializeJson())+" ,paidtra信息: "+(paidtra==null?"paidtra为null":paidtra.serializeJson()));
			if (PmpPayConst.PMP_SUCCESS.equals(r.get(PmpPayConst.PMP_RESULT))) {
				String trade_state = r.get(PmpPayConst.PMP_TRADE_STATUS);
				if (PmpPayConst.PMP_SUCCESS.equals(trade_state)) {
					String total_fee = r.get(PmpPayConst.PMP_AMOUNT);
					rnt.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
					tra.setTrade_status(TradeStatusEnum.REFUND_SUCCESS);
					pmputils.setTradeAndRntVal(tra, r, pmputils.strToYuan(total_fee), rnt);
					// 设置可退款金额
					FDouble fee = tra.getAmount();
					FDouble abk = ord.getAmount_bk();
					ord.setAmount_bk(abk.sub(fee));
					ord.setStatus(DOStatus.UPDATED);
					tra.setTrade_no_chl(r.get(PmpPayConst.PMP_TRADE_CHL_NO));
					tra.setDt_finish(pmputils.getServerDateTime());
				} else if (PmpPayConst.PMP_ERROR.equals(trade_state)) {
					rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
					tra.setTrade_status(TradeStatusEnum.REFUND_FAIL);
					rnt.setErr_code(r.get(PmpPayConst.PMP_ERR_CODE));
					rnt.setErr_code_des(r.get(PmpPayConst.PMP_ERR_MSG));
					tra.setErr_code(r.get(PmpPayConst.PMP_ERR_CODE));
				} else {
					rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
					rnt.setErr_code(r.get(PmpPayConst.PMP_ERR_CODE));
					rnt.setErr_code_des(r.get(PmpPayConst.PMP_ERR_MSG));
					tra.setErr_code(r.get(PmpPayConst.PMP_ERR_CODE));
					tra.setTrade_no_chl(r.get(PmpPayConst.PMP_TRADE_CHL_NO));
					
					Map<String, String> rst = this.dorefundquery(tra, ord, paidtra);
					PmpPayLogUtils.info("[4]PMP_PmpPayBP_refund,调用退款查询结果: "+(rst==null?"rst为null":YxPayUtils.m2json2(rst))+" ,入参: "+(data==null?"data为null":YxPayUtils.m2json(data))+" ,tra信息: "+(tra==null?"tra为null":tra.serializeJson())+" ,ord信息: "+(ord==null?"ord为null":ord.serializeJson())+" ,OrdReqDTO信息: "+(dto==null?"dto为null":dto.serializeJson())+" ,paidtra信息: "+(paidtra==null?"paidtra为null":paidtra.serializeJson()));
					pmprefundquery(tra, dto, ord, rst, rnt);
				}

			} else {
				rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
				rnt.setErr_code(r.get(PmpPayConst.PMP_ERR_CODE));
				rnt.setErr_code_des(r.get(PmpPayConst.PMP_ERR_MSG));
				tra.setErr_code(r.get(PmpPayConst.PMP_ERR_CODE));
				Map<String, String> rst = this.dorefundquery(tra, ord, paidtra);
				pmprefundquery(tra, dto, ord, rst, rnt);
			}

		} else {
			rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
		}
		tra.setStatus(DOStatus.UPDATED);
		SaveOrdAndTrade(new TradeDO[] { tra }, new OrdDO[] { ord });
		PmpPayLogUtils.info("[5]PMP_PmpPayBP_refund,信息: "+(data==null?"data为null":YxPayUtils.m2json(data))+" ,tra信息: "+(tra==null?"tra为null":tra.serializeJson())+" ,ord信息: "+(ord==null?"ord为null":ord.serializeJson())+" ,OrdReqDTO信息: "+(dto==null?"dto为null":dto.serializeJson())+" ,paidtra信息: "+(paidtra==null?"paidtra为null":paidtra.serializeJson()));
		// 返回参数加上交易状态
		setRntVal(rnt, tra, ord);
		PmpPayLogUtils.info("[6]PMP_PmpPayBP_refund,最后返回结果信息: "+(rnt==null?"rnt is null":rnt.serializeJson())+" ,入参: "+(data==null?"data为null":YxPayUtils.m2json(data))+" ,tra信息: "+(tra==null?"tra为null":tra.serializeJson())+" ,ord信息: "+(ord==null?"ord为null":ord.serializeJson())+" ,OrdReqDTO信息: "+(dto==null?"dto为null":dto.serializeJson())+" ,paidtra信息: "+(paidtra==null?"paidtra为null":paidtra.serializeJson()));
		return rnt;
	}

	public void SaveOrdAndTrade(final TradeDO[] tra, final OrdDO[] ord) throws BizException {
		try {
			TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
				@Override
				public String doInTransaction(TransactionStatus arg0) {
					try {
						pmputils.getTradeCUDService().save(tra);
						pmputils.getOrdCudService().save(ord);
						return null;
					} catch (Exception e) {
						throw new BizRuntimeException(e.getMessage(), e);
					}
				}
			});
		} catch (Exception e) {
			PmpWxPayLogUtils.logEx(e);
		}
	}

	/**
	 * 处理退款结果未知的查询结果
	 * 
	 * @param t
	 * @param dto
	 * @param ord
	 * @param r1
	 * @param rnt
	 * @throws BizException
	 */
	private void pmprefundquery(TradeDO t, OrdReqDTO dto, OrdDO ord, Map<String, String> r1, OrdRstDTO rnt)
			throws BizException {
		PmpPayLogUtils.info("[1]PMP_PmpPayBP_pmprefundquery,处理退款结果未知的入参: "+" t信息: "+(t==null?"t为null":t.serializeJson())+" ,ord信息: "+(ord==null?"ord为null":ord.serializeJson())+" ,r1信息: "+(r1==null?"r1为null":YxPayUtils.m2json2(r1))+" ,OrdRstDTO: "+(rnt==null?"rnt is null":rnt.serializeJson()));
		if (r1 != null) {
			Map<String, String> r = this.dataconvert.RefundQueryRntConvert(r1);
			PmpPayLogUtils.info("[2]PMP_PmpPayBP_pmprefundquery,退款查询返回参数转换: "+(r==null?"r is null":YxPayUtils.m2json2(r))+" ,入参: "+" t信息: "+(t==null?"t为null":t.serializeJson())+" ,ord信息: "+(ord==null?"ord为null":ord.serializeJson())+" ,r1信息: "+(r1==null?"r1为null":YxPayUtils.m2json2(r1))+" ,OrdRstDTO: "+(rnt==null?"rnt is null":rnt.serializeJson()));
			if (PmpPayConst.PMP_SUCCESS.equals(r.get(PmpPayConst.PMP_RESULT))) {
				String status = r.get(PmpPayConst.PMP_TRADE_STATUS);
				if (PmpPayConst.PMP_SUCCESS.equals(status)) {
					rnt.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
					String total_fee = r.get(PmpPayConst.PMP_AMOUNT);
					FDouble fee = pmputils.strToYuan(total_fee);
					pmputils.setTradeAndRntVal(t, r, fee, rnt);
					utils.updateTradeStatusnew(t, TradeStatusEnum.REFUND_SUCCESS);
					// 设置订单可退金额
					FDouble feet = t.getAmount();
					FDouble abk = ord.getAmount_bk();
					ord.setAmount_bk(abk.sub(feet));
					ord.setStatus(DOStatus.UPDATED);
					t.setTrade_no_chl(r.get(PmpPayConst.PMP_TRADE_CHL_NO));
					t.setDt_finish(pmputils.getServerDateTime());
				} else if (PmpPayConst.PMP_UNKNOW.equals(status)) {
					rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
					t.setTrade_no_chl(r.get(PmpPayConst.PMP_TRADE_CHL_NO));
					utils.updateTradeStatusnew(t, TradeStatusEnum.TRADE_UNKNOWN);
					rnt.setTrade_status(TradeStatusEnum.TRADE_UNKNOWN);

				} else if (PmpPayConst.PMP_ERROR.equals(status)) {

					utils.updateTradeStatusnew(t, TradeStatusEnum.REFUND_FAIL);
					pmputils.setOrdNotExistErrCode(t, PmpPayConst.PMP_ERR_CODE);
				}
			} else {

			}
		} else {

		}
		PmpPayLogUtils.info("[3]PMP_PmpPayBP_pmprefundquery,处理退款结果未知结束: , 入参: "+" t信息: "+(t==null?"t为null":t.serializeJson())+" ,ord信息: "+(ord==null?"ord为null":ord.serializeJson())+" ,r1信息: "+(r1==null?"r1为null":YxPayUtils.m2json2(r1))+" ,OrdRstDTO: "+(rnt==null?"rnt is null":rnt.serializeJson()));
	}

	/**
	 * 刷卡支付轮询查询状态
	 * 
	 * @param t
	 * @param o
	 * @return
	 */
	@SuppressWarnings("unused")
	@Deprecated
	private Map<String, String> doquerypost(TradeDO t, OrdDO ord, OrdReqDTO dto) {
		int remainingTimeMs = 60 * 1000;
		int connectTimeoutMs = 2000;
		long startTimestampMs = 0;
		Map<String, String> lastResult = null;
		Exception lastException = null;
		String lastState = null;
		while (true) {
			startTimestampMs = WXPayUtil.getCurrentTimestampMs();
			int readTimeoutMs = remainingTimeMs - connectTimeoutMs;
			if (readTimeoutMs > 1000) {
				try {
					lastResult = this.doquery(t, ord);

					if (lastResult != null && lastResult.containsKey("code")) {
						String trade_state = lastResult.get("code");
						lastState = trade_state;
						if (!(trade_state.equals(PmpPayConst.PMP_USERPAYING))) {
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
					lastException = ex;
					break;
				}
			} else {
				break;
			}
		}
		return lastResult;
	}

	private void setRntVal(OrdRstDTO rnt, TradeDO tra, OrdDO ord) {
		// 返回参数加上交易状态
		rnt.setAmount(ord.getAmount());
		rnt.setAmount_bk(ord.getAmount_bk());
		rnt.setTrade_status(tra.getTrade_status());
		rnt.setMch_order_no(ord.getCode());
		rnt.setTradetype(tra.getTradetype());
		rnt.setOrd_no(ord.getOrd_no());
		rnt.setRefund_no(tra.getRefund_req_no());
	}
}
