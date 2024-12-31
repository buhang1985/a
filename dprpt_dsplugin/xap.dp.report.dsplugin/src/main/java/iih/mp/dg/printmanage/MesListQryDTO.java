package iih.mp.dg.printmanage;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

public class MesListQryDTO extends BaseDTO{

	private static final long serialVersionUID = 1L;

	/**
	 * 计划执行时间
	 * @return String
	 */
	public String getDt_mp_plan() {
		return ((String) getAttrVal("Dt_mp_plan"));
	}
	/**
	 * 计划执行时间
	 * @param Dt_mp_plan
	 */
	public void setDt_mp_plan(String Dt_mp_plan) {
		setAttrVal("Dt_mp_plan", Dt_mp_plan);
	}
	/**
	 * 执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp() {
		return ((FDateTime) getAttrVal("Dt_mp"));
	}
	/**
	 * 执行时间
	 * @param Dt_mp
	 */
	public void setDt_mp(FDateTime Dt_mp) {
		setAttrVal("Dt_mp", Dt_mp);
	}
	/**
	 * 巡视情况
	 * @return String
	 */
	public String getStatus_rst() {
		return ((String) getAttrVal("Status_rst"));
	}
	/**
	 * 巡视情况
	 * @param Status_rst
	 */
	public void setStatus_rst(String Status_rst) {
		setAttrVal("Status_rst", Status_rst);
	}
	/**
	 * 输液登记id
	 * @return String
	 */
	public String getId_dginfu() {
		return ((String) getAttrVal("Id_dginfu"));
	}
	/**
	 * 输液登记id
	 * @param Id_dginfu
	 */
	public void setId_dginfu(String Id_dginfu) {
		setAttrVal("Id_dginfu", Id_dginfu);
	}	
	/**
	 * 输液登记id
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}
	/**
	 * 输液登记id
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 执行类型编码
	 * @return String
	 */
	public String getSd_dgprtp() {
		return ((String) getAttrVal("Sd_dgprtp"));
	}
	/**
	 * 执行类型编码
	 * @param Sd_dgprtp
	 */
	public void setSd_dgprtp(String Sd_dgprtp) {
		setAttrVal("Sd_dgprtp", Sd_dgprtp);
	}

	/**
	 * 滴速
	 * @return Integer
	 */
	public Integer getIvgtt() {
		return ((Integer) getAttrVal("Ivgtt"));
	}
	/**
	 * 滴速
	 * @param Ivgtt
	 */
	public void setIvgtt(Integer Ivgtt) {
		setAttrVal("Ivgtt", Ivgtt);
	}

}
