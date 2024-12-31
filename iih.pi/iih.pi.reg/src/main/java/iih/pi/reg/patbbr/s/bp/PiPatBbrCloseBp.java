package iih.pi.reg.patbbr.s.bp;

import iih.pi.reg.patbbr.d.PiPatBbrDO;
import iih.pi.reg.patbbr.i.IPatbbrCudService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class PiPatBbrCloseBp {
	public PiPatBbrDO[] exec(PiPatBbrDO[] pipatBbrs) throws BizException {
		if (pipatBbrs == null || pipatBbrs.length <= 0) {
			return null;
		}
		PiPatBbrDO[] result = ClosePiPatBbr(pipatBbrs);
		return result;
	}

	private PiPatBbrDO[] ClosePiPatBbr(PiPatBbrDO[] pipatBbrs)throws BizException {
		for (PiPatBbrDO pipatBbrDO : pipatBbrs) {
			pipatBbrDO.setFg_active(FBoolean.FALSE);
		}
		PiPatBbrDO[] result = SavePiPatBbr(pipatBbrs);
		return result;
	}
	/**
	 * 保存物品信息
	 * 
	 * @param materials
	 * @return
	 * @throws BizException
	 */
	private PiPatBbrDO[] SavePiPatBbr(PiPatBbrDO[] pipatBbrs) throws BizException {
		IPatbbrCudService patbbrrCudervice  = ServiceFinder.find(IPatbbrCudService.class);
		PiPatBbrDO[] result = patbbrrCudervice.update(pipatBbrs);
		return result;
	}
}
