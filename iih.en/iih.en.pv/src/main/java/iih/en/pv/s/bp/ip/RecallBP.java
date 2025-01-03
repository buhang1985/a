package iih.en.pv.s.bp.ip;

import com.ymer.core.util.ParamUtil;

import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bl.st.dto.blipauditstatus.d.BlIpAuditStatusDTO;
import iih.bl.st.i.IBlStOutQryService;
import iih.ci.mr.ciamr.d.AMrDO;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.BedEP;
import iih.en.comm.ep.EnPatTpEP;
import iih.en.comm.ep.EntBedEP;
import iih.en.comm.ep.EntDeptEP;
import iih.en.comm.ep.EntEmpEP;
import iih.en.comm.ep.EntWgEP;
import iih.en.comm.ep.IpEP;
import iih.en.comm.ep.NbEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.evt.EnEvtHandle;
import iih.en.comm.util.EnAgeCalcUtil;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.HosRecallDTO;
import iih.en.pv.enres.d.EnBedDO;
import iih.en.pv.enres.s.EnbedCrudServiceImpl;
import iih.en.pv.inpatient.d.EnIppreDO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.inpatient.dto.d.Recall4EsDTO;
import iih.en.pv.inpatient.i.IEnippreCudService;
import iih.en.pv.inpatient.i.IEnippreRService;
import iih.en.pv.inpatient.s.InpatientCrudServiceImpl;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.s.PativisitCrudServiceImpl;
import iih.en.pv.s.event.IpRecallEvent;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;
/**
 * 出院召回BP
 * @author renying 
 * @author yankan 
 * @since 2015-10-14
 *
 */
public class RecallBP {

