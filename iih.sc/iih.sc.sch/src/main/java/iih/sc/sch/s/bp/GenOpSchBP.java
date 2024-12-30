package iih.sc.sch.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.IntegerUtils;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScParamUtils;
import iih.sc.scbd.scapptrule.d.ScapptruleDO;
import iih.sc.scbd.scapptrule.i.IScapptruleRService;
import iih.sc.sch.dto.d.OpSchTplDTO;
import iih.sc.sch.dto.d.PlanGenResult;
import iih.sc.sch.dto.d.SchKey;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.d.ScSchEmpDO;
import iih.sc.sch.scsch.d.ScSchEnDO;
import iih.sc.sch.scsch.d.ScSchOptsrvDO;
import iih.sc.sch.sctick.d.EuAddTickMod;
import iih.sc.sch.sctick.d.EuUseScope;
import iih.sc.sch.sctick.d.EuUseState;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scploptsrv.d.ScPlOptSrvDO;
import iih.sc.scp.scploptsrv.i.IScploptsrvRService;
import iih.sc.scp.scpltick.d.ScPlanWeekTickDO;
import iih.sc.scp.scpltick.i.IScpltickRService;
import iih.sc.scp.scplticks.d.ScPlanWeekTicksDO;
import iih.sc.scp.scplticks.i.IScplticksRService;
import iih.sc.scp.scplweek.d.ScPlanWeekChlDO;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;
import iih.sc.scp.scplweek.d.ScPlanWeekEmpDO;
import iih.sc.scp.scplweek.d.ScPlanWeekEnDO;
import iih.sc.scp.scplweek.d.ScplweekAggDO;
import iih.sc.scp.scplweek.i.IScplweekRService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 生成门诊排班
 *
 * @author yankan
 * @since 2017-05-25
 */
public class GenOpSchBP {
	/**
	 * 生成门诊排班
	 * 
	 * @param planDO 排班计划
	 * @param tpls 排班模板
	 * @param excludeSchList 需排除的排班
	 * @throws BizException
	 */
	public PlanGenResult exec(ScPlanDO planDO, OpSchTplDTO[] tpls, Map<SchKey, ScSchDO> excludeSchMap)
			throws BizException {
		PlanGenResult result = new PlanGenResult();
		if (planDO == null || ArrayUtil.isEmpty(tpls)) {
			return result;
		}
		ScplweekAggDO[] weekAggDOs = this.getWeekPlanList(planDO.getId_scpl());
		if (!ArrayUtil.isEmpty(weekAggDOs)) {
			// 计划中含多午别，排班模板中只有日期，没有午别
			Map<String, List<ScplweekAggDO>> weekPlanMap = this.processWeekPlan(planDO.getId_scpl(), weekAggDOs);
			GenerateIdBP genIdBP = new GenerateIdBP(tpls.length * 2);// 午别通常2个
			for (OpSchTplDTO schTplDTO : tpls) {
				String planKey = this.wrapSchTplKey(planDO.getId_scpl(), schTplDTO);
				List<ScplweekAggDO> weekPlAggList = weekPlanMap.get(planKey);
				if (ListUtil.isEmpty(weekPlAggList)) {
					continue;
				}
				FDate d_last_sch = null;
				for (ScplweekAggDO weekPlAggDO : weekPlAggList) {
					SchKey schKey = new SchKey(weekPlAggDO.getParentDO().getId_scpl(), schTplDTO.getDate(), weekPlAggDO
							.getParentDO().getId_dayslot());
					if (!excludeSchMap.containsKey(schKey)) {
						result.getWillDelSchKeyList().add(schKey);// 添加到预删除排班
						String schId = genIdBP.getNewId();
						this.genOpSch(planDO, weekPlAggDO, schId, schTplDTO.getDate(), result);// 生成排班
						if(d_last_sch == null || d_last_sch.compareTo(schTplDTO.getDate()) < 0){
							d_last_sch = schTplDTO.getDate();
							planDO.setStatus(DOStatus.UPDATED);
							planDO.setD_last_sch(d_last_sch);
						}
					}
				}
			}
		}

		return result;
	}

