package iih.bd.srv.medsrv.s;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedSrvExtCudService;
import iih.bd.srv.medsrv.i.IMedSrvExtRService;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.bd.srv.medsrv.s.bp.SetRealPriBp;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医疗服务扩展查询服务
 * 
 * @author hao_wu
 *
 */
public class MedSrvExtCrudServiceImpl implements IMedSrvExtCudService, IMedSrvExtRService {

	@Override
	public MedsrvAggDO FindMedSrvAggById(String medsrvId) throws BizException {
		IMedsrvRService medsrvRService = ServiceFinder.find(IMedsrvRService.class);
		MedsrvAggDO result = medsrvRService.findById(medsrvId);
		SetRealPriBp bp = new SetRealPriBp();
		bp.exec(new MedSrvDO[] { result.getParentDO() });
		return result;
	}

	@Override
	public MedsrvAggDO[] FindByIdsAndLength(String[] ids, FBoolean isLazy) throws BizException {
		MedsrvCrudServiceImpl medsrvCrudService = new MedsrvCrudServiceImpl();
		MedsrvAggDO[] result = medsrvCrudService.findByIds(ids, isLazy, FBoolean.TRUE);
		return result;
	}
}
