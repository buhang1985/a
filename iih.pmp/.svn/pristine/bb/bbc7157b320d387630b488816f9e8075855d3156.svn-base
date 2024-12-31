package iih.pmp.yxpaySDK.cmbc;

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
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.yxpaySDK.bp.YxPayConfig;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class YxcmbcDataConvert  implements IPmpDataconvert{
	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();
	@Override
	public Map<String, Object> getBarcodeParam(OrdReqDTO dto, OrdDO ord, TradeDO tra) throws BizException {
		// TODO Auto-generated method stub
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("channelid", "62");
		data.put("terminalid", "63");		
		if("API_WXSCAN".equals(tra.getTradetype())) {
			data.put("sceneid", "12");
		}else if("API_ZFBSCAN".equals(tra.getTradetype())) {
			data.put("sceneid", "14");
		}
		data.put("merchantCode", YxPayConfig.getMchID());
		data.put("remark", dto.getAuth_code());
		data.put("totalFee", dto.getAmount().getDouble()+"");
		data.put("body", dto.getSubject());
		data.put("merchantSeq", ord.getCode());
		data.put("mchSeqNo", tra.getTrade_no());
		if(dto.getTradetype()!=null) {
			data.put("selectTradeType", dto.getTradetype());
		}else {
			data.put("selectTradeType", tra.getTradetype());
		}
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
		data.put("merchantCode", YxPayConfig.getMchID());
		data.put("merchantSeq", ord.getCode());
		data.put("querySeq", tra.getTrade_no());
		data.put("mchSeqNo", tra.getTrade_no());
		return data;
	}

	@Override
	public Map<String, Object> getRefundQueryParam(OrdDO ord, TradeDO tra, TradeDO paidtra) throws BizException {
		// TODO Auto-generated method stub
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("merchantCode", YxPayConfig.getMchID());
		data.put("merchantSeq", ord.getCode());
		data.put("mchSeqNo", tra.getTrade_no());
		data.put("querySeq", tra.getTrade_no());
		return data;
	}

	@Override
	public Map<String, Object> getReFundParam(OrdDO ord, TradeDO tra, OrdReqDTO dto, TradeDO paidtra)
			throws BizException {
		// TODO Auto-generated method stub
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("merchantCode", YxPayConfig.getMchID());
		data.put("merchantSeq", ord.getCode());
		data.put("mchSeqNo", tra.getTrade_no());
		data.put("querySeq", tra.getTrade_no());
		data.put("orderAmount", tra.getAmount().getDouble()+"");
		data.put("refundDesc", dto.getSubject());
		return data;
	}

	@Override
	public Map<String, String> BarcodeRntConvert(Map<String, String> rnt) throws BizException {
		// TODO Auto-generated method stub
		return RntConvert(rnt);
	}

	@Override
	public Map<String, String> QrcodeRntConvert(Map<String, String> rnt) throws BizException {
		// TODO Auto-generated method stub
		return RntConvert(rnt);
	}

	@Override
	public Map<String, String> QueryRntConvert(Map<String, String> rnt) throws BizException {
		// TODO Auto-generated method stub
		return RntConvert(rnt);
	}

	@Override
	public Map<String, String> RefundQueryRntConvert(Map<String, String> rnt) throws BizException {
		// TODO Auto-generated method stub
		return RntConvert(rnt);
	}

	@Override
	public Map<String, String> RefundRntConvert(Map<String, String> rnt) throws BizException {
		// TODO Auto-generated method stub
		return RntConvert(rnt);
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
		return "pay.yx.cmbc.0006";
	}
	
	private String getTradeStatus(String status) {
		if ("S".equals(status)) {
			return PmpPayConst.PMP_SUCCESS;
		} else if ("R".equals(status)) {
			return PmpPayConst.PMP_UNKNOW;
		} else if ("E".equals(status)) {
			return PmpPayConst.PMP_ERROR;
		} else {
			return null;
		}
	}
	
	private Map<String, String> RntConvert(Map<String, String> rnt) {

		Map<String, String> data = new HashMap<>();
		if (PmpPayConst.PMP_SUCCESS.equals(rnt.get(PmpPayConst.PMP_RESULT))) {
			data.put(PmpPayConst.PMP_TRADE_STATUS, this.getTradeStatus(rnt.get("tradeStatus")));
			if (PmpPayConst.PMP_SUCCESS.equals(data.get(PmpPayConst.PMP_TRADE_STATUS))) {
				
				data.put(PmpPayConst.PMP_AMOUNT, pmputils.fenToYuan(rnt.get("amount"))==null?null: pmputils.fenToYuan(rnt.get("amount"))+ "");//将金额由分转成元
				data.put(PmpPayConst.PMP_TRADE_NO, rnt.get("bankTradeNo"));
				data.put(PmpPayConst.PMP_ORDER_NO, rnt.get("bankOrderNo"));
				data.put(PmpPayConst.PMP_TRADE_CHL_NO, rnt.get("centerSeqId"));
				data.put(PmpPayConst.PMP__CHL_CODE, null);
				rnt.remove("amount");
				rnt.remove("bankTradeNo");
				rnt.remove("bankOrderNo");
				rnt.remove("centerSeqId");
			}
			rnt.remove("tradeStatus");
			
		}
		for (Map.Entry<String, String> entry : rnt.entrySet()) {
//			  System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			data.put(entry.getKey(), entry.getValue());
		}
		return data;
	}


}
