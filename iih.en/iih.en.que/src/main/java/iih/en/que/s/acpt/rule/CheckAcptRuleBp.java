package iih.en.que.s.acpt.rule;

import iih.en.comm.IEnRuleConst;
import iih.en.pv.dto.d.ResultDTO;

import java.util.HashMap;
import java.util.Map;

import xap.mw.core.data.BizException;


/**
 * 接诊规则引擎校验
 * @author ltf
 *
 */
public class CheckAcptRuleBp {
	private static final String Key_Id_ent = "Id_ent";
	
	public ResultDTO check(String entId) throws BizException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Key_Id_ent, entId);
		ResultDTO result = CheckAcptRuleResultPro.check(IEnRuleConst.EN_ACPT_RULEPKG_CONST, map);
		return result;
	}
}
