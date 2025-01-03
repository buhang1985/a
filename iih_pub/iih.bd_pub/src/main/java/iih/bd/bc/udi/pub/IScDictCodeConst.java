package iih.bd.bc.udi.pub;

/**
 * 资源计划与预约模块(IIH.SC)相关的基础数据常量定义。
 */
public interface IScDictCodeConst {

	/**
	 * 预约渠道类型自定义档案id_udidoclist
	 */
	public static final String ID_UDIDOCLIST = "@@@@ZZ2000000000004F";
	public static final String ID_UDIDOCLIST_APT_TAG = "@@@@ZZ200000000000CF"; // 口腔预约状态标签
	public static final String ID_UDIDOCLIST_TICK_REG = "@@@@ZZ200000000000CG"; // 号位保留原因

	/**
	 * 票号模式
	 */
	public static final String SD_TICKMD_TICK = "01"; // 号位模式
	public static final String SD_TICKMD_TICKS = "02"; // 号段模式
	public static final String SD_TICKMD_TIME = "03"; // 时间片模式
	public static final String ID_TICKMD_TICK = "@@@@AA1000000001D8EN"; // 号位模式
	public static final String ID_TICKMD_TICKS = "@@@@AA1000000001D8EO"; // 号位模式
	public static final String ID_TICKMD_TIME = "@@@@Z8100000000PWWWW";// 时间片模式
	public static final String NAME_TICKMD_TICK = "号位"; // 号位模式
	public static final String NAME_TICKMD_TICKS = "号段"; // 号段模式
	public static final String NAME_TICKMD_TIME = "时间片"; // 时间片模式

	/**
	 * 排班调整类型
	 */
	public static final String SCSCH_ADJ_STOP = "01"; // 停诊
	public static final String SCSCH_ADJ_EXCHANGE = "02"; // 互换
	public static final String SCSCH_ADJ_REPLACE = "03"; // 替换
	public static final String SCSCH_ADJ_ADDITIONAL = "04"; // 追加

	/**
	 * 排班规则类型
	 */
	public static final String SCSCH_RULE_EVEN = "0"; // 偶数预约
	public static final String SCSCH_RULE_ODD = "1"; // 奇数预约
	public static final String SCSCH_RULE_SCTICKS = "2"; // 号段预约
	public static final String SCSCH_RULE_TABLE = "4"; // 号表枚举
	public static final String SCSCH_RULE_ALL = "5"; // 全部可预约
	public static final String SCSCH_RULE_PLUG = "9"; // 外挂函数

	/**
	 * 预约状态
	 */
	public static final String SD_APTSTATUS_ORDER = "1"; // 预约
	public static final String SD_APTSTATUS_PAY = "2"; // 支付
	public static final String SD_APTSTATUS_FINISH = "3"; // 完成
	public static final String SD_APTSTATUS_CANCEL = "4"; // 取消
	public static final String SD_APTSTATUS_BEF_CONF = "5";//术前确认
	/**
	 * 预约状态ID
	 */
	public static final String ID_APTSTATUS_ORDER = "@@@@AA10000000025498"; // 预约
	public static final String ID_APTSTATUS_PAY = "@@@@AA10000000025499"; // 支付
	public static final String ID_APTSTATUS_FINISH = "@@@@AA1000000002549A"; // 完成
	public static final String ID_APTSTATUS_CANCEL = "@@@@AA1000000002549B"; // 取消
	public static final String ID_APTSTATUS_BEF_CONF = "@@@@Z8100000000XJ1PQ";//术前确认
	/**
	 * 口腔科预约状态编码
	 */
	public static final String SD_ORAL_APTSTATUS_UNTREATED = "0"; // 未处理
	public static final String SD_ORAL_APTSTATUS_COMFIRM = "1"; // 确认
	public static final String SD_ORAL_APTSTATUS_COMFIRM_CANCEL = "2"; // 确认取消
	public static final String SD_ORAL_APTSTATUS_UNRESPONSE = "3"; // 联系未回应


