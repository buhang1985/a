package iih.pmp.pay.dataconvert.bp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.pmp.pay.channelbillitem.d.ChlBillItemDO;
import iih.pmp.pay.custom.i.IPmpDataconvert;
import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordqryrstdto.d.CmbcBillTypeEnum;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayAppUtils;
import iih.pmp.pay.util.WXPayAppUtils;
import iih.pmp.pay.util.WXParamUtils.RFQueryRNTParamConst;
import iih.pmp.pay.util.WXParamUtils.WXCommonRntParamCode;
import iih.pmp.pay.util.wxerrorcode.WXMicropayErrorCodeConst;
import iih.pmp.pay.util.wxerrorcode.WXQueryErrorcode;
import iih.pmp.pay.util.wxerrorcode.WXReFundErrorCode;
import wxpay.sdk.WXPay;
import wxpay.sdk.WXProConfig;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

public class PmpWXDataConvertBP  implements IPmpDataconvert {
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	WXPayAppUtils utils=new WXPayAppUtils();

	@Override
	public Map<String, Object> getBarcodeParam(OrdReqDTO dto, OrdDO ord, TradeDO tra) {
		// TODO Auto-generated method stub
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("out_trade_no", tra.getTrade_no());
		data.put("body", dto.getSubject());
		data.put("total_fee", pmputils.Yuan2Fen(dto.getAmount()));
		data.put("auth_code", dto.getAuth_code());	
		return data;
	}

	@Override
	public Map<String, Object> getQueryParam(OrdDO ord, TradeDO tra) {
		// TODO Auto-generated method stub
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("out_trade_no", tra.getTrade_no());
		return data;
	}

	@Override
	public Map<String, Object> getRefundQueryParam(OrdDO ord, TradeDO tra, TradeDO paidtra) {
		// TODO Auto-generated method stub
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("out_refund_no", tra.getTrade_no());
		return data;
	}

	@Override
	public Map<String, Object> getReFundParam(OrdDO ord, TradeDO tra, OrdReqDTO dto, TradeDO paidtra) {
		// TODO Auto-generated method stub
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("out_trade_no", tra.getTrade_no_rel());
		data.put("out_refund_no", tra.getTrade_no());
		data.put("total_fee",
				pmputils.Yuan2Fen(ord.getAmount()));		
		data.put("refund_fee",
				pmputils.Yuan2Fen(dto.getAmount()));		
		data.put("refund_fee_type", "CNY");
		data.put("op_user_id", PmpPayAppUtils.getWXConfig().getMchID());
		String notifyurl=WXProConfig.getProperty("refund_notify_url");
		if(notifyurl!=null&&notifyurl.trim().length()!=0) {
			data.put("notify_url", notifyurl);
		}
//		data.put("notify_url", "http://59.108.125.241:8083/pmp/WXReFundNotifyHandler");
		
		//测试代码
//		data.put("out_trade_no", "0000000072");
//		data.put("out_refund_no", "05141510");
//		data.put("total_fee",1+"");
//		data.put("refund_fee",1+"");
		return data;
	}

