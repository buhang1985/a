package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.res.bizgrp.d.BizGroupDO;
import iih.bd.res.bizgrp.i.IBizgrpMDOCudService;
import iih.bd.res.bizgrp.i.IBizgrpMDORService;
import iih.ci.mr.ciamr.d.AMrDO;
import iih.en.comm.ep.NbEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.PativisitensonDTO;
import iih.en.pv.enres.d.EnMedGrpDO;
import iih.en.pv.enres.d.EnPsnDO;
import iih.en.pv.enres.i.IEnmedgrpCudService;
import iih.en.pv.enres.i.IEnmedgrpRService;
import iih.en.pv.enres.i.IEnpsnCudService;
import iih.en.pv.enres.i.IEnpsnRService;
import iih.en.pv.i.IEnIpQryService;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.inpatient.dto.d.ChgEmp4EsDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.s.event.IpChgEmpEvent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 保存新的医护人员信息
 * 
 * @author renying
 *
 */
public class SaveEnPsnBP {

	/**
	 * 保存新的医护人员信息
	 * 
	 * @param dto
	 * @throws BizException
	 */
	public PativisitensonDTO[] exec(PativisitensonDTO dto) throws BizException {
		//验证数据
		this.volidate(dto);
		//获取系统时间
		FDateTime servTime = EnAppUtils.getServerDateTime();
		//1. 获取需要修改医护人员的婴儿信息
		List<PativisitensonDTO> babys = getNeedChgBabyInfos(dto);
		//2. 更新表en_ent
		this.updateEnt(dto, babys);
		//3. 更新过程表 en_ent_wg
		this.updateEntWg(dto, babys, servTime);
		//4. 更新人员过程表
		this.updatePsn(dto, babys, servTime);
		//
		if (dto.getFg_private() != null && dto.getFg_private().booleanValue() ) {
			this.UpdateBdWgEntId(dto.getId_wg(), dto.getId_ent());
		}
		// 11. 触发事件
		try {
			this.invokeIpEnterDeptEvent(dto);
		} catch (Exception ex) {
			System.out.println("ch");
		}
		return this.assemblyPativisitensons(dto, babys);
	}
	/**
	 * 获取需要修改医护人员的婴儿信息
	 * 
	 * @param dto
	 * @return
	 * @throws BizException 
	 */
	private List<PativisitensonDTO> getNeedChgBabyInfos(PativisitensonDTO dto) throws BizException{
		NbEP ep = new NbEP();
		NewbornDO[] babys = ep.getNbListByMomEntInHos(dto.getId_ent());
		if(EnValidator.isEmpty(babys))
			return null;
		List<PativisitensonDTO> list = new ArrayList<>();
		IEnIpQryService serv = ServiceFinder.find(IEnIpQryService.class);
		for(NewbornDO baby : babys){
			PativisitensonDTO pat = serv.getMedPsn(baby.getId_ent_bb());
			if(!this.isChanged(dto, pat))
				list.add(pat);
		}
		return list;
	}
	/**
	 * 婴儿数据是否改变
	 * 
	 * @param mom
	 * @param baby
	 * @return
	 */
	private boolean isChanged(PativisitensonDTO mom, PativisitensonDTO baby){
		if(mom == null || baby == null)
			return false;
		if((mom.getWg_id() == null && baby.getWg_id() != null) || (mom.getWg_id() != null && !mom.getWg_id().equals(baby.getWg_id())))
			return true;
		if((mom.getZr_doc_id() == null && baby.getZr_doc_id() != null) || (mom.getZr_doc_id() != null && !mom.getZr_doc_id().equals(baby.getZr_doc_id())))
			return true;
		if((mom.getZz_doc_id() == null && baby.getZz_doc_id() != null) || (mom.getZz_doc_id() != null && !mom.getZz_doc_id().equals(baby.getZz_doc_id())))
			return true;
		if((mom.getZy_doc_id() == null && baby.getZy_doc_id() != null) || (mom.getZy_doc_id() != null && !mom.getZy_doc_id().equals(baby.getZy_doc_id())))
			return true;
		if((mom.getEmp_phy_id() == null && baby.getEmp_phy_id() != null) || (mom.getEmp_phy_id() != null && !mom.getEmp_phy_id().equals(baby.getEmp_phy_id())))
			return true;
		if((mom.getEmp_nur_id() == null && baby.getEmp_nur_id() != null) || (mom.getEmp_nur_id() != null && !mom.getEmp_nur_id().equals(baby.getEmp_nur_id())))
			return true;
		return false;
	}

