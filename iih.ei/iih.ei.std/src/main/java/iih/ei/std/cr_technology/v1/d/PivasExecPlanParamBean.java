package iih.ei.std.cr_technology.v1.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 药品执行计划入参
 * 
 * @author dj.zhang
 *
 */
@XmlRootElement(name = "parameters")
@XmlAccessorType(XmlAccessType.FIELD)
public class PivasExecPlanParamBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "sDate")
	private String begin_date;
	@XmlElement(name = "eDate")
	private String end_date;
	@XmlElement(name = "eDay")
	private String datediff;

	public String getBegin_date() {
		return begin_date;
	}

	public void setBegin_date(String begin_date) {
		this.begin_date = begin_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getDatediff() {
		return datediff;
	}

	public void setDatediff(String datediff) {
		this.datediff = datediff;
	}

}
