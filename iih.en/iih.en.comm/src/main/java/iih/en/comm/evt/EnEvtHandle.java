package iih.en.comm.evt;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.res.bed.d.Bdbed;
import iih.en.comm.ep.EnEvtEP;
import iih.en.comm.ep.PiPatEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.dto.d.UrgStayRegistryDTO;
import iih.en.pv.dto.d.DischargeDTO;
import iih.en.pv.dto.d.EnDepDTO;
import iih.en.pv.dto.d.EnHosRegDTO;
import iih.en.pv.dto.d.HosRecallDTO;
import iih.en.pv.dto.d.LvHosAppDTO;
import iih.en.pv.dto.d.TransDepPatDTO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.inpatient.dto.d.BedBigCardDTO;
import iih.en.pv.inpatient.dto.d.EnIppreCancelHosDTO;
import iih.en.pv.inpatient.dto.d.EnIppreInfoDTO;
import iih.en.pv.inpatient.dto.d.EnIppreTransHosDTO;
//import iih.en.pv.inpatient.dto.d.EnIppreCancelHosDTO;
//import iih.en.pv.inpatient.dto.d.EnIppreTransHosDTO;
import iih.en.pv.out.d.EnEvtDTO;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.dto.d.OpRegPatDTO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.que.dto.d.TriageQueSiteDTO;
import iih.pi.reg.pat.d.PatDO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Logger;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 就诊事件处理
 * 
 * @author liubin
 *
 */
public class EnEvtHandle{
	private EnEvtEP ep;
	
	public EnEvtHandle(){
		ep = new EnEvtEP();
	}
	
