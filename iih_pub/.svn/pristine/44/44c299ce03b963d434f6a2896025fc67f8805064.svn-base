package iih.bd.res.params;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.appfw.log.Log;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 资源参数
 * @author ly 2017/07/26
 *
 */
public class BdResParams {

	private Context ctx = Context.get();
	public static final String CHIS_DATA_SOURCE = "chisdatasource";//chis数据源参数
	
	/**
	 * chis数据源名称
	 * @return
	 */
	public String CHISDB(){
		try {
			return ParamsetQryUtil.getParaString(ctx.getOrgId(), CHIS_DATA_SOURCE);
		} catch (BizException e) {
			Log.error(e);
		}
		return null;
	}
}
