package iih.bd.srv.medsrv.refs.sql;

import org.apache.commons.lang3.StringUtils;
import xap.mw.core.data.BizException;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class OrMedSrvOrderFactory {
	private String paramCode="CIOR0265";
	public OrMedSrvOrderBase getOrMedSrvQuery(String id_org) {
		// 获得临床医嘱在院执行标识默认值设置插件
		String pluginStr;
		try {
			pluginStr = ParamsetQryUtil.getParaString(id_org, paramCode);
		} catch (BizException e1) {
			return new OrMedSrvOrderNameLength();
		}
		// 空判断
		if (StringUtils.isEmpty(pluginStr))
			return new OrMedSrvOrderNameLength();
		try {
			Class<?> c = Class.forName(pluginStr);
			return (OrMedSrvOrderBase) c.newInstance();
		} catch (Exception e) {
			return new OrMedSrvOrderNameLength();
		}
	}

}
