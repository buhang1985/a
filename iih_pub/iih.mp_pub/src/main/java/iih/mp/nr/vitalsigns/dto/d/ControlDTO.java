package iih.mp.nr.vitalsigns.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 控件结构 DTO数据 
 * 
 */
public class ControlDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 控件ID
	 * @return String
	 */
	public String getId_control() {
		return ((String) getAttrVal("Id_control"));
	}
	/**
	 * 控件ID
	 * @param Id_control
	 */
	public void setId_control(String Id_control) {
		setAttrVal("Id_control", Id_control);
	}
	/**
	 * 属性ID
	 * @return String
	 */
	public String getId_mrtpl_vs_itm() {
		return ((String) getAttrVal("Id_mrtpl_vs_itm"));
	}
	/**
	 * 属性ID
	 * @param Id_mrtpl_vs_itm
	 */
	public void setId_mrtpl_vs_itm(String Id_mrtpl_vs_itm) {
		setAttrVal("Id_mrtpl_vs_itm", Id_mrtpl_vs_itm);
	}
	/**
	 * 控件编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 控件编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 测量项目ID
	 * @return String
	 */
	public String getId_mrvtitm() {
		return ((String) getAttrVal("Id_mrvtitm"));
	}
	/**
	 * 测量项目ID
	 * @param Id_mrvtitm
	 */
	public void setId_mrvtitm(String Id_mrvtitm) {
		setAttrVal("Id_mrvtitm", Id_mrvtitm);
	}
	/**
	 * 服务项目
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务项目
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 体征属性
	 * @return String
	 */
	public String getId_srvvt() {
		return ((String) getAttrVal("Id_srvvt"));
	}
	/**
	 * 体征属性
	 * @param Id_srvvt
	 */
	public void setId_srvvt(String Id_srvvt) {
		setAttrVal("Id_srvvt", Id_srvvt);
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
	 * 文本
	 * @return String
	 */
	public String getText() {
		return ((String) getAttrVal("Text"));
	}
	/**
	 * 文本
	 * @param Text
	 */
	public void setText(String Text) {
		setAttrVal("Text", Text);
	}
	/**
	 * 值
	 * @return String
	 */
	public String getValue() {
		return ((String) getAttrVal("Value"));
	}
	/**
	 * 值
	 * @param Value
	 */
	public void setValue(String Value) {
		setAttrVal("Value", Value);
	}
	/**
	 * 原始值
	 * @return String
	 */
	public String getOldvalue() {
		return ((String) getAttrVal("Oldvalue"));
	}
	/**
	 * 原始值
	 * @param Oldvalue
	 */
	public void setOldvalue(String Oldvalue) {
		setAttrVal("Oldvalue", Oldvalue);
	}
	/**
	 * 字典编码
	 * @return String
	 */
	public String getSd_enum() {
		return ((String) getAttrVal("Sd_enum"));
	}
	/**
	 * 字典编码
	 * @param Sd_enum
	 */
	public void setSd_enum(String Sd_enum) {
		setAttrVal("Sd_enum", Sd_enum);
	}
	/**
	 * 最大值
	 * @return FDouble
	 */
	public FDouble getMin_value() {
		return ((FDouble) getAttrVal("Min_value"));
	}
	/**
	 * 最大值
	 * @param Min_value
	 */
	public void setMin_value(FDouble Min_value) {
		setAttrVal("Min_value", Min_value);
	}
	/**
	 * 最小值
	 * @return FDouble
	 */
	public FDouble getMax_value() {
		return ((FDouble) getAttrVal("Max_value"));
	}
	/**
	 * 最小值
	 * @param Max_value
	 */
	public void setMax_value(FDouble Max_value) {
		setAttrVal("Max_value", Max_value);
	}
	/**
	 * 位移
	 * @return Integer
	 */
	public Integer getPadding() {
		return ((Integer) getAttrVal("Padding"));
	}
	/**
	 * 位移
	 * @param Padding
	 */
	public void setPadding(Integer Padding) {
		setAttrVal("Padding", Padding);
	}
	/**
	 * 枚举值
	 * @return FArrayList
	 */
	public FArrayList getEnumsource() {
		return ((FArrayList) getAttrVal("Enumsource"));
	}
	/**
	 * 枚举值
	 * @param Enumsource
	 */
	public void setEnumsource(FArrayList Enumsource) {
		setAttrVal("Enumsource", Enumsource);
	}
	/**
	 * 数据类型
	 * @return Integer
	 */
	public Integer getDatatp() {
		return ((Integer) getAttrVal("Datatp"));
	}
	/**
	 * 数据类型
	 * @param Datatp
	 */
	public void setDatatp(Integer Datatp) {
		setAttrVal("Datatp", Datatp);
	}
	/**
	 * 控件类型
	 * @return Integer
	 */
	public Integer getControltp() {
		return ((Integer) getAttrVal("Controltp"));
	}
	/**
	 * 控件类型
	 * @param Controltp
	 */
	public void setControltp(Integer Controltp) {
		setAttrVal("Controltp", Controltp);
	}
	/**
	 * 数据源值域编码
	 * @return String
	 */
	public String getValdomaincode() {
		return ((String) getAttrVal("Valdomaincode"));
	}
	/**
	 * 数据源值域编码
	 * @param Valdomaincode
	 */
	public void setValdomaincode(String Valdomaincode) {
		setAttrVal("Valdomaincode", Valdomaincode);
	}
	/**
	 * 是否只读
	 * @return FBoolean
	 */
	public FBoolean getReadonly() {
		return ((FBoolean) getAttrVal("Readonly"));
	}
	/**
	 * 是否只读
	 * @param Readonly
	 */
	public void setReadonly(FBoolean Readonly) {
		setAttrVal("Readonly", Readonly);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}
	/**
	 * 单位名称
	 * @param Name_unit
	 */
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
	}
	/**
	 * 默认项
	 * @return FBoolean
	 */
	public FBoolean getFg_default() {
		return ((FBoolean) getAttrVal("Fg_default"));
	}
	/**
	 * 默认项
	 * @param Fg_default
	 */
	public void setFg_default(FBoolean Fg_default) {
		setAttrVal("Fg_default", Fg_default);
	}
	/**
	 * 下拉允许编辑
	 * @return FBoolean
	 */
	public FBoolean getFg_edit() {
		return ((FBoolean) getAttrVal("Fg_edit"));
	}
	/**
	 * 下拉允许编辑
	 * @param Fg_edit
	 */
	public void setFg_edit(FBoolean Fg_edit) {
		setAttrVal("Fg_edit", Fg_edit);
	}
	/**
	 * 精度
	 * @return Integer
	 */
	public Integer getPrecision() {
		return ((Integer) getAttrVal("Precision"));
	}
	/**
	 * 精度
	 * @param Precision
	 */
	public void setPrecision(Integer Precision) {
		setAttrVal("Precision", Precision);
	}
	/**
	 * 长度
	 * @return Integer
	 */
	public Integer getLen() {
		return ((Integer) getAttrVal("Len"));
	}
	/**
	 * 长度
	 * @param Len
	 */
	public void setLen(Integer Len) {
		setAttrVal("Len", Len);
	}
}