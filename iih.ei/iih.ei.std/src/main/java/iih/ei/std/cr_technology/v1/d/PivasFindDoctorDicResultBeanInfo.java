package iih.ei.std.cr_technology.v1.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 医生字典JavaBean
 * 
 * @author dj.zhang
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PivasFindDoctorDicResultBeanInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "CODE")
	private String code;

	@XmlElement(name = "MESSAGE")
	private String message;
	
	@XmlElement(name = "SEQID")
	private String seqid;
	
	@XmlElement(name = "ROWS")
	private PivasFindDoctorDicResultBeanInfoDt[] beanInfoDt;

	/**
	 * 应答码
	 * 
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 应答码
	 * 
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 应答消息
	 * 
	 * @return
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 应答消息
	 * 
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * 客户端序列号
	 * 
	 * @return
	 */
	public String getSeqid() {
		return seqid;
	}

	/**
	 * 客户端序列号
	 * 
	 * @param seqid
	 */
	public void setSeqid(String seqid) {
		this.seqid = seqid;
	}

	/**
	 * 医生字典
	 * 
	 * @return
	 */
	public PivasFindDoctorDicResultBeanInfoDt[] getBeanInfoDt() {
		return beanInfoDt;
	}

	/**
	 * 医生字典
	 * 
	 * @param beanInfoDt
	 */
	public void setBeanInfoDt(PivasFindDoctorDicResultBeanInfoDt[] beanInfoDt) {
		this.beanInfoDt = beanInfoDt;
	}

}