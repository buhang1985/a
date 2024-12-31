package iih.nm.nqm.dto.nqmchktable.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 质量检查表 DTO数据 
 * 
 */
public class QcTbDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * ID
	 * @return String
	 */
	public String getId_tb() {
		return ((String) getAttrVal("Id_tb"));
	}
	/**
	 * ID
	 * @param Id_tb
	 */
	public void setId_tb(String Id_tb) {
		setAttrVal("Id_tb", Id_tb);
	}
	/**
	 * 表格标题
	 * @return String
	 */
	public String getTitle() {
		return ((String) getAttrVal("Title"));
	}
	/**
	 * 表格标题
	 * @param Title
	 */
	public void setTitle(String Title) {
		setAttrVal("Title", Title);
	}
	/**
	 * 质量检查标准id
	 * @return String
	 */
	public String getId_nqm_cs() {
		return ((String) getAttrVal("Id_nqm_cs"));
	}
	/**
	 * 质量检查标准id
	 * @param Id_nqm_cs
	 */
	public void setId_nqm_cs(String Id_nqm_cs) {
		setAttrVal("Id_nqm_cs", Id_nqm_cs);
	}
	/**
	 * 质量检查编码
	 * @return String
	 */
	public String getCode_nqm_cs() {
		return ((String) getAttrVal("Code_nqm_cs"));
	}
	/**
	 * 质量检查编码
	 * @param Code_nqm_cs
	 */
	public void setCode_nqm_cs(String Code_nqm_cs) {
		setAttrVal("Code_nqm_cs", Code_nqm_cs);
	}
	/**
	 * 质量检查名称
	 * @return String
	 */
	public String getName_nqm_cs() {
		return ((String) getAttrVal("Name_nqm_cs"));
	}
	/**
	 * 质量检查名称
	 * @param Name_nqm_cs
	 */
	public void setName_nqm_cs(String Name_nqm_cs) {
		setAttrVal("Name_nqm_cs", Name_nqm_cs);
	}
	/**
	 * 质量检查模板id
	 * @return String
	 */
	public String getId_nqm_cstmpl() {
		return ((String) getAttrVal("Id_nqm_cstmpl"));
	}
	/**
	 * 质量检查模板id
	 * @param Id_nqm_cstmpl
	 */
	public void setId_nqm_cstmpl(String Id_nqm_cstmpl) {
		setAttrVal("Id_nqm_cstmpl", Id_nqm_cstmpl);
	}
	/**
	 * 质量检查模板名称
	 * @return String
	 */
	public String getName_nqm_cstmpl() {
		return ((String) getAttrVal("Name_nqm_cstmpl"));
	}
	/**
	 * 质量检查模板名称
	 * @param Name_nqm_cstmpl
	 */
	public void setName_nqm_cstmpl(String Name_nqm_cstmpl) {
		setAttrVal("Name_nqm_cstmpl", Name_nqm_cstmpl);
	}
	/**
	 * 根节点宽度
	 * @return Integer
	 */
	public Integer getRootwidth() {
		return ((Integer) getAttrVal("Rootwidth"));
	}
	/**
	 * 根节点宽度
	 * @param Rootwidth
	 */
	public void setRootwidth(Integer Rootwidth) {
		setAttrVal("Rootwidth", Rootwidth);
	}
	/**
	 * 列集合
	 * @return FArrayList
	 */
	public FArrayList getColumns() {
		return ((FArrayList) getAttrVal("Columns"));
	}
	/**
	 * 列集合
	 * @param Columns
	 */
	public void setColumns(FArrayList Columns) {
		setAttrVal("Columns", Columns);
	}
	/**
	 * 行集合
	 * @return FArrayList
	 */
	public FArrayList getRows() {
		return ((FArrayList) getAttrVal("Rows"));
	}
	/**
	 * 行集合
	 * @param Rows
	 */
	public void setRows(FArrayList Rows) {
		setAttrVal("Rows", Rows);
	}
	/**
	 * 表尾集合
	 * @return FArrayList
	 */
	public FArrayList getFooters() {
		return ((FArrayList) getAttrVal("Footers"));
	}
	/**
	 * 表尾集合
	 * @param Footers
	 */
	public void setFooters(FArrayList Footers) {
		setAttrVal("Footers", Footers);
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