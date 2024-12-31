package iih.bl.inc.s.bp.inc.incsplit;

import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.pp.inccasplit.d.BdInccaSplitDO;
import iih.bl.inc.s.bp.inc.incsplit.data.IncSplitMaskDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;

/**
 * 发票分组核心逻辑(新版)
 * 
 * @author ly 2018/08/21
 */
public class IncSplitCoreBP {

	/*
	 * 返回值默认Key
	 */
	private final static String DEFAULT_KEY = "default";

	/*
	 * 条件和对应字段映射map 单据条件暂忽略
	 */
	private static Map<String, String> condFieldMap;
	
	/*
	 * 显示项和对应字段映射map 目前对按核算分组生效
	 */
	public static Map<String, String> dispFieldMap;

	static {
		condFieldMap = new HashMap<String, String>();
		condFieldMap.put(IBdPpCodeTypeConst.SD_SPLIT_CASE_DEPTOR,IncSplitMaskDTO.ID_DEP_OR);
		condFieldMap.put(IBdPpCodeTypeConst.SD_SPLIT_CASE_DEPTMP,IncSplitMaskDTO.ID_DEP_MP);
		condFieldMap.put(IBdPpCodeTypeConst.SD_SPLIT_CASE_DOCTOR,IncSplitMaskDTO.ID_EMP_OR);
		condFieldMap.put(IBdPpCodeTypeConst.SD_SPLIT_CASE_ENTIMES,IncSplitMaskDTO.ID_ENT);
		condFieldMap.put(IBdPpCodeTypeConst.SD_SPLIT_CASE_ORDER,IncSplitMaskDTO.ID_OR);
		
		dispFieldMap = new HashMap<String, String>();
		dispFieldMap.put(IBdPpCodeTypeConst.SD_DISPTP_DETAIL, IncSplitMaskDTO.ID_PK);
		dispFieldMap.put(IBdPpCodeTypeConst.SD_DISPTP_INCITM, IncSplitMaskDTO.CODE_INCCAITM);
		dispFieldMap.put(IBdPpCodeTypeConst.SD_DISPTP_ORDER, IncSplitMaskDTO.ID_OR);
		dispFieldMap.put(IBdPpCodeTypeConst.SD_DISPTP_ACCOUNT, IncSplitMaskDTO.CODE_ACCOUNT);
		dispFieldMap.put(IBdPpCodeTypeConst.SD_DISPTP_DETAILORDER, IncSplitMaskDTO.ID_PK);
		dispFieldMap.put(IBdPpCodeTypeConst.SD_DISPTP_DETAILINCITM, IncSplitMaskDTO.ID_PK);
		dispFieldMap.put(IBdPpCodeTypeConst.SD_DISPTP_DETAILINCITMORDER, IncSplitMaskDTO.ID_PK);
	}

	/**
	 * 发票分组
	 * 
	 * @param itmList 明细数据集合
	 * @param splitSet 分票配置
	 * @return 分组后的明细数据
	 * @throws BizException
	 */
	public Map<String, List<IncSplitMaskDTO>> split(BdInccaSplitDO splitSet, List<IncSplitMaskDTO> itmList)
			throws BizException {

		Map<String, List<IncSplitMaskDTO>> splitMap = null;

		// 备注：手工拆票暂不支持
		
		if(FBoolean.TRUE.equals(splitSet.getFg_splitbyaccount())){
			// 核算联分票
			splitMap = this.accSplit(splitSet, itmList);
		}else{
			// 主票分票
			splitMap = this.mainIncSplit(splitSet, itmList);
		}

		return splitMap;
	}

	/**
	 * 获取分组条件映射结果
	 * @param splitCase
	 * @return
	 */
	private String[] getSplitCondMapRlt(String splitCase){
		
		if(StringUtil.isEmpty(splitCase))
			return null;
		
		String[] conds =splitCase.split(",");
		List<String> condMapList = new ArrayList<String>();
		for (String cond : conds) {
			condMapList.add(condFieldMap.get(cond));
		}
		
		return condMapList.toArray(new String[0]);
	}
	
	/**
	 * 获取key组合
	 * 
	 * @param conds
	 * @param itm
	 * @return
	 */
	private String getSplitKey(String[] conds, IncSplitMaskDTO itm) {

		if (conds == null)
			return DEFAULT_KEY;

		String key = "";
		for (String cond : conds) {
			Object val = itm.getAttrVal(cond);
			key += val == null ? "_" : val.toString();
		}

		return key;
	}
	
