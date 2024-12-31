package iih.ci.sdk.cache;

import iih.bd.base.cache.ContextCache;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 所有医务人员缓存信息
 * @author wangqingzhu
 *
 */
public class BDPsnInfoCache {

	public static String BDPsnInfoCache_Key = "BDPsnInfoCachee_Key";
	public static String DefaultContext_ID = "@@@@";

	
	private BDPsnInfoCache() {
	}

	
	public static PsnDocDO GetPsnInfoOfIdPsn(String id_psn) throws BizException {
		PsnDocDO psnInfo = ContextCache.Get(BDPsnInfoCache.class.getSimpleName(),DefaultContext_ID, DefaultContext_ID, BDPsnInfoCache_Key, id_psn);
		if (null == psnInfo) {
			PsnDocDO[] szPsnDocDO = ServiceFinder.find(IPsndocMDORService.class).findByAttrValString(PsnDocDO.ID_PSNDOC, id_psn);
			if (null != szPsnDocDO && szPsnDocDO.length > 0){
				ContextCache.Put(BDPsnInfoCache.class.getSimpleName(),DefaultContext_ID, DefaultContext_ID, BDPsnInfoCache_Key, id_psn, szPsnDocDO[0]);
				return szPsnDocDO[0];
			}
			
		}
		return psnInfo;
	}
	

	public static void Clear(){
		ContextCache.Clear(BDPsnInfoCache.class.getSimpleName());
	}
	
}
