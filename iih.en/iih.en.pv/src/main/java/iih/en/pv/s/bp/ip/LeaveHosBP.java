package iih.en.pv.s.bp.ip;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bl.cg.i.IBlOutCmdService;
import iih.ci.ord.cior.d.OrdApOutDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.BedEP;
import iih.en.comm.ep.EntBedEP;
import iih.en.comm.ep.EntDeptEP;
import iih.en.comm.ep.EntEmpEP;
import iih.en.comm.ep.EntWgEP;
import iih.en.comm.ep.IpEP;
import iih.en.comm.ep.NbEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.evt.EnEvtHandle;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.CheckStatus;
import iih.en.pv.dto.d.LvHosAppDTO;
import iih.en.pv.inpatient.d.EnIppreDO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.inpatient.dto.d.LvDep4EsDTO;
import iih.en.pv.inpatient.dto.d.LvHos4EsDTO;
import iih.en.pv.inpatient.i.IEnippreCudService;
import iih.en.pv.inpatient.i.IEnippreRService;
import iih.en.pv.inpatient.i.IInpatientCudService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitCudService;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.en.pv.pativisit.s.PativisitCrudServiceImpl;
import iih.en.pv.s.event.IpLvDepEvent;
import iih.en.pv.s.event.IpLvHosEvent;
import iih.mp.nr.foreign.i.IForeignService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 出院BP
 * 
 * @author renying
 * @since 2015-10-13
 */
