package iih.bd.utils;

import iih.bd.bc.param.IBdSrvParamCodeConst;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医疗服务域参数工具类
 * 
 * @author hao_wu
 *
 */
public class BdSrvParamUtils {

	/**
	 * 获取检查医疗服务编码长度标识
	 * 
	 * @return 检查医疗服务编码长度标识
	 * @throws BizException
	 */
	public static FBoolean getFgCheckSrvCodeLength() throws BizException {
		FBoolean paramValue = ParamUtils.getOrgParamFBooleanValue(ContextUtils.getOrgId(),
				IBdSrvParamCodeConst.FGCHECKSRVCODELENGTH);
		return paramValue;
	}

	/**
	 * 获取诊断标准和诊断字典是否同步停用标识
	 * 
	 * @return 诊断标准和诊断字典是否同步停用标识
	 * @throws BizException
	 */
	public static FBoolean getIsDiAndStdStopTogether() throws BizException {
		FBoolean paramValue = ParamUtils.getOrgParamFBooleanValue(ContextUtils.getOrgId(),
				IBdSrvParamCodeConst.ISDIANDSTDSTOPTOGETHER);
		return paramValue;
	}

	/**
	 * 获取医疗服务是否进行临床启用校验标识
	 * 
	 * @return 诊断医疗服务是否进行临床启用校验标识
	 * @throws BizException
	 */
	public static FBoolean getIsValidateTreatEnableByCi() throws BizException {
		FBoolean paramValue = ParamUtils.getOrgParamFBooleanValue(ContextUtils.getOrgId(),
				IBdSrvParamCodeConst.ISVALIDATETREATENABLEBYCI);
		return paramValue;
	}

	/**
	 * 上下文参数_是否检查用法</br>
	 * 药品通用名保存时因为主DO和子DO分开保存，保存主DO时需要不检查用法
	 * 
	 * @return
	 */
	public static boolean getCheckRouteFlag() {
		FBoolean paramValue = ParamUtils.getContextParamFBooleanValue(IBdSrvParamCodeConst.CHECKROUTEFLAG);
		return FBoolean.TRUE.equals(paramValue);
	}

	/**
	 * 上下文参数_是否检查用法</br>
	 * 药品通用名保存时因为主DO和子DO分开保存，保存主DO时需要不检查用法
	 * 
	 * @return
	 */
	public static void setCheckRouteFlag(boolean checkRouteFlag) {
		ParamUtils.setContextParam(IBdSrvParamCodeConst.CHECKROUTEFLAG, new FBoolean(checkRouteFlag));
	}
}
