package iih.ci.sdk.cache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.bd.base.cache.ContextCache;
import iih.bd.srv.routedosage.d.RouteDosageRefDO;
import iih.bd.srv.routedosage.i.IRoutedosageRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 剂型缓存器
 * @author wangqingzhu
 *
 */
public class BDDosageInfoCache {
	public static String BDDosageInfoCache_Key = "BDDosageInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";

	private BDDosageInfoCache() {
	}


	public static String[] GetIdsOfDosageInfo(String id_route) throws BizException{
		List<RouteDosageRefDO> dosageList = ContextCache.Get(BDDosageInfoCache.class.getSimpleName(),DefaultContext_ID, DefaultContext_ID, BDDosageInfoCache_Key, id_route);
		if(null == dosageList){
			RouteDosageRefDO[] routeDosages = ServiceFinder.find(IRoutedosageRService.class).find("id_route='" + id_route + "'",
					null, FBoolean.FALSE);
			if(null != routeDosages && routeDosages.length > 0){
				dosageList = Arrays.asList(routeDosages);
				ContextCache.Put(BDDosageInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID, BDDosageInfoCache_Key, id_route, dosageList);
			}
		}
		
		List<String> infoList = new ArrayList<String>(); 
		if (dosageList != null && dosageList.size() > 0) {
			
			for (RouteDosageRefDO routeDosageRef : dosageList) {
				infoList.add(routeDosageRef.getId_dosage());
			}
			
		}
		return infoList.toArray(new String[infoList.size()]);
	}
	
	public static void Clear(){
		ContextCache.Clear(BDDosageInfoCache.class.getSimpleName());
	}
}
