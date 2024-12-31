package iih.bd.fc.s.bp.batwfexdept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.wf.d.EnumMacro;
import iih.bd.fc.wf.d.WfDepDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

/**
 * 
 * @author xu_xing
 * @version 2016-10-27,增肌“跟随医嘱”的宏标识，宏为“跟随医嘱”时，返回“执行科室”参数
 * @version 2016-11-22 参数中，回填宏执行科室
 * @version xuxing_2018年6月28日08:49:27(此逻辑废弃不用)
 */
public class GetOrExDepResultBatchBp {

	/**
	 * 主入口
	 * 
	 * @param map
	 * @return
	 * @throws BizException
	 */
	public OrWfExDeptParamDTO[] exec(HashMap<OrWfExDeptParamDTO, List<WfDepDO>> map) throws BizException {

		// 1、实例化所有涉及的部门信息
		Map<String, DeptDO> mapDept = initDeptInfo(map);

		// 2、组装返回结果
		OrWfExDeptParamDTO[] rtn = packageRrn(map, mapDept);

		return rtn;
	}

	/**
	 * 实例化所有部门信息
	 * 
	 * @param map
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Map<String, DeptDO> initDeptInfo(HashMap<OrWfExDeptParamDTO, List<WfDepDO>> map) throws BizException {

		List<WfDepDO> listWfDepts = new ArrayList<WfDepDO>();
		List<OrWfExDeptParamDTO> params = new ArrayList<OrWfExDeptParamDTO>();

		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {

			Map.Entry entry = (Map.Entry) iter.next();
			listWfDepts.addAll((List<WfDepDO>) entry.getValue());
			params.add((OrWfExDeptParamDTO) entry.getKey());
		}

		Map<String, DeptDO> reMap = getDeptDOS(listWfDepts, params);

		return reMap;
	}

	/**
	 * 获取涉及到的全部部门信息
	 * 
	 * @param listWfDepts
	 * @return
	 * @throws BizException
	 */
	private Map<String, DeptDO> getDeptDOS(List<WfDepDO> listWfDepts, List<OrWfExDeptParamDTO> params) throws BizException {

		Map<String, DeptDO> map = new HashMap<String, DeptDO>();

		List<String> listDept = new ArrayList<String>();

		for (WfDepDO dept : listWfDepts) {

			if (!listDept.contains(dept.getId_dep_mp())) {

				listDept.add(dept.getId_dep_mp());// 执行科室
			}
		}

		for (OrWfExDeptParamDTO param : params) {

			if (!listDept.contains(param.getId_dept_or())) {
				listDept.add(param.getId_dept_or());// 开单科室
			}

			if (!listDept.contains(param.getId_dept_en())) {
				listDept.add(param.getId_dept_en());// 就诊科室
			}

			if (!listDept.contains(param.getId_dept_ns())) {
				listDept.add(param.getId_dept_ns());// 护理科室
			}

			if (!listDept.contains(param.getId_dept_ex())) {
				listDept.add(param.getId_dept_ex());// 主执行科室
			}
		}

		IDeptRService findServce = ServiceFinder.find(IDeptRService.class);

		DeptDO[] depts = findServce.findByBIds(listDept.toArray(new String[listDept.size()]), FBoolean.FALSE);

		if (depts != null && depts.length > 0) {

			for (DeptDO deptDO : depts) {

				map.put(deptDO.getId_dep(), deptDO);
			}
		}

		return map;
	}

