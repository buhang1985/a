package iih.en.pv.s.bp.mt;

import iih.en.comm.util.EnAppUtils;
import iih.en.pv.dto.d.MedTechTransDTO;
import iih.en.pv.enres.d.EnDepDO;
import iih.en.pv.enres.s.EndepCrudServiceImpl;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDateTime;

/**
 * 医技转出
 * @author Administrator
 *
 */
public class MtTransOutBP {
	/**
	 * 医技转出
	 * @param dto 医技转入DTO
	 * @throws BizException
	 */
	public void exec(MedTechTransDTO dto) throws BizException{
		EndepCrudServiceImpl service = new EndepCrudServiceImpl();
		EnDepDO enDepDO = service.findById(dto.getId_entdep());		
		if(enDepDO!=null) {
			enDepDO.setStatus(DOStatus.UPDATED);
			FDateTime curTime = EnAppUtils.getServerDateTime();
			enDepDO.setDt_e(curTime);
			service.update(new EnDepDO[]{enDepDO});
		}
	}
}
