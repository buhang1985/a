package iih.sc.scp.s.bp;

import iih.sc.comm.ScSqlUtils;
import iih.sc.sch.sctick.d.EuUseScope;
import iih.sc.scp.s.ep.OralScplEP;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scploptsrv.d.ScPlOptSrvDO;
import iih.sc.scp.scpltick.d.ScPlanWeekTickDO;
import iih.sc.scp.scplweek.d.ScPlanWeekChlDO;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;
import iih.sc.scp.scplweek.d.ScplweekAggDO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 保存口腔科排班周计划BP
 * 
 * @author zhengcm
 * @date 2016-09-23 15:59:11
 *
 */
public class SaveOralPlanBP {

	/**
	 * 保存口腔科排班周计划
	 *
	 * @param planDO 排班计划DO
	 * @param srvValStr 备选服务字符串（逗号隔开）
	 * @param datasMap 周计划、排班号位和排班渠道数据
	 * @throws BizException
	 * @author zhengcm
	 */
	public void exec(ScPlanDO planDO, String srvValStr, Map<String, Map<String, Object>> datasMap)
			throws BizException {
		if (null == planDO || null == datasMap || datasMap.isEmpty()) {
			return;
		}

		// 排班周计划AggDO
		List<ScplweekAggDO> planWeekAggDOList = new ArrayList<ScplweekAggDO>();
		// 排班周计划号位
		List<ScPlanWeekTickDO> planWeekTickDOList = new ArrayList<ScPlanWeekTickDO>();
		// 排班计划备选服务
		List<ScPlOptSrvDO> planOptSrvList = new ArrayList<ScPlOptSrvDO>();

		// 1、获取备选服务
		String[] optSrvVals = this.getOptSrvVal(srvValStr);

		// 2、处理排班计划DO
		this.processPlanDO(planDO);

		// 3、处理排班周计划数据
		this.processPlanWeekDatas(planDO, datasMap, planWeekAggDOList, planWeekTickDOList);

		// 4、处理备选服务
		this.processPlanOptSrv(planDO, optSrvVals, planOptSrvList);

		// 5、删除已有的排班周计划备选服务
		this.deleteOldPlanOptSrvDO(planDO);

		// 6、删除已有的排班周计划渠道
		this.deleteOldPlanWeekChlDO(planWeekAggDOList);

		// 7、删除已有的排班周计划号位
		this.deleteOldPlanWeekTickDO(planWeekAggDOList);

		// 8、保存排班计划
		this.savePlanDO(planDO);

		// 9、保存排班计划备选服务
		this.savePlanOptSrvDO(planOptSrvList);

		// 10、保存排班周计划
		this.savePlanWeekAggDO(planWeekAggDOList);

		// 11、保存排班周计划号位
		this.savePlanWeekTickDO(planWeekTickDOList);
	}

