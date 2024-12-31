package iih.bl.hp.hpque.bp;

import iih.pi.reg.patbbr.d.PiPatBbrDO;
import iih.pi.reg.patbbr.i.IPatbbrRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class CheckPiPatBbrBlackBp {
	/**
	 * 用于判断患者是否在医保黑名单中
	 * 
	 * @param id_pat
	 *            患者ID
	 * @return FBoolean.TRUE：在医保黑名单中； FBoolean.FALSE：不在医保黑名单中；
	 * @throws BizException
	 */
	public FBoolean exec(String id_pat) throws BizException {

		IPatbbrRService IPatbbrRService = ServiceFinder.find(IPatbbrRService.class);
		PiPatBbrDO[] pPiPatBbrDOArr = IPatbbrRService.find(" Id_pat='" + id_pat + "' and SD_BBRTP = '51' and FG_ACTIVE = 'Y'", "", FBoolean.FALSE);
		if (pPiPatBbrDOArr != null && pPiPatBbrDOArr.length > 0) {
			return FBoolean.TRUE;
		} else {
			return FBoolean.FALSE;
		}
	}
}
