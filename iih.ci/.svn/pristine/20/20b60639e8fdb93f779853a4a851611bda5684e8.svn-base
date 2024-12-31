package iih.ci.sdk.cache;

import iih.bd.base.cache.ContextCache;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.i.IMedSrvDrugDORService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.sdk.utils.ObjectUtils;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 药品服务属性
 * @author wangqingzhu
 *
 */
public class BDMmPropInfoCache {
	public static String BDMmPropInfoCache_Key = "BDMmPropInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";

	private BDMmPropInfoCache() {
	}

	public static MedSrvDrugDO GetDrugPropInfo(CiEnContextDTO ctx,String id_srv) throws BizException{
		MedSrvDrugDO[] szMedSrvDrugDO = ContextCache.Get(BDMmPropInfoCache.class.getSimpleName(),ObjectUtils.isEmpty(ctx)?DefaultContext_ID:ctx.getId_grp(), 
				ObjectUtils.isEmpty(ctx)?DefaultContext_ID:ctx.getId_org(), BDMmPropInfoCache_Key, DefaultContext_ID);
		if (null == szMedSrvDrugDO || szMedSrvDrugDO.length == 0){
			szMedSrvDrugDO = ServiceFinder.find(IMedSrvDrugDORService.class)
					.findByAttrValString(MedSrvDrugDO.ID_SRV, id_srv);
		}
		
		return null == szMedSrvDrugDO || szMedSrvDrugDO.length == 0?null:szMedSrvDrugDO[0];
	}

	public static void Clear(){
		ContextCache.Clear(BDMmPropInfoCache.class.getSimpleName());
	}
}
