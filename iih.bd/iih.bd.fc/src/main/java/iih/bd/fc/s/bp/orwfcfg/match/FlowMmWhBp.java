package iih.bd.fc.s.bp.orwfcfg.match;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import iih.bd.fc.dto.deptflow.d.DeptFlowDTO;
import iih.bd.fc.dto.orwf.d.CfgFlowBas;
import iih.bd.fc.dto.orwf.d.WfCfgMmWhDTO;
import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.s.bp.common.WfUtils;
import iih.bd.fc.s.bp.orwfcfg.qry.GetDepInfoSql;
import iih.bd.fc.s.bp.orwfcfg.qry.GetMmStockSql;
import iih.bd.fc.wf.d.EnumMacro;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * @Description:停开库存校验，组装返回值
 * @author: xu_xing@founder.com.cn
 * @version：2019年4月28日 下午1:54:35 创建
 */
public class FlowMmWhBp {

	/**
	 * 主入口
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public OrWfExDeptParamDTO[] exec(HashMap<OrWfExDeptParamDTO, List<CfgFlowBas>> params) throws BizException {

		//1、基础校验
		if (params == null || params.size() < 1)
			return null;

		// 2、获取需要做仓库物品限制的科室
		List<String> listDept = new ArrayList<String>();
		List<String> listMm = new ArrayList<String>();
		String[] id_deps = getDeptIDs(params, listDept, listMm);

		//3、实例化全部科室信息
		initDeptInfo(listDept.toArray(new String[0]));

		//3、获取指定物品和仓库下的物品状态
		initMmWhSta(id_deps, listMm);

		//4、计算停开和库存，组装返回值
		OrWfExDeptParamDTO[] rtns = packetRtn(params);

		return rtns;
	}

	private List<String> listMmWhOut;
	private List<String> listMmStock;
	private HashMap<String, DeptFlowDTO> mapDep;

	/**
	 * 获取需要做仓库物品限制的科室
	 * 
	 * @param flowMap
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private String[] getDeptIDs(HashMap<OrWfExDeptParamDTO, List<CfgFlowBas>> flowMap, List<String> listDept, List<String> listMm) {
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
			List<CfgFlowBas> listFlow = (List<CfgFlowBas>) entry.getValue();
			if (listFlow == null || listFlow.size() < 1)
				continue;
			for (CfgFlowBas flow : listFlow) {
				String id_dep = getDeptInfo(flow, param);
				if (StringUtil.isEmptyWithTrim(id_dep))
					continue;
				// 此集合用于计算科室信息
				if (!listDept.contains(id_dep))
					listDept.add(id_dep);
				//无库存和停开校验的
				if (FBoolean.FALSE.equals(flow.getFg_mmwh()) && FBoolean.FALSE.equals(flow.getFg_stock()))
					continue;
				// 此集合用于计算物品仓库限制
				if (!reList.contains(id_dep))
					reList.add(id_dep);
			}
		}
		return reList.toArray(new String[0]);
	}

	/**
	 * 实例化全部科室信息
	 * @param id_deps
	 * @throws BizException
	 */
	private void initDeptInfo(String[] id_deps) throws BizException {
		mapDep = new HashMap<String, DeptFlowDTO>();
		if (id_deps == null || id_deps.length < 1)
			return;
		GetDepInfoSql sql = new GetDepInfoSql(id_deps);
		DeptFlowDTO[] rtns = (DeptFlowDTO[]) AppFwUtil.getDORstWithDao(sql, DeptFlowDTO.class);
		if (rtns == null || rtns.length < 1)
			return;
		mapDep = WfUtils.mapBaseDO(rtns, "Id_dep_mp");
	}

	/**
	 * 获取执行科室
	 * 
	 * @param dept
	 * @param param
	 * @return
	 */
	private String getDeptInfo(CfgFlowBas flow, OrWfExDeptParamDTO param) {
		if (flow.getFg_macro().equals(FBoolean.TRUE)) {
			if (EnumMacro.ORDERDEP.equals(flow.getEu_macro()))
				return param.getId_dept_or();// 开立科室
			if (EnumMacro.ENTDEP.equals(flow.getEu_macro()))
				return param.getId_dept_en();// 就诊科室
			// 2016-10-27,增肌“跟随医嘱”的宏标识，宏为“跟随医嘱”时，返回“执行科室”参数
			if (EnumMacro.FOLLOWOR.equals(flow.getEu_macro()))
				return param.getId_dept_ex();// 主医嘱执行科室
			if (EnumMacro.ENTWARD.equals(flow.getEu_macro()))
				return param.getId_dept_ns();// 护理单元
		} else {
			return flow.getId_dep_mp();
		}
		return null;
	}

