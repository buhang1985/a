package iih.ci.sdk.cache;

import iih.bd.base.cache.ContextCache;
import iih.bd.srv.medsrv.d.MedSrvOpDO;
import iih.bd.srv.medsrv.i.IMedSrvOpDORService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.sdk.utils.ObjectUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医疗服务手术属性缓存
 * @author Young
 *
 */
public class BDSrvOprInfoCache {

	public static String BDSrvOprInfoCache_Key = "BDSrvOprInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";
	
	private static BDSrvOprInfoCache ins = new BDSrvOprInfoCache();

	private BDSrvOprInfoCache() {
	}
	
	private List<MedSrvOpDO> get(String[] szId_srv) throws BizException {
		MedSrvOpDO[] medSrvOprArr = ServiceFinder.find(IMedSrvOpDORService.class)
				.findByAttrValStrings(MedSrvOpDO.ID_SRV, szId_srv);
		if (!ObjectUtils.isEmpty(medSrvOprArr)) {
			return Arrays.asList(medSrvOprArr);
		}
		return null;
	}
	
	/**
	 * 根据id_srv获取手术属性对象
	 * @param ctx
	 * @param Id_srv
	 * @return
	 * @throws BizException
	 */
	public static MedSrvOpDO GetBdSrvOprInfo(CiEnContextDTO ctx, String Id_srv) throws BizException {
		MedSrvOpDO medSrvOprInfo = ContextCache.Get(BDSrvOprInfoCache.class.getSimpleName(), 
				null != ctx ? ctx.getId_grp() : DefaultContext_ID,
				null != ctx ? ctx.getId_org() : DefaultContext_ID,
				null != ctx ? String.format("%s||%s", BDSrvOprInfoCache_Key, ctx.getCode_entp()) : BDSrvOprInfoCache_Key,
				Id_srv);
		if (null == medSrvOprInfo) {
			List<MedSrvOpDO> infoList = (List<MedSrvOpDO>) ins.get(new String[] { Id_srv });
			if (!ObjectUtils.isEmpty(infoList)) {
				medSrvOprInfo = infoList.get(0);
				ContextCache.Put(BDSrvOprInfoCache.class.getSimpleName(), 
						null != ctx ? ctx.getId_grp() : DefaultContext_ID,
						null != ctx ? ctx.getId_org() : DefaultContext_ID, 
						null != ctx ? String.format("%s||%s", BDSrvOprInfoCache_Key, ctx.getCode_entp()) : BDSrvOprInfoCache_Key,
						Id_srv, medSrvOprInfo);
			}
		}
		return medSrvOprInfo;
	}

	/**
	 * 根据id_srv集合获取手术属性对象集合
	 * @param ctx
	 * @param szId_srv
	 * @return
	 * @throws BizException
	 */
	public static MedSrvOpDO[] GetBdSrvOprInfos(CiEnContextDTO ctx, String[] szId_srv) throws BizException {
		List<MedSrvOpDO> infoList = new ArrayList<MedSrvOpDO>();
		for (String id_srv : szId_srv) {
			MedSrvOpDO info = GetBdSrvOprInfo(ctx, id_srv);
			if (null != info) {
				infoList.add(info);
			}
		}

		return infoList.size() > 0 ? infoList.toArray(new MedSrvOpDO[0]) : null;
	}

	public static void Clear() {
		ContextCache.Clear(BDSrvOprInfoCache.class.getSimpleName());
	}
}
