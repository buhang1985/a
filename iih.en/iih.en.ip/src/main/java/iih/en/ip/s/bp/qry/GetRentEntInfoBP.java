package iih.en.ip.s.bp.qry;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.util.EnAgeCalcUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.ip.dto.d.RentInfoDTO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取包床患者信息
 * 
 * @author zhangpp
 *
 */
public class GetRentEntInfoBP {

	/**
	 * 获取包床的就诊信息
	 * 
	 * @param entId 就诊ID
	 * @return 包床信息DTO
	 * @throws BizException
	 */
	public RentInfoDTO exec(String entId) throws BizException {
		RentInfoDTO entInfo = new RentInfoDTO();
		IPativisitRService rservice = ServiceFinder.find(IPativisitRService.class);
		IInpatientRService irservice = ServiceFinder.find(IInpatientRService.class);
		PatiVisitDO pativisitDO = rservice.findById(entId);
		InpatientDO[] inpatientDOs = irservice.find("id_ent='" + entId + "' and sd_status ='"
				+IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN+"'", "", FBoolean.FALSE);
		if (pativisitDO == null || EnValidator.isEmpty(inpatientDOs)) {
			return null;
		}
		entInfo.setId_ent(pativisitDO.getId_ent());
		entInfo.setName_pat(pativisitDO.getName_pat());
		entInfo.setId_sex(pativisitDO.getId_sex_pat());
		entInfo.setName_sex(pativisitDO.getName_sex());
		entInfo.setName_marry(pativisitDO.getName_mari());
		entInfo.setId_bed(inpatientDOs[0].getId_bed());
		entInfo.setName_bed(inpatientDOs[0].getName_bed());
		//获取年龄
		EnAgeCalcUtil.setDoAges(new RentInfoDTO[]{entInfo}, "Id_ent", "Age");
		
		return entInfo;
	}
}