	/**
	 * 处理排班周计划数据
	 *
	 * @param planDO 排班计划DO
	 * @param datasMap 排班周计划数据Map
	 * @param planWeekAggDOList 排班周计划AggDO列表
	 * @param planWeekTickDOList 排班周计划号位DO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	private void processPlanWeekDatas(ScPlanDO planDO, Map<String, Map<String, Object>> datasMap,
			List<ScplweekAggDO> planWeekAggDOList, List<ScPlanWeekTickDO> planWeekTickDOList)
			throws BizException {
		// 遍历午别数据Map
		for (Map.Entry<String, Map<String, Object>> entry : datasMap.entrySet()) {
			String id_dayslot = entry.getKey();
			ScPlanWeekDO planWeekDO = null;
			Map<String, Object> map = entry.getValue();
			// 获取排班周计划、排班周计划号位、排班周计划渠道数据
			if (null != map && !map.isEmpty()) {
				String key = "week";
				if (map.containsKey(key)) {
					planWeekDO = (ScPlanWeekDO) map.get(key);
					// 处理排班周计划DO
					this.processPlanWeekDO(planDO, planWeekDO, id_dayslot);
				}
				key = "tick";
				if (map.containsKey(key)) {
					List<ScPlanWeekTickDO> planWeekTickDOs = (List<ScPlanWeekTickDO>) map.get(key);
					// 处理排班周计划号位
					this.processPlanWeekTick(planWeekDO, planWeekTickDOs, planWeekTickDOList);
				}
				key = "scchl";
				if (map.containsKey(key)) {
					List<String> chlList = (List<String>) map.get(key);
					List<ScPlanWeekChlDO> planWeekChlList = new ArrayList<ScPlanWeekChlDO>();
					if (!ListUtil.isEmpty(chlList)) {
						for (String chl : chlList) {// 格式为：号源_可预约数_渠道1,渠道2...
							String[] vals = chl.split("_");
							int quanNo = Integer.parseInt(vals[0]);
							int apptNum = Integer.parseInt(vals[1]);
							if (vals.length > 2) {
								String[] chls = vals[2].split(",");
								// 处理排班周计划渠道
								this.processPlanWeekChl(planWeekDO, quanNo, chls, planWeekChlList);
							}
							// 设置周计划对应号源的可预约数
							planWeekDO.setAttrVal("Quan" + quanNo + "_appt", apptNum);
						}
						// 设置号源池数
						planWeekDO.setScpolcn(chlList.size());
					}
					// 处理排班周计划渠道
					this.processPlanWeek(planWeekDO, planWeekChlList, planWeekAggDOList);
				}
			}
		}
	}

	/**
	 * 处理排班周计划渠道
	 *
	 * @param planWeekDO 排班周计划DO
	 * @param planWeekChlDOList 排班周计划渠道DO列表
	 * @param planWeekAggDOList 排班周计划AggDO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private void processPlanWeek(ScPlanWeekDO planWeekDO, List<ScPlanWeekChlDO> planWeekChlDOList,
			List<ScplweekAggDO> planWeekAggDOList) throws BizException {
		if (null == planWeekDO) {
			return;
		}
		// 设置数量总数给数量总数可预约
		planWeekDO.setQuan_total_appt(planWeekDO.getQuan_total());
		// 设置排班周计划聚合DO
		ScplweekAggDO planWeekAggDO = new ScplweekAggDO();
		planWeekAggDO.setParentDO(planWeekDO);
		if (!ListUtil.isEmpty(planWeekChlDOList)) {
			planWeekAggDO.setChildren(ScPlanWeekChlDO.class,
					planWeekChlDOList.toArray(new ScPlanWeekChlDO[0]));
		}
		planWeekAggDOList.add(planWeekAggDO);
	}

	/**
	 * 处理排班渠道数据
	 *
	 * @param planWeekDO 排班周计划DO
	 * @param quanNo 渠道号
	 * @param chls 渠道数组
	 * @param planWeekChlList 排班周计划渠道DO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private void processPlanWeekChl(ScPlanWeekDO planWeekDO, int quanNo, String[] chls,
			List<ScPlanWeekChlDO> planWeekChlList) throws BizException {
		if (ArrayUtil.isEmpty(chls)) {
			return;
		}
		// 生成排班周计划渠道
		for (String chlId : chls) {
			ScPlanWeekChlDO planWeekChlDO = new ScPlanWeekChlDO();
			planWeekChlDO.setStatus(DOStatus.NEW);
			planWeekChlDO.setId_scplweek(planWeekDO.getId_scplweek());
			planWeekChlDO.setId_scchl(chlId);
			planWeekChlDO.setScpolcn(quanNo);
			planWeekChlList.add(planWeekChlDO);
		}
	}

	/**
	 * 处理排班周计划号位
	 *
	 * @param planWeekDO 排班周计划DO
	 * @param planWeekTickList 排班周计划号位DO列表（当前）
	 * @param planWeekTickDOList 排班周计划号位DO列表（保存）
	 * @throws BizException
	 * @author zhengcm
	 */
	private void processPlanWeekTick(ScPlanWeekDO planWeekDO,
			List<ScPlanWeekTickDO> planWeekTickList, List<ScPlanWeekTickDO> planWeekTickDOList)
			throws BizException {
		if (null == planWeekDO || ListUtil.isEmpty(planWeekTickList)) {
			return;
		}
		for (ScPlanWeekTickDO planWeekTickDO : planWeekTickList) {
			planWeekTickDO.setStatus(DOStatus.NEW);
			planWeekTickDO.setId_scplweek(planWeekDO.getId_scplweek());
			planWeekTickDOList.add(planWeekTickDO);
		}
	}

