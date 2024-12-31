package iih.bd.utils;

import java.util.HashMap;
import java.util.Map;

import iih.bd.bc.param.IBdMhiParamCodeConst;
import xap.mw.core.data.BizException;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 医疗保险域参数工具类
 * 
 * @author hao_wu
 *
 */
public class BdMhiParamUtils {

	/**
	 * 编程配置
	 * 
	 * @author hao_wu
	 *
	 */
	public static class ProgramConfig {

		/**
		 * 根据医保产品主键获取医保产品工厂实例类全名称
		 * 
		 * @param hpId
		 *            医保产品主键
		 * @return 医保产品工厂实例类全名称
		 * @throws BizException
		 */
		public static String GetHpFactoryInstFullName(String hpId) throws BizException {
			String paramValue = ParamUtils.getInstanceParamStringValue(hpId,
					IBdMhiParamCodeConst.ProgramConfig.HPFACTORYINSTFULLNAME);
			return paramValue;
		}

		/**
		 * 根据医保产品主键集合获取医保产品工厂实例类全名称字典
		 * 
		 * @param hpIds
		 *            医保产品主键集合
		 * @return 医保产品工厂实例类全名称字典[医保产品主键,医保产品工厂实例类全名称]
		 * @throws BizException
		 */
		public static Map<String, String> GetHpFactoryInstFullNameMap(String[] hpIds) throws BizException {
			Map<String, String> paramValueMap = ParamUtils.getInstanceParamStringValueMap(hpIds,
					IBdMhiParamCodeConst.ProgramConfig.HPFACTORYINSTFULLNAME);
			return paramValueMap;
		}

		/**
		 * 根据医保产品主键集合获取医保产品数据源名称字典
		 * 
		 * @param hpIds
		 *            医保产品主键集合
		 * @return 医保产品数据源名称字典
		 * @throws BizException
		 */
		public static Map<String, String> GetHpDataSourceNameMap(String[] hpIds) throws BizException {
			Map<String, String> paramValueMap = ParamUtils.getInstanceParamStringValueMap(hpIds,
					IBdMhiParamCodeConst.ProgramConfig.HPDATASOURCENAME);
			return paramValueMap;
		}

		/**
		 * 根据医保产品主键查询医保住院结算导出路径
		 * 
		 * @param hpId
		 *            医保产品主键
		 * @return 医保住院结算导出路径
		 * @throws BizException
		 */
		public static String getHpIpStExpPathByHpId(String hpId) throws BizException {
			String paramValue = ParamUtils.getInstanceParamStringValue(hpId,
					IBdMhiParamCodeConst.ProgramConfig.HPIPSTEXPPATH);
			return paramValue;
		}

		/**
		 * 根据医保产品主键集合查询医保住院结算导出路径字典
		 * 
		 * @param hpIds
		 *            医保产品主键集合
		 * @return 医保住院结算导出路径字典<医保产品主键,医保住院结算导出路径>
		 * @throws BizException
		 */
		public static Map<String, String> getHpIpStExpPathMap(String[] hpIds) throws BizException {
			Map<String, String> paramValueMap = ParamUtils.getInstanceParamStringValueMap(hpIds,
					IBdMhiParamCodeConst.ProgramConfig.HPIPSTEXPPATH);
			return paramValueMap;
		}

		/**
		 * 根据医保产品主键查询医保住院结算导入路径
		 * 
		 * @param hpId
		 *            医保产品主键
		 * @return 医保住院结算导入路径
		 * @throws BizException
		 */
		public static String getHpIpStImpPathByHpId(String hpId) throws BizException {
			String paramValue = ParamUtils.getInstanceParamStringValue(hpId,
					IBdMhiParamCodeConst.ProgramConfig.HPIPSTIMPPATH);
			return paramValue;
		}

		/**
		 * 根据医保产品主键集合查询医保住院结算导入路径字典
		 * 
		 * @param hpIds
		 *            医保产品主键集合
		 * @return 医保住院结算导入路径字典<医保产品主键,医保住院结算导入路径>
		 * @throws BizException
		 */
		public static Map<String, String> getHpIpStImpPathMap(String[] hpIds) throws BizException {
			Map<String, String> paramValueMap = ParamUtils.getInstanceParamStringValueMap(hpIds,
					IBdMhiParamCodeConst.ProgramConfig.HPIPSTIMPPATH);
			return paramValueMap;
		}
	}

