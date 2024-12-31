package iih.en.pv.s.bp.ip;

import iih.en.pv.enfee.d.EnAccountDO;
import iih.en.pv.enfee.i.IEnaccountMDOCudService;
import iih.en.pv.enfee.i.IEnaccountMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 修改就诊账户的最后记账时间BP
 * @author yank
 *
 */
public class UpdateEnAccDtEndBP {
	/**
	 * 修改患者就诊账户的最后记账时间
	 * @param Id_entacc 患者就诊账户ID
	 * @param dt_e 记账结束时间
	 * @throws BizException 
	 * */
	public void exec(String enAccId,FDateTime endTime) throws BizException{
		IEnaccountMDORService accRService = ServiceFinder.find(IEnaccountMDORService.class);		
		EnAccountDO enAccountDO = accRService.findById(enAccId);
		if(enAccountDO == null){
			throw new BizException("患者就诊账户"+enAccId+"不存在!");
		}
		enAccountDO.setDt_backcg(endTime);
		enAccountDO.setStatus(DOStatus.UPDATED);
		IEnaccountMDOCudService accCudService = ServiceFinder.find(IEnaccountMDOCudService.class);
		accCudService.save(new EnAccountDO[]{enAccountDO});
	}
}
