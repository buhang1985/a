package iih.mp.nr.visgncollectsingle.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class VisgnsingleTreeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId() {
		return ((String) getAttrVal("Id"));
	}
	/**
	 * 主键
	 * @param Id
	 */
	public void setId(String Id) {
		setAttrVal("Id", Id);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 父级主键
	 * @return String
	 */
	public String getId_parent() {
		return ((String) getAttrVal("Id_parent"));
	}
	/**
	 * 父级主键
	 * @param Id_parent
	 */
	public void setId_parent(String Id_parent) {
		setAttrVal("Id_parent", Id_parent);
	}
	/**
	 * 测量日期时间
	 * @return FDateTime
	 */
	public FDateTime getDt_actual() {
		return ((FDateTime) getAttrVal("Dt_actual"));
	}
	/**
	 * 测量日期时间
	 * @param Dt_actual
	 */
	public void setDt_actual(FDateTime Dt_actual) {
		setAttrVal("Dt_actual", Dt_actual);
	}
	/**
	 * 测量时间
	 * @return FTime
	 */
	public FTime getDt_correct() {
		return ((FTime) getAttrVal("Dt_correct"));
	}
	/**
	 * 测量时间
	 * @param Dt_correct
	 */
	public void setDt_correct(FTime Dt_correct) {
		setAttrVal("Dt_correct", Dt_correct);
	}
	/**
	 * 测量日期
	 * @return FDate
	 */
	public FDate getDt_date() {
		return ((FDate) getAttrVal("Dt_date"));
	}
	/**
	 * 测量日期
	 * @param Dt_date
	 */
	public void setDt_date(FDate Dt_date) {
		setAttrVal("Dt_date", Dt_date);
	}
	/**
	 * 测量时间ID
	 * @return String
	 */
	public String getName_time() {
		return ((String) getAttrVal("Name_time"));
	}
	/**
	 * 测量时间ID
	 * @param Name_time
	 */
	public void setName_time(String Name_time) {
		setAttrVal("Name_time", Name_time);
	}
	/**
	 * 定点测量时间ID
	 * @return String
	 */
	public String getId_time() {
		return ((String) getAttrVal("Id_time"));
	}
	/**
	 * 定点测量时间ID
	 * @param Id_time
	 */
	public void setId_time(String Id_time) {
		setAttrVal("Id_time", Id_time);
	}
	/**
	 * 就诊主键
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊主键
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 责任人
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	/**
	 * 责任人
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 责任人名称
	 * @return String
	 */
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}
	/**
	 * 责任人名称
	 * @param Name_emp
	 */
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	/**
	 * 显示内容
	 * @return String
	 */
	public String getDisplayname() {
		return ((String) getAttrVal("Displayname"));
	}
	/**
	 * 显示内容
	 * @param Displayname
	 */
	public void setDisplayname(String Displayname) {
		setAttrVal("Displayname", Displayname);
	}
	/**
	 * 临床时间
	 * @return FTime
	 */
	public FTime getDt_clinical() {
		return ((FTime) getAttrVal("Dt_clinical"));
	}
	/**
	 * 临床时间
	 * @param Dt_clinical
	 */
	public void setDt_clinical(FTime Dt_clinical) {
		setAttrVal("Dt_clinical", Dt_clinical);
	}
	/**
	 * 修正时间
	 * @return FTime
	 */
	public FTime getDt_time() {
		return ((FTime) getAttrVal("Dt_time"));
	}
	/**
	 * 修正时间
	 * @param Dt_time
	 */
	public void setDt_time(FTime Dt_time) {
		setAttrVal("Dt_time", Dt_time);
	}
	/**
	 * 修正日期时间
	 * @return FDateTime
	 */
	public FDateTime getDt_vt() {
		return ((FDateTime) getAttrVal("Dt_vt"));
	}
	/**
	 * 修正日期时间
	 * @param Dt_vt
	 */
	public void setDt_vt(FDateTime Dt_vt) {
		setAttrVal("Dt_vt", Dt_vt);
	}
	/**
	 * 是否是系统事件
	 * @return FBoolean
	 */
	public FBoolean getFg_sysevent() {
		return ((FBoolean) getAttrVal("Fg_sysevent"));
	}
	/**
	 * 是否是系统事件
	 * @param Fg_sysevent
	 */
	public void setFg_sysevent(FBoolean Fg_sysevent) {
		setAttrVal("Fg_sysevent", Fg_sysevent);
	}
}