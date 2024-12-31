package iih.ci.ord.s.ems.cache;

import org.apache.commons.lang3.StringUtils;

import iih.bd.base.cache.ContextCache;
import iih.ci.ord.s.ems.meta.StringList;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;

/**
 * 用户信息缓存
 * 
 * @author wangqingzhu
 *
 */
public class BDUserInfoCache {
	public static String BDUserInfoCache_Key = "BDUserInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";

	private BDUserInfoCache() {
	}

	public static String GetNameOfSysUserInfo(String id_user) throws BizException {
		UserDO userInfo = ContextCache.Get(BDUserInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID,
				BDUserInfoCache_Key, id_user);
		if (null == userInfo) {
			userInfo = (UserDO) ServiceFinder.find(IUserRService.class).findById(id_user);

			if (null != userInfo) {

				ContextCache.Put(BDUserInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID,
						BDUserInfoCache_Key, id_user, userInfo);
			}

		}
		return userInfo == null ? null : userInfo.getName();
	}

	/**
	 * 根据人员ID，获取 用户名称
	 * 
	 * @param id_psn
	 * @return
	 * @throws BizException
	 */
	public static String GetNameOfSysUserInfoWithPsnID(String id_psn) throws BizException {
		UserDO userInfo = ContextCache.Get(BDUserInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID,
				BDUserInfoCache_Key, id_psn);
		if (null == userInfo) {
			UserDO[] szUserInfo = (UserDO[]) ServiceFinder.find(IUserRService.class).findByAttrValStrings(UserDO.ID_PSN,
					new String[] { id_psn });

			if (null != szUserInfo && szUserInfo.length > 0) {
				userInfo = szUserInfo[0];
				ContextCache.Put(BDUserInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID,
						BDUserInfoCache_Key, id_psn, userInfo);
			}

		}
		return userInfo == null ? null : userInfo.getName();
	}

	/**
	 * 根据人员ID 获取用户ID
	 * 
	 * @param id_psn
	 * @return
	 * @throws BizException
	 */
	public static String GetUserIDOfSysUserInfoWithPsnID(String id_psn) throws BizException {
		UserDO userInfo = ContextCache.Get(BDUserInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID,
				BDUserInfoCache_Key, id_psn);
		if (null == userInfo) {
			UserDO[] szUserInfo = (UserDO[]) ServiceFinder.find(IUserRService.class).findByAttrValStrings(UserDO.ID_PSN,
					new String[] { id_psn });

			if (null != szUserInfo && szUserInfo.length > 0) {
				userInfo = szUserInfo[0];
				ContextCache.Put(BDUserInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID,
						BDUserInfoCache_Key, id_psn, userInfo);
			}

		}
		return userInfo == null ? null : userInfo.getId_user();
	}

	/**
	 * 根据人员ID 获取用户ID
	 * 
	 * @param id_psn
	 * @return
	 * @throws BizException
	 */
	public static String[] GetUserIDsOfSysUserInfoWithPsnIDs(String[] szId_psn) throws BizException {
		StringList useridList = new StringList();
		// 循环查看缓存是否存在，并获取用户ID
		for (String id_psn : szId_psn) {
			String id_user = GetUserIDOfSysUserInfoWithPsnID(id_psn);
			if (!StringUtils.isEmpty(id_user)) {
				useridList.add(id_user);
			}
		}

		return useridList.asArray();
	}

	public static void Clear() {
		ContextCache.Clear(BDUserInfoCache.class.getSimpleName());
	}
}
