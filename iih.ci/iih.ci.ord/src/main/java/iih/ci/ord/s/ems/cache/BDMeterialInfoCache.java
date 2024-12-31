package iih.ci.ord.s.ems.cache;

import java.util.Arrays;
import java.util.List;

import iih.bd.base.cache.ContextCache;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.ci.core.utils.ObjectUtils;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 物品信息缓存
 * 
 * @author wangqingzhu
 *
 */
public class BDMeterialInfoCache {
	public static String BDMeterialInfoCache_Key = "BDMeterialInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";
	private static BDMeterialInfoCache ins = new BDMeterialInfoCache();

	private BDMeterialInfoCache() {
	}

	private List<MeterialDO> get(String[] szId_mm) throws BizException {

		MeterialDO[] szMeterialDO = ServiceFinder.find(IMeterialMDORService.class).findByIds(szId_mm, FBoolean.TRUE);
		if (null != szMeterialDO && szMeterialDO.length == 1) {
			return Arrays.asList(szMeterialDO);

		}
		return null;
	}

	public static MeterialDO GetMeterialInfo(CiEnContextDTO ctx, String id_mm) throws BizException {
		MeterialDO mInfo = ContextCache.Get(BDMeterialInfoCache.class.getSimpleName(),null != ctx ? ctx.getId_grp() : DefaultContext_ID,
				null != ctx ? ctx.getId_org() : DefaultContext_ID,
				null != ctx ? String.format("%s||%s", BDMeterialInfoCache_Key, ctx.getCode_entp())
						: BDMeterialInfoCache_Key,
				id_mm);
		if (null == mInfo) {
			List<MeterialDO> infoList = (List<MeterialDO>) ins.get(new String[] { id_mm });
			if (infoList != null && infoList.size() > 0) {
				mInfo = infoList.get(0);
				ContextCache.Put(BDMeterialInfoCache.class.getSimpleName(),null != ctx ? ctx.getId_grp() : DefaultContext_ID,
						null != ctx ? ctx.getId_org() : DefaultContext_ID,
						null != ctx ? String.format("%s||%s", BDMeterialInfoCache_Key, ctx.getCode_entp())
								: BDMeterialInfoCache_Key,
						id_mm, mInfo);
			}
		}

		return mInfo;
	}
	
	/**
	 * 批量获取物品
	 * @param ctx
	 * @param szId_mm
	 * @return
	 * @throws BizException
	 */
	public static MeterialDO[] GetMeterialInfos(CiEnContextDTO ctx, String[] szId_mm) throws BizException {
		List<MeterialDO> mInfoList = ContextCache.Get(BDMeterialInfoCache.class.getSimpleName(),null != ctx ? ctx.getId_grp() : DefaultContext_ID,
				null != ctx ? ctx.getId_org() : DefaultContext_ID,
						null != ctx ? String.format("L||%s||%s", BDMeterialInfoCache_Key, ctx.getCode_entp())
						: "L"+BDMeterialInfoCache_Key,
				ObjectUtils.asString(szId_mm));
		if (mInfoList == null || mInfoList.size()<=0) {
			mInfoList = (List<MeterialDO>) ins.get(szId_mm);
			if (mInfoList != null && mInfoList.size()>0) {
				
				ContextCache.Put(BDMeterialInfoCache.class.getSimpleName(),null != ctx ? ctx.getId_grp() : DefaultContext_ID,
						null != ctx ? ctx.getId_org() : DefaultContext_ID,
								null != ctx ? String.format("L||%s||%s", BDMeterialInfoCache_Key, ctx.getCode_entp())
								: "L"+BDMeterialInfoCache_Key,
								ObjectUtils.asString(szId_mm), mInfoList);
			}
		}

		return mInfoList == null?null:mInfoList.toArray(new MeterialDO[] {});
	}

	/**
	 * 获取指定物品ID的名称
	 * 
	 * @param ctx
	 * @param id_mm
	 * @return
	 * @throws BizException
	 */
	public static String GetNameOfMeterialInfo(CiEnContextDTO ctx, String id_mm) throws BizException {
		MeterialDO mInfo = GetMeterialInfo(ctx, id_mm);

		return null != mInfo ? mInfo.getName() : null;
	}

	public static void Clear() {
		ContextCache.Clear(BDMeterialInfoCache.class.getSimpleName()); // 最后一个参数给空，则清空所有的BDMeterialInfoCache_Key 下的缓存
	}
}
