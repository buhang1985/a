package iih.ci.sdk.cache;

import iih.bd.base.cache.ContextCache;
import iih.ci.ord.ems.d.CiEnContextDTO;

/**
 * 断点压栈信息缓存
 * 
 * @author wangqingzhu
 *
 */
public class EmsStackInfoCache {
	public static String EmsStackInfoCache_Key = "EmsStackInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";

	private EmsStackInfoCache() {
	}

	public static <T> void PutCache(CiEnContextDTO ctx, String id_stack, String id_srv, T objEms) {
		ContextCache.Put(EmsStackInfoCache.class.getSimpleName(), ctx.getId_grp(), ctx.getId_org(),
				EmsStackInfoCache_Key + "," + id_stack, id_srv, objEms);
	}

	public static <T> T GetCache(CiEnContextDTO ctx, String id_stack, String id_srv) {
		return ContextCache.Get(EmsStackInfoCache.class.getSimpleName(), ctx.getId_grp(), ctx.getId_org(),
				EmsStackInfoCache_Key + "," + id_stack, id_srv);
	}

	public static void Clear() {
		ContextCache.Clear(EmsStackInfoCache.class.getSimpleName());
	}
}
