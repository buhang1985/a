package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IBdBcDictCodeConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeTypeConst;
import iih.bl.cg.i.IBlOutCmdService;
import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.ord.cior.d.OrdApTransDO;
import iih.ci.ord.cior.i.ICiorapptransdeptCudService;
import iih.ci.ord.cior.i.ICiorapptransdeptRService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.en.comm.IEnConst;
import iih.en.comm.ep.BedEP;
import iih.en.comm.ep.EntAuthEP;
import iih.en.comm.ep.EntBedEP;
import iih.en.comm.ep.EntDeptEP;
import iih.en.comm.ep.EntEmpEP;
import iih.en.comm.ep.EntWgEP;
import iih.en.comm.ep.IpEP;
import iih.en.comm.ep.NbEP;
import iih.en.comm.ep.PsnDocEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.ep.UdiDocEP;
import iih.en.comm.evt.EnEvtHandle;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.deptrans.d.EnDepTransDO;
import iih.en.pv.deptrans.d.EnEuTrans;
import iih.en.pv.deptrans.i.IEndeptransCudService;
import iih.en.pv.deptrans.i.IEndeptransRService;
import iih.en.pv.dto.d.EnDepDTO;
import iih.en.pv.dto.d.TransDepPatDTO;
import iih.en.pv.enres.d.EnDepDO;
import iih.en.pv.enres.d.EnMedGrpDO;
import iih.en.pv.enres.d.EnPsnDO;
import iih.en.pv.enres.i.IEnpsnCudService;
import iih.en.pv.inpatient.d.EnIppreDO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.inpatient.dto.d.ChgEmp4EsDTO;
import iih.en.pv.inpatient.dto.d.EnterDept4EsDTO;
import iih.en.pv.inpatient.dto.d.TransDept4EsDTO;
import iih.en.pv.inpatient.i.IEnippreCudService;
import iih.en.pv.inpatient.i.IEnippreRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitCudService;
import iih.en.pv.s.event.IpChgEmpEvent;
import iih.en.pv.s.event.IpEnterDeptEvent;
import iih.en.pv.s.event.IpTransDeptEvent;
import iih.en.pv.s.event.IpTransWardEvent;
import iih.mp.nr.foreign.i.IForeignService;

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
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 转科转入
 * 
 * @author renying
 *
 */
