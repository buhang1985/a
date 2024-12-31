package iih.nm.nhr.dto.nurinfo.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 护理人员信息 DTO数据 
 * 
 */
public class NurInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 人员主键
	 * @return String
	 */
	public String getId_psndoc() {
		return ((String) getAttrVal("Id_psndoc"));
	}
	/**
	 * 人员主键
	 * @param Id_psndoc
	 */
	public void setId_psndoc(String Id_psndoc) {
		setAttrVal("Id_psndoc", Id_psndoc);
	}
	/**
	 * 人员名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 人员名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 护理主键
	 * @return String
	 */
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}
	/**
	 * 护理主键
	 * @param Id_nur
	 */
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 人员编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 护士层级id
	 * @return String
	 */
	public String getId_nur_level() {
		return ((String) getAttrVal("Id_nur_level"));
	}
	/**
	 * 护士层级id
	 * @param Id_nur_level
	 */
	public void setId_nur_level(String Id_nur_level) {
		setAttrVal("Id_nur_level", Id_nur_level);
	}
	/**
	 * 护士层级
	 * @return String
	 */
	public String getName_nur_level() {
		return ((String) getAttrVal("Name_nur_level"));
	}
	/**
	 * 护士层级
	 * @param Name_nur_level
	 */
	public void setName_nur_level(String Name_nur_level) {
		setAttrVal("Name_nur_level", Name_nur_level);
	}
	/**
	 * 工作部门id
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 工作部门id
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 工作部门
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 工作部门
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 职务id
	 * @return String
	 */
	public String getId_psnpost() {
		return ((String) getAttrVal("Id_psnpost"));
	}
	/**
	 * 职务id
	 * @param Id_psnpost
	 */
	public void setId_psnpost(String Id_psnpost) {
		setAttrVal("Id_psnpost", Id_psnpost);
	}
	/**
	 * 职务
	 * @return String
	 */
	public String getName_psnpost() {
		return ((String) getAttrVal("Name_psnpost"));
	}
	/**
	 * 职务
	 * @param Name_psnpost
	 */
	public void setName_psnpost(String Name_psnpost) {
		setAttrVal("Name_psnpost", Name_psnpost);
	}
	/**
	 * 性别id
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}
	/**
	 * 性别id
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}
	/**
	 * 性别
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
	 * 证件号码
	 * @return String
	 */
	public String getId_card() {
		return ((String) getAttrVal("Id_card"));
	}
	/**
	 * 证件号码
	 * @param Id_card
	 */
	public void setId_card(String Id_card) {
		setAttrVal("Id_card", Id_card);
	}
	/**
	 * 民族id
	 * @return String
	 */
	public String getId_nation() {
		return ((String) getAttrVal("Id_nation"));
	}
	/**
	 * 民族id
	 * @param Id_nation
	 */
	public void setId_nation(String Id_nation) {
		setAttrVal("Id_nation", Id_nation);
	}
	/**
	 * 民族
	 * @return String
	 */
	public String getName_nation() {
		return ((String) getAttrVal("Name_nation"));
	}
	/**
	 * 民族
	 * @param Name_nation
	 */
	public void setName_nation(String Name_nation) {
		setAttrVal("Name_nation", Name_nation);
	}
	/**
	 * 到院日期
	 * @return String
	 */
	public String getDt_in() {
		return ((String) getAttrVal("Dt_in"));
	}
	/**
	 * 到院日期
	 * @param Dt_in
	 */
	public void setDt_in(String Dt_in) {
		setAttrVal("Dt_in", Dt_in);
	}
	/**
	 * 执业证号
	 * @return String
	 */
	public String getLicensenum() {
		return ((String) getAttrVal("Licensenum"));
	}
	/**
	 * 执业证号
	 * @param Licensenum
	 */
	public void setLicensenum(String Licensenum) {
		setAttrVal("Licensenum", Licensenum);
	}
	/**
	 * 学历id
	 * @return String
	 */
	public String getId_edu() {
		return ((String) getAttrVal("Id_edu"));
	}
	/**
	 * 学历id
	 * @param Id_edu
	 */
	public void setId_edu(String Id_edu) {
		setAttrVal("Id_edu", Id_edu);
	}
	/**
	 * 学历
	 * @return String
	 */
	public String getName_edu() {
		return ((String) getAttrVal("Name_edu"));
	}
	/**
	 * 学历
	 * @param Name_edu
	 */
	public void setName_edu(String Name_edu) {
		setAttrVal("Name_edu", Name_edu);
	}
	/**
	 * 序号
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
}