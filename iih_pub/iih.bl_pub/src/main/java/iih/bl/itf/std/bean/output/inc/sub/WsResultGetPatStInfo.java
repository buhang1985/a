package iih.bl.itf.std.bean.output.inc.sub;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 门诊自助发票查询结果-结算信息
 * 
 * @author shaokx 2019/02/26
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultGetPatStInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	// 结算顺序号码
	@XmlElement(name = "stNO")
	private String stNO;
	
	// 01 挂号  02 收费
	@XmlElement(name = "blType")
	private String blType;
	
	// 用户姓名
	@XmlElement(name = "patName")
	private String patName;
	
	// 性别 1 男 2 女
	@XmlElement(name = "patSex")
	private String patSex;
	
	// 患者类型  Y 医保  N 自费
	@XmlElement(name = "patType")
	private String patType;
	
	// 交易时间
	@XmlElement(name = "stTime")
	private String stTime;
	
	// 门诊本次所有医疗单据  就诊总费用  单位分
	@XmlElement(name = "entAmout")
	private String entAmout;

	
	public String getBlType() {
		return blType;
	}

	public void setBlType(String blType) {
		this.blType = blType;
	}

	public String getPatName() {
		return patName;
	}

	public void setPatName(String patName) {
		this.patName = patName;
	}

	public String getPatSex() {
		return patSex;
	}

	public void setPatSex(String patSex) {
		this.patSex = patSex;
	}

	public String getPatType() {
		return patType;
	}

	public void setPatType(String patType) {
		this.patType = patType;
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

	public String getStNO() {
		return stNO;
	}

	public void setStNO(String stNO) {
		this.stNO = stNO;
	}

}
