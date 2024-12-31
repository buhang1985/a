package iih.bl.itf.std.bean.output.inc.sub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import iih.bl.itf.std.bean.output.WsResultInfoWithCustom;

/**
 * 门诊自助发票明细查询结果
 * 
 * @author shaokx 2019/02/26
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultGetIncItmInfo extends WsResultInfoWithCustom {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "stinfo")
	private WsResultGetIncItmStInfo stinfo;

	// 提示信息
	@XmlElement(name = "note")
	private String note;

	public WsResultGetIncItmStInfo getStinfo() {
		return stinfo;
	}

	public void setStinfo(WsResultGetIncItmStInfo stinfo) {
		this.stinfo = stinfo;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
}
