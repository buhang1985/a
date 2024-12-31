package iih.ci.ord.s.ems.cache;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.meta.StringList;

/**
 * 医疗单列表缓存
 * @author wangqingzhu
 *
 */
public class EmsListCacheAction extends BaseCacheAction {

	@Override
	public boolean prepareCacheL2(CiEnContextDTO ctx, StringList ids) {
//		String sessionKey = L2SessionKeyWith(ctx);
//		if (!this.isHitCahce(sessionKey, EmsList_Cache_Key)){
//			// 获取医嘱信息
//			List<CiOrderDO> ordList = (List<CiOrderDO>)this.getCache(sessionKey, OrderList_Cache_Key);
//			if(null != ordList && ordList.size() != 0){
//				StringList ordIdList = new StringList();
//				for (CiOrderDO o : ordList){
//					ordIdList.add(o.getId_or());
//				}
//				// 缓存该就诊下的所有医疗单
//				
//			}
//			
//		}
		return false;
	}

	@Override
	public boolean prepareCacheL3(CiEnContextDTO ctx, StringList ids) {
//		String sessionKey = L3SessionKeyWith(ctx);
//		
//		
//		if (!CacheContext.GetInstance().contains(sessionKey, EmsList_Cache_Key)){
//			// 缓存该就诊下的所有医疗单
//			
//		}
		return true;
	}
	
}
