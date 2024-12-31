package iih.ei.std.d.v1.en.enstate.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 多个就诊编码组成的入参 DTO数据 
 * 
 */
public class CodeEntsParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getCode_ents() {
		return ((String) getAttrVal("Code_ents"));
	}	
	/**
	 * 就诊编码
	 * @param Code_ents
	 */
	public void setCode_ents(String Code_ents) {
		setAttrVal("Code_ents", Code_ents);
	}
}