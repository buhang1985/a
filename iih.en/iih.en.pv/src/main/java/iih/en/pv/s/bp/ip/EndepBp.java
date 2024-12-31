package iih.en.pv.s.bp.ip;

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
import iih.en.comm.ep.IpEP;
import iih.en.comm.ep.PsnDocEP;
import iih.en.comm.evt.EnEvtHandle;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EnDepDTO;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.en.pv.enres.d.EnPsnDO;
import iih.en.pv.enres.i.IEnpsnCudService;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.dto.d.ChgEmp4EsDTO;
import iih.en.pv.inpatient.dto.d.EnterDept4EsDTO;
import iih.en.pv.inpatient.i.IInpatientCudService;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitCudService;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.en.pv.s.event.IpChgEmpEvent;
import iih.en.pv.s.event.IpEnterDeptEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.bdfw.bbd.d.PsnDocDO;

/**
 * 入科
 * 
 * @author renying
 */
public class EndepBp {
	/**
	 * 入科
	 * 
	 * @param enDepDTO
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(EnDepDTO enDepDTO) throws BizException {
		this.validate(enDepDTO);
		if (enDepDTO.getDt_acpt() == null)
			enDepDTO.setDt_acpt(EnAppUtils.getServerDateTime());
		FDateTime Dt_b = enDepDTO.getDt_acpt();
		BedEP bedBP = new BedEP();
		EndepBp endep = new EndepBp();
		// 校验状态
		this.getInpatientDO(enDepDTO);
		// 新床位，需校验
		if (!enDepDTO.getId_bed().equals(enDepDTO.getId_bed_old())) {
			FBoolean hasUsed = bedBP.hasUsed(enDepDTO.getId_bed());
			if (hasUsed.booleanValue()) {
				throw new BizException(IEnMsgConst.ERROR_BED_STATUS_USED);
			}
			if(bedBP.hasChanged(enDepDTO.getId_bed(), IBdResDictCodeConst.SD_BEDSU_EMPTY).booleanValue()){
				throw new BizException(IEnMsgConst.ERROR_BED_STATUS_CHANGED);
			}
		}else{
			if(bedBP.hasChanged(enDepDTO.getId_bed(), IBdResDictCodeConst.SD_BEDSU_OCCUPYBYIN).booleanValue()){
				throw new BizException(IEnMsgConst.ERROR_BED_STATUS_CHANGED);
			}
		}
		// 1. 更新表bd_bed(判断是否区分床位性别)
		Bdbed nBedDO = null;
		if (IEnDictCodeConst.BED_HAS_SEX.equals(EnParamUtils.getBedSexParam(enDepDTO.getId_dep_nur()))) {
			bedBP.releaseBedWithSex(enDepDTO.getId_ent(), enDepDTO.getId_bed_old(), FBoolean.FALSE);// 释放占用床位
			nBedDO = bedBP.occupyBedWithSex(enDepDTO.getId_bed(), null, enDepDTO.getSex_pat().toString(), FBoolean.FALSE,
					IBdResDictCodeConst.SD_BEDSU_USEDBYPATIENT, IBdResDictCodeConst.ID_BEDSU_USEDBYPATIENT);// 占用新床位
		}else {
			bedBP.releaseBed(enDepDTO.getId_ent(), enDepDTO.getId_bed_old());// 释放占用床位
			nBedDO = bedBP.useBed(enDepDTO.getId_bed());// 占用新床位
		}
		// 2.更新表en_ent
		PatiVisitDO patiVisitDO = endep.updatePatVisit(enDepDTO, Dt_b);
		// 7.插入到过程表 en_ent_emp
		endep.insertEntEmp(enDepDTO, Dt_b);
		// 3.更新表en_ent_ip
		InpatientDO inpatient = endep.updateInpatient(enDepDTO, nBedDO);
		// 4. 插入到过程表en_ent_bed
		endep.insertEntBed(enDepDTO, nBedDO, Dt_b);
		// 5。将科室和病区信息插入到过程表en_ent_dep
		endep.insertEntDep(enDepDTO, Dt_b);
		// 6.插入到过程表 en_ent_wg
		endep.insertEntWg(enDepDTO, Dt_b);
		// 8.如果是专用诊疗组 更新bd_wg 设置id_ent_used
		if (enDepDTO.getFg_pri() != null && enDepDTO.getFg_pri().booleanValue()) {
			EntWgEP entWgBp = new EntWgEP();
			entWgBp.setBdWgEntId(enDepDTO.getId_wg_phy(), enDepDTO.getId_ent());
		}
		// 9.将病情和新入院插入到就诊状况表中(已移动到监听器)
		// 10.插入就诊病案
		//endep.insertAmr(enDepDTO, patiVisitDO, inpatient);
		this.InserteDcg(patiVisitDO);
		// 11.修改账户表最后记账日期
		this.updateAccDtCg(enDepDTO.getId_ent(), Dt_b);
		// 12.记录入科就诊事件
		new EnEvtHandle().insertEnterDepEvt(enDepDTO);
		// 13. 触发事件	
		this.invokeIpEnterDeptEvent(enDepDTO, inpatient);
		this.invokeChangePsnEvent(enDepDTO);
		return FBoolean.TRUE;// 全部正确执行，返回true
	}

	/**
	 * 校验住院数据
	 * 
	 * @param enHosRegDTO
	 * @return
	 * @throws BizException
	 */
	private void getInpatientDO(EnDepDTO enDepDTO) throws BizException {
		// 入科校验
		InpatientDO inpatientDO = null;
		if (EnValidator.isEmpty(enDepDTO.getId_ent())) {
			return;
		}
		inpatientDO = new IpEP().getIpByEntId(enDepDTO.getId_ent());
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
	private void insertEntBed(EnDepDTO enDepDTO, Bdbed nBedDO, FDateTime Dt_b) throws BizException {
		EntBedEP enbedEp = new EntBedEP();
		enbedEp.useBed(enDepDTO.getId_ent(), nBedDO.getId_bed(), nBedDO.getName(), enDepDTO.getId_dep_nur(), Dt_b);
	}

	/**
	 * 插入en_ent_dep
	 * 
	 * @param enDepDTO
	 * @param Dt_b
	 * @param true1
	 * @throws BizException
	 */
	private void insertEntDep(EnDepDTO enDepDTO, FDateTime Dt_b) throws BizException {
		EntDeptEP entDeptEp = new EntDeptEP();
		entDeptEp.insertEntDep(enDepDTO.getId_dep_phy(), enDepDTO.getId_ent(), IEnDictCodeConst.SD_ENTDEPROLE_DEP, IEnDictCodeConst.ID_ENTDEPROLE_DEP, Dt_b);
		entDeptEp.insertEntDep(enDepDTO.getId_dep_nur(), enDepDTO.getId_ent(), IEnDictCodeConst.SD_ENTDEPROLE_IA, IEnDictCodeConst.ID_ENTDEPROLE_IA, Dt_b);
	}

	/**
	 * 插入医疗组
	 * 
	 * @param enDepDTO
	 * @param Dt_b
	 * @throws BizException
	 */
	private void insertEntWg(EnDepDTO enDepDTO, FDateTime Dt_b) throws BizException {
		EntWgEP enwgEP = new EntWgEP();
		enwgEP.insertEntWg(enDepDTO.getId_ent(), enDepDTO.getId_wg_phy(), enDepDTO.getFg_pri(), Dt_b);
	}

	/**
	 * 插入数据到en_ent_emp
	 * 
	 * @param enDepDTO
	 * @param Dt_b
	 * @throws BizException
	 */
	private void insertEntEmp(EnDepDTO enDepDTO, FDateTime Dt_b) throws BizException {
		EnPsnDO[] emp = new EnPsnDO[5];
		EntEmpEP entEmp = new EntEmpEP();
		// 责任医师
		emp[0] = entEmp.createEmp(enDepDTO.getId_ent(), enDepDTO.getId_emp_phy(), IEnDictCodeConst.ID_EMPROLE_DOCTOR, IEnDictCodeConst.SD_EMPROLE_DOCTOR, Dt_b);
		// 责任护士
		emp[1] = entEmp.createEmp(enDepDTO.getId_ent(), enDepDTO.getId_emp_nur(), IEnDictCodeConst.ID_EMPROLE_NURSE, IEnDictCodeConst.SD_EMPROLE_NURSE, Dt_b);
		// 主任医师
		emp[2] = entEmp.createEmp(enDepDTO.getId_ent(), enDepDTO.getId_zr_doc(), IEnDictCodeConst.ID_EMPROLE_ZRDOC, IEnDictCodeConst.SD_EMPROLE_ZRDOC, Dt_b);
		// 主治医师
		emp[3] = entEmp.createEmp(enDepDTO.getId_ent(), enDepDTO.getId_zz_doc(), IEnDictCodeConst.ID_EMPROLE_ZZDOC, IEnDictCodeConst.SD_EMPROLE_ZZDOC, Dt_b);
		// 住院医师
		emp[4] = entEmp.createEmp(enDepDTO.getId_ent(), enDepDTO.getId_zy_doc(), IEnDictCodeConst.ID_EMPROLE_ZYDOC, IEnDictCodeConst.SD_EMPROLE_ZYDOC, Dt_b);

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
	private PatiVisitDO updatePatVisit(EnDepDTO enDepDTO, FDateTime Dt_b) throws BizException {
		String Id_ent = enDepDTO.getId_ent();
		IPativisitCudService en_ent_service = ServiceFinder.find(IPativisitCudService.class);
		IPativisitRService entRService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO patiVisitDO = entRService.findById(Id_ent);
		patiVisitDO.setId_emp_phy(enDepDTO.getId_emp_phy());
		patiVisitDO.setId_emp_nur(enDepDTO.getId_emp_nur());
		patiVisitDO.setFg_acptvalid(FBoolean.TRUE);
		patiVisitDO.setFg_ip(FBoolean.TRUE);
		patiVisitDO.setDt_acpt(Dt_b);
		patiVisitDO.setId_wg_phy(enDepDTO.getId_wg_phy());
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
	private InpatientDO updateInpatient(EnDepDTO enDepDTO, Bdbed nBedDO) throws BizException {
		String Id_ip = enDepDTO.getId_ip();
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
	private void validate(EnDepDTO enDepDTO) throws BizException{
		if(enDepDTO==null)
			throw new BizException("入科数据不能为空！");
		if (EnParamUtils.getEnIpArrangePhyTp() == IEnConst.NURSE_APPOINT) {
			if(EnValidator.isEmpty(enDepDTO.getId_zr_doc()))
				throw new BizException("主任医师不能为空！");
			if(EnValidator.isEmpty(enDepDTO.getId_zy_doc()))
				throw new BizException("住院医师不能为空！");
		}
		//主任医师和住院医师是否可以相同
		if(!EnParamUtils.isZrZyCanSame()){
			if(!EnValidator.isEmpty(enDepDTO.getId_zr_doc()) && !EnValidator.isEmpty(enDepDTO.getId_zy_doc()) 
					&& enDepDTO.getId_zr_doc().equals(enDepDTO.getId_zy_doc())){
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
	private void invokeIpEnterDeptEvent(EnDepDTO enDepDTO, InpatientDO inpatient) throws BizException {
		this.setDocs(enDepDTO);
		// 1、构造事件源
		EnterDept4EsDTO enterDept4EsDTO = new EnterDept4EsDTO();
		enterDept4EsDTO.setId_ent(enDepDTO.getId_ent());
		enterDept4EsDTO.setId_pat(enDepDTO.getId_pat());
		enterDept4EsDTO.setDt_acpt(enDepDTO.getDt_acpt());
		enterDept4EsDTO.setName_pat(enDepDTO.getName_pat());
		enterDept4EsDTO.setDt_birth_pat(enDepDTO.getDt_birth_pat());
		enterDept4EsDTO.setName_dep_phy(enDepDTO.getName_dep_phy());
		enterDept4EsDTO.setName_bed(enDepDTO.getBed_name());
		enterDept4EsDTO.setSd_emp_zr(enDepDTO.getSd_emp_zr());//主任
		enterDept4EsDTO.setName_emp_zr(enDepDTO.getZr_name());
		enterDept4EsDTO.setSd_emp_doc(enDepDTO.getSd_emp_zy());//住院
		enterDept4EsDTO.setPhy_name(enDepDTO.getZy_name());
		enterDept4EsDTO.setSd_emp_zz(enDepDTO.getSd_emp_zz());//主治 
		enterDept4EsDTO.setName_emp_zz(enDepDTO.getZz_name());
		enterDept4EsDTO.setEvent_source(IEventType.TYPE_INSERT_AFTER);
		enterDept4EsDTO.setId_dep_opr(EnContextUtils.getDeptId());  //操作科室
		enterDept4EsDTO.setId_emp_opr(EnContextUtils.getPsnId());//操作员
		enterDept4EsDTO.setDt_opr(EnAppUtils.getServerDateTime());
		enterDept4EsDTO.setId_dep_nur(enDepDTO.getId_dep_nur());
		enterDept4EsDTO.setSd_emp_ry(inpatient.getCode_emp_phy_op());
		enterDept4EsDTO.setName_emp_ry(inpatient.getName_emp_phy_op());
		enterDept4EsDTO.setFg_newborn(FBoolean.FALSE);
		// 2、触发事件
		IpEnterDeptEvent enterDeptEvent = new IpEnterDeptEvent();
		enterDeptEvent.invoke(enterDept4EsDTO);
	}
	
	
	/**
	 * 触发医护人员修改事件
	 * 
	 * @param enDepDTO
	 * @throws BizException
	 */
	private void invokeChangePsnEvent(EnDepDTO dto) throws BizException {
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

	
	private void setDocs(EnDepDTO enDepDTO) throws BizException{
		List<String> psnIdList = new ArrayList<>();
		psnIdList.add(enDepDTO.getId_zr_doc());
		psnIdList.add(enDepDTO.getId_zz_doc());
		psnIdList.add(enDepDTO.getId_zy_doc());
		PsnDocEP ep = new PsnDocEP();
		Map<String, PsnDocDO> psndocs = ep.getPsnByIdList(psnIdList);
		if(psndocs.containsKey(enDepDTO.getId_zr_doc())){
			PsnDocDO doc = psndocs.get(enDepDTO.getId_zr_doc());
			if(doc != null){
				enDepDTO.setSd_emp_zr(doc.getCode());
				enDepDTO.setZr_name(doc.getName());
			}
		}
		if(psndocs.containsKey(enDepDTO.getId_zz_doc())){
			PsnDocDO doc = psndocs.get(enDepDTO.getId_zz_doc());
			if(doc != null){
				enDepDTO.setSd_emp_zz(doc.getCode());
				enDepDTO.setZz_name(doc.getName());
			}
		}
		if(psndocs.containsKey(enDepDTO.getId_zy_doc())){
			PsnDocDO doc = psndocs.get(enDepDTO.getId_zy_doc());
			if(doc != null){
				enDepDTO.setSd_emp_zy(doc.getCode());
				enDepDTO.setZy_name(doc.getName());				
			}
		}
	}

}