	/**
	 * 生成排班
	 * 
	 * @param planDO 排班计划
	 * @param weekPlAggDO 周计划
	 * @param schId 排班ID
	 * @param date 排班日期
	 * @param result 生成结果
	 * @throws BizException
	 */
	private void genOpSch(ScPlanDO planDO, ScplweekAggDO weekPlAggDO, String schId, FDate date, PlanGenResult result)
			throws BizException {
		// 1、生成排班信息
		ScPlanWeekDO weekPlanDO = weekPlAggDO.getParentDO();
		ScSchDO schDO = this.genSchDO(schId, planDO, weekPlanDO, date);
		String sd_schrule = this.getSdApprule(schDO.getId_apptru());
		result.getSchDOList().add(schDO);

		// 2、生成排班渠道信息
		ScPlanWeekChlDO[] weekPlanChlDOList = weekPlAggDO.getScPlanWeekChlDO();
		List<ScSchChlDO> schChlDOs = this.genSchChlDOList(schId, weekPlanChlDOList);
		result.getSchChlDOList().addAll(schChlDOs);

		// 3、生成排班就诊
		ScPlanWeekEnDO[] weekPlanEnDOList = weekPlAggDO.getScPlanWeekEnDO();
		List<ScSchEnDO> schEnDOs = this.genSchEnDOList(schId, weekPlanEnDOList);
		result.getSchEnDOList().addAll(schEnDOs);
		
		// 4、生成排班人员
		ScPlanWeekEmpDO[] weekPlanEmpDOList = weekPlAggDO.getScPlanWeekEmpDO();
		List<ScSchEmpDO> schEmpDOs = this.genSchEmpDOList(schId, weekPlanEmpDOList);
		result.getSchEmpDOList().addAll(schEmpDOs);
		
		// 5、生成备用排班服务
		if(IScDictCodeConst.SD_SCTP_MT.equals(planDO.getSd_sctp())){
			List<ScSchOptsrvDO> scPlOptSrvDOs = this.genScPlOptSrvDOList(schId, weekPlanDO, planDO.getId_dep());
			if(!ListUtil.isEmpty(scPlOptSrvDOs)){
				result.getscSchOptsrvDOList().addAll(scPlOptSrvDOs);
			}
		}
		// 6、生成号段、号位
		if (IScDictCodeConst.SD_TICKMD_TICKS.equals(planDO.getSd_tickmd())) {
			// 号段模式
			// 查找周计划对应的号段信息
			ScPlanWeekTicksDO[] weekPlanTicksList = this.getPlanTicksList(weekPlanDO.getId_scplweek());
			// 生成号段
			List<ScSchTicksDO> ticksDOList = this.genSchTicksDOList(schDO, weekPlanTicksList, planDO, weekPlanDO,
					result, sd_schrule);
			result.getSchTicksDOList().addAll(ticksDOList);
			// if (weekPlanDO.getFg_setscchl() == null ||
			// !weekPlanDO.getFg_setscchl().booleanValue()) {
			// // 生成号位信息
			// List<ScSchTickDO> tickDOList = new ArrayList<ScSchTickDO>();
			// for (ScSchTicksDO ticksDO : ticksDOList) {
			// this.genSchTickDOListFromTicks(schDO, ticksDO, false,
			// tickDOList,sd_schrule);
			// }
			//
			//
			// result.getSchTickDOList().addAll(tickDOList);
			// }
		} else {
			// 号位模式，生成号位信息
			result.getSchTickDOList().addAll(this.processTickDO(weekPlanDO, schDO, result));
		}
	}

