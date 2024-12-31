package iih.bd.fc.s.bp.deptflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import iih.bd.fc.dto.deptflow.d.DeptFlowDTO;
import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.s.bp.common.WfUtils;
import iih.bd.fc.s.bp.deptflow.qry.GetDeptInfoSql;
import iih.bd.fc.s.bp.deptflow.qry.GetWfDepMmRelSql;
import iih.bd.fc.wf.d.EnumMacro;
import iih.bd.fc.wfdepmm.d.WfDepMmDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * @Description:物品仓库限制处理，构建返回值
 * @author: xu_xing@founder.com.cn
 * @version：2019年1月10日 下午3:15:56 创建
 */
public class PkgWfDeptRtnBp {

	/**
	 * 物品科室关系
	 */
	private HashMap<String, List<String>> mapDepMm;
	private HashMap<String, DeptFlowDTO> depInfoMap;

	/**
	 * 主入口
	 * 
	 * @param flowMap
	 * @throws BizException
	 */
	public OrWfExDeptParamDTO[] exec(HashMap<OrWfExDeptParamDTO, List<DeptFlowDTO>> flowMap) throws BizException {

		// 1、基础校验
		if (flowMap == null || flowMap.size() < 1)
			return null;

		// 2、获取需要做仓库物品限制的科室
		List<String> listDept = new ArrayList<String>();
		List<String> listMm = new ArrayList<String>();
		String[] id_deps = getDeptIDs(flowMap, listDept, listMm);

		// 3、实例化科室物品关系
		initDepMmMap(id_deps, listMm.toArray(new String[0]));

		// 4、实例化科室基本信息
		initDeptInfo(listDept.toArray(new String[0]));

		// 5、构建返回值
		OrWfExDeptParamDTO[] rtns = packetRtn(flowMap);

		return rtns;
	}

	/**
	 * 获取需要做仓库物品限制的科室
	 * 
	 * @param flowMap
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private String[] getDeptIDs(HashMap<OrWfExDeptParamDTO, List<DeptFlowDTO>> flowMap, List<String> listDept, List<String> listMm) {
		List<String> reList = new ArrayList<String>();
		Iterator iter = flowMap.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			// key：入参（需要计算流向的参数）
			OrWfExDeptParamDTO param = (OrWfExDeptParamDTO) entry.getKey();
			if (param == null)
				continue;
			// 记录本次入参中的全部物品信息
			if (!StringUtil.isEmptyWithTrim(param.getId_mm()) && !listMm.contains(param.getId_mm()))
				listMm.add(param.getId_mm());
			// value：入参计算之后的流向科室
			List<DeptFlowDTO> listFlow = (List<DeptFlowDTO>) entry.getValue();
			if (listFlow == null || listFlow.size() < 1)
				continue;
			for (DeptFlowDTO flow : listFlow) {
				String[] id_dep = getDeptInfo(flow, param);
				if (StringUtil.isEmptyWithTrim(id_dep[0]))
					continue;
				// 此集合用于计算科室信息
				if (!listDept.contains(id_dep[0]))
					listDept.add(id_dep[0]);
				if (FBoolean.FALSE.equals(flow.getFg_mmwh()))
					continue;
				// 此集合用于计算物品仓库限制
				if (!reList.contains(id_dep[0]))
					reList.add(id_dep[0]);
			}
		}
		return reList.toArray(new String[0]);
	}

	/**
	 * 实例化部门信息
	 * 
	 * @param id_deps
	 * @return
	 * @throws BizException
	 */
	private void initDeptInfo(String[] id_deps) throws BizException {
		GetDeptInfoSql sql = new GetDeptInfoSql(id_deps);
		DeptFlowDTO[] rtns = (DeptFlowDTO[]) AppFwUtil.getDORstWithDao(sql, DeptFlowDTO.class);
		if (rtns == null || rtns.length < 1)
			return;
		depInfoMap = WfUtils.mapBaseDO(rtns, "Id_dep_mp");
	}

	/**
	 * 获取执行科室
	 * 
	 * @param dept
	 * @param param
	 * @return
	 */
	private String[] getDeptInfo(DeptFlowDTO flow, OrWfExDeptParamDTO param) {
		String[] rtns = new String[2];
		if (flow.getFg_macro().equals(FBoolean.TRUE)) {
			if (EnumMacro.ORDERDEP.equals(flow.getEu_macrodepmp()))
				rtns[0] = param.getId_dept_or();// 开立科室
			if (EnumMacro.ENTDEP.equals(flow.getEu_macrodepmp()))
				rtns[0] = param.getId_dept_en();// 就诊科室
			// 2016-10-27,增肌“跟随医嘱”的宏标识，宏为“跟随医嘱”时，返回“执行科室”参数
			if (EnumMacro.FOLLOWOR.equals(flow.getEu_macrodepmp()))
				rtns[0] = param.getId_dept_ex();// 主医嘱执行科室
			if (EnumMacro.ENTWARD.equals(flow.getEu_macrodepmp()))
				rtns[0] = param.getId_dept_ns();// 护理单元
		} else {
			rtns[0] = flow.getId_dep_mp();
			rtns[1] = flow.getName_dep_mp();
		}
		return rtns;
	}

