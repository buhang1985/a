package iih.sc.apt.s.bp.mt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.dbutils.handlers.BeanHandler;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.pat.d.PatDO;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.dto.d.MtApt4EsDTO;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.i.IScAptQryService;
import iih.sc.apt.s.bp.GetAptAggBp;
import iih.sc.apt.s.bp.mt.apt.AptCheckChlPeriodManualBP;
import iih.sc.apt.s.bp.mt.apt.CheckAptTickChannelNewBP;
import iih.sc.apt.s.bp.mt.apt.validate.ValSchSrvBP;
import iih.sc.apt.s.bp.opt.OptAptCiObsOperateBP;
import iih.sc.apt.s.ep.AptEP;
import iih.sc.apt.s.ep.MtAptEP;
import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.apt.s.event.MakeMtAptEvent;
import iih.sc.apt.scapt.d.AptOthDO;
import iih.sc.apt.scapt.d.ScAptMtDO;
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
import iih.sc.scbd.bdsrv.d.ScBdsrvDO;
import iih.sc.scbd.bdsrv.i.IScbdsrvMDORService;
import iih.sc.sch.dto.d.SchTickMdTimeDTO;
import iih.sc.sch.i.IScSchOutCmdService;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
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

public class SaveMtAptPubBP {

	/**
	 * 医技预约 (与第三方调用共同方法)
	 * @param mtresdto
	 * @param appdto
	 * @param fg_out 第三方标识
	 * @return
	 * @throws BizException
	 */
	public FMap exec(MtResDTO resDTO, MtAppDTO appDTO, String sd_sctp, FBoolean fg_out) throws BizException
	{
		FMap result = new FMap();
		OralAptEP aptEP = new OralAptEP();
		// 1、 检查预约申请单状态是否作废
		this.checkScAptApplStatus(appDTO);
		// 渠道期间检查
		new AptCheckChlPeriodManualBP().exec(resDTO.getId_scchl(), resDTO.getId_sch(),sd_sctp);
		
		// 3、检查申请单记账状态
		if (FBoolean.FALSE == fg_out && ScParamUtils.getScAptMtChkFee(appDTO.getId_dep_mp())) {
			this.checkMtAppFeeStatus(appDTO);
		}

		// 4、检查预约申请单(有申请单)
		if (!StringUtil.isEmptyWithTrim(appDTO.getId_or())) {
			this.checkApp(appDTO, sd_sctp);
		}
				
		//FIXME 自动预约从这里就要开始根据渠道查询所有排班信息 然后按照过滤出来的互斥服务日期筛选排班选出排班后根据排班选号位
				
		// 5、查询排班信息
		ScSchDO schDO = aptEP.getSch(resDTO.getId_sch());
				
		// 2、查询排班计划
		ScPlanDO planDO = aptEP.getScPlan(schDO.getId_scpl());

		// 6、查询渠道信息
		ScSchChlDO[] chlDOs = aptEP.getSchChlByCond(String.format("id_sch = '%s' and id_scchl = '%s'", resDTO.getId_sch(), resDTO.getId_scchl()),null,appDTO.getId_enttp(),schDO.getFg_setentp(),appDTO.getCode_scchl(),schDO);

		// 7、校验排班数据
		if(chlDOs == null || chlDOs.length == 0)
		{
			throw new BizException(IScMsgConst.SC_APT_NOT_FIND_CHL);
		}
		this.checkSchInfo(planDO, schDO, chlDOs[0]);
		// 根据科室参数SC0030 判断是否需要校验排班服务
		if(ScParamUtils.getscAptCOI(appDTO.getId_dep_mp()).booleanValue()){
			new ValSchSrvBP().exec(appDTO.getId_srv(),resDTO.getId_sch(),planDO);
		}
				 
		// 8、医技服务互斥检查
		ScSchTickDO tickDO = null;
		if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_MT)) {
			this.checkSrvMutex(appDTO.getId_pat(), appDTO.getId_srv(),appDTO.getId_ent(), ScAppUtils.getServerDateTime(),resDTO,schDO.getD_sch(),appDTO.getFg_hp());
			// 医技服务互斥数据去重
			this.duplicateExclDate(resDTO);
			tickDO = this.getSchTick(planDO, resDTO, appDTO, resDTO.getId_scchl(),chlDOs,schDO);
		}
		
		// 9、没有可用号位则返回校验结果
		if (tickDO == null) {
			//医技服务互斥数据去重
			this.duplicateExclDate(resDTO);
			result.put("isSuc", FBoolean.FALSE);
			result.put("result", resDTO);
			return result;
		}else{
			//医技服务互斥判断是否要提示
			this.duplicateExclDateTwo(resDTO);
		}
				
		// 10、保存预约信息
		ScaptAggDO aptAggDO = new GetAptAggBp().exec(planDO, schDO, tickDO, appDTO.getId_pat(), chlDOs[0].getId_scchl(),appDTO.getFg_mtapp_apt());
				
		// 11、保存预约申请
		ScAptApplDO[] aptApplDOs = ServiceFinder.find(IScaptapplMDORService.class).find(" id_aptappl='"+appDTO.getId_apt_appl()+"'", null, FBoolean.FALSE);
				
		ScAptApplDO aptApplDO = null;
		if(ArrayUtil.isEmpty(aptApplDOs)){
			aptApplDO = this.saveAptAppl(schDO, planDO, appDTO, sd_sctp);
		}else{
			aptApplDO = this.saveAptAppl(aptAggDO.getParentDO().getId_apt() ,schDO, planDO, appDTO, sd_sctp,aptApplDOs[0]);
		}
				
		// 12、非住院、门诊、医技、手术预约需保存其他预约扩展表
		this.saveOthApt(aptAggDO, aptApplDO, sd_sctp);

		// 13、保存医技预约信息
		aptAggDO = this.saveMtApt(aptAggDO, resDTO, appDTO, aptApplDO,planDO,fg_out);
				
		// 14、回写预约申请
		this.rewriteScAptAppl(aptAggDO, aptApplDO);
		// 15、更新医嘱申请单状态
		if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_MT)) {
					// 回写医嘱医技申请单
			MtAptCiObsOperateBP mtAptCiObsOperateBP = new MtAptCiObsOperateBP();
			if (!FBoolean.TRUE.equals(aptApplDO.getFg_multor())){
				mtAptCiObsOperateBP.rewriteObsStatus(appDTO.getId_or(), Boolean.TRUE,aptAggDO.getParentDO().getDt_appt());
			} else {
				List<String> orList = this.getIdOrList(appDTO);
				if (orList != null){
					for(String id_or : orList){
						mtAptCiObsOperateBP.rewriteObsStatus(id_or, Boolean.TRUE,aptAggDO.getParentDO().getDt_appt());
					}
				}
			}
		} else {
					// 回写医嘱手术申请单
			if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_OT)) {
				if (!StringUtil.isEmptyWithTrim(appDTO.getId_or())) {
					new OptAptCiObsOperateBP().rewriteAptSuccess(appDTO.getId_or(), new FDateTime(schDO.getD_sch(), tickDO.getT_b()));
				}
			}
		}
		// 15、设置自动拍照、自动打印
		this.checkFgAutoCfm(resDTO, appDTO, aptAggDO);
		
		resDTO.setId_aptappl(aptApplDO.getId_aptappl());
		resDTO.setId_apt_mt(aptAggDO.getScAptMtDO()[0].getId_aptmt());
		resDTO.setId_apt(aptAggDO.getParentDO().getId_apt());
		resDTO.setQueno(tickDO.getQueno());
		resDTO.setId_ticks(tickDO.getId_tick());
		resDTO.setId_scca(planDO.getId_scca());
		resDTO.setApt_time(tickDO.getT_b());
		resDTO.setFg_needcfm(aptAggDO.getScAptMtDO()[0].getFg_needcfm());
		result.put("isSuc", FBoolean.TRUE);
		result.put("result", resDTO);
		return result;
	}
	/**
	 * 校验自动确认，设置自动拍照和自动打印
	 * @author yhl
	 * @throws BizException 
	 */
	private void checkFgAutoCfm(MtResDTO resDTO, MtAppDTO appDTO,ScaptAggDO aptAggDO) throws BizException{
		if(aptAggDO.getScAptMtDO()[0].getFg_needcfm().booleanValue()){
			Boolean chkFee = ScParamUtils.getScAptMtChkFee(appDTO.getId_dep_mp());// 检查费用参数
			if(appDTO.getFg_auto_cfm()!= null && appDTO.getFg_auto_cfm().booleanValue() && ((chkFee && appDTO.getFg_bl().booleanValue()) || !chkFee )){
				IScAptQryService qryService = ServiceFinder.find(IScAptQryService.class);
				MtResDTO res = qryService.getDepPrintAndPhoto(aptAggDO.getParentDO().getId_apt());
				resDTO.setFg_auto_pho(res.getFg_auto_pho());
				resDTO.setFg_auto_prn(res.getFg_auto_prn());
				resDTO.setFg_auto_prn_bar(res.getFg_auto_prn_bar());
			}
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
	 * 保存医技预约
	 *
	 * @author zhengcm
	 * 
	 * @param aptAggDO
	 * @param resDTO
	 * @param appDTO
	 * @param applDO
	 * @param fg_out 是否第三方
	 * @return
	 * @throws BizException
	 */
	private ScaptAggDO saveMtApt(ScaptAggDO aptAggDO, MtResDTO resDTO, MtAppDTO appDTO, ScAptApplDO applDO,ScPlanDO planDO,FBoolean fg_out)
			throws BizException {
		ScAptMtDO mtAptDO = new ScAptMtDO();
		mtAptDO.setFg_manu_tak(appDTO.getFg_manu_tak());
		mtAptDO.setStatus(DOStatus.NEW);
		mtAptDO.setId_grp(ScContextUtils.getGrpId()); // 预约集团
		mtAptDO.setId_org(ScContextUtils.getOrgId()); // 预约机构
		mtAptDO.setFg_arrive(FBoolean.FALSE); // 医技辅签到标志
		mtAptDO.setId_dep_mp(resDTO.getId_dep()); // 执行部门
		mtAptDO.setId_mt(resDTO.getId_mt()); // 资源医技辅id
		mtAptDO.setFg_needcfm(GetScSrvDOBySccaAndSrv(applDO.getId_scca(),appDTO.getId_srv()));//是否需要确认
		//如果该服务需要确认 且勾选了自动确认 则直接将该预约进行确认
		if (mtAptDO.getFg_needcfm().booleanValue()) {// 是否需要确认
			Boolean chkFee = ScParamUtils.getScAptMtChkFee(appDTO.getId_dep_mp());// 检查费用参数
			if (chkFee && !appDTO.getFg_bl().booleanValue()) {
				mtAptDO.setFg_aptcfm(FBoolean.FALSE);
			} else {
				mtAptDO.setFg_aptcfm(appDTO.getFg_auto_cfm() == null ? FBoolean.FALSE : appDTO.getFg_auto_cfm());
				if (mtAptDO.getFg_aptcfm().booleanValue()) {
					mtAptDO.setId_emp_cfm(ScContextUtils.getPsnId());
					mtAptDO.setDt_apt_cfm(ScAppUtils.getServerDateTime());
				}
			}
		}
		mtAptDO.setId_aptappl(applDO.getId_aptappl());// 预约申请ID
		mtAptDO.setNote(appDTO.getNote());//预约备注
		mtAptDO.setId_apt(aptAggDO.getParentDO().getId_apt());
		aptAggDO.setScAptMtDO(new ScAptMtDO[] { mtAptDO });
		// 保存
		aptAggDO = new AptEP().save(new ScaptAggDO[] { aptAggDO })[0];
		// 触发检查预约信息事件
		if(FBoolean.FALSE.equals(fg_out))
		{
			MtApt4EsDTO apt4EsDTO = new MtApt4EsDTO();
			apt4EsDTO.setId_apt(aptAggDO.getParentDO().getId_apt());
			new MakeMtAptEvent().invoke(apt4EsDTO);
		}
		return aptAggDO;
	}
	
	/**
	 * 根据排班分类，医疗项目 查询是否需要确认
	 * @param id_scca
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
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
	 * 设置是否要提示信息
	 * @param resDTO
	 */
	@SuppressWarnings("unchecked")
	private void duplicateExclDateTwo(MtResDTO resDTO){
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
			this.handleIsShowMsg(exclMustTemp, setData);
			resDTO.setDays_excl_must(exclMustTemp);
		}
		// 2.次数限制
		if (!ListUtil.isEmpty(exclTimes)) {
			FArrayList exclTimesTemp = new FArrayList();
			Set<FMap> setData = new HashSet<FMap>();
			setData.addAll(exclTimes);
			this.handleIsShowMsg(exclTimesTemp, setData);
			resDTO.setDays_excl_times(exclTimesTemp);
		}
		//3.并行禁止
		if(!ListUtil.isEmpty(togetherMust)){
			FArrayList togetherMustTemp = new FArrayList();
			Set<FMap> setData = new HashSet<FMap>();
			setData.addAll(togetherMust);
			this.handleIsShowMsg(togetherMustTemp, setData);
			resDTO.setDays_together_must(togetherMustTemp);
		}
		// 4.排斥提示
		if(!ListUtil.isEmpty(exclHint)){
			FArrayList exclHintTemp = new FArrayList();
			Set<FMap> setData = new HashSet<FMap>();
			setData.addAll(exclHint);
			this.handleIsShowMsg(exclHintTemp, setData);
			resDTO.setDays_excl_hint(exclHintTemp);
		}
		// 5.并行提示
		if(!ListUtil.isEmpty(togetherHint)){
			FArrayList togetherHintTemp = new FArrayList();
			Set<FMap> setData = new HashSet<FMap>();
			setData.addAll(togetherHint);
			this.handleIsShowMsg(togetherHintTemp, setData);
			resDTO.setDays_together_hint(togetherHintTemp);
		}
	}
	/**
	 * 过滤提示消息剔除不需要显示的消息
	 * @param list
	 * @param setData
	 */
	private void handleIsShowMsg(FArrayList list,Set<FMap> setData){
		for (FMap fMap : setData) {
			if(fMap.get("is_show") != null && fMap.get("is_show").toString().equals(FBoolean.TRUE.toString())){
				list.add(fMap);
			}
		}
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
			applDO.setId_entp(appDTO.getId_enttp());
			applDO.setCode_entp("00");
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
	@SuppressWarnings("unused")
	private ScAptApplDO saveAptAppl(String id_apt,ScSchDO schDO, ScPlanDO planDO, MtAppDTO appDTO, String sd_sctp,ScAptApplDO applDO)
			throws BizException {

		MtAptEP mtAptEP = new MtAptEP();
		// 就诊DO
		PatiVisitDO entDO = null;
		if (!StringUtil.isEmptyWithTrim(appDTO.getId_ent())) {
			entDO = mtAptEP.getEntById(appDTO.getId_ent());
		}
		// 患者DO
		PatDO patDO = mtAptEP.getPatById(appDTO.getId_pat());
		applDO.setStatus(DOStatus.UPDATED);
		applDO.setId_grp(planDO.getId_grp());
		applDO.setId_org(planDO.getId_org());
		applDO.setSd_sctp(sd_sctp);
		applDO.setId_scca(planDO.getId_scca());
		applDO.setPriority(0);
		applDO.setDt_appl(ScAppUtils.getServerDateTime());
		applDO.setFg_comfirm(FBoolean.FALSE);
		applDO.setFg_canc(FBoolean.FALSE);
		applDO.setId_scsrv(planDO.getId_scsrv());
		applDO.setId_scres(planDO.getId_scres());
		applDO.setId_scapt(id_apt);
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
		String sd_tickmd = resDTO.getSd_tickmd();// 票号模式
		// 单渠道对应号源池 改为 取出渠道对应的所有号源池进行计算
		List<String> schIdList = new ArrayList<String>();
		schIdList.add(resDTO.getId_sch());
		Map<String, Map<Integer,Integer>> polcnMap = ServiceFinder.find(IScSchOutQryService.class).batchGetChlSchRemainFilterEntpAmount(schIdList,appDTO.getId_enttp(), id_scchl);
		if (polcnMap == null) return null;
		Map<Integer,Integer> polcnNumMap = polcnMap.get(resDTO.getId_sch());
		
		if (IScDictCodeConst.SD_TICKMD_TICK.equals(sd_tickmd)) {// 号位模式
			if(IScDictCodeConst.SC_CHOICE_APT.equals(resDTO.getSc_oper_src())){// 选号预约
				// 检查号段号位渠道
				new CheckAptTickChannelNewBP().exec(sd_tickmd, resDTO.getId_ticks(), id_scchl, null,appDTO.getId_enttp(),polcnMap);
				// 占用号位
				tickDO = outQryService.occupyChlTick4Manual(resDTO.getId_ticks(), polcnNumMap, id_scchl,resDTO,appDTO.getId_srv());
			}else{// 快捷预约
				tickDO = outQryService.occupyChlTickBySch4Manual(resDTO.getId_sch(),polcnNumMap, null, id_scchl, appDTO.getId_enttp(), resDTO,appDTO.getId_srv());
			}
		}else if(IScDictCodeConst.SD_TICKMD_TICKS.equals(sd_tickmd)){// 号段模式
			if(IScDictCodeConst.SC_CHOICE_APT.equals(resDTO.getSc_oper_src())){// 选号预约
				// 检查号段号位渠道
				new CheckAptTickChannelNewBP().exec(sd_tickmd, resDTO.getId_ticks(), id_scchl, null,appDTO.getId_enttp(),polcnMap);
			}
			// 占用号段号位
			tickDO = outQryService.occupyChlTickBySch4Manual(resDTO.getId_sch(), polcnNumMap,resDTO.getId_ticks(), id_scchl,appDTO.getId_enttp(),resDTO,appDTO.getId_srv());
		}else if(IScDictCodeConst.SD_TICKMD_TIME.equals(sd_tickmd)){// 时间片模式
			if(IScDictCodeConst.SC_CHOICE_APT.equals(resDTO.getSc_oper_src())){//时间片选号模式				
				if(resDTO.getFlist_seltime()==null)
					throw new BizException("时间片模式下选择的时间段不能为空！");
				tickDO = outQryService.occupyChlTickByAchAndTime4Manual(resDTO.getId_sch(), (SchTickMdTimeDTO)resDTO.getFlist_seltime().get(0), id_scchl,appDTO.getId_enttp(),resDTO);
			}else{//时间片快捷预约
				tickDO = outQryService.OccupyChlTimeBySchQuick4Manual(planDO,appDTO,id_scchl,chlDOs,schDO,resDTO);
			}
		}
		return tickDO;
	}
	
	

	/**
	 * 医技服务互斥检查
	 *
	 * @param id_pat
	 * @param id_srv
	 * @param aptTime
	 * @param exclDateList 需要排斥掉的日期
	 * @param firstDateList 优先需要选择的日期
	 * @param d_sch 排班日期
	 * @param fg_hp 医保支付标识
	 * @throws BizException
	 * @author zhengcm
	 * @author liubin
	 */
	private void checkSrvMutex(String id_pat, String id_srv, String id_ent,FDateTime aptTime,MtResDTO resDTO,FDate d_sch,FBoolean fg_hp) throws BizException {
		// 检查患者是否存在有效期内的互斥项目
		IScSchOutQryService schOutQryService = ServiceFinder.find(IScSchOutQryService.class);
		schOutQryService.mutexCheck4ManualMtApt(id_pat, id_srv,id_ent, aptTime,resDTO,d_sch,fg_hp);
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
				throw new BizException(String.format(IScMsgConst.SC_APT_MT_NOT_SUIT_FEE_STATUS, IScMsgConst.SC_APT_MT_NOT_FEE,IScMsgConst.SC_APT_MT_NOT_NEED_CFM));
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
	 * 检查医嘱申请单是否是合单申请
	 *
	 * @param appDTO
	 * @throws BizException
	 * @author yu.b
	 */
	private Boolean getFgMultor(MtAppDTO appDTO) throws BizException {
		StringBuilder sql = new StringBuilder();
		SqlParam sqlParam = new SqlParam();
		sql.append("SELECT FG_MULTOR FROM SC_APT_APPL WHERE ID_OR = ? ");
		sqlParam.addParam(appDTO.getId_or());
		String fg_multor = (String) new DAFacade().execQuery(sql.toString(), sqlParam,
				new BeanHandler(String.class));
		return fg_multor == null ? false : Boolean.parseBoolean(fg_multor);
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
