package iih.ci.ord.s.ems.cache;

import iih.bd.base.cache.ContextCache;
import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

/**
 * 获取服务类型
 * 
 * @author Young
 *
 */
public class BDSrvtpInfoCache {

	public static String BDSrvtpInfoCache_Key = "BDSrvtpInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";

	private static UdidocDO[] getBdSrvtp() throws BizException {

		UdidocDO[] result = ServiceFinder.find(IUdidocServiceExt.class)
				.findByUdidoclistCode(IBdSrvDictCodeTypeConst.SD_SRVTP);
		return result;
	}

	public static UdidocDO[] GetBdSrvtpInfo(String[] sd_srvtps) throws BizException {
		// 有效性判断
		if (sd_srvtps == null || sd_srvtps.length <= 0) {
			return null;
		}
		UdidocDO[] bdsrvtp = new UdidocDO[sd_srvtps.length];
		int i = 0;
		for (String sd : sd_srvtps) {

			// 如果没有命中缓存，则查询基础定义档案，并缓存所有
			bdsrvtp[i] = ContextCache.Get(BDSrvtpInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID, BDSrvtpInfoCache_Key, sd);

			if (null == bdsrvtp[i]) {
				UdidocDO[] objs = getBdSrvtp();
				for (UdidocDO obj : objs) {
					if (obj.getCode().equals(sd)) {
						bdsrvtp[i] = obj;
						ContextCache.Put(BDSrvtpInfoCache.class.getSimpleName(),DefaultContext_ID, DefaultContext_ID, BDSrvtpInfoCache_Key, obj.getCode(),
								obj);
					}

				}
			}

			i++;
		}
		return bdsrvtp;
	}

	public static UdidocDO GetBdSrvtpInfo(String sd_srvtp) throws BizException {
		UdidocDO[] bdsrvtp = GetBdSrvtpInfo(new String[] { sd_srvtp });
		return bdsrvtp[0];
	}

	public static String GetNameOfBDSrvtpInfo(String sd_srvtp) throws BizException {
		UdidocDO rst = GetBdSrvtpInfo(sd_srvtp);
		return null != rst ? rst.getName() : null;
	}
}
