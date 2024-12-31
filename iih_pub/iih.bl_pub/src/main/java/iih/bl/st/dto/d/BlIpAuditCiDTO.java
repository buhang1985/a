package iih.bl.st.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 费用审核-医嘱内容 DTO数据 
 * 
 */
public class BlIpAuditCiDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 患者就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	 * 服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 比例金额
	 * @return String
	 */
	public String getAmt_ratio() {
		return ((String) getAttrVal("Amt_ratio"));
	}
	/**
	 * 比例金额
	 * @param Amt_ratio
	 */
	public void setAmt_ratio(String Amt_ratio) {
		setAttrVal("Amt_ratio", Amt_ratio);
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
	 * 长临标志
	 * @return String
	 */
	public String getFg_long() {
		return ((String) getAttrVal("Fg_long"));
	}
	/**
	 * 长临标志
	 * @param Fg_long
	 */
	public void setFg_long(String Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	/**
	 * 医嘱开立时间
	 * @return String
	 */
	public String getDt_effe() {
		return ((String) getAttrVal("Dt_effe"));
	}
	/**
	 * 医嘱开立时间
	 * @param Dt_effe
	 */
	public void setDt_effe(String Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 医嘱结束时间
	 * @return String
	 */
	public String getDt_end() {
		return ((String) getAttrVal("Dt_end"));
	}
	/**
	 * 医嘱结束时间
	 * @param Dt_end
	 */
	public void setDt_end(String Dt_end) {
		setAttrVal("Dt_end", Dt_end);
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
	 * 开立人
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}
	/**
	 * 开立人
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	/**
	 * 开立人名称
	 * @return String
	 */
	public String getEmp_name_or() {
		return ((String) getAttrVal("Emp_name_or"));
	}
	/**
	 * 开立人名称
	 * @param Emp_name_or
	 */
	public void setEmp_name_or(String Emp_name_or) {
		setAttrVal("Emp_name_or", Emp_name_or);
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
	/**
	 * 比例单价
	 * @return String
	 */
	public String getPrice_ratio() {
		return ((String) getAttrVal("Price_ratio"));
	}
	/**
	 * 比例单价
	 * @param Price_ratio
	 */
	public void setPrice_ratio(String Price_ratio) {
		setAttrVal("Price_ratio", Price_ratio);
	}
	/**
	 * 备注说明
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 备注说明
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 服务记账时间
	 * @return String
	 */
	public String getDt_cg() {
		return ((String) getAttrVal("Dt_cg"));
	}
	/**
	 * 服务记账时间
	 * @param Dt_cg
	 */
	public void setDt_cg(String Dt_cg) {
		setAttrVal("Dt_cg", Dt_cg);
	}
}