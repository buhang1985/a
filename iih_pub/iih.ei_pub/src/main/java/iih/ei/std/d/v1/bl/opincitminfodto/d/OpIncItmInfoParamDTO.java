package iih.ei.std.d.v1.bl.opincitminfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊自助发票明细查询入参 DTO数据 
 * 
 */
public class OpIncItmInfoParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 结算号
	 * @return String
	 */
	public String getCode_stoep() {
		return ((String) getAttrVal("Code_stoep"));
	}	
	/**
	 * 结算号
	 * @param Code_stoep
	 */
	public void setCode_stoep(String Code_stoep) {
		setAttrVal("Code_stoep", Code_stoep);
	}
	/**
	 * 操作员编码
	 * @return String
	 */
	public String getCode_opera() {
		return ((String) getAttrVal("Code_opera"));
	}	
	/**
	 * 操作员编码
	 * @param Code_opera
	 */
	public void setCode_opera(String Code_opera) {
		setAttrVal("Code_opera", Code_opera);
	}
}