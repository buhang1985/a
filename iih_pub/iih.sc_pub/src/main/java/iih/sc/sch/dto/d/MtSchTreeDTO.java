package iih.sc.sch.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医技排班树 DTO数据 
 * 
 */
public class MtSchTreeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 树id
	 * @return String
	 */
	public String getId_tree() {
		return ((String) getAttrVal("Id_tree"));
	}
	/**
	 * 树id
	 * @param Id_tree
	 */
	public void setId_tree(String Id_tree) {
		setAttrVal("Id_tree", Id_tree);
	}
	/**
	 * 树name
	 * @return String
	 */
	public String getName_tree() {
		return ((String) getAttrVal("Name_tree"));
	}
	/**
	 * 树name
	 * @param Name_tree
	 */
	public void setName_tree(String Name_tree) {
		setAttrVal("Name_tree", Name_tree);
	}
	/**
	 * 父id
	 * @return String
	 */
	public String getId_parent() {
		return ((String) getAttrVal("Id_parent"));
	}
	/**
	 * 父id
	 * @param Id_parent
	 */
	public void setId_parent(String Id_parent) {
		setAttrVal("Id_parent", Id_parent);
	}
	/**
	 * 树类型
	 * @return String
	 */
	public String getTp_tree() {
		return ((String) getAttrVal("Tp_tree"));
	}
	/**
	 * 树类型
	 * @param Tp_tree
	 */
	public void setTp_tree(String Tp_tree) {
		setAttrVal("Tp_tree", Tp_tree);
	}
	/**
	 * 主id
	 * @return String
	 */
	public String getId_main() {
		return ((String) getAttrVal("Id_main"));
	}
	/**
	 * 主id
	 * @param Id_main
	 */
	public void setId_main(String Id_main) {
		setAttrVal("Id_main", Id_main);
	}
	/**
	 * 父name
	 * @return String
	 */
	public String getName_parent() {
		return ((String) getAttrVal("Name_parent"));
	}
	/**
	 * 父name
	 * @param Name_parent
	 */
	public void setName_parent(String Name_parent) {
		setAttrVal("Name_parent", Name_parent);
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
	 * 计划id
	 * @return String
	 */
	public String getId_scpl() {
		return ((String) getAttrVal("Id_scpl"));
	}
	/**
	 * 计划id
	 * @param Id_scpl
	 */
	public void setId_scpl(String Id_scpl) {
		setAttrVal("Id_scpl", Id_scpl);
	}
	/**
	 * 计划是否启用
	 * @return String
	 */
	public String getFg_active() {
		return ((String) getAttrVal("Fg_active"));
	}
	/**
	 * 计划是否启用
	 * @param Fg_active
	 */
	public void setFg_active(String Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 计划名称
	 * @return String
	 */
	public String getName_pl() {
		return ((String) getAttrVal("Name_pl"));
	}
	/**
	 * 计划名称
	 * @param Name_pl
	 */
	public void setName_pl(String Name_pl) {
		setAttrVal("Name_pl", Name_pl);
	}
	/**
	 * 是否处理完成
	 * @return FBoolean
	 */
	public FBoolean getFg_finish() {
		return ((FBoolean) getAttrVal("Fg_finish"));
	}
	/**
	 * 是否处理完成
	 * @param Fg_finish
	 */
	public void setFg_finish(FBoolean Fg_finish) {
		setAttrVal("Fg_finish", Fg_finish);
	}
	/**
	 * 分诊台ID
	 * @return String
	 */
	public String getId_queben() {
		return ((String) getAttrVal("Id_queben"));
	}
	/**
	 * 分诊台ID
	 * @param Id_queben
	 */
	public void setId_queben(String Id_queben) {
		setAttrVal("Id_queben", Id_queben);
	}
	/**
	 * 最大日期
	 * @return FDate
	 */
	public String getD_maxsch() {
		return ((String) getAttrVal("D_maxsch"));
	}
	/**
	 * 最大日期
	 * @param D_maxsch
	 */
	public void setD_maxsch(String D_maxsch) {
		setAttrVal("D_maxsch", D_maxsch);
	}
	/**
	 * 排班分类id
	 * @return String
	 */
	public String getId_scca() {
		return ((String) getAttrVal("Id_scca"));
	}
	/**
	 * 排班分类id
	 * @param Id_scca
	 */
	public void setId_scca(String Id_scca) {
		setAttrVal("Id_scca", Id_scca);
	}
}