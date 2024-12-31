package iih.nm.nqm.dto.nqmchktable.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 质量检查行数据 DTO数据 
 * 
 */
public class QcTbRowDTO extends BaseDTO {
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
	 * 质量检查指标名称
	 * @return String
	 */
	public String getName_nqm_kpi() {
		return ((String) getAttrVal("Name_nqm_kpi"));
	}
	/**
	 * 质量检查指标名称
	 * @param Name_nqm_kpi
	 */
	public void setName_nqm_kpi(String Name_nqm_kpi) {
		setAttrVal("Name_nqm_kpi", Name_nqm_kpi);
	}
	/**
	 * 父级质量检查指标id
	 * @return String
	 */
	public String getId_nqm_kpi_par() {
		return ((String) getAttrVal("Id_nqm_kpi_par"));
	}
	/**
	 * 父级质量检查指标id
	 * @param Id_nqm_kpi_par
	 */
	public void setId_nqm_kpi_par(String Id_nqm_kpi_par) {
		setAttrVal("Id_nqm_kpi_par", Id_nqm_kpi_par);
	}
	/**
	 * 树形列标识
	 * @return String
	 */
	public String getId_column() {
		return ((String) getAttrVal("Id_column"));
	}
	/**
	 * 树形列标识
	 * @param Id_column
	 */
	public void setId_column(String Id_column) {
		setAttrVal("Id_column", Id_column);
	}
	/**
	 * 叶子节点标志
	 * @return FBoolean
	 */
	public FBoolean getFg_child() {
		return ((FBoolean) getAttrVal("Fg_child"));
	}
	/**
	 * 叶子节点标志
	 * @param Fg_child
	 */
	public void setFg_child(FBoolean Fg_child) {
		setAttrVal("Fg_child", Fg_child);
	}
	/**
	 * 质量检查单元格数据集合
	 * @return FArrayList
	 */
	public FArrayList getCells() {
		return ((FArrayList) getAttrVal("Cells"));
	}
	/**
	 * 质量检查单元格数据集合
	 * @param Cells
	 */
	public void setCells(FArrayList Cells) {
		setAttrVal("Cells", Cells);
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