package iih.ci.sdk.cache;

import iih.bd.base.cache.ContextCache;
import iih.ci.sdk.utils.ObjectUtils;
import iih.pi.reg.dto.d.PiPatBasicInfoDTO;
import iih.pi.reg.i.IPiRegQryService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 患者信息缓存，属于懒加载的方式
 * 
 * @author wangqingzhu
 *
 */
public class PatInfoCache {

	public static final String PATCacheKey = "PI_PAT_DEF_CACHEKEY";
	public static String DefaultContext_ID = "@@@@";
	private static PatInfoCache ins = new PatInfoCache();

	private PatInfoCache() {
	}

	/**
	 * 根据患者id获取患者基本信息
	 * 
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	private PiPatBasicInfoDTO getPiPatBasicInfo(String id_pat) throws BizException {

		PiPatBasicInfoDTO patInfo = ContextCache.Get(PatInfoCache.class.getSimpleName(),DefaultContext_ID, DefaultContext_ID, PATCacheKey, id_pat);
		if (null == patInfo) {
			PiPatBasicInfoDTO[] rst = ServiceFinder.find(IPiRegQryService.class)
					.findPiPatBasicInfoByPatIds(new String[] { id_pat });
			if (ObjectUtils.isEmpty(rst)) {
				return null;
			}
			patInfo = rst[0];
			ContextCache.Put(PatInfoCache.class.getSimpleName(),DefaultContext_ID, DefaultContext_ID, PATCacheKey, id_pat, patInfo);
		}

		return patInfo;
	}

	/**
	 * 获取患者姓名
	 * 
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	public static String GetPatName(String id_pat) throws BizException {
		PiPatBasicInfoDTO patInfo = ins.getPiPatBasicInfo(id_pat);
		if (ObjectUtils.isEmpty(patInfo)) {
			return null;
		}
		return patInfo.getName();
	}

	/**
	 * 获取患者性别
	 * 
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	public static String GetPatSex(String id_pat) throws BizException {
		PiPatBasicInfoDTO patInfo = ins.getPiPatBasicInfo(id_pat);
		if (ObjectUtils.isEmpty(patInfo)) {
			return null;
		}
		return patInfo.getSd_sex();
	}

	/**
	 * 获取患者年龄
	 * 
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	public static String GetPatAge(String id_pat) throws BizException {
		PiPatBasicInfoDTO patInfo = ins.getPiPatBasicInfo(id_pat);
		if (ObjectUtils.isEmpty(patInfo)) {
			return null;
		}
		return patInfo.getAge();
	}

	/**
	 * 获取患者生日
	 * 
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	public static String GetPatBirth(String id_pat) throws BizException {
		PiPatBasicInfoDTO patInfo = ins.getPiPatBasicInfo(id_pat);
		if (ObjectUtils.isEmpty(patInfo)) {
			return null;
		}
		return patInfo.getDt_birth().toString();
	}
	
	public static PiPatBasicInfoDTO GetPatInfo(String id_pat) throws BizException {
		PiPatBasicInfoDTO patInfo = ins.getPiPatBasicInfo(id_pat);
		return patInfo;
	}

	/**
	 * 清空缓存对象
	 */
	public static void Clear() {
		ContextCache.Clear(PatInfoCache.class.getSimpleName());
	}
}
