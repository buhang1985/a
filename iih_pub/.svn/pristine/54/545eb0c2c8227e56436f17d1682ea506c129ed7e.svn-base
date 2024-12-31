package iih.en.utils.params;

import iih.en.utils.EnContextUtils;
import iih.en.utils.IEnFlowKeyConst;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.log.Log;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * EN 参数帮助类
 * 
 * @author liubin
 *
 */
public class EnParamsUtil{
	
	/********************公共参数********************/
	
	/**
	 * 患者身高体重默认获取天数
	 * 
	 * @param depId
	 * @return
	 */
	public static int EN000170(String depId){
		Integer param =  getIntegerParam(depId, EnParamsConst.EN000170);
		return param != null ? param : 0;
	}
	
	/********************门诊参数********************/
	
	/********************急诊参数********************/
	
	/********************住院参数********************/
	
	/********************实体参数********************/
	
	/********************其他域参数*******************/
	
	/**
	 * 获取新生儿体重(g)服务
	 * 
	 * @return
	 */
	public static String MPNR0109(){
		return getStringParam(EnContextUtils.getOrgId(), EnParamsConst.MPNR0109);
	}
	/**
	 * 获取身高采集服务
	 * 
	 * @return
	 */
	public static String MPNR0113(){
		return getStringParam(EnContextUtils.getOrgId(), EnParamsConst.MPNR0113);
	}
	/**
	 * 体重(KG)采集服务
	 * 
	 * @return
	 */
	public static String MPNR0114(){
		return getStringParam(EnContextUtils.getOrgId(), EnParamsConst.MPNR0114);
	}
	
	/********************私有方法********************/

	/**
	 * Sting类参数
	 * @param orgId
	 * @param paramCode
	 * @return
	 */
	private static String getStringParam(String orgId, String paramCode) {
		try {
			String key = IEnFlowKeyConst.EN_FLOW_CTX_KEY + paramCode + orgId;
			Object value = EnContextUtils.getCtxAttribute(key);
			if(value != null){
				return (String)value;
			}
			
			String param = ParamsetQryUtil.getParaString(orgId, paramCode);
			EnContextUtils.setCtxAttribute(key, param);
			return param;
		} catch (BizException e) {
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
			String key = IEnFlowKeyConst.EN_FLOW_CTX_KEY + paramCode + orgId;
			Object value = EnContextUtils.getCtxAttribute(key);
			if(value != null){
				return (Integer)value;
			}
			
			Integer param = ParamsetQryUtil.getParaInt(orgId, paramCode);
			EnContextUtils.setCtxAttribute(key, param);
			return param;
		} catch (BizException e) {
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
	@SuppressWarnings("unused")
	private static FDouble getDoubleParam(String orgId,String paramCode){
		try {
			String key = IEnFlowKeyConst.EN_FLOW_CTX_KEY + paramCode + orgId;
			Object value = EnContextUtils.getCtxAttribute(key);
			if(value != null){
				return (FDouble)value;
			}
			
			FDouble param = ParamsetQryUtil.getParaDbl(orgId, paramCode);
			EnContextUtils.setCtxAttribute(key, param);
			return param;
		} catch (BizException e) {
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
	@SuppressWarnings("unused")
	private static FBoolean getBooleanParam(String orgId,String paramCode){
		try {
			String key = IEnFlowKeyConst.EN_FLOW_CTX_KEY + paramCode + orgId;
			Object value = EnContextUtils.getCtxAttribute(key);
			if(value != null){
				return (FBoolean)value;
			}
			
			FBoolean param = ParamsetQryUtil.getParaBoolean(orgId, paramCode);
			EnContextUtils.setCtxAttribute(key, param);
			return param;
		} catch (BizException e) {
			Log.error(e);
		}
		return null;
	}

	/**
	 * Sting类实体参数
	 * @param instanceId
	 * @param paramCode
	 * @return
	 */
	@SuppressWarnings("unused")
	private static String getInstanceStringParam(String instanceId,String paramCode){
		try {
			String key = IEnFlowKeyConst.EN_FLOW_CTX_KEY + paramCode + instanceId;
			Object value = EnContextUtils.getCtxAttribute(key);
			if (value != null) {
				return (String) value;
			}

			String param = ParamsetQryUtil.getParaStringByInstance(instanceId,paramCode);
			EnContextUtils.setCtxAttribute(key, param);
			return param;
		} catch (BizException e) {
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
	private static Integer getInstanceIntegerParam(String instanceId,String paramCode){
		try {
			String key = IEnFlowKeyConst.EN_FLOW_CTX_KEY + paramCode + instanceId;
			Object value = EnContextUtils.getCtxAttribute(key);
			if (value != null) {
				return (Integer) value;
			}

			Integer param = ParamsetQryUtil.getParaIntByInstance(instanceId, paramCode);
			EnContextUtils.setCtxAttribute(key, param);
			return param;
		} catch (BizException e) {
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
	private static FDouble getInstanceFDoubleParam(String instanceId,String paramCode){
		try {
			String key = IEnFlowKeyConst.EN_FLOW_CTX_KEY + paramCode + instanceId;
			Object value = EnContextUtils.getCtxAttribute(key);
			if (value != null) {
				return (FDouble) value;
			}

			FDouble param = ParamsetQryUtil.getParaDblByInstance(instanceId, paramCode);
			EnContextUtils.setCtxAttribute(key, param);
			return param;
		} catch (BizException e) {
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
	private static FBoolean getInstanceFBooleanParam(String instanceId,String paramCode){
		try {
			String key = IEnFlowKeyConst.EN_FLOW_CTX_KEY + paramCode + instanceId;
			Object value = EnContextUtils.getCtxAttribute(key);
			if (value != null) {
				return (FBoolean) value;
			}

			FBoolean param = ParamsetQryUtil.getParaBooleanByInstance(instanceId, paramCode);
			EnContextUtils.setCtxAttribute(key, param);
			return param;
		} catch (BizException e) {
			Log.error(e);
		}
		return null;
	}
}