	/**
	 * 更新表en_ent
	 * 
	 * @param dto
	 * @throws BizException
	 */
	private void updateEnt(PativisitensonDTO dto, List<PativisitensonDTO> babys) throws BizException {
		String[] entIds = this.assemblyEntIds(dto, babys);
		PvEP ep = new PvEP();
		PatiVisitDO[] pvs = ep.getPvsByPKs(entIds);
		for(PatiVisitDO pv : pvs) {
			//更换医疗组
			if (dto.getId_wg() != null && !dto.getId_wg().equals(dto.getWg_id())) {
				pv.setId_wg_phy(dto.getId_wg());
				pv.setId_emp_phy(dto.getId_emp_phy());
			}else {//未更换医疗组
				if (!EnValidator.isEmpty(dto.getId_emp_phy()))
					pv.setId_emp_phy(dto.getId_emp_phy());
			}
			//当前 责任护士
			if (!EnValidator.isEmpty(dto.getId_emp_nur()))
				pv.setId_emp_nur(dto.getId_emp_nur());
				
			pv.setStatus(DOStatus.UPDATED);
		}
		ep.save(pvs);
	}

	/**
	 * 更新表en_ent_wg
	 * 
	 * @param dto
	 * @throws BizException
	 */
	private void updateEntWg(PativisitensonDTO dto, List<PativisitensonDTO> babys, FDateTime servTime) throws BizException {
		IEnmedgrpRService rServ = ServiceFinder.find(IEnmedgrpRService.class);
		IEnmedgrpCudService cudServ = ServiceFinder.find(IEnmedgrpCudService.class);
		String whereStr = "Id_ent = '"+dto.getId_ent()+"'" + " and isnull(dt_e, '~')='~' ";
		EnMedGrpDO[] enMedGrpDOs = rServ.find(whereStr, null, FBoolean.FALSE);
		if(EnValidator.isEmpty(enMedGrpDOs))
			return;
		//判断医疗组是否修改
		if(!EnValidator.isEmpty(dto.getId_wg())
				&& !dto.getId_wg().equals(dto.getWg_id())){
			String[] entIds = this.assemblyEntIds(dto, babys);
			if(!EnValidator.isEmpty(babys)){
				whereStr = EnSqlUtils.getInSqlByIds("Id_ent", entIds) + " and isnull(dt_e, '~')='~' ";
				enMedGrpDOs = rServ.find(whereStr, null, FBoolean.FALSE);
				if(EnValidator.isEmpty(enMedGrpDOs))
					return;
			}
			List<EnMedGrpDO> list = new ArrayList<EnMedGrpDO>();
			//结束旧的医疗组
			for(EnMedGrpDO enMedGrpDO : enMedGrpDOs){
				enMedGrpDO.setDt_e(servTime);
				enMedGrpDO.setStatus(DOStatus.UPDATED);
				list.add(enMedGrpDO);
			}
			//创建新的医疗组信息
			list.addAll(this.createNewEnMedDOs(dto, entIds, servTime));
			cudServ.save(list.toArray(new EnMedGrpDO[]{}));
		}
	}

	/**
	 * 更新表en_ent_emp
	 * 
	 * @param dto
	 * @param babys
	 * @param servTime
	 * @throws BizException
	 */
	private void updatePsn(PativisitensonDTO dto, List<PativisitensonDTO> babys, FDateTime servTime) throws BizException {
		// 更新到过程表 en_ent_emp
		// 设置en_ent_emp表中对应主治大夫等5人的基本信息
		String[] entIds = this.assemblyEntIds(dto, babys);
		//更换了医疗组并且 现医师为空 原医师不为空
		boolean flag = dto.getId_wg() != null && !dto.getId_wg().equals(dto.getWg_id()) && dto.getId_wg() == null && dto.getWg_id() != null;
		// 责任医师
		if (flag || (!EnValidator.isEmpty(dto.getId_emp_phy()) && !(dto.getId_emp_phy().equals(dto.getEmp_phy_id())))) {
			this.updateEnEmp(entIds, IEnDictCodeConst.ID_EMPROLE_DOCTOR, IEnDictCodeConst.SD_EMPROLE_DOCTOR, 
					dto.getEmp_phy_id(), dto.getId_emp_phy(), servTime);
		}

		if (flag || (!EnValidator.isEmpty(dto.getId_zy_doc()) && !(dto.getId_zy_doc().equals(dto.getZy_doc_id())))) { // 住院医师
				this.updateEnEmp(entIds, IEnDictCodeConst.ID_EMPROLE_ZYDOC, IEnDictCodeConst.SD_EMPROLE_ZYDOC, 
						dto.getZy_doc_id(), dto.getId_zy_doc(), servTime);
		}

		if (flag || (!EnValidator.isEmpty(dto.getId_zz_doc()) && !(dto.getId_zz_doc().equals(dto.getZz_doc_id())))) { // 主治医师
				this.updateEnEmp(entIds, IEnDictCodeConst.ID_EMPROLE_ZZDOC, IEnDictCodeConst.SD_EMPROLE_ZZDOC, 
						dto.getZz_doc_id(), dto.getId_zz_doc(), servTime);
		}

		if (flag || (!EnValidator.isEmpty(dto.getId_zr_doc()) && !(dto.getId_zr_doc().equals(dto.getZr_doc_id())))) { // 主任医师
				this.updateEnEmp(entIds, IEnDictCodeConst.ID_EMPROLE_ZRDOC, IEnDictCodeConst.SD_EMPROLE_ZRDOC, 
						dto.getZr_doc_id(), dto.getId_zr_doc(), servTime);
		}

		if (!EnValidator.isEmpty(dto.getId_emp_nur())) { // 责任护士
			if (!(dto.getId_emp_nur().equals(dto.getEmp_nur_id()))) {
				this.updateEnEmp(entIds, IEnDictCodeConst.ID_EMPROLE_NURSE, IEnDictCodeConst.SD_EMPROLE_NURSE, 
						dto.getEmp_nur_id(), dto.getId_emp_nur(), servTime);
			}
		}
	}

