package iih.bl.itf.std.bean.output.charge.sub;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * 费用清单医嘱信息
 * @author ly 2018/07/20
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultBillOrderInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	//医嘱号
	@XmlElement(name = "applyCode")
	private String applyCode;
	
	//处方类别
	@XmlElement(name = "applyTpCode")
	private String applyTpCode;
	
	//结算标志
	@XmlElement(name = "stflag")
	private String stflag;
	
	//记账时间
	@XmlElement(name = "cgTime")
	private String cgTime;
	
	//科室名称
	@XmlElement(name = "orDepName")
	private String orDepName;
	
	//医生名称
	@XmlElement(name = "orEmpName")
	private String orEmpName;
	
	//执行科室名称
	@XmlElement(name = "mpDepName")
	private String mpDepName;
	
	//医嘱项目明细
	@XmlElementWrapper(name="srvList")
	@XmlElement(name = "srv")
	private List<WsResultBillSrvInfo> srvList;
	
	public String getApplyCode() {
		return applyCode;
	}

	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
	}

	public String getApplyTpCode() {
		return applyTpCode;
	}

	public void setApplyTpCode(String applyTpCode) {
		this.applyTpCode = applyTpCode;
	}

	public String getStflag() {
		return stflag;
	}

	public void setStflag(String stflag) {
		this.stflag = stflag;
	}

	public String getCgTime() {
		return cgTime;
	}

	public void setCgTime(String cgTime) {
		this.cgTime = cgTime;
	}

	public String getOrDepName() {
		return orDepName;
	}

	public void setOrDepName(String orDepName) {
		this.orDepName = orDepName;
	}

	public String getOrEmpName() {
		return orEmpName;
	}

	public void setOrEmpName(String orEmpName) {
		this.orEmpName = orEmpName;
	}

	public List<WsResultBillSrvInfo> getSrvList() {
		return srvList;
	}

	public void setSrvList(List<WsResultBillSrvInfo> srvList) {
		this.srvList = srvList;
	}

	public String getMpDepName() {
		return mpDepName;
	}

	public void setMpDepName(String mpDepName) {
		this.mpDepName = mpDepName;
	}
	
}
