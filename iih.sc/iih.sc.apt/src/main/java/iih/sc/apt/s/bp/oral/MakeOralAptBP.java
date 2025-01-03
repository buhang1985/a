package iih.sc.apt.s.bp.oral;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.en.pv.dto.d.ResultDTO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.outpatient.dto.d.RegRuleDTO;
import iih.sc.apt.dto.d.AptOralDTO;
import iih.sc.apt.dto.d.OpApt4EsDTO;
import iih.sc.apt.s.bp.AptCheckChlPeriodBP;
import iih.sc.apt.s.ep.AptEP;
import iih.sc.apt.s.ep.AptOpEP;
import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.apt.s.event.OpAptEvent;
import iih.sc.apt.scapt.d.AptOpOralDO;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.d.ScAptOpDO;
import iih.sc.apt.scapt.d.desc.ScAptDODesc;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScLogUtil;
import iih.sc.comm.ScParamUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.scheduleres.d.ScheduleResDO;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvDO;
import iih.sc.sch.i.IScSchOutCmdService;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.d.ScschAggDO;
import iih.sc.sch.sctick.d.EuUseScope;
import iih.sc.sch.sctick.d.EuUseState;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplan.i.IScplanRService;
import iih.sc.scp.scploptsrv.d.ScPlOptSrvDO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;

/**
 * 口腔科预约BP
 * 
 * @author zhengcm
 * @date 2016-09-28 16:29:22
 *
 */
public class MakeOralAptBP {

