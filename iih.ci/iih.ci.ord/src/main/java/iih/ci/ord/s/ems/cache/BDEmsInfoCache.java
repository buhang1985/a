package iih.ci.ord.s.ems.cache;

import iih.bd.base.cache.ContextCache;
import iih.ci.ord.ems.d.CiEnContextDTO;

/**
 * 医疗单基础信息缓存
 * @author wangqingzhu
 *
 */
public class BDEmsInfoCache {
	public static String BDEmsInfoCache_Key = "BDEmsInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";

	
	private BDEmsInfoCache() {
	}

	
	public static <T> void PutCache(CiEnContextDTO ctx, String id_ems, String id_srv, T objEms){
		ContextCache.Put(BDEmsInfoCache.class.getSimpleName(), ctx.getId_grp(), ctx.getId_org(), BDEmsInfoCache_Key +","+ctx.getCode_entp()+","+id_ems, id_srv, objEms);
	}
	
	public static <T> T GetCache(CiEnContextDTO ctx, String id_ems,String id_srv){
		return ContextCache.Get(BDEmsInfoCache.class.getSimpleName(),ctx.getId_grp(), ctx.getId_org(), BDEmsInfoCache_Key+","+ctx.getCode_entp()+","+id_ems, id_srv);
	}
	
	public static void Clear(){
		ContextCache.Clear(BDEmsInfoCache.class.getSimpleName());
	}
}
