package iih.ci.ord.s.ems.cache;

import iih.bd.base.cache.ContextCache;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;

public class PsndocInfoCache {
	public static final String PsndocCacheKey = "PI_PAT_DEF_CACHEKEY";
	public static String DefaultContext_ID = "@@@@";
	private static PsndocInfoCache ins = new PsndocInfoCache();

	private PsndocInfoCache() {
	}
	
	/**
	 * 根据医生id获取医生基本信息
	 * 
	 * @param id_psndoc
	 * @return
	 * @throws BizException
	 */
	private PsnDocDO getPsnInfo(String id_psndoc) throws BizException {

		PsnDocDO psnInfo = ContextCache.Get(PsndocInfoCache.class.getSimpleName(),DefaultContext_ID, DefaultContext_ID, PsndocCacheKey, id_psndoc);
		if (null == psnInfo) {
			PsnDocDO rst = ServiceFinder.find(IPsndocMDORService.class).findById(id_psndoc);
			if (CiOrdUtils.isEmpty(rst)) {
				return null;
			}
			psnInfo = rst;
			ContextCache.Put(PsndocInfoCache.class.getSimpleName(),DefaultContext_ID, DefaultContext_ID, PsndocCacheKey, id_psndoc, psnInfo);
		}

		return psnInfo;
	}
	
	public static PsnDocDO getPsnInfoCache(String id_psndoc) throws BizException {
		return ins.getPsnInfo(id_psndoc);
	}

	/**
	 * 清空缓存对象
	 */
	public static void Clear() {
		ContextCache.Clear(PsndocInfoCache.class.getSimpleName());
	}
}