	/**
	 * 口腔科预约
	 *
	 * @param patId 患者ID
	 * @param oralAptDTO 口腔预约信息
	 * @param oralTickDTOs 预约号位集合
	 * @throws BizException
	 * @author zhengcm
	 */
	public AptOralDTO exec(String patId, AptOralDTO oralAptDTO) throws BizException {
		// 1、检查参数
		ScValidator.validateParam("patId", patId);
		if (null == oralAptDTO) {
			return null;
		}
		
		// 记录日志
		ScSchDO schDO = new OralAptEP().getSch(oralAptDTO.getId_sch());
		ScLogUtil.getInstance().logInfo("[预约前]口腔预约：(患者：" + patId + "),排班：" + schDO.toString());

		// 2、校验排班
		new CheckOralAptSchBP().check(oralAptDTO.getId_sch());

		// 3、检查是否需要触发预约事件
		boolean isInvoke = this.checkIsInvokeEvent(oralAptDTO);

		// 4、检查预约状态
		this.checkAptStatus(oralAptDTO);

		// 5、处理DTO状态
		this.processDTOStatus(oralAptDTO);

		// 6、取消已有预约
		this.cancApted(oralAptDTO);

		// 7、获取排班渠道
		ScSchChlDO chlDO = new OralAptEP().getSchChl(oralAptDTO.getId_sch(), oralAptDTO.getId_scchl());
		if (null == chlDO) {
			throw new BizException(IScMsgConst.SC_APT_ORAL_NOT_CHL);
		}
		// 检查排班渠道（非本科渠道不允许修改）
		if (!StringUtil.isEmptyWithTrim(oralAptDTO.getId_apt())
				&& !StringUtil.isEmptyWithTrim(oralAptDTO.getId_apt_old())) {
			new CheckOralChlBP().check(chlDO.getId_scchl());
		}

		// 8、排班计划
		ScPlanDO planDO = new OralAptEP().getScPlan(oralAptDTO.getId_scpl());
		// 校验排班服务 预约的号别与计划号别不一致 2018年11月3日 11:35:59 bug:137464 by yzh  
		this.checkScSrv(oralAptDTO.getId_scpl(),oralAptDTO.getId_scsrv(),planDO.getId_scsrv());
		// 9、校验挂号规则(新增时校验，修改时不校验)
		if (oralAptDTO.getStatus() == DOStatus.NEW) {
			this.validateRegRule(patId, oralAptDTO.getId_sch(), planDO.getId_scres(), planDO.getId_dep(),
					oralAptDTO.getD_sch(), planDO.getId_scsrv(), oralAptDTO.getId_dayslot(), chlDO.getCode_scchl());
			// 渠道期间检查
			new AptCheckChlPeriodBP().exec(oralAptDTO.getId_scchl(), oralAptDTO.getId_sch(),
					IScDictCodeConst.SD_SCTP_OP);
		}

		// 10、主号位
		ScSchTickDO mainTickDO = new OralAptEP().getSchTickById(oralAptDTO.getId_tick());

		// 11、检查患者是否在同一天预约相同的排班计划(改走校验规则)
		// this.checkPatApt(patId, oralAptDTO, mainTickDO);

		// 12、判断要预约的号是否有效
		this.checkIsCanUse(oralAptDTO, mainTickDO);

		// 记录日志
		schDO = new OralAptEP().getSch(oralAptDTO.getId_sch());
		ScLogUtil.getInstance().logInfo("[预约中]释放号位前：(患者：" + patId + "),排班：" + schDO.toString());

		// 13、释放号位
		this.releaseTick(oralAptDTO);

		// 记录日志
		schDO = new OralAptEP().getSch(oralAptDTO.getId_sch());
		ScLogUtil.getInstance().logInfo("[预约中]释放号位后：(患者：" + patId + "),排班：" + schDO.toString());

		// 14、检查当前号源池剩余数量
		this.checkSchQuanCanUse(oralAptDTO);

		// 15、处理最小号为使用，其余号为占用
		this.occupyTick(oralAptDTO, chlDO);

		// 16、保存预约
		String aptId = this.saveApt(patId, oralAptDTO, mainTickDO, planDO);

		// 17、保存预约挂号
		this.saveAptOp(oralAptDTO, planDO);

		// 18、保存口腔科预约
		this.saveOralApt(oralAptDTO);

		// 19、返回预约数据
		oralAptDTO = new GetOralAptInfoBP().exec(aptId);
		if (null == oralAptDTO) {
			throw new BizException(IScMsgConst.SC_APT_ORAL_NOT_FROM);
		}

		// 20、设置号源池剩余数量
		this.setAptQuanNum(oralAptDTO, chlDO);

		// 21、触发预约事件 changed by zhengcm 2018-01-29 增加参数控制
		if (ScParamUtils.getNeedSendMsg(planDO.getId_dep())) {
			this.invokeOpAptEvent(oralAptDTO, isInvoke,planDO.getId_dep());
		}

		// 记录日志
		schDO = new OralAptEP().getSch(oralAptDTO.getId_sch());
		ScLogUtil.getInstance().logInfo("[预约后]口腔预约成功：(患者：" + patId + "),排班：" + schDO.toString());

		return oralAptDTO;
	}

