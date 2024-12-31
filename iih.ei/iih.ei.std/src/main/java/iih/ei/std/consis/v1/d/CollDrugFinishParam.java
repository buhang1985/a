package iih.ei.std.consis.v1.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ROOT")
@XmlAccessorType(XmlAccessType.FIELD)
public class CollDrugFinishParam implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "OPSYSTEM")
	private String code_sys;
	@XmlElement(name = "OPWINID")
	private String no_win;
	@XmlElement(name = "OPTYPE")
	private String code_type;
	@XmlElement(name = "OPIP")
	private String ip;
	@XmlElement(name = "OPMANNO")
	private String code_emp_colldrug;
	@XmlElement(name = "OPMANNAME")
	private String name_emp_colldrug;

	@XmlElement(name = "CONSIS_PRESC_MSTVW")
	private CollDrugFinishPres[] press;

	public String getCode_sys() {
		return code_sys;
	}

	public void setCode_sys(String code_sys) {
		this.code_sys = code_sys;
	}

	public String getNo_win() {
		return no_win;
	}

	public void setNo_win(String no_win) {
		this.no_win = no_win;
	}

	public String getCode_type() {
		return code_type;
	}

	public void setCode_type(String code_type) {
		this.code_type = code_type;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCode_emp_colldrug() {
		return code_emp_colldrug;
	}

	public void setCode_emp_colldrug(String code_emp_colldrug) {
		this.code_emp_colldrug = code_emp_colldrug;
	}

	public String getName_emp_colldrug() {
		return name_emp_colldrug;
	}

	public void setName_emp_colldrug(String name_emp_colldrug) {
		this.name_emp_colldrug = name_emp_colldrug;
	}

	public CollDrugFinishPres[] getPress() {
		return press;
	}

	public void setPress(CollDrugFinishPres[] press) {
		this.press = press;
	}
}
