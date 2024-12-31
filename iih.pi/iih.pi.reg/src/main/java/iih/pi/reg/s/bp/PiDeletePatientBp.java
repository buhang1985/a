package iih.pi.reg.s.bp;

import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.s.PatiMDOCrudServiceImpl;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;

/**
 * 删除患者逻辑类
 * @author ly 2017/1/13
 *
 */
public class PiDeletePatientBp {

	/**
	 * 删除患者
	 * 暂时只更新作废标志
	 * @param patID 患者id
	 * @throws BizException
	 */
	public void exec(String patID) throws BizException{
	
		PatiMDOCrudServiceImpl mService = new PatiMDOCrudServiceImpl();
		PatDO patDo = mService.findById(patID);
		
		if(patDo == null)
			return;
		
		patDo.setFg_invd(FBoolean.TRUE);
		patDo.setStatus(DOStatus.UPDATED);
		
		mService.update(patDo);
	}
}
