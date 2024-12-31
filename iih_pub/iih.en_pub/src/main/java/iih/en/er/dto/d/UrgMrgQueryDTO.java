package iih.en.er.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 急诊入出转管理查询DTO DTO数据 
 * 
 */
public class UrgMrgQueryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 查询条件
	 * @return String
	 */
	public String getValue() {
		return ((String) getAttrVal("Value"));
	}
	/**
	 * 查询条件
	 * @param Value
	 */
	public void setValue(String Value) {
		setAttrVal("Value", Value);
	}
	/**
	 * 未入科
	 * @return FBoolean
	 */
	public FBoolean getFg_unentry() {
		return ((FBoolean) getAttrVal("Fg_unentry"));
	}
	/**
	 * 未入科
	 * @param Fg_unentry
	 */
	public void setFg_unentry(FBoolean Fg_unentry) {
		setAttrVal("Fg_unentry", Fg_unentry);
	}
	/**
	 * 已入科
	 * @return FBoolean
	 */
	public FBoolean getFg_indep() {
		return ((FBoolean) getAttrVal("Fg_indep"));
	}
	/**
	 * 已入科
	 * @param Fg_indep
	 */
	public void setFg_indep(FBoolean Fg_indep) {
		setAttrVal("Fg_indep", Fg_indep);
	}
	/**
	 * 已出科
	 * @return FBoolean
	 */
	public FBoolean getFg_lvdep() {
		return ((FBoolean) getAttrVal("Fg_lvdep"));
	}
	/**
	 * 已出科
	 * @param Fg_lvdep
	 */
	public void setFg_lvdep(FBoolean Fg_lvdep) {
		setAttrVal("Fg_lvdep", Fg_lvdep);
	}
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
}