	/**
	 * 召回
	 * @param recallDTOs 召回DTO
	 * @throws BizException
	 */
	public void exec(HosRecallDTO[] recallDTOs) throws BizException{
		if(recallDTOs==null ){
			return;
		}

	    this.recall(recallDTOs[0]);
	    
	}
	/**
	 * 召回
	 * @param recallDTO 召回DTO
	 * @throws BizException
	 */
	private void recall(HosRecallDTO recallDTO) throws BizException {
		// 验证输入参数
		this.validateRecall(recallDTO);
		if(!EnParamUtils.isMultIp()){
			IpEP ipEp = new IpEP();
			//校验在院
			ipEp.validateInpatientDO(recallDTO.getId_pat());
		}
		//1.返回：判断是成人或者允许分床的新生儿
		//2.如果是新生儿，保存分床标志
		boolean isAduatOrSepaNb = this.isAduatOrSepaNb(recallDTO);

		//当前选中床位是否可用
		BedEP bedBP = new BedEP();
		if(isAduatOrSepaNb){
		if( bedBP.hasUsed(recallDTO.getId_bed_new()).booleanValue()){			
				throw new BizException(recallDTO.getName_bed_new() +IEnMsgConst.ERROR_BED_STATUS_CHANGED);
			}			
		}
		//已出院结算不允许召回
		if(recallDTO.getFg_st()!=null && recallDTO.getFg_st().booleanValue() ){
			throw new BizException("该患者已结算，不允许召回！");
		}
		PativisitCrudServiceImpl pvService = new PativisitCrudServiceImpl();
		PatiVisitDO pvDO = pvService.findById(recallDTO.getId_ent());
		if(pvDO.getFg_st()!=null && pvDO.getFg_st().booleanValue()){
			throw new BizException("该患者已结算，不允许召回！");
		}			
		FDateTime curTime = EnAppUtils.getServerDateTime();
		if (isAduatOrSepaNb) {
			// 1、床位占用
			if (IEnDictCodeConst.BED_HAS_SEX.equals(EnParamUtils.getBedSexParam(recallDTO.getId_dep_nur()))) {
				bedBP.occupyBedWithSex(recallDTO.getId_bed_new(), null, recallDTO.getSd_sex_pat().toString(), FBoolean.TRUE, 
						IBdResDictCodeConst.SD_BEDSU_USEDBYPATIENT, IBdResDictCodeConst.ID_BEDSU_USEDBYPATIENT);
			}else {
				bedBP.useBed(recallDTO.getId_bed_new());
			}
		}
		// 2、还原就诊信息	
		pvDO.setFg_ip(FBoolean.TRUE);
		if(!FBoolean.TRUE.equals(recallDTO.getFg_blrecall())){
			pvDO.setDt_end(null);// 召回原因选临床诊断，结束时间置空
		}
		pvDO.setStatus(DOStatus.UPDATED);
		PatiVisitDO[] pvDos = pvService.save(new PatiVisitDO[] { pvDO });

		// 3、还原住院信息，并更新床位
		InpatientCrudServiceImpl ipService = new InpatientCrudServiceImpl();
		InpatientDO[] ipDOs = ipService.find(String.format("id_ent='%s'", recallDTO.getId_ent()), null, FBoolean.FALSE);
		if (!EnValidator.isEmpty(ipDOs)) {
			InpatientDO ipDO = ipDOs[0];
			ipDO.setId_dep_phydisc(null);// 出院科室置空
			ipDO.setId_dep_nurdisc(null);// 出院病区置空
			ipDO.setId_bed(recallDTO.getId_bed_new());// 保存新床位
			ipDO.setName_bed(recallDTO.getName_bed_new());// 保存新床号
			ipDO.setSd_status(IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN);// 状态改为入科
			ipDO.setFg_blrecall(recallDTO.getFg_blrecall());
			ipDO.setStatus(DOStatus.UPDATED);
			ipService.save(new InpatientDO[] { ipDO });
		}

		String whereSql = "";
		// 4、更新就诊资源--床位
		if (!FBoolean.TRUE.equals(recallDTO.getFg_blrecall()) && isAduatOrSepaNb) {
			EnbedCrudServiceImpl enbedService = new EnbedCrudServiceImpl();
			if (recallDTO.getId_bed_new().equals(recallDTO.getId_bed())) {
				// 原来的床位，则更新结束时间
				whereSql = String.format("Id_ent = '%s' and Id_usetype='%s' AND dt_e='%s'", recallDTO.getId_ent(), IEnDictCodeConst.ID_USETYPE_MAIN, recallDTO.getDt_end());
				EnBedDO[] enbedDOs = enbedService.find(whereSql, "dt_b desc", FBoolean.FALSE);
				if (enbedDOs != null && enbedDOs.length > 0) {
					EnBedDO enbedDO = enbedDOs[0];
					if(enbedDO.getId_bed().equals(recallDTO.getId_bed_new())){
						enbedDO.setStatus(DOStatus.UPDATED);
						enbedDO.setDt_e(null);
						enbedDO.setId_usetype(IEnDictCodeConst.ID_USETYPE_MAIN);// 主床
						enbedService.save(new EnBedDO[] { enbedDO });
					}else{//如果新床和查出的床不一样，新增记录
						EntBedEP entBedBP = new EntBedEP();
						entBedBP.useBed(recallDTO.getId_ent(), recallDTO.getId_bed_new(), recallDTO.getName_bed_new(), recallDTO.getId_dep_nur(), recallDTO.getDt_end());
					}
				}
			} else {
				EntBedEP entBedBP = new EntBedEP();
				entBedBP.useBed(recallDTO.getId_ent(), recallDTO.getId_bed_new(), recallDTO.getName_bed_new(), recallDTO.getId_dep_nur(), recallDTO.getDt_end());
			}
		}
		if(!FBoolean.TRUE.equals(recallDTO.getFg_blrecall())){
			if (isAduatOrSepaNb) {
				// 5、恢复科室
				EntDeptEP endeptEP = new EntDeptEP();
				endeptEP.recDept(recallDTO.getId_ent(), recallDTO.getDt_end());
			}
		}
		// 6、恢复医疗组
		EntWgEP entWgEp = new EntWgEP();
		entWgEp.recWg(recallDTO.getId_ent(), recallDTO.getDt_end());
		// 7、恢复医护人员
		EntEmpEP entEmpEP = new EntEmpEP();
		entEmpEP.recEmp(recallDTO.getId_ent(), recallDTO.getDt_end());

		// 8、更新病案
		this.updateAmr(recallDTO);
		// 9.还原预住院
		this.updateIppre(recallDTO);
		// 10、添加出院召回就诊事件
        new EnEvtHandle().insertRecallHosEvt(recallDTO);
        
		// 11.记录标签
		new EnPatTpEP().setEntBlReCallTag(recallDTO.getId_ent(), recallDTO.getFg_blrecall());
		
		try {
			this.setRecall4ListenerBP(recallDTO, curTime, pvDos[0]);
		} catch (Exception e) {
			Logger.error("出院召回消息发送失败：", e);
		}
	}	
	/**
	 * 1.返回：判断是成人或者允许分床的新生儿
	 * 2.如果是新生儿，保存分床标志
	 * @author lilei
	 * @date 2020年5月26日
	 */
	private boolean isAduatOrSepaNb (HosRecallDTO recallDTO) throws BizException{
		boolean isAdult = recallDTO.getFg_newborn() == null || !recallDTO.getFg_newborn().booleanValue();//是成人
		boolean isSepa = EnParamUtils.getIsCanMmBbSepa();//ENIP0191设置是否母婴分床
		if(isSepa){
			//查母亲的就诊信息信息
			PvEP pvEP = new PvEP();
			PatiVisitDO pvmom = pvEP.getPvById(recallDTO.getId_ent_mom());
			if(pvmom != null && pvmom.getFg_ip().booleanValue()){
				//如果母亲在院，查床号
				IpEP ipEP = new IpEP();
				InpatientDO ipmom = ipEP.getIpByEntId(recallDTO.getId_ent_mom());
				if(ipmom != null && ipmom.getId_bed().equals(recallDTO.getId_bed_new())){//新生儿选的床和母亲现在的床是同一个
					//修改新生儿分离标志为false,合床
					isSepa = false;
				}
			}
		}
		//设置婴儿的分床标志
		if(recallDTO.getFg_newborn() != null && recallDTO.getFg_newborn().booleanValue()){
			new NbEP().setNbBornDOSepa(recallDTO.getId_ent(),new FBoolean(isSepa));
		}
		return isAdult || (recallDTO.getFg_newborn() != null && recallDTO.getFg_newborn().booleanValue() && isSepa);
	}
	
	
	/**
	 * 验证召回
	 * @param recallDTO 召回的DTO
	 */
	private void validateRecall(HosRecallDTO recallDTO) throws BizException{
		//验证参数
		EnValidator.validateParam("recallDTO", recallDTO);
		
		if(recallDTO==null){
			throw new BizException(IEnMsgConst.ERROR_NOT_ACCCPT_RECALL);
		}
		if(EnValidator.isEmpty(recallDTO.getId_bed_new())){
			throw new BizException(IEnMsgConst.ERROR_NOT_GET_RECALLBED);
		}
		if(null == recallDTO.getFg_blrecall()){
			throw new BizException(IEnMsgConst.ERROR_NOT_BLRECALL);
		}
		IBlStOutQryService blService = ServiceFinder.find(IBlStOutQryService.class);
		BlIpAuditStatusDTO[] ipAuditStatus = blService.getIpAuditStatus(new String[] { recallDTO.getId_ent() });
		if (!EnValidator.isEmpty(ipAuditStatus)) {
			BlIpAuditStatusDTO blauditip = ipAuditStatus[0];
			// 诊疗费用已审核不允许召回
			if (FBoolean.TRUE.equals(blauditip.getFg_pass_clinic())) {
				throw new BizException("该患者费用已审核，请取消审核后再进行召回！");
			}
			// 医保费用已审核不允许召回
			if (FBoolean.TRUE.equals(blauditip.getFg_pass_hp())) {
				throw new BizException("该患者费用已审核，请取消审核后再进行召回！");
			}
		}
	}
	
