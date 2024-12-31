package iih.ci.ord.s.bp.cfg.rulecfg.rule.ris;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.commons.lang3.StringUtils;

import iih.ci.ord.cfg.dto.ris.d.RisDataMergeDTO;
import iih.ci.ord.s.bp.cfg.rulecfg.rule.DefaultRuleExecutor;

/**
 * 检查合单抽象执行类
 * @author HUMS
 *
 */
public abstract class AbstractRisSplitRuleExecutor extends DefaultRuleExecutor<Map<String,List<RisDataMergeDTO>>>{

	/**
	 * 按照检查检查分组规则进行分组
	 */
	@Override
	public Map<String,List<RisDataMergeDTO>> executeRule(Map<String,List<RisDataMergeDTO>> risDataMergeMap) {

		Map<String,List<RisDataMergeDTO>> newRisDataMergeMap = new HashMap<String,List<RisDataMergeDTO>>();

		for(String key : risDataMergeMap.keySet()){
			
			List<RisDataMergeDTO> rsiDataMergeList = risDataMergeMap.get(key);
			for(RisDataMergeDTO risDataMerge : rsiDataMergeList){
				String presIdentification = this.getDefaultIdentification(risDataMerge);
				String newMapKey = key + presIdentification;
				
				if(!newRisDataMergeMap.containsKey(newMapKey)){
					List<RisDataMergeDTO> risDataMergeList = new Vector<RisDataMergeDTO>();
					newRisDataMergeMap.put(newMapKey, risDataMergeList);
				}
				
				newRisDataMergeMap.get(newMapKey).add(risDataMerge);
			}
		}
		
		return newRisDataMergeMap;
	}
	
	/**
	 * 获取默认的处方标识
	 * 
	 * @param orderPresSplit
	 *            处方明细项
	 * @return 返回处方唯一标识，如果子类返回值为空，使用当前类名作为处方唯一标识
	 */
	private String getDefaultIdentification(RisDataMergeDTO rRisDataMerge) {

		String presIdentification = this.getIdentification(rRisDataMerge);
		if (StringUtils.isEmpty(presIdentification)) {
			return this.getClass().getName();
		}
		return presIdentification;
	}
	
	/**
	 * 获取默认的检验合单标识
	 * 
	 * @param rRisDataMerge 检验合单数据对象
	 * @return 返回合单唯一标识
	 */
	protected abstract String getIdentification(RisDataMergeDTO rRisDataMerge);
}