	/**
	 * 获取指定物品和仓库下的物品状态
	 * @param listDept
	 * @param listMm
	 * @return
	 * @throws BizException
	 */
	private void initMmWhSta(String[] id_deps, List<String> listMm) throws BizException {
		listMmWhOut = new ArrayList<String>();
		listMmStock = new ArrayList<String>();
		GetMmStockSql sql = new GetMmStockSql(id_deps, listMm.toArray(new String[0]));
		WfCfgMmWhDTO[] rtns = (WfCfgMmWhDTO[]) AppFwUtil.getDORstWithDao(sql, WfCfgMmWhDTO.class);
		if (rtns == null || rtns.length < 1)
			return;
		for (WfCfgMmWhDTO mmwh : rtns) {
			String key = mmwh.getId_mm() + "|" + mmwh.getId_dep();
			if (!listMmWhOut.contains(key)) {
				//记录没有停开的
				if (FBoolean.FALSE.equals(mmwh.getFg_out()))
					listMmWhOut.add(key);
			}
			if (!listMmStock.contains(key)) {
				//记录有库存的
				if (mmwh.getQuan_usable().doubleValue() > 0)
					listMmStock.add(key);
			}
		}
	}

	/**
	 * 组装返回值
	 * 
	 * @param flowMap
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private OrWfExDeptParamDTO[] packetRtn(HashMap<OrWfExDeptParamDTO, List<CfgFlowBas>> flowMap) {
		List<OrWfExDeptParamDTO> reList = new ArrayList<OrWfExDeptParamDTO>();
		Iterator iter = flowMap.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			// key：入参（需要计算流向的参数）
			OrWfExDeptParamDTO param = (OrWfExDeptParamDTO) entry.getKey();
			if (param == null)
				continue;
			// value：入参计算之后的流向科室
			List<CfgFlowBas> listFlow = (List<CfgFlowBas>) entry.getValue();
			if (listFlow == null || listFlow.size() < 1){
				reList.add(param);
				continue;
			}
			//停开，库存校验
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
	private List<OrWfExDeptDTO> mergeDept(List<CfgFlowBas> listFlow, OrWfExDeptParamDTO param) {
		List<OrWfExDeptDTO> listDept = new ArrayList<OrWfExDeptDTO>();
		for (CfgFlowBas flow : listFlow) {
			String id_dep = getDeptInfo(flow, param);
			if (StringUtil.isEmpty(id_dep))
				continue;
			if (!StringUtil.isEmptyWithTrim(param.getId_mm())) {
				String key = param.getId_mm() + "|" + id_dep;
				//停开校验
				if (FBoolean.TRUE.equals(flow.getFg_mmwh())) {
					// 无未停开的记录
					if (!listMmWhOut.contains(key))
						continue;
				}
				//库存校验
				if (FBoolean.TRUE.equals(flow.getFg_stock())) {
					// 无未停开的记录
					if (!listMmStock.contains(key))
						continue;
				}
			}
			OrWfExDeptDTO DTO = new OrWfExDeptDTO();
			// 此属性用于调试用，并不实际返回
			DTO.setAttrVal("Id_wf_cfg", flow.getId_wf_cfg());
			DTO.setSortno(flow.getSortno());// 序号
			DTO.setId_dept(id_dep);// 执行科室ID
			if (mapDep.containsKey(DTO.getId_dept())) {
				DeptFlowDTO depInfo = mapDep.get(DTO.getId_dept());
				if (depInfo != null) {
					DTO.setName_dept(depInfo.getName_dep_mp());// 科室名称
					DTO.setId_org(depInfo.getId_org_mp());// 机构ID
					DTO.setCode_org(depInfo.getCode_org());// 机构编码
					DTO.setName_org(depInfo.getName_org());// 机构名称
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
