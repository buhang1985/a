package iih.en.er.bp.stayregist;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bl.params.BlParams;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.BedEP;
import iih.en.comm.ep.ErPreEP;
import iih.en.comm.ep.IpEP;
import iih.en.comm.ep.PiPatAmrCodeEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.evt.EnEvtHandle;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.util.EnVisitTimesUtils;
import iih.en.comm.util.FDoubleUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.dto.d.UrgStayRegistryDTO;
import iih.en.pv.dto.d.EnHosRegDTO;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.en.pv.enfee.i.IEnaccountMDORService;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.dto.d.DisHos4EsDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.s.event.IpDisHosEvent;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.acc.account.i.IAccountMDORService;
import iih.sc.apt.aptip.d.AptIpDO;
import iih.sc.apt.aptip.i.IAptipMDOCudService;
import iih.sc.apt.aptip.i.IAptipMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 取消留观登记
 * 
 * @author liubin
 *
 */
public class CancUrgStayRegistBP {
	/**
	 * 取消留观登记
	 * 
	 * @param urgStayRegistry
	 * @return
	 * @throws BizException
	 */
	public void exec(UrgStayRegistryDTO urgStayRegistry) throws BizException {
		//1、 查找就诊数据
		InpatientDO inpatientDO = new IpEP().getIpByEntId(urgStayRegistry.getId_ent());
		//2..校验
		validate(inpatientDO, urgStayRegistry);
		//3.更新住院信息
		PatiVisitDO pv = updateInpatientDO(inpatientDO, urgStayRegistry);
		//4.更新预检信息
		cancObsErPre(urgStayRegistry);
		//5.更新申请单信息
		cancScAptIp(urgStayRegistry);
		//6.记录取消登记就诊事件
		EnHosRegDTO enHosReg = new EnHosRegDTO();
		enHosReg.setId_ent(urgStayRegistry.getId_ent());
		new EnEvtHandle().insertIpRegistCancelEvt(enHosReg);
		//7.发送集成平台事件
		this.invokeCancelRegistEvent(pv, inpatientDO);
	}
	
	/**
	 * 校验
	 * 
	 * @param inpatientDO
	 * @param urgStayRegistry
	 * @throws BizException
	 */
	private void validate(InpatientDO inpatientDO, UrgStayRegistryDTO urgStayRegistry) throws BizException {
		//1.校验住院数据
		IpEP ipep = new IpEP();
		ipep.validateInpatientDO(inpatientDO);
		//2.预交金校验
		this.checkPrepayment(urgStayRegistry);
	}
	
