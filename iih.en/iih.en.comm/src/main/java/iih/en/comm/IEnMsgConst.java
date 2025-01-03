package iih.en.comm;

/**
 * 就诊错误信息常量 错误信息一定要明确具体,比如：保存失败；应该：入院通知单保存失败！
 * 
 * @author Administrator
 *
 */
public interface IEnMsgConst {
	// 通用
	public static final String ERROR_NO_UNIQUE = "";
	public static final String ERROR_SV_NOT_EXIST = "版本标识字段不存在，无法校验其版本是否正确！";
	public static final String ERROR_DATA_HAS_MODIFIED = "当前数据已经被修改，请刷新后重试！";

	// 基础数据
	public static final String ERROR_BED_NOT_EXIST = "床位不存在";
	public static final String ERROR_BED_NOT_ACTIVE = "床位未启用，请刷新后重试！";
	public static final String ERROR_BED_HAS_USED = "床位已经被使用";
	public static final String ERROR_DAYSLOT_STARTTIME_NODEFINED = "日期分组开始时间为定义";

	// 不存在系列
	public static final String ERROR_PATID_NOT_EXIST = "未检测到患者ID！";
	public static final String ERROR_PAT_NOT_EXIST = "未检索到患者信息！";
	public static final String ERROR_ENT_NOT_EXIST = "患者就诊信息不存在！";
	public static final String ERROR_ENT_PATID_NOT_EXIST = "就诊表中未存患者信息！";
	public static final String ERROR_DOC_PATID_NOT_EXIST = "建档表中未存患者信息！";
	public static final String ERROR_ENT_NOT_INPATIENT = "该患者未办理入院登记！";
	public static final String ERROR_ENT_NOT_APTIP = "未检索到入院通知单！";
	public static final String ERROR_APTIP_HAS_CHG = "入院通知单状态发生改变，请刷新后重试！";
	public static final String ERROR_ENT_NOT_INPATIENTDO = "该就诊对应的住院信息不存在！";
	public static final String ERROR_ENTP_NOT_ASSIST = "该就诊类型不支持！";

	// 挂号
	public static final String ERROR_OP_REG_WRONG = "挂号失败！";
	public static final String ERROR_OP_REG_PRICE_NOT_EXIST = "划价信息为空";
	public static final String ERROR_OP_REG_REGINFO_IS_NULL = "挂号信息为空！";
	public static final String ERROR_OP_REG_NO_AVAILABLE_TICK = "号源已经用完，没有可用号位！";
	public static final String ERROR_FORMATTER_OP_REG_NO_QUE = "排班资源%s和科室%s，对应的门诊队列不存在，请在“门诊队列维护”中生成队列信息！";
	public static final String ERROR_OP_REG_SETTLE_FAILED = "结算失败";
	public static final String ERROR_OP_REG_SETTLE_FAILED_CGID_IS_NULL = "结算失败,得到结算ID为空！";
	public static final String ERROR_OP_REG_NEWPRICE_CANNOT_ACCOUNT = "新划价方式不支持记账！";
	public static final String ERROR_OP_REG_PRICING_BL_FAILED = "费用划价失败！";
	public static final String ERROR_OP_REG_REGINFO_HAS_NO_RES = "参数挂号信息中号源信息为空！";
	public static final String ERROR_OP_REG_GET_PAYSTYLE = "结算的付款方式获取失败！";
	public static final String ERROR_OP_REG_DATE_BEFORE = "挂号失败，日期早于服务器时间！";
	public static final String ERROR_OP_REG_AFTER_END_REGTIME = "该排班已停止挂号！";

	// 门急诊退号
	public static final String ERROR_OP_OPINFO_NOT_EXISTS = "门诊信息不存在！";
	public static final String ERROR_OP_PVINFO_NOT_EXISTS = "就诊信息不存在！";
	public static final String ERROR_OP_ACPT_CANNOT_CANC = "此号已经就诊，不能退号！";
	public static final String ERROR_OP_REG_HAS_CANCED = "此号已经退了，不能重复退号！";
	public static final String ERROR_OP_SAVE_OP_ERROR = "门诊信息保存失败！";
	public static final String ERROR_OP_CANCREG_NOT_EXIST = "医保分摊信息为空";

