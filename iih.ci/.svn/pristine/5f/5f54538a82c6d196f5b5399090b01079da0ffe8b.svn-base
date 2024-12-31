package iih.ci.mi.sysparam;

import iih.mi.itf2.util.MiParamUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.log.Log;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;


/**
 * 临床医保参数
 * @author HUMS
 *
 */
public class CiMiParamUtil {

	private static Context context=Context.get();
	
	/**
	 * 医保特殊病流程下，医生站采用病种模式还是采用诊断模式 0 病种模式， 1诊断模式
	 * @return
	 */
	public static Integer MHIR0001(){
		return MiParamUtil.MHIR0001();
	}	
	
	/**
	 * 是否急诊就诊判断方式 
	 * @return 0就诊类型，1就诊科室
	 */
	public static String LL_CIOR0315() {
		return getOrgStringParam(Context.get().getOrgId(),CiMiParamConst.LL_CIOR0315);
	}
	
	/**
	 * 是否急诊就诊判断方式 
	 * @return 0就诊类型，1就诊科室
	 */
	public static String LL_CIOR0320() {
		return getOrgStringParam(Context.get().getOrgId(),CiMiParamConst.LL_CIOR0320);
	}
	
	/*********************医保校验end*******************/
	
	private static String getOrgStringParam(String id,String paramCode){
		try {
			return ParamsetQryUtil.getParaString(id,paramCode);
		} catch (BizException e) {
			throw new RuntimeException("获取组织参数【"+paramCode+"】值失败！");			
		}	
	}
	
	
	/**
	 * Sting类实体参数
	 * @param instanceId
	 * @param paramCode
	 * @return
	 */
	private static String getStringParam(String instanceId,String paramCode){
		try {
			String param = ParamsetQryUtil.getParaStringByInstance(instanceId,paramCode);
			return param;
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return null;
	}
	
	
	/**
	 * int类参数
	 * @param orgId
	 * @param paramCode
	 * @return
	 */
	private static Integer getBooleanParam(String orgId,String paramCode){
		try {
			String key =paramCode + orgId;
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
	 * Integer类实体参数
	 * @param instanceId
	 * @param paramCode
	 * @return
	 */
	@SuppressWarnings("unused")
	private static Integer getIntegerParam(String instanceId,String paramCode){
		try {
			Integer param = ParamsetQryUtil.getParaIntByInstance(instanceId, paramCode);
			return param;
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return null;
	}
	
	/**
	 * FDouble类实体参数
	 * @param instanceId
	 * @param paramCode
	 * @return
	 */
	@SuppressWarnings("unused")
	private static FDouble getFDoubleParam(String instanceId,String paramCode){
		try {
			FDouble param = ParamsetQryUtil.getParaDblByInstance(instanceId, paramCode);
			return param;
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return null;
	}
	
	/**
	 * FBoolean类实体参数
	 * @param instanceId
	 * @param paramCode
	 * @return
	 */
	@SuppressWarnings("unused")
	private static FBoolean getFBooleanParam(String instanceId,String paramCode){
		try {
			FBoolean param = ParamsetQryUtil.getParaBooleanByInstance(instanceId, paramCode);
			return param;
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return null;
	}
}
