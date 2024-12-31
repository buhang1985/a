package iih.bd.utils;

import iih.bd.bc.param.IBdBcParamCodeConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 基础编码域参数工具类
 * 
 * @author hao_wu
 *
 */
public class BdBcParamUtil {
	/**
	 * 获取IIH标准产品版本运行场景设置
	 * 
	 * @return IIH标准产品版本运行场景设置
	 * @throws BizException
	 */
	public static String GetIIHStdVerRunScene() throws BizException {
		String paramValue = ParamsetQryUtil.getParaString(Context.get().getOrgId(),
				IBdBcParamCodeConst.IIHStdVerRunScene);
		return paramValue;
	}
}
