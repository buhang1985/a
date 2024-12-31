package iih.bd.fc.s.bp.wfexdept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.s.bp.qry.GetWfDepMmInfoSql;
import iih.bd.fc.wf.d.EnumMacro;
import iih.bd.fc.wf.d.WfDepDO;
import iih.bd.fc.wfdepmm.d.WfDepMmDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

/**
 * 
 * 2016-10-27,增肌“跟随医嘱”的宏标识，宏为“跟随医嘱”时，返回“执行科室”参数
 * 
 * @version 2018年6月27日16:48:40_xuxing_物品目录限制
 */
public class GetOrExDepResultBp {

	/**
	 * 拼装流向科室集合
	 * 
	 * @param listWfDepts
	 * @return
	 * @throws BizException
	 */
	public OrWfExDeptDTO[] exec(List<WfDepDO> listWfDepts, OrWfExDeptParamDTO param, HashMap<String, Integer> mapEuFlow) throws BizException {

		// 1、校验
		if (listWfDepts == null || listWfDepts.size() == 0)
			return null;

		// 2、累计实例化科室物品关系
		initDepMm(listWfDepts, param);

		// 3、获取符合条件的流向科室
		OrWfExDeptDTO[] rtn = mergeDept(listWfDepts, param, mapEuFlow);

		// 4、填补科室名称编码
		setDeptInfo(rtn);

		// 5、排序
		sortDept(rtn);

		return rtn;
	}

	private HashMap<String, List<String>> mapDepMm;

	/**
	 * 累计实例化科室物品关系
	 * 
	 * @param listWfDepts
	 * @param param
	 * @throws BizException
	 */
	private void initDepMm(List<WfDepDO> listWfDepts, OrWfExDeptParamDTO param) throws BizException {
		// 首次实例化科室物品关系Map
		if (mapDepMm == null)
			mapDepMm = new HashMap<String, List<String>>();
		// 获取本次流向全部未对照物品的目标科室ID
		String[] id_deps = getDeptIds(listWfDepts, param);
		List<String> lietDep = new ArrayList<String>();
		if (id_deps != null && id_deps.length > 0) {
			for (String id_dep : id_deps) {
				if (!StringUtil.isEmptyWithTrim(id_dep) && !mapDepMm.containsKey(id_dep))
					lietDep.add(id_dep);
			}
		}
		// 获取科室物品关系
		if (lietDep.size() > 0)
			setDepMmMap(lietDep.toArray(new String[0]));
	}

	/**
	 * 获取本次流向全部的目标科室ID
	 * 
	 * @param listWfDepts
	 * @param param
	 * @return
	 */
	private String[] getDeptIds(List<WfDepDO> listWfDepts, OrWfExDeptParamDTO param) {
		List<String> reList = new ArrayList<String>();
		for (WfDepDO wfDep : listWfDepts) {
			if (FBoolean.FALSE.equals(wfDep.getFg_mmwh()))
				continue;
			String[] id_dep = getDeptID(wfDep, param);
			if (!reList.contains(id_dep[0]))
				reList.add(id_dep[0]);
		}
		return reList.toArray(new String[0]);
	}

	/**
	 * 获取科室物品关系
	 * 
	 * @param list
	 * @return
	 * @throws BizException
	 */
	private void setDepMmMap(String[] id_deps) throws BizException {
		if (id_deps == null || id_deps.length < 1)
			return;
		GetWfDepMmInfoSql sql = new GetWfDepMmInfoSql(id_deps);
		WfDepMmDTO[] wfDepMmDTOS = (WfDepMmDTO[]) AppFwUtil.getDORstWithDao(sql, WfDepMmDTO.class);
		if (wfDepMmDTOS != null && wfDepMmDTOS.length > 0) {
			if (wfDepMmDTOS != null && wfDepMmDTOS.length > 0) {
				for (WfDepMmDTO t : wfDepMmDTOS) {
					Object key = t.getId_dep();
					Object val = t.getId_mm();
					if (key == null || val == null)
						continue;
					if (mapDepMm.containsKey(key.toString())) {
						mapDepMm.get(key.toString()).add(val.toString());
					} else {
						List<String> list = new ArrayList<String>();
						list.add(val.toString());
						mapDepMm.put(key.toString(), list);
					}
				}
			}
		}
	}

