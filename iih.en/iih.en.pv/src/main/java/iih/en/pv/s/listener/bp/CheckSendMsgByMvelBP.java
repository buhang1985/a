package iih.en.pv.s.listener.bp;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.ResultDTO;
import iih.en.pv.s.rule.CheckMvelRuleResultPro;
import iih.pi.reg.pat.d.PatDO;

import java.util.HashMap;
import java.util.Map;

import xap.lui.system.rulemgr.XapRuleAPI;
import xap.mw.core.data.BizException;
import xap.mw.log.logging.Logger;

/***
 * 根据挂号短信发送规则判断是否发送短信，true，发送，false，不发送
 * @author fanlq
 *
 */
public class CheckSendMsgByMvelBP {
	
	private static final String KEY_ENTID = "ENTID";
	
	public ResultDTO exec(String pkgCode,PatDO patDO,String entId) throws BizException {
		if (EnValidator.isEmpty(pkgCode))
			throw new BizException("规则引擎：规则包编码不能为空！");
		Map<String, Object> map = this.orzParam(patDO,entId);
		try {
			long b = System.currentTimeMillis();
			// 调用规则引擎
			Map<String, Object> rstMap = XapRuleAPI.exeRule(pkgCode, map);
			long e = System.currentTimeMillis();
			long t = e - b;
			System.out.println(t);
			return CheckMvelRuleResultPro.DealResult(rstMap);
		} catch (Exception ex) {
			Logger.error("规则引擎异常日志！", ex);
			return null;
		}
	}
	

	/***
	 * 组织参数
	 * @author fanlq 
	 * @param srvCode
	 * @param mobiles
	 * @param msgCode
	 * @return
	 */
	private Map<String, Object> orzParam(PatDO PatDO,String entId) {
		Map<String, Object> map = new HashMap<>();
		map.put(PatDO.class.getSimpleName(), PatDO);
		map.put(KEY_ENTID, entId);
		return map;
	}
}
