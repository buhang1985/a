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
public class PivasBaseBodyParam {

	/**
	 * 客户端序列号
	 */
	@XmlElement(name = "SEQID")
	private String seqid;

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
}
