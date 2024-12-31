package iih.mc.itf.hvitem.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 高值耗材使用出库DTO DTO数据 
 * 
 */
public class McHvUseOutDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 唯一码
	 * @return String
	 */
	public String getOnlycode() {
		return ((String) getAttrVal("Onlycode"));
	}
	/**
	 * 唯一码
	 * @param Onlycode
	 */
	public void setOnlycode(String Onlycode) {
		setAttrVal("Onlycode", Onlycode);
	}
	/**
	 * 物品编号
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品编号
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 医嘱编号
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱编号
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 手术申请单号
	 * @return String
	 */
	public String getId_orop() {
		return ((String) getAttrVal("Id_orop"));
	}
	/**
	 * 手术申请单号
	 * @param Id_orop
	 */
	public void setId_orop(String Id_orop) {
		setAttrVal("Id_orop", Id_orop);
	}
	/**
	 * 价格
	 * @return String
	 */
	public String getMm_pri() {
		return ((String) getAttrVal("Mm_pri"));
	}
	/**
	 * 价格
	 * @param Mm_pri
	 */
	public void setMm_pri(String Mm_pri) {
		setAttrVal("Mm_pri", Mm_pri);
	}
	/**
	 * 数量
	 * @return FDouble
	 */
	public FDouble getQuan_actual() {
		return ((FDouble) getAttrVal("Quan_actual"));
	}
	/**
	 * 数量
	 * @param Quan_actual
	 */
	public void setQuan_actual(FDouble Quan_actual) {
		setAttrVal("Quan_actual", Quan_actual);
	}
	/**
	 * 仓库
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}
	/**
	 * 仓库
	 * @param Id_wh
	 */
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	/**
	 * 使用科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 使用科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 录入人
	 * @return String
	 */
	public String getId_emp_inp() {
		return ((String) getAttrVal("Id_emp_inp"));
	}
	/**
	 * 录入人
	 * @param Id_emp_inp
	 */
	public void setId_emp_inp(String Id_emp_inp) {
		setAttrVal("Id_emp_inp", Id_emp_inp);
	}
	/**
	 * 使用时间
	 * @return FDate
	 */
	public FDate getDt_time() {
		return ((FDate) getAttrVal("Dt_time"));
	}
	/**
	 * 使用时间
	 * @param Dt_time
	 */
	public void setDt_time(FDate Dt_time) {
		setAttrVal("Dt_time", Dt_time);
	}
	/**
	 * 出库单号
	 * @return String
	 */
	public String getId_out() {
		return ((String) getAttrVal("Id_out"));
	}
	/**
	 * 出库单号
	 * @param Id_out
	 */
	public void setId_out(String Id_out) {
		setAttrVal("Id_out", Id_out);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊号
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 高值服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 高值服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
}