	/**
	 * 获取返回值集合
	 * 
	 * @param listWfDepts
	 * @param wfAggDOS
	 * @param param
	 * @return
	 */
	private OrWfExDeptDTO[] mergeDept(List<WfDepDO> listWfDepts, OrWfExDeptParamDTO param, HashMap<String, Integer> mapEuFlow) {
		List<OrWfExDeptDTO> listDept = new ArrayList<OrWfExDeptDTO>();
		for (WfDepDO dept : listWfDepts) {

			// 2016-08-02，未取到科室ID时，本条记录不返回
			// 2016-10-27 代码位置调整
			String[] id_dep = getDeptID(dept, param);
			if (StringUtil.isEmpty(id_dep[0]))
				continue;

			// 启用了物品目录限制xuxing_2018年6月27日16:48:21
			if (FBoolean.TRUE.equals(dept.getFg_mmwh())) {
				// 该科室对应仓库下无药品
				if (!mapDepMm.containsKey(id_dep[0]))
					continue;
				List<String> listMm = mapDepMm.get(id_dep[0]);
				if (listMm == null || listMm.size() < 1)
					continue;

				// 该科室对应仓库下的药品中不包含本次开单的物品
				if (!listMm.contains(param.getId_mm()))
					continue;
			}

			OrWfExDeptDTO DTO = new OrWfExDeptDTO();
			DTO.setSortno(dept.getSortno());// 序号
			DTO.setId_org(dept.getId_org_mp());// 机构ID
			DTO.setCode_org(dept.getCode_org());// 机构编码
			DTO.setName_org(dept.getName_org());// 机构名称
			DTO.setId_dept(id_dep[0]);// 执行科室ID
			DTO.setName_dept(id_dep[1]);
			// 2018年7月3日09:46:22出参赋值流向类型
			if (mapEuFlow != null && mapEuFlow.containsKey(dept.getId_wf()))
				DTO.setEu_wftp(mapEuFlow.get(dept.getId_wf()));// 流向类型
			listDept.add(DTO);
		}
		return listDept.toArray(new OrWfExDeptDTO[listDept.size()]);
	}

	/**
	 * 获取执行科室
	 * 
	 * @param dept
	 * @param param
	 * @return
	 */
	private String[] getDeptID(WfDepDO dept, OrWfExDeptParamDTO param) {
		String[] Id_dept = new String[2];
		if (dept.getFg_macro().equals(FBoolean.TRUE)) {
			if (EnumMacro.ORDERDEP.equals(dept.getEu_macrodepmp()))
				Id_dept[0] = param.getId_dept_or();// 开立科室
			if (EnumMacro.ENTDEP.equals(dept.getEu_macrodepmp()))
				Id_dept[0] = param.getId_dept_en();// 就诊科室
			// 2016-10-27,增肌“跟随医嘱”的宏标识，宏为“跟随医嘱”时，返回“执行科室”参数
			if (EnumMacro.FOLLOWOR.equals(dept.getEu_macrodepmp()))
				Id_dept[0] = param.getId_dept_ex();// 主医嘱执行科室
			if (EnumMacro.ENTWARD.equals(dept.getEu_macrodepmp()))
				Id_dept[0] = param.getId_dept_ns();// 护理单元
		} else {
			Id_dept[0] = dept.getId_dep_mp();
			Id_dept[1] = dept.getName_dep_mp();
		}
		return Id_dept;
	}

	/**
	 * 填补部门名称编码字段
	 * 
	 * @param map
	 * @param rtn
	 * @throws BizException
	 */
	private void setDeptInfo(OrWfExDeptDTO[] rtn) throws BizException {
		List<String> listDept = new ArrayList<String>();
		if (rtn != null && rtn.length > 0) {
			for (OrWfExDeptDTO orWfExDeptDTO : rtn) {
				// 执行科室id非空 并且 没有执行科室名称 并且 不重复的执行科室id
				if (!StringUtil.isEmpty(orWfExDeptDTO.getId_dept()) && StringUtil.isEmpty(orWfExDeptDTO.getName_dept()) && !listDept.contains(orWfExDeptDTO.getId_dept())) {
					listDept.add(orWfExDeptDTO.getId_dept());
				}
			}
		}
		if (listDept.size() == 0)
			return;
		IDeptRService findServce = ServiceFinder.find(IDeptRService.class);
		DeptDO[] depts = findServce.findByBIds(listDept.toArray(new String[listDept.size()]), FBoolean.FALSE);
		Map<String, DeptDO> tmpDeptDOMap = new HashMap<String, DeptDO>();
		if (depts != null && depts.length > 0) {
			for (DeptDO deptDO : depts) {
				tmpDeptDOMap.put(deptDO.getId_dep(), deptDO);
			}
		}
		for (OrWfExDeptDTO wfExDo : rtn) {
			if (tmpDeptDOMap.containsKey(wfExDo.getId_dept())) {
				DeptDO dept = tmpDeptDOMap.get(wfExDo.getId_dept());
				wfExDo.setName_dept(dept.getName());
			}
		}
	}

	/**
	 * 对结果进行排序
	 * 
	 * @param deptDTOS
	 */
	private void sortDept(OrWfExDeptDTO[] deptDTOS) {
		if (deptDTOS != null && deptDTOS.length > 0) {
			for (int i = 0; i < deptDTOS.length - 1; i++) {
				for (int j = i + 1; j < deptDTOS.length; j++) {
					if (deptDTOS[i].getSortno() != null && deptDTOS[j].getSortno() != null) {
						if (deptDTOS[i].getSortno() > deptDTOS[j].getSortno()) {
							OrWfExDeptDTO temExchange = (OrWfExDeptDTO) deptDTOS[i].clone();
							deptDTOS[i] = (OrWfExDeptDTO) deptDTOS[j].clone();
							deptDTOS[j] = temExchange;
						}
					}
				}
			}
		}
	}
}
