package iih.en.pv.s.bp.mt;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.ci.ord.cior.d.OrdApTransDO;
import iih.ci.ord.cior.i.ICiorapptransdeptCudService;
import iih.ci.ord.cior.i.ICiorapptransdeptRService;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.MedTechTransDTO;
import iih.en.pv.enres.d.EnDepDO;
import iih.en.pv.enres.i.IEndepCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医技转入
 * @author Administrator
 *
 */
public class MtTransInBP {
	/**
	 * 医技转入
	 * @param dto 医技转入DTO
	 * @throws BizException
	 */
	public void exec(MedTechTransDTO dto) throws BizException{
		ICiorapptransdeptRService transRService = ServiceFinder.find(ICiorapptransdeptRService.class);
		OrdApTransDO ordApTrans = transRService.findById(dto.getId_ortrans());
		if(ordApTrans!=null) {
			ordApTrans.setStatus(DOStatus.UPDATED);
			ordApTrans.setSd_su_trans(ICiDictCodeConst.SD_SU_TRANS_RECEIVED);
			ICiorapptransdeptCudService transCudService = ServiceFinder.find(ICiorapptransdeptCudService.class);
			OrdApTransDO[] ordApTransDOs = transCudService.update(new OrdApTransDO[]{ordApTrans});
			FDateTime curTime = EnAppUtils.getServerDateTime();
			if(!EnValidator.isEmpty(ordApTransDOs)) {
				EnDepDO enDepDO = new EnDepDO();
				enDepDO.setStatus(DOStatus.NEW);
				enDepDO.setId_ent(dto.getId_ent());
				enDepDO.setId_dep(dto.getId_dep_to());
				enDepDO.setSd_entdeprole(IEnDictCodeConst.SD_ENTDEPROLE_MT);
				enDepDO.setId_dep_from(dto.getId_dep_phy());
				enDepDO.setId_dep_to(null);
				enDepDO.setDt_b(curTime);
				enDepDO.setDt_e(null);
				enDepDO.setFg_admit(FBoolean.FALSE);
				enDepDO.setSd_status(IEnDictCodeConst.SD_ENTDEP_STATUS_SUC);
				enDepDO.setDt_dcg_bill(null);
				IEndepCudService depCudService = ServiceFinder.find(IEndepCudService.class);
				depCudService.save(new EnDepDO[]{enDepDO});
			}
		}
	}
	
}
