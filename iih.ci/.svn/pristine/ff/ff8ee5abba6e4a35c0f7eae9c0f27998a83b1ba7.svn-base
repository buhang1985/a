package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.dto.newordertemplatedto.d.OrderTemplateRstDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.cache.BDTplInfoCache;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;

public class GetSrvortplitemAggDOSCacheBP {
	public OrderTemplateRstDTO exec(String[] id_ortmpls, CiEnContextDTO ctx) throws BizException {
		String Id_pripat = ctx.getId_pripat();
		String id_hp = ctx.getId_hp_default();
		String code_entp = ctx.getCode_entp();

		OrderTemplateRstDTO tempLRst = new OrderTemplateRstDTO();
		// if (this.isHitCahce(L1SessionKeyWith(ctx), OrTempl_Cache_key))
		getSrvortplitemAggDOSBP bp = new getSrvortplitemAggDOSBP(ctx);
		// 缓存存在，但可能医嘱模板不全，缓存中不存在的模板取出来，在查询数据库
		FMap ortmplMap = BDTplInfoCache.GetCache(ctx, ctx.getId_dep_or(), ctx.getId_emp_or());
		if (null != ortmplMap) {
			List<String> unContainsIds = new ArrayList<String>();
			for (String id_ortmpl : id_ortmpls) {
				if (!ortmplMap.containsKey(id_ortmpl))
					unContainsIds.add(id_ortmpl);
			}
			if (unContainsIds.size() > 0) {
				FMap unOrtmplMap = bp.getNewOrderTemplateDTO2(unContainsIds.toArray(new String[unContainsIds.size()]));
				ortmplMap.putAll(unOrtmplMap);
				BDTplInfoCache.PutCache(ctx, ctx.getId_dep_or(), ctx.getId_emp_or(), ortmplMap);
			}
		} else {
			// 缓存中不存在，需要查询数据库
			ortmplMap = bp.getNewOrderTemplateDTO2(id_ortmpls, Id_pripat, id_hp, code_entp);
			BDTplInfoCache.PutCache(ctx, ctx.getId_dep_or(), ctx.getId_emp_or(), ortmplMap);
		}
		tempLRst.setTemplItm(ortmplMap);
		tempLRst.setFreqdefdo(bp.getFreqMap());
		return tempLRst;
	}
}
