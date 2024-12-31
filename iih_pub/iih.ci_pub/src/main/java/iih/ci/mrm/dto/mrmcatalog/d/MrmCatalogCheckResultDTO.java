package iih.ci.mrm.dto.mrmcatalog.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 病案编目核查结果 DTO数据 
 * 
 */
public class MrmCatalogCheckResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_mrcatalogverifyrules() {
		return ((String) getAttrVal("Id_mrcatalogverifyrules"));
	}
	/**
	 * 主键
	 * @param Id_mrcatalogverifyrules
	 */
	public void setId_mrcatalogverifyrules(String Id_mrcatalogverifyrules) {
		setAttrVal("Id_mrcatalogverifyrules", Id_mrcatalogverifyrules);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 序号
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 表名
	 * @return String
	 */
	public String getTabname() {
		return ((String) getAttrVal("Tabname"));
	}
	/**
	 * 表名
	 * @param Tabname
	 */
	public void setTabname(String Tabname) {
		setAttrVal("Tabname", Tabname);
	}
	/**
	 * 字段名
	 * @return String
	 */
	public String getFieldname() {
		return ((String) getAttrVal("Fieldname"));
	}
	/**
	 * 字段名
	 * @param Fieldname
	 */
	public void setFieldname(String Fieldname) {
		setAttrVal("Fieldname", Fieldname);
	}
	/**
	 * 控件名
	 * @return String
	 */
	public String getCtlname() {
		return ((String) getAttrVal("Ctlname"));
	}
	/**
	 * 控件名
	 * @param Ctlname
	 */
	public void setCtlname(String Ctlname) {
		setAttrVal("Ctlname", Ctlname);
	}
	/**
	 * 审核脚本
	 * @return String
	 */
	public String getVerify_script() {
		return ((String) getAttrVal("Verify_script"));
	}
	/**
	 * 审核脚本
	 * @param Verify_script
	 */
	public void setVerify_script(String Verify_script) {
		setAttrVal("Verify_script", Verify_script);
	}
	/**
	 * 脚本类型
	 * @return String
	 */
	public String getId_type_script() {
		return ((String) getAttrVal("Id_type_script"));
	}
	/**
	 * 脚本类型
	 * @param Id_type_script
	 */
	public void setId_type_script(String Id_type_script) {
		setAttrVal("Id_type_script", Id_type_script);
	}
	/**
	 * 脚本类型名称
	 * @return String
	 */
	public String getName_type_script() {
		return ((String) getAttrVal("Name_type_script"));
	}
	/**
	 * 脚本类型名称
	 * @param Name_type_script
	 */
	public void setName_type_script(String Name_type_script) {
		setAttrVal("Name_type_script", Name_type_script);
	}
	/**
	 * 脚本类型编码
	 * @return String
	 */
	public String getCode_type_script() {
		return ((String) getAttrVal("Code_type_script"));
	}
	/**
	 * 脚本类型编码
	 * @param Code_type_script
	 */
	public void setCode_type_script(String Code_type_script) {
		setAttrVal("Code_type_script", Code_type_script);
	}
	/**
	 * 错误提示
	 * @return String
	 */
	public String getErr_text() {
		return ((String) getAttrVal("Err_text"));
	}
	/**
	 * 错误提示
	 * @param Err_text
	 */
	public void setErr_text(String Err_text) {
		setAttrVal("Err_text", Err_text);
	}
	/**
	 * 规则类型
	 * @return String
	 */
	public String getId_rule_type() {
		return ((String) getAttrVal("Id_rule_type"));
	}
	/**
	 * 规则类型
	 * @param Id_rule_type
	 */
	public void setId_rule_type(String Id_rule_type) {
		setAttrVal("Id_rule_type", Id_rule_type);
	}
	/**
	 * 规则类型编码
	 * @return String
	 */
	public String getCode_rule_type() {
		return ((String) getAttrVal("Code_rule_type"));
	}
	/**
	 * 规则类型编码
	 * @param Code_rule_type
	 */
	public void setCode_rule_type(String Code_rule_type) {
		setAttrVal("Code_rule_type", Code_rule_type);
	}
	/**
	 * 规则类型名称
	 * @return String
	 */
	public String getName_rule_type() {
		return ((String) getAttrVal("Name_rule_type"));
	}
	/**
	 * 规则类型名称
	 * @param Name_rule_type
	 */
	public void setName_rule_type(String Name_rule_type) {
		setAttrVal("Name_rule_type", Name_rule_type);
	}
	/**
	 * 规则类型颜色
	 * @return String
	 */
	public String getColor_rule_type() {
		return ((String) getAttrVal("Color_rule_type"));
	}
	/**
	 * 规则类型颜色
	 * @param Color_rule_type
	 */
	public void setColor_rule_type(String Color_rule_type) {
		setAttrVal("Color_rule_type", Color_rule_type);
	}
	/**
	 * 审核范围
	 * @return String
	 */
	public String getId_audit_scope() {
		return ((String) getAttrVal("Id_audit_scope"));
	}
	/**
	 * 审核范围
	 * @param Id_audit_scope
	 */
	public void setId_audit_scope(String Id_audit_scope) {
		setAttrVal("Id_audit_scope", Id_audit_scope);
	}
	/**
	 * 审核范围编码
	 * @return String
	 */
	public String getCode_audit_scope() {
		return ((String) getAttrVal("Code_audit_scope"));
	}
	/**
	 * 审核范围编码
	 * @param Code_audit_scope
	 */
	public void setCode_audit_scope(String Code_audit_scope) {
		setAttrVal("Code_audit_scope", Code_audit_scope);
	}
	/**
	 * 审核范围名称
	 * @return String
	 */
	public String getName_audit_scope() {
		return ((String) getAttrVal("Name_audit_scope"));
	}
	/**
	 * 审核范围名称
	 * @param Name_audit_scope
	 */
	public void setName_audit_scope(String Name_audit_scope) {
		setAttrVal("Name_audit_scope", Name_audit_scope);
	}
	/**
	 * 适用范围
	 * @return String
	 */
	public String getId_range_apply() {
		return ((String) getAttrVal("Id_range_apply"));
	}
	/**
	 * 适用范围
	 * @param Id_range_apply
	 */
	public void setId_range_apply(String Id_range_apply) {
		setAttrVal("Id_range_apply", Id_range_apply);
	}
	/**
	 * 适用范围编码
	 * @return String
	 */
	public String getCode_range_apply() {
		return ((String) getAttrVal("Code_range_apply"));
	}
	/**
	 * 适用范围编码
	 * @param Code_range_apply
	 */
	public void setCode_range_apply(String Code_range_apply) {
		setAttrVal("Code_range_apply", Code_range_apply);
	}
	/**
	 * 适用范围名称
	 * @return String
	 */
	public String getName_range_apply() {
		return ((String) getAttrVal("Name_range_apply"));
	}
	/**
	 * 适用范围名称
	 * @param Name_range_apply
	 */
	public void setName_range_apply(String Name_range_apply) {
		setAttrVal("Name_range_apply", Name_range_apply);
	}
	/**
	 * 错误数量
	 * @return String
	 */
	public String getErrorcount() {
		return ((String) getAttrVal("Errorcount"));
	}
	/**
	 * 错误数量
	 * @param Errorcount
	 */
	public void setErrorcount(String Errorcount) {
		setAttrVal("Errorcount", Errorcount);
	}
}