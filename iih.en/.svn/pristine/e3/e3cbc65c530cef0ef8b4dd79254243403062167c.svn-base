package iih.en.pv.s.bp.op;

import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.PvEP;
import iih.en.pv.outpatient.d.EuPreObs;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;

import java.util.HashMap;
import java.util.Map;

import xap.lui.core.scriptrule.XapScriptAPI;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.Logger;

/**
 * 
 * @author liubin
 *
 */
public class CheckIsNeedPreExamBP {
	private static final String CODE = "F.HDSD00.03";
	
	private static final String KEY_PAT = "ID_PAT";
	private static final String KEY_ENT = "ID_ENT";
	private static final String KEY_PV = "PV";
	private static final String KEY_OP = "OP";
	
	/**
	 * 是否需要预检
	 * @param entId 就诊id
	 * @param oprId 操作员id
	 * @return FBoolean
	 * @throws BizException
	 */
	public FBoolean exec(String entId,String oprId) throws BizException{
		Map<String, Object> map = new HashMap<>();
		PvEP pvep = new PvEP();
		PatiVisitDO pv = pvep.getPvById(entId);
		map.put(KEY_ENT, pv.getId_ent());
		map.put(KEY_PAT, pv.getId_pat());
		map.put(KEY_PV, pv);
		OpEP opep = new OpEP();
		OutpatientDO op = opep.getOpByEntId(entId);
		map.put(KEY_OP, op);
		try{
			Boolean r = XapScriptAPI.Rule(CODE, map, XapScriptAPI.operType_OR);
			FBoolean result =  new FBoolean(r);
			this.setEuPreObs(opep, op, result);
			return result;
		}catch(Exception ex){
			Logger.error("预检规则出错！", ex);
		}
		return FBoolean.FALSE;
	}
	/**
	 * 设置预检状态
	 * 
	 * @param isNeedPre
	 * @throws BizException
	 */
	private void setEuPreObs(OpEP ep, OutpatientDO op, FBoolean isNeedPre) throws BizException{
		if(!FBoolean.TRUE.equals(isNeedPre))
			return;
		if(!EuPreObs.ALREADYPREOBS.equals(op.getEu_preobs())){
			op.setEu_preobs(EuPreObs.WAITPREOBS);
			op.setStatus(DOStatus.UPDATED);
			ep.save(op);
		}
	}
}
