package iih.sc.apt.s.bp.op;

import java.util.HashMap;
import java.util.Map;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.pv.dto.d.ResultDTO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.outpatient.dto.d.RegRuleDTO;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.dto.d.OpApt4EsDTO;
import iih.sc.apt.dto.d.ScAptRuleParamDTO;
import iih.sc.apt.s.bp.AptCheckChlPeriodBP;
import iih.sc.apt.s.bp.CheckAptTickChannelBP;
import iih.sc.apt.s.bp.GetAptAggBp;
import iih.sc.apt.s.bp.op.qry.GetOpResInfoBP;
import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.apt.s.event.OpAptEvent;
import iih.sc.apt.s.rule.CheckRuleResultPro;
import iih.sc.apt.scapt.d.ScAptOpDO;
import iih.sc.apt.scapt.d.ScaptAggDO;
import iih.sc.apt.scapt.i.IScaptCudService;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.IScRuleConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScParamUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.scheduleres.d.ScheduleResDO;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvDO;
import iih.sc.sch.i.IScSchOutCmdService;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.scp.scplan.d.ScPlanDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存门诊预约信息(预约)BP
 * 
 * @author zhengcm
 * @created by renying
 */
public class SaveOpAptBP {

	/**
	 * 保存门诊预约信息(预约)
	 * 
	 * @param resDTO
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	public MtResDTO exec(MtResDTO resDTO, String patId, String operate_source) throws BizException {
		// 1、检查参数
		ScValidator.validateParam("patId", patId);
		if (resDTO == null) {
			return resDTO;
		}

		OralAptEP aptEP = new OralAptEP();

		// 检查同一患者同一号源同一日期同一午别是否存在预约
		// new AptCheckBP().exec(patId, resDTO.getId_sch());

		// 渠道期间检查
		new AptCheckChlPeriodBP().exec(resDTO.getId_scchl(), resDTO.getId_sch(), IScDictCodeConst.SD_SCTP_OP);

		// 2、查询排班计划
		ScPlanDO planDO = aptEP.getScPlan(resDTO.getId_scpl());

		// 3、查询排班信息
		ScSchDO schDO = aptEP.getSch(resDTO.getId_sch());

		// 4、查询渠道信息
		ScSchChlDO chlDO = aptEP.getSchChl(resDTO.getId_sch(), resDTO.getId_scchl());

		// 5、查询排班服务
		ScheduleSrvDO scsrvDO = aptEP.getScSrvById(resDTO.getId_scsrv());

		// 6、查询排班资源
		ScheduleResDO resDO = aptEP.getScRes(resDTO.getId_res());

		// 7、校验排班数据
		this.checkSchInfo(planDO, schDO, chlDO, scsrvDO);

		// 8、校验挂号规则
		this.validateRegRule(patId, resDTO.getId_sch(), planDO.getId_scres(), planDO.getId_dep(), resDTO.getD_sch(),
				resDTO.getId_scsrv(), resDTO.getId_dayslot(), chlDO.getCode_scchl());

		// 9、获取号位信息
		ScSchTickDO tickDO = this.getSchTick(resDTO);

		// 10、保存预约信息
		ScaptAggDO aptAggDO = new GetAptAggBp().exec(planDO, schDO, tickDO, patId, chlDO.getId_scchl(),FBoolean.FALSE);

		// 11、保存门诊预约信息
		this.saveOpApt(aptAggDO, resDTO, planDO, resDO, scsrvDO);

		// 12、返回最新数据
		MtResDTO resultDTO = new GetOpResInfoBP().exec(resDTO.getId_dep(), resDTO.getId_sch(), resDTO.getId_scchl());
		resultDTO.setId_apt(resDTO.getId_apt());

		// 13、触发门诊预约事件 changed by zhengcm 2018-01-29 增加参数控制
		this.invokeOpAptEvent(resultDTO, patId, planDO, operate_source);

		return resultDTO;
	}

	/**
	 * 获取排班号位
	 *
	 * @param resDTO
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private ScSchTickDO getSchTick(MtResDTO resDTO) throws BizException {
		IScSchOutCmdService outQryService = ServiceFinder.find(IScSchOutCmdService.class);
		ScSchTickDO tickDO = null;
		if (StringUtil.isEmptyWithTrim(resDTO.getId_ticks())) {
			return outQryService
					.occupyChlTickBySch(resDTO.getId_sch(), resDTO.getScpolcn(), null, resDTO.getId_scchl());
		}
		String sd_tickmd = resDTO.getSd_tickmd();// 票号模式
		if (sd_tickmd.equals(IScDictCodeConst.SD_TICKMD_TICK)) {// 号位
			// 检查号位渠道
			new CheckAptTickChannelBP().exec(sd_tickmd, resDTO.getId_ticks(), resDTO.getId_scchl(), null);
			// 占用号位
			tickDO = outQryService.occupyChlTick(resDTO.getId_ticks(), resDTO.getScpolcn(), resDTO.getId_scchl());
		} else if (sd_tickmd.equals(IScDictCodeConst.SD_TICKMD_TICKS)) {// 号段
			// 检查号段号位渠道
			new CheckAptTickChannelBP().exec(sd_tickmd, resDTO.getId_ticks(), resDTO.getId_scchl(), null);
			// 占用号段号位
			tickDO = outQryService.occupyChlTickBySch(resDTO.getId_sch(), resDTO.getScpolcn(), resDTO.getId_ticks(),
					resDTO.getId_scchl());
		}
		return tickDO;
	}

	/**
	 * 保存门诊预约
	 *
	 * @param aptAggDO
	 * @param resDTO
	 * @param planDO
	 * @param resDO
	 * @param scsrvDO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void saveOpApt(ScaptAggDO aptAggDO, MtResDTO resDTO, ScPlanDO planDO, ScheduleResDO resDO,
			ScheduleSrvDO scsrvDO) throws BizException {
		ScAptOpDO opAptDO = new ScAptOpDO();
		opAptDO.setStatus(DOStatus.NEW);
		opAptDO.setId_dep(planDO.getId_dep());// 计划科室
		opAptDO.setId_dep_belong(resDO.getId_dep());// 资源归属部门
		if (!StringUtil.isEmpty(resDO.getId_emp())) {
			// 如果资源为专家号时 插入医生
			opAptDO.setId_emp(resDO.getId_emp());
		}
		opAptDO.setId_grp(ScContextUtils.getGrpId());
		opAptDO.setId_org(ScContextUtils.getOrgId());
		opAptDO.setSd_apptmd_op(IScDictCodeConst.SD_APPTMD_OP_NORMAL);// 门诊预约方式编码
		opAptDO.setId_apptmd_op(IScDictCodeConst.ID_APPTMD_OP_NORMAL);
		opAptDO.setSd_srvtp(scsrvDO.getSd_srvtp()); // 医疗服务类型编码
		opAptDO.setId_srvtp(scsrvDO.getId_srvtp());

		aptAggDO.setScAptOpDO(new ScAptOpDO[] { opAptDO });
		// 保存
		IScaptCudService cudSrv = ServiceFinder.find(IScaptCudService.class);
		aptAggDO = cudSrv.save(new ScaptAggDO[] { aptAggDO })[0];
		resDTO.setId_apt(aptAggDO.getParentDO().getId_apt());
	}

	/**
	 * 校验数据
	 *
	 * @param planDO
	 * @param schDO
	 * @param chlDO
	 * @param scsrvDO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void checkSchInfo(ScPlanDO planDO, ScSchDO schDO, ScSchChlDO chlDO, ScheduleSrvDO scsrvDO)
			throws BizException {
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
		if (null == scsrvDO) {
			throw new BizException(IScMsgConst.SC_APT_PLAN_SCSRV_EXISTS);
		}
	}

	/**
	 * 校验挂号规则
	 *
	 * @param id_pat
	 * @param id_sch
	 * @param id_scres
	 * @param id_dep
	 * @param d_sch
	 * @param id_scsrv
	 * @param id_dayslot
	 * @param code_scchl
	 * @throws BizException
	 * @author zhengcm
	 */
	private void validateRegRule(String id_pat, String id_sch, String id_scres, String id_dep, FDate d_sch,
			String id_scsrv, String id_dayslot, String code_scchl) throws BizException {
		ScAptRuleParamDTO aptParam = new ScAptRuleParamDTO();
		aptParam.setId_pat(id_pat);
		aptParam.setId_sch(id_sch);
		aptParam.setId_dayslot(id_dayslot);
		aptParam.setId_scres(id_scres);
		aptParam.setId_scsrv(id_scsrv);
		aptParam.setId_dep(id_dep);
		aptParam.setD_sch(d_sch);
		aptParam.setCode_scchl(code_scchl);
		aptParam.setDt_now(ScAppUtils.getServerDateTime());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(ScAptRuleParamDTO.class.getSimpleName(), aptParam);
		//调用预约规则
		ResultDTO resultDTO = CheckRuleResultPro.checkDealResult(IScRuleConst.SC_OP_APT_RULE, map);
		if (FBoolean.FALSE.equals(resultDTO.getFlag())) {
			throw new BizException(resultDTO.getMsg());
		}
		
		RegRuleDTO regRule = new RegRuleDTO();
		regRule.setId_pat(id_pat);
		regRule.setId_sch(id_sch);
		regRule.setId_scres(id_scres);
		regRule.setId_dept(id_dep);
		regRule.setRegdate(d_sch.toStdString());
		regRule.setId_scsrv(id_scsrv);
		regRule.setId_dayslot(id_dayslot);
		regRule.setCode_scchl(code_scchl);
		IEnOutQryService enOutQryService = ServiceFinder.find(IEnOutQryService.class);
		resultDTO = enOutQryService.isPermitRegByMvel(regRule);
		if (FBoolean.FALSE.equals(resultDTO.getFlag())) {
			throw new BizException(resultDTO.getMsg());
		}
	}

	/**
	 * 触发门诊预约事件
	 *
	 * @param resultDTO
	 * @param patId
	 * @throws BizException
	 * @author zhengcm
	 */
	private void invokeOpAptEvent(MtResDTO resultDTO, String patId, ScPlanDO planDO, String operate_source) throws BizException {
		// 触发门诊预约发送短信事件
		OpApt4EsDTO apt4EsDTO = new OpApt4EsDTO();
		apt4EsDTO.setId_apt(resultDTO.getId_apt());
		apt4EsDTO.setId_pat(patId);
		apt4EsDTO.setId_sch(resultDTO.getId_sch());
		apt4EsDTO.setId_dep_pl(planDO.getId_dep());
		if(!IScDictCodeConst.SC_CHANGE_APT_OPERATE.equals(operate_source)){
			apt4EsDTO.setOperate_source(IScDictCodeConst.SC_APT_OPERATE);
		}else{
			apt4EsDTO.setOperate_source(operate_source);
		}
		new OpAptEvent().invoke(apt4EsDTO);
	}

}
