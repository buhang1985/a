package iih.en.pv.s.bp.op;

import java.util.HashMap;
import java.util.Map;

import iih.bd.srv.dto.d.PhySignDTO;
import iih.en.comm.IEnConst;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.pv.dto.d.ResultDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.s.rule.CheckMvelRuleResultPro;
import xap.lui.core.scriptrule.XapScriptAPI;
import xap.mw.core.data.BizException;

/**
 * 预检弹框关闭规则
 * @author lilei,fanlq
 *
 */
public class CheckIsBloodPressureBP {
	private static final String CODE = "F.HDSD00.04";
	
	private static final String KEY_PAT = "ID_PAT";
	private static final String KEY_ENT = "ID_ENT";
	private static final String KEY_PV = "PV";
	private static final String KEY_PHYSIGNDTO = "PHYSIGNDTO";
	
	/**
	 * 预检弹框关闭规则
	 * @param entId 就诊id
	 * @param oprId 操作员id
	 * @return FBoolean
	 * @throws BizException
	 */
	public ResultDTO exec(String entId,String oprId,PhySignDTO[] phySignDtos) throws BizException{
	    try
        {
	    	EnContextUtils.setCtxAttribute(IEnConst.KEYCTX_RULE_DEALTIPS, true);
	    	Map<String, Object> map = new HashMap<>();
			PvEP pvep = new PvEP();
			PatiVisitDO pv = pvep.getPvById(entId);
			map.put(KEY_ENT, pv.getId_ent());
			map.put(KEY_PAT, pv.getId_pat());
			map.put(KEY_PV, pv);
			map.put(KEY_PHYSIGNDTO, phySignDtos);	
			Map<String, Object> resultMap = XapScriptAPI.exeRule(CODE, map);
	    	return CheckMvelRuleResultPro.DealResult(resultMap);
		}catch(Exception ex){
			EnLogUtil.getInstance().logError("预检弹框关闭规则出错！", ex);
			return null;
		}
	}
	
}
