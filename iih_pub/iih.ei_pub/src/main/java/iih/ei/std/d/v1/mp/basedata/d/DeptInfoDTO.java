package iih.ei.std.d.v1.mp.basedata.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 部门基础数据 DTO数据 
 * 
 */
public class DeptInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 部门编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	/**
	 * 部门编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 部门名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 部门名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
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
	 * 部门类型编码
	 * @return String
	 */
	public String getCode_depttp() {
		return ((String) getAttrVal("Code_depttp"));
	}	
	/**
	 * 部门类型编码
	 * @param Code_depttp
	 */
	public void setCode_depttp(String Code_depttp) {
		setAttrVal("Code_depttp", Code_depttp);
	}
	/**
	 * 部门类型名称
	 * @return String
	 */
	public String getName_depttp() {
		return ((String) getAttrVal("Name_depttp"));
	}	
	/**
	 * 部门类型名称
	 * @param Name_depttp
	 */
	public void setName_depttp(String Name_depttp) {
		setAttrVal("Name_depttp", Name_depttp);
	}
	/**
	 * 临床专业类型编码
	 * @return String
	 */
	public String getCode_proftp() {
		return ((String) getAttrVal("Code_proftp"));
	}	
	/**
	 * 临床专业类型编码
	 * @param Code_proftp
	 */
	public void setCode_proftp(String Code_proftp) {
		setAttrVal("Code_proftp", Code_proftp);
	}
	/**
	 * 临床专业类型名称
	 * @return String
	 */
	public String getName_proftp() {
		return ((String) getAttrVal("Name_proftp"));
	}	
	/**
	 * 临床专业类型名称
	 * @param Name_proftp
	 */
	public void setName_proftp(String Name_proftp) {
		setAttrVal("Name_proftp", Name_proftp);
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