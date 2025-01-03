package iih.sc.comm;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.orgfw.org.i.IOrgConst;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 参数帮助类
 *
 * @author yankan
 *
 */
public class ScParamUtils {
	// 门诊
	private static final String KEY_SC_LOCK_TYPE = "SC0340";//占用号源加锁类型
	private static final String KEY_SC_LOCK_DISTRIBUTED_TIME = "SC0350";//占用号源使用分布式锁等待时间（毫秒）
	private static final String KEY_SC_LOCK_VALIDITY_MIN = "SC0330";//排班锁有效期（分钟）
	private static final String KEY_EN_TAKEAPT_DAYS = "ENOP0071";//门诊预约取号默认取号天数(单位:天)
	private static final String KEY_EN_PC_MG_DEPIDS = "ENPC1010";// PC管理的所有科室的排班
	private static final String KEY_APT_NEEDCFM = "SC0020";// 预约需要确认
	private static final String KEY_EN_REG_SRGGEST_NUM = "ENOP0060";// 推荐号源数
	private static final String KEY_OP_SCH_HOSPITAL = "SCAU0003";// 全院医技排班权限
	private static final String KEY_EN_OP_REG_MVEL = "en_op_reg_mvel";// 是否调用挂号规则引擎
	private static final String KEY_SC_NOTE_EXCL_CHLTP = "SC0060";// 预约无需短信通知的渠道类型
	private static final String KEY_SC_GCVIP_NOTE_TEL = "SC0080";// 绿色通道预约通知电话-预约中心负责人电话
	private static final String KEY_SC_NOTE_RTN_DEPIDS = "SC0090";// 需短信通知复诊的科室ID
	private static final String KEY_EN_IDEMP_SYS = "ENTH0020";// 系统对应的员工ID
	// add by zhengcm 2017-12-19
	private static final String EN_OP_MAX_DI_PERIODM = "ENOP0080";// 门诊医生接诊最大时长
	private static final String KEY_IDSCSRV_NOOPSCH = "SC0111";//非门诊排班的排班服务id
	private static final String KEY_EN_OP_USEDEPSCH = "ENOP0300";//有排班医生是否可以使用科室普通号
	private static final String KEY_SC_PL_CODE_AUTOCREATE = "SC0280";//门诊排班计划 是否自生成编码 add by yaohl
	//口腔医学门诊
	private static final String KEY_DEP_HOSPITAL_ORAL = "SC0070";//口腔医学门诊 参数编码
	// 急诊
	private static final String KEY_JZ_SCH_HOSPITAL = "SCAU0010";// 全院急诊排班权限
	// 医技
	private static final String KEY_MT_SCH_HOSPITAL = "SCAU0004";// 全院医技排班权限
	private static final String KEY_OT_SCH_HOSPITAL = "SCAU0017";// 全院手术排班权限
	private static final String SC_APT_CHK_OBS_ITM = "SC0030"; // 医技预约检查项目类型
	private static final String SC_APT_MT_CHK_FEE = "SC0035";// 医技预约费用检查
	private static final String KEY_SC_OBSAPT_SRVTPS = "SC0120";// 医技预约可预约的医嘱类型
	//预约
	private static final String KEY_SC_SYS_APTUSEMPCIRCLE = "SC1000";//预约时是否调用闭环
	//手术预约前是否需要临床科室确认 SC0300 组织参数
	private static final String KEY_SC_OPT_DEP_APPROVE = "SC0300";

	// 住院预约
	private static final String KEY_IPNT_VALID_DAYAS = "ENIP0050";// 入院通知的那有效时间
	private static final String SC_APT_IP_HOSPITAL = "SCAU0005";// 住院预约--全院预约权限
	private static final String SC_IP_MAXDAYS_WAIT = "SC0040";// 住院预约--最大等待时间
	private static final String SC_IP_MAXHOURS_OCCP_BED = "SC0041";// 住院预约--最大占床时间
	private static final String SC_MAX_DAY_OBS_EXCLU = "SC0100";// 最大互斥间隔天数
	private static final String SC_OP_RECYCLE_DAYS = "SC0050";// 门诊号源回收天数
	private static final String SC_WGTP_USEBED = "SC0180";//住院预约中分配床位的医疗组类型

	public static final String ENPC_APTNOTE_PRINTER = "SCPC1000";// 预约条打印机

	public static final String SCPC_PRINTER_MTAPPLY = "SCPC1001";// 医技条码打印机

