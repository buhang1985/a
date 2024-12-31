package iih.ci.sdk.cache;

import iih.bd.base.cache.ContextCache;
import iih.bd.bc.medterm.d.SampCollectTimeDictDO;
import iih.bd.bc.medterm.i.ISampcoltimedictRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 标本类型缓存
 * @author wangqingzhu
 *
 */
public class BDSampcolTimeInfoCache {
	public static String BDSampcolTimeInfoCache_Key = "BDSampcolTimeInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";

	
	private BDSampcolTimeInfoCache() {
	}

	
	public static SampCollectTimeDictDO GetBDSampcolTimeInfo(String id_sampcoltime) throws BizException {
		SampCollectTimeDictDO sampColTimeInfo = ContextCache.Get(BDSampcolTimeInfoCache.class.getSimpleName(),DefaultContext_ID, DefaultContext_ID, BDSampcolTimeInfoCache_Key, id_sampcoltime);
		if (null == sampColTimeInfo) {
			SampCollectTimeDictDO rtnDo = ServiceFinder.find(ISampcoltimedictRService.class).findById(id_sampcoltime);
			if (null != rtnDo){
				sampColTimeInfo = rtnDo;
				ContextCache.Put(BDSampcolTimeInfoCache.class.getSimpleName(),DefaultContext_ID, DefaultContext_ID, BDSampcolTimeInfoCache_Key, id_sampcoltime, sampColTimeInfo);
			}
			
		}
		return sampColTimeInfo;
	}
	
	public static void Clear(){
		ContextCache.Clear(BDSampcolTimeInfoCache.class.getSimpleName());
	}
}
