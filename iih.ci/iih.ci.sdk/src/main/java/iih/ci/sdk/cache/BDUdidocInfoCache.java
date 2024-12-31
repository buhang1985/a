package iih.ci.sdk.cache;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.base.cache.ContextCache;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;

public class BDUdidocInfoCache {
	public static String BDUdidocInfoCache_Key = "BDUdidocInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";

	private static BDUdidocInfoCache ins = new BDUdidocInfoCache();

	private BDUdidocInfoCache() {
	}

	private List<UdidocDO> get(String[] szIDs) throws DAException {
		String conditions = "";
		SqlParam param = new SqlParam();
		for (String id : szIDs) {
			conditions += ",?";
			param.addParam(id);
		}
		String sql = String.format("Select id_udidoc,name from bd_udidoc where id_udidoc in(%s) ", conditions.substring(1));
		List<UdidocDO> rst = (List<UdidocDO>) new DAFacade().execQuery(sql, param, new BeanListHandler(UdidocDO.class));
		return null != rst ? rst : null;
	}

	public static String GetNameOfBDUdidocInfo(String id_udidoc) throws BizException {
		if (StringUtils.isEmpty(id_udidoc)) {
			return null;
		}
		List<UdidocDO> udidocList = ContextCache.Get(BDUdidocInfoCache.class.getSimpleName(), DefaultContext_ID,
				DefaultContext_ID, BDUdidocInfoCache_Key, id_udidoc);
		if (null == udidocList) {
			udidocList = ins.get(new String[] { id_udidoc });
			ContextCache.Put(BDUdidocInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID,
					BDUdidocInfoCache_Key, id_udidoc, udidocList);
		}
		return udidocList == null ? null : udidocList.get(0).getName();
	}
	
	private List<UdidocDO> get(String id_udidoclist, String code, boolean fg_active) throws DAException {
		SqlParam param = new SqlParam();
		param.addParam(id_udidoclist);
		if (StringUtils.isNotEmpty(code)) {
			param.addParam(code);
		}
		String sql = "Select * from bd_udidoc where id_udidoclist=?" 
		+ (StringUtils.isNotEmpty(code)?" and code=?" : "") + (fg_active ? " and activestate=2" : "");
		List<UdidocDO> rst = (List<UdidocDO>) new DAFacade().execQuery(sql, param, new BeanListHandler(UdidocDO.class));
		return null != rst ? rst : null;
	}
	
	public static UdidocDO[] GetBDUdidocInfo(String id_udidoclist, boolean fg_active) throws BizException {
		if (StringUtils.isEmpty(id_udidoclist)) {
			return null;
		}
		List<UdidocDO> udidocList = ContextCache.Get(BDUdidocInfoCache.class.getSimpleName(), DefaultContext_ID,
				DefaultContext_ID, BDUdidocInfoCache_Key, id_udidoclist);
		if (null == udidocList) {
			udidocList = ins.get(id_udidoclist, null, fg_active);
			ContextCache.Put(BDUdidocInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID,
					BDUdidocInfoCache_Key, id_udidoclist, udidocList);
		}
		return udidocList == null ? null : udidocList.toArray(new UdidocDO[] {});
	}
	
	public static String GetNameOfBDUdidocInfo(String id_udidoclist, String code) throws BizException {
		if (StringUtils.isEmpty(id_udidoclist) || StringUtils.isEmpty(code)) {
			return null;
		}
		List<UdidocDO> udidocList = ContextCache.Get(BDUdidocInfoCache.class.getSimpleName(), DefaultContext_ID,
				DefaultContext_ID, BDUdidocInfoCache_Key, id_udidoclist+code);
		if (null == udidocList) {
			udidocList = ins.get(id_udidoclist, code, false);
			ContextCache.Put(BDUdidocInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID,
					BDUdidocInfoCache_Key, id_udidoclist+code, udidocList);
		}
		return udidocList == null ? null : udidocList.get(0).getName();
	}
	
	public static void Clear() {
		ContextCache.Clear(BDUdidocInfoCache.class.getSimpleName());
	}
}
