package iih.ei.std.cr_technology.v1.d;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * PIVAS基础WebService参数
 * 
 * @author dj.zhang
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PivasBaseHead {

	/**
	 * 消息来源
	 */
	@XmlElement(name = "SourceSystem")
	private String sourceSystem;

	/**
	 * 消息编号
	 */
	@XmlElement(name = "MessageID")
	private String messageID;

	/**
	 * 消息来源
	 * 
	 * @return
	 */
	public String getSourceSystem() {
		return sourceSystem;
	}

	/**
	 * 消息来源
	 * 
	 * @param sourceSystem
	 */
	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}

	/**
	 * 消息编号
	 * 
	 * @return
	 */
	public String getMessageID() {
		return messageID;
	}

	/**
	 * 消息编号
	 * 
	 * @param messageID
	 */
	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}

}