	/**
	 * 生成排班对象
	 * 
	 * @param schId 排班ID
	 * @param planDO 排班计划
	 * @param weekPlanDO 周计划
	 * @param schDate 排班日期
	 * @return
	 * @throws BizException
	 */
	private ScSchDO genSchDO(String schId, ScPlanDO planDO, ScPlanWeekDO weekPlanDO, FDate schDate) throws BizException {
		ScSchDO schdo = new ScSchDO();
		schdo.setStatus(DOStatus.NEW);
		schdo.setId_sch(schId);
		schdo.setId_scpl(weekPlanDO.getId_scpl());
		schdo.setId_org(ScContextUtils.getOrgId());// 机构
		schdo.setId_grp(ScContextUtils.getGrpId());// 集团
		schdo.setId_scca(planDO.getId_scca());// 排班分类
		schdo.setSd_sctp(planDO.getSd_sctp());// 排班类型编码
		schdo.setId_sctp(planDO.getId_sctp());// 排班类型id
		schdo.setD_sch(schDate);// 排班日期
		schdo.setId_dayslot(weekPlanDO.getId_dayslot());// 午别

		schdo.setSd_tickmd(planDO.getSd_tickmd());// 票号模式
		schdo.setId_tickmd(planDO.getId_tickmd());
		schdo.setId_apptru(planDO.getId_apptru());// 预约规则
		schdo.setSd_schrule(planDO.getCode_apptru());// 预约规则编码
		schdo.setT_b_acpt(weekPlanDO.getT_b_acpt());// 开始就诊时间
		schdo.setT_e_acpt(weekPlanDO.getT_e_acpt());// 结束就诊时间
		schdo.setFg_std_acpt(weekPlanDO.getFg_std_acpt());// 是否标准就诊时长
		schdo.setSrvslot(weekPlanDO.getSrvslot());// 单个服务时间
		schdo.setSugest_exmint(weekPlanDO.getSugest_exmint());// 推荐提前报到时间
		schdo.setSugest_num_mint(weekPlanDO.getSugest_num_mint());// 分钟数
		schdo.setSugest_num_tick(weekPlanDO.getSugest_num_tick());// 号数
		schdo.setT_e_reg(weekPlanDO.getT_e_reg());
		schdo.setFg_active(FBoolean.TRUE);
		// 设置号源池
		schdo.setQuan_total(weekPlanDO.getQuan_total());// 总数
		schdo.setQuan_total_appt(weekPlanDO.getQuan_total_appt());// 可预约
		schdo.setQuan_total_used(0);// 已使用
		schdo.setMax_num_add(weekPlanDO.getMax_num_add());// 最大加号数量
		schdo.setAddquecn(0);// 已加号数量
		schdo.setScpolcn(weekPlanDO.getScpolcn());// 号源池总数
		schdo.setQuan0_appt(weekPlanDO.getQuan0_appt() == null ? 0 : weekPlanDO.getQuan0_appt());
		schdo.setQuan1_appt(weekPlanDO.getQuan1_appt() == null ? 0 : weekPlanDO.getQuan1_appt());
		schdo.setQuan2_appt(weekPlanDO.getQuan2_appt() == null ? 0 : weekPlanDO.getQuan2_appt());
		schdo.setQuan3_appt(weekPlanDO.getQuan3_appt() == null ? 0 : weekPlanDO.getQuan3_appt());
		schdo.setQuan4_appt(weekPlanDO.getQuan4_appt() == null ? 0 : weekPlanDO.getQuan4_appt());
		schdo.setQuan5_appt(weekPlanDO.getQuan5_appt() == null ? 0 : weekPlanDO.getQuan5_appt());
		schdo.setQuan6_appt(weekPlanDO.getQuan6_appt() == null ? 0 : weekPlanDO.getQuan6_appt());
		schdo.setQuan7_appt(weekPlanDO.getQuan7_appt() == null ? 0 : weekPlanDO.getQuan7_appt());
		schdo.setQuan8_appt(weekPlanDO.getQuan8_appt() == null ? 0 : weekPlanDO.getQuan8_appt());
		schdo.setQuan9_appt(weekPlanDO.getQuan9_appt() == null ? 0 : weekPlanDO.getQuan9_appt());
		schdo.setQuan0_used(0);
		schdo.setQuan1_used(0);
		schdo.setQuan2_used(0);
		schdo.setQuan3_used(0);
		schdo.setQuan4_used(0);
		schdo.setQuan5_used(0);
		schdo.setQuan6_used(0);
		schdo.setQuan7_used(0);
		schdo.setQuan8_used(0);
		schdo.setQuan9_used(0);
		// 自动释放号源 zhengcm 2017-10-23
		schdo.setFg_auto_release(weekPlanDO.getFg_auto_release());
		//就诊类型
		schdo.setFg_setentp(weekPlanDO.getFg_setentp());
		//设置是否适用自动预约
		schdo.setFg_auto_apt(weekPlanDO.getFg_auto_apt());
		return schdo;
	}

	/**
	 * 周计划渠道生成排班渠道
	 * 
	 * @param schId 排班ID
	 * @param weekPlanChlDOs 周计划渠道集合
	 * @return
	 * @throws BizException
	 */
	private List<ScSchChlDO> genSchChlDOList(String schId, ScPlanWeekChlDO[] weekPlanChlDOs) throws BizException {
		if (ArrayUtil.isEmpty(weekPlanChlDOs))
			return null;
		List<ScSchChlDO> schChlList = new ArrayList<ScSchChlDO>();
		for (ScPlanWeekChlDO weekPlanChlDO : weekPlanChlDOs) {
			ScSchChlDO schChlDO = this.genSchChlDO(schId, weekPlanChlDO);
			schChlList.add(schChlDO);
		}
		return schChlList;
	}

	/**
	 * 周计划渠道生成排班渠道
	 * 
	 * @param schId 排班ID
	 * @param weekPlanChlDO 周计划渠道
	 * @return
	 */
	private ScSchChlDO genSchChlDO(String schId, ScPlanWeekChlDO weekPlanChlDO) {
		ScSchChlDO schChlDO = new ScSchChlDO();
		schChlDO.setStatus(DOStatus.NEW);
		schChlDO.setId_sch(schId);// 排班id
		schChlDO.setId_grp(ScContextUtils.getGrpId());
		schChlDO.setId_org(ScContextUtils.getOrgId());
		schChlDO.setId_scchl(weekPlanChlDO.getId_scchl());
		schChlDO.setScpolcn(weekPlanChlDO.getScpolcn());
		schChlDO.setIds_dep_spec(weekPlanChlDO.getIds_dep_spec());
		schChlDO.setIds_emp_spec(weekPlanChlDO.getIds_emp_spec());
		schChlDO.setId_entp(weekPlanChlDO.getId_entp());//就诊类型
		return schChlDO;

	}
	
