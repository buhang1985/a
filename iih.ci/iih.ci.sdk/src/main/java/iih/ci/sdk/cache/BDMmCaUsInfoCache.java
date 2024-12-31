package iih.ci.sdk.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.cache.ContextCache;
import iih.bd.base.database.ListMapRecordSet;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.sdk.database.SqlParamBuilder;
import iih.ci.sdk.database.SqlParamDbUtils;
import iih.ci.sdk.utils.ObjectUtils;
import xap.mw.core.data.BizException;

/**
 * 物品自定义分类缓存
 * 
 * @author liuxiaoying
 *
 */
public class BDMmCaUsInfoCache {
	public static String BDMmCaUsInfoCache = "BDMmCaUsInfoCache";
	public static String DefaultContext_ID = "@@@@";
	private static BDMmCaUsInfoCache ins = new BDMmCaUsInfoCache();

	private BDMmCaUsInfoCache() {
		
	}

	private Map<String,List<String>> get(String id_mm) throws BizException {
		Map<String,List<String>> mmMap = new HashMap<String,List<String>>();
		String sql = "select rel.id_mmorca as id_mm,itm.id_mmcaus from bd_mmca_us_itm_rel rel left join bd_mmca_us_itm itm on itm.id_mmcausitm=rel.id_mmcausitm where rel.id_mmorca=?";
		iih.ci.sdk.database.ListMapRecordSet rstMap = SqlParamDbUtils.Q(new SqlParamBuilder(sql).appendParam(id_mm));
		if (rstMap.size() > 0) {
			for (Map<String, Object> map : rstMap) {
				List<String> id_mmcauslist = null;
				String id_mmcaus = ObjectUtils.isEmpty(map.get("id_mmcaus")) ? "" : map.get("id_mmcaus").toString();
				if (mmMap.containsKey(map.get("id_mm"))) {
					id_mmcauslist = mmMap.get(map.get("id_mm"));
				} else {
					id_mmcauslist = new ArrayList<String>();
					mmMap.put(map.get("id_mm").toString(), id_mmcauslist);
				}
				
				if (!ObjectUtils.isEmpty(id_mmcaus)) {
					id_mmcauslist.add(id_mmcaus);
				}
			}
		}
		return mmMap;
	}

	public static String GetMeterialInfo(CiEnContextDTO ctx, String id_mm) throws BizException {
		String mmcausids = ContextCache.Get(BDMmCaUsInfoCache.class.getSimpleName(),null != ctx ? ctx.getId_grp() : DefaultContext_ID,
				null != ctx ? ctx.getId_org() : DefaultContext_ID,
						null != ctx ? String.format("%s||%s", BDMmCaUsInfoCache, ctx.getCode_entp())
								: BDMmCaUsInfoCache,
								id_mm);
		if (null == mmcausids || "".equals(mmcausids)) {
			Map<String,List<String>> infMap = (Map<String,List<String>>) ins.get(id_mm);
			if (infMap != null && infMap.size() > 0) {
				List<String> mmcausidlist=infMap.get(id_mm);
				String ids="";
				if(mmcausidlist.size() >0){
					for(String id:mmcausidlist){
						ids+=","+id;
					}
					mmcausids=ids.substring(1);
				}
				
				
				ContextCache.Put(BDMmCaUsInfoCache.class.getSimpleName(),null != ctx ? ctx.getId_grp() : DefaultContext_ID,
						null != ctx ? ctx.getId_org() : DefaultContext_ID,
								null != ctx ? String.format("%s||%s", BDMmCaUsInfoCache, ctx.getCode_entp())
										: BDMmCaUsInfoCache,
										id_mm, mmcausids);
			}
		}

		return mmcausids;
	}
	

	public static void Clear() {
		ContextCache.Clear(BDMmCaUsInfoCache.class.getSimpleName()); // 最后一个参数给空，则清空所有的BDMmCaUsInfoCache 下的缓存
	}
}
