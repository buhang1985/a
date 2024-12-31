package iih.bd.bc.event.pub;

/**
 * 患者事件常量
 *  
 * 
 * @author shaosq
 * @date 2016年8月24日  下午3:47:33
 */
public interface IPiEventConst {
	
	/**
	 * 患者关系事件源ID
	 */
	public static final String EVENT_IE_PATIENT_RELATION = "iih.pi.dic.dto.d.PiUdidocDTO";
	
	public static final String ERROR_PICHANGED4IP_LISTENER_NOT_MATCH_EVENT = "患者注册监听器与事件源不匹配！";
	public static final String ERROR_PI_ALPHY_LISTENER_NOT_MATCH_EVENT = "患者过敏及生理信息监听器与事件源不匹配！";

}
