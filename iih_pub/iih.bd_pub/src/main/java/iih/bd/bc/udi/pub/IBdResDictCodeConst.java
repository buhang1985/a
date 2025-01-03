package iih.bd.bc.udi.pub;

/**
 * 医院资源(IIH.BD.RES)相关的基础数据常量定义。
 */
public interface IBdResDictCodeConst {

	/**
	 * 床位状态
	 */
	public static final String SD_BEDSU_EMPTY = "0"; // 空床
	public static final String SD_BEDSU_USEDBYPATIENT = "1"; // 患者使用
	public static final String SD_BEDSU_RENT = "2"; // 包床
	public static final String SD_BEDSU_OCCUPYBYIN = "3"; // 入院占用
	public static final String SD_BEDSU_CLEAN = "4"; // 清洁

	/**
	 * 床位状态ID
	 */
	public static final String ID_BEDSU_EMPTY = "@@@@AA1000000000QWE4"; // 空床
	public static final String ID_BEDSU_USEDBYPATIENT = "@@@@AA1000000000QWE5"; // 患者使用
	public static final String ID_BEDSU_RENT = "@@@@AA1000000008RNKL"; // 包床
	public static final String ID_BEDSU_OCCUPYBYIN = "@@@@AA1000000001E5KH"; // 入院占用
	public static final String ID_BEDSU_CLEAN = "@@@@AA1000000008RNKM"; // 清洁

	/**
	 * 床位特征
	 */
	public static final String SD_BEDTP_WINDOW = "10";// 靠窗
	public static final String SD_BEDTP_OXYGEN = "11";// 有供氧通道
	public static final String SD_BEDTP_MONITOR = "12";// 有监控仪
	public static final String SD_BEDTP_LEVEL = "13";// 病床级别
	public static final String SD_BEDTP_SEX = "21";// 床位性别

	/**
	 * 床位特征
	 */
	public static final String ID_BEDTP_WINDOW = "@@@@AA1000000008FO8W";// 靠窗
	public static final String ID_BEDTP_OXYGEN = "@@@@AA1000000008FO8Y";// 有供氧通道
	public static final String ID_BEDTP_MONITOR = "@@@@Z71000000001XIBQ";// 有监控仪
	public static final String ID_BEDTP_LEVEL = "@@@@Z71000000001XIBR";// 病床级别
	public static final String ID_BEDTP_SEX = "@@@@Z71000000001XIBS";// 床位性别

	/**
	 * 床位类型
	 */
	public static final String SD_BEDTYPE_ORI = "01";// 普通
	public static final String SD_BEDTYPE_ADD = "02";// 加床
	public static final String SD_BEDTYPE_VIRTUAL = "03";// 虚床
	public static final String SD_BEDTYPE_MONITOR = "04";// 监护

	/**
	 * 床位类型
	 */
	public static final String ID_BEDTYPE_ORI = "@@@@AA1000000000QWDZ";// 普通
	public static final String ID_BEDTYPE_ADD = "@@@@AA1000000000QWE0";// 加床
	public static final String ID_BEDTYPE_VIRTUAL = "@@@@Z7100000000CXKSX";// 虚床
	public static final String ID_BEDTYPE_MONITOR = "@@@@Z7100000000CXKSY";// 监护

	/**
	 * BD.RES.1025 仓库类型
	 */
	// 药库
	public static final String SD_WHTP_YAOKU = "01";
	// 药房
	public static final String SD_WHTP_YAOFANG = "02";
	// 基数药房
	public static final String SD_WHTP_JISHU = "03";
	// 耗材库
	public static final String SD_WHTP_HAOCAI = "11";
	// 高值耗材库
	public static final String SD_WHTP_HVHAOCAI = "12";

	/**
	 * 科室类型
	 */
	public static final String SD_DEPTTP_CLINICAL = "01";// 临床
	public static final String SD_DEPTTP_NUR = "02";// 护理单元（病区）
	public static final String SD_DEPTTP_MT = "03";// 医技
	public static final String SD_DEPTTP_PHARMACY = "0402";// 药房

