package iih.en.que.s.acpt.rule;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.ResultDTO;

import java.util.Map;
import java.util.Set;

import xap.lui.system.rulemgr.XapRuleAPI;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public class CheckAcptRuleResultPro {

	/**
	 * 调用规则引擎
	 * 
	 * @author ltf
	 * 
	 * @param ruleCode
	 * @param map
	 * @return
	 * @throws BizException
	 */
	public static ResultDTO check(String ruleCode, Map<String, Object> map) throws BizException{
			Map<String, Object> rstMap = XapRuleAPI.exeRule(ruleCode, map);
			long e = System.currentTimeMillis();
			return DealResult(rstMap);
	}
	
	/**
	 * 处理规则结果信息
	 * 
	 * @param rstMap
	 * @return
	 */
	public static ResultDTO DealResult(Map<String, Object> rstMap) {
		ResultDTO rst = new ResultDTO();
		if (rstMap == null || rstMap.isEmpty()){
			rst.setFlag(FBoolean.TRUE);
			return rst;
		}
		StringBuilder rstSb = new StringBuilder();
		boolean rstFlag = true;
		Set<String> rstKetSet = rstMap.keySet();
		if(rstKetSet.contains("EN_IP_BL")) rstKetSet.remove("EN_IP_BL");
		for (String key : rstKetSet) {
			Object result = rstMap.get(key);
			if (result != null && !EnValidator.isEmpty(result.toString())) {
				rstFlag = false;
				rstSb.append(result.toString());
			}
		}
		rst.setFlag(new FBoolean(rstFlag));
		rst.setMsg(rstSb.toString());
		return rst;
	}
}
