package iih.bl.itf.std.bean.input.wxpublic.sub;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
/**
 * 微信公众号费用通知患者信息
 * @author zhangxin
 * @date 2019年11月5日
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamWxPublicPatient implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 模板消息编码
	 */
	@XmlElement(name = "templcode")
	private String  templcode;
	/**
	 * 患者ID
	 */
	@XmlElement(name = "id_pat")
	private String id_pat;
	/**
	 * 患者编码
	 */
	@XmlElement(name = "codepat")
	private String codepat;
	/**
	 * 患者姓名
	 */
	@XmlElement(name = "namepat")
	private String namepat;
	/**
	 * 就诊卡
	 */
	@XmlElement(name = "cardcode")
	private String cardcode;
	/**
	 * 住院号
	 */
	@XmlElement(name = "ipcode")
	private String ipcode;
	/**
	 * 凭证ID
	 */
	@XmlElementWrapper(name = "ids")
	@XmlElement(name = "id")
	private List<String> ids;
	public String getTemplcode() {
		return templcode;
	}
	public void setTemplcode(String templcode) {
		this.templcode = templcode;
	}
	public String getId_pat() {
		return id_pat;
	}
	public void setId_pat(String id_pat) {
		this.id_pat = id_pat;
	}
	public String getCodepat() {
		return codepat;
	}
	public void setCodepat(String codepat) {
		this.codepat = codepat;
	}
	public String getNamepat() {
		return namepat;
	}
	public void setNamepat(String namepat) {
		this.namepat = namepat;
	}
	public String getCardcode() {
		return cardcode;
	}
	public void setCardcode(String cardcode) {
		this.cardcode = cardcode;
	}
	public String getIpcode() {
		return ipcode;
	}
	public void setIpcode(String ipcode) {
		this.ipcode = ipcode;
	}
	public List<String> getIds() {
		return ids;
	}
	public void setIds(List<String> ids) {
		this.ids = ids;
	}
	
}
