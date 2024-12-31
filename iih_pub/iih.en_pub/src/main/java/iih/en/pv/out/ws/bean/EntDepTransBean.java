package iih.en.pv.out.ws.bean;

import iih.bd.webservice.BaseWsParam;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 转科记录信息
 * 
 * @author liubin
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class EntDepTransBean extends BaseWsParam implements Serializable {

	/**
     * 
     */
	private static final long serialVersionUID = 1L;
	
	//就诊ID
	private String Id_ent = "";
	
	// 原科室编码
	private String Code_dep_from = "";

	// 原科室名称
	private String Name_dep_from = "";
	
	// 原病区编码
	private String Code_nur_from = "";
	
	// 原病区名称
	private String Name_nur_from = "";
	
	// 原床位编码
	private String Code_bed_from = "";
	
	// 原床位名称
	private String Name_bed_from = "";
	
	// 目标科室编码
	private String Code_dep_to = "";
	
	// 目标科室名称
	private String Name_dep_to = "";
	
	// 目标病区编码
	private String Code_nur_to = "";
	
	// 目标病区名称
	private String Name_nur_to = "";
	
	// 目标床位编码
	private String Code_bed_to = "";
	
	// 目标床位名称	
	private String Name_bed_to = "";
	
	// 专科申请时间
	private String Dt_apply = "";
	
	// 专科接收时间
	private String Dt_acpt = "";
	
	// 申请操作人编码
	private String Code_emp_appl = "";
	
	// 申请操作人名称
	private String Name_emp_appl = "";
	
	// 接受操作人编码
	private String Code_emp_acpt = "";
	
	// 接手操作人名称
	private String Name_emp_acpt = "";
	
	
	
	public String getId_ent() {
		return Id_ent;
	}

	public void setId_ent(String id_ent) {
		Id_ent = id_ent;
	}

	public String getCode_dep_from() {
		return Code_dep_from;
	}

	public void setCode_dep_from(String code_dep_from) {
		Code_dep_from = code_dep_from;
	}

	public String getName_dep_from() {
		return Name_dep_from;
	}

	public void setName_dep_from(String name_dep_from) {
		Name_dep_from = name_dep_from;
	}

	public String getCode_nur_from() {
		return Code_nur_from;
	}

	public void setCode_nur_from(String code_nur_from) {
		Code_nur_from = code_nur_from;
	}

	public String getName_nur_from() {
		return Name_nur_from;
	}

	public void setName_nur_from(String name_nur_from) {
		Name_nur_from = name_nur_from;
	}

	public String getCode_bed_from() {
		return Code_bed_from;
	}

	public void setCode_bed_from(String code_bed_from) {
		Code_bed_from = code_bed_from;
	}

	public String getName_bed_from() {
		return Name_bed_from;
	}

	public void setName_bed_from(String name_bed_from) {
		Name_bed_from = name_bed_from;
	}

	public String getCode_dep_to() {
		return Code_dep_to;
	}

	public void setCode_dep_to(String code_dep_to) {
		Code_dep_to = code_dep_to;
	}

	public String getName_dep_to() {
		return Name_dep_to;
	}

	public void setName_dep_to(String name_dep_to) {
		Name_dep_to = name_dep_to;
	}

	public String getCode_nur_to() {
		return Code_nur_to;
	}

	public void setCode_nur_to(String code_nur_to) {
		Code_nur_to = code_nur_to;
	}

	public String getName_nur_to() {
		return Name_nur_to;
	}

	public void setName_nur_to(String name_nur_to) {
		Name_nur_to = name_nur_to;
	}

	public String getCode_bed_to() {
		return Code_bed_to;
	}

	public void setCode_bed_to(String code_bed_to) {
		Code_bed_to = code_bed_to;
	}

	public String getName_bed_to() {
		return Name_bed_to;
	}

	public void setName_bed_to(String name_bed_to) {
		Name_bed_to = name_bed_to;
	}

	public String getDt_apply() {
		return Dt_apply;
	}

	public void setDt_apply(String dt_apply) {
		Dt_apply = dt_apply;
	}

	public String getDt_acpt() {
		return Dt_acpt;
	}

	public void setDt_acpt(String dt_acpt) {
		Dt_acpt = dt_acpt;
	}

	public String getCode_emp_appl() {
		return Code_emp_appl;
	}

	public void setCode_emp_appl(String code_emp_appl) {
		Code_emp_appl = code_emp_appl;
	}

	public String getName_emp_appl() {
		return Name_emp_appl;
	}

	public void setName_emp_appl(String name_emp_appl) {
		Name_emp_appl = name_emp_appl;
	}

	public String getCode_emp_acpt() {
		return Code_emp_acpt;
	}

	public void setCode_emp_acpt(String code_emp_acpt) {
		Code_emp_acpt = code_emp_acpt;
	}

	public String getName_emp_acpt() {
		return Name_emp_acpt;
	}

	public void setName_emp_acpt(String name_emp_acpt) {
		Name_emp_acpt = name_emp_acpt;
	}
	
	
}
