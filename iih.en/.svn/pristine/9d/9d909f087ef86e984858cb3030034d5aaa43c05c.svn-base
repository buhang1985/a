package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.BedEP;
import iih.en.comm.ep.PiPatAmrCodeEP;
import iih.en.comm.evt.EnEvtHandle;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.util.EnVisitTimesUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EnHosRegDTO;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.en.pv.enfee.d.desc.EnAccountDODesc;
import iih.en.pv.enfee.i.IEnaccountMDORService;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.d.desc.InpatientDODesc;
import iih.en.pv.inpatient.dto.d.DisHos4EsDTO;
import iih.en.pv.inpatient.i.IInpatientCudService;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.s.PativisitCrudServiceImpl;
import iih.en.pv.s.event.IpDisHosEvent;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDOCudService;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.sc.apt.aptip.d.AptIpDO;
import iih.sc.apt.aptip.i.IAptipMDOCudService;
import iih.sc.apt.aptip.i.IAptipMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 取消登记
 * 
 * @author Sarah
 *
 */
public class CancelRegisterBP {
	/**
	 * 取消登记
	 * 
	 * @param enhosRegDTO
	 * @throws BizException
	 */
	public void exec(EnHosRegDTO enHosRegDTO) throws BizException {
		//1、 查找就诊数据
		InpatientDO inpatientDO = this.getInpatient(enHosRegDTO.getId_ent());
		//2.校验数据
		ValidateCanRegInfoBP vb = new ValidateCanRegInfoBP();
		vb.exec(enHosRegDTO, inpatientDO);
		//3、更新住院信息
		this.updateInpatientDO(inpatientDO, enHosRegDTO);
		//4.记录取消登记就诊事件
		new EnEvtHandle().insertIpRegistCancelEvt(enHosRegDTO);
	}
	
