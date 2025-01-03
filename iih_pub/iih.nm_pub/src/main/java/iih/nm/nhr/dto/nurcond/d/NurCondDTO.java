package iih.nm.nhr.dto.nurcond.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 人员查询条件 DTO数据 
 * 
 */
public class NurCondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 条件id
	 * @return String
	 */
	public String getId_cond() {
		return ((String) getAttrVal("Id_cond"));
	}
	/**
	 * 条件id
	 * @param Id_cond
	 */
	public void setId_cond(String Id_cond) {
		setAttrVal("Id_cond", Id_cond);
	}
	/**
	 * 条件编码
	 * @return String
	 */
	public String getCode_cond() {
		return ((String) getAttrVal("Code_cond"));
	}
	/**
	 * 条件编码
	 * @param Code_cond
	 */
	public void setCode_cond(String Code_cond) {
		setAttrVal("Code_cond", Code_cond);
	}
	/**
	 * 条件名称
	 * @return String
	 */
	public String getName_cond() {
		return ((String) getAttrVal("Name_cond"));
	}
	/**
	 * 条件名称
	 * @param Name_cond
	 */
	public void setName_cond(String Name_cond) {
		setAttrVal("Name_cond", Name_cond);
	}
	/**
	 * 业务数据id
	 * @return String
	 */
	public String getId() {
		return ((String) getAttrVal("Id"));
	}
	/**
	 * 业务数据id
	 * @param Id
	 */
	public void setId(String Id) {
		setAttrVal("Id", Id);
	}
	/**
	 * 业务数据父级id
	 * @return String
	 */
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}
	/**
	 * 业务数据父级id
	 * @param Id_par
	 */
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
	}
	/**
	 * 业务数据名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 业务数据名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 业务数据编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 业务数据编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 部门id
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 部门id
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 上级护理单元id
	 * @return String
	 */
	public String getId_dep_par() {
		return ((String) getAttrVal("Id_dep_par"));
	}
	/**
	 * 上级护理单元id
	 * @param Id_dep_par
	 */
	public void setId_dep_par(String Id_dep_par) {
		setAttrVal("Id_dep_par", Id_dep_par);
	}
}