package iih.sc.sch.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.i.IScBdQryService;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDsDO;
import iih.sc.scbd.scheduleca.d.ScheduleCADO;
import iih.sc.sch.dto.d.MtSchDTO;
import iih.sc.sch.s.ep.SchBdEP;
import iih.sc.sch.s.ep.SchEP;
import iih.sc.sch.s.ep.SchPlEP;
import iih.sc.sch.s.ep.TicksEP;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.d.ScSchEmpDO;
import iih.sc.sch.scsch.d.ScSchEnDO;
import iih.sc.sch.scsch.d.ScSchOptsrvDO;
import iih.sc.sch.scsch.d.ScschAggDO;
import iih.sc.sch.scsch.i.IScschMDORService;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplan.i.IScplanCudService;
import iih.sc.scp.scplan.i.IScplanRService;
import iih.sc.scp.scploptsrv.d.ScPlOptSrvDO;
import iih.sc.scp.scploptsrv.i.IScploptsrvRService;
import iih.sc.scp.scpltick.d.ScPlanWeekTickDO;
import iih.sc.scp.scpltick.d.desc.ScPlanWeekTickDODesc;
import iih.sc.scp.scpltick.i.IScpltickRService;
import iih.sc.scp.scplticks.d.ScPlanWeekTicksDO;
import iih.sc.scp.scplticks.i.IScplticksRService;
import iih.sc.scp.scplweek.d.ScPlanWeekChlDO;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;
import iih.sc.scp.scplweek.d.ScPlanWeekEmpDO;
import iih.sc.scp.scplweek.d.ScPlanWeekEnDO;
import iih.sc.scp.scplweek.d.ScplweekAggDO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
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
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 保存排班信息
 * 
 * @author renying
 */
public class SaveMtSchBP {
	/**
	 * 保存医技排班信息
	 * 
	 * @param mtschdto
	 * @return
	 * @throws BizException
	 */
	public String exec(MtSchDTO[] mtschdtos, Boolean fg_cover, FDate dt_b, FDate dt_e, String tp, String depId)
			throws BizException {
		// 1.校验参数
		if (ArrayUtil.isEmpty(mtschdtos))
			return null;
		ScValidator.validateParam("fg_cover", fg_cover);
		FDateTime serverDateTime = ScAppUtils.getServerDateTime();
		FDate now = serverDateTime.getDate();
		String id_scpl = mtschdtos[0].getId_scpl();// 计划id
		// 2.需要排班的日期
		List<String> dateList = new ArrayList<String>();
		// 3.获取获取需要排班的日期
		dateList = this.GetDateList(mtschdtos);
		// 4.获取对应的参数
		ScDeptParamDsDO[] dsDOs = this.getScDeptParam(depId, tp);
		// 5.需要排除的日期 和 删除数据
		List<ScSchDO> exceptionDataList = this.delSch(mtschdtos, fg_cover, dateList, tp, dsDOs, serverDateTime);

		// 6. 定义 集合数据
		// 号段list
		List<ScSchTicksDO> ticksList = new ArrayList<ScSchTicksDO>();
		// 号位list
		List<ScSchTickDO> tickList = new ArrayList<ScSchTickDO>();
		Map<String, ScplweekAggDO> plWeekAggMap = new HashMap<String, ScplweekAggDO>();// 周计划
		Map<String, List<ScPlanWeekTickDO>> wkTickMap = new HashMap<String, List<ScPlanWeekTickDO>>();// 计划号位
		Map<String, List<ScPlanWeekTicksDO>> wkTicksMap = new HashMap<String, List<ScPlanWeekTicksDO>>();// 计划号段
		Map<String, List<ScPlanDO>> pldoMap = new HashMap<String, List<ScPlanDO>>();// 计划do

		// 7。查出来所有的周计划
		this.getSchPlWkMap(mtschdtos, plWeekAggMap, wkTickMap, wkTicksMap, pldoMap);
		// 8。创建排班do
		this.SaveSch(mtschdtos, plWeekAggMap, ticksList, tickList, tp, exceptionDataList, now, dsDOs, wkTickMap,
				wkTicksMap, pldoMap);
		// 9.保存号位号段信息
		this.SaveTickDO(tickList, ticksList, wkTickMap, wkTicksMap);
		// 10. 更新计划中最大排班日期 dt_last_sch
		this.updateScPlDatelastSch(id_scpl, dt_e);
		return this.getDate(exceptionDataList, dsDOs, now);
	}

