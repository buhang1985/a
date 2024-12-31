package iih.pis.phk.render.patientdata.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者管家_患者信息 DTO数据 
 * 
 */
public class PatientData extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者编码
	 * @return String
	 */
	public String getPatcode() {
		return ((String) getAttrVal("Patcode"));
	}
	/**
	 * 患者编码
	 * @param Patcode
	 */
	public void setPatcode(String Patcode) {
		setAttrVal("Patcode", Patcode);
	}
	/**
	 * 就诊队列id
	 * @return String
	 */
	public String getId_entque() {
		return ((String) getAttrVal("Id_entque"));
	}
	/**
	 * 就诊队列id
	 * @param Id_entque
	 */
	public void setId_entque(String Id_entque) {
		setAttrVal("Id_entque", Id_entque);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 患者姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getPatdirthdate() {
		return ((FDate) getAttrVal("Patdirthdate"));
	}
	/**
	 * 出生日期
	 * @param Patdirthdate
	 */
	public void setPatdirthdate(FDate Patdirthdate) {
		setAttrVal("Patdirthdate", Patdirthdate);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getSex() {
		return ((String) getAttrVal("Sex"));
	}
	/**
	 * 性别
	 * @param Sex
	 */
	public void setSex(String Sex) {
		setAttrVal("Sex", Sex);
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
	 * 患者等级
	 * @return String
	 */
	public String getPatgrade() {
		return ((String) getAttrVal("Patgrade"));
	}
	/**
	 * 患者等级
	 * @param Patgrade
	 */
	public void setPatgrade(String Patgrade) {
		setAttrVal("Patgrade", Patgrade);
	}
	/**
	 * 患者收费等级
	 * @return String
	 */
	public String getPatfeegrade() {
		return ((String) getAttrVal("Patfeegrade"));
	}
	/**
	 * 患者收费等级
	 * @param Patfeegrade
	 */
	public void setPatfeegrade(String Patfeegrade) {
		setAttrVal("Patfeegrade", Patfeegrade);
	}
	/**
	 * 固定电话
	 * @return String
	 */
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}
	/**
	 * 固定电话
	 * @param Tel
	 */
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	/**
	 * 电话
	 * @return String
	 */
	public String getMobile() {
		return ((String) getAttrVal("Mobile"));
	}
	/**
	 * 电话
	 * @param Mobile
	 */
	public void setMobile(String Mobile) {
		setAttrVal("Mobile", Mobile);
	}
	/**
	 * 患者地址
	 * @return String
	 */
	public String getPataddr() {
		return ((String) getAttrVal("Pataddr"));
	}
	/**
	 * 患者地址
	 * @param Pataddr
	 */
	public void setPataddr(String Pataddr) {
		setAttrVal("Pataddr", Pataddr);
	}
	/**
	 * 患者先住址
	 * @return String
	 */
	public String getPatcomaddr() {
		return ((String) getAttrVal("Patcomaddr"));
	}
	/**
	 * 患者先住址
	 * @param Patcomaddr
	 */
	public void setPatcomaddr(String Patcomaddr) {
		setAttrVal("Patcomaddr", Patcomaddr);
	}
	/**
	 * 证件号
	 * @return String
	 */
	public String getIdentityno() {
		return ((String) getAttrVal("Identityno"));
	}
	/**
	 * 证件号
	 * @param Identityno
	 */
	public void setIdentityno(String Identityno) {
		setAttrVal("Identityno", Identityno);
	}
	/**
	 * 孕期
	 * @return String
	 */
	public String getGestation() {
		return ((String) getAttrVal("Gestation"));
	}
	/**
	 * 孕期
	 * @param Gestation
	 */
	public void setGestation(String Gestation) {
		setAttrVal("Gestation", Gestation);
	}
	/**
	 * 开始时间
	 * @return String
	 */
	public String getBegindate() {
		return ((String) getAttrVal("Begindate"));
	}
	/**
	 * 开始时间
	 * @param Begindate
	 */
	public void setBegindate(String Begindate) {
		setAttrVal("Begindate", Begindate);
	}
	/**
	 * 结束时间
	 * @return String
	 */
	public String getEnddate() {
		return ((String) getAttrVal("Enddate"));
	}
	/**
	 * 结束时间
	 * @param Enddate
	 */
	public void setEnddate(String Enddate) {
		setAttrVal("Enddate", Enddate);
	}
	/**
	 * 头像
	 * @return byte[]
	 */
	public byte[] getPhoto() {
		return ((byte[]) getAttrVal("Photo"));
	}
	/**
	 * 头像
	 * @param Photo
	 */
	public void setPhoto(byte[] Photo) {
		setAttrVal("Photo", Photo);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getDiagnosisno() {
		return ((String) getAttrVal("Diagnosisno"));
	}
	/**
	 * 就诊号
	 * @param Diagnosisno
	 */
	public void setDiagnosisno(String Diagnosisno) {
		setAttrVal("Diagnosisno", Diagnosisno);
	}
	/**
	 * 最后月经期
	 * @return FDate
	 */
	public FDate getD_last_menst() {
		return ((FDate) getAttrVal("D_last_menst"));
	}
	/**
	 * 最后月经期
	 * @param D_last_menst
	 */
	public void setD_last_menst(FDate D_last_menst) {
		setAttrVal("D_last_menst", D_last_menst);
	}
	/**
	 * 患者Id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者Id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 管家
	 * @return String
	 */
	public String getId_phk_emp() {
		return ((String) getAttrVal("Id_phk_emp"));
	}
	/**
	 * 管家
	 * @param Id_phk_emp
	 */
	public void setId_phk_emp(String Id_phk_emp) {
		setAttrVal("Id_phk_emp", Id_phk_emp);
	}
	/**
	 * 患者状态
	 * @return Integer
	 */
	public Integer getSd_phkstatus() {
		return ((Integer) getAttrVal("Sd_phkstatus"));
	}
	/**
	 * 患者状态
	 * @param Sd_phkstatus
	 */
	public void setSd_phkstatus(Integer Sd_phkstatus) {
		setAttrVal("Sd_phkstatus", Sd_phkstatus);
	}
	/**
	 * 管家人员姓名
	 * @return String
	 */
	public String getName_psndoc() {
		return ((String) getAttrVal("Name_psndoc"));
	}
	/**
	 * 管家人员姓名
	 * @param Name_psndoc
	 */
	public void setName_psndoc(String Name_psndoc) {
		setAttrVal("Name_psndoc", Name_psndoc);
	}
	/**
	 * 管家接待id
	 * @return String
	 */
	public String getId_phk() {
		return ((String) getAttrVal("Id_phk"));
	}
	/**
	 * 管家接待id
	 * @param Id_phk
	 */
	public void setId_phk(String Id_phk) {
		setAttrVal("Id_phk", Id_phk);
	}
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 挂号医生id
	 * @return String
	 */
	public String getId_emp_reg() {
		return ((String) getAttrVal("Id_emp_reg"));
	}
	/**
	 * 挂号医生id
	 * @param Id_emp_reg
	 */
	public void setId_emp_reg(String Id_emp_reg) {
		setAttrVal("Id_emp_reg", Id_emp_reg);
	}
	/**
	 * 挂号医生姓名
	 * @return String
	 */
	public String getName_emp_reg() {
		return ((String) getAttrVal("Name_emp_reg"));
	}
	/**
	 * 挂号医生姓名
	 * @param Name_emp_reg
	 */
	public void setName_emp_reg(String Name_emp_reg) {
		setAttrVal("Name_emp_reg", Name_emp_reg);
	}
	/**
	 * 挂号医生code
	 * @return String
	 */
	public String getCode_emp_reg() {
		return ((String) getAttrVal("Code_emp_reg"));
	}
	/**
	 * 挂号医生code
	 * @param Code_emp_reg
	 */
	public void setCode_emp_reg(String Code_emp_reg) {
		setAttrVal("Code_emp_reg", Code_emp_reg);
	}
	/**
	 * 就诊状态
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 就诊状态
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 当前主管医生
	 * @return String
	 */
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}
	/**
	 * 当前主管医生
	 * @param Id_emp_phy
	 */
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
	}
	/**
	 * 当前主管医生姓名
	 * @return String
	 */
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}
	/**
	 * 当前主管医生姓名
	 * @param Name_emp_phy
	 */
	public void setName_emp_phy(String Name_emp_phy) {
		setAttrVal("Name_emp_phy", Name_emp_phy);
	}
	/**
	 * 当前主管医生code
	 * @return String
	 */
	public String getCode_emp_phy() {
		return ((String) getAttrVal("Code_emp_phy"));
	}
	/**
	 * 当前主管医生code
	 * @param Code_emp_phy
	 */
	public void setCode_emp_phy(String Code_emp_phy) {
		setAttrVal("Code_emp_phy", Code_emp_phy);
	}
	/**
	 * 就诊接诊日期时间
	 * @return String
	 */
	public String getDt_acpt() {
		return ((String) getAttrVal("Dt_acpt"));
	}
	/**
	 * 就诊接诊日期时间
	 * @param Dt_acpt
	 */
	public void setDt_acpt(String Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 诊断
	 * @return String
	 */
	public String getEn_ent_di() {
		return ((String) getAttrVal("En_ent_di"));
	}
	/**
	 * 诊断
	 * @param En_ent_di
	 */
	public void setEn_ent_di(String En_ent_di) {
		setAttrVal("En_ent_di", En_ent_di);
	}
	/**
	 * 科室id
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 科室id
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 分诊台id
	 * @return String
	 */
	public String getId_ben() {
		return ((String) getAttrVal("Id_ben"));
	}
	/**
	 * 分诊台id
	 * @param Id_ben
	 */
	public void setId_ben(String Id_ben) {
		setAttrVal("Id_ben", Id_ben);
	}
	/**
	 * 时间分组id
	 * @return String
	 */
	public String getId_dayslot() {
		return ((String) getAttrVal("Id_dayslot"));
	}
	/**
	 * 时间分组id
	 * @param Id_dayslot
	 */
	public void setId_dayslot(String Id_dayslot) {
		setAttrVal("Id_dayslot", Id_dayslot);
	}
}