	/**
	 * 周计划渠道生成排班--就诊
	 * 
	 * @param schId 排班ID
	 * @param weekPlanChlDOs 周计划渠道集合
	 * @return
	 * @throws BizException
	 */
	private List<ScSchEnDO> genSchEnDOList(String schId, ScPlanWeekEnDO[] weekPlanEnDOs) throws BizException {
		if (ArrayUtil.isEmpty(weekPlanEnDOs))
			return new ArrayList<ScSchEnDO>();
		List<ScSchEnDO> schenList = new ArrayList<ScSchEnDO>();
		for (ScPlanWeekEnDO weekPlanEnDO : weekPlanEnDOs) {
			ScSchEnDO schEnDO = this.genSchEnDO(schId, weekPlanEnDO);
			schenList.add(schEnDO);
		}
		return schenList;
	}

	/**
	 * 周计划渠道生成排班--就诊
	 * 
	 * @param schId 排班ID
	 * @param weekPlanChlDO 周计划渠道
	 * @return
	 */
	private ScSchEnDO genSchEnDO(String schId, ScPlanWeekEnDO weekPlanEnDO) {
		ScSchEnDO schEnDO = new ScSchEnDO();
		schEnDO.setStatus(DOStatus.NEW);
		schEnDO.setId_sch(schId);// 排班id
		schEnDO.setId_entp(weekPlanEnDO.getId_entp());//就诊id
		schEnDO.setSd_entp(weekPlanEnDO.getSd_entp());//就诊编码
		schEnDO.setScpolcn(weekPlanEnDO.getScpolcn());//号源池
		return schEnDO;

	}
	
	/**
	 * 备用服务
	 * @param schId
	 * @param weekPlanDO
	 * @return
	 * @throws BizException 
	 */
	private List<ScSchOptsrvDO> genScPlOptSrvDOList(String schId, ScPlanWeekDO weekPlanDO, String depId) throws BizException {
		if (weekPlanDO == null)
			return new ArrayList<ScSchOptsrvDO>();
		IScploptsrvRService iscploptsrvrservice = ServiceFinder.find(IScploptsrvRService.class);
		ScPlOptSrvDO[] scploptsrvs = null;
		// 根据计划获取备用服务
			scploptsrvs = iscploptsrvrservice.find("id_scpl = '"+weekPlanDO.getId_scpl()+"'",null, FBoolean.FALSE);
		// 周模板获取备用服务
		//if(ScParamUtils.getPlOptSrv(depId) == 1){
		//	scploptsrvs = iscploptsrvrservice.find("id_scplweek = '"+weekPlanDO.getId_scplweek()+"'",null, FBoolean.FALSE);
		//}
		if(ArrayUtil.isEmpty(scploptsrvs)){
			return null;
		}
		List<ScSchOptsrvDO> list = new ArrayList<ScSchOptsrvDO>();
		
		for (ScPlOptSrvDO scploptsrvdo : scploptsrvs) {
			ScSchOptsrvDO optsrvDO = new ScSchOptsrvDO();
			optsrvDO.setStatus(DOStatus.NEW);
			optsrvDO.setId_sch(schId);
			optsrvDO.setId_scsrv(scploptsrvdo.getId_scsrv());
			list.add(optsrvDO);
		}
		return list;
	}
	
	/**
	 * 周计划渠道生成排班--人员
	 * 
	 * @param schId 排班ID
	 * @param weekPlanChlDOs 周计划渠道集合
	 * @return
	 * @throws BizException
	 */
	private List<ScSchEmpDO> genSchEmpDOList(String schId, ScPlanWeekEmpDO[] weekPlanEmpDOs) throws BizException {
		if (ArrayUtil.isEmpty(weekPlanEmpDOs))
			return new ArrayList<ScSchEmpDO>();
		List<ScSchEmpDO> schEmpList = new ArrayList<ScSchEmpDO>();
		for (ScPlanWeekEmpDO weekPlanEmpDO : weekPlanEmpDOs) {
			ScSchEmpDO schEmpDO = this.genSchEmpDO(schId, weekPlanEmpDO);
			schEmpList.add(schEmpDO);
		}
		return schEmpList;
	}

	/**
	 * 周计划渠道生成排班--人员诊
	 * 
	 * @param schId 排班ID
	 * @param weekPlanChlDO 周计划渠道
	 * @return
	 */
	private ScSchEmpDO genSchEmpDO(String schId, ScPlanWeekEmpDO weekPlanEmpDO) {
		ScSchEmpDO schEmpDO = new ScSchEmpDO();
		schEmpDO.setStatus(DOStatus.NEW);
		schEmpDO.setId_sch(schId);// 排班id
		schEmpDO.setId_emp(weekPlanEmpDO.getId_emp());//人员
		return schEmpDO;

	}

