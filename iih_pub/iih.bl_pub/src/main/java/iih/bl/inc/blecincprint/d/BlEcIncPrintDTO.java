package iih.bl.inc.blecincprint.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 电子票据打印数据 DTO数据 
 * 
 */
public class BlEcIncPrintDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 结算id
	 * @return String
	 */
	public String getId_st() {
		return ((String) getAttrVal("Id_st"));
	}
	/**
	 * 结算id
	 * @param Id_st
	 */
	public void setId_st(String Id_st) {
		setAttrVal("Id_st", Id_st);
	}
}