	/**
	 * 检查患者是否在同一天预约相同的排班计划
	 *
	 * @param patId 患者id
	 * @param oralAptDTO 口腔科预约DTO
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unused")
	private void checkPatApt(String patId, AptOralDTO oralAptDTO, ScSchTickDO mainTickDO) throws BizException {
		if (StringUtil.isEmptyWithTrim(patId) || oralAptDTO.getStatus() == DOStatus.UPDATED) {
			return;
		}

		OralAptEP oralAptEP = new OralAptEP();

		// 查询患者已预约数据
		String where = String.format("id_pat = '%s' and sd_status = '" + IScDictCodeConst.SD_APTSTATUS_ORDER
				+ "' and id_tick <> '%s'", patId, mainTickDO.getId_tick());

		ScAptDO[] aptDOs = new AptEP().getByWhere(where);
		if (ArrayUtil.isEmpty(aptDOs)) {
			return;
		}
		List<String> tickIds = new ArrayList<String>();
		for (ScAptDO aptDO : aptDOs) {
			tickIds.add(aptDO.getId_tick());
		}
		where = ScSqlUtils.getInSqlByIds("id_tick", tickIds);
		ScSchTickDO[] aptTickDOs = oralAptEP.getSchTickByWhereStr(where);
		if (ArrayUtil.isEmpty(aptTickDOs)) {
			return;
		}
		List<String> schIds = new ArrayList<String>();
		for (ScSchTickDO tickDO : aptTickDOs) {
			schIds.add(tickDO.getId_sch());
		}
		where = ScSqlUtils.getInSqlByIds("id_sch", schIds);
		ScSchDO[] aptSchDOs = oralAptEP.getSchByWhere(where);
		if (ArrayUtil.isEmpty(aptSchDOs)) {
			return;
		}
		ScSchDO curSchDO = oralAptEP.getSch(mainTickDO.getId_sch());
		for (ScSchDO schDO : aptSchDOs) {
			if (schDO.getD_sch().compareTo(curSchDO.getD_sch()) == 0
					&& schDO.getId_scpl().equals(oralAptDTO.getId_scpl())) {
				ScPlanDO planDO = oralAptEP.getScPlan(schDO.getId_scpl());
				DaysLotDO dayslotDO = oralAptEP.getDayslot(schDO.getId_dayslot());
				throw new BizException(String.format(IScMsgConst.SC_APT_ORAL_DONOT_REPEAT,
						planDO.getName() + schDO.getD_sch() + dayslotDO.getName()));
			}
		}
	}

	/**
	 * 判断要预约的号是否有效
	 *
	 * @param oralAptDTO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void checkIsCanUse(AptOralDTO oralAptDTO, ScSchTickDO mainTickDO) throws BizException {
		if (null == oralAptDTO) {
			return;
		}
		OralAptEP oralAptEP = new OralAptEP();
		ScSchDO schDO = oralAptEP.getSch(mainTickDO.getId_sch());
		ScPlanDO planDO = oralAptEP.getScPlan(schDO.getId_scpl());
		String msg = planDO.getName() + " " + schDO.getD_sch() + " " + mainTickDO.getT_b();
		if (mainTickDO.getFg_active().equals(FBoolean.FALSE)) {
			throw new BizException(String.format(IScMsgConst.SC_APT_ORAL_UNACTIVE, msg));
		} else if (oralAptDTO.getStatus() == DOStatus.NEW && mainTickDO.getEu_used() != EuUseState.WY) {
			throw new BizException(String.format(IScMsgConst.SC_APT_ORAL_HAS_USED_OR_OCCUPY, msg));
		} else if (mainTickDO.getEu_usescope() != EuUseScope.APT) {
			throw new BizException(String.format(IScMsgConst.SC_APT_ORAL_NOT_APPT, msg));
		}
	}

	/**
	 * 处理DTO状态
	 *
	 * @param oralAptDTO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void processDTOStatus(AptOralDTO oralAptDTO) throws BizException {
		if (null == oralAptDTO) {
			return;
		}
		if (StringUtil.isEmptyWithTrim(oralAptDTO.getId_apt())) {
			oralAptDTO.setStatus(DOStatus.NEW);
		} else {
			oralAptDTO.setStatus(DOStatus.UPDATED);
		}
	}

	/**
	 * 释放号位
	 *
	 * @param id_tick
	 * @throws BizException
	 * @author zhengcm
	 */
	private void releaseTick(AptOralDTO oralAptDTO) throws BizException {
		if (null == oralAptDTO || StringUtil.isEmptyWithTrim(oralAptDTO.getId_apt())) {
			return;
		}
		// 退号
		IScSchOutCmdService cmdService = ServiceFinder.find(IScSchOutCmdService.class);
		if (!StringUtil.isEmptyWithTrim(oralAptDTO.getId_apt())) {
			// 获取预约
			ScAptDO aptDO = new AptEP().getById(oralAptDTO.getId_apt());
			if (aptDO.getSd_status().equals(IScDictCodeConst.SD_APTSTATUS_CANCEL) && aptDO.getFg_canc().booleanValue()) {
				return;
			}
			// 判断是否需要补号
			IEnOutQryService qryService = ServiceFinder.find(IEnOutQryService.class);
			String supplyTicketType = qryService.getSupplyTicketType(null, aptDO.getId_apt());
			// cmdService.drawbackTick(aptDO.getId_tick());
			cmdService.revokeTick(aptDO.getId_tick(), supplyTicketType);
		}
	}

