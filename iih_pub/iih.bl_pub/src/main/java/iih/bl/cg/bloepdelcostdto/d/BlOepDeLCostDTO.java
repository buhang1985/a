package iih.bl.cg.bloepdelcostdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊销账 DTO数据 
 * 
 */
public class BlOepDeLCostDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 开始时间
	 * @return String
	 */
	public String getDt_begin() {
		return ((String) getAttrVal("Dt_begin"));
	}
	/**
	 * 开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(String Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 结束时间
	 * @return String
	 */
	public String getDt_end() {
		return ((String) getAttrVal("Dt_end"));
	}
	/**
	 * 结束时间
	 * @param Dt_end
	 */
	public void setDt_end(String Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 数量
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}
	/**
	 * 数量
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getSrvu_name() {
		return ((String) getAttrVal("Srvu_name"));
	}
	/**
	 * 单位
	 * @param Srvu_name
	 */
	public void setSrvu_name(String Srvu_name) {
		setAttrVal("Srvu_name", Srvu_name);
	}
	/**
	 * 单价
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 单价
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 实交金额
	 * @return FDouble
	 */
	public FDouble getAmt_ratio() {
		return ((FDouble) getAttrVal("Amt_ratio"));
	}
	/**
	 * 实交金额
	 * @param Amt_ratio
	 */
	public void setAmt_ratio(FDouble Amt_ratio) {
		setAttrVal("Amt_ratio", Amt_ratio);
	}
	/**
	 * 退费数量
	 * @return FDouble
	 */
	public FDouble getReturn_quan() {
		return ((FDouble) getAttrVal("Return_quan"));
	}
	/**
	 * 退费数量
	 * @param Return_quan
	 */
	public void setReturn_quan(FDouble Return_quan) {
		setAttrVal("Return_quan", Return_quan);
	}
	/**
	 * 可退数量
	 * @return FDouble
	 */
	public FDouble getCan_quan() {
		return ((FDouble) getAttrVal("Can_quan"));
	}
	/**
	 * 可退数量
	 * @param Can_quan
	 */
	public void setCan_quan(FDouble Can_quan) {
		setAttrVal("Can_quan", Can_quan);
	}
	/**
	 * 退费金额
	 * @return FDouble
	 */
	public FDouble getReturn_amt() {
		return ((FDouble) getAttrVal("Return_amt"));
	}
	/**
	 * 退费金额
	 * @param Return_amt
	 */
	public void setReturn_amt(FDouble Return_amt) {
		setAttrVal("Return_amt", Return_amt);
	}
	/**
	 * 医嘱执行状态名称
	 * @return String
	 */
	public String getName_su_mp() {
		return ((String) getAttrVal("Name_su_mp"));
	}
	/**
	 * 医嘱执行状态名称
	 * @param Name_su_mp
	 */
	public void setName_su_mp(String Name_su_mp) {
		setAttrVal("Name_su_mp", Name_su_mp);
	}
	/**
	 * 医嘱执行状态
	 * @return String
	 */
	public String getId_su_mp() {
		return ((String) getAttrVal("Id_su_mp"));
	}
	/**
	 * 医嘱执行状态
	 * @param Id_su_mp
	 */
	public void setId_su_mp(String Id_su_mp) {
		setAttrVal("Id_su_mp", Id_su_mp);
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
	 * 记账明细id
	 * @return String
	 */
	public String getId_cgitmoep() {
		return ((String) getAttrVal("Id_cgitmoep"));
	}
	/**
	 * 记账明细id
	 * @param Id_cgitmoep
	 */
	public void setId_cgitmoep(String Id_cgitmoep) {
		setAttrVal("Id_cgitmoep", Id_cgitmoep);
	}
	/**
	 * 记账主键
	 * @return String
	 */
	public String getId_cgoep() {
		return ((String) getAttrVal("Id_cgoep"));
	}
	/**
	 * 记账主键
	 * @param Id_cgoep
	 */
	public void setId_cgoep(String Id_cgoep) {
		setAttrVal("Id_cgoep", Id_cgoep);
	}
	/**
	 * 处方id
	 * @return String
	 */
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}
	/**
	 * 处方id
	 * @param Id_pres
	 */
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 医嘱名称
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}
	/**
	 * 医嘱名称
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
}