package iih.ci.sdk.cache;

import java.util.List;

import iih.bd.base.cache.ContextCache;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.cherbboilmd.d.CHerbBoilMdDO;
import iih.bd.srv.cherbboilmd.d.desc.CHerbBoilMdDODesc;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 基础数据煎法缓存工具
 * 
 * @author wangqingzhu
 *
 */
public class BDBoilInfoCache {
	public static String BDBoilInfoCache_Key = "BDBoilInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";

	private static BDBoilInfoCache ins = new BDBoilInfoCache();

	private BDBoilInfoCache() {
	}

	private CHerbBoilMdDO[] gets(String id_dosage) throws BizException {
		String sql = "select a0.Id_boil,a0.Name from bd_boil a0 where ds<1 and "
				+ EnvContextUtil.processEnvContext("", new CHerbBoilMdDO(), CHerbBoilMdDODesc.TABLE_ALIAS_NAME);
		;
		List<CHerbBoilMdDO> rst = (List<CHerbBoilMdDO>) new DAFacade().execQuery(sql,
				new BeanListHandler(CHerbBoilMdDO.class));
		return null != rst ? rst.toArray(new CHerbBoilMdDO[rst.size()]) : null;
	}

	private CHerbBoilMdDO get(String id_boil) throws BizException {
		String sql = String.format("select a0.Id_boil,a0.Name from bd_boil a0 where a0.Id_boil = '%s'", id_boil);

		List<CHerbBoilMdDO> rst = (List<CHerbBoilMdDO>) new DAFacade().execQuery(sql,
				new BeanListHandler(CHerbBoilMdDO.class));
		return null != rst ? rst.get(0) : null;
	}

	public static CHerbBoilMdDO[] GetBdBoilInfos(CiEnContextDTO ctx) throws BizException {
		CHerbBoilMdDO[] szCHerbBoilMdDO = ContextCache.Get(BDBoilInfoCache.class.getSimpleName(),ctx.getId_grp(), ctx.getId_org(), BDBoilInfoCache_Key,
				DefaultContext_ID);
		if (null == szCHerbBoilMdDO || szCHerbBoilMdDO.length == 0) {
			szCHerbBoilMdDO = ins.gets(IBdSrvDictCodeConst.ID_DOSAGE_HERB);
			ContextCache.Put(BDBoilInfoCache.class.getSimpleName(),ctx.getId_grp(), ctx.getId_org(), BDBoilInfoCache_Key, DefaultContext_ID, szCHerbBoilMdDO);
		}
		return szCHerbBoilMdDO;
	}

	public static String GetNameOfBdBoilInfo(String id_boil) throws BizException {
		CHerbBoilMdDO boilInfo = ContextCache.Get(BDBoilInfoCache.class.getSimpleName(),DefaultContext_ID, DefaultContext_ID, BDBoilInfoCache_Key, id_boil);
		if (null == boilInfo) {
			boilInfo = ins.get(id_boil);
			ContextCache.Put(BDBoilInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID, BDBoilInfoCache_Key, id_boil, boilInfo);
		}
		return boilInfo == null ? null : boilInfo.getName();
	}
	
	public static void Clear(){
		ContextCache.Clear(BDBoilInfoCache.class.getSimpleName());
	}
}
