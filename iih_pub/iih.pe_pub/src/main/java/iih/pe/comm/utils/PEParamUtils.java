package iih.pe.comm.utils;

import iih.bd.utils.ContextUtils;
import iih.pe.comm.constant.IPEParamConst;
import xap.mw.core.data.BizException;
import xap.sys.orgfw.org.i.IOrgConst;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public final class PEParamUtils {

	// 获取是否启用流程控制
	public static boolean isWorkFlowControl() {
		String paramValue = getOrgParamValue(ContextUtils.getOrgId(), IPEParamConst.PE000001);
		return Boolean.parseBoolean(paramValue);
	}

	// 获取临时证件号码的前缀
	public static String codeIdcodePrefix() {
		String paramValue = getOrgParamValue(ContextUtils.getOrgId(), IPEParamConst.PE000007);
		return paramValue;
	}

	// 获取是否收费接口传输汇总金额
	public static boolean isChargeSum() {
		String paramValue = getOrgParamValue(ContextUtils.getOrgId(), IPEParamConst.PE000012);
		return Boolean.parseBoolean(paramValue);
	}

	// 获取体检中心负责人编码或ID
	public static String codePeChief() {
		String paramValue = getOrgParamValue(ContextUtils.getOrgId(), IPEParamConst.PE000013);
		return paramValue;
	}

	// 获取是否收费团体接口传输汇总金额
	public static boolean isChargeSummber() {
		String paramValue = getOrgParamValue(ContextUtils.getOrgId(), IPEParamConst.PE000024);
		return Boolean.parseBoolean(paramValue);	
	}

	// 获取医院体检中心科室编码或ID
	public static String codePeDept() {
		String paramValue = getOrgParamValue(ContextUtils.getOrgId(), IPEParamConst.PE000014);
		return paramValue;
	}

	// 获取HIS收费-体检费-编码或ID
	public static String codePeChargeSum() {
		String paramValue = getOrgParamValue(ContextUtils.getOrgId(), IPEParamConst.PE000015);
		return paramValue;
	}

	// 获取体检中心检验科室编码或ID
	public static String codePeLab() {
		String paramValue = getOrgParamValue(ContextUtils.getOrgId(), IPEParamConst.PE000016);
		return paramValue;
	}
	
	// 体检团体名单导入后直接登记报到
	public static boolean isCorpListReg() {
		String paramValue = getOrgParamValue(ContextUtils.getOrgId(), IPEParamConst.PE000018);
		return Boolean.parseBoolean(paramValue);
	}	

	// 体检科一般项目科室
	public static String getPeNormalDepCode() {
		String paramValue = getOrgParamValue(ContextUtils.getOrgId(), IPEParamConst.PE000019);
		return paramValue;
	}
	
	//体检条码打印方式
	public static String getBarcodeType() {
		String paramValue = getOrgParamValue(ContextUtils.getOrgId(), IPEParamConst.PE000025);
		return paramValue;
	}	

	//体检检验结果回传医院方式
	public static String lisResultType() {
		String paramValue = getOrgParamValue(ContextUtils.getOrgId(), IPEParamConst.PE000027);
		return paramValue;
	}
	
	//检查报告来源
	public static String risResultType() {
		String paramValue = getOrgParamValue(ContextUtils.getOrgId(), IPEParamConst.PE000028);
		return paramValue;
	}
	
	// 体检收费按体检项目还是门诊项目收费
	public static boolean isPeCatCharge() {
		String paramValue = getOrgParamValue(ContextUtils.getOrgId(), IPEParamConst.PE000030);
		return Boolean.parseBoolean(paramValue);
	}
	
	// 体检收费按体检项目还是门诊项目收费
	public static boolean isMultiGroup() {
		String paramValue = getOrgParamValue(ContextUtils.getOrgId(), IPEParamConst.PE000031);
		return Boolean.parseBoolean(paramValue);
	}
	
	// 个人客户预约（含注册）的体检套餐项目中的红色项目是否允许操作
	public static boolean isAllowRedEdit() {
		String paramValue = getOrgParamValue(ContextUtils.getOrgId(), IPEParamConst.PE000038);
		return Boolean.parseBoolean(paramValue);
	}
	
	//是否推送危急值消息
	public static boolean isSendCrisis() {
		String paramValue = getOrgParamValue(ContextUtils.getOrgId(), IPEParamConst.PE000039);
		return Boolean.parseBoolean(paramValue);
	}
	
	//体检项目价格是否采用门诊医嘱参考价格
	public static boolean isOutpatientsPri() {
		String paramValue = getOrgParamValue(ContextUtils.getOrgId(), IPEParamConst.PE000040);
		return Boolean.parseBoolean(paramValue);
	}	
	
	//总检医生站是否开启体检报告发放领取信息记录
	public static boolean isStartGtant() {
		String paramValue = getOrgParamValue(ContextUtils.getOrgId(), IPEParamConst.PE000041);
		return Boolean.parseBoolean(paramValue);
	}
	//体检总检医生站界面报告没有打印的，一周自动提示
	public static boolean isSendPeRptWeekPoints() {
		String paramValue = getOrgParamValue(ContextUtils.getOrgId(), IPEParamConst.PE000042);
		return Boolean.parseBoolean(paramValue);
	}

	//检查申请单号类型
	public static String risApplyNoType() {
		String paramValue = getOrgParamValue(ContextUtils.getOrgId(), IPEParamConst.PE000047);
		return paramValue;
	}

	//体检唯一码前缀
	public static String pecodePrefix() {
		String paramValue = getOrgParamValue(ContextUtils.getOrgId(), IPEParamConst.PE000053);
		return paramValue;
	}
	
	// 体检IE平台消息开关设置
	public static boolean isIEMsgOpen(String MsgID) {
		String paramValue = getOrgParamValue(ContextUtils.getOrgId(), MsgID);
		return Boolean.parseBoolean(paramValue);
	}	

	/* ======================私有方法========================= */
	/**
	 * 获取PC参数
	 * 
	 * @param pcId
	 *            PC的KEY
	 * @param paramCode
	 *            参数编码
	 * @return
	 */
	private static String getPcParamValue(String pcId, String paramCode) {
		return getInstanceParamValue(pcId, paramCode);
	}

	/**
	 * 获取部门参数
	 * 
	 * @param depId
	 *            部门id
	 * @param paramCode
	 *            参数编码
	 * @return
	 */
	private static String getDepParamValue(String depId, String paramCode) {
		return getParamValue(depId, paramCode);
	}

	/**
	 * 获取组织参数
	 * 
	 * @param orgId
	 *            组织id
	 * @param paramCode
	 *            参数编码
	 * @return
	 */
	private static String getOrgParamValue(String orgId, String paramCode) {
		return getParamValue(orgId, paramCode);
	}

	/**
	 * 获取全局参数
	 * 
	 * @param paramCode
	 *            参数编码
	 * @return
	 */
	private static String getGlobalParamValue(String paramCode) {
		return getParamValue(IOrgConst.GLOBEORG, paramCode);
	}

	/**
	 * 获取系统参数
	 * 
	 * @param paramCode
	 *            参数编码
	 * @return
	 */
	private static String getSysParamValue(String paramCode) {
		return getParamValue(IOrgConst.GLOBEORG, paramCode);
	}

	/**
	 * 获取参数
	 * 
	 * @param dataId
	 *            实体ID
	 * @param paramCode
	 *            参数编码
	 * @return
	 */
	private static String getParamValue(String dataId, String paramCode) {
		// 框架提供的方法
		String val = "";
		try {
			val = ParamsetQryUtil.getParaString(dataId, paramCode);
		} catch (BizException e) {
			e.printStackTrace();
		}
		return val;
	}

	/**
	 * 获取参数
	 * 
	 * @param dataId
	 *            实体ID
	 * @param paramCode
	 *            参数编码
	 * @return
	 */
	private static String getInstanceParamValue(String dataId, String paramCode) {
		try {
			return ParamsetQryUtil.getParaStringByInstance(dataId, paramCode);
		} catch (BizException e) {
			e.printStackTrace();
		}
		return null;
	}
}
