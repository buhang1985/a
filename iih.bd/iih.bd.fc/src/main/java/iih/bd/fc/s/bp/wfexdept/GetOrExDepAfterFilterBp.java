package iih.bd.fc.s.bp.wfexdept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import iih.bd.fc.bdwfdepctr.d.DgCtrEnum;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.pub.BdFcAppUtils;
import iih.bd.fc.wf.d.OrRecurTypeEnum;
import iih.bd.fc.wf.d.WfAggDO;
import iih.bd.fc.wf.d.WfDepDO;
import iih.bd.srv.srvcate.d.SrvCateDO;
import iih.bd.srv.srvcate.i.ISrvcateRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 执行科室流向匹配逻辑
 * 
 * @author xuxing
 * @version 2018年6月21日09:22:24_xuxing
 */
public class GetOrExDepAfterFilterBp {

	/**
	 * 过滤初始的流向集合
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public List<WfDepDO> exec(WfAggDO[] aggDOS, OrWfExDeptParamDTO param) throws BizException {

		// 1、获取全部流向科室
		List<WfDepDO> listDept = getDeptDOS(aggDOS);

		// 2、实例化全部服务分类
		initSrvca(listDept);

		// 3、匹配流向参数
		List<WfDepDO> listAfterFilterDep = filter(listDept, param);

		return listAfterFilterDep;
	}

	private HashMap<String, SrvCateDO> mapSrvca;

	/**
	 * 获取全部流向科室集合
	 * 
	 * @param AggDOS
	 * @return
	 */
	private List<WfDepDO> getDeptDOS(WfAggDO[] AggDOS) {
		if (AggDOS != null && AggDOS.length > 0) {
			List<WfDepDO> reList = new ArrayList<WfDepDO>();
			for (WfAggDO wfAggDO : AggDOS) {
				WfDepDO[] wfDepDOS = wfAggDO.getWfDepDO();
				if (wfDepDOS != null && wfDepDOS.length > 0) {
					for (WfDepDO wfDepDO : wfDepDOS) {
						reList.add(wfDepDO);
					}
				}
			}
			return reList;
		}
		return null;
	}

	/**
	 * 实例化全部服务分类
	 * 
	 * @param listDept
	 * @return
	 * @throws BizException
	 */
	private void initSrvca(List<WfDepDO> listDept) throws BizException {
		// 批量流向多次调用此逻辑，仅查询一次
		if (mapSrvca != null)
			return;
		mapSrvca = new HashMap<String, SrvCateDO>();
		SrvCateDO[] rtns = ServiceFinder.find(ISrvcateRService.class).find("1=1", "", FBoolean.FALSE);
		if (rtns != null && rtns.length > 0) {
			for (SrvCateDO srvca : rtns) {
				mapSrvca.put(srvca.getId_srvca(), srvca);
			}
		}
	}

	/**
	 * 匹配流向参数
	 * 
	 * @param listDept
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	private List<WfDepDO> filter(List<WfDepDO> listDept, OrWfExDeptParamDTO param) throws BizException {
		List<WfDepDO> reList = new ArrayList<WfDepDO>();
		if (listDept != null && listDept.size() > 0) {
			for (WfDepDO wfDepDO : listDept) {
				if (matchCondition(wfDepDO, param)) {
					reList.add(wfDepDO);
				}
			}
		}
		return reList;
	}

	/**
	 * 校验：用法、长临、星期、时间、服务
	 * 
	 * @param wfDepDO
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	private boolean matchCondition(WfDepDO wfDepDO, OrWfExDeptParamDTO param) throws BizException {
		// 用法
		if (!isStrsInclude(wfDepDO.getId_usgs(), param.getId_usage()))
			return false;
		// 长临标识
		if (!isStrMatchInt(wfDepDO.getOrdrecurtp(), param.getRecurstr()))
			return false;
		// 星期
		if (!isStrsIncludeStrs(wfDepDO.getSd_weeks(), param.getWeekno()))
			return false;
		// 时间
		if (!isTimeBetween(wfDepDO.getTime_b(), wfDepDO.getTime_e(), param.getTimestr()))
			return false;
		// 服务分类
		if (!srvcaInclude(wfDepDO.getId_srvcas(), param.getId_srvca()))
			return false;
		// 剂型(2018年6月21日09:28:58新增加)
		if (!isStrsInclude(wfDepDO.getId_dosages(), param.getId_dosage()))
			return false;
		// 物品(2018年6月27日15:11:55新增加)
		if (!isStrsInclude(wfDepDO.getId_mms(), param.getId_mm()))
			return false;
		// 草药剂型(2019年4月16日15:18:55新增加)
		if (!isStrsInclude(wfDepDO.getSd_herbpreparationtp(), param.getSd_herbpreparationtp()))
			return false;
		// 毒麻分类(2018年6月28日10:39:14新增加)
		if (!isStrsInclude(wfDepDO.getSd_pois(), param.getSd_pois()))
			return false;
		// 出院带药(2018年6月28日10:39:14新增加)
		if (!isEnumAndBoolMatch(wfDepDO.getEu_presoutpctr(), param.getFg_pres_outp()))
			return false;
		// 服务
		if (!isStrsInclude(wfDepDO.getId_srvs(), param.getId_srv()))
			return false;
		// 开单科室
		if (!isStrsIncludeStrs(wfDepDO.getId_dep_ors(), param.getId_dept_or()))
			return false;
		// 就诊科室
		if (!isStrsIncludeStrs(wfDepDO.getId_dep_clinics(), param.getId_dept_en()))
			return false;
		// 护理单元
		if (!isStrsIncludeStrs(wfDepDO.getId_dep_nurs(), param.getId_dept_ns()))
			return false;
		return true;
	}

	/**
	 * 服务分类向下匹配
	 * 
	 * @param id_srvcas
	 * @param id_srvca_param
	 * @return
	 * @throws BizException 
	 */
	private boolean srvcaInclude(String id_srvcas, String id_srvca_param) throws BizException {
		// 流向服务分类为空，任何都能匹配
		if (id_srvcas == null)
			return true;
		// 流向服务分类不为空，入参为空，任何都不能匹配
		if (StringUtil.isEmptyWithTrim(id_srvca_param))
			return false;
		List<String> listSrvca = getSrvcaInnercode(id_srvcas);
		if (listSrvca.size() < 1)
			return false;// 此种情况由于配置的服务分类无法找到导致
		SrvCateDO paramSrvcaDO = mapSrvca.get(id_srvca_param);
		if (paramSrvcaDO == null)
			return false;// 不存在指定的服务分类
		return listSrvca.contains(paramSrvcaDO.getInnercode());
	}

	/**
	 * 获取服务分类串下的全部包括孩子分类的InnerCode
	 * 
	 * @param id_srvcas
	 * @param reList
	 */
	private List<String> getSrvcaInnercode(String id_srvcas) throws BizException {
		List<String> reList = new ArrayList<String>();
		for (String id_srvca : id_srvcas.split(",")) {
			SrvCateDO srvcaDO = mapSrvca.get(id_srvca);
			if (srvcaDO == null)
				throw new BizException("获取服务分类失败【" + id_srvca + "】");
			reList.add(srvcaDO.getInnercode());
			setChildren(srvcaDO.getInnercode(), reList);
		}
		return reList;
	}

	/**
	 * 遍历子服务分类
	 * 
	 * @param innercode
	 * @param reList
	 */
	@SuppressWarnings("rawtypes")
	private void setChildren(String innercode, List<String> reList) {
		Iterator iter = mapSrvca.keySet().iterator();
		while (iter.hasNext()) {
			SrvCateDO srvca = mapSrvca.get(iter.next());
			if (srvca.getInnercode().indexOf(innercode) == 0) {
				if (!reList.contains(srvca.getInnercode())) {
					reList.add(srvca.getInnercode());
				}
			}
		}
	}

	/**
	 * 字符串包含（键）校验（以逗号分割），字符串和键都非空才校验
	 * 
	 * @param strSplit
	 * @param str
	 * @return
	 */
	private boolean isStrsInclude(String strSplit, String str) {
		if (!StringUtil.isEmptyWithTrim(strSplit)) {
			if (StringUtil.isEmptyWithTrim(str))
				return false;
			for (String itm : strSplit.split(",")) {
				if (str.equals(itm))
					return true;
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
		if (!StringUtil.isEmptyWithTrim(strSplit)) {
			if (StringUtil.isEmptyWithTrim(strs)) {
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
		if (integ == null)
			return true;
		if (OrRecurTypeEnum.NULL.equals(integ))
			return true;
		if (StringUtil.isEmptyWithTrim(str))
			return false;
		if (!str.equals(integ + ""))
			return false;
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
		if (!StringUtil.isEmptyWithTrim(strDef)) {
			if (StringUtil.isEmptyWithTrim(str)) {
				return false;
			}
			if (strDef.equals(str)) {
				return true;
			}
		}
		return true;
	}

	/**
	 * 加急匹配
	 * 
	 * @param eu_urgent
	 * @param fg_urgent
	 * @return
	 */
	private boolean isEnumAndBoolMatch(Integer eu_enum, FBoolean fg_bool) {
		// 规则未设置，默认匹配
		if (eu_enum == null)
			return true;
		// 不限制
		if (eu_enum == DgCtrEnum.NOLIMIT)
			return true;
		// 加急
		if (eu_enum == DgCtrEnum.LIMIT_TRUE && FBoolean.TRUE.equals(fg_bool))
			return true;
		// 不加急
		if (eu_enum == DgCtrEnum.LIMIT_FALSE && FBoolean.FALSE.equals(fg_bool))
			return true;
		return false;
	}
}
