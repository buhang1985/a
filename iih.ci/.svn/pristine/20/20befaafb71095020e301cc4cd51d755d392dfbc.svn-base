package iih.ci.sdk.cache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.bd.base.cache.ContextCache;
import iih.bd.srv.medsrv.d.MedSrvSaniDO;
import iih.bd.srv.medsrv.i.IMedSrvSaniDORService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医疗服务卫材属性缓存
 * @author HUMS
 *
 */
public class BDSrvSaniInfoCache {
	
	public static String BDSrvSaniInfoCache_Key = "BDSrvSaniInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";
	private static BDSrvSaniInfoCache ins = new BDSrvSaniInfoCache();

	private BDSrvSaniInfoCache() {
	}

	private List<MedSrvSaniDO> get(String[] szId_srv) throws BizException {	
				MedSrvSaniDO[] medSrvSaniArr = ServiceFinder.find(IMedSrvSaniDORService.class).findByAttrValStrings(MedSrvSaniDO.ID_SRV, szId_srv);
		if(medSrvSaniArr!= null && medSrvSaniArr.length >=0){
			return Arrays.asList(medSrvSaniArr);
		}
		
		return null;
	}

	/**
	 * 根据id_srv获取卫材属性对象
	 * @param ctx
	 * @param Id_srv
	 * @return
	 * @throws BizException
	 */
	public static MedSrvSaniDO GetBdSrvSaniInfo(CiEnContextDTO ctx, String Id_srv) throws BizException {
		MedSrvSaniDO medSrvSaniInfo = ContextCache.Get(BDSrvSaniInfoCache.class.getSimpleName(),null != ctx ? ctx.getId_grp() : DefaultContext_ID,
				null != ctx ? ctx.getId_org() : DefaultContext_ID,
				null != ctx ? String.format("%s||%s", BDSrvSaniInfoCache_Key, ctx.getCode_entp()) : BDSrvSaniInfoCache_Key,
				Id_srv);
		if (null == medSrvSaniInfo) {
			List<MedSrvSaniDO> infoList = (List<MedSrvSaniDO>) ins.get(new String[] { Id_srv });
			if (null != infoList && infoList.size() > 0) {
				medSrvSaniInfo = infoList.get(0);
				ContextCache.Put(BDSrvSaniInfoCache.class.getSimpleName(),null != ctx ? ctx.getId_grp() : DefaultContext_ID,
						null != ctx ? ctx.getId_org() : DefaultContext_ID, null != ctx
								? String.format("%s||%s", BDSrvSaniInfoCache_Key, ctx.getCode_entp()) : BDSrvSaniInfoCache_Key,
						Id_srv, medSrvSaniInfo);
			}
		}

		return medSrvSaniInfo;
	}

	/**
	 * 根据id_srv集合获取卫材属性对象集合
	 * @param ctx
	 * @param szId_srv
	 * @return
	 * @throws BizException
	 */
	public static MedSrvSaniDO[] GetBdSrvSaniInfos(CiEnContextDTO ctx, String[] szId_srv) throws BizException {
		List<MedSrvSaniDO> infoList = new ArrayList<MedSrvSaniDO>();
		for (String id : szId_srv) {
			MedSrvSaniDO info = GetBdSrvSaniInfo(ctx, id);
			if (null != info) {
				infoList.add(info);
			}
		}

		return infoList.size() != 0 ? infoList.toArray(new MedSrvSaniDO[infoList.size()]) : null;
	}

	public static void Clear() {
		ContextCache.Clear(BDSrvSaniInfoCache.class.getSimpleName()); // 最后一个参数给空，则清空所有的BDSrvSaniInfoCache_Key 下的缓存
	}
}
