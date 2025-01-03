package iih.mi.itf2.util;

import iih.mi.itf2.constant.MiParamConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.log.Log;
import xap.sys.orgfw.org.i.IOrgConst;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 医保平台参数帮助类
 * @author ly 2019/05/29
 *
 */
public class MiParamUtil {

	/**
	 * 新医保产品工厂全名称
	 * @param hpId
	 * @return
	 */
	public static String MI0001(String hpId){
		return getInstanceStringParam(hpId, MiParamConst.MI0001);
	}
	
	/**
	 * 医保特殊病流程下，医生站采用病种模式还是采用诊断模式
	 * @return
	 */
	public static Integer MHIR0001(){
		return getBooleanParam(Context.get().getOrgId(),MiParamConst.MHIR0001);
	}
	
	/**
	 * 医保诊疗目录下载包含的目录
	 * @param hpId
	 * @return
	 */
	public static String MI1001(String hpId){
		return getInstanceStringParam(hpId, MiParamConst.MI1001);
	}
	
	/**
	 * 医保接口调用接口类型
	 * @return
	 * @throws BizException 
	 */
	public static Integer MIBD0001() throws BizException{
		return getBooleanParam(IOrgConst.GLOBEORG,MiParamConst.MIBD0001);
	}
	
	/*********************医保校验begin*******************/
	/**
	 * 门诊收费默认加载调入天数
	 * @return
	 * @throws BizException 
	 */
	public static Integer MI3001(String id_hp) throws BizException{
		return getInstanceIntegerParam(id_hp, MiParamConst.MI3001);
	}
	
	/**
	 * 重复开药的排斥剂型
	 * @param id_hp
	 * @return
	 * @throws BizException
	 */
	public static String MI3002(String id_hp) throws BizException{
		return getInstanceStringParam(id_hp, MiParamConst.MI3002);
	}
	
	/**
	 * 门诊领量天数(慢性病)
	 * @return
	 * @throws BizException 
	 */
	public static Integer MI3003(String id_hp) throws BizException{
		return getInstanceIntegerParam(id_hp, MiParamConst.MI3003);
	}
	
	/**
	 * 门诊领量天数（行动不便）
	 * @return
	 * @throws BizException 
	 */
	public static Integer MI3004(String id_hp) throws BizException{
		return getInstanceIntegerParam(id_hp, MiParamConst.MI3004);
	}
	
	/**
	 * 门诊领量天数（普通）
	 * @return
	 * @throws BizException 
	 */
	public static Integer MI3005(String id_hp) throws BizException{
		return getInstanceIntegerParam(id_hp, MiParamConst.MI3005);
	}
	
	/**
	 * 急诊领料量限制天数
	 * @return
	 * @throws BizException 
	 */
	public static Integer MI3006(String id_hp) throws BizException{
		return getInstanceIntegerParam(id_hp, MiParamConst.MI3006);
	}
	
	/**
	 * 门诊草药开单限制付数
	 * @return
	 * @throws BizException 
	 */
	public static Integer MI3007(String id_hp) throws BizException{
		return getInstanceIntegerParam(id_hp, MiParamConst.MI3007);
	}
	
	/**
	 * 历史持有量限制天数
	 * @return
	 * @throws BizException 
	 */
	public static Integer MI3008(String id_hp) throws BizException{
		return getInstanceIntegerParam(id_hp, MiParamConst.MI3008);
	}
	
	/**
	 * 门诊医生站最大开药提醒天数
	 * @return
	 * @throws BizException 
	 */
	public static Integer MI3009(String id_hp) throws BizException{
		return getInstanceIntegerParam(id_hp, MiParamConst.MI3009);
	}
	
	/**
	 * 医保适应症提示信息模式设置
	 * 医保适应症提示信息模式设置： 0——医保限制条件提示信息（显示医保备注） ；1——院内限制提示信息（显示医院备注） ；2——医保限制+院内限制 信息（显示医保备注+显示医院备注）
	 * @return
	 * @throws BizException 
	 */
	public static Integer MI3010(String id_hp) throws BizException{
		return getInstanceIntegerParam(id_hp, MiParamConst.MI3010);
	}
	
	/**
	 * 急诊草药开单限制付数
	 * @return
	 * @throws BizException 
	 */
	public static Integer MI3011(String id_hp) throws BizException{
		return getInstanceIntegerParam(id_hp, MiParamConst.MI3011);
	}
	
	/**
	 * 是否启用医保共享
	 * @return
	 * @throws BizException 
	 */
	public static FBoolean MI3012(String id_hp) throws BizException{
		return getInstanceFBooleanParam(id_hp, MiParamConst.MI3012);
	}
	/*********************医保校验end*******************/
	/**
	 * Sting类实体参数
	 * @param instanceId
	 * @param paramCode
	 * @return
	 */
	private static String getInstanceStringParam(String instanceId,String paramCode){
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
	private static Integer getInstanceIntegerParam(String instanceId,String paramCode){
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
	private static FDouble getInstanceFDoubleParam(String instanceId,String paramCode){
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
	private static FBoolean getInstanceFBooleanParam(String instanceId,String paramCode){
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
