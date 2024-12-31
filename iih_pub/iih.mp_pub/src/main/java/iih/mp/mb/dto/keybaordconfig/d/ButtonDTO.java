package iih.mp.mb.dto.keybaordconfig.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 键盘按键 DTO数据 
 * 
 */
public class ButtonDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 按钮类型
	 * @return String
	 */
	public String getButtontype() {
		return ((String) getAttrVal("Buttontype"));
	}
	/**
	 * 按钮类型
	 * @param Buttontype
	 */
	public void setButtontype(String Buttontype) {
		setAttrVal("Buttontype", Buttontype);
	}
	/**
	 * 高
	 * @return Integer
	 */
	public Integer getButtonh() {
		return ((Integer) getAttrVal("Buttonh"));
	}
	/**
	 * 高
	 * @param Buttonh
	 */
	public void setButtonh(Integer Buttonh) {
		setAttrVal("Buttonh", Buttonh);
	}
	/**
	 * 宽
	 * @return Integer
	 */
	public Integer getButtonw() {
		return ((Integer) getAttrVal("Buttonw"));
	}
	/**
	 * 宽
	 * @param Buttonw
	 */
	public void setButtonw(Integer Buttonw) {
		setAttrVal("Buttonw", Buttonw);
	}
	/**
	 * x坐标
	 * @return Integer
	 */
	public Integer getButtonx() {
		return ((Integer) getAttrVal("Buttonx"));
	}
	/**
	 * x坐标
	 * @param Buttonx
	 */
	public void setButtonx(Integer Buttonx) {
		setAttrVal("Buttonx", Buttonx);
	}
	/**
	 * Y坐标
	 * @return Integer
	 */
	public Integer getButtony() {
		return ((Integer) getAttrVal("Buttony"));
	}
	/**
	 * Y坐标
	 * @param Buttony
	 */
	public void setButtony(Integer Buttony) {
		setAttrVal("Buttony", Buttony);
	}
	/**
	 * 背景颜色
	 * @return String
	 */
	public String getGroupc() {
		return ((String) getAttrVal("Groupc"));
	}
	/**
	 * 背景颜色
	 * @param Groupc
	 */
	public void setGroupc(String Groupc) {
		setAttrVal("Groupc", Groupc);
	}
	/**
	 * 默认文本
	 * @return String
	 */
	public String getText() {
		return ((String) getAttrVal("Text"));
	}
	/**
	 * 默认文本
	 * @param Text
	 */
	public void setText(String Text) {
		setAttrVal("Text", Text);
	}
	
	/**
	 * 按钮编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 按钮编码
	 * @param Text
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
}