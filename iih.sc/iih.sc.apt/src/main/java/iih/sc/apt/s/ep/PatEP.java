package iih.sc.apt.s.ep;

import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.sc.comm.IScMsgConst;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 患者实体操作类
 * 
 * @author yank
 */
public class PatEP {
	/**
	 * 获取患者信息
	 * 
	 * @param patId 患者ID
	 * @return
	 * @throws BizException
	 */
	public PatDO getPatById(String patId) throws BizException {
		IPatiMDORService patRService = ServiceFinder.find(IPatiMDORService.class);
		PatDO patDO = patRService.findById(patId);
		if (patDO == null) {
			throw new BizException(IScMsgConst.SC_PAT_NOT_EXISTS);
		}
		return patDO;
	}
}
