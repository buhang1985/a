package iih.en.pv.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 集成平台挂号DTO DTO数据 
 * 
 */
public class Reg4IpDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 就诊编码
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 就诊编码
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getName_entp() {
		return ((String) getAttrVal("Name_entp"));
	}
	/**
	 * 就诊类型
	 * @param Name_entp
	 */
	public void setName_entp(String Name_entp) {
		setAttrVal("Name_entp", Name_entp);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
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
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 就诊次数
	 * @return Integer
	 */
	public Integer getTimes_en() {
		return ((Integer) getAttrVal("Times_en"));
	}
	/**
	 * 就诊次数
	 * @param Times_en
	 */
	public void setTimes_en(Integer Times_en) {
		setAttrVal("Times_en", Times_en);
	}
	/**
	 * 挂号时间
	 * @return String
	 */
	public String getDt_reg() {
		return ((String) getAttrVal("Dt_reg"));
	}
	/**
	 * 挂号时间
	 * @param Dt_reg
	 */
	public void setDt_reg(String Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
	}
	/**
	 * 就诊时间
	 * @return String
	 */
	public String getDt_entry() {
		return ((String) getAttrVal("Dt_entry"));
	}
	/**
	 * 就诊时间
	 * @param Dt_entry
	 */
	public void setDt_entry(String Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 域id
	 * @return String
	 */
	public String getId_domain() {
		return ((String) getAttrVal("Id_domain"));
	}
	/**
	 * 域id
	 * @param Id_domain
	 */
	public void setId_domain(String Id_domain) {
		setAttrVal("Id_domain", Id_domain);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getCode_dept() {
		return ((String) getAttrVal("Code_dept"));
	}
	/**
	 * 科室编码
	 * @param Code_dept
	 */
	public void setCode_dept(String Code_dept) {
		setAttrVal("Code_dept", Code_dept);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}
	/**
	 * 科室名称
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	/**
	 * 消息类型
	 * @return String
	 */
	public String getMsgtype() {
		return ((String) getAttrVal("Msgtype"));
	}
	/**
	 * 消息类型
	 * @param Msgtype
	 */
	public void setMsgtype(String Msgtype) {
		setAttrVal("Msgtype", Msgtype);
	}
	/**
	 * 挂号方式编码
	 * @return String
	 */
	public String getCode_regmode() {
		return ((String) getAttrVal("Code_regmode"));
	}
	/**
	 * 挂号方式编码
	 * @param Code_regmode
	 */
	public void setCode_regmode(String Code_regmode) {
		setAttrVal("Code_regmode", Code_regmode);
	}
	/**
	 * 挂号方式
	 * @return String
	 */
	public String getName_regmode() {
		return ((String) getAttrVal("Name_regmode"));
	}
	/**
	 * 挂号方式
	 * @param Name_regmode
	 */
	public void setName_regmode(String Name_regmode) {
		setAttrVal("Name_regmode", Name_regmode);
	}
	/**
	 * 费用类别编码
	 * @return String
	 */
	public String getCode_feetype() {
		return ((String) getAttrVal("Code_feetype"));
	}
	/**
	 * 费用类别编码
	 * @param Code_feetype
	 */
	public void setCode_feetype(String Code_feetype) {
		setAttrVal("Code_feetype", Code_feetype);
	}
	/**
	 * 费用类别名称
	 * @return String
	 */
	public String getName_feetype() {
		return ((String) getAttrVal("Name_feetype"));
	}
	/**
	 * 费用类别名称
	 * @param Name_feetype
	 */
	public void setName_feetype(String Name_feetype) {
		setAttrVal("Name_feetype", Name_feetype);
	}
	/**
	 * 号别编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 号别编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 号别名称
	 * @return String
	 */
	public String getName_srvtp() {
		return ((String) getAttrVal("Name_srvtp"));
	}
	/**
	 * 号别名称
	 * @param Name_srvtp
	 */
	public void setName_srvtp(String Name_srvtp) {
		setAttrVal("Name_srvtp", Name_srvtp);
	}
	/**
	 * 时段编码
	 * @return String
	 */
	public String getCode_period() {
		return ((String) getAttrVal("Code_period"));
	}
	/**
	 * 时段编码
	 * @param Code_period
	 */
	public void setCode_period(String Code_period) {
		setAttrVal("Code_period", Code_period);
	}
	/**
	 * 时段
	 * @return String
	 */
	public String getName_period() {
		return ((String) getAttrVal("Name_period"));
	}
	/**
	 * 时段
	 * @param Name_period
	 */
	public void setName_period(String Name_period) {
		setAttrVal("Name_period", Name_period);
	}
	/**
	 * 医生编码
	 * @return String
	 */
	public String getCode_doc() {
		return ((String) getAttrVal("Code_doc"));
	}
	/**
	 * 医生编码
	 * @param Code_doc
	 */
	public void setCode_doc(String Code_doc) {
		setAttrVal("Code_doc", Code_doc);
	}
	/**
	 * 医生名称
	 * @return String
	 */
	public String getName_doc() {
		return ((String) getAttrVal("Name_doc"));
	}
	/**
	 * 医生名称
	 * @param Name_doc
	 */
	public void setName_doc(String Name_doc) {
		setAttrVal("Name_doc", Name_doc);
	}
	/**
	 * 就诊序号
	 * @return Integer
	 */
	public Integer getTickno() {
		return ((Integer) getAttrVal("Tickno"));
	}
	/**
	 * 就诊序号
	 * @param Tickno
	 */
	public void setTickno(Integer Tickno) {
		setAttrVal("Tickno", Tickno);
	}
	/**
	 * empi就诊类型
	 * @return String
	 */
	public String getEntp() {
		return ((String) getAttrVal("Entp"));
	}
	/**
	 * empi就诊类型
	 * @param Entp
	 */
	public void setEntp(String Entp) {
		setAttrVal("Entp", Entp);
	}
	/**
	 * 组织编码
	 * @return String
	 */
	public String getCode_org() {
		return ((String) getAttrVal("Code_org"));
	}
	/**
	 * 组织编码
	 * @param Code_org
	 */
	public void setCode_org(String Code_org) {
		setAttrVal("Code_org", Code_org);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}
	/**
	 * 组织名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 域
	 * @return String
	 */
	public String getArea() {
		return ((String) getAttrVal("Area"));
	}
	/**
	 * 域
	 * @param Area
	 */
	public void setArea(String Area) {
		setAttrVal("Area", Area);
	}
	/**
	 * 健康卡号
	 * @return String
	 */
	public String getBarcode_chis() {
		return ((String) getAttrVal("Barcode_chis"));
	}
	/**
	 * 健康卡号
	 * @param Barcode_chis
	 */
	public void setBarcode_chis(String Barcode_chis) {
		setAttrVal("Barcode_chis", Barcode_chis);
	}
	/**
	 * 预检分诊号
	 * @return String
	 */
	public String getPre_exam_num() {
		return ((String) getAttrVal("Pre_exam_num"));
	}
	/**
	 * 预检分诊号
	 * @param Pre_exam_num
	 */
	public void setPre_exam_num(String Pre_exam_num) {
		setAttrVal("Pre_exam_num", Pre_exam_num);
	}
	/**
	 * 就诊流水号
	 * @return String
	 */
	public String getCode_ent_serial() {
		return ((String) getAttrVal("Code_ent_serial"));
	}
	/**
	 * 就诊流水号
	 * @param Code_ent_serial
	 */
	public void setCode_ent_serial(String Code_ent_serial) {
		setAttrVal("Code_ent_serial", Code_ent_serial);
	}
}