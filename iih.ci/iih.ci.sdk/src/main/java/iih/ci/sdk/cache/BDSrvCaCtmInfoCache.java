package iih.ci.sdk.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.cache.ContextCache;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.sdk.database.SqlParamBuilder;
import iih.ci.sdk.database.SqlParamDbUtils;
import xap.mw.core.data.BizException;

/**
 * 服务自定义分类缓存
 * 
 * @author liuxiaoying
 *
 */
public class BDSrvCaCtmInfoCache {
	public static String BDSrvCaCtmInfoCache = "BDSrvCaCtmInfoCache";
	public static String DefaultContext_ID = "@@@@";
	private static BDSrvCaCtmInfoCache ins = new BDSrvCaCtmInfoCache();

	private BDSrvCaCtmInfoCache() {
	}

	private Map<String,List<String>> get(String id_srv) throws BizException {

		Map<String,List<String>> mmMap=new HashMap<String,List<String>>();
		String sql="select srvrel.id_srv,srvitm.id_srvcactm from bd_srvca_ctm_itm_rel srvrel left join bd_srvca_ctm_itm srvitm on srvitm.id_srvcactmitm=srvrel.id_srvcactmitm where srvrel.id_srv=?";
		iih.ci.sdk.database.ListMapRecordSet rstMap= SqlParamDbUtils.Q(new SqlParamBuilder(sql).appendParam(id_srv));
		if(rstMap.size()>0){
			for(Map<String, Object> map:rstMap){
				if(mmMap.containsKey(map.get("id_srv"))){
					mmMap.get("id_srv").add(map.get("id_srvcactm").toString());
				}else{
					List<String> id_mmcauslist=new ArrayList<String>();
					id_mmcauslist.add(map.get("id_srvcactm").toString());
					mmMap.put(map.get("id_srv").toString(), id_mmcauslist);
				}
			}
		}
		return mmMap;
	}

	public static String GetMeterialInfo(CiEnContextDTO ctx, String id_srv) throws BizException {
		String mmcausids = ContextCache.Get(BDSrvCaCtmInfoCache.class.getSimpleName(),null != ctx ? ctx.getId_grp() : DefaultContext_ID,
				null != ctx ? ctx.getId_org() : DefaultContext_ID,
						null != ctx ? String.format("%s||%s", BDSrvCaCtmInfoCache, ctx.getCode_entp())
								: BDSrvCaCtmInfoCache,
								id_srv);
		if (null == mmcausids || "".equals(mmcausids)) {
			Map<String,List<String>> infMap = (Map<String,List<String>>) ins.get(id_srv);
			if (infMap != null && infMap.size() > 0) {
				List<String> mmcausidlist=infMap.get(id_srv);
				String ids="";
				for(String id:mmcausidlist){
					ids+=","+id;
				}
				mmcausids=ids.substring(1);
				ContextCache.Put(BDSrvCaCtmInfoCache.class.getSimpleName(),null != ctx ? ctx.getId_grp() : DefaultContext_ID,
						null != ctx ? ctx.getId_org() : DefaultContext_ID,
								null != ctx ? String.format("%s||%s", BDSrvCaCtmInfoCache, ctx.getCode_entp())
										: BDSrvCaCtmInfoCache,
										id_srv, mmcausids);
			}
		}

		return mmcausids;
	}
	

	public static void Clear() {
		ContextCache.Clear(BDSrvCaCtmInfoCache.class.getSimpleName()); // 最后一个参数给空，则清空所有的BDSrvCaCtmInfoCache 下的缓存
	}
}
