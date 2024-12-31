package iih.hp.cp.applist.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 元素类型Tab页数据源 DTO数据 
 * 
 */
public class EleTypeTabDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 元素ID
	 * @return String
	 */
	public String getId_ele() {
		return ((String) getAttrVal("Id_ele"));
	}
	/**
	 * 元素ID
	 * @param Id_ele
	 */
	public void setId_ele(String Id_ele) {
		setAttrVal("Id_ele", Id_ele);
	}
	/**
	 * 元素类型
	 * @return String
	 */
	public String getId_eletp() {
		return ((String) getAttrVal("Id_eletp"));
	}
	/**
	 * 元素类型
	 * @param Id_eletp
	 */
	public void setId_eletp(String Id_eletp) {
		setAttrVal("Id_eletp", Id_eletp);
	}
	/**
	 * 元素类型编码
	 * @return String
	 */
	public String getEletp_code() {
		return ((String) getAttrVal("Eletp_code"));
	}
	/**
	 * 元素类型编码
	 * @param Eletp_code
	 */
	public void setEletp_code(String Eletp_code) {
		setAttrVal("Eletp_code", Eletp_code);
	}
	/**
	 * 所属阶段
	 * @return String
	 */
	public String getId_ele_stage() {
		return ((String) getAttrVal("Id_ele_stage"));
	}
	/**
	 * 所属阶段
	 * @param Id_ele_stage
	 */
	public void setId_ele_stage(String Id_ele_stage) {
		setAttrVal("Id_ele_stage", Id_ele_stage);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 未执行数量
	 * @return Integer
	 */
	public Integer getNum_unexec() {
		return ((Integer) getAttrVal("Num_unexec"));
	}
	/**
	 * 未执行数量
	 * @param Num_unexec
	 */
	public void setNum_unexec(Integer Num_unexec) {
		setAttrVal("Num_unexec", Num_unexec);
	}
	/**
	 * 父级ID
	 * @return String
	 */
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}
	/**
	 * 父级ID
	 * @param Id_par
	 */
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 患者
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 诊疗计划
	 * @return String
	 */
	public String getId_cp() {
		return ((String) getAttrVal("Id_cp"));
	}
	/**
	 * 诊疗计划
	 * @param Id_cp
	 */
	public void setId_cp(String Id_cp) {
		setAttrVal("Id_cp", Id_cp);
	}
	/**
	 * 计划应用
	 * @return String
	 */
	public String getId_cpapp() {
		return ((String) getAttrVal("Id_cpapp"));
	}
	/**
	 * 计划应用
	 * @param Id_cpapp
	 */
	public void setId_cpapp(String Id_cpapp) {
		setAttrVal("Id_cpapp", Id_cpapp);
	}
	/**
	 * 包内项目选择类型
	 * @return Integer
	 */
	public Integer getEu_pkgitmseltp() {
		return ((Integer) getAttrVal("Eu_pkgitmseltp"));
	}
	/**
	 * 包内项目选择类型
	 * @param Eu_pkgitmseltp
	 */
	public void setEu_pkgitmseltp(Integer Eu_pkgitmseltp) {
		setAttrVal("Eu_pkgitmseltp", Eu_pkgitmseltp);
	}
}