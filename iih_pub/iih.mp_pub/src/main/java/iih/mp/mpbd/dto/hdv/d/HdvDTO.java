package iih.mp.mpbd.dto.hdv.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 交接班DTO DTO数据 
 * 
 */
public class HdvDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 交班报告id
	 * @return String
	 */
	public String getId_hdv() {
		return ((String) getAttrVal("Id_hdv"));
	}
	/**
	 * 交班报告id
	 * @param Id_hdv
	 */
	public void setId_hdv(String Id_hdv) {
		setAttrVal("Id_hdv", Id_hdv);
	}
	/**
	 * 班次
	 * @return String
	 */
	public String getId_hdv_def() {
		return ((String) getAttrVal("Id_hdv_def"));
	}
	/**
	 * 班次
	 * @param Id_hdv_def
	 */
	public void setId_hdv_def(String Id_hdv_def) {
		setAttrVal("Id_hdv_def", Id_hdv_def);
	}
	/**
	 * 交班科室
	 * @return String
	 */
	public String getId_dep_hdv() {
		return ((String) getAttrVal("Id_dep_hdv"));
	}
	/**
	 * 交班科室
	 * @param Id_dep_hdv
	 */
	public void setId_dep_hdv(String Id_dep_hdv) {
		setAttrVal("Id_dep_hdv", Id_dep_hdv);
	}
	/**
	 * 交班护士
	 * @return String
	 */
	public String getId_emp_hdv() {
		return ((String) getAttrVal("Id_emp_hdv"));
	}
	/**
	 * 交班护士
	 * @param Id_emp_hdv
	 */
	public void setId_emp_hdv(String Id_emp_hdv) {
		setAttrVal("Id_emp_hdv", Id_emp_hdv);
	}
	/**
	 * 交班时间
	 * @return FDate
	 */
	public FDate getDt_hdv() {
		return ((FDate) getAttrVal("Dt_hdv"));
	}
	/**
	 * 交班时间
	 * @param Dt_hdv
	 */
	public void setDt_hdv(FDate Dt_hdv) {
		setAttrVal("Dt_hdv", Dt_hdv);
	}
	/**
	 * 交班开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}
	/**
	 * 交班开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 交班结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 交班结束时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_oper() {
		return ((FDateTime) getAttrVal("Dt_oper"));
	}
	/**
	 * 操作时间
	 * @param Dt_oper
	 */
	public void setDt_oper(FDateTime Dt_oper) {
		setAttrVal("Dt_oper", Dt_oper);
	}
	/**
	 * 交班状态
	 * @return Integer
	 */
	public Integer getEu_hav_sta() {
		return ((Integer) getAttrVal("Eu_hav_sta"));
	}
	/**
	 * 交班状态
	 * @param Eu_hav_sta
	 */
	public void setEu_hav_sta(Integer Eu_hav_sta) {
		setAttrVal("Eu_hav_sta", Eu_hav_sta);
	}
	/**
	 * 交接班患者
	 * @return String
	 */
	public String getId_hdv_ent() {
		return ((String) getAttrVal("Id_hdv_ent"));
	}
	/**
	 * 交接班患者
	 * @param Id_hdv_ent
	 */
	public void setId_hdv_ent(String Id_hdv_ent) {
		setAttrVal("Id_hdv_ent", Id_hdv_ent);
	}
	/**
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
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
	 * 床号
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}
	/**
	 * 床号
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 交班内容
	 * @return String
	 */
	public String getContent() {
		return ((String) getAttrVal("Content"));
	}
	/**
	 * 交班内容
	 * @param Content
	 */
	public void setContent(String Content) {
		setAttrVal("Content", Content);
	}
	/**
	 * 交接班属性
	 * @return FArrayList
	 */
	public FArrayList getArrayattr() {
		return ((FArrayList) getAttrVal("Arrayattr"));
	}
	/**
	 * 交接班属性
	 * @param Arrayattr
	 */
	public void setArrayattr(FArrayList Arrayattr) {
		setAttrVal("Arrayattr", Arrayattr);
	}
	/**
	 * 属性集合
	 * @return FArrayList
	 */
	public FArrayList getArraylable() {
		return ((FArrayList) getAttrVal("Arraylable"));
	}
	/**
	 * 属性集合
	 * @param Arraylable
	 */
	public void setArraylable(FArrayList Arraylable) {
		setAttrVal("Arraylable", Arraylable);
	}
	/**
	 * 标题
	 * @return String
	 */
	public String getTitle() {
		return ((String) getAttrVal("Title"));
	}
	/**
	 * 标题
	 * @param Title
	 */
	public void setTitle(String Title) {
		setAttrVal("Title", Title);
	}
	/**
	 * 颜色
	 * @return String
	 */
	public String getColor() {
		return ((String) getAttrVal("Color"));
	}
	/**
	 * 颜色
	 * @param Color
	 */
	public void setColor(String Color) {
		setAttrVal("Color", Color);
	}
	/**
	 * 交班名称
	 * @return String
	 */
	public String getName_hdv() {
		return ((String) getAttrVal("Name_hdv"));
	}
	/**
	 * 交班名称
	 * @param Name_hdv
	 */
	public void setName_hdv(String Name_hdv) {
		setAttrVal("Name_hdv", Name_hdv);
	}
	/**
	 * 宽度
	 * @return Integer
	 */
	public Integer getWidth() {
		return ((Integer) getAttrVal("Width"));
	}
	/**
	 * 宽度
	 * @param Width
	 */
	public void setWidth(Integer Width) {
		setAttrVal("Width", Width);
	}
	/**
	 * 护理等级颜色
	 * @return String
	 */
	public String getColor_entsta() {
		return ((String) getAttrVal("Color_entsta"));
	}
	/**
	 * 护理等级颜色
	 * @param Color_entsta
	 */
	public void setColor_entsta(String Color_entsta) {
		setAttrVal("Color_entsta", Color_entsta);
	}
	/**
	 * 交班指标
	 * @return FArrayList
	 */
	public FArrayList getArraytagt() {
		return ((FArrayList) getAttrVal("Arraytagt"));
	}
	/**
	 * 交班指标
	 * @param Arraytagt
	 */
	public void setArraytagt(FArrayList Arraytagt) {
		setAttrVal("Arraytagt", Arraytagt);
	}
}