	/**
	 * 获取住院数据
	 * 
	 * @param entID
	 * @return
	 * @throws BizException
	 */
	public InpatientDO getInpatient(String entID) throws BizException {
		IInpatientRService inpatientRService = ServiceFinder.find(IInpatientRService.class);
		InpatientDO[] inpatientDOs = inpatientRService.find(InpatientDODesc.TABLE_ALIAS_NAME + ".id_ent = '" + entID + "'", null, FBoolean.FALSE);
		if (inpatientDOs == null || inpatientDOs.length == 0) {
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_INPATIENT);
		}
		InpatientDO inpatientDO = inpatientDOs[0];
		return inpatientDO;
	}
		
	/**
	 * 校验是否有预交金
	 * 
	 * @param entID
	 * @throws BizException
	 */
	@SuppressWarnings("unused")
	private void validateAmt(String entID) throws BizException {
		IEnaccountMDORService enaccRService = ServiceFinder.find(IEnaccountMDORService.class);
		EnAccountDO[] enAccountDOArray = enaccRService.find(EnAccountDODesc.TABLE_ALIAS_NAME + ".id_ent='" + entID + "'", "", FBoolean.FALSE);
		if (!EnValidator.isEmpty(enAccountDOArray)) {
			EnAccountDO enaccDO = enAccountDOArray[0];
			if (enaccDO.getAmt_prepay() != null && enaccDO.getAmt_prepay().doubleValue() != 0) {
				throw new BizException(IEnMsgConst.ERROR_ENHOSREG_HAS_PREAMT);
			}
		}
	}
	/**
	 * 更新住院信息
	 * 
	 * @param inpatientDO
	 * @param enhosRegDTO
	 * @throws BizException
	 */
	private void updateInpatientDO(InpatientDO inpatientDO, EnHosRegDTO enhosRegDTO) throws BizException {
		IInpatientCudService inpatientCrudService = ServiceFinder.find(IInpatientCudService.class);
		IPatiMDORService iPatiRService = ServiceFinder.find(IPatiMDORService.class);
		IPatiMDOCudService iPatiCudService = ServiceFinder.find(IPatiMDOCudService.class);
		FDateTime curTime = EnAppUtils.getServerDateTime();

		// 释放占用床位
		BedEP bedbp = new BedEP();
		if (IEnDictCodeConst.BED_HAS_SEX.equals(EnParamUtils.getBedSexParam(inpatientDO.getId_dep_nuradm()))) {
			bedbp.releaseBedWithSex(inpatientDO.getId_ent(), inpatientDO.getId_bed(), FBoolean.FALSE);
		}else {
			bedbp.releaseBed(inpatientDO.getId_ent(), inpatientDO.getId_bed());
		}
		//患者病案编码表，如果是非普通住院患者，更新 zhangpp 2019.10.16
		 boolean roolBackAmrCode = new PiPatAmrCodeEP().disOrCancSavePatAmrCodeDO(enhosRegDTO.getId_pat(), enhosRegDTO.getSd_ip_spec());
		// 住院表
		inpatientDO.setSd_status(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALQUIT);// 修改状态
		int timesIp = inpatientDO.getTimes_ip();
		inpatientDO.setTimes_ip(EnVisitTimesUtils.calcCancIpTimes(enhosRegDTO.getId_pat()));
		if(roolBackAmrCode){
			inpatientDO.setCode_amr_ip(null);
		}
		// 退院
		inpatientCrudService.update(new InpatientDO[] { inpatientDO });
		//更新住院表后，同步患者表住院次数
		PatDO patdo = iPatiRService.findById(enhosRegDTO.getId_pat());
		if(patdo != null){
			patdo.setLast_times_ip(patdo.getLast_times_ip() - 1);
			iPatiCudService.update(new PatDO[]{patdo});
		}
		// 就诊表
		PativisitCrudServiceImpl pativisitService = new PativisitCrudServiceImpl();
		PatiVisitDO patiVisitDO = pativisitService.findById(enhosRegDTO.getId_ent());
		patiVisitDO.setStatus(DOStatus.UPDATED);
		patiVisitDO.setFg_canc(FBoolean.TRUE); // 退诊标志
		patiVisitDO.setId_emp_canc(EnContextUtils.getPsnId()); // 退诊人员
		patiVisitDO.setDt_canc(curTime); // 取消时间
		pativisitService.update(patiVisitDO);
		//入院申请单，如果入院申请单的确认标志为false，回退申请单的状态为0 zhangpp 2019.10.18
		IAptipMDORService iAptipMDORService = ServiceFinder.find(IAptipMDORService.class);
		AptIpDO[] aptIpDOs = iAptipMDORService.findByAttrValString("Id_entip", inpatientDO.getId_ent());
		if (aptIpDOs != null && aptIpDOs.length >= 1 && !FBoolean.TRUE.equals(aptIpDOs[0].getFg_cfm())) {
			IAptipMDOCudService iAptipMDOCudService = ServiceFinder.find(IAptipMDOCudService.class);
			aptIpDOs[0].setSd_status(IEnDictCodeConst.SD_STATUS_NOTICE_CREATE);
			aptIpDOs[0].setId_entip(null);
			aptIpDOs[0].setStatus(DOStatus.UPDATED);
			iAptipMDOCudService.save(aptIpDOs);
		}
		try {
			this.invokeCancelRegistEvent(patiVisitDO, inpatientDO, timesIp);
		} catch (Exception e) {
			Logger.error("取消入院登记消息发送失败：",e);
		}
	}
	
	/**
	 * 取消登记事件
	 * 
	 * @param patiVisitDO
	 * @throws BizException 
	 */
	private void invokeCancelRegistEvent(PatiVisitDO patiVisitDO, InpatientDO inpatientDO, Integer timesIp) throws BizException {
		DisHos4EsDTO esDTO = new DisHos4EsDTO();
		esDTO.setId_ent(patiVisitDO.getId_ent());
		esDTO.setId_pat(patiVisitDO.getId_pat());
		esDTO.setId_dep_nur(patiVisitDO.getId_dep_nur());
		esDTO.setId_dep_phy(patiVisitDO.getId_dep_phy());
		esDTO.setBed_code(inpatientDO.getName_bed());
		esDTO.setDt_lv(EnAppUtils.getServerDateTime());
		esDTO.setEvent_source(IEventType.TYPE_INSERT_AFTER);
		esDTO.setId_dep_opr(EnContextUtils.getDeptId());  //操作科室
		esDTO.setId_emp_opr(EnContextUtils.getPsnId());//操作员
		esDTO.setDt_opr(EnAppUtils.getServerDateTime());
		esDTO.setCode_pat(patiVisitDO.getCode_pat());
		esDTO.setTimes_ip(timesIp);
		
		IpDisHosEvent disEvent = new IpDisHosEvent();
		disEvent.invoke(esDTO);
	}
}
