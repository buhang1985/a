package iih.en.ip.s.bp;

import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.res.bed.d.Bdbed;
import iih.en.comm.IEnConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.BedEP;
import iih.en.comm.ep.EnAccEP;
import iih.en.comm.ep.EnDcgEP;
import iih.en.comm.ep.EntBedEP;
import iih.en.comm.ep.EntDeptEP;
import iih.en.comm.ep.EntEmpEP;
import iih.en.comm.ep.EntWgEP;
import iih.en.comm.ep.PsnDocEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.ip.dto.d.EnIpDepInfoDTO;
import iih.en.ip.s.event.IpChgEmpEvent2;
import iih.en.ip.s.event.IpEnterDeptEvent2;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.en.pv.enres.d.EnPsnDO;
import iih.en.pv.enres.i.IEnpsnCudService;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.d.desc.InpatientDODesc;
import iih.en.pv.inpatient.dto.d.ChgEmp4EsDTO;
import iih.en.pv.inpatient.dto.d.EnterDept4EsDTO;
import iih.en.pv.inpatient.i.IInpatientCudService;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitCudService;
import iih.en.pv.pativisit.i.IPativisitRService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.bdfw.bbd.d.PsnDocDO;

/**
 * 入科增删改服务2
 * 
 * @author li.wm
 *
 */
