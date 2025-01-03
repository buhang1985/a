package iih.sc.apt.s.bp.mt;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.ci.ord.cior.d.OrdApOpDO;
import iih.ci.ord.cior.i.ICiorappsurgeryMDORService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.pat.d.PatDO;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.dto.d.MtApt4EsDTO;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.dto.d.OptApt4OrmDTO;
import iih.sc.apt.dto.d.OtAppDTO;
import iih.sc.apt.s.bp.AptCheckChlPeriodBP;
import iih.sc.apt.s.bp.CheckAptTickChannelBP;
import iih.sc.apt.s.bp.GetAptAggBp;
import iih.sc.apt.s.bp.RewriteOrClosedLoopState;
import iih.sc.apt.s.bp.mt.apt.validate.ValSchSrvBP;
import iih.sc.apt.s.bp.opt.OptAptCiObsOperateBP;
import iih.sc.apt.s.ep.AptEP;
import iih.sc.apt.s.ep.MtAptEP;
import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.apt.s.event.MakeMtAptEvent;
import iih.sc.apt.s.event.MakeOptAptEvent;
import iih.sc.apt.scapt.d.AptOthDO;
import iih.sc.apt.scapt.d.ScAptMtDO;
import iih.sc.apt.scapt.d.ScAptOptDO;
import iih.sc.apt.scapt.d.ScaptAggDO;
import iih.sc.apt.scapt.i.IAptothCudService;
import iih.sc.apt.scaptappl.d.EuAptmd;
import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.apt.scaptappl.d.ScAptApplOptDO;
import iih.sc.apt.scaptappl.d.desc.ScAptApplDODesc;
import iih.sc.apt.scaptappl.i.IScAptApplOptDOCudService;
import iih.sc.apt.scaptappl.i.IScaptapplMDORService;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScParamUtils;
import iih.sc.scbd.bdsrv.d.ScBdsrvDO;
import iih.sc.scbd.bdsrv.i.IScbdsrvMDORService;
import iih.sc.scbd.scheduleres.d.ScheduleResDO;
import iih.sc.scbd.scheduleres.i.IScheduleresRService;
import iih.sc.sch.dto.d.SchTickMdTimeDTO;
import iih.sc.sch.i.IScSchOutCmdService;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.scp.scplan.d.ScPlanDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 保存医技预约信息(增加对手术预约的支持)
 * 
 * @author zhengcm
 *
 */
public class SaveMtAptBP {

