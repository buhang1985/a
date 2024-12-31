package iih.bd.bc.udi.pub;

/**
 * 付款策略 BD.PP
 */
public interface IBdPpCodeTypeConst {

	/**
	 * 票据类型 的Sd值及其对应的Id值
	 */
	public static final String SD_OUTPATIENT_INVOICE = "11"; // 门诊发票
	public static final String SD_INHOS_INVOICE = "12"; // 住院发票
	public static final String SD_OUTREGISTER_INVIOCE = "13";// 门诊挂号发票
	public static final String SD_OUTPATIENT_DEPOSIT = "21"; // 门诊押金条
	public static final String SD_INHOS_DEPOSIT = "22"; // 住院押金条
	public static final String SD_DESIGNED_FUND = "23"; // 优惠套餐收据
    public static final String CODE_ET_INVOICE = "25"; // 急诊留观押金条

	public static final String ID_OUTPATIENT_INVOICE = "@@@@AA1000000001SHRD"; // 门诊发票
	public static final String ID_INHOS_INVOICE = "@@@@AA1000000001SHRE"; // 住院发票
	public static final String ID_OUTREGISTER_INVIOCE = "@@@@AA1000000001SHRN";// 门诊挂号发票
	public static final String ID_OUTPATIENT_DEPOSIT = "@@@@AA1000000001SHRF"; // 门诊押金条
	public static final String ID_INHOS_DEPOSIT = "@@@@AA1000000001SHRG"; // 住院押金条
	public static final String ID_DESIGNED_FUND = "@@@@AA1000000007H9P0"; // 优惠套餐收据
    public static final String ID_ET_INVOICE = "@@@@AA1000000001SHRM";// 急诊留观押金条

	/**
	 * 分票条件
	 */
	public static final String SD_SPLIT_CASE_DEPTOR = "01";// 开单科室
	public static final String SD_SPLIT_CASE_DEPTMP = "02";// 执行科室
	public static final String SD_SPLIT_CASE_DOCTOR = "03";// 开单医生
	public static final String SD_SPLIT_CASE_ENTIMES = "04";// 就诊次数
	public static final String SD_SPLIT_CASE_SHEET = "05";// 单据
	public static final String SD_SPLIT_CASE_ORDER = "06";// 医嘱

	/**
	 * 票据显示项目
	 */
	public static final String SD_DISPTP_DETAIL = "01";// 费用明细
	public static final String SD_DISPTP_INCITM = "02";// 票据归类
	public static final String SD_DISPTP_ORDER = "03";// 医嘱
	public static final String SD_DISPTP_ACCOUNT = "04";// 核算分类
	public static final String SD_DISPTP_DETAILORDER = "05";// 费用明细 &医嘱
	public static final String SD_DISPTP_DETAILINCITM = "06";// 费用明细&账单项
	public static final String SD_DISPTP_DETAILINCITMORDER = "07";// 费用明细&账单项&医嘱

	/**
	 * 医保计划目录类型
	 */
	public static final String SD_HPSRVTP = "BD.BL.1020";

	/**
	 * 发票作废原因BL.BL.0555
	 */
	public static final String ID_REFUND = "@@@@AA1000000000EL10";// 退费
	public static final String ID_PRINT_ERROR = "@@@@AA1000000000EL12";// 打印故障
	public static final String ID_BLANK_ERROR = "@@@@AA1000000000ELL8";// 使用前污损
	public static final String ID_OTHER = "@@@@AA1000000000ELL9";// 其它
	public static final String ID_REINC = "@@@@Z8100000003JWCY1";// 拆票

	public static final String SD_REFUND = "01";// 退费
	public static final String SD_PRINT_ERROR = "02";// 打印故障
	public static final String SD_BLANK_ERROR = "03";// 使用前污损
	public static final String SD_OTHER = "09";// 其它
	public static final String SD_REINC = "04";// 拆票

	public static final String DES_REFUND = "退费";// 退费
	public static final String DES_PRINT_ERROR = "打印故障";// 打印故障
	public static final String DES_BLANK_ERROR = "使用前污损";// 使用前污损
	public static final String DES_OTHER = "其它";// 其它
	public static final String DES_REINC = "拆票";// 拆票


