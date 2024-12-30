package iih.sc.scp.s.bp;

import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scp.s.ep.OralScplEP;
import iih.sc.scp.scpltick.d.ScPlanWeekTickDO;
import iih.sc.scp.scplweek.d.ScPlanWeekChlDO;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;
import iih.sc.scp.scplweek.d.ScplweekAggDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;

/**
 * 根据口腔科排班计划获取口腔科排班周计划和备选服务BP
 * 
 * @author zhengcm
 * @date 2016-09-26 09:53:40
 *
 */
public class GetOralPlanWeekBP {

	/**
	 * 根据口腔科排班计划获取口腔科排班周计划和备选服务
	 *
	 * @param id_scpl 排班计划
	 * @return 排班周计划数据Map
	 * @throws BizException
	 * @author zhengcm
	 */
	public Map<String, Map<String, Object>> exec(String id_scpl) throws BizException {
		// 1、检查参数
		ScValidator.validateParam("id_scpl", id_scpl);

		// 返回的数据
		Map<String, Map<String, Object>> planWeekMap = new HashMap<String, Map<String, Object>>();
		// 排班计划号位
		Map<String, List<ScPlanWeekTickDO>> planWeekTickMap = new HashMap<String, List<ScPlanWeekTickDO>>();
		// 排班计划AggDO
		List<ScplweekAggDO> planWeekAggDOList = new ArrayList<ScplweekAggDO>();

		// 2、获取排班周计划数据
		planWeekAggDOList = this.getPlanWeekAggDO(id_scpl);

		// 3、获取排班周计划号位数据
		planWeekTickMap = this.getPlanWeekTickMap(planWeekAggDOList);

		// 4、处理排班周计划返回数据
		this.processPlanWeekData(planWeekAggDOList, planWeekTickMap, planWeekMap);

		return planWeekMap;
	}

	/**
	 * 获取排班周计划
	 *
	 * @param id_scpl 排班计划id
	 * @return 排班周计划AggDO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private List<ScplweekAggDO> getPlanWeekAggDO(String id_scpl) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_scpl)) {
			return null;
		}
		String where = String.format("id_scpl = '%s'", id_scpl);
		ScplweekAggDO[] aggDOs = new OralScplEP().getPlanWeekAggByCond(where, null);
		if (ArrayUtil.isEmpty(aggDOs)) {
			return null;
		}
		List<ScplweekAggDO> aggList = new ArrayList<ScplweekAggDO>();
		for (ScplweekAggDO aggDO : aggDOs) {
			aggList.add(aggDO);
		}
		return aggList;
	}

	/**
	 * 根据排班周计划获取排班周计划号位
	 *
	 * @param planWeekAggDOList 排班周计划AggDO列表
	 * @return 排班周计划号位Map
	 * @throws BizException
	 * @author zhengcm
	 */
	private Map<String, List<ScPlanWeekTickDO>> getPlanWeekTickMap(
			List<ScplweekAggDO> planWeekAggDOList) throws BizException {
		Map<String, List<ScPlanWeekTickDO>> planWeekTickMap = new HashMap<String, List<ScPlanWeekTickDO>>();
		if (ListUtil.isEmpty(planWeekAggDOList)) {
			return planWeekTickMap;
		}
		List<String> ids = new ArrayList<String>();
		for (ScplweekAggDO aggDO : planWeekAggDOList) {
			if (!StringUtil.isEmptyWithTrim(aggDO.getParentDO().getId_scplweek())) {
				ids.add(aggDO.getParentDO().getId_scplweek());
			}
		}
		if (ListUtil.isEmpty(ids)) {
			return planWeekTickMap;
		}
		String where = ScSqlUtils.getInSqlByIds("id_scplweek", ids);
		ScPlanWeekTickDO[] planWeekTickDOs = new OralScplEP().getPlanWeekTickByCond(where, null);
		if (ArrayUtil.isEmpty(planWeekTickDOs)) {
			return planWeekTickMap;
		}
		for (ScPlanWeekTickDO planWeekTickDO : planWeekTickDOs) {
			String key = planWeekTickDO.getId_scplweek();
			if (planWeekTickMap.containsKey(key)) {
				planWeekTickMap.get(key).add(planWeekTickDO);
			} else {
				List<ScPlanWeekTickDO> temp = new ArrayList<ScPlanWeekTickDO>();
				temp.add(planWeekTickDO);
				planWeekTickMap.put(key, temp);
			}
		}
		return planWeekTickMap;
	}

	/**
	 * 处理排班周计划数据
	 *
	 * @param planWeekAggDOList 排班周计划AggDO列表
	 * @param planWeekTickMap 排班周计划号位Map
	 * @param planWeekMap 排班周计划数据Map
	 * @throws BizException
	 * @author zhengcm
	 */
	private void processPlanWeekData(List<ScplweekAggDO> planWeekAggDOList,
			Map<String, List<ScPlanWeekTickDO>> planWeekTickMap,
			Map<String, Map<String, Object>> planWeekMap) throws BizException {
		if (ListUtil.isEmpty(planWeekAggDOList)) {
			return;
		}
		for (ScplweekAggDO aggDO : planWeekAggDOList) {
			ScPlanWeekDO planWeekDO = aggDO.getParentDO();
			String key = planWeekDO.getId_dayslot();
			ScPlanWeekChlDO[] chlDOs = (ScPlanWeekChlDO[]) aggDO.getChildren(ScPlanWeekChlDO.class);
			List<ScPlanWeekChlDO> planWeekChlDOList = new ArrayList<ScPlanWeekChlDO>();
			if (!ArrayUtil.isEmpty(chlDOs)) {
				for (ScPlanWeekChlDO chlDO : chlDOs) {
					planWeekChlDOList.add(chlDO);
				}
			}
			List<ScPlanWeekTickDO> planWeekTickDOList = null;
			if (planWeekTickMap.containsKey(planWeekDO.getId_scplweek())) {
				planWeekTickDOList = planWeekTickMap.get(planWeekDO.getId_scplweek());
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("week", planWeekDO);
			map.put("scchl", planWeekChlDOList);
			map.put("tick", planWeekTickDOList);
			planWeekMap.put(key, map);
		}
	}

}
