package iih.en.pv.s.bp.ip.qry;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EnDepDTO;
import iih.en.pv.enres.d.EnMedGrpDO;
import iih.en.pv.enres.d.EnPsnDO;
import iih.en.pv.enres.i.IEnmedgrpRService;
import iih.en.pv.enres.i.IEnpsnRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 查找转科患者的相关信息显示在页面上
 * 
 * @author renying
 */
public class GetTransDocInfoBP {
	/**
	 * 查找转科患者的相关信息显示在页面上
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public EnDepDTO exec(String entId) throws BizException {
		// 1、校验参数
		if (EnValidator.isEmpty(entId))
			return null;
		EnDepDTO endepDTO = new EnDepDTO();
		// 2、设置就诊数据值
		this.setEntInfo4DTO(entId, endepDTO);
		// 3、设置医疗组信息
		this.setWgInfo4DTO(entId, endepDTO);
		// 4、查找人员信息
		EnPsnDO[] enpsndocArray = this.getEnPsnArray(entId);
		// 5、设置人员信息
		this.setPsnValue(enpsndocArray, endepDTO);
		return endepDTO;
	}

	/**
	 * 查找人员doArray
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private EnPsnDO[] getEnPsnArray(String entId) throws BizException {
		IEnpsnRService retrieveService = ServiceFinder.find(IEnpsnRService.class);
		String whereStr = String.format("id_ent= '%s'  and (Isnull(dt_e,'~')='~') ", entId);
		EnPsnDO[] oriDOs = retrieveService.find(whereStr, "", FBoolean.FALSE);
		if (EnValidator.isEmpty(oriDOs))
			return null;
		return oriDOs;
	}

	/**
	 * 根据角色对应do
	 * 
	 * @param enpsnDOs
	 * @param emproleSd
	 * @return
	 */
	private EnPsnDO getEnPsnDO(EnPsnDO[] enpsnDOs, String emproleSd) {
		if (EnValidator.isEmpty(enpsnDOs)) {
			return null;
		}
		EnPsnDO enpsndo = null;
		for (EnPsnDO enpsnDo : enpsnDOs) {
			if (enpsnDo.getSd_emprole().equals(emproleSd)) {
				enpsndo = enpsnDo;
			}
		}
		return enpsndo;
	}

	/**
	 * 设置医疗组的值
	 * 
	 * @param entId
	 * @param endepDTO
	 * @throws BizException
	 */
	private void setWgInfo4DTO(String entId, EnDepDTO endepDTO) throws BizException {
		IEnmedgrpRService enwgService = ServiceFinder.find(IEnmedgrpRService.class);
		EnMedGrpDO[] enMedGrpDOs = enwgService.find("a0.id_ent='" + entId
				+ "' and (Isnull(a0.dt_e,'~')='~') ", "", FBoolean.FALSE);

		if (EnValidator.isEmpty(enMedGrpDOs)) {
			return;
		}
		EnMedGrpDO enMedGrpDO = enMedGrpDOs[0];
		endepDTO.setId_wg_phy(enMedGrpDO.getId_wg());
		endepDTO.setWg_name(enMedGrpDO.getName_wg());
	}

	/**
	 * 查找entdo 并设置相关值
	 * 
	 * @param enHosRegDTO
	 * @return
	 * @throws BizException
	 */
	private void setEntInfo4DTO(String entId, EnDepDTO endepDTO) throws BizException {
		IPativisitRService ipRService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO patiVisitDO = new PatiVisitDO();
		patiVisitDO = ipRService.findById(entId);
		endepDTO.setId_ent(entId);
		endepDTO.setId_pat(patiVisitDO.getId_pat());
		if (patiVisitDO == null)
			return;
		endepDTO.setId_dep_phy(patiVisitDO.getId_dep_phy());
	}

	/**
	 * 设置人员信息值
	 * 
	 * @param enpsndocArray
	 * @param endepDTO
	 */
	private void setPsnValue(EnPsnDO[] enpsndocArray, EnDepDTO endepDTO) {
		EnPsnDO docPsn = this.getEnPsnDO(enpsndocArray, IEnDictCodeConst.SD_EMPROLE_DOCTOR);// 责任医师
		EnPsnDO zyPsn = this.getEnPsnDO(enpsndocArray, IEnDictCodeConst.SD_EMPROLE_ZYDOC);// 住院
		EnPsnDO zzPsn = this.getEnPsnDO(enpsndocArray, IEnDictCodeConst.SD_EMPROLE_ZZDOC);// 主治
		EnPsnDO zrPsn = this.getEnPsnDO(enpsndocArray, IEnDictCodeConst.SD_EMPROLE_ZRDOC);// 主任
		EnPsnDO nurPsn = this.getEnPsnDO(enpsndocArray, IEnDictCodeConst.SD_EMPROLE_NURSE);// 护士

		if (docPsn != null) {// 责任医师
			endepDTO.setId_emp_phy(docPsn.getId_emp());
			endepDTO.setPhy_name(docPsn.getName_psndoc());
		}

		if (zyPsn != null) {// 住院医师
			endepDTO.setId_zy_doc(zyPsn.getId_emp());
			endepDTO.setZy_name(zyPsn.getName_psndoc());
		}

		if (zzPsn != null) {// 主治医师
			endepDTO.setId_zz_doc(zzPsn.getId_emp());
			endepDTO.setZz_name(zzPsn.getName_psndoc());
		}

		if (zrPsn != null) {// 主任医师
			endepDTO.setId_zr_doc(zrPsn.getId_emp());
			endepDTO.setZr_name(zrPsn.getName_psndoc());
		}

		if (nurPsn != null) {// 护士
			endepDTO.setId_emp_nur(nurPsn.getId_emp());
			endepDTO.setSd_emp_nur(nurPsn.getSd_psndoc());
			endepDTO.setNur_name(nurPsn.getName_psndoc());
		}

	}
}
