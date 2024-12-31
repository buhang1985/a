package iih.pis.phk.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 科室介绍 DTO数据 
 * 
 */
public class DeptPsndocDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 科室id
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 科室id
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}
	/**
	 * 科室编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 科室地址
	 * @return String
	 */
	public String getAddr_dep() {
		return ((String) getAttrVal("Addr_dep"));
	}
	/**
	 * 科室地址
	 * @param Addr_dep
	 */
	public void setAddr_dep(String Addr_dep) {
		setAttrVal("Addr_dep", Addr_dep);
	}
	/**
	 * 科室描述
	 * @return String
	 */
	public String getDes_dep() {
		return ((String) getAttrVal("Des_dep"));
	}
	/**
	 * 科室描述
	 * @param Des_dep
	 */
	public void setDes_dep(String Des_dep) {
		setAttrVal("Des_dep", Des_dep);
	}
	/**
	 * 人员信息
	 * @return FArrayList
	 */
	public FArrayList getGuidepsninfo() {
		return ((FArrayList) getAttrVal("Guidepsninfo"));
	}
	/**
	 * 人员信息
	 * @param Guidepsninfo
	 */
	public void setGuidepsninfo(FArrayList Guidepsninfo) {
		setAttrVal("Guidepsninfo", Guidepsninfo);
	}
}