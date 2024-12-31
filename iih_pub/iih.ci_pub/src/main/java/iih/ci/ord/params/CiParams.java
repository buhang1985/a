package iih.ci.ord.params;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.log.Log;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class CiParams {
	public static String CIOR0486(){
		String str = getStringParam(Context.get().getOrgId(), iih.ci.ord.i.ICiOrdNSysParamConst.SYS_PARAM_SkinTestModel);
		if(str == null){
			return "0";
		}
		return str;
	}
	/**
	 * 非药品医嘱首日执行次数是否默认加1顿,默认加1
	 * @return
	 */
	public static FBoolean CIOR0520(){
		FBoolean flag = getBooleanParam(Context.get().getOrgId(), iih.ci.ord.i.ICiOrdNSysParamConst.SYS_PARAM_CIOR0520);
		if(flag == null){
			return FBoolean.TRUE;
		}
		return flag;
	}
	/**
	 * 药品类医嘱首日执行次数是否加1，默认不加1
	 * @return
	 */
	public static FBoolean ZZ_CIOR0002(){
		String flagStr = getStringParam(Context.get().getOrgId(), iih.ci.ord.i.ICiOrdNSysParamConst.SYS_PARAM_IsFirstDayMp);
		if(flagStr == null){
			return FBoolean.FALSE;
		}
		if("Y".equals(flagStr)){
			return FBoolean.TRUE; 
		}
		return FBoolean.FALSE;
	}

	/**
	 * 护嘱绑定的费用首日执行次数是否跟随所绑定的医嘱（true 跟随  false 不跟随  默认false）
	 * @return
	 */
	public static FBoolean YX_CIOR0009(){
		FBoolean flag = getBooleanParam(Context.get().getOrgId(), iih.ci.ord.i.ICiOrdCustomSysParamConst.YX_PARAM_NURSORDER_FIRDY_MP_FOLLOW);
		if(flag == null){
			return FBoolean.FALSE;
		}
		return flag;
	}
	
	/**
	 * 获得参照药品分组显示集合模式值
	 */
	public static String CIOR0540(){
		String flag = getStringParam(Context.get().getOrgId(), iih.ci.ord.i.ICiOrdNSysParamConst.SYS_PARAM_CIOR0540);
		return flag;
	}
	/**
	 * 获得住院服务参照药品显示模式值
	 */
	public static String CIOR0421(){
		String flag = getStringParam(Context.get().getOrgId(), iih.ci.ord.i.ICiOrdNSysParamConst.SYS_PARAM_CIOR0421);
		return flag;
	}
	/**
	 * Sting类参数
	 * @param orgId
	 * @param paramCode
	 * @return
	 */
	private static String getStringParam(String orgId, String paramCode) {
		try {
			String key = paramCode + orgId;
			Object value = Context.get().getAttribute(key);
			if(value != null){
				return (String)value;
			}
			
			String param = ParamsetQryUtil.getParaString(orgId, paramCode);
			Context.get().setAttribute(key, param);
			return param;
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return null;
	}
	
	/**
	 * Integer类参数
	 * @param orgId
	 * @param paramCode
	 * @return
	 */
	private static Integer getIntegerParam(String orgId,String paramCode){
		try {
			String key = paramCode + orgId;
			Object value = Context.get().getAttribute(key);
			if(value != null){
				return (Integer)value;
			}
			
			Integer param = ParamsetQryUtil.getParaInt(orgId, paramCode);
			Context.get().setAttribute(key, param);
			return param;
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return null;
	}
	
	/**
	 * FDouble类参数
	 * @param orgId
	 * @param paramCode
	 * @return
	 */
	private static FDouble getDoubleParam(String orgId,String paramCode){
		try {
			String key = paramCode + orgId;
			Object value = Context.get().getAttribute(key);
			if(value != null){
				return (FDouble)value;
			}
			
			FDouble param = ParamsetQryUtil.getParaDbl(orgId, paramCode);
			Context.get().setAttribute(key, param);
			return param;
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return null;
	}
	
	/**
	 * Boolean类参数
	 * @param orgId
	 * @param paramCode
	 * @return
	 */
	private static FBoolean getBooleanParam(String orgId,String paramCode){
		try {
			String key = paramCode + orgId;
			Object value = Context.get().getAttribute(key);
			if(value != null){
				return (FBoolean)value;
			}
			
			FBoolean param = ParamsetQryUtil.getParaBoolean(orgId, paramCode);
			Context.get().setAttribute(key, param);
			return param;
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return null;
	}
}