	/**
	 * 更新病例的信息
	 * 
	 * @param patDTO
	 * @param endepDTO
	 * @throws BizException
	 */
	private void updateAmr(HosRecallDTO recallDTO) throws BizException {
		AmrBP amrBp = new AmrBP();
		AMrDO amrdo = amrBp.getAmrDO(recallDTO.getId_ent());
		if (amrdo != null) {
			amrdo.setStatus(DOStatus.UPDATED);
			amrdo.setId_bed(recallDTO.getId_bed_new());
			amrBp.saveAmr(amrdo);
		}
	}
	/**
	 * 
	 * @param recallDTO
	 * @param curTime
	 * @throws BizException
	 */
	private void setRecall4ListenerBP(HosRecallDTO recallDTO, FDateTime curTime, PatiVisitDO entDo) throws BizException
	{
		Recall4EsDTO esDTO = new Recall4EsDTO();
		esDTO.setId_ent(recallDTO.getId_ent());
		esDTO.setCode_ent(entDo.getCode());
		esDTO.setCode_enttp(entDo.getCode_entp());
		esDTO.setName_enttp(entDo.getName_entp());
		esDTO.setId_pat(recallDTO.getId_pat());
		esDTO.setDt_recall(curTime);
		esDTO.setName_pat(recallDTO.getName_pat());
		if (recallDTO.getSd_sex_pat() != null) {
			esDTO.setSd_sex(recallDTO.getSd_sex_pat().toString());
		}
		esDTO.setDt_birth(recallDTO.getDt_birth_pat());
		EnAgeCalcUtil.setDoAges(new Recall4EsDTO[]{esDTO}, "Id_ent", "Age");
		esDTO.setName_bed(recallDTO.getName_bed_new());
		esDTO.setId_dep_nur(recallDTO.getId_dep_nur());
		esDTO.setId_dep_phy(recallDTO.getId_dep_phy());
		esDTO.setEvent_source(IEventType.TYPE_INSERT_AFTER);
		esDTO.setId_dep_opr(EnContextUtils.getDeptId());  //操作科室
		esDTO.setId_emp_opr(EnContextUtils.getPsnId());//操作员
		esDTO.setDt_opr(EnAppUtils.getServerDateTime());
		esDTO.setDt_end(recallDTO.getDt_end());//上次出院时间
		IpRecallEvent recallEvent = new IpRecallEvent();
		recallEvent.invoke(esDTO);
	}
	
	/**
	 * 预住院处理
	 * @param recallDTO
	 * @throws BizException 
	 */
	private void updateIppre(HosRecallDTO recallDTO) throws BizException {
		IEnippreCudService iCudService = ServiceFinder.find(IEnippreCudService.class);
		IEnippreRService iRService = ServiceFinder.find(IEnippreRService.class);
		EnIppreDO[] enIppreDOs = iRService.find(" id_ent = '" + recallDTO.getId_ent() + "' ", "", FBoolean.FALSE);
		if(enIppreDOs!=null && enIppreDOs.length>0){
			for (EnIppreDO enIppreDO : enIppreDOs) {
				enIppreDO.setSd_status(IEnDictCodeConst.SD_STATUS_IPPRE_DEP_ENTER);
				enIppreDO.setStatus(DOStatus.UPDATED);
			}
			  // 预住院出院召回事件
	        new EnEvtHandle().insertIppreRecallHosEvt(recallDTO);
		}
		iCudService.save(enIppreDOs);	
	}

}
