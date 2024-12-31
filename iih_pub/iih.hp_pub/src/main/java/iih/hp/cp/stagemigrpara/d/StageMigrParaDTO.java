package iih.hp.cp.stagemigrpara.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 阶段迁移用参数 DTO数据 
 * 
 */
public class StageMigrParaDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 诊疗计划应用ID
	 * @return String
	 */
	public String getId_cpapp() {
		return ((String) getAttrVal("Id_cpapp"));
	}
	/**
	 * 诊疗计划应用ID
	 * @param Id_cpapp
	 */
	public void setId_cpapp(String Id_cpapp) {
		setAttrVal("Id_cpapp", Id_cpapp);
	}
	/**
	 * 诊疗计划应用元素ID
	 * @return String
	 */
	public String getId_appele() {
		return ((String) getAttrVal("Id_appele"));
	}
	/**
	 * 诊疗计划应用元素ID
	 * @param Id_appele
	 */
	public void setId_appele(String Id_appele) {
		setAttrVal("Id_appele", Id_appele);
	}
	/**
	 * 是否最后阶段
	 * @return FBoolean
	 */
	public FBoolean getFg_laststage() {
		return ((FBoolean) getAttrVal("Fg_laststage"));
	}
	/**
	 * 是否最后阶段
	 * @param Fg_laststage
	 */
	public void setFg_laststage(FBoolean Fg_laststage) {
		setAttrVal("Fg_laststage", Fg_laststage);
	}
	/**
	 * 当前阶段元素ID
	 * @return String
	 */
	public String getId_ele_curstage() {
		return ((String) getAttrVal("Id_ele_curstage"));
	}
	/**
	 * 当前阶段元素ID
	 * @param Id_ele_curstage
	 */
	public void setId_ele_curstage(String Id_ele_curstage) {
		setAttrVal("Id_ele_curstage", Id_ele_curstage);
	}
	/**
	 * 最新阶段元素ID
	 * @return String
	 */
	public String getId_ele_nextstage() {
		return ((String) getAttrVal("Id_ele_nextstage"));
	}
	/**
	 * 最新阶段元素ID
	 * @param Id_ele_nextstage
	 */
	public void setId_ele_nextstage(String Id_ele_nextstage) {
		setAttrVal("Id_ele_nextstage", Id_ele_nextstage);
	}
	/**
	 * 变异原因类型
	 * @return String
	 */
	public String getSd_halt_reson() {
		return ((String) getAttrVal("Sd_halt_reson"));
	}
	/**
	 * 变异原因类型
	 * @param Sd_halt_reson
	 */
	public void setSd_halt_reson(String Sd_halt_reson) {
		setAttrVal("Sd_halt_reson", Sd_halt_reson);
	}
	/**
	 * 异常情况说明
	 * @return String
	 */
	public String getReson_desc() {
		return ((String) getAttrVal("Reson_desc"));
	}
	/**
	 * 异常情况说明
	 * @param Reson_desc
	 */
	public void setReson_desc(String Reson_desc) {
		setAttrVal("Reson_desc", Reson_desc);
	}
	/**
	 * 实际操作时间
	 * @return FDateTime
	 */
	public FDateTime getOperationtime() {
		return ((FDateTime) getAttrVal("Operationtime"));
	}
	/**
	 * 实际操作时间
	 * @param Operationtime
	 */
	public void setOperationtime(FDateTime Operationtime) {
		setAttrVal("Operationtime", Operationtime);
	}
}