	/**
	 * 生成号段集合
	 * 
	 * @param schDO 排班
	 * @param weekPlanTicksDOs 周计划号段集合
	 * @return
	 * @throws BizException
	 */
	private List<ScSchTicksDO> genSchTicksDOList(ScSchDO schDO, ScPlanWeekTicksDO[] weekPlanTicksDOs, ScPlanDO planDO,
			ScPlanWeekDO planWeekDO, PlanGenResult result, String sd_schrule) throws BizException {
		List<ScSchTicksDO> ticksList = new ArrayList<ScSchTicksDO>();
		DBUtil dbUtil = new DBUtil();
		String[] ids = dbUtil.getOIDs(weekPlanTicksDOs.length);
		int i = 0;
		for (ScPlanWeekTicksDO weekPlanTicksDO : weekPlanTicksDOs) {
			ScSchTicksDO ticksDO = this.genTicksDO(schDO.getId_sch(), weekPlanTicksDO);
			ticksDO.setId_ticks(ids[i]);
			ticksList.add(ticksDO);
			i++;
			List<ScSchTickDO> tickDOList = new ArrayList<ScSchTickDO>();
			// 生成号位信息
			if (planWeekDO.getFg_setscchl() != null && (planWeekDO.getFg_setscchl().booleanValue())) {
				setTickDOsWithTicks(planWeekDO, schDO, ticksDO, tickDOList,
						getPlanTickList(planWeekDO.getId_scplweek()), weekPlanTicksDO);
				this.genSchTickDOListFromTicks(schDO, ticksDO, true, tickDOList, sd_schrule);

			} else {
				this.genSchTickDOListFromTicks(schDO, ticksDO, false, tickDOList, sd_schrule);
			}

			result.getSchTickDOList().addAll(tickDOList);

		}

		return ticksList;
	}

	/**
	 * 计划号段生成排班号段
	 * 
	 * @param schId 排班ID
	 * @param weekPlanTicksDO 周计划号段
	 * @return
	 */
	private ScSchTicksDO genTicksDO(String schId, ScPlanWeekTicksDO weekPlanTicksDO) {
		ScSchTicksDO ticksDO = new ScSchTicksDO();
		ticksDO.setStatus(DOStatus.NEW);
		ticksDO.setId_grp(ScContextUtils.getGrpId());
		ticksDO.setId_org(ScContextUtils.getOrgId());
		ticksDO.setId_sch(schId);
		ticksDO.setCode(weekPlanTicksDO.getCode());
		ticksDO.setName(weekPlanTicksDO.getName());
		ticksDO.setT_b(weekPlanTicksDO.getT_b());
		ticksDO.setT_e(weekPlanTicksDO.getT_e());
		ticksDO.setQueno_b(weekPlanTicksDO.getQueno_b() == null ? 0 : weekPlanTicksDO.getQueno_b());
		ticksDO.setQuecn(weekPlanTicksDO.getQuecn());
		ticksDO.setQuecn_appt(weekPlanTicksDO.getQuecn_appt());
		ticksDO.setQuecn_used(weekPlanTicksDO.getQuecn_used());
		ticksDO.setId_scsrv(weekPlanTicksDO.getId_scsrv());
		ticksDO.setFg_used(weekPlanTicksDO.getFg_used());
		ticksDO.setFg_active(weekPlanTicksDO.getFg_active());
		// 排班服务类别细目
		ticksDO.setIds_kinditm(weekPlanTicksDO.getIds_kinditm());
		return ticksDO;
	}

	/**
	 * 设置号段的号位
	 * 
	 * @param scPlWkDO 周计划do
	 * @param schdo 排班do
	 * @param schTicksDO 排班号段
	 * @param schTickList 排班号位
	 * @param wkTickMap 周计划号位
	 * @param wkTicksDO 周计划号段
	 * @throws BizException
	 */
	private void setTickDOsWithTicks(ScPlanWeekDO scPlWkDO, ScSchDO schdo, ScSchTicksDO schTicksDO,
			List<ScSchTickDO> schTickList, ScPlanWeekTickDO[] wkTicks, ScPlanWeekTicksDO wkTicksDO) throws BizException {
		SetTickDOBP scBp = new SetTickDOBP();
		List<ScSchTickDO> tickDOList = null;
		// 有计划的号位
		if (scPlWkDO.getFg_setscchl() != null && scPlWkDO.getFg_setscchl().booleanValue()) {
			tickDOList = this.setTickDOsWithWkTick(scPlWkDO, schdo.getId_sch(), schTicksDO.getId_ticks(), wkTicks,
					wkTicksDO);
			scBp.setTickValueWithPlTick(schTicksDO, schdo, tickDOList);
		} else {// 无计划的号位
			tickDOList = scBp.setTickDos(schTicksDO, schdo);
		}

		if (ListUtil.isEmpty(tickDOList))
			return;
		schTickList.addAll(tickDOList);
	}

