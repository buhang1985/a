package iih.bl.itf.std.bean.output.charge.sub;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * 门诊处方信息新
 * 
 * @author shaokx 2019/07/19
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultPresInfoNew implements Serializable {

	private static final long serialVersionUID = 1L;

	// 申请单编号
	@XmlElement(name = "applyCode")
	private String applyCode;

	// 医嘱类别
	@XmlElement(name = "applyTpCode")
	private String applyTpCode;
	
	// 医嘱名称
	@XmlElement(name = "orName")
	private String orName;
		
	// 开单日期时间
	@XmlElement(name = "dtEffe")
	private String dtEffe;

	// 开单科室编号
	@XmlElement(name = "deptId")
	private String deptId;

	// 开单科室名称
	@XmlElement(name = "deptName")
	private String deptName;
	
	// 医生编号
	@XmlElement(name = "doctorId")
	private String doctorId;

	// 医生姓名
	@XmlElement(name = "doctorName")
	private String doctorName;
	
	// 整张医疗单 总计金额
	@XmlElement(name = "presAmt")
	private String presAmt;

	// 申请单具体明细
	@XmlElementWrapper(name = "presItem")
	@XmlElement(name = "item")
	private List<WsResultItemNew> presItem;

	public String getOrName() {
		return orName;
	}

	public void setOrName(String orName) {
		this.orName = orName;
	}

	public String getDtEffe() {
		return dtEffe;
	}

	public void setDtEffe(String dtEffe) {
		this.dtEffe = dtEffe;
	}

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

	public String getPresAmt() {
		return presAmt;
	}

	public void setPresAmt(String presAmt) {
		this.presAmt = presAmt;
	}

	public List<WsResultItemNew> getPresItem() {
		return presItem;
	}

	public void setPresItem(List<WsResultItemNew> presItem) {
		this.presItem = presItem;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
}
