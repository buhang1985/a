package iih.bd.srv.medsrv.s.ext;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.bd.srv.medsrv.i.ext.IMedsrvExtQryService;
import iih.bd.srv.medsrv.s.bp.SetupInccaBp;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医疗服务扩展查询服务
 * 
 * @author hao_wu
 *
 */
public class MedsrvExtQryServiceImpl implements IMedsrvExtQryService {

	@Override
	public MedsrvAggDO findById(String id) throws BizException {
		IMedsrvRService medsrvRService = ServiceFinder.find(IMedsrvRService.class);
		MedsrvAggDO result = medsrvRService.findById(id);

		SetupInccaBp bp = new SetupInccaBp();
		bp.exec(new MedSrvDO[] { result.getParentDO() });

		return result;
	}

}