	/**
	 * 扩展属性
	 * 
	 * @author hao_wu
	 *
	 */
	public static class ExtAttr {

		/**
		 * 根据医保产品主键查询所有参数字典
		 * 
		 * @param hpIds
		 *            医保产品主键集合
		 * @return 实体参数字典[医保产品主,[参数编码，参数值]]
		 * @throws BizException
		 */
		public static Map<String, Map<String, String>> getAllParamsByHpIds(String[] hpIds) throws BizException {
			if (hpIds == null || hpIds.length <= 0) {
				return null;
			}

			Map<String, Map<String, String>> allParamMap = new HashMap<String, Map<String, String>>();
			for (String hpId : hpIds) {
				Map<String, String> paramsMap = getAllInstParamsByHpId(hpId);
				if (paramsMap != null) {
					allParamMap.put(hpId, paramsMap);
				}
			}
			return allParamMap;
		}

		/**
		 * 获取医保产品的所有实体参数
		 * 
		 * @param hpId
		 *            医保产品主键
		 * @return 实体参数字典[参数编码，参数值]
		 * @throws BizException
		 */
		public static Map<String, String> getAllInstParamsByHpId(String hpId) throws BizException {
			Map<String, String> allParamMap = ParamsetQryUtil.getParasStringByInstance(hpId,
					IBdMhiParamCodeConst.CacheParamCodes);
			return allParamMap;
		}

		/**
		 * 根据医保产品主键获取医保定点医疗机构编码
		 * 
		 * @param hpId
		 *            医保产品主键
		 * @return 医保定点医疗机构编码
		 * @throws BizException
		 */
		public static String GetHpDesigMICode(String hpId) throws BizException {
			String paramValue = ParamUtils.getInstanceParamStringValue(hpId,
					IBdMhiParamCodeConst.ExtAttr.HPDESIGMICODE);
			return paramValue;
		}

		/**
		 * 根据医保产品主键集合获取医保定点医疗机构编码字典
		 * 
		 * @param hpIds
		 *            医保产品主键集合
		 * @return 医保定点医疗机构编码字典[医保产品主键,医保定点医疗机构编码]
		 * @throws BizException
		 */
		public static Map<String, String> GetHpDesigMICodeMap(String[] hpIds) throws BizException {
			Map<String, String> paramValueMap = ParamUtils.getInstanceParamStringValueMap(hpIds,
					IBdMhiParamCodeConst.ExtAttr.HPDESIGMICODE);
			return paramValueMap;
		}

		/**
		 * 根据医保产品主键获取医保定点医疗机构名称
		 * 
		 * @param hpId
		 *            医保产品主键
		 * @return 医保定点医疗机构名称
		 * @throws BizException
		 */
		public static String GetHpDesigMIName(String hpId) throws BizException {
			String paramValue = ParamUtils.getInstanceParamStringValue(hpId,
					IBdMhiParamCodeConst.ExtAttr.HPDESIGMINAME);
			return paramValue;
		}

		/**
		 * 根据医保产品主键集合获取医保定点医疗机构名称字典
		 * 
		 * @param hpIds
		 *            医保产品主键集合
		 * @return 医保定点医疗机构名称字典[医保产品主键,医保定点医疗机构名称]
		 * @throws BizException
		 */
		public static Map<String, String> GetHpDesigMINameMap(String[] hpIds) throws BizException {
			Map<String, String> paramValueMap = ParamUtils.getInstanceParamStringValueMap(hpIds,
					IBdMhiParamCodeConst.ExtAttr.HPDESIGMINAME);
			return paramValueMap;
		}

		/**
		 * 根据医保产品主键获取就医地地区编码
		 * 
		 * @param hpId
		 *            医保产品主键
		 * @return 就医地地区编码
		 * @throws BizException
		 */
		public static String getHpMedDistCode(String hpId) throws BizException {
			String paramValue = ParamUtils.getInstanceParamStringValue(hpId,
					IBdMhiParamCodeConst.ExtAttr.HPMEDDISTCODE);
			return paramValue;
		}