public class LeaveHosBP {
	/**
	 * 出院
	 * 
	 * @param appDTO  出院申请DTO
	 * @throws BizException
	 */
	public void exec(LvHosAppDTO appDTO) throws BizException {
		// 0、验证是否可出院
		if (!this.canLeave(appDTO)) {
			return;
		}
		//出院前校验医嘱状态
		this.validateOrderSu(appDTO);
		NbEP nbep = new NbEP();
		//获取患者新生儿记录
		NewbornDO[] nbdos = nbep.getNbListByMomEntInHos(appDTO.getId_ent());
		//获取就诊id的List
		ArrayList<String> arrList = this.getEntIdList(appDTO.getId_ent(), nbdos);
		//获取婴儿就诊Do
		PatiVisitDO[] nbEntDos = this.getNbEntDo(arrList);
		//获取出院新生儿的LvHosAppDTO
		LvHosAppDTO[] nbLvHosAppDTOs = this.getNbLvHosAppDTOs(nbdos, nbEntDos, appDTO);
		// 0.1校验是否入院
		this.validateInpatientDO(arrList);
		// 0.2所有单据，都是同一时间
		FDateTime leaveTime = appDTO.getDt_disc();
		//如果患者存在新生儿且患者出院时间选择的是医嘱时间，并且新生儿有出院医嘱，则新生儿取自己出院医嘱的时间作为出院时间；否则取母亲的出院时间
		boolean isDtOutOr = false;
		//获取母亲及新生儿的出院医嘱时间
		List<LvHosAppDTO> dtOutOrList = getDtOutOrs(arrList);
		for (LvHosAppDTO lvHosAppDTO : dtOutOrList) {
			if (!EnValidator.isEmpty(nbdos) && appDTO.getId_ent().equals(lvHosAppDTO.getId_ent()) && appDTO.getDt_disc().equals(lvHosAppDTO.getDt_outor())) {
				isDtOutOr = true;
			}
		}
		// 1、更新就诊表
		PatiVisitDO[] entDos = this.updatePatVisitDO(appDTO, arrList, dtOutOrList, isDtOutOr);
		// 2、更新住院
		this.updateInpatientDO(appDTO, arrList, dtOutOrList, isDtOutOr);
		// 3、释放床位
		if(appDTO.getFg_nb() ==null || !appDTO.getFg_nb().booleanValue())
		{
			this.updateBedDO(appDTO);
			// 4、更新就诊资源--床位
			if(!FBoolean.TRUE.equals(appDTO.getFg_blrecall())){
				this.updateEnBedDO(appDTO, leaveTime);
			}
		}else if(appDTO.getFg_nb().booleanValue()){
			NewbornDO nbChild = nbep.getNbChild(appDTO.getId_ent());
			if(nbChild != null && nbChild.getFg_sepa().booleanValue()){
				this.updateBedDO(appDTO);
				// 4、更新就诊资源--床位
				if(!FBoolean.TRUE.equals(appDTO.getFg_blrecall())){
					this.updateEnBedDO(appDTO, leaveTime);
				}
			}
		}
		if(!FBoolean.TRUE.equals(appDTO.getFg_blrecall())){
			// 5、更新就诊资源--科室
			this.updateEnDepDO(appDTO, leaveTime);
		}
		// 6、更新就诊资源--医疗组
		this.updatEntWgDO(appDTO, arrList, dtOutOrList, isDtOutOr);
		// 7、更新就诊资源--医护人员
		this.updateEnEmp(appDTO, arrList, dtOutOrList, isDtOutOr);
		// 8、更新就诊域
		this.updateMP(appDTO);
		// 9、调用费用接口，划价
		this.backStageRecord(leaveTime, appDTO.getId_pat(), nbdos,appDTO.getId_ent());
		// 10、处理预住院
		this.updateIppre(appDTO, arrList, dtOutOrList, isDtOutOr);
		// 11、添加出院就诊事件
		new EnEvtHandle().insertLvHosEvt(appDTO, arrList, dtOutOrList, isDtOutOr);
		// 12、发送出院事件
		try {
			Map<String, PatiVisitDO> map = new HashMap<String, PatiVisitDO>();
			for (PatiVisitDO patiVisitDO : entDos) {
				map.put(patiVisitDO.getId_ent(), patiVisitDO);
			}
			this.invokeLvHos4IdListener(appDTO, map.get(appDTO.getId_ent()));
			if (nbLvHosAppDTOs != null && nbLvHosAppDTOs.length > 0) {
				for (LvHosAppDTO lvHosAppDTO : nbLvHosAppDTOs) {
					this.invokeLvHos4IdListener(lvHosAppDTO, map.get(lvHosAppDTO.getId_ent()));
				}
			}
		} catch (Exception ex) {
			Logger.error("出院消息发送失败：", ex);
		}
		// 13、发送出科事件
		try {
			Map<String, PatiVisitDO> map = new HashMap<String, PatiVisitDO>();
			for (PatiVisitDO patiVisitDO : entDos) {
				map.put(patiVisitDO.getId_ent(), patiVisitDO);
			}
			this.invokeLvDep4IdListener(appDTO, map.get(appDTO.getId_ent()));
			if (nbLvHosAppDTOs != null && nbLvHosAppDTOs.length > 0) {
				for (LvHosAppDTO lvHosAppDTO : nbLvHosAppDTOs) {
					this.invokeLvDep4IdListener(lvHosAppDTO, map.get(lvHosAppDTO.getId_ent()));
				}
			}
		} catch (Exception ex) {
			Logger.error("出科消息发送失败：", ex);
		}
		
	}
	

	/**
	 * 1、更新就诊表
	 * 
	 * @param appDTO
	 * @param leaveTime
	 * @throws BizException
	 */
	private PatiVisitDO[] updatePatVisitDO(LvHosAppDTO appDTO, ArrayList<String> arrList, List<LvHosAppDTO> dtOutOrList, boolean isDtOutOr) throws BizException {
		PvEP pvep = new PvEP();
		PatiVisitDO[] pvDOs = pvep.getPVs(arrList);
		for(PatiVisitDO pvDO:pvDOs ){
			pvDO.setFg_ip(FBoolean.FALSE);// 出院
			if(!FBoolean.TRUE.equals(appDTO.getFg_blrecall())){
				//设置出院时间
				FDateTime dtEnd = getDtDisc(appDTO, pvDO.getId_ent(), dtOutOrList, isDtOutOr);
				pvDO.setDt_end(dtEnd);// 就诊结束时间
			}
			pvDO.setStatus(DOStatus.UPDATED);
		}
		IPativisitCudService pvCrudSV = ServiceFinder.find(IPativisitCudService.class);
		pvDOs = pvCrudSV.save(pvDOs);
		return pvDOs;
	}

