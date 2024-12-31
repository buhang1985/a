package iih.bl.itf.std.bean.output.inc.sub;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * 门诊自助发票明细查询结果--结算信息
 * 
 * @author shaokx 2019/02/26
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultGetIncItmStInfo {

	private static final long serialVersionUID = 1L;

	// 结算顺序号码
	@XmlElement(name = "stNO")
	private String stNO;

	// 医院级别
	@XmlElement(name = "mlType")
	private String mlType;

	// 医保类型
	@XmlElement(name = "hpType")
	private String hpType;

	// 医保号
	@XmlElement(name = "hpNO")
	private String hpNO;

	// 医院名称
	@XmlElement(name = "mlName")
	private String mlName;

	// 操作员编码
	@XmlElement(name = "opCode")
	private String opCode;

	// 结算时间
	@XmlElement(name = "stTime")
	private String stTime;

	// 门诊本次结算总费用 单位分
	@XmlElement(name = "entAmout")
	private String entAmout;

	@XmlElementWrapper(name = "incList")
	@XmlElement(name = "incItm")
	private List<WsResultGetIncList> incNoItm;

	public String getStNO() {
		return stNO;
	}

	public void setStNO(String stNO) {
		this.stNO = stNO;
	}

	public String getMlType() {
		return mlType;
	}

	public void setMlType(String mlType) {
		this.mlType = mlType;
	}

	public String getHpType() {
		return hpType;
	}

	public void setHpType(String hpType) {
		this.hpType = hpType;
	}

	public String getHpNO() {
		return hpNO;
	}

	public void setHpNO(String hpNO) {
		this.hpNO = hpNO;
	}

	public String getMlName() {
		return mlName;
	}

	public void setMlName(String mlName) {
		this.mlName = mlName;
	}

	public String getOpCode() {
		return opCode;
	}

	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}

	public String getStTime() {
		return stTime;
	}

	public void setStTime(String stTime) {
		this.stTime = stTime;
	}

	public String getEntAmout() {
		return entAmout;
	}

	public void setEntAmout(String entAmout) {
		this.entAmout = entAmout;
	}

	public List<WsResultGetIncList> getIncNoItm() {
		return incNoItm;
	}

	public void setIncNoItm(List<WsResultGetIncList> incNoItm) {
		this.incNoItm = incNoItm;
	}
	
}
