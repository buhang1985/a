package iih.bl.cc.s.bp;

import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.i.IBlpaypatCudService;
import iih.bl.pay.blpaypat.i.IBlpaypatRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 取消结账--预交金表
 * @author LIM
 * @since 2017-06-26
 */
public class UpdatePrePayPatForCancelBP {
	/**
	 * 修改预交金表(BL_PREPAY_PAT)中结账标志为未结账
	 * @param sqlStr
	 * @throws BizException
	 */
	public void exec(String sqlStr)throws BizException{
		IBlpaypatRService payRService = ServiceFinder.find(IBlpaypatRService.class);
		
		BlPrePayPatDO[] blPrePayPatDOArr = payRService.find(sqlStr, null, FBoolean.FALSE);
		if(blPrePayPatDOArr != null && blPrePayPatDOArr.length > 0){
			for(BlPrePayPatDO blPrePayPatDO : blPrePayPatDOArr){
				blPrePayPatDO.setId_cc(null);
				blPrePayPatDO.setFg_cc(FBoolean.FALSE);
				blPrePayPatDO.setStatus(DOStatus.UPDATED);
			}
			IBlpaypatCudService payCService = ServiceFinder.find(IBlpaypatCudService.class);
			payCService.save(blPrePayPatDOArr);
		}	
	}
}
