package iih.ci.ord.s.ems.cache;

import iih.bd.base.cache.ContextCache;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.i.IMedSrvDrugDORService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 药品属性缓存
 * @author wangqingzhu
 *
 */
public class BDSrvDrugInfoCache {
	public static String BDSrvDrugInfoCache_Key = "BDSrvDrugInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";

	private BDSrvDrugInfoCache() {
	}
	
	/**
	 * 根据id_srv获取检验属性对象
	 * @param ctx
	 * @param Id_srv
	 * @return
	 * @throws BizException
	 */
	public static MedSrvDrugDO GetBdSrvDrugInfo(CiEnContextDTO ctx, String Id_srv) throws BizException {
		MedSrvDrugDO medSrvDrugInfo = ContextCache.Get(BDSrvDrugInfoCache.class.getSimpleName(),null != ctx ? ctx.getId_grp() : DefaultContext_ID,
				null != ctx ? ctx.getId_org() : DefaultContext_ID,
				null != ctx ? String.format("%s||%s", BDSrvDrugInfoCache_Key, ctx.getCode_entp()) : BDSrvDrugInfoCache_Key,
				Id_srv);
		if (medSrvDrugInfo == null) {
			MedSrvDrugDO[] szDrugInfo = ServiceFinder.find(IMedSrvDrugDORService.class).findByAttrValString(MedSrvDrugDO.ID_SRV, Id_srv);
			
			if (null != szDrugInfo && szDrugInfo.length > 0) {
				medSrvDrugInfo = szDrugInfo[0];
				ContextCache.Put(BDSrvDrugInfoCache.class.getSimpleName(),null != ctx ? ctx.getId_grp() : DefaultContext_ID,
						null != ctx ? ctx.getId_org() : DefaultContext_ID, null != ctx
								? String.format("%s||%s", BDSrvDrugInfoCache_Key, ctx.getCode_entp()) : BDSrvDrugInfoCache_Key,
						Id_srv, medSrvDrugInfo);
			}
		}

		return medSrvDrugInfo;
	}
	
	/**
	 * 
	 */
	public static void Clear() {
		ContextCache.Clear(BDSrvDrugInfoCache.class.getSimpleName()); // 最后一个参数给空，则清空所有的BDSrvLisInfoCache_Key 下的缓存
	}
}
