package iih.bd.pp.bdbltpl.s;

import java.util.Map;

import iih.bd.pp.bdbltpl.d.BdBltplItmDO;
import iih.bd.pp.bdbltpl.d.BdbltplAggDO;
import iih.bd.pp.bdbltpl.i.IBdBltplExtRService;
import iih.bd.pp.bdbltpl.s.bp.FindBltplAggDoByIdBp;
import iih.bd.pp.bdbltpl.s.bp.GetTplPriceMapBp;
import iih.bd.pp.bdbltpl.s.bp.UpdateBlTplItmsBp;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;

/**
 * 自定义费用模板扩展服务
 * 
 * @author hao_wu
 *
 */
public class BdBltplExtCrudServiceImpl implements IBdBltplExtRService {

	@Override
	public BdbltplAggDO findBltplAggDoById(String tplId) throws BizException {
		FindBltplAggDoByIdBp bp = new FindBltplAggDoByIdBp();
		BdbltplAggDO bltplAggDo = bp.exec(tplId);
		return bltplAggDo;
	}

	@Override
	public BdBltplItmDO[] updateBlTplItms(BdBltplItmDO[] itms) throws BizException {
		UpdateBlTplItmsBp bp = new UpdateBlTplItmsBp();
		bp.exec(itms);
		return itms;
	}

	@Override
	public Map<String, FDouble> getTplPriceMap(String[] tplIds) throws BizException {
		GetTplPriceMapBp bp = new GetTplPriceMapBp();
		Map<String, FDouble> priceMap = bp.exec(tplIds);
		return priceMap;
	}
}
