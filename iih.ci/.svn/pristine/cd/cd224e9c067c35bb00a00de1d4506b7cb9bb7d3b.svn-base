package iih.ci.ord.s.ems.cache;

import iih.bd.base.cache.ContextCache;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

/**
 * 检查目的
 * 
 * @author wangqingzhu
 *
 */
public class BDPpsInfoCache {
	public static String BDPpsInfoCache_Key = "BDPpsInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";

	private BDPpsInfoCache() {
	}

	public static UdidocDO GetBdPpsInfo() throws BizException {
		UdidocDO[] szUdidocDO = ServiceFinder.find(IUdidocRService.class).findByAttrValString(UdidocDO.ID_UDIDOCLIST,
				"@@@@ZZ20000000000075");
		return null == szUdidocDO || szUdidocDO.length == 0 ? null : szUdidocDO[0];
	}

	public static String GetNameOfBdPpsInfo(String id_pps) throws BizException {
		UdidocDO ppsInfo = ContextCache.Get(BDPpsInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID,
				BDPpsInfoCache_Key, id_pps);
		if (null == ppsInfo) {
			UdidocDO[] szUdidocDO = ServiceFinder.find(IUdidocRService.class).findByAttrValString(UdidocDO.ID_UDIDOC,
					id_pps);
			if (null != szUdidocDO && szUdidocDO.length > 0) {
				ContextCache.Put(BDPpsInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID,
						BDPpsInfoCache_Key, id_pps, ppsInfo);
			}

		}
		return ppsInfo == null ? null : ppsInfo.getName();
	}

	public static void Clear() {
		ContextCache.Clear(BDPpsInfoCache.class.getSimpleName());
	}
}
