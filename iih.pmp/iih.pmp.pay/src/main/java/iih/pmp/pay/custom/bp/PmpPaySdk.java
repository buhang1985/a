package iih.pmp.pay.custom.bp;

import java.util.Map;

import iih.pmp.pay.custom.i.IPmpSdk;
import iih.pmp.pay.ordqryrstdto.d.CmbcBillTypeEnum;
import iih.pmp.pay.s.bp.AlipaySdk;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayBaseCost;
import wxpay.sdk.WXPmpPaySdk;
import xap.mw.core.data.BizException;

public class PmpPaySdk implements IPmpSdk {

	AlipaySdk alisdk;
	WXPmpPaySdk wxsdk;

	public PmpPaySdk() throws BizException {
	}

	@Override
	public Map<String, String> doScanPay(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub

		if (map.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.WX)) {
			map.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			Map<String, String> rst = this.getWXPmpPaySdk().doScanPay(map);
			if (rst != null)
				rst.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.WX);
			return rst;
		} else if (map.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.ZFB)) {
			map.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			Map<String, String> rst = this.getAlipaySdk().doScanPay(map);
			if (rst != null)
				rst.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.ZFB);
			return rst;
		}
		return null;
	}

	@Override
	public Map<String, String> doQRCODEPay(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		if (map.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.WX)) {
			map.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			Map<String, String> rst = this.getWXPmpPaySdk().doQRCODEPay(map);
			if (rst != null)
				rst.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.WX);
			return rst;
		} else if (map.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.ZFB)) {
			map.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			Map<String, String> rst = this.getAlipaySdk().doQRCODEPay(map);
			if (rst != null)
				rst.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.ZFB);
			return rst;
		}
		return null;
	}

	@Override
	public Map<String, String> doQuery(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		if (map.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.WX)) {
			map.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			Map<String, String> rst = this.getWXPmpPaySdk().doQuery(map);
			if (rst != null)
				rst.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.WX);
			return rst;
		} else if (map.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.ZFB)) {
			map.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			Map<String, String> rst = this.getAlipaySdk().doQuery(map);
			if (rst != null)
				rst.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.ZFB);
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
		if (map.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.WX)) {
			map.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			Map<String, String> rst = this.getWXPmpPaySdk().refund(map);
			if (rst != null)
				rst.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.WX);
			return rst;
		} else if (map.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.ZFB)) {
			map.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			Map<String, String> rst = this.getAlipaySdk().refund(map);
			if (rst != null)
				rst.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.ZFB);
			return rst;
		}
		return null;
	}

	@Override
	public Map<String, String> dorefundquery(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		if (map.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.WX)) {
			map.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			Map<String, String> rst = this.getWXPmpPaySdk().dorefundquery(map);
			if (rst != null)
				rst.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.WX);
			return rst;
		} else if (map.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.ZFB)) {
			map.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			Map<String, String> rst = this.getAlipaySdk().dorefundquery(map);
			if (rst != null)
				rst.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.ZFB);
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
		if (map.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.WX)) {
			map.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			Map<String, String> rst = this.getWXPmpPaySdk().downloadfile(map);
			if (rst != null)
				rst.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.WX);
			return rst;
		} else if (map.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.ZFB)) {
			map.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			Map<String, String> rst = this.getAlipaySdk().downloadfile(map);
			if (rst != null)
				rst.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.ZFB);
			return rst;
		}
		return null;
	}

	@Override
	public String[] getBillContent(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		if (map.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.WX)) {
			map.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			String[] rst = this.getWXPmpPaySdk().getBillContent(map);
			if (rst != null)
				map.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.WX);
			return rst;
		} else if (map.get(PmpPayBaseCost.PAY_BILL_TYPE).equals(CmbcBillTypeEnum.ZFB)) {
			map.remove(PmpPayBaseCost.PAY_BILL_TYPE);
			String[] rst = this.getAlipaySdk().getBillContent(map);
			if (rst != null)
				map.put(PmpPayBaseCost.PAY_BILL_TYPE, CmbcBillTypeEnum.ZFB);
			return rst;
		}
		return null;
	}

	@Override
	public String getChlCode() {
		// TODO Auto-generated method stub
		return PmpPayConst.PAY_PMP_CHANNEL_CODE;
	}

	private AlipaySdk getAlipaySdk() throws BizException {
		if (this.alisdk == null) {
			this.alisdk = new AlipaySdk();
		}
		return this.alisdk;
	}

	private WXPmpPaySdk getWXPmpPaySdk() {
		if (this.wxsdk == null) {
			this.wxsdk = new WXPmpPaySdk();
		}
		return this.wxsdk;
	}

}
