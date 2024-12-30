package iih.sc.apt.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.en.pv.dto.d.ResultDTO;
import iih.en.pv.i.IEnOutCmdService;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.out.i.IEn4ScQryService;
import iih.en.pv.outpatient.dto.d.RegRuleDTO;
import iih.pi.acc.account.i.IPatAccServiceExt;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.sc.apt.dto.d.AptPayDTO;
import iih.sc.apt.dto.d.OpApt4EsDTO;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.dto.d.ScAptRuleParamDTO;
import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.apt.s.event.OpAptAndPayEvent;
import iih.sc.apt.s.event.OpAptEvent;
import iih.sc.apt.s.rule.CheckRuleResultPro;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.d.ScAptOpDO;
import iih.sc.apt.scapt.d.desc.ScAptDODesc;
import iih.sc.apt.scapt.i.IScAptOpDOCudService;
import iih.sc.apt.scapt.i.IScaptMDOCudService;
import iih.sc.apt.scapt.i.IScaptMDORService;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.IScRuleConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScParamUtils;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvDO;
import iih.sc.sch.i.IScSchOutCmdService;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.i.IScschMDORService;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.sch.scticks.i.IScticksRService;
import iih.sc.scp.scplan.d.ScPlanDO;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;

/**
 * 门诊预约BP
 * 
 * @author yank
 */
public class AptOpBP {
	/**
	 * 预约
	 * 
	 * @param aptDTO
	 *            预约DTO
	 * @param isAuth
	 *            授权预约
	 * @param isPrePay
	 *            是否预付费
	 * @param chlId
	 *            渠道ID
	 * @param payDTO
	 *            支付DTO,TODO 参数暂时未用
	 * @throws BizException
	 */
	public String exec(OpAptDTO aptDTO, FBoolean isAuth, FBoolean isPrePay, String chlId, AptPayDTO payDTO) throws BizException {
		// 1、参数校验
		this.validateParam(aptDTO, isAuth, isPrePay, chlId, payDTO);

		// 2、准备所需数据
		// 挂号资源
		RegResDTO regResDTO = (RegResDTO) aptDTO.getRegresarray().get(0);
		// 获取排班信息
		ScSchDO schDO = this.getSch(regResDTO.getId_sch());
		// 3、校验是否可预约
		// 3.1 校验排班是否停诊和是否已经预约过
		this.ValidateIsStoped(schDO);
		this.validateHasAppted(aptDTO.getId_pat(), regResDTO.getId_sch());

		// 3.2 验证挂号规则

		ScSchChlDO chlDO = new OralAptEP().getSchChl(regResDTO.getId_sch(), chlId);
		if (null == chlDO) {
			throw new BizException(IScMsgConst.SC_APT_ORAL_NOT_CHL);
		}
		// 4、占用号位资源
		this.occupyTick(aptDTO, regResDTO, schDO, regResDTO.getPolcn());
		this.validateRegRule(aptDTO, schDO, regResDTO, chlDO);
		// 5、保存预约信息
		ScAptDO aptDO = this.saveApt(schDO, chlId, aptDTO);
		aptDTO.setId_apt(aptDO.getId_apt());// 预约ID
		
		// 6、保存门诊预约信息
		ScAptOpDO aptOpDO = this.saveAptOp(aptDO, aptDTO);

		// 7、如果是预付费,生成就诊，并结算
		if (FBoolean.TRUE.equals(isPrePay)) {
			// 2.获取患者的默认医保分类
			IEn4ScQryService iEn4ScQryService = ServiceFinder.find(IEn4ScQryService.class);
			PiPatCaDO patCaDO = iEn4ScQryService.getAptSelfPayPatCa(aptDTO.getId_pat());
			if (patCaDO == null)
				throw new BizException("自费结算获取患者分类失败！");
			aptDTO.setId_patca(patCaDO.getId_patca());
			aptDTO.setId_pripat(patCaDO.getId_patpritp());
			aptDTO.setId_patcret(patCaDO.getId_patcrettp());
			
			// 后台划价
			this.pricing(aptDTO, FBoolean.FALSE);
			// 结算
			this.settle(aptDTO, regResDTO, payDTO);
			// 触发预约+收费事件
			this.invokeAptAndPayEvent(aptDO, aptOpDO, aptDTO);
		} else {
			//触发预约事件 changed by fanlq 2018-04-11 增加参数控制
			if (ScParamUtils.getNeedSendMsg(aptOpDO.getId_dep())){
				// 8、触发事件
				this.invokeAptEvent(aptDO, aptOpDO, aptDTO);
			}
		}

		return aptOpDO.getId_apt();
	}

