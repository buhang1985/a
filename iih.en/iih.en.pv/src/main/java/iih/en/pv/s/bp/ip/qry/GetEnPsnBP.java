package iih.en.pv.s.bp.ip.qry;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.IpEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.PativisitensonDTO;
import iih.en.pv.enres.d.EnMedGrpDO;
import iih.en.pv.enres.d.EnPsnDO;
import iih.en.pv.enres.i.IEnmedgrpRService;
import iih.en.pv.enres.i.IEnpsnRService;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.inpatient.i.INewbornRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据就诊id查找医护人员
 * 
 * @author renying
 *
 */
public class GetEnPsnBP {

	/**
	 * 根据就诊id查找医护人员
	 * 
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	public PativisitensonDTO exec(String entId) throws BizException {
		// 1、校验参数
		if (EnValidator.isEmpty(entId))
			return null;
		PativisitensonDTO pativisitensonDTO = new PativisitensonDTO();
		// 2、设置就诊数据值
		this.setEntInfo4DTO(entId, pativisitensonDTO);
		if(pativisitensonDTO.getFg_ip() !=null && !pativisitensonDTO.getFg_ip().booleanValue()){
			return pativisitensonDTO;
		}
		// 3、设置医疗组信息
		this.setWgInfo4DTO(entId, pativisitensonDTO);
		// 4、查找人员信息
		EnPsnDO[] enpsndocArray = this.getEnPsnArray(entId);
		// 5、设置人员信息
		EnPsnDO docPsn = this.getEnPsnDO(enpsndocArray, IEnDictCodeConst.SD_EMPROLE_DOCTOR);//责任
		EnPsnDO zyPsn = this.getEnPsnDO(enpsndocArray, IEnDictCodeConst.SD_EMPROLE_ZYDOC);//住院
		EnPsnDO zzPsn = this.getEnPsnDO(enpsndocArray, IEnDictCodeConst.SD_EMPROLE_ZZDOC);//主治
		EnPsnDO zrPsn = this.getEnPsnDO(enpsndocArray, IEnDictCodeConst.SD_EMPROLE_ZRDOC);//主任
		EnPsnDO nurPsn = this.getEnPsnDO(enpsndocArray, IEnDictCodeConst.SD_EMPROLE_NURSE);//护士

		if (docPsn != null){// 责任医师	
			pativisitensonDTO.setEmp_phy_id(docPsn.getId_emp());
			pativisitensonDTO.setName_emp_phy_show(docPsn.getName_psndoc());
		}

		if (zyPsn != null){// 住院医师	
			pativisitensonDTO.setZy_doc_id(zyPsn.getId_emp());
			pativisitensonDTO.setName_zy_doc_show(zyPsn.getName_psndoc());
		}

		if (zzPsn != null){// 主治医师		
			pativisitensonDTO.setZz_doc_id(zzPsn.getId_emp());
			pativisitensonDTO.setName_zz_doc_show(zzPsn.getName_psndoc());
		}

		if (zrPsn != null){// 主任医师
			pativisitensonDTO.setZr_doc_id(zrPsn.getId_emp());
			pativisitensonDTO.setName_zr_doc_show(zrPsn.getName_psndoc());
		}

		if (nurPsn != null){// 护士		
			pativisitensonDTO.setEmp_nur_id(nurPsn.getId_emp());
			pativisitensonDTO.setName_emp_nur_show(nurPsn.getName_psndoc());
		}
		//	新生儿设置ip相关信息（新生儿标识、母亲entID）
		this.setIpInfo4DTO(entId, pativisitensonDTO);
		return pativisitensonDTO;
	}

	/**
	 * 查找entdo 并设置相关值
	 * 
	 * @param enHosRegDTO
	 * @return
	 * @throws BizException
	 */
	private void setEntInfo4DTO(String entId, PativisitensonDTO pativisitensonDTO) throws BizException {
		IPativisitRService ipRService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO patiVisitDO = new PatiVisitDO();
		patiVisitDO = ipRService.findById(entId);
		pativisitensonDTO.setId_ent(entId);
		if (patiVisitDO == null)
			return;
		pativisitensonDTO.setId_dep_phy(patiVisitDO.getId_dep_phy());
		pativisitensonDTO.setFg_ip(patiVisitDO.getFg_ip());
		pativisitensonDTO.setId_dep_nur(patiVisitDO.getId_dep_nur());
	}

	/**
	 * 新生儿设置ip相关信息（新生儿标识、母亲entID）
	 * @param entId
	 * @param pativisitensonDTO
	 * @throws BizException
	 */
	private void setIpInfo4DTO(String entId,PativisitensonDTO pativisitensonDTO) throws BizException {
		IpEP ipep = new IpEP();
		InpatientDO[] inpatientDOs = ipep.getIpDOByEntId(entId);
		if(EnValidator.isEmpty(inpatientDOs)){
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_INPATIENTDO);
		}
		pativisitensonDTO.setId_dep_phyadm(inpatientDOs[0].getId_dep_phyadm());

		pativisitensonDTO.setFg_newborn(inpatientDOs[0].getFg_newborn());
		
		if(inpatientDOs[0].getFg_newborn()!=null && inpatientDOs[0].getFg_newborn().booleanValue()){
			INewbornRService nbService = ServiceFinder.find(INewbornRService.class);
			NewbornDO[] newborn = nbService.findByAttrValString(NewbornDO.ID_ENT_BB, entId);
			if(!EnValidator.isEmpty(newborn)){
				pativisitensonDTO.setId_ent_mother(newborn[0].getId_ent_mom());
			}
		}
		
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
		if(EnValidator.isEmpty(enpsnDOs))
			return null;
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
	 * @param pativisitensonDTO
	 * @throws BizException
	 */
	private void setWgInfo4DTO(String entId, PativisitensonDTO pativisitensonDTO) throws BizException {
		IEnmedgrpRService enwgService = ServiceFinder.find(IEnmedgrpRService.class);
		EnMedGrpDO[] enMedGrpDOs = enwgService.find("a0.id_ent='" + entId + "' and (Isnull(a0.dt_e,'~')='~') ", "", FBoolean.FALSE);
		if (EnValidator.isEmpty(enMedGrpDOs))
			return;
		EnMedGrpDO enMedGrpDO = enMedGrpDOs[0];
		if (enMedGrpDO == null)
			return;
		pativisitensonDTO.setWg_id(enMedGrpDO.getId_wg());
		pativisitensonDTO.setName_wg_show(enMedGrpDO.getName_wg());
	}

}
