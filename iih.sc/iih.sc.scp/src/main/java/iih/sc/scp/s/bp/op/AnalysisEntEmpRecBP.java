package iih.sc.scp.s.bp.op;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.i.IScBdOutQryService;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDsDO;
import iih.sc.scbd.scdeptparam.d.ScdeptparamAggDO;
import iih.sc.scp.dto.d.ScAidSetDTO;
import iih.sc.scp.s.ep.OralScplEP;
import iih.sc.scp.scplan.d.ScPlanDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class AnalysisEntEmpRecBP {

	/**
	 * 分析医生接诊数据
	 * 
	 * @author zhengcm
	 * @date 2017-12-04 17:10:11
	 *
	 * @param id_scpl
	 * @param d_b
	 * @param d_e
	 * @param isCurrentPlan
	 * @return
	 * @throws BizException
	 */
	public ScAidSetDTO[] exec(String id_scpl, FDate d_b, FDate d_e, String id_dayslot, int minVal, int maxVal,
			FBoolean fg_plself) throws BizException {
		// 检查参数
		ScValidator.validateParam("id_scpl", id_scpl);
		ScValidator.validateParam("d_b", d_b);
		ScValidator.validateParam("d_e", d_e);
		ScValidator.validateParam("id_dayslot", id_dayslot);
		ScValidator.validateParam("minVal", minVal);
		ScValidator.validateParam("maxVal", maxVal);
		ScValidator.validateParam("fg_plself", fg_plself);

		// 排班计划DO
		ScPlanDO planDO = new OralScplEP().getPlanById(id_scpl);

		// 查询医生接诊数据
		List<ScAidSetDTO> alldatas = this.queryEntEmpDatas(planDO, d_b, d_e, fg_plself);

		// 过滤掉开始日期和结束日期不一致的数据
		alldatas = this.filterDateNotRightDatas(alldatas);
		if (ListUtil.isEmpty(alldatas)) {
			return null;
		}

		// 按照日期对数据分组
		Map<String, List<ScAidSetDTO>> dateMap = this.groupDatasByDate(alldatas);

		// 分析后的数据
		List<ScAidSetDTO> resultList = new ArrayList<ScAidSetDTO>();

		// 按日期来分析数据
		for (Map.Entry<String, List<ScAidSetDTO>> entry : dateMap.entrySet()) {
			List<ScAidSetDTO> datas = entry.getValue();

			// 设置初始默认值
			this.initDefaultValue(datas);

			// 过滤科室非选择午别的数据
			if (!id_dayslot.equals(IScDictCodeConst.ID_DAYSLOT_QB)) {
				// 计划科室当前午别的诊疗时间DO
				ScDeptParamDsDO dsDO = this.getDeptParamTime(planDO, id_dayslot);
				datas = this.filterNotMatchDayslotDatas(datas, dsDO);
			}

			// 过滤掉同一患者一天内的非第一次就诊数据
			datas = this.filterPatSameDayEntDatas(datas);

			// 整理数据
			this.arrangeDatas(datas);

			// 过滤太短的时间数据
			datas = this.filterTooMinDatas(datas, minVal);
			// 过滤太长的时间数据
			datas = this.filterTooMaxDatas(datas, maxVal);

			// 初始化顺序号
			this.initSortNo(datas);

			// 设置号位号
			this.setTickNo(datas);

			// 将数据添加到分析后的结果中
			if (!ListUtil.isEmpty(datas)) {
				resultList.addAll(datas);
			}
		}

		if (ListUtil.isEmpty(resultList)) {
			return null;
		}

		return resultList.toArray(new ScAidSetDTO[0]);
	}

	/**
	 * 查询接诊数据
	 * 
	 * @author zhengcm
	 * @date 2017-12-04 17:09:56
	 *
	 * @param planDO
	 * @param d_b
	 * @param d_e
	 * @param fg_plself
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<ScAidSetDTO> queryEntEmpDatas(ScPlanDO planDO, FDate d_b, FDate d_e, FBoolean fg_plself)
			throws BizException {
		// 查询SQL
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("emp.id_entemp as id_aidset,");
		sb.append("emp.id_ent,");
		sb.append("emp.id_emp,");
		sb.append("emp.dt_b,");
		sb.append("emp.dt_e,");
		sb.append("substr(emp.dt_b,0,10) as d_sc,");
		sb.append("substr(emp.dt_b,11) as t_b,");
		sb.append("substr(emp.dt_e,11) as t_e ");
		sb.append("from ");
		sb.append("en_ent_emp emp ");
		sb.append("inner join en_ent_op op on op.id_ent = emp.id_ent ");
		sb.append("inner join sc_res res on res.id_emp = emp.id_emp ");
		if (fg_plself.booleanValue()) {
			sb.append("inner join sc_pl pl on pl.id_scres = res.id_scres ");
		}
		sb.append("where 1 = 1 ");
		sb.append("and emp.dt_b >= ? ");
		sb.append("and emp.dt_e <= ? ");
		sb.append("and res.id_scres = ? ");
		if (fg_plself.booleanValue()) {
			sb.append("and pl.id_scpl = ? ");
		}
		sb.append("order by emp.dt_b");
		SqlParam params = new SqlParam();
		params.addParam(d_b);
		params.addParam(d_e);
		params.addParam(planDO.getId_scres());
		if (fg_plself.booleanValue()) {
			params.addParam(planDO.getId_scpl());
		}
		// 查询数据
		List<ScAidSetDTO> datas = (List<ScAidSetDTO>) new DAFacade().execQuery(sb.toString(), params,
				new BeanListHandler(ScAidSetDTO.class));
		return datas;
	}

	/**
	 * 过滤掉开始时间和结束时间日期不一致的数据
	 * 
	 * @author zhengcm
	 * @date 2017-12-15 19:33:04
	 *
	 * @param datas
	 * @return
	 * @throws BizException
	 */
	private List<ScAidSetDTO> filterDateNotRightDatas(List<ScAidSetDTO> datas) throws BizException {
		if (ListUtil.isEmpty(datas)) {
			return null;
		}
		List<ScAidSetDTO> resultList = new ArrayList<ScAidSetDTO>();
		for (ScAidSetDTO data : datas) {
			FDateTime dt_b = data.getDt_b();
			FDateTime dt_e = data.getDt_e();
			if (null != dt_b && null != dt_e
					&& dt_b.getBeginDate().toLocalString().equals(dt_e.getBeginDate().toLocalString())) {
				resultList.add(data);
			}
		}
		return resultList;
	}

	/**
	 * 数据按日期对数据进行分组
	 * 
	 * @author zhengcm
	 * @date 2017-12-14 11:48:58
	 *
	 * @param datas
	 * @return
	 * @throws BizException
	 */
	private Map<String, List<ScAidSetDTO>> groupDatasByDate(List<ScAidSetDTO> datas) throws BizException {
		if (ListUtil.isEmpty(datas)) {
			return null;
		}
		Map<String, List<ScAidSetDTO>> map = new LinkedHashMap<String, List<ScAidSetDTO>>();
		for (ScAidSetDTO data : datas) {
			String key = data.getD_sc().toLocalString();
			if (map.containsKey(key)) {
				map.get(key).add(data);
			} else {
				List<ScAidSetDTO> list = new ArrayList<ScAidSetDTO>();
				list.add(data);
				map.put(key, list);
			}
		}
		return map;
	}

	/**
	 * 设置初始默认值
	 * 
	 * @author zhengcm
	 * @date 2017-12-07 16:16:37
	 *
	 * @param datas
	 * @throws BizException
	 */
	private void initDefaultValue(List<ScAidSetDTO> datas) throws BizException {
		if (ListUtil.isEmpty(datas)) {
			return;
		}
		int index = 0;
		for (ScAidSetDTO data : datas) {
			data.setPeriod(0);
			data.setSortno(++index);
		}
	}

	/**
	 * 过滤科室非选择午别时间范围的数据
	 * 
	 * @author zhengcm
	 * @date 2017-12-07 16:24:51
	 *
	 * @param datas
	 * @param dsDO
	 * @return
	 * @throws BizException
	 */
	private List<ScAidSetDTO> filterNotMatchDayslotDatas(List<ScAidSetDTO> datas, ScDeptParamDsDO dsDO)
			throws BizException {
		if (null == datas || null == dsDO) {
			return null;
		}
		FTime t_b = dsDO.getT_begin();
		FTime t_e = dsDO.getT_end();
		List<ScAidSetDTO> newDatas = new ArrayList<ScAidSetDTO>();
		for (ScAidSetDTO data : datas) {
			if (data.getT_b().before(t_b) || data.getT_e().after(t_e)) {
				continue;
			}
			newDatas.add(data);
		}
		return newDatas;
	}

	/**
	 * 过滤同一患者一天内非第一次就诊的数据
	 * 
	 * @author zhengcm
	 * @date 2017-12-07 16:44:04
	 *
	 * @param datas
	 * @return
	 * @throws BizException
	 */
	private List<ScAidSetDTO> filterPatSameDayEntDatas(List<ScAidSetDTO> datas) throws BizException {
		if (ListUtil.isEmpty(datas)) {
			return null;
		}
		Map<String, ScAidSetDTO> map = new LinkedHashMap<String, ScAidSetDTO>();
		for (ScAidSetDTO data : datas) {
			String key = data.getId_ent() + "_" + data.getD_sc();
			if (!map.containsKey(key)) {
				map.put(key, data);
			} else {
				ScAidSetDTO _data = map.get(key);
				if (data.getSortno() < _data.getSortno()) {
					map.put(key, data);
				}
			}
		}
		List<ScAidSetDTO> newDatas = new ArrayList<ScAidSetDTO>();
		for (Map.Entry<String, ScAidSetDTO> entry : map.entrySet()) {
			newDatas.add(entry.getValue());
		}
		return newDatas;
	}

	/**
	 * 过滤时间太短的数据
	 * 
	 * @author zhengcm
	 * @date 2017-12-07 17:50:43
	 *
	 * @param datas
	 * @param minVal
	 * @return
	 * @throws BizException
	 */
	private List<ScAidSetDTO> filterTooMinDatas(List<ScAidSetDTO> datas, int minVal) throws BizException {
		if (ListUtil.isEmpty(datas)) {
			return null;
		}
		List<ScAidSetDTO> newDatas = new ArrayList<ScAidSetDTO>();
		for (ScAidSetDTO data : datas) {
			if (data.getPeriod() > minVal) {
				newDatas.add(data);
			}
		}
		return newDatas;
	}

	/**
	 * 过滤时间太长的数据
	 * 
	 * @author zhengcm
	 * @date 2017-12-07 17:51:16
	 *
	 * @param datas
	 * @param maxVal
	 * @return
	 * @throws BizException
	 */
	private List<ScAidSetDTO> filterTooMaxDatas(List<ScAidSetDTO> datas, int maxVal) throws BizException {
		if (ListUtil.isEmpty(datas)) {
			return null;
		}
		List<ScAidSetDTO> newDatas = new ArrayList<ScAidSetDTO>();
		for (ScAidSetDTO data : datas) {
			if (data.getPeriod() <= maxVal) {
				newDatas.add(data);
			}
		}
		return newDatas;
	}

	/**
	 * 整理数据
	 * 
	 * @author zhengcm
	 * @date 2017-12-07 18:02:43
	 *
	 * @param datas
	 * @throws BizException
	 */
	private void arrangeDatas(List<ScAidSetDTO> datas) throws BizException {
		// 初始化顺序号
		this.initSortNo(datas);
		// 设置下一次就诊时间和时长
		this.setNextPeriod(datas);
	}

	/**
	 * 初始化顺序号
	 * 
	 * @author zhengcm
	 * @date 2017-12-07 16:49:20
	 *
	 * @param datas
	 * @throws BizException
	 */
	private void initSortNo(List<ScAidSetDTO> datas) throws BizException {
		if (ListUtil.isEmpty(datas)) {
			return;
		}
		int index = 0;
		for (ScAidSetDTO data : datas) {
			data.setSortno(++index);
		}
	}

	/**
	 * 设置下一次就诊时间和时长
	 * 
	 * @author zhengcm
	 * @date 2017-12-07 17:43:58
	 *
	 * @param datas
	 * @throws BizException
	 */
	private void setNextPeriod(List<ScAidSetDTO> datas) throws BizException {
		if (ListUtil.isEmpty(datas)) {
			return;
		}
		Map<String, ScAidSetDTO> map = new HashMap<String, ScAidSetDTO>();
		for (ScAidSetDTO data : datas) {
			String key = data.getSortno() + "_" + data.getD_sc();
			map.put(key, data);
		}
		for (ScAidSetDTO data : datas) {
			String key = data.getSortno() + 1 + "_" + data.getD_sc();
			if (map.containsKey(key)) {
				data.setT_next(map.get(key).getT_b());
				data.setPeriod(this.calcBetweenMinites(data.getT_next(), data.getT_b()));
			} else {
				data.setPeriod(this.calcBetweenMinites(data.getT_e(), data.getT_b()));
			}
		}
	}

	/**
	 * 设置号位票号
	 * 
	 * @author zhengcm
	 * @date 2017-12-07 17:54:44
	 *
	 * @param datas
	 * @throws BizException
	 */
	private void setTickNo(List<ScAidSetDTO> datas) throws BizException {
		if (ListUtil.isEmpty(datas)) {
			return;
		}
		for (ScAidSetDTO data : datas) {
			data.setTickno(data.getSortno());
		}
	}

	/**
	 * 计算两个时间相差的分钟数
	 * 
	 * @author zhengcm
	 * @date 2017-12-07 17:43:24
	 *
	 * @param currentTime
	 * @param targetTime
	 * @return
	 * @throws BizException
	 */
	private int calcBetweenMinites(FTime currentTime, FTime targetTime) throws BizException {
		FDate date = new FDate("2000-01-01");
		int minutes = Math.abs(FDateTime.getMinutesBetween(new FDateTime(date + " " + currentTime), new FDateTime(date
				+ " " + targetTime)));
		return minutes;
	}

	/**
	 * 获取科室参数指定午别的诊疗时间
	 * 
	 * @author zhengcm
	 * @date 2017-12-04 17:44:15
	 *
	 * @param planDO
	 * @param id_dayslot
	 * @return
	 * @throws BizException
	 */
	private ScDeptParamDsDO getDeptParamTime(ScPlanDO planDO, String id_dayslot) throws BizException {
		IScBdOutQryService bdQryService = ServiceFinder.find(IScBdOutQryService.class);
		ScdeptparamAggDO[] aggDOs = bdQryService.getDeptParamList(planDO.getId_dep(), planDO.getSd_sctp());
		ScdeptparamAggDO aggDO = null;
		if (!StringUtil.isEmptyWithTrim(planDO.getId_depparam())) {
			for (ScdeptparamAggDO _aggDO : aggDOs) {
				if (_aggDO.getParentDO().getId_deptparam().equals(planDO.getId_depparam())) {
					aggDO = _aggDO;
					break;
				}
			}
		} else {
			aggDO = aggDOs[0];
		}
		if (null == aggDO) {
			throw new BizException("获取科室参数失败！");
		}
		ScDeptParamDsDO[] dsDOs = aggDO.getScDeptParamDsDO();
		ScDeptParamDsDO dsDO = null;
		for (ScDeptParamDsDO _dsDO : dsDOs) {
			if (_dsDO.getId_dayslot().equals(id_dayslot)) {
				dsDO = _dsDO;
			}
		}
		return dsDO;
	}
}
