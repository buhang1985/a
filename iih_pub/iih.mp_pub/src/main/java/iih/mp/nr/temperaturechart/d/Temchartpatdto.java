package iih.mp.nr.temperaturechart.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体温单患者dto DTO数据 
 * 
 */
public class Temchartpatdto extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 主键
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 就诊编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 患者编号
	 * @return String
	 */
	public String getPatcode() {
		return ((String) getAttrVal("Patcode"));
	}
	/**
	 * 患者编号
	 * @param Patcode
	 */
	public void setPatcode(String Patcode) {
		setAttrVal("Patcode", Patcode);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
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
	 * 科室
	 * @return String
	 */
	public String getDept() {
		return ((String) getAttrVal("Dept"));
	}
	/**
	 * 科室
	 * @param Dept
	 */
	public void setDept(String Dept) {
		setAttrVal("Dept", Dept);
	}
	/**
	 * 所属病区
	 * @return String
	 */
	public String getWard() {
		return ((String) getAttrVal("Ward"));
	}
	/**
	 * 所属病区
	 * @param Ward
	 */
	public void setWard(String Ward) {
		setAttrVal("Ward", Ward);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getBedcode() {
		return ((String) getAttrVal("Bedcode"));
	}
	/**
	 * 床号
	 * @param Bedcode
	 */
	public void setBedcode(String Bedcode) {
		setAttrVal("Bedcode", Bedcode);
	}
	/**
	 * 入院日期
	 * @return FDateTime
	 */
	public FDateTime getAdmindate() {
		return ((FDateTime) getAttrVal("Admindate"));
	}
	/**
	 * 入院日期
	 * @param Admindate
	 */
	public void setAdmindate(FDateTime Admindate) {
		setAttrVal("Admindate", Admindate);
	}
	/**
	 * 病区接收时间
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}
	/**
	 * 病区接收时间
	 * @param Dt_acpt
	 */
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 事件主键
	 * @return String
	 */
	public String getId_case() {
		return ((String) getAttrVal("Id_case"));
	}
	/**
	 * 事件主键
	 * @param Id_case
	 */
	public void setId_case(String Id_case) {
		setAttrVal("Id_case", Id_case);
	}
	/**
	 * 母亲住院号
	 * @return String
	 */
	public String getCode_amr_ip_mom() {
		return ((String) getAttrVal("Code_amr_ip_mom"));
	}
	/**
	 * 母亲住院号
	 * @param Code_amr_ip_mom
	 */
	public void setCode_amr_ip_mom(String Code_amr_ip_mom) {
		setAttrVal("Code_amr_ip_mom", Code_amr_ip_mom);
	}
	/**
	 * 西医诊断
	 * @return String
	 */
	public String getDi_west() {
		return ((String) getAttrVal("Di_west"));
	}
	/**
	 * 西医诊断
	 * @param Di_west
	 */
	public void setDi_west(String Di_west) {
		setAttrVal("Di_west", Di_west);
	}
	/**
	 * 中医诊断
	 * @return String
	 */
	public String getDi_china() {
		return ((String) getAttrVal("Di_china"));
	}
	/**
	 * 中医诊断
	 * @param Di_china
	 */
	public void setDi_china(String Di_china) {
		setAttrVal("Di_china", Di_china);
	}
	/**
	 * 护理单元
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 护理单元
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 新生儿标识
	 * @return FBoolean
	 */
	public FBoolean getFg_newborn() {
		return ((FBoolean) getAttrVal("Fg_newborn"));
	}
	/**
	 * 新生儿标识
	 * @param Fg_newborn
	 */
	public void setFg_newborn(FBoolean Fg_newborn) {
		setAttrVal("Fg_newborn", Fg_newborn);
	}
	/**
	 * 出院日期
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 出院日期
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
}