package iih.bl.cg.dto.addfee.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 纯补费用查询条件dto DTO数据 
 * 
 */
public class BlCgAddFeeQryCondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 记账科室
	 * @return String
	 */
	public String getId_dep_cg() {
		return ((String) getAttrVal("Id_dep_cg"));
	}
	/**
	 * 记账科室
	 * @param Id_dep_cg
	 */
	public void setId_dep_cg(String Id_dep_cg) {
		setAttrVal("Id_dep_cg", Id_dep_cg);
	}
	/**
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 是否关联医嘱
	 * @return FBoolean
	 */
	public FBoolean getFg_relateor() {
		return ((FBoolean) getAttrVal("Fg_relateor"));
	}
	/**
	 * 是否关联医嘱
	 * @param Fg_relateor
	 */
	public void setFg_relateor(FBoolean Fg_relateor) {
		setAttrVal("Fg_relateor", Fg_relateor);
	}
	/**
	 * 数据产生功能点
	 * @return String
	 */
	public String getSrcfunc_des() {
		return ((String) getAttrVal("Srcfunc_des"));
	}
	/**
	 * 数据产生功能点
	 * @param Srcfunc_des
	 */
	public void setSrcfunc_des(String Srcfunc_des) {
		setAttrVal("Srcfunc_des", Srcfunc_des);
	}
	/**
	 * 是否包含退费数据
	 * @return FBoolean
	 */
	public FBoolean getFg_containrefund() {
		return ((FBoolean) getAttrVal("Fg_containrefund"));
	}
	/**
	 * 是否包含退费数据
	 * @param Fg_containrefund
	 */
	public void setFg_containrefund(FBoolean Fg_containrefund) {
		setAttrVal("Fg_containrefund", Fg_containrefund);
	}
}