	/**
	 * 业务线角色
	 */
	public static final String SD_DEPROLE_DEP = "0100";// 科室/0100 --科室 0101 病区
	public static final String SD_DEPROlE_NUR = "0101";// 病区）

	/**
	 * 部门业务线类型
	 */
	public static final String SD_DEPLTP_DEPNUR = "0106";// 科室/0100 --科室 0101 病区

	/**
	 * 诊断过程标准
	 */

	public static final String SD_DIAG_INHOS = "3";
	public static final String NAME_DIAG_INHOS = "入院诊断";

	/**
	 * 手术台类型sd
	 */
	public static final String SD_OPERATINGTABLE_ORDINARY = "01";// 普通
	public static final String SD_OPERATINGTABLE_COMPLEX = "02";// 综合
	public static final String SD_OPERATINGTABLE_SPECIAL = "03";// 专用

	/**
	 * 手术台类型id
	 */
	public static final String ID_OPERATINGTABLE_ORDINARY = "@@@@AA1000000000QWD8";// 普通
	public static final String ID_OPERATINGTABLE_COMPLEX = "@@@@AA1000000000QWD9";// 综合
	public static final String ID_OPERATINGTABLE_SPECIAL = "@@@@AA1000000000QWDA";// 专用

	/**
	 * 医技辅类型sd
	 * 
	 */
	public static final String SD_MEDTECH_B = "01";// B超
	public static final String SD_MEDTH_RADIATION = "02";// 放射
	public static final String SD_MEDTECH_NMR = "03"; // 核磁
	public static final String SD_MEDTECH_GASTROSCOPY = "04";// 胃镜
	public static final String SD_MEDTECH_COLONOSCOPY = "05";// 肠镜

	/**
	 * 医技辅类型id
	 * 
	 */
	public static final String ID_MEDTECH_B = "@@@@AA1000000000QWE6";// B超
	public static final String ID_MEDTH_RADIATION = "@@@@AA1000000000QWE7";// 放射
	public static final String ID_MEDTECH_NMR = "@@@@AA1000000000QWE8"; // 核磁
	public static final String ID_MEDTECH_GASTROSCOPY = "@@@@AA1000000000QWE9";// 胃镜
	public static final String ID_MEDTECH_COLONOSCOPY = "@@@@AA1000000000QWEA";// 肠镜

	/**
	 * 日期分组分类类型sd
	 */
	public static final String SD_DAYSLOTSORT_OP = "1"; // 门诊
	public static final String SD_DAYSLOTSORT_EM = "2";// 急诊
	public static final String SD_DAYSLOTSORT_MEDTECH = "3";// 医技
	public static final String SD_DAYSLOTSORT_OTHER = "9";// 其他
	/**
	 * 日期分组分类类型id
	 */
	public static final String ID_DAYSLOTSORT_OP = "@@@@Z71000000001X575"; // 门诊
	public static final String ID_DAYSLOTSORT_EM = "@@@@Z71000000001X576";// 急诊
	public static final String ID_DAYSLOTSORT_MEDTECH = "@@@@Z71000000001X577";// 医技
	public static final String ID_DAYSLOTSORT_OTHER = "@@@@Z71000000001X578";// 其他

	/**
	 * 日期分组类型sd
	 */
	public static final String SD_DAYSLOT_MORNING = "01";// 上午
	public static final String SD_DAYSLOT_NOON = "02";// 中午
	public static final String SD_DAYSLOT_AFTERNOON = "03";// 下午
	public static final String SD_DAYSLOT_NIGHT = "04";// 晚上
	public static final String SD_DAYSLOT_DAYSHIFT = "10";// 白班
	public static final String SD_DAYSLOT_NIGHTSHIFT = "12";// 晚班
	public static final String SD_DAYSLOT_ALLDAY = "20";// 全部

