package iih.ci.ord.s.ems.cache;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.cache.ContextCache;
import iih.bd.srv.ortpl.d.OrTmplDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 医嘱模板定义态缓存
 * 
 * @author wangqingzhu
 *
 */
public class BDTemlInfoCache {
	public static String BDTemlInfoCache_Key = "BDTemlInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";
	private static BDTemlInfoCache ins = new BDTemlInfoCache();

	private BDTemlInfoCache() {
	}

	private List<OrTmplDO> get(String[] szId_ortmpl) throws BizException {

		List<OrTmplDO> szOrTmplDO = (List<OrTmplDO>) new DAFacade().findByPKs(OrTmplDO.class, szId_ortmpl);
		if (null != szOrTmplDO && szOrTmplDO.size() == 1) {
			return szOrTmplDO;

		}
		return null;
	}

	/**
	 * 获取单一模板对象信息
	 * 
	 * @param ctx
	 * @param Id_ortmpl
	 * @return
	 * @throws BizException
	 */
	public static OrTmplDO GetTemlInfo(CiEnContextDTO ctx, String Id_ortmpl) throws BizException {
		OrTmplDO mInfo = ContextCache.Get(BDTemlInfoCache.class.getSimpleName(),
				null != ctx ? ctx.getId_grp() : DefaultContext_ID, null != ctx ? ctx.getId_org() : DefaultContext_ID,
				null != ctx ? String.format("%s||%s", BDTemlInfoCache_Key, ctx.getCode_entp()) : BDTemlInfoCache_Key,
				Id_ortmpl);
		if (null == mInfo) {
			List<OrTmplDO> infoList = (List<OrTmplDO>) ins.get(new String[] { Id_ortmpl });
			if (null != infoList && infoList.size() > 0) {
				mInfo = infoList.get(0);
				ContextCache.Put(BDTemlInfoCache.class.getSimpleName(),
						null != ctx ? ctx.getId_grp() : DefaultContext_ID,
						null != ctx ? ctx.getId_org() : DefaultContext_ID,
						null != ctx ? String.format("%s||%s", BDTemlInfoCache_Key, ctx.getCode_entp())
								: BDTemlInfoCache_Key,
						Id_ortmpl, mInfo);
			}
		}

		return mInfo;
	}

	/**
	 * 批量获取医嘱模板信息
	 * 
	 * @param ctx
	 * @param szId_ortmpl
	 * @return
	 * @throws BizException
	 */
	public static OrTmplDO[] GetTemlInfo(CiEnContextDTO ctx, String[] szId_ortmpl) throws BizException {
		List<OrTmplDO> szOrTmplDO = new ArrayList<OrTmplDO>();
		for (String id : szId_ortmpl) {
			OrTmplDO tmpl = GetTemlInfo(ctx, id);
			if (null != tmpl) {
				szOrTmplDO.add(tmpl);
			}
		}
		return szOrTmplDO.size() != 0 ? szOrTmplDO.toArray(new OrTmplDO[szOrTmplDO.size()]) : null;
	}

	/**
	 * 清空缓存
	 * 
	 * @param ctx
	 */
	public static void Clear(CiEnContextDTO ctx) {
		ContextCache.Clear(BDTemlInfoCache.class.getSimpleName()); // 最后一个参数给空，则清空所有的BDMeterialInfoCache_Key
																	// 下的缓存
	}
}