	/**
	 * 更新bd_wg 设置id_ent
	 * 
	 * @param idWg
	 * @param idEnt
	 * @throws BizException
	 */
	private void UpdateBdWgEntId(String idWg, String idEnt) throws BizException {
		IBizgrpMDORService bizRServie = ServiceFinder.find(IBizgrpMDORService.class);
		IBizgrpMDOCudService bizCServie = ServiceFinder.find(IBizgrpMDOCudService.class);
		BizGroupDO bizdo = bizRServie.findById(idWg);
		bizdo.setStatus(DOStatus.UPDATED);
		if(EnValidator.isEmpty(bizdo.getId_ent_used()) || "~".equals(bizdo.getId_ent_used())){
			bizdo.setId_ent_used(idEnt);
		}
		bizCServie.save(new BizGroupDO[] { bizdo });
	}

	/**
	 * 查找人员信息
	 * 
	 * @param entId
	 * @param emprole
	 * @param psnId
	 * @param enpsnService
	 * @return
	 * @throws BizException
	 */
	private void updateEnEmp(String[] entIds, String roleIdConst, String roleSdConst, String oldempId, String newEmpId, FDateTime servTime) throws BizException {
		IEnpsnRService rServ = ServiceFinder.find(IEnpsnRService.class);
		IEnpsnCudService cudServ = ServiceFinder.find(IEnpsnCudService.class);
		String whereStr = EnSqlUtils.getInSqlByIds("id_ent", entIds) + 
				" and sd_emprole='" + roleSdConst + "'" + " and (isnull(dt_e,'~')='~')";
		EnPsnDO[] enPsns = rServ.find(whereStr, null, FBoolean.FALSE);
		//停止之前人员信息
		if(!EnValidator.isEmpty(enPsns)){
			for(EnPsnDO enPsn : enPsns){
				enPsn.setStatus(DOStatus.UPDATED);
				enPsn.setDt_e(servTime);
			}
			cudServ.save(enPsns);
		}
		//添加人员信息
		List<EnPsnDO> newList = new ArrayList<>();
		for(String entId : entIds){
			EnPsnDO newdoctorDO = new EnPsnDO();
			newdoctorDO.setStatus(DOStatus.NEW);
			newdoctorDO.setId_emp(newEmpId);
			newdoctorDO.setId_ent(entId);
			newdoctorDO.setSd_emprole(roleSdConst);
			newdoctorDO.setId_emprole(roleIdConst);
			newdoctorDO.setDt_b(servTime);
			newList.add(newdoctorDO);
		}
		cudServ.save(newList.toArray(new EnPsnDO[0]));
		this.updateCiAmr(entIds, roleSdConst, newEmpId);
	}

	/**
	 * 创建新的医疗组信息
	 * 
	 * @param dto
	 * @param entIds
	 * @param servTime
	 * @return
	 * @throws BizException
	 */
	private List<EnMedGrpDO> createNewEnMedDOs(PativisitensonDTO dto, String[] entIds, FDateTime servTime) throws BizException {
		if(EnValidator.isEmpty(entIds))
			return null;
		List<EnMedGrpDO> list = new ArrayList<>();
		for(String entId : entIds){
			EnMedGrpDO newEntMEdDO = new EnMedGrpDO();
			newEntMEdDO.setStatus(DOStatus.NEW);
			newEntMEdDO.setId_wg(dto.getId_wg());
			newEntMEdDO.setId_ent(entId);
			newEntMEdDO.setSd_enwgrole(IEnDictCodeConst.SD_ENWGROLE_PHY);
			newEntMEdDO.setId_enwgrole(IEnDictCodeConst.ID_ENWGROLE_PHY);
			newEntMEdDO.setDt_b(servTime);
			newEntMEdDO.setFg_psn(dto.getFg_private());
			list.add(newEntMEdDO);
		}
		return list;
	}

