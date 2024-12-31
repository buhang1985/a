package iih.bd.bs.ctmitf.s.bp;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.bs.ctmitf.d.CtmImplDO;
import iih.bd.bs.ctmitf.i.ICtmimplCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class UpdateSysBp {

	/**
	 * 升级客开接口实现类为系统数据
	 * 
	 * @param ctmImpls
	 * @return
	 * @throws BizException
	 */
	public CtmImplDO[] exec(CtmImplDO[] ctmImpls) throws BizException {
		if (ArrayUtils.isEmpty(ctmImpls)) {
			return null;
		}

		for (CtmImplDO ctmImplDO : ctmImpls) {
			ctmImplDO.setFg_sys(FBoolean.TRUE);
			ctmImplDO.setStatus(DOStatus.UPDATED);
		}

		ICtmimplCudService ctmimplCudService = ServiceFinder.find(ICtmimplCudService.class);
		CtmImplDO[] result = ctmimplCudService.update(ctmImpls);
		return result;
	}

}
