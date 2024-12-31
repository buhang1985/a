package iih.ci.sdk.cache;

import java.util.List;

import iih.bd.base.cache.ContextCache;
import iih.ci.sdk.utils.ObjectUtils;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

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
			if (ObjectUtils.isEmpty(rst)) {
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
	
	public static String GetIDOfPsndocInfo(String code) throws BizException {
		PsnDocDO psnInfo = ContextCache.Get(PsndocInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID,
				PsndocCacheKey, code);
		if (null == psnInfo) {
			psnInfo = ins.getByCode(code);
			ContextCache.Put(PsndocInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID,
					PsndocCacheKey, code, psnInfo);
		}
		return psnInfo == null ? null : psnInfo.getId_psndoc();
	}
	
	private PsnDocDO getByCode(String code) throws BizException {
		String sql = String.format("select a0.Id_psndoc,a0.Name from bd_psndoc a0 where a0.Code='%s'", code);
		List<PsnDocDO> rst = (List<PsnDocDO>) new DAFacade().execQuery(sql, new BeanListHandler(PsnDocDO.class));
		return null != rst ? rst.get(0) : null;
	}

	/**
	 * 清空缓存对象
	 */
	public static void Clear() {
		ContextCache.Clear(PsndocInfoCache.class.getSimpleName());
	}
}
