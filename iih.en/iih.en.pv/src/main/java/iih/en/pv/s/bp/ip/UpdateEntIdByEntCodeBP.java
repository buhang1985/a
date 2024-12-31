package iih.en.pv.s.bp.ip;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.enhpreferral.d.EnHpReferralDO;
import iih.en.pv.enhpreferral.i.IEnhpreferralCudService;
import iih.en.pv.enhpreferral.i.IEnhpreferralRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/***
 * 根据就诊编码回写转诊单就诊id
 * @author fanlq
 *
 */
public class UpdateEntIdByEntCodeBP {
	/***
	 * 根据就诊编码回写转诊单就诊id
	 * @param codeEnt 就诊编码
	 * @throws BizException 
	 */
	public void exec(String codeEnt) throws BizException{
		if(EnValidator.isEmpty(codeEnt)){
			return;
		}
		PatiVisitDO patiVisitDO = this.getEntIdBySql(codeEnt);
		if(patiVisitDO == null){
			return;
		}
		this.updateEntId(patiVisitDO, codeEnt);
	}
	
	/***
	 * 从就诊表中获取到就诊id
	 * @param codeEnt
	 * @return
	 * @throws BizException
	 */
	private PatiVisitDO getEntIdBySql(String codeEnt) throws BizException{
		IPativisitRService service = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO[] patiVisitDOs = service.find("code = '"+codeEnt+"'", null, FBoolean.FALSE);
		if(patiVisitDOs != null && patiVisitDOs.length == 1){
			return patiVisitDOs[0];
		}
		return null;
	}
	
	/***
	 * 更新医保转诊单表中的就诊id
	 * @param id_ent
	 * @param codeEnt
	 * @throws BizException
	 */
	private void updateEntId(PatiVisitDO patiVisitDO,String codeEnt) throws BizException{
		IEnhpreferralRService rService = ServiceFinder.find(IEnhpreferralRService.class);
		EnHpReferralDO[] enHpReferralDOs = rService.find("ent_code = '"+codeEnt+"'", null, FBoolean.FALSE);
		if(enHpReferralDOs != null && enHpReferralDOs.length == 1){
			IEnhpreferralCudService cudService = ServiceFinder.find(IEnhpreferralCudService.class);
			enHpReferralDOs[0].setId_ent(patiVisitDO.getId_ent());
			enHpReferralDOs[0].setId_pat(patiVisitDO.getId_pat());
			enHpReferralDOs[0].setStatus(DOStatus.UPDATED);
			cudService.save(enHpReferralDOs);
		}
			return;
	}
}
