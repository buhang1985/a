package iih.ci.mrm.bp.common;

import iih.ci.mr.pub.MrConst.IMrSysParamConst;
import iih.ci.mr.pub.MrConst.IMrSysParamDefaultConst;
import iih.ci.mrm.pub.MrMConst.IMrMSysParamConst;
import iih.ci.mrm.pub.MrMConst.IMrMSysParamDefaultConst;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class CiMrMParamUtils {

	/**
	 * 完成病历是否生成电子文档
	 * @param id_org
	 * @return
	 */
	public static Boolean getSysParamComPleteGenerateEle(String id_org) {
		FBoolean result = FBoolean.TRUE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org,IMrMSysParamConst.SYS_PARAM_MRM_COMPLETE_GENERATE_ELE);
		} catch (BizException e) {
			return IMrMSysParamDefaultConst.SYS_PARAM_MRM_COMPLETE_GENERATE_ELE_DEFAULT;
		}

		return result.booleanValue();

	}
	
	/**
	 * 首次打印是否收费
	 * @param id_org
	 * @return
	 */
	public static Boolean getSysParamPrintFirstFree(String id_org) {
		FBoolean result = FBoolean.TRUE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org,IMrMSysParamConst.SYS_PARAM_MRM_PRINT_FIRST_FREE);
		} catch (BizException e) {
			return IMrMSysParamDefaultConst.SYS_PARAM_MRM_PRINT_FIRST_FREE_DEFAULT;
		}

		return result.booleanValue();

	}
	
	/**
	 * 收费服务
	 * @param id_org
	 * @return
	 */
	public static String getSysParamPrintCharge(String id_org) {
		String result = "";
		try {
			result = ParamsetQryUtil.getParaString(id_org,IMrMSysParamConst.SYS_PARAM_MRM_PRINT_CHARGE);
		} catch (BizException e) {
			return IMrMSysParamDefaultConst.SYS_PARAM_MRM_PRINT_CHARGE_DEFAULT;
		}

		return result;

	}
	
	/**
	 * 入库是否录入信息
	 * @param id_org
	 * @return
	 */
	public static Boolean getSysParamStorageAddInfo(String id_org) {
		FBoolean result = FBoolean.TRUE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org,IMrMSysParamConst.SYS_PARAM_MRM_STORAGE_ADD_INFO);
		} catch (BizException e) {
			return IMrMSysParamDefaultConst.SYS_PARAM_MRM_STORAGE_ADD_INFO_DEFAULT;
		}

		return result.booleanValue();

	}
	
	/**
	 * 自动生成病案电子文档格式
	 * @param id_org
	 * @return
	 */
	public static String getSysParamSaveFormat(String id_org) {
		String result = "";
		try {
			result = ParamsetQryUtil.getParaString(id_org,IMrMSysParamConst.SYS_PARAM_MRM_SAVE_FORMAT);
		} catch (BizException e) {
			return IMrMSysParamDefaultConst.SYS_PARAM_MRM_SAVE_FORMAT_DEFAULT;
		}

		return result;

	}
	
	/**
	 * 获取文件改名前缀
	 * @param id_org
	 * @return
	 */
	public static String getSysParamFilePrefix(String id_org) {
		String result = "";
		try {
			result = ParamsetQryUtil.getParaString(id_org,IMrMSysParamConst.SYS_PARAM_MRM_FILE_PREFIX);
		} catch (BizException e) {
			return IMrMSysParamDefaultConst.SYS_PARAM_MRM_FILE_PREFIX_DEFAULT;
		}

		return result;

	}
	
	/**
	 * 获取文件改名序号长度
	 * @param id_org
	 * @return
	 */
	public static String getSysParamNumLength(String id_org) {
		String result = "";
		try {
			result = ParamsetQryUtil.getParaString(id_org,IMrMSysParamConst.SYS_PARAM_MRM_NUM_LENGTH);
		} catch (BizException e) {
			return IMrMSysParamDefaultConst.SYS_PARAM_MRM_NUM_LENGTH_DEFAULT;
		}

		return result;

	}
	
	/**
	 * 获取病案输出水印设置
	 * @param id_org
	 * @return
	 */
	public static String getSysParamWaterMark(String id_org) {
		String result = "";
		try {
			result = ParamsetQryUtil.getParaString(id_org,IMrMSysParamConst.SYS_PARAM_MRM_WATER_MARK);
		} catch (BizException e) {
			return IMrMSysParamDefaultConst.SYS_PARAM_MRM_WATER_MARK_DEFAULT;
		}

		return result;

	}
	
	/**
	 * 是否弹出应收预收金录入
	 * @param id_org
	 * @return
	 */
	public static Boolean getSysParamCheckAdvancePay(String id_org) {
		FBoolean result = FBoolean.TRUE;
		
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org, IMrMSysParamConst.SYS_PARAM_MRM_CHECK_ADVANCE_PAY);
		} catch (BizException e) {
			return IMrMSysParamDefaultConst.SYS_PARAM_MRM_CHECK_ADVANCE_PAY_DEFAULT;
		}
		
		return result.booleanValue();
	}
	
	/**
	 * 未打印病案是否可邮寄确认
	 * @param id_org
	 * @return
	 */
	public static Boolean getSysParamCheckUnprinted(String id_org) {
		FBoolean result = FBoolean.TRUE;
		
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org, IMrMSysParamConst.SYS_PARAM_MRM_CHECK_UNPRINTED);
		} catch (BizException e) {
			return IMrMSysParamDefaultConst.SYS_PARAM_MRM_CHECK_UNPRINTED_DEFAULT;
		}
		
		return result.booleanValue();
	}
	/**
	 * 获取上报数据来源
	 * @param id_org
	 * @return
	 */
	public static int GetSysParamCIMRFP_REPORT_DATA_SRC(String id_org)
	{
		int result = 2;
		try {
			result = ParamsetQryUtil.getParaInt(id_org, IMrSysParamConst.SYS_PARAM_CIMRFP_REPORT_DATA_SRC);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_CIMRFP_REPORT_DATA_SRC_DEFAULT;
		}
		return result;
	}
	/**
	 * 获取首页中西医分类
	 * @param id_org
	 * @return
	 */
	public static int GetSysParamMRM_FP_TYPE(String id_org)
	{
		int result = 0;
		try {
			result = ParamsetQryUtil.getParaInt(id_org, IMrMSysParamConst.SYS_PARAM_MRM_FP_TYPE);
		} catch (BizException e) {
			return IMrMSysParamDefaultConst.SYS_PARAM_MRM_FP_TYPE_DEFAULT;
		}
		return result;
	}
	
	

	/**
	 * 获取病案签收文书状态
	 * @param id_org
	 * @return
	 */
	public static String getMrSignOffStatusParam(String id_org) {
		String result = "";
		try {
			result = ParamsetQryUtil.getParaString(id_org,IMrMSysParamConst.SYS_PARAM_MRM_SIGNOFF_STATUS);
		} catch (BizException e) {
			return result;
		}
		return result;
	}
	
	/**
	 * 获取参数--上报无效诊断编码  
	 * @parpm id_org
	 * @return
	 */
	public static String getMrUselessDiagnoseParam(String id_org){
		String result = "";
		try{
			result = ParamsetQryUtil.getParaString(id_org,IMrMSysParamConst.SYS_PARAM_MRM_USELESS_DIAGNOSE);
		}catch(BizException e){
			return result;
		}
		return result;
	}
	
}
