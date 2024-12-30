package iih.sc.apt.s.bp.mt.apt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.commons.collections.MapUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.pat.d.PatDO;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.dto.d.MtAppQryDTO;
import iih.sc.apt.dto.d.MtApt4EsDTO;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.i.IScAptQryService;
import iih.sc.apt.s.bp.GetAptAggBp;
import iih.sc.apt.s.bp.RewriteOrClosedLoopState;
import iih.sc.apt.s.bp.mt.GetMtResBP;
import iih.sc.apt.s.bp.mt.MtAptCiObsOperateBP;
import iih.sc.apt.s.bp.mt.apt.auto.AptCheckChlPeriodAutoBP;
import iih.sc.apt.s.bp.mt.apt.auto.GetMtResList4AutoAptBP;
import iih.sc.apt.s.bp.opt.OptAptCiObsOperateBP;
import iih.sc.apt.s.ep.AptEP;
import iih.sc.apt.s.ep.MtAptEP;
import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.apt.s.event.MakeMtAptEvent;
import iih.sc.apt.scapt.d.AptOthDO;
import iih.sc.apt.scapt.d.ScAptMtDO;
import iih.sc.apt.scapt.d.ScAptOptDO;
import iih.sc.apt.scapt.d.ScaptAggDO;
import iih.sc.apt.scapt.i.IAptothCudService;
import iih.sc.apt.scaptappl.d.EuAptmd;
import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.apt.scaptappl.d.desc.ScAptApplDODesc;
import iih.sc.apt.scaptappl.i.IScaptapplMDORService;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScParamUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.bdsrv.d.ScBdsrvDO;
import iih.sc.scbd.bdsrv.i.IScbdsrvMDORService;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import iih.sc.scbd.scdeptparam.i.IScdeptparamMDORService;
import iih.sc.scbd.scheduleres.d.ScheduleResDO;
import iih.sc.scbd.scheduleres.i.IScheduleresRService;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO;
import iih.sc.scbd.schedulesrv.i.IScheduleSrvRelDORService;
import iih.sc.sch.i.IScSchOutCmdService;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.d.ScSchOptsrvDO;
import iih.sc.sch.scsch.i.IScSchOptsrvDORService;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.scp.scplan.d.ScPlanDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 保存自动化医技预约信息(增加对手术预约的支持)
 * 
 * @author yzh
 *
 */
public class SaveAutoMtAptBP {

