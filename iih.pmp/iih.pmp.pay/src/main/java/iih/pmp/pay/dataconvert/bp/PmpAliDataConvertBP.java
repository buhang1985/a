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
import iih.pmp.pay.udi.PmpPayConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

public class PmpAliDataConvertBP  implements IPmpDataconvert{

	@Override
	public Map<String, Object> getBarcodeParam(OrdReqDTO dto, OrdDO ord, TradeDO tra) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("out_trade_no", tra.getTrade_no());
		data.put("subject", dto.getSubject());
		data.put("body", dto.getSubject());
		data.put("total_fee", dto.getAmount().toString());
		data.put("auth_code", dto.getAuth_code());	
		return data;
	}

	@Override
	public Map<String, Object> getQueryParam(OrdDO ord, TradeDO tra) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("out_trade_no", tra.getTrade_no());
		return data;
	}

	@Override
	public Map<String, Object> getRefundQueryParam(OrdDO ord, TradeDO tra, TradeDO paidtra) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("out_trade_no", tra.getTrade_no_rel());
		data.put("out_request_no", tra.getTrade_no());
		return data;
	}

	@Override
	public Map<String, Object> getReFundParam(OrdDO ord, TradeDO tra, OrdReqDTO dto, TradeDO paidtra) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("out_trade_no", tra.getTrade_no_rel());
		data.put("refund_amount", dto.getAmount().toString());
		data.put("refund_reason", dto.getSubject());
		data.put("out_request_no", tra.getTrade_no());
		return data;
	}

	@Override
	public Map<String, String> BarcodeRntConvert(Map<String, String> rnt) throws BizException {
		return rnt;
	}

	@Override
	public Map<String, String> QueryRntConvert(Map<String, String> rnt) throws BizException {
		return rnt;
	}

	@Override
	public Map<String, String> RefundQueryRntConvert(Map<String, String> rnt) throws BizException {
		return rnt;
	}

	@Override
	public Map<String, String> RefundRntConvert(Map<String, String> rnt) throws BizException {
		return rnt;
	}

	@Override
	public void setTradeVal(TradeDO t, Map<String, String> m, FDouble fee, OrdRstDTO rnt) throws BizException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ChlBillItemDO str2BillItem(String str, String sd_chl, FDate dt, Map<String, Object> map)
			throws BizException {
		String[] mrnt = str.split(",");
		ChlBillItemDO b = new ChlBillItemDO();
		b.setTradetime(new FDateTime(mrnt[5].trim()));
		b.setChanneltradeno(mrnt[0].trim());
		b.setTrade_status("交易".equals(mrnt[2].trim()) ? "SUCCESS" : "REFUND");
		b.setMch_trade_no(mrnt[1].trim());
		b.setUser_identify(mrnt[10].trim());
		if ("SUCCESS".equals(b.getTrade_status())) {
			b.setTotal_fee(new FDouble(Double.parseDouble(mrnt[11].trim())));
			b.setRefund_fee(new FDouble(0));
			b.setBanktradeno(mrnt[1].trim());
		}
		else {
			b.setTotal_fee(new FDouble(0));
			b.setRefund_fee(new FDouble(-1 * Double.parseDouble(mrnt[11].trim())));
			b.setBanktradeno(mrnt[21].trim());
		}
		b.setMch_refund_no(mrnt[21].trim());
		b.setProduct_name(mrnt[3].trim());
		b.setId_chl(PmpPayConst.getUdiID(sd_chl, PmpPayConst.CHANNEL_DOCLIST_ID));
		b.setSd_chl(sd_chl);
		b.setBill_type(CmbcBillTypeEnum.ZFB);
		b.setStatus(DOStatus.NEW);
		return b;
	}

	@Override
	public List<Map<String, Object>> getBillItemParam(FDate dt) throws BizException {
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String,Object> data = new HashMap<String,Object>();	 		 
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd"); 
		String d = format1.format(dt.toDate());
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
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("out_trade_no", tra.getTrade_no());
		data.put("subject", dto.getSubject());
		data.put("body", dto.getSubject());
		data.put("total_fee", dto.getAmount().toString());
		return data;
	}

	@Override
	public Map<String, String> QrcodeRntConvert(Map<String, String> rnt) throws BizException {
		return rnt;
	}

}
