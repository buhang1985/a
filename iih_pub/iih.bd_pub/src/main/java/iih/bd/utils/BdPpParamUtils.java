package iih.bd.utils;

import iih.bd.bc.param.IBdPpParamCodeConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;

/**
 * 付款策略域参数工具类
 * 
 * @author hao_wu
 *
 */
public class BdPpParamUtils {

	/**
	 * 获取参数价表维护时计量单位是否可空标识值
	 * 
	 * @return
	 * @throws BizException
	 */
	public static FBoolean GetUnitNullFlag() throws BizException {
		FBoolean paramValue = ParamUtils.getOrgParamFBooleanValue(ContextUtils.getOrgId(),
				IBdPpParamCodeConst.BD_PP_FG_NULL_UNIT_PRICE);
		return paramValue;
	}

	/**
	 * 优惠券分类编码长度
	 * 
	 * @return
	 * @throws BizException
	 */
	public static Integer GetCpnCateCodeLength() throws BizException {
		Integer paramVaule = ParamUtils.getOrgParamIntegerValue(ContextUtils.getOrgId(),
				IBdPpParamCodeConst.BD_PP_CPNCATE_CODELENGTH);
		return paramVaule;
	}

	/**
	 * 医保药品名称类型
	 * 
	 * @return
	 * @throws BizException
	 */
	public static String GetMiDrugNameType() throws BizException {
		String paramVaule = ParamUtils.getOrgParamStringValue(ContextUtils.getOrgId(),
				IBdPpParamCodeConst.BD_PP_MI_DRUGNAMETYPE);
		return paramVaule;
	}

	/**
	 * 获取使用财务核算体系标识
	 * 
	 * @return
	 * @throws BizException
	 */
	public static FBoolean getUseAccountSystemFlag() throws BizException {
		FBoolean paramVaule = ParamUtils.getOrgParamFBooleanValue(ContextUtils.getOrgId(),
				IBdPpParamCodeConst.BL_AC_USEACCOUNTSYSTEMFLAG);
		return paramVaule;
	}

	/**
	 * 获取共用核算体系标识
	 * 
	 * @return
	 * @throws BizException
	 */
	public static FBoolean getShareAcountSystemFlag() throws BizException {
		FBoolean paramVaule = ParamUtils.getOrgParamFBooleanValue(ContextUtils.getOrgId(),
				IBdPpParamCodeConst.BL_AC_SHAREACCOUNTSYSTEM);
		return paramVaule;
	}

	/**
	 * 特殊项目调价是否强制使用调价计划
	 * 
	 * @return
	 * @throws BizException
	 */
	public static FBoolean GetWhetherUseModifyPricePlan() throws BizException {
		FBoolean paramVaule = ParamUtils.getOrgParamFBooleanValue(ContextUtils.getOrgId(),
				IBdPpParamCodeConst.BD_PP_USE_MODIFYPRICEPLAN);
		return paramVaule;
	}

	/**
	 * 调价计划调价标识Key
	 */
	private static String planModifyPriFlagKey = "PlanModifyPriFlag";

	/**
	 * 获取调价计划调价标识
	 * 
	 * @return
	 */
	public static Boolean getPlanModifyPriFlag() {
		Boolean planModifyPriFlag = Context.get().getAttribute(planModifyPriFlagKey, Boolean.class);
		if (planModifyPriFlag == null) {
			return Boolean.FALSE;
		}
		return planModifyPriFlag;
	}

	/**
	 * 设置调价计划调价标识
	 * 
	 * @param planModifyPriFlag
	 */
	public static void setPlanModifyPriFlag(Boolean planModifyPriFlag) {
		Context.get().setAttribute(planModifyPriFlagKey, planModifyPriFlag);
	}

	/**
	 * 是否使用IIH的财务核算体系</br>
	 * 此方法已过时，请使用getUseAccountSystemFlag
	 * 
	 * @return
	 * @throws BizException
	 */
	@Deprecated
	public static FBoolean GetIfIIHAcSystem() throws BizException {
		FBoolean paramVaule = ParamUtils.getOrgParamFBooleanValue(ContextUtils.getOrgId(),
				IBdPpParamCodeConst.BL_AC_IFIIHACSYSTEM);
		return paramVaule;
	}

	/**
	 * 是否共用一套核算体系</br>
	 * 此方法已过时，请使用getShareAcountSystemFlag
	 * 
	 * @return
	 * @throws BizException
	 */
	@Deprecated
	public static FBoolean GetIfShareAcSystem() throws BizException {
		FBoolean paramVaule = ParamUtils.getOrgParamFBooleanValue(ContextUtils.getOrgId(),
				IBdPpParamCodeConst.BL_AC_IFSHAREACSYSTEM);
		return paramVaule;
	}

	/**
	 * 获取后台任务调价标识
	 * 
	 * @return
	 */
	public static Boolean getBgTaskModifyPriFlag() {
		FBoolean paramValue = ParamUtils
				.getContextParamFBooleanValue(IBdPpParamCodeConst.BD_PP_CONTEXT_BGTASKMODIFYPRIFLAGKEY);
		if (paramValue != null && FBoolean.TRUE.equals(paramValue)) {
			return true;
		}
		return false;
	}

	/**
	 * 设置后台任务调价标识
	 * 
	 * @param planModifyPriFlag
	 */
	public static void setBgTaskModifyPriFlag(Boolean paramValue) {
		ParamUtils.setContextParam(IBdPpParamCodeConst.BD_PP_CONTEXT_BGTASKMODIFYPRIFLAGKEY, new FBoolean(paramValue));
	}

	/**
	 * 获取默认的医嘱标识
	 * 
	 * @return
	 * @throws BizException
	 */
	public static FBoolean getDefaultFgOr() throws BizException {
		FBoolean defaultFgOr = ParamUtils.getOrgParamFBooleanValue(IBdPpParamCodeConst.BD_PP_DEFAULT_FGOR);
		if (defaultFgOr == null) {
			return FBoolean.FALSE;
		}
		return defaultFgOr;
	}
}
