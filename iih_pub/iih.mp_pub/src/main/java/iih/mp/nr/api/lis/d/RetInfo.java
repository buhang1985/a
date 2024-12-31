package iih.mp.nr.api.lis.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 接收检验报告返回消息 DTO数据 
 * 
 */
public class RetInfo extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 结果代码
	 * @return String
	 */
	public String getResult_code() {
		return ((String) getAttrVal("Result_code"));
	}
	/**
	 * 结果代码
	 * @param Result_code
	 */
	public void setResult_code(String Result_code) {
		setAttrVal("Result_code", Result_code);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
}