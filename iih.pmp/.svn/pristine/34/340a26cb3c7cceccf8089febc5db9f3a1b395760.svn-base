package iih.pmp.pay.dataconvert.bp;

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
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

public class CmbcDataconvertBP implements IPmpDataconvert {
	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();

	@Override
	public Map<String, Object> getBarcodeParam(OrdReqDTO dto, OrdDO ord, TradeDO tra) {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("deviceInfo", dto.getDeviceinfo());
		String remark = pmputils.getBase64Str(dto.getAuth_code());
		data.put("remark", remark);
		String amount = pmputils.Yuan2Fen(dto.getAmount());
		data.put("amount", amount);
		data.put("orderInfo", dto.getSubject());
		data.put("merchantSeq", ord.getCode());
		data.put("mchSeqNo", tra.getTrade_no());
		FDateTime dt = pmputils.getServerDateTime();
		String transdate = pmputils.getTransDate(dt, "yyyyMMdd");
		String transtime = pmputils.getTransDate(dt, "yyyyMMddHHmmssSSS");
		data.put("transDate", transdate);
		data.put("transTime", transtime);
		data.put("inExtData", dto.getBody());
		if(dto.getTradetype()!=null) {
			data.put("selectTradeType", dto.getTradetype());
		}else {
			data.put("selectTradeType", tra.getTradetype());
		}
		
		return data;
	}

	@Override
	public Map<String, Object> getQueryParam(OrdDO ord, TradeDO tra) {
		// TODO Auto-generated method stub
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("merchantSeq", ord.getCode());
		data.put("mchSeqNo", tra.getTrade_no());
		return data;
	}



	@Override
	public Map<String, Object> getRefundQueryParam(OrdDO ord, TradeDO tra,TradeDO paidtra) {
		// TODO Auto-generated method stub
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("merchantSeq", ord.getCode());
		data.put("mchSeqNo", tra.getTrade_no());
		return data;
	}

	@Override
	public Map<String, Object> getReFundParam(OrdDO ord, TradeDO tra, OrdReqDTO dto,TradeDO paidtra) {
		// TODO Auto-generated method stub
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("merchantSeq", ord.getCode());
		data.put("mchSeqNo", tra.getTrade_no());
		String amount = pmputils.Yuan2Fen(dto.getAmount());
		data.put("orderAmount", amount);
		data.put("orderNote", dto.getSubject());
		data.put("reserve", dto.getBody());
		return data;
	}

	@Override
	public Map<String, String> BarcodeRntConvert(Map<String, String> rnt) {

		return RntConvert(rnt);
	}

	/**
	 * 解析消息头
	 * 
	 * @param rnt
	 * @return
	 */
	private Map<String, String> getRntHead(Map<String, String> rnt) {
		Map<String, String> data = new HashMap<String, String>();
		String result = rnt.get("gateReturnType");
		if ("S".equals(result)) {
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
			rnt.remove("gateReturnType");
		} else {
			data.put(PmpPayConst.PMP_RESULT, "FAIL");
		}
		data.put(PmpPayConst.PMP_ERR_CODE, rnt.get("gateReturnCode"));
		data.put(PmpPayConst.PMP_ERR_MSG, rnt.get("gateReturnMessage"));
		rnt.remove("gateReturnCode");
		rnt.remove("gateReturnMessage");
		return data;
	}

	@Override
	public void setTradeVal(TradeDO t, Map<String, String> m, FDouble fee, OrdRstDTO rnt) {

	}

	@Override
	public Map<String, String> QueryRntConvert(Map<String, String> rnt) {
		// TODO Auto-generated method stub
		return RntConvert(rnt);
	}

	@Override
	public Map<String, String> RefundRntConvert(Map<String, String> rnt) {
		// TODO Auto-generated method stub
		return RntConvert(rnt);
	}

	private Map<String, String> RntConvert(Map<String, String> rnt) {

		Map<String, String> data = getRntHead(rnt);
		if (PmpPayConst.PMP_SUCCESS.equals(data.get(PmpPayConst.PMP_RESULT))) {
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

	@Override
	public Map<String, String> RefundQueryRntConvert(Map<String, String> rnt) {
		// TODO Auto-generated method stub
		return RntConvert(rnt);
	}
	
	@Override
	public ChlBillItemDO str2BillItem(String str,String sd_chl,FDate dt,Map<String,Object> map) {
		// TODO Auto-generated method stub
		String[] ds=str.split("\\|");
		ChlBillItemDO dto=new ChlBillItemDO();
//		dto.setPlatformid(ds[0]);
		dto.setAppid(ds[1]);
		dto.setMch_trade_no(ds[5]);			
		dto.setBanktradeno(ds[8]);
		dto.setChanneltradeno(ds[7]);
		dto.setChalel_name("民生银行");
		dto.setStatus(DOStatus.NEW);
		dto.setId_channel_bill(null);
		dto.setId_chl(PmpPayConst.getUdiID(sd_chl, PmpPayConst.CHANNEL_DOCLIST_ID));
		dto.setSd_chl(sd_chl);
		FDateTime f=new FDateTime(dt.toDate());
		dto.setTradetime(f);
		String amount=ds[14];
		if(amount.trim().startsWith("-")) {
			Double d=Double.parseDouble(amount);
			dto.setRefund_fee((new FDouble(d)).multiply(-1));
			dto.setTrade_status("REFUND");
		}else {
			Double d=Double.parseDouble(amount);
			dto.setTotal_fee(new FDouble(d));
			dto.setTrade_status("SUCCESS");
		}
		dto.setBill_type(map.get("fileType")+"");
		return dto;
	}
/**
 * 
 * 微信加支付宝数据对账
 */
	@Override
	public List<Map<String, Object>> getBillItemParam(FDate dt) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list=new ArrayList<>();
		Map<String,Object>data=new HashMap<String,Object>();	 
		 String transdate=pmputils.getTransDate(dt, "yyyyMMdd");	  
		 data.put("slcTransDate", transdate);
		 data.put("segmentIndex", 0+"");
		 data.put("fileType", CmbcBillTypeEnum.WX);
		 data.put("segmentSize", "4");
		 data.put("reserve", "没有备注信息");
		 list.add(data);
		 
		 data=new HashMap<String,Object>();
		 data.put("slcTransDate", transdate);
		 data.put("segmentIndex", 0+"");
		 data.put("fileType", CmbcBillTypeEnum.ZFB);
		 data.put("segmentSize", "4");
		 data.put("reserve", "没有备注信息");
		 list.add(data);
		return list;
	}

@Override
public String getChlCode() {
	// TODO Auto-generated method stub
	return PmpPayConst.CMBC_CHANNEL_CODE;
}

@Override
public Map<String, Object> getQRCODEParam(OrdReqDTO dto, OrdDO ord, TradeDO tra) throws BizException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Map<String, String> QrcodeRntConvert(Map<String, String> rnt) throws BizException {
	// TODO Auto-generated method stub
	return null;
}

}
