package iih.mp.nr.mpwardprint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import iih.mp.nr.dto.mpwardprint.d.MpOrPrnPlanSrvDTO;
import iih.mp.nr.dto.mpwardprint.d.WardPrntCondDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 病区执行打印按服务维度分组处理（执行单）
 * 
 * @author fengjj
 * @date 2019年3月15日18:09:20 创建
 * @version xuxing_2019年5月24日09:54:28，迭代
 * @version xuxing
 */
public class GetMpPrnPlanSrvInfosBp {

	/**
	 * 按服务维度分组处理 主入口
	 * 
	 * @param args
	 * @throws BizException
	 * @throws IOException
	 */
	public List<MpOrPrnPlanSrvDTO> exec(String inParam) throws BizException, IOException {

		// 1.参数解析
		WardPrntCondDTO param = paramAnalyze(inParam);

		// 2.获取数据
		List<MpOrPrnPlanSrvDTO> listDatas = getPlanSrvData(param);

		// 3、分组
		boolean fg_plan_fold = (new FBoolean(param.getFg_plan_fold())).booleanValue();
		LinkedHashMap<String, LinkedList<MpOrPrnPlanSrvDTO>> map = mapParam(listDatas, fg_plan_fold);

		// 4、数据处理(计算序号及成组符号)
		List<MpOrPrnPlanSrvDTO> rtns = handleData(map, fg_plan_fold);

		return rtns;
	}

	/**
	 * 参数解析
	 * 
	 * @param param
	 * @throws BizException
	 * @throws IOException
	 */
	private WardPrntCondDTO paramAnalyze(String param) throws BizException, IOException {
		if (param == null || param.length() <= 0)
			throw new BizException("报表参数不能为空!");
		WardPrntCondDTO rtn = new WardPrntCondDTO();
		rtn.deSerializeJson(param);
		return rtn;
	}

	/**
	 * 获取所有的srv数据
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private List<MpOrPrnPlanSrvDTO> getPlanSrvData(WardPrntCondDTO param) throws BizException {
		GetSrvPlanCommonBp bp = new GetSrvPlanCommonBp();
		return bp.exec(param);
	}

	/**
	 * 分组
	 * 
	 * @param listParam
	 * @param mapDtPlan
	 * @return
	 */
	private LinkedHashMap<String, LinkedList<MpOrPrnPlanSrvDTO>> mapParam(List<MpOrPrnPlanSrvDTO> listParam, boolean fg_unfold) {
		LinkedHashMap<String, LinkedList<MpOrPrnPlanSrvDTO>> reMap = new LinkedHashMap<String, LinkedList<MpOrPrnPlanSrvDTO>>();
		HashMap<String, List<String>> mapPlan = new HashMap<String, List<String>>();
		if (listParam != null && listParam.size() > 0) {
			for (MpOrPrnPlanSrvDTO param : listParam) {
				// map中不存在id_or 则添加
				if (!mapPlan.containsKey(param.getId_or())) {
					List<String> list = new ArrayList<String>();
					list.add(param.getId_or_pr());
					mapPlan.put(param.getId_or(), list);
				}
				// 存在则取第一条计划
				String id_or_pr = mapPlan.get(param.getId_or()).get(0);
				// 日次多张卡
				if (fg_unfold) {
					InitDrugList(reMap, param);
				}
				// 非日次多张卡时，取一顿计划作为显示
				if (!fg_unfold && id_or_pr.equals(param.getId_or_pr())) {
					InitDrugList(reMap, param);
				}
			}
		}
		return reMap;
	}

	/**
	 * 获取药品列表
	 * 
	 * @param reMap
	 * @param param
	 */
	private void InitDrugList(LinkedHashMap<String, LinkedList<MpOrPrnPlanSrvDTO>> reMap, MpOrPrnPlanSrvDTO param) {
		if (reMap.containsKey(param.getId_or())) {
			reMap.get(param.getId_or()).add(param);
		} else {
			LinkedList<MpOrPrnPlanSrvDTO> list = new LinkedList<MpOrPrnPlanSrvDTO>();
			list.add(param);
			reMap.put(param.getId_or(), list);
		}
	}

	/**
	 * 结果处理
	 * 
	 * @param list
	 * @return
	 */
	private List<MpOrPrnPlanSrvDTO> handleData(LinkedHashMap<String, LinkedList<MpOrPrnPlanSrvDTO>> map, boolean fg_unfold) {
		LinkedList<MpOrPrnPlanSrvDTO> reList = new LinkedList<MpOrPrnPlanSrvDTO>();
		if (map != null && map.size() > 0) {
			for (String id_or : map.keySet()) {
				LinkedList<MpOrPrnPlanSrvDTO> listRtn = map.get(id_or);
				// 数据的行处理
				setData(listRtn, fg_unfold);
				reList.addAll(listRtn);
			}
		}
		return reList;
	}

	/**
	 * 数据的行处理
	 * 
	 * @param listRtn
	 * @param listDtPlan
	 */
	private void setData(LinkedList<MpOrPrnPlanSrvDTO> listRtn, Boolean fg_unfold) {
		// 判断是否需要按id_or_pr分组
		if (fg_unfold && listRtn.size() >= 2) {
			LinkedHashMap<String, LinkedList<MpOrPrnPlanSrvDTO>> map = new LinkedHashMap<String, LinkedList<MpOrPrnPlanSrvDTO>>();
			for (MpOrPrnPlanSrvDTO param : listRtn) {
				if (!map.containsKey(param.getId_or_pr())) {
					LinkedList<MpOrPrnPlanSrvDTO> list = new LinkedList<MpOrPrnPlanSrvDTO>();
					list.add(param);
					map.put(param.getId_or_pr(), list);
				} else {
					map.get(param.getId_or_pr()).add(param);
				}
			}
			if (map != null && map.size() > 0) {
				for (String id_or_pr : map.keySet()) {
					LinkedList<MpOrPrnPlanSrvDTO> listRm = map.get(id_or_pr);
					setSymbol(listRm, fg_unfold);
				}
			}
		} else {
			setSymbol(listRtn, fg_unfold);
		}
	}

	/**
	 * 设置成组药符号 @param listRtn @param fg_unfold @throws
	 */
	private void setSymbol(LinkedList<MpOrPrnPlanSrvDTO> listRtn, boolean fg_unfold) {
		int index = 1;
		int length = listRtn.size();
		for (MpOrPrnPlanSrvDTO param : listRtn) {
			// 成组符号
			String symbolStr = " ";
			if (listRtn.size() == 2) {
				if (index == 1)
					symbolStr = "┏";
				if (index == 2)
					symbolStr = "┗";
			} else if (listRtn.size() > 2) {
				if (index == 1)
					symbolStr = "┏";
				else if (index == length)
					symbolStr = "┗";
				else
					symbolStr = "┃";
			}
			param.setContent_or_symbol(symbolStr + param.getName());
			index++;
		}
	}
}