	/**
	 * 是否已经预约过
	 * 
	 * @param patId
	 *            患者id
	 * @param schId
	 *            排班id
	 * @throws BizException
	 */
	private void validateHasAppted(String patId, String schId) throws BizException {
		IScaptMDORService aptRService = ServiceFinder.find(IScaptMDORService.class);
		String whereStr = String.format("a0.id_sch = '%s' and a0.id_pat ='%s' and a0.fg_canc <> 'Y'", schId, patId);
		ScAptDO[] scAptDOs = aptRService.find(whereStr, null, FBoolean.FALSE);
		if (scAptDOs != null && scAptDOs.length > 0) {
			throw new BizException("已经预约过该资源，无法重复预约");
		}
	}

	/**
	 * 校验挂号规则
	 * 
	 * @param aptDTO
	 *            预约DTO
	 * @param schDO
	 *            排班DO
	 * @param regResDTO
	 *            预约资源DTO
	 * @throws BizException
	 */
	private void validateRegRule(OpAptDTO aptDTO, ScSchDO schDO, RegResDTO regResDTO, ScSchChlDO chlDO) throws BizException {
		ScAptRuleParamDTO aptParam = new ScAptRuleParamDTO();
		aptParam.setId_pat(aptDTO.getId_pat());
		aptParam.setId_sch(schDO.getId_sch());
		aptParam.setId_dayslot(schDO.getId_dayslot());
		aptParam.setId_scres(regResDTO.getId_scres());
		aptParam.setId_scsrv(regResDTO.getId_scsrv());
		aptParam.setId_dep(regResDTO.getId_dep());
		aptParam.setD_sch(schDO.getD_sch());
		aptParam.setCode_scchl(chlDO.getCode_scchl());
		aptParam.setDt_now(ScAppUtils.getServerDateTime());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(ScAptRuleParamDTO.class.getSimpleName(), aptParam);
		//调用预约规则
		ResultDTO resultDTO = CheckRuleResultPro.checkDealResult(IScRuleConst.SC_OP_APT_RULE, map);
		if (FBoolean.FALSE.equals(resultDTO.getFlag())) {
			throw new BizException(resultDTO.getMsg());
		}
		RegRuleDTO regRule = new RegRuleDTO();
		regRule.setId_pat(aptDTO.getId_pat());
		regRule.setId_sch(schDO.getId_sch());
		regRule.setId_scres(regResDTO.getId_scres());
		regRule.setId_dept(regResDTO.getId_dep());
		regRule.setRegdate(schDO.getD_sch().toStdString());
		regRule.setId_scsrv(regResDTO.getId_scsrv());
		regRule.setId_dayslot(schDO.getId_dayslot());
		regRule.setCode_scchl(chlDO.getCode_scchl());
		regRule.setFg_apt(FBoolean.TRUE);
		//调用挂号规则
		IEnOutQryService enOutQryService = ServiceFinder.find(IEnOutQryService.class);
		resultDTO = enOutQryService.isPermitRegByMvel(regRule);
		if (FBoolean.FALSE.equals(resultDTO.getFlag())) {
			throw new BizException(resultDTO.getMsg());
		}
	}
	/**
	 * 校验排班是否停用
	 * 
	 * @param schDO
	 * @throws BizException
	 */
	private void ValidateIsStoped(ScSchDO schDO) throws BizException {
		if (schDO.getFg_active() != null && !schDO.getFg_active().booleanValue()) {
			throw new BizException("该排班已经停诊");
		}
	}
	/**
	 * 验证预交金额是否足够
	 * 
	 * @param patDO
	 *            患者信息
	 * @param amt_pat
	 *            排班服务id
	 * @throws BizException
	 */
	private void validatePreAcc(PatDO patDO, FDouble amt_pat) throws BizException {
		// 取得服务对应价格
		IPatAccServiceExt IPatAccServiceExt = ServiceFinder.find(IPatAccServiceExt.class);
		FDouble balance = IPatAccServiceExt.GetOutpPrepaymentAmount(patDO.getId_pat());
		if (amt_pat.doubleValue() > balance.doubleValue()) {
			throw new BizException("预交金余额不足");
		}
	}

