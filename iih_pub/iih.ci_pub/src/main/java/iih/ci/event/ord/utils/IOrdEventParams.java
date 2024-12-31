package iih.ci.event.ord.utils;
/**
 * 系统参数
 * @author F
 *
 * @date 2019年11月26日下午4:10:38
 *
 * @classpath iih.ci.event.ord.utils.IOrdEventParams
 */
public interface IOrdEventParams {

	public static final String SYS_PARAM_EVENT_CODE_ENTP="CIOR0526";//集成平台自定义就诊类型 - 01,0201,0202,0203,03 分别代表门诊、急诊流水、急诊抢救、急诊留观、住院的就诊类型
	public static final String ORD_EVENT_PATH_PATTERN="CIOR0766";//病理申请集成平台消息模式 - 01检查申请，发送BS002消息;02病理申请，发送BS452消息;
}
