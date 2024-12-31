package iih.ci.ord.s.ems.cache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.bd.base.cache.ContextCache;
import iih.bd.srv.medsrv.d.MedSrvLisDO;
import iih.bd.srv.medsrv.i.IMedSrvLisDORService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医疗服务检验属性缓存
 * @author HUMS
 *
 */
public class BDSrvLisInfoCache {
	
	public static String BDSrvLisInfoCache_Key = "BDSrvLisInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";
	private static BDSrvLisInfoCache ins = new BDSrvLisInfoCache();

	private BDSrvLisInfoCache() {
	}

	private List<MedSrvLisDO> get(String[] szId_srv) throws BizException {	
		
		MedSrvLisDO[] medSrvLisArr = ServiceFinder.find(IMedSrvLisDORService.class).findByAttrValStrings(MedSrvLisDO.ID_SRV, szId_srv);
		if(medSrvLisArr!= null && medSrvLisArr.length >0){
			return Arrays.asList(medSrvLisArr);
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
	public static MedSrvLisDO GetBdSrvLisInfo(CiEnContextDTO ctx, String Id_srv) throws BizException {
		MedSrvLisDO medSrvLisInfo = ContextCache.Get(BDSrvLisInfoCache.class.getSimpleName(),null != ctx ? ctx.getId_grp() : DefaultContext_ID,
				null != ctx ? ctx.getId_org() : DefaultContext_ID,
				null != ctx ? String.format("%s||%s", BDSrvLisInfoCache_Key, ctx.getCode_entp()) : BDSrvLisInfoCache_Key,
				Id_srv);
		if (null == medSrvLisInfo) {
			List<MedSrvLisDO> infoList = (List<MedSrvLisDO>) ins.get(new String[] { Id_srv });
			if (null != infoList && infoList.size() > 0) {
				medSrvLisInfo = infoList.get(0);
				ContextCache.Put(BDSrvLisInfoCache.class.getSimpleName(),null != ctx ? ctx.getId_grp() : DefaultContext_ID,
						null != ctx ? ctx.getId_org() : DefaultContext_ID, null != ctx
								? String.format("%s||%s", BDSrvLisInfoCache_Key, ctx.getCode_entp()) : BDSrvLisInfoCache_Key,
						Id_srv, medSrvLisInfo);
			}
		}

		return medSrvLisInfo;
	}

	/**
	 * 根据id_srv集合获取检验属性对象集合
	 * @param ctx
	 * @param szId_srv
	 * @return
	 * @throws BizException
	 */
	public static MedSrvLisDO[] GetBdSrvLisInfos(CiEnContextDTO ctx, String[] szId_srv) throws BizException {
		List<MedSrvLisDO> infoList = new ArrayList<MedSrvLisDO>();
		for (String id : szId_srv) {
			MedSrvLisDO info = GetBdSrvLisInfo(ctx, id);
			if (null != info) {
				infoList.add(info);
			}
		}

		return infoList.size() != 0 ? infoList.toArray(new MedSrvLisDO[infoList.size()]) : null;
	}

	public static void Clear() {
		ContextCache.Clear(BDSrvLisInfoCache.class.getSimpleName()); // 最后一个参数给空，则清空所有的BDSrvLisInfoCache_Key 下的缓存
	}
}