	/**
	 * 口腔科预约状态主键
	 */
	public static final String ID_ORAL_APTSTATUS_UNTREATED = "@@@@Z7100000000EQTLV"; // 未处理
	public static final String ID_ORAL_APTSTATUS_COMFIRM = "@@@@Z7100000000EQTLW"; // 确认
	public static final String ID_ORAL_APTSTATUS_COMFIRM_CANCEL = "@@@@Z7100000000EQTLX"; // 确认取消
	public static final String ID_ORAL_APTSTATUS_UNRESPONSE = "@@@@Z7100000000EQTLY"; // 联系未回应

	/**
	 * 住院预约状态
	 */
	public static final String SD_APTIP_STATUS_APPLY = "0"; // 申请
	public static final String SD_APTIP_STATUS_ARRANGE = "1"; // 安排
	public static final String SD_APTIP_STATUS_APPROVE = "2"; // 审核通过
	public static final String SD_APTIP_STATUS_REJECT = "3"; // 审核拒绝
	public static final String SD_APTIP_STATUS_INHOS = "4"; // 患者入院

	/**
	 * 预约渠道类型
	 */
	public static final String SD_SCCHLTP_HOSPITAL_ALL = "00"; // 预约中心（医院全部）
	public static final String SD_SCCHLTP_HOSPITAL_WINDOW = "01"; // 医院窗口
	public static final String SD_SCCHLTP_HOSPITAL_ROOM = "02"; // 医院诊间
	public static final String SD_SCCHLTP_HOSPITAL_SELF = "05"; // 医院患者自助
	public static final String SD_SCCHLTP_HOSPITAL_ROOM_DEPT = "04"; // 医院诊间(本科)
	public static final String SD_SCCHLTP_HOSPITAL_Triage = "07"; // 分诊台

	// 患者渠道
	public static final String SD_SCCHLTP_PATIENT_MOBILE = "15"; // 移动端
	public static final String SD_SCCHLTP_PATIENT_WEIXIN = "16"; // 微信
	public static final String SD_SCCHLTP_PATIENT_ZHIFUBAO = "17"; // 支付宝
	public static final String SD_SCCHLTP_PATIENT_WEB = "19"; // 官网

	// 外部渠道
	public static final String SD_SCCHLTP_OUT_AGENT = "21"; // 外部代理
	public static final String SD_SCCHLTP_OUT_AREA = "22"; // 外部区域

	/**
	 * 排班类型
	 */
	public static final String SD_SCTP_OP = "01";// 门诊
	public static final String SD_SCTP_IP = "02";// 住院
	public static final String SD_SCTP_MT = "03";// 医技
	public static final String SD_SCTP_OT = "04";// 手术
	public static final String SD_SCTP_JZ = "05";// 急诊
	public static final String SD_SCTP_TY = "9";//通用

	/**
	 * 排班类型主键
	 */
	public static final String ID_SCTP_OP = "@@@@AA1000000001WFQR";// 门诊
	public static final String ID_SCTP_IP = "@@@@AA1000000001WFQS";// 住院
	public static final String ID_SCTP_MT = "@@@@AA1000000001D8EG";// 医技
	public static final String ID_SCTP_OT = "@@@@AA1000000001D8EH";// 手术
	public static final String ID_SCTP_JZ = "@@@@AA1000000005HXST";// 急诊
	public static final String ID_SCTP_TY = "@@@@Z8100000000NJP2N";//通用

	/**
	 * 资源类型
	 */
	public static final String SD_SCRESTP_DEP = "00";// 部门
	public static final String SD_SCRESTP_EMP = "01";// 人员
	public static final String SD_SCRESTP_BED = "02";// 床位
	public static final String SD_SCRESTP_OT = "03";// 手术台IScDictCodeConst
	public static final String SD_SCRESTP_MT = "04";// 医技辅
	public static final String SD_SCRESTP_WG = "05";// 医疗组

	/**
	 * 门诊预约方式编码
	 */
	public static final String SD_APPTMD_OP_NORMAL = "0"; // 普通预约
	public static final String SD_APPTMD_OP_ROOM = "1"; // 诊间加号

	/**
	 * 门诊预约方式ID
	 */
	public static final String ID_APPTMD_OP_NORMAL = "@@@@AA1000000008XKE1"; // 普通预约
	public static final String ID_APPTMD_OP_ROOM = "@@@@AA1000000008XKE2"; // 诊间加号

