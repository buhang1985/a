package iih.bl.itf.std.bean.output.ippay.sub;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import iih.bl.itf.std.bean.output.WsResultInfo;

/**
 * 
 * @author hanjq 下午5:27:53
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultIpPayStInfo extends WsResultInfo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8539301208496832871L;

	//结算顺序号码
	@XmlElement(name = "stNO")
	private String stNO;
	
	//医院类型
	@XmlElement(name = "mlType")
	private String mlType;
	
	//医保类型患者分类
	@XmlElement(name = "hpType")
	private String hpType;
	
	//医保号
	@XmlElement(name = "hpNO")
	private String hpNO;

	//医院名称
	@XmlElement(name = "mlName")
	private String mlName;

	//操作员编号
	@XmlElement(name = "opCode")
	private String opCode;	

	//结算时间
	@XmlElement(name = "stTime")
	private String stTime;

	//预交金总额（单位分）
	@XmlElement(name = "prepayment")
	private String prepayment;

	//住院本次所有医疗单据 就诊总费用 单位分
	@XmlElement(name = "entAmout")
	private String entAmout;

	//住院本次所有医疗单据 个人支付费用 单位分
	@XmlElement(name = "entselfAmout")
	private String entselfAmout;

	//住院本次所有医疗单据 医保账户支付费用 单位分
	@XmlElement(name = "enthpcardAmout")
	private String enthpcardAmout;

	//住院本次所有医疗单据 医保统筹支付费用 单位分
	@XmlElement(name = "enthpAmout")
	private String enthpAmout;

	//本次结算找零金额
	@XmlElement(name = "entChangeAmout")
	private String entChangeAmout;
	
	//发票信息
	@XmlElementWrapper(name = "incList")
	@XmlElement(name = "incItm")
	private List<WsResultIPPayInc> incList;
	
	
	public WsResultIpPayStInfo() {
	}
	
	public WsResultIpPayStInfo(String stNO, String mlType, String hpType, String hpNO, String mlName, String opCode,
			String stTime, String prepayment, String entAmout, String entselfAmout, String enthpcardAmout,
			String enthpAmout, String entChangeAmout, List<WsResultIPPayInc> incList) {
		super();
		this.stNO = stNO;
		this.mlType = mlType;
		this.hpType = hpType;
		this.hpNO = hpNO;
		this.mlName = mlName;
		this.opCode = opCode;
		this.stTime = stTime;
		this.prepayment = prepayment;
		this.entAmout = entAmout;
		this.entselfAmout = entselfAmout;
		this.enthpcardAmout = enthpcardAmout;
		this.enthpAmout = enthpAmout;
		this.entChangeAmout = entChangeAmout;
		this.incList = incList;
	}

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

	public String getPrepayment() {
		return prepayment;
	}

	public void setPrepayment(String prepayment) {
		this.prepayment = prepayment;
	}

	public String getEntAmout() {
		return entAmout;
	}

	public void setEntAmout(String entAmout) {
		this.entAmout = entAmout;
	}

	public String getEntselfAmout() {
		return entselfAmout;
	}

	public void setEntselfAmout(String entselfAmout) {
		this.entselfAmout = entselfAmout;
	}

	public String getEnthpcardAmout() {
		return enthpcardAmout;
	}

	public void setEnthpcardAmout(String enthpcardAmout) {
		this.enthpcardAmout = enthpcardAmout;
	}

	public String getEnthpAmout() {
		return enthpAmout;
	}

	public void setEnthpAmout(String enthpAmout) {
		this.enthpAmout = enthpAmout;
	}

	public String getEntChangeAmout() {
		return entChangeAmout;
	}

	public void setEntChangeAmout(String entChangeAmout) {
		this.entChangeAmout = entChangeAmout;
	}

	public List<WsResultIPPayInc> getIncList() {
		return incList;
	}

	public void setIncList(List<WsResultIPPayInc> incList) {
		this.incList = incList;
	}
	
}
