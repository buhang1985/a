package iih.bd.srv.medsrv.refs.sql.hptype;

import java.util.Map;

import xap.lui.core.cache.XapCacheMgr;
import xap.mw.core.data.Context;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapHandler;

/**
 * @code 医保目录类型缺省值获取
 * @author LiYue
 * @date 2020年1月6日,下午3:08:55
 */
public class HptypeDisplay {
	
	private static HptypeDisplay hptypeDisplay;
	private HptypeDisplay(){
	}
	public static HptypeDisplay getInstance()	{
		if(hptypeDisplay==null){
			hptypeDisplay = new HptypeDisplay();
		}
		return hptypeDisplay;
	}
	
	// 判断【医保目录类型】字典中是否存在【缺省值标志】CTRL1=Y的数据，若存在则显示启用的第一条缺省值。
	// 若不存在，则显示空。
	public String getHptyDisplay() {
		String key = MakeRedisKey(Context.get().getGroupId(), Context.get().getOrgId(), HptypeDisplay.class.getName(),
				"hptypeDisplay");
		String id_org = Context.get().getOrgId();
		//缓存里有直接取，缓存没有，查出来放到缓存里
		if (XapCacheMgr.getStrongCacheAdapter(HptypeDisplay.class.getName()).containsKey(key)) {
			return (String) XapCacheMgr.getStrongCacheAdapter(HptypeDisplay.class.getName()).get(key);
		} else {
			Map<String, Object> HptyMap;
			String sql = "select name from  bd_udidoc where ID_UDIDOCLIST='@@@@ZZ2000000000003P' and ACTIVESTATE = '2' and CTRL1 ='Y' ";
			try {
				HptyMap = (Map<String, Object>) new DAFacade().execQuery(sql, new MapHandler());
				XapCacheMgr.getStrongCacheAdapter(HptypeDisplay.class.getName()).put(key,
						HptyMap.get("name").toString());
			} catch (Exception e) {
				XapCacheMgr.getStrongCacheAdapter(HptypeDisplay.class.getName()).put(key, " ");
			}

		}
		return (String) XapCacheMgr.getStrongCacheAdapter(HptypeDisplay.class.getName()).get(key);
	}
	
	/**
	 * 构建Redis缓存key
	 * 
	 * @param sid
	 * @param key
	 * @return
	 */
	public static String MakeRedisKey(String groupID, String orgID, String sid, String key) {
		return String.format("%s/%s/%s@%s", groupID, orgID, sid, key);
	}
	public static void clear(){
		XapCacheMgr.getStrongCacheAdapter(HptypeDisplay.class.getName()).clear();
	}
}