	/**
	 * 校验参数
	 * 
	 * @param aptDTO
	 *            预约DTO
	 * @param isAuth
	 *            授权预约
	 * @param isPrePay
	 *            是否预付费
	 * @param chlId
	 *            渠道ID
	 * @param payDTO
	 *            支付DTO,TODO 参数暂时未用
	 * @throws BizException
	 */
	private void validateParam(OpAptDTO aptDTO, FBoolean isAuth, FBoolean isPrePay, String chlId, AptPayDTO payDTO) throws BizException {
		if (aptDTO == null) {
			throw new BizException("预约信息为空!");
		} else if (StringUtils.isEmpty(aptDTO.getId_pat())) {
			throw new BizException("患者id为空！");
		}
	}

	/**
	 * 获取患者信息
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private PatDO getPat(String patId) throws BizException {
		IPatiMDORService patRService = ServiceFinder.find(IPatiMDORService.class);
		PatDO patDO = patRService.findById(patId);
		if (patDO == null) {
			throw new BizException(IScMsgConst.SC_PAT_NOT_EXISTS);
		}
		return patDO;
	}

	/**
	 * 获取排班信息
	 * 
	 * @param schId
	 *            排班ID
	 * @return
	 * @throws BizException
	 */
	private ScSchDO getSch(String schId) throws BizException {
		// 获取排班
		IScschMDORService schSrv = ServiceFinder.find(IScschMDORService.class);
		ScSchDO schDO = schSrv.findById(schId);
		if (schDO == null) {
			throw new BizException(IScMsgConst.ERROR_SC_SCH_NOT_EXISTS);
		}
		return schDO;
	}

	/**
	 * 占用号源
	 * 
	 * @param aptDTO
	 *            预约DTO
	 * @param regResDTO
	 *            预约资源
	 * @param schDO
	 *            排班DO
	 * @param polcn
	 *            号源池
	 * @throws BizException
	 */
	private void occupyTick(OpAptDTO aptDTO, RegResDTO regResDTO, ScSchDO schDO, Integer polcn) throws BizException {
		ScSchTicksDO ticksDO = null;
		IScSchOutCmdService schService = ServiceFinder.find(IScSchOutCmdService.class);
		ScSchTickDO tickDO = null;
		if (!StringUtil.isEmpty(aptDTO.getId_tick())) {
			tickDO = schService.occupyTick(aptDTO.getId_tick(), polcn);// 占用确切号位
		} else {
			tickDO = schService.occupyTickBySch(regResDTO.getId_sch(), polcn, aptDTO.getId_ticks(), regResDTO.getId_scchl());// 占用排班号位
		}
		if (!StringUtil.isEmpty(tickDO.getId_ticks())) {
			IScticksRService ticksRService = ServiceFinder.find(IScticksRService.class);
			ticksDO = ticksRService.findById(tickDO.getId_ticks());
		}
		if (ticksDO != null) {
			aptDTO.setId_ticks(ticksDO.getId_ticks()); // 号段
			aptDTO.setDt_b(new FDateTime(schDO.getD_sch().asLocalBegin(), ticksDO.getT_b())); // 预计开始时间
			aptDTO.setDt_e(new FDateTime(schDO.getD_sch().asLocalBegin(), ticksDO.getT_e())); // 预计结束时间
		} else if (tickDO != null) {
			aptDTO.setDt_b(new FDateTime(schDO.getD_sch().asLocalBegin(), tickDO.getT_b())); // 预计开始时间
			aptDTO.setDt_e(new FDateTime(schDO.getD_sch().asLocalBegin(), tickDO.getT_e())); // 预计结束时间
		}
		aptDTO.setId_tick(tickDO.getId_tick()); // 号位
		aptDTO.setQueno(tickDO.getQueno()); // 票号
	}

