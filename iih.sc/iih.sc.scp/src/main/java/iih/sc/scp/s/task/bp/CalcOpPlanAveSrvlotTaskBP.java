package iih.sc.scp.s.task.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScParamUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.scp.dto.d.ScAidSetDTO;
import iih.sc.scp.s.ep.ScplEp;
import iih.sc.scp.scplan.d.ScPlanDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 计算门诊排班计划平均就诊时长定时任务BP
 * 
 * @author zhengcm
 * @date 2017-12-19 10:23:44
 *
 */
public class CalcOpPlanAveSrvlotTaskBP {
	
	private static final String KEY_ORG_ID = "id_org";

	/**
	 * 计算门诊排班计划平均就诊时长定时任务
	 * 
	 * @author zhengcm
	 * @date 2017-12-19 10:24:54
	 *
	 * @throws BizException
	 */
	public void exec(Map<String, Object> map) throws BizException {
		
		if(Context.get().getOrgId() == null){
		// 设置上下文组织
			if(!map.containsKey(KEY_ORG_ID) || map.get(KEY_ORG_ID) == null)
				throw new BizException("定时任务参数id_org未设置！");
			Context.get().setOrgId((String) map.get(KEY_ORG_ID));
		}

		// 取出所有有效的门诊排班计划
		ScPlanDO[] planDOs = this.getAllPlans();
		if (ArrayUtil.isEmpty(planDOs)) {
			return;
		}

		// 计划Map
		Map<String, ScPlanDO> planMap = this.plan2Map(planDOs);

		// 门诊医生接诊最大时长
		int maxPeriod = ScParamUtils.getEnOpMaxDiPeriodm();

		// 所有计划主键
		List<String> planPKList = this.getAllPlanPK(planDOs);

		// 查询所有计划对应排班的接诊记录
		List<ScAidSetDTO> datas = this.getAllPlanEntEmp(planPKList);
		if (ListUtil.isEmpty(datas)) {
			return;
		}

		// 根据医生接诊最大时长过滤接诊数据
		datas = this.filterEntEmpByMaxPeriod(datas, maxPeriod);
		if (ListUtil.isEmpty(datas)) {
			return;
		}

		// 计算平均接诊时间并更新计划
		this.updatePlanByCalcSrvlot(planMap, datas);
	}

	/**
	 * 获取所有有效的门诊排班计划
	 * 
	 * @author zhengcm
	 * @date 2017-12-19 10:28:55
	 *
	 * @return
	 * @throws BizException
	 */
	private ScPlanDO[] getAllPlans() throws BizException {
		String where = String.format("sd_sctp = '%s' and fg_active = 'Y'", IScDictCodeConst.SD_SCTP_OP);
		return new ScplEp().getScPls(where, null);
	}

	/**
	 * 获取所有有效计划主键
	 * 
	 * @author zhengcm
	 * @date 2017-12-19 10:33:35
	 *
	 * @param planDOs
	 * @return
	 * @throws BizException
	 */
	private List<String> getAllPlanPK(ScPlanDO[] planDOs) throws BizException {
		List<String> pkList = new ArrayList<String>();
		for (ScPlanDO planDO : planDOs) {
			String pk = planDO.getId_scpl();
			if (!StringUtil.isEmptyWithTrim(pk) && !pkList.contains(pk)) {
				pkList.add(pk);
			}
		}
		return pkList;
	}

	/**
	 * 计划DO转Map
	 * 
	 * @author zhengcm
	 * @date 2017-12-19 14:12:33
	 *
	 * @param planDOs
	 * @return
	 * @throws BizException
	 */
	private Map<String, ScPlanDO> plan2Map(ScPlanDO[] planDOs) throws BizException {
		Map<String, ScPlanDO> planMap = new HashMap<String, ScPlanDO>();
		for (ScPlanDO planDO : planDOs) {
			planMap.put(planDO.getId_scpl(), planDO);
		}
		return planMap;
	}

