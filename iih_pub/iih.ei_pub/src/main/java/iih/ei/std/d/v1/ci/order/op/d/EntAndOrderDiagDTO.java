package iih.ei.std.d.v1.ci.order.op.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱诊断信息 DTO数据 
 * 
 */
public class EntAndOrderDiagDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getCode_en() {
		return ((String) getAttrVal("Code_en"));
	}	
	/**
	 * 就诊编码
	 * @param Code_en
	 */
	public void setCode_en(String Code_en) {
		setAttrVal("Code_en", Code_en);
	}
	/**
	 * 临床诊断编码
	 * @return String
	 */
	public String getCode_diag() {
		return ((String) getAttrVal("Code_diag"));
	}	
	/**
	 * 临床诊断编码
	 * @param Code_diag
	 */
	public void setCode_diag(String Code_diag) {
		setAttrVal("Code_diag", Code_diag);
	}
	/**
	 * 临床诊断名称
	 * @return String
	 */
	public String getName_diag() {
		return ((String) getAttrVal("Name_diag"));
	}	
	/**
	 * 临床诊断名称
	 * @param Name_diag
	 */
	public void setName_diag(String Name_diag) {
		setAttrVal("Name_diag", Name_diag);
	}
}