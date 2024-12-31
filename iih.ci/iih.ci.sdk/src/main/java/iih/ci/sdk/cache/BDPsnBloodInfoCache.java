package iih.ci.sdk.cache;

import java.util.Arrays;
import java.util.List;

import iih.bd.base.cache.ContextCache;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.pi.reg.pat.d.PiPatBiolDO;
import iih.pi.reg.pat.i.IPiPatBiolDORService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 患者血型缓存
 * @author LiuXiaoying
 *
 */
public class BDPsnBloodInfoCache {
	
	public static String BDPsnBloodInfoCache_Key = "BDPsnBloodInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";
	private static BDPsnBloodInfoCache ins = new BDPsnBloodInfoCache();

	private BDPsnBloodInfoCache() {
	}

	private List<PiPatBiolDO> get(String[] szId_pat) throws BizException {	
				PiPatBiolDO[] mmDispensCtrArr = ServiceFinder.find(IPiPatBiolDORService.class).findByAttrValStrings(PiPatBiolDO.ID_PAT, szId_pat);
		if(mmDispensCtrArr!= null && mmDispensCtrArr.length >=0){
			return Arrays.asList(mmDispensCtrArr);
		}
		
		return null;
	}

	/**
	 * 根据id_pat获取血型属性
	 * @param ctx
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	public static PiPatBiolDO GetPsnBloodInfo(CiEnContextDTO ctx) throws BizException {
		PiPatBiolDO psnBloodInfo = ContextCache.Get(BDPsnBloodInfoCache.class.getSimpleName(),null != ctx ? ctx.getId_grp() : DefaultContext_ID,
				null != ctx ? ctx.getId_org() : DefaultContext_ID,
				null != ctx ? String.format("%s||%s", BDPsnBloodInfoCache_Key, ctx.getCode_entp()) : BDPsnBloodInfoCache_Key,
						ctx.getId_pat());
		if (null == psnBloodInfo) {
			List<PiPatBiolDO> infoList = (List<PiPatBiolDO>) ins.get(new String[] { ctx.getId_pat()});
			if (null != infoList && infoList.size() > 0) {
				psnBloodInfo = infoList.get(0);
				ContextCache.Put(BDPsnBloodInfoCache.class.getSimpleName(),null != ctx ? ctx.getId_grp() : DefaultContext_ID,
						null != ctx ? ctx.getId_org() : DefaultContext_ID, null != ctx
								? String.format("%s||%s", BDPsnBloodInfoCache_Key, ctx.getCode_entp()) : BDPsnBloodInfoCache_Key,
										ctx.getId_pat(), psnBloodInfo);
			}
		}

		return psnBloodInfo;
	}

	
	public static void Clear() {
		ContextCache.Clear(BDPsnBloodInfoCache.class.getSimpleName()); // 最后一个参数给空，则清空所有的BDPsnBloodInfoCache_Key 下的缓存
	}
}
