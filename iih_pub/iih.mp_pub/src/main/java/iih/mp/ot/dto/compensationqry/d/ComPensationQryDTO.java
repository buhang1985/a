package iih.mp.ot.dto.compensationqry.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医技补费查询dto DTO数据 
 * 
 */
public class ComPensationQryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 主医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 补医嘱项目
	 * @return String
	 */
	public String getId_orsrv_add() {
		return ((String) getAttrVal("Id_orsrv_add"));
	}
	/**
	 * 补医嘱项目
	 * @param Id_orsrv_add
	 */
	public void setId_orsrv_add(String Id_orsrv_add) {
		setAttrVal("Id_orsrv_add", Id_orsrv_add);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}
	/**
	 * 医嘱号
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getCode_apply() {
		return ((String) getAttrVal("Code_apply"));
	}
	/**
	 * 申请单号
	 * @param Code_apply
	 */
	public void setCode_apply(String Code_apply) {
		setAttrVal("Code_apply", Code_apply);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getDes_order() {
		return ((String) getAttrVal("Des_order"));
	}
	/**
	 * 医嘱内容
	 * @param Des_order
	 */
	public void setDes_order(String Des_order) {
		setAttrVal("Des_order", Des_order);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 住院号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
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
	 * 物品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}
	/**
	 * 物品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
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
	 * 单位
	 * @return String
	 */
	public String getName_pkgu() {
		return ((String) getAttrVal("Name_pkgu"));
	}
	/**
	 * 单位
	 * @param Name_pkgu
	 */
	public void setName_pkgu(String Name_pkgu) {
		setAttrVal("Name_pkgu", Name_pkgu);
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
	 * 金额
	 * @return FDouble
	 */
	public FDouble getAmount() {
		return ((FDouble) getAttrVal("Amount"));
	}
	/**
	 * 金额
	 * @param Amount
	 */
	public void setAmount(FDouble Amount) {
		setAttrVal("Amount", Amount);
	}
	/**
	 * 开单科室
	 * @return String
	 */
	public String getId_dep_ap() {
		return ((String) getAttrVal("Id_dep_ap"));
	}
	/**
	 * 开单科室
	 * @param Id_dep_ap
	 */
	public void setId_dep_ap(String Id_dep_ap) {
		setAttrVal("Id_dep_ap", Id_dep_ap);
	}
	/**
	 * 开单科室名称
	 * @return String
	 */
	public String getName_dep_ap() {
		return ((String) getAttrVal("Name_dep_ap"));
	}
	/**
	 * 开单科室名称
	 * @param Name_dep_ap
	 */
	public void setName_dep_ap(String Name_dep_ap) {
		setAttrVal("Name_dep_ap", Name_dep_ap);
	}
	/**
	 * 开单人
	 * @return String
	 */
	public String getId_emp_ap() {
		return ((String) getAttrVal("Id_emp_ap"));
	}
	/**
	 * 开单人
	 * @param Id_emp_ap
	 */
	public void setId_emp_ap(String Id_emp_ap) {
		setAttrVal("Id_emp_ap", Id_emp_ap);
	}
	/**
	 * 开单人名称
	 * @return String
	 */
	public String getName_emp_ap() {
		return ((String) getAttrVal("Name_emp_ap"));
	}
	/**
	 * 开单人名称
	 * @param Name_emp_ap
	 */
	public void setName_emp_ap(String Name_emp_ap) {
		setAttrVal("Name_emp_ap", Name_emp_ap);
	}
	/**
	 * 记账状态
	 * @return String
	 */
	public String getSd_su_bl() {
		return ((String) getAttrVal("Sd_su_bl"));
	}
	/**
	 * 记账状态
	 * @param Sd_su_bl
	 */
	public void setSd_su_bl(String Sd_su_bl) {
		setAttrVal("Sd_su_bl", Sd_su_bl);
	}
	/**
	 * 记账状态名称
	 * @return String
	 */
	public String getName_su_bl() {
		return ((String) getAttrVal("Name_su_bl"));
	}
	/**
	 * 记账状态名称
	 * @param Name_su_bl
	 */
	public void setName_su_bl(String Name_su_bl) {
		setAttrVal("Name_su_bl", Name_su_bl);
	}
	/**
	 * 开单时间
	 * @return FDateTime
	 */
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}
	/**
	 * 开单时间
	 * @param Dt_create
	 */
	public void setDt_create(FDateTime Dt_create) {
		setAttrVal("Dt_create", Dt_create);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}
	/**
	 * 执行科室
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
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
	 * 记账人
	 * @return String
	 */
	public String getId_emp_cg() {
		return ((String) getAttrVal("Id_emp_cg"));
	}
	/**
	 * 记账人
	 * @param Id_emp_cg
	 */
	public void setId_emp_cg(String Id_emp_cg) {
		setAttrVal("Id_emp_cg", Id_emp_cg);
	}
	/**
	 * 记账人名称
	 * @return String
	 */
	public String getName_emp_cg() {
		return ((String) getAttrVal("Name_emp_cg"));
	}
	/**
	 * 记账人名称
	 * @param Name_emp_cg
	 */
	public void setName_emp_cg(String Name_emp_cg) {
		setAttrVal("Name_emp_cg", Name_emp_cg);
	}
	/**
	 * 未记账金额合计
	 * @return FDouble
	 */
	public FDouble getAmountsumsd0() {
		return ((FDouble) getAttrVal("Amountsumsd0"));
	}
	/**
	 * 未记账金额合计
	 * @param Amountsumsd0
	 */
	public void setAmountsumsd0(FDouble Amountsumsd0) {
		setAttrVal("Amountsumsd0", Amountsumsd0);
	}
	/**
	 * 已记账金额合计
	 * @return FDouble
	 */
	public FDouble getAmountsumsd1() {
		return ((FDouble) getAttrVal("Amountsumsd1"));
	}
	/**
	 * 已记账金额合计
	 * @param Amountsumsd1
	 */
	public void setAmountsumsd1(FDouble Amountsumsd1) {
		setAttrVal("Amountsumsd1", Amountsumsd1);
	}
	/**
	 * 已退费金额合计
	 * @return FDouble
	 */
	public FDouble getAmountsumsd2() {
		return ((FDouble) getAttrVal("Amountsumsd2"));
	}
	/**
	 * 已退费金额合计
	 * @param Amountsumsd2
	 */
	public void setAmountsumsd2(FDouble Amountsumsd2) {
		setAttrVal("Amountsumsd2", Amountsumsd2);
	}
}