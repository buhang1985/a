package iih.ci.ord.s.ems.cache;

import java.util.List;

import iih.bd.base.cache.ContextCache;
import iih.bd.srv.medusage.d.MedUsageDesDO;
import iih.bd.srv.medusage.d.desc.MedUsageDesDODesc;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 用法要求基础数据缓存
 * 
 * @author wangqingzhu
 *
 */
public class BDRouteDesInfoCache {
	public static String BDRouteDesInfoCache_Key = "BDRouteDesInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";

	private static BDRouteDesInfoCache ins = new BDRouteDesInfoCache();

	private BDRouteDesInfoCache() {
	}

	private List<MedUsageDesDO> get(String[] szIDs) throws DAException {
		String conditions = "";
		SqlParam param = new SqlParam();
		for (String id : szIDs) {
			conditions += ",?";
			param.addParam(id);
		}
		String sql = String.format(
				"Select a0.Id_routedes, a0.name  from bd_route_des a0 where a0.Id_routedes in (%s) and "
						+ EnvContextUtil.processEnvContext("", new MedUsageDesDO(), MedUsageDesDODesc.TABLE_ALIAS_NAME),
				conditions.substring(1));
		List<MedUsageDesDO> rst = (List<MedUsageDesDO>) new DAFacade().execQuery(sql, param,
				new BeanListHandler(MedUsageDesDO.class));
		return null != rst ? rst : null;
	}

	public static String GetNameOfBdRouteDesInfo(String id_routedes) throws BizException {
		List<MedUsageDesDO> routeInfoList = ContextCache.Get(BDRouteDesInfoCache.class.getSimpleName(),
				DefaultContext_ID, DefaultContext_ID, BDRouteDesInfoCache_Key, id_routedes);
		if (null == routeInfoList) {
			routeInfoList = ins.get(new String[] { id_routedes });
			ContextCache.Put(BDRouteDesInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID,
					BDRouteDesInfoCache_Key, id_routedes, routeInfoList);
		}
		return routeInfoList == null ? null : routeInfoList.get(0).getName();
	}

	public static void Clear() {
		ContextCache.Clear(BDRouteDesInfoCache.class.getSimpleName());
	}
}
