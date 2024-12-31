package iih.bd.fc.s.bp.batwfexdept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.pub.BdFcAppUtils;
import iih.bd.fc.wf.d.OrRecurTypeEnum;
import iih.bd.fc.wf.d.WfAggDO;
import iih.bd.fc.wf.d.WfDepDO;
import iih.bd.fc.wf.d.WfSrvtpDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FTime;

/**
 * 批量匹配执行科室
 * 
 * @author xuxing_2016-11-14
 * @version xuxing_2018年6月28日08:49:27(此逻辑废弃不用)
 *
 */
public class GetOrExDepAfterFilterBatchBp {

	/**
	 * 主入口
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public HashMap<OrWfExDeptParamDTO, List<WfDepDO>> exec(WfAggDO[] aggDOS, OrWfExDeptParamDTO[] params) throws BizException {

		// 1、匹配流向参数
		HashMap<OrWfExDeptParamDTO, List<WfDepDO>> reMap = filter(aggDOS, params);

		return reMap;
	}

	/**
	 * 匹配流向参数
	 * 
	 * @param listDept
	 * @param param
	 * @return
	 */
	private HashMap<OrWfExDeptParamDTO, List<WfDepDO>> filter(WfAggDO[] aggDOS, OrWfExDeptParamDTO[] params) {

		HashMap<OrWfExDeptParamDTO, List<WfDepDO>> reMap = new HashMap<OrWfExDeptParamDTO, List<WfDepDO>>();

		for (OrWfExDeptParamDTO param : params) {

			List<WfDepDO> listDept = getWfDeptBySrvtpAndEntp(aggDOS, param);
			List<WfDepDO> list = new ArrayList<WfDepDO>();

			if (listDept != null && listDept.size() > 0) {

				for (WfDepDO wfDepDO : listDept) {

					if (matchCondition(wfDepDO, param)) {

						list.add((WfDepDO) wfDepDO.clone());
					}
				}
			}
			reMap.put(param, list);
		}
		return reMap;
	}

	/**
	 * 匹配就诊类型和服务类型，返回匹配的科室集合
	 * 
	 * @param aggDOS
	 * @param param
	 * @return
	 */
	private List<WfDepDO> getWfDeptBySrvtpAndEntp(WfAggDO[] aggDOS, OrWfExDeptParamDTO param) {

		List<WfDepDO> reList = new ArrayList<WfDepDO>();

		for (WfAggDO agg : aggDOS) {

			if (agg.getParentDO().getCode_entp().equals(param.getCode_entp())) {

				for (WfSrvtpDO srvtpDO : agg.getWfSrvtpDO()) {

					if (param.getSd_srvtp().indexOf(srvtpDO.getSd_srvtp()) == 0) {

						addArrayToList(reList, agg.getWfDepDO());
						continue;
					}
				}
			}
		}

		return reList;
	}

	/**
	 * 集合追加到List
	 * 
	 * @param reList
	 * @param deps
	 */
	private void addArrayToList(List<WfDepDO> reList, WfDepDO[] deps) {

		if (deps != null && deps.length > 0) {

			for (WfDepDO wfDepDO : deps) {

				reList.add(wfDepDO);
			}
		}
	}

	/**
	 * 校验：用法、长临、星期、时间、服务
	 * 
	 * @param wfDepDO
	 * @param param
	 * @return
	 */
	private boolean matchCondition(WfDepDO wfDepDO, OrWfExDeptParamDTO param) {

		// 用法
		if (!isStrsInclude(wfDepDO.getId_usgs(), param.getId_usage())) {
			return false;
		}

		// 长临标识
		if (!isStrMatchInt(wfDepDO.getOrdrecurtp(), param.getRecurstr())) {
			return false;
		}

		// 星期
		if (!isStrsIncludeStrs(wfDepDO.getSd_weeks(), param.getWeekno())) {
			return false;
		}

		// 时间
		if (!isTimeBetween(wfDepDO.getTime_b(), wfDepDO.getTime_e(), param.getTimestr())) {
			return false;
		}

		// 服务
		if (!isStrsInclude(wfDepDO.getId_srvs(), param.getId_srv())) {
			return false;
		}

		// 开单科室
		if (!isStrsIncludeStrs(wfDepDO.getId_dep_ors(), param.getId_dept_or())) {
			return false;
		}

		// 就诊科室
		if (!isStrsIncludeStrs(wfDepDO.getId_dep_clinics(), param.getId_dept_en())) {
			return false;
		}

		// 护理单元
		if (!isStrsIncludeStrs(wfDepDO.getId_dep_nurs(), param.getId_dept_ns())) {
			return false;
		}

		return true;
	}

	/**
	 * 字符串包含（键）校验（以逗号分割），字符串和键都非空才校验
	 * 
	 * @param strSplit
	 * @param str
	 * @return
	 */
	private boolean isStrsInclude(String strSplit, String str) {

		if (!StringUtil.isEmpty(strSplit)) {

			if (StringUtil.isEmpty(str)) {
				return false;
			}

			for (String itm : strSplit.split(",")) {
				if (str.equals(itm)) {
					return true;
				}
			}
			return false;
		}
		return true;
	}

	/**
	 * 字符串包含字符串
	 * 
	 * @param strSplit
	 * @param strs
	 * @return
	 */
	private boolean isStrsIncludeStrs(String strSplit, String strs) {

		if (!StringUtil.isEmpty(strSplit)) {

			if (StringUtil.isEmpty(strs)) {
				return false;
			}

			int count = 0;

			for (String str : strs.split(",")) {

				for (String itm : strSplit.split(",")) {

					if (itm.equals(str)) {
						count++;
						break;
					}
				}
			}

			return count == strs.split(",").length;
		}
		return true;
	}

	/**
	 * 字符串和整型比较
	 * 
	 * @param str
	 * @param integ
	 * @return
	 */
	private boolean isStrMatchInt(Integer integ, String str) {

		if (integ == null) {
			return true;
		}

		if (OrRecurTypeEnum.NULL.equals(integ)) {
			return true;
		}

		if (StringUtil.isEmpty(str)) {
			return false;
		}

		if (!str.equals(integ + "")) {
			return false;
		}

		return true;
	}

	/**
	 * 时间区间校验
	 * 
	 * @param bg
	 * @param ed
	 * @param time
	 * @return
	 */
	private boolean isTimeBetween(FTime bg, FTime ed, FTime time) {

		if (bg != null && ed != null) {
			FTime inputTime = null;
			if (time == null) {
				inputTime = BdFcAppUtils.getServerDateTime().getUFTime();
			} else {
				inputTime = time;
			}
			if (inputTime.before(bg) || inputTime.after(ed)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 单字符串匹配
	 * 
	 * @param strDef
	 * @param str
	 * @return
	 */
	@SuppressWarnings("unused")
	private boolean isStrMatch(String strDef, String str) {

		if (!StringUtil.isEmpty(strDef)) {

			if (StringUtil.isEmpty(str)) {
				return false;
			}

			if (strDef.equals(str)) {
				return true;
			}

		}
		return true;
	}

}
