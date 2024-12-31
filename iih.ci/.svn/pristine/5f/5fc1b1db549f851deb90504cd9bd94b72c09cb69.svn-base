package iih.ci.ord.s.ems.cache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.bd.base.cache.ContextCache;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 基础数据服务缓存
 * 
 * @author wangqingzhu
 *
 */
public class BDSrvInfoCache {
	public static String BDSrvInfoCache_Key = "BDSrvInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";
	private static BDSrvInfoCache ins = new BDSrvInfoCache();

	private BDSrvInfoCache() {
	}

	private List<MedSrvDO> get(String[] szId_srv) throws BizException {

		MedSrvDO[] szMedSrvDO = ServiceFinder.find(IMedsrvMDORService.class).findByBIds(szId_srv, FBoolean.TRUE);
		if (null != szMedSrvDO && szMedSrvDO.length == 1) {
			return Arrays.asList(szMedSrvDO);

		}
		return null;
	}

	public static MedSrvDO GetBdSrvInfo(CiEnContextDTO ctx, String Id_srv) throws BizException {
		MedSrvDO mInfo = ContextCache.Get(BDSrvInfoCache.class.getSimpleName(),null != ctx ? ctx.getId_grp() : DefaultContext_ID,
				null != ctx ? ctx.getId_org() : DefaultContext_ID,
				null != ctx ? String.format("%s||%s", BDSrvInfoCache_Key, ctx.getCode_entp()) : BDSrvInfoCache_Key,
				Id_srv);
		if (null == mInfo) {
			List<MedSrvDO> infoList = (List<MedSrvDO>) ins.get(new String[] { Id_srv });
			if (null != infoList && infoList.size() > 0) {
				mInfo = infoList.get(0);
				ContextCache.Put(BDSrvInfoCache.class.getSimpleName(),null != ctx ? ctx.getId_grp() : DefaultContext_ID,
						null != ctx ? ctx.getId_org() : DefaultContext_ID, null != ctx
								? String.format("%s||%s", BDSrvInfoCache_Key, ctx.getCode_entp()) : BDSrvInfoCache_Key,
						Id_srv, mInfo);
			}
		}

		return mInfo;
	}

	public static MedSrvDO[] GetBdSrvInfos(CiEnContextDTO ctx, String[] szId_srv) throws BizException {
		List<MedSrvDO> infoList = new ArrayList<MedSrvDO>();
		for (String id : szId_srv) {
			MedSrvDO info = GetBdSrvInfo(ctx, id);
			if (null != info) {
				infoList.add(info);
			}
		}

		return infoList.size() != 0 ? infoList.toArray(new MedSrvDO[infoList.size()]) : null;
	}
	
	/**
	 * 根据服务id 获取基础服务定义中的名称
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	public static String GetNameOfBdSrvInfo(String id_srv) throws BizException{
		MedSrvDO srvInfo = GetBdSrvInfo(null,id_srv);
		if(null != srvInfo){
			return srvInfo.getName();
		}
		return null;
	}

	public static void Clear(CiEnContextDTO ctx) {
		ContextCache.Clear(BDSrvInfoCache.class.getSimpleName()); // 最后一个参数给空，则清空所有的BDMeterialInfoCache_Key 下的缓存
	}
}