	/**
	 * 取消已有预约
	 *
	 * @param oralAptDTO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void cancApted(AptOralDTO oralAptDTO) throws BizException {
		if (null == oralAptDTO || StringUtil.isEmptyWithTrim(oralAptDTO.getId_apt_old())) {
			return;
		}
		if (!StringUtil.isEmptyWithTrim(oralAptDTO.getId_apt())
				&& oralAptDTO.getId_apt().equals(oralAptDTO.getId_apt_old())) {
			return;
		}
		if (!StringUtil.isEmptyWithTrim(oralAptDTO.getId_apt_old())) {
			new CancOralAptBP().exec(oralAptDTO.getId_apt_old(), FBoolean.TRUE, 1);
		}
	}

	/**
	 * 号位使用和占用
	 *
	 * @param oralAptDTO
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	private void occupyTick(AptOralDTO oralAptDTO, ScSchChlDO chlDO) throws BizException {
		if (null == oralAptDTO) {
			return;
		}
		List<String> tickIds = new ArrayList<String>();
		tickIds.add(oralAptDTO.getId_tick());
		FArrayList flist = oralAptDTO.getTickarray();
		if (null != flist && flist.size() > 0) {
			String[] otherTickIds = (String[]) flist.toArray(new String[0]);
			for (String otherTickId : otherTickIds) {
				String[] arr = otherTickId.replace("[", "").replace("]", "").split(",");
				for (String tickId : arr) {
					if (!tickIds.contains(tickId)) {
						tickIds.add(tickId);
					}
				}
			}
		}
		String where = ScSqlUtils.getInSqlByIds("id_tick", tickIds);
		ScSchTickDO[] tickDOs = new OralAptEP().getSchTickByWhereStr(where);
		// 排班对外维护服务
		IScSchOutCmdService outCmdService = ServiceFinder.find(IScSchOutCmdService.class);
		// 占用号位
		tickDOs = outCmdService.occupyMultTick(tickDOs, chlDO.getScpolcn());
		// 记录日志
		ScLogUtil.getInstance().logInfo("[预约中]口腔预约号位：" + flist.toString());
		for (ScSchTickDO tickDO : tickDOs) {
			ScLogUtil.getInstance().logInfo("[预约中]占用号位：" + tickDO.toString());
		}
	}

	/**
	 * 计算预约结束日期时间
	 *
	 * @param oralAptDTO
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	private FDateTime caluAptDt_End(AptOralDTO oralAptDTO, ScSchTickDO mainTickDO) throws BizException {
		FDateTime dt_e = new FDateTime(oralAptDTO.getD_sch() + " " + mainTickDO.getT_e());
		FArrayList flist = oralAptDTO.getTickarray();
		if (null != flist && flist.size() > 0) {
			List<String> tickIds = flist;
			String where = ScSqlUtils.getInSqlByIds("id_tick", tickIds);
			ScSchTickDO[] tickDOs = new OralAptEP().getSchTickByWhereStr(where);
			FTime t_e = mainTickDO.getT_e();
			for (ScSchTickDO tickDO : tickDOs) {
				if (t_e.compareTo(tickDO.getT_e()) < 0) {
					t_e = tickDO.getT_e();
				}
			}
			dt_e = new FDateTime(oralAptDTO.getD_sch() + " " + t_e);
		}
		return dt_e;
	}

	/**
	 * 保存预约
	 *
	 * @param oralAptDTO
	 * @throws BizException
	 * @author zhengcm
	 */
	private String saveApt(String patId, AptOralDTO oralAptDTO, ScSchTickDO mainTickDO, ScPlanDO planDO)
			throws BizException {
		if (null == oralAptDTO) {
			return null;
		}
		AptEP aptEP = new AptEP();
		ScAptDO aptDO = new ScAptDO();
		if (oralAptDTO.getStatus() == DOStatus.NEW) {
			aptDO.setStatus(DOStatus.NEW);
			aptDO.setCode(this.createCode(ScAptDODesc.CLASS_FULLNAME));
			aptDO.setSd_status(IScDictCodeConst.SD_APTSTATUS_ORDER);// 预约状态
			aptDO.setId_status(IScDictCodeConst.ID_APTSTATUS_ORDER);
		} else {
			aptDO = aptEP.getById(oralAptDTO.getId_apt());
			aptDO.setStatus(DOStatus.UPDATED);
		}
		aptDO.setId_tick(oralAptDTO.getId_tick());
		aptDO.setId_scchl(oralAptDTO.getId_scchl());
		aptDO.setSd_sctp(IScDictCodeConst.SD_SCTP_OP);// 排班类型：门诊
		aptDO.setId_sctp(IScDictCodeConst.ID_SCTP_OP);
		aptDO.setId_scca(planDO.getId_scca());// 排班分类
		aptDO.setId_sch(oralAptDTO.getId_sch());
		aptDO.setId_dateslot(oralAptDTO.getId_dayslot());
		aptDO.setId_scres(planDO.getId_scres());
		aptDO.setId_scsrv(oralAptDTO.getId_scsrv());// 排班服务
		aptDO.setId_tick(oralAptDTO.getId_tick());
		aptDO.setQueno(oralAptDTO.getQueno());// 票号
		if (aptDO.getDt_appt() == null) {
			aptDO.setDt_appt(ScAppUtils.getServerDateTime());
		}
		aptDO.setDt_b(new FDateTime(oralAptDTO.getD_sch() + " " + oralAptDTO.getT_b_tick()));
		aptDO.setDt_e(this.caluAptDt_End(oralAptDTO, mainTickDO));
		aptDO.setId_pat(patId);
		aptDO.setId_scchl(oralAptDTO.getId_scchl());
		aptDO.setId_grp(ScContextUtils.getGrpId());
		aptDO.setId_org(ScContextUtils.getOrgId());
		aptDO.setId_dep_appt(ScContextUtils.getDeptId());
		aptDO.setId_emp_appt(ScContextUtils.getPsnId());
		aptDO.setFg_payment(FBoolean.FALSE);
		aptDO.setFg_notice(FBoolean.FALSE);
		aptDO.setFg_canc(FBoolean.FALSE);
		aptDO.setFg_canc_notice(FBoolean.FALSE);
		aptDO.setFg_bill(FBoolean.FALSE);

		// 保存预约
		aptDO = aptEP.save(aptDO);
		oralAptDTO.setId_apt(aptDO.getId_apt());
		return aptDO.getId_apt();
	}

