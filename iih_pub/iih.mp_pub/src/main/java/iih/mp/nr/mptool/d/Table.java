package iih.mp.nr.mptool.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 数据库表属性 DTO数据 
 * 
 */
public class Table extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 实体ID
	 * @return String
	 */
	public String getId_class() {
		return ((String) getAttrVal("Id_class"));
	}
	/**
	 * 实体ID
	 * @param Id_class
	 */
	public void setId_class(String Id_class) {
		setAttrVal("Id_class", Id_class);
	}
	/**
	 * 显示名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 显示名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 表名
	 * @return String
	 */
	public String getTable_name() {
		return ((String) getAttrVal("Table_name"));
	}
	/**
	 * 表名
	 * @param Table_name
	 */
	public void setTable_name(String Table_name) {
		setAttrVal("Table_name", Table_name);
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
}