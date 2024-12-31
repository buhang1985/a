package iih.en.pv.s.rule;

import iih.en.comm.IEnConst;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.ResultDTO;

import java.util.Map;
import java.util.Set;

import xap.lui.system.rulemgr.XapRuleAPI;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 规则引擎结果处理
 * 
 * 
 * @author liubin
 * 
 * 下午4:20:11
 */
public class CheckMvelRuleResultPro {
	
	/**
	 * 调用规则引擎
	 * 
	 * @author liubin
	 * 
	 * @param ruleCode
	 * @param map
	 * @return
	 * @throws BizException
	 */
	public static ResultDTO check(String ruleCode, Map<String, Object> map) throws BizException{
		try {
			Map<String, Object> rstMap = XapRuleAPI.exeRule(ruleCode, map);
			return DealResult(rstMap);
		} catch (Exception ex) {
			EnLogUtil.getInstance().logError(ruleCode + "规则引擎异常日志！", ex);
			throw new BizException("规则引擎异常，请联系管理员！", ex);
		}
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
		Object obj = EnContextUtils.getCtxAttribute(IEnConst.KEYCTX_RULE_DEALTIPS);
		boolean isDealTips = obj==null? false :(boolean)obj; 
		StringBuilder rstSb = new StringBuilder();
		StringBuilder tipsSb = new StringBuilder();
		boolean rstFlag = true;
		Set<String> rstKetSet = rstMap.keySet();
		for (String key : rstKetSet) {
			Object result = rstMap.get(key);
			if (result != null && !EnValidator.isEmpty(result.toString())) {
				String msg = result.toString().trim();
				boolean isTip = msg.startsWith("1");
				if(isTip){
					//处理提示信息
					if (isDealTips) {
						rstFlag = false;
						tipsSb.append(msg.substring(1));
					}
				}else{
					rstFlag = false;
					rstSb.append(msg);
				}
			}
		}
		rst.setFlag(new FBoolean(rstFlag));
		rst.setMsg(rstSb.toString());
		rst.setMsg_tips(tipsSb.toString());
		return rst;
	}
}