	/**
	 * 保存口腔科预约
	 *
	 * @param oralAptDTO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void saveOralApt(AptOralDTO oralAptDTO) throws BizException {
		if (null == oralAptDTO) {
			return;
		}
		OralAptEP oralAptEP = new OralAptEP();
		AptOpOralDO oralAptDO = new AptOpOralDO();
		if (oralAptDTO.getStatus() == DOStatus.NEW) {
			oralAptDO.setStatus(DOStatus.NEW);
		} else {
			String where = String.format("id_apt = '%s'", oralAptDTO.getId_apt());
			AptOpOralDO[] oralAptDOs = oralAptEP.findAptOpOralByWhere(where);
			if (ArrayUtil.isEmpty(oralAptDOs)) {
				return;
			}
			oralAptDO = oralAptDOs[0];
			oralAptDO.setStatus(DOStatus.UPDATED);
		}
		oralAptDO.setId_apt(oralAptDTO.getId_apt());
		oralAptDO.setPosi_teeth(oralAptDTO.getPosi_teeth());
		oralAptDO.setId_proc_oral(oralAptDTO.getId_proc_oral());
		oralAptDO.setSd_proc_oral(oralAptDTO.getSd_proc_oral());
		oralAptDO.setName_proc_oral(oralAptDTO.getName_proc_oral());
		oralAptDO.setSvrslot(oralAptDTO.getSvrslot());
		oralAptDO.setNote(oralAptDTO.getNote());
		oralAptDO.setD_next_appt(oralAptDTO.getD_next_appt());
		oralAptDO.setNote_next(oralAptDTO.getNote_next());
		oralAptDO.setId_emp_lastmdf(ScContextUtils.getPsnId());
		oralAptDO.setDt_lastmdf(ScAppUtils.getServerDateTime());
		oralAptDO.setId_statustag(oralAptDTO.getId_statustag());// 口腔科预约状态
		oralAptDO.setSd_statustag(oralAptDTO.getSd_statustag());
		// 保存
		oralAptEP.saveAptOpOral(new AptOpOralDO[] { oralAptDO });
	}

	/**
	 * 保存预约挂号
	 *
	 * @param oralAptDTO
	 * @param planDO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void saveAptOp(AptOralDTO oralAptDTO, ScPlanDO planDO) throws BizException {
		if (null == oralAptDTO) {
			return;
		}
		AptOpEP opAptEP = new AptOpEP();
		ScheduleResDO resDO = new OralAptEP().getScRes(planDO.getId_scres());
		// 排班服务
		ScheduleSrvDO scsrvDO = new OralAptEP().getScSrvById(oralAptDTO.getId_scsrv());
		ScAptOpDO aptOpDO = new ScAptOpDO();
		if (oralAptDTO.getStatus() == DOStatus.NEW) {
			aptOpDO.setStatus(DOStatus.NEW);
			aptOpDO.setId_grp(ScContextUtils.getGrpId());
			aptOpDO.setId_org(ScContextUtils.getOrgId());
		} else {
			aptOpDO = opAptEP.getAptOpByAptId(oralAptDTO.getId_apt());
			if (null == aptOpDO) {
				return;
			}
			aptOpDO.setStatus(DOStatus.UPDATED);
		}
		aptOpDO.setId_apt(oralAptDTO.getId_apt());
		aptOpDO.setId_apptmd_op(IScDictCodeConst.ID_APPTMD_OP_NORMAL);
		aptOpDO.setSd_apptmd_op(IScDictCodeConst.SD_APPTMD_OP_NORMAL);
		aptOpDO.setId_dep(planDO.getId_dep());
		if (null != resDO) {
			aptOpDO.setId_emp(resDO.getId_emp());
		}
		aptOpDO.setId_dep_belong(planDO.getId_dep());
		if (null != scsrvDO) {
			aptOpDO.setId_srvtp(scsrvDO.getId_srvtp());
			aptOpDO.setSd_srvtp(scsrvDO.getSd_sctp());
		}
		aptOpDO.setFg_add(FBoolean.FALSE);

		// 保存
		opAptEP.save(aptOpDO);
	}

	/**
	 * 生成编码
	 * 
	 * @param doDescFullName 实体元数据类全名
	 * @return
	 * @throws BizException
	 */
	private String createCode(String doDescFullName) throws BizException {
		IBillcodeManage codeManage = ServiceFinder.find(IBillcodeManage.class);
		String code = codeManage.getPreBillCode_RequiresNew(doDescFullName);
		return code;
	}

