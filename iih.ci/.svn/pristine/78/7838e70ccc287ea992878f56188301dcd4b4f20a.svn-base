package iih.ci.ord.s.ems.cache;

import iih.bd.base.cache.ContextCache;
import iih.ci.ord.ems.d.CiEnContextDTO;

/**
 * 模板明细
 * @author wangqingzhu
 *
 */
public class OrTplNItemInfoCache {
	public static String OrTplNItemInfoCache_Key = "OrTplNItemInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";

	
	private OrTplNItemInfoCache() {
	}

	
	public static <T> void PutCache(CiEnContextDTO ctx, String key, T objEms){
		ContextCache.Put(OrTplNItemInfoCache.class.getSimpleName(), ctx.getId_grp(), ctx.getId_org(), OrTplNItemInfoCache_Key +","+ctx.getCode_entp(),key, objEms);
	}
	
	public static <T> T GetCache(CiEnContextDTO ctx, String key){
		return ContextCache.Get(OrTplNItemInfoCache.class.getSimpleName(),ctx.getId_grp(), ctx.getId_org(), OrTplNItemInfoCache_Key+","+ctx.getCode_entp(), key);
	}
	
	public static void Clear(){
		ContextCache.Clear(OrTplNItemInfoCache.class.getSimpleName());
	}
}
