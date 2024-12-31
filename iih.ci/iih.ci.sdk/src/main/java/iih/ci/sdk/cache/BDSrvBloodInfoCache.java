package iih.ci.sdk.cache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.bd.base.cache.ContextCache;
import iih.bd.srv.medsrv.d.MedSrvBloodDO;
import iih.bd.srv.medsrv.i.IMedSrvBloodDORService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医疗服务血液属性缓存
 * @author HUMS
 *
 */
public class BDSrvBloodInfoCache {
	
	public static String BDSrvBloodInfoCache_Key = "BDSrvBloodInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";
	private static BDSrvBloodInfoCache ins = new BDSrvBloodInfoCache();

	private BDSrvBloodInfoCache() {
	}

	private List<MedSrvBloodDO> get(String[] szId_srv) throws BizException {	
				MedSrvBloodDO[] medSrvBloodArr = ServiceFinder.find(IMedSrvBloodDORService.class).findByAttrValStrings(MedSrvBloodDO.ID_SRV, szId_srv);
		if(medSrvBloodArr!= null && medSrvBloodArr.length >=0){
			return Arrays.asList(medSrvBloodArr);
		}
		
		return null;
	}

	/**
	 * 根据id_srv获取血液属性对象
	 * @param ctx
	 * @param Id_srv
	 * @return
	 * @throws BizException
	 */
	public static MedSrvBloodDO GetBdSrvBloodInfo(CiEnContextDTO ctx, String Id_srv) throws BizException {
		MedSrvBloodDO medSrvBloodInfo = ContextCache.Get(BDSrvBloodInfoCache.class.getSimpleName(),null != ctx ? ctx.getId_grp() : DefaultContext_ID,
				null != ctx ? ctx.getId_org() : DefaultContext_ID,
				null != ctx ? String.format("%s||%s", BDSrvBloodInfoCache_Key, ctx.getCode_entp()) : BDSrvBloodInfoCache_Key,
				Id_srv);
		if (null == medSrvBloodInfo) {
			List<MedSrvBloodDO> infoList = (List<MedSrvBloodDO>) ins.get(new String[] { Id_srv });
			if (null != infoList && infoList.size() > 0) {
				medSrvBloodInfo = infoList.get(0);
				ContextCache.Put(BDSrvBloodInfoCache.class.getSimpleName(),null != ctx ? ctx.getId_grp() : DefaultContext_ID,
						null != ctx ? ctx.getId_org() : DefaultContext_ID, null != ctx
								? String.format("%s||%s", BDSrvBloodInfoCache_Key, ctx.getCode_entp()) : BDSrvBloodInfoCache_Key,
						Id_srv, medSrvBloodInfo);
			}
		}

		return medSrvBloodInfo;
	}

	/**
	 * 根据id_srv集合获取血液属性对象集合
	 * @param ctx
	 * @param szId_srv
	 * @return
	 * @throws BizException
	 */
	public static MedSrvBloodDO[] GetBdSrvLisInfos(CiEnContextDTO ctx, String[] szId_srv) throws BizException {
		List<MedSrvBloodDO> infoList = new ArrayList<MedSrvBloodDO>();
		for (String id : szId_srv) {
			MedSrvBloodDO info = GetBdSrvBloodInfo(ctx, id);
			if (null != info) {
				infoList.add(info);
			}
		}

		return infoList.size() != 0 ? infoList.toArray(new MedSrvBloodDO[infoList.size()]) : null;
	}

	public static void Clear() {
		ContextCache.Clear(BDSrvBloodInfoCache.class.getSimpleName()); // 最后一个参数给空，则清空所有的BDSrvBloodInfoCache_Key 下的缓存
	}
}