public class SaveEnIpDepInfoDTOBP {
	/**
	 * 入科
	 * 
	 * @param enDepDTO
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(EnIpDepInfoDTO  enIpDepInfoDTO) throws BizException {
		this.validate(enIpDepInfoDTO);
		if (enIpDepInfoDTO.getDt_acpt() == null)
			enIpDepInfoDTO.setDt_acpt(EnAppUtils.getServerDateTime());
		FDateTime Dt_b = enIpDepInfoDTO.getDt_acpt();
		BedEP bedBP = new BedEP();
		// 校验状态
		this.getInpatientDO(enIpDepInfoDTO);
		// 新床位，需校验
		if (!enIpDepInfoDTO.getId_bed().equals(enIpDepInfoDTO.getId_bed_old())) {
			FBoolean hasUsed = bedBP.hasUsed(enIpDepInfoDTO.getId_bed());
			if (hasUsed.booleanValue()) {
				throw new BizException(IEnMsgConst.ERROR_BED_STATUS_USED);
			}
			if(bedBP.hasChanged(enIpDepInfoDTO.getId_bed(), IBdResDictCodeConst.SD_BEDSU_EMPTY).booleanValue()){
				throw new BizException(IEnMsgConst.ERROR_BED_STATUS_CHANGED);
			}
		}else{
			if(bedBP.hasChanged(enIpDepInfoDTO.getId_bed(), IBdResDictCodeConst.SD_BEDSU_OCCUPYBYIN).booleanValue()){
				throw new BizException(IEnMsgConst.ERROR_BED_STATUS_CHANGED);
			}
		}
		// 1. 更新表bd_bed(判断是否区分床位性别)
		Bdbed nBedDO = null;
		if (IEnDictCodeConst.BED_HAS_SEX.equals(EnParamUtils.getBedSexParam(enIpDepInfoDTO.getId_dep_nur()))) {
			bedBP.releaseBedWithSex(enIpDepInfoDTO.getId_ent(), enIpDepInfoDTO.getId_bed_old(), FBoolean.FALSE);// 释放占用床位
			nBedDO = bedBP.occupyBedWithSex(enIpDepInfoDTO.getId_bed(), null, enIpDepInfoDTO.getSex_pat().toString(), FBoolean.FALSE,
					IBdResDictCodeConst.SD_BEDSU_USEDBYPATIENT, IBdResDictCodeConst.ID_BEDSU_USEDBYPATIENT);// 占用新床位
		}else {
			bedBP.releaseBed(enIpDepInfoDTO.getId_ent(), enIpDepInfoDTO.getId_bed_old());// 释放占用床位
			nBedDO = bedBP.useBed(enIpDepInfoDTO.getId_bed());// 占用新床位
		}
		// 2.更新表en_ent
		PatiVisitDO patiVisitDO = this.updatePatVisit(enIpDepInfoDTO, Dt_b);
		// 7.插入到过程表 en_ent_emp
		this.insertEntEmp(enIpDepInfoDTO, Dt_b);
		// 3.更新表en_ent_ip
		InpatientDO inpatient = this.updateInpatient(enIpDepInfoDTO, nBedDO);
		// 4. 插入到过程表en_ent_bed
		this.insertEntBed(enIpDepInfoDTO, nBedDO, Dt_b);
		// 5。将科室和病区信息插入到过程表en_ent_dep
		this.insertEntDep(enIpDepInfoDTO, Dt_b);
		// 6.插入到过程表 en_ent_wg
		this.insertEntWg(enIpDepInfoDTO, Dt_b);
		// 8.如果是专用诊疗组 更新bd_wg 设置id_ent_used
		if (enIpDepInfoDTO.getFg_pri() != null && enIpDepInfoDTO.getFg_pri().booleanValue()) {
			EntWgEP entWgBp = new EntWgEP();
			entWgBp.setBdWgEntId(enIpDepInfoDTO.getId_wg_phy(), enIpDepInfoDTO.getId_ent());
		}
		// 9.将病情和新入院插入到就诊状况表中(已移动到监听器)
		// 10.插入就诊病案
		//endep.insertAmr(enDepDTO, patiVisitDO, inpatient);
		this.InserteDcg(patiVisitDO);
		// 11.修改账户表最后记账日期
		this.updateAccDtCg(enIpDepInfoDTO.getId_ent(), Dt_b);
		// 12. 触发事件
		try {
			this.invokeIpEnterDeptEvent(enIpDepInfoDTO, inpatient);
		} catch (Exception ex) {
			Logger.error("入科消息失败：", ex);
		}
		try {
			this.invokeChangePsnEvent(enIpDepInfoDTO);
		} catch (Exception e) {
			Logger.error("医护人员消息失败：", e);
		}
		return FBoolean.TRUE;// 全部正确执行，返回true
	}

	/**
	 * 校验住院数据
	 * 
	 * @param enHosRegDTO
	 * @return
	 * @throws BizException
	 */
	private void getInpatientDO(EnIpDepInfoDTO enIpDepInfoDTO) throws BizException {
		// 入科校验
		IInpatientRService ipRService = ServiceFinder.find(IInpatientRService.class);
		InpatientDO inpatientDO = null;
		if (EnValidator.isEmpty(enIpDepInfoDTO.getId_ent())) {
			return;
		}
		String whereStr = InpatientDODesc.TABLE_ALIAS_NAME + ".id_ent = '" + enIpDepInfoDTO.getId_ent() + "'";
		InpatientDO[] inpatientDOs = ipRService.find(whereStr, null, FBoolean.FALSE);
		if (EnValidator.isEmpty(inpatientDOs)) {
			return;
		}
		inpatientDO = inpatientDOs[0];
		if (!inpatientDO.getSd_status().equals(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN)) {
			throw new BizException(IEnMsgConst.ERROR_ENT_STATUS_STATUS);
		}
	}
	/**
	 * 插入en_ent_bed 数据
	 * 
	 * @param enDepDTO
	 * @param nBedDO
	 * @param Dt_b
	 * @throws BizException
	 */
	private void insertEntBed(EnIpDepInfoDTO enIpDepInfoDTO, Bdbed nBedDO, FDateTime Dt_b) throws BizException {
		EntBedEP enbedEp = new EntBedEP();
		enbedEp.useBed(enIpDepInfoDTO.getId_ent(), nBedDO.getId_bed(), nBedDO.getName(), enIpDepInfoDTO.getId_dep_nur(), Dt_b);
	}

	/**
	 * 插入en_ent_dep
	 * 
	 * @param enDepDTO
	 * @param Dt_b
	 * @param true1
	 * @throws BizException
	 */
	private void insertEntDep(EnIpDepInfoDTO enIpDepInfoDTO, FDateTime Dt_b) throws BizException {
		EntDeptEP entDeptEp = new EntDeptEP();
		entDeptEp.insertEntDep(enIpDepInfoDTO.getId_dep_phy(), enIpDepInfoDTO.getId_ent(), IEnDictCodeConst.SD_ENTDEPROLE_DEP, IEnDictCodeConst.ID_ENTDEPROLE_DEP, Dt_b);
		entDeptEp.insertEntDep(enIpDepInfoDTO.getId_dep_nur(), enIpDepInfoDTO.getId_ent(), IEnDictCodeConst.SD_ENTDEPROLE_IA, IEnDictCodeConst.ID_ENTDEPROLE_IA, Dt_b);
	}

