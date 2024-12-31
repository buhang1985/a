package iih.ci.ord.s.ortmpl.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.cache.ContextCache;
import iih.ci.ord.dto.newordertemplatedto.d.OrderTemplateRstDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.cache.BDTplInfoCache;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医嘱模板明细查询
 * @author Young
 *
 */
public class GetOrTplNItmDTOsCacheBP extends ContextCache {

	public OrderTemplateRstDTO exec(String[] id_ortmpls, CiEnContextDTO ctx, FBoolean isReFresh) throws BizException{
		GetOrTplNItmDTOsBP bp = new GetOrTplNItmDTOsBP(ctx);
		OrderTemplateRstDTO tempLRst = new OrderTemplateRstDTO();
		//缓存存在，但可能医嘱模板不全，缓存中存在的模板取出来，在查询数据库
		FMap ortmplMap = isReFresh.booleanValue()? new FMap() : (FMap)BDTplInfoCache.GetCache(ctx, ctx.getId_dep_or(), ctx.getId_emp_or());
		if (null != ortmplMap && ortmplMap.size() > 0)
		{
			List<String> unContainsIds = new ArrayList<String>();
			for (String id_ortmpl : id_ortmpls) {
				if (!ortmplMap.containsKey(id_ortmpl))
					unContainsIds.add(id_ortmpl);
			}
			if (unContainsIds.size() > 0) {
				FMap unOrtmplMap = bp.getOrderTemplateDTO(unContainsIds.toArray(new String[unContainsIds.size()]));
				ortmplMap.putAll(unOrtmplMap);
				BDTplInfoCache.PutCache(ctx, ctx.getId_dep_or(), ctx.getId_emp_or(), ortmplMap);
			}
		} else {
			//缓存中不存在，需要查询数据库
			ortmplMap = bp.getOrderTemplateDTO(id_ortmpls);
			BDTplInfoCache.PutCache(ctx, ctx.getId_dep_or(), ctx.getId_emp_or(), ortmplMap);
		}
		tempLRst.setTemplItm(ortmplMap);
		tempLRst.setFreqdefdo(bp.getFreqDefDO());
		return tempLRst;
	}
}
