package iih.bd.base.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import xap.lui.core.cache.XapCache;
import xap.lui.core.cache.XapCacheMgr;

/**
 * 固定时间寄存器
 * 
 * @author wangqingzhu
 *
 */
public class ContextCache implements ICacheConstData {

	/**
	 * 缓存标记
	 */
	private static String CACHETAG = "@@@@[CI]@@@@";

	/**
	 * 获取缓存器对象
	 * 
	 * @param ca
	 * @return
	 */
	private static XapCache GetBizXapCacheByCa(String cacheID) {

		XapCache rootCache = GetRootCache();

		List<String> keyList = GetAllKeyList();
		if (keyList == null) {
			keyList = new ArrayList<String>();
			GetRootCache().put(CACHETAG, keyList);
		}
		if (!keyList.contains(CACHETAG + cacheID)) {
			keyList.add(CACHETAG + cacheID);
			rootCache.put(CACHETAG, keyList);
		}

		return XapCacheMgr.getStrongCacheAdapter(CACHETAG + cacheID);
	}

	private static XapCache GetBizXapCache(String cacheID) {
		return XapCacheMgr.getStrongCacheAdapter(CACHETAG + cacheID);
	}

	private static XapCache GetRootCache() {
		return XapCacheMgr.getStrongCacheAdapter(CACHETAG);
	}

	private static List<String> GetAllKeyList() {
		if (GetRootCache().containsKey(CACHETAG)) {
			return (List<String>) GetRootCache().get(CACHETAG);
		}
		return null;
	}

	/**
	 * 多组织缓存支持
	 * 
	 * @param groupID
	 * @param orgID
	 * @param sessionId
	 * @param key
	 * @return
	 */
	public static boolean Contains(String cacheID, String grpID, String orgID, String sessionId, String key) {
		// 有效性判断
		if (StringUtils.isEmpty(grpID) || StringUtils.isEmpty(orgID) || StringUtils.isEmpty(sessionId)) {
			return false;
		}
		// 判断缓存key中是否包含给定的缓存key
		return GetBizXapCacheByCa(cacheID).containsKey(MakeRedisKey(grpID, orgID, sessionId, key));

	}

	/**
	 * 从缓存器获取对象
	 * 
	 * @param cacheID
	 * @param grpID
	 * @param orgID
	 * @param sessionId
	 * @param key
	 * @return
	 */
	public static <T> T Get(String cacheID, String grpID, String orgID, String sessionId, String key) {
		// 有效性判断
		if (StringUtils.isEmpty(grpID) || StringUtils.isEmpty(orgID) || StringUtils.isEmpty(sessionId)) {
			return null;
		}

		// 增加获取缓存异常时候，处理机制
		Object objValue = null;
		try {
			// 获取缓存服务器中的数据
			objValue = GetBizXapCache(cacheID).get(MakeRedisKey(grpID, orgID, sessionId, key));
		} catch (Throwable e) {
			// 出现异常，则清空缓存服务器中的该缓存记录

		}
		return (T) objValue;
	}

	/**
	 * 向缓存器中设置对象
	 * 
	 * @param cacheID
	 * @param grpID
	 * @param orgID
	 * @param sessionId
	 * @param key
	 * @param value
	 */
	public static <T> void Put(String cacheID, String grpID, String orgID, String sessionId, String key, T value) {
		if (StringUtils.isEmpty(sessionId) || StringUtils.isEmpty(key) || StringUtils.isEmpty(grpID)
				|| StringUtils.isEmpty(orgID) || null == value) {
			return;
		}

		GetBizXapCacheByCa(cacheID).put(MakeRedisKey(grpID, orgID, sessionId, key), value);
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

	public static String[] UnMakeRedisKey(String key) {
		return key.split("@");

	}

	/**
	 * 按照缓存类型清空缓存
	 * 
	 * @param cacheType
	 */
	public static void Clear(String cacheID, String grpID, String orgID, String sessionID, String kw) {
		Set<String> allKeys = GetBizXapCache(cacheID).getKeys();
		String findKey = MakeRedisKey(grpID, orgID, sessionID, kw == null ? "" : kw);

		for (String key : allKeys) {
			if (key.contains(findKey)) {
				GetBizXapCacheByCa(cacheID).remove(key);
			}
		}

	}

	public static void Clear(String cacheID) {
		List<String> allKeys = GetAllKeyList();
		if (null != allKeys && allKeys.contains(cacheID)) {
			allKeys.remove(cacheID);
			GetRootCache().put(CACHETAG, allKeys);

			GetBizXapCache(cacheID).clear();
		}

	}

	/**
	 * 按照缓存类型清空缓存
	 * 
	 * @param cacheType
	 */
	public static void ClearAll() {
		List<String> allKeys = GetAllKeyList();
		if (null != allKeys) {

			for (String cacheID : allKeys) {
				XapCacheMgr.getStrongCacheAdapter(cacheID).clear();
			}
			GetRootCache().clear();
		}

	}

}