	/**
	 * 保存预约
	 * 
	 * @param patDO
	 *            患者DO
	 * @param schDO
	 *            排班DO
	 * @param chlId
	 *            渠道ID
	 * @param aptDTO
	 *            预约DTO
	 * @return
	 * @throws BizException
	 */
	private ScAptDO saveApt(ScSchDO schDO, String chlId, OpAptDTO aptDTO) throws BizException {
		// 获取患者信息
		PatDO patDO = this.getPat(aptDTO.getId_pat());
		// 预约数据
		IScSchOutQryService iScSchOutQryService = ServiceFinder.find(IScSchOutQryService.class);
		ScPlanDO planDO = iScSchOutQryService.getScplanBySchBp(schDO);
		if (planDO == null)
			throw new BizException(IScMsgConst.SC_SCH_SCPLAN_ISEMPY);
		ScAptDO scAptDO = new ScAptDO();
		scAptDO.setCode(this.createCode(ScAptDODesc.CLASS_FULLNAME));
		scAptDO.setId_grp(schDO.getId_grp()); // 集团
		scAptDO.setId_org(schDO.getId_org()); // 机构
		scAptDO.setSd_sctp(schDO.getSd_sctp()); // 排班类型
		scAptDO.setId_scca(schDO.getId_scca()); // 排班分类
		scAptDO.setId_sch(schDO.getId_sch()); // 排班
		scAptDO.setId_dateslot(schDO.getId_dayslot()); // 日期分组
		scAptDO.setId_scres(planDO.getId_scres()); // 排班资源
		scAptDO.setId_scsrv(planDO.getId_scsrv()); // 排班服务
		scAptDO.setId_ticks(aptDTO.getId_ticks()); // 号段
		scAptDO.setDt_b(aptDTO.getDt_b()); // 预计开始时间
		scAptDO.setDt_e(aptDTO.getDt_e()); // 预计结束时间
		scAptDO.setId_tick(aptDTO.getId_tick()); // 号位
		scAptDO.setQueno(aptDTO.getQueno()); // 票号
		scAptDO.setDt_appt(ScAppUtils.getServerDateTime()); // 预约操作时间
		scAptDO.setId_scchl(chlId); // 预约渠道
		scAptDO.setId_pat(patDO.getId_pat()); // 患者
		scAptDO.setId_org_appt(ScContextUtils.getOrgId()); // 预约操作机构
		scAptDO.setId_dep_appt(ScContextUtils.getDeptId()); // 预约操作部门
		if (aptDTO.getId_emp_appt() != null) {
			scAptDO.setId_emp_appt(aptDTO.getId_emp_appt()); // 当前医生
		} else {
			scAptDO.setId_emp_appt(ScContextUtils.getPsnId());
		}
		scAptDO.setId_sctp(schDO.getId_sctp());
		scAptDO.setFg_canc_notice(FBoolean.FALSE);
		// add by zhengcm 2-17-11-06 (保存状态ID)
		scAptDO.setId_status(IScDictCodeConst.ID_APTSTATUS_ORDER);
		scAptDO.setSd_status(IScDictCodeConst.SD_APTSTATUS_ORDER); // 预约状态
		scAptDO.setFg_payment(FBoolean.FALSE); // 未支付标志
		scAptDO.setFg_bill(FBoolean.FALSE); // 未记费标志
		scAptDO.setFg_notice(FBoolean.FALSE); // 预约已通知标志
		scAptDO.setStatus(DOStatus.NEW);
		IScaptMDOCudService aptService = ServiceFinder.find(IScaptMDOCudService.class);
		ScAptDO[] aptDOs = aptService.save(new ScAptDO[] { scAptDO });
		return aptDOs[0];
	}

	/**
	 * 新增门诊预约
	 * 
	 * @param aptDO
	 *            预约DO
	 * @param schDO
	 *            排班DO
	 * @return
	 * @throws BizException
	 */
	private ScAptOpDO saveAptOp(ScAptDO aptDO, OpAptDTO aptDTO) throws BizException {
		ScAptOpDO aptopDO = new ScAptOpDO();
		aptopDO.setId_apt(aptDO.getId_apt()); // 预约信息ID
		aptopDO.setId_apptmd_op(IScDictCodeConst.ID_APPTMD_OP_ROOM);
		aptopDO.setSd_apptmd_op(IScDictCodeConst.SD_APPTMD_OP_ROOM); // 诊间预约
		FArrayList resList = aptDTO.getRegresarray();
		RegResDTO resDTO = (RegResDTO) resList.get(0);
		aptopDO.setId_dep(resDTO.getId_dep()); // 计划科室
		aptopDO.setId_emp(resDTO.getId_emp()); // 医生
		aptopDO.setId_dep_belong(resDTO.getId_dep()); // 计划科室

		/**
		 * // 获取服务类型 FArrayList srvDTOList = resDTO.getSrvarray(); int size =
		 * srvDTOList == null ? 0 : srvDTOList.size(); for (int i = 0; i < size;
		 * i++) { RelSrvDTO srvDTO = (RelSrvDTO) srvDTOList.get(i); if
		 * (FBoolean.TRUE.equals(srvDTO.getFg_maj())) {
		 * aptopDO.setId_srvtp(srvDTO.getId_srvtp());
		 * aptopDO.setSd_srvtp(srvDTO.getSd_srvtp()); break; } }
		 **/
		// 服务类型取排班服务的号别类型(add by zhengcm 2017-10-30)
		ScheduleSrvDO scsrvDO = new OralAptEP().getScSrvById(aptDO.getId_scsrv());
		if (null != scsrvDO) {
			aptopDO.setId_srvtp(scsrvDO.getId_srvtp());
			aptopDO.setSd_srvtp(scsrvDO.getSd_srvtp());
		}
		aptopDO.setId_grp(aptDO.getId_grp());
		aptopDO.setId_org(aptDO.getId_org());

		aptopDO.setFg_en(FBoolean.FALSE); // 就诊标志
		aptopDO.setFg_add(aptDTO.getFg_add() == null ? FBoolean.FALSE : aptDTO.getFg_add());
		// 加号标志
		aptopDO.setStatus(DOStatus.NEW);
		IScAptOpDOCudService aptOpCudService = ServiceFinder.find(IScAptOpDOCudService.class);
		ScAptOpDO[] aptOpDOs = aptOpCudService.save(new ScAptOpDO[] { aptopDO });
		return aptOpDOs[0];
	}