	/**
	 * 号段生成号位集合
	 * 
	 * @param schDO 排班信息
	 * @param ticksDO 号段信息
	 * @param sdApptRule 预约规则编码
	 * @return
	 */
	private List<ScSchTickDO> genSchTickDOListFromTicks(ScSchDO schDO, ScSchTicksDO ticksDO, Boolean isHasWkTick,
			List<ScSchTickDO> schTickList, String sd_schrule) {

		FTime dt_b = ticksDO.getT_b();
		int suggestMin = schDO.getSugest_num_mint() == null ? 0 : schDO.getSugest_num_mint();
		int suggestNum = schDO.getSugest_num_tick() == null ? 0 : schDO.getSugest_num_tick();
		for (int i = 1; i <= ticksDO.getQuecn().intValue(); i++) {
			ScSchTickDO tickDO = new ScSchTickDO();
			if (isHasWkTick) {
				tickDO = schTickList.get(i - 1);
			}
			tickDO.setStatus(DOStatus.NEW);
			tickDO.setId_grp(ScContextUtils.getGrpId());
			tickDO.setId_org(ScContextUtils.getOrgId());
			tickDO.setId_sch(schDO.getId_sch());
			tickDO.setId_ticks(ticksDO.getId_ticks());
			tickDO.setCode(String.valueOf(i));// 编码
			tickDO.setQueno(ticksDO.getQueno_b() + i - 1);
			if (suggestMin == 0 || suggestNum == 0) {// 号数 分钟
				tickDO.setT_b(ticksDO.getT_b());
				tickDO.setT_e(ticksDO.getT_e());
			} else {
				// 按分批粒度赋值
				if (new FTime(dt_b.getMillis() + suggestMin * 60000).getMillis() >= ticksDO.getT_e().getMillis()) {
					tickDO.setT_b(dt_b);
					tickDO.setT_e(ticksDO.getT_e());
				} else if (i % suggestNum == 0) {
					tickDO.setT_b(dt_b);
					tickDO.setT_e(new FTime(dt_b.getMillis() + suggestMin * 60000));
					dt_b = new FTime(dt_b.getMillis() + suggestMin * 60000);
				} else {
					tickDO.setT_b(dt_b);
					tickDO.setT_e(new FTime(dt_b.getMillis() + suggestMin * 60000));
				}
			}
			tickDO.setId_scsrv(ticksDO.getId_scsrv());
			// tickDO.setEu_usescope(EuUseScope.APT);//使用范围,默认开放
			tickDO.setFg_active(FBoolean.TRUE);
			tickDO.setEu_used(0);
			tickDO.setEu_add(0);// 加号标识
			if (!isHasWkTick) {
				schTickList.add(tickDO);
			}
			// 排班服务类别明细
			tickDO.setIds_kinditm(ticksDO.getIds_kinditm());
		}
		if (!isHasWkTick) {
			setTickUseScope(schTickList, sd_schrule, ticksDO.getQuecn_appt());
		}
		return schTickList;
	}

	/**
	 * 设置号段的号位
	 * 
	 * @param plWeekId
	 * @param schID
	 * @param ticksId
	 * @throws BizException
	 */
	private List<ScSchTickDO> setTickDOsWithWkTick(ScPlanWeekDO scPlWkDO, String schID, String ticksId,
			ScPlanWeekTickDO[] wkTicks, ScPlanWeekTicksDO wkTicksDO) throws BizException {
		List<ScSchTickDO> tickList = new ArrayList<ScSchTickDO>();
		if (ArrayUtil.isEmpty(wkTicks))
			return null;
		// 根据周计划设置号位值
		for (ScPlanWeekTickDO wkTickDO : wkTicks) {
			if (wkTicksDO.getId_ticks().equals(wkTickDO.getId_scplweekticks())) {
				ScSchTickDO tickDO = new ScSchTickDO();
				this.setTickValue(tickDO, wkTickDO, schID, ticksId,wkTicksDO);
				tickList.add(tickDO);
			}
		}
		return tickList;
	}

	/**
	 * 设置使用范围
	 * 
	 * @param tickDOList 号位集合
	 * @param sdApptRule 预约规则
	 * @param aptAmt 开放数
	 */
	private void setTickUseScope(List<ScSchTickDO> tickDOList, String sdApptRule, Integer aptAmt) {
		if (ListUtil.isEmpty(tickDOList)) {
			return;
		}

		int currentAmt = 0;
		for (int i = 0; i < tickDOList.size(); i++) {
			ScSchTickDO tickDO = tickDOList.get(i);
			boolean isapt = this.isApt(sdApptRule, tickDO.getQueno(), currentAmt < aptAmt);
			if (isapt) {
				tickDO.setEu_usescope(EuUseScope.APT);// 开放
				currentAmt++;
			} else {
				tickDO.setEu_usescope(EuUseScope.REG);// 保留
			}
		}
		// 如果预约数不足
		if (currentAmt < aptAmt) {
			for (ScSchTickDO tickDO : tickDOList) {
				if (currentAmt >= aptAmt) {
					break;
				}
				if (tickDO.getEu_usescope() == null || EuUseScope.REG.equals(tickDO.getEu_usescope())) {
					tickDO.setEu_usescope(EuUseScope.APT);
					currentAmt++;
				}
			}
		}
	}

