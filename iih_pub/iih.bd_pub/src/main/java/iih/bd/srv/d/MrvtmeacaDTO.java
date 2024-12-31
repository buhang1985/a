package iih.bd.srv.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 生命体征测量分类DTO DTO数据 
 * 
 */
public class MrvtmeacaDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 生命体征测量分类主键标识
	 * @return String
	 */
	public String getId_mrvtca() {
		return ((String) getAttrVal("Id_mrvtca"));
	}
	/**
	 * 生命体征测量分类主键标识
	 * @param Id_mrvtca
	 */
	public void setId_mrvtca(String Id_mrvtca) {
		setAttrVal("Id_mrvtca", Id_mrvtca);
	}
	/**
	 * 医疗记录模板主键标识
	 * @return String
	 */
	public String getId_mrtpl() {
		return ((String) getAttrVal("Id_mrtpl"));
	}
	/**
	 * 医疗记录模板主键标识
	 * @param Id_mrtpl
	 */
	public void setId_mrtpl(String Id_mrtpl) {
		setAttrVal("Id_mrtpl", Id_mrtpl);
	}
	/**
	 * 测量分类名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 测量分类名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 测量分类编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 测量分类编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 适用护理等级
	 * @return String
	 */
	public String getId_level_nur() {
		return ((String) getAttrVal("Id_level_nur"));
	}
	/**
	 * 适用护理等级
	 * @param Id_level_nur
	 */
	public void setId_level_nur(String Id_level_nur) {
		setAttrVal("Id_level_nur", Id_level_nur);
	}
	/**
	 * 适用护理等级名称
	 * @return String
	 */
	public String getId_level_nur_name() {
		return ((String) getAttrVal("Id_level_nur_name"));
	}
	/**
	 * 适用护理等级名称
	 * @param Id_level_nur_name
	 */
	public void setId_level_nur_name(String Id_level_nur_name) {
		setAttrVal("Id_level_nur_name", Id_level_nur_name);
	}
	/**
	 * 适用护理等级编码
	 * @return String
	 */
	public String getId_level_nur_code() {
		return ((String) getAttrVal("Id_level_nur_code"));
	}
	/**
	 * 适用护理等级编码
	 * @param Id_level_nur_code
	 */
	public void setId_level_nur_code(String Id_level_nur_code) {
		setAttrVal("Id_level_nur_code", Id_level_nur_code);
	}
	/**
	 * 病情等级
	 * @return String
	 */
	public String getId_level_dise() {
		return ((String) getAttrVal("Id_level_dise"));
	}
	/**
	 * 病情等级
	 * @param Id_level_dise
	 */
	public void setId_level_dise(String Id_level_dise) {
		setAttrVal("Id_level_dise", Id_level_dise);
	}
	/**
	 * 病情等级名称
	 * @return String
	 */
	public String getId_level_dise_name() {
		return ((String) getAttrVal("Id_level_dise_name"));
	}
	/**
	 * 病情等级名称
	 * @param Id_level_dise_name
	 */
	public void setId_level_dise_name(String Id_level_dise_name) {
		setAttrVal("Id_level_dise_name", Id_level_dise_name);
	}
	/**
	 * 病情等级编码
	 * @return String
	 */
	public String getId_level_dise_code() {
		return ((String) getAttrVal("Id_level_dise_code"));
	}
	/**
	 * 病情等级编码
	 * @param Id_level_dise_code
	 */
	public void setId_level_dise_code(String Id_level_dise_code) {
		setAttrVal("Id_level_dise_code", Id_level_dise_code);
	}
	/**
	 * 医疗记录模板所属类型
	 * @return String
	 */
	public String getId_owtp() {
		return ((String) getAttrVal("Id_owtp"));
	}
	/**
	 * 医疗记录模板所属类型
	 * @param Id_owtp
	 */
	public void setId_owtp(String Id_owtp) {
		setAttrVal("Id_owtp", Id_owtp);
	}
	/**
	 * 所属类型名称
	 * @return String
	 */
	public String getId_owtp_name() {
		return ((String) getAttrVal("Id_owtp_name"));
	}
	/**
	 * 所属类型名称
	 * @param Id_owtp_name
	 */
	public void setId_owtp_name(String Id_owtp_name) {
		setAttrVal("Id_owtp_name", Id_owtp_name);
	}
	/**
	 * 所属类型编码
	 * @return String
	 */
	public String getId_owtp_code() {
		return ((String) getAttrVal("Id_owtp_code"));
	}
	/**
	 * 所属类型编码
	 * @param Id_owtp_code
	 */
	public void setId_owtp_code(String Id_owtp_code) {
		setAttrVal("Id_owtp_code", Id_owtp_code);
	}
	/**
	 * 所属科室
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}
	/**
	 * 所属科室
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	/**
	 * 所属科室名称
	 * @return String
	 */
	public String getId_dept_name() {
		return ((String) getAttrVal("Id_dept_name"));
	}
	/**
	 * 所属科室名称
	 * @param Id_dept_name
	 */
	public void setId_dept_name(String Id_dept_name) {
		setAttrVal("Id_dept_name", Id_dept_name);
	}
	/**
	 * 所属科室编码
	 * @return String
	 */
	public String getId_dept_code() {
		return ((String) getAttrVal("Id_dept_code"));
	}
	/**
	 * 所属科室编码
	 * @param Id_dept_code
	 */
	public void setId_dept_code(String Id_dept_code) {
		setAttrVal("Id_dept_code", Id_dept_code);
	}
	/**
	 * 拼音
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}
	/**
	 * 拼音
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 五笔
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}
	/**
	 * 五笔
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}
	/**
	 * 助记码
	 * @param Mnecode
	 */
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	/**
	 * 生命体征测量分类
	 * @return FDateTime
	 */
	public FDateTime getCa_sv() {
		return ((FDateTime) getAttrVal("Ca_sv"));
	}
	/**
	 * 生命体征测量分类
	 * @param Ca_sv
	 */
	public void setCa_sv(FDateTime Ca_sv) {
		setAttrVal("Ca_sv", Ca_sv);
	}
	/**
	 * 医疗记录模板
	 * @return FDateTime
	 */
	public FDateTime getTpl_sv() {
		return ((FDateTime) getAttrVal("Tpl_sv"));
	}
	/**
	 * 医疗记录模板
	 * @param Tpl_sv
	 */
	public void setTpl_sv(FDateTime Tpl_sv) {
		setAttrVal("Tpl_sv", Tpl_sv);
	}
}