public class CfmTransDepAppBP {
	/**
	 * 当前时间
	 */
	private 	FDateTime curTime;
	/**
	 * 转科转入申请确认
	 * 
	 * @param patDTO
	 *            申请患者
	 * @param endepDTO
	 *            入科信息
	 * @throws BizException
	 */
	public void exec(TransDepPatDTO patDTO, EnDepDTO endepDTO) throws BizException {
		validate(endepDTO);
		validateEnTransStatus(patDTO);
		validataCiStatus(patDTO.getId_or());
		// 得到ent的IDList （带婴儿）
		NbEP nbep = new NbEP();
		NewbornDO[] nbdos = nbep.getNbListByMomEntInHos(patDTO.getId_ent());
		ArrayList<String> arrList = this.getEntIdList(patDTO.getId_ent(), nbdos);
		//界面填写
		if(endepDTO.getDt_acpt() != null)
			curTime = endepDTO.getDt_acpt();
		else
			curTime = EnAppUtils.getServerDateTime();
		// 更新科室信息
		this.updateEntDep(patDTO, endepDTO);
		// 更新就诊医疗组
		this.updateEntWg(patDTO, endepDTO, curTime, arrList);
		if (endepDTO.getFg_pri() != null && endepDTO.getFg_pri().booleanValue()) {
			EntWgEP entWgBp = new EntWgEP();
			entWgBp.setBdWgEntId(endepDTO.getId_wg_phy(), patDTO.getId_ent());
		}
		this.updateEntEmp(patDTO, endepDTO, curTime, arrList);
        if(patDTO.getId_bed() !=null && !patDTO.getId_bed().equals(endepDTO.getId_bed())){//只转病区的时候不用更新床位信息
			// 更新bd床位信息
			this.updateBdBed(patDTO, endepDTO);
			// 更新ent床位
			EntBedEP entbedbp = new EntBedEP();
			entbedbp.changeToBed(patDTO.getId_ent(), endepDTO.getId_bed(), endepDTO.getBed_name(), patDTO.getId_dep_nur(), curTime);
        }
		// 患者就诊
		PatiVisitDO patiVisitDO = this.updatePatvisit(patDTO, endepDTO, arrList);
		// 患者就诊_住院属性
		this.updateEntIp(patDTO, endepDTO, arrList);
		if(patDTO.getFg_ippre()	!= null && patDTO.getFg_ippre().booleanValue()){
			// 更新预住院表
			this.updateEnIppre(patDTO);
		}
		// 更新医嘱状态
		this.updateCiAp(patDTO, endepDTO);
		this.updateMP(patDTO);
		// 更新病案
		this.updateAmr(patDTO, endepDTO, arrList);
		//费用划价
		this.backStageRecord(curTime, patDTO.getId_ent(), nbdos);
		//修改转科记录表
		this.updataDepTrans(patDTO, endepDTO);
		//添加转科就诊事件
		new EnEvtHandle().insertTransDepEvt(patDTO, endepDTO);
		
		//预住院相关处理   发送BS316消息
		if(patDTO.getFg_ippre()!=null && patDTO.getFg_ippre().booleanValue()){
			IpEP ep = new IpEP();
			InpatientDO inpatient = ep.getIpByEntId(patDTO.getId_ent());
			if(inpatient!=null){
				endepDTO.setId_pat(patDTO.getId_pat());
				this.invokeIpEnterDeptEvent(endepDTO, inpatient);
			}
			return;
		}
		
		String[] babyEntId = this.getBabyEntIdList(nbdos);
		PvEP pvEP = new PvEP();
		PatiVisitDO[] BabypatiVisitDOs = pvEP.getPvByIds(babyEntId);
		// 转科不转 病区
		if ((patDTO.getId_dep_nur().equals(patDTO.getOld_dep_nur())) && !(patDTO.getId_dep_phy().equals(patDTO.getOld_dep_phy()))) {
			try {
				this.invokeTransDeptEvent(patDTO, endepDTO,curTime, patiVisitDO, IEnConst.TRANSDEPT);
				invokeBabyTransDeptEvent(patDTO, endepDTO,curTime, BabypatiVisitDOs, IEnConst.TRANSDEPT);
			} catch (Exception ex) {
				Logger.error("转科不转病区消息发送失败：", ex);
			}			
			try {
				this.invokeIpEnterDeptEvent(patDTO);
				invokeBabyIpEnterDeptEvent(babyEntId);
			} catch (Exception e) {
				Logger.error("医护人员修改消息发送失败：", e);
			}
		}

		// 转病区不转科
		else if ((patDTO.getId_dep_phy().equals(patDTO.getOld_dep_phy())) && !(patDTO.getId_dep_nur().equals(patDTO.getOld_dep_nur()))) {
			try {
				this.invokeTransDeptEvent(patDTO, endepDTO,curTime, patiVisitDO, IEnConst.CHGBED);
				invokeBabyTransDeptEvent(patDTO, endepDTO,curTime, BabypatiVisitDOs, IEnConst.CHGBED);
			} catch (Exception ex) {
				Logger.error("转病区不转科消息发送失败：", ex);
			}
			try {
				this.invokeIpEnterDeptEvent(patDTO);
				invokeBabyIpEnterDeptEvent(babyEntId);
			} catch (Exception e) {
				Logger.error("医护人员修改消息发送失败：", e);
			}
		}

		// 既转科又转病区
		else if (!(patDTO.getId_dep_phy().equals(patDTO.getOld_dep_phy())) && !(patDTO.getId_dep_nur().equals(patDTO.getOld_dep_nur()))) {
			try {
				this.invokeTransDeptEvent(patDTO, endepDTO,curTime, patiVisitDO, IEnConst.TRANSDEPT);
				invokeBabyTransDeptEvent(patDTO, endepDTO,curTime, BabypatiVisitDOs, IEnConst.TRANSDEPT);
			} catch (Exception ex) {
				Logger.error("既转科又转病区消息发送失败：", ex);
			}		
			try {
				this.invokeIpEnterDeptEvent(patDTO);
				invokeBabyIpEnterDeptEvent(babyEntId);
			} catch (Exception e) {
				Logger.error("医护人员修改消息发送失败：", e);
			}			
		}
		//转科时处理患者授权
		EntAuthEP mgrbp = new EntAuthEP();
		mgrbp.dealForTransdep(arrList);
		
	}
	
	/**
	 * 预住院患者更新预住院表
	 * @param patDTO
	 * @throws BizException 
	 */
	private void updateEnIppre(TransDepPatDTO patDTO) throws BizException {
		IEnippreRService iRService = ServiceFinder.find(IEnippreRService.class);
		IEnippreCudService iCudService = ServiceFinder.find(IEnippreCudService.class);
		EnIppreDO[] enIppreDOs = iRService.find(" id_ent ='" + patDTO.getId_ent() + "'", "", FBoolean.FALSE);
		if (enIppreDOs != null && enIppreDOs.length>0) {
			enIppreDOs[0].setSd_status(IEnDictCodeConst.SD_STATUS_IPPRE_DEP_ENTER);//3-入科
			enIppreDOs[0].setDt_end_ippre(curTime);//出预住院时间
			enIppreDOs[0].setStatus(DOStatus.UPDATED);
			iCudService.update(enIppreDOs);
		}
		
	}

