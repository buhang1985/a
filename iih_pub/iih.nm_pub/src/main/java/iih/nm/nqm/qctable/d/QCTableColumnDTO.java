package iih.nm.nqm.qctable.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 质量检查表格列 DTO数据 
 * 
 */
public class QCTableColumnDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
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
	public FBoolean getFg_visiable() {
		return ((FBoolean) getAttrVal("Fg_visiable"));
	}
	/**
	 * 是否可见
	 * @param Fg_visiable
	 */
	public void setFg_visiable(FBoolean Fg_visiable) {
		setAttrVal("Fg_visiable", Fg_visiable);
	}
	/**
	 * 水平对齐方式
	 * @return Integer
	 */
	public Integer getHorizontal() {
		return ((Integer) getAttrVal("Horizontal"));
	}
	/**
	 * 水平对齐方式
	 * @param Horizontal
	 */
	public void setHorizontal(Integer Horizontal) {
		setAttrVal("Horizontal", Horizontal);
	}
	/**
	 * 垂直对齐方式
	 * @return Integer
	 */
	public Integer getVertical() {
		return ((Integer) getAttrVal("Vertical"));
	}
	/**
	 * 垂直对齐方式
	 * @param Vertical
	 */
	public void setVertical(Integer Vertical) {
		setAttrVal("Vertical", Vertical);
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
}