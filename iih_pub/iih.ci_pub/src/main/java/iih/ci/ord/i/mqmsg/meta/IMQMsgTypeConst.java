package iih.ci.ord.i.mqmsg.meta;

/**
 * MQ消息定义类型
 * @author HUMS
 *
 */
public interface IMQMsgTypeConst {

	/**
	 * 护士待确认消息
	 */
	public final static String CIS_MSG_NURSE_WAIT_CONFIRM = "CIS_MSG_NURSE_WAIT_CONFIRM";
	/**
	 * 加急的院内会诊提示信息
	 */
	public final static String CIS_MSG_HZ_CONFIRM = "CIS_MSG_HZ_CONFIRM";
	/**
	 * 入院三天没有诊断签署提醒
	 */
	public final static String CI_MSG_UN_DIAG_SIGN = "CiMsgUnDiagSign";
	/**
	 * 住院开立手术医嘱确认提醒
	 */
	public final static String CI_MSG_IP_OPR_CONFIRM = "CiMsgIpOprConfirm";
}