	public static final String SCPC_LOOK_LAST_DATE_SCH = "SCPC1002";// 排班显示最后排班日期
	// add by zhengcm 2018-01-29
	public static final String SC_NOTE_NEED_SEND_MSG = "SC0061";// 预约是否需要IIH发短信

	public static final String SC_CANC_APT_NEED_SEND_MSG = "SC0062";// 取消预约是否需要IIH发短信

	public static final String KEY_EN_BED_HAS_SEX = "EN000070";// 床位显示性别,1-床位区分性别0-床位不区分性别，默认为1

	// add by zhengcm 2018-04-17
	public static final String KEY_SC_BROKEN_TP = "SC0210";// 预约挂号爽约控制方式

	private static final String KEY_SC_MAXDAYS_APTCFM = "SC0230";//医技预约最大确认天数

	//yu.b 20-08-07
	private static final String CI_OR_SIGN_CFM = "CIOR0821";//住院医技预约触发点

	/*-----------------门诊参数-----------------------------*/
	private static final String KEY_SC_PSN_APT = "SCAU0001";// 医生选号预约权限

	private static final String KEY_SC_PSN_CANCLE_APT = "SCAU0002";// 医生退约权限
	// 医技预约时是否同步CHIS医技申请单信息
	private static final String SC_MT_SYNC_CHIS = "SC0270";

	//医技预约确认权限
	private static final String SC_MTAPT_CFM = "SCAU0100";

	// 医技预约时是否判断实际时间点
	private static final String SC_MT_APT_CHK_NOWTIME = "SC0275";

	// 门诊保留sc_tick时长
	private static final String SC_SCP_OP_SAVE_SCTICK = "SC0360";
	// 医技保留sc_tick时长
	private static final String SC_SCP_MT_SAVE_SCTICK = "SC0370";
	// 手术保留sc_tick时长
	private static final String SC_SCP_OPT_SAVE_SCTICK = "SC0380";
	// 其他保留sc_tick时长
	private static final String SC_SCP_OTHER_SAVE_SCTICK = "SC0390";

	// 医技预约自动预约渠道配置
	private static final String  SC_MT_AUTO_APT_CHL = "SC0400";

	/**
	 * 获取占用号源加锁类型
	 *
	 * @return
	 */
	public static String getScLockType(){
		return getOrgParamValue(ScContextUtils.getOrgId(), KEY_SC_LOCK_TYPE);
	}

	/**
	 * 获取占用号源使用分布式锁等待时间（毫秒）
	 *
	 * @return
	 */
	public static int getScLockDistributedTime(){
		String paramValue = getOrgParamValue(ScContextUtils.getOrgId(), KEY_SC_LOCK_DISTRIBUTED_TIME);
		return Integer.parseInt(paramValue);
	}

	/**
	 * 排班锁有效期(单位:分钟)
	 * @author  FANLQ
	 * @return
	 */
	public static Integer getScLockValidityMin(){
	    String paramValue = getOrgParamValue(ScContextUtils.getOrgId(), KEY_SC_LOCK_VALIDITY_MIN);
		return Integer.parseInt(paramValue);
	}
		/**
	 * 获取口腔医学门诊的科室id集合
	 * @return
	 */
	public static String getParamOral(){
		String paramValue  = getParamValue(ScContextUtils.getOrgId(),KEY_DEP_HOSPITAL_ORAL);
		return null;
	}
	/**
	 * 门诊预约取号默认取号天数(单位:天)
	 * @author  FANLQ
	 * @return
	 */
	public static Integer getEnTakeAptDays(){
	    String paramValue = getOrgParamValue(ScContextUtils.getOrgId(), KEY_EN_TAKEAPT_DAYS);
		return Integer.parseInt(paramValue);
	}
	/**
	 * 门诊排班计划是否自动生成计划编码
	 * @author  yhl
	 * @return
	 */
	public static Boolean canAutoCreatePlCode(){
	    String paramValue = getParamValue(ScContextUtils.getOrgId(), KEY_SC_PL_CODE_AUTOCREATE);
		return Boolean.parseBoolean(paramValue);
	}
	/**
	 * 获取医生是否有选号预约权限
	 * @author yzh
	 * @return
	 */
	public static Boolean canPsnApt(){
		String paramValue = getParamValue(ScContextUtils.getPsnId(), KEY_SC_PSN_APT);
		return Boolean.parseBoolean(paramValue);
	}
	/**
	 * 获取医生是否有退约权限
	 * @author yzh
	 * @return
	 */
	public static Boolean canPsnCancleApt(){
		String paramValue = getParamValue(ScContextUtils.getPsnId(), KEY_SC_PSN_CANCLE_APT);
		return Boolean.parseBoolean(paramValue);
	}
	/**
	 * 获取医生是否有医技预约确认权限
	 * @author yzh
	 * @return
	 */
	public static Boolean canMtAptCfm(){
		String paramValue = getParamValue(ScContextUtils.getPsnId(), SC_MTAPT_CFM);
		return Boolean.parseBoolean(paramValue);
	}
	/**
	 * 获取非门诊排班的排班服务id
	 *
	 * @return
	 */
	public static String getScSrvIdsNoOpSch(){
		String paramValue = getOrgParamValue(ScContextUtils.getOrgId(), KEY_IDSCSRV_NOOPSCH);
		return paramValue;
	}