	/**
	 * 判断预交金是否为0
	 * 
	 * @param id_ent
	 * @throws BizException
	 */
	private void checkPrepayment(UrgStayRegistryDTO urgStayRegistry) throws BizException {
		Integer param = BlParams.BLST0002();
		if(1 == param){//如果是1,取pi_pat_acc的
			IAccountMDORService rervice = ServiceFinder.find(IAccountMDORService.class);
			PiPatAccDO[] pataccs = rervice.findByAttrValString(PiPatAccDO.ID_PAT, urgStayRegistry.getId_pat());
			if (!EnValidator.isEmpty(pataccs)){
				PiPatAccDO pataccDO = pataccs[0];
				if (FDoubleUtils.isMoreThanZero(pataccDO.getPrepay_emgstay())) {
					throw new BizException(IEnMsgConst.ERROR_ENHOSREG_HAS_PREAMT);
				}
			}
		}else if(2 == param){//如果是2,取en_ent_acc的
			IEnaccountMDORService enaccRService = ServiceFinder.find(IEnaccountMDORService.class);
			EnAccountDO[] enAccountDOArray = enaccRService.findByAttrValString(EnAccountDO.ID_ENT, urgStayRegistry.getId_ent());
			if (!EnValidator.isEmpty(enAccountDOArray)) {
				EnAccountDO enaccDO = enAccountDOArray[0];
				if (FDoubleUtils.isMoreThanZero(enaccDO.getAmt_prepay())) {
					throw new BizException(IEnMsgConst.ERROR_ENHOSREG_HAS_PREAMT);
				}
			}
		}else{
			throw new BizException("预交金参数配置有问题!");
		}
	}
	/**
	 * 释放床位
	 * 
	 * @param inpatientDO
	 * @throws BizException
	 */
	private void releaseBed(InpatientDO inpatientDO, PatiVisitDO patiVisitDO) throws BizException {
		// 释放占用床位
		BedEP bedbp = new BedEP();
		if (IEnDictCodeConst.BED_HAS_SEX.equals(EnParamUtils.getBedSexParam(patiVisitDO.getId_dep_nur()))) {
			bedbp.releaseBedWithSex(inpatientDO.getId_ent(), inpatientDO.getId_bed(), FBoolean.FALSE);
		}else {
			bedbp.releaseBed(inpatientDO.getId_ent(), inpatientDO.getId_bed());
		}		
	}
	/**
	 * 更新住院信息
	 * 
	 * @param inpatientDO
	 * @param urgStayRegistry
	 * @throws BizException
	 */
	private PatiVisitDO updateInpatientDO(InpatientDO inpatientDO, UrgStayRegistryDTO urgStayRegistry) throws BizException {
		IpEP ipEp = new IpEP();
		FDateTime curTime = EnAppUtils.getServerDateTime();
		inpatientDO.setStatus(DOStatus.UPDATED);
		// 住院表
		inpatientDO.setSd_status(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALQUIT);// 修改状态
		inpatientDO.setTimes_ip(EnVisitTimesUtils.calcCancObsTimes(urgStayRegistry.getId_pat()));
		if(!EnValidator.isEmpty(inpatientDO.getSd_ip_spec())){
			//患者病案编码表，如果是非普通住院患者
			boolean roolBackAmrCode = new PiPatAmrCodeEP().disOrCancSavePatAmrCodeDO(urgStayRegistry.getId_pat(), inpatientDO.getSd_ip_spec());
			if(roolBackAmrCode){
				inpatientDO.setCode_amr_ip(null);
			}
		}
		 // 退院
		ipEp.save(inpatientDO);
		
		PvEP pvEp = new PvEP();
		// 就诊表
		PatiVisitDO patiVisitDO = pvEp.getPvByPK(urgStayRegistry.getId_ent());
		patiVisitDO.setStatus(DOStatus.UPDATED);
		patiVisitDO.setFg_canc(FBoolean.TRUE); // 退诊标志
		patiVisitDO.setId_emp_canc(EnContextUtils.getPsnId()); // 退诊人员
		patiVisitDO.setDt_canc(curTime); // 取消时间
		patiVisitDO = pvEp.savePv(patiVisitDO);
		
		//3.释放床位
		releaseBed(inpatientDO, patiVisitDO);
		
		return patiVisitDO;
	}
	/**
	 * 取消急诊留观修改预计信息
	 * 
	 * @param urgStayRegistry
	 * @throws BizException
	 */
	private void cancObsErPre(UrgStayRegistryDTO urgStayRegistry) throws BizException{
		ErPreEP ep = new ErPreEP();
		ep.cancObsErPre(urgStayRegistry.getId_ent());
	}
	/**
	 * 取消入院通知单
	 * 
	 * @param urgStayRegistry
	 * @throws BizException
	 */
	private void cancScAptIp(UrgStayRegistryDTO urgStayRegistry) throws BizException {
		if(EnValidator.isEmpty(urgStayRegistry.getId_aptip()))
			return;
		//入院申请单，如果入院申请单的确认标志为false，回退申请单的状态为0 zhangpp 2019.10.18
		IAptipMDORService iAptipMDORService = ServiceFinder.find(IAptipMDORService.class);
		AptIpDO aptIpDO = iAptipMDORService.findById(urgStayRegistry.getId_aptip());
		if (aptIpDO != null && !FBoolean.TRUE.equals(aptIpDO.getFg_cfm())) {
			IAptipMDOCudService iAptipMDOCudService = ServiceFinder.find(IAptipMDOCudService.class);
			aptIpDO.setSd_status(IEnDictCodeConst.SD_STATUS_NOTICE_CREATE);
			aptIpDO.setId_entip(null);
			aptIpDO.setStatus(DOStatus.UPDATED);
			iAptipMDOCudService.save(new AptIpDO[]{aptIpDO});
		}
	}
	
	/**
	 * 取消登记事件
	 * 
	 * @param patiVisitDO
	 * @throws BizException 
	 */
	private void invokeCancelRegistEvent(PatiVisitDO patiVisitDO, InpatientDO inpatientDO) throws BizException {
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
		esDTO.setTimes_ip(inpatientDO.getTimes_ip());
		try {
			IpDisHosEvent disEvent = new IpDisHosEvent();
			disEvent.invoke(esDTO);
		} catch (Exception e) {
			EnLogUtil.getInstance().logError("取消留观登记消息发送失败：",e);
		}
		
	}
}