	/**
	 * 是否预约
	 * 
	 * @param tickDO
	 * @param index
	 * @param apptRuleCode
	 */
	private boolean isApt(String apptRuleCode, Integer index, boolean notEnough) {
		boolean isOpen = false;
		switch (apptRuleCode) {
		case IScDictCodeConst.SCSCH_RULE_EVEN:
			isOpen = IntegerUtils.isEven(index) && notEnough;
			break;
		case IScDictCodeConst.SCSCH_RULE_ODD:
			isOpen = IntegerUtils.isOdd(index) && notEnough;
			break;
		case IScDictCodeConst.SCSCH_RULE_ALL:
			isOpen = true && notEnough;
			break;
		default:
			isOpen = false;// 默认开放
			break;
		}
		return isOpen;
	}

	/**
	 * 生成号位
	 * 
	 * @param schID 排班ID
	 * @param weekPlTickDOs 周计划号位
	 * @return
	 * @throws BizException
	 */
	private List<ScSchTickDO> genSchTickDOList(String schID, ScPlanWeekTickDO[] weekPlTickDOs) throws BizException {
		List<ScSchTickDO> tickDOList = new ArrayList<ScSchTickDO>();
		for (ScPlanWeekTickDO wkPlTickDO : weekPlTickDOs) {
			ScSchTickDO tickDO = genTickDO(schID, wkPlTickDO);
			tickDOList.add(tickDO);
		}
		return tickDOList;
	}

	/**
	 * 周计划号位生成排班号位
	 * 
	 * @param schID 排班ID
	 * @param wkPlTickDO 周计划号位
	 * @return
	 */
	private ScSchTickDO genTickDO(String schID, ScPlanWeekTickDO wkPlTickDO) {
		ScSchTickDO tickDO = new ScSchTickDO();
		tickDO.setStatus(DOStatus.NEW);
		tickDO.setId_grp(ScContextUtils.getGrpId());// 集团
		tickDO.setId_org(ScContextUtils.getOrgId());// 组织
		tickDO.setId_sch(schID);// 排班ID
		tickDO.setId_ticks(null);// 号段ID
		tickDO.setCode(wkPlTickDO.getCode());
		tickDO.setName(wkPlTickDO.getName());
		tickDO.setQueno(wkPlTickDO.getQueno());// 号位
		tickDO.setT_b(wkPlTickDO.getT_b());// 开始时间
		tickDO.setT_e(wkPlTickDO.getT_e());// 结束时间
		tickDO.setId_scsrv(wkPlTickDO.getId_scsrv());// 指定服务
		tickDO.setEu_usescope(wkPlTickDO.getEu_usescope());// 使用范围
		tickDO.setEu_used(EuUseState.WY);// 未使用
		tickDO.setEu_add(EuAddTickMod.ZCH);// 正常号
		tickDO.setFg_active(wkPlTickDO.getFg_active());
		tickDO.setIds_scchl(wkPlTickDO.getIds_scchl());
		tickDO.setPolno(wkPlTickDO.getPolno());
		// 排班服务类别细目
		tickDO.setIds_kinditm(wkPlTickDO.getIds_kinditm());
		return tickDO;
	}

	/**
	 * 获取计划的所有周计划
	 * 
	 * @param planId 计划ID
	 * @return
	 * @throws BizException
	 */
	private ScplweekAggDO[] getWeekPlanList(String planId) throws BizException {
		IScplweekRService weekPlRService = ServiceFinder.find(IScplweekRService.class);
		String whereStr = String.format("Id_scpl='%s'", planId);
		return weekPlRService.find(whereStr, null, FBoolean.FALSE);
	}

	/**
	 * 获取周计划号段
	 * 
	 * @param weekPlanId 周计划ID
	 * @return 号位集合
	 * @throws BizException
	 */
	private ScPlanWeekTicksDO[] getPlanTicksList(String weekPlanId) throws BizException {
		IScplticksRService ticksRService = ServiceFinder.find(IScplticksRService.class);
		return ticksRService.find("Id_scplweek ='"+weekPlanId+"'", "t_b", FBoolean.FALSE);
	}

	/**
	 * 获取周计划号位
	 * 
	 * @param weekPlanId 周计划ID
	 * @return 号位集合
	 * @throws BizException
	 */
	private ScPlanWeekTickDO[] getPlanTickList(String weekPlanId) throws BizException {
		IScpltickRService tickRService = ServiceFinder.find(IScpltickRService.class);
		return tickRService.find("Id_scplweek ='"+weekPlanId+"'", "to_number(queno)", FBoolean.FALSE);
	}