	/**
	 * 主票分票逻辑
	 * @param splitSet
	 * @param itmList
	 * @return
	 */
	private Map<String, List<IncSplitMaskDTO>> mainIncSplit(BdInccaSplitDO splitSet,List<IncSplitMaskDTO> itmList)throws BizException {
		
		Map<String, List<IncSplitMaskDTO>> splitMap = new HashMap<String, List<IncSplitMaskDTO>>();
		
		// 分组条件
		String[] conds = this.getSplitCondMapRlt(splitSet.getSd_split_case());

		// 1.对数据进行分类分组
		Map<String, List<IncSplitMaskDTO>> condSplitMap = new HashMap<String, List<IncSplitMaskDTO>>();
		for (IncSplitMaskDTO itm : itmList) {
			String key = this.getSplitKey(conds, itm);

			List<IncSplitMaskDTO> list = null;
			if (condSplitMap.containsKey(key)) {
				list = condSplitMap.get(key);
			} else {
				list = new ArrayList<IncSplitMaskDTO>();
				condSplitMap.put(key, list);
			}

			list.add(itm);
		}
		
		// 数量上限判断
		if(splitSet.getItmbignum() == null || splitSet.getItmbignum() <= 0)
			return condSplitMap;

		// 2.对数据进行数量上限分组
		for (Entry<String, List<IncSplitMaskDTO>> entry : condSplitMap.entrySet()) {
			
			String groupKey = dispFieldMap.get(splitSet.getSd_disptp());
			Map<String, List<IncSplitMaskDTO>> limitSplitMap = this.mainIncLimitGroup(
					entry.getKey(), entry.getValue(), splitSet.getItmbignum(), groupKey);
			
			splitMap.putAll(limitSplitMap);
		}
		
		return splitMap;
	}
	
	/**
	 * 主票显示数据上限分组
	 * @param oldKey
	 * @param itmList
	 * @param max
	 * @param groupKey
	 * @return
	 * @throws BizException
	 */
	private Map<String, List<IncSplitMaskDTO>> mainIncLimitGroup(String oldKey,
			List<IncSplitMaskDTO> itmList, Integer max,String groupKey) throws BizException {
		
		// 按可以key进行分组
		List<String> splitItmList = new ArrayList<String>();
		Map<String, List<IncSplitMaskDTO>> splitItmMap = new HashMap<String, List<IncSplitMaskDTO>>();
		for (IncSplitMaskDTO itm : itmList) {

			List<IncSplitMaskDTO> subItmList = null;
			String value = itm.getAttrVal(groupKey) + "";
			if (splitItmList.contains(value)) {
				subItmList = splitItmMap.get(value);
			} else {
				splitItmList.add(value);
				subItmList = new ArrayList<IncSplitMaskDTO>();
				splitItmMap.put(value, subItmList);
			}
			subItmList.add(itm);
		}
		
		//上限分组
		Map<String, List<IncSplitMaskDTO>> splitMap = new HashMap<String, List<IncSplitMaskDTO>>();
		List<IncSplitMaskDTO> calList = null;
		for (int i = 0; i < splitItmList.size(); i++) {

			if (i % max == 0) {
				calList = new ArrayList<IncSplitMaskDTO>();
				splitMap.put(oldKey + "_" + (i / max), calList);
			}

			calList.addAll(splitItmMap.get(splitItmList.get(i)));
		}
		
		return splitMap;
	}

	/**
	 * 核算联分票
	 * @param splitSet
	 * @param itmList
	 * @return
	 * @throws BizException
	 */
	private Map<String, List<IncSplitMaskDTO>> accSplit(BdInccaSplitDO splitSet,List<IncSplitMaskDTO> itmList)throws BizException {
		
		Map<String, List<IncSplitMaskDTO>> splitMap = new HashMap<String, List<IncSplitMaskDTO>>();
		
		// 分组条件
		String[] conds = this.getSplitCondMapRlt(splitSet.getSd_split_acc_case());
		
		// 核算联显示项目也进入分组条件中
		String acCond = dispFieldMap.get(splitSet.getSd_ac_disptp());
		List<String> condList = new ArrayList<String>();
		condList.addAll(Arrays.asList(conds));
		condList.add(acCond);
		
		// 数据分组
		List<String> keyList = new ArrayList<String>();
		Map<String, List<IncSplitMaskDTO>> condSplitMap = new HashMap<String, List<IncSplitMaskDTO>>();
		for (IncSplitMaskDTO itm : itmList) {
			String key = this.getSplitKey(condList.toArray(new String[0]), itm);
			
			List<IncSplitMaskDTO> list = null;
			if (keyList.contains(key)) {
				list = condSplitMap.get(key);
			} else {
				keyList.add(key);
				list = new ArrayList<IncSplitMaskDTO>();
				condSplitMap.put(key, list);
			}

			list.add(itm);
		}
		
		// 根据显示数量进行分票
		List<IncSplitMaskDTO> calList = null;
		for (int i = 0; i < keyList.size(); i++) {
			
			if (i % splitSet.getCount_account() == 0) {
				calList = new ArrayList<IncSplitMaskDTO>();
				splitMap.put(DEFAULT_KEY + "_" + (i / splitSet.getCount_account()), calList);
			}

			calList.addAll(condSplitMap.get(keyList.get(i)));
		}
		
		return splitMap;
	} 
}
