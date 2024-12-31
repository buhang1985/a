package iih.ci.ord.s.ems.cache;

import iih.bd.base.cache.ContextCache;
import iih.ci.ord.ems.d.CiEnContextDTO;

/**
 * 医疗单缓存,针对于 老的保存逻辑 缓存处理
 * 
 * @author wangqingzhu
 *
 */
public class CIEmsDTOCache {
	public static String CIEmsDTOCache_Key = "CIEmsDTOCache_Key";

	private CIEmsDTOCache() {
	}

	public static <T> void PutCache(CiEnContextDTO ctx, String key, T v) {
		ContextCache.Put(CIEmsDTOCache.class.getSimpleName(), ctx.getId_grp(), ctx.getId_org(), CIEmsDTOCache_Key, key,
				v);
	}

	public static <T> T GetCache(CiEnContextDTO ctx, String key) {
		return ContextCache.Get(CIEmsDTOCache.class.getSimpleName(), ctx.getId_grp(), ctx.getId_org(),
				CIEmsDTOCache_Key, key);
	}

	public static void Clear() {
		ContextCache.Clear(CIEmsDTOCache.class.getSimpleName());
	}
}
