package iih.ci.ord.s.ems.cache;

import iih.bd.base.cache.ContextCache;
import iih.ci.ord.ems.d.CiEnContextDTO;

public class EmsOrDrugInfoCache {
	public static String EmsOrDrugInfoCache_Key = "EmsOrDrugInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";

	private EmsOrDrugInfoCache() {
	}

	public static <T> void PutCache(CiEnContextDTO ctx, String key, T objEms) {
		ContextCache.Put(EmsOrDrugInfoCache.class.getSimpleName(), ctx.getId_grp(), ctx.getId_org(),
				EmsOrDrugInfoCache_Key+"/"+ctx.getCode_entp() , key, objEms);
	}

	public static <T> T GetCache(CiEnContextDTO ctx, String key) {
		return ContextCache.Get(EmsOrDrugInfoCache.class.getSimpleName(), ctx.getId_grp(), ctx.getId_org(),
				EmsOrDrugInfoCache_Key+"/"+ctx.getCode_entp() , key);
	}

	public static void Clear() {
		ContextCache.Clear(EmsOrDrugInfoCache.class.getSimpleName());
	}
}
