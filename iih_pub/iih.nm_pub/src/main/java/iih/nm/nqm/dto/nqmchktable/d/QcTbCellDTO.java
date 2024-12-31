package iih.nm.nqm.dto.nqmchktable.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 质量检查单元格数据 DTO数据 
 * 
 */
public class QcTbCellDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 质量检查指标id
	 * @return String
	 */
	public String getId_nqm_kpi() {
		return ((String) getAttrVal("Id_nqm_kpi"));
	}
	/**
	 * 质量检查指标id
	 * @param Id_nqm_kpi
	 */
	public void setId_nqm_kpi(String Id_nqm_kpi) {
		setAttrVal("Id_nqm_kpi", Id_nqm_kpi);
	}
	/**
	 * 质量检查指标编码
	 * @return String
	 */
	public String getCode_nqm_kpi() {
		return ((String) getAttrVal("Code_nqm_kpi"));
	}
	/**
	 * 质量检查指标编码
	 * @param Code_nqm_kpi
	 */
	public void setCode_nqm_kpi(String Code_nqm_kpi) {
		setAttrVal("Code_nqm_kpi", Code_nqm_kpi);
	}
	/**
	 * 列标识
	 * @return String
	 */
	public String getId_column() {
		return ((String) getAttrVal("Id_column"));
	}
	/**
	 * 列标识
	 * @param Id_column
	 */
	public void setId_column(String Id_column) {
		setAttrVal("Id_column", Id_column);
	}
	/**
	 * 值id
	 * @return String
	 */
	public String getId_value() {
		return ((String) getAttrVal("Id_value"));
	}
	/**
	 * 值id
	 * @param Id_value
	 */
	public void setId_value(String Id_value) {
		setAttrVal("Id_value", Id_value);
	}
	/**
	 * 值编码
	 * @return String
	 */
	public String getCode_value() {
		return ((String) getAttrVal("Code_value"));
	}
	/**
	 * 值编码
	 * @param Code_value
	 */
	public void setCode_value(String Code_value) {
		setAttrVal("Code_value", Code_value);
	}
	/**
	 * 值(显示文本)
	 * @return String
	 */
	public String getValue() {
		return ((String) getAttrVal("Value"));
	}
	/**
	 * 值(显示文本)
	 * @param Value
	 */
	public void setValue(String Value) {
		setAttrVal("Value", Value);
	}
	/**
	 * 上限值
	 * @return FDouble
	 */
	public FDouble getMax_value() {
		return ((FDouble) getAttrVal("Max_value"));
	}
	/**
	 * 上限值
	 * @param Max_value
	 */
	public void setMax_value(FDouble Max_value) {
		setAttrVal("Max_value", Max_value);
	}
	/**
	 * 下限值
	 * @return FDouble
	 */
	public FDouble getMin_value() {
		return ((FDouble) getAttrVal("Min_value"));
	}
	/**
	 * 下限值
	 * @param Min_value
	 */
	public void setMin_value(FDouble Min_value) {
		setAttrVal("Min_value", Min_value);
	}
	/**
	 * 值数据源
	 * @return FArrayList
	 */
	public FArrayList getValuelist() {
		return ((FArrayList) getAttrVal("Valuelist"));
	}
	/**
	 * 值数据源
	 * @param Valuelist
	 */
	public void setValuelist(FArrayList Valuelist) {
		setAttrVal("Valuelist", Valuelist);
	}
	/**
	 * 评分类型
	 * @return Integer
	 */
	public Integer getEu_gradtp() {
		return ((Integer) getAttrVal("Eu_gradtp"));
	}
	/**
	 * 评分类型
	 * @param Eu_gradtp
	 */
	public void setEu_gradtp(Integer Eu_gradtp) {
		setAttrVal("Eu_gradtp", Eu_gradtp);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}
	/**
	 * 扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}
	/**
	 * 扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}
	/**
	 * 扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}
	/**
	 * 扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}
	/**
	 * 扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
}