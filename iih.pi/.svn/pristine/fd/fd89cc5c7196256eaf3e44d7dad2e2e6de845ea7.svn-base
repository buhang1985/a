package iih.pi.reg.s;

import iih.pi.reg.i.IPiPatBadRecQryWService;
import iih.pi.reg.s.bp.CheckPatBadRecBp;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 患者不良记录查询WebService
 * 
 * @author hao_wu
 *
 */
public class PiPatBadRecQryWServiceImpl implements IPiPatBadRecQryWService {

	@Override
	public String checkPatBadRec(String patCode, String badRecTpCode) throws BizException {
		CheckPatBadRecBp bp = new CheckPatBadRecBp();
		FBoolean hasBadRec = bp.exec(patCode, badRecTpCode);
		if (hasBadRec != null && FBoolean.TRUE.equals(hasBadRec)) {
			return "Y";
		}
		return "N";
	}

}
