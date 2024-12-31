package iih.pmp.pay.s.bp;

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
import iih.pmp.pay.util.PmpPayAppUtils;
import iih.pmp.pay.util.WXPayAppUtils;
import iih.pmp.pay.util.WXParamUtils.WXCommonRntParamCode;
import iih.pmp.pay.util.wxerrorcode.WXMicropayErrorCodeConst;
import iih.pmp.pay.util.wxerrorcode.WXReFundErrorCode;
import iih.pmp.pay.util.wxerrorcode.WXUnifiedErrorCodeConst;
import test.wxpay.sdk.WXPayConfigImpl;
import wxpay.sdk.WXPay;
import wxpay.sdk.WXPayUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDouble;

public class WXPayBP {

	private WXPay wxpay;
	private WXPayConfigImpl config;
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	WXPayAppUtils utils=new WXPayAppUtils();

	public WXPayBP() {
		try {
			config = WXPayConfigImpl.getInstance();
//			wxpay = new WXPay(config,"http://hit.viphk.ngrok.org/pmp/WXPayNotifyHandle",true,true);
			wxpay = new WXPay(config,"http://59.108.125.241:8083/pmp/WXPayNotifyHandle",true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public  OrdRstDTO UnifiedOrder(HashMap<String, String> data,TradeDO tra,OrdDO ord,OrdReqDTO dto) throws BizException {
		OrdRstDTO rnt = null;
		try {
			Map<String, String> r = wxpay.unifiedOrder(data);
			rnt = new OrdRstDTO();
			if (r.get(WXCommonRntParamCode.RETURN_CODE).equals(WXCommonRntParamCode.SUCCESS)) {
				if (WXCommonRntParamCode.SUCCESS.equals(r.get(WXCommonRntParamCode.RESULT_CODE))) {
					rnt.setAppid(r.get(WXCommonRntParamCode.APPID));
					rnt.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
					rnt.setPrepay_id(r.get(WXCommonRntParamCode.PREPAY_ID));
					String code_url = r.get(WXCommonRntParamCode.CODE_URL);
					tra.setQr_code(code_url);
					rnt.setQr_code(PmpPayAppUtils
							.getQRCodeImge(code_url));
					tra.setTrade_status(TradeStatusEnum.PAY_WAIT);
					ord.setOrd_status(OrdStatusEnum.WAIT_TO_PAY);
					utils.HandleExInfo(rnt, dto.getSd_scene(),
							config);
				} else {
					rnt.setAppid(r.get(WXCommonRntParamCode.APPID));
					rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
					
					rnt.setErr_code(r.get(WXCommonRntParamCode.ERR_CODE));
					rnt.setErr_code_des(r.get(WXCommonRntParamCode.ERR_CODE_DES));
					tra.setTrade_status(WXUnifiedErrorCodeConst
							.getTradeFailStatus(r.get(WXCommonRntParamCode.ERR_CODE)));
					tra.setErr_code(r.get(WXCommonRntParamCode.ERR_CODE));
					utils.setOrdState(tra, ord);
				}

				updateOrdAndTrade( tra, ord);
			}
			return rnt;

		} catch (Exception e) {
			e.printStackTrace();
		}
	return rnt;
	}
	

	
	public OrdRstDTO microPayWithPos(HashMap<String, String> data,TradeDO tra,OrdDO ord,OrdReqDTO dto) throws BizException {
		OrdRstDTO rnt = null;
		
		try {
//			/*
			Map<String, String> r = wxpay.microPay(data);

			rnt = new OrdRstDTO();
			if (r.get(WXCommonRntParamCode.RETURN_CODE).equals(WXCommonRntParamCode.SUCCESS)) {
				if (WXCommonRntParamCode.SUCCESS.equals(r.get(WXCommonRntParamCode.RESULT_CODE))) {
					rnt.setAppid(r.get(WXCommonRntParamCode.APPID));
					rnt.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
					tra.setTrade_status(TradeStatusEnum.PAY_SUCCESS);
					tra.setDt_finish(pmputils.getServerDateTime());
					tra.setTrade_no_chl(r.get("transaction_id"));
					ord.setDt_pay(pmputils.getServerDateTime());
					ord.setOrd_status(OrdStatusEnum.PAID);

				} else {
					rnt.setAppid(r.get(WXCommonRntParamCode.APPID));
					rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);

					rnt.setErr_code(r.get(WXCommonRntParamCode.ERR_CODE));
					rnt.setErr_code_des(r.get(WXCommonRntParamCode.ERR_CODE_DES));
					tra.setTrade_status(WXMicropayErrorCodeConst
							.getTradeFailStatus(r.get(WXCommonRntParamCode.ERR_CODE)));
					tra.setErr_code(r.get(WXCommonRntParamCode.ERR_CODE));
//					if(tra.getTrade_status().equals(TradeStatusEnum.PAY_WAIT)||tra.getTrade_status().equals(TradeStatusEnum.TRADE_UNKNOWN))
//					{
					Map<String,String>m=this.tradequery(tra);
					this.HandleQueryRst(tra, m, rnt);
//					}
//					if(tra.getTrade_status()==TradeStatusEnum.TRADE_UNKNOWN||tra.getTrade_status()==TradeStatusEnum.PAY_FAIL){
//						//交易状态未知或者确认失败的情况下撤回订单
//						int tradestate=this.doCancel(tra.getTrade_no());
//                        if(tradestate==TradeStatusEnum.REVOKED||tradestate==TradeStatusEnum.PAY_WAIT){
//                        	tra.setTrade_status(tradestate);
//                        }
//					}
					utils.setOrdState(tra, ord);

				}
				updateOrdAndTrade( tra, ord);
			}
			return rnt;
//        */
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rnt;
	}

	public OrdRstDTO refund(HashMap<String, String> data,TradeDO tra,OrdDO ord){
		OrdRstDTO rnt = null;		
		try {
			Map<String, String> r = wxpay.refund(data);
			rnt = new OrdRstDTO();
			System.out.println(r);
			if (r.get(WXCommonRntParamCode.RETURN_CODE).equals(WXCommonRntParamCode.SUCCESS)) {
				if (WXCommonRntParamCode.SUCCESS.equals(r.get(WXCommonRntParamCode.RESULT_CODE))) {
					rnt.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
					tra.setTrade_status(TradeStatusEnum.REFUNDING);
					FDouble fee=tra.getAmount();
					FDouble abk=ord.getAmount_bk();
					ord.setAmount_bk(abk.sub(fee));
					ord.setStatus(DOStatus.UPDATED);
				} else {
					rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
					rnt.setErr_code(r.get(WXCommonRntParamCode.ERR_CODE));
					rnt.setErr_code_des(r.get(WXCommonRntParamCode.ERR_CODE_DES));
					tra.setTrade_status(WXReFundErrorCode
							.getTradeFailStatus(r.get(WXCommonRntParamCode.ERR_CODE)));
					tra.setErr_code(r.get(WXCommonRntParamCode.ERR_CODE));
				}
				tra.setStatus(DOStatus.UPDATED);
				pmputils.getTradeCUDService().save(
						new TradeDO[] { tra });
				pmputils.getOrdCudService().save(new OrdDO[] {ord});
			}
			return rnt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	
	}

	/**
	 * 通过交易号查询订单
	 * 
	 * @param out_trade_no
	 * @return
	 */
	public Map<String, String> doOrderQuery(String out_trade_no) {
		System.out.println("查询订单");
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("out_trade_no", out_trade_no);
		try {
			Map<String, String> r = wxpay.orderQuery(data);
			System.out.println(r);
			return r;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 可以设置超时时间
	 * @param out_trade_no
	 * @param connectTimeoutMs
	 * @param readTimeoutMs
	 * @return
	 */
	public Map<String,String>orderQuery(String out_trade_no,int connectTimeoutMs,int readTimeoutMs){
		System.out.println("查询订单");
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("out_trade_no", out_trade_no);
		try {
			Map<String, String> r = wxpay.orderQuery(data,connectTimeoutMs,readTimeoutMs);
			System.out.println(r);
			return r;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 通过微信订单号查询订单
	 * 
	 * @param transaction_id
	 * @return
	 */
	public Map<String, String> doOrderQuery8WXID(String transaction_id) {
		System.out.println("查询订单");
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("transaction_id", transaction_id);
		try {
			Map<String, String> r = wxpay.orderQuery(data);
			System.out.println(r);
			return r;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 订单撤销
	 * 
	 * @param out_trade_no
	 */
	public Map<String, String> doOrderReverse(String out_trade_no) {
		System.out.println("撤销");
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("out_trade_no", out_trade_no);

		try {
			Map<String, String> r = wxpay.reverse(data);
			return r;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 订单撤销
	 * 
	 * @param out_trade_no
	 */
	public Map<String, String> doOrderReverse(String out_trade_no,int connectTimeoutMs,int readTimeoutMs) {
		System.out.println("撤销");
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("out_trade_no", out_trade_no);

		try {
			Map<String, String> r = wxpay.reverse(data,connectTimeoutMs,readTimeoutMs);
			return r;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	

	public Map<String, String> doRefundQuery(String out_refund_no) {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("out_refund_no", out_refund_no);
		try {
			Map<String, String> r = wxpay.refundQuery(data);
			System.out.println(r);
			return r;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public Map<String, String> doRefundQuery8trade(String out_trade_no) {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("out_trade_no", out_trade_no);
		try {
			Map<String, String> r = wxpay.refundQuery(data);
			System.out.println(r);
			return r;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
    public Map<String,String> downloadBill(HashMap<String, String> data){				
		try {
			Map<String, String> r = wxpay.downloadBill(data);
			System.out.println(r);
			return r;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
/**
 * 撤回  轮询
 * @param out_trade_no
 * @return
 * @throws Exception 
 */
	public  Map<String,String> doCancel(String out_trade_no) throws Exception{
		int remainingTimeMs=30*1000;
		long startTimestampMs=0;
		Map<String,String>lastResult=null;
		Exception lastException=null;	
		int connectTimeoutMs=this.config.getHttpConnectTimeoutMs();
		while(true){
			startTimestampMs=WXPayUtil.getCurrentTimestampMs();
			int readTimeoutMs=remainingTimeMs-connectTimeoutMs;
			if(readTimeoutMs>1000){
				try{
					lastResult=this.doOrderReverse(out_trade_no, connectTimeoutMs, readTimeoutMs);
					String returnCode=lastResult.get("return_code");
					if(returnCode.equals("SUCCESS")){
						String resultCode=lastResult.get("result_code");
						String errCode=lastResult.get("err_code");
						if(resultCode.equals("SUCCESS")){
							return lastResult;
						}else{
					            if(errCode=="USERPAYING"){
					            	return lastResult;
					            }
					            String recall=lastResult.get("recall");
					            if("N".equals(recall))
					            	return lastResult;
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
							
						}
					}else{
						break;
					}
				}catch(Exception ex){
					lastResult=null;
					lastException=ex;
					break;
				}
			}else{
				break;
			}
		}

			return lastResult;		
	}
	
	private void updateOrdAndTrade(TradeDO tra,OrdDO ord) throws BizException{
		tra.setStatus(DOStatus.UPDATED);
		pmputils.getTradeCUDService().update(
				new TradeDO[] { tra });

		ord.setStatus(DOStatus.UPDATED);
		pmputils.getOrdCudService().update(
				new OrdDO[] { ord });
	}
	private Map<String,String> tradequery(TradeDO tra){
		Map<String,String>m=this.doquerypost(tra);
		return m;
	}
	private void HandleQueryRst(TradeDO tra,Map<String,String> m,OrdRstDTO rnt){
		if (m!=null&&m.get(WXCommonRntParamCode.RETURN_CODE).equals(WXCommonRntParamCode.SUCCESS)) {
			if (WXCommonRntParamCode.SUCCESS.equals(m.get(WXCommonRntParamCode.RESULT_CODE))) {
				String trade_state=m.get(WXCommonRntParamCode.TRADE_STATE);
				if ( "SUCCESS".equals(trade_state)) {
					// 支付成功
					tra.setDt_finish(pmputils.getServerDateTime());
					rnt.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
				tra.setTrade_status(TradeStatusEnum.PAY_SUCCESS);

				} else if (  "REFUND".equals(trade_state)) {
					// 转入退款
					tra.setDt_finish(pmputils.getServerDateTime());
					tra.setTrade_status(TradeStatusEnum.PAY_SUCCESS);

				} else if ( "CLOSED".equals(trade_state)) {
					// 已关闭
					tra.setTrade_status(TradeStatusEnum.CLOSED);

				} else if ( "REVOKED".equals(trade_state)) {
					// 已撤销（刷卡支付）
					tra.setTrade_status(TradeStatusEnum.REVOKED);

				} else if ( "USERPAYING".equals(trade_state)) {
					// 用户支付中
					tra.setTrade_status(TradeStatusEnum.PAY_WAIT);

				} else if ( "PAYERROR".equals(trade_state)) {
					// 支付失败(其他原因，如银行返回失败)
					tra.setTrade_status(TradeStatusEnum.PAY_FAIL);
				} else if (trade_state == "NOTPAY") {
					// 未支付
					tra.setTrade_status(TradeStatusEnum.PAY_FAIL);
				}
			}
			}
	}
	
	/**
	 * 刷卡支付轮询查询状态
	 * @param t
	 * @param o
	 * @return
	 */
	private Map<String,String> doquerypost(TradeDO t){
		int remainingTimeMs=60*1000;
		int  connectTimeoutMs=  2000;
		long startTimestampMs=0;
		Map<String,String>lastResult=null;
		Exception lastException=null;	
		String lastState=null;
		while(true){
			startTimestampMs=WXPayUtil.getCurrentTimestampMs();
			int readTimeoutMs=remainingTimeMs-connectTimeoutMs;
			if(readTimeoutMs>1000){
				try{
					lastResult=this.orderQuery(
							t.getTrade_no(), connectTimeoutMs, readTimeoutMs);
					 
					String returnCode=lastResult.get(WXCommonRntParamCode.RETURN_CODE);
					if(returnCode.equals(WXCommonRntParamCode.SUCCESS)){
						String resultCode=lastResult.get(WXCommonRntParamCode.RESULT_CODE);
						if(resultCode.equals(WXCommonRntParamCode.SUCCESS)){
							String trade_state=lastResult.get(WXCommonRntParamCode.TRADE_STATE);
							 lastState=trade_state;  
                            if(!(trade_state.equals("USERPAYING"))){
                            	break;
                            }
						}else{							
							break;							
						}
							
					}else{
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
					lastException=ex;
					break;
				}
			}else{
				break;
			}
		}
		return lastResult;
	}
	
	
	
	
}
