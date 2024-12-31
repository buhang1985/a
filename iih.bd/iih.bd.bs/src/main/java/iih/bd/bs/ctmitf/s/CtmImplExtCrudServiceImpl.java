package iih.bd.bs.ctmitf.s;

import iih.bd.bs.ctmitf.d.CtmImplDO;
import iih.bd.bs.ctmitf.i.ICtmImplExtCudService;
import iih.bd.bs.ctmitf.i.ICtmImplExtRService;
import iih.bd.bs.ctmitf.s.bp.UpdateSysBp;
import xap.mw.core.data.BizException;

/**
 * 客开接口实现类扩展服务
 * 
 * @author hao_wu 2019-7-29
 *
 */
public class CtmImplExtCrudServiceImpl implements ICtmImplExtCudService, ICtmImplExtRService {

	@Override
	public CtmImplDO[] updateSys(CtmImplDO[] ctmImpls) throws BizException {
		UpdateSysBp bp = new UpdateSysBp();
		CtmImplDO[] result = bp.exec(ctmImpls);
		return result;
	}

}
