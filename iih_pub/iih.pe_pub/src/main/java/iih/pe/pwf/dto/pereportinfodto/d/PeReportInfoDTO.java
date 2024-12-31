package iih.pe.pwf.dto.pereportinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检报告信息 DTO数据 
 * 
 */
public class PeReportInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 文档的操作版本
	 * @return String
	 */
	public String getVersionnumber() {
		return ((String) getAttrVal("Versionnumber"));
	}
	/**
	 * 文档的操作版本
	 * @param Versionnumber
	 */
	public void setVersionnumber(String Versionnumber) {
		setAttrVal("Versionnumber", Versionnumber);
	}
	/**
	 * 接口服务ID
	 * @return String
	 */
	public String getServerid() {
		return ((String) getAttrVal("Serverid"));
	}
	/**
	 * 接口服务ID
	 * @param Serverid
	 */
	public void setServerid(String Serverid) {
		setAttrVal("Serverid", Serverid);
	}
	/**
	 * 电子签章号
	 * @return String
	 */
	public String getSignatureid() {
		return ((String) getAttrVal("Signatureid"));
	}
	/**
	 * 电子签章号
	 * @param Signatureid
	 */
	public void setSignatureid(String Signatureid) {
		setAttrVal("Signatureid", Signatureid);
	}
	/**
	 * 报告号
	 * @return String
	 */
	public String getReportno() {
		return ((String) getAttrVal("Reportno"));
	}
	/**
	 * 报告号
	 * @param Reportno
	 */
	public void setReportno(String Reportno) {
		setAttrVal("Reportno", Reportno);
	}
	/**
	 * 文档标题
	 * @return String
	 */
	public String getDocumentname() {
		return ((String) getAttrVal("Documentname"));
	}
	/**
	 * 文档标题
	 * @param Documentname
	 */
	public void setDocumentname(String Documentname) {
		setAttrVal("Documentname", Documentname);
	}
	/**
	 * 域ID
	 * @return String
	 */
	public String getPatientdomain() {
		return ((String) getAttrVal("Patientdomain"));
	}
	/**
	 * 域ID
	 * @param Patientdomain
	 */
	public void setPatientdomain(String Patientdomain) {
		setAttrVal("Patientdomain", Patientdomain);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getPatientlid() {
		return ((String) getAttrVal("Patientlid"));
	}
	/**
	 * 患者ID
	 * @param Patientlid
	 */
	public void setPatientlid(String Patientlid) {
		setAttrVal("Patientlid", Patientlid);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getMedicalno() {
		return ((String) getAttrVal("Medicalno"));
	}
	/**
	 * 就诊号
	 * @param Medicalno
	 */
	public void setMedicalno(String Medicalno) {
		setAttrVal("Medicalno", Medicalno);
	}
	/**
	 * 就诊次数
	 * @return Integer
	 */
	public Integer getVisittimes() {
		return ((Integer) getAttrVal("Visittimes"));
	}
	/**
	 * 就诊次数
	 * @param Visittimes
	 */
	public void setVisittimes(Integer Visittimes) {
		setAttrVal("Visittimes", Visittimes);
	}
	/**
	 * 就诊日期
	 * @return FDateTime
	 */
	public FDateTime getVisitdate() {
		return ((FDateTime) getAttrVal("Visitdate"));
	}
	/**
	 * 就诊日期
	 * @param Visitdate
	 */
	public void setVisitdate(FDateTime Visitdate) {
		setAttrVal("Visitdate", Visitdate);
	}
	/**
	 * 患者名称
	 * @return String
	 */
	public String getPatientname() {
		return ((String) getAttrVal("Patientname"));
	}
	/**
	 * 患者名称
	 * @param Patientname
	 */
	public void setPatientname(String Patientname) {
		setAttrVal("Patientname", Patientname);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getGendercode() {
		return ((String) getAttrVal("Gendercode"));
	}
	/**
	 * 性别编码
	 * @param Gendercode
	 */
	public void setGendercode(String Gendercode) {
		setAttrVal("Gendercode", Gendercode);
	}
	/**
	 * 性别名称
	 * @return String
	 */
	public String getGendername() {
		return ((String) getAttrVal("Gendername"));
	}
	/**
	 * 性别名称
	 * @param Gendername
	 */
	public void setGendername(String Gendername) {
		setAttrVal("Gendername", Gendername);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getBirthdate() {
		return ((FDate) getAttrVal("Birthdate"));
	}
	/**
	 * 出生日期
	 * @param Birthdate
	 */
	public void setBirthdate(FDate Birthdate) {
		setAttrVal("Birthdate", Birthdate);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getPatientage() {
		return ((String) getAttrVal("Patientage"));
	}
	/**
	 * 年龄
	 * @param Patientage
	 */
	public void setPatientage(String Patientage) {
		setAttrVal("Patientage", Patientage);
	}
	/**
	 * 团体编码
	 * @return String
	 */
	public String getProorgcode() {
		return ((String) getAttrVal("Proorgcode"));
	}
	/**
	 * 团体编码
	 * @param Proorgcode
	 */
	public void setProorgcode(String Proorgcode) {
		setAttrVal("Proorgcode", Proorgcode);
	}
	/**
	 * 团体名称
	 * @return String
	 */
	public String getProorgname() {
		return ((String) getAttrVal("Proorgname"));
	}
	/**
	 * 团体名称
	 * @param Proorgname
	 */
	public void setProorgname(String Proorgname) {
		setAttrVal("Proorgname", Proorgname);
	}
	/**
	 * 家庭地址
	 * @return String
	 */
	public String getAddress() {
		return ((String) getAttrVal("Address"));
	}
	/**
	 * 家庭地址
	 * @param Address
	 */
	public void setAddress(String Address) {
		setAttrVal("Address", Address);
	}
	/**
	 * 患者备注信息
	 * @return String
	 */
	public String getPatientmemo() {
		return ((String) getAttrVal("Patientmemo"));
	}
	/**
	 * 患者备注信息
	 * @param Patientmemo
	 */
	public void setPatientmemo(String Patientmemo) {
		setAttrVal("Patientmemo", Patientmemo);
	}
	/**
	 * 总检日期
	 * @return FDateTime
	 */
	public FDateTime getSummarydate() {
		return ((FDateTime) getAttrVal("Summarydate"));
	}
	/**
	 * 总检日期
	 * @param Summarydate
	 */
	public void setSummarydate(FDateTime Summarydate) {
		setAttrVal("Summarydate", Summarydate);
	}
	/**
	 * 总检医生编码
	 * @return String
	 */
	public String getSummarydoccode() {
		return ((String) getAttrVal("Summarydoccode"));
	}
	/**
	 * 总检医生编码
	 * @param Summarydoccode
	 */
	public void setSummarydoccode(String Summarydoccode) {
		setAttrVal("Summarydoccode", Summarydoccode);
	}
	/**
	 * 总检医生名称
	 * @return String
	 */
	public String getSummarydocname() {
		return ((String) getAttrVal("Summarydocname"));
	}
	/**
	 * 总检医生名称
	 * @param Summarydocname
	 */
	public void setSummarydocname(String Summarydocname) {
		setAttrVal("Summarydocname", Summarydocname);
	}
	/**
	 * 医疗机构编码
	 * @return String
	 */
	public String getOrgcode() {
		return ((String) getAttrVal("Orgcode"));
	}
	/**
	 * 医疗机构编码
	 * @param Orgcode
	 */
	public void setOrgcode(String Orgcode) {
		setAttrVal("Orgcode", Orgcode);
	}
	/**
	 * 医疗机构名称
	 * @return String
	 */
	public String getOrgname() {
		return ((String) getAttrVal("Orgname"));
	}
	/**
	 * 医疗机构名称
	 * @param Orgname
	 */
	public void setOrgname(String Orgname) {
		setAttrVal("Orgname", Orgname);
	}
	/**
	 * 审核日期
	 * @return FDateTime
	 */
	public FDateTime getRvdatetime() {
		return ((FDateTime) getAttrVal("Rvdatetime"));
	}
	/**
	 * 审核日期
	 * @param Rvdatetime
	 */
	public void setRvdatetime(FDateTime Rvdatetime) {
		setAttrVal("Rvdatetime", Rvdatetime);
	}
	/**
	 * 审核医生编码
	 * @return String
	 */
	public String getRvdoccode() {
		return ((String) getAttrVal("Rvdoccode"));
	}
	/**
	 * 审核医生编码
	 * @param Rvdoccode
	 */
	public void setRvdoccode(String Rvdoccode) {
		setAttrVal("Rvdoccode", Rvdoccode);
	}
	/**
	 * 审核医生名称
	 * @return String
	 */
	public String getRvdocname() {
		return ((String) getAttrVal("Rvdocname"));
	}
	/**
	 * 审核医生名称
	 * @param Rvdocname
	 */
	public void setRvdocname(String Rvdocname) {
		setAttrVal("Rvdocname", Rvdocname);
	}
	/**
	 * 修改日期
	 * @return String
	 */
	public String getModifydate() {
		return ((String) getAttrVal("Modifydate"));
	}
	/**
	 * 修改日期
	 * @param Modifydate
	 */
	public void setModifydate(String Modifydate) {
		setAttrVal("Modifydate", Modifydate);
	}
	/**
	 * 患者照片信息
	 * @return String
	 */
	public String getImagecontent() {
		return ((String) getAttrVal("Imagecontent"));
	}
	/**
	 * 患者照片信息
	 * @param Imagecontent
	 */
	public void setImagecontent(String Imagecontent) {
		setAttrVal("Imagecontent", Imagecontent);
	}
	/**
	 * 患者照片格式
	 * @return String
	 */
	public String getImageformat() {
		return ((String) getAttrVal("Imageformat"));
	}
	/**
	 * 患者照片格式
	 * @param Imageformat
	 */
	public void setImageformat(String Imageformat) {
		setAttrVal("Imageformat", Imageformat);
	}
	/**
	 * 患者照片提示
	 * @return String
	 */
	public String getImagememo() {
		return ((String) getAttrVal("Imagememo"));
	}
	/**
	 * 患者照片提示
	 * @param Imagememo
	 */
	public void setImagememo(String Imagememo) {
		setAttrVal("Imagememo", Imagememo);
	}
	/**
	 * 一般检查信息
	 * @return FArrayList2
	 */
	public FArrayList2 getNormalinfo() {
		return ((FArrayList2) getAttrVal("Normalinfo"));
	}
	/**
	 * 一般检查信息
	 * @param Normalinfo
	 */
	public void setNormalinfo(FArrayList2 Normalinfo) {
		setAttrVal("Normalinfo", Normalinfo);
	}
	/**
	 * 专科检查信息
	 * @return FArrayList2
	 */
	public FArrayList2 getSpecialinfo() {
		return ((FArrayList2) getAttrVal("Specialinfo"));
	}
	/**
	 * 专科检查信息
	 * @param Specialinfo
	 */
	public void setSpecialinfo(FArrayList2 Specialinfo) {
		setAttrVal("Specialinfo", Specialinfo);
	}
	/**
	 * 医技检查项目信息
	 * @return FArrayList2
	 */
	public FArrayList2 getPeinfo() {
		return ((FArrayList2) getAttrVal("Peinfo"));
	}
	/**
	 * 医技检查项目信息
	 * @param Peinfo
	 */
	public void setPeinfo(FArrayList2 Peinfo) {
		setAttrVal("Peinfo", Peinfo);
	}
	/**
	 * 实验室检验项目信息
	 * @return FArrayList2
	 */
	public FArrayList2 getLaboratoryitem() {
		return ((FArrayList2) getAttrVal("Laboratoryitem"));
	}
	/**
	 * 实验室检验项目信息
	 * @param Laboratoryitem
	 */
	public void setLaboratoryitem(FArrayList2 Laboratoryitem) {
		setAttrVal("Laboratoryitem", Laboratoryitem);
	}
	/**
	 * 体格检查异常部分: 一般检查信息
	 * @return FArrayList2
	 */
	public FArrayList2 getNormalexamination() {
		return ((FArrayList2) getAttrVal("Normalexamination"));
	}
	/**
	 * 体格检查异常部分: 一般检查信息
	 * @param Normalexamination
	 */
	public void setNormalexamination(FArrayList2 Normalexamination) {
		setAttrVal("Normalexamination", Normalexamination);
	}
	/**
	 * 体格检查异常部分: 专科检查信息
	 * @return FArrayList2
	 */
	public FArrayList2 getSpecialexamination() {
		return ((FArrayList2) getAttrVal("Specialexamination"));
	}
	/**
	 * 体格检查异常部分: 专科检查信息
	 * @param Specialexamination
	 */
	public void setSpecialexamination(FArrayList2 Specialexamination) {
		setAttrVal("Specialexamination", Specialexamination);
	}
	/**
	 * 体格检查异常部分: 医技检查信息
	 * @return FMap
	 */
	public FMap getPeexamination() {
		return ((FMap) getAttrVal("Peexamination"));
	}
	/**
	 * 体格检查异常部分: 医技检查信息
	 * @param Peexamination
	 */
	public void setPeexamination(FMap Peexamination) {
		setAttrVal("Peexamination", Peexamination);
	}
	/**
	 * 重点问题提示信息
	 * @return FArrayList2
	 */
	public FArrayList2 getSummary() {
		return ((FArrayList2) getAttrVal("Summary"));
	}
	/**
	 * 重点问题提示信息
	 * @param Summary
	 */
	public void setSummary(FArrayList2 Summary) {
		setAttrVal("Summary", Summary);
	}
	/**
	 * 健康指导建议信息
	 * @return FArrayList2
	 */
	public FArrayList2 getHealthguide() {
		return ((FArrayList2) getAttrVal("Healthguide"));
	}
	/**
	 * 健康指导建议信息
	 * @param Healthguide
	 */
	public void setHealthguide(FArrayList2 Healthguide) {
		setAttrVal("Healthguide", Healthguide);
	}
}