package iih.en.pv.s.bp.ip.qry;

import iih.en.comm.IEnConst;
import iih.en.comm.IEnRuleConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.LvCheckOtherResultDTO;
import iih.en.pv.dto.d.TransDepPatDTO;
import iih.en.pv.inpatient.d.TransDepCheckStatus;
import iih.en.pv.inpatient.dto.d.EnIppreInfoDTO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import xap.lui.system.rulemgr.XapRuleAPI;
import xap.mw.core.data.BizException;

/**
 * 获取出院其他校验结果
 * 
 * @author liubin
 *
 */
public class GetLvCheckOtherResultsBP {
	
	/**
	 * 规则引擎调用key
	 */
	private static String KEY_ENT_IDS = "idEnts";
	private static String KEY_TRANSDEPPATDTOS = "transDepPatDtos";
	/**
     * 获取出院其他校验结果	
     * 
     * @param id_ent
     * @return
     * @throws BizException
     */
	public LvCheckOtherResultDTO[] exec(String[] id_ents) throws BizException { 
		if(EnValidator.isEmpty(id_ents))
			return null;
		Map<String, Object> varies = new HashMap<String, Object>();
		varies.put(KEY_ENT_IDS, id_ents);
		Map<String, Object> results = XapRuleAPI.exeRule(IEnRuleConst.EN_IP_LVHOSCHECK_CODE, varies);
		if(results != null){
			List<LvCheckOtherResultDTO> lvCheckOtherResults = new LinkedList<>();
			for(Entry<String, Object> result : results.entrySet()){
				LvCheckOtherResultDTO[] lvCheckOtherResultRules = (LvCheckOtherResultDTO[])result.getValue();
				if(!EnValidator.isEmpty(lvCheckOtherResultRules))
					lvCheckOtherResults.addAll(Arrays.asList(lvCheckOtherResultRules));
			}
			return EnValidator.isEmpty(lvCheckOtherResults) ? null : lvCheckOtherResults.toArray(new LvCheckOtherResultDTO[lvCheckOtherResults.size()]);
		}
		return null;
	}
	/***
	 * 获取转科其他校验结果
	 * 
	 * @param id_ents
	 * @return
	 */
	public LvCheckOtherResultDTO[] trancheck(String[] id_ents,TransDepPatDTO[] dtos){
		if(EnValidator.isEmpty(id_ents))
			return null;
		Map<String, Object> varies = new HashMap<String, Object>();
		varies.put(KEY_ENT_IDS, id_ents);
		varies.put(KEY_TRANSDEPPATDTOS, dtos);
		Map<String, Object> results = XapRuleAPI.exeRule(IEnRuleConst.EN_IP_TRANDEPCHECK_CODE, varies);
		if(results != null){
			List<LvCheckOtherResultDTO> lvCheckOtherResults = new LinkedList<>();
			for(Entry<String, Object> result : results.entrySet()){
				LvCheckOtherResultDTO[] lvCheckOtherResultRules = (LvCheckOtherResultDTO[])result.getValue();
				if(!EnValidator.isEmpty(lvCheckOtherResultRules))
					lvCheckOtherResults.addAll(Arrays.asList(lvCheckOtherResultRules));
			}
			return EnValidator.isEmpty(lvCheckOtherResults) ? null : lvCheckOtherResults.toArray(new LvCheckOtherResultDTO[lvCheckOtherResults.size()]);
		}
		return null;
	}
	
	/***
	 * 获取预住院转住院其他校验结果
	 * 
	 * @param id_ents
	 * @return
	 */
	public LvCheckOtherResultDTO[] trancheck(String[] id_ents,EnIppreInfoDTO[] dtos){
		if(EnValidator.isEmpty(id_ents))
			return null;
		Map<String, Object> varies = new HashMap<String, Object>();
		varies.put(KEY_ENT_IDS, id_ents);
		varies.put(KEY_TRANSDEPPATDTOS, dtos);
		Map<String, Object> results = XapRuleAPI.exeRule(IEnRuleConst.EN_IP_TRANDEPCHECK_CODE, varies);
		if(results != null){
			List<LvCheckOtherResultDTO> lvCheckOtherResults = new LinkedList<>();
			for(Entry<String, Object> result : results.entrySet()){
				LvCheckOtherResultDTO[] lvCheckOtherResultRules = (LvCheckOtherResultDTO[])result.getValue();
				if(!EnValidator.isEmpty(lvCheckOtherResultRules))
					lvCheckOtherResults.addAll(Arrays.asList(lvCheckOtherResultRules));
			}
			return EnValidator.isEmpty(lvCheckOtherResults) ? null : lvCheckOtherResults.toArray(new LvCheckOtherResultDTO[lvCheckOtherResults.size()]);
		}
		return null;
	}
	/**
	 * 组装返回结果
	 * 
	 * @param lvCheckOtherResults
	 * @return
	 * @throws BizException
	 */
	public Map<String, Integer> essemlyMap(LvCheckOtherResultDTO[] lvCheckOtherResults)throws BizException { 
		Map<String, Integer> map = new HashMap<>();
		if(EnValidator.isEmpty(lvCheckOtherResults))
			return map;
		for(LvCheckOtherResultDTO lvCheckOtherResult : lvCheckOtherResults){
			String entId = lvCheckOtherResult.getId_ent();
			if(map.containsKey(entId) && TransDepCheckStatus.Error.equals(map.get(entId)))
				continue;
			String problem_type =  lvCheckOtherResult.getProblem_type();
			if(IEnConst.CHECK_FORBID.equals(problem_type))
				map.put(entId, TransDepCheckStatus.Error);
			else if(IEnConst.CHECK_WARM.equals(problem_type))
				map.put(entId, TransDepCheckStatus.Warning);
		}
		return map;
	}
}
