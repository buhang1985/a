package iih.bl.itf.std.bean.input;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * ws入参数据客开属性
 * 
 * @author ly 2018/07/20
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamInfoWithCustom implements Serializable {

	private static final long serialVersionUID = 1L;

	// 客开参数1~6
	@XmlElement(name = "ODS1")
	private String ods1;

	@XmlElement(name = "ODS2")
	private String ods2;

	@XmlElement(name = "ODS3")
	private String ods3;

	@XmlElement(name = "ODS4")
	private String ods4;

	@XmlElement(name = "ODS5")
	private String ods5;

	@XmlElement(name = "ODS6")
	private String ods6;
	
	//使用第三方系统处理金额来源描述
	@XmlElement(name = "sourceDesc")
	private String sourceDesc;

	public String getOds1() {
		return ods1;
	}

	public void setOds1(String ods1) {
		this.ods1 = ods1;
	}

	public String getOds2() {
		return ods2;
	}

	public void setOds2(String ods2) {
		this.ods2 = ods2;
	}

	public String getOds3() {
		return ods3;
	}

	public void setOds3(String ods3) {
		this.ods3 = ods3;
	}

	public String getOds4() {
		return ods4;
	}

	public void setOds4(String ods4) {
		this.ods4 = ods4;
	}

	public String getOds5() {
		return ods5;
	}

	public void setOds5(String ods5) {
		this.ods5 = ods5;
	}

	public String getOds6() {
		return ods6;
	}

	public void setOds6(String ods6) {
		this.ods6 = ods6;
	}
	
	public String getSourceDesc() {
		return sourceDesc;
	}

	public void setSourceDesc(String sourceDesc) {
		this.sourceDesc = sourceDesc;
	}
}
