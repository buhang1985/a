package iih.bl.itf.std.bean.output.settle.sub;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import iih.bl.itf.std.bean.output.WsResultInfo;

/**
 * 账单项分类明细
 * @author hanjq 上午9:20:10
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultIPorderDetailInfo extends WsResultInfo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4147754499918710470L;

	//医嘱号
	@XmlElement(name = "applyCode")
	private String applyCode;
	
	//处方类别 001药品;002检查;003 检验;004治疗  具体类型看医院参照
	@XmlElement(name = "applyTpCode")
	private String applyTpCode;
	
	//结算标志 Y结算 N未结算
	@XmlElement(name = "stflag")
	private String stflag;
	
	//记账时间 结算标示
	@XmlElement(name = "cgTime")
	private String cgTime;
	
	//科室名称
	@XmlElement(name = "orDepName")
	private String orDepName;
	
	//医生名称
	@XmlElement(name = "orEmpName")
	private String orEmpName;
	
	//医嘱项目明细，支持多srvlist节点
	@XmlElementWrapper(name = "srvList")
	@XmlElement(name = "srv")
	private ArrayList<WsResultSrv> srvList;

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

	public ArrayList<WsResultSrv> getSrvList() {
		return srvList;
	}

	public void setSrvList(ArrayList<WsResultSrv> srvList) {
		this.srvList = srvList;
	}
	
	
}