	/**
	 * 更新bd_bed
	 * 
	 * @param patDTO
	 * @param endepDTO
	 * @throws BizException
	 */
	private void updateBdBed(TransDepPatDTO patDTO, EnDepDTO endepDTO) throws BizException {
		// 床位释放与 床位状态修改
		if (!(patDTO.getId_bed().equals(endepDTO.getId_bed()))) {
			BedEP bedBp = new BedEP();
			if (IEnDictCodeConst.BED_HAS_SEX.equals(EnParamUtils.getBedSexParam(patDTO.getOld_dep_nur()))) {
				bedBp.releaseBedWithSex(patDTO.getId_ent(), patDTO.getId_bed(), FBoolean.FALSE);// 释放占用床位
			}else {
				bedBp.releaseBed(patDTO.getId_ent(), patDTO.getId_bed());// 释放占用床位
			}
			if (IEnDictCodeConst.BED_HAS_SEX.equals(EnParamUtils.getBedSexParam(patDTO.getId_dep_nur()))) {
				bedBp.occupyBedWithSex(endepDTO.getId_bed(), null, endepDTO.getSex_pat().toString(), FBoolean.FALSE,
						IBdResDictCodeConst.SD_BEDSU_USEDBYPATIENT, IBdResDictCodeConst.ID_BEDSU_USEDBYPATIENT);// 占用新床位
			}else {
				bedBp.useBed(endepDTO.getId_bed());// 占用新床位
			}
		}
	}

	/**
	 * 更新部门
	 * 
	 * @param patDTO
	 * @param endepDTO
	 * @throws BizException
	 */
	private void updateEntDep(TransDepPatDTO patDTO, EnDepDTO endepDTO) throws BizException {
		EntDeptEP entResBP = new EntDeptEP();// 就诊资源BP 处理 大部分是那种 在新增时需要修改结束时间的
		// 转科不转 病区
		if ((patDTO.getId_dep_nur().equals(patDTO.getOld_dep_nur())) && !(patDTO.getId_dep_phy().equals(patDTO.getOld_dep_phy()))) {
			addEnDep(patDTO, entResBP, endepDTO, 1);
		}

		// 转病区不转科
		else if ((patDTO.getId_dep_phy().equals(patDTO.getOld_dep_phy())) && !(patDTO.getId_dep_nur().equals(patDTO.getOld_dep_nur()))) {
			addEnDep(patDTO, entResBP, endepDTO, 2);
		}

		// 既转科又转病区
		else if (!(patDTO.getId_dep_phy().equals(patDTO.getOld_dep_phy())) && !(patDTO.getId_dep_nur().equals(patDTO.getOld_dep_nur()))) {
			addEnDep(patDTO, entResBP, endepDTO, 1);
			addEnDep(patDTO, entResBP, endepDTO, 2);
		}
	}

	/**
	 * 对EnDepDO实体 更新操作进行封装
	 * 
	 * @param patDTO
	 *            转科患者DTO
	 * @param entResBP
	 * @param depDTO
	 *            住院入科DTO
	 * @param stat
	 *            判断是科室 还是病情 1： 科室 2： 病区
	 * @throws BizException
	 */
	private void addEnDep(TransDepPatDTO patDTO, EntDeptEP entdeptBP, EnDepDTO depDTO, int stat) throws BizException {

		UdiDocEP docep = new UdiDocEP();
		Map<String,UdidocDO> map = docep.getUdiDocsByCode(IEnDictCodeTypeConst.SD_DEP_ROLE);
		EnDepDO depDO = new EnDepDO();
		// 就诊id
		depDO.setId_ent(patDTO.getId_ent());

		if (stat == 1) {
			depDO.setId_dep(patDTO.getId_dep_phy());// 科室
			depDO.setSd_entdeprole(IEnDictCodeConst.SD_ENTDEPROLE_DEP);// 角色编码
																		// 科室
			depDO.setId_dep_from(patDTO.getOld_dep_phy()); // 来源科室
			if(map!=null){
				depDO.setId_entdeprole(map.get(IEnDictCodeConst.SD_ENTDEPROLE_DEP)== null ?null: map.get(IEnDictCodeConst.SD_ENTDEPROLE_DEP).getId_udidoc());
			}
		} else if (stat == 2) {
			depDO.setId_dep(patDTO.getId_dep_nur());// 病区
			depDO.setSd_entdeprole(IEnDictCodeConst.SD_ENTDEPROLE_IA);// 角色编码 病区
			depDO.setId_dep_from(patDTO.getOld_dep_nur());// 来源病区
			if(map!=null){
				depDO.setId_entdeprole(map.get(IEnDictCodeConst.SD_ENTDEPROLE_IA)== null ?null: map.get(IEnDictCodeConst.SD_ENTDEPROLE_IA).getId_udidoc());
			}
		}
		depDO.setDt_b(curTime); // 开始时间
		depDO.setFg_admit(FBoolean.FALSE); // 入院标识
		depDO.setFg_discharge(FBoolean.FALSE); // 出院标识
		depDO.setDt_dcg_bill(curTime); // 收费最近日期
		depDO.setSd_status(IEnDictCodeConst.SD_ENTDEP_STATUS_SUC); // 状态
		if(patDTO.getFg_ippre() != null && patDTO.getFg_ippre().booleanValue()){//预住院相关处理
			depDO.setFg_admit(FBoolean.TRUE);
			depDO.setFg_ippre(FBoolean.TRUE);
		}
		depDO.setStatus(DOStatus.NEW);

		entdeptBP.changeDep(depDO, patDTO, FBoolean.FALSE, curTime);
	}

