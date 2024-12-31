package iih.en.pv.s.bp.ip.ws.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "wristbandPrint")
@XmlAccessorType(XmlAccessType.FIELD)
public class WristPrintTimesBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 患者编码
	private String patient_id;

	// 住院号
	private String mrn;

	// 住院次数
	private String series;

	// 腕带打印次数
	private String printTimes;

	public String getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}

	public String getMrn() {
		return mrn;
	}

	public void setMrn(String mrn) {
		this.mrn = mrn;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getPrintTimes() {
		return printTimes;
	}

	public void setPrintTimes(String printTimes) {
		this.printTimes = printTimes;
	}

	@Override
	public String toString() {
		return "WristPrintTimesBean [patient_id=" + patient_id + ", mrn=" + mrn + ", series=" + series + ", printTimes="
				+ printTimes + "]";
	}

}