	/**
	 * 2、更新住院
	 * 
	 * @param appDTO
	 * @throws BizException
	 */
	private void updateInpatientDO(LvHosAppDTO appDTO, ArrayList<String> arrList, List<LvHosAppDTO> dtOutOrList, boolean isDtOutOr) throws BizException {
		// 2、更新住院
		IpEP ipep = new IpEP();
		InpatientDO[] inpatientDOs = ipep.getInpatientDOs(arrList);
		if (!EnValidator.isEmpty(inpatientDOs)) {
			for (InpatientDO ipDO : inpatientDOs) {
				ipDO.setId_dep_phydisc(appDTO.getId_dep_phy());// 科室
				ipDO.setId_dep_nurdisc(appDTO.getId_dep_nur());// 病区
				ipDO.setSd_status(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT);// 就诊状态改为出院
				if(!FBoolean.TRUE.equals(appDTO.getFg_blrecall())){
					//设置出院时间
					FDateTime dtEnd = getDtDisc(appDTO, ipDO.getId_ent(), dtOutOrList, isDtOutOr);
					ipDO.setDt_disc(dtEnd);
				}
				ipDO.setDt_end_last(EnAppUtils.getServerDateTime());
				ipDO.setId_emp_disc(appDTO.getId_emp_disc());
				ipDO.setStatus(DOStatus.UPDATED);
				if(appDTO.getId_ent().equals(ipDO.getId_ent()))
					this.updateIpGoWhereAndOutComes(ipDO, appDTO.getId_or());
			}
			IInpatientCudService ipCrudSV = ServiceFinder.find(IInpatientCudService.class);
			ipCrudSV.save(inpatientDOs);
		}
	}

	/**
	 * 3、释放床位
	 * 
	 * @param appDTO
	 * @throws BizException
	 */
	private void updateBedDO(LvHosAppDTO appDTO) throws BizException {
		// 3、释放床位
		BedEP bedBP = new BedEP();
		if (IEnDictCodeConst.BED_HAS_SEX.equals(EnParamUtils.getBedSexParam(appDTO.getId_dep_nur()))) {
			bedBP.releaseBedWithSex(appDTO.getId_ent(), appDTO.getId_bed(), FBoolean.FALSE);
			return;
		}
		bedBP.releaseBed(appDTO.getId_ent(), appDTO.getId_bed());
	}

	/**
	 * 更新就诊床位信息
	 * 
	 * @param appDTO
	 * @param leaveTime
	 * @throws BizException
	 */
	private void updateEnBedDO(LvHosAppDTO appDTO, FDateTime leaveTime) throws BizException {
		EntBedEP entBedEP = new EntBedEP();
		entBedEP.endUseBed(appDTO.getId_ent(), leaveTime);
	}

	/**
	 * 更新就诊部门信息
	 * 
	 * @param appDTO
	 * @param leaveTime
	 * @throws BizException
	 */
	private void updateEnDepDO(LvHosAppDTO appDTO, FDateTime leaveTime) throws BizException {
		EntDeptEP enDeptEp = new EntDeptEP();
		enDeptEp.endDept(appDTO.getId_ent(), null, null, FBoolean.TRUE, leaveTime);
	}

	/**
	 * 更新就诊医疗组信息
	 * 
	 * @param appDTO
	 * @param leaveTime
	 * @throws BizException
	 */
	private void updatEntWgDO(LvHosAppDTO appDTO, ArrayList<String> arrList, List<LvHosAppDTO> dtOutOrList, boolean isDtOutOr) throws BizException {
		EntWgEP entWgEP = new EntWgEP();
		for (String entId : arrList) {
			List<String> list = new ArrayList<>();
			list.add(entId);
			//设置出院时间
			FDateTime dtEnd = getDtDisc(appDTO, entId, dtOutOrList, isDtOutOr);
			entWgEP.endWg(list, null, dtEnd);
		}
	}