	/**
	 * 检查预约状态：取号后不允许修改
	 *
	 * @param oralAptDTO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void checkAptStatus(AptOralDTO oralAptDTO) throws BizException {
		if (null == oralAptDTO) {
			return;
		}
		new CheckOralAptStatusBP().check(oralAptDTO.getId_apt());
	}

	/**
	 * 检查号源池剩余数量
	 *
	 * @param oralAptDTO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void checkSchQuanCanUse(AptOralDTO oralAptDTO) throws BizException {
		if (null == oralAptDTO) {
			return;
		}
		OralAptEP oralAptEP = new OralAptEP();
		ScschAggDO aggDO = oralAptEP.getSchAggDOs(String.format("id_sch = '%s'", oralAptDTO.getId_sch()))[0];
		int quanCanUse = oralAptEP.calSchQuanCanUse(aggDO, oralAptDTO.getId_scchl());
		int tickNums = 0;
		if (null != oralAptDTO.getTickarray()) {
			tickNums = oralAptDTO.getTickarray().size();
		}
		if (quanCanUse == 0 || tickNums > quanCanUse) {
			throw new BizException(String.format(IScMsgConst.SC_APT_ORAL_QUAN_NUM, quanCanUse));
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
		ResultDTO resultDTO = enOutQryService.isPermitRegByMvel(regRule);
		if (FBoolean.FALSE.equals(resultDTO.getFlag())) {
			throw new BizException(resultDTO.getMsg());
		}
	}

	/**
	 * 设置号源池剩余数量
	 *
	 * @param oralAptDTO
	 * @param chlDO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void setAptQuanNum(AptOralDTO oralAptDTO, ScSchChlDO chlDO) throws BizException {
		List<AptOralDTO> list = new ArrayList<AptOralDTO>();
		oralAptDTO.setId_scchl(chlDO.getId_scchl());
		list.add(oralAptDTO);
		new SetOralAptQuanCanUseBP().exec(list);
		oralAptDTO = list.get(0);
	}

	/**
	 * 检查是否需要发送门诊预约事件（新增或者预约开始时间变化时）
	 *
	 * @param oralAptDTO
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private boolean checkIsInvokeEvent(AptOralDTO oralAptDTO) throws BizException {
		boolean isInvoke = false;
		if (StringUtil.isEmptyWithTrim(oralAptDTO.getId_apt())) {
			isInvoke = true;
		} else {
			// 原预约数据
			ScAptDO oldAptDO = new AptEP().getById(oralAptDTO.getId_apt());
			FDateTime oldDateTime = oldAptDO.getDt_b();
			FDateTime newDateTime = new FDateTime(oralAptDTO.getD_sch() + " " + oralAptDTO.getT_b_tick());
			if (oldDateTime.compareTo(newDateTime) != 0) {
				isInvoke = true;
			}
		}
		return isInvoke;
	}

	/**
	 * 触发门诊预约事件
	 *
	 * @param oralAptDTO
	 * @param isInvoke
	 * @throws BizException
	 * @author zhengcm
	 */
	private void invokeOpAptEvent(AptOralDTO oralAptDTO, boolean isInvoke,String id_dep_pl) throws BizException {
		if (!isInvoke) {
			return;
		}
		// 触发门诊预约发送短信事件
		OpApt4EsDTO apt4EsDTO = new OpApt4EsDTO();
		apt4EsDTO.setId_apt(oralAptDTO.getId_apt());
		apt4EsDTO.setId_pat(oralAptDTO.getId_pat());
		apt4EsDTO.setId_sch(oralAptDTO.getId_sch());
		apt4EsDTO.setId_dep_pl(id_dep_pl);
		new OpAptEvent().invoke(apt4EsDTO);
	}
	/**
	 * 校验排班服务
	 * @author yzh
	 * @throws BizException 
	 * @date 2018年11月2日 19:54:03
	 */
	private void checkScSrv(String id_scpl,String id_scsrv,String id_scpl_scsrv) throws BizException{
		if (id_scsrv.equals(id_scpl_scsrv)) {
			return;
		}
		ScPlOptSrvDO[] scplopesrvs = new OralAptEP().getScPlOptSrv(id_scpl);
		if(!ArrayUtil.isEmpty(scplopesrvs)){
			for (ScPlOptSrvDO scPlOptSrvDO : scplopesrvs) {
				if(id_scsrv.equals(scPlOptSrvDO.getId_scsrv())){
					return;
				}
			}
		}
		throw new BizException(IScMsgConst.SC_APT_ORAL_SCSRV_ERR);
		
	}
}
