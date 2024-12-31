package iih.pmp.yxpaySDK.aggpay;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iih.pmp.pay.channelbillitem.d.ChlBillItemDO;
import iih.pmp.pay.custom.i.IPmpDataconvert;

import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordqryrstdto.d.CmbcBillTypeEnum;
import iih.pmp.pay.ordreqdto.d.CmbcSceneEnum;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayBaseCost;
import iih.pmp.yxpaySDK.wx.YxWxDataConvert;
import iih.pmp.yxpaySDK.zfb.YxZfbDataConvert;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDouble;

public class YxAggPayDataConvert   implements IPmpDataconvert{
	YxZfbDataConvert aliconvert=new YxZfbDataConvert();
	YxWxDataConvert wxconvert=new YxWxDataConvert();

	@Override
	public Map<String, Object> getBarcodeParam(OrdReqDTO dto, OrdDO ord, TradeDO tra) throws BizException {
		// TODO Auto-generated method stub
		Map<String, Object> data=null;
		if(tra.getTradetype()==null)throw new BizException("没有交易类型！条码号："+dto.getAuth_code());
		if(CmbcSceneEnum.WXSCAN.equals(tra.getTradetype())) {
			data=wxconvert.getBarcodeParam(dto, ord, tra);
			data.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.WX);
		}else if(CmbcSceneEnum.ZFBSCAN.equals(tra.getTradetype())) {
			data=aliconvert.getBarcodeParam(dto, ord, tra);
			data.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.ZFB);
		}
		return data;
	}
	@Override
	public Map<String, Object> getQRCODEParam(OrdReqDTO dto, OrdDO ord, TradeDO tra) throws BizException {
		// TODO Auto-generated method stub
		Map<String, Object> data=null;
		if(tra.getTradetype()==null)throw new BizException("没有交易类型！");
		if(CmbcSceneEnum.WXQRCODE.equals(tra.getTradetype())) {
			data=wxconvert.getQRCODEParam(dto, ord, tra);
			data.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.WX);
		}else if(CmbcSceneEnum.ZFBQRCODE.equals(tra.getTradetype())) {
			data=aliconvert.getQRCODEParam(dto, ord, tra);
			data.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.ZFB);
		}
		return data;
	}

	@Override
	public Map<String, Object> getQueryParam(OrdDO ord, TradeDO tra)  throws BizException{
		// TODO Auto-generated method stub
		Map<String, Object> data=null;
		if(CmbcSceneEnum.ZFBSCAN.equals(tra.getTradetype())||CmbcSceneEnum.ZFBQRCODE.equals(tra.getTradetype())) {
			data=aliconvert.getQueryParam( ord, tra);
			data.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.ZFB);
		}else {
			data=wxconvert.getQueryParam(ord, tra);
			data.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.WX);
		}
		return data;
	}

	@Override
	public Map<String, Object> getRefundQueryParam(OrdDO ord, TradeDO tra, TradeDO paidtra) throws BizException {
		// TODO Auto-generated method stub
		Map<String, Object> data=null;
        if(CmbcSceneEnum.ZFBSCAN.equals(tra.getTradetype())||CmbcSceneEnum.ZFBQRCODE.equals(tra.getTradetype())) {
			data=aliconvert.getRefundQueryParam( ord, tra,paidtra);
			data.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.ZFB);
		}else {
			data=wxconvert.getRefundQueryParam(ord, tra,paidtra);
			data.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.WX);
		}
		return data;
	}

	@Override
	public Map<String, Object> getReFundParam(OrdDO ord, TradeDO tra, OrdReqDTO dto, TradeDO paidtra) throws BizException {
		// TODO Auto-generated method stub
		Map<String, Object> data=null;
		if(paidtra.getTradetype()==null)throw new BizException("没有交易类型！条码号："+dto.getAuth_code());
		if(CmbcSceneEnum.WXSCAN.equals(paidtra.getTradetype())||CmbcSceneEnum.WXQRCODE.equals(tra.getTradetype())) {
			data=wxconvert.getReFundParam(ord, tra,dto,paidtra);
			data.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.WX);
		}else if(CmbcSceneEnum.ZFBSCAN.equals(paidtra.getTradetype())||CmbcSceneEnum.ZFBQRCODE.equals(tra.getTradetype())) {
			data=aliconvert.getReFundParam( ord, tra,dto,paidtra);
			data.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.ZFB);
		}
		return data;
	}

	@Override
	public Map<String, String> BarcodeRntConvert(Map<String, String> rnt) throws BizException {
		// TODO Auto-generated method stub
		if(rnt.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.WX)) {
			rnt.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			return wxconvert.BarcodeRntConvert(rnt);
		}else if(rnt.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.ZFB)){
			rnt.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			return aliconvert.BarcodeRntConvert(rnt);
		}
		return null;
	}
	@Override
	public Map<String, String> QrcodeRntConvert(Map<String, String> rnt) throws BizException {
		// TODO Auto-generated method stub
		if(rnt.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.WX)) {
			rnt.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			return wxconvert.QrcodeRntConvert(rnt);
		}else if(rnt.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.ZFB)){
			rnt.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			return aliconvert.QrcodeRntConvert(rnt);
		}
		return null;
	}

	@Override
	public Map<String, String> QueryRntConvert(Map<String, String> rnt) throws BizException {
		// TODO Auto-generated method stub
		if(rnt.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.WX)) {
			rnt.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			return wxconvert.QueryRntConvert(rnt);
		}else if(rnt.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.ZFB)){
			rnt.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			return aliconvert.QueryRntConvert(rnt);
		}
		return null;
	}

	@Override
	public Map<String, String> RefundQueryRntConvert(Map<String, String> rnt) throws BizException {
		// TODO Auto-generated method stub
		if(rnt.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.WX)) {
			rnt.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			return wxconvert.RefundQueryRntConvert(rnt);
		}else if(rnt.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.ZFB)){
			rnt.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			return aliconvert.RefundQueryRntConvert(rnt);
		}
		return null;
	}

	@Override
	public Map<String, String> RefundRntConvert(Map<String, String> rnt) throws BizException {
		// TODO Auto-generated method stub
		if(rnt.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.WX)) {
			rnt.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			return wxconvert.RefundRntConvert(rnt);
		}else if(rnt.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.ZFB)){
			rnt.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			return aliconvert.RefundRntConvert(rnt);
		}
		return null;
	}

	@Override
	public void setTradeVal(TradeDO t, Map<String, String> m, FDouble fee, OrdRstDTO rnt) throws BizException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ChlBillItemDO str2BillItem(String str, String sd_chl, FDate dt, Map<String, Object> map)
			throws BizException {
		// TODO Auto-generated method stub
		if(map.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.WX)) {
			return wxconvert.str2BillItem( str,  sd_chl,  dt,  map);
		}else if(map.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.ZFB)){
			return aliconvert.str2BillItem( str,  sd_chl,  dt,  map);
		}
		return null;
	}

	@Override
	public List<Map<String, Object>> getBillItemParam(FDate dt) throws BizException {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list=new ArrayList<>();
		List<Map<String, Object>> m1=this.aliconvert.getBillItemParam(dt);

		List<Map<String, Object>> m2=this.wxconvert.getBillItemParam(dt);
		
		if(m1!=null) {
			for(int i=0;i<m1.size();i++) {
				Map<String, Object> o=m1.get(i);
				o.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.ZFB);
			}
			list.addAll(m1);
		}
		if(m2!=null) {
			for(int i=0;i<m2.size();i++) {
				Map<String, Object> o=m2.get(i);
				o.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.WX);
			}
			list.addAll(m2);
		}
		return list;
	}

	@Override
	public String getChlCode() {
		// TODO Auto-generated method stub
		return "pay.yx.aggpay.0009";
	}



}
