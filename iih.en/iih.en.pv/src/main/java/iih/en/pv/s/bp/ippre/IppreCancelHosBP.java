package iih.en.pv.s.bp.ippre;

import iih.bd.bc.udi.pub.IBdBcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.BedEP;
import iih.en.comm.ep.EntBedEP;
import iih.en.comm.evt.EnEvtHandle;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.pv.dto.d.LvHosAppDTO;
import iih.en.pv.inpatient.d.EnIppreDO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.d.desc.InpatientDODesc;
import iih.en.pv.inpatient.dto.d.EnIppreCancelHosDTO;
import iih.en.pv.inpatient.i.IEnippreCudService;
import iih.en.pv.inpatient.i.IEnippreRService;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.en.pv.inpatient.s.InpatientCrudServiceImpl;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.s.PativisitCrudServiceImpl;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/***
 * 预住院中止住院BP
 * @author zhangpp
 *
 */
public class IppreCancelHosBP {

	public void exec(EnIppreCancelHosDTO enIppreCancelDto) throws BizException{
		
		//校验状态
		this.validate(enIppreCancelDto);
		//所有时间都使用同一时间
		FDateTime leaveTime = EnAppUtils.getServerDateTime();
		//调用费用接口关账
		//TODO 调用接口
		//更新预住院表
		this.updateEnIppre(enIppreCancelDto,leaveTime);
		//更新就诊和住院状态	
		this.updatePatVisitDO(enIppreCancelDto, leaveTime);
		//释放床位资源
		this.updateBdBed(enIppreCancelDto);
		//更新就诊床位信息
		this.updateEnBedDO(enIppreCancelDto, leaveTime);
		//记录就诊事件
		new EnEvtHandle().insertCancelHosEvt(enIppreCancelDto, leaveTime);
		//try {
			//预住院中止入院事件
			//this.invokeIppreCancelHosEvent(enIppreCancelDto);
		//} catch (Exception e) {
		//	Logger.error("预住院中止入院消息发送失败：",e);
		//}
	}
	
	/**
	 * 校验状态
	 * @param enIppreCancelDto
	 * @throws BizException
	 */
	private void validate(EnIppreCancelHosDTO enIppreCancelDto) throws BizException{
		if(enIppreCancelDto==null || StringUtil.isEmpty(enIppreCancelDto.getId_ent() ))
			throw new BizException("该患者不存在");		
		this.validateInpatientDO(enIppreCancelDto);
	}
	
	/**
	 * 更新预住院表
	 * @param enIppreCancelDto
	 * @param leaveTime 
	 * @throws BizException 
	 */
	private void updateEnIppre(EnIppreCancelHosDTO enIppreCancelDto, FDateTime leaveTime) throws BizException{	
		IEnippreRService iRService = ServiceFinder.find(IEnippreRService.class);
		IEnippreCudService iCudService = ServiceFinder.find(IEnippreCudService.class);
		EnIppreDO[] enIppreDOs = iRService.find(" id_ent = '" + enIppreCancelDto.getId_ent() + "' ", "", FBoolean.FALSE);
		if (!ArrayUtil.isEmpty(enIppreDOs)) {
			enIppreDOs[0].setSd_status(IEnDictCodeConst.SD_STATUS_IPPRE_HOS_STOP);
			enIppreDOs[0].setNote_canc(enIppreCancelDto.getNote());
			enIppreDOs[0].setStatus(DOStatus.UPDATED);
			enIppreDOs[0].setDt_end_ippre(leaveTime);
			iCudService.update(new EnIppreDO[]{enIppreDOs[0]});
		}
	}
	
