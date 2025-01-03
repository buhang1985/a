package iih.ei.std.s.bp;

import iih.ei.itf.eiitfdo.d.EiItfDO;
import xap.mw.core.data.Context;

/**
 * IIH服务参数工具类
 * 
 * @author hao_wu 2019-9-20
 *
 */
public class IIHServiceParamUtils {

	/**
	 * 获取接口信息
	 * 
	 * @return
	 */
	public static EiItfDO getEiItfDo() {
		return (EiItfDO) Context.get().getAttribute("IIH_WEBSERVICE_PARAM_ITFDO");
	}

	/**
	 * 设置接口信息
	 * 
	 * @param itfInfoDo
	 */
	public static void setEiItfDo(EiItfDO itfInfoDo) {
		Context.get().setAttribute("IIH_WEBSERVICE_PARAM_ITFDO", itfInfoDo);
	}

	/**
	 * 获取外部编码
	 * 
	 * @return
	 */
	public static String getExternalCode() {
		return (String) Context.get().getAttribute("IIH_WEBSERVICE_PARAM_EXTERNALCODE");
	}

	/**
	 * 设置外部编码
	 * 
	 * @param itfInfoDo
	 */
	public static void setExternalCode(String externalCode) {
		Context.get().setAttribute("IIH_WEBSERVICE_PARAM_EXTERNALCODE", externalCode);
	}
}
