package iih.mp.nr.mpcharge.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 执行记账配置 DTO数据 
 * 
 */
public class MpChargeSetDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 记账人员
	 * @return String
	 */
	public String getId_emp_cg() {
		return ((String) getAttrVal("Id_emp_cg"));
	}
	/**
	 * 记账人员
	 * @param Id_emp_cg
	 */
	public void setId_emp_cg(String Id_emp_cg) {
		setAttrVal("Id_emp_cg", Id_emp_cg);
	}
	/**
	 * 记账机构
	 * @return String
	 */
	public String getId_org_cg() {
		return ((String) getAttrVal("Id_org_cg"));
	}
	/**
	 * 记账机构
	 * @param Id_org_cg
	 */
	public void setId_org_cg(String Id_org_cg) {
		setAttrVal("Id_org_cg", Id_org_cg);
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
	 * 记账时间
	 * @return FDateTime
	 */
	public FDateTime getDt_cg() {
		return ((FDateTime) getAttrVal("Dt_cg"));
	}
	/**
	 * 记账时间
	 * @param Dt_cg
	 */
	public void setDt_cg(FDateTime Dt_cg) {
		setAttrVal("Dt_cg", Dt_cg);
	}
	/**
	 * 是否计算服务价格
	 * @return FBoolean
	 */
	public FBoolean getFg_price_cal() {
		return ((FBoolean) getAttrVal("Fg_price_cal"));
	}
	/**
	 * 是否计算服务价格
	 * @param Fg_price_cal
	 */
	public void setFg_price_cal(FBoolean Fg_price_cal) {
		setAttrVal("Fg_price_cal", Fg_price_cal);
	}
	/**
	 * 是否单患者模式
	 * @return FBoolean
	 */
	public FBoolean getFg_singlepat() {
		return ((FBoolean) getAttrVal("Fg_singlepat"));
	}
	/**
	 * 是否单患者模式
	 * @param Fg_singlepat
	 */
	public void setFg_singlepat(FBoolean Fg_singlepat) {
		setAttrVal("Fg_singlepat", Fg_singlepat);
	}
	/**
	 * 是否支持后付费
	 * @return FBoolean
	 */
	public FBoolean getFg_postpaid() {
		return ((FBoolean) getAttrVal("Fg_postpaid"));
	}
	/**
	 * 是否支持后付费
	 * @param Fg_postpaid
	 */
	public void setFg_postpaid(FBoolean Fg_postpaid) {
		setAttrVal("Fg_postpaid", Fg_postpaid);
	}
	/**
	 * 是否抛异常
	 * @return FBoolean
	 */
	public FBoolean getFg_exception() {
		return ((FBoolean) getAttrVal("Fg_exception"));
	}
	/**
	 * 是否抛异常
	 * @param Fg_exception
	 */
	public void setFg_exception(FBoolean Fg_exception) {
		setAttrVal("Fg_exception", Fg_exception);
	}
	/**
	 * 是否补费
	 * @return FBoolean
	 */
	public FBoolean getFg_addfee() {
		return ((FBoolean) getAttrVal("Fg_addfee"));
	}
	/**
	 * 是否补费
	 * @param Fg_addfee
	 */
	public void setFg_addfee(FBoolean Fg_addfee) {
		setAttrVal("Fg_addfee", Fg_addfee);
	}
	/**
	 * 记账来源
	 * @return String
	 */
	public String getSrcfunc_des() {
		return ((String) getAttrVal("Srcfunc_des"));
	}
	/**
	 * 记账来源
	 * @param Srcfunc_des
	 */
	public void setSrcfunc_des(String Srcfunc_des) {
		setAttrVal("Srcfunc_des", Srcfunc_des);
	}
	/**
	 * 费用来源
	 * @return Integer
	 */
	public Integer getEu_srctp() {
		return ((Integer) getAttrVal("Eu_srctp"));
	}
	/**
	 * 费用来源
	 * @param Eu_srctp
	 */
	public void setEu_srctp(Integer Eu_srctp) {
		setAttrVal("Eu_srctp", Eu_srctp);
	}
	/**
	 * 执行记账来源
	 * @return Integer
	 */
	public Integer getEu_src() {
		return ((Integer) getAttrVal("Eu_src"));
	}
	/**
	 * 执行记账来源
	 * @param Eu_src
	 */
	public void setEu_src(Integer Eu_src) {
		setAttrVal("Eu_src", Eu_src);
	}
}