	/**
	 * 更新就诊和住院状态
	 * @param enIppreCancelDto
	 * @param leaveTime
	 * @throws BizException
	 */
	private void updatePatVisitDO(EnIppreCancelHosDTO enIppreCancelDto, FDateTime leaveTime) throws BizException{
		PativisitCrudServiceImpl pativisitService = new PativisitCrudServiceImpl();		
		PatiVisitDO entDO = pativisitService.findById(enIppreCancelDto.getId_ent());
		//enIppreCancelDto.setCode_pat(entDO.getCode_pat());
		entDO.setStatus(DOStatus.UPDATED);
		entDO.setFg_ip(FBoolean.FALSE);// 出院
		entDO.setDt_end(leaveTime);// 就诊结束时间
		pativisitService.update(new PatiVisitDO[]{entDO});	
		
		InpatientCrudServiceImpl ipService = new InpatientCrudServiceImpl();
		InpatientDO[] ipDOs = ipService.find(String.format("id_ent='%s'",enIppreCancelDto.getId_ent()), null, FBoolean.FALSE);
		if(ipDOs!=null && ipDOs.length>0){
			for (InpatientDO ipDO : ipDOs) {
				ipDO.setId_dep_phydisc(enIppreCancelDto.getId_ippre_phy());// 科室
				ipDO.setId_dep_nurdisc(enIppreCancelDto.getId_ippre_nur());// 病区
				ipDO.setSd_status(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT);// 就诊状态改为出院
				ipDO.setDt_disc(leaveTime);
				ipDO.setId_emp_disc(EnContextUtils.getPsnId());
				ipDO.setStatus(DOStatus.UPDATED);
				//if(enIppreCancelDto.getId_ent().equals(ipDO.getId_ent()))
				//	this.updateIpGoWhereAndOutComes(ipDO, enIppreCancelDto.getId_or());
			}
		}
		ipService.save(ipDOs);	
	}
	/**
	 * 释放床位资源
	 * @param enIppreCancelDto
	 * @throws BizException
	 */
	private void updateBdBed(EnIppreCancelHosDTO enIppreCancelDto) throws BizException{
		BedEP  bedbp = new BedEP();
		if (IEnDictCodeConst.BED_HAS_SEX.equals(EnParamUtils.getBedSexParam(enIppreCancelDto.getId_ippre_nur()))) {
			bedbp.releaseBedWithSex(enIppreCancelDto.getId_ent(), enIppreCancelDto.getId_bed(), FBoolean.FALSE);
			return;
		}
		bedbp.releaseBed(enIppreCancelDto.getId_ent(), enIppreCancelDto.getId_bed());		
	}
	
	
	/**
	 * 更新就诊床位信息
	 * 
	 * @param enIppreCancelDto
	 * @param leaveTime
	 * @throws BizException
	 */
	private void updateEnBedDO(EnIppreCancelHosDTO enIppreCancelDto, FDateTime leaveTime) throws BizException {
		EntBedEP entBedEP = new EntBedEP();
		entBedEP.endUseBed(enIppreCancelDto.getId_ent(), leaveTime);
	}
	/**
	 * 校验住院数据
	 * @param enIppreCancelDto
	 * @throws BizException
	 */
	private void validateInpatientDO(EnIppreCancelHosDTO enIppreCancelDto) throws BizException {
		// 入科校验
		IInpatientRService ipRService = ServiceFinder.find(IInpatientRService.class);
		String whereStr = InpatientDODesc.TABLE_ALIAS_NAME + ".id_ent = '" + enIppreCancelDto.getId_ent() + "'";
		InpatientDO[] inpatientDOs = ipRService.find(whereStr, null, FBoolean.FALSE);
		if (ArrayUtil.isEmptyNoNull(inpatientDOs)) {
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_INPATIENTDO);
		}
		InpatientDO inpatientDO = inpatientDOs[0];
		if (!inpatientDO.getSd_status().equals(IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN)) {
			throw  new BizException(IEnMsgConst.ERROR_ENT_STATUS_STATUS);
		}
	}
	
	/**
	 * 预住院中止入院事件
	 * @param enIppreDTO
	 * @throws BizException
	 */
	private void invokeIppreCancelHosEvent(EnIppreCancelHosDTO enIppreDTO) throws BizException
	{
		//DisHos4EsDTO esDTO = new DisHos4EsDTO();
		//esDTO.setId_ent(disDTO.getId_ent());
		//esDTO.setId_pat(disDTO.getId_pat());
		//esDTO.setId_dep_nur(disDTO.getId_dep_nur());
		//esDTO.setId_dep_phy(disDTO.getId_dep_phy());
		//esDTO.setBed_code(disDTO.getName_bed());
		//esDTO.setDt_lv(EnAppUtils.getServerDateTime());
		//esDTO.setEvent_source(IEventType.TYPE_INSERT_AFTER);
		//esDTO.setId_dep_opr(EnContextUtils.getDeptId());  //操作科室
		//esDTO.setId_emp_opr(EnContextUtils.getPsnId());//操作员
		//esDTO.setDt_opr(EnAppUtils.getServerDateTime());
		//esDTO.setCode_pat(disDTO.getCode_pat());
		//esDTO.setTimes_ip(disDTO.getTimes_ip());
		
		//IpDisHosEvent disEvent = new IpDisHosEvent();
		//disEvent.invoke(esDTO);
	}
}
