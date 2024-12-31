package iih.pi.reg.wsstd.bean.output.patinfo.sub;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 患者信息查询之患者标签信息
 * @author shaokx 2020/06/08
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultPatTagInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// 患者标签code 
	@XmlElement(name = "tag_code")
	private String tag_code;
	
	// 患者标签name
    @XmlElement(name = "tag_name")
	private String tag_name;

	public String getTag_code() {
		return tag_code;
	}

	public void setTag_code(String tag_code) {
		this.tag_code = tag_code;
	}

	public String getTag_name() {
		return tag_name;
	}

	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
    
    
}
