package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.res.bed.d.Bdbed;
import iih.bd.res.bed.i.IBedMDOCudService;
import iih.bd.res.bed.i.IBedMDORService;
import iih.bd.res.bizgrp.d.BizGroupDO;
import iih.bd.res.bizgrp.i.IBizgrpMDOCudService;
import iih.bd.res.bizgrp.i.IBizgrpMDORService;
import iih.bl.cg.service.i.IBLChargesService;
import iih.ci.ord.i.ICiOrdQryService;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.evt.EnEvtHandle;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.DischargeDTO;
import iih.en.pv.enres.d.EnBedDO;
import iih.en.pv.enres.d.EnDepDO;
import iih.en.pv.enres.d.EnMedGrpDO;
import iih.en.pv.enres.d.EnPsnDO;
import iih.en.pv.enres.i.IEnbedCudService;
import iih.en.pv.enres.i.IEnbedRService;
import iih.en.pv.enres.i.IEndepCudService;
import iih.en.pv.enres.i.IEndepRService;
import iih.en.pv.enres.i.IEnmedgrpCudService;
import iih.en.pv.enres.i.IEnmedgrpRService;
import iih.en.pv.enres.i.IEnpsnCudService;
import iih.en.pv.enres.i.IEnpsnRService;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.d.desc.InpatientDODesc;
import iih.en.pv.inpatient.dto.d.CancelEnterDept4EsDTO;
import iih.en.pv.inpatient.i.IInpatientCudService;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitCudService;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.en.pv.s.bp.ip.qry.GetDisChargeBP;
import iih.en.pv.s.event.IpCancelEnterDeptEvent;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 取消入科
 * @author zhangpp-2018.12.11
 *
 */
public class DisIpacptBP {
	
