package iih.en.pv.s.bp.ippre;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeTypeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.en.comm.IEnConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.evt.EnEvtHandle;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.deptrans.d.EnDepTransDO;
import iih.en.pv.deptrans.d.EnEuTrans;
import iih.en.pv.deptrans.i.IEndeptransCudService;
import iih.en.pv.deptrans.i.IEndeptransRService;
import iih.en.pv.enres.d.EnDepDO;
import iih.en.pv.enres.d.EnMedGrpDO;
import iih.en.pv.enres.d.EnPsnDO;
import iih.en.pv.enres.i.IEndepCudService;
import iih.en.pv.enres.i.IEndepRService;
import iih.en.pv.enres.i.IEnpsnCudService;
import iih.en.pv.inpatient.d.EnIppreDO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.inpatient.dto.d.ChgEmp4EsDTO;
import iih.en.pv.inpatient.dto.d.EnIppreTransHosDTO;
import iih.en.pv.inpatient.dto.d.EnterDept4EsDTO;
import iih.en.pv.inpatient.dto.d.TransDept4EsDTO;
import iih.en.pv.inpatient.i.IEnippreCudService;
import iih.en.pv.inpatient.i.IEnippreRService;
import iih.en.pv.inpatient.i.IInpatientCudService;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitCudService;
import iih.en.pv.s.bp.ip.SaveEnPsnBP;
import iih.en.pv.s.event.IpChgEmpEvent;
import iih.en.pv.s.event.IpEnterDeptEvent;
import iih.en.pv.s.event.IpTransDeptEvent;
import iih.en.comm.ep.BedEP;
import iih.en.comm.ep.EntBedEP;
import iih.en.comm.ep.EntEmpEP;
import iih.en.comm.ep.EntWgEP;
import iih.en.comm.ep.IpEP;
import iih.en.comm.ep.NbEP;
import iih.en.comm.ep.PsnDocEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.ep.UdiDocEP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.xbd.udi.d.UdidocDO;

/***
 * 预住院转住院BP
 * @author zhangpp
 *
 */
public class IppreTransHosBP {

	/**
	 * 当前时间
	 */
	private FDateTime curTime;
	
	private boolean ippreTransMethod;
	
