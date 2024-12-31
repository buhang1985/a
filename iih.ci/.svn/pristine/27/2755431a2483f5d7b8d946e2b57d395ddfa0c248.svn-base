package iih.ci.sdk.cache;

import java.util.List;

import iih.bd.base.cache.ContextCache;
import iih.bd.srv.medsrv.d.MedSrvRelMmDTO;
import iih.ci.sdk.utils.CiOrdAppUtils;
import iih.ci.sdk.utils.ObjectUtils;
import xap.mw.core.data.BizException;

/**
 * 
 * @author wangqingzhu
 *
 */
public class BDSrvRelMmInfoCache {
	public static String BDSrvRelMmInfoCache_Key = "BDSrvRelMmInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";
	

	private BDSrvRelMmInfoCache() {
	}
	
	public static MedSrvRelMmDTO[] GetSrvRelMmInfos(String id_dep, String id_srv) throws BizException {
		List<MedSrvRelMmDTO> mInfoList = ContextCache.Get(BDSrvRelMmInfoCache.class.getSimpleName(), DefaultContext_ID,
				 DefaultContext_ID,id_dep, id_srv);
		if(ObjectUtils.isEmpty(mInfoList)) {
			MedSrvRelMmDTO[] srvrelmmdos = CiOrdAppUtils.getBdSrvQryQryService().getMedSrvRelMmDept(id_srv, id_dep);
			if(!ObjectUtils.isEmpty(srvrelmmdos)) {
				mInfoList = ObjectUtils.asList(srvrelmmdos);
				ContextCache.Put(BDSrvInfoCache.class.getSimpleName(), DefaultContext_ID,
						 DefaultContext_ID,id_dep, id_srv, mInfoList);
				 
			}
		}
		
		return ObjectUtils.isEmpty(mInfoList)?null:mInfoList.toArray(new MedSrvRelMmDTO[] {});
	}
	
	public static void Clear() {
		ContextCache.Clear(BDSrvRelMmInfoCache.class.getSimpleName()); 
	}
}