	// 状态系列
	public static final String ERROR_ENT_STATUS_INDEPT = "患者已入科！";
	public static final String ERROR_ENT_STATUS_STATUS = "患者状态发生改变，请刷新后重试";
	public static final String ERROR_SD_STATUS_STATUS = "患者已经有申请入院记录正在处理，不可用重复申请！";
	public static final String ERROR_SD_STATUS_INHOS = "患者已经在院!";
	public static final String ERROR_SD_STATUS_INREG = "患者已经办理登记!";

	// 床位信息系列
	public static final String ERROR_BED_STATUS_USED = "床位已经占用，请更换其他床位！";
	public static final String ERROR_BED_STATUS_CHANGED = "床位状态已经改变，请重新选择床位";
	public static final String ERROR_BED_STATUS_APPT = "床位已经预约，请更换其他床位！";
	public static final String ERROR_BED_NOTEXIT = "该病区不存在空床";
	public static final String ERROR_DEP_NOTEXIT = "未获取到病区";
	public static final String ERROR_BED_STATUS_CHANGED2 = "患者床位已经发生变化，请刷新后重试！";
	// 保存抛错系列
	public static final String ERROR_SAVE_WRONG = "保存失败！";
	public static final String ERROR_HASTIMES = " 住院次数重复！请修改";
	public static final String ERROR_ENT_FGINCP = "患者在临床路径中，不能出院！";
	public static final String ERROR_ENT_FGINCP_BB = "婴儿在临床路径中，不能出院！";
	// 节点参数系列
	public static final String EOORO_ENHOSREGINFO_NULL = "入院登记参数或患者信息为空";
	public static final String ERROR_ENHOSREG_NULL = "入院登记参数为空！";
	public static final String ERROR_PREGDOC_NULL = "产科建档参数为空！";
	public static final String ERROR_ENHOSREG_HAS_PREAMT = "预交金不为0，不能取消登记！";
	public static final String ERROR_NOT_ACCCPT_RECALL = "未接收到召回数据！";
	public static final String ERROR_NOT_GET_RECALLBED = "未取到召回床位";
	public static final String ERROR_NOT_BLRECALL = "未选择召回原因！";
	public static final String ERROR_CUSTOMPAT_SQL = "自定义患者列表查询出错，请到患者列表配置重新维护！";
	public static final String ERROR_ENTID_NOT_EXIST = "未取到就诊ID信息！";

	// 门诊分诊
	public static final String ERROR_NO_NOW_DAYSLOT = "未找到当前日期分组！";
	public static final String ERROR_NOT_CORRENT_DAYSLOT = "当前日期分组错误，请刷新界面后重试！";
	public static final String ERROR_TRIAGE_WRONG = "不能分诊到此工作站点！";
	public static final String ERROR_CANCEL_SIGNIN_WRONG = "取消到诊失败！";
	public static final String ERROR_CANCEL_TRIAGE_WRONG = "取消分诊失败！";
	public static final String ERROR_CANCEL_CALL_WRONG = "取消叫号失败！";
	public static final String ERROR_CHANGLEVEL_WRONG = "改变优先级失败！";
	public static final String ERROR_ARRIVE_WRONG = "到诊失败！";

	// 门诊医生接诊
	public static final String ERROR_PASS_NUM = "过号失败！";
	public static final String ERROR_CALL_NUM_FILL = "叫号数量已达到最大申请量！";
	public static final String ERROR_NO_ENT_CALL = "没有新患者可叫号！";
	public static final String ERROR_CALL_WRONG = "叫号失败！";
	public static final String ERROR_CALLNEXT_WRONG = "叫下一个号失败！";
	public static final String ERROR_ACPT_WRONG = "接诊失败！";
	public static final String ERROR_OUT_VALIDITY = "挂号的有效期是%s-%s,不允许接诊!";
	public static final String ERROR_CANC_OUT_VALIDITY = "挂号的有效期是%s-%s,不允许取消接诊!";

	// 取消接诊
	public static final String ERROR_NO_CANCEL_ACPT_OR = "该患者已有医嘱，不能取消接诊！";
	public static final String ERROR_NO_CANCEL_ACPT_DI = "该患者已有诊断，不能取消接诊！";

	// 对外接口系列
	public static final String ERROR_ADDENTDEPX = "跨科处置日期不能交叉重叠,请对应处理!";
	public static final String ERROR_PHARM_NO_QUE = "药房科室未定义队列,请在基础数据->药房队列维护中处理！";