	/**
	 * 保存医技预约信息
	 * @author yzh
	 * @param resDTO
	 * @param appDTO
	 * @param sd_sctp
	 * @throws BizException
	 */
	public MtResDTO exec(MtResDTO resDTO, MtAppDTO appDTO, String sd_sctp) throws BizException {
		if (null == appDTO) {
			return resDTO;
		}
 		OralAptEP aptEP = new OralAptEP();
		if (StringUtil.isEmptyWithTrim(appDTO.getId_pat())) {
			throw new BizException("预约患者为空，请检查！");
		}
		// 1、 检查预约申请单状态是否作废
		this.checkScAptApplStatus(appDTO);
		// 2、 根据执行科室 渠道id 获取符合要求的所有排班
		MtResDTO[] scSchs = new GetMtResList4AutoAptBP().exec(this.getQry4ScSch(appDTO.getId_dep_mp(), ScAppUtils.getServerDate(),appDTO.getId_srv(),appDTO.getId_enttp(),resDTO.getId_scca(),FBoolean.FALSE));
		if(ArrayUtil.isEmpty(scSchs)){
			throw new BizException(IScMsgConst.SC_APT_NOT_FIND_SCH);
		}
		
		// 3、 医技服务互斥检查 根据idSrv和患者id查询出患者从一定时间开始的所有预约记录并且计算出各种互斥类型的日期在resDTO中返回
		if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_MT)) {
			this.checkSrvMutex(appDTO.getId_pat(), appDTO.getId_srv(),appDTO.getId_ent(), ScAppUtils.getServerDateTime(), resDTO,appDTO.getFg_hp());
		}
	
		// 4、 根据排斥日期筛选出可用排班
		scSchs = this.getScSch8ExclDate(scSchs, resDTO);
		if(ArrayUtil.isEmpty(scSchs)){
			throw new BizException(IScMsgConst.SC_APT_NOT_FIND_EXCL_SCH);
		}
		
		// 5、渠道期间检查
		scSchs = new AptCheckChlPeriodAutoBP().exec(resDTO.getId_scchl(), sd_sctp,scSchs);
		if(ArrayUtil.isEmpty(scSchs)){
			throw new BizException(IScMsgConst.SC_APT_NOT_FIND_PERIOD_SCH);
		}
		// 6.2、检查申请单记账状态                   SD_SCTP_MT：  医技
		if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_MT) && ScParamUtils.getScAptMtChkFee(appDTO.getId_dep_mp()) && !appDTO.getFg_needcfm().booleanValue()) {
			this.checkMtAppFeeStatus(appDTO);
		}
		// 6.3、检查预约申请单(有申请单)
		if (!StringUtil.isEmptyWithTrim(appDTO.getId_or())) {
			this.checkApp(appDTO, sd_sctp);
		}
		boolean hasAptRes = false;
		String id_apt = "";
		String id_apt_mt ="";
		ScPlanDO planDO = null;
		// 6、 循环处理排班数据
		for (MtResDTO scSchDO : scSchs) {
			// 本次排班是否可以预约
			boolean isApt = false;
			
			// 6.1、查询排班计划 
			 planDO = aptEP.getScPlan(scSchDO.getId_scpl());
			
			// 6.4、查询排班信息
			ScSchDO schDO = aptEP.getSch(scSchDO.getId_sch());
			
			// 6.5、查询渠道信息
			ScSchChlDO[] chlDOs = aptEP.getSchChlByCond(String.format("id_sch = '%s' and id_scchl = '%s'", scSchDO.getId_sch(), resDTO.getId_scchl()),null);
			if(ArrayUtil.isEmpty(chlDOs)){
				continue;
			}
			// 6.6、校验排班数据
			if(!this.checkSchInfo(planDO, schDO, chlDOs[0])){
				continue;
			} 
			// 6.7 根据科室参数SC0030 判断是否需要校验排班服务
			if(ScParamUtils.getscAptCOI(ScContextUtils.getDeptId()).booleanValue()){
				this.checkSchSrv(appDTO.getId_srv(),scSchDO.getId_sch(),planDO);
			}
			// 6.8、 获取可用号位信息
			resDTO.setFg_release(scSchDO.getFg_release());
			ScSchTickDO tickDO = this.getSchTick(planDO, resDTO, appDTO, resDTO.getId_scchl(),chlDOs,schDO);
			if(tickDO == null){
				continue;
			}else{
				isApt = true;
			}
			// 6.9、保存预约信息
			ScaptAggDO aptAggDO = new GetAptAggBp().exec(planDO, schDO, tickDO, appDTO.getId_pat(), chlDOs[0].getId_scchl(),FBoolean.FALSE);
			
			// 6.10、保存预约申请
			ScAptApplDO[] aptApplDOs = ServiceFinder.find(IScaptapplMDORService.class).find(" id_aptappl='"+appDTO.getId_apt_appl()+"'", null, FBoolean.FALSE);
			
			ScAptApplDO aptApplDO = null;
			if(ArrayUtil.isEmpty(aptApplDOs)){
				aptApplDO = this.saveAptAppl(schDO, planDO, appDTO, sd_sctp);
			}else{
				aptApplDO = this.saveAptAppl(schDO, planDO, appDTO, sd_sctp,aptApplDOs[0]);
			}
			
			// 6.11、非住院、门诊、医技、手术预约需保存其他预约扩展表
			this.saveOthApt(aptAggDO, aptApplDO, sd_sctp);

			// 6.12、保存医技预约信息
			if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_MT)) {
				aptAggDO = this.saveMtApt(aptAggDO, resDTO, appDTO, aptApplDO,planDO,scSchDO);
				id_apt_mt = aptAggDO.getScAptMtDO()[0].getId_aptmt();//为了拍照传给前台id
				id_apt = aptAggDO.getScAptMtDO()[0].getId_apt();
			} else {
				aptAggDO = this.saveOptApt(aptAggDO, aptApplDO, planDO);
			}
			
			// 6.13、回写预约申请
			this.rewriteScAptAppl(aptAggDO, aptApplDO);
				
			// 6.14、更新医嘱申请单状态
			if(EuAptmd.APPL.equals(appDTO.getSd_aptmd())){
			if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_MT)) {
				MtAptCiObsOperateBP mtAptCiObsOperateBP=  new MtAptCiObsOperateBP();
				// 回写医嘱医技申请单
				if (!aptApplDO.getFg_multor().booleanValue()){
					mtAptCiObsOperateBP.rewriteObsStatus(appDTO.getId_or(), Boolean.TRUE,aptAggDO.getParentDO().getDt_appt());
				} else {
					List<String> orList = this.getIdOrList(appDTO);
					if (orList != null){
						for(String id_or : orList){
							mtAptCiObsOperateBP.rewriteObsStatus(id_or, Boolean.TRUE,aptAggDO.getParentDO().getDt_appt());
						}
					}
				}
				//new MtAptCiObsOperateBP().rewriteObsStatus(appDTO.getId_or(), Boolean.TRUE,aptAggDO.getParentDO().getDt_appt());
			} else {
				// 回写医嘱手术申请单
				if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_OT)) {
					if (!StringUtil.isEmptyWithTrim(appDTO.getId_or())) {
						new OptAptCiObsOperateBP().rewriteAptSuccess(appDTO.getId_or(), new FDateTime(schDO.getD_sch(), tickDO.getT_b()));
					}
				}
			}
			if(appDTO.getOr_closed_flag() == null || appDTO.getOr_closed_flag().booleanValue())
			{
			RewriteOrClosedLoopState.exec(appDTO.getId_or(), appDTO.getDt_effe_or(), "43401110",0);// 43401110=医技预约(中心预约) 功能节点编码
				}
			}
			
			
			// 6.16、 预约成功跳出循环 
			if(isApt){
				hasAptRes = true;
				resDTO.setId_sch(schDO.getId_sch());
				resDTO.setScpolcn(tickDO.getPolno());
				resDTO.setQueno(tickDO.getQueno());
				resDTO.setApt_time(tickDO.getT_b());
				this.handleAutoPrnPho(resDTO, schDO.getId_scca(), resDTO.getId_dep(),aptAggDO.getParentDO().getId_apt(),aptAggDO.getScAptMtDO()[0].getFg_needcfm(),appDTO.getFg_auto_cfm(),appDTO);
				break;
			}
		}
		// 7、返回最新的数据
		this.validate(resDTO, appDTO.getId_srv());
		MtResDTO mtRes = new GetMtResBP().exec(resDTO.getId_dep(), resDTO.getId_sch(), resDTO.getId_scchl(),resDTO.getFg_autofilter(),appDTO.getId_srv());
		if(!hasAptRes){
			throw new BizException(IScMsgConst.ERROR_SC_APT_RES_NOT_ENOUGH);
		}else{
			this.initInfo(mtRes,appDTO,resDTO,id_apt_mt,planDO,id_apt);
		}
		return mtRes;
	}
	/**
	 * 校验关键数据
	 * @param resDTO
	 * @param id_srv
	 * @throws BizException
	 */
	private void validate(MtResDTO resDTO,String id_srv) throws BizException{
		boolean isCheck = true;
		if(ScValidator.isNullOrEmpty(resDTO.getId_sch())){
			isCheck = false;
		}
		if(ScValidator.isNullOrEmpty(resDTO.getId_dep())){
			isCheck = false;
		}
		if(ScValidator.isNullOrEmpty(resDTO.getId_scchl())){
			isCheck = false;
		}
		if(resDTO.getFg_autofilter().booleanValue()){
			if(ScValidator.isNullOrEmpty(id_srv)){
				isCheck = false;
			}
		}
		if(!isCheck){
			throw new BizException(IScMsgConst.SC_APT_NOT_FIND_MATCH_SCH);
		}
	}
	/**
	 * 校验医疗服务是否在排班所对应排班服务当中
	 * @param id_srv
	 * @param schDO
	 * @throws BizException 
	 */
	private boolean checkSchSrv(String id_srv,String id_sch,ScPlanDO planDO) throws BizException{
		// 排班服务查询服务
		IScheduleSrvRelDORService relQryService = ServiceFinder.find(IScheduleSrvRelDORService.class);
		String where = String.format(ScheduleSrvRelDO.ID_MDSRV + " = '%s'", id_srv);
		ScheduleSrvRelDO[] relDOs = relQryService.find(where, null, FBoolean.FALSE);
		if (ArrayUtil.isEmpty(relDOs)) {
			return false;
		}
		List<String> scSrvIds = new ArrayList<String>();
		for (ScheduleSrvRelDO relDO : relDOs) {
			scSrvIds.add(relDO.getId_scsrv());
		}
		//查询排班的备用排班服务
		IScSchOptsrvDORService iscschoptsrvdorservice = ServiceFinder.find(IScSchOptsrvDORService.class);
		ScSchOptsrvDO[] optsrvs = iscschoptsrvdorservice.find("id_sch='"+id_sch+"'", null, FBoolean.FALSE);
		if(!ArrayUtil.isEmpty(optsrvs)){
			for (ScSchOptsrvDO scSchOptsrvDO : optsrvs) {
				scSrvIds.add(scSchOptsrvDO.getId_scsrv());
			}
		}
		if(!scSrvIds.contains(planDO.getId_scsrv())){
			return false;
		}
		return true;
	}
	/**
	 * 获取排班号位
	 *
	 * @param planDO
	 * @param resDTO
	 * @param appDTO
	 * @param id_scchl
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private ScSchTickDO getSchTick(ScPlanDO planDO, MtResDTO resDTO, MtAppDTO appDTO, String id_scchl,ScSchChlDO[] chlDOs,ScSchDO schDO)
			throws BizException {
		List<Integer> polcnList = new ArrayList<Integer>();
		for (ScSchChlDO scschchldo : chlDOs) {
			polcnList.add(scschchldo.getScpolcn());
		}
		ScSchTickDO tickDO = null;
		IScSchOutCmdService outQryService = ServiceFinder.find(IScSchOutCmdService.class);
		String sd_tickmd = schDO.getSd_tickmd();// 票号模式
		List<String> schIdList = new ArrayList<String>();
		schIdList.add(schDO.getId_sch());
		Map<String, Map<Integer,Integer>> polcnMap = ServiceFinder.find(IScSchOutQryService.class).batchGetChlSchRemainFilterEntpAmount4AutoApt(schIdList,appDTO.getId_enttp(), id_scchl);
		if(polcnMap == null) return null;
		Map<Integer,Integer> polcnNumMap = polcnMap.get(schDO.getId_sch());
		if (IScDictCodeConst.SD_TICKMD_TICK.equals(sd_tickmd)) {// 号位模式
			// 自动预约
			tickDO = outQryService.occupyChlTickBySch4Auto(schDO.getId_sch(),polcnNumMap, null, id_scchl, appDTO.getId_enttp(), resDTO,appDTO.getId_srv());
		} else if (IScDictCodeConst.SD_TICKMD_TICKS.equals(sd_tickmd)) {// 号段模式
			// 占用号段号位
			tickDO = outQryService.occupyChlTickBySch4Auto(schDO.getId_sch(), polcnNumMap,resDTO.getId_ticks(), id_scchl,appDTO.getId_enttp(),resDTO,appDTO.getId_srv());
		} else if(IScDictCodeConst.SD_TICKMD_TIME.equals(sd_tickmd)){//时间片模式
			// 占用时间段号位
			tickDO = outQryService.occupyChlTimeBySch4Auto(planDO, appDTO, id_scchl,chlDOs,schDO,resDTO);
		}
		return tickDO;
	}
	
	/**
	 * 保存医技预约
	 *
	 * @author zhengcm
	 * 
	 * @param aptAggDO
	 * @param resDTO
	 * @param appDTO
	 * @param applDO
	 * @return
	 * @throws BizException
	 */
	private ScaptAggDO saveMtApt(ScaptAggDO aptAggDO, MtResDTO resDTO, MtAppDTO appDTO, ScAptApplDO applDO,ScPlanDO planDO,MtResDTO scSchDO)
			throws BizException {
		ScAptMtDO mtAptDO = new ScAptMtDO();
		mtAptDO.setStatus(DOStatus.NEW);
		mtAptDO.setId_grp(ScContextUtils.getGrpId()); // 预约集团
		mtAptDO.setId_org(ScContextUtils.getOrgId()); // 预约机构
		mtAptDO.setFg_arrive(FBoolean.FALSE); // 医技辅签到标志
		mtAptDO.setId_dep_mp(resDTO.getId_dep()); // 执行部门
		mtAptDO.setId_mt(scSchDO.getId_mt()); // 资源医技辅id
		mtAptDO.setFg_needcfm(GetScSrvDOBySccaAndSrv(aptAggDO.getParentDO().getId_scca(),appDTO.getId_srv()));//是否需要确认
		//如果该服务需要确认 且勾选了自动确认 则直接将该预约进行确认
		if (mtAptDO.getFg_needcfm().booleanValue() && appDTO.getFg_auto_cfm() != null && appDTO.getFg_auto_cfm().booleanValue()) {
			Boolean chkFee = ScParamUtils.getScAptMtChkFee(appDTO.getId_dep_mp());//检查费用参数
			if(chkFee && !appDTO.getFg_bl().booleanValue()){
				mtAptDO.setFg_aptcfm(FBoolean.FALSE);
			}else{
				mtAptDO.setFg_aptcfm(appDTO.getFg_auto_cfm()==null?FBoolean.FALSE:appDTO.getFg_auto_cfm());
				if (mtAptDO.getFg_aptcfm().booleanValue()) {
					mtAptDO.setId_emp_cfm(ScContextUtils.getPsnId());
					mtAptDO.setDt_apt_cfm(ScAppUtils.getServerDateTime());
				}
			}		
		}
		mtAptDO.setId_aptappl(applDO.getId_aptappl());// 预约申请ID
		mtAptDO.setNote(appDTO.getNote());//预约备注
		aptAggDO.setScAptMtDO(new ScAptMtDO[] { mtAptDO });
		// 保存
		aptAggDO = new AptEP().save(new ScaptAggDO[] { aptAggDO })[0];
		// 触发检查预约信息事件
		MtApt4EsDTO apt4EsDTO = new MtApt4EsDTO();
		apt4EsDTO.setId_apt(aptAggDO.getParentDO().getId_apt());
		new MakeMtAptEvent().invoke(apt4EsDTO);
		return aptAggDO;
	}
	
	//根据排班分类，医疗项目 查询是否需要确认
	private FBoolean GetScSrvDOBySccaAndSrv(String id_scca,String id_srv) throws BizException
	{
		IScbdsrvMDORService scbdsrvMDORService = ServiceFinder.find(IScbdsrvMDORService.class);
		ScBdsrvDO[] dos = scbdsrvMDORService.find(" id_srv = '"+id_srv+"' and id_scca = '"+id_scca+"'", "", FBoolean.FALSE);
		if(dos.length == 0)
		{
			return FBoolean.FALSE;
		}
		else
		{
			return dos[0].getFg_needcfm();
		}
	}

	/**
	 * 保存手术预约
	 * 
	 * @author zhengcm
	 *
	 * @param aptAggDO
	 * @param applDO
	 * @param planDO
	 * @return
	 * @throws BizException
	 */
	private ScaptAggDO saveOptApt(ScaptAggDO aptAggDO, ScAptApplDO applDO, ScPlanDO planDO) throws BizException {
		// 预约资源
		IScheduleresRService resQryService = ServiceFinder.find(IScheduleresRService.class);
		ScheduleResDO resDO = resQryService.findById(aptAggDO.getParentDO().getId_scres());
		ScAptOptDO optDO = new ScAptOptDO();
		optDO.setStatus(DOStatus.NEW);
		optDO.setFg_arrive(FBoolean.FALSE);
		optDO.setId_dep_belong(planDO.getId_dep());
		optDO.setId_aptappl(applDO.getId_aptappl());// 预约申请ID
		optDO.setId_opt(resDO.getId_opt());// 手术台
		aptAggDO.setScAptOptDO(new ScAptOptDO[] { optDO });
		// 保存
		aptAggDO = new AptEP().save(new ScaptAggDO[] { aptAggDO })[0];
		return aptAggDO;
	}

	/**
	 * 回写预约申请
	 *
	 * @author zhengcm
	 * 
	 * @param aptAggDO
	 * @param applDO
	 * @throws BizException
	 */
	private void rewriteScAptAppl(ScaptAggDO aptAggDO, ScAptApplDO applDO) throws BizException {
		if (null == aptAggDO || null == applDO) {
			return;
		}
		applDO.setStatus(DOStatus.UPDATED);
		applDO.setId_scapt(aptAggDO.getParentDO().getId_apt());
		applDO.setFg_comfirm(FBoolean.TRUE);
		new MtAptEP().saveAptAppl(new ScAptApplDO[] { applDO });
	}

	/**
	 * 保存预约申请
	 *
	 * @author zhengcm
	 * 
	 * @param schDO
	 * @param planDO
	 * @param appDTO
	 * @return
	 * @throws BizException
	 */
	private ScAptApplDO saveAptAppl(ScSchDO schDO, ScPlanDO planDO, MtAppDTO appDTO, String sd_sctp)
			throws BizException {

		MtAptEP mtAptEP = new MtAptEP();
		// 就诊DO
		PatiVisitDO entDO = null;
		if (!StringUtil.isEmptyWithTrim(appDTO.getId_ent())) {
			entDO = mtAptEP.getEntById(appDTO.getId_ent());
		}
		// 患者DO
		PatDO patDO = mtAptEP.getPatById(appDTO.getId_pat());
		ScAptApplDO applDO = new ScAptApplDO();
		applDO.setStatus(DOStatus.NEW);
		applDO.setDt_effe_or(appDTO.getDt_effe_or());
		applDO.setId_srv(appDTO.getId_srv());
		applDO.setId_grp(planDO.getId_grp());
		applDO.setId_org(planDO.getId_org());
		applDO.setSd_sctp(sd_sctp);
		applDO.setId_scca(planDO.getId_scca());
		applDO.setPriority(0);
		applDO.setDt_appl(ScAppUtils.getServerDateTime());
		applDO.setFg_comfirm(FBoolean.FALSE);
		applDO.setFg_canc(FBoolean.FALSE);
		applDO.setId_or(appDTO.getId_or());
		if (null != entDO) {
			applDO.setCode(this.createScAptApplCode(entDO.getCode_entp()));
			applDO.setCode_entp(entDO.getCode_entp());// 就诊类型编码
			applDO.setId_ent(entDO.getId_ent());// 就诊ID
		} else {
			applDO.setCode(this.createScAptApplCode(null));
		}
		applDO.setName(appDTO.getName_or());// 医嘱名称
		applDO.setApplyno(appDTO.getNo_applyform());// 医嘱申请单号
		applDO.setDes(appDTO.getDesc_or());// 医嘱描述
		applDO.setFg_urgent(appDTO.getFg_urgent());// 加急标识
		if (StringUtil.isEmptyWithTrim(appDTO.getId_or())) {
			applDO.setD_b(schDO.getD_sch());
			applDO.setContent_or(appDTO.getName_or());// 医嘱内容
		} else {
			applDO.setD_b(appDTO.getDt_plan().getBeginDate());
			if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_OT)) {
				// 更新医嘱的日期为预约日期
				applDO.setContent_or(appDTO.getContent_or().replaceFirst("\\d{4}-\\d{2}-\\d{2}",
						schDO.getD_sch().toLocalString()));// 医嘱内容
			} else {
				applDO.setContent_or(appDTO.getContent_or());// 医嘱内容
			}
		}
		
		applDO.setId_dep_appl(appDTO.getId_dep_apply());
		applDO.setId_emp_appl(appDTO.getId_emp_apply());
		applDO.setId_pi(patDO.getId_pat());
		applDO.setPi_name(patDO.getName());
		applDO.setPiname(patDO.getName());
		applDO.setId_sex(patDO.getId_sex());
		applDO.setSd_sex(patDO.getSd_sex());
		applDO.setSex_name(patDO.getName_sex());
		applDO.setD_pi(patDO.getDt_birth());
		applDO.setPimobile(patDO.getMob());
		applDO.setId_scsrv(planDO.getId_scsrv());
		applDO.setId_scres(planDO.getId_scres());
		// 预约模式
		if (StringUtil.isEmptyWithTrim(appDTO.getId_or())) {
			applDO.setEu_aptmd(EuAptmd.MANUAL);// 非申请单
		} else {
			applDO.setEu_aptmd(EuAptmd.APPL);// 申请单
		}
		// 保存预约申请
		return mtAptEP.saveAptAppl(new ScAptApplDO[] { applDO })[0];
	}
	/**
	 * 保存预约申请
	 *
	 * @author zhengcm
	 * 
	 * @param schDO
	 * @param planDO
	 * @param appDTO
	 * @return
	 * @throws BizException
	 */
	private ScAptApplDO saveAptAppl(ScSchDO schDO, ScPlanDO planDO, MtAppDTO appDTO, String sd_sctp,ScAptApplDO applDO)
			throws BizException {

		MtAptEP mtAptEP = new MtAptEP();
		// 就诊DO
		PatiVisitDO entDO = null;
		if (!StringUtil.isEmptyWithTrim(appDTO.getId_ent())) {
			entDO = mtAptEP.getEntById(appDTO.getId_ent());
		}
		// 患者DO
		applDO.setStatus(DOStatus.UPDATED);
		applDO.setId_scca(planDO.getId_scca());
		applDO.setPriority(0);
		applDO.setDt_appl(ScAppUtils.getServerDateTime());
		applDO.setFg_comfirm(FBoolean.FALSE);
		applDO.setFg_canc(FBoolean.FALSE);
		if (null == entDO) {
			applDO.setCode(this.createScAptApplCode(null));
		}
		applDO.setId_scsrv(planDO.getId_scsrv());
		applDO.setId_scres(planDO.getId_scres());
		// 预约模式
		if (StringUtil.isEmptyWithTrim(appDTO.getId_or())) {
			applDO.setEu_aptmd(EuAptmd.MANUAL);// 非申请单
		} else {
			applDO.setEu_aptmd(EuAptmd.APPL);// 申请单
		}
		// 保存预约申请
		return mtAptEP.saveAptAppl(new ScAptApplDO[] { applDO })[0];
	}

	/**
	 * 非住院、门诊、医技、手术预约需保存其他预约扩展表
	 * 
	 * @author zhengcm
	 *
	 * @param aptAggDO
	 * @param applDO
	 * @param sd_sctp
	 * @throws BizException
	 */
	private void saveOthApt(ScaptAggDO aptAggDO, ScAptApplDO applDO, String sd_sctp) throws BizException {
		if (!StringUtil.isEmptyWithTrim(sd_sctp) && !sd_sctp.equals(IScDictCodeConst.SD_SCTP_MT)
				&& !sd_sctp.equals(IScDictCodeConst.SD_SCTP_OT)) {
			AptOthDO othDO = new AptOthDO();
			othDO.setStatus(DOStatus.NEW);
			othDO.setId_grp(aptAggDO.getParentDO().getId_grp());
			othDO.setId_org(aptAggDO.getParentDO().getId_org());
			othDO.setId_apt(aptAggDO.getParentDO().getId_apt());
			othDO.setId_aptappl(applDO.getId_aptappl());
			IAptothCudService cmdService = ServiceFinder.find(IAptothCudService.class);
			cmdService.save(new AptOthDO[] { othDO });
		}
	}

	/**
	 * 创建预约申请编码
	 *
	 * @author zhengcm
	 * 
	 * @param sd_entp 就诊类型编码
	 * @return 编码
	 * @throws BizException
	 */
	private String createScAptApplCode(String sd_entp) throws BizException {
		String code = this.createCode(ScAptApplDODesc.CLASS_FULLNAME);
		if (!StringUtil.isEmptyWithTrim(sd_entp)) {
			code = code.substring(0, 3) + sd_entp + code.substring(3);
		}
		return code;
	}

	/**
	 * 生成编码
	 * 
	 * @param doDescFullName 实体元数据类全名
	 * @return 根据编码规则生成编码
	 * @throws BizException
	 */
	private String createCode(String doDescFullName) throws BizException {
		IBillcodeManage codeManage = ServiceFinder.find(IBillcodeManage.class);
		String code = codeManage.getPreBillCode_RequiresNew(doDescFullName);
		return code;
	}

	/**
	 * 校验数据
	 *
	 * @param planDO
	 * @param schDO
	 * @param chlDO
	 * @throws BizException
	 * @author zhengcm
	 */
	private boolean checkSchInfo(ScPlanDO planDO, ScSchDO schDO, ScSchChlDO chlDO) throws BizException {
		if (null == planDO) {
			return false;
		}
		if (null == schDO) {
			return false;
		} else if (!schDO.getFg_active().booleanValue()) {
			return false;
		}
		if (null == chlDO) {
			return false;
		}
		return true;
	}

	/**
	 * 医技服务互斥检查
	 * @param id_pat 患者id
	 * @param id_srv 诊疗项目 id
	 * @param id_ent 就诊id
	 * @param aptTime 预约时间
	 * @param resDTO 排班数据
	 * @param fg_hp 医保支付标识
	 * @throws BizException
	 * @author yzh
	 */
	private void checkSrvMutex(String id_pat, String id_srv,String id_ent,FDateTime aptTime,MtResDTO resDTO,FBoolean fg_hp) throws BizException {
		// 检查患者是否存在有效期内的互斥项目
		IScSchOutQryService schOutQryService = ServiceFinder.find(IScSchOutQryService.class);
		schOutQryService.mutexCheck4AutoMtApt8ExclDate(id_pat, id_srv,id_ent,aptTime,resDTO,fg_hp);
	}
	/**
	 * 检查申请单计费状态
	 * @param appDTO
	 * @throws BizException
	 */
	private void checkMtAppFeeStatus(MtAppDTO appDTO) throws BizException{
		// 住院不检查申请单计费状态
		if (appDTO.getId_enttp().equals(IBdFcDictCodeConst.ID_CODE_ENTP_IP)) {
			return;
		}
		ScAptApplDO[] aptApplDOs = ServiceFinder.find(IScaptapplMDORService.class).find(" id_aptappl='"+appDTO.getId_apt_appl()+"' and fg_canc='N' ", null, FBoolean.FALSE);
		if(!ArrayUtil.isEmpty(aptApplDOs)){
			ScAptApplDO scaptappldo = aptApplDOs[0];
			if (!scaptappldo.getFg_bl().booleanValue() && !appDTO.getFg_needcfm().booleanValue()) {
				throw new BizException(String.format(IScMsgConst.SC_APT_MT_NOT_SUIT_FEE_STATUS, IScMsgConst.SC_APT_MT_NOT_FEE));
			}
		}else{
			throw new BizException(IScMsgConst.SC_APT_APPL_NOT_FOUND);
		}
	}

	/**
	 * 检查预约申请单
	 * 
	 * @author zhengcm
	 *
	 * @param appDTO
	 * @param sd_sctp
	 * @throws BizException
	 */
	private void checkApp(MtAppDTO appDTO, String sd_sctp) throws BizException {
		// 检查申请单是否已预约
		if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_OT) || sd_sctp.equals(IScDictCodeConst.SD_SCTP_MT)) {
		StringBuilder sb = new StringBuilder();
		sb.append("select apt.id_apt ");
		sb.append("from sc_apt apt ");
		sb.append("inner join sc_apt_appl appl on appl.id_scapt = apt.id_apt ");
		sb.append("where 1 = 1 ");
		sb.append("and apt.fg_canc = 'N' ");
		sb.append("and appl.id_aptappl = ? ");
		SqlParam params = new SqlParam();
		params.addParam(appDTO.getId_apt_appl());
		String id_apt = (String) new DAFacade().execQuery(sb.toString(), params, new ColumnHandler());
		if (!StringUtil.isEmptyWithTrim(id_apt)) {
			throw new BizException("该申请单已预约，不能重复预约！");
		}
	}
	}
	
	/**
	 * 组装查询排班的入参
	 * @author yzh
	 * @param id_dep
	 * @param dt_b
	 * @param sd_sctp
	 * @return
	 */
	private MtAppQryDTO getQry4ScSch(String id_dep,FDate dt_b,String id_srv,String id_entp,String id_scca,FBoolean fg_autofilter){
		MtAppQryDTO qry = new MtAppQryDTO();
		qry.setFg_autofilter(fg_autofilter);
		qry.setId_dep(id_dep);
		qry.setD_begin(dt_b);
		qry.setId_srv(id_srv);
		qry.setId_entp(id_entp);
		qry.setQrytype(0);// 3为手术
		qry.setId_scca(id_scca);
		
		return qry;
	}
	/**
	 * 通过互斥日期筛选可用的排班
	 * @author yzh
	 * @param scSchDOs
	 * @param resDTO
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private MtResDTO[] getScSch8ExclDate(MtResDTO[] scSchDOs, MtResDTO resDTO) {
		this.duplicateExclDate(resDTO);
		List<MtResDTO> result = new ArrayList<MtResDTO>();
		List<MtResDTO> canuse_scsch_result = new ArrayList<MtResDTO>();
		List<MtResDTO> mustuse_scsch_result = new ArrayList<MtResDTO>();
		List<MtResDTO> mustsel_scsch_result = new ArrayList<MtResDTO>();
		
		FArrayList days_excl_must = resDTO.getDays_excl_must();// 排斥禁止
		FArrayList days_excl_times = resDTO.getDays_excl_times();// 排斥次数禁止
		FArrayList days_together_must = resDTO.getDays_together_must();// 并行禁止
		FArrayList days_together_hint = resDTO.getDays_together_hint();// 并行提示
		for (MtResDTO scSchDO : scSchDOs) {
			FDate d_sch = scSchDO.getD_sch().asBegin();
			boolean canUseCheck = true;//可用
			boolean mustUseCheck = false;//并行提示
			boolean mustSelCheck = false;//并行禁止
			// 1.过滤排斥禁止
			if (!ListUtil.isEmpty(days_excl_must)) {
				for (Object exclMust : days_excl_must) {
					FMap dtMap = (FMap) exclMust;
					if(MapUtils.isEmpty(dtMap)){
						continue;
					}
					FDate dt_b = new FDate(dtMap.get("dt_b").toString());
					FDate dt_e = new FDate(dtMap.get("dt_e").toString());
					if (d_sch.compareTo(dt_b) > 0 && d_sch.compareTo(dt_e) < 0) {
						canUseCheck = false;
					}
				}
			}
			// 2.过滤排斥次数
			if (!ListUtil.isEmpty(days_excl_times)) {
				if (canUseCheck) {
					Map<String,Integer> countMap = new HashMap<String,Integer>();
					for (Object exclTime : days_excl_times) {
						int countMax = 0;
						FArrayList timesList = (FArrayList) exclTime;
						if (!ListUtil.isEmpty(timesList)) {
							for (Object exclTimeMap : timesList) {
								FMap dtMap = (FMap) exclTimeMap;
								if(MapUtils.isEmpty(dtMap)){
									continue;
								}
								if (countMap.containsKey(dtMap.get("pk"))) {
									countMax = countMap.get(dtMap.get("pk"));
								}
								int times = Integer.parseInt(dtMap.get("times").toString());
								FDate dt_b = new FDate(dtMap.get("dt_b").toString());
								FDate dt_e = new FDate(dtMap.get("dt_e").toString());
								if (d_sch.compareTo(dt_b) >= 0 && d_sch.compareTo(dt_e) <= 0) {
									countMax++;
								}
								if (countMax == times) {
									canUseCheck = false;
									break;
								}
								countMap.put(dtMap.get("pk").toString(), countMax);
							}
						}
					}
				}
			}
			// 通过了排斥禁止和次数限制限制后校验并行禁止 符合并行禁止的排班要优先使用
			if(canUseCheck){
				// 3.过滤并行禁止
				if (!ListUtil.isEmpty(days_together_must)) {
					boolean select = false;
					for (Object togetherMust : days_together_must) {
						FMap dtMap = (FMap) togetherMust;
						if(MapUtils.isEmpty(dtMap)){
							continue;
						}
						FDate dt_b = new FDate(dtMap.get("dt_b").toString());
						FDate dt_e = new FDate(dtMap.get("dt_e").toString());
						FDate aptTime = new FDate(dtMap.get("aptTime").toString()).asBegin();
						if(d_sch.compareTo(dt_b) >= 0 && d_sch.compareTo(dt_e) <= 0 ){
							mustSelCheck = true;
							if(d_sch.compareTo(aptTime)==0){
								select = true;
							}
						}
					}
					if(mustSelCheck){
						if(select){
							scSchDO.setFg_release(FBoolean.TRUE);//强制并行释放号源类别明细
							mustsel_scsch_result.add(0, scSchDO);
						}else{
							if(mustsel_scsch_result.size() == 0)
							{
								mustsel_scsch_result.add(0,scSchDO);
							}
							else
							{
								mustsel_scsch_result.add(mustsel_scsch_result.size(),scSchDO);
							}
						}
					}else{
						canUseCheck = false;
					}
				}
			}
				// 过滤并行提示
				if (canUseCheck) {
					if(!ListUtil.isEmpty(days_together_hint)){
						boolean select = false;
						for (Object togetherHint : days_together_hint) {
							FMap dtMap = (FMap) togetherHint;
							if(MapUtils.isEmpty(dtMap)){
								continue;
							}
							FDate dt_b = new FDate(dtMap.get("dt_b").toString());
							FDate dt_e = new FDate(dtMap.get("dt_e").toString());
							FDate aptTime = new FDate(dtMap.get("aptTime").toString()).asBegin();
							if(d_sch.compareTo(dt_b) >= 0 && d_sch.compareTo(dt_e) <= 0 ){
								mustUseCheck = true;
								if(d_sch.compareTo(aptTime)==0){
									select = true;
								}
							}
						}
						if(mustUseCheck){
							scSchDO.setFg_release(FBoolean.TRUE);//强制并行释放号源类别明细
							if(select){
								mustuse_scsch_result.add(0, scSchDO);
							}else{
								mustuse_scsch_result.add(mustuse_scsch_result.size(),scSchDO);
							}
						}
					}
				}
			
			
			// 非并行禁止和并行提示的可用数据归入可用
			if (canUseCheck && !mustSelCheck && !mustUseCheck) {
				canuse_scsch_result.add(scSchDO);
			}
		}
		 
		// 4.顺序添加并行禁止的排班
		if (!ListUtil.isEmpty(mustsel_scsch_result)) {
			result.addAll(this.levelPriSort(mustsel_scsch_result));
		}
		// 5.顺序添加并行提示的排班
		if (!ListUtil.isEmpty(mustuse_scsch_result)) {
			result.addAll(this.levelPriSort(mustuse_scsch_result));
		}
		// 6.顺序添加可用的排班
		if(!ListUtil.isEmpty(canuse_scsch_result)){
			result.addAll(this.levelPriSort(canuse_scsch_result)); 
		}
		return result.toArray(new MtResDTO[0]);
	}
	/**
	 * 优先级排序
	 * @param resList
	 */
	@SuppressWarnings("unchecked")
	private List<MtResDTO> levelPriSort(List<MtResDTO> resList){
 		List<MtResDTO> result = new ArrayList<MtResDTO>(); 
		FMap map = new FMap();
		for (MtResDTO mtResDTO : resList) {
			if(!map.containsKey(mtResDTO.getD_sch().toString())){
				List<MtResDTO> list = new ArrayList<MtResDTO>();
				list.add(mtResDTO);
				map.put(mtResDTO.getD_sch().toString(), list);
			}else{
				List<MtResDTO> list =  (List<MtResDTO>) map.get(mtResDTO.getD_sch().toString());
				list.add(mtResDTO);
			}
		}
		for (Entry<String, Object> entry : map.entrySet()) {
			List<MtResDTO> list = (List<MtResDTO>) entry.getValue();
			Collections.sort(list, new Comparator<MtResDTO>() {
				@Override
				public int compare(MtResDTO o1, MtResDTO o2) {
					// 按照优先级进行降序排序
					if (o1.getT_b_acpt().before(o2.getT_b_acpt())) {
						return -1;
					}
					if (o1.getT_b_acpt().compareTo(o2.getT_b_acpt()) == 0) {
						return 0;
					}
					return 1;
				}
			});
		}
		for (Entry<String, Object> entry : map.entrySet()) {
			List<MtResDTO> list = (List<MtResDTO>) entry.getValue();
			Collections.sort(list, new Comparator<MtResDTO>() {
				@Override
				public int compare(MtResDTO o1, MtResDTO o2) {
					// 按照优先级进行降序排序
					if (o1.getLevel_pri() > o2.getLevel_pri()) {
						return -1;
					}
					if (o1.getLevel_pri() == o2.getLevel_pri()) {
						if(o1.getT_b_acpt().compareTo(o2.getT_b_acpt()) == 0){
							int o1Remain = 0;
							int o2Remain = 0;
							if(IScDictCodeConst.SD_TICKMD_TIME.equals(o1.getSd_tickmd())){
								o1Remain = o1.getQuan_total_appt()-o1.getQuan_total_used();
								o1Remain = (int) Math.floor(o1Remain/((o1.getSrvlot() == null || o1.getSrvlot() == 0)?(o1.getSrvlot_min() == null || o1.getSrvlot_min()==0)?1:o1.getSrvlot_min():o1.getSrvlot()));
							}else{
								o1Remain = o1.getQuan_total_appt()-o1.getQuan_total_used();
							}
							if(IScDictCodeConst.SD_TICKMD_TIME.equals(o2.getSd_tickmd())){
								o2Remain = o2.getQuan_total_appt()-o2.getQuan_total_used();
								o2Remain = (int) Math.floor(o2Remain/((o1.getSrvlot() == null || o1.getSrvlot() == 0)?(o2.getSrvlot_min() == null || o2.getSrvlot_min() ==0)?1:o2.getSrvlot_min():o2.getSrvlot()));
							}else{
								o2Remain = o2.getQuan_total_appt()-o2.getQuan_total_used();
							}
							if(o1Remain > o2Remain){
								return -1;
							}
						}
						return 0;
					}
					return 1;
				}
			});
			result.addAll(list);
		}
		return result;
	}
	/**
	 * 去除排斥日期中重复的数据
	 * @param resDTO
	 */
	@SuppressWarnings("unchecked")
	private void duplicateExclDate(MtResDTO resDTO){
		FArrayList exclMust = resDTO.getDays_excl_must();
		FArrayList exclTimes = resDTO.getDays_excl_times();
		FArrayList togetherMust = resDTO.getDays_together_must();
		FArrayList exclHint = resDTO.getDays_excl_hint();
		FArrayList togetherHint = resDTO.getDays_together_hint();
		// 1.排斥禁止
		if(!ListUtil.isEmpty(exclMust)){
			FArrayList exclMustTemp = new FArrayList();
			Set<FMap> setData = new HashSet<FMap>();
			setData.addAll(exclMust);
			exclMustTemp.addAll(setData);
			resDTO.setDays_excl_must(exclMustTemp);
		}
		// 2.次数限制
		if (!ListUtil.isEmpty(exclTimes)) {
			FArrayList exclTimesTemp = new FArrayList();
			Set<FMap> setData = new HashSet<FMap>();
			setData.addAll(exclTimes);
			exclTimesTemp.addAll(setData);
			resDTO.setDays_excl_times(exclTimesTemp);
		}
		//3.并行禁止
		if(!ListUtil.isEmpty(togetherMust)){
			FArrayList togetherMustTemp = new FArrayList();
			Set<FMap> setData = new HashSet<FMap>();
			setData.addAll(togetherMust);
			togetherMustTemp.addAll(setData);
			resDTO.setDays_together_must(togetherMustTemp);
		}
		// 4.排斥提示
		if(!ListUtil.isEmpty(exclHint)){
			FArrayList exclHintTemp = new FArrayList();
			Set<FMap> setData = new HashSet<FMap>();
			setData.addAll(exclHint);
			exclHintTemp.addAll(setData);
			resDTO.setDays_excl_hint(exclHintTemp);
		}
		// 5.并行提示
		if(!ListUtil.isEmpty(togetherHint)){
			FArrayList togetherHintTemp = new FArrayList();
			Set<FMap> setData = new HashSet<FMap>();
			setData.addAll(togetherHint);
			togetherHintTemp.addAll(setData);
			resDTO.setDays_together_hint(togetherHintTemp);
		}
	}
	
	/**
	 * 初始化
	 * @param resDTO
	 */
	private void initInfo(MtResDTO resDTO,MtAppDTO appDTO,MtResDTO src,String id_apt_mt,ScPlanDO planDO,String id_apt){
		resDTO.setQueno(src.getQueno());
		resDTO.setId_aptappl(appDTO.getId_apt_appl());
		resDTO.setId_apt(id_apt);
		resDTO.setFg_auto_pho(src.getFg_auto_pho());
		resDTO.setFg_auto_prn(src.getFg_auto_prn());
		resDTO.setFg_auto_prn_bar(src.getFg_auto_prn_bar());
		resDTO.setId_pat(appDTO.getId_pat());
		resDTO.setId_dep(appDTO.getId_dep_mp());
		resDTO.setFg_stop_daysmsgs(FBoolean.FALSE);
		resDTO.setDays_excl_must(new FArrayList());
		resDTO.setDays_excl_hint(new FArrayList());
		resDTO.setDays_together_must(new FArrayList());
		resDTO.setDays_together_hint(new FArrayList());
		resDTO.setDays_excl_times(new FArrayList());
		resDTO.setId_srv(appDTO.getId_srv());
		resDTO.setId_scca(planDO.getId_scca());
		resDTO.setId_scsrv(planDO.getId_scsrv());
		resDTO.setId_dep(appDTO.getId_dep_mp());
		resDTO.setSrvlot(src.getSrvlot());
		resDTO.setSrvlot_min(src.getSrvlot_min());
		resDTO.setApt_time(src.getApt_time());
		if(!StringUtil.isEmpty(id_apt_mt))
		{
			resDTO.setId_apt_mt(id_apt_mt);
		}
	}
	/**
	 * 处理返回结果是否自动打印 和 自动拍照
	 * @author yzh
	 * @param resDTO
	 * @param id_scca
	 * @param id_dep
	 * @throws BizException 
	 */
	private void handleAutoPrnPho(MtResDTO resDTO,String id_scca,String id_dep,String id_apt,FBoolean fg_needcfm,FBoolean fg_auto_cfm,MtAppDTO appDTO) throws BizException{
		if(fg_needcfm.booleanValue())
		{
			Boolean chkFee = ScParamUtils.getScAptMtChkFee(appDTO.getId_dep_mp());// 检查费用参数
			if(fg_auto_cfm!= null && fg_auto_cfm.booleanValue() && ((chkFee && appDTO.getFg_bl().booleanValue()) || !chkFee)){
				IScAptQryService qryService = ServiceFinder.find(IScAptQryService.class);
				MtResDTO res = qryService.getDepPrintAndPhoto(id_apt);
				resDTO.setFg_auto_pho(res.getFg_auto_pho());
				resDTO.setFg_auto_prn(res.getFg_auto_prn());
				resDTO.setFg_auto_prn_bar(res.getFg_auto_prn_bar());
			}else{
			resDTO.setFg_auto_pho(FBoolean.FALSE);
			resDTO.setFg_auto_prn(FBoolean.FALSE);
				resDTO.setFg_auto_prn_bar(FBoolean.FALSE);
			}
			return;
		}
		IScdeptparamMDORService iscdeptparammdorservice = ServiceFinder.find(IScdeptparamMDORService.class);
		StringBuffer condtion = new StringBuffer();
		condtion.append("id_dep ='").append(id_dep).append("' and id_scca='").append(id_scca).append("'");
		ScDeptParamDO[] scDepParams = iscdeptparammdorservice.find(condtion.toString(), null, FBoolean.FALSE);
		resDTO.setId_apt(id_apt);
		if(ArrayUtil.isEmpty(scDepParams)){
			resDTO.setFg_auto_pho(FBoolean.FALSE);
			resDTO.setFg_auto_prn(FBoolean.FALSE);
			resDTO.setFg_auto_prn_bar(FBoolean.FALSE);
		}else{
			resDTO.setFg_auto_pho(scDepParams[0].getFg_auto_pho());
			resDTO.setFg_auto_prn(scDepParams[0].getFg_auto_prn());
			resDTO.setFg_auto_prn_bar(scDepParams[0].getFg_auto_prn_bar());
		}
	}
	
	/**
	 * 检查医技预约申请单状态是否正常
	 * @param appDTO
	 * @throws BizException 
	 */
	private void checkScAptApplStatus(MtAppDTO appDTO) throws BizException{
		ScAptApplDO[] aptApplDOs = ServiceFinder.find(IScaptapplMDORService.class).find(" id_aptappl='"+appDTO.getId_apt_appl()+"' and fg_canc='N' ", null, FBoolean.FALSE);
		if(ArrayUtil.isEmpty(aptApplDOs)){
			throw new BizException("未找到申请单，请确认申请单是否存在、是否已取消！");
		}
	}
	/**
	 * 根据申请单ID获取医嘱ID
	 *
	 * @param appDTO
	 * @throws BizException
	 * @author yu.b
	 */
	private List<String> getIdOrList(MtAppDTO appDTO) throws BizException {
		StringBuilder sql = new StringBuilder();
		SqlParam sqlParam = new SqlParam();
		sql.append("SELECT ID_OR FROM SC_APT_APPL_ITM WHERE ID_APTAPPL = ? ");
		sqlParam.addParam(appDTO.getId_apt_appl());
		List<String> orList = (List<String>) new DAFacade().execQuery(sql.toString(), sqlParam,
				new BeanListHandler(String.class));
		return orList;
	}
}
