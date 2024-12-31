package iih.pe.pwf.dto.morphtestreportinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 操作方法信息 DTO数据 
 * 
 */
public class OperateMethodDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 标本条码号
	 * @return String
	 */
	public String getSampleno() {
		return ((String) getAttrVal("Sampleno"));
	}
	/**
	 * 标本条码号
	 * @param Sampleno
	 */
	public void setSampleno(String Sampleno) {
		setAttrVal("Sampleno", Sampleno);
	}
	/**
	 * 操作方法信息编码
	 * @return String
	 */
	public String getOminfocode() {
		return ((String) getAttrVal("Ominfocode"));
	}
	/**
	 * 操作方法信息编码
	 * @param Ominfocode
	 */
	public void setOminfocode(String Ominfocode) {
		setAttrVal("Ominfocode", Ominfocode);
	}
	/**
	 * 操作方法编码
	 * @return String
	 */
	public String getOmcode() {
		return ((String) getAttrVal("Omcode"));
	}
	/**
	 * 操作方法编码
	 * @param Omcode
	 */
	public void setOmcode(String Omcode) {
		setAttrVal("Omcode", Omcode);
	}
	/**
	 * 操作方法名称
	 * @return String
	 */
	public String getOmname() {
		return ((String) getAttrVal("Omname"));
	}
	/**
	 * 操作方法名称
	 * @param Omname
	 */
	public void setOmname(String Omname) {
		setAttrVal("Omname", Omname);
	}
}