	/**
	 * 保存医技预约信息
	 *
	 * @param resDTO
	 * @param appDTO
	 * @param sd_sctp
	 * @throws BizException
	 * @author zhengcm
	 */
	public MtResDTO exec(MtResDTO resDTO, MtAppDTO appDTO, String sd_sctp) throws BizException {
		if (null == appDTO) {
			return resDTO;
		}
		// 1、 检查预约申请单状态是否作废
		this.checkScAptApplStatus(appDTO);
		OralAptEP aptEP = new OralAptEP();

		// 1、检查同一患者同一号源同一日期同一午别是否存在预约
		// new AptCheckBP().exec(appDTO.getId_pat(), resDTO.getId_sch());

		if (StringUtil.isEmptyWithTrim(appDTO.getId_pat())) {
			throw new BizException("预约患者为空，请检查！");
		}

		// 渠道期间检查
		new AptCheckChlPeriodBP().exec(resDTO.getId_scchl(), resDTO.getId_sch(), sd_sctp);

		// 2、查询排班计划
		ScPlanDO planDO = aptEP.getScPlan(resDTO.getId_scpl());

		// 3、检查申请单记账状态
		if ((IScDictCodeConst.SD_SCTP_MT.equals(sd_sctp) || IScDictCodeConst.SD_SCTP_OT.equals(sd_sctp)) && ScParamUtils.getScAptMtChkFee(appDTO.getId_dep_mp())) {
			this.checkMtAppFeeStatus(appDTO,sd_sctp);
		}

		// 4、检查预约申请单(有申请单)
		if (!StringUtil.isEmptyWithTrim(appDTO.getId_or())) {
			this.checkApp(appDTO, sd_sctp);
		}

		// 5、查询排班信息
		ScSchDO schDO = aptEP.getSch(resDTO.getId_sch());

		// 6、查询渠道信息
		ScSchChlDO chlDO = aptEP.getSchChl(resDTO.getId_sch(), resDTO.getId_scchl());

		// 7、校验排班数据
		this.checkSchInfo(planDO, schDO, chlDO);
		// 根据科室参数SC0030 判断是否需要校验排班服务
		if(ScParamUtils.getscAptCOI(appDTO.getId_dep_mp()).booleanValue()){
			new ValSchSrvBP().exec(appDTO.getId_srv(),resDTO.getId_sch(),planDO);
		}
		// 8、获取号位信息
		resDTO.setScpolcn(chlDO.getScpolcn());
		ScSchTickDO tickDO = this.getSchTick(planDO, resDTO, appDTO, resDTO.getId_scchl(),sd_sctp);

		// 9、医技服务互斥检查
		if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_MT)) {
			this.checkSrvMutex(appDTO.getId_pat(), appDTO.getId_srv(), new FDateTime(schDO.getD_sch(), tickDO.getT_b()));
		}

		// 10、保存预约信息
		ScaptAggDO aptAggDO = new GetAptAggBp().exec(planDO, schDO, tickDO, appDTO.getId_pat(), chlDO.getId_scchl(),FBoolean.FALSE);
		
		// 11、保存预约申请
		ScAptApplDO aptApplDO = new ScAptApplDO();
		if(!EuAptmd.MANUAL.toString().equals(appDTO.getSd_aptmd()))//手工录入申请单  不保存和更新数据
		{
			if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_OT)) {
				//手术有申请单,不需要保存申请单
				aptApplDO = this.saveOTApplDO(schDO, planDO, appDTO, sd_sctp);
			}
			else
			{
				aptApplDO = this.saveAptAppl(schDO, planDO, appDTO, sd_sctp);
			}
			// 12、非住院、门诊、医技、手术预约需保存其他预约扩展表
			this.saveOthApt(aptAggDO, aptApplDO, sd_sctp);
		}
		else
		{
			IScaptapplMDORService service = ServiceFinder.find(IScaptapplMDORService.class);
			aptApplDO = service.findById(appDTO.getId_apt_appl());
		}
		
		

		// 13、保存医技预约信息
		if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_MT)) {
			aptAggDO = this.saveMtApt(aptAggDO, resDTO, appDTO, aptApplDO,planDO);
		} else {
			aptAggDO = this.saveOptApt(aptAggDO, aptApplDO, planDO);
		}

		// 14、回写预约申请
		this.rewriteScAptAppl(aptAggDO, aptApplDO);
		if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_OT)) {
			//手术预约发送集成平台消息BS009
			this.sendOptIeMsg(aptAggDO);
		}
		// 15、更新医嘱申请单状态
		if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_MT)) {
			// 回写医嘱医技申请单
			new MtAptCiObsOperateBP().rewriteObsStatus(appDTO.getId_or(), Boolean.TRUE,aptAggDO.getParentDO().getDt_appt());
		} else {
			// 回写医嘱手术申请单
			if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_OT)) {
				if (!StringUtil.isEmptyWithTrim(appDTO.getId_or())) {
					new OptAptCiObsOperateBP().rewriteAptSuccess(appDTO.getId_or(), new FDateTime(schDO.getD_sch(), tickDO.getT_b()));
				}
			}
		}
		
		// 16、 回写医嘱闭环状态
		if(!EuAptmd.MANUAL.toString().equals(appDTO.getSd_aptmd()))//手工录入申请单  不走闭环
		{
			this.rewriteOrClosedLoopState(appDTO, sd_sctp);
		}
		
		// 17、返回最新的数据
		MtResDTO mtRes = new GetMtResBP().exec(resDTO.getId_dep(), resDTO.getId_sch(), resDTO.getId_scchl(),FBoolean.FALSE,null);
		mtRes.setId_apt(aptAggDO.getParentDO().getId_apt());
		return mtRes;
	}

	/**
	 * 回写医嘱闭环状态
	 * @param appDTO
	 * @param sd_sctp
	 * @throws BizException
	 */
	private void rewriteOrClosedLoopState(MtAppDTO appDTO,String sd_sctp) throws BizException{
			if(appDTO.getOr_closed_flag()==null || appDTO.getOr_closed_flag().booleanValue())
			{
				String fun_code = "";
				if(sd_sctp.equals(IScDictCodeConst.SD_SCTP_MT))
				{
					// 43401110=医技预约(中心预约) 功能节点编码
					fun_code =  "43402610";
				}
				else if(sd_sctp.equals(IScDictCodeConst.SD_SCTP_OT))
				{
					//43402640=手术预约(手术室) 功能节点编码
					fun_code = "43402640";
				}
				if(!StringUtil.isEmpty(fun_code))
				{
					RewriteOrClosedLoopState.exec(appDTO.getId_or(), appDTO.getDt_effe_or(), fun_code, 0);
				}
			}
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
	private ScSchTickDO getSchTick(ScPlanDO planDO, MtResDTO resDTO, MtAppDTO appDTO, String id_scchl,String sd_sctp)
			throws BizException {
		ScSchTickDO tickDO = null;
		IScSchOutCmdService outQryService = ServiceFinder.find(IScSchOutCmdService.class);
		String sd_tickmd = resDTO.getSd_tickmd();// 票号模式
		// 读取系统参数医技预约检查项目类型
		FBoolean isSrvCheck = ScParamUtils.getscAptCOI(planDO.getId_dep());
		// 自录入申请单不作检查（无医疗服务）
		if (StringUtil.isEmptyWithTrim(appDTO.getId_or())) {
			isSrvCheck = FBoolean.FALSE;
		}
		if (IScDictCodeConst.SD_TICKMD_TICK.equals(sd_tickmd)) {// 号位模式
			if (isSrvCheck.booleanValue() && !sd_sctp.equals(IScDictCodeConst.SD_SCTP_OT)) {// 检查
				if (StringUtil.isEmptyWithTrim(resDTO.getId_ticks())) {// 快捷预约
					tickDO = outQryService.occupyChlTickBySchAndSrv(resDTO.getId_sch(), resDTO.getScpolcn(), null,
							appDTO.getId_srv(), id_scchl);
				} else {// 选号预约
					// 检查号位渠道
					new CheckAptTickChannelBP().exec(sd_tickmd, resDTO.getId_ticks(), id_scchl, appDTO.getId_srv());
					// 占用号位
					tickDO = outQryService.occupyChlTickBySrv(resDTO.getId_ticks(), resDTO.getScpolcn(),
							appDTO.getId_srv(), id_scchl);
				}
			} else {// 不检查
				if (StringUtil.isEmptyWithTrim(resDTO.getId_ticks())) {// 快捷预约
					tickDO = outQryService.occupyChlTickBySch(resDTO.getId_sch(), resDTO.getScpolcn(), null, id_scchl);
				} else {// 选号预约
					// 检查号位渠道
					new CheckAptTickChannelBP().exec(sd_tickmd, resDTO.getId_ticks(), id_scchl, null);
					// 占用号位
					tickDO = outQryService.occupyChlTick(resDTO.getId_ticks(), resDTO.getScpolcn(), id_scchl);
				}
			}
		} else if (IScDictCodeConst.SD_TICKMD_TICKS.equals(sd_tickmd)) {// 号段模式
			if (isSrvCheck.booleanValue()&& !sd_sctp.equals(IScDictCodeConst.SD_SCTP_OT)) {// 检查
				// 检查号段号位渠道
				if (!StringUtil.isEmptyWithTrim(resDTO.getId_ticks())) {
					new CheckAptTickChannelBP().exec(sd_tickmd, resDTO.getId_ticks(), id_scchl, appDTO.getId_srv());
				}
				// 占用号段号位
				tickDO = outQryService.occupyChlTickBySchAndSrv(resDTO.getId_sch(), resDTO.getScpolcn(),
						resDTO.getId_ticks(), appDTO.getId_srv(), id_scchl);
			} else {// 不检查
				// 检查号段号位渠道
				if (!StringUtil.isEmptyWithTrim(resDTO.getId_ticks())) {
					new CheckAptTickChannelBP().exec(sd_tickmd, resDTO.getId_ticks(), id_scchl, null);
				}
				// 占用号段号位
				tickDO = outQryService.occupyChlTickBySch(resDTO.getId_sch(), resDTO.getScpolcn(),
						resDTO.getId_ticks(), id_scchl);
			}
		} else if(IScDictCodeConst.SD_TICKMD_TIME.equals(sd_tickmd)) {//时间片模式
			if(isSrvCheck.booleanValue()){
				
			}
			if(resDTO.getFlist_seltime()==null)
				throw new BizException("时间片模式下选择的时间段不能为空！");
			tickDO = outQryService.occupyChlTickByAchAndTime(resDTO.getId_sch(), (SchTickMdTimeDTO)resDTO.getFlist_seltime().get(0), id_scchl);
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
	private ScaptAggDO saveMtApt(ScaptAggDO aptAggDO, MtResDTO resDTO, MtAppDTO appDTO, ScAptApplDO applDO,ScPlanDO planDO)
			throws BizException {
		ScAptMtDO mtAptDO = new ScAptMtDO();
		mtAptDO.setStatus(DOStatus.NEW);
		mtAptDO.setId_grp(ScContextUtils.getGrpId()); // 预约集团
		mtAptDO.setId_org(ScContextUtils.getOrgId()); // 预约机构
		mtAptDO.setFg_arrive(FBoolean.FALSE); // 医技辅签到标志
		mtAptDO.setId_dep_mp(resDTO.getId_dep()); // 执行部门
		mtAptDO.setId_mt(resDTO.getId_mt()); // 资源医技辅id
		mtAptDO.setFg_needcfm(GetScSrvDOBySccaAndSrv(applDO.getId_scca(),appDTO.getId_srv()));//是否需要确认
		mtAptDO.setId_aptappl(applDO.getId_aptappl());// 预约申请ID
		aptAggDO.setScAptMtDO(new ScAptMtDO[] { mtAptDO });
		// 保存
		aptAggDO = new AptEP().save(new ScaptAggDO[] { aptAggDO })[0];
		// 触发检查预约信息事件
		MtApt4EsDTO apt4EsDTO = new MtApt4EsDTO();
		apt4EsDTO.setId_apt(aptAggDO.getParentDO().getId_apt());
		new MakeMtAptEvent().invoke(apt4EsDTO);
		return aptAggDO;
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
		optDO.setId_or(applDO.getId_or());
		aptAggDO.setScAptOptDO(new ScAptOptDO[] { optDO });
		// 保存
		aptAggDO = new AptEP().save(new ScaptAggDO[] { aptAggDO })[0];
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
		applDO.setId_srv(appDTO.getId_srv());
		applDO.setStatus(DOStatus.NEW);
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
		applDO.setId_dep_mp(appDTO.getId_dep_mp());
		applDO.setDt_effe_or(appDTO.getDt_effe_or());
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
	private void checkSchInfo(ScPlanDO planDO, ScSchDO schDO, ScSchChlDO chlDO) throws BizException {
		if (null == planDO) {
			throw new BizException(IScMsgConst.SC_APT_NOT_FIND_PLAN);
		}
		if (null == schDO) {
			throw new BizException(IScMsgConst.SC_APT_NOT_FIND_SCH);
		} else if (!schDO.getFg_active().booleanValue()) {
			throw new BizException(IScMsgConst.SC_APT_SCH_UNACTIVE);
		}
		if (null == chlDO) {
			throw new BizException(IScMsgConst.SC_APT_NOT_FIND_CHL);
		}
	}

	/**
	 * 医技服务互斥检查
	 *
	 * @param id_pat
	 * @param id_srv
	 * @param aptTime
	 * @throws BizException
	 * @author zhengcm
	 * @author liubin
	 */
	private void checkSrvMutex(String id_pat, String id_srv, FDateTime aptTime) throws BizException {
		// 检查患者是否存在有效期内的互斥项目
		IScSchOutQryService schOutQryService = ServiceFinder.find(IScSchOutQryService.class);
		schOutQryService.mutexCheck4MtApt(id_pat, id_srv, aptTime);
	}

	/**
	 * 检查申请单计费状态
	 * @param appDTO
	 * @throws BizException
	 */
	private void checkMtAppFeeStatus(MtAppDTO appDTO,String sd_sctp) throws BizException{
		// 住院不检查申请单计费状态
		if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(appDTO.getSd_enttp()) || IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(appDTO.getId_enttp())) {
			return;
		}
		ScAptApplDO[] aptApplDOs = ServiceFinder.find(IScaptapplMDORService.class).find(" id_aptappl='"+appDTO.getId_apt_appl()+"' and fg_canc='N' ", null, FBoolean.FALSE);
		if(!ArrayUtil.isEmpty(aptApplDOs)){
			ScAptApplDO scaptappldo = aptApplDOs[0];
			if(IScDictCodeConst.SD_SCTP_MT.equals(sd_sctp)){
				if (!scaptappldo.getFg_bl().booleanValue() && !appDTO.getFg_needcfm().booleanValue()) {
					throw new BizException(String.format(IScMsgConst.SC_APT_MT_NOT_SUIT_FEE_STATUS, IScMsgConst.SC_APT_MT_NOT_FEE,IScMsgConst.SC_APT_MT_NOT_NEED_CFM));
		}
		}
			if(IScDictCodeConst.SD_SCTP_OT.equals(sd_sctp)){
				if (!scaptappldo.getFg_bl().booleanValue()) {
					throw new BizException(String.format(IScMsgConst.SC_APT_OT_NOT_SUIT_FEE_STATUS, IScMsgConst.SC_APT_MT_NOT_FEE));
		}
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
		// 检查手术申请单是否已预约
		if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_OT)) {
			StringBuilder sql = new StringBuilder();
			sql.append(" select apt.id_apt,");
			sql.append(" apt.fg_canc as fg_apt_canc,");
			sql.append(" appl.fg_canc as fg_appl_canc");
			sql.append(" from sc_apt_appl appl");
			sql.append(" left join sc_apt apt on appl.id_scapt = apt.id_apt");
			sql.append(" where 1 = 1 ");
			sql.append(" and appl.id_aptappl = ? ");
			SqlParam params = new SqlParam();
			params.addParam(appDTO.getId_apt_appl());
			List<OtAppDTO> list = (List<OtAppDTO>) new DAFacade().execQuery(sql.toString(), params,
					new BeanListHandler(OtAppDTO.class));
			if(list == null || list.size() == 0)
			{
				return;
			}
			if(list.get(0).getFg_appl_canc() == FBoolean.TRUE)
			{
				throw new BizException("申请单已取消，不能预约，请刷新后重试！");
			}
			if(!StringUtil.isEmptyWithTrim(list.get(0).getId_apt()) && list.get(0).getFg_apt_canc() == FBoolean.FALSE)
			{
				throw new BizException("该申请单已预约，不能重复预约，请刷新后重试！");
			}
		}
	}
	
	/**
	 * 查询申请单
	 * @return
	 * @throws BizException
	 */
	private ScAptApplDO saveOTApplDO(ScSchDO schDO, ScPlanDO planDO, MtAppDTO appDTO, String sd_sctp) throws BizException
	{
		IScaptapplMDORService service = ServiceFinder.find(IScaptapplMDORService.class);
		ScAptApplDO[] applDOs = service.find(" id_or = '"+appDTO.getId_or()+"' ", "", FBoolean.FALSE);
		if(applDOs == null || applDOs.length == 0)
		{
			ScAptApplDO applDO =  this.saveAptAppl(schDO, planDO, appDTO, sd_sctp);
			if(!StringUtil.isEmpty(appDTO.getId_or()))
			{
				ICiorappsurgeryMDORService ordService = ServiceFinder.find(ICiorappsurgeryMDORService.class);
				OrdApOpDO[] ordApOpDO = ordService.find(String.format(" id_or = '%s' ",appDTO.getId_or()), "", FBoolean.FALSE);
				if(ordApOpDO.length == 0)
				{
					throw new BizException("未在医嘱表找到麻醉方式!");
				}
				else
				{
					IScAptApplOptDOCudService cudService = ServiceFinder.find(IScAptApplOptDOCudService.class);
					ScAptApplOptDO optDO = new ScAptApplOptDO();
					optDO.setStatus(DOStatus.NEW);
					optDO.setId_aptappl(applDO.getId_aptappl());
					optDO.setId_anestp(ordApOpDO[0].getId_anestp());//麻醉方式
					optDO.setSd_anestp(ordApOpDO[0].getSd_anestp());
					optDO.setSpecialreq(ordApOpDO[0].getSpecialreq());//特殊用物
					optDO.setSpecialinstrument(ordApOpDO[0].getSpecialinstrument());//特殊仪器
					optDO.setSpecialdes(ordApOpDO[0].getSpecialdes());//特殊准备
					cudService.save(new ScAptApplOptDO[]{optDO});
				}
			}
			return applDO;
		}
		applDOs[0].setStatus(DOStatus.UPDATED);
		applDOs[0].setId_scsrv(planDO.getId_scsrv());
		applDOs[0].setId_scres(planDO.getId_scres());
		applDOs[0].setId_scca(planDO.getId_scca());
		MtAptEP mtAptEP = new MtAptEP();
		return mtAptEP.saveAptAppl(new ScAptApplDO[] { applDOs[0] })[0];
	}
	
	/**
	 * 发送手术预约IE信息
	 * @param aptAggDO
	 * @throws BizException
	 */
	private void sendOptIeMsg(ScaptAggDO aptAggDO) throws BizException{
		// 触发手术预约信息事件
		OptApt4OrmDTO optapt4ormdto = new OptApt4OrmDTO();
		optapt4ormdto.setId_apt(aptAggDO.getParentDO().getId_apt());
		List<OptApt4OrmDTO> list = new ArrayList<OptApt4OrmDTO>();
		list.add(optapt4ormdto);
		new MakeOptAptEvent().invoke(list);
	}
	
	/**
	 * 检查医技预约申请单状态是否正常
	 * @param appDTO
	 * @throws BizException 
	 */
	private void checkScAptApplStatus(MtAppDTO appDTO) throws BizException{
		ScAptApplDO[] aptApplDOs = ServiceFinder.find(IScaptapplMDORService.class).find(" id_aptappl='"+appDTO.getId_apt_appl()+"' and fg_canc='N' ", null, FBoolean.FALSE);
		if(ArrayUtil.isEmpty(aptApplDOs)){
			throw new BizException("未找到符合要求的预约申请单信息！");
		}
	}
}
