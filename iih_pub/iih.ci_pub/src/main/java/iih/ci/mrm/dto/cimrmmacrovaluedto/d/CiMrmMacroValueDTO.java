package iih.ci.mrm.dto.cimrmmacrovaluedto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 宏元素查询数据DTO DTO数据 
 * 
 */
public class CiMrmMacroValueDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 宏元素主键
	 * @return String
	 */
	public String getId_marco_value() {
		return ((String) getAttrVal("Id_marco_value"));
	}
	/**
	 * 宏元素主键
	 * @param Id_marco_value
	 */
	public void setId_marco_value(String Id_marco_value) {
		setAttrVal("Id_marco_value", Id_marco_value);
	}
	/**
	 * 所属集团id
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}
	/**
	 * 所属集团id
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织id
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 所属组织id
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 宏元素自定义主键
	 * @return String
	 */
	public String getId_type() {
		return ((String) getAttrVal("Id_type"));
	}
	/**
	 * 宏元素自定义主键
	 * @param Id_type
	 */
	public void setId_type(String Id_type) {
		setAttrVal("Id_type", Id_type);
	}
	/**
	 * 宏元素自定义编码
	 * @return String
	 */
	public String getSd_type() {
		return ((String) getAttrVal("Sd_type"));
	}
	/**
	 * 宏元素自定义编码
	 * @param Sd_type
	 */
	public void setSd_type(String Sd_type) {
		setAttrVal("Sd_type", Sd_type);
	}
	/**
	 * 宏元素自定义名称
	 * @return String
	 */
	public String getName_type() {
		return ((String) getAttrVal("Name_type"));
	}
	/**
	 * 宏元素自定义名称
	 * @param Name_type
	 */
	public void setName_type(String Name_type) {
		setAttrVal("Name_type", Name_type);
	}
	/**
	 * 病历元素表主键
	 * @return String
	 */
	public String getId_mr_de() {
		return ((String) getAttrVal("Id_mr_de"));
	}
	/**
	 * 病历元素表主键
	 * @param Id_mr_de
	 */
	public void setId_mr_de(String Id_mr_de) {
		setAttrVal("Id_mr_de", Id_mr_de);
	}
	/**
	 * 病历元素表编码
	 * @return String
	 */
	public String getSd_mr_de() {
		return ((String) getAttrVal("Sd_mr_de"));
	}
	/**
	 * 病历元素表编码
	 * @param Sd_mr_de
	 */
	public void setSd_mr_de(String Sd_mr_de) {
		setAttrVal("Sd_mr_de", Sd_mr_de);
	}
	/**
	 * 病历元素表名称
	 * @return String
	 */
	public String getName_mr_de() {
		return ((String) getAttrVal("Name_mr_de"));
	}
	/**
	 * 病历元素表名称
	 * @param Name_mr_de
	 */
	public void setName_mr_de(String Name_mr_de) {
		setAttrVal("Name_mr_de", Name_mr_de);
	}
	/**
	 * 表名
	 * @return String
	 */
	public String getName_table() {
		return ((String) getAttrVal("Name_table"));
	}
	/**
	 * 表名
	 * @param Name_table
	 */
	public void setName_table(String Name_table) {
		setAttrVal("Name_table", Name_table);
	}
	/**
	 * 字段名
	 * @return String
	 */
	public String getName_column() {
		return ((String) getAttrVal("Name_column"));
	}
	/**
	 * 字段名
	 * @param Name_column
	 */
	public void setName_column(String Name_column) {
		setAttrVal("Name_column", Name_column);
	}
	/**
	 * 是否启用
	 * @return String
	 */
	public String getFg_active() {
		return ((String) getAttrVal("Fg_active"));
	}
	/**
	 * 是否启用
	 * @param Fg_active
	 */
	public void setFg_active(String Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 公共数据元编码
	 * @return String
	 */
	public String getCode_de() {
		return ((String) getAttrVal("Code_de"));
	}
	/**
	 * 公共数据元编码
	 * @param Code_de
	 */
	public void setCode_de(String Code_de) {
		setAttrVal("Code_de", Code_de);
	}
}