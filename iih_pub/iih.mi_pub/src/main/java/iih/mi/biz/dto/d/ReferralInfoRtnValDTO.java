package iih.mi.biz.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 转诊单信息 DTO数据 
 * 
 */
public class ReferralInfoRtnValDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	

	//出参全集
	public static final String IDCARDSTORE= "Idcardstore";
	public static final String UPDATETIME= "Updatetime";
	public static final String HOSIN3NAME= "Hosin3name";
	public static final String BANKACCOUNT_NO= "Bankaccount_no";
	public static final String APPLYNOTE= "Applynote";
	public static final String PATPHONE= "Patphone";
	public static final String AUDITORNAME= "Auditorname";
	public static final String PAYTP_NAME= "Paytp_name";
	public static final String CHCITYCODE= "Chcitycode";
	public static final String HOSIN2NAME= "Hosin2name";
	public static final String MEDICALCODE= "Medicalcode";
	public static final String SEXCODE= "Sexcode";
	public static final String PATNAME= "Patname";
	public static final String REFERRALSTATUS= "Referralstatus";
	public static final String HOSIN2CODE= "Hosin2code";
	public static final String GRAVEASSIST_IDENT= "Graveassist_ident";
	public static final String APPLYDATE= "Applydate";
	public static final String BANKNAME= "Bankname";
	public static final String REFERRALTP_NAME= "Referraltp_name";
	public static final String CHPROVCODE= "Chprovcode";
	public static final String IDCARD= "Idcard";
	public static final String AGENCIESCODE= "Agenciescode";
	public static final String HOSINNAME= "Hosinname";
	public static final String HOSFROMCODE= "Hosfromcode";
	public static final String AUDITDATE= "Auditdate";
	public static final String AUDITNOTE= "Auditnote";
	public static final String CHAREACODE= "Chareacode";
	public static final String BIRTHDAY= "Birthday";
	public static final String BANKACCOUNT_NAME= "Bankaccount_name";
	public static final String HOUSEMASTER_REL= "Housemaster_rel";
	public static final String AUDITSTATUSNAME= "Auditstatusname";
	public static final String INSTITUCONTACTOR= "Institucontactor";
	public static final String DRGS_NAME= "Drgs_name";
	public static final String REFERRALTP_CODE= "Referraltp_code";
	public static final String PATCONTACTOR= "Patcontactor";
	public static final String CREATETIME= "Createtime";
	public static final String MEDICALCODESTORE= "Medicalcodestore";
	public static final String CHPROVNAME= "Chprovname";
	public static final String AGENCIESNAME= "Agenciesname";
	public static final String PAYTP_CODE= "Paytp_code";
	public static final String DICODE= "Dicode";
	public static final String HOSFROMNAME= "Hosfromname";
	public static final String ACCUMULAMT= "Accumulamt";
	public static final String CIVILASSIST_IDENT= "Civilassist_ident";
	public static final String CHAREANAME= "Chareaname";
	public static final String REFERRALCODE= "Referralcode";
	public static final String FAMILYCODE= "Familycode";
	public static final String INSTITUMAIL= "Institumail";
	public static final String HOSINCODE= "Hosincode";
	public static final String HOSIN3CODE= "Hosin3code";
	public static final String INSTITUCONTACTWAY= "Institucontactway";
	public static final String DT_ENTRY= "Dt_entry";
	public static final String PERSONCODE= "Personcode";
	public static final String CHCITYNAME= "Chcityname";
	public static final String SEXNAME= "Sexname";
	public static final String DINAME= "Diname";
	public static final String DRGS_CODE= "Drgs_code";
	
	/**
	 * 转诊单编码
	 * @return String
	 */
	public String getReferralcode() {
		return ((String) getAttrVal("Referralcode"));
	}
	/**
	 * 转诊单编码
	 * @param Referralcode
	 */
	public void setReferralcode(String Referralcode) {
		setAttrVal("Referralcode", Referralcode);
	}
	/**
	 * 个人代码
	 * @return String
	 */
	public String getPersoncode() {
		return ((String) getAttrVal("Personcode"));
	}
	/**
	 * 个人代码
	 * @param Personcode
	 */
	public void setPersoncode(String Personcode) {
		setAttrVal("Personcode", Personcode);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPatname() {
		return ((String) getAttrVal("Patname"));
	}
	/**
	 * 患者姓名
	 * @param Patname
	 */
	public void setPatname(String Patname) {
		setAttrVal("Patname", Patname);
	}
	/**
	 * 疾病编码
	 * @return String
	 */
	public String getDicode() {
		return ((String) getAttrVal("Dicode"));
	}
	/**
	 * 疾病编码
	 * @param Dicode
	 */
	public void setDicode(String Dicode) {
		setAttrVal("Dicode", Dicode);
	}
	/**
	 * 申请日期
	 * @return String
	 */
	public String getApplydate() {
		return ((String) getAttrVal("Applydate"));
	}
	/**
	 * 申请日期
	 * @param Applydate
	 */
	public void setApplydate(String Applydate) {
		setAttrVal("Applydate", Applydate);
	}
	/**
	 * 申请说明
	 * @return String
	 */
	public String getApplynote() {
		return ((String) getAttrVal("Applynote"));
	}
	/**
	 * 申请说明
	 * @param Applynote
	 */
	public void setApplynote(String Applynote) {
		setAttrVal("Applynote", Applynote);
	}
	/**
	 * 经办机构代码
	 * @return String
	 */
	public String getAgenciescode() {
		return ((String) getAttrVal("Agenciescode"));
	}
	/**
	 * 经办机构代码
	 * @param Agenciescode
	 */
	public void setAgenciescode(String Agenciescode) {
		setAttrVal("Agenciescode", Agenciescode);
	}
	/**
	 * 转出医院代码
	 * @return String
	 */
	public String getHosfromcode() {
		return ((String) getAttrVal("Hosfromcode"));
	}
	/**
	 * 转出医院代码
	 * @param Hosfromcode
	 */
	public void setHosfromcode(String Hosfromcode) {
		setAttrVal("Hosfromcode", Hosfromcode);
	}
	/**
	 * 转入医院代码
	 * @return String
	 */
	public String getHosincode() {
		return ((String) getAttrVal("Hosincode"));
	}
	/**
	 * 转入医院代码
	 * @param Hosincode
	 */
	public void setHosincode(String Hosincode) {
		setAttrVal("Hosincode", Hosincode);
	}
	/**
	 * 转诊状态
	 * @return String
	 */
	public String getReferralstatus() {
		return ((String) getAttrVal("Referralstatus"));
	}
	/**
	 * 转诊状态
	 * @param Referralstatus
	 */
	public void setReferralstatus(String Referralstatus) {
		setAttrVal("Referralstatus", Referralstatus);
	}
	/**
	 * 审核日期
	 * @return String
	 */
	public String getAuditdate() {
		return ((String) getAttrVal("Auditdate"));
	}
	/**
	 * 审核日期
	 * @param Auditdate
	 */
	public void setAuditdate(String Auditdate) {
		setAttrVal("Auditdate", Auditdate);
	}
	/**
	 * 参合区（县）地区代码
	 * @return String
	 */
	public String getChareacode() {
		return ((String) getAttrVal("Chareacode"));
	}
	/**
	 * 参合区（县）地区代码
	 * @param Chareacode
	 */
	public void setChareacode(String Chareacode) {
		setAttrVal("Chareacode", Chareacode);
	}
	/**
	 * 疾病名称
	 * @return String
	 */
	public String getDiname() {
		return ((String) getAttrVal("Diname"));
	}
	/**
	 * 疾病名称
	 * @param Diname
	 */
	public void setDiname(String Diname) {
		setAttrVal("Diname", Diname);
	}
	/**
	 * 经办机构名称
	 * @return String
	 */
	public String getAgenciesname() {
		return ((String) getAttrVal("Agenciesname"));
	}
	/**
	 * 经办机构名称
	 * @param Agenciesname
	 */
	public void setAgenciesname(String Agenciesname) {
		setAttrVal("Agenciesname", Agenciesname);
	}
	/**
	 * 转出医院名称
	 * @return String
	 */
	public String getHosfromname() {
		return ((String) getAttrVal("Hosfromname"));
	}
	/**
	 * 转出医院名称
	 * @param Hosfromname
	 */
	public void setHosfromname(String Hosfromname) {
		setAttrVal("Hosfromname", Hosfromname);
	}
	/**
	 * 转入医院名称
	 * @return String
	 */
	public String getHosinname() {
		return ((String) getAttrVal("Hosinname"));
	}
	/**
	 * 转入医院名称
	 * @param Hosinname
	 */
	public void setHosinname(String Hosinname) {
		setAttrVal("Hosinname", Hosinname);
	}
	/**
	 * 审核人姓名
	 * @return String
	 */
	public String getAuditorname() {
		return ((String) getAttrVal("Auditorname"));
	}
	/**
	 * 审核人姓名
	 * @param Auditorname
	 */
	public void setAuditorname(String Auditorname) {
		setAttrVal("Auditorname", Auditorname);
	}
	/**
	 * 审核说明
	 * @return String
	 */
	public String getAuditnote() {
		return ((String) getAttrVal("Auditnote"));
	}
	/**
	 * 审核说明
	 * @param Auditnote
	 */
	public void setAuditnote(String Auditnote) {
		setAttrVal("Auditnote", Auditnote);
	}
	/**
	 * 参合区（县）地区名称
	 * @return String
	 */
	public String getChareaname() {
		return ((String) getAttrVal("Chareaname"));
	}
	/**
	 * 参合区（县）地区名称
	 * @param Chareaname
	 */
	public void setChareaname(String Chareaname) {
		setAttrVal("Chareaname", Chareaname);
	}
	/**
	 * 审核状态名称
	 * @return String
	 */
	public String getAuditstatusname() {
		return ((String) getAttrVal("Auditstatusname"));
	}
	/**
	 * 审核状态名称
	 * @param Auditstatusname
	 */
	public void setAuditstatusname(String Auditstatusname) {
		setAttrVal("Auditstatusname", Auditstatusname);
	}
	/**
	 * 身份证号
	 * @return String
	 */
	public String getIdcard() {
		return ((String) getAttrVal("Idcard"));
	}
	/**
	 * 身份证号
	 * @param Idcard
	 */
	public void setIdcard(String Idcard) {
		setAttrVal("Idcard", Idcard);
	}
	/**
	 * 身份证号存储地址
	 * @return String
	 */
	public String getIdcardstore() {
		return ((String) getAttrVal("Idcardstore"));
	}
	/**
	 * 身份证号存储地址
	 * @param Idcardstore
	 */
	public void setIdcardstore(String Idcardstore) {
		setAttrVal("Idcardstore", Idcardstore);
	}
	/**
	 * 医疗证号
	 * @return String
	 */
	public String getMedicalcode() {
		return ((String) getAttrVal("Medicalcode"));
	}
	/**
	 * 医疗证号
	 * @param Medicalcode
	 */
	public void setMedicalcode(String Medicalcode) {
		setAttrVal("Medicalcode", Medicalcode);
	}
	/**
	 * 医疗证号存储地址
	 * @return String
	 */
	public String getMedicalcodestore() {
		return ((String) getAttrVal("Medicalcodestore"));
	}
	/**
	 * 医疗证号存储地址
	 * @param Medicalcodestore
	 */
	public void setMedicalcodestore(String Medicalcodestore) {
		setAttrVal("Medicalcodestore", Medicalcodestore);
	}
	/**
	 * 就诊日期
	 * @return String
	 */
	public String getDt_entry() {
		return ((String) getAttrVal("Dt_entry"));
	}
	/**
	 * 就诊日期
	 * @param Dt_entry
	 */
	public void setDt_entry(String Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 性别代码
	 * @return String
	 */
	public String getSexcode() {
		return ((String) getAttrVal("Sexcode"));
	}
	/**
	 * 性别代码
	 * @param Sexcode
	 */
	public void setSexcode(String Sexcode) {
		setAttrVal("Sexcode", Sexcode);
	}
	/**
	 * 性别名称
	 * @return String
	 */
	public String getSexname() {
		return ((String) getAttrVal("Sexname"));
	}
	/**
	 * 性别名称
	 * @param Sexname
	 */
	public void setSexname(String Sexname) {
		setAttrVal("Sexname", Sexname);
	}
	/**
	 * 机构联系人
	 * @return String
	 */
	public String getInstitucontactor() {
		return ((String) getAttrVal("Institucontactor"));
	}
	/**
	 * 机构联系人
	 * @param Institucontactor
	 */
	public void setInstitucontactor(String Institucontactor) {
		setAttrVal("Institucontactor", Institucontactor);
	}
	/**
	 * 机构联系方式
	 * @return String
	 */
	public String getInstitucontactway() {
		return ((String) getAttrVal("Institucontactway"));
	}
	/**
	 * 机构联系方式
	 * @param Institucontactway
	 */
	public void setInstitucontactway(String Institucontactway) {
		setAttrVal("Institucontactway", Institucontactway);
	}
	/**
	 * 机构联系邮箱
	 * @return String
	 */
	public String getInstitumail() {
		return ((String) getAttrVal("Institumail"));
	}
	/**
	 * 机构联系邮箱
	 * @param Institumail
	 */
	public void setInstitumail(String Institumail) {
		setAttrVal("Institumail", Institumail);
	}
	/**
	 * 生日
	 * @return String
	 */
	public String getBirthday() {
		return ((String) getAttrVal("Birthday"));
	}
	/**
	 * 生日
	 * @param Birthday
	 */
	public void setBirthday(String Birthday) {
		setAttrVal("Birthday", Birthday);
	}
	/**
	 * 创建时间
	 * @return String
	 */
	public String getCreatetime() {
		return ((String) getAttrVal("Createtime"));
	}
	/**
	 * 创建时间
	 * @param Createtime
	 */
	public void setCreatetime(String Createtime) {
		setAttrVal("Createtime", Createtime);
	}
	/**
	 * 更新时间
	 * @return String
	 */
	public String getUpdatetime() {
		return ((String) getAttrVal("Updatetime"));
	}
	/**
	 * 更新时间
	 * @param Updatetime
	 */
	public void setUpdatetime(String Updatetime) {
		setAttrVal("Updatetime", Updatetime);
	}
	/**
	 * 单病种代码
	 * @return String
	 */
	public String getDrgs_code() {
		return ((String) getAttrVal("Drgs_code"));
	}
	/**
	 * 单病种代码
	 * @param Drgs_code
	 */
	public void setDrgs_code(String Drgs_code) {
		setAttrVal("Drgs_code", Drgs_code);
	}
	/**
	 * 单病种名称
	 * @return String
	 */
	public String getDrgs_name() {
		return ((String) getAttrVal("Drgs_name"));
	}
	/**
	 * 单病种名称
	 * @param Drgs_name
	 */
	public void setDrgs_name(String Drgs_name) {
		setAttrVal("Drgs_name", Drgs_name);
	}
	/**
	 * 患者联系人
	 * @return String
	 */
	public String getPatcontactor() {
		return ((String) getAttrVal("Patcontactor"));
	}
	/**
	 * 患者联系人
	 * @param Patcontactor
	 */
	public void setPatcontactor(String Patcontactor) {
		setAttrVal("Patcontactor", Patcontactor);
	}
	/**
	 * 患者联系电话
	 * @return String
	 */
	public String getPatphone() {
		return ((String) getAttrVal("Patphone"));
	}
	/**
	 * 患者联系电话
	 * @param Patphone
	 */
	public void setPatphone(String Patphone) {
		setAttrVal("Patphone", Patphone);
	}
	/**
	 * 民政救助标识
	 * @return String
	 */
	public String getCivilassist_ident() {
		return ((String) getAttrVal("Civilassist_ident"));
	}
	/**
	 * 民政救助标识
	 * @param Civilassist_ident
	 */
	public void setCivilassist_ident(String Civilassist_ident) {
		setAttrVal("Civilassist_ident", Civilassist_ident);
	}
	/**
	 * 大病救助标识
	 * @return String
	 */
	public String getGraveassist_ident() {
		return ((String) getAttrVal("Graveassist_ident"));
	}
	/**
	 * 大病救助标识
	 * @param Graveassist_ident
	 */
	public void setGraveassist_ident(String Graveassist_ident) {
		setAttrVal("Graveassist_ident", Graveassist_ident);
	}
	/**
	 * 家庭编码
	 * @return String
	 */
	public String getFamilycode() {
		return ((String) getAttrVal("Familycode"));
	}
	/**
	 * 家庭编码
	 * @param Familycode
	 */
	public void setFamilycode(String Familycode) {
		setAttrVal("Familycode", Familycode);
	}
	/**
	 * 转入医院 2 代码
	 * @return String
	 */
	public String getHosin2code() {
		return ((String) getAttrVal("Hosin2code"));
	}
	/**
	 * 转入医院 2 代码
	 * @param Hosin2code
	 */
	public void setHosin2code(String Hosin2code) {
		setAttrVal("Hosin2code", Hosin2code);
	}
	/**
	 * 转入医院 2 名称
	 * @return String
	 */
	public String getHosin2name() {
		return ((String) getAttrVal("Hosin2name"));
	}
	/**
	 * 转入医院 2 名称
	 * @param Hosin2name
	 */
	public void setHosin2name(String Hosin2name) {
		setAttrVal("Hosin2name", Hosin2name);
	}
	/**
	 * 转入医院 3 代码
	 * @return String
	 */
	public String getHosin3code() {
		return ((String) getAttrVal("Hosin3code"));
	}
	/**
	 * 转入医院 3 代码
	 * @param Hosin3code
	 */
	public void setHosin3code(String Hosin3code) {
		setAttrVal("Hosin3code", Hosin3code);
	}
	/**
	 * 转入医院 3名称	
	 * @return String
	 */
	public String getHosin3name() {
		return ((String) getAttrVal("Hosin3name"));
	}
	/**
	 * 转入医院 3名称	
	 * @param Hosin3name
	 */
	public void setHosin3name(String Hosin3name) {
		setAttrVal("Hosin3name", Hosin3name);
	}
	/**
	 * 累计金额
	 * @return String
	 */
	public String getAccumulamt() {
		return ((String) getAttrVal("Accumulamt"));
	}
	/**
	 * 累计金额
	 * @param Accumulamt
	 */
	public void setAccumulamt(String Accumulamt) {
		setAttrVal("Accumulamt", Accumulamt);
	}
	/**
	 * 账户名称
	 * @return String
	 */
	public String getBankaccount_name() {
		return ((String) getAttrVal("Bankaccount_name"));
	}
	/**
	 * 账户名称
	 * @param Bankaccount_name
	 */
	public void setBankaccount_name(String Bankaccount_name) {
		setAttrVal("Bankaccount_name", Bankaccount_name);
	}
	/**
	 * 银行账号
	 * @return String
	 */
	public String getBankaccount_no() {
		return ((String) getAttrVal("Bankaccount_no"));
	}
	/**
	 * 银行账号
	 * @param Bankaccount_no
	 */
	public void setBankaccount_no(String Bankaccount_no) {
		setAttrVal("Bankaccount_no", Bankaccount_no);
	}
	/**
	 * 开户银行名称
	 * @return String
	 */
	public String getBankname() {
		return ((String) getAttrVal("Bankname"));
	}
	/**
	 * 开户银行名称
	 * @param Bankname
	 */
	public void setBankname(String Bankname) {
		setAttrVal("Bankname", Bankname);
	}
	/**
	 * 医疗付费方式代码
	 * @return String
	 */
	public String getPaytp_code() {
		return ((String) getAttrVal("Paytp_code"));
	}
	/**
	 * 医疗付费方式代码
	 * @param Paytp_code
	 */
	public void setPaytp_code(String Paytp_code) {
		setAttrVal("Paytp_code", Paytp_code);
	}
	/**
	 * 医疗付费方式名称
	 * @return String
	 */
	public String getPaytp_name() {
		return ((String) getAttrVal("Paytp_name"));
	}
	/**
	 * 医疗付费方式名称
	 * @param Paytp_name
	 */
	public void setPaytp_name(String Paytp_name) {
		setAttrVal("Paytp_name", Paytp_name);
	}
	/**
	 * 参合省代码
	 * @return String
	 */
	public String getChprovcode() {
		return ((String) getAttrVal("Chprovcode"));
	}
	/**
	 * 参合省代码
	 * @param Chprovcode
	 */
	public void setChprovcode(String Chprovcode) {
		setAttrVal("Chprovcode", Chprovcode);
	}
	/**
	 * 参合省名称
	 * @return String
	 */
	public String getChprovname() {
		return ((String) getAttrVal("Chprovname"));
	}
	/**
	 * 参合省名称
	 * @param Chprovname
	 */
	public void setChprovname(String Chprovname) {
		setAttrVal("Chprovname", Chprovname);
	}
	/**
	 * 参合市代码
	 * @return String
	 */
	public String getChcitycode() {
		return ((String) getAttrVal("Chcitycode"));
	}
	/**
	 * 参合市代码
	 * @param Chcitycode
	 */
	public void setChcitycode(String Chcitycode) {
		setAttrVal("Chcitycode", Chcitycode);
	}
	/**
	 * 参合市名称
	 * @return String
	 */
	public String getChcityname() {
		return ((String) getAttrVal("Chcityname"));
	}
	/**
	 * 参合市名称
	 * @param Chcityname
	 */
	public void setChcityname(String Chcityname) {
		setAttrVal("Chcityname", Chcityname);
	}
	/**
	 * 转诊类型代码
	 * @return String
	 */
	public String getReferraltp_code() {
		return ((String) getAttrVal("Referraltp_code"));
	}
	/**
	 * 转诊类型代码
	 * @param Referraltp_code
	 */
	public void setReferraltp_code(String Referraltp_code) {
		setAttrVal("Referraltp_code", Referraltp_code);
	}
	/**
	 * 转诊类型名称
	 * @return String
	 */
	public String getReferraltp_name() {
		return ((String) getAttrVal("Referraltp_name"));
	}
	/**
	 * 转诊类型名称
	 * @param Referraltp_name
	 */
	public void setReferraltp_name(String Referraltp_name) {
		setAttrVal("Referraltp_name", Referraltp_name);
	}
	/**
	 * 与户主关系
	 * @return String
	 */
	public String getHousemaster_rel() {
		return ((String) getAttrVal("Housemaster_rel"));
	}
	/**
	 * 与户主关系
	 * @param Housemaster_rel
	 */
	public void setHousemaster_rel(String Housemaster_rel) {
		setAttrVal("Housemaster_rel", Housemaster_rel);
	}
}