	/**
	 * 划价
	 * 
	 * @param aptDTO
	 *            预约信息DTO
	 * @param fgAcc
	 *            记账标志
	 * @throws BizException
	 */
	private void pricing(OpAptDTO aptDTO, FBoolean fgAcc) throws BizException {
		// 划价，在前台不处理划价，显示标准价格即可
		IEnOutCmdService en4AptService = ServiceFinder.find(IEnOutCmdService.class);
		aptDTO = en4AptService.pricing(aptDTO, fgAcc, FBoolean.FALSE);// 结算，不打印发票
	}

	/**
	 * 结算
	 * 
	 * @param aptDTO
	 *            预约DTO
	 * @param payDTO
	 *            支付DTO
	 * @throws BizException
	 */
	private void settle(OpAptDTO aptDTO, RegResDTO regResDTO, AptPayDTO payDTO) throws BizException {
		if (payDTO == null) {
			payDTO = new AptPayDTO();
		}
		payDTO.setAmt_st(regResDTO.getAmt_st());// 标准金额
		payDTO.setAmt_hp(regResDTO.getAmt_hp());// 医保支付
		payDTO.setAmt_pat(regResDTO.getAmt_pat());// 患者自付
		payDTO.setAmt(regResDTO.getAmt());// 应付金额
		payDTO.setPaystyle(IBdPripmCodeConst.CODE_PRI_PM_PAY);// 支付方式,预交金
		payDTO.setFg_print(payDTO.getFg_print());
		// 结算
		SettleOpAptBP settleBP = new SettleOpAptBP();
		settleBP.exec(aptDTO, payDTO, FBoolean.FALSE);
	}

	/**
	 * 生成编码
	 * 
	 * @param doDescFullName
	 *            实体元数据类全名
	 * @return
	 * @throws BizException
	 */
	private String createCode(String doDescFullName) throws BizException {
		IBillcodeManage codeManage = ServiceFinder.find(IBillcodeManage.class);
		String code = codeManage.getPreBillCode_RequiresNew(doDescFullName);
		return code;
	}

	/**
	 * 触发预约+收费事件
	 * 
	 * @param aptDO
	 * @param aptOpDO
	 * @throws BizException
	 */
	private void invokeAptAndPayEvent(ScAptDO aptDO, ScAptOpDO aptOpDO, OpAptDTO aptDTO) throws BizException {
		OpApt4EsDTO apt4EsDTO = new OpApt4EsDTO();
		apt4EsDTO.setId_apt(aptDO.getId_apt());
		apt4EsDTO.setId_pat(aptDO.getId_pat());
		apt4EsDTO.setId_sch(aptDO.getId_sch());
		apt4EsDTO.setId_ent(aptDTO.getId_ent());
		apt4EsDTO.setId_dep_pl(aptOpDO.getId_dep());//短信发送,有科室检验
		new OpAptAndPayEvent().invoke(apt4EsDTO);
	}

	/**
	 * 触发事件
	 * 
	 * @param aptDO
	 * @param aptOpDO
	 * @throws BizException
	 */
	private void invokeAptEvent(ScAptDO aptDO, ScAptOpDO aptOpDO, OpAptDTO aptDTO) throws BizException {
		OpApt4EsDTO apt4EsDTO = new OpApt4EsDTO();
		apt4EsDTO.setId_apt(aptDO.getId_apt());
		apt4EsDTO.setId_pat(aptDO.getId_pat());
		apt4EsDTO.setId_sch(aptDO.getId_sch());
		apt4EsDTO.setId_ent(aptDTO.getId_ent());
		apt4EsDTO.setId_dep_pl(aptOpDO.getId_dep());//短信发送,有科室检验
		new OpAptEvent().invoke(apt4EsDTO);
	}
}