	/**
	 * 更新排班计划 d_last_sch
	 * 
	 * @param id_scpl
	 *            计划id
	 * @param dt_e
	 *            生成排班结束日期
	 * @throws BizException
	 */
	private void updateScPlDatelastSch(String id_scpl, FDate dt_e) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_scpl) || dt_e == null) {
			return;
		}
		IScplanRService planRService = ServiceFinder.find(IScplanRService.class);
		ScPlanDO scPlanDO = planRService.findById(id_scpl);

		IScschMDORService schRService = ServiceFinder.find(IScschMDORService.class);
		String cond = " id_scpl = '" + id_scpl + "'";
		ScSchDO[] schDOs = schRService.find(cond, " D_SCH DESC", FBoolean.FALSE);
		FDate d_last_sch = dt_e;
		if (!ArrayUtil.isEmpty(schDOs)) {
			FDate d_max_sch = schDOs[0].getD_sch();
			if (d_last_sch.compareTo(d_max_sch) < 0)
				d_last_sch = d_max_sch;
		}
		if (scPlanDO != null) {
			scPlanDO.setStatus(DOStatus.UPDATED);
			scPlanDO.setD_last_sch(d_last_sch);
			ServiceFinder.find(IScplanCudService.class).save(new ScPlanDO[] { scPlanDO });
		}
	}

	/**
	 * 3.获取需要排班的日期
	 * 
	 * @param mtschdtos
	 * @return
	 */
	private List<String> GetDateList(MtSchDTO[] mtschdtos) {
		List<String> dateList = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (MtSchDTO mtschDTO : mtschdtos) {
			String str = sdf.format(mtschDTO.getDt_date().toDate());
			dateList.add(str);
		}
		return dateList;
	}

	/**
	 * 6。 覆盖的前提下删除没有使用的排班 返回不能删除的排班
	 * 
	 * @param mtschdtos
	 * @param fg_cover
	 * @param dt_b
	 * @param dt_e
	 * @return 需要保留的排班（已经过期的，已经使用的）
	 * @throws BizException
	 */
	private List<ScSchDO> delSch(MtSchDTO[] mtschdtos, Boolean fg_cover, List<String> dateList, String tp,
			ScDeptParamDsDO[] dsDOs, FDateTime now) throws BizException {
		if (dateList.size() == 0)
			return null;

		SchEP schep = new SchEP();
		ScschAggDO[] schAggs = schep.getSchs(dateList, mtschdtos[0].getId_scpl(), tp);
		if (ArrayUtil.isEmpty(schAggs))
			return null;
		// 已经被占用不能新建 ，需要从新建数组中移除的list
		List<ScSchDO> exceptionData = new ArrayList<ScSchDO>();
		// 已经生成的，需要被覆盖的排班
		List<ScschAggDO> delList = new ArrayList<ScschAggDO>();
		List<String> schIdList = new ArrayList<String>();
		for (ScschAggDO aggdo : schAggs) {
			if (now.getBeginDate().toString().equals(aggdo.getParentDO().getD_sch().toString())) {
				if (!this.isNotPast(aggdo.getParentDO().getId_dayslot(), dsDOs)) {
					exceptionData.add(aggdo.getParentDO());
				}
			}

			ScSchDO schDo = aggdo.getParentDO();
			// 已经使用 或者 不覆盖 的情况下 排除的DO
			if (schDo.getQuan_total_used() != 0 || !fg_cover) {
				if (!exceptionData.contains(aggdo.getParent())) {
					exceptionData.add(((ScSchDO) aggdo.getParent()));
				}
			} else {
				if(now.getBeginDate().compareTo(schDo.getD_sch()) == 0){
					if(this.isNotPast(aggdo.getParentDO().getId_dayslot(), dsDOs)){
				delList.add(aggdo);
				schIdList.add(aggdo.getParentDO().getId_sch());
			}
				}else{
					delList.add(aggdo);
					schIdList.add(aggdo.getParentDO().getId_sch());
				}
			}
		}
		if (fg_cover && !ListUtil.isEmpty(delList)) {
			schep.delSchs(delList);// 删除排班
			TicksEP tickep = new TicksEP();// 删除号位号段
			tickep.deleteTicksBySchIds(schIdList);
		}
		return exceptionData;
	}

	/**
	 * 4.获取所有周计划的map 主键为周计划的主键
	 * 
	 * @param schPlWkIds
	 * @return
	 * @throws BizException
	 */
	private void getSchPlWkMap(MtSchDTO[] newMtsch, Map<String, ScplweekAggDO> plWeekAggMap,
			Map<String, List<ScPlanWeekTickDO>> wktickMap, Map<String, List<ScPlanWeekTicksDO>> wkticksMap,
			Map<String, List<ScPlanDO>> pldoMap) throws BizException {
		List<String> plweekList = new ArrayList<String>();
		List<String> plList = new ArrayList<String>();
		ScplweekAggDO[] scPlWkAggs = this.getSvPls(newMtsch, plweekList, plList);
		if (ArrayUtil.isEmpty(scPlWkAggs))
			return;
		for (ScplweekAggDO aggdo : scPlWkAggs) {
			if (plWeekAggMap.containsKey(aggdo.getParentDO().getId_scplweek())) {
				continue;
			}
			plWeekAggMap.put(aggdo.getParentDO().getId_scplweek(), aggdo);
		}
		this.GetPl(plList, pldoMap);
		this.GetwkTick(plweekList, wktickMap);
		this.GetwkTicks(plweekList, wkticksMap);

	}

	/**
	 * 查找dto对应的周计划do
	 * 
	 * @param newMtsch
	 * @return
	 * @throws BizException
	 */
	private ScplweekAggDO[] getSvPls(MtSchDTO[] newMtsch, List<String> plweekList, List<String> wkplList)
			throws BizException {
		// 周计划idlist
		List<String> wkIds = new ArrayList<String>();
		for (MtSchDTO meschDTO : newMtsch) {
			if (ListUtil.isEmpty(meschDTO.getPlweeks())) {
				continue;
			}
			for (Object plwk : (meschDTO.getPlweeks())) {
				wkIds.add(((ScPlanWeekDO) plwk).getId_scplweek().toString());
				for (Object wkid : wkIds) {
					if (!plweekList.contains(wkid)) {
						plweekList.add(wkid.toString());
					}

				}
			}
		}
		String[] schPlWkIds = wkIds.toArray(new String[] {});
		if (ArrayUtil.isEmpty(schPlWkIds)) {
			return null;
		}
		SchPlEP schPlep = new SchPlEP();
		ScplweekAggDO[] scPlWkAggs = schPlep.getPlWeekById(schPlWkIds);
		if (ArrayUtil.isEmpty(scPlWkAggs)) {
			throw new BizException("未检索到周计划");
		}

		for (ScplweekAggDO aggDO : scPlWkAggs) {
			wkplList.add(((ScPlanWeekDO) aggDO.getParent()).getId_scpl());
		}
		return scPlWkAggs;
	}

	/**
	 * 5.保存排班数据
	 * 
	 * @param newMtsch
	 * @param wkAggMap
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private ScschAggDO[] SaveSch(MtSchDTO[] newMtsch, Map<String, ScplweekAggDO> wkAggMap,
			List<ScSchTicksDO> schTicksList, List<ScSchTickDO> schTickList, String tp, List<ScSchDO> exceptionDataList,
			FDate now, ScDeptParamDsDO[] dsDOs, Map<String, List<ScPlanWeekTickDO>> wktickMap,
			Map<String, List<ScPlanWeekTicksDO>> wkticksMap, Map<String, List<ScPlanDO>> pldoMap) throws BizException {

		List<ScschAggDO> aggList = new ArrayList<ScschAggDO>();
		// 保存agg
		for (MtSchDTO meschDTO : newMtsch) {

			if (ListUtil.isEmpty(meschDTO.getPlweeks())) {
				continue;
			}
			for (Object plwk : meschDTO.getPlweeks()) {
				ScplweekAggDO wkPlAgg = wkAggMap.get(((ScPlanWeekDO) plwk).getId_scplweek());
				ScschAggDO aggdo = this.setNewSchDO(wkPlAgg, meschDTO.getDt_date(), schTickList, schTicksList, tp,
						exceptionDataList, now, dsDOs, wktickMap, wkticksMap, pldoMap);
				if (aggdo != null) {
					aggList.add(aggdo);
				}
			}
		}
		SchEP schEP = new SchEP();
		if (ListUtil.isEmpty(aggList)) {
			return null;
		}
		ScschAggDO[] aggdos = schEP.saveSchAggs(aggList);

		return aggdos;
	}

	/**
	 * 获取计划
	 * 
	 * @param plList
	 * @param pldoMap
	 * @throws BizException
	 */
	private void GetPl(List<String> plList, Map<String, List<ScPlanDO>> pldoMap) throws BizException {
		SchPlEP scplep = new SchPlEP();
		ScPlanDO[] scPlanDO = scplep.getScPls(plList);
		for (ScPlanDO scplDO : scPlanDO) {
			if (pldoMap.containsKey(scplDO.getId_scpl())) {
				pldoMap.get((scplDO.getId_scpl())).add(scplDO);
				continue;
			}
			List<ScPlanDO> list = new ArrayList<ScPlanDO>();
			list.add(scplDO);
			pldoMap.put(scplDO.getId_scpl(), list);
		}
	}

	/**
	 * 获取周计划号位
	 * 
	 * @param plweekList
	 * @param tickMap
	 * @throws BizException
	 */
	private void GetwkTick(List<String> plweekList, Map<String, List<ScPlanWeekTickDO>> tickMap) throws BizException {

		String str = ScSqlUtils.buildIdStr(plweekList);
		IScpltickRService rService = ServiceFinder.find(IScpltickRService.class);
		ScPlanWeekTickDO[] scPlWks = rService
				.find(ScPlanWeekTickDODesc.TABLE_ALIAS_NAME + ".id_scplweek in(" + str + ")", "queno", FBoolean.FALSE);

		for (ScPlanWeekTickDO wktickDO : scPlWks) {
			if (tickMap.containsKey(wktickDO.getId_scplweek())) {
				tickMap.get((wktickDO.getId_scplweek())).add(wktickDO);
				continue;
			}
			List<ScPlanWeekTickDO> list = new ArrayList<ScPlanWeekTickDO>();
			list.add(wktickDO);
			tickMap.put(wktickDO.getId_scplweek(), list);
		}
	}

	/**
	 * 获取周计划号段
	 * 
	 * @param plweekList
	 * @param tickMap
	 * @throws BizException
	 */
	private void GetwkTicks(List<String> plweekList, Map<String, List<ScPlanWeekTicksDO>> tickMap) throws BizException {

		String str = ScSqlUtils.buildIdStr(plweekList);
		IScplticksRService rService = ServiceFinder.find(IScplticksRService.class);
		ScPlanWeekTicksDO[] scPlWks = rService
				.find(ScPlanWeekTickDODesc.TABLE_ALIAS_NAME + ".id_scplweek in(" + str + ")", "", FBoolean.FALSE);

		for (ScPlanWeekTicksDO wkticksDO : scPlWks) {
			if (tickMap.containsKey(wkticksDO.getId_scplweek())) {
				tickMap.get((wkticksDO.getId_scplweek())).add(wkticksDO);
				continue;
			}
			List<ScPlanWeekTicksDO> list = new ArrayList<ScPlanWeekTicksDO>();
			list.add(wkticksDO);
			tickMap.put(wkticksDO.getId_scplweek(), list);
		}
	}

	/**
	 * 根据周计划生成排班
	 * 
	 * @param wkAggDO
	 * @throws BizException
	 */
	private ScschAggDO setNewSchDO(ScplweekAggDO wkAggDO, FDate fdate, List<ScSchTickDO> tickList,
			List<ScSchTicksDO> ticksList, String tp, List<ScSchDO> exceptionDataList, FDate now,
			ScDeptParamDsDO[] dsDOs, Map<String, List<ScPlanWeekTickDO>> tickMap,
			Map<String, List<ScPlanWeekTicksDO>> ticksMap, Map<String, List<ScPlanDO>> pldoMap) throws BizException {
		if (this.IsExceptions(wkAggDO, fdate, exceptionDataList)) {
			return null;
		}
		ScPlanWeekDO scPlWkDO = wkAggDO.getParentDO();
		FDateTime entdt = new FDateTime(fdate, scPlWkDO.getT_e_acpt());
		FDateTime begdt = new FDateTime(fdate, scPlWkDO.getT_b_acpt());
		// 结束时间小于当前时间时且开始时间小于结束时间,不生成排班,当开始时间大于结束时间则排班跨天应该生成
		if (ScAppUtils.getServerDateTime().compareTo(entdt) > 0 && entdt.compareTo(begdt) > 0) {
			return null;
		}
		ScschAggDO schAgg = new ScschAggDO();
		// 1 。创建排班do
		schAgg.setParent(this.setSchDO(wkAggDO, fdate, tickList, ticksList, tp, tickMap, ticksMap));
		// 2。创建排班渠道
		schAgg.setScSchChlDO(this.setSchChl(wkAggDO));
		// 3。创建排班就诊
		schAgg.setScSchEnDO(this.setScSchEnDO(wkAggDO));
		// 4 。创建排班人员
		schAgg.setScSchEmpDO(this.setEmpDOs(wkAggDO));
		// 5.  创建排班备用服务
		schAgg.setScSchOptsrvDO(this.setOptsrvDOs(wkAggDO));
		return schAgg;
	}

	/**
	 * 是不是需要排除的do（今天：已经过去的， 已经使用的 不是今天：有排班，已经使用）
	 * 
	 * @param wkAggDO
	 * @param fdate
	 * @param exceptionDataList
	 * @return
	 */
	private boolean IsExceptions(ScplweekAggDO wkAggDO, FDate fdate, List<ScSchDO> exceptionDataList) {
		if (exceptionDataList == null)
			return false;
		for (ScSchDO schDO : exceptionDataList) {
			if (schDO.getD_sch().toString().equals(fdate.toString())
					&& wkAggDO.getParentDO().getId_dayslot().equals(schDO.getId_dayslot())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 创建排班id
	 * 
	 * @param wkAggDO
	 * @param fdate
	 * @param daysLotId
	 * @throws BizException
	 */
	private ScSchDO setSchDO(ScplweekAggDO wkAggDO, FDate fdate, List<ScSchTickDO> schTickList,
			List<ScSchTicksDO> schTicksList, String tp, Map<String, List<ScPlanWeekTickDO>> wkTickMap,
			Map<String, List<ScPlanWeekTicksDO>> wkTicksMap) throws BizException {
		ScSchDO schdo = new ScSchDO();
		schdo.setStatus(DOStatus.NEW);
		ScPlanWeekDO scPlWkDO = wkAggDO.getParentDO();
		SchPlEP schPlEP = new SchPlEP();
		ScPlanDO scPlanDO = schPlEP.getScPl(scPlWkDO.getId_scpl());
		SchBdEP bdEp = new SchBdEP();
		ScheduleCADO[] caDos = bdEp.getSchEduleCaDOs(tp);
		if (ArrayUtil.isEmpty(caDos)) {
			String nameSctp = this.getSdSctp(tp);
			throw new BizException(String.format("未查到[%s]排班分类！", nameSctp));
		}
		DBUtil dbUtil = new DBUtil();
		schdo.setId_sch(dbUtil.getOIDs(1)[0]);
		schdo.setId_scpl(scPlWkDO.getId_scpl());
		schdo.setId_org(ScContextUtils.getOrgId());// 机构
		schdo.setId_grp(ScContextUtils.getGrpId());// 集团
        schdo.setSd_sctp(scPlanDO.getSd_sctp());// 排班类型
	    schdo.setId_sctp(scPlanDO.getId_sctp());

		// schdo.setId_scca(caDos[0].getId_scca());// 排班分类
	    schdo.setId_scca(scPlanDO.getId_scca());// 排班分类
		schdo.setD_sch(fdate);// 排班日期
		schdo.setId_dayslot(scPlWkDO.getId_dayslot());// 午别
		schdo.setMax_num_add(scPlWkDO.getMax_num_add() == null ? 0 : scPlWkDO.getMax_num_add());
		schdo.setScpolcn(scPlWkDO.getScpolcn());// 号源池总数
		schdo.setSd_tickmd(scPlanDO.getSd_tickmd());// 票号模式
		schdo.setId_tickmd(scPlanDO.getId_tickmd());
		schdo.setId_apptru(scPlanDO.getId_apptru());// 预约规则
		schdo.setQuan_total(scPlWkDO.getQuan_total());// 总数
		schdo.setQuan_total_appt(scPlWkDO.getQuan_total_appt());// 可预约
		schdo.setQuan_total_used(0);// 已使用
		schdo.setAddquecn(0);// 已加号数量
		schdo.setT_b_acpt(scPlWkDO.getT_b_acpt());// 开始就诊时间
		schdo.setT_e_acpt(scPlWkDO.getT_e_acpt());// 结束就诊时间
		schdo.setFg_std_acpt(scPlWkDO.getFg_std_acpt());// 是否标准就诊时长
		schdo.setSrvslot(scPlWkDO.getSrvslot());// 单个服务时间
		schdo.setFg_active(scPlanDO.getFg_active());
		schdo.setSugest_exmint(scPlWkDO.getSugest_exmint());// 推荐提前报到时间
		schdo.setSugest_num_mint(scPlWkDO.getSugest_num_mint());// 分钟数
		schdo.setSugest_num_tick(scPlWkDO.getSugest_num_tick());// 号数
		schdo.setT_e_reg(scPlWkDO.getT_e_reg());
		schdo.setFg_active(FBoolean.TRUE);
		schdo.setQuan0_appt(scPlWkDO.getQuan0_appt() == null ? 0 : scPlWkDO.getQuan0_appt());
		schdo.setQuan1_appt(scPlWkDO.getQuan1_appt() == null ? 0 : scPlWkDO.getQuan1_appt());
		schdo.setQuan2_appt(scPlWkDO.getQuan2_appt() == null ? 0 : scPlWkDO.getQuan2_appt());
		schdo.setQuan3_appt(scPlWkDO.getQuan3_appt() == null ? 0 : scPlWkDO.getQuan3_appt());
		schdo.setQuan4_appt(scPlWkDO.getQuan4_appt() == null ? 0 : scPlWkDO.getQuan4_appt());
		schdo.setQuan5_appt(scPlWkDO.getQuan5_appt() == null ? 0 : scPlWkDO.getQuan5_appt());
		schdo.setQuan6_appt(scPlWkDO.getQuan6_appt() == null ? 0 : scPlWkDO.getQuan6_appt());
		schdo.setQuan7_appt(scPlWkDO.getQuan7_appt() == null ? 0 : scPlWkDO.getQuan7_appt());
		schdo.setQuan8_appt(scPlWkDO.getQuan8_appt() == null ? 0 : scPlWkDO.getQuan8_appt());
		schdo.setQuan9_appt(scPlWkDO.getQuan9_appt() == null ? 0 : scPlWkDO.getQuan9_appt());
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
		schdo.setFg_auto_release(scPlWkDO.getFg_auto_release());
		// 就诊类型
		schdo.setFg_setentp(scPlWkDO.getFg_setentp());
		// 设置是否允许自动预约
		schdo.setFg_auto_apt(scPlWkDO.getFg_auto_apt());
		// 设置排班号段号位信息
		this.setSchTicksAndTickInfo(schdo, schTickList, schTicksList, scPlWkDO, wkTickMap, wkTicksMap);
		return schdo;
	}
	/**
	 * 根据sd获取排班类型名称
	 * @param tp
	 * @return
	 */
	private String getSdSctp(String tp){
		String str = "";
		if(StringUtil.isEmptyWithTrim(tp)) return str;
		switch (tp) {
		case IScDictCodeConst.SD_SCTP_JZ:
			str = "急诊";
			break;
		case IScDictCodeConst.SD_SCTP_MT:
			str = "医技";
			break;
		case IScDictCodeConst.SD_SCTP_OP:
			str = "门诊";
			break;
		case IScDictCodeConst.SD_SCTP_OT:
			str = "手术";
			break;
		default:
			break;
		}
		return str;
	}
	/**
	 * 设置排班渠道
	 * 
	 * @param plWks
	 * @return
	 */
	private ScSchChlDO[] setSchChl(ScplweekAggDO wkAggDO) {
		ScPlanWeekChlDO[] plWks = wkAggDO.getScPlanWeekChlDO();
		if (ArrayUtil.isEmpty(plWks))
			return null;
		List<ScSchChlDO> choDos = new ArrayList<ScSchChlDO>();
		for (ScPlanWeekChlDO plwk : plWks) {
			ScSchChlDO chlDO = new ScSchChlDO();
			chlDO.setStatus(DOStatus.NEW);
			chlDO.setId_scchl(plwk.getId_scchl());
			chlDO.setScpolcn(plwk.getScpolcn());
			chlDO.setIds_dep_spec(plwk.getIds_dep_spec());
			chlDO.setIds_emp_spec(plwk.getIds_emp_spec());
			chlDO.setId_grp(ScContextUtils.getGrpId());
			chlDO.setId_org(ScContextUtils.getOrgId());
			chlDO.setFg_active(FBoolean.TRUE);// add by zhengcm 2017-09-28
			chlDO.setId_entp(plwk.getId_entp());// 就诊类型
			choDos.add(chlDO);
		}
		return choDos.toArray(new ScSchChlDO[] {});
	}

	/**
	 * 设置就诊
	 * 
	 * @param planEnDOs
	 * @return
	 */
	private ScSchEnDO[] setScSchEnDO(ScplweekAggDO wkAggDO) {
		ScPlanWeekEnDO[] planEnDOs = wkAggDO.getScPlanWeekEnDO();
		if (ArrayUtil.isEmpty(planEnDOs)) {
			return null;
		}
		List<ScSchEnDO> enDos = new ArrayList<ScSchEnDO>();
		for (ScPlanWeekEnDO enwk : planEnDOs) {
			ScSchEnDO enDO = new ScSchEnDO();
			enDO.setStatus(DOStatus.NEW);
			enDO.setId_entp(enwk.getId_entp());
			enDO.setSd_entp(enwk.getSd_entp());
			enDO.setScpolcn(enwk.getScpolcn());
			enDos.add(enDO);
		}
		return enDos.toArray(new ScSchEnDO[] {});
	}

	/**
	 * 设置排班人员
	 * 
	 * @param planEmpDOs
	 * @return
	 */
	private ScSchEmpDO[] setEmpDOs(ScplweekAggDO wkAggDO) {
		ScPlanWeekEmpDO[] planEmpDOs = wkAggDO.getScPlanWeekEmpDO();
		if (ArrayUtil.isEmpty(planEmpDOs))
			return null;
		List<ScSchEmpDO> list = new ArrayList<ScSchEmpDO>();
		for (ScPlanWeekEmpDO empDO : planEmpDOs) {
			ScSchEmpDO schEmp = new ScSchEmpDO();
			schEmp.setStatus(DOStatus.NEW);
			empDO.setId_emp(empDO.getId_emp());
			list.add(schEmp);
		}
		return list.toArray(new ScSchEmpDO[] {});
	}

	/**
	 * 设置排班备用服务
	 * 
	 * @param wkAggDO
	 * @return
	 * @throws BizException
	 */
	private ScSchOptsrvDO[] setOptsrvDOs(ScplweekAggDO wkAggDO) throws BizException {
		ScPlanWeekDO scPlWkDO = wkAggDO.getParentDO();
		IScploptsrvRService iscploptsrvrservice = ServiceFinder.find(IScploptsrvRService.class);
		ScPlOptSrvDO[] scploptsrvs = iscploptsrvrservice.find("id_scpl = '" + scPlWkDO.getId_scpl() + "'", null,
				FBoolean.FALSE);
		if (ArrayUtil.isEmpty(scploptsrvs)) {
			return null;
		}
		List<ScSchOptsrvDO> list = new ArrayList<ScSchOptsrvDO>();

		for (ScPlOptSrvDO scploptsrvdo : scploptsrvs) {
			ScSchOptsrvDO optsrvDO = new ScSchOptsrvDO();
			optsrvDO.setStatus(DOStatus.NEW);
			optsrvDO.setId_scsrv(scploptsrvdo.getId_scsrv());
			list.add(optsrvDO);
		}
		return list.toArray(new ScSchOptsrvDO[] {});
	}

	/**
	 * 设置排班号段号位信息
	 * 
	 * @param aggdo
	 * @param schTickList
	 * @param schTicksList
	 * @param plWeekId
	 * @throws BizException
	 */
	private void setSchTicksAndTickInfo(ScSchDO schdo, List<ScSchTickDO> schTickList, List<ScSchTicksDO> schTicksList,
			ScPlanWeekDO scPlWkDO, Map<String, List<ScPlanWeekTickDO>> wkTickMap,
			Map<String, List<ScPlanWeekTicksDO>> wkTicksMap) throws BizException {
		// 号段模式
		if (IScDictCodeConst.SD_TICKMD_TICKS.equals(schdo.getSd_tickmd())) {
			this.setTicksDO(scPlWkDO, schdo, schTickList, schTicksList, wkTicksMap, wkTickMap);
			return;
		}
		// 号位模式
		this.setTickDOs(scPlWkDO, schdo.getId_sch(), schTickList, wkTickMap);
	}

	/**
	 * 号位模式
	 * 
	 * @param plWeekId
	 * @param schID
	 * @param ticksId
	 * @throws BizException
	 */
	private void setTickDOs(ScPlanWeekDO scPlWkDO, String schID, List<ScSchTickDO> tickList,
			Map<String, List<ScPlanWeekTickDO>> tickMap) throws BizException {
		if (!tickMap.containsKey(scPlWkDO.getId_scplweek()))
			return;
		ScPlanWeekTickDO[] scPlWks = tickMap.get(scPlWkDO.getId_scplweek()).toArray(new ScPlanWeekTickDO[] {});
		if (ArrayUtil.isEmpty(scPlWks))
			return;
		// 根据周计划设置号位值
		for (ScPlanWeekTickDO wkTickDO : scPlWks) {
			ScSchTickDO tickDO = new ScSchTickDO();
			this.setTickValue(tickDO, wkTickDO, schID, null);
			tickList.add(tickDO);
		}
	}

	/**
	 * 设置号段信息
	 * 
	 * @param plWeekId
	 * @param schID
	 * @throws BizException
	 */
	private void setTicksDO(ScPlanWeekDO scPlWkDO, ScSchDO schdo, List<ScSchTickDO> tickList,
			List<ScSchTicksDO> ticksList, Map<String, List<ScPlanWeekTicksDO>> ticksMap,
			Map<String, List<ScPlanWeekTickDO>> tickMap) throws BizException {
		if (!ticksMap.containsKey(scPlWkDO.getId_scplweek()))
			return;
		ScPlanWeekTicksDO[] scPlWks = ticksMap.get(scPlWkDO.getId_scplweek()).toArray(new ScPlanWeekTicksDO[] {});
		if (ArrayUtil.isEmpty(scPlWks))
			return;

		for (ScPlanWeekTicksDO wkTicksDO : scPlWks) {
			ScSchTicksDO ticksDO = new ScSchTicksDO();
			ticksDO.setStatus(DOStatus.NEW);
			ticksDO.setId_grp(ScContextUtils.getGrpId());
			ticksDO.setId_org(ScContextUtils.getOrgId());
			ticksDO.setId_sch(schdo.getId_sch());
			ticksDO.setCode(wkTicksDO.getCode());
			ticksDO.setName(wkTicksDO.getName());
			ticksDO.setT_b(wkTicksDO.getT_b());
			ticksDO.setT_e(wkTicksDO.getT_e());
			ticksDO.setQueno_b(wkTicksDO.getQueno_b() == null ? 0 : wkTicksDO.getQueno_b());
			ticksDO.setQuecn(wkTicksDO.getQuecn());
			ticksDO.setQuecn_appt(wkTicksDO.getQuecn_appt());
			ticksDO.setQuecn_used(wkTicksDO.getQuecn_used());
			ticksDO.setId_scsrv(wkTicksDO.getId_scsrv());
			ticksDO.setFg_used(wkTicksDO.getFg_used());
			ticksDO.setFg_active(wkTicksDO.getFg_active());
			// 排班服务类别细目
			ticksDO.setIds_kinditm(wkTicksDO.getIds_kinditm());
			DBUtil dbUtil = new DBUtil();
			ticksDO.setId_ticks(dbUtil.getOIDs(1)[0]);

			this.setTickDOsWithTicks(scPlWkDO, schdo, ticksDO, tickList, tickMap, wkTicksDO);
			ticksList.add(ticksDO);
		}

	}

	/**
	 * 设置号段的号位
	 * 
	 * @param scPlWkDO
	 *            周计划do
	 * @param schdo
	 *            排班do
	 * @param schTicksDO
	 *            排班号段
	 * @param schTickList
	 *            排班号位
	 * @param wkTickMap
	 *            周计划号位
	 * @param wkTicksDO
	 *            周计划号段
	 * @throws BizException
	 */
	private void setTickDOsWithTicks(ScPlanWeekDO scPlWkDO, ScSchDO schdo, ScSchTicksDO schTicksDO,
			List<ScSchTickDO> schTickList, Map<String, List<ScPlanWeekTickDO>> wkTickMap, ScPlanWeekTicksDO wkTicksDO)
			throws BizException {
		SetTickDOBP scBp = new SetTickDOBP();
		List<ScSchTickDO> tickDOList = null;
		// 有计划的号位
		if (scPlWkDO.getFg_setscchl() != null && scPlWkDO.getFg_setscchl().booleanValue()) {
			tickDOList = this.setTickDOsWithWkTick(scPlWkDO, schdo.getId_sch(), wkTickMap, wkTicksDO);
			scBp.setTickValueWithPlTick(schTicksDO, schdo, tickDOList);
		} else {// 无计划的号位
			tickDOList = scBp.setTickDos(schTicksDO, schdo);
		}

		if (ListUtil.isEmpty(tickDOList))
			return;
		schTickList.addAll(tickDOList);
	}

	/**
	 * 设置号段的号位
	 * 
	 * @param plWeekId
	 * @param schID
	 * @param ticksId
	 * @throws BizException
	 */
	private List<ScSchTickDO> setTickDOsWithWkTick(ScPlanWeekDO scPlWkDO, String schID,
			Map<String, List<ScPlanWeekTickDO>> tickMap, ScPlanWeekTicksDO wkTicksDO) throws BizException {
		List<ScSchTickDO> tickList = new ArrayList<ScSchTickDO>();
		ScPlanWeekTickDO[] wkTickArray = tickMap.get(scPlWkDO.getId_scplweek()).toArray(new ScPlanWeekTickDO[] {});
		if (ArrayUtil.isEmpty(wkTickArray))
			return null;
		// 根据周计划设置号位值
		for (ScPlanWeekTickDO wkTickDO : wkTickArray) {
			if (wkTicksDO.getId_ticks().equals(wkTickDO.getId_scplweekticks())) {
				ScSchTickDO tickDO = new ScSchTickDO();
				this.setTickValue(tickDO, wkTickDO, schID, wkTicksDO);
				tickList.add(tickDO);
			}

		}
		return tickList;
	}

	/**
	 * 保存号位号段
	 * 
	 * @param tickList
	 * @param ticksList
	 * @throws BizException
	 */
	private void SaveTickDO(List<ScSchTickDO> tickList, List<ScSchTicksDO> ticksList,
			Map<String, List<ScPlanWeekTickDO>> tickMap, Map<String, List<ScPlanWeekTicksDO>> ticksMap)
			throws BizException {

		if (ListUtil.isEmpty(tickList))
			return;
		SchEP schep = new SchEP();

		if (!ticksList.isEmpty()) {
			schep.SaveSchTicks(ticksList.toArray(new ScSchTicksDO[] {}));
		}
		schep.SaveSchTick(tickList.toArray(new ScSchTickDO[] {}));

	}

	/**
	 * 设置返回的日期
	 * 
	 * @param dateList
	 * @return
	 * @throws BizException
	 */
	private String getDate(List<ScSchDO> dateList, ScDeptParamDsDO[] dsDOs, FDate now) throws BizException {
		if (ListUtil.isEmpty(dateList))
			return null;
		ArrayList<String> schDOList = new ArrayList<String>();
		for (ScSchDO schDo : dateList) {
			if (now.getDay() == schDo.getD_sch().getDay()) {
				if (!this.isNotPast(schDo.getId_dayslot(), dsDOs)) {
					continue;
				}
			}
			// 已经使用 + 不包含重复日期
			if (schDo.getQuan_total_used() != null && schDo.getQuan_total_used() != 0
					&& !schDOList.contains(schDo.getD_sch())) {
				schDOList.add(schDo.getName_dayslot() + "已经使用");
			}
		}
		if (schDOList.isEmpty())
			return null;
		Collections.sort(schDOList);

		return schDOList.toString();
	}

	/**
	 * 设置部门参数
	 * 
	 * @return
	 * @throws BizException
	 */
	private ScDeptParamDsDO[] getScDeptParam(String depId, String tp) throws BizException {

		IScBdQryService service = ServiceFinder.find(IScBdQryService.class);
		ScDeptParamDsDO[] scDeptParamDOs = service.getUsableDepParamDsDos(depId, tp);
		return scDeptParamDOs;
	}

	/**
	 * 判定当前给定的午别 是不是在可用的范围内
	 * 
	 * @param schDO
	 * @param scDeptParamDOs
	 * @return
	 * @throws BizException
	 */
	private boolean isNotPast(String dayslotId, ScDeptParamDsDO[] scDeptParamDOs) throws BizException {

		if (scDeptParamDOs == null || scDeptParamDOs.length == 0)
			return false;
		for (ScDeptParamDsDO dsDO : scDeptParamDOs) {
			if (dayslotId != null && dayslotId.equals(dsDO.getId_dayslot())) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 根据票号设置号位的值
	 * 
	 * @param tickDO
	 * @param wkTickDO
	 * @param schID
	 * @param ticksId
	 */
	private void setTickValue(ScSchTickDO tickDO, ScPlanWeekTickDO wkTickDO, String schID, ScPlanWeekTicksDO ticks) {
		tickDO.setStatus(DOStatus.NEW);
		tickDO.setId_grp(ScContextUtils.getGrpId());
		tickDO.setId_org(ScContextUtils.getOrgId());
		tickDO.setId_sch(schID);
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
		if (ticks != null) {
			tickDO.setId_ticks(ticks.getId_ticks());
			// 号段模式 排班服务类别明细
			tickDO.setIds_kinditm(ticks.getIds_kinditm());
		} else {

		// 排班服务类别细目
		tickDO.setIds_kinditm(wkTickDO.getIds_kinditm());
	}
	}
}