	/**
	 * 更新医疗组
	 * 
	 * @param patDTO
	 * @param endepDTO
	 * @param curTime
	 * @throws BizException
	 */
	private void updateEntWg(TransDepPatDTO patDTO, EnDepDTO endepDTO, FDateTime curTime, ArrayList<String> entList) throws BizException {
		EntWgEP entwgBp = new EntWgEP();

		if (EnValidator.isEmpty(entList))
			return;
		EnMedGrpDO[] enMedGrpDOs = entwgBp.CreatNewWGs(entList, endepDTO.getId_wg_phy(), curTime, endepDTO.getFg_pri());
		entwgBp.changeMedGrp(enMedGrpDOs, curTime);
	}

	/**
	 * 插入数据到en_ent_emp
	 * 
	 * @param enDepDTO
	 * @param Dt_b
	 * @throws BizException
	 */
	private void updateEntEmp(TransDepPatDTO patDTO, EnDepDTO enDepDTO, FDateTime Dt_b, List<String> entIdlist) throws BizException {
		EntEmpEP entEmp = new EntEmpEP();
		entEmp.endOldEmp(entIdlist, null, Dt_b);
		ArrayList<EnPsnDO> entEmpList = new ArrayList<EnPsnDO>();
		for (String entId : entIdlist) {
			// 主治大夫
			EnPsnDO empDoc = entEmp.createEmp(entId, enDepDTO.getId_emp_phy(), IEnDictCodeConst.ID_EMPROLE_DOCTOR, IEnDictCodeConst.SD_EMPROLE_DOCTOR, Dt_b);
			entEmpList.add(empDoc);
			// 责任护士
			EnPsnDO empNur = entEmp.createEmp(entId, enDepDTO.getId_emp_nur(), IEnDictCodeConst.ID_EMPROLE_NURSE, IEnDictCodeConst.SD_EMPROLE_NURSE, Dt_b);
			entEmpList.add(empNur);
			// 主任医师
			EnPsnDO empZR = entEmp.createEmp(entId, enDepDTO.getId_zr_doc(), IEnDictCodeConst.ID_EMPROLE_ZRDOC, IEnDictCodeConst.SD_EMPROLE_ZRDOC, Dt_b);
			entEmpList.add(empZR);
			// 主治医师
			EnPsnDO empZZ = entEmp.createEmp(entId, enDepDTO.getId_zz_doc(), IEnDictCodeConst.ID_EMPROLE_ZZDOC, IEnDictCodeConst.SD_EMPROLE_ZZDOC, Dt_b);
			entEmpList.add(empZZ);
			// 住院医师
			EnPsnDO empZY = entEmp.createEmp(entId, enDepDTO.getId_zy_doc(), IEnDictCodeConst.ID_EMPROLE_ZYDOC, IEnDictCodeConst.SD_EMPROLE_ZYDOC, Dt_b);
			entEmpList.add(empZY);
		}
		IEnpsnCudService enpsnService = ServiceFinder.find(IEnpsnCudService.class);
		enpsnService.insert(entEmpList.toArray(new EnPsnDO[] {}));
	}