	/**
	 * 医保计划ID
	 */
	// public static final String
	// ID_HP_BJ_TOWNANDCOUNTRY_MEDICAL_INSUR="@@@";//海淀区城乡一体
	public static final String ID_HP_BJ_BASIC_MEDICAL_INSUR = "0001AA1000000001871V";// 北京社保
	public static final String SD_HP_BJ = "026";// 北京社保
	// public static final String ID_HP_BJ_SPECIAL_MEDICAL_INSUR =
	// "0001Z7100000000F7M14";//028北京市城镇社保基本医疗保险(特殊病）
	// public static final String ID_HP_BJ_WORK_INJURY_MEDICAL_INSUR =
	// "@@";//北京市城镇社保基本医疗保险(工伤保险）
	public static final String SD_HP_NEUSOFT = "027"; // 安徽东软医保
	/**
	 * 医保计划下险种 TODO 后续应该改为编码而不是ID，yankan,2017-06-22
	 */
	public static final String ID_HP_BJ_KIND_INSUR = "1001Z7100000000VXDWD";// 工伤保险
	public static final String ID_HP_BJ_KIND_BASIC = "1001Z7100000000VU0QG";// 基本医疗保险
	public static final String ID_HP_BJ_KIND_BEAR = "1001Z7100000000VXDWE";// 生育保险
	public static final String ID_HP_BJ_KIND_PUBLIC_EXPENSE = "1001Z7100000000VXDWB";// 公费医疗
	public static final String ID_HP_BJ_KIND_STUDENT = "1001Z7100000000VXDWJ";// 学生儿童大病医疗保险

	public static final String SD_HP_BJ_KIND_ENDOWMENT = "1";// 基本养老保险
	public static final String SD_HP_BJ_KIND_IDLENESS = "2";// 失业保险
	public static final String SD_HP_BJ_KIND_INSUR = "4";// 工伤保险
	public static final String SD_HP_BJ_KIND_BASIC = "3";// 基本医疗保险
	public static final String SD_HP_BJ_KIND_BEAR = "5";// 生育保险
	public static final String SD_HP_BJ_KIND_BUSSINESSENDOWMENT = "6";// 企业补充养老保险
	public static final String SD_HP_BJ_KIND_PUBLIC_EXPENSE = "32";// 公费医疗
	public static final String SD_HP_BJ_KIND_STUDENT = "91";// 学生儿童大病医疗保险
	public static final String SD_HP_BJ_KIND_DEPOSITENDOWMENT = "7";// 个人储蓄性养老保险
	public static final String SD_HP_BJ_KIND_SUPPLEMENTARY = "8";// 预提补充医疗保险
	public static final String SD_HP_BJ_KIND_RETIRESUPPLEMENTARY = "81";// 退休人员统一补充医疗保险
	public static final String SD_HP_BJ_KIND_MEDICALASSISTANCE = "20";// 大额医疗互助
	public static final String SD_HP_BJ_KIND_CIVILSERVANT = "30";// 公务员医疗补助
	public static final String SD_HP_BJ_KIND_RETIREUNIFY = "31";// 离休医疗费统筹
	public static final String SD_HP_BJ_KIND_CHILDSERIOUSDISEASE = "91";// 学生儿童大病医疗保险
	public static final String SD_HP_BJ_KIND_TOWNAGED = "92";// 城镇无保障老年人大病医疗保险
	public static final String SD_HP_BJ_KIND_TOWNBASE = "93";
	public static final String SD_HP_BJ_KIND_LANDLEVYDPERSON = "33";

	/**
	 * 医保目录等级
	 */
	public static final String ID_HP_BJ_ONE = "@@@@AA1000000000MNSF";// 甲类ID
	public static final String ID_HP_BJ_TOW = "@@@@AA1000000000MNSG";// 乙类ID
	public static final String ID_HP_BJ_THREE = "@@@@AA1000000000MNSH";// 丙类ID
	public static final String SD_HP_BJ_ONE = "1";// 甲类
	public static final String SD_HP_BJ_TOW = "2";// 乙类
	public static final String SD_HP_BJ_THREE = "3";// 丙类

	/**
	 * 医保整体开单校验返回的中文提示信息与代码直接的分隔符
	 */
	public static final String CHECK_CIHP_SAVE_DES_CODE_SPLIT = "^";

	/**
	 * 费用模板类型
	 */
	public static final String SD_BTPLTP = "BD.BL.2505";

	/**
	 * 付款方式类型
	 */
	public static final String SD_PMTP = "BD.BL.0510";

	/**
	 * 医保患者来源
	 */
	public static final String SD_HPPATSOURCE = "BD.MHI.0505";

	/**
	 * 入院登记计费项目所属类型
	 */
	public static final String SD_OWTP_ALL = "0";// 全院
	public static final String SD_OWTP_DEP = "1";// 科室

	/**
	 * 付款方式使用场景
	 */
	public static final String SD_PRIPMSCENE = "BD.PP.0520";
	/**
	 * 费用分类
	 */
	public static final String SD_PRITP = "BD.BL.2005";
}