	/**
	 * 拼装返回结果
	 * 
	 * @param map
	 * @param mapDept
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private OrWfExDeptParamDTO[] packageRrn(HashMap<OrWfExDeptParamDTO, List<WfDepDO>> map, Map<String, DeptDO> mapDept) {

		List<OrWfExDeptParamDTO> reList = new ArrayList<OrWfExDeptParamDTO>();

		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {

			Map.Entry entry = (Map.Entry) iter.next();

			OrWfExDeptParamDTO param = (OrWfExDeptParamDTO) entry.getKey();
			OrWfExDeptDTO[] depDTOS = mergeDept((List<WfDepDO>) entry.getValue(), param);

			// 排序
			sortDept(depDTOS);

			// 设置部门信息
			setDeptInfo(mapDept, depDTOS);

			// 数组转换为FArrayList
			FArrayList array = getArrayList(depDTOS);

			// 设值
			param.setRes(array);

			reList.add(param);
		}

		return reList.toArray(new OrWfExDeptParamDTO[reList.size()]);

	}

	/**
	 * 获取返回值集合
	 * 
	 * @param listWfDepts
	 * @param wfAggDOS
	 * @param param
	 * @return
	 */
	private OrWfExDeptDTO[] mergeDept(List<WfDepDO> listWfDepts, OrWfExDeptParamDTO param) {

		List<OrWfExDeptDTO> listDept = new ArrayList<OrWfExDeptDTO>();

		for (WfDepDO dept : listWfDepts) {

			// 2016-11-22参数中，回填宏执行科室
			param.setEu_macrodepmp(dept.getEu_macrodepmp());

			// 2016-10-27,增肌“跟随医嘱”的宏标识，宏为“跟随医嘱”时，返回“执行科室”参数
			String id_dep = "";
			if (!EnumMacro.FOLLOWOR.equals(dept.getEu_macrodepmp())) {
				id_dep = getDeptID(dept, param);
				if (StringUtil.isEmpty(id_dep)) {
					continue;
				}
			}

			OrWfExDeptDTO DTO = new OrWfExDeptDTO();
			DTO.setSortno(dept.getSortno());// 序号
			DTO.setId_org(dept.getId_org_mp());// 机构ID
			DTO.setCode_org(dept.getCode_org());// 机构编码
			DTO.setName_org(dept.getName_org());// 机构名称

			DTO.setId_dept(id_dep);// 执行科室ID
			DTO.setEu_wftp(dept.getEu_wftp());// 流向类型
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
	private String getDeptID(WfDepDO dept, OrWfExDeptParamDTO param) {

		String Id_dept = "";

		if (dept.getFg_macro().equals(FBoolean.TRUE)) {

			if (EnumMacro.ORDERDEP.equals(dept.getEu_macrodepmp())) {
				Id_dept = param.getId_dept_or();// 开立科室
			}

			if (EnumMacro.ENTDEP.equals(dept.getEu_macrodepmp())) {
				Id_dept = param.getId_dept_en();// 就诊科室
			}

			if (EnumMacro.ENTWARD.equals(dept.getEu_macrodepmp())) {
				Id_dept = param.getId_dept_ns();// 护理单元
			}

		} else {

			Id_dept = dept.getId_dep_mp();
		}

		return Id_dept;
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

	/**
	 * 填补部门名称编码字段
	 * 
	 * @param map
	 * @param rtn
	 */
	private void setDeptInfo(Map<String, DeptDO> map, OrWfExDeptDTO[] rtn) {

		if (rtn != null && rtn.length > 0) {

			for (OrWfExDeptDTO orWfExDeptDTO : rtn) {

				if (!StringUtil.isEmpty(orWfExDeptDTO.getId_dept())) {

					DeptDO deptDO = map.get(orWfExDeptDTO.getId_dept());

					if (deptDO != null) {

						orWfExDeptDTO.setCode_dept(deptDO.getCode());// 部门编码
						orWfExDeptDTO.setName_dept(deptDO.getName());// 部门名称
					}
				}
			}
		}
	}

	/**
	 * 集合转为FArrayList
	 * 
	 * @param depDTOS
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private FArrayList getArrayList(OrWfExDeptDTO[] depDTOS) {

		FArrayList reArray = new FArrayList();

		for (OrWfExDeptDTO dept : depDTOS) {

			reArray.add(dept);
		}

		return reArray;
	}

}
