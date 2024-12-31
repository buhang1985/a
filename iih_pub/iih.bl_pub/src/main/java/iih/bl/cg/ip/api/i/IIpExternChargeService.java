package iih.bl.cg.ip.api.i;

import iih.mp.nr.api.bill.d.Billsupply;
import xap.mw.core.data.BizException;

/**
 * 住院对外补费接口，各种类型的汇总
 * @author yangyang
 * @Date 2017-12-22
 */
public interface IIpExternChargeService {

	/** 住院lis合管，采样器补费接口
	 * @param supplyBillArr
	 * @throws BizException
	 */
	public void setBillForSampler(Billsupply[] supplyBillArr) throws BizException;
}
