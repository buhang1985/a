package iih.nm.nqm.dto.nqmchktable.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 表格列 DTO数据 
 * 
 */
public class QCTbColumnDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 列名称
	 * @return String
	 */
	public String getCaption() {
		return ((String) getAttrVal("Caption"));
	}
	/**
	 * 列名称
	 * @param Caption
	 */
	public void setCaption(String Caption) {
		setAttrVal("Caption", Caption);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 列宽
	 * @return Integer
	 */
	public Integer getWidth() {
		return ((Integer) getAttrVal("Width"));
	}
	/**
	 * 列宽
	 * @param Width
	 */
	public void setWidth(Integer Width) {
		setAttrVal("Width", Width);
	}
	/**
	 * 是否可见
	 * @return FBoolean
	 */
	public FBoolean getVisiable() {
		return ((FBoolean) getAttrVal("Visiable"));
	}
	/**
	 * 是否可见
	 * @param Visiable
	 */
	public void setVisiable(FBoolean Visiable) {
		setAttrVal("Visiable", Visiable);
	}
	/**
	 * 是否可编辑
	 * @return FBoolean
	 */
	public FBoolean getEditable() {
		return ((FBoolean) getAttrVal("Editable"));
	}
	/**
	 * 是否可编辑
	 * @param Editable
	 */
	public void setEditable(FBoolean Editable) {
		setAttrVal("Editable", Editable);
	}
	/**
	 * 水平对齐方式
	 * @return Integer
	 */
	public Integer getEu_horizontal() {
		return ((Integer) getAttrVal("Eu_horizontal"));
	}
	/**
	 * 水平对齐方式
	 * @param Eu_horizontal
	 */
	public void setEu_horizontal(Integer Eu_horizontal) {
		setAttrVal("Eu_horizontal", Eu_horizontal);
	}
	/**
	 * 垂直对齐方式
	 * @return Integer
	 */
	public Integer getEu_vertical() {
		return ((Integer) getAttrVal("Eu_vertical"));
	}
	/**
	 * 垂直对齐方式
	 * @param Eu_vertical
	 */
	public void setEu_vertical(Integer Eu_vertical) {
		setAttrVal("Eu_vertical", Eu_vertical);
	}
	/**
	 * 列类型
	 * @return Integer
	 */
	public Integer getEu_columntp() {
		return ((Integer) getAttrVal("Eu_columntp"));
	}
	/**
	 * 列类型
	 * @param Eu_columntp
	 */
	public void setEu_columntp(Integer Eu_columntp) {
		setAttrVal("Eu_columntp", Eu_columntp);
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