	/**
	 * 实例化科室物品关系
	 * 
	 * @param list
	 * @return
	 * @throws BizException
	 */
	private void initDepMmMap(String[] id_deps, String[] id_mms) throws BizException {
		mapDepMm = new HashMap<String, List<String>>();
		if (id_deps == null || id_deps.length < 1)
			return;
		if (id_mms == null || id_mms.length < 1)
			return;
		GetWfDepMmRelSql sql = new GetWfDepMmRelSql(id_deps, id_mms);
		WfDepMmDTO[] wfDepMmDTOS = (WfDepMmDTO[]) AppFwUtil.getDORstWithDao(sql, WfDepMmDTO.class);
		if (wfDepMmDTOS == null || wfDepMmDTOS.length < 1)
			return;
		mapDepMm = WfUtils.groupBaseDO(wfDepMmDTOS, "Id_dep", "Id_mm");
	}

	/**
	 * 组装返回值
	 * 
	 * @param flowMap
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private OrWfExDeptParamDTO[] packetRtn(HashMap<OrWfExDeptParamDTO, List<DeptFlowDTO>> flowMap) {
		List<OrWfExDeptParamDTO> reList = new ArrayList<OrWfExDeptParamDTO>();
		Iterator iter = flowMap.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			// key：入参（需要计算流向的参数）
			OrWfExDeptParamDTO param = (OrWfExDeptParamDTO) entry.getKey();
			if (param == null)
				continue;
			// value：入参计算之后的流向科室
			List<DeptFlowDTO> listFlow = (List<DeptFlowDTO>) entry.getValue();
			if (listFlow == null || listFlow.size() < 1) {
				reList.add(param);
				continue;
			}
			List<OrWfExDeptDTO> wfDeptRtn = mergeDept(listFlow, param);
			// 排序
			sortDept(wfDeptRtn);
			FArrayList array = new FArrayList();
			array.addAll(wfDeptRtn);
			param.setRes(array);
			reList.add(param);
		}
		return reList.toArray(new OrWfExDeptParamDTO[0]);
	}

	/**
	 * 获取返回值集合
	 * 
	 * @param listWfDepts
	 * @param wfAggDOS
	 * @param param
	 * @return
	 */
	private List<OrWfExDeptDTO> mergeDept(List<DeptFlowDTO> listFlow, OrWfExDeptParamDTO param) {
		List<OrWfExDeptDTO> listDept = new ArrayList<OrWfExDeptDTO>();
		for (DeptFlowDTO flow : listFlow) {
			String[] id_dep = getDeptInfo(flow, param);
			if (StringUtil.isEmpty(id_dep[0]))
				continue;
			if (FBoolean.TRUE.equals(flow.getFg_mmwh())) {
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
			// 此属性用于调试用，并不实际返回
			DTO.setAttrVal("Id_wfdep", flow.getId_wfdep());
			DTO.setSortno(flow.getSortno());// 序号
			DTO.setId_dept(id_dep[0]);// 执行科室ID
			if (depInfoMap.containsKey(DTO.getId_dept())) {
				DeptFlowDTO depInfo = depInfoMap.get(DTO.getId_dept());
				if (depInfo != null) {
					DTO.setName_dept(depInfo.getName_dep_mp());// 科室名称
					DTO.setId_org(depInfo.getId_org_mp());// 机构ID
					DTO.setCode_org(flow.getCode_org());// 机构编码
					DTO.setName_org(flow.getName_org());// 机构名称
				}
			}
			DTO.setEu_wftp(flow.getEu_wftp());// 流向类型
			listDept.add(DTO);
		}
		return listDept;
	}

	/**
	 * 对结果进行排序
	 * 
	 * @param deptDTOS
	 */
	private void sortDept(List<OrWfExDeptDTO> listRtns) {
		if (listRtns == null || listRtns.size() < 1)
			return;
		int len = listRtns.size();
		for (int i = 0; i < len - 1; i++) {
			int i_sortno = listRtns.get(i).getSortno();
			for (int j = i + 1; j < len; j++) {
				int j_sortno = listRtns.get(j).getSortno();
				if (i_sortno > j_sortno) {
					OrWfExDeptDTO temExchange = (OrWfExDeptDTO) listRtns.get(i).clone();
					listRtns.set(i, listRtns.get(j));
					listRtns.set(j, temExchange);
					i_sortno = listRtns.get(i).getSortno();
				}
			}
		}
	}
}
