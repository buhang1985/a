package iih.bd.fc.s.bp.deptflow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import iih.bd.fc.dto.deptflow.d.DeptFlowDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.s.bp.common.WfUtils;
import iih.bd.fc.s.bp.deptflow.qry.GetSimpleSrvcaSql;
import iih.bd.srv.srvcate.d.SrvCateDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * @Description:流向匹配
 * @author: xu_xing@founder.com.cn
 * @version：2019年1月10日 下午1:38:35 创建
 */
public class FlowFilterBp {

	/**
	 * 主入口
	 * 
	 * @param params
	 * @param mapSrvca
	 * @return
	 * @throws BizException
	 */
	public HashMap<OrWfExDeptParamDTO, List<DeptFlowDTO>> exec(DeptFlowDTO[] flowParams, OrWfExDeptParamDTO[] params,
			HashMap<OrWfExDeptParamDTO, List<String>> mapParamAndWfRel) throws BizException {

		// 1、基础校验
		if (flowParams == null || flowParams.length < 1)
			return null;

		// 2、初始化服务分类信息
		initSrvcas(flowParams, params);

		// 3、逐一匹配
		HashMap<OrWfExDeptParamDTO, List<DeptFlowDTO>> rtns = filter(flowParams, params, mapParamAndWfRel);

		return rtns;
	}

	private HashMap<String, SrvCateDO> mapSrvca;

	/**
	 * 初始化服务分类信息
	 * 
	 * @param deptWfs
	 * @param params
	 * @throws BizException
	 */
	private void initSrvcas(DeptFlowDTO[] deptWfs, OrWfExDeptParamDTO[] params) throws BizException {
		List<String> listSrvcas = new ArrayList<String>();
		if (deptWfs != null && deptWfs.length > 0) {
			// 定义态中使用的服务分类ID收集
			for (DeptFlowDTO flow : deptWfs) {
				if (StringUtil.isEmptyWithTrim(flow.getId_srvcas()))
					continue;
				String[] id_srvcas = flow.getId_srvcas().split("\\,");
				listSrvcas.addAll(Arrays.asList(id_srvcas));
			}
		}
		if (params != null && params.length > 0) {
			// 业务中使用的服务分类ID收集
			for (OrWfExDeptParamDTO param : params) {
				if (StringUtil.isEmptyWithTrim(param.getId_srvca()))
					continue;
				listSrvcas.add(param.getId_srvca());
			}
		}
		String[] id_srvcas = WfUtils.getEffecFromList(listSrvcas);
		if (id_srvcas == null || id_srvcas.length < 1)
			return;
		GetSimpleSrvcaSql sql = new GetSimpleSrvcaSql(id_srvcas);
		SrvCateDO[] srvcas = (SrvCateDO[]) AppFwUtil.getDORstWithDao(sql, SrvCateDO.class);
		mapSrvca = WfUtils.mapBaseDO(srvcas, SrvCateDO.ID_SRVCA);
	}

	/**
	 * 逐一匹配
	 * 
	 * @param flowParams
	 * @param params
	 * @return
	 */
	private HashMap<OrWfExDeptParamDTO, List<DeptFlowDTO>> filter(DeptFlowDTO[] flowParams, OrWfExDeptParamDTO[] params,
			HashMap<OrWfExDeptParamDTO, List<String>> mapParamAndWfRel) {
		HashMap<OrWfExDeptParamDTO, List<DeptFlowDTO>> reMap = new HashMap<OrWfExDeptParamDTO, List<DeptFlowDTO>>();
		for (OrWfExDeptParamDTO param : params) {
			List<DeptFlowDTO> reList = new ArrayList<DeptFlowDTO>();
			if (!mapParamAndWfRel.containsKey(param))
				continue;
			List<String> listWf = mapParamAndWfRel.get(param);
			if (listWf != null && listWf.size() > 0) {
				for (DeptFlowDTO flow : flowParams) {
					if (!listWf.contains(flow.getId_wf()))
						continue;
					if (!isMatchSuccess(flow, param))
						continue;
					// 一个定义的流向可能匹配多次请求
					reList.add((DeptFlowDTO) flow.clone());
				}
			}
			reMap.put(param, reList);
		}
		return reMap;
	}

