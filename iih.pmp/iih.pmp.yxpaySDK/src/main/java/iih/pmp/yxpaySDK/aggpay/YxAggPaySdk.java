package iih.pmp.yxpaySDK.aggpay;

import java.util.Map;

import iih.pmp.pay.custom.i.IPmpSdk;
import iih.pmp.pay.ordqryrstdto.d.CmbcBillTypeEnum;
import iih.pmp.pay.util.PmpPayBaseCost;
import iih.pmp.yxpaySDK.wx.YxWxPaySDK;
import iih.pmp.yxpaySDK.zfb.YxZfbPaySDK;
import xap.mw.core.data.BizException;

public class YxAggPaySdk    implements IPmpSdk{
	YxZfbPaySDK alisdk;
	YxWxPaySDK wxsdk;
	public YxAggPaySdk() throws BizException {
		 alisdk=new YxZfbPaySDK();
		 wxsdk=new YxWxPaySDK();
	}

	@Override
	public Map<String, String> doScanPay(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		
		if(map.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.WX)) {
			map.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			 Map<String, String> rst=wxsdk.doScanPay(map);
			 if(rst!=null)rst.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.WX);
			return rst;
		}else if(map.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.ZFB)){
			map.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			Map<String, String> rst=alisdk.doScanPay(map);
			 if(rst!=null)rst.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.ZFB);
			return rst;
		}
		return null;
	}
	
	@Override
	public Map<String, String> doQRCODEPay(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		if(map.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.WX)) {
			map.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			 Map<String, String> rst=wxsdk.doQRCODEPay(map);
			 if(rst!=null)rst.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.WX);
			return rst;
		}else if(map.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.ZFB)){
			map.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			Map<String, String> rst=alisdk.doQRCODEPay(map);
			 if(rst!=null)rst.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.ZFB);
			return rst;
		}
		return null;
	}

	@Override
	public Map<String, String> doQuery(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		if(map.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.WX)) {
			map.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			 Map<String, String> rst=wxsdk.doQuery(map);
			 if(rst!=null)rst.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.WX);
			return rst;
		}else if(map.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.ZFB)){
			map.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			Map<String, String> rst=alisdk.doQuery(map);
			 if(rst!=null)rst.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.ZFB);
			return rst;
		}
		return null;
	}

	@Override
	public Map<String, String> reverse(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> refund(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		if(map.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.WX)) {
			map.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			 Map<String, String> rst=wxsdk.refund(map);
			 if(rst!=null)rst.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.WX);
			return rst;
		}else if(map.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.ZFB)){
			map.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			Map<String, String> rst=alisdk.refund(map);
			 if(rst!=null)rst.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.ZFB);
			return rst;
		}
		return null;
	}

	@Override
	public Map<String, String> dorefundquery(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
        if(map.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.WX)) {
			map.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			 Map<String, String> rst=wxsdk.dorefundquery(map);
			 if(rst!=null)rst.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.WX);
			return rst;
		}else if(map.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.ZFB)){
			map.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			Map<String, String> rst=alisdk.dorefundquery(map);
			if(rst!=null)rst.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.ZFB);
			return rst;
		}
		return null;
	}

	@Override
	public Map<String, String> GetCheckLedgerInfo(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> downloadfile(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		if(map.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.WX)) {
			map.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			 Map<String, String> rst=wxsdk.downloadfile(map);
			 if(rst!=null)rst.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.WX);
			return rst;
		}else if(map.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.ZFB)){
			map.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			Map<String, String> rst=alisdk.downloadfile(map);
			if(rst!=null)rst.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.ZFB);
			return rst;
		}
		return null;
	}

	@Override
	public String[] getBillContent(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		if(map.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.WX)) {
			map.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			 String[] rst=wxsdk.getBillContent(map);
			 if(rst!=null)map.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.WX);
			return rst;
		}else if(map.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.ZFB)){
			map.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			String[] rst=alisdk.getBillContent(map);
			if(rst!=null)map.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.ZFB);
			return rst;
		}
		return null;
	}

	@Override
	public String getChlCode() {
		// TODO Auto-generated method stub
		return "pay.yx.aggpay.0009";
	}


}
