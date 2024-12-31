package iih.syn.sbd.psndoc.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 人员信息数据同步 DTO数据 
 * 
 */
public class VwPsnDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 人员编码/工号
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 人员编码/工号
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 人员姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 人员姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 签章图片
	 * @return String
	 */
	public String getSign_pic() {
		return ((String) getAttrVal("Sign_pic"));
	}
	/**
	 * 签章图片
	 * @param Sign_pic
	 */
	public void setSign_pic(String Sign_pic) {
		setAttrVal("Sign_pic", Sign_pic);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}
	/**
	 * 科室编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}
	/**
	 * 拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 五笔码
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}
	/**
	 * 五笔码
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}
	/**
	 * 性别编码
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 性别名称
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}
	/**
	 * 性别名称
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 出生日期
	 * @return String
	 */
	public String getDt_birth() {
		return ((String) getAttrVal("Dt_birth"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(String Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 证件类型
	 * @return String
	 */
	public String getSd_idtype() {
		return ((String) getAttrVal("Sd_idtype"));
	}
	/**
	 * 证件类型
	 * @param Sd_idtype
	 */
	public void setSd_idtype(String Sd_idtype) {
		setAttrVal("Sd_idtype", Sd_idtype);
	}
	/**
	 * 证件类型名称
	 * @return String
	 */
	public String getName_idtype() {
		return ((String) getAttrVal("Name_idtype"));
	}
	/**
	 * 证件类型名称
	 * @param Name_idtype
	 */
	public void setName_idtype(String Name_idtype) {
		setAttrVal("Name_idtype", Name_idtype);
	}
	/**
	 * 证件号码
	 * @return String
	 */
	public String getId() {
		return ((String) getAttrVal("Id"));
	}
	/**
	 * 证件号码
	 * @param Id
	 */
	public void setId(String Id) {
		setAttrVal("Id", Id);
	}
	/**
	 * 邮箱
	 * @return String
	 */
	public String getEmail() {
		return ((String) getAttrVal("Email"));
	}
	/**
	 * 邮箱
	 * @param Email
	 */
	public void setEmail(String Email) {
		setAttrVal("Email", Email);
	}
	/**
	 * 职称编码
	 * @return String
	 */
	public String getSd_emptitle() {
		return ((String) getAttrVal("Sd_emptitle"));
	}
	/**
	 * 职称编码
	 * @param Sd_emptitle
	 */
	public void setSd_emptitle(String Sd_emptitle) {
		setAttrVal("Sd_emptitle", Sd_emptitle);
	}
	/**
	 * 职称名称
	 * @return String
	 */
	public String getName_emptitle() {
		return ((String) getAttrVal("Name_emptitle"));
	}
	/**
	 * 职称名称
	 * @param Name_emptitle
	 */
	public void setName_emptitle(String Name_emptitle) {
		setAttrVal("Name_emptitle", Name_emptitle);
	}
	/**
	 * 联系地址
	 * @return String
	 */
	public String getAddr() {
		return ((String) getAttrVal("Addr"));
	}
	/**
	 * 联系地址
	 * @param Addr
	 */
	public void setAddr(String Addr) {
		setAttrVal("Addr", Addr);
	}
	/**
	 * 人员工作类型编码
	 * @return String
	 */
	public String getSd_empwktp() {
		return ((String) getAttrVal("Sd_empwktp"));
	}
	/**
	 * 人员工作类型编码
	 * @param Sd_empwktp
	 */
	public void setSd_empwktp(String Sd_empwktp) {
		setAttrVal("Sd_empwktp", Sd_empwktp);
	}
	/**
	 * 人员工作类型名称
	 * @return String
	 */
	public String getName_empwktp() {
		return ((String) getAttrVal("Name_empwktp"));
	}
	/**
	 * 人员工作类型名称
	 * @param Name_empwktp
	 */
	public void setName_empwktp(String Name_empwktp) {
		setAttrVal("Name_empwktp", Name_empwktp);
	}
	/**
	 * 联系电话
	 * @return String
	 */
	public String getOfficephone() {
		return ((String) getAttrVal("Officephone"));
	}
	/**
	 * 联系电话
	 * @param Officephone
	 */
	public void setOfficephone(String Officephone) {
		setAttrVal("Officephone", Officephone);
	}
	/**
	 * 移动电话
	 * @return String
	 */
	public String getMobile() {
		return ((String) getAttrVal("Mobile"));
	}
	/**
	 * 移动电话
	 * @param Mobile
	 */
	public void setMobile(String Mobile) {
		setAttrVal("Mobile", Mobile);
	}
	/**
	 * 删除标识
	 * @return String
	 */
	public String getFg_active() {
		return ((String) getAttrVal("Fg_active"));
	}
	/**
	 * 删除标识
	 * @param Fg_active
	 */
	public void setFg_active(String Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
}