	// 住院系列
	public static final String ERROR_TRANS_FAILED = "转科失败！";
	public static final String ERROR_ACCOUNT_NOT_EXIST = "就诊账户不存在";
	public static final String ERROR_ACC_ENT_AND_ACC_NOT_MATCH = "就诊数量与账户数量不一致，可能有的患者没有就诊账户";

	// 新生儿管理
	public static final String ERROR_NEWBORN_HAS_FEE = "该新生儿存在独立的有效费用，不允许删除！";
	public static final String ERROR_NEWBORN_HAS_ORDER = "该新生儿存在有效医嘱，不允许删除！";
	public static final String ERROR_NEWBORN_HAS_DI = "新生儿存在诊断，不允许删除！";
	public static final String ERROR_NEWBORN_HAS_PAPER = "新生儿存在住院病历，不允许删除！";
	public static final String ERROR_NEWBORN_HAS_SEPA = "新生儿处于母婴分床状态，不允许删除！";

	// 集成平台
	public static final String ERROR_OPREG4IP_LISTENER_NOT_MATCH_EVENT = "门诊挂号监听器与事件源不匹配！";
	public static final String ERROR_LISTENER_NOT_MATCH_EVENT = "监听器与事件源不匹配！";
	public static final String ERROR_LISTENER_NO_SOURCE = "事件源数据不能为空！";
	public static final String ERROR_ENOPQUE_EVENT_TYPE = "事件类型错误";

	// 回收号源
	public static final String ERROR_APT_NOT_EXIST = "没找到对应预约记录!";
	public static final String ERROR_APT_NOT_CANC_CANCED = "该预约已经取消, 不能再次取消预约!";
	public static final String ERROR_APT_NOT_CANC_PAY = "预约已经支付, 不能取消预约!";
	public static final String ERROR_APT_NOT_CANC_FINISH = "预约已经完成, 不能取消预约!";
	public static final String INFO_ACPT_CANC_SUCCESS = "取消预约成功！";

	// 门诊挂号规则引擎提示信息常量（该消息常量对应IEnConst类中的“门诊挂号规则引擎常量”，需要对应匹配使用,且需要在EnAppUtils.getRegMvelMsgForErr()中返回对应消息）
	public static final String EN_REG_AGE_CONST_MSG = "患者大于16周岁，不能挂此号！"; // 年龄规则
	public static final String EN_REG_SEX_MALE_CONST_MSG = "男性患者不能挂此号！"; // 男性规则
	public static final String EN_REG_SEX_FEMALE_CONST_MSG = "女性患者不能挂此号！"; // 女性规则
	public static final String EN_REG_COUNT_CONST_MSG = "不允许在同一天挂多个相同科室大于2个相同服务号！"; // 不允许在同一天挂多个相同科室大于2个相同服务号
	public static final String EN_REG_REPEAT_CONST_MSG = "已存在当前号源的门诊挂号记录！"; // 跨节点校验是否已挂该号
	public static final String SC_APT_REPEAT_CONST_MSG = "已存在当前号源的预约记录！"; // 跨节点校验是否已预约该号
	public static final String EN_REG_DLOT_DEP_CONST_MSG = "同一午别，患者最多可以挂2个科室的号！";
	public static final String IP_IS_EXIST_CONST_MSG = "患者当前为已在院状态，不能执行门诊相关操作！"; // 住院期间不允许挂门诊
	public static final String EN_REG_JOINT_RULE2 = "患者大于14周岁，不能挂此号！！";
	public static final String EN_REG_AGE18_CONST_MSG = "患者大于18周岁，不能挂此号！"; // 年龄规则
	// 入院登记规则引擎提示信息常量（该消息常量对应IEnConst类中的“入院登记规则引擎常量”，需要对应匹配使用,且需要在EnAppUtils.getRegMvelMsgForErr()中返回对应消息）
	public static final String EN_IP_AGE_CONST_MSG = "患者已成年不能登记该科室！"; // 年龄规则
	public static final String EN_IP_SEX_MALE_CONST_MSG = "男性患者不能登记该科室！"; // 男性规则
	public static final String EN_IP_SEX_FEMALE_CONST_MSG = "女性患者不能登记该科室！"; // 女性规则
	
	
	//住院团检系列
	public static final String ERROR_PECMPY_ACCOUNT_NOT_EXIST = "团检账户不存在";

	
}
