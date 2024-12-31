package iih.bd.pp.medsrvrealpriceqry.s;

import iih.bd.pp.medsrvrealpriceqry.i.IMedSrvRealPriceQryService;
import iih.bd.pp.medsrvrealpriceqry.s.bp.FindMedSrvRealPriMapByIdsBp;
import iih.bd.pp.medsrvrealpriceqry.s.bp.FindMedSrvRefPriMapByIdsBp;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;

/**
 * 医疗服务真实价格查询服务
 * 
 * @author hao_wu
 *
 */
public class MedSrvRealPriceQryServiceImpl implements IMedSrvRealPriceQryService {

	@Override
	public FMap2 FindMedSrvRealPriMapByIds(String[] medSrvIds) throws BizException {
		FindMedSrvRealPriMapByIdsBp bp = new FindMedSrvRealPriMapByIdsBp();
		FMap2 realPriMap = bp.exec(medSrvIds);
		return realPriMap;
	}

	@Override
	public FMap findMedSrvRefPriMapByIds(String[] medSrvIds) throws BizException {
		FindMedSrvRefPriMapByIdsBp bp = new FindMedSrvRefPriMapByIdsBp();
		FMap refPriMap = bp.exec(medSrvIds);
		return refPriMap;
	}
}
