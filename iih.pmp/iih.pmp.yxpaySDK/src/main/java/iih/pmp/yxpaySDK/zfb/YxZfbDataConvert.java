package iih.pmp.yxpaySDK.zfb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pmp.pay.channelbillitem.d.ChlBillItemDO;
import iih.pmp.pay.custom.i.IPmpDataconvert;
import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.zfb.errorcode.ZFBFaceToFaceErrorCodeConst;
import iih.pmp.pay.util.zfb.errorcode.ZFBQueryErrorCondeConst;
import iih.pmp.pay.util.zfb.errorcode.ZFBRefundErrorCodeConst;
import iih.pmp.pay.util.zfb.errorcode.ZFBRefundQueryErrorCodeConst;
import iih.pmp.yxpaySDK.bp.YxPayConfig;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class YxZfbDataConvert   implements IPmpDataconvert{
	
	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();
	@Override
	public Map<String, Object> getBarcodeParam(OrdReqDTO dto, OrdDO ord, TradeDO tra) throws BizException {
		// TODO Auto-generated method stub
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("channelid", "2");
		data.put("terminalid", "63");
		data.put("sceneid", "14");
		data.put("merchantCode", YxPayConfig.getMchID());
		data.put("auth_code", dto.getAuth_code());
		data.put("totalFee", dto.getAmount().getDouble()+"");
		data.put("subject", dto.getSubject());
		data.put("body", dto.getBody());
		data.put("tradeType", "当面付");
		data.put("merchantTradeNo", tra.getTrade_no());
		data.put("scene", "bar_code");
		if(!pmputils.isStrEmpty(dto.getId_pat())) {
			IPatiMDORService  ipat=ServiceFinder.find(IPatiMDORService.class);
			PatDO p=ipat.findById(dto.getId_pat());
			if(p!=null) {
				data.put("name", p.getName());
				data.put("patientid", p.getCode());
				data.put("phone", p.getMob());
				data.put("idNo", p.getId_code());
			}else {
				data.put("name", "张三");
				data.put("patientid", "00012992000");
				data.put("phone", "18888888888");
				data.put("idNo", "42091111111111111");
			}
		}else {
			data.put("name", "张三");
			data.put("patientid", "00012992000");
			data.put("phone", "18888888888");
			data.put("idNo", "42091111111111111");
		}
		if (dto.getBiz_scene()!=null&&(dto.getBiz_scene().equals(IBlDictCodeConst.SD_BIZSCENE_OEP_CHARGE)||dto.getBiz_scene().equals(IBlDictCodeConst.SD_BIZSCENE_OEP_PRE))) {
			data.put("businessid", "17");
		}else if(dto.getBiz_scene()!=null&&dto.getBiz_scene().equals(IBlDictCodeConst.SD_BIZSCENE_OEP_ENT)) {
			data.put("businessid", "16");
		}else {
			data.put("businessid", "17");
		}
		
		return data;
	}

	@Override
	public Map<String, Object> getQRCODEParam(OrdReqDTO dto, OrdDO ord, TradeDO tra) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getQueryParam(OrdDO ord, TradeDO tra) throws BizException {
		// TODO Auto-generated method stub
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("merchantTradeNo", tra.getTrade_no());
		return data;
	}

	@Override
	public Map<String, Object> getRefundQueryParam(OrdDO ord, TradeDO tra, TradeDO paidtra) throws BizException {
		// TODO Auto-generated method stub
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("merchantTradeNo", paidtra.getTrade_no());
		data.put("merchantRefundTradeNo", tra.getTrade_no());
		return data;
	}

	@Override
	public Map<String, Object> getReFundParam(OrdDO ord, TradeDO tra, OrdReqDTO dto, TradeDO paidtra)
			throws BizException {
		// TODO Auto-generated method stub
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("merchantTradeNo", paidtra.getTrade_no());
		data.put("merchantRefundTradeNo", tra.getTrade_no());
		data.put("refundFee", tra.getAmount().getDouble()+"");
		data.put("refundDesc", dto.getSubject());
		data.put("refundMethod", dto.getBody());
		return data;
	}

	@Override
	public Map<String, String> BarcodeRntConvert(Map<String, String> rnt) throws BizException {
		// TODO Auto-generated method stub
		Map<String, String> data = new HashMap<String, String>();
		if("10000".equals(rnt.get("code"))&&!pmputils.isStrEmpty(rnt.get("trade_no"))) {
			//支付成功
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
    		data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_SUCCESS);
    		data.put(PmpPayConst.PMP_AMOUNT, rnt.get("total_amount"));
    		data.put(PmpPayConst.PMP_TRADE_NO, rnt.get("out_trade_no"));
    		data.put(PmpPayConst.PMP_ORDER_NO, rnt.get("out_trade_no"));
    		data.put(PmpPayConst.PMP_TRADE_CHL_NO, rnt.get("trade_no"));
		}else {
			String subcode=rnt.get("sub_code");
			int status=0;
			if(!pmputils.isStrEmpty(subcode)) {
				status=ZFBFaceToFaceErrorCodeConst.getTradeFailStatus(subcode);
			}
			
			  if(status==TradeStatusEnum.PAY_FAIL||status==TradeStatusEnum.CLOSED||status==TradeStatusEnum.REVOKED) {
				  data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
				  data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
              }else {
              	data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
              }
            data.put(PmpPayConst.PMP_ERR_CODE, pmputils.isStrEmpty(subcode)?rnt.get("msg"):subcode);
      		data.put(PmpPayConst.PMP_ERR_MSG, pmputils.isStrEmpty(rnt.get("sub_msg"))?rnt.get("msg"):rnt.get("sub_msg"));
		}
		return data;
	}

	@Override
	public Map<String, String> QrcodeRntConvert(Map<String, String> rnt) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> QueryRntConvert(Map<String, String> rnt) throws BizException {
		// TODO Auto-generated method stub
		Map<String, String> data = new HashMap<String, String>();
		if(PmpPayConst.PMP_SUCCESS.equals(rnt.get(PmpPayConst.PMP_RESULT))) {
		if("10000".equals(rnt.get("code"))&&!pmputils.isStrEmpty(rnt.get("trade_status"))) {
		String tradestatus=rnt.get("trade_status");
		switch (tradestatus) {
        case "TRADE_SUCCESS":
        	data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
    		data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_SUCCESS);
    		data.put(PmpPayConst.PMP_AMOUNT, rnt.get("total_amount"));
    		data.put(PmpPayConst.PMP_TRADE_NO, rnt.get("out_trade_no"));
    		data.put(PmpPayConst.PMP_ORDER_NO, rnt.get("out_trade_no"));
    		data.put(PmpPayConst.PMP_TRADE_CHL_NO, rnt.get("trade_no"));
            break;
        case "TRADE_FINISHED":
        	data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
    		data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_SUCCESS);
    		data.put(PmpPayConst.PMP_AMOUNT, rnt.get("total_amount"));
    		data.put(PmpPayConst.PMP_TRADE_NO, rnt.get("out_trade_no"));
    		data.put(PmpPayConst.PMP_ORDER_NO, rnt.get("out_trade_no"));
    		data.put(PmpPayConst.PMP_TRADE_CHL_NO, rnt.get("trade_no"));
            break;
        case "TRADE_CLOSED":
        	data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
        	data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
            data.put(PmpPayConst.PMP_ERR_CODE, rnt.get("msg"));
    		data.put(PmpPayConst.PMP_ERR_MSG, rnt.get("msg"));
            break;

        case "WAIT_BUYER_PAY":
        	data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
        	data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
            data.put(PmpPayConst.PMP_ERR_CODE, rnt.get("msg"));
    		data.put(PmpPayConst.PMP_ERR_MSG, rnt.get("msg"));
            break;
    }
	
		}else {
			
			String subcode=rnt.get("sub_code");
			int status=0;
			if(!pmputils.isStrEmpty(subcode)) {
				status=ZFBQueryErrorCondeConst.getTradeFailStatus(subcode);
			}
			 if(status==TradeStatusEnum.PAY_FAIL||status==TradeStatusEnum.CLOSED||status==TradeStatusEnum.REVOKED) {
				    data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
	              	data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
	              	data.put(PmpPayConst.PMP_ERR_CODE
							, PmpPayConst.PMP_ORD_NOT_EXIST);
					data.put(PmpPayConst.PMP_ERR_MSG, rnt.get("sub_msg"));
	          }else {
	        	  data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
				  data.put(PmpPayConst.PMP_ERR_MSG, rnt.get("sub_msg"));
	          }  
		}
		}else {
			data=rnt;
		}
		return data;
	}

	@Override
	public Map<String, String> RefundQueryRntConvert(Map<String, String> rnt) throws BizException {
		// TODO Auto-generated method stub
		Map<String, String> data = new HashMap<String, String>();	
            if(PmpPayConst.PMP_SUCCESS.equals(rnt.get(PmpPayConst.PMP_RESULT))) {
			if("10000".equals(rnt.get("code"))&&!pmputils.isStrEmpty(rnt.get("trade_no"))) {
				data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
        		data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_SUCCESS);
        		data.put(PmpPayConst.PMP_AMOUNT, rnt.get("refund_amount"));
        		data.put(PmpPayConst.PMP_TRADE_NO, rnt.get("out_request_no"));
        		data.put(PmpPayConst.PMP_ORDER_NO, rnt.get("out_trade_no"));
        		data.put(PmpPayConst.PMP_TRADE_CHL_NO, rnt.get("trade_no"));
			}else {
				String subcode=rnt.get("sub_code");
				int status=0;
				if(!pmputils.isStrEmpty(subcode)) {
					status=ZFBRefundQueryErrorCodeConst.getTradeFailStatus(subcode);
				}
				 if(status==TradeStatusEnum.REFUND_FAIL) {
					    data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
		              	data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
		              	data.put(PmpPayConst.PMP_ERR_CODE
								, PmpPayConst.PMP_ORD_NOT_EXIST);
						data.put(PmpPayConst.PMP_ERR_MSG, rnt.get("sub_msg"));
		          }else {
		        	  data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
					  data.put(PmpPayConst.PMP_ERR_MSG, rnt.get("sub_msg"));
		          }               
			}		
            }else {
            	data=rnt;
            }
		return data;
	}

	@Override
	public Map<String, String> RefundRntConvert(Map<String, String> rnt) throws BizException {
		// TODO Auto-generated method stub
		Map<String, String> data = new HashMap<String, String>();
		if("10000".equals(rnt.get("code"))&&!pmputils.isStrEmpty(rnt.get("trade_no"))) {
			
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
    		data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_SUCCESS);
//    		data.put(PmpPayConst.PMP_AMOUNT, rnt.get("total_amount"));
    		data.put(PmpPayConst.PMP_TRADE_NO, rnt.get(PmpPayConst.PMP_TRADE_NO));
    		data.put(PmpPayConst.PMP_ORDER_NO, rnt.get("out_trade_no"));
    		data.put(PmpPayConst.PMP_TRADE_CHL_NO, rnt.get("trade_no"));
		}else {
			String subcode=rnt.get("sub_code");
			int status=0;
			if(!pmputils.isStrEmpty(subcode)) {
				status=ZFBRefundErrorCodeConst.getTradeFailStatus(subcode);
			}
			if(status==TradeStatusEnum.REFUND_FAIL) {
				data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
				data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
			}else {
				data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
			}    		
			data.put(PmpPayConst.PMP_ERR_CODE, pmputils.isStrEmpty(subcode)?rnt.get("msg"):subcode);
	      	data.put(PmpPayConst.PMP_ERR_MSG, pmputils.isStrEmpty(rnt.get("sub_msg"))?rnt.get("msg"):rnt.get("sub_msg"));
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
		return null;
	}

	@Override
	public List<Map<String, Object>> getBillItemParam(FDate dt) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getChlCode() {
		// TODO Auto-generated method stub
		return "pay.yx.ali.0007";
	}

}
