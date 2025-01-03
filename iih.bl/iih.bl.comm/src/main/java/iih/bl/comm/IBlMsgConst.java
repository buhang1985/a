package iih.bl.comm;

/**
 * 消息常量
 * 
 * @author yankan
 *
 */
public interface IBlMsgConst {

	// 不存在系列
	public static final String ERROR_PAT_NOT_EXIST = "患者信息不存在！";
	public static final String ERROR_ENT_NOT_EXIST = "就诊信息不存在！";
	public static final String ERROR_EVENT_SOURCE_IS_NULL = "事件源为空";
	public static final String ERROR_PATACC_NOT_EXIST = "患者账户不存在！";
	public static final String ERROR_ENTACC_NOT_EXIST = "就诊账户不存在！";
	public static final String ERROR_INCOEP_NOT_EXIST="未查询到对应的结算发票";

	// 消息
	public static final String ERROR_INVOICE_ALERT = "请先领取票据号！";
	public static final String ERROR_INCISS_JZFP_ALERT = "获取当前票号失败，请在<发票领退管理>界面，查询当前用户是否有急诊留观发票类型的可用票据"; // 检查是否有可用的急诊押金条类型的票据
	public static final String ERROR_INCISS_MZFP_ALERT = "获取当前票号失败，请在<发票领退管理>界面，查询当前用户是否有门诊发票类型的可用票据"; // 检查是否有可用的门诊发票类型的票据
	public static final String ERROR_INCISS_GHFP_ALERT = "获取当前票号失败，请在<发票领退管理>界面，查询当前用户是否有门诊挂号发票类型的可用票据"; // 检查是否有可用的门诊发票类型的票据
	public static final String ERROR_INCISS_ZYFP_ALERT = "获取当前票号失败，请在<发票领退管理>界面，查询当前用户是否有住院发票类型的可用票据"; // 检查是否有可用的住院发票类型的票据
	public static final String ERROR_INCISS_MZYJT_ALERT = "获取当前票号失败，请在<发票领退管理>界面，查询当前用户是否有门诊押金条的可用票据"; // 检查是否有可用的门诊押金条类型的票据
	public static final String ERROR_INCISS_ZYYJT_ALERT = "获取当前票号失败，请在<发票领退管理>界面，查询当前用户是否有住院押金条的可用票据"; // 检查是否有可用的住院押金条类型的票据
	public static final String ERROR_INCISS_ZYK_ALERT = "获取当前票号失败，请在<发票领退管理>界面，查询当前用户是否有专用款类型的可用票据"; // 检查是否有可用的专用款类型的票据
	public static final String ERROR_INCISS_MZGHFP_ALERT = "获取当前票号失败，请在<发票领退管理>界面，查询当前用户是否有门诊发票类型的可用票据"; // 检查是否有可用的门诊发票类型的票据
	public static final String ERROR_INCISS_NOT_ENOUGH = "当前发票包发票数量不足，请更换发票包";
	public static final String ERROR_INCISS_LOCK_ALERT = "票据加锁失败，其他用户正在处理，请刷新重试";
	public static final String ERROR_INCISS_NOPC_ALERT = "获取当前票号失败，未查询到计算机信息";
	
	public static final String ERROR_CHECK_INCSRCTP_ALERT = "该发票号不是挂号发票，请重新输入票号"; // 检查某个发票号对应的费用来源是否是挂号发票
	public static final String ERROR_INCOEP_CC_OUT="该发票已经结账，不能再补打发票";
	
	// 事件
	public static final String ERROR_LISTENER_NOT_MATCH_EVENT = "监听器与事件源不匹配！";

	// 医保签到及签退
	public static final String SIGNIN_LENGTH_ERROR = "当前用户有多条签到数据，请及时联系管理员！";
	public static final String SIGNIN_INSERT_ERROR = "当前用户已经存在签到记录，请先签退后重新签到！";
	//医保依赖性校验
	public static final String ERROR_DEPEND= "不能删除全部诊断！";
	
	public static final  String FG_SUCESS = "0"; //成功
	public static final  String FG_FAIL = "1"; //失败
}
