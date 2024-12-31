package iih.bl.cc.s.bp;

import iih.bl.pay.blpayspcl.d.BlPaySpclDO;
import iih.bl.pay.blpayspcl.i.IBlpayspclMDOCudService;
import iih.bl.pay.blpayspcl.i.IBlpayspclMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 专用款表取消结账
 * @author LIM
 *@since 2019-05-23
 */
public class UpdatePaySpclForCancelBP {
	/**
	 * 修改门诊结算表(bl_pay_spcl)中结账标志为未结账
	 * @throws BizException
	 */
	public void exec(String sqlStr) throws BizException{
		IBlpayspclMDORService payspclMDOService = ServiceFinder.find(IBlpayspclMDORService.class);		
		BlPaySpclDO[] blPaySpclDOArr = payspclMDOService.find(sqlStr.toString(), null, FBoolean.FALSE);
		if(!ArrayUtil.isEmpty(blPaySpclDOArr)){
			for(BlPaySpclDO blPaySpclDO : blPaySpclDOArr){
				blPaySpclDO.setId_cc(null);
				blPaySpclDO.setFg_cc(FBoolean.FALSE);
				blPaySpclDO.setStatus(DOStatus.UPDATED);
			}
			IBlpayspclMDOCudService payspclService = ServiceFinder.find(IBlpayspclMDOCudService.class);
			payspclService.save(blPaySpclDOArr);
		}
	}
}
