package iih.ci.ord.s.ems.cache;

import iih.bd.base.cache.ContextCache;
import iih.ci.ord.ems.d.CiEnContextDTO;

/**
 * 模板通用缓存
 * @author wangqingzhu
 *
 */
public class BDTplInfoCache {
	public static String BDTplInfoCache_Key = "BDTplInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";

	
	private BDTplInfoCache() {
	}

	
	public static <T> void PutCache(CiEnContextDTO ctx, String key, String id, T tpl){
		ContextCache.Put(BDTplInfoCache.class.getSimpleName(), ctx.getId_grp(), ctx.getId_org(), BDTplInfoCache_Key +","+ctx.getCode_entp()+","+key, id, tpl);
	}
	
	public static <T> T GetCache(CiEnContextDTO ctx, String key,String id){
		return ContextCache.Get(BDTplInfoCache.class.getSimpleName(),ctx.getId_grp(), ctx.getId_org(), BDTplInfoCache_Key+","+ctx.getCode_entp()+","+key, id);
	}
	
	public static void Clear(){
		ContextCache.Clear(BDTplInfoCache.class.getSimpleName());
	}
}