	/**
	 * 插入医疗组
	 * 
	 * @param enDepDTO
	 * @param Dt_b
	 * @throws BizException
	 */
	private void insertEntWg(EnIpDepInfoDTO enIpDepInfoDTO, FDateTime Dt_b) throws BizException {
		EntWgEP enwgEP = new EntWgEP();
		enwgEP.insertEntWg(enIpDepInfoDTO.getId_ent(), enIpDepInfoDTO.getId_wg_phy(), enIpDepInfoDTO.getFg_pri(), Dt_b);
	}

	/**
	 * 插入数据到en_ent_emp
	 * 
	 * @param enDepDTO
	 * @param Dt_b
	 * @throws BizException
	 */
	private void insertEntEmp(EnIpDepInfoDTO enIpDepInfoDTO, FDateTime Dt_b) throws BizException {
		EnPsnDO[] emp = new EnPsnDO[5];
		EntEmpEP entEmp = new EntEmpEP();
		// 责任医师
		emp[0] = entEmp.createEmp(enIpDepInfoDTO.getId_ent(), enIpDepInfoDTO.getId_emp_phy(), IEnDictCodeConst.ID_EMPROLE_DOCTOR, IEnDictCodeConst.SD_EMPROLE_DOCTOR, Dt_b);
		// 责任护士
		emp[1] = entEmp.createEmp(enIpDepInfoDTO.getId_ent(), enIpDepInfoDTO.getId_emp_nur(), IEnDictCodeConst.ID_EMPROLE_NURSE, IEnDictCodeConst.SD_EMPROLE_NURSE, Dt_b);
		// 主任医师
		emp[2] = entEmp.createEmp(enIpDepInfoDTO.getId_ent(), enIpDepInfoDTO.getId_zr_doc(), IEnDictCodeConst.ID_EMPROLE_ZRDOC, IEnDictCodeConst.SD_EMPROLE_ZRDOC, Dt_b);
		// 主治医师
		emp[3] = entEmp.createEmp(enIpDepInfoDTO.getId_ent(), enIpDepInfoDTO.getId_zz_doc(), IEnDictCodeConst.ID_EMPROLE_ZZDOC, IEnDictCodeConst.SD_EMPROLE_ZZDOC, Dt_b);
		// 住院医师
		emp[4] = entEmp.createEmp(enIpDepInfoDTO.getId_ent(), enIpDepInfoDTO.getId_zy_doc(), IEnDictCodeConst.ID_EMPROLE_ZYDOC, IEnDictCodeConst.SD_EMPROLE_ZYDOC, Dt_b);

		IEnpsnCudService enpsnService = ServiceFinder.find(IEnpsnCudService.class);
		enpsnService.insert(emp);
	}

	/**
	 * 更新en_ent
	 * 
	 * @param enDepDTO
	 * @param Dt_b
	 * @return
	 * @throws BizException
	 */
	private PatiVisitDO updatePatVisit(EnIpDepInfoDTO enIpDepInfoDTO, FDateTime Dt_b) throws BizException {
		String Id_ent = enIpDepInfoDTO.getId_ent();
		IPativisitCudService en_ent_service = ServiceFinder.find(IPativisitCudService.class);
		IPativisitRService entRService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO patiVisitDO = entRService.findById(Id_ent);
		patiVisitDO.setId_emp_phy(enIpDepInfoDTO.getId_emp_phy());
		patiVisitDO.setId_emp_nur(enIpDepInfoDTO.getId_emp_nur());
		patiVisitDO.setFg_acptvalid(FBoolean.TRUE);
		patiVisitDO.setFg_ip(FBoolean.TRUE);
		patiVisitDO.setDt_acpt(Dt_b);
		patiVisitDO.setId_wg_phy(enIpDepInfoDTO.getId_wg_phy());
		patiVisitDO.setStatus(DOStatus.UPDATED);
		PatiVisitDO[] patvisitDos = en_ent_service.save(new PatiVisitDO[] { patiVisitDO });
		return patvisitDos[0];
	}

