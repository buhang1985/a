package iih.bd.pp.prisrvcomp.s;

import iih.bd.pp.prisrvcomp.d.PriSrvCompDO;
import iih.bd.pp.prisrvcomp.i.IPrisrvcompExtCudService;
import iih.bd.pp.prisrvcomp.i.IPrisrvcompExtRService;
import iih.bd.pp.prisrvcomp.s.bp.FindByMedsrvIdBp;
import xap.mw.core.data.BizException;

/**
 * 付款策略_组合定价扩展服务
 * 
 * @author hao_wu
 *
 */
public class PrisrvcompExtCrudServiceImpl implements IPrisrvcompExtCudService, IPrisrvcompExtRService {

	@Override
	public PriSrvCompDO[] FindByMedsrvId(String medsrvId, String orderByPart) throws BizException {
		FindByMedsrvIdBp bp = new FindByMedsrvIdBp();
		PriSrvCompDO[] result = bp.exec(medsrvId, orderByPart);
		return result;
	}

}
