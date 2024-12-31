package iih.bl.itf.std.bean.output.charge.sub;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * 门诊自助支付待缴数据模型
 * 
 * @author shaokx 2019/01/09
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultEntInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	// 门诊就诊编码
	@XmlElement(name = "entCode")
	private String entCode;

	// 门诊就诊次数
	@XmlElement(name = "enTimes")
	private String enTimes;

	// 门诊就诊类型
	@XmlElement(name = "entTp")
	private String entTp;

	// 患者类型
	@XmlElement(name = "patType")
	private String patType;

	// 门诊本次所有医疗单据 就诊总费用 单位分
	@XmlElement(name = "entAmout")
	private String entAmout;

	// 接诊时间
	@XmlElement(name = "entTime")
	private String entTime;

	// 备注
	@XmlElement(name = "note")
	private String note;
	
	//门诊就诊处方费用明细列表，缴费的基本单位为处方
	@XmlElementWrapper(name="entPresList")
	@XmlElement(name = "presInfo")
	private List<WsResultPresInfo> entPresList;

	public String getEntCode() {
		return entCode;
	}

	public void setEntCode(String entCode) {
		this.entCode = entCode;
	}


	public String getEnTimes() {
		return enTimes;
	}

	public void setEnTimes(String enTimes) {
		this.enTimes = enTimes;
	}

	public String getEntTp() {
		return entTp;
	}

	public void setEntTp(String entTp) {
		this.entTp = entTp;
	}


	public String getPatType() {
		return patType;
	}

	public void setPatType(String patType) {
		this.patType = patType;
	}

	public String getEntAmout() {
		return entAmout;
	}

	public void setEntAmout(String entAmout) {
		this.entAmout = entAmout;
	}

	public String getEntTime() {
		return entTime;
	}

	public void setEntTime(String entTime) {
		this.entTime = entTime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<WsResultPresInfo> getEntPresList() {
		return entPresList;
	}

	public void setEntPresList(List<WsResultPresInfo> entPresList) {
		this.entPresList = entPresList;
	}
	
	
}
