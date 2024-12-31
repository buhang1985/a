package iih.en.er.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 急诊患者概况dto DTO数据 
 * 
 */
public class UrgPatInfoDTO extends BaseDTO {
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
	 * 预检id
	 * @return String
	 */
	public String getId_erpre() {
		return ((String) getAttrVal("Id_erpre"));
	}
	/**
	 * 预检id
	 * @param Id_erpre
	 */
	public void setId_erpre(String Id_erpre) {
		setAttrVal("Id_erpre", Id_erpre);
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
	 * 患者性别
	 * @return String
	 */
	public String getSex() {
		return ((String) getAttrVal("Sex"));
	}
	/**
	 * 患者性别
	 * @param Sex
	 */
	public void setSex(String Sex) {
		setAttrVal("Sex", Sex);
	}
	/**
	 * 患者年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}
	/**
	 * 患者年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 患者编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 入院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}
	/**
	 * 入院时间
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 科室
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}
	/**
	 * 科室
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	/**
	 * 病区
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}
	/**
	 * 病区
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 床位
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}
	/**
	 * 床位
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 主管医生
	 * @return String
	 */
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}
	/**
	 * 主管医生
	 * @param Name_emp_phy
	 */
	public void setName_emp_phy(String Name_emp_phy) {
		setAttrVal("Name_emp_phy", Name_emp_phy);
	}
	/**
	 * 电话
	 * @return String
	 */
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}
	/**
	 * 电话
	 * @param Tel
	 */
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	/**
	 * 行政区划
	 * @return String
	 */
	public String getName_admdiv() {
		return ((String) getAttrVal("Name_admdiv"));
	}
	/**
	 * 行政区划
	 * @param Name_admdiv
	 */
	public void setName_admdiv(String Name_admdiv) {
		setAttrVal("Name_admdiv", Name_admdiv);
	}
	/**
	 * 街道
	 * @return String
	 */
	public String getStreet() {
		return ((String) getAttrVal("Street"));
	}
	/**
	 * 街道
	 * @param Street
	 */
	public void setStreet(String Street) {
		setAttrVal("Street", Street);
	}
	/**
	 * 发送时间
	 * @return FDateTime
	 */
	public FDateTime getDt_send() {
		return ((FDateTime) getAttrVal("Dt_send"));
	}
	/**
	 * 发送时间
	 * @param Dt_send
	 */
	public void setDt_send(FDateTime Dt_send) {
		setAttrVal("Dt_send", Dt_send);
	}
	/**
	 * 事件类型
	 * @return String
	 */
	public String getEvttp() {
		return ((String) getAttrVal("Evttp"));
	}
	/**
	 * 事件类型
	 * @param Evttp
	 */
	public void setEvttp(String Evttp) {
		setAttrVal("Evttp", Evttp);
	}
	/**
	 * 描述
	 * @return String
	 */
	public String getDesc() {
		return ((String) getAttrVal("Desc"));
	}
	/**
	 * 描述
	 * @param Desc
	 */
	public void setDesc(String Desc) {
		setAttrVal("Desc", Desc);
	}
	/**
	 * 简述
	 * @return String
	 */
	public String getResume() {
		return ((String) getAttrVal("Resume"));
	}
	/**
	 * 简述
	 * @param Resume
	 */
	public void setResume(String Resume) {
		setAttrVal("Resume", Resume);
	}
	/**
	 * 记录时间
	 * @return FDateTime
	 */
	public FDateTime getDt_record() {
		return ((FDateTime) getAttrVal("Dt_record"));
	}
	/**
	 * 记录时间
	 * @param Dt_record
	 */
	public void setDt_record(FDateTime Dt_record) {
		setAttrVal("Dt_record", Dt_record);
	}
	/**
	 * 记录人
	 * @return String
	 */
	public String getEmp_record() {
		return ((String) getAttrVal("Emp_record"));
	}
	/**
	 * 记录人
	 * @param Emp_record
	 */
	public void setEmp_record(String Emp_record) {
		setAttrVal("Emp_record", Emp_record);
	}
	/**
	 * 序号
	 * @return String
	 */
	public String getNum() {
		return ((String) getAttrVal("Num"));
	}
	/**
	 * 序号
	 * @param Num
	 */
	public void setNum(String Num) {
		setAttrVal("Num", Num);
	}
	/**
	 * 时长
	 * @return String
	 */
	public String getTime() {
		return ((String) getAttrVal("Time"));
	}
	/**
	 * 时长
	 * @param Time
	 */
	public void setTime(String Time) {
		setAttrVal("Time", Time);
	}
	/**
	 * 预检等级
	 * @return String
	 */
	public String getLevel() {
		return ((String) getAttrVal("Level"));
	}
	/**
	 * 预检等级
	 * @param Level
	 */
	public void setLevel(String Level) {
		setAttrVal("Level", Level);
	}
	/**
	 * 绿色通道
	 * @return String
	 */
	public String getName_green_channel() {
		return ((String) getAttrVal("Name_green_channel"));
	}
	/**
	 * 绿色通道
	 * @param Name_green_channel
	 */
	public void setName_green_channel(String Name_green_channel) {
		setAttrVal("Name_green_channel", Name_green_channel);
	}
	/**
	 * 过敏名称
	 * @return String
	 */
	public String getName_altp() {
		return ((String) getAttrVal("Name_altp"));
	}
	/**
	 * 过敏名称
	 * @param Name_altp
	 */
	public void setName_altp(String Name_altp) {
		setAttrVal("Name_altp", Name_altp);
	}
	/**
	 * news评分
	 * @return String
	 */
	public String getNews() {
		return ((String) getAttrVal("News"));
	}
	/**
	 * news评分
	 * @param News
	 */
	public void setNews(String News) {
		setAttrVal("News", News);
	}
	/**
	 * gsc评分
	 * @return String
	 */
	public String getGsc() {
		return ((String) getAttrVal("Gsc"));
	}
	/**
	 * gsc评分
	 * @param Gsc
	 */
	public void setGsc(String Gsc) {
		setAttrVal("Gsc", Gsc);
	}
	/**
	 * apac评分
	 * @return String
	 */
	public String getApac() {
		return ((String) getAttrVal("Apac"));
	}
	/**
	 * apac评分
	 * @param Apac
	 */
	public void setApac(String Apac) {
		setAttrVal("Apac", Apac);
	}
	/**
	 * 患者生日
	 * @return FDate
	 */
	public FDate getD_birth() {
		return ((FDate) getAttrVal("D_birth"));
	}
	/**
	 * 患者生日
	 * @param D_birth
	 */
	public void setD_birth(FDate D_birth) {
		setAttrVal("D_birth", D_birth);
	}
	/**
	 * 评分
	 * @return String
	 */
	public String getScore() {
		return ((String) getAttrVal("Score"));
	}
	/**
	 * 评分
	 * @param Score
	 */
	public void setScore(String Score) {
		setAttrVal("Score", Score);
	}
}