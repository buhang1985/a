package iih.pmp.pay.cmbc.s.bp;

import java.util.HashMap;
import java.util.Map;

import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ord.d.OrdStatusEnum;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.BizStatusEnum;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.WXPayAppUtils;
import iih.pmp.wxpay.cmbc.CmbcPay;
import wxpay.sdk.WXPayUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDouble;

public class CmbcPayBP {
	CmbcPay pay=new CmbcPay();
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	WXPayAppUtils utils=new WXPayAppUtils();
	/**
	 * 查询
	 * @param ord_no
	 * @param trade_no
	 * @return
	 * @throws BizException 
	 */
	public Map<String,String>orderQuery(String ord_no,String trade_no) throws BizException{
		Map<String, Object> data=new HashMap<String,Object>();
		data.put("merchantSeq", ord_no);
		data.put("mchSeqNo", trade_no);
		Map<String,String> rst=pay.doQuery(data);
		return rst;
	}
	
	public OrdRstDTO refund(Map<String, Object> data,TradeDO tra,OrdDO ord){
		OrdRstDTO rnt = null;		
		try {
			Map<String, String> r = pay.refund(data);
			rnt = new OrdRstDTO();
			System.out.println(r);
			if (r != null
					&& "S".equals(r
							.get("gateReturnType"))) {

				    String	status = r.get("tradeStatus");
//					}
					if ("S".equals(status)) {
						rnt.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
						tra.setTrade_status(TradeStatusEnum.REFUND_SUCCESS);
						tra.setBanktradeno(r.get("bankTradeNo"));
						tra.setBankorderno(r.get("bankOrderNo"));
						tra.setTrade_no_chl(r.get("centerSeqId"));
						tra.setDt_finish(pmputils.getServerDateTime());
						FDouble fee=tra.getAmount();
						FDouble abk=ord.getAmount_bk();
						ord.setAmount_bk(abk.sub(fee));
						ord.setStatus(DOStatus.UPDATED);
						rnt.setAmount(fee);
						rnt.setBanktradeno(tra.getBanktradeno());
						rnt.setMch_order_no(ord.getCode());
						rnt.setTrade_no(tra.getTrade_no());
						rnt.setBankorderno(tra.getBankorderno());
						rnt.setTrade_no_chl(tra.getTrade_no_chl());
					}  else if ("R".equals(status)) {
						rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
						tra.setTrade_status(TradeStatusEnum.TRADE_UNKNOWN);
						refundquery( tra, ord,  rnt);

					} else if ("E".equals(status)) {
						rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
//						tra.setTrade_status(TradeStatusEnum.REFUND_FAIL);
						refundquery( tra, ord,  rnt);
					}


			}else if("E".equals(r.get("gateReturnType"))){
				rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
//				tra.setTrade_status(TradeStatusEnum.REFUND_FAIL);
				rnt.setErr_code(r.get("gateReturnCode"));
				rnt.setErr_code_des(r.get("gateReturnMessage"));
				tra.setErr_code(r.get("gateReturnCode"));
				refundquery( tra, ord,  rnt);
			}else {
				rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
			}
			tra.setStatus(DOStatus.UPDATED);
			pmputils.getTradeCUDService().save(
					new TradeDO[] { tra });
			pmputils.getOrdCudService().save(new OrdDO[] {ord});
			return rnt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	
	/**
	 * 统一下单
	 * @param data
	 * @return
	 * @throws BizException 
	 */
	public OrdRstDTO dobarcodepay(Map<String, Object> data,TradeDO tra,OrdDO ord,OrdReqDTO dto) throws BizException{
		Map<String,String> rst=pay.doScanPay(data);
		OrdRstDTO rnt = new OrdRstDTO();
		if(rst!=null) {
		if("S".equals(rst.get("gateReturnType"))) {
			if(rst.containsKey("tradeStatus")) {
				String tradestatus=rst.get("tradeStatus");
				if("R".equals(tradestatus)) {
					//查询交易是否成功
					payquery( tra, ord, dto, rnt);
				}else if("E".equals(tradestatus)){
					rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
					rnt.setErr_code(rst.get("gateReturnCode"));
					rnt.setErr_code_des(rst.get("gateReturnMessage"));
					int state = TradeStatusEnum.PAY_FAIL;
					utils.updateTradeStatusnew(tra, state);
					utils.updateOrdStatus(ord, OrdStatusEnum.FAIL);
					tra.setErr_code(rst.get("gateReturnCode"));
				}else {
					rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
				}
				
				
			}
		}else {
			rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
			rnt.setErr_code(rst.get("gateReturnCode"));
			rnt.setErr_code_des(rst.get("gateReturnMessage"));
//			int state = TradeStatusEnum.PAY_FAIL;
//			utils.updateTradeStatusnew(tra, state);
//			utils.updateOrdStatus(ord, OrdStatusEnum.FAIL);
			tra.setErr_code(rst.get("gateReturnCode"));
			payquery( tra, ord, dto, rnt);
			
		}
		updateOrdAndTrade( tra, ord);
		}
		return rnt;
	}
	/**
	 * 支付查询
	 * @param tra
	 * @param ord
	 * @param dto
	 * @param rnt
	 * @throws BizException 
	 */
	private void payquery(TradeDO tra,OrdDO ord,OrdReqDTO dto,OrdRstDTO rnt) throws BizException {
		
		//查询交易是否成功
		Map<String,String> r=orderQuery(ord.getCode(),tra.getTrade_no());
		if(r!=null&& "S".equals(r
				.get("gateReturnType"))) {
			String trade_state = r.get("tradeStatus");
			String total_fee = r.get("amount");
			if ("S".equals(trade_state)) {
				// 支付成功

				rnt.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
				tra.setDt_finish(pmputils.getServerDateTime());
				tra.setBanktradeno(r.get("bankTradeNo"));
				tra.setTrade_no_chl(r.get("centerSeqId"));
				tra.setBankorderno(r.get("bankOrderNo"));
				tra.setStatus(DOStatus.UPDATED);
				rnt.setBankorderno(r.get("bankOrderNo"));
				rnt.setTrade_no_chl(r.get("centerSeqId"));
				ord.setDt_pay(pmputils.getServerDateTime());
				utils.updateTradeStatusnew(tra, TradeStatusEnum.PAY_SUCCESS,
						total_fee);
				utils.updateOrdStatus2(ord, OrdStatusEnum.PAID,  "0");
				rnt.setAmount(tra.getAmount());
				rnt.setMch_order_no(ord.getCode());
				rnt.setBanktradeno(tra.getBanktradeno());

			} else if ("E".equals(trade_state)) {
				// 支付失败(其他原因，如银行返回失败)
				rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
				int state = TradeStatusEnum.PAY_FAIL;
				utils.updateTradeStatusnew(tra, state);
				utils.updateOrdStatus(ord, OrdStatusEnum.FAIL);
			} else if (trade_state.equals("R")) {
				// 未支付
				rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
				utils.updateTradeStatusnew(tra, TradeStatusEnum.NOTPAY);
				utils.updateOrdStatus(ord, OrdStatusEnum.FAIL);
				String err_msg="交易结果未知，请刷新界面！"+rnt.getErr_code_des();
				rnt.setErr_code_des(err_msg);
			}
			
		}else {
			rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
			String err_msg="交易结果未知，请刷新界面！"+rnt.getErr_code_des();
			rnt.setErr_code_des(err_msg);
		}
	}
	/**
	 * 退款查询
	 * @param tra
	 * @param ord
	 * @param rnt
	 * @throws BizException 
	 */
	
private void refundquery(TradeDO tra,OrdDO ord,OrdRstDTO rnt) throws BizException {
		
		//查询交易是否成功
		Map<String,String> r=orderQuery(ord.getCode(),tra.getTrade_no());
		if(r!=null&& "S".equals(r
				.get("gateReturnType"))) {
			String trade_state = r.get("tradeStatus");
			String total_fee = r.get("amount");
			if ("S".equals(trade_state)) {
				// 退款成功

				rnt.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
				tra.setDt_finish(pmputils.getServerDateTime());
				tra.setBankorderno(r.get("bankOrderNo"));
				tra.setTrade_no_chl(r.get("centerSeqId"));
				tra.setBanktradeno(r.get("bankTradeNo"));
				tra.setStatus(DOStatus.UPDATED);
				
				utils.updateTradeStatusnew(tra, TradeStatusEnum.REFUND_SUCCESS,
						total_fee);
				FDouble fee=tra.getAmount();
				FDouble abk=ord.getAmount_bk();
				ord.setAmount_bk(abk.sub(fee));
				ord.setStatus(DOStatus.UPDATED);
				rnt.setAmount(tra.getAmount());
				rnt.setBankorderno(r.get("bankOrderNo"));
				rnt.setTrade_no_chl(r.get("centerSeqId"));
				rnt.setMch_order_no(ord.getCode());
				rnt.setBanktradeno(tra.getBanktradeno());
				rnt.setTrade_no(tra.getTrade_no());

			} else if ("E".equals(trade_state)) {
				// 退款失败(其他原因，如银行返回失败)
				rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
				tra.setTrade_status(TradeStatusEnum.REFUND_FAIL);
			} else if (trade_state.equals("R")) {
				// 未退款
				rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
				tra.setTrade_status(TradeStatusEnum.TRADE_UNKNOWN);
			}
			
		}else {
			rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
		}
	}
	
	
	/**
	 * 刷卡支付轮询查询状态
	 * @param t
	 * @param o
	 * @return
	 */
	private Map<String,String> doquerypost(TradeDO t,OrdDO ord){
		int remainingTimeMs=60*1000;
		int  connectTimeoutMs=  2000;
		long startTimestampMs=0;
		Map<String,String>lastResult=null;
		while(true){
			startTimestampMs=WXPayUtil.getCurrentTimestampMs();
			int readTimeoutMs=remainingTimeMs-connectTimeoutMs;
			if(readTimeoutMs>1000){
				try{
					lastResult=orderQuery(ord.getCode(),t.getTrade_no());
					if(lastResult!=null&& "S".equals(lastResult
							.get("gateReturnType"))) {
						String trade_state=lastResult.get("tradeStatus");
						if(!(trade_state.equals("R"))){
                        	break;
                        }
					}else {
						break;
					}
					// 状态是支付中、支付失败、查询失败，继续轮询
					remainingTimeMs=remainingTimeMs-(int)(WXPayUtil.getCurrentTimestampMs()-startTimestampMs);
					startTimestampMs=WXPayUtil.getCurrentTimestampMs();
					if(remainingTimeMs<=100){
						break;
					}
					else{
						if(remainingTimeMs>5*1000){
							Thread.sleep(5*1000);
						}else{
							Thread.sleep(1*1000);
						}
						remainingTimeMs=remainingTimeMs-(int)(WXPayUtil.getCurrentTimestampMs()-startTimestampMs);
						continue;
					}
				}catch(Exception ex){
					lastResult=null;
					break;
				}
			}else{
				break;
			}
		}
		return lastResult;
	}
	/**
	 * 退款
	 * @param ord_no
	 * @param trade_no
	 * @param amount
	 * @return
	 * @throws BizException 
	 */
	public Map<String,String>dorefund(String ord_no,String trade_no,int amount) throws BizException{
		Map<String, Object> data=new HashMap<String,Object>();
		data.put("merchantSeq", ord_no);
		data.put("mchSeqNo", trade_no);
		data.put("orderAmount", amount+"");
		Map<String,String> rst=pay.refund(data);
		return rst;
	}
	private void updateOrdAndTrade(TradeDO tra,OrdDO ord) throws BizException{
		tra.setStatus(DOStatus.UPDATED);
		pmputils.getTradeCUDService().update(
				new TradeDO[] { tra });

		ord.setStatus(DOStatus.UPDATED);
		pmputils.getOrdCudService().update(
				new OrdDO[] { ord });
	}
	
}