	/**
	 * 添加挂号就诊事件
	 */
	public void insertOpRegistEvt(String entId, RegInfoDTO regInfo) throws BizException{
		EnEvtDTO evt = new EnEvtDTO();
		evt.setId_ent(entId);
		evt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_OPREGIST);
		evt.setShort_des("挂号");
		evt.setDes("挂号");
		evt.setDt_evt(EnAppUtils.getServerDateTime());
		evt.setDt_insert(evt.getDt_evt());
		evt.setId_emp_rec(EnContextUtils.getPsnId());
		ep.insertEvt(new EnEvtDTO[]{evt});
	}
	/**
	 * 添加分诊就诊事件
	 * 
	 * @param enQueId
	 * @throws BizException
	 */
	public void insertTriageEvt(String entId, TriageQueSiteDTO triageQueSite) throws BizException{
		EnEvtDTO evt = new EnEvtDTO();
		evt.setId_ent(entId);
		evt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_TRIAGE);
		evt.setShort_des("分诊");
		evt.setDes(String.format("分诊<队列:%s, 诊台:%s, 医生:%s>", triageQueSite.getName_que(), triageQueSite.getName_quesite(), triageQueSite.getEmp_name()));
		evt.setDt_evt(EnAppUtils.getServerDateTime());
		evt.setDt_insert(evt.getDt_evt());
		evt.setId_emp_rec(EnContextUtils.getPsnId());
		ep.insertEvt(new EnEvtDTO[]{evt});
	}
	/**
	 * 添加接诊就诊事件
	 * 
	 * @param entId
	 * @param queSite
	 * @throws BizException
	 */
	public void insertAcptEvt(String entId, QueSiteDO queSite) throws BizException{
		EnEvtDTO evt = new EnEvtDTO();
		evt.setId_ent(entId);
		evt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_ACPT);
		evt.setShort_des("接诊");
		evt.setDes(String.format("接诊<科室:%s, 诊台:%s, 医生:%s>", queSite.getDep_name(), queSite.getName(), queSite.getEmp_name()));
		evt.setDt_evt(EnAppUtils.getServerDateTime());
		evt.setDt_insert(evt.getDt_evt());
		evt.setId_emp_rec(EnContextUtils.getPsnId());
		ep.insertEvt(new EnEvtDTO[]{evt});
	}
	/**
	 * 添加留观登记就诊事件
	 * 
	 * @param urgStayRegistry
	 * @throws BizException
	 */
	public void insertIpRegistEvt(UrgStayRegistryDTO urgStayRegistry) throws BizException{
		FDateTime curTime = EnAppUtils.getServerDateTime();
		EnEvtDTO ipRegistEvt = new EnEvtDTO();
		ipRegistEvt.setId_ent(urgStayRegistry.getId_ent());
		ipRegistEvt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_IPREGIST);
		ipRegistEvt.setShort_des("入院登记");
		ipRegistEvt.setDes(String.format("入院登记<科室:%s, 病区:%s, 床位:%s>", urgStayRegistry.getName_dep_phyadm(), urgStayRegistry.getName_dep_nuradm(), urgStayRegistry.getName_bed()));
		ipRegistEvt.setDt_evt(curTime);
		ipRegistEvt.setDt_insert(curTime);
		ipRegistEvt.setId_emp_rec(EnContextUtils.getPsnId());
		EnEvtDTO useBedEvt = new EnEvtDTO();
		useBedEvt.setId_ent(urgStayRegistry.getId_ent());
		useBedEvt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_DISTRIBUTIONBED);
		useBedEvt.setShort_des("入院分配床位");
		useBedEvt.setDes(String.format("入院分配床位<床位:%s>", urgStayRegistry.getName_bed()));
		useBedEvt.setDt_evt(curTime);
		useBedEvt.setDt_insert(curTime);
		useBedEvt.setVal_new(urgStayRegistry.getId_bed());
		useBedEvt.setId_emp_rec(EnContextUtils.getPsnId());
		ep.insertEvt(new EnEvtDTO[]{ipRegistEvt, useBedEvt});
	}
	/**
	 * 添加入院就诊事件
	 * 
	 * @param enHosRegDTO
	 * @throws BizException
	 */
	public void insertIpRegistEvt(EnHosRegDTO enHosRegDTO) throws BizException{
		FDateTime curTime = EnAppUtils.getServerDateTime();
		EnEvtDTO ipRegistEvt = new EnEvtDTO();
		ipRegistEvt.setId_ent(enHosRegDTO.getId_ent());
		ipRegistEvt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_IPREGIST);
		ipRegistEvt.setShort_des("入院登记");
		ipRegistEvt.setDes(String.format("入院登记<科室:%s, 病区:%s, 床位:%s>", enHosRegDTO.getPhy_name(), enHosRegDTO.getNur_name(), enHosRegDTO.getBedname()));
		ipRegistEvt.setDt_evt(curTime);
		ipRegistEvt.setDt_insert(curTime);
		ipRegistEvt.setId_emp_rec(EnContextUtils.getPsnId());
		EnEvtDTO useBedEvt = new EnEvtDTO();
		useBedEvt.setId_ent(enHosRegDTO.getId_ent());
		useBedEvt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_DISTRIBUTIONBED);
		useBedEvt.setShort_des("入院分配床位");
		useBedEvt.setDes(String.format("入院分配床位<床位:%s>", enHosRegDTO.getBedname()));
		useBedEvt.setDt_evt(curTime);
		useBedEvt.setDt_insert(curTime);
		useBedEvt.setVal_new(enHosRegDTO.getId_bed());
		useBedEvt.setId_emp_rec(EnContextUtils.getPsnId());
		ep.insertEvt(new EnEvtDTO[]{ipRegistEvt, useBedEvt});
	}
	/**
	 * 添加入科就诊事件
	 * 
	 * @param enHosRegDTO
	 * @throws BizException
	 */
	public void insertEnterDepEvt(EnDepDTO enDepDTO) throws BizException{
		FDateTime curTime = EnAppUtils.getServerDateTime();
		EnEvtDTO enterDepEvt = new EnEvtDTO();
		enterDepEvt.setId_ent(enDepDTO.getId_ent());
		enterDepEvt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_ENTERDEP);
		enterDepEvt.setShort_des("入科");
		enterDepEvt.setDes(String.format("入科<床位:%s, 责任医生:%s, 责任护士:%s>", enDepDTO.getBed_name(), enDepDTO.getPhy_name(), enDepDTO.getNur_name()));
		enterDepEvt.setDt_evt(curTime);
		enterDepEvt.setDt_insert(curTime);
		enterDepEvt.setId_emp_rec(EnContextUtils.getPsnId());
		EnEvtDTO useBedEvt = new EnEvtDTO();
		useBedEvt.setId_ent(enDepDTO.getId_ent());
		useBedEvt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_DISTRIBUTIONBED);
		useBedEvt.setShort_des("入科分配床位");
		useBedEvt.setDes(String.format("入科分配床位<床位:%s>", enDepDTO.getBed_name()));
		useBedEvt.setDt_evt(curTime);
		useBedEvt.setDt_insert(curTime);
		useBedEvt.setVal_old(enDepDTO.getId_bed_old());
		useBedEvt.setVal_new(enDepDTO.getId_bed());
		useBedEvt.setId_emp_rec(EnContextUtils.getPsnId());
		ep.insertEvt(new EnEvtDTO[]{enterDepEvt, useBedEvt});
	}
	/**
	 * 添加 接收预住院事件
	 * 
	 * @param enHosRegDTO
	 * @throws BizException
	 */
	public void insertAccepteEnterDepEvt(EnDepDTO enDepDTO) throws BizException{
		FDateTime curTime = EnAppUtils.getServerDateTime();
		EnEvtDTO enterDepEvt = new EnEvtDTO();
		enterDepEvt.setId_ent(enDepDTO.getId_ent());
		enterDepEvt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_ENTERDEP);
		enterDepEvt.setShort_des("接受预住院");
		enterDepEvt.setDes(String.format("入科<床位:%s, 责任医生:%s, 责任护士:%s>", enDepDTO.getBed_name(), enDepDTO.getPhy_name(), enDepDTO.getNur_name()));
		enterDepEvt.setDt_evt(curTime);
		enterDepEvt.setDt_insert(curTime);
		enterDepEvt.setId_emp_rec(EnContextUtils.getPsnId());
		EnEvtDTO useBedEvt = new EnEvtDTO();
		useBedEvt.setId_ent(enDepDTO.getId_ent());
		useBedEvt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_ENIPPRE);
		useBedEvt.setShort_des("接受预住院分配床位");
		useBedEvt.setDes(String.format("接受预住院分配床位<床位:%s>", enDepDTO.getBed_name()));
		useBedEvt.setDt_evt(curTime);
		useBedEvt.setDt_insert(curTime);
		useBedEvt.setVal_old(enDepDTO.getId_bed_old());
		useBedEvt.setVal_new(enDepDTO.getId_bed());
		useBedEvt.setId_emp_rec(EnContextUtils.getPsnId());
		ep.insertEvt(new EnEvtDTO[]{enterDepEvt, useBedEvt});
		//发送事件
		useBedEvt.setId_dep_oper(EnContextUtils.getDeptId());
		String event = IEnDictCodeConst.SD_ENTEVT_ENIPPRE;
		BusinessEvent opRegEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_IP_ENT, IEnEventConst.EVENT_EN_PRE_IP,useBedEvt);
		Logger.info("发送预住院就诊变更事件: "+event+";发送数据：" + useBedEvt);
		EventDispatcher.fireEvent(opRegEvent); 
	}
	/**
	 * 添加出院就诊事件
	 * 
	 * @param appDTO
	 * @throws BizException
	 */
	public void insertLvHosEvt(LvHosAppDTO app, List<String> entList, List<LvHosAppDTO> dtOutOrList, boolean isDtOutOr) throws BizException{
		List<EnEvtDTO> list = new ArrayList<EnEvtDTO>();
		for(String ent : entList){
			FDateTime dt_end = app.getDt_disc();
			if (isDtOutOr) {
				for (LvHosAppDTO lvHosDto : dtOutOrList) {
					if (ent.equals(lvHosDto.getId_ent()) && lvHosDto.getDt_outor() != null) {
						dt_end = lvHosDto.getDt_outor();
					}
				}	
			}
			EnEvtDTO evt = new EnEvtDTO();
			evt.setId_ent(ent);
			evt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_LVHOS);
			evt.setShort_des("出院");
			evt.setDes(String.format("出院<科室:%s, 病区:%s, 出院时间:%s>", app.getName_dep(), app.getName_nur(), dt_end));
			evt.setDt_evt(EnAppUtils.getServerDateTime());
			evt.setDt_insert(evt.getDt_evt());
			evt.setId_emp_rec(EnContextUtils.getPsnId());
			evt.setVal_new(dt_end.toString());
			list.add(evt);
		}
		ep.insertEvt(list.toArray(new EnEvtDTO[0]));
	}
	/**
	 * 添加预住院患者出院就诊事件
	 * 
	 * @param appDTO
	 * @throws BizException
	 */
	public void insertIppreLvHosEvt(LvHosAppDTO app, List<String> entList, List<LvHosAppDTO> dtOutOrList, boolean isDtOutOr) throws BizException{
		List<EnEvtDTO> list = new ArrayList<EnEvtDTO>();
		for(String ent : entList){
			FDateTime dt_end = app.getDt_disc();
			if (isDtOutOr) {
				for (LvHosAppDTO lvHosDto : dtOutOrList) {
					if (ent.equals(lvHosDto.getId_ent()) && lvHosDto.getDt_outor() != null) {
						dt_end = lvHosDto.getDt_outor();
					}
				}	
			}
			EnEvtDTO evt = new EnEvtDTO();
			evt.setId_ent(ent);
			evt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_IPPRELVHOS);
			evt.setShort_des("预住院出院");
			evt.setDes(String.format("预住院出院<科室:%s, 病区:%s, 出院时间:%s>", app.getName_dep(), app.getName_nur(), dt_end));
			evt.setDt_evt(EnAppUtils.getServerDateTime());
			evt.setDt_insert(evt.getDt_evt());
			evt.setId_emp_rec(EnContextUtils.getPsnId());
			evt.setVal_new(dt_end.toString());
			list.add(evt);
		}
		ep.insertEvt(list.toArray(new EnEvtDTO[0]));
		//发送就诊变更事件
		if(list.size()>0){
			for (EnEvtDTO enEvtDTO : list) {
				enEvtDTO.setId_dep_oper(EnContextUtils.getDeptId());
				String event = IEnDictCodeConst.SD_ENTEVT_IPPRELVHOS;
				BusinessEvent opRegEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_IP_ENT, IEnEventConst.EVENT_EN_PRE_IP,enEvtDTO);
				Logger.info("发送预住院就诊变更事件: "+event+";发送数据：" + enEvtDTO);
				EventDispatcher.fireEvent(opRegEvent); 
			}
		}
	}
	/**
	 * 添加出院召回就诊事件
	 * 
	 * @param entId
	 * @param queSite
	 * @throws BizException
	 */
	public void insertRecallHosEvt(HosRecallDTO recallDTO) throws BizException{
		FDateTime curTime = EnAppUtils.getServerDateTime();
		EnEvtDTO recallEvt = new EnEvtDTO();
		recallEvt.setId_ent(recallDTO.getId_ent());
		recallEvt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_RECALLHOS);
		recallEvt.setShort_des("出院召回");
		recallEvt.setDes(String.format("出院召回<科室:%s, 病区:%s, 床位:%s>", recallDTO.getName_dep(), recallDTO.getName_nur(), recallDTO.getName_bed_new()));
		recallEvt.setDt_evt(curTime);
		recallEvt.setDt_insert(curTime);
		recallEvt.setId_emp_rec(EnContextUtils.getPsnId());
		EnEvtDTO useBedEvt = new EnEvtDTO();
		useBedEvt.setId_ent(recallDTO.getId_ent());
		useBedEvt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_DISTRIBUTIONBED);
		useBedEvt.setShort_des("出院召回分配床位");
		useBedEvt.setDes(String.format("出院召回分配床位<床位:%s>", recallDTO.getName_bed_new()));
		useBedEvt.setDt_evt(curTime);
		useBedEvt.setDt_insert(curTime);
		useBedEvt.setVal_old(recallDTO.getId_bed());
		useBedEvt.setVal_new(recallDTO.getId_bed_new());
		useBedEvt.setId_emp_rec(EnContextUtils.getPsnId());
		ep.insertEvt(new EnEvtDTO[]{recallEvt, useBedEvt});
	}
	/**
	 * 添加预住院患者出院召回就诊事件
	 * 
	 * @param entId
	 * @param queSite
	 * @throws BizException
	 */
	public void insertIppreRecallHosEvt(HosRecallDTO recallDTO) throws BizException{
		FDateTime curTime = EnAppUtils.getServerDateTime();
		EnEvtDTO recallEvt = new EnEvtDTO();
		recallEvt.setId_ent(recallDTO.getId_ent());
		recallEvt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_IPPRERECALLHOS);
		recallEvt.setShort_des("预住院出院召回");
		recallEvt.setDes(String.format("预住院出院召回<科室:%s, 病区:%s, 床位:%s>", recallDTO.getName_dep(), recallDTO.getName_nur(), recallDTO.getName_bed_new()));
		recallEvt.setDt_evt(curTime);
		recallEvt.setDt_insert(curTime);
		recallEvt.setId_emp_rec(EnContextUtils.getPsnId());
		EnEvtDTO useBedEvt = new EnEvtDTO();
		useBedEvt.setId_ent(recallDTO.getId_ent());
		useBedEvt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_DISTRIBUTIONBED);
		useBedEvt.setShort_des("预住院出院召回分配床位");
		useBedEvt.setDes(String.format("预住院出院召回分配床位<床位:%s>", recallDTO.getName_bed_new()));
		useBedEvt.setDt_evt(curTime);
		useBedEvt.setDt_insert(curTime);
		useBedEvt.setVal_old(recallDTO.getId_bed());
		useBedEvt.setVal_new(recallDTO.getId_bed_new());
		useBedEvt.setId_emp_rec(EnContextUtils.getPsnId());
		ep.insertEvt(new EnEvtDTO[]{recallEvt, useBedEvt});
	}
	/**
	 * 添加撤销中止入院就诊事件
	 * 
	 * @param entId
	 * @param queSite
	 * @throws BizException
	 */
	public void insertIppreCancelSuspendHosEvt(EnIppreInfoDTO recallDTO) throws BizException{
		FDateTime curTime = EnAppUtils.getServerDateTime();
		EnEvtDTO recallEvt = new EnEvtDTO();
		recallEvt.setId_ent(recallDTO.getId_ent());
		recallEvt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_CANCELSUSPENDHOS);
		recallEvt.setShort_des("撤销中止住院");
		recallEvt.setDes(String.format("取消中止住院<科室:%s, 病区:%s, 床位:%s>", recallDTO.getName_dep_phy(), recallDTO.getName_dep_nur(), recallDTO.getName_bed_new()));
		recallEvt.setDt_evt(curTime);
		recallEvt.setDt_insert(curTime);
		recallEvt.setId_emp_rec(EnContextUtils.getPsnId());
		EnEvtDTO useBedEvt = new EnEvtDTO();
		useBedEvt.setId_ent(recallDTO.getId_ent());
		useBedEvt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_DISTRIBUTIONBED);
		useBedEvt.setShort_des("撤销中止住院分配床位");
		useBedEvt.setDes(String.format("撤销中止住院分配床位<床位:%s>", recallDTO.getName_bed_new()));
		useBedEvt.setDt_evt(curTime);
		useBedEvt.setDt_insert(curTime);
		useBedEvt.setVal_old(recallDTO.getId_bed());
		useBedEvt.setVal_new(recallDTO.getId_bed_new());
		useBedEvt.setId_emp_rec(EnContextUtils.getPsnId());
		ep.insertEvt(new EnEvtDTO[]{recallEvt, useBedEvt});
		//发送事件
		recallEvt.setId_dep_oper(EnContextUtils.getDeptId());
		String event = IEnDictCodeConst.SD_ENTEVT_CANCELSUSPENDHOS;
		BusinessEvent opRegEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_IP_ENT, IEnEventConst.EVENT_EN_PRE_IP,recallEvt);
		Logger.info("发送预住院就诊变更事件: "+event+";发送数据：" + recallEvt);
		EventDispatcher.fireEvent(opRegEvent); 
	}
	/**
	 * 添加取消登记就诊事件
	 * 
	 * @param enHosRegDTO
	 * @throws BizException
	 */
	public void insertIpRegistCancelEvt(EnHosRegDTO enHosRegDTO) throws BizException{
		EnEvtDTO evt = new EnEvtDTO();
		evt.setId_ent(enHosRegDTO.getId_ent());
		evt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_DISCHARGE);
		evt.setShort_des("取消登记");
		evt.setDes("取消登记");
		evt.setDt_evt(EnAppUtils.getServerDateTime());
		evt.setDt_insert(evt.getDt_evt());
		evt.setId_emp_rec(EnContextUtils.getPsnId());
		ep.insertEvt(new EnEvtDTO[]{evt});
	}
	/**
	 * 添加取消登记就诊事件
	 * 
	 * @param enHosRegDTO
	 * @throws BizException
	 */
	public void insertDischargeEvt(DischargeDTO dischargeDTO) throws BizException{
		EnEvtDTO evt = new EnEvtDTO();
		evt.setId_ent(dischargeDTO.getId_ent());
		evt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_DISCHARGE);
		evt.setShort_des("退院");
		evt.setDes("当日退院");
		evt.setDt_evt(EnAppUtils.getServerDateTime());
		evt.setDt_insert(evt.getDt_evt());
		evt.setId_emp_rec(EnContextUtils.getPsnId());
		ep.insertEvt(new EnEvtDTO[]{evt});
	}
	/**
	 * 添加包床就诊事件
	 * 
	 * @param entId
	 * @param bedDO
	 * @throws BizException
	 */
	public void insertRentBedEvt(String entId, Bdbed bedDO) throws BizException{
		EnEvtDTO evt = new EnEvtDTO();
		evt.setId_ent(entId);
		evt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_RENTBED);
		evt.setShort_des("包床");
		evt.setDes(String.format("包床<床位:%s>", bedDO.getName()));
		evt.setDt_evt(EnAppUtils.getServerDateTime());
		evt.setDt_insert(evt.getDt_evt());
		evt.setId_emp_rec(EnContextUtils.getPsnId());
		ep.insertEvt(new EnEvtDTO[]{evt});
	}
	/**
	 * 添加换床分配床位就诊事件
	 * 
	 * @param entId
	 * @param oldBed
	 * @param newBed
	 * @throws BizException
	 */
	public void insertChangeBedEvt(BedBigCardDTO source, BedBigCardDTO target, ArrayList<String> sourceEntIdList, ArrayList<String> targetEntIdList) throws BizException{
		FDateTime curTime = EnAppUtils.getServerDateTime();
		List<EnEvtDTO> list = new ArrayList<EnEvtDTO>();
		if(!EnValidator.isEmpty(sourceEntIdList)){
			for(String ent : sourceEntIdList){
				EnEvtDTO evt = new EnEvtDTO();
				evt.setId_ent(ent);
				evt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_DISTRIBUTIONBED);
				evt.setShort_des("换床分配床位");
				evt.setDes(String.format("换床分配床位<原床位:%s, 新床位:%s>", source.getName_bed(), target.getName_bed()));
				evt.setDt_evt(curTime);
				evt.setDt_insert(curTime);
				evt.setVal_old(source.getId_bed());
				evt.setVal_new(target.getId_bed());
				evt.setId_emp_rec(EnContextUtils.getPsnId());
				list.add(evt);
			}
		}
		if(!EnValidator.isEmpty(targetEntIdList)){
			for(String ent : targetEntIdList){
				EnEvtDTO evt = new EnEvtDTO();
				evt.setId_ent(ent);
				evt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_DISTRIBUTIONBED);
				evt.setShort_des("换床分配床位");
				evt.setDes(String.format("换床分配床位<原床位:%s, 新床位:%s>", target.getName_bed(), source.getName_bed()));
				evt.setDt_evt(curTime);
				evt.setDt_insert(curTime);
				evt.setVal_old(target.getId_bed());
				evt.setVal_new(source.getId_bed());
				evt.setId_emp_rec(EnContextUtils.getPsnId());
				list.add(evt);
			}
		}
		if(!EnValidator.isEmpty(list))
			ep.insertEvt(list.toArray(new EnEvtDTO[0]));
	}
	/**
	 * 添加母婴合并事件
	 * 
	 * @param entId
	 * @param bedDO
	 * @throws BizException
	 */
	public void insertMmBbMergeEvt(String id_ent,NewbornDO newBornDO) throws BizException{
		EnEvtDTO evt = new EnEvtDTO();
		evt.setId_ent(id_ent);
		evt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_DISTRIBUTIONBED);
		evt.setShort_des("母婴合并");
		evt.setDes(String.format("母婴合并<婴儿序号:%s>", newBornDO.getNo_bb()));
		evt.setDt_evt(EnAppUtils.getServerDateTime());
		evt.setDt_insert(evt.getDt_evt());
		evt.setId_emp_rec(EnContextUtils.getPsnId());
		ep.insertEvt(new EnEvtDTO[]{evt});
	}
	/**
	 * 添加母婴分离事件
	 * 
	 * @param entId
	 * @param bedDO
	 * @throws BizException
	 */
	public void insertMmBbSepaEvt(String id_ent,NewbornDO newBornDO) throws BizException{
		EnEvtDTO evt = new EnEvtDTO();
		evt.setId_ent(id_ent);
		evt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_DISTRIBUTIONBED);
		evt.setShort_des("母婴分离");
		evt.setDes(String.format("母婴分离<婴儿序号:%s>", newBornDO.getNo_bb()));
		evt.setDt_evt(EnAppUtils.getServerDateTime());
		evt.setDt_insert(evt.getDt_evt());
		evt.setId_emp_rec(EnContextUtils.getPsnId());
		ep.insertEvt(new EnEvtDTO[]{evt});
	}
	/**
	 * 添加转科就诊事件
	 * 
	 * @param patDTO
	 * @param endepDTO
	 * @throws BizException
	 */
	public void insertTransDepEvt(TransDepPatDTO patDTO, EnDepDTO endepDTO)throws BizException{
		//预住院相关处理
		String short_des = "";
		String sd_event = "";
		if(patDTO.getFg_ippre()!=null && patDTO.getFg_ippre().booleanValue()){
			short_des = "预住院转住院";
			sd_event = IEnDictCodeConst.SD_ENTEVT_TRANSHOS;
		}else{
			short_des = "转科/转病区";
			sd_event = IEnDictCodeConst.SD_ENTEVT_TRANSDEP;
		}
		FDateTime curTime = EnAppUtils.getServerDateTime();
		//转科/转病区   或者   预住院转住院  事件
		EnEvtDTO transDepEvt = new EnEvtDTO();
		transDepEvt.setId_ent(patDTO.getId_ent());
		transDepEvt.setSd_entevt(sd_event);
		transDepEvt.setShort_des(short_des);
		transDepEvt.setDes(String.format(short_des+"<科室:%s, 病区:%s, 床位:%s, 责任医生:%s, 责任护士:%s>", 
				patDTO.getName_dep_phy(), patDTO.getName_dep_nur(), endepDTO.getBed_name(), endepDTO.getPhy_name(), endepDTO.getNur_name()));
		transDepEvt.setDt_evt(curTime);
		transDepEvt.setDt_insert(curTime);
		transDepEvt.setId_emp_rec(EnContextUtils.getPsnId());
		//分配床位事件
		EnEvtDTO useBedEvt = new EnEvtDTO();
		useBedEvt.setId_ent(patDTO.getId_ent());
		useBedEvt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_DISTRIBUTIONBED);
		useBedEvt.setShort_des(short_des+"分配床位");
		useBedEvt.setDes(String.format(short_des+"分配床位<床位:%s>", endepDTO.getBed_name()));
		useBedEvt.setDt_evt(curTime);
		useBedEvt.setDt_insert(curTime);
		useBedEvt.setVal_old(patDTO.getId_bed());
		useBedEvt.setVal_new(endepDTO.getId_bed());
		useBedEvt.setId_emp_rec(EnContextUtils.getPsnId());
		ep.insertEvt(new EnEvtDTO[]{transDepEvt, useBedEvt});
		
		//如果是预住院,发送事件
		if(patDTO.getFg_ippre()!=null && patDTO.getFg_ippre().booleanValue()){
			//发送事件
			transDepEvt.setId_dep_oper(EnContextUtils.getDeptId());
			BusinessEvent opRegEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_IP_ENT, IEnEventConst.EVENT_EN_PRE_IP,transDepEvt);
			Logger.info("发送预住院就诊变更事件: "+sd_event+";发送数据：" + transDepEvt);
			EventDispatcher.fireEvent(opRegEvent); 
		}
		
		
	}
	/**
	 * 打印腕带
	 * 
	 * @param ipDo
	 * @param oldPrintTime
	 * @throws BizException
	 */
	public void insertPrintWrist(InpatientDO ipDo, Integer oldPrintTime) throws BizException{
		EnEvtDTO evt = new EnEvtDTO();
		evt.setId_ent(ipDo.getId_ent());
		evt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_PRTWRIST);
		evt.setShort_des("打印腕带");
		evt.setDes("打印腕带");
		evt.setDt_evt(EnAppUtils.getServerDateTime());
		evt.setDt_insert(evt.getDt_evt());
		evt.setId_emp_rec(EnContextUtils.getPsnId());
		evt.setVal_old(String.valueOf(oldPrintTime));
		evt.setVal_new(String.valueOf(ipDo.getTimes_print()));
		ep.insertEvt(new EnEvtDTO[]{evt});
	}
	
	/**
	 * 添加取消入科就诊事件
	 * 
	 * @param enHosRegDTO
	 * @throws BizException
	 */
	public void insertDisIpacptEvt(DischargeDTO dischargeDTO) throws BizException{
		EnEvtDTO evt = new EnEvtDTO();
		evt.setId_ent(dischargeDTO.getId_ent());
		evt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_CHANELENTRY);
		evt.setShort_des("取消入科");
		evt.setDes(String.format("取消入科<科室:%s, 病区:%s, 床位:%s>", dischargeDTO.getName_dep_phy(), dischargeDTO.getName_dep_nur(), dischargeDTO.getName_bed()));
		evt.setDt_evt(EnAppUtils.getServerDateTime());
		evt.setDt_insert(evt.getDt_evt());
		evt.setId_emp_rec(EnContextUtils.getPsnId());
		ep.insertEvt(new EnEvtDTO[]{evt});
	}
	
	/**
	 * 添加预住院中止住院就诊事件
	 * 
	 * @param enIppreCancelDto
	 * @param dt_end
	 * @throws BizException
	 */
	public void insertCancelHosEvt(EnIppreCancelHosDTO enIppreCancelDto, FDateTime dt_end) throws BizException{
		EnEvtDTO evt = new EnEvtDTO();
		evt.setId_ent(enIppreCancelDto.getId_ent());
		evt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_CANCELHOS);
		evt.setShort_des("预住院中止入院");
		evt.setDes(String.format("预住院中止入院<科室:%s, 病区:%s, 预住院中止入院时间:%s>", enIppreCancelDto.getName_ippre_phy(), enIppreCancelDto.getName_ippre_nur(), dt_end));
		evt.setDt_evt(EnAppUtils.getServerDateTime());
		evt.setDt_insert(evt.getDt_evt());
		evt.setId_emp_rec(EnContextUtils.getPsnId());
		evt.setVal_new(dt_end.toString());
		ep.insertEvt(new EnEvtDTO[]{evt});
		
		//发送事件
		evt.setId_dep_oper(EnContextUtils.getDeptId());
		String event = IEnDictCodeConst.SD_ENTEVT_CANCELHOS;
		BusinessEvent opRegEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_IP_ENT, IEnEventConst.EVENT_EN_PRE_IP,evt);
		Logger.info("发送预住院就诊变更事件: "+event+";发送数据：" + evt);
		EventDispatcher.fireEvent(opRegEvent); 
	}
	/**
	 * 添加预住院转住院就诊事件(直接转的时候调用)
	 * 
	 * @param ippreTransHos
	 * @param curTime
	 * @throws BizException
	 */
	public void insertTransHosEvt(EnIppreTransHosDTO ippreTransHos, FDateTime curTime)throws BizException{
		EnEvtDTO transDepEvt = new EnEvtDTO();
		transDepEvt.setId_ent(ippreTransHos.getId_ent());
		transDepEvt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_TRANSHOS);
		transDepEvt.setShort_des("预住院转入院");
		transDepEvt.setDes(String.format("预住院转入院<科室:%s, 病区:%s, 床位:%s, 责任医生:%s, 责任护士:%s>", 
				ippreTransHos.getName_ippre_phy(), ippreTransHos.getName_ippre_nur(), ippreTransHos.getName_bed(), 
				ippreTransHos.getName_emp_doc(), ippreTransHos.getName_emp_doc()));
		transDepEvt.setDt_evt(curTime);
		transDepEvt.setDt_insert(curTime);
		transDepEvt.setId_emp_rec(EnContextUtils.getPsnId());
		EnEvtDTO useBedEvt = new EnEvtDTO();
		useBedEvt.setId_ent(ippreTransHos.getId_ent());
		useBedEvt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_DISTRIBUTIONBED);
		useBedEvt.setShort_des("预住院转入院分配床位");
		useBedEvt.setDes(String.format("预住院转入院分配床位<床位:%s>", ippreTransHos.getName_bed()));
		useBedEvt.setDt_evt(curTime);
		useBedEvt.setDt_insert(curTime);
		useBedEvt.setVal_old(ippreTransHos.getId_bed_old());
		useBedEvt.setVal_new(ippreTransHos.getId_bed());
		useBedEvt.setId_emp_rec(EnContextUtils.getPsnId());
		ep.insertEvt(new EnEvtDTO[]{transDepEvt, useBedEvt});
		
		//发送事件
		transDepEvt.setId_dep_oper(EnContextUtils.getDeptId());
		String event = IEnDictCodeConst.SD_ENTEVT_TRANSHOS;
		BusinessEvent opRegEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_IP_ENT, IEnEventConst.EVENT_EN_PRE_IP,transDepEvt);
		Logger.info("发送预住院就诊变更事件: "+event+";发送数据：" + transDepEvt);
		EventDispatcher.fireEvent(opRegEvent); 
	}
	/**
	 * 添加患者就诊事件
	 * 
	 * @param patOldId
	 * @param patNewId
	 * @throws BizException
	 */
	public void insertPatChgEvt(OpRegPatDTO opRegPatDto) throws BizException{
		if(EnValidator.isEmpty(opRegPatDto.getId_pat()) 
				|| EnValidator.isEmpty(opRegPatDto.getId_pat_old()))
			return;
		PiPatEP patEP = new PiPatEP();
		PatDO[] pats = patEP.getPatByPKs(new String[] {opRegPatDto.getId_pat(), opRegPatDto.getId_pat_old()});
		if(EnValidator.isEmpty(pats))
			return;
		PatDO patOld = null;
		PatDO patNew = null;
		for(PatDO pat : pats){
			if(opRegPatDto.getId_pat().equals(pat.getId_pat()))
				patNew = pat;
			if(opRegPatDto.getId_pat_old().equals(pat.getId_pat()))
				patOld = pat;
		}
		if(patOld == null || patNew == null)
			return;
		EnEvtDTO evt = new EnEvtDTO();
		evt.setId_erpre(opRegPatDto.getId_erpre());
		evt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_PATCHG);
		evt.setShort_des("急诊挂号换患者");
		evt.setDes(String.format("换患者<原患者[%s, %s], 新患者[%s, %s]>", patOld.getCode(), patOld.getName(), patNew.getCode(), patNew.getName()));
		evt.setDt_evt(EnAppUtils.getServerDateTime());
		evt.setDt_insert(evt.getDt_evt());
		evt.setId_emp_rec(EnContextUtils.getPsnId());
		ep.insertEvt(new EnEvtDTO[]{evt});
	}
	
	/**
	 * 抢救-打印腕带
	 * 
	 * @param ipDo
	 * @param oldPrintTime
	 * @throws BizException
	 */
	public void insertRescuePrintWrist(OutpatientDO opDo, Integer oldPrintTime) throws BizException{
		EnEvtDTO evt = new EnEvtDTO();
		evt.setId_ent(opDo.getId_ent());
		evt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_PRTWRIST);
		evt.setShort_des("打印腕带(抢救)");
		evt.setDes("打印腕带(抢救)");
		evt.setDt_evt(EnAppUtils.getServerDateTime());
		evt.setDt_insert(evt.getDt_evt());
		evt.setId_emp_rec(EnContextUtils.getPsnId());
		evt.setVal_old(String.valueOf(oldPrintTime));
		evt.setVal_new(String.valueOf(opDo.getTimes_print()));
		ep.insertEvt(new EnEvtDTO[]{evt});
	}
}