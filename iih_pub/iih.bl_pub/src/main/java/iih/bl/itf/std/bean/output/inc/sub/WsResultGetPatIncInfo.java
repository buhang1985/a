package iih.bl.itf.std.bean.output.inc.sub;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import iih.bl.itf.std.bean.output.WsResultInfoWithCustom;

/**
 * 门诊自助发票查询结果
 * 
 * @author shaokx 2019/02/26
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultGetPatIncInfo extends WsResultInfoWithCustom {

	private static final long serialVersionUID = 1L;

	// 门诊就诊处方费用明细列表，缴费的基本单位为处方
	@XmlElementWrapper(name = "stinfo")
	@XmlElement(name = "stItem")
	private List<WsResultGetPatStInfo> stinfo;

	// 提示信息
	@XmlElement(name = "note")
	private String note;

	public List<WsResultGetPatStInfo> getStinfo() {
		return stinfo;
	}

	public void setStinfo(List<WsResultGetPatStInfo> stinfo) {
		this.stinfo = stinfo;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
}