	/**
	 * 日期分组类型id
	 */
	public static final String ID_DAYSLOT_MORNING = "@@@@Z71000000001X579";// 上午
	public static final String ID_DAYSLOT_NOON = "@@@@Z71000000001X57A";// 中午
	public static final String ID_DAYSLOT_AFTERNOON = "@@@@Z71000000001X57B";// 下午
	public static final String ID_DAYSLOT_NIGHT = "@@@@Z71000000001X57C";// 晚上
	public static final String ID_DAYSLOT_DAYSHIFT = "@@@@Z71000000001X57D";// 白班
	public static final String ID_DAYSLOT_NIGHTSHIFT = "@@@@Z71000000001X57E";// 晚班
	public static final String ID_DAYSLOT_ALLDAY = "@@@@Z71000000001X57F";// 全部

	/**
	 * 业务组类型
	 */
	public static final String SD_WGTP_CLI = "01";// 临床
	public static final String SD_WGTP_IP = "0101";// 住院
	public static final String SD_WGTP_SPECIAL = "0105";// 专用
	public static final String SD_WGTP_OP = "0110";// 门诊
	public static final String SD_WGTP_OPFEE = "0301";// 门诊费用组
	public static final String SD_WGTP_IPFEE = "0302";// 住院费用组

	/**
	 * 业务组类型
	 */
	public static final String ID_WGTP_CLI = "@@@@AA1000000000ELMF";// 临床
	public static final String ID_WGTP_IP = "@@@@AA1000000000ELMG";// 住院
	public static final String ID_WGTP_SPECIAL = "@@@@Z71000000001XIBP";// 专用
	public static final String ID_WGTP_OP = "@@@@AA10000000087XMH";// 门诊
	public static final String ID_WGTP_OPFEE = "@@@@Z8100000003NGG6C";// 门诊费用组
	public static final String ID_WGTP_IPFEE = "@@@@Z8100000003NGG6D";// 住院费用组

	/**
	 * 人员档案：人员类型
	 */
	public static final String SD_PSN_HUMANTYPT_NURS = "01";// 护理

	/**
	 * 人员档案：人员工作类型
	 */
	public static final String SD_PSN_EMPWKTP_DOCT = "01";// 医生
	public static final String SD_PSN_EMPWKTP_NURS = "02";// 护理
	public static final String SD_PSN_EMPWKTP_TECH = "03";// 医技
	public static final String SD_PSN_EMPWKTP_MEDI = "04";// 医药
	public static final String SD_PSN_EMPWKTP_FINA = "05";// 财务
	public static final String SD_PSN_EMPWKTP_ADMI = "06";// 行政
	public static final String SD_PSN_EMPWKTP_MANA = "07";// 管理
	public static final String SD_PSN_EMPWKTP_OTHER = "99";// 其他

	/**
	 * 人员档案启用状态
	 */
	public static final int SD_PSN_ACTIVESTATE_ENABLE = 2;// 已启用

	/**
	 * 门诊发药模式
	 */
	public static final String SD_DISP_DIRECT = "0";// 直接发药
	public static final String SD_DISP_PREP_HUMAN = "1";// 人工后台摆药
	public static final String SD_DISP_PREP_MACHINE = "2";// 摆药机摆药

	/**
	 * 1007 床位性别限制sd
	 */
	public static final String SD_BEDSEXLIMIT_UNLIMIT = "0";;// 不限制
	public static final String SD_BEDSEXLIMIT_MALE = "1";;// 男
	public static final String SD_BEDSEXLIMIT_FEMALE = "2";;// 女

	/**
	 * 1007 床位性别限制id
	 */
	public static final String ID_BEDSEXLIMIT_UNLIMIT = "@@@@Z8100000000PIXWO";;// 不限制
	public static final String ID_BEDSEXLIMIT_MALE = "@@@@Z8100000000PIXWP";;// 男
	public static final String ID_BEDSEXLIMIT_FEMALE = "@@@@Z8100000000PIXWQ";;// 女

}
