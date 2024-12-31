package iih.ci.ord.s.ems.cache;

import java.util.List;

import iih.bd.base.cache.ContextCache;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.medusage.d.MedUsageDO;
import iih.bd.srv.medusage.d.desc.MedUsageDODesc;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;

public class BDRouteInfoCache {
	public static String BDRouteInfoCache_Key = "BDRouteInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";

	private static BDRouteInfoCache ins = new BDRouteInfoCache();

	private BDRouteInfoCache() {
	}

	private MedUsageDO[] gets(String id_dosage) throws BizException {
		String sql = "select distinct a0.Id_route,a0.Name from bd_route a0 "
				+ "	left join bd_route_dosage_ref b on a0.id_route = b.id_route "
				+ " where b.id_dosage = ? and b.ds=0 and a0.ds=0 and "
				+ EnvContextUtil.processEnvContext("", new MedUsageDO(), MedUsageDODesc.TABLE_ALIAS_NAME);
		SqlParam param = new SqlParam();
		param.addParam(id_dosage);
		List<MedUsageDO> rst = (List<MedUsageDO>) new DAFacade().execQuery(sql, param,
				new BeanListHandler(MedUsageDO.class));
		return null != rst ? rst.toArray(new MedUsageDO[rst.size()]) : null;
	}

	private MedUsageDO get(String id_route) throws BizException {
		String sql = String.format("select distinct a.Id_route,a.Name from bd_route a where a.ds=0 and id_route = ?");
		SqlParam param = new SqlParam();
		param.addParam(id_route);
		List<MedUsageDO> rst = (List<MedUsageDO>) new DAFacade().execQuery(sql, param,
				new BeanListHandler(MedUsageDO.class));
		return null != rst ? rst.get(0) : null;
	}

	public static MedUsageDO[] GetBdRouteInfos(CiEnContextDTO ctx) throws BizException {
		MedUsageDO[] szMedUsageDO = ContextCache.Get(BDRouteInfoCache.class.getSimpleName(), ctx.getId_grp(),
				ctx.getId_org(), BDRouteInfoCache_Key, DefaultContext_ID);
		if (null == szMedUsageDO || szMedUsageDO.length == 0) {
			szMedUsageDO = ins.gets(IBdSrvDictCodeConst.ID_DOSAGE_HERB);
			ContextCache.Put(BDRouteInfoCache.class.getSimpleName(), ctx.getId_grp(), ctx.getId_org(),
					BDRouteInfoCache_Key, DefaultContext_ID, szMedUsageDO);
		}
		return szMedUsageDO;
	}

	public static String GetNameOfBdRouteInfo(String id_route) throws BizException {
		MedUsageDO routeInfo = ContextCache.Get(BDRouteInfoCache.class.getSimpleName(), DefaultContext_ID,
				DefaultContext_ID, BDRouteInfoCache_Key, id_route);
		if (null == routeInfo) {
			routeInfo = ins.get(id_route);
			ContextCache.Put(BDRouteInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID,
					BDRouteInfoCache_Key, id_route, routeInfo);
		}
		return routeInfo == null ? null : routeInfo.getName();
	}

	public static void Clear() {
		ContextCache.Clear(BDRouteInfoCache.class.getSimpleName());
	}
}
