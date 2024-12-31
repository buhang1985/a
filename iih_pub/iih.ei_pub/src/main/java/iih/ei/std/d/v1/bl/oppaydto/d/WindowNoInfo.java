package iih.ei.std.d.v1.bl.oppaydto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 药品窗口号 DTO数据 
 * 
 */
public class WindowNoInfo extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 申请单编码
	 * @return String
	 */
	public String getCode_apply() {
		return ((String) getAttrVal("Code_apply"));
	}	
	/**
	 * 申请单编码
	 * @param Code_apply
	 */
	public void setCode_apply(String Code_apply) {
		setAttrVal("Code_apply", Code_apply);
	}
	/**
	 * 窗口号
	 * @return String
	 */
	public String getWindowno() {
		return ((String) getAttrVal("Windowno"));
	}	
	/**
	 * 窗口号
	 * @param Windowno
	 */
	public void setWindowno(String Windowno) {
		setAttrVal("Windowno", Windowno);
	}
}