	/**
	 * 更新就诊表信息
	 * 
	 * @param patDTO
	 * @param endepDTO
	 * @throws BizException
	 */
	private PatiVisitDO updatePatvisit(TransDepPatDTO patDTO, EnDepDTO endepDTO, List<String> entIdList) throws BizException {
		IPativisitCudService iPativisitCudService = ServiceFinder.find(IPativisitCudService.class);
		PvEP pvep = new PvEP();
		PatiVisitDO[] pativisits = pvep.getPVs(entIdList);
		for (PatiVisitDO patiVisitDO : pativisits) {
			patiVisitDO.setId_dep_phy(patDTO.getId_dep_phy());
			patiVisitDO.setId_dep_nur(patDTO.getId_dep_nur());
			patiVisitDO.setId_wg_phy(endepDTO.getId_wg_phy());
			patiVisitDO.setId_emp_phy(endepDTO.getId_emp_phy());
			patiVisitDO.setId_emp_nur(endepDTO.getId_emp_nur());
			if(patiVisitDO.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE)){//预住院相关处理
				patiVisitDO.setId_entp(IBdFcDictCodeConst.ID_CODE_ENTP_IP);
				patiVisitDO.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
				patiVisitDO.setDt_acpt(curTime);
			}
			patiVisitDO.setStatus(DOStatus.UPDATED);
		}
		return iPativisitCudService.save(pativisits)[0];
	}

	/**
	 * 更新住院表信息
	 * 
	 * @param patDTO
	 * @param endepDTO
	 * @throws BizException
	 */
	private void updateEntIp(TransDepPatDTO patDTO, EnDepDTO endepDTO, List<String> entIdList) throws BizException {
		IpEP ep = new IpEP();
		InpatientDO[] inpatientDOs = ep.getInpatientDOs(entIdList);
		if (!EnValidator.isEmpty(inpatientDOs)) {
			for (InpatientDO ipdo : inpatientDOs) {
				ipdo.setId_bed(endepDTO.getId_bed());
				ipdo.setName_bed(endepDTO.getBed_name());
				if(ipdo.getFg_ippre()!=null && ipdo.getFg_ippre().booleanValue()){//预住院相关处理
					ipdo.setFg_ippre(FBoolean.FALSE);
				}
				ipdo.setStatus(DOStatus.UPDATED);
			}
		}
		ep.save(inpatientDOs);
	}

	/**
	 * 更新ciaptrans的信息
	 * 
	 * @param patDTO
	 * @param endepDTO
	 * @throws BizException
	 */
	private void updateCiAp(TransDepPatDTO patDTO, EnDepDTO endepDTO) throws BizException {
		ICiorapptransdeptRService apTransDepService = ServiceFinder.find(ICiorapptransdeptRService.class);
		ICiorapptransdeptCudService OrdTransCudService = ServiceFinder.find(ICiorapptransdeptCudService.class);

		OrdApTransDO[] ordApTransDOArr = apTransDepService.find("id_or='" + patDTO.getId_or() + "'", "", FBoolean.FALSE);
		if (ordApTransDOArr != null && ordApTransDOArr.length != 0) {
			OrdApTransDO ordTranDO = ordApTransDOArr[0];
			ordTranDO.setSd_su_trans(ICiDictCodeConst.SD_CI_TRANS_YJSWC);
			ordTranDO.setId_su_trans(ICiDictCodeConst.ID_CI_TRANS_YJSWC);
			OrdTransCudService.update(new OrdApTransDO[] { ordTranDO });
		}
	}

	/**
	 * 更新执行域
	 * 
	 * @param appDTO
	 * @throws BizException
	 */
	private void updateMP(TransDepPatDTO patDTO) throws BizException {
		if(EnValidator.isEmpty(patDTO.getId_or()))
			return;
		IForeignService fordignRServoce = ServiceFinder.find(IForeignService.class);
		fordignRServoce.UpdateOrderStatus(new String[] { patDTO.getId_or() });
	}

	/**
	 * 更新病例的信息
	 * 
	 * @param patDTO
	 * @param endepDTO
	 * @throws BizException
	 */
	private void updateAmr(TransDepPatDTO patDTO, EnDepDTO endepDTO, ArrayList<String> entIdList) throws BizException {
		AmrBP amrBp = new AmrBP();
		AMrDO[] amrdos = amrBp.getAmrDO(entIdList);
		if (!EnValidator.isEmpty(amrdos)) {
			for (AMrDO amrdo : amrdos) {
				amrdo.setStatus(DOStatus.UPDATED);
				amrdo.setId_treat_doctor(endepDTO.getId_emp_phy());
				amrdo.setId_mast_doctor(endepDTO.getId_zz_doc());
				amrdo.setId_dir_doctor(endepDTO.getId_zr_doc());
				amrdo.setId_dep_nuradm(patDTO.getId_dep_nur());
				amrdo.setId_bed(endepDTO.getId_bed());
				amrdo.setId_dep_cur(patDTO.getId_dep_phy());
			}
			amrBp.saveAmr(amrdos);
		}
	}

	/**
	 * 发送转科事件
	 * @param patDTO
	 * @param endepDTO
	 * @throws BizException
	 */
	private void invokeTransDeptEvent(TransDepPatDTO patDTO, EnDepDTO endepDTO, FDateTime curTime, PatiVisitDO entDo, String orderTypeCode) throws BizException {
		TransDept4EsDTO enDTO = new TransDept4EsDTO();
		enDTO.setOrder_type_code(orderTypeCode);
		enDTO.setId_ent(patDTO.getId_ent());
		enDTO.setCode_pat(entDo.getCode_pat());
		enDTO.setCode_ent(entDo.getCode());
		enDTO.setCode_enttp(entDo.getCode_entp());
		enDTO.setName_enttp(entDo.getName_entp());
		enDTO.setId_pat(patDTO.getId_pat());
		enDTO.setSd_sex_pat(patDTO.getSd_sex_pat());
		enDTO.setCode_amr_ip(patDTO.getCode_amr_ip());
		enDTO.setTransinto_time(curTime);
		enDTO.setName_pat(patDTO.getName_pat());
		enDTO.setDt_birth(patDTO.getDt_birth_pat());
		enDTO.setOld_dep_nur_name(patDTO.getOld_dep_nur_name());
		enDTO.setOld_sd_dep_nur(patDTO.getOld_sd_dep_nur());
		enDTO.setOld_dep_phy_name(patDTO.getOld_dep_phy_name());
		enDTO.setOld_sd_dep_phy(patDTO.getOld_sd_dep_phy());

		enDTO.setSd_dep_nur(patDTO.getSd_dep_nur());
		enDTO.setName_dep_nur(patDTO.getName_dep_nur());
		enDTO.setName_dep_phy(patDTO.getName_dep_phy());
		enDTO.setSd_dep_phy(patDTO.getSd_dep_phy());

		enDTO.setOld_bedname(patDTO.getName_bed());

		enDTO.setNew_bedname(endepDTO.getBed_name());
		enDTO.setCi_code(patDTO.getCi_code());

		enDTO.setSd_emp_nur(endepDTO.getSd_emp_nur());
		enDTO.setName_emp_nur(endepDTO.getNur_name());
		enDTO.setId_or(patDTO.getId_or());
		enDTO.setId_dep_nur(patDTO.getId_dep_nur());
		enDTO.setId_emp_opr(EnContextUtils.getPsnId());//操作员
		enDTO.setId_dep_opr(EnContextUtils.getDeptId());  //操作科室
		enDTO.setDt_opr(curTime); //操作时间
		IpTransDeptEvent ipTransDeptEvent = new IpTransDeptEvent();
		ipTransDeptEvent.invoke(enDTO);
	}
	
	/**
	 * 发送转科事件 baby   0147306
	 * @param patDTO
	 * @param endepDTO
	 * @throws BizException
	 */
	private void invokeBabyTransDeptEvent(TransDepPatDTO patDTO, EnDepDTO endepDTO, FDateTime curTime, PatiVisitDO[] entDos, String orderTypeCode) throws BizException {
		if(null == entDos || EnValidator.isEmpty(entDos)){
			return;
		}
		for(PatiVisitDO entDo : entDos){
			TransDept4EsDTO enDTO = new TransDept4EsDTO();
			enDTO.setOrder_type_code(orderTypeCode);
			enDTO.setId_ent(entDo.getId_ent());
			enDTO.setCode_pat(entDo.getCode_pat());
			enDTO.setCode_ent(entDo.getCode());
			enDTO.setCode_enttp(entDo.getCode_entp());
			enDTO.setName_enttp(entDo.getName_entp());
			enDTO.setId_pat(entDo.getId_pat());
			enDTO.setSd_sex_pat(entDo.getSd_sex_pat());
			IpEP ipEP = new IpEP();
			InpatientDO inpatientDO = ipEP.getIpDOsInHos(entDo.getId_ent())[0];
			enDTO.setCode_amr_ip(inpatientDO.getCode_amr_ip());
			enDTO.setTransinto_time(curTime);
			enDTO.setName_pat(entDo.getName_pat());
			enDTO.setDt_birth(entDo.getDt_birth_pat());
			enDTO.setOld_dep_nur_name(patDTO.getOld_dep_nur_name());
			enDTO.setOld_sd_dep_nur(patDTO.getOld_sd_dep_nur());
			enDTO.setOld_dep_phy_name(patDTO.getOld_dep_phy_name());
			enDTO.setOld_sd_dep_phy(patDTO.getOld_sd_dep_phy());

			enDTO.setSd_dep_nur(patDTO.getSd_dep_nur());
			enDTO.setName_dep_nur(patDTO.getName_dep_nur());
			enDTO.setName_dep_phy(patDTO.getName_dep_phy());
			enDTO.setSd_dep_phy(patDTO.getSd_dep_phy());

			enDTO.setOld_bedname(patDTO.getName_bed());

			enDTO.setNew_bedname(endepDTO.getBed_name());
			enDTO.setCi_code(patDTO.getCi_code());

			enDTO.setSd_emp_nur(endepDTO.getSd_emp_nur());
			enDTO.setName_emp_nur(endepDTO.getNur_name());
			enDTO.setId_or(patDTO.getId_or());
			enDTO.setId_dep_nur(patDTO.getId_dep_nur());
			enDTO.setId_emp_opr(EnContextUtils.getPsnId());//操作员
			enDTO.setId_dep_opr(EnContextUtils.getDeptId());  //操作科室
			enDTO.setDt_opr(curTime); //操作时间
			IpTransDeptEvent ipTransDeptEvent = new IpTransDeptEvent();
			ipTransDeptEvent.invoke(enDTO);
		}
	}

	/**
	 * 发送转病区事件
	 * @param patDTO
	 * @param endepDTO
	 * @throws BizException
	 */
	private void invokeTransWardEvent(TransDepPatDTO patDTO, EnDepDTO endepDTO, FDateTime curTime) throws BizException {
		TransDept4EsDTO enDTO = new TransDept4EsDTO();
		enDTO.setId_ent(patDTO.getId_ent());
		enDTO.setId_pat(patDTO.getId_pat());
		enDTO.setCode_amr_ip(patDTO.getCode_amr_ip());
		enDTO.setTransinto_time(curTime);
		enDTO.setName_pat(patDTO.getName_pat());
		//enDTO.setDt_birth(patDTO.getDt_birth_pat());
		enDTO.setOld_dep_nur_name(patDTO.getOld_dep_nur_name());
		enDTO.setOld_sd_dep_nur(patDTO.getOld_sd_dep_nur());
		enDTO.setOld_dep_phy_name(patDTO.getOld_dep_phy_name());
		enDTO.setOld_sd_dep_phy(patDTO.getOld_sd_dep_phy());

		enDTO.setSd_dep_nur(patDTO.getSd_dep_nur());
		enDTO.setName_dep_nur(patDTO.getName_dep_nur());
		enDTO.setName_dep_phy(patDTO.getName_dep_phy());
		enDTO.setSd_dep_phy(patDTO.getSd_dep_phy());

		enDTO.setOld_bedname(patDTO.getName_bed());

		enDTO.setNew_bedname(endepDTO.getBed_name());
		enDTO.setCi_code(patDTO.getCi_code());
		enDTO.setEvent_source(IEventType.TYPE_INSERT_AFTER);
		enDTO.setId_dep_opr(EnContextUtils.getDeptId());  //操作科室
		enDTO.setId_emp_opr(EnContextUtils.getPsnId());//操作员
	    enDTO.setDt_opr(this.curTime);
		enDTO.setId_or(patDTO.getId_or());
		enDTO.setId_dep_nur(patDTO.getId_dep_nur());
		IpTransWardEvent ipTransDeptEvent = new IpTransWardEvent();
		ipTransDeptEvent.invoke(enDTO);
	}
	/**
	 * 校验医嘱状态是否发生变化
	 * @param orderId
	 * @throws BizException
	 */
	private void validataCiStatus(String orderId) throws BizException{
		if(EnValidator.isEmpty(orderId)){
			return;
		}
		ICiorderMDORService rService = ServiceFinder.find(ICiorderMDORService.class);
		CiOrderDO ciorder =	rService.findById(orderId);
		if(ciorder == null)
			throw new BizException("未获取到医嘱ID对应的医嘱");
		if((!ICiDictCodeConst.SD_SU_CHECKTHROUGH.equals(ciorder.getSd_su_or()))&&(!ICiDictCodeConst.SD_SU_CHECKSTOP.equals(ciorder.getSd_su_or()))){
			throw new BizException("医嘱状态发生改变，请重新申请转科");
		}
		
	}
	
	/**
	 * 校验转科记录表状态
	 * 
	 * @param transDepPatDTO
	 * @throws BizException
	 */
	private void validateEnTransStatus(TransDepPatDTO transDepPatDTO) throws BizException{
		
		IEndeptransRService rService = ServiceFinder.find(IEndeptransRService.class);
		EnDepTransDO enDepTransDO = rService.findById(transDepPatDTO.getId_dep_trans());
		
		if (enDepTransDO == null || !EnEuTrans.APPLY.equals(enDepTransDO.getEu_trans())) {
			throw new BizException("患者状态发生变化，请刷新后重试！");
		}
	}
	
	/**
	 * 校验数据
	 * @param endepDTO
	 * @throws BizException
	 */
	private void validate(EnDepDTO endepDTO) throws BizException{
		if(endepDTO==null){
			throw new BizException("转科入科的数据不能为空！");
		}
		//主任医师和住院医师是否可以相同
		if(!EnParamUtils.isZrZyCanSame()){
			if(!EnValidator.isEmpty(endepDTO.getId_zr_doc()) && !EnValidator.isEmpty(endepDTO.getId_zy_doc()) 
					&& endepDTO.getId_zr_doc().equals(endepDTO.getId_zy_doc())){
				throw new BizException("主任医师与住院医师不能相同！");
			}
		}
	}
	
	/**
	 * 触发事件
	 * 
	 * @param enDepDTO
	 * @throws BizException
	 */
	private void invokeIpEnterDeptEvent(TransDepPatDTO  dto) throws BizException {
		// 1、构造事件源
		ChgEmp4EsDTO esDTO = new ChgEmp4EsDTO();
		esDTO.setId_ent( dto.getId_ent());
		esDTO.setEvent_source(IEventType.TYPE_INSERT_AFTER);
		esDTO.setId_dep_opr(EnContextUtils.getDeptId());  //操作科室
		esDTO.setId_emp_opr(EnContextUtils.getPsnId());//操作员
		esDTO.setDt_opr(this.curTime);
		
		// 2、触发事件
		IpChgEmpEvent enterDeptEvent = new IpChgEmpEvent();
		enterDeptEvent.invoke(esDTO);
	}
	/**
	 * 触发事件
	 * 
	 * @param enDepDTO
	 * @throws BizException
	 */
	private void invokeBabyIpEnterDeptEvent(String[] babyEntIds) throws BizException {
		if(null == babyEntIds || EnValidator.isEmpty(babyEntIds)){
			return;
		}
		for(String idEnt:babyEntIds){
			// 1、构造事件源
			ChgEmp4EsDTO esDTO = new ChgEmp4EsDTO();
			esDTO.setId_ent(idEnt);
			esDTO.setEvent_source(IEventType.TYPE_INSERT_AFTER);
			esDTO.setId_dep_opr(EnContextUtils.getDeptId());  //操作科室
			esDTO.setId_emp_opr(EnContextUtils.getPsnId());//操作员
			esDTO.setDt_opr(this.curTime);
			
			// 2、触发事件
			IpChgEmpEvent enterDeptEvent = new IpChgEmpEvent();
			enterDeptEvent.invoke(esDTO);
		}
	}
	/**
	 * 1、调用费用接口，划价
	 * 
	 * @param dt_e
	 * @param id_pat
	 * @throws BizException
	 */
	private void backStageRecord(FDateTime dt_e, String id_ent, NewbornDO[] nbdos) throws BizException {
		IBlOutCmdService blCgService = ServiceFinder.find(IBlOutCmdService.class);
		blCgService.chargeTurnDeptByEntId(id_ent, dt_e);
		if(EnValidator.isEmpty(nbdos))
			return;
		for(NewbornDO nbdo : nbdos)
			blCgService.chargeTurnDeptByEntId(nbdo.getId_ent_bb(), dt_e);
	}
	/**
	 * 获取就诊id（带婴儿）的list
	 * 
	 * @param patDTO
	 * @return
	 * @throws BizException
	 */
	private ArrayList<String> getEntIdList(String entId, NewbornDO[] nbdos) throws BizException {
		if (EnValidator.isEmpty(entId))
			return null;
		ArrayList<String> entIdList = new ArrayList<String>();
		entIdList.add(entId);
		if (EnValidator.isEmpty(nbdos))
			return entIdList;
		for (NewbornDO nbDO : nbdos) {
			if(!nbDO.getFg_sepa().booleanValue())
			entIdList.add(nbDO.getId_ent_bb());
		}
		return entIdList;
	}
	
	private String[] getBabyEntIdList(NewbornDO[] nbdos) throws BizException {
		ArrayList<String> entIdList = new ArrayList<String>();
		if (EnValidator.isEmpty(nbdos))
			return null;
		for (NewbornDO nbDO : nbdos) {
			entIdList.add(nbDO.getId_ent_bb());
		}
		return entIdList.toArray(new String[entIdList.size()]);
	}
	
	/**
	 * 修改就诊入科记录
	 * 
	 * @throws BizException 
	 */
	private void updataDepTrans(TransDepPatDTO patDTO, EnDepDTO endepDTO) throws BizException {
	    IEndeptransCudService  cudService = ServiceFinder.find(IEndeptransCudService.class);
	    IEndeptransRService RService  = ServiceFinder.find(IEndeptransRService.class);
	    String whereStr = "id_ent = '" +patDTO.getId_ent()+"' AND Eu_trans ='"+EnEuTrans.APPLY + "' ";
	    if(!EnValidator.isEmpty(patDTO.getId_or()))
	    	whereStr += " AND Id_or = '" + patDTO.getId_or() +"'";
	    EnDepTransDO[] find = RService.find(whereStr, "SV", FBoolean.FALSE);
	    if (!EnValidator.isEmpty(find)) {
	        EnDepTransDO seldo = find[0];
	        seldo.setEu_trans(EnEuTrans.ACPT);
	        seldo.setId_bed_to(endepDTO.getId_bed());
            //接收操作人
	        seldo.setId_emp_acpt(EnContextUtils.getPsnId());
	        seldo.setDt_acpt(new FDateTime());
	        seldo.setStatus(DOStatus.UPDATED);
            cudService.update(new EnDepTransDO[] {seldo});
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
		enterDept4EsDTO.setId_ent(inpatient.getId_ent());
		enterDept4EsDTO.setId_pat(enDepDTO.getId_pat());
		FDateTime curTime = EnAppUtils.getServerDateTime();
		if(EnValidator.isEmpty(enDepDTO.getDt_acpt())){
			enterDept4EsDTO.setDt_acpt(curTime);
		}else{
			enterDept4EsDTO.setDt_acpt(enDepDTO.getDt_acpt());
		}
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
		enterDept4EsDTO.setDt_opr(curTime);
		enterDept4EsDTO.setId_dep_nur(enDepDTO.getId_dep_nur());
		enterDept4EsDTO.setSd_emp_ry(inpatient.getCode_emp_phy_op());
		enterDept4EsDTO.setName_emp_ry(inpatient.getName_emp_phy_op());
		enterDept4EsDTO.setCode(IEnConst.UPDATE);//预住院发送的入科消息类型为update
		enterDept4EsDTO.setFg_newborn(FBoolean.FALSE);
		// 2、触发事件
		IpEnterDeptEvent enterDeptEvent = new IpEnterDeptEvent();
		enterDeptEvent.invoke(enterDept4EsDTO);
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
