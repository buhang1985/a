package iih.mp.nr.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import iih.mp.nr.dto.LiquidCheckDTO;
import iih.mp.nr.dto.PatLiquidCheckdDTO;
import xap.mw.core.utils.StringUtil;

/**
 * 液体核对卡和执行卡通用的数据处理逻辑
 * 
 * @ClassName: WardPrintUtils
 * @Description: TODO
 * @author Fengjj
 * @date 2018年8月31日 下午5:54:41
 * @version xuxing_2018年9月21日13:55:35，液体核对卡合并组，途径频次修改
 */
public class WardPrintUtils {

	/**
	 * 分组
	 * 
	 * @param listDatas
	 * @param mapDtPlan
	 * @param fg_unfold
	 * @return
	 */
	public static LinkedHashMap<String, PatLiquidCheckdDTO> groupData(List<LiquidCheckDTO> listDatas, HashMap<String, List<String>> mapDtPlan, boolean fg_unfold) {
		if (listDatas != null && listDatas.size() > 0) {
			// 存放结果
			LinkedHashMap<String, PatLiquidCheckdDTO> reMap = new LinkedHashMap<String, PatLiquidCheckdDTO>();
			// 标记map:key--id_or , value--List<id_or_pr>
			HashMap<String, List<String>> mapPlan = new HashMap<String, List<String>>();
			// 遍历
			for (LiquidCheckDTO liquidCheckDTO : listDatas) {
				// 判断医嘱id是否存在于mapplan中,不存在则添加
				if (!mapPlan.containsKey(liquidCheckDTO.getId_or())) {
					List<String> list = new ArrayList<String>();
					list.add(liquidCheckDTO.getId_or_pr());
					mapPlan.put(liquidCheckDTO.getId_or(), list);
				}
				// 如果存在的时候
				// 第一条计划
				String id_or_pr = mapPlan.get(liquidCheckDTO.getId_or()).get(0);
				// 实例化表头信息
				PatLiquidCheckdDTO title = getCardTitle(liquidCheckDTO, reMap);
				// 日次多张卡，都显示
				if (fg_unfold)
					initDrugList(title, liquidCheckDTO);
				// 非日次多张卡时，取一顿计划作为显示
				if (!fg_unfold && id_or_pr.equals(liquidCheckDTO.getId_or_pr()))
					initDrugList(title, liquidCheckDTO);

			}
			return reMap;
		}
		return null;
	}

	/**
	 * 实例化核对卡表头信息
	 * 
	 * @param liquidCheckDTO
	 * @param map
	 * @return
	 */
	private static PatLiquidCheckdDTO getCardTitle(LiquidCheckDTO liquidCheckDTO, HashMap<String, PatLiquidCheckdDTO> map) {
		if (map.containsKey(liquidCheckDTO.getId_ent())) {
			return map.get(liquidCheckDTO.getId_ent());
		} else {
			PatLiquidCheckdDTO rtn = new PatLiquidCheckdDTO();
			rtn.setName_pat(liquidCheckDTO.getName_pat());
			rtn.setName_dep_phy(liquidCheckDTO.getName_dep_phy());
			rtn.setCode_amr_ip(liquidCheckDTO.getCode_amr_ip());
			rtn.setBed_code(liquidCheckDTO.getBed_code());
			rtn.setDt_birth_pat(liquidCheckDTO.getDt_birth_pat());
			Date parse;
			try {
				parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(liquidCheckDTO.getDt_mp_plan());
				rtn.setDt_mp_plan(new SimpleDateFormat("yyyy年MM月dd日").format(parse));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			map.put(liquidCheckDTO.getId_ent(), rtn);
			return rtn;
		}
	}

	/**
	 * 获取药品列表
	 * 
	 * @param title
	 * @return
	 */
	private static void initDrugList(PatLiquidCheckdDTO title, LiquidCheckDTO liquidCheckDTO) {
		if (title.getInfolist() == null) {
			List<LiquidCheckDTO> list = new ArrayList<LiquidCheckDTO>();
			list.add(liquidCheckDTO);
			title.setInfolist(list);
			return;
		}
		title.getInfolist().add(liquidCheckDTO);
	}

	/**
	 * 数据处理
	 * 
	 * @param mapRtn
	 * @param mapDtPlan
	 * @return
	 */
	public static List<PatLiquidCheckdDTO> handleRtn(LinkedHashMap<String, PatLiquidCheckdDTO> mapRtn, HashMap<String, List<String>> mapDtPlan) {
		List<PatLiquidCheckdDTO> reList = new ArrayList<PatLiquidCheckdDTO>();
		if (mapRtn != null && mapRtn.size() > 0) {
			for (String id_ent : mapRtn.keySet()) {
				PatLiquidCheckdDTO infuDTO = mapRtn.get(id_ent);
				if (infuDTO != null) {
					List<LiquidCheckDTO> listDrug = infuDTO.getInfolist();
					if (listDrug != null) {
						List<String> listOr = new ArrayList<String>();
						// 根据医id_or_pr分组
						HashMap<String, List<LiquidCheckDTO>> mapListInfus = groupBaseDO(listDrug, listOr);
						// 用no控制显示时的序号
						int no = 1;
						for (String id_or : listOr) {
							// 药品明细
							List<LiquidCheckDTO> listInfu = mapListInfus.get(id_or);
							setSymbolStr(listInfu, no);
							no++;
						}
					}
					reList.add(infuDTO);
				}
			}
		}
		return reList;
	}

	/**
	 * BaseDO分组映射
	 * 
	 * @param params
	 * @param listOr
	 * @return
	 */
	public static HashMap<String, List<LiquidCheckDTO>> groupBaseDO(List<LiquidCheckDTO> params, List<String> listOr) {
		HashMap<String, List<LiquidCheckDTO>> reMap = new HashMap<String, List<LiquidCheckDTO>>();
		if (params != null && params.size() > 0) {
			for (LiquidCheckDTO t : params) {
				Object key = t.getId_or_pr();
				if (key == null)
					continue;
				if (!listOr.contains(key.toString()))
					listOr.add(key.toString());
				if (reMap.containsKey(key.toString())) {
					reMap.get(key.toString()).add(t);
				} else {
					List<LiquidCheckDTO> list = new ArrayList<LiquidCheckDTO>();
					list.add(t);
					reMap.put(key.toString(), list);
				}
			}
		}
		return reMap;
	}

	/**
	 * 设置序号
	 * 
	 * @param listDrug
	 * @param i
	 */
	private static void setSymbolStr(List<LiquidCheckDTO> listDrug, Integer no) {
		for (LiquidCheckDTO param : listDrug) {
			// 医疗要求
			if (!StringUtil.isEmptyWithTrim(param.getName_routedes()))
				param.setOrsrv_name(param.getOrsrv_name() + "(" + param.getName_routedes() + ")");
			// 规格
			if (!StringUtil.isEmptyWithTrim(param.getSpec()))
				param.setOrsrv_name(param.getOrsrv_name() + "/" + param.getSpec());
			// 设置显示序号
			if("Y".equals(param.getFg_highrisk())){
				param.setOrsrv_name("☆"+param.getOrsrv_name());
			}
			String symbolStr = no + "";
			param.setIndex(symbolStr);
		}
	}
}
