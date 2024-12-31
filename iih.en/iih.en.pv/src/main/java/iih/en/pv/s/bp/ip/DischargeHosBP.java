package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.ep.BedEP;
import iih.en.comm.ep.PiPatAmrCodeEP;
import iih.en.comm.evt.EnEvtHandle;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.util.EnVisitTimesUtils;
import iih.en.pv.dto.d.DischargeDTO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.dto.d.DisHos4EsDTO;
import iih.en.pv.inpatient.s.InpatientCrudServiceImpl;
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
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 退院
 * @author renying
 *
 */
public class DischargeHosBP {
			
	/** 
	 * 退院
	 * @param dischargeDTO 退院DTO
	 * @throws BizException 异常
	 */
	public void exec(DischargeDTO dischargeDTO) throws BizException{
		//0.退院前校验状态
		ValidateDischargeInfoBP vb = new ValidateDischargeInfoBP();
		vb.exec(dischargeDTO);
		//1、更新退院状态	
		this.updatePatVisitDO(dischargeDTO);
		//2、释放床位资源
		this.updateBdBed(dischargeDTO);
		//3、记录就诊事件
		new EnEvtHandle().insertDischargeEvt(dischargeDTO);
		try {
			this.invokeDisChargeEvent(dischargeDTO);
		} catch (Exception e) {

		}
	}
	/**
	 * 更新就诊数据
	 * @param dischargeDTO
	 * @throws BizException
	 */
	private void updatePatVisitDO(DischargeDTO dischargeDTO) throws BizException{
		//更新就诊表数据
		PativisitCrudServiceImpl pativisitService = new PativisitCrudServiceImpl();		
		PatiVisitDO entDO = pativisitService.findById(dischargeDTO.getId_ent());
		dischargeDTO.setCode_pat(entDO.getCode_pat());
		entDO.setStatus(DOStatus.UPDATED);
		entDO.setFg_canc(FBoolean.TRUE);
		String operatorId = EnContextUtils.getPsnId();
		entDO.setId_emp_canc(operatorId);
		entDO.setFg_ip(FBoolean.FALSE);
		FDateTime time = EnAppUtils.getServerDateTime();
		entDO.setDt_canc(time);
		pativisitService.update(new PatiVisitDO[]{entDO});	
		//入院申请单，如果入院申请单的确认标志为false，回退申请单的状态为0 zhangpp 2019.10.18
		IAptipMDORService iAptipMDORService = ServiceFinder.find(IAptipMDORService.class);
		AptIpDO[] aptIpDOs = iAptipMDORService.findByAttrValString("Id_entip", dischargeDTO.getId_ent());
		if (aptIpDOs != null && aptIpDOs.length >= 1 && !FBoolean.TRUE.equals(aptIpDOs[0].getFg_cfm())) {
			IAptipMDOCudService iAptipMDOCudService = ServiceFinder.find(IAptipMDOCudService.class);
			aptIpDOs[0].setSd_status(IEnDictCodeConst.SD_STATUS_NOTICE_CREATE);
			aptIpDOs[0].setId_entip(null);
			aptIpDOs[0].setStatus(DOStatus.UPDATED);
			iAptipMDOCudService.save(aptIpDOs);
		}
		//更新住院表数据
		InpatientCrudServiceImpl ipService = new InpatientCrudServiceImpl();
		InpatientDO[] ipDOs = ipService.find(String.format("id_ent='%s'",dischargeDTO.getId_ent()), null, FBoolean.FALSE);
		if(ipDOs!=null && ipDOs.length>0){
			
			//更新患者病案编码表数据，如果是非普通住院患者 zhangpp 2019.10.16
			boolean rollBackAmrCode = new PiPatAmrCodeEP().disOrCancSavePatAmrCodeDO(entDO.getId_pat(), ipDOs[0].getSd_ip_spec());
			
			dischargeDTO.setTimes_ip(ipDOs[0].getTimes_ip());
			InpatientDO ipDO = ipDOs[0];
			ipDO.setSd_status(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALQUIT);
			ipDO.setStatus(DOStatus.UPDATED);
			ipDO.setTimes_ip(EnVisitTimesUtils.calcCancIpTimes(entDO.getId_pat()));
			if (rollBackAmrCode) {
				ipDO.setCode_amr_ip(null);
			}
			ipService.save(new InpatientDO[]{ipDO});
			//住院表数据更新后同步患者表住院次数
			this.SetPatDo(entDO.getId_pat());
		}	
	}
	
	/**
	 * 同步患者表住院次数
	 * @param times
	 * @throws BizException 
	 */
	private void SetPatDo(String id_pat) throws BizException{
		IPatiMDORService iPatiRService = ServiceFinder.find(IPatiMDORService.class);
		IPatiMDOCudService iPatiCudService = ServiceFinder.find(IPatiMDOCudService.class);
		PatDO patdo = iPatiRService.findById(id_pat);
		if(patdo != null){
			patdo.setLast_times_ip(patdo.getLast_times_ip() - 1);
			iPatiCudService.update(new PatDO[]{patdo});
		}
	}
	
	/**
	 * 释放床位资源
	 * @param dischargeDTO
	 * @throws BizException
	 */
	private void updateBdBed(DischargeDTO dischargeDTO) throws BizException{
		BedEP  bedbp = new BedEP();
		if (IEnDictCodeConst.BED_HAS_SEX.equals(EnParamUtils.getBedSexParam(dischargeDTO.getId_dep_nur()))) {
			bedbp.releaseBedWithSex(dischargeDTO.getId_ent(), dischargeDTO.getId_bed(), FBoolean.FALSE);
			return;
		}
		bedbp.releaseBed(dischargeDTO.getId_ent(), dischargeDTO.getId_bed());		
	}
	
	/**
	 * 退院事件
	 * @param disDTO
	 * @throws BizException
	 */
	private void invokeDisChargeEvent(DischargeDTO disDTO) throws BizException
	{
		DisHos4EsDTO esDTO = new DisHos4EsDTO();
		esDTO.setId_ent(disDTO.getId_ent());
		esDTO.setId_pat(disDTO.getId_pat());
		esDTO.setId_dep_nur(disDTO.getId_dep_nur());
		esDTO.setId_dep_phy(disDTO.getId_dep_phy());
		esDTO.setBed_code(disDTO.getName_bed());
		esDTO.setDt_lv(EnAppUtils.getServerDateTime());
		esDTO.setEvent_source(IEventType.TYPE_INSERT_AFTER);
		esDTO.setId_dep_opr(EnContextUtils.getDeptId());  //操作科室
		esDTO.setId_emp_opr(EnContextUtils.getPsnId());//操作员
		esDTO.setDt_opr(EnAppUtils.getServerDateTime());
		esDTO.setCode_pat(disDTO.getCode_pat());
		esDTO.setTimes_ip(disDTO.getTimes_ip());
		
		IpDisHosEvent disEvent = new IpDisHosEvent();
		disEvent.invoke(esDTO);
	}
	
}
