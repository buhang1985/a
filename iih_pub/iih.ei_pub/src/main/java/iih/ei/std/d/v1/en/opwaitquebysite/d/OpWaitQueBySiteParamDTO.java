package iih.ei.std.d.v1.en.opwaitquebysite.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医生站点候诊队列入参 DTO数据 
 * 
 */
public class OpWaitQueBySiteParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 站点编码
	 * @return String
	 */
	public String getCode_site() {
		return ((String) getAttrVal("Code_site"));
	}	
	/**
	 * 站点编码
	 * @param Code_site
	 */
	public void setCode_site(String Code_site) {
		setAttrVal("Code_site", Code_site);
	}
	/**
	 * 操作员
	 * @return String
	 */
	public String getCode_opr() {
		return ((String) getAttrVal("Code_opr"));
	}	
	/**
	 * 操作员
	 * @param Code_opr
	 */
	public void setCode_opr(String Code_opr) {
		setAttrVal("Code_opr", Code_opr);
	}
}