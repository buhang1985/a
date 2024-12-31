package iih.mp.nr.opreport;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import iih.mp.nr.dto.pres.d.PreSkinTestDTO;

/**
 * 皮试/注射处方单公共的处理数据方法
 * 
 * @author fengjj
 * @date 2019年3月20日18:52:11 创建
 *
 */
public class OpReUtil {

	/**
	 * 组装数据
	 * 
	 * @param listDatas
	 * @return
	 */
	public List<PreSkinTestDTO> packageData(List<PreSkinTestDTO> listDatas) {
		List<PreSkinTestDTO> rtns = new ArrayList<PreSkinTestDTO>();
		if (listDatas == null || listDatas.size() <= 0)
			return rtns;
		List<String> listOr = new ArrayList<String>();
		// 根据id_or_pr分组
		HashMap<String, List<PreSkinTestDTO>> mapListInfus = groupByOrPr(listDatas, listOr);
		Collection<List<PreSkinTestDTO>> values = mapListInfus.values();
		for (List<PreSkinTestDTO> list : values) {
			PreSkinTestDTO dto = new PreSkinTestDTO();
			dto = list.get(0);
			dto.setDrugarrays(list);
			rtns.add(dto);
		}
		return rtns;
	}

	/**
	 * 根据id_or_pr分组
	 * 
	 * @param paramss
	 * @param listOr
	 * @return
	 */
	private HashMap<String, List<PreSkinTestDTO>> groupByOrPr(List<PreSkinTestDTO> params, List<String> listOr) {
		HashMap<String, List<PreSkinTestDTO>> reMap = new HashMap<String, List<PreSkinTestDTO>>();
		if (params != null && params.size() > 0) {
			for (PreSkinTestDTO t : params) {
				Object key = t.getId_or_pr();
				if (key == null)
					continue;
				if (!listOr.contains(key.toString()))
					listOr.add(key.toString());
				if (reMap.containsKey(key.toString())) {
					reMap.get(key.toString()).add(t);
				} else {
					List<PreSkinTestDTO> list = new ArrayList<PreSkinTestDTO>();
					list.add(t);
					reMap.put(key.toString(), list);
				}
			}
		}
		return reMap;
	}
}