	/**
	 * 更新病案信息
	 * 
	 * @param entIds
	 * @param emproleSdConst
	 * @param empId
	 * @throws BizException
	 */
	private void updateCiAmr(String[] entIds, String emproleSdConst, String empId) throws BizException {
		AmrBP amrBp = new AmrBP();
		if(EnValidator.isEmpty(entIds))
			return;
		AMrDO[] amrdos = amrBp.getAmrDOs(entIds);
		if (amrdos == null)
			return;
		if (emproleSdConst.equals(IEnDictCodeConst.SD_EMPROLE_DOCTOR)) {
			for(AMrDO amr : amrdos){
				amr.setStatus(DOStatus.UPDATED);
				amr.setId_treat_doctor(empId);
			}
			amrBp.saveAmr(amrdos);
		}
		if (emproleSdConst.equals(IEnDictCodeConst.SD_EMPROLE_ZZDOC)) {
			for(AMrDO amr : amrdos){
				amr.setStatus(DOStatus.UPDATED);
				amr.setId_mast_doctor(empId);
			}
			amrBp.saveAmr(amrdos);
		}
		if (emproleSdConst.equals(IEnDictCodeConst.SD_EMPROLE_ZRDOC)) {
			for(AMrDO amr : amrdos){
				amr.setStatus(DOStatus.UPDATED);
				amr.setId_dir_doctor(empId);
			}
			amrBp.saveAmr(amrdos);
		}
		if (emproleSdConst.equals(IEnDictCodeConst.SD_EMPROLE_NURSE)) {
			for(AMrDO amr : amrdos){
				amr.setStatus(DOStatus.UPDATED);
				amr.setId_emp_nur(empId);
			}
			amrBp.saveAmr(amrdos);
		}
	}
	
	/**
	 * 触发事件
	 * 
	 * @param enDepDTO
	 * @throws BizException
	 */
	private void invokeIpEnterDeptEvent(PativisitensonDTO dto) throws BizException {
		// 1、构造事件源
		ChgEmp4EsDTO esDTO = new ChgEmp4EsDTO();
		esDTO.setId_ent( dto.getId_ent());
		esDTO.setEvent_source(IEventType.TYPE_INSERT_AFTER);
		esDTO.setId_dep_opr(EnContextUtils.getDeptId());  //操作科室
		esDTO.setId_emp_opr(EnContextUtils.getPsnId());//操作员
		esDTO.setDt_opr(EnAppUtils.getServerDateTime());
		
		// 2、触发事件
		IpChgEmpEvent enterDeptEvent = new IpChgEmpEvent();
		enterDeptEvent.invoke(esDTO);
	}
	
	/**
	 * 组装就诊id集合
	 * 
	 * @param dto
	 * @param babys
	 * @return
	 */
	private String[] assemblyEntIds(PativisitensonDTO dto, List<PativisitensonDTO> babys){
		Set<String> set = new HashSet<>();
		set.add(dto.getId_ent());
		if(!EnValidator.isEmpty(babys)) {
			for(PativisitensonDTO baby : babys)
				set.add(baby.getId_ent());
		}
		return set.toArray(new String[0]);
	}
	/**
	 * 组装PativisitensonDTO集合
	 * 
	 * @param dto
	 * @param babys
	 * @return
	 */
	private PativisitensonDTO[] assemblyPativisitensons(PativisitensonDTO dto, List<PativisitensonDTO> babys){
		if(EnValidator.isEmpty(babys))
			return new PativisitensonDTO[]{dto};
		babys.add(dto);
		return babys.toArray(new PativisitensonDTO[0]);
	}
	//验证数据
	private void volidate(PativisitensonDTO dto) throws BizException {
		if (EnParamUtils.isZrZyCanSame())
			return;
		String zr = !EnValidator.isEmpty(dto.getId_zr_doc()) ? dto
				.getId_zr_doc() : dto.getZr_doc_id();
		String zy = !EnValidator.isEmpty(dto.getId_zy_doc()) ? dto
				.getId_zy_doc() : dto.getZy_doc_id();
		if (zr != null && zr.equals(zy))
			throw new BizException("主任医师与住院医师不能相同！");
	}
}
