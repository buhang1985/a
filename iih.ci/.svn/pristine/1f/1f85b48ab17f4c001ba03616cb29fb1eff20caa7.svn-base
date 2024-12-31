package iih.ci.sdk.cache;

import java.util.List;

import iih.bd.base.cache.ContextCache;
import iih.bd.srv.cherbboilmd.d.CHerbBoilDesDO;
import iih.bd.srv.cherbboilmd.d.desc.CHerbBoilDesDODesc;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 煎法要求基础数据缓存集合
 * @author wangqingzhu
 *
 */
public class BDBoilDesInfoCache {
	public static String BDBoilDesInfoCache_Key = "BDBoilDesInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";

	private static BDBoilDesInfoCache ins = new BDBoilDesInfoCache();

	private BDBoilDesInfoCache() {
	}
	
	private List<CHerbBoilDesDO> get(String[] szIDs) throws DAException{
		String conditions = "";
		SqlParam param = new SqlParam();
		for(String id : szIDs){
			conditions +=",?";
			param.addParam(id);
		}
		String sql = String.format("Select Id_boildes,name from bd_boil_des a1 where Id_boildes in(%s) and " 
		+ EnvContextUtil.processEnvContext("", new CHerbBoilDesDO(), CHerbBoilDesDODesc.TABLE_ALIAS_NAME) , conditions.substring(1));
		List<CHerbBoilDesDO> rst = (List<CHerbBoilDesDO>) new DAFacade().execQuery(sql, param,new BeanListHandler(CHerbBoilDesDO.class));
		return null != rst ? rst : null;
	}
	
	public static String GetNameOfBdBoilDesInfo(String id_boildes) throws BizException {
		List<CHerbBoilDesDO> boildesList = ContextCache.Get(BDBoilDesInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID, BDBoilDesInfoCache_Key, id_boildes);
		if (null == boildesList) {
			boildesList = ins.get(new String[]{id_boildes});
			ContextCache.Put(BDBoilDesInfoCache.class.getSimpleName(),DefaultContext_ID, DefaultContext_ID, BDBoilDesInfoCache_Key, id_boildes, boildesList);
		}
		return boildesList == null ? null : boildesList.get(0).getName();
	}
	
	public static void Clear(){
		ContextCache.Clear(BDBoilDesInfoCache.class.getSimpleName());
	}
}
