package iih.ei.std.d.v1.mp.basedata.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 标本类型数据 DTO数据 
 * 
 */
public class SamptpInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 标本编码
	 * @return String
	 */
	public String getCode_sampt() {
		return ((String) getAttrVal("Code_sampt"));
	}	
	/**
	 * 标本编码
	 * @param Code_sampt
	 */
	public void setCode_sampt(String Code_sampt) {
		setAttrVal("Code_sampt", Code_sampt);
	}
	/**
	 * 标本名称
	 * @return String
	 */
	public String getName_sampt() {
		return ((String) getAttrVal("Name_sampt"));
	}	
	/**
	 * 标本名称
	 * @param Name_sampt
	 */
	public void setName_sampt(String Name_sampt) {
		setAttrVal("Name_sampt", Name_sampt);
	}
	/**
	 * 组织编码
	 * @return String
	 */
	public String getCode_org() {
		return ((String) getAttrVal("Code_org"));
	}	
	/**
	 * 组织编码
	 * @param Code_org
	 */
	public void setCode_org(String Code_org) {
		setAttrVal("Code_org", Code_org);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	/**
	 * 组织名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 最后更改时间
	 * @return String
	 */
	public String getTimestamp() {
		return ((String) getAttrVal("Timestamp"));
	}	
	/**
	 * 最后更改时间
	 * @param Timestamp
	 */
	public void setTimestamp(String Timestamp) {
		setAttrVal("Timestamp", Timestamp);
	}
}