	/**
	 * 计算
	 * 
	 * @param wfDepDO
	 * @param param
	 * @return
	 */
	private boolean isMatchSuccess(DeptFlowDTO flow, OrWfExDeptParamDTO param) {
		// 用法
		if (!WfUtils.isStrsInclude(flow.getId_usgs(), param.getId_usage()))
			return false;
		// 长临标识
		if (!WfUtils.isStrMatchInt(flow.getOrdrecurtp(), param.getRecurstr()))
			return false;
		// 星期
		if (!WfUtils.isStrsIncludeStrs(flow.getSd_weeks(), param.getWeekno()))
			return false;
		// 时间
		if (!WfUtils.isTimeBetween(flow.getTime_b(), flow.getTime_e(), param.getTimestr()))
			return false;
		// 服务分类
		if (!srvcaInclude(flow.getId_srvcas(), param.getId_srvca()))
			return false;
		// 剂型(2018年6月21日09:28:58新增加)
		if (!WfUtils.isStrsInclude(flow.getId_dosages(), param.getId_dosage()))
			return false;
		// 物品(2018年6月27日15:11:55新增加)
		if (!WfUtils.isStrsInclude(flow.getId_mms(), param.getId_mm()))
			return false;
		// 草药剂型(2019年4月16日15:25:55新增加)
		if (!WfUtils.isStrsInclude(flow.getSd_herbpreparationtp(), param.getSd_herbpreparationtp()))
			return false;
		// 毒麻分类(2018年6月28日10:39:14新增加)
		if (!WfUtils.isStrsInclude(flow.getSd_pois(), param.getSd_pois()))
			return false;
		// 出院带药(2018年6月28日10:39:14新增加)
		if (!WfUtils.isEnumAndBoolMatch(flow.getEu_presoutpctr(), param.getFg_pres_outp()))
			return false;
		// 服务
		if (!WfUtils.isStrsInclude(flow.getId_srvs(), param.getId_srv()))
			return false;
		// 开单科室
		if (!WfUtils.isStrsIncludeStrs(flow.getId_dep_ors(), param.getId_dept_or()))
			return false;
		// 就诊科室
		if (!WfUtils.isStrsIncludeStrs(flow.getId_dep_clinics(), param.getId_dept_en()))
			return false;
		// 护理单元
		if (!WfUtils.isStrsIncludeStrs(flow.getId_dep_nurs(), param.getId_dept_ns()))
			return false;
		return true;
	}

	/**
	 * 服务分类匹配
	 * 
	 * @param id_srvcas
	 * @param id_srvca
	 * @param mapSrvca
	 * @return
	 */
	private boolean srvcaInclude(String id_srvcas, String id_srvca) {
		// 定义态流向服务分类为空，任何都能匹配
		if (id_srvcas == null)
			return true;
		// 流向服务分类不为空，入参为空，任何都不能匹配
		if (StringUtil.isEmptyWithTrim(id_srvca))
			return false;
		List<String> listSrvca = getSrvcaInnercode(id_srvcas);
		if (listSrvca.size() < 1)
			return false;// 此种情况由于配置的服务分类无法找到导致
		SrvCateDO paramSrvcaDO = mapSrvca.get(id_srvca);
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
	private List<String> getSrvcaInnercode(String id_srvcas) {
		List<String> reList = new ArrayList<String>();
		for (String id_srvca : id_srvcas.split(",")) {
			SrvCateDO srvcaDO = mapSrvca.get(id_srvca);
			reList.add(srvcaDO.getInnercode());
			setChildren(srvcaDO.getInnercode(), reList, mapSrvca);
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
	private void setChildren(String innercode, List<String> reList, HashMap<String, SrvCateDO> mapSrvca) {
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
}
