package iih.mp.nr.opreport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
 
import iih.mp.nr.dto.pres.d.PreSkinTestDTO;
import xap.mw.core.utils.StringUtil;

/**
 * 门诊注射单（按分组打印）
 * 
 * @author fengjj
 * @version:2020年5月3日09:18:41,创建
 *
 */
public class GetInjectListByGrpBp extends GetInjectCommonBp {

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
		List<String> listgrp = new ArrayList<String>();
		// 根据no_grp分组
		HashMap<String, List<PreSkinTestDTO>> mapListInfus = groupByGrp(listDatas, listgrp);
		Set<Entry<String, List<PreSkinTestDTO>>> entrySet = mapListInfus.entrySet();
		// 设置no_grp 与id_or_pr对应关系
		HashMap<String, String> rel = getRel(entrySet);
		for (Entry<String, List<PreSkinTestDTO>> entry : entrySet) {
			PreSkinTestDTO dto = new PreSkinTestDTO();
			List<PreSkinTestDTO> list = entry.getValue();
			dto = list.get(0);
			Collections.sort(list, new Comparator<PreSkinTestDTO>() {
				@Override
				public int compare(PreSkinTestDTO dto1, PreSkinTestDTO dto2) {
					return dto1.getDis_grp_no().compareTo(dto2.getDis_grp_no());
				}
			});
			dto.setDrugarrays(list);
			dto.setId_or_pr(rel.get(entry.getKey()));
			rtns.add(dto);
		}
		return rtns;
	}

	/**
	 * 设置no_grp 与id_or_pr对应关系
	 * @param mapListInfus
	 * @return
	 */
	private HashMap<String, String> getRel(Set<Entry<String, List<PreSkinTestDTO>>> entrySet) {
		HashMap<String, String> rtn = new HashMap<String, String>(); 
		for (Entry<String, List<PreSkinTestDTO>> entry : entrySet) {
			List<PreSkinTestDTO> value = entry.getValue();
			String id_or_prs = "";
			for (PreSkinTestDTO preSkinTestDTO : value) {
				if (!id_or_prs.contains(preSkinTestDTO.getId_or_pr()))
					id_or_prs += (StringUtil.isEmptyWithTrim(id_or_prs) ? "" :  ",") + preSkinTestDTO.getId_or_pr();
			}
			rtn.put(entry.getKey(), id_or_prs);
		}
		return rtn;

	}

	/**
	 * 根据分组分组
	 * 
	 * @param listDatas
	 * @param listgrp
	 * @param listOr
	 * @return
	 */
	private HashMap<String, List<PreSkinTestDTO>> groupByGrp(List<PreSkinTestDTO> params, List<String> listgrp) {
		if (params == null || params.size() < 1)
			return null;
		HashMap<String, List<PreSkinTestDTO>> reMap = new HashMap<String, List<PreSkinTestDTO>>();
		if (params != null && params.size() > 0) {
			for (PreSkinTestDTO t : params) {
				Object key = t.getNo_grp();
				if (key == null) {
					// key为null是未分组的数据，将id_or_pr作为key,以便成组药组合
					if (listgrp.contains(t.getId_or_pr()))
						reMap.get(t.getId_or_pr()).add(t);
					else {
						listgrp.add(t.getId_or_pr());
						List<PreSkinTestDTO> list = new ArrayList<PreSkinTestDTO>();
						list.add(t);
						reMap.put(t.getId_or_pr(), list);
					}
					continue;
				}
				if (reMap.containsKey(key.toString())) {
					reMap.get(key.toString()).add(t);
				} else {
					listgrp.add(key.toString());
					List<PreSkinTestDTO> list = new ArrayList<PreSkinTestDTO>();
					list.add(t);
					reMap.put(key.toString(), list);
				}
			}
		}
		return reMap;
	}
}