	public void exec(EnIppreTransHosDTO ippreTransHos) throws BizException{
		//校验床位信息
		validateBed(ippreTransHos);
		//校验医疗组
		validateDoc(ippreTransHos);
		ippreTransMethod = EnParamUtils.getIppreTransMethod();//判断是不是先转出再转入
		//获取患者的entIdList（带婴儿）
		NbEP nbep = new NbEP();
		NewbornDO[] nbdos = nbep.getNbListByMomEntInHos(ippreTransHos.getId_ent());
		ArrayList<String> arrList = this.getEntIdList(ippreTransHos.getId_ent(), nbdos);
		//设置统一时间
	    curTime = EnAppUtils.getServerDateTime();
	    
	    //------------处理先转出再转入ENIP0300=1-------------
		if(ippreTransMethod){
		//这里处理转出逻辑
		//1.转出核查(在前端完成)
		//this.checkTrans(ippreTransHos);
		//2.转出
		//2.1修改预住院表
		this.updateEnIppre(arrList);
		//2.2保存转科表
		this.saveDepTrans(ippreTransHos);
			return;
		}
		
		//------------处理直接转入ENIP0300=0----------------
	    //更新bd床位信息及ent床位信息
	  	this.updateBdBed(ippreTransHos);
	  	this.saveDepTrans(ippreTransHos);
		//更新科室信息
		this.updateEntDep(ippreTransHos);
		//更新就诊医疗组
		this.updateEntWg(ippreTransHos, arrList);
		//如果是专用医疗组
		/*if (endepDTO.getFg_pri() != null && endepDTO.getFg_pri().booleanValue()) {
			EntWgEP entWgBp = new EntWgEP();
			entWgBp.setBdWgEntId(endepDTO.getId_wg_phy(), patDTO.getId_ent());
		}*/
		//插入数据到en_ent_emp
		this.updateEntEmp(ippreTransHos, arrList);
	    //更新就诊表
	  	PatiVisitDO patiVisitDO = this.updatePatvisit(ippreTransHos, arrList);
	  	ippreTransHos.setId_pat(patiVisitDO.getId_pat());
		//更新住院表
		this.updateEntIp(ippreTransHos, arrList);
		//更新预住院表
		this.updateEnIppre(arrList);
		//更新医嘱状态
		//this.updateCiAp(patDTO, endepDTO);
		//更新执行域
		//this.updateMP(patDTO);
		//更新病案
		//this.updateAmr(patDTO, endepDTO, arrList);
		//费用划价
		//this.backStageRecord(curTime, patDTO.getId_pat(), nbdos);
		//修改转科记录表
		//FDateTime dtActp = this.updataDepTrans(ippreTransHos);
		
		
		IpEP ep = new IpEP();
		InpatientDO inpatient = ep.getIpByEntId(ippreTransHos.getId_ent());
		if(inpatient!=null){
			//发送BS316消息
			this.invokeIpEnterDeptEvent(ippreTransHos, inpatient);
		}
		//发送事件
		//this.invokeIppreEnterDepEvent();
		//添加预住院转住院就诊事件
		new EnEvtHandle().insertTransHosEvt(ippreTransHos, curTime);
		////发送消息
		
		// 转科不转病区
		if ((ippreTransHos.getId_dep_nur().equals(ippreTransHos.getId_ippre_nur())) && !(ippreTransHos.getId_dep_phy().equals(ippreTransHos.getId_ippre_phy()))) {
			try {
				this.invokeTransDeptEvent(ippreTransHos,curTime, patiVisitDO, IEnConst.TRANSDEPT);
			} catch (Exception ex) {
				Logger.error("转科不转病区消息发送失败：", ex);
			}			
			try {
				this.invokeIpEnterDeptEvent(ippreTransHos);
			} catch (Exception e) {
				Logger.error("医护人员修改消息发送失败：", e);
			}
		}
		// 转病区不转科
		else if ((ippreTransHos.getId_dep_phy().equals(ippreTransHos.getId_ippre_phy())) && !(ippreTransHos.getId_dep_nur().equals(ippreTransHos.getId_ippre_nur()))) {
			try {
				this.invokeTransDeptEvent(ippreTransHos,curTime, patiVisitDO, IEnConst.CHGBED);
			} catch (Exception ex) {
				Logger.error("转病区不转科消息发送失败：", ex);
			}
			try {
				this.invokeIpEnterDeptEvent(ippreTransHos);
			} catch (Exception e) {
				Logger.error("医护人员修改消息发送失败：", e);
			}
		}
		// 既转科又转病区
		else if (!(ippreTransHos.getId_dep_phy().equals(ippreTransHos.getId_ippre_phy())) && !(ippreTransHos.getId_dep_nur().equals(ippreTransHos.getId_ippre_nur()))) {
			try {
				this.invokeTransDeptEvent(ippreTransHos,curTime, patiVisitDO, IEnConst.TRANSDEPT);
			} catch (Exception ex) {
				Logger.error("既转科又转病区消息发送失败：", ex);
			}		
			try {
				this.invokeIpEnterDeptEvent(ippreTransHos);
			} catch (Exception e) {
				Logger.error("医护人员修改消息发送失败：", e);
			}			
		}
		
		//转科时处理患者授权
		/*EnAuthMgrBp mgrbp = new EnAuthMgrBp();
		mgrbp.dealForTransdep(arrList);
		//用webservice调用his接口  lilei
		if(EnParamUtils.getIsSysEnInfoToHis()){
			EnSycnInfo4JsrmhBp enSycnInfo4JsrmhBp = new EnSycnInfo4JsrmhBp();
			PvEP ep = new PvEP();
			PatiVisitDO pvDo = ep.getPvById(patDTO.getId_ent());
			pvDo.setDt_acpt(dtActp);//用这个来传一下转科中转入时间
			IpEP ipep = new IpEP();
			InpatientDO[] inpatientDOs = ipep.getIpDOByEntId(pvDo.getId_ent());
			InpatientDO ido = new InpatientDO();
			if(!ArrayUtil.isEmpty(inpatientDOs)){
			ido = inpatientDOs[0];
			}
			enSycnInfo4JsrmhBp.orgChangeInfo(pvDo, ido,IEnDictCodeConst.SD_HIS_EVTTYPE_TRANSDEP);
		}*/
		
	}
	
	
	/**
	 * 发送消息
	 * @throws BizException 
	 */
	private void invokeIppreEnterDepEvent() throws BizException {
		String event = "042";
		EnIppreTransHosDTO dto = new EnIppreTransHosDTO();
		BusinessEvent opRegEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_IP_ENT, event,dto);
		Logger.info("发送通用队列事件: "+event+";发送数据：" + dto);
		EventDispatcher.fireEvent(opRegEvent); 	
	}



	/**
	 * 更新bd_bed
	 * 
	 * @param ippreTransHos
	 * @throws BizException
	 */
	private void updateBdBed(EnIppreTransHosDTO ippreTransHos) throws BizException {
		// 床位释放与 床位状态修改
		if (!(ippreTransHos.getId_bed().equals(ippreTransHos.getId_bed_old()))) {
			BedEP bedBp = new BedEP();
			if (IEnDictCodeConst.BED_HAS_SEX.equals(EnParamUtils.getBedSexParam(ippreTransHos.getId_dep_nur()))) {
				bedBp.releaseBedWithSex(ippreTransHos.getId_ent(), ippreTransHos.getId_bed_old(), FBoolean.FALSE);// 释放占用床位
			}else {
				bedBp.releaseBed(ippreTransHos.getId_ent(), ippreTransHos.getId_bed_old());// 释放占用床位
			}
			if (IEnDictCodeConst.BED_HAS_SEX.equals(EnParamUtils.getBedSexParam(ippreTransHos.getId_ippre_nur()))) {
				bedBp.occupyBedWithSex(ippreTransHos.getId_bed(), null, ippreTransHos.getSd_sex_pat(), FBoolean.FALSE,
						IBdResDictCodeConst.SD_BEDSU_USEDBYPATIENT, IBdResDictCodeConst.ID_BEDSU_USEDBYPATIENT);// 占用新床位
			}else {
				bedBp.useBed(ippreTransHos.getId_bed());// 占用新床位
			}
		}
		
		// 更新ent床位
		EntBedEP entbedbp = new EntBedEP();
		entbedbp.changeToBed(ippreTransHos.getId_ent(), ippreTransHos.getId_bed(), ippreTransHos.getName_bed(), ippreTransHos.getId_ippre_nur(), curTime);
				
	}

	/**
	 * 更新部门
	 * 
	 * @param ippreTransHos
	 * @throws BizException
	 */
	private void updateEntDep(EnIppreTransHosDTO ippreTransHos) throws BizException {
		// 转科不转 病区
		if ((ippreTransHos.getId_dep_phy().equals(ippreTransHos.getId_ippre_phy())) && !(ippreTransHos.getId_dep_nur().equals(ippreTransHos.getId_ippre_nur()))) {
			addEnDep(ippreTransHos, 1);
		}

		// 转病区不转科
		else if (!(ippreTransHos.getId_dep_phy().equals(ippreTransHos.getId_ippre_phy())) && (ippreTransHos.getId_dep_nur().equals(ippreTransHos.getId_ippre_nur()))) {
			addEnDep(ippreTransHos, 2);
		}

		// 既转科又转病区
		else if (!(ippreTransHos.getId_dep_phy().equals(ippreTransHos.getId_ippre_phy())) && !(ippreTransHos.getId_dep_nur().equals(ippreTransHos.getId_ippre_nur()))) {
			addEnDep(ippreTransHos, 1);
			addEnDep(ippreTransHos, 2);
		}
	}

	/**
	 * 对EnDepDO实体 更新操作进行封装
	 * 
	 * @param ippreTransHos
	 * @param stat 判断是科室 还是病情 1： 科室 2： 病区
	 * @throws BizException
	 */
	private void addEnDep(EnIppreTransHosDTO ippreTransHos, int stat) throws BizException {

		UdiDocEP docep = new UdiDocEP();
		Map<String,UdidocDO> map = docep.getUdiDocsByCode(IEnDictCodeTypeConst.SD_DEP_ROLE);
		EnDepDO depDO = new EnDepDO();
		// 就诊id
		depDO.setId_ent(ippreTransHos.getId_ent());

		if (stat == 1) {
			depDO.setId_dep(ippreTransHos.getId_ippre_phy());// 科室
			depDO.setSd_entdeprole(IEnDictCodeConst.SD_ENTDEPROLE_DEP);// 角色编码
																		// 科室
			depDO.setId_dep_from(ippreTransHos.getId_dep_phy()); // 来源科室
			if(map!=null){
				depDO.setId_entdeprole(map.get(IEnDictCodeConst.SD_ENTDEPROLE_DEP)== null ?null: map.get(IEnDictCodeConst.SD_ENTDEPROLE_DEP).getId_udidoc());
			}
		} else if (stat == 2) {
			depDO.setId_dep(ippreTransHos.getId_ippre_nur());// 病区
			depDO.setSd_entdeprole(IEnDictCodeConst.SD_ENTDEPROLE_IA);// 角色编码 病区
			depDO.setId_dep_from(ippreTransHos.getId_dep_nur());// 来源病区
			if(map!=null){
				depDO.setId_entdeprole(map.get(IEnDictCodeConst.SD_ENTDEPROLE_IA)== null ?null: map.get(IEnDictCodeConst.SD_ENTDEPROLE_IA).getId_udidoc());
			}
		}
		depDO.setDt_b(curTime); // 开始时间
		depDO.setFg_ippre(FBoolean.TRUE);//预住院标识
		depDO.setFg_admit(FBoolean.TRUE); // 入院标识(预住院的为true)
		depDO.setFg_discharge(FBoolean.FALSE); // 出院标识
		depDO.setDt_dcg_bill(curTime); // 收费最近日期
		depDO.setSd_status(IEnDictCodeConst.SD_ENTDEP_STATUS_SUC); // 状态
		depDO.setStatus(DOStatus.NEW);

		changeDep(depDO, ippreTransHos, FBoolean.FALSE);
	}
	/**
	 * 更新科室或病区
	 * 
	 * @param entDepDO 科室或病区DO
	 * @param ippreTransHos
	 * @param fg_discharge
	 * @throws BizException
	 */
	public void changeDep(EnDepDO entDepDO, EnIppreTransHosDTO ippreTransHos, FBoolean fg_discharge) throws BizException {
		// 结束当前前使用科室
		if (IEnDictCodeConst.SD_ENTDEPROLE_DEP.equals(entDepDO.getSd_entdeprole())) {
			this.endDept(entDepDO.getId_ent(), entDepDO.getSd_entdeprole(), ippreTransHos.getId_ippre_phy(), fg_discharge);
		}
		if (IEnDictCodeConst.SD_ENTDEPROLE_IA.equals(entDepDO.getSd_entdeprole())) {
			this.endDept(entDepDO.getId_ent(), entDepDO.getSd_entdeprole(), ippreTransHos.getId_ippre_nur(), fg_discharge);
		}
		// 新增科室记录
		IEndepCudService endepCudService = ServiceFinder.find(IEndepCudService.class);
		endepCudService.insert(new EnDepDO[] { entDepDO });
	}

	/**
	 * 停止使用当前科室
	 * 
	 * @param entId 就诊id
	 * @param deptRole 科室类型
	 * @param toDeptId 转到科室id
	 * @param fg_discharge
	 * @throws BizException
	 */
	public void endDept(String entId, String deptRole, String toDeptId, FBoolean fg_discharge) throws BizException {
		IEndepRService endepRService = ServiceFinder.find(IEndepRService.class);
		String whereStr = String.format(" id_ent= '%s' AND dt_e is null  ", entId);
		if (!StringUtil.isEmptyWithTrim(deptRole)) {
			whereStr += String.format(" AND sd_entdeprole = '%s' ", deptRole);
		}

		EnDepDO[] enDepDOs = endepRService.find(whereStr, "", FBoolean.FALSE);
		if (!ArrayUtil.isEmpty(enDepDOs)) {
			for (EnDepDO enDepDO : enDepDOs) {
				enDepDO.setDt_e(curTime);
				enDepDO.setId_dep_to(toDeptId);
				enDepDO.setStatus(DOStatus.UPDATED);
				enDepDO.setFg_discharge(fg_discharge);
			}
			IEndepCudService endepCudService = ServiceFinder.find(IEndepCudService.class);
			endepCudService.save(enDepDOs);
		}
	}

	/**
	 * 更新医疗组
	 * 
	 * @param ippreTransHos
	 * @param entList
	 * @throws BizException
	 */
	private void updateEntWg(EnIppreTransHosDTO ippreTransHos, ArrayList<String> entList) throws BizException {
		EntWgEP entwgBp = new EntWgEP();
		if (ListUtil.isEmpty(entList))
			return;
		EnMedGrpDO[] enMedGrpDOs = entwgBp.CreatNewWGs(entList, ippreTransHos.getId_wg(), curTime, FBoolean.FALSE);
		entwgBp.changeMedGrp(enMedGrpDOs, curTime);
	}

	/**
	 * 插入数据到en_ent_emp
	 * 
	 * @param ippreTransHos
	 * @param entIdlist
	 * @throws BizException
	 */
	private void updateEntEmp(EnIppreTransHosDTO ippreTransHos, List<String> entIdlist) throws BizException {
		EntEmpEP entEmp = new EntEmpEP();
		entEmp.endOldEmp(entIdlist, null, null);
		ArrayList<EnPsnDO> entEmpList = new ArrayList<EnPsnDO>();
		for (String entId : entIdlist) {
			// 主治大夫
			EnPsnDO empDoc = entEmp.createEmp(entId, ippreTransHos.getId_emp_doc(), IEnDictCodeConst.ID_EMPROLE_DOCTOR, IEnDictCodeConst.SD_EMPROLE_DOCTOR, curTime);
			entEmpList.add(empDoc);
			// 责任护士
			EnPsnDO empNur = entEmp.createEmp(entId, ippreTransHos.getId_emp_nur(), IEnDictCodeConst.ID_EMPROLE_NURSE, IEnDictCodeConst.SD_EMPROLE_NURSE, curTime);
			entEmpList.add(empNur);
			// 主任医师
			EnPsnDO empZR = entEmp.createEmp(entId, ippreTransHos.getId_emp_zr(), IEnDictCodeConst.ID_EMPROLE_ZRDOC, IEnDictCodeConst.SD_EMPROLE_ZRDOC, curTime);
			entEmpList.add(empZR);
			// 主治医师
			EnPsnDO empZZ = entEmp.createEmp(entId, ippreTransHos.getId_emp_zz(), IEnDictCodeConst.ID_EMPROLE_ZZDOC, IEnDictCodeConst.SD_EMPROLE_ZZDOC, curTime);
			entEmpList.add(empZZ);
			// 住院医师
			EnPsnDO empZY = entEmp.createEmp(entId, ippreTransHos.getId_emp_zy(), IEnDictCodeConst.ID_EMPROLE_ZYDOC, IEnDictCodeConst.SD_EMPROLE_ZYDOC, curTime);
			entEmpList.add(empZY);
		}
		IEnpsnCudService enpsnService = ServiceFinder.find(IEnpsnCudService.class);
		enpsnService.insert(entEmpList.toArray(new EnPsnDO[] {}));
	}

	/**
	 * 更新就诊表信息
	 * 
	 * @param ippreTransHos
	 * @param entIdList
	 * @throws BizException
	 */
	private PatiVisitDO updatePatvisit(EnIppreTransHosDTO ippreTransHos, List<String> entIdList) throws BizException {
		IPativisitCudService iPativisitCudService = ServiceFinder.find(IPativisitCudService.class);
		PvEP pvep = new PvEP();
		PatiVisitDO[] pativisits = pvep.getPVs(entIdList);
		for (PatiVisitDO patiVisitDO : pativisits) {
			patiVisitDO.setDt_acpt(curTime);
			patiVisitDO.setId_entp(IBdFcDictCodeConst.ID_CODE_ENTP_IP);
			patiVisitDO.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
			patiVisitDO.setId_dep_phy(ippreTransHos.getId_dep_phy());
			patiVisitDO.setId_dep_nur(ippreTransHos.getId_dep_nur());
			patiVisitDO.setId_wg_phy(ippreTransHos.getId_wg());
			patiVisitDO.setId_emp_phy(ippreTransHos.getId_emp_doc());
			patiVisitDO.setId_emp_nur(ippreTransHos.getId_emp_nur());
			patiVisitDO.setStatus(DOStatus.UPDATED);
		}
		return iPativisitCudService.save(pativisits)[0];
	}

	/**
	 * 更新住院表信息
	 * 
	 * @param ippreTransHos
	 * @param entIdList
	 * @throws BizException
	 */
	private void updateEntIp(EnIppreTransHosDTO ippreTransHos, List<String> entIdList) throws BizException {
		IInpatientCudService iInpatientCudService = ServiceFinder.find(IInpatientCudService.class);
		IInpatientRService iInpatientRService = ServiceFinder.find(IInpatientRService.class);
		String entIdStr = EnSqlUtils.buildIdStr(entIdList);
		InpatientDO[] inpatientDOs = iInpatientRService.find(" id_ent in (" + entIdStr + ") ", "", FBoolean.FALSE);
		if (!ArrayUtil.isEmpty(inpatientDOs)) {
			for (InpatientDO ipdo : inpatientDOs) {
				ipdo.setId_bed(ippreTransHos.getId_bed());
				ipdo.setName_bed(ippreTransHos.getName_bed());
				ipdo.setFg_ippre(FBoolean.FALSE);
				ipdo.setStatus(DOStatus.UPDATED);
			}
		}
		iInpatientCudService.save(inpatientDOs);
	}
	
	/**
	 * 更新住院表信息
	 * 
	 * @param entIdList
	 * @throws BizException
	 */
	private void updateEnIppre(List<String> entIdList) throws BizException {
		IEnippreCudService iCudService = ServiceFinder.find(IEnippreCudService.class);
		IEnippreRService iRService = ServiceFinder.find(IEnippreRService.class);
		String entIdStr = EnSqlUtils.buildIdStr(entIdList);
		EnIppreDO[] enIppreDOs = iRService.find(" id_ent in (" + entIdStr + ") ", "", FBoolean.FALSE);
		if (!ArrayUtil.isEmpty(enIppreDOs)) {
			for (EnIppreDO enIppreDO : enIppreDOs) {
				if(ippreTransMethod){
					enIppreDO.setFg_transdep(FBoolean.TRUE);
				}else{
					enIppreDO.setSd_status(IEnDictCodeConst.SD_STATUS_IPPRE_DEP_ENTER);//3-入科
					enIppreDO.setDt_end_ippre(curTime);
					}
				enIppreDO.setStatus(DOStatus.UPDATED);
			}
		}
		iCudService.save(enIppreDOs);
	}

	/**
	 * 发送转科事件
	 * @param patDTO
	 * @param endepDTO
	 * @throws BizException
	 */
	/*private void invokeTransDeptEvent(TransDepPatDTO patDTO, EnDepDTO endepDTO, FDateTime curTime, PatiVisitDO entDo, String orderTypeCode) throws BizException {
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
		enDTO.setId_dep_phy(patDTO.getId_dep_phy());
		enDTO.setOld_id_dep_nur(patDTO.getOld_dep_nur());
		enDTO.setOld_id_dep_phy(patDTO.getOld_dep_phy());
		
		enDTO.setId_emp_opr(EnContextUtils.getPsnId());//操作员
		enDTO.setId_dep_opr(EnContextUtils.getDeptId());  //操作科室
		enDTO.setDt_opr(curTime); //操作时间
		IpTransDeptEvent ipTransDeptEvent = new IpTransDeptEvent();
		ipTransDeptEvent.invoke(enDTO);
	}*/

	/**
	 * 发送转病区事件
	 * @param patDTO
	 * @param endepDTO
	 * @throws BizException
	 */
	/*private void invokeTransWardEvent(TransDepPatDTO patDTO, EnDepDTO endepDTO, FDateTime curTime) throws BizException {
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
	}*/
	
	/**
	 * 校验医嘱状态是否发生变化
	 * @param orderId
	 * @throws BizException
	 */
	private void validataCiStatus(String orderId) throws BizException{
		if(StringUtil.isEmptyWithTrim(orderId)){
			throw new BizException("未获取到医嘱ID");
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
	 * 触发事件
	 * 
	 * @param dto
	 * @throws BizException
	 */
	/*private void invokeIpEnterDeptEvent(TransDepPatDTO  dto) throws BizException {
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
	}*/

	/**
	 * 获取就诊id（带婴儿）的list
	 * 
	 * @param entId
	 * @param nbdos
	 * @return
	 * @throws BizException
	 */
	private ArrayList<String> getEntIdList(String entId, NewbornDO[] nbdos) throws BizException {
		if (StringUtil.isEmptyWithTrim(entId))
			return null;
		ArrayList<String> entIdList = new ArrayList<String>();
		entIdList.add(entId);
		if (ArrayUtil.isEmpty(nbdos))
			return entIdList;
		for (NewbornDO nbDO : nbdos) {
			entIdList.add(nbDO.getId_ent_bb());
		}
		return entIdList;
	}
	
	/**
	 * 校验医疗组
	 * @paramippreTransHos
	 * @throws BizException 
	 */
	private void validateDoc(EnIppreTransHosDTO ippreTransHos) throws BizException{
		if(ippreTransHos==null)
			throw new BizException("入科数据不能为空！");
		String id_zr_doc = ippreTransHos.getId_emp_zr();
		String id_zy_doc = ippreTransHos.getId_emp_zy();
		//String id_zz_doc = ippreTransHos.getId_emp_zz();
		//SaveEnPsnBP enPsnBP = new SaveEnPsnBP();
		//enPsnBP.volidateEnPsnBp(id_zr_doc, id_zy_doc, id_zz_doc);
		//主任医师和住院医师是否可以相同
		if(!EnParamUtils.isZrZyCanSame()){
			if(!EnValidator.isEmpty(id_zr_doc) && !EnValidator.isEmpty(id_zy_doc) 
					&& id_zr_doc.equals(id_zy_doc)){
				throw new BizException("主任医师与住院医师不能相同！");
			}
		}
	}
	
	/**
	 * 校验床位信息
	 * @param ippreTransHos
	 * @throws BizException
	 */
	private void validateBed(EnIppreTransHosDTO ippreTransHos) throws BizException{
		BedEP bedBP = new BedEP();
		// 新床位，需校验
		if (!ippreTransHos.getId_bed().equals(ippreTransHos.getId_bed_old())) {
			FBoolean hasUsed = bedBP.hasUsed(ippreTransHos.getId_bed());
			if (hasUsed.booleanValue()) {
				throw new BizException(IEnMsgConst.ERROR_BED_STATUS_USED);
			}
			if(bedBP.hasChanged(ippreTransHos.getId_bed(), IBdResDictCodeConst.SD_BEDSU_EMPTY).booleanValue()){
				throw new BizException(IEnMsgConst.ERROR_BED_STATUS_CHANGED);
			}
		}else{
			if(bedBP.hasChanged(ippreTransHos.getId_bed(), IBdResDictCodeConst.SD_BEDSU_OCCUPYBYIN).booleanValue()){
				throw new BizException(IEnMsgConst.ERROR_BED_STATUS_CHANGED);
			}
		}
	}
	
	
	/**
	 * 保存转科记录表
	 * @param transDTO
	 * @throws BizException 
	 */
	private void saveDepTrans(EnIppreTransHosDTO transDTO) throws BizException {
		EnDepTransDO depTransDO;
		IEndeptransRService RService  = ServiceFinder.find(IEndeptransRService.class);
  	    String whereStr = "id_ent = '" +transDTO.getId_ent()+"' AND Eu_trans ='"+EnEuTrans.APPLY+"'";
  	    String whereStr2 = "id_ent = '" +transDTO.getId_ent()+"' AND Eu_trans ='"+EnEuTrans.ACPT+"'";
  	    EnDepTransDO[] res = RService.find(whereStr, "", FBoolean.FALSE);
  	    EnDepTransDO[] res2 = RService.find(whereStr2, "", FBoolean.FALSE);
  	    if(!EnValidator.isEmpty(res2))
  	    	throw new BizException("申请状态发生改变，请刷新界面！");
  	    if(EnValidator.isEmpty(res)){
		//创建一个新的对象
  	    depTransDO= new EnDepTransDO();
  	    depTransDO.setStatus(DOStatus.NEW);}
  	    else{
  	    	depTransDO = res[0];
  	    	depTransDO.setStatus(DOStatus.UPDATED);
  	    }
        //就诊id
  	    depTransDO.setId_ent(transDTO.getId_ent());
        //目标科室
  	  	depTransDO.setId_dep_to(transDTO.getId_dep_phy());
  	  	//目标病区
  	  	depTransDO.setId_dep_nur_to(transDTO.getId_dep_nur());
        //目标床位
  	  	depTransDO.setId_bed_to(transDTO.getId_bed());
        //原科室
  	  	depTransDO.setId_dep_from(transDTO.getId_ippre_phy());
        //原病区
  	  	depTransDO.setId_dep_nur_from(transDTO.getId_ippre_nur());
        //原床位
  	  	depTransDO.setId_bed_from(transDTO.getId_bed_old());
        //转科过程状态
  	  	depTransDO.setEu_trans(EnEuTrans.APPLY);
  	  	depTransDO.setFg_ippre(FBoolean.TRUE);
  	  	depTransDO.setDt_apply(curTime);
  	  	if(!ippreTransMethod){//直接转入
  	  		depTransDO.setDt_acpt(curTime);
  	  		depTransDO.setId_emp_acpt(EnContextUtils.getPsnId());
  	  		depTransDO.setEu_trans(EnEuTrans.ACPT);
  	  	}
  	  	depTransDO.setId_emp_appl(EnContextUtils.getPsnId());
  	  	IEndeptransCudService  cudService = ServiceFinder.find(IEndeptransCudService.class);
  	  	cudService.save(new EnDepTransDO[] {depTransDO});
	}
	/**
	 * 转出检查
	 * @param ippreTransHos
	 * @throws BizException 
	 */
	private void checkTrans(EnIppreTransHosDTO ippreTransHos) throws BizException {
		IEnippreRService iRService = ServiceFinder.find(IEnippreRService.class);
		EnIppreDO[] enIppreDOs = iRService.find(" id_ent = '" + ippreTransHos.getId_ent() + "'", "", FBoolean.FALSE);
		if(enIppreDOs==null || enIppreDOs.length<=0){
			throw new BizException("患者预住院数据错误！");
		}
		String checkDepCfg = EnParamUtils.getIppreTransCheck();
		if(EnValidator.isEmpty(checkDepCfg) || checkDepCfg.length() != 4)
			throw new BizException("转住院检查参数(ENIP0310)配置错误！");
		String checkResult = "";
		boolean fg_done_mt = !checkDepCfg.substring(0,1).equals("0");
		boolean fg_done_anest = !checkDepCfg.substring(1,2).equals("0");
		boolean fg_done_bed = !checkDepCfg.substring(2,3).equals("0");
		boolean fg_done_dep = !checkDepCfg.substring(3,4).equals("0");
		
		if(fg_done_mt && !(enIppreDOs[0].getFg_done_mt().booleanValue())){
			checkResult = checkResult+"[检查未完成]";
		}
		if(fg_done_anest && !(enIppreDOs[0].getFg_done_anest().booleanValue())){
			checkResult = checkResult+"[麻醉评估未完成]";
		}
		if(fg_done_bed && !(enIppreDOs[0].getFg_done_bed().booleanValue())){
			checkResult = checkResult+"[床位预约未完成]";
		}
		if(fg_done_dep && !(enIppreDOs[0].getFg_done_dep().booleanValue())){
			checkResult = checkResult+"[入院审核未完成]";
		}
		if(!checkResult.equals("")){
			throw new BizException(checkResult);
		}
		
	}
	/**
     * 保存就诊转科记录
     * @throws BizException 
     */
    private void saveEnDepTransDO(EnDepTransDO saveDo) throws BizException {
        IEndeptransRService RService  = ServiceFinder.find(IEndeptransRService.class);
  	    String whereStr = "id_ent = '" +saveDo.getId_ent()+"' AND Eu_trans ='"+EnEuTrans.APPLY;
  	    EnDepTransDO[] res = RService.find(whereStr, "", FBoolean.FALSE);
  	    if(!EnValidator.isEmpty(res))
  	    	throw new BizException("申请状态发生改变，请刷新界面！");
        IEndeptransCudService  cudService = ServiceFinder.find(IEndeptransCudService.class);
        cudService.save(new EnDepTransDO[] {saveDo});
    }
    
    /**
	 * 触发入科事件
	 * 
	 * @param enDepDTO
	 * @throws BizException
	 */
	private void invokeIpEnterDeptEvent(EnIppreTransHosDTO enDepDTO, InpatientDO inpatient) throws BizException {
		this.setDocs(enDepDTO);
		// 1、构造事件源
		EnterDept4EsDTO enterDept4EsDTO = new EnterDept4EsDTO();
		enterDept4EsDTO.setId_ent(enDepDTO.getId_ent());
		enterDept4EsDTO.setId_pat(enDepDTO.getId_pat());
		enterDept4EsDTO.setDt_acpt(curTime);//暂时取这个
		enterDept4EsDTO.setName_pat(enDepDTO.getName_pat());
		enterDept4EsDTO.setDt_birth_pat(enDepDTO.getDt_birth());
		enterDept4EsDTO.setName_dep_phy(enDepDTO.getName_dep_phy());
		enterDept4EsDTO.setName_bed(enDepDTO.getName_bed());
		enterDept4EsDTO.setSd_emp_zr(enDepDTO.getSd_emp_zr());//主任
		enterDept4EsDTO.setName_emp_zr(enDepDTO.getName_emp_zr());
		enterDept4EsDTO.setSd_emp_doc(enDepDTO.getSd_emp_zy());//住院
		enterDept4EsDTO.setPhy_name(enDepDTO.getName_emp_zy());
		enterDept4EsDTO.setSd_emp_zz(enDepDTO.getSd_emp_zz());//主治 
		enterDept4EsDTO.setName_emp_zz(enDepDTO.getName_emp_zz());
		enterDept4EsDTO.setEvent_source(IEventType.TYPE_INSERT_AFTER);
		enterDept4EsDTO.setId_dep_opr(EnContextUtils.getDeptId());  //操作科室
		enterDept4EsDTO.setId_emp_opr(EnContextUtils.getPsnId());//操作员
		enterDept4EsDTO.setDt_opr(EnAppUtils.getServerDateTime());
		enterDept4EsDTO.setId_dep_nur(enDepDTO.getId_dep_nur());
		enterDept4EsDTO.setSd_emp_ry(inpatient.getCode_emp_phy_op());
		enterDept4EsDTO.setName_emp_ry(inpatient.getName_emp_phy_op());
		enterDept4EsDTO.setCode(IEnConst.UPDATE);//预住院发送的入科消息类型为update
		enterDept4EsDTO.setFg_newborn(FBoolean.FALSE);
		// 2、触发事件
		IpEnterDeptEvent enterDeptEvent = new IpEnterDeptEvent();
		enterDeptEvent.invoke(enterDept4EsDTO);
	}
	private void setDocs(EnIppreTransHosDTO enDepDTO) throws BizException{
		List<String> psnIdList = new ArrayList<>();
		psnIdList.add(enDepDTO.getId_emp_zr());
		psnIdList.add(enDepDTO.getId_emp_zz());
		psnIdList.add(enDepDTO.getId_emp_zy());
		PsnDocEP ep = new PsnDocEP();
		Map<String, PsnDocDO> psndocs = ep.getPsnByIdList(psnIdList);
		if(psndocs.containsKey(enDepDTO.getId_emp_zr())){
			PsnDocDO doc = psndocs.get(enDepDTO.getId_emp_zr());
			if(doc != null){
				enDepDTO.setSd_emp_zr(doc.getCode());
				enDepDTO.setName_emp_zr(doc.getName());
			}
		}
		if(psndocs.containsKey(enDepDTO.getId_emp_zz())){
			PsnDocDO doc = psndocs.get(enDepDTO.getId_emp_zz());
			if(doc != null){
				enDepDTO.setSd_emp_zz(doc.getCode());
				enDepDTO.setName_emp_zz(doc.getName());
			}
		}
		if(psndocs.containsKey(enDepDTO.getId_emp_zy())){
			PsnDocDO doc = psndocs.get(enDepDTO.getId_emp_zy());
			if(doc != null){
				enDepDTO.setSd_emp_zy(doc.getCode());
				enDepDTO.setName_emp_zy(doc.getName());				
			}
		}
	}
	
	/**
	 * 发送转科事件
	 * @param patDTO
	 * @param endepDTO
	 * @throws BizException
	 */
	private void invokeTransDeptEvent(EnIppreTransHosDTO patDTO, FDateTime curTime, PatiVisitDO entDo, String orderTypeCode) throws BizException {
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
		enDTO.setDt_birth(patDTO.getDt_birth());
		enDTO.setOld_dep_nur_name(patDTO.getName_ippre_nur());
		enDTO.setOld_sd_dep_nur(patDTO.getSd_ippre_nur());
		enDTO.setOld_dep_phy_name(patDTO.getName_ippre_phy());
		enDTO.setOld_sd_dep_phy(patDTO.getSd_ippre_phy());

		enDTO.setSd_dep_nur(patDTO.getSd_dep_nur());
		enDTO.setName_dep_nur(patDTO.getName_dep_nur());
		enDTO.setName_dep_phy(patDTO.getName_dep_phy());
		enDTO.setSd_dep_phy(patDTO.getSd_dep_phy());

		enDTO.setOld_bedname(patDTO.getName_bed());

		enDTO.setNew_bedname(patDTO.getName_bed());
		//enDTO.setCi_code(patDTO.getCi_code());??

		enDTO.setSd_emp_nur(patDTO.getSd_emp_nur());
		enDTO.setName_emp_nur(patDTO.getName_emp_nur());
		//enDTO.setId_or(patDTO.getId_or());??
		enDTO.setId_dep_nur(patDTO.getId_dep_nur());
		enDTO.setId_emp_opr(EnContextUtils.getPsnId());//操作员
		enDTO.setId_dep_opr(EnContextUtils.getDeptId());  //操作科室
		enDTO.setDt_opr(curTime); //操作时间
		IpTransDeptEvent ipTransDeptEvent = new IpTransDeptEvent();
		ipTransDeptEvent.invoke(enDTO);
	}
	
	/**
	 * 触发事件(医护人员修改)
	 * 
	 * @param enDepDTO
	 * @throws BizException
	 */
	private void invokeIpEnterDeptEvent(EnIppreTransHosDTO  dto) throws BizException {
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
	
}
