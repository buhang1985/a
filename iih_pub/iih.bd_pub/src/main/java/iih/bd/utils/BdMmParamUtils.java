package iih.bd.utils;

import iih.bd.bc.param.IBdMmParamCodeConst;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医疗物品域参数工具类
 * 
 * @author hao_wu
 *
 */
public class BdMmParamUtils {

	/**
	 * 获取药品用药属性管理模式
	 * 
	 * @return 药品用药属性管理模式
	 * @throws BizException
	 */
	public static String GetDrugMCPropMM() throws BizException {
		String paramValue = ParamUtils.getOrgParamStringValue(ContextUtils.getOrgId(), IBdMmParamCodeConst.DRUGMCPROPMM);
		return paramValue;
	}
	
	/**
	 * 药品用医基换算系数是否允许修改
	 * 
	 * @return 药品用药属性管理模式
	 * @throws BizException
	 */
	public static FBoolean GetMedfactorCanUpdate() throws BizException {
		FBoolean paramValue = ParamUtils.getOrgParamFBooleanValue(ContextUtils.getOrgId(), IBdMmParamCodeConst.MMMEDFACTORCANUPDATE);
		return paramValue;
	}
}