	/**
	 * 获取预约无需短信通知的渠道类型
	 *
	 * @param orgId
	 *            组织ID
	 * @return 渠道类型，用逗号分隔
	 * @author fanlq -2017-09-11
	 */
	public static String getNoteExclChlTp(String orgId) {
		String paramValue = getOrgParamValue(orgId, KEY_SC_NOTE_EXCL_CHLTP);
		return paramValue;
	}

	/**
	 * 是否有全院门诊排班权限
	 *
	 * @return
	 */
	public static Boolean getOPSchHosAuth() {
		String paramValue = getParamValue(ScContextUtils.getPsnId(), KEY_OP_SCH_HOSPITAL);
		return Boolean.parseBoolean(paramValue);
	}

	/**
	 * 是否有全院急诊排班权限
	 *
	 * @return
	 */
	public static Boolean getJZSchHosAuth() {
		String paramValue = getParamValue(ScContextUtils.getPsnId(), KEY_JZ_SCH_HOSPITAL);
		return Boolean.parseBoolean(paramValue);
	}

	/**
	 * Pc可挂号的科室
	 *
	 * @param pcId
	 *            计算机ID
	 * @return
	 */
	public static String getPcAvlRegDepIds(String pcId) {
		String paramValue = getPcParamValue(pcId, KEY_EN_PC_MG_DEPIDS);
		return paramValue;
	}

	/**
	 * 获取全局参数:挂号规则引擎是否调用
	 *
	 * @return
	 */
	public static Boolean getEnOpRegMvel() {
		String paramVal = getOrgParamValue(ScContextUtils.getOrgId(), KEY_EN_OP_REG_MVEL);
		return Boolean.parseBoolean(paramVal);
	}

	/**
	 * 获取预约是否确认
	 *
	 * @return
	 */
	public static Boolean getAptNeedCfm() {
		String paramValue = getOrgParamValue(ScContextUtils.getOrgId(), KEY_APT_NEEDCFM);
		return Boolean.parseBoolean(paramValue);
	}

	/**
	 * 获取门诊号源回收天数
	 *
	 * @return 回收天数
	 * @throws BizException
	 */
	public static Integer getOpTickRecycleDays() throws BizException {
		String days = getOrgParamValue(ScContextUtils.getOrgId(), SC_OP_RECYCLE_DAYS);
		return days == null ? 0 : Integer.parseInt(days);
	}

	/**
	 * 获取绿色通道预约通知电话
	 *
	 * @param orgId
	 *            组织ID
	 * @return 电话号码，多个用逗号分隔
	 * @author yank
	 */
	public static String getGcVipNoteTel(String orgId) {
		String paramValue = getOrgParamValue(orgId, KEY_SC_GCVIP_NOTE_TEL);
		return paramValue;
	}

	/**
	 * 获取门诊医生就诊最大时长
	 *
	 * @author zhengcm add 2017-12-19
	 * @date 2017-12-19 11:25:20
	 *
	 * @return
	 */
	public static int getEnOpMaxDiPeriodm() {
		String max = getOrgParamValue(ScContextUtils.getOrgId(), EN_OP_MAX_DI_PERIODM);
		return max == null ? 0 : Integer.parseInt(max);
	}

	/**
	 * 有排班医生是否可以使用科室普通号
	 *
	 * @return
	 */
	public static boolean isUseDeptSch(String depId){
		String param = getDepParamValue(depId, KEY_EN_OP_USEDEPSCH);
		return Boolean.parseBoolean(param);
	}
	/*-----------------医技参数-----------------------------*/

