package iih.hp.cp.app.dto;

import xap.mw.core.data.BaseDTO;

/**
 * 临床路径元素DTO
 * @author HUMS
 *
 */
public class HpCpEleDTO extends BaseDTO{

	/**
	 * 临床路径Id
	 * 
	 * @return String
	 */
	public String getId_cp() {
		return ((String) getAttrVal("Id_cp"));
	}

	/**
	 * 临床路径Id
	 * 
	 * @param Id_cp
	 */
	public void setId_cp(String Id_cp) {
		setAttrVal("Id_cp", Id_cp);
	}
	
	/**
	 * 临床路径阶段Id
	 * @return String
	 */
	public String getId_ele_stage() {
		return ((String) getAttrVal("Id_ele_stage"));
	}

	/**
	 * 临床路径阶段Id
	 * @param Id_ele_stage
	 */
	public void setId_ele_stage(String Id_ele_stage) {
		setAttrVal("Id_ele_stage", Id_ele_stage);
	}
	
	
	/**
	 * 诊疗计划元素ID
	 * 
	 * @return String
	 */
	public String getId_ele() {
		return ((String) getAttrVal("Id_ele"));
	}

	/**
	 * 诊疗计划元素ID
	 * 
	 * @param Id_ele
	 */
	public void setId_ele(String Id_ele) {
		setAttrVal("Id_ele", Id_ele);
	}
	/**
	 * 诊疗计划元素编码
	 * 
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}

	/**
	 * 诊疗计划元素编码
	 * 
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 诊疗计划元素名称
	 * 
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}

	/**
	 * 诊疗计划元素名称
	 * 
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	
	/**
	 * 元素必选标识
	 * 
	 * @return String
	 */
	public String getFg_necessary() {
		return ((String) getAttrVal("Fg_necessary"));
	}

	/**
	 * 元素必选标识
	 * 
	 * @param Fg_necessary
	 */
	public void setFg_necessary(String Fg_necessary) {
		setAttrVal("Fg_necessary", Fg_necessary);
	}
	
	
	/**
	 * 元素序号
	 * 
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}

	/**
	 * 元素序号
	 * 
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	
	/**
	 * 元素类型编码
	 * 
	 * @return Integer
	 */
	public String getEletp_code() {
		return ((String) getAttrVal("Eletp_code"));
	}

	/**
	 * 元素类型编码
	 * 
	 * @param Sortno
	 */
	public void setEletp_code(String Eletp_code) {
		setAttrVal("Eletp_code", Eletp_code);
	}
}
