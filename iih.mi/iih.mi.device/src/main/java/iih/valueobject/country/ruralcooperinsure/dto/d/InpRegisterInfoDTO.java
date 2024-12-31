package iih.valueobject.country.ruralcooperinsure.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医保住院登记信息 DTO数据 
 * 
 */
public class InpRegisterInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 住院登记流水号
	 * @return String
	 */
	public String getInpno() {
		return ((String) getAttrVal("Inpno"));
	}
	/**
	 * 住院登记流水号
	 * @param Inpno
	 */
	public void setInpno(String Inpno) {
		setAttrVal("Inpno", Inpno);
	}
	/**
	 * 就医机构代码
	 * @return String
	 */
	public String getJyhoscode() {
		return ((String) getAttrVal("Jyhoscode"));
	}
	/**
	 * 就医机构代码
	 * @param Jyhoscode
	 */
	public void setJyhoscode(String Jyhoscode) {
		setAttrVal("Jyhoscode", Jyhoscode);
	}
	/**
	 * 就医机构名称
	 * @return String
	 */
	public String getJyhosname() {
		return ((String) getAttrVal("Jyhosname"));
	}
	/**
	 * 就医机构名称
	 * @param Jyhosname
	 */
	public void setJyhosname(String Jyhosname) {
		setAttrVal("Jyhosname", Jyhosname);
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
	 * 患者性别代码
	 * @return String
	 */
	public String getSexcode() {
		return ((String) getAttrVal("Sexcode"));
	}
	/**
	 * 患者性别代码
	 * @param Sexcode
	 */
	public void setSexcode(String Sexcode) {
		setAttrVal("Sexcode", Sexcode);
	}
	/**
	 * 患者性别名称
	 * @return String
	 */
	public String getSexname() {
		return ((String) getAttrVal("Sexname"));
	}
	/**
	 * 患者性别名称
	 * @param Sexname
	 */
	public void setSexname(String Sexname) {
		setAttrVal("Sexname", Sexname);
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
	 * 年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 通讯地址
	 * @return String
	 */
	public String getAddress() {
		return ((String) getAttrVal("Address"));
	}
	/**
	 * 通讯地址
	 * @param Address
	 */
	public void setAddress(String Address) {
		setAttrVal("Address", Address);
	}
	/**
	 * 参合省代码
	 * @return String
	 */
	public String getChprovincecode() {
		return ((String) getAttrVal("Chprovincecode"));
	}
	/**
	 * 参合省代码
	 * @param Chprovincecode
	 */
	public void setChprovincecode(String Chprovincecode) {
		setAttrVal("Chprovincecode", Chprovincecode);
	}
	/**
	 * 参合省名称
	 * @return String
	 */
	public String getChprovincename() {
		return ((String) getAttrVal("Chprovincename"));
	}
	/**
	 * 参合省名称
	 * @param Chprovincename
	 */
	public void setChprovincename(String Chprovincename) {
		setAttrVal("Chprovincename", Chprovincename);
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
	 * 参合区代码
	 * @return String
	 */
	public String getChdistrictcode() {
		return ((String) getAttrVal("Chdistrictcode"));
	}
	/**
	 * 参合区代码
	 * @param Chdistrictcode
	 */
	public void setChdistrictcode(String Chdistrictcode) {
		setAttrVal("Chdistrictcode", Chdistrictcode);
	}
	/**
	 * 参合区名称
	 * @return String
	 */
	public String getChdistrictname() {
		return ((String) getAttrVal("Chdistrictname"));
	}
	/**
	 * 参合区名称
	 * @param Chdistrictname
	 */
	public void setChdistrictname(String Chdistrictname) {
		setAttrVal("Chdistrictname", Chdistrictname);
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
	 * 个人编码
	 * @return String
	 */
	public String getPersoncode() {
		return ((String) getAttrVal("Personcode"));
	}
	/**
	 * 个人编码
	 * @param Personcode
	 */
	public void setPersoncode(String Personcode) {
		setAttrVal("Personcode", Personcode);
	}
	/**
	 * 身高
	 * @return String
	 */
	public String getHeight() {
		return ((String) getAttrVal("Height"));
	}
	/**
	 * 身高
	 * @param Height
	 */
	public void setHeight(String Height) {
		setAttrVal("Height", Height);
	}
	/**
	 * 体重
	 * @return String
	 */
	public String getWeight() {
		return ((String) getAttrVal("Weight"));
	}
	/**
	 * 体重
	 * @param Weight
	 */
	public void setWeight(String Weight) {
		setAttrVal("Weight", Weight);
	}
	/**
	 * 住院疾病诊断代码
	 * @return String
	 */
	public String getInpdicode() {
		return ((String) getAttrVal("Inpdicode"));
	}
	/**
	 * 住院疾病诊断代码
	 * @param Inpdicode
	 */
	public void setInpdicode(String Inpdicode) {
		setAttrVal("Inpdicode", Inpdicode);
	}
	/**
	 * 住院疾病诊断名称
	 * @return String
	 */
	public String getInpdiname() {
		return ((String) getAttrVal("Inpdiname"));
	}
	/**
	 * 住院疾病诊断名称
	 * @param Inpdiname
	 */
	public void setInpdiname(String Inpdiname) {
		setAttrVal("Inpdiname", Inpdiname);
	}
	/**
	 * 第二疾病诊断代码
	 * @return String
	 */
	public String getInpdicode2() {
		return ((String) getAttrVal("Inpdicode2"));
	}
	/**
	 * 第二疾病诊断代码
	 * @param Inpdicode2
	 */
	public void setInpdicode2(String Inpdicode2) {
		setAttrVal("Inpdicode2", Inpdicode2);
	}
	/**
	 * 第二疾病诊断名称
	 * @return String
	 */
	public String getInpdiname2() {
		return ((String) getAttrVal("Inpdiname2"));
	}
	/**
	 * 第二疾病诊断名称
	 * @param Inpdiname2
	 */
	public void setInpdiname2(String Inpdiname2) {
		setAttrVal("Inpdiname2", Inpdiname2);
	}
	/**
	 * 手术编码
	 * @return String
	 */
	public String getSurgerycode() {
		return ((String) getAttrVal("Surgerycode"));
	}
	/**
	 * 手术编码
	 * @param Surgerycode
	 */
	public void setSurgerycode(String Surgerycode) {
		setAttrVal("Surgerycode", Surgerycode);
	}
	/**
	 * 手术名称
	 * @return String
	 */
	public String getSurgeryname() {
		return ((String) getAttrVal("Surgeryname"));
	}
	/**
	 * 手术名称
	 * @param Surgeryname
	 */
	public void setSurgeryname(String Surgeryname) {
		setAttrVal("Surgeryname", Surgeryname);
	}
	/**
	 * 治疗编码
	 * @return String
	 */
	public String getCurecode() {
		return ((String) getAttrVal("Curecode"));
	}
	/**
	 * 治疗编码
	 * @param Curecode
	 */
	public void setCurecode(String Curecode) {
		setAttrVal("Curecode", Curecode);
	}
	/**
	 * 治疗名称
	 * @return String
	 */
	public String getCurename() {
		return ((String) getAttrVal("Curename"));
	}
	/**
	 * 治疗名称
	 * @param Curename
	 */
	public void setCurename(String Curename) {
		setAttrVal("Curename", Curename);
	}
	/**
	 * 入院科室代码
	 * @return String
	 */
	public String getDepcode() {
		return ((String) getAttrVal("Depcode"));
	}
	/**
	 * 入院科室代码
	 * @param Depcode
	 */
	public void setDepcode(String Depcode) {
		setAttrVal("Depcode", Depcode);
	}
	/**
	 * 入院科室名称
	 * @return String
	 */
	public String getDepname() {
		return ((String) getAttrVal("Depname"));
	}
	/**
	 * 入院科室名称
	 * @param Depname
	 */
	public void setDepname(String Depname) {
		setAttrVal("Depname", Depname);
	}
	/**
	 * 就诊类型代码
	 * @return String
	 */
	public String getHp_enttp() {
		return ((String) getAttrVal("Hp_enttp"));
	}
	/**
	 * 就诊类型代码
	 * @param Hp_enttp
	 */
	public void setHp_enttp(String Hp_enttp) {
		setAttrVal("Hp_enttp", Hp_enttp);
	}
	/**
	 * 就诊类型名称
	 * @return String
	 */
	public String getHp_enttpname() {
		return ((String) getAttrVal("Hp_enttpname"));
	}
	/**
	 * 就诊类型名称
	 * @param Hp_enttpname
	 */
	public void setHp_enttpname(String Hp_enttpname) {
		setAttrVal("Hp_enttpname", Hp_enttpname);
	}
	/**
	 * 并发症编码
	 * @return String
	 */
	public String getComplicationcode() {
		return ((String) getAttrVal("Complicationcode"));
	}
	/**
	 * 并发症编码
	 * @param Complicationcode
	 */
	public void setComplicationcode(String Complicationcode) {
		setAttrVal("Complicationcode", Complicationcode);
	}
	/**
	 * 并发症名称
	 * @return String
	 */
	public String getComplicationname() {
		return ((String) getAttrVal("Complicationname"));
	}
	/**
	 * 并发症名称
	 * @param Complicationname
	 */
	public void setComplicationname(String Complicationname) {
		setAttrVal("Complicationname", Complicationname);
	}
	/**
	 * 来院状态编码
	 * @return String
	 */
	public String getInhos_status() {
		return ((String) getAttrVal("Inhos_status"));
	}
	/**
	 * 来院状态编码
	 * @param Inhos_status
	 */
	public void setInhos_status(String Inhos_status) {
		setAttrVal("Inhos_status", Inhos_status);
	}
	/**
	 * 来院状态名称
	 * @return String
	 */
	public String getInhos_statusname() {
		return ((String) getAttrVal("Inhos_statusname"));
	}
	/**
	 * 来院状态名称
	 * @param Inhos_statusname
	 */
	public void setInhos_statusname(String Inhos_statusname) {
		setAttrVal("Inhos_statusname", Inhos_statusname);
	}
	/**
	 * 联系人
	 * @return String
	 */
	public String getContactor() {
		return ((String) getAttrVal("Contactor"));
	}
	/**
	 * 联系人
	 * @param Contactor
	 */
	public void setContactor(String Contactor) {
		setAttrVal("Contactor", Contactor);
	}
	/**
	 * 电话号码
	 * @return String
	 */
	public String getPhone() {
		return ((String) getAttrVal("Phone"));
	}
	/**
	 * 电话号码
	 * @param Phone
	 */
	public void setPhone(String Phone) {
		setAttrVal("Phone", Phone);
	}
	/**
	 * 医生姓名
	 * @return String
	 */
	public String getDoctorname() {
		return ((String) getAttrVal("Doctorname"));
	}
	/**
	 * 医生姓名
	 * @param Doctorname
	 */
	public void setDoctorname(String Doctorname) {
		setAttrVal("Doctorname", Doctorname);
	}
	/**
	 * 入院时间
	 * @return String
	 */
	public String getDt_entry() {
		return ((String) getAttrVal("Dt_entry"));
	}
	/**
	 * 入院时间
	 * @param Dt_entry
	 */
	public void setDt_entry(String Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 入院号
	 * @return String
	 */
	public String getEnt_code() {
		return ((String) getAttrVal("Ent_code"));
	}
	/**
	 * 入院号
	 * @param Ent_code
	 */
	public void setEnt_code(String Ent_code) {
		setAttrVal("Ent_code", Ent_code);
	}
	/**
	 * 病床号
	 * @return String
	 */
	public String getBedno() {
		return ((String) getAttrVal("Bedno"));
	}
	/**
	 * 病床号
	 * @param Bedno
	 */
	public void setBedno(String Bedno) {
		setAttrVal("Bedno", Bedno);
	}
	/**
	 * 入院病区
	 * @return String
	 */
	public String getNurdep() {
		return ((String) getAttrVal("Nurdep"));
	}
	/**
	 * 入院病区
	 * @param Nurdep
	 */
	public void setNurdep(String Nurdep) {
		setAttrVal("Nurdep", Nurdep);
	}
	/**
	 * 转诊类型代码
	 * @return String
	 */
	public String getReferraltp() {
		return ((String) getAttrVal("Referraltp"));
	}
	/**
	 * 转诊类型代码
	 * @param Referraltp
	 */
	public void setReferraltp(String Referraltp) {
		setAttrVal("Referraltp", Referraltp);
	}
	/**
	 * 转诊类型名称
	 * @return String
	 */
	public String getReferraltpname() {
		return ((String) getAttrVal("Referraltpname"));
	}
	/**
	 * 转诊类型名称
	 * @param Referraltpname
	 */
	public void setReferraltpname(String Referraltpname) {
		setAttrVal("Referraltpname", Referraltpname);
	}
	/**
	 * 转诊单号
	 * @return String
	 */
	public String getReferralcode() {
		return ((String) getAttrVal("Referralcode"));
	}
	/**
	 * 转诊单号
	 * @param Referralcode
	 */
	public void setReferralcode(String Referralcode) {
		setAttrVal("Referralcode", Referralcode);
	}
	/**
	 * 转诊日期
	 * @return String
	 */
	public String getReferraldate() {
		return ((String) getAttrVal("Referraldate"));
	}
	/**
	 * 转诊日期
	 * @param Referraldate
	 */
	public void setReferraldate(String Referraldate) {
		setAttrVal("Referraldate", Referraldate);
	}
	/**
	 * 收费收据号
	 * @return String
	 */
	public String getIncno() {
		return ((String) getAttrVal("Incno"));
	}
	/**
	 * 收费收据号
	 * @param Incno
	 */
	public void setIncno(String Incno) {
		setAttrVal("Incno", Incno);
	}
	/**
	 * 民政通知书号
	 * @return String
	 */
	public String getCivilnoticecode() {
		return ((String) getAttrVal("Civilnoticecode"));
	}
	/**
	 * 民政通知书号
	 * @param Civilnoticecode
	 */
	public void setCivilnoticecode(String Civilnoticecode) {
		setAttrVal("Civilnoticecode", Civilnoticecode);
	}
	/**
	 * 生育证号
	 * @return String
	 */
	public String getBirthcerticode() {
		return ((String) getAttrVal("Birthcerticode"));
	}
	/**
	 * 生育证号
	 * @param Birthcerticode
	 */
	public void setBirthcerticode(String Birthcerticode) {
		setAttrVal("Birthcerticode", Birthcerticode);
	}
	/**
	 * 医疗证/卡号
	 * @return String
	 */
	public String getMedicalcerticode() {
		return ((String) getAttrVal("Medicalcerticode"));
	}
	/**
	 * 医疗证/卡号
	 * @param Medicalcerticode
	 */
	public void setMedicalcerticode(String Medicalcerticode) {
		setAttrVal("Medicalcerticode", Medicalcerticode);
	}
	/**
	 * 出生日期
	 * @return String
	 */
	public String getBirth() {
		return ((String) getAttrVal("Birth"));
	}
	/**
	 * 出生日期
	 * @param Birth
	 */
	public void setBirth(String Birth) {
		setAttrVal("Birth", Birth);
	}
	/**
	 * 创建日期
	 * @return String
	 */
	public String getCreatedate() {
		return ((String) getAttrVal("Createdate"));
	}
	/**
	 * 创建日期
	 * @param Createdate
	 */
	public void setCreatedate(String Createdate) {
		setAttrVal("Createdate", Createdate);
	}
	/**
	 * 更新日期
	 * @return String
	 */
	public String getUpdatetdate() {
		return ((String) getAttrVal("Updatetdate"));
	}
	/**
	 * 更新日期
	 * @param Updatetdate
	 */
	public void setUpdatetdate(String Updatetdate) {
		setAttrVal("Updatetdate", Updatetdate);
	}
	/**
	 * 操作者代码
	 * @return String
	 */
	public String getOperatorcode() {
		return ((String) getAttrVal("Operatorcode"));
	}
	/**
	 * 操作者代码
	 * @param Operatorcode
	 */
	public void setOperatorcode(String Operatorcode) {
		setAttrVal("Operatorcode", Operatorcode);
	}
	/**
	 * 操作者姓名
	 * @return String
	 */
	public String getOperatorname() {
		return ((String) getAttrVal("Operatorname"));
	}
	/**
	 * 操作者姓名
	 * @param Operatorname
	 */
	public void setOperatorname(String Operatorname) {
		setAttrVal("Operatorname", Operatorname);
	}
}