package iih.ei.sc.common;

import xap.mw.core.data.BizException;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 参数帮助类
 * 
 * @author yankan
 *
 */
public class ScParamUtils {
	private static final String SC_APT_MT_CHK_FEE = "SC0035";// 医技预约费用检查

	/**
	 * 获取医技预约申请单是否费用检查
	 *
	 * @param deptId
	 * @return
	 * @author zhengcm
	 */
	public static Boolean getScAptMtChkFee(String deptId) {
		String paramValue = getDepParamValue(deptId, SC_APT_MT_CHK_FEE);
		return "1".equals(paramValue);
	}
	/**
	 * 获取部门参数
	 * 
	 * @param depId 部门id
	 * @param paramCode 参数编码
	 * @return
	 */
	private static String getDepParamValue(String depId, String paramCode) {
		// 框架提供的方法
		String val = "";
		try {
			val = ParamsetQryUtil.getParaString(depId, paramCode);
		} catch (BizException e) {
			e.printStackTrace();
		}
		return val;
	}
}
