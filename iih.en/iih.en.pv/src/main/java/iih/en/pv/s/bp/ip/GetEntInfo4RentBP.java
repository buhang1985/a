package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EntInfo4RentDTO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取包床的就诊信息
 * 
 * @author renying
 *
 */
public class GetEntInfo4RentBP {
	/**
	 * 获取包床的就诊信息
	 * 
	 * @param entId 就诊ID
	 * @return 包床信息DTO
	 * @throws BizException
	 */
	public EntInfo4RentDTO exec(String entId) throws BizException {
		EntInfo4RentDTO ent4rent = new EntInfo4RentDTO();
		IPativisitRService rservice = ServiceFinder.find(IPativisitRService.class);
		IInpatientRService irservice = ServiceFinder.find(IInpatientRService.class);
		PatiVisitDO pativisitDO = rservice.findById(entId);
		InpatientDO[] inpatientDOs = irservice.find("id_ent='" + entId + "' and sd_status ='"
				+IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN+"'", "", FBoolean.FALSE);
		if (pativisitDO == null || EnValidator.isEmpty(inpatientDOs)) {
			return null;
		}
		ent4rent.setName_pat(pativisitDO.getName_pat());
		ent4rent.setName_sex(pativisitDO.getName_sex());
		ent4rent.setName_marry(pativisitDO.getName_mari());
		ent4rent.setD_birth(pativisitDO.getDt_birth_pat());
		ent4rent.setName_bed(inpatientDOs[0].getName_bed());
		ent4rent.setId_bed(inpatientDOs[0].getId_bed());
		return ent4rent;
	}
}