	/**
	 * 查询所有计划对应排班的接诊记录
	 * 
	 * @author zhengcm
	 * @date 2017-12-19 11:55:01
	 *
	 * @param pkList
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<ScAidSetDTO> getAllPlanEntEmp(List<String> pkList) throws BizException {
		if (ListUtil.isEmpty(pkList)) {
			return null;
		}
		// 服务器日期
		FDate nowDate = ScAppUtils.getServerDate();
		String endDate = nowDate.toLocalString() + " 00:00:00";
		String beginDate = nowDate.getDateBefore(30).toLocalString() + " 00:00:00";
		// 查询SQL
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("sch.id_scpl,");
		sb.append("ent.id_ent,");
		sb.append("emp.dt_b,");
		sb.append("emp.dt_e ");
		sb.append("from ");
		sb.append("en_ent_emp emp ");
		sb.append("inner join en_ent ent on ent.id_ent = emp.id_ent ");
		sb.append("inner join en_ent_op op on op.id_ent = ent.id_ent ");
		sb.append("inner join sc_sch sch on sch.id_sch = op.id_sch ");
		sb.append("where 1 = 1 ");
		sb.append("and ent.fg_acptvalid = 'Y' ");
		sb.append("and ent.fg_canc = 'N' ");
		sb.append("and ent.dt_acpt >= ? ");
		sb.append("and ent.dt_acpt <= ? ");
		sb.append("and " + ScSqlUtils.getInSqlByIds("sch.id_scpl", pkList));
		SqlParam params = new SqlParam();
		params.addParam(beginDate);
		params.addParam(endDate);
		// 查询数据
		List<ScAidSetDTO> datas = (List<ScAidSetDTO>) new DAFacade().execQuery(sb.toString(), params,
				new BeanListHandler(ScAidSetDTO.class));
		return datas;
	}

	/**
	 * 根据医生接诊最大时长过滤接诊数据
	 * 
	 * @author zhengcm
	 * @date 2017-12-19 13:34:15
	 *
	 * @param empDataList
	 * @param maxPeriod
	 * @return
	 * @throws BizException
	 */
	private List<ScAidSetDTO> filterEntEmpByMaxPeriod(List<ScAidSetDTO> datas, int maxPeriod) throws BizException {
		List<ScAidSetDTO> resultList = new ArrayList<ScAidSetDTO>();
		for (ScAidSetDTO dto : datas) {
			FDateTime dt_b = dto.getDt_b();
			FDateTime dt_e = dto.getDt_e();
			if (null == dt_b || null == dt_e) {
				continue;
			}
			int minutes = Math.abs(FDateTime.getMinutesBetween(dt_b, dt_e));
			// 丢弃0和大于等于最大接诊时长的数据
			if (minutes > 0 && minutes < maxPeriod) {
				dto.setPeriod(minutes);
				resultList.add(dto);
			}
		}
		return resultList;
	}

	/**
	 * 计算平均时长并更新计划
	 * 
	 * @author zhengcm
	 * @date 2017-12-19 14:17:43
	 *
	 * @param planMap
	 * @param datas
	 * @throws BizException
	 */
	private void updatePlanByCalcSrvlot(Map<String, ScPlanDO> planMap, List<ScAidSetDTO> datas) throws BizException {
		// 根据计划分组
		Map<String, List<ScAidSetDTO>> map = new HashMap<String, List<ScAidSetDTO>>();
		for (ScAidSetDTO data : datas) {
			String key = data.getId_scpl();
			if (map.containsKey(key)) {
				map.get(key).add(data);
			} else {
				List<ScAidSetDTO> list = new ArrayList<ScAidSetDTO>();
				list.add(data);
				map.put(key, list);
			}
		}
		// 计算平均时长
		Map<String, Integer> dataMap = new HashMap<String, Integer>();
		for (Map.Entry<String, List<ScAidSetDTO>> entry : map.entrySet()) {
			List<ScAidSetDTO> list = entry.getValue();
			int sum = 0;
			for (ScAidSetDTO data : list) {
				sum = sum + data.getPeriod();
			}
			dataMap.put(entry.getKey(), sum / list.size());
		}
		// 更新计划
		List<ScPlanDO> updateList = new ArrayList<ScPlanDO>();
		for (Map.Entry<String, Integer> entry : dataMap.entrySet()) {
			ScPlanDO planDO = planMap.get(entry.getKey());
			planDO.setStatus(DOStatus.UPDATED);
			planDO.setSrvslot_cal(new FDouble(entry.getValue()));
			updateList.add(planDO);
		}
		new ScplEp().save(updateList.toArray(new ScPlanDO[0]));
	}
}
