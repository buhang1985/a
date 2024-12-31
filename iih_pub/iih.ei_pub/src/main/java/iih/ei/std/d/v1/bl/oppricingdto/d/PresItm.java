package iih.ei.std.d.v1.bl.oppricingdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊划价出参处方明细 DTO数据 
 * 
 */
public class PresItm extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 记账流水号
	 * @return String
	 */
	public String getCode_cg() {
		return ((String) getAttrVal("Code_cg"));
	}	
	/**
	 * 记账流水号
	 * @param Code_cg
	 */
	public void setCode_cg(String Code_cg) {
		setAttrVal("Code_cg", Code_cg);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}	
	/**
	 * 服务编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
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
	 * 服务单位名称
	 * @return String
	 */
	public String getName_srvu() {
		return ((String) getAttrVal("Name_srvu"));
	}	
	/**
	 * 服务单位名称
	 * @param Name_srvu
	 */
	public void setName_srvu(String Name_srvu) {
		setAttrVal("Name_srvu", Name_srvu);
	}
	/**
	 * 规格
	 * @return String
	 */
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}	
	/**
	 * 规格
	 * @param Spec
	 */
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}
	/**
	 * 单价
	 * @return String
	 */
	public String getPrice() {
		return ((String) getAttrVal("Price"));
	}	
	/**
	 * 单价
	 * @param Price
	 */
	public void setPrice(String Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 数量
	 * @return String
	 */
	public String getQuan() {
		return ((String) getAttrVal("Quan"));
	}	
	/**
	 * 数量
	 * @param Quan
	 */
	public void setQuan(String Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 账单项编码
	 * @return String
	 */
	public String getCode_inccaitm() {
		return ((String) getAttrVal("Code_inccaitm"));
	}	
	/**
	 * 账单项编码
	 * @param Code_inccaitm
	 */
	public void setCode_inccaitm(String Code_inccaitm) {
		setAttrVal("Code_inccaitm", Code_inccaitm);
	}
	/**
	 * 账单项名称
	 * @return String
	 */
	public String getName_inccaitm() {
		return ((String) getAttrVal("Name_inccaitm"));
	}	
	/**
	 * 账单项名称
	 * @param Name_inccaitm
	 */
	public void setName_inccaitm(String Name_inccaitm) {
		setAttrVal("Name_inccaitm", Name_inccaitm);
	}
	/**
	 * 执行科室编码
	 * @return String
	 */
	public String getCode_dep_mp() {
		return ((String) getAttrVal("Code_dep_mp"));
	}	
	/**
	 * 执行科室编码
	 * @param Code_dep_mp
	 */
	public void setCode_dep_mp(String Code_dep_mp) {
		setAttrVal("Code_dep_mp", Code_dep_mp);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}	
	/**
	 * 执行科室名称
	 * @param Name_dep_mp
	 */
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}
	/**
	 * 明细金额
	 * @return String
	 */
	public String getAmt() {
		return ((String) getAttrVal("Amt"));
	}	
	/**
	 * 明细金额
	 * @param Amt
	 */
	public void setAmt(String Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 开单时间
	 * @return String
	 */
	public String getDt_or() {
		return ((String) getAttrVal("Dt_or"));
	}	
	/**
	 * 开单时间
	 * @param Dt_or
	 */
	public void setDt_or(String Dt_or) {
		setAttrVal("Dt_or", Dt_or);
	}
}