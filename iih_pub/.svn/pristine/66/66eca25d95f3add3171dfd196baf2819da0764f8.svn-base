package iih.pi.utils;

import iih.bd.bc.param.IPiParamCodeConst;
import iih.bd.utils.ContextUtils;
import iih.bd.utils.ParamUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 患者信息域参数工具类
 * 
 * @author hao_wu
 *
 */
public class PiParamUtils {

	/**
	 * 是否创建患者到CHIS
	 * 
	 * @return
	 * @throws BizException
	 */
	public static FBoolean getCreatePatToChis() throws BizException {
		FBoolean paramValue = ParamUtils.GetOrgParamFBooleanValue(ContextUtils.getOrgId(),
				IPiParamCodeConst.CREATEPATTOCHIS);
		return paramValue;
	}

	/**
	 * 是否更新患者到CHIS
	 * 
	 * @return
	 * @throws BizException
	 */
	public static FBoolean getSyncPatToChis() throws BizException {
		FBoolean paramValue = ParamUtils.GetOrgParamFBooleanValue(ContextUtils.getOrgId(),
				IPiParamCodeConst.SYNCPATTOCHIS);
		return paramValue;
	}
}
