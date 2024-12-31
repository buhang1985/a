package iih.sc.pub;

/**
 * 短信常量
 * 
 * @author yank
 *
 */
public interface IScSmsConst {
	// 短信系统服务ID
	public static final String SMS_MSG_SYS_ID = "8W6HEA";

	// 短信消息模板
	public static final String SC_APT_MSG_TEMPLATE = "sc_op_apt_msg";// 预约成功消息
	public static final String SC_PAY_FOR_APT_MSG_TEMPLATE = "sc_pay_for_apt_msg";// 预约支付消息
	public static final String SC_APT_AND_PAY_MSG_TEMPLATE = "sc_apt_and_pay_msg";// 付费预约消息
	public static final String SC_CANCEL_APT_MSG_TEMPLATE = "sc_cancel_apt_msg";// 取消预约消息
	public static final String SC_STOPCANCEL_OP_APT_MSG_TEMPLATE = "sc_stopcancel_op_apt_msg";// 停诊取消预约短信通知
	public static final String SC_DIAG_END_MSG_TEMPLATE = "sc_diag_end_msg";// 门诊诊毕
	public static final String EN_OP_APT_CFM_MSG_TEMPLATE = "en_op_apt_cfm_reg_msg";// 预约取号短信通知
	public static final String EN_OP_REG_MSG_TEMPLATE = "en_op_apt_cfm_reg_msg";// 门诊挂号短信通知
	public static final String SC_DIAG_END_MSG_REVISIT = "sc_diag_end_msg_revisit";// 门诊复诊
	public static final String EN_OP_GREEN_CHANNEL_MSG = "en_op_green_channel_msg";// 绿色通道患者通知

	public static final String PREG_DOC_SEND_MSG = "preg_doc_send_msg";// 就诊未建档管理发送短信
	
	/**
	 * 医技预约提前一天短信通知
	 */
	public static final String SC_MT_APT_SMS_NOTICE = "sc_mt_apt_sms_notice";
}