	public void exec(DischargeDTO dischargeDTO) throws BizException{

		//取消入科前校验数据
		this.validateDisIpacpt(dischargeDTO);
		//更新状态
		String Id_ent = dischargeDTO.getId_ent();
		//1.更新bd_bed
		this.updateBdBed(dischargeDTO);
		//2.更新en_ent
		this.updatepatVisit(Id_ent);
		//3.更新en_ent_ip
		this.updateInpatient(Id_ent);
		//4.更新en_ent_emp
		this.deleteEntEmp(Id_ent);
		//5.更新en_ent_bed
		this.deleteEntBed(Id_ent);
		//6.更新en_ent_dep
		this.deleteEntDep(Id_ent);
		//7.更新en_ent_wg
		this.deleteEntWg(Id_ent);
		//8.更新bd_wg
		this.updateBdWg(Id_ent);
		//9.添加取消入科就诊事件
		new EnEvtHandle().insertDisIpacptEvt(dischargeDTO);
		//10.触发事件
		this.invokeCancelEvent(dischargeDTO);
	}
	/**
	 * 取消入科前校验数据
	 * @param dischargeDTO
	 * @throws BizException
	 */
	private void validateDisIpacpt(DischargeDTO dischargeDTO) throws BizException {		
		if(dischargeDTO==null || EnValidator.isEmpty(dischargeDTO.getId_ent() ))
			throw new BizException("该患者不存在");
		IInpatientRService ipRService = ServiceFinder.find(IInpatientRService.class);
		String whereStr = InpatientDODesc.TABLE_ALIAS_NAME + ".id_ent = '" + dischargeDTO.getId_ent() + "'";
		InpatientDO[] inpatientDOs = ipRService.find(whereStr, null, FBoolean.FALSE);
		if (EnValidator.isEmpty(inpatientDOs)) {
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_INPATIENTDO);
		}
		InpatientDO inpatientDO = inpatientDOs[0];
		if (!inpatientDO.getSd_status().equals(IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN)) {
			throw  new BizException(IEnMsgConst.ERROR_ENT_STATUS_STATUS);
		}
		String erroMsg = "";
		GetDisChargeBP checkBp = new GetDisChargeBP();
		if(GetDisChargeBP.HAS_VALUE.equals(checkBp.checkConsume(dischargeDTO.getId_ent())))
			erroMsg += GetDisChargeBP.HAS_VALUE +";";
		String erro_or = checkBp.checkOR(dischargeDTO.getId_ent());
		if(!EnValidator.isEmpty(erro_or))
			erroMsg += erro_or+";";
		if(!EnValidator.isEmpty(erroMsg)){
			throw  new BizException(erroMsg);
		}
	}
	
	/**
	 * 更新bd_bed
	 * @param dischargeDTO
	 * @throws BizException
	 */
	private void updateBdBed(DischargeDTO dischargeDTO) throws BizException {
		IBedMDOCudService iCudService = ServiceFinder.find(IBedMDOCudService.class);
		IBedMDORService iRService = ServiceFinder.find(IBedMDORService.class);
		String Id_bed = dischargeDTO.getId_bed();
		Bdbed bedDO = iRService.findById(Id_bed);
		bedDO.setId_bedsu(IBdResDictCodeConst.ID_BEDSU_OCCUPYBYIN);
		bedDO.setSd_bedsu(IBdResDictCodeConst.SD_BEDSU_OCCUPYBYIN);
		bedDO.setFg_appt(FBoolean.FALSE);
		bedDO.setStatus(DOStatus.UPDATED);
		iCudService.save(new Bdbed[]{bedDO});
	}
	
	/**
	 * 更新en_ent
	 * @param dischargeDTO
	 * @throws BizException
	 */
	private void updatepatVisit(String id_ent) throws BizException {		
		IPativisitCudService iCudService = ServiceFinder.find(IPativisitCudService.class);
		IPativisitRService iRService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO patiVisitDO = iRService.findById(id_ent);
		patiVisitDO.setId_emp_phy(null);
		patiVisitDO.setId_emp_nur(null);
		patiVisitDO.setFg_acptvalid(FBoolean.FALSE);
		patiVisitDO.setFg_ip(FBoolean.FALSE);
		patiVisitDO.setDt_acpt(null);
		patiVisitDO.setId_wg_phy(null);
		patiVisitDO.setStatus(DOStatus.UPDATED);
		iCudService.save(new PatiVisitDO[]{patiVisitDO});
	}
	/**
	 * 更新en_ent_ip
	 * @param dischargeDTO
	 * @param id_ent
	 * @throws BizException
	 */
	private void updateInpatient(String id_ent) throws BizException {	
		IInpatientCudService iCudService = ServiceFinder.find(IInpatientCudService.class);
		IInpatientRService iRService = ServiceFinder.find(IInpatientRService.class);
		InpatientDO[] inpatientDOs = iRService.findByAttrValString(InpatientDO.ID_ENT, id_ent);
		InpatientDO inpatientDO = inpatientDOs[0];
		inpatientDO.setSd_status(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN);
		inpatientDO.setStatus(DOStatus.UPDATED);
		iCudService.save(inpatientDOs);
	}
	/**
	 * 更新en_ent_emp
	 * @param dischargeDTO
	 * @param whereStr
	 * @throws BizException
	 */
	private void deleteEntEmp(String id_ent) throws BizException {
		IEnpsnCudService iCudService = ServiceFinder.find(IEnpsnCudService.class);
		IEnpsnRService iRService = ServiceFinder.find(IEnpsnRService.class);
		EnPsnDO[] enPsnDOs = iRService.findByAttrValString(EnPsnDO.ID_ENT, id_ent);
		iCudService.delete(enPsnDOs);
	}
	/**
	 * 更新en_ent_bed
	 * @param dischargeDTO
	 * @param whereStr
	 * @throws BizException
	 */
	private void deleteEntBed(String id_ent) throws BizException {
		IEnbedCudService iCudService = ServiceFinder.find(IEnbedCudService.class);
		IEnbedRService iRService = ServiceFinder.find(IEnbedRService.class);
		EnBedDO[] enBedDOs = iRService.findByAttrValString(EnBedDO.ID_ENT, id_ent);
		iCudService.delete(enBedDOs);
	}
	/**
	 * 更新en_ent_dep
	 * @param dischargeDTO
	 * @param whereStr
	 * @throws BizException
	 */
	private void deleteEntDep(String id_ent) throws BizException {
		IEndepCudService iCudService = ServiceFinder.find(IEndepCudService.class);
		IEndepRService iRService = ServiceFinder.find(IEndepRService.class);
		EnDepDO[] enDepDOs = iRService.findByAttrValString(EnDepDO.ID_ENT, id_ent);
		iCudService.delete(enDepDOs);
	}
	/**
	 * 更新en_ent_wg
	 * @param dischargeDTO
	 * @param whereStr
	 * @throws BizException
	 */
	private void deleteEntWg(String id_ent) throws BizException {
		IEnmedgrpCudService iCudService = ServiceFinder.find(IEnmedgrpCudService.class);
		IEnmedgrpRService iRService = ServiceFinder.find(IEnmedgrpRService.class);
		EnMedGrpDO[] enMedGrpDOs = iRService.findByAttrValString(EnMedGrpDO.ID_ENT, id_ent);
		iCudService.delete(enMedGrpDOs);	
	}
	/**
	 * 更新bd_wg
	 * @param dischargeDTO
	 * @throws BizException
	 */
	private void updateBdWg(String Id_ent) throws BizException {
		IBizgrpMDOCudService bizCServie = ServiceFinder.find(IBizgrpMDOCudService.class);
		IBizgrpMDORService bizRServie = ServiceFinder.find(IBizgrpMDORService.class);
		BizGroupDO[] bizdos = bizRServie.findByAttrValString(BizGroupDO.ID_ENT_USED, Id_ent);
		if(EnValidator.isEmpty(bizdos)){
			return;
		}
		BizGroupDO bizdo = bizdos[0];
		bizdo.setId_ent_used("~");
		bizdo.setStatus(DOStatus.UPDATED);
		bizCServie.save(new BizGroupDO[]{bizdo});
	}
	
	private void invokeCancelEvent(DischargeDTO dischargeDTO) throws BizException{
		//1.构造事件源
		CancelEnterDept4EsDTO esDTO = new CancelEnterDept4EsDTO();
		esDTO.setId_ent(dischargeDTO.getId_ent());
		esDTO.setCode_ent(dischargeDTO.getCode_ent());
		esDTO.setId_pat(dischargeDTO.getId_pat());
		esDTO.setEvent_source(IEventType.TYPE_UPDATE_AFTER);
		esDTO.setId_dep_phy(dischargeDTO.getId_dep_phy());
		esDTO.setName_dep_phy(dischargeDTO.getName_dep_phy());
		esDTO.setId_dep_nur(dischargeDTO.getId_dep_nur());
		esDTO.setName_dep_nur(dischargeDTO.getName_dep_nur());
		esDTO.setId_emp_phy(dischargeDTO.getId_emp_phy());
		esDTO.setName_emp_phy(dischargeDTO.getName_emp_phy());
		esDTO.setId_emp_nur(dischargeDTO.getId_emp_nur());
		esDTO.setName_emp_nur(dischargeDTO.getName_emp_nur());
		esDTO.setId_bed(dischargeDTO.getId_bed());
		esDTO.setName_bed(dischargeDTO.getName_bed());
		esDTO.setError_bl(dischargeDTO.getError_bl());
		esDTO.setFg_newborn(dischargeDTO.getFg_newborn());
		esDTO.setAmt_prepay(dischargeDTO.getAmt_prepay());
		esDTO.setDt_acpt(dischargeDTO.getDt_acpt());
		esDTO.setFg_ip(dischargeDTO.getFg_ip());
		esDTO.setSd_status(dischargeDTO.getSd_status());
		esDTO.setId_emp_opr(EnContextUtils.getPsnId());
		esDTO.setId_dep_opr(EnContextUtils.getDeptId());
		esDTO.setDt_opr(EnAppUtils.getServerDateTime());
		//2.触发
		IpCancelEnterDeptEvent event = new IpCancelEnterDeptEvent();
		event.invoke(esDTO);
	}
}