	/**
	 * 处理生成号位信息
	 * 
	 * @param weekPlanDO
	 * @param schDO
	 * @param result
	 * @throws BizException
	 */
	private List<ScSchTickDO> processTickDO(ScPlanWeekDO weekPlanDO, ScSchDO schDO, PlanGenResult result)
			throws BizException {
		// 号位模式，生成号位信息
		ScPlanWeekTickDO[] weekPlTickDOs = this.getPlanTickList(weekPlanDO.getId_scplweek());
		return this.genSchTickDOList(schDO.getId_sch(), weekPlTickDOs);

	}

	/**
	 * 处理周计划
	 * 
	 * @param planId 排班ID
	 * @param weekAggDOs 周计划Agg
	 * @return
	 */
	private Map<String, List<ScplweekAggDO>> processWeekPlan(String planId, ScplweekAggDO[] weekAggDOs) {
		Map<String, List<ScplweekAggDO>> weekPlanMap = new HashMap<String, List<ScplweekAggDO>>();
		for (ScplweekAggDO weekPlanAggDO : weekAggDOs) {
			String key = this.wrapWeekPlKey(weekPlanAggDO.getParentDO());
			List<ScplweekAggDO> weekPlList = weekPlanMap.get(key);
			if (weekPlList == null) {
				weekPlList = new ArrayList<ScplweekAggDO>();
				weekPlanMap.put(key, weekPlList);
			}
			weekPlList.add(weekPlanAggDO);
		}
		return weekPlanMap;
	}

	/**
	 * 包装周计划的key
	 * 
	 * @param weekPlanDO 周计划DO
	 * @return
	 */
	private String wrapWeekPlKey(ScPlanWeekDO weekPlanDO) {
		return this.wrapKey(weekPlanDO.getId_scpl(), weekPlanDO.getIdx_week(), weekPlanDO.getWeekno());
	}

	/**
	 * 包装生成模板的ID
	 * 
	 * @param planId 排班计划ID
	 * @param tplDTO 排班模板DTO
	 * @return
	 */
	private String wrapSchTplKey(String planId, OpSchTplDTO tplDTO) {
		FDate schDate = tplDTO.getSch_date() == null ? tplDTO.getDate() : tplDTO.getSch_date();
		int weekNo = schDate.getWeek() == 0 ? 7 : schDate.getWeek();
		return this.wrapKey(planId, tplDTO.getWeek_index(), weekNo);
	}

	/**
	 * 包装可以
	 * 
	 * @param planId
	 * @param weekIndex
	 * @param weekNo
	 * @return
	 */
	private String wrapKey(String planId, Integer weekIndex, Integer weekNo) {
		return String.format("%s,%s,%s", planId, weekIndex, weekNo);
	}

	/**
	 * 根据票号设置号位的值
	 * 
	 * @param tickDO
	 * @param wkTickDO
	 * @param schID
	 * @param ticksId
	 */
	private void setTickValue(ScSchTickDO tickDO, ScPlanWeekTickDO wkTickDO, String schID, String ticksId,ScPlanWeekTicksDO wkTicksDO) {
		tickDO.setStatus(DOStatus.NEW);
		tickDO.setId_grp(ScContextUtils.getGrpId());
		tickDO.setId_org(ScContextUtils.getOrgId());
		tickDO.setId_sch(schID);
		tickDO.setId_ticks(ticksId);
		tickDO.setCode(wkTickDO.getCode());
		tickDO.setName(wkTickDO.getName());
		tickDO.setQueno(wkTickDO.getQueno());
		tickDO.setT_b(wkTickDO.getT_b());
		tickDO.setT_e(wkTickDO.getT_e());
		tickDO.setId_scsrv(wkTickDO.getId_scsrv());
		tickDO.setEu_usescope(wkTickDO.getEu_usescope());
		tickDO.setFg_active(wkTickDO.getFg_active());
		tickDO.setEu_used(0);
		tickDO.setEu_add(0);// 加号标识
		tickDO.setIds_scchl(wkTickDO.getIds_scchl());// 号位指定渠道
		tickDO.setPolno(wkTickDO.getPolno());
		tickDO.setIds_kinditm(wkTicksDO.getIds_kinditm());
	}

	/**
	 * 获取预约规则
	 * 
	 * @param apprule
	 * @return
	 * @throws BizException
	 */
	private String getSdApprule(String apprule) throws BizException {
		IScapptruleRService rservice = ServiceFinder.find(IScapptruleRService.class);
		ScapptruleDO ruleDO = rservice.findById(apprule);
		if (ruleDO == null || StringUtil.isEmptyWithTrim(ruleDO.getSd_schrule())) {
			throw new BizException("未取到对应的规则");
		}
		return ruleDO.getSd_schrule();
	}

}
