package iih.bl.cg.service.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

public class BlRefundItmDTO  extends BaseDTO {
	private static final long serialVersionUID = 1L;
	/**
	 *  退费主表主键
	 * @return
	 */
	public String getId_cgoep() {
		return ((String) getAttrVal("Id_cgoep"));
	}
	public void setId_cgoep(String Id_cgoep) {
		setAttrVal("Id_cgoep", Id_cgoep);
	}
	/**
	 *  退费项目主键
	 * @return
	 */
	public String getId_cditmoep() {
		return ((String) getAttrVal("Id_cditmoep"));
	}
	public void setId_cditmoep(String Id_cditmoep) {
		setAttrVal("Id_cditmoep", Id_cditmoep);
	}
	
	/**
	 *  退费项目:Id_orsrv
	 * @return
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	
	/**
	 * 退费数量
	 * @return
	 */
	public FDouble getQuan_refund() {
		return ((FDouble) getAttrVal("Quan_refund"));
	}
	public void setQuan_refund(FDouble Quan_refund) {
		setAttrVal("Quan_refund", Quan_refund);
	}
	/**
	 * 是否物品
	 * @return
	 */
	public FBoolean getFg_mm() {
		return ((FBoolean) getAttrVal("Fg_mm"));
	}
	public void setFg_mm(FBoolean Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
	}
	/**
	 * 药品是否发放
	 * @return
	 */
	public FBoolean getFg_drug_provide() {
		return ((FBoolean) getAttrVal("Fg_drug_provide"));
	}
	public void setFg_drug_provide(FBoolean Fg_drug_provide) {
		setAttrVal("Fg_drug_provide", Fg_drug_provide);
	}
	
	//退物品预留需要的
	/**
	 *  物品ID:Id_mm
	 * @return
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 *  当前单位：Req_unit_id
	 * @return
	 */
	public String getReq_unit_id() {
		return ((String) getAttrVal("Req_unit_id"));
	}
	public void setReq_unit_id(String Req_unit_id) {
		setAttrVal("Req_unit_id", Req_unit_id);
	}
	/**
	 *  执行科室：Id_dep
	 * @return
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 *  仓库：Id_dep_wh
	 * @return
	 */
	public String getId_dep_wh() {
		return ((String) getAttrVal("Id_dep_wh"));
	}
	public void setId_dep_wh(String Id_dep_wh) {
		setAttrVal("Id_dep_wh", Id_dep_wh);
	}
	/**
	 *  执行科室：Name_dep_mp
	 * @return
	 */
	public String getName_Dep_Mp() {
		return ((String) getAttrVal("name_dep_mp"));
	}
	public void getName_Dep_Mp(String name_dep_mp) {
		setAttrVal("name_dep_mp", name_dep_mp);
	}
	/**
	 *  执行人：Name_emp_cg
	 * @return
	 */
	public String getName_Emp_Cg() {
		return ((String) getAttrVal("name_emp_cg"));
	}
	public void getName_Emp_Cg(String name_emp_cg) {
		setAttrVal("name_emp_cg", name_emp_cg);
	}
	
	
	/**
	 *  费用来源
	 * @return
	 */
	public Integer getEu_srctp() {
		return ((Integer) getAttrVal("Eu_srctp"));
	}
	public void setEu_srctp(Integer Eu_srctp) {
		setAttrVal("Eu_srctp", Eu_srctp);
	}
	
}