	/**
	 * 更新就诊人员信息
	 * 
	 * @param appDTO
	 * @param leaveTime
	 * @throws BizException
	 */
	private void updateEnEmp(LvHosAppDTO appDTO, ArrayList<String> arrList, List<LvHosAppDTO> dtOutOrList, boolean isDtOutOr) throws BizException {
		EntEmpEP entEmpEp = new EntEmpEP();
		for (String entId : arrList) {
			List<String> list = new ArrayList<>();
			list.add(entId);
			//设置出院时间
			FDateTime dtEnd = getDtDisc(appDTO, entId, dtOutOrList, isDtOutOr);
			entEmpEp.endOldEmp(list, null, dtEnd);
		}
	}

	/**
	 * 验证
	 * 
	 * @param appDTO
	 * @return
	 */
	private Boolean canLeave(LvHosAppDTO appDTO) {
		if (appDTO != null) {
			if (isPassed(appDTO.getStatus_or()) && isPassed(appDTO.getStatus_med()) && isPassed(appDTO.getStatus_mp()) && isPassed(appDTO.getStatus_tech()) && isPassed(appDTO.getStatus_other())) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 验证状态是否通过
	 * 
	 * @param status   状态
	 * @return
	 */
	private Boolean isPassed(Integer status) {
		if (status != null) {
			if (status == CheckStatus.SUCCESS || status == CheckStatus.WARN) {
				return true;
			}
		}
		// return false;
		return true;// 暂时，后续添加响应验证后，改为false
	}

	/**
	 * 1、调用费用接口，划价
	 * 
	 * @param dt_e
	 * @param id_pat
	 * @throws BizException
	 */
	private void backStageRecord(FDateTime dt_e, String patId, NewbornDO[] nbdos,String entId) throws BizException {
		IBlOutCmdService blCgService = ServiceFinder.find(IBlOutCmdService.class);
		blCgService.chargeOutDeptByEntId(entId, dt_e);//execIpCgTask
		if(EnValidator.isEmpty(nbdos))
			return;
		for(NewbornDO nbdo : nbdos)
			blCgService.chargeOutDeptByEntId(nbdo.getId_ent_bb(), dt_e);//execIpCgTask
	}

	/**
	 * 校验住院数据
	 * 
	 * @param enHosRegDTO
	 * @return
	 * @throws BizException
	 */
	private void validateInpatientDO(ArrayList<String> arrList ) throws BizException {
		// 入科校验
		if (EnValidator.isEmpty(arrList)) {
			return ;
		}
		IpEP ep = new IpEP();
		InpatientDO[] inpatientDOs = ep.getInpatientDOs(arrList);
		if (EnValidator.isEmpty(inpatientDOs)) {
			return ;
		}
		for(InpatientDO inpatientDO :inpatientDOs){
		
			if (!inpatientDO.getSd_status().equals(IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN)) {
				throw new BizException(IEnMsgConst.ERROR_ENT_STATUS_STATUS);
			}
			
			if(inpatientDO.getFg_incp() !=null && inpatientDO.getFg_incp().booleanValue()){
				if(inpatientDO.getFg_newborn() != null && inpatientDO.getFg_newborn().booleanValue()){
					throw new BizException(IEnMsgConst.ERROR_ENT_FGINCP_BB);
				}
				throw new BizException(IEnMsgConst.ERROR_ENT_FGINCP);
			}
		}
		return ;
	}
	/**
	 * 更新执行域
	 * @param appDTO
	 * @throws BizException
	 */
	private void updateMP(LvHosAppDTO appDTO) throws BizException
	{
		IForeignService fordignRServoce = ServiceFinder.find(IForeignService.class);
		fordignRServoce.UpdateOrderStatus(new String[]{appDTO.getId_or()});
	}
	
	/**
	 * 出院事件
	 * @param appDTO
	 * @throws BizException
	 */
	private void invokeLvHos4IdListener(LvHosAppDTO appDTO, PatiVisitDO entDo) throws BizException {
		LvHos4EsDTO esDTO = new LvHos4EsDTO();
		esDTO.setId_ent(appDTO.getId_ent());
		esDTO.setCode_ent(entDo.getCode());
		esDTO.setCode_enttp(entDo.getCode_entp());
		esDTO.setName_enttp(entDo.getName_entp());
		esDTO.setId_pat(appDTO.getId_pat());
		esDTO.setName_pat(appDTO.getName());
		if (appDTO.getSex() != null) {
			esDTO.setSd_sex(appDTO.getSex().toString());
		}
		esDTO.setDt_birth(appDTO.getDt_birth());
		esDTO.setAge(appDTO.getAge());
		esDTO.setId_dep_nur(appDTO.getId_dep_nur());
		esDTO.setId_dep_phy(appDTO.getId_dep_phy());
		esDTO.setBed_code(appDTO.getName_bed());
		esDTO.setDt_lv(entDo.getDt_end());
		esDTO.setCi_code(appDTO.getCi_code());
		esDTO.setName_ci(appDTO.getName_or());
		esDTO.setCode_amr_ip(appDTO.getCode_amr_ip());

		esDTO.setSd_outtp(appDTO.getSd_outtp());
		esDTO.setName_outtp(appDTO.getName_outtp());
		esDTO.setDt_ci_lv(appDTO.getDt_outor());
		esDTO.setEvent_source(IEventType.TYPE_INSERT_AFTER);
		esDTO.setId_dep_opr(EnContextUtils.getDeptId());  //操作科室
		esDTO.setId_emp_opr(EnContextUtils.getPsnId());//操作员
		esDTO.setDt_opr(entDo.getDt_end());
		esDTO.setId_or(appDTO.getId_or());
		IpLvHosEvent lvevent = new IpLvHosEvent();
		lvevent.invoke(esDTO);
	}
	/**
	 * 出科事件
	 * @param appDTO
	 * @throws BizException
	 */
	private void invokeLvDep4IdListener(LvHosAppDTO appDTO, PatiVisitDO entDo) throws BizException {
		LvDep4EsDTO esDTO = new LvDep4EsDTO();
		esDTO.setId_ent(appDTO.getId_ent());
		esDTO.setCode_ent(entDo.getCode());
		esDTO.setCode_enttp(entDo.getCode_entp());
		esDTO.setName_enttp(entDo.getName_entp());
		esDTO.setId_pat(appDTO.getId_pat());
		esDTO.setName_pat(appDTO.getName());
		if (appDTO.getSex() != null) {
			esDTO.setSd_sex(appDTO.getSex().toString());
		}
		esDTO.setDt_birth(appDTO.getDt_birth());
		esDTO.setAge(appDTO.getAge());
		esDTO.setId_dep_nur(appDTO.getId_dep_nur());
		esDTO.setId_dep_phy(appDTO.getId_dep_phy());
		esDTO.setBed_code(appDTO.getName_bed());
		esDTO.setDt_lv(entDo.getDt_end());
		esDTO.setCi_code(appDTO.getCi_code());
		esDTO.setName_ci(appDTO.getName_or());
		esDTO.setCode_amr_ip(appDTO.getCode_amr_ip());

		esDTO.setSd_outtp(appDTO.getSd_outtp());
		esDTO.setName_outtp(appDTO.getName_outtp());
		esDTO.setDt_ci_lv(appDTO.getDt_outor());
		esDTO.setEvent_source(IEventType.TYPE_INSERT_AFTER);
		esDTO.setId_dep_opr(EnContextUtils.getDeptId());  //操作科室
		esDTO.setId_emp_opr(EnContextUtils.getPsnId());//操作员
		esDTO.setDt_opr(entDo.getDt_end());
		esDTO.setId_or(appDTO.getId_or());
		IpLvDepEvent lvevent = new IpLvDepEvent();
		lvevent.invoke(esDTO);
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
			if(!nbDO.getFg_sepa().booleanValue())//去除分床的新生儿
			entIdList.add(nbDO.getId_ent_bb());
		}
		return entIdList;
	}
	/**
	 * 修改离院转归和疾病转归
	 * @param ors
	 * @throws BizException 
	 */
	private void updateIpGoWhereAndOutComes(InpatientDO ip, String orId) throws BizException{
		if(ip == null || EnValidator.isEmpty(orId))
			return;
		List<OrdApOutDO> list =  (List<OrdApOutDO>) new DAFacade().findByAttrValString(OrdApOutDO.class, OrdApOutDO.ID_OR, orId, null);
		if(EnValidator.isEmpty(list))
			return;
		ip.setId_gowhere(list.get(0).getId_outtp());
		ip.setSd_gowhere(list.get(0).getSd_outtp());
		ip.setId_outcomes(list.get(0).getDef1());
		ip.setSd_outcomes(list.get(0).getDef2());
	}
	
	/**
	 * 获取出院新生儿的LvHosAppDTO
	 * 
	 * @param nbdos
	 * @param nbEntDo 
	 * @return
	 * @throws BizException 
	 */
	private LvHosAppDTO[] getNbLvHosAppDTOs(NewbornDO[] nbdos, PatiVisitDO[] nbEntDos,LvHosAppDTO appDTO) throws BizException {
		if (nbdos != null && nbdos.length > 0) {
			LvHosAppDTO[] nbLvHosAppDTOs = new LvHosAppDTO[nbdos.length];
			for (int i = 0; i < nbdos.length; i++) {
				if(nbdos[i].getFg_sepa().booleanValue()) continue; //去除分床的新生儿
				LvHosAppDTO lvHosAppDTO = new LvHosAppDTO();
				if (nbEntDos != null && nbEntDos.length > 0) {
					for (PatiVisitDO nbEntDo : nbEntDos) {
						if (nbEntDo.getId_ent().equals(nbdos[i].getId_ent_bb())) {
							lvHosAppDTO.setId_dep_nur(nbEntDo.getId_dep_nur());
							lvHosAppDTO.setId_dep_phy(nbEntDo.getId_dep_phy());
						}
					}
				}
				lvHosAppDTO.setId_ent(nbdos[i].getId_ent_bb());
				lvHosAppDTO.setId_pat(nbdos[i].getId_pat_bb());
				lvHosAppDTO.setName(nbdos[i].getName_bb());
				if (nbdos[i].getSd_sex() != null) {
					lvHosAppDTO.setSex(Integer.parseInt(nbdos[i].getSd_sex()));
				}
				if (nbdos[i].getDt_birth() != null) {
					lvHosAppDTO.setDt_birth(nbdos[i].getDt_birth().getDate());
					lvHosAppDTO.setAge(AgeCalcUtil.getAge(nbdos[i].getDt_birth().getDate()));
				}
				lvHosAppDTO.setName_bed(appDTO.getName_bed());// 0147311
				lvHosAppDTO.setCi_code(appDTO.getCi_code());
				lvHosAppDTO.setDt_outor(appDTO.getDt_outor());
				lvHosAppDTO.setName_or(appDTO.getName_or());
				lvHosAppDTO.setSd_outtp(appDTO.getSd_outtp());
				nbLvHosAppDTOs[i] = lvHosAppDTO;
			}
			return nbLvHosAppDTOs;
		}
		return null;
	}
	
	/**
	 * 获取出院医嘱时间
	 * @param entIdList
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<LvHosAppDTO> getDtOutOrs(ArrayList<String> entIdList) throws BizException {
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT ");
		builder.append(" ENT.ID_ENT, ");
		builder.append(" CIOR.DT_EFFE AS DT_OUTOR ");
		builder.append(" FROM EN_ENT ENT ");
		builder.append(" INNER JOIN CI_ORDER CIOR ON ENT.ID_ENT = CIOR.ID_EN AND CIOR.SD_SU_OR in(?,?,?)");
		builder.append(" INNER JOIN CI_AP_OUT AP ON AP.ID_OR = CIOR.ID_OR ");
		builder.append(" WHERE 1 = 1 AND ENT.CODE_ENTP <> ?");//过滤预住院
		SqlParam param = new SqlParam();
		param.addParam(ICiDictCodeConst.SD_SU_CHECKTHROUGH);
		param.addParam(ICiDictCodeConst.SD_SU_CHECKSTOP);
		param.addParam(ICiDictCodeConst.SD_SU_FINISH);
		param.addParam(IEnDictCodeConst.SD_ENTP_IPPRE);
		builder.append(" AND ");
		String ids = SqlUtils.getInSqlByIds("ENT.ID_ENT", entIdList);
		builder.append(ids);
		
		List<LvHosAppDTO> dtoList = (List<LvHosAppDTO>) new DAFacade().execQuery(builder.toString(), param, new BeanListHandler(LvHosAppDTO.class));
		return dtoList;
	}	

	
	private FDateTime getDtDisc(LvHosAppDTO appDTO, String idEnt, List<LvHosAppDTO> dtOutOrList, boolean isDtOutOr) throws BizException{
		if (isDtOutOr) {
			for (LvHosAppDTO lvHosApp : dtOutOrList) {
				if (idEnt.equals(lvHosApp.getId_ent()) && lvHosApp.getDt_outor() != null) {
					return lvHosApp.getDt_outor();
				}
			}
		}
		return appDTO.getDt_disc();
	} 
	
	/**
	 * 获取新生儿就诊Do
	 * 
	 * @param id_ent
	 * @param arrList
	 * @return
	 * @throws BizException 
	 */
	private PatiVisitDO[] getNbEntDo(ArrayList<String> arrList) throws BizException {
		if (arrList != null && arrList.size() > 0) {
			IPativisitRService pativisitCrudServiceImpl = new PativisitCrudServiceImpl();
			return pativisitCrudServiceImpl.findByIds(arrList.toArray(new String[0]), FBoolean.FALSE);
		}
		return null;
	}

	/**
	 * 出院前校验医嘱状态
	 * 
	 * @param transDepPat
	 * @throws BizException
	 */
	private void validateOrderSu(LvHosAppDTO appDTO) throws BizException {
		if(appDTO == null ||EnValidator.isEmpty(appDTO.getId_or()))
			return;
		CiOrderDO ciOrder = (CiOrderDO) new DAFacade().findByPK(
				CiOrderDO.class, appDTO.getId_or());
		if (ciOrder == null
				|| !(ICiDictCodeConst.SD_SU_CHECKTHROUGH.equals(ciOrder
						.getSd_su_or())
						|| ICiDictCodeConst.SD_SU_CHECKSTOP.equals(ciOrder
								.getSd_su_or()) || ICiDictCodeConst.SD_SU_FINISH
							.equals(ciOrder.getSd_su_or()))) {
			throw new BizException(String.format("患者[%s]出院医嘱状态发生改变，请刷新后重试！",
					appDTO.getName()));
		}
	}
	
	/**
	 * 处理预住院
	 * @param appDTO
	 * @param leaveTime 
	 * @param arrList 
	 * @throws BizException 
	 */
	private void updateIppre(LvHosAppDTO appDTO, ArrayList<String> arrList, List<LvHosAppDTO> dtOutOrList, boolean isDtOutOr) throws BizException {
		IEnippreCudService iCudService = ServiceFinder.find(IEnippreCudService.class);
		IEnippreRService iRService = ServiceFinder.find(IEnippreRService.class);
		EnIppreDO[] enIppreDOs = iRService.find(" id_ent = '" + appDTO.getId_ent() + "' ", "", FBoolean.FALSE);
		if(enIppreDOs!=null && enIppreDOs.length>0){
			for (EnIppreDO enIppreDO : enIppreDOs) {
				enIppreDO.setSd_status(IEnDictCodeConst.SD_STATUS_IPPRE_HOS_OUTER);
				enIppreDO.setStatus(DOStatus.UPDATED);
			}
			//添加预住院患者出院就诊事件
			new EnEvtHandle().insertIppreLvHosEvt(appDTO, arrList, dtOutOrList, isDtOutOr);
		}
		iCudService.save(enIppreDOs);
		
	}
}
