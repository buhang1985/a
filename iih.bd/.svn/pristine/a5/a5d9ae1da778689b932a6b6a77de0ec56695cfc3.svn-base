package iih.bd.fc.s.bp.batwfexdept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.s.bp.wfexdept.GetOrExDepAfterFilterBp;
import iih.bd.fc.s.bp.wfexdept.GetOrExDepInitialBp;
import iih.bd.fc.s.bp.wfexdept.GetOrExDepResultBp;
import iih.bd.fc.s.bp.wfexdept.GetOrExDepValidationBp;
import iih.bd.fc.wf.d.WfAggDO;
import iih.bd.fc.wf.d.WfDepDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

/**
 * 批量获取医嘱执行、物资流向
 * 
 * @author Administrator
 * @version xuxing_2018年6月27日20:48:18（批量逻辑复用单个的逻辑）
 *
 */
public class GetOrExDeptBatchBP {

	/**
	 * 主入口
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public OrWfExDeptParamDTO[] exec(OrWfExDeptParamDTO[] params) throws BizException {

		// 1、有效性判断
		GetOrExDepValidationBp bp = new GetOrExDepValidationBp();
		if (!bp.exec(params))
			return null;

		// 2、根就诊类型 服务类型获取流向集合
		HashMap<OrWfExDeptParamDTO, List<WfAggDO>> mapwfAggs = getIniWfCollection(params);
		if (mapwfAggs == null || mapwfAggs.size() < 1)
			return params;

		// 3、获取参数匹配部门之间对应关系
		HashMap<OrWfExDeptParamDTO, List<WfDepDO>> mapRelation = getFilterDeptDOS(mapwfAggs, params);

		// 4、处理排序，部门实例化
		OrWfExDeptParamDTO[] rtn = getWfResultDept(mapRelation);

		return rtn;
	}

	private HashMap<String, Integer> mapEuFlow;

	/**
	 * 根就诊类型 服务类型获取流向集合
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private HashMap<OrWfExDeptParamDTO, List<WfAggDO>> getIniWfCollection(OrWfExDeptParamDTO[] params) throws BizException {
		GetOrExDepInitialBp bp = new GetOrExDepInitialBp();
		return bp.exec(params);
	}

	/**
	 * 获取过滤后的刘流向科室集合
	 * 
	 * @param aggDOS
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private HashMap<OrWfExDeptParamDTO, List<WfDepDO>> getFilterDeptDOS(HashMap<OrWfExDeptParamDTO, List<WfAggDO>> mapwfAggs, OrWfExDeptParamDTO[] params) throws BizException {
		HashMap<OrWfExDeptParamDTO, List<WfDepDO>> reMap = new HashMap<OrWfExDeptParamDTO, List<WfDepDO>>();
		GetOrExDepAfterFilterBp bp = new GetOrExDepAfterFilterBp();
		Iterator iter = mapwfAggs.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			OrWfExDeptParamDTO param = (OrWfExDeptParamDTO) entry.getKey();
			List<WfAggDO> listAgg = (List<WfAggDO>) entry.getValue();
			if (param != null && listAgg != null && listAgg.size() > 0) {
				setEuFlow(listAgg);
				List<WfDepDO> listDept = bp.exec(listAgg.toArray(new WfAggDO[0]), param);
				reMap.put(param, listDept);
			}
		}
		return reMap;
	}

	/**
	 * 记录执行流向类型
	 * 
	 * @param list
	 */
	private void setEuFlow(List<WfAggDO> list) {
		if (mapEuFlow == null)
			mapEuFlow = new HashMap<String, Integer>();// 记录流向的类型
		for (WfAggDO wfAggDO : list) {
			mapEuFlow.put(wfAggDO.getParentDO().getId_wf(), wfAggDO.getParentDO().getEu_wftp());
		}
	}

	/**
	 * 获取医嘱流向结果
	 * 
	 * @param listWfDepts
	 * @param wfAggDOS
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private OrWfExDeptParamDTO[] getWfResultDept(HashMap<OrWfExDeptParamDTO, List<WfDepDO>> map) throws BizException {
		List<OrWfExDeptParamDTO> reList = new ArrayList<OrWfExDeptParamDTO>();
		GetOrExDepResultBp bp = new GetOrExDepResultBp();
		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			OrWfExDeptParamDTO param = (OrWfExDeptParamDTO) entry.getKey();
			List<WfDepDO> listWfdep = (List<WfDepDO>) entry.getValue();
			if (param != null && listWfdep != null && listWfdep.size() > 0) {
				OrWfExDeptDTO[] rtns = bp.exec(listWfdep, param, this.mapEuFlow);
				param.setRes(getArrayList(rtns));
			}
			reList.add(param);
		}
		return reList.toArray(new OrWfExDeptParamDTO[0]);
	}

	/**
	 * 集合转为FArrayList
	 * 
	 * @param depDTOS
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private FArrayList getArrayList(OrWfExDeptDTO[] params) {
		FArrayList reArray = new FArrayList();
		for (OrWfExDeptDTO param : params) {
			reArray.add(param);
		}
		return reArray;
	}
}