	/**
	 * 更新住院表
	 * 
	 * @param enDepDTO
	 * @param nBedDO
	 * @throws BizException
	 */
	private InpatientDO updateInpatient(EnIpDepInfoDTO enIpDepInfoDTO, Bdbed nBedDO) throws BizException {
		String Id_ip = enIpDepInfoDTO.getId_ip();
		IInpatientCudService iCudService = ServiceFinder.find(IInpatientCudService.class);
		IInpatientRService iRService = ServiceFinder.find(IInpatientRService.class);
		InpatientDO inpatientDO = iRService.findById(Id_ip);
		inpatientDO.setId_bed(nBedDO.getId_bed());// 设置住院患者占用的床位的id与name
		inpatientDO.setName_bed(nBedDO.getName());
		inpatientDO.setSd_status(IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN);// 入科
																			// //更新就诊状态到住院
		inpatientDO.setStatus(DOStatus.UPDATED);
		inpatientDO = iCudService.update(new InpatientDO[] { inpatientDO })[0]; // 将更改的信息更新到en_ent表中
		return inpatientDO;
	}

	/**
	 * 插入固定费用
	 * 
	 * @param patiVisitDO
	 * @throws BizException
	 */
	private void InserteDcg(PatiVisitDO patiVisitDO) throws BizException {
		EnDcgEP endcgep = new EnDcgEP();
		endcgep.insertEnDcg(patiVisitDO.getId_ent(), patiVisitDO.getDt_acpt());
	}
	/**
	 * 修改账户表最后记账日期
	 * 
	 * @param entId
	 * @param dt_acc
	 * @throws BizException
	 */
	private void updateAccDtCg(String entId, FDateTime dt_acc) throws BizException {
		EnAccEP ep = new EnAccEP();
		EnAccountDO acc = ep.getAccByEntId(entId);
		acc.setStatus(DOStatus.UPDATED);
		acc.setDt_backcg(dt_acc);
		ep.update(new EnAccountDO[0]);
	}
	
	/**
	 * 校验
	 * @throws BizException 
	 * 
	 */
	private void validate(EnIpDepInfoDTO enIpDepInfoDTO) throws BizException{
		if(enIpDepInfoDTO==null)
			throw new BizException("入科数据不能为空！");
		if (enIpDepInfoDTO.getDt_acpt() == null)
			enIpDepInfoDTO.setDt_acpt(EnAppUtils.getServerDateTime());
		FDateTime Dt_b = enIpDepInfoDTO.getDt_acpt();
		//
		if (EnParamUtils.getEnIpArrangePhyTp() == IEnConst.NURSE_APPOINT) {
			if(EnValidator.isEmpty(enIpDepInfoDTO.getId_zr_doc()))
				throw new BizException("主任医师不能为空！");
			if(EnValidator.isEmpty(enIpDepInfoDTO.getId_zy_doc()))
				throw new BizException("住院医师不能为空！");
		}
		//主任医师和住院医师是否可以相同
		if(!EnParamUtils.isZrZyCanSame()){
			if(!EnValidator.isEmpty(enIpDepInfoDTO.getId_zr_doc()) && !EnValidator.isEmpty(enIpDepInfoDTO.getId_zy_doc()) 
					&& enIpDepInfoDTO.getId_zr_doc().equals(enIpDepInfoDTO.getId_zy_doc())){
				throw new BizException("主任医师与住院医师不能相同！");
			}
		}
	}
	