	/**
	 * 处理排班计划备选服务
	 *
	 * @param planDO 排班计划DO
	 * @param optSrvs 排班计划备选服务的排班服务id数组
	 * @param planOptSrvList 排班计划备选服务DO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private void processPlanOptSrv(ScPlanDO planDO, String[] optSrvs,
			List<ScPlOptSrvDO> planOptSrvList) throws BizException {
		if (null == planDO || ArrayUtil.isEmpty(optSrvs)) {
			return;
		}
		for (String id_scsrv : optSrvs) {
			ScPlOptSrvDO planOptSrvDO = new ScPlOptSrvDO();
			planOptSrvDO.setStatus(DOStatus.NEW);
			planOptSrvDO.setId_scpl(planDO.getId_scpl());
			planOptSrvDO.setId_scsrv(id_scsrv);
			planOptSrvList.add(planOptSrvDO);
		}
	}

	/**
	 * 处理排班周计划DO
	 *
	 * @param planDO 排班计划DO
	 * @param planWeekDO 排班周计划DO
	 * @param id_dayslot 日期分组id
	 * @throws BizException
	 * @author zhengcm
	 */
	private void processPlanWeekDO(ScPlanDO planDO, ScPlanWeekDO planWeekDO, String id_dayslot)
			throws BizException {
		if (null == planDO || null == planWeekDO || StringUtil.isEmptyWithTrim(id_dayslot)) {
			return;
		}
		if (StringUtil.isEmptyWithTrim(planWeekDO.getId_scplweek())) {
			DBUtil util = new DBUtil();
			planWeekDO.setStatus(DOStatus.NEW);
			planWeekDO.setId_scplweek(util.getOIDs(1)[0]);// 主键
		} else {
			planWeekDO.setStatus(DOStatus.UPDATED);
		}
		planWeekDO.setId_scpl(planDO.getId_scpl());
		planWeekDO.setId_dayslot(id_dayslot);
		planWeekDO.setQuan_total_appt(planWeekDO.getQuan_total());
	}

	/**
	 * 处理排班计划DO
	 *
	 * @param planDO 排班计划DO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void processPlanDO(ScPlanDO planDO) throws BizException {
		if (null == planDO) {
			return;
		}
		if (StringUtil.isEmptyWithTrim(planDO.getId_scpl())) {
			DBUtil util = new DBUtil();
			planDO.setId_scpl(util.getOIDs(1)[0]);// 主键
			planDO.setStatus(DOStatus.NEW);
		} else {
			planDO.setStatus(DOStatus.UPDATED);
		}
	}

	/**
	 * 获取备选服务数据
	 *
	 * @param srvValStr 备选服务值
	 * @return 备选服务id数组
	 * @throws BizException
	 * @author zhengcm
	 */
	private String[] getOptSrvVal(String srvValStr) throws BizException {
		if (StringUtil.isEmptyWithTrim(srvValStr)) {
			return null;
		}
		return srvValStr.split(",");
	}