	/**
	 * 诊间加号默认从此号开始
	 */
	public static final Integer BASE_ADDQUENO_USED = 1000;

	/**
	 * 报表服务器接口参数key值
	 */
	public static final String REPORT_KEY = "xap.report.connection";

	public static final String EU_USED_NOUSED = "0";// 0-未用 1-使用 2-取消使用
	public static final String EU_USED_USED = "1";// 使用
	public static final String EU_USED_CANCEL_USED = "2";// 取消使用

	/**
	 * 考勤科室权限
	 */
	public static final String SC_TASK_DEPTP_ALL = "0";// 全院
	public static final String SC_TASK_DEPTP_DEP = "1";// 科室

	/**
	 * 口腔科预约患者不良行为类型id
	 */
	public static final String ID_APT_SCORAL_BREAK_BBRTP = "@@@@Z7100000000FF1EJ";// 预约挂号违约
	public static final String ID_REG_NOTICKET_BREAK_BBRTP = "@@@@Z8100000000PWWWK";// 挂号未到诊违约

	/**
	 * 口腔科预约患者不良行为类型编码
	 */
	public static final String SD_APT_SCORAL_BREAK_BBRTP = "00";// 预约挂号违约
	public static final String SD_REG_NOTICKET_BREAK_BBRTP = "04";// 挂号违约
	/**
	 * 编辑模式
	 */
	public static final String EU_EDIT_TP_ORAL = "1";// 专科
	public static final String EU_EDIT_TP_OTHER = "0";// 普通

	/**
	 * 服务的号别类型
	 */
	public static final String SD_SRVTP_EXPRERT = "090101";//专家
	public static final String SD_SRVTP_ORI ="090102";	//普通
	public static final String SD_SRVTP_EM = "090103";//急诊
	public static final String SD_SRVTP_TX = "090104";//特需
	/**
	 * 午别：全部
	 */
	public static final String ID_DAYSLOT_QB = "99999999999999999999";
	public static final String SD_DAYSLOT_QB = "QB";
	public static final String NAME_DAYSLOT_QB = "全部";

	// 排班服务互斥类型 begin
	/**
	 * 排斥禁止
	 */
	public static final String ID_SCSRVEXCLTP_REJECT_PROHIBIT = "@@@@Z8100000000NDD2O";//排斥禁止
	public static final String SD_SCSRVEXCLTP_REJECT_PROHIBIT = "02";
	/**
	 * 排斥提示
	 */
	public static final String ID_SCSRVEXCLTP_REJECT_HINT = "@@@@Z8100000000NDD2N";//排斥提示
	public static final String SD_SCSRVEXCLTP_REJECT_HINT = "01";
	/**
	 * 并行禁止
	 */
	public static final String ID_SCSRVEXCLTP_PARALLEL_PROHIBIT = "@@@@Z8100000000NDLUC";//并行禁止
	public static final String SD_SCSRVEXCLTP_PARALLEL_PROHIBIT = "04";
	/**
	 * 并行提示
	 */
	public static final String ID_SCSRVEXCLTP_PARALLEL_HINT = "@@@@Z8100000000NDLUB";//并行提示
	public static final String SD_SCSRVEXCLTP_PARALLEL_HINT = "03";
	/**
	 * 次数禁止
	 */
	public static final String ID_SCSRVEXCLTP_TIMES_LIMIT = "@@@@Z8100000000NDLUD";//次数禁止
	public static final String SD_SCSRVEXCLTP_TIMES_LIMIT = "10";
	// 排班服务互斥类型 end
	/**
	 * 预约方式
	 */
	public static String SC_AUTO_APT = "02";//自动预约
    public static String SC_CHOICE_APT = "00";//选号预约
    public static String SC_QUICK_APT = "01";//快捷预约----不选号预约
    /**
     * 渠道剩余可预约数量
     */
    public static int SC_CHL_REMAIN = 99;

    /**
     * 门诊医生站预约模式
     */
    public static String CI_NO_SC_APT_MODE = "00";// 不预约
    public static String CI_DIALOG_SC_APT_MODE = "01";// 弹出节点预约
    public static String CI_AUTO_SC_APT_MODE = "02";// 自动预约

