package iih.ci.sdk.cache;

import java.util.List;

import iih.bd.base.cache.ContextCache;
import iih.bd.srv.medsrv.d.MedSrvConsDO;
import iih.bd.srv.medsrv.i.IMedSrvConsDORService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.sdk.utils.ObjectUtils;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 会诊服务属性缓存
 * @author wangqingzhu
 *
 */
public class BDSrvConsInfoCache {
	public static String BDSrvConsInfoCache_Key = "BDSrvConsInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";
	
	private BDSrvConsInfoCache() {
	}
	
	public static MedSrvConsDO GetBdSrvConsInfo(CiEnContextDTO ctx, String Id_srv) throws BizException {
		MedSrvConsDO mInfo = ContextCache.Get(BDSrvConsInfoCache.class.getSimpleName(),null != ctx ? ctx.getId_grp() : DefaultContext_ID,
				null != ctx ? ctx.getId_org() : DefaultContext_ID,
				null != ctx ? String.format("%s||%s", BDSrvConsInfoCache_Key, ctx.getCode_entp()) : BDSrvConsInfoCache_Key,
				Id_srv);
		if (null == mInfo) {
			MedSrvConsDO[] szSrvConsInfo = ServiceFinder.find(IMedSrvConsDORService.class).findByAttrValStrings(MedSrvConsDO.ID_SRV, new String[] {Id_srv});
			if (!ObjectUtils.isEmpty(szSrvConsInfo)) {
				mInfo = szSrvConsInfo[0];
				ContextCache.Put(BDSrvConsInfoCache.class.getSimpleName(),null != ctx ? ctx.getId_grp() : DefaultContext_ID,
						null != ctx ? ctx.getId_org() : DefaultContext_ID, null != ctx
								? String.format("%s||%s", BDSrvConsInfoCache_Key, ctx.getCode_entp()) : BDSrvConsInfoCache_Key,
						Id_srv, mInfo);
			}
		}

		return mInfo;
	}
	
	public static MedSrvConsDO[] GetBdSrvConsInfos(CiEnContextDTO ctx, String[] szId_srv) throws BizException {
		List<MedSrvConsDO> mInfoList = ContextCache.Get(BDSrvConsInfoCache.class.getSimpleName(),null != ctx ? ctx.getId_grp() : DefaultContext_ID,
				null != ctx ? ctx.getId_org() : DefaultContext_ID,
				null != ctx ? String.format("L||%s||%s", BDSrvConsInfoCache_Key, ctx.getCode_entp()) : BDSrvConsInfoCache_Key,
						ObjectUtils.asString(szId_srv));
		if (ObjectUtils.isEmpty(mInfoList)) {
			MedSrvConsDO[] szSrvConsInfo = ServiceFinder.find(IMedSrvConsDORService.class).findByAttrValStrings(MedSrvConsDO.ID_SRV, szId_srv);
			if (!ObjectUtils.isEmpty(szSrvConsInfo)) {
				mInfoList = ObjectUtils.asList(szSrvConsInfo);
				ContextCache.Put(BDSrvConsInfoCache.class.getSimpleName(),null != ctx ? ctx.getId_grp() : DefaultContext_ID,
						null != ctx ? ctx.getId_org() : DefaultContext_ID, null != ctx
								? String.format("L||%s||%s", BDSrvConsInfoCache_Key, ctx.getCode_entp()) : BDSrvConsInfoCache_Key,
										ObjectUtils.asString(szId_srv), mInfoList);
			}
		}

		return ObjectUtils.isEmpty(mInfoList)?null:mInfoList.toArray(new MedSrvConsDO[mInfoList.size()]); 
	}
	
	public static void Clear() {
		ContextCache.Clear(BDSrvConsInfoCache.class.getSimpleName()); 
	}
}
