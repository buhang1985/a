package iih.pe.pwf.dto.pewfdinnerdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检标准餐工作站列表 DTO数据 
 * 
 */
public class PeWfDinnerDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 体检预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}
	/**
	 * 体检预约单ID
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
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
	 * @return Integer
	 */
	public Integer getAge() {
		return ((Integer) getAttrVal("Age"));
	}
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(Integer Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 当前诊室
	 * @return String
	 */
	public String getRoom_cur() {
		return ((String) getAttrVal("Room_cur"));
	}
	/**
	 * 当前诊室
	 * @param Room_cur
	 */
	public void setRoom_cur(String Room_cur) {
		setAttrVal("Room_cur", Room_cur);
	}
	/**
	 * 距离进入餐厅时间
	 * @return Integer
	 */
	public Integer getTimetodinner() {
		return ((Integer) getAttrVal("Timetodinner"));
	}
	/**
	 * 距离进入餐厅时间
	 * @param Timetodinner
	 */
	public void setTimetodinner(Integer Timetodinner) {
		setAttrVal("Timetodinner", Timetodinner);
	}
	/**
	 * 荤素标识
	 * @return FBoolean
	 */
	public FBoolean getFg_meal() {
		return ((FBoolean) getAttrVal("Fg_meal"));
	}
	/**
	 * 荤素标识
	 * @param Fg_meal
	 */
	public void setFg_meal(FBoolean Fg_meal) {
		setAttrVal("Fg_meal", Fg_meal);
	}
	/**
	 * 清真饮食标识
	 * @return FBoolean
	 */
	public FBoolean getFg_muslim() {
		return ((FBoolean) getAttrVal("Fg_muslim"));
	}
	/**
	 * 清真饮食标识
	 * @param Fg_muslim
	 */
	public void setFg_muslim(FBoolean Fg_muslim) {
		setAttrVal("Fg_muslim", Fg_muslim);
	}
	/**
	 * VIP标识
	 * @return FBoolean
	 */
	public FBoolean getFg_vip() {
		return ((FBoolean) getAttrVal("Fg_vip"));
	}
	/**
	 * VIP标识
	 * @param Fg_vip
	 */
	public void setFg_vip(FBoolean Fg_vip) {
		setAttrVal("Fg_vip", Fg_vip);
	}
	/**
	 * 身高
	 * @return FDouble
	 */
	public FDouble getHeight() {
		return ((FDouble) getAttrVal("Height"));
	}
	/**
	 * 身高
	 * @param Height
	 */
	public void setHeight(FDouble Height) {
		setAttrVal("Height", Height);
	}
	/**
	 * 体重
	 * @return FDouble
	 */
	public FDouble getWeight() {
		return ((FDouble) getAttrVal("Weight"));
	}
	/**
	 * 体重
	 * @param Weight
	 */
	public void setWeight(FDouble Weight) {
		setAttrVal("Weight", Weight);
	}
	/**
	 * 团体名称
	 * @return String
	 */
	public String getCorp() {
		return ((String) getAttrVal("Corp"));
	}
	/**
	 * 团体名称
	 * @param Corp
	 */
	public void setCorp(String Corp) {
		setAttrVal("Corp", Corp);
	}
	/**
	 * 体检唯一码
	 * @return String
	 */
	public String getPe_code() {
		return ((String) getAttrVal("Pe_code"));
	}
	/**
	 * 体检唯一码
	 * @param Pe_code
	 */
	public void setPe_code(String Pe_code) {
		setAttrVal("Pe_code", Pe_code);
	}
}