    /**
     * 医技预约功能节点编码
     */
    public static String PSN_SC_APT_FUNC_CODE = "43401130";// 医生医技预约
    public static String CENTER_SC_APT_FUNC_CODE = "43401110";// 医技预约中心
    public static String APP_SC_APT_FUNC_CODE = "43401120";// 申请单医技预约

    /**
     * 排班属性类型
     */
    public static String ID_SCHPROPTP_PAT = "@@@@Z8100000000NJ3DD";//患者类型属性
    public static String ID_SCHPROPTP_KINDITM  = "@@@@Z8100000000NJ3DE";//服务类别明细属性
    public static String ID_SCHPROPTP_TICK = "@@@@Z8100000000NJ3DF";//号位指定渠道属性
    public static String ID_SCHPROPTP_IS_RETAIN_TICK = "@@@@Z8100000000NJ3DG";//是否保留号位属性
	/**
	 * 固定时间类型
	 */
    public static String ID_PERIOD_TP_FIX = "@@@@Z8100000000NJ3DH";
    public static String SD_PERIOD_TP_FIX = "1";
	/**
	 * 相对操作时间类型
	 */
    public static String ID_PERIOD_TP_REF_OPT = "@@@@Z8100000000NJ3DI";
    public static String SD_PERIOD_TP_REF_OPT = "2";
    /**
     * 是否计算节假日
     */
    public static String FG_HOLIDAY_EXCL_TRUE = "Y";
    public static String FG_HOLIDAY_EXCL_FALSE = "N";
    /**
     * 医技预约申请单来源编码
     */
    public static String SD_SYS_FROM_IIH = "0";// IIH
    public static String SD_SYS_FROM_CHIS = "1";//CHIS
    public static String SD_SYS_FROM_LOCAL_MANUAL = "2";//本院手工
    public static String SD_SYS_FROM_OUT_MANUAL = "3";//外院手工
    public static String SD_SYS_FROM_OTHER = "4";//其他
    /**
     * 医技预约申请单预约模式
     */
    public static String SD_APTMD_WITH_IIH = "0";//有IIH申请单
    public static String SD_APTMD_WITHOUT_IIH = "1";//无IIH申请单

    public static String S= "S";//秒
    public static String MIN = "MIN";//分
    public static String HR = "HR";//小时
    public static String D = "D";//天
    /**
     * 时间单位
     */
    public static String ID_SECOND = "@@@@Z7100000000E5Q2M";
    public static String SD_SECOND = "S";//秒
    public static String ID_MINUTE = "@@@@Z7100000000E5Q2N";
    public static String SD_MINUTE = "MIN";//分
    public static String ID_HOUR = "@@@@Z7100000000E5Q2O";
    public static String SD_HOUR = "HR";//小时
    public static String ID_DAY = "@@@@Z7100000000E5Q2P";
    public static String SD_DAY = "D";//天

	/**
	 * 预约打印类型
	 */
    // 告知单
    public static String ID_RPTTMPL_NOTE = "@@@@Z8100000000YFFLQ";
    public static String  SD_RPTTMPL_NOTE = "01";
    public static String NAME_RPTTMPL_NOTE = "医技预约告知单";
    // 条码
    public static String ID_RPTTMPL_BAR = "@@@@Z8100000000YFFLR";
    public static String SD_RPTTMPL_BAR = "02";
    public static String NAME_RPTTMPL_BAR = "医技预约条码";

    /**
     * BS024 到检和取消到检消息状态码
     */
    public static String SD_MP_ARY = "51";//到检
    public static String SD_MP_CANC_ARY = "79";//取消到检
	/**
	 * 退约时间类型
	 */
	public static final String DAYSLOT_TP = "0";//按午别设置
	public static final String SCH_TIME_TP = "1";//按排班时间设置