	/**
	 * 获取最大确认天数
	 *
	 * @author liubin
	 *
	 * @param depId
	 * @return
	 * @throws BizException
	 */
	public static int getMaxDaysAptCfm(String depId) throws BizException{
		String maxDay = getDepParamValue(depId, SC_APT_CHK_OBS_ITM);
		if (StringUtil.isEmpty(maxDay)) {
			throw new BizException(IScMsgConst.SC_MAX_DAY_APTCFM_NOT_EXIST);
		}
		return Integer.parseInt(maxDay);
	}

	/**
	 * 获取是否为医技预约检查项目类型
	 *
	 * @param deptId
	 * @return
	 */
	public static FBoolean getscAptCOI(String deptId) {
		String fbool = getDepParamValue(deptId, SC_APT_CHK_OBS_ITM);
		return new FBoolean(fbool);
	}

	/**
	 * 获取医技预约申请单是否费用检查
	 *
	 * @param deptId
	 * @return
	 * @author zhengcm
	 */
	public static Boolean getScAptMtChkFee(String deptId) {
		String paramValue = getDepParamValue(deptId, SC_APT_MT_CHK_FEE);
		return "1".equals(paramValue);
	}

	/**
	 * 是否有全院医技排班权限
	 *
	 * @return
	 */
	public static Boolean getMtSchHosAuth() {
		String paramValue = getParamValue(ScContextUtils.getPsnId(), KEY_MT_SCH_HOSPITAL);
		return Boolean.parseBoolean(paramValue);
	}
	/**
	 * 是否有全院医技排班权限
	 *
	 * @return
	 */
	public static Boolean getOtSchHosAuth() {
		String paramValue = getParamValue(ScContextUtils.getPsnId(), KEY_OT_SCH_HOSPITAL);
		return Boolean.parseBoolean(paramValue);
	}

	/**
	 * 获取检查最大互斥天数
	 *
	 * @return
	 * @throws BizException
	 */
	public static Integer getExcluMaxDay() throws BizException {
		String maxDay = getOrgParamValue(ScContextUtils.getOrgId(), SC_MAX_DAY_OBS_EXCLU);
		if (StringUtil.isEmpty(maxDay)) {
			throw new BizException(IScMsgConst.SC_MAX_DAY_OBS_EXCLU_NOT_EXIST);
		}
		return Integer.parseInt(maxDay);
	}

	/*-----------------住院参数-----------------------------*/

	/**
	 * 床位显示性别,1-床位区分性别 0-床位不区分性别，默认为1
	 *
	 * @return
	 */
	public static Integer getDepBedSexParam(String id_dep){
		String value = getDepParamValue(id_dep, KEY_EN_BED_HAS_SEX);
		return value == null ? 1 : Integer.parseInt(value);
	}
	/**
	 * 获取入院通知到有效时间
	 *
	 * @return
	 */
	public static Integer getIpntValidTime() {
		String validDays = getOrgParamValue(ScContextUtils.getOrgId(), KEY_IPNT_VALID_DAYAS);
		if (validDays != null) {
			return Integer.parseInt(validDays);
		}
		return null;
	}

	/**
	 * 获取是否可全院预约住院权限
	 *
	 * @return
	 */
	public static Boolean canApptIpHospital() {
		String paramValue = getParamValue(ScContextUtils.getPsnId(), SC_APT_IP_HOSPITAL);
		return Boolean.parseBoolean(paramValue);
	}

	/**
	 * 获取最大等待时间
	 *
	 * @return
	 */
	public static Integer canScIpMaxDaysWait() {
		String maxDaysWait = getOrgParamValue(ScContextUtils.getOrgId(), SC_IP_MAXDAYS_WAIT);
		if (StringUtils.isNotBlank(maxDaysWait)) {
			return Integer.parseInt(maxDaysWait);
		}
		return null;
	}

	/**
	 * 获取最大占床时间
	 *
	 * @return
	 */
	public static Integer canScIpMaxhoursOccpBed() {
		String maxHoursOccpBed = getOrgParamValue(ScContextUtils.getOrgId(), SC_IP_MAXHOURS_OCCP_BED);
		if (StringUtils.isNotBlank(maxHoursOccpBed)) {
			return Integer.parseInt(maxHoursOccpBed);
		}
		return null;
	}

	/**
	 * 号源推荐数wjy
	 *
	 * @return
	 */
	public static Integer getSuggestNum() {
		String paramValue = getOrgParamValue(ScContextUtils.getOrgId(), KEY_EN_REG_SRGGEST_NUM);
		if (paramValue != null) {
			return Integer.parseInt(paramValue);
		}
		return null;
	}

	/**
	 * 获取系统对应员工ID
	 *
	 * @author zhengcm
	 *
	 * @return
	 */
	public static String getSysEmpId() {
		return getOrgParamValue(ScContextUtils.getOrgId(), KEY_EN_IDEMP_SYS);
	}

	/**
	 * 医技预约可预约的医嘱类型
	 *
	 * @author zhengcm
	 *
	 * @return
	 */
	public static String getObsAptSrvtps() {
		return getOrgParamValue(ScContextUtils.getOrgId(), KEY_SC_OBSAPT_SRVTPS);
	}

	/**
	 * 获取预约条打印机
	 *
	 * @author zhengcm
	 *
	 * @param pcId
	 * @return
	 */
	public static String getAptNotePrinter(String pcId) {
		String paramValue = getPcParamValue(pcId, ENPC_APTNOTE_PRINTER);
		return paramValue;
	}
	/**
	 * 获取条码打印机
	 *
	 * @author fanlq
	 *
	 * @param pcId
	 * @return
	 */
	public static String getMtApplyPrinter(String pcId) {
		String paramValue = getPcParamValue(pcId, SCPC_PRINTER_MTAPPLY);
		return paramValue;
	}
	/**
	 * 排班是否显示最后排班日期
	 * @author yaohl
	 * @return
	 * @throws BizException
	 */
	public static Boolean getScSchMaxDates() throws BizException{
		String pcId = ScContextUtils.getRealPcId();
		String paramValue = getPcParamValue(pcId, SCPC_LOOK_LAST_DATE_SCH);
		if("true".equals(paramValue)){
			return true;
		}
		return false;
	}
	/**
	 * 获取预约是否需要IIH发短信 add by zhengcm 2018-01-29
	 *
	 * @author zhengcm
	 *
	 * @param deptId
	 * @return
	 */
	public static Boolean getNeedSendMsg(String deptId) {
		String paramValue = getOrgParamValue(deptId, SC_NOTE_NEED_SEND_MSG);
		return Boolean.parseBoolean(paramValue);
	}
	/**
	 * 获取取消预约是否需要IIH发短信 add by yzh 2019-08-05
	 *
	 * @author yzh
	 *
	 * @param deptId
	 * @return
	 */
	public static Boolean getCancAptNeedSendMsg(String deptId) {
		String paramValue = getOrgParamValue(deptId, SC_CANC_APT_NEED_SEND_MSG);
		return Boolean.parseBoolean(paramValue);
	}
	/**
	 * 获取预约挂号爽约控制方式
	 *
	 * @author zhengcm
	 *
	 * @param orgId
	 * @return
	 */
	public static Integer getScBrokenTp(String orgId) {
		String paramValue = getOrgParamValue(orgId, KEY_SC_BROKEN_TP);
		if (paramValue != null) {
			return Integer.parseInt(paramValue);
		}
		return null;
	}

	/**
	 * 门诊保留sc_tick时长
	 *
	 * @author li.wm
	 *
	 * @param orgId
	 * @return
	 */
	public static Integer getScScpOpDuration(String orgId) {
		String paramValue = getOrgParamValue(orgId, SC_SCP_OP_SAVE_SCTICK);
		if (paramValue != null) {
			return Integer.parseInt(paramValue);
		}

		return null;
	}
	/**
	 * 医技保留sc_tick时长
	 *
	 * @author li.wm
	 *
	 * @param orgId
	 * @return
	 */
	public static Integer getScScpMtDuration(String orgId) {
		String paramValue = getOrgParamValue(orgId, SC_SCP_MT_SAVE_SCTICK);
		if (paramValue != null) {
			return Integer.parseInt(paramValue);
		}
		return null;
	}
	/**
	 * 手术保留sc_tick时长
	 *
	 * @author li.wm
	 *
	 * @param orgId
	 * @return
	 */
	public static Integer getScScpOptDuration(String orgId) {
		String paramValue = getOrgParamValue(orgId, SC_SCP_OPT_SAVE_SCTICK);
		if (paramValue != null) {
			return Integer.parseInt(paramValue);
		}
		return null;
	}
	/**
	 * 其他保留sc_tick时长
	 *
	 * @author li.wm
	 *
	 * @param orgId
	 * @return
	 */
	public static Integer getScScpOtherDuration(String orgId) {
		String paramValue = getOrgParamValue(orgId, SC_SCP_OTHER_SAVE_SCTICK);
		if (paramValue != null) {
			return Integer.parseInt(paramValue);
		}
		return null;
	}

	// -----------------------私有方法-------------------------------//
	/**
	 * 获取参数的值
	 *
	 * @param paramCode
	 *            参数编码
	 * @return
	 * @throws BizException
	 */
	private static String getParamValue(String paramCode) {
		// 框架提供的方法
		String val = getOrgParamValue(IOrgConst.GLOBEORG, paramCode);
		return val;
	}

	/**
	 * 获取医技预约自动预约渠道配置
	 *
	 * @param deptId
	 * @return
	 * @author yzh
	 */
	public static String getScMtAutoAptChl(String deptId) {
		String paramValue = getDepParamValue(deptId, SC_MT_AUTO_APT_CHL);
		return paramValue;
	}

	/**
	 * 获取PC参数 获取方法中，如果没有设置参数，则会抛异常，其实没设置也属于正常业务，所以吃掉异常
	 *
	 * @param pcId
	 *            PC的KEY
	 * @param paramCode
	 *            参数编码
	 * @return
	 */
	private static String getPcParamValue(String pcId, String paramCode) {
		try {
			return ParamsetQryUtil.getParaStringByInstance(pcId, paramCode);
		} catch (BizException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取组织参数 获取方法中，如果没有设置参数，则会抛异常，其实没设置也属于正常业务，所以吃掉异常
	 *
	 * @param orgId
	 *            组织id
	 * @param paramCode
	 *            参数编码
	 * @return
	 */
	private static String getOrgParamValue(String orgId, String paramCode) {
		String val = "";
		try {
			val = ParamsetQryUtil.getParaString(orgId, paramCode);
		} catch (BizException e) {
			e.printStackTrace();
		}
		return val;
	}

	/**
	 * 获取部门参数
	 *
	 * @param depId 部门id
	 * @param paramCode 参数编码
	 * @return
	 */
	private static String getDepParamValue(String depId, String paramCode) {
		// 框架提供的方法
		String val = "";
		try {
			val = ParamsetQryUtil.getParaString(depId, paramCode);
		} catch (BizException e) {
			e.printStackTrace();
		}
		return val;
	}

	/**
	 * 获取参数 获取方法中，如果没有设置参数，则会抛异常，其实没设置也属于正常业务，所以吃掉异常
	 *
	 * @param dataId
	 * @param paramCode
	 * @return
	 */
	private static String getParamValue(String dataId, String paramCode) {
		// 框架提供的方法
		String val = "";
		try {
			val = ParamsetQryUtil.getParaStringByInstance(dataId, paramCode);
		} catch (BizException e) {
			e.printStackTrace();
		}
		return val;
	}
	/**
	 * 获取预约时是否调用闭环参数
	 * @author yzh
	 * @return 0-不调用 1-调用
	 * @throws BizException
	 */
	public static Integer getScSysAptUseMpCircle() throws BizException {
		String param = getOrgParamValue(ScContextUtils.getOrgId(), KEY_SC_SYS_APTUSEMPCIRCLE);
		return Integer.parseInt(param);
	}
	/**
	 * 获取手术预约前是否需要临床科室确认参数
	 * @return
	 * @throws BizException
	 */
	public static Boolean getScOptDepApprove() throws BizException {
		String param = getOrgParamValue(ScContextUtils.getOrgId(), KEY_SC_OPT_DEP_APPROVE);
		return Boolean.parseBoolean(param);
	}
	/**
	 * 获取医技预约时是否同步chis医技申请参数
	 *
	 * @return
	 */
	public static FBoolean getscMtSyncChis() {
		String fbool =getDepParamValue(ScContextUtils.getDeptId(), SC_MT_SYNC_CHIS);
		return new FBoolean(fbool);
	}

	/**
	 * 医技预约时是否判断实际时间点参数
	 *
	 * @return
	 */
	public static FBoolean getscMtAptChkNowTime() {
		String fbool =getDepParamValue(ScContextUtils.getDeptId(), SC_MT_APT_CHK_NOWTIME);
		return new FBoolean(fbool);
	}

	/**
	 * 住院医技预约触发点CIOR0281
	 * 
	 * @author yu.b 20-08-07
	 *
	 * @param orgId
	 * @return
	 */
	public static String getCiOrSignCfm(String orgId) {
		String paramValue = getOrgParamValue(orgId, CI_OR_SIGN_CFM);
		return paramValue;
	}
}