		/**
		 * 根据医保产品主键集合获取就医地地区编码字典
		 * 
		 * @param hpIds
		 *            医保产品主键集合
		 * @return 就医地地区编码字典[医保产品主键,就医地地区编码]
		 * @throws BizException
		 */
		public static Map<String, String> getHpMedDistCodeMap(String[] hpIds) throws BizException {
			Map<String, String> paramValueMap = ParamUtils.getInstanceParamStringValueMap(hpIds,
					IBdMhiParamCodeConst.ExtAttr.HPMEDDISTCODE);
			return paramValueMap;
		}
	}

	/**
	 * 流程控制
	 * 
	 * @author hao_wu
	 *
	 */
	public static class ProcessControl {

		/**
		 * 根据医保产品主键获取医保产品支持的业务场景
		 * 
		 * @param hpId
		 *            医保产品主键
		 * @return 医保产品支持的业务场景
		 * @throws BizException
		 */
		public static String GetHpSupportedBizScenes(String hpId) throws BizException {
			String paramValue = ParamUtils.getInstanceParamStringValue(hpId,
					IBdMhiParamCodeConst.ProcessControl.HPSUPPORTEDBIZSCENES);
			return paramValue;
		}

		/**
		 * 根据医保产品主键集合获取医保产品支持的业务场景字典
		 * 
		 * @param hpIds
		 *            医保产品主键集合
		 * @return 医保产品支持的业务场景字典[医保产品主键,医保产品支持的业务场景]
		 * @throws BizException
		 */
		public static Map<String, String> GetHpSupportedBizScenesMap(String[] hpIds) throws BizException {
			Map<String, String> paramValueMap = ParamUtils.getInstanceParamStringValueMap(hpIds,
					IBdMhiParamCodeConst.ProcessControl.HPSUPPORTEDBIZSCENES);
			return paramValueMap;
		}

		/**
		 * 根据医保产品主键获取医保产品结算模式
		 * 
		 * @param hpId
		 *            医保产品主键
		 * @return 医保产品结算模式
		 * @throws BizException
		 */
		public static String GetHpStMode(String hpId) throws BizException {
			String paramValue = ParamUtils.getInstanceParamStringValue(hpId,
					IBdMhiParamCodeConst.ProcessControl.HPSTMODE);
			return paramValue;
		}

		/**
		 * 根据医保产品主键集合获取医保产品结算模式字典
		 * 
		 * @param hpIds
		 *            医保产品主键集合
		 * @return 医保产品结算模式字典[医保产品主键,医保产品结算模式]
		 * @throws BizException
		 */
		public static Map<String, String> GetHpStModeMap(String[] hpIds) throws BizException {
			Map<String, String> paramValueMap = ParamUtils.getInstanceParamStringValueMap(hpIds,
					IBdMhiParamCodeConst.ProcessControl.HPSTMODE);
			return paramValueMap;
		}
	}

	/**
	 * 医保校验
	 * 
	 * @author dj.zhang
	 *
	 */
	public static class Validation {

		/**
		 * 根据医保产品主键获取医生站药品最大可使用天数
		 * 
		 * @param hpId
		 *            医保产品主键
		 * @return 医生站药品最大可使用天数
		 * @throws BizException
		 */
		public static String GetMaxAvailableDaysForDrugs(String hpId) throws BizException {
			String paramValue = ParamUtils.getInstanceParamStringValue(hpId,
					IBdMhiParamCodeConst.Validation.MAXAVAILABLEDAYSFORDRUGS);
			return paramValue;
		}

		/**
		 * 根据医保产品主键集合获取医生站药品最大可使用天数字典
		 * 
		 * @param hpIds
		 *            医保产品主键集合
		 * @return 医生站药品最大可使用天数字典[医保产品主键,医生站药品最大可使用天数]
		 * @throws BizException
		 */
		public static Map<String, String> GetMaxAvailableDaysForDrugsMap(String[] hpIds) throws BizException {
			Map<String, String> paramValueMap = ParamUtils.getInstanceParamStringValueMap(hpIds,
					IBdMhiParamCodeConst.Validation.MAXAVAILABLEDAYSFORDRUGS);
			return paramValueMap;
		}

	}
}
