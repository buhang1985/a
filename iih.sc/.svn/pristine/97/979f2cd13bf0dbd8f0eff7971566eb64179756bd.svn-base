package iih.sc.apt.s.rule;

import iih.en.pv.dto.d.ResultDTO;
import iih.sc.comm.ScLogUtil;
import iih.sc.comm.ScValidator;

import java.util.Map;

import xap.lui.system.rulemgr.XapRuleAPI;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 规则处理
 * 
 * @author liubin
 *
 */
public class CheckRuleResultPro {
	/**
	 * 调用规则引擎，并提供结果处理
	 * 
	 * @param ruleCode
	 * @param map
	 * @return
	 */
	public static ResultDTO checkDealResult(String ruleCode, Map<String, Object> map) throws BizException{
		Map<String, Object> resultMap = check(ruleCode, map);
		return dealResult(resultMap);
	}
	/**
	 * 调用规则引擎
	 * 
	 * @param ruleCode
	 * @param map
	 * @return
	 * @throws BizException
	 */
	public static Map<String, Object> check(String ruleCode, Map<String, Object> map) throws BizException {
		try {
			return XapRuleAPI.exeRule(ruleCode, map);
		} catch (Exception ex) {
			String errorMsg = String.format("规则[%s]错误!", ruleCode);
			ScLogUtil.getInstance().logEx(new BizException(errorMsg, ex));
			throw new BizException(errorMsg, ex);
		}
	}
	/**
	 * 处理结果
	 * 
	 * @param resultMap
	 * @return
	 */
	private static ResultDTO dealResult(Map<String, Object> resultMap){
		ResultDTO result = new ResultDTO();
		result.setFlag(FBoolean.TRUE);
		if(resultMap == null || resultMap.isEmpty()){
			return result;
		}
		StringBuilder builder = new StringBuilder();
		for(String key : resultMap.keySet()){
			Object obj = resultMap.get(key);
			if(obj == null || !(obj instanceof String))
				continue;
			String msg = (String)obj;
			if(ScValidator.isEmptyIgnoreBlank(msg))
				continue;
			result.setFlag(FBoolean.FALSE);
			builder.append(msg);
		}
		if(builder.length() > 0)
			result.setMsg(builder.toString());
		return result;
	}
}
