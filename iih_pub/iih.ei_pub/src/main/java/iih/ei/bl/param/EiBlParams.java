package iih.ei.bl.param;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.appfw.log.Log;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 对外接口--费用参数
 * @author ly 2019/12/16
 *
 */
public class EiBlParams {

	/**
	 * 电子发票调用地址
	 * @return
	 */
	public static String EIBL0001() {
		return getStringParam(Context.get().getOrgId(), EiBlParamConst.EIBL0001);
	}

	/**
	 * 电子发票应用账号
	 * @return
	 */
	public static String EIBL0002() {
		return getStringParam(Context.get().getOrgId(), EiBlParamConst.EIBL0002);
	}

	/**
	 * 电子发票公共密钥
	 * @return
	 */
	public static String EIBL0003() {
		return getStringParam(Context.get().getOrgId(), EiBlParamConst.EIBL0003);
	}
	
	/**
	 * 发票不可流通的支付方式
	 * @return
	 */
	public static String EIBL0006() {
		return getStringParam(Context.get().getOrgId(), EiBlParamConst.EIBL0006);
	}
	
	/**
	 * Sting类参数
	 * @param orgId
	 * @param paramCode
	 * @return
	 */
	private static String getStringParam(String orgId, String paramCode) {
		try {
			String param = ParamsetQryUtil.getParaString(orgId, paramCode);
			return param;
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return null;
	}
}