	/**
	 * 触发入科事件
	 * 
	 * @param enDepDTO
	 * @throws BizException
	 */
	private void invokeIpEnterDeptEvent(EnIpDepInfoDTO enIpDepInfoDTO, InpatientDO inpatient) throws BizException {
		this.setDocs(enIpDepInfoDTO);
		// 1、构造事件源
		EnterDept4EsDTO enterDept4EsDTO = new EnterDept4EsDTO();
		enterDept4EsDTO.setId_ent(enIpDepInfoDTO.getId_ent());
		enterDept4EsDTO.setId_pat(enIpDepInfoDTO.getId_pat());
		enterDept4EsDTO.setDt_acpt(enIpDepInfoDTO.getDt_acpt());
		enterDept4EsDTO.setName_pat(enIpDepInfoDTO.getName_pat());
		enterDept4EsDTO.setDt_birth_pat(enIpDepInfoDTO.getDt_birth_pat());
		enterDept4EsDTO.setName_dep_phy(enIpDepInfoDTO.getName_dep_phy());
		enterDept4EsDTO.setName_bed(enIpDepInfoDTO.getBed_name());
		enterDept4EsDTO.setSd_emp_zr(enIpDepInfoDTO.getSd_emp_zr());//主任
		enterDept4EsDTO.setName_emp_zr(enIpDepInfoDTO.getZr_name());
		enterDept4EsDTO.setSd_emp_doc(enIpDepInfoDTO.getSd_emp_zy());//住院
		enterDept4EsDTO.setPhy_name(enIpDepInfoDTO.getZy_name());
		enterDept4EsDTO.setSd_emp_zz(enIpDepInfoDTO.getSd_emp_zz());//主治 
		enterDept4EsDTO.setName_emp_zz(enIpDepInfoDTO.getZz_name());
		enterDept4EsDTO.setEvent_source(IEventType.TYPE_INSERT_AFTER);
		enterDept4EsDTO.setId_dep_opr(EnContextUtils.getDeptId());  //操作科室
		enterDept4EsDTO.setId_emp_opr(EnContextUtils.getPsnId());//操作员
		enterDept4EsDTO.setDt_opr(EnAppUtils.getServerDateTime());
		enterDept4EsDTO.setId_dep_nur(enIpDepInfoDTO.getId_dep_nur());
		enterDept4EsDTO.setSd_emp_ry(inpatient.getCode_emp_phy_op());
		enterDept4EsDTO.setName_emp_ry(inpatient.getName_emp_phy_op());
		// 2、触发事件
		IpEnterDeptEvent2 enterDeptEvent = new IpEnterDeptEvent2();
		enterDeptEvent.invoke(enterDept4EsDTO);
	}
	
	
	/**
	 * 触发医护人员修改事件
	 * 
	 * @param enDepDTO
	 * @throws BizException
	 */
	private void invokeChangePsnEvent(EnIpDepInfoDTO enIpDepInfoDTO) throws BizException {
		// 1、构造事件源
		ChgEmp4EsDTO esDTO = new ChgEmp4EsDTO();
		esDTO.setId_ent( enIpDepInfoDTO.getId_ent());
		esDTO.setEvent_source(IEventType.TYPE_INSERT_AFTER);
		esDTO.setId_dep_opr(EnContextUtils.getDeptId());  //操作科室
		esDTO.setId_emp_opr(EnContextUtils.getPsnId());//操作员
		esDTO.setDt_opr(EnAppUtils.getServerDateTime());
		
		// 2、触发事件
		IpChgEmpEvent2 enterDeptEvent = new IpChgEmpEvent2();
		enterDeptEvent.invoke(esDTO);
	}

	
	private void setDocs(EnIpDepInfoDTO enIpDepInfoDTO) throws BizException{
		List<String> psnIdList = new ArrayList<>();
		psnIdList.add(enIpDepInfoDTO.getId_zr_doc());
		psnIdList.add(enIpDepInfoDTO.getId_zz_doc());
		psnIdList.add(enIpDepInfoDTO.getId_zy_doc());
		PsnDocEP ep = new PsnDocEP();
		Map<String, PsnDocDO> psndocs = ep.getPsnByIdList(psnIdList);
		if(psndocs.containsKey(enIpDepInfoDTO.getId_zr_doc())){
			PsnDocDO doc = psndocs.get(enIpDepInfoDTO.getId_zr_doc());
			if(doc != null){
				enIpDepInfoDTO.setSd_emp_zr(doc.getCode());
				enIpDepInfoDTO.setZr_name(doc.getName());
			}
		}
		if(psndocs.containsKey(enIpDepInfoDTO.getId_zz_doc())){
			PsnDocDO doc = psndocs.get(enIpDepInfoDTO.getId_zz_doc());
			if(doc != null){
				enIpDepInfoDTO.setSd_emp_zz(doc.getCode());
				enIpDepInfoDTO.setZz_name(doc.getName());
			}
		}
		if(psndocs.containsKey(enIpDepInfoDTO.getId_zy_doc())){
			PsnDocDO doc = psndocs.get(enIpDepInfoDTO.getId_zy_doc());
			if(doc != null){
				enIpDepInfoDTO.setSd_emp_zy(doc.getCode());
				enIpDepInfoDTO.setZy_name(doc.getName());				
			}
		}
	}

}