	@Override
	public Map<String, String> BarcodeRntConvert(Map<String, String> rnt) throws BizException {
		Map<String, String> data = new HashMap<String, String>();
		// TODO Auto-generated method stub
		if (rnt.get(WXCommonRntParamCode.RETURN_CODE).equals(WXCommonRntParamCode.SUCCESS)) {
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
			if (WXCommonRntParamCode.SUCCESS.equals(rnt.get(WXCommonRntParamCode.RESULT_CODE))) {
				setSuccessState(data,rnt);
			}else {
				int status=WXMicropayErrorCodeConst.getTradeFailStatus(rnt.get(WXCommonRntParamCode.ERR_CODE));
                if(status==TradeStatusEnum.PAY_FAIL||status==TradeStatusEnum.CLOSED||status==TradeStatusEnum.REVOKED) {
                	data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
                }else {
                	data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
                }
                data.put(PmpPayConst.PMP_ERR_CODE, rnt.get("err_code"));
        		data.put(PmpPayConst.PMP_ERR_MSG, rnt.get("err_code_des"));
			}
		}else {
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_ERROR);
			data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
			data.put(PmpPayConst.PMP_ERR_MSG, rnt.get(WXCommonRntParamCode.RETURN_MSG));
		}
		for (Map.Entry<String, String> entry : rnt.entrySet()) {
//			  System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			data.put(entry.getKey(), entry.getValue());
		}
		return data;
	}

	@Override
	public Map<String, String> QueryRntConvert(Map<String, String> rnt) throws BizException {
		// TODO Auto-generated method stub
		Map<String, String> data = new HashMap<String, String>();
		if (rnt != null
				&& WXCommonRntParamCode.SUCCESS.equals(rnt
						.get(WXCommonRntParamCode.RETURN_CODE))) {
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
			if (WXCommonRntParamCode.SUCCESS.equals(rnt
					.get(WXCommonRntParamCode.RESULT_CODE))) {		
		String trade_state=rnt.get("trade_state");
		if ("SUCCESS".equals(trade_state)) {
			// 支付成功
			setSuccessState(data,rnt);

		} else if ("REFUND".equals(trade_state)) {
			// 转入退款
			setSuccessState(data,rnt);
		
		} else if ("CLOSED".equals(trade_state)) {
			// 已关闭
			data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);

		} else if ("REVOKED".equals(trade_state)) {
			// 已撤销（刷卡支付）
			data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);

		} else if ("USERPAYING".equals(trade_state)) {
			// 用户支付中
			data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);

		} else if ("PAYERROR".equals(trade_state)) {
			// 支付失败(其他原因，如银行返回失败)
			data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
		} else if (trade_state.equals("NOTPAY")) {
			// 未支付
			data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
		}

			}else {
				int state=WXQueryErrorcode.getTradeFailStatus(rnt.get(WXCommonRntParamCode.ERR_CODE));
				if(state==TradeStatusEnum.PAY_FAIL) {
					data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
					data.put(PmpPayConst.PMP_ERR_CODE
							, PmpPayConst.PMP_ORD_NOT_EXIST);
				}else {
					data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
				}
			}
		}else {
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_ERROR);
			data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
		}
		for (Map.Entry<String, String> entry : rnt.entrySet()) {
//			  System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			data.put(entry.getKey(), entry.getValue());
		}
		return data;
	}
	
	private void setSuccessState(Map<String, String> data,Map<String, String> rnt) {
		data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_SUCCESS);
		data.put(PmpPayConst.PMP_AMOUNT, pmputils.fenToYuan(rnt.get("total_fee"))==null?null: pmputils.fenToYuan(rnt.get("total_fee"))+ "");//将金额由分转成元
		data.put(PmpPayConst.PMP_TRADE_NO, rnt.get("out_trade_no"));
		data.put(PmpPayConst.PMP_ORDER_NO, rnt.get("out_trade_no"));
		data.put(PmpPayConst.PMP_TRADE_CHL_NO, rnt.get("transaction_id"));
	}

	@Override
	public Map<String, String> RefundQueryRntConvert(Map<String, String> rnt) throws BizException {
		// TODO Auto-generated method stub
		Map<String, String> data = new HashMap<String, String>();
		if (rnt != null
				&& WXCommonRntParamCode.SUCCESS.equals(rnt
						.get(WXCommonRntParamCode.RETURN_CODE))) {
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
			if (WXCommonRntParamCode.SUCCESS.equals(rnt
					.get(WXCommonRntParamCode.RESULT_CODE))) {
				Map<String, String> mr = utils.GetRntParam2(rnt);
				Map<String, String> m = rnt;
				String status = m.get(mr.get(RFQueryRNTParamConst.REFUND_STATUS));

				if ("SUCCESS".equals(status)) {
					data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_SUCCESS);
					data.put(PmpPayConst.PMP_AMOUNT, pmputils.fenToYuan(rnt.get(mr.get(RFQueryRNTParamConst.REFUND_FEE)))==null?null: pmputils.fenToYuan(rnt.get(mr.get(RFQueryRNTParamConst.REFUND_FEE)))+ "");//将金额由分转成元
					data.put(PmpPayConst.PMP_TRADE_NO, rnt.get(mr.get(RFQueryRNTParamConst.OUT_REFUND_NO)));
					data.put(PmpPayConst.PMP_ORDER_NO, rnt.get(RFQueryRNTParamConst.OUT_TRADE_NO));
					data.put(PmpPayConst.PMP_TRADE_CHL_NO, rnt.get(mr.get(RFQueryRNTParamConst.REFUND_ID)));

				} else if ("REFUNDCLOSE".equals(status)) {
					// todo 退款已关闭是否可以用同样的单号继续退款？？？？
					data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
					data.put(PmpPayConst.PMP_ERR_MSG, "REFUNDCLOSE");

				} else if ("PROCESSING".equals(status)) {
					data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
					data.put(PmpPayConst.PMP_ERR_MSG, "PROCESSING");

				} else if ("CHANGE".equals(status)) {
					data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
					data.put(PmpPayConst.PMP_ERR_MSG, "CHANGE");
				}
			} else if (rnt.get(WXCommonRntParamCode.ERR_CODE).equals(
					"REFUNDNOTEXIST")) {
				data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
				data.put(PmpPayConst.PMP_ERR_CODE
						, PmpPayConst.PMP_ORD_NOT_EXIST);

			} else {	
				data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
			}

		} else {
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_ERROR);
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_UNKNOW);
		}
		for (Map.Entry<String, String> entry : rnt.entrySet()) {
//			  System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			data.put(entry.getKey(), entry.getValue());
		}
		return data;
	}

	@Override
	public Map<String, String> RefundRntConvert(Map<String, String> rnt) throws BizException {
		// TODO Auto-generated method stub
		Map<String, String> data = new HashMap<String, String>();
		// TODO Auto-generated method stub
		if (rnt.get(WXCommonRntParamCode.RETURN_CODE).equals(WXCommonRntParamCode.SUCCESS)) {
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
			if (WXCommonRntParamCode.SUCCESS.equals(rnt.get(WXCommonRntParamCode.RESULT_CODE))) {
				data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_SUCCESS);
				data.put(PmpPayConst.PMP_AMOUNT, pmputils.fenToYuan(rnt.get("refund_fee"))==null?null: pmputils.fenToYuan(rnt.get("refund_fee"))+ "");//将金额由分转成元
				data.put(PmpPayConst.PMP_TRADE_NO, rnt.get("out_refund_no"));
				data.put(PmpPayConst.PMP_ORDER_NO, rnt.get("out_trade_no"));
				data.put(PmpPayConst.PMP_TRADE_CHL_NO, rnt.get("refund_id"));
			}else {
				int status=WXReFundErrorCode.getTradeFailStatus(rnt.get(WXCommonRntParamCode.ERR_CODE));
                if(status==TradeStatusEnum.REFUND_FAIL) {
                	data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
                }else {
                	data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
                }
                data.put(PmpPayConst.PMP_ERR_CODE, rnt.get("err_code"));
        		data.put(PmpPayConst.PMP_ERR_MSG, rnt.get("err_code_des"));
			}
		}else {
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_ERROR);
			data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
			data.put(PmpPayConst.PMP_ERR_MSG, rnt.get(WXCommonRntParamCode.RETURN_MSG));
		}
		for (Map.Entry<String, String> entry : rnt.entrySet()) {
//			  System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			data.put(entry.getKey(), entry.getValue());
		}
		return data;
	}

	@Override
	public void setTradeVal(TradeDO t, Map<String, String> m, FDouble fee, OrdRstDTO rnt) throws BizException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ChlBillItemDO str2BillItem(String str, String sd_chl, FDate dt, Map<String, Object> map)
			throws BizException {
		// TODO Auto-generated method stub
		 String[] mrnt=str.split(",");
		   ChlBillItemDO b=new ChlBillItemDO();
			b.setTradetime(new FDateTime(getBillVal(mrnt[0])));
			b.setChanneltradeno(this.getBillVal(mrnt[5]));
			b.setMch_trade_no(this.getBillVal(mrnt[6]));
			b.setUser_identify(this.getBillVal(mrnt[7]));
			b.setTrade_type(this.getBillVal(mrnt[8]));
			b.setTrade_status(this.getBillVal(mrnt[9]));
			b.setBank(this.getBillVal(mrnt[10]));
			b.setCurrency_type(this.getBillVal(mrnt[11]));
			Double d=Double.parseDouble(this.getBillVal(mrnt[12]));
			b.setTotal_fee(new FDouble(d));
			b.setChannel_refund_no(this.getBillVal(mrnt[14]));
			b.setMch_refund_no(this.getBillVal(mrnt[15]));
			d=Double.parseDouble(this.getBillVal(mrnt[16]));
			b.setRefund_fee(new FDouble(d));
			b.setRefund_type(this.getBillVal(mrnt[18]));
			b.setRefund_status(this.getBillVal(mrnt[19]));
			b.setProduct_name(this.getBillVal(mrnt[20]));
			b.setStatus(DOStatus.NEW);
			b.setId_chl(PmpPayConst.getUdiID(sd_chl, PmpPayConst.CHANNEL_DOCLIST_ID));
			b.setSd_chl(sd_chl);
            b.setBanktradeno(b.getMch_trade_no());
            if(b.getTrade_status().equals("REFUND"))
            	b.setBanktradeno(b.getMch_refund_no());
            b.setBill_type(CmbcBillTypeEnum.WX);
		    return b;
	}
	private String getBillVal(String val){
		return val.substring(1, val.length());
	}

	@Override
	public List<Map<String, Object>> getBillItemParam(FDate dt) throws BizException {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list=new ArrayList<>();
		Map<String,Object>data=new HashMap<String,Object>();	 		 
		 DateFormat format1 = new SimpleDateFormat("yyyyMMdd"); 
			String d=format1.format(dt.toDate());
			data.put("bill_date", d);
			data.put("bill_type", "ALL");
		 list.add(data);	 
		
		return list;
	}

	@Override
	public String getChlCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getQRCODEParam(OrdReqDTO dto, OrdDO ord, TradeDO tra) throws BizException {
		// TODO Auto-generated method stub
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("body", dto.getSubject());
		data.put("out_trade_no", tra.getTrade_no());
		data.put("device_info", "");
		data.put("fee_type", "CNY");
		data.put("total_fee", pmputils.Yuan2Fen(dto.getAmount()));
		data.put("spbill_create_ip", "123.12.12.123");
		data.put("trade_type", dto.getSd_scene());
		data.put("product_id", "11");	
		data.put("notify_url", "www.baidu.com");	
		return data;
	}

	@Override
	public Map<String, String> QrcodeRntConvert(Map<String, String> rnt) throws BizException {
		// TODO Auto-generated method stub
		Map<String, String> data = new HashMap<String, String>();
		if (rnt.get(WXCommonRntParamCode.RETURN_CODE).equals(WXCommonRntParamCode.SUCCESS)) {
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
			if (WXCommonRntParamCode.SUCCESS.equals(rnt.get(WXCommonRntParamCode.RESULT_CODE))) {
//				setSuccessState(data,rnt);
				data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_SUCCESS);
				data.put(PmpPayConst.PMP_AMOUNT, pmputils.fenToYuan(rnt.get("total_fee"))==null?null: pmputils.fenToYuan(rnt.get("total_fee"))+ "");//将金额由分转成元
				data.put(PmpPayConst.PMP__PREPAY_ID, rnt.get(WXCommonRntParamCode.PREPAY_ID));
				data.put(PmpPayConst.PMP__QR_CODE, rnt.get(WXCommonRntParamCode.CODE_URL));
			}else {
				int status=WXMicropayErrorCodeConst.getTradeFailStatus(rnt.get(WXCommonRntParamCode.ERR_CODE));
                if(status==TradeStatusEnum.PAY_FAIL||status==TradeStatusEnum.CLOSED||status==TradeStatusEnum.REVOKED) {
                	data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
                }else {
                	data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
                }
                data.put(PmpPayConst.PMP_ERR_CODE, rnt.get("err_code"));
        		data.put(PmpPayConst.PMP_ERR_MSG, rnt.get("err_code_des"));
			}
		}else {
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_ERROR);
			data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
			data.put(PmpPayConst.PMP_ERR_MSG, rnt.get(WXCommonRntParamCode.RETURN_MSG));
		}
		for (Map.Entry<String, String> entry : rnt.entrySet()) {
//			  System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			data.put(entry.getKey(), entry.getValue());
		}
		return data;
	}

}
