package iih.ci.ord.s.ems.cache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.bd.base.cache.ContextCache;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.bd.srv.ortpl.i.IOrTplNItmDORService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 临床医嘱模板明细信息缓存
 * 
 * @author wangqingzhu
 *
 */
public class CiOrdTmplItemInfoCache {
	public static String CiOrdTmplItemInfoCache_Key = "CiOrdTmplItemInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";
	private static CiOrdTmplItemInfoCache ins = new CiOrdTmplItemInfoCache();

	private CiOrdTmplItemInfoCache() {
	}

	private List<OrTplNItmDO> get(String[] szId_ortmplitm) throws BizException {

		OrTplNItmDO[] szOrTplNItmDO = ServiceFinder.find(IOrTplNItmDORService.class).findByIds(szId_ortmplitm,
				FBoolean.FALSE);// IOrTplNItmDORService (List<OrTplNItmDO>) new
								// DAFacade().findByPKs(OrTplNItmDO.class,

		if (null != szOrTplNItmDO && szOrTplNItmDO.length == 1) {
			return Arrays.asList(szOrTplNItmDO);

		}
		return null;
	}

	public static OrTplNItmDO GetOrTplNItmDOInfo(CiEnContextDTO ctx, String Id_ortmplitm) throws BizException {
		OrTplNItmDO mInfo = ContextCache.Get(CiOrdTmplItemInfoCache.class.getSimpleName(),
				null != ctx ? ctx.getId_grp() : DefaultContext_ID, null != ctx ? ctx.getId_org() : DefaultContext_ID,
				null != ctx ? String.format("%s||%s", CiOrdTmplItemInfoCache_Key, ctx.getCode_entp())
						: CiOrdTmplItemInfoCache_Key,
				Id_ortmplitm);
		if (null == mInfo) {
			List<OrTplNItmDO> infoList = (List<OrTplNItmDO>) ins.get(new String[] { Id_ortmplitm });
			if (null != infoList && infoList.size() > 0) {
				mInfo = infoList.get(0);
				ContextCache.Put(CiOrdTmplItemInfoCache.class.getSimpleName(),
						null != ctx ? ctx.getId_grp() : DefaultContext_ID,
						null != ctx ? ctx.getId_org() : DefaultContext_ID,
						null != ctx ? String.format("%s||%s", CiOrdTmplItemInfoCache_Key, ctx.getCode_entp())
								: CiOrdTmplItemInfoCache_Key,
						Id_ortmplitm, mInfo);
			}
		}

		return mInfo;
	}

	public static OrTplNItmDO[] GetOrTplNItmDOInfos(CiEnContextDTO ctx, String[] szId_ortmplitm) throws BizException {
		List<OrTplNItmDO> infoList = new ArrayList<OrTplNItmDO>();
		for (String id : szId_ortmplitm) {
			OrTplNItmDO info = GetOrTplNItmDOInfo(ctx, id);
			if (null != info) {
				infoList.add(info);
			}
		}

		return infoList.size() != 0 ? infoList.toArray(new OrTplNItmDO[infoList.size()]) : null;
	}

	public static void Clear() {
		ContextCache.Clear(CiOrdTmplItemInfoCache.class.getSimpleName()); // 最后一个参数给空，则清空所有的BDMeterialInfoCache_Key
																			// 下的缓存
	}
}
