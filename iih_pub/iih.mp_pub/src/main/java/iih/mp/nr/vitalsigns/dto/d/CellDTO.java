package iih.mp.nr.vitalsigns.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 单元格结构 DTO数据 
 * 
 */
public class CellDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 是否文本
	 * @return FBoolean
	 */
	public FBoolean getFg_str() {
		return ((FBoolean) getAttrVal("Fg_str"));
	}
	/**
	 * 是否文本
	 * @param Fg_str
	 */
	public void setFg_str(FBoolean Fg_str) {
		setAttrVal("Fg_str", Fg_str);
	}
	/**
	 * 文本值
	 * @return String
	 */
	public String getValue() {
		return ((String) getAttrVal("Value"));
	}
	/**
	 * 文本值
	 * @param Value
	 */
	public void setValue(String Value) {
		setAttrVal("Value", Value);
	}
	/**
	 * 控件集合
	 * @return FArrayList
	 */
	public FArrayList getControls() {
		return ((FArrayList) getAttrVal("Controls"));
	}
	/**
	 * 控件集合
	 * @param Controls
	 */
	public void setControls(FArrayList Controls) {
		setAttrVal("Controls", Controls);
	}
	/**
	 * 单元格内容是否可见
	 * @return FBoolean
	 */
	public FBoolean getFg_visiable() {
		return ((FBoolean) getAttrVal("Fg_visiable"));
	}
	/**
	 * 单元格内容是否可见
	 * @param Fg_visiable
	 */
	public void setFg_visiable(FBoolean Fg_visiable) {
		setAttrVal("Fg_visiable", Fg_visiable);
	}
}