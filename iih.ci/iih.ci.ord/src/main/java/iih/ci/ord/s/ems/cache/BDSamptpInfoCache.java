package iih.ci.ord.s.ems.cache;

import iih.bd.base.cache.ContextCache;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

/**
 * 标本类型缓存
 * @author wangqingzhu
 *
 */
public class BDSamptpInfoCache {
	public static String BDSamptpInfoCache_Key = "BDSamptpInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";

	
	private BDSamptpInfoCache() {
	}

	
	public static String GetNameOfBdSamptpInfo(String id_samptp) throws BizException {
		if(id_samptp == null){
			return null;
		}
		UdidocDO samptpInfo = ContextCache.Get(BDSamptpInfoCache.class.getSimpleName(),DefaultContext_ID, DefaultContext_ID, BDSamptpInfoCache_Key, id_samptp);
		if (null == samptpInfo) {
			UdidocDO[] szUdidocDO = ServiceFinder.find(IUdidocRService.class).findByAttrValString(UdidocDO.ID_UDIDOC, id_samptp);
			if (null != szUdidocDO && szUdidocDO.length > 0){
				samptpInfo = szUdidocDO[0];
				ContextCache.Put(BDSamptpInfoCache.class.getSimpleName(),DefaultContext_ID, DefaultContext_ID, BDSamptpInfoCache_Key, id_samptp, samptpInfo);
			}
			
		}
		return samptpInfo == null ? null : samptpInfo.getName();
	}
	
	public static void Clear(){
		ContextCache.Clear(BDSamptpInfoCache.class.getSimpleName());
	}
}