	/**
	 * 保存口腔科排班计划
	 *
	 * @param planDO 排班计划DO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void savePlanDO(ScPlanDO planDO) throws BizException {
		if (null == planDO) {
			return;
		}
		new OralScplEP().savePlan(new ScPlanDO[] { planDO });
	}

	/**
	 * 保存口腔科排班周计划
	 *
	 * @param planWeekDOList 排班周计划AggDO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private void savePlanWeekAggDO(List<ScplweekAggDO> planWeekAggDOList) throws BizException {
		if (ListUtil.isEmpty(planWeekAggDOList)) {
			return;
		}
		new OralScplEP().savePlanWeekAgg(planWeekAggDOList.toArray(new ScplweekAggDO[0]));
	}

	/**
	 * 保存口腔科排班周计划备选服务
	 *
	 * @param planOptSrvDOList 排班计划备选服务DO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private void savePlanOptSrvDO(List<ScPlOptSrvDO> planOptSrvDOList) throws BizException {
		if (ListUtil.isEmpty(planOptSrvDOList)) {
			return;
		}
		new OralScplEP().savePlanOptSrvDO(planOptSrvDOList.toArray(new ScPlOptSrvDO[0]));
	}

	/**
	 * 保存口腔科排班周计划号位
	 *
	 * @param planWeekTickDOList 排班周计划号位DO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private void savePlanWeekTickDO(List<ScPlanWeekTickDO> planWeekTickDOList) throws BizException {
		if (ListUtil.isEmpty(planWeekTickDOList)) {
			return;
		}
		// 设置号位使用范围
		for (ScPlanWeekTickDO weekTickDO : planWeekTickDOList) {
			weekTickDO.setEu_usescope(EuUseScope.APT);
		}
		new OralScplEP().savePlanWeekTickDO(planWeekTickDOList.toArray(new ScPlanWeekTickDO[0]));
	}

	/**
	 * 删除已有的排班周计划备选服务
	 *
	 * @param planDO 排班计划DO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void deleteOldPlanOptSrvDO(ScPlanDO planDO) throws BizException {
		if (null == planDO) {
			return;
		}
		String where = String.format("id_scpl = '%s'", planDO.getId_scpl());
		new OralScplEP().deleteScplOptSrvByCond(where);
	}

	/**
	 * 删除已有的排班周计划渠道
	 *
	 * @param planWeekAggDOList 排班周计划AggDO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private void deleteOldPlanWeekChlDO(List<ScplweekAggDO> planWeekAggDOList) throws BizException {
		if (ListUtil.isEmpty(planWeekAggDOList)) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		for (ScplweekAggDO weekAggDO : planWeekAggDOList) {
			ScPlanWeekDO planWeekDO = weekAggDO.getParentDO();
			if (!StringUtil.isEmptyWithTrim(planWeekDO.getId_scplweek())) {
				ScPlanWeekChlDO[] chlDOs = (ScPlanWeekChlDO[]) weekAggDO
						.getChildren(ScPlanWeekChlDO.class);
				if (!ArrayUtil.isEmpty(chlDOs)) {
					String where = String.format("(id_scplweek = '%s' and scpolcn in (",
							planWeekDO.getId_scplweek());
					for (int i = 0; i < chlDOs.length; i++) {
						if (i != chlDOs.length - 1) {
							where = where + "'" + chlDOs[i].getScpolcn() + "',";
						} else {
							where = where + "'" + chlDOs[i].getScpolcn() + "'";
						}
					}
					where = where + "))";
					if (sb.toString().isEmpty()) {
						sb.append(where);
					} else {
						sb.append(" or " + where);
					}
				}
			}
		}
		if (sb.toString().isEmpty()) {
			return;
		}
		new OralScplEP().deletePlanWeekChlByCond(sb.toString());
	}

	/**
	 * 删除已有的排班周计划号位
	 *
	 * @param planWeekAggDOList 排班周计划AggDO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private void deleteOldPlanWeekTickDO(List<ScplweekAggDO> planWeekAggDOList) throws BizException {
		if (ListUtil.isEmpty(planWeekAggDOList)) {
			return;
		}
		List<String> ids = new ArrayList<String>();
		for (ScplweekAggDO planWeekAggDO : planWeekAggDOList) {
			String id_planweek = planWeekAggDO.getParentDO().getId_scplweek();
			if (!StringUtil.isEmptyWithTrim(id_planweek)) {
				ids.add(id_planweek);
			}
		}
		if (ListUtil.isEmpty(ids)) {
			return;
		}
		String where = ScSqlUtils.getInSqlByIds("id_scplweek", ids);
		new OralScplEP().deletePlanWeekTickByCond(where);
	}
}
