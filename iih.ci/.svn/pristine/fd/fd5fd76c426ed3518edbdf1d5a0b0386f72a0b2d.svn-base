package iih.ci.ord.s.external.thirdws.utils;

import iih.bd.srv.medusage.d.MedUsageDO;
import iih.bd.srv.medusage.d.MedUsageDesDO;
import iih.bd.srv.medusage.i.IMedusageRService;
import iih.bd.srv.medusage.i.IMedusagedesRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 用法相关工具类
 * @author zhangwq
 *
 */
public class RouteUtils {
	/**
	 * 查询用法
	 * @param usagecode
	 * @return
	 * @throws BizException
	 */
	public static MedUsageDO getMedUsageDO(String usagecode) throws BizException{
		IMedusageRService service = ServiceFinder.find(IMedusageRService.class);
		MedUsageDO[] usages = service.findByAttrValString(MedUsageDO.CODE, usagecode);
		if(usages!=null && usages.length>0){
			return usages[0];
		}
		return null;
	}
	/**
	 * 查询用法要求
	 * @param code
	 * @return
	 * @throws BizException
	 */
	public static MedUsageDesDO getUsageDes(String code) throws BizException{
		IMedusagedesRService service = ServiceFinder.find(IMedusagedesRService.class);
		MedUsageDesDO[] usagedess = service.findByAttrValString(MedUsageDesDO.CODE, code);
		if(usagedess!=null && usagedess.length>0){
			return usagedess[0];
		}
		return null;
	}
}
