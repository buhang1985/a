package iih.en.comm.util;

import iih.en.comm.IEnConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.ResultDTO;
import iih.en.pv.outpatient.dto.d.RegRuleDTO;
import iih.pi.reg.pat.d.PatDO;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import xap.lui.system.rulemgr.XapRuleAPI;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.sys.jdbc.facade.DAFacade;
/***
 * 就诊规则引擎调用工具类
 * @author fanlq
 * @date: 2019年11月18日 下午2:20:55
 */
public class EnRuleUtils {

	/***
	 * @Description:就诊规则引擎调用工具类
	 * @param code_pkgs 规则包编码
	 * @param regRule 规则DTO
	 * @return
	 * @throws BizException
	 */
	public ResultDTO regRule(String[] code_pkgs,RegRuleDTO regRule) throws BizException{
		//1.校验规则包
		if(code_pkgs == null || code_pkgs.length <= 0){
			throw new BizException("规则引擎：调用规则包不能为空！");
		}
		//2.查找患者
		PatDO patDo =null;
		if(!EnValidator.isEmpty(regRule.getId_pat())){
			patDo = (PatDO) new DAFacade().findByPK(PatDO.class, regRule.getId_pat());
		}
		if(patDo == null)
			throw new BizException("规则引擎：患者信息不能为空！");
		if (!EnValidator.isEmpty(regRule.getRegdate())) {
			FDateTime dateTime = EnAppUtils.getFDateTime(new FDate(regRule.getRegdate()).asBegin(), new FTime("00:00:00"));
			regRule.setRegdate(dateTime.toStdString());
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(PatDO.class.getSimpleName(), patDo);
		map.put(RegRuleDTO.class.getSimpleName(), regRule);
		ResultDTO result = new ResultDTO();
		//3.循环调用规则引擎校验
		for(String code_pkg:code_pkgs){
			try {
				Map<String, Object> rstMap = XapRuleAPI.exeRule(code_pkg, map);
				result = DealResult(rstMap);
				if(result != null && FBoolean.FALSE.equals(result.getFlag())){
			    	return result;
			    }else continue;
			} catch (Exception ex) {
				EnLogUtil.getInstance().logError(code_pkg + "规则引擎异常日志！", ex);
				throw new BizException("规则引擎异常，请联系管理员！", ex);
			}
		}
		return result;
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
