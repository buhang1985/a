package iih.ci.sdk.cache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.bd.base.cache.ContextCache;
import iih.bd.srv.medsrv.d.MedSrvLisDO;
import iih.bd.srv.medsrv.d.MedSrvRisDO;
import iih.bd.srv.medsrv.i.IMedSrvRisDORService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 检查属性缓存
 * @author wangqingzhu
 *
 */
public class BDSrvRisInfoCache {
	public static String BdSrvRisInfoCache_Key = "BdSrvRisInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";
	private static BDSrvRisInfoCache ins = new BDSrvRisInfoCache();

	private BDSrvRisInfoCache() {
	}

	private List<MedSrvRisDO> get(String[] szId_srv) throws BizException {	
		
		MedSrvRisDO[] medSrvRisArr = ServiceFinder.find(IMedSrvRisDORService.class).findByAttrValStrings(MedSrvLisDO.ID_SRV, szId_srv);
		if(medSrvRisArr!= null && medSrvRisArr.length >0){
			return Arrays.asList(medSrvRisArr);
		}
		
		return null;
	}

	/**
	 * 根据id_srv获取检验属性对象
	 * @param ctx
	 * @param Id_srv
	 * @return
	 * @throws BizException
	 */
	public static MedSrvRisDO GetBdSrvRisInfo(CiEnContextDTO ctx, String Id_srv) throws BizException {
		MedSrvRisDO medSrvRisInfo = ContextCache.Get(BDSrvLisInfoCache.class.getSimpleName(),null != ctx ? ctx.getId_grp() : DefaultContext_ID,
				null != ctx ? ctx.getId_org() : DefaultContext_ID,
				null != ctx ? String.format("%s||%s", BdSrvRisInfoCache_Key, ctx.getCode_entp()) : BdSrvRisInfoCache_Key,
				Id_srv);
		if (null == medSrvRisInfo) {
			List<MedSrvRisDO> infoList = (List<MedSrvRisDO>) ins.get(new String[] { Id_srv });
			if (null != infoList && infoList.size() > 0) {
				medSrvRisInfo = infoList.get(0);
				ContextCache.Put(BDSrvLisInfoCache.class.getSimpleName(),null != ctx ? ctx.getId_grp() : DefaultContext_ID,
						null != ctx ? ctx.getId_org() : DefaultContext_ID, null != ctx
								? String.format("%s||%s", BdSrvRisInfoCache_Key, ctx.getCode_entp()) : BdSrvRisInfoCache_Key,
						Id_srv, medSrvRisInfo);
			}
		}

		return medSrvRisInfo;
	}

	/**
	 * 根据id_srv集合获取检验属性对象集合
	 * @param ctx
	 * @param szId_srv
	 * @return
	 * @throws BizException
	 */
	public static MedSrvRisDO[] GetBdSrvRisInfos(CiEnContextDTO ctx, String[] szId_srv) throws BizException {
		List<MedSrvRisDO> infoList = new ArrayList<MedSrvRisDO>();
		for (String id : szId_srv) {
			MedSrvRisDO info = GetBdSrvRisInfo(ctx, id);
			if (null != info) {
				infoList.add(info);
			}
		}

		return infoList.size() != 0 ? infoList.toArray(new MedSrvRisDO[infoList.size()]) : null;
	}

	public static void Clear() {
		ContextCache.Clear(BDSrvRisInfoCache.class.getSimpleName()); // 最后一个参数给空，则清空所有的BDSrvLisInfoCache_Key 下的缓存
	}
}