    /**
     * 手术角色
     */
  //手术角色类型
    public static String ID_OP_ROLE_ZDYS = "@@@@AA1000000004IXRX"; //主刀医师
    public static String ID_OP_ROLE_DYZS = "@@@@AA1000000004IXRY"; //第一助手
    public static String ID_OP_ROLE_DEZS = "@@@@AA1000000004IXRZ"; //第二助手
    public static String ID_OP_ROLE_MZYS = "@@@@AA1000000004IXS0"; //麻醉医师
    public static String ID_OP_ROLE_DRMZYS = "@@@@Z8100000000HD18U"; //第二麻醉医师
    public static String ID_OP_ROLE_QXHS = "@@@@Z8100000000HD19E"; //器械护士(洗手)
    public static String ID_OP_ROLE_QXHSE = "@@@@Z8100000000HD19O"; //器械护士二
    public static String ID_OP_ROLE_XHHS = "@@@@Z8100000000HD19T"; //巡回护士
    public static String ID_OP_ROLE_XHHSE = "@@@@Z8100000000HD19Y"; //巡回护士二
    public static String ID_OP_ROLE_DSZS = "@@@@LL100000000497F5";//第三助手
    public static String ID_OP_ROLE_JS = "@@@@LL100000000497FF";//接送
    public static String ID_OP_ROLE_CG = "@@@@LL100000000497FJ";//参观

    public static String SD_OP_ROLE_ZDYS = "00"; //主刀医师
    public static String SD_OP_ROLE_DYZS = "01"; //第一助手
    public static String SD_OP_ROLE_DEZS = "02"; //第二助手
    public static String SD_OP_ROLE_MZYS = "03"; //麻醉医师
    public static String SD_OP_ROLE_DRMZYS = "04"; //第二麻醉医师
    public static String SD_OP_ROLE_QXHS = "05"; //器械护士(洗手)
    public static String SD_OP_ROLE_QXHSE = "06"; //器械护士二
    public static String SD_OP_ROLE_XHHS = "07"; //巡回护士
    public static String SD_OP_ROLE_XHHSE = "08"; //巡回护士二
    public static String SD_OP_ROLE_DSZS = "09"; //第三助手
    public static String SD_OP_ROLE_JS = "10"; //接送
    public static String SD_OP_ROLE_CG = "11"; //参观

    /**
     * 预约操作来源
     */
    public static String SC_APT_OPERATE = "0";//预约操作
    public static String SC_CANC_APT_OPERATE = "1";//退约操作
    public static String SC_CHANGE_APT_OPERATE = "2";//改约操作

	/**
	 * 退约操作类型0-正常退约 1-限制退约 2-爽约
	 */
    public static final String SC_CANC_APT_NORM = "0";//正常退约
    public static final String SC_CANC_APT_LIMIT = "1";//限制退约
    public static final String SC_CANC_APT_BREAK = "2";//爽约

    /**
	 * 退号释放规则
	 *
	 */
	public static final String SC_CANC_RULE_RELEASE = "01";//退号后，释放原号，可以再次使用
	public static final String SC_CANC_RULE_SUPPLY = "02";//退号后，作废原号位，并补充一个号，可使用补充号
	public static final String SC_CANC_RULE_USED = "03";//退号后，不释放原号位，原号不可再次被使用
	public static final String SC_CANC_RULE_PAST = "04";//退号后，不释放原号位，原号位设置成过期状态

	/**
	 * 人员工作类型
	 */
	public static final String ID_EMP_WORKTYPE_LC = "@@@@AA1000000000SMV5";//临床
	public static final String ID_EMP_WORKTYPE_HL = "@@@@AA1000000000SMV6";//护理

	public static final String SD_EMP_WORKTYPE_LC = "01";//临床
	public static final String SD_EMP_WORKTYPE_HL = "02";//护理

	/**
	 * 科室手术确认
	 */
	public static final String SC_OPT_APT_CONFIRM = "confirm";
	/**
	 * 科室手术取消确认
	 */
	public static final String SC_OPT_APT_CANC_CONFIRM = "canc";
	/**
	 * 医技预约规则操作类型
	 */
	public static final String RULE_SC_MT_APT= "0";//预约操作
	public static final String RULE_SC_MT_CANC_APT = "1";//退约操作
	public static final String RULE_SC_MT_CHANGE_APT = "2";//改约操作
	/**
	 * 住院医技预约触发点
	 */
	public static final String CI_OR_MT_SIGN= "0";//医嘱确认
	public static final String CI_OR_MT_CFM = "1";//医嘱签署
}
