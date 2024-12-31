package iih.mp.ot.dto.confirm.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医技确认费用信息 DTO数据 
 * 
 */
public class MpOtFeeInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 三态
	 * @return Integer
	 */
	public Integer getTri() {
		return ((Integer) getAttrVal("Tri"));
	}
	/**
	 * 三态
	 * @param Tri
	 */
	public void setTri(Integer Tri) {
		setAttrVal("Tri", Tri);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getNo() {
		return ((Integer) getAttrVal("No"));
	}
	/**
	 * 序号
	 * @param No
	 */
	public void setNo(Integer No) {
		setAttrVal("No", No);
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
	 * 退数量
	 * @return Integer
	 */
	public Integer getQuan_ret() {
		return ((Integer) getAttrVal("Quan_ret"));
	}
	/**
	 * 退数量
	 * @param Quan_ret
	 */
	public void setQuan_ret(Integer Quan_ret) {
		setAttrVal("Quan_ret", Quan_ret);
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
	 * 医保类型
	 * @return String
	 */
	public String getTp_hp() {
		return ((String) getAttrVal("Tp_hp"));
	}
	/**
	 * 医保类型
	 * @param Tp_hp
	 */
	public void setTp_hp(String Tp_hp) {
		setAttrVal("Tp_hp", Tp_hp);
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
	 * 是否补录项目
	 * @return FBoolean
	 */
	public FBoolean getIf_item_add() {
		return ((FBoolean) getAttrVal("If_item_add"));
	}
	/**
	 * 是否补录项目
	 * @param If_item_add
	 */
	public void setIf_item_add(FBoolean If_item_add) {
		setAttrVal("If_item_add", If_item_add);
	}
	/**
	 * 是否补录费用
	 * @return FBoolean
	 */
	public FBoolean getIf_cost_add() {
		return ((FBoolean) getAttrVal("If_cost_add"));
	}
	/**
	 * 是否补录费用
	 * @param If_cost_add
	 */
	public void setIf_cost_add(FBoolean If_cost_add) {
		setAttrVal("If_cost_add", If_cost_add);
	}
	/**
	 * 执行记录服务项目记账记录id
	 * @return String
	 */
	public String getId_or_pr_srv_bl() {
		return ((String) getAttrVal("Id_or_pr_srv_bl"));
	}
	/**
	 * 执行记录服务项目记账记录id
	 * @param Id_or_pr_srv_bl
	 */
	public void setId_or_pr_srv_bl(String Id_or_pr_srv_bl) {
		setAttrVal("Id_or_pr_srv_bl", Id_or_pr_srv_bl);
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
	 * 医嘱服务项目
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱服务项目
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
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
	 * 服务项目
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务项目
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 物品id
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品id
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 计量单位
	 * @return String
	 */
	public String getId_unit_med() {
		return ((String) getAttrVal("Id_unit_med"));
	}
	/**
	 * 计量单位
	 * @param Id_unit_med
	 */
	public void setId_unit_med(String Id_unit_med) {
		setAttrVal("Id_unit_med", Id_unit_med);
	}
	/**
	 * 当前包装单位
	 * @return String
	 */
	public String getId_pkgu_cur() {
		return ((String) getAttrVal("Id_pkgu_cur"));
	}
	/**
	 * 当前包装单位
	 * @param Id_pkgu_cur
	 */
	public void setId_pkgu_cur(String Id_pkgu_cur) {
		setAttrVal("Id_pkgu_cur", Id_pkgu_cur);
	}
	/**
	 * 物品标志
	 * @return FBoolean
	 */
	public FBoolean getFg_mm() {
		return ((FBoolean) getAttrVal("Fg_mm"));
	}
	/**
	 * 物品标志
	 * @param Fg_mm
	 */
	public void setFg_mm(FBoolean Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
	}
	/**
	 * 婴儿标志
	 * @return FBoolean
	 */
	public FBoolean getFg_bb() {
		return ((FBoolean) getAttrVal("Fg_bb"));
	}
	/**
	 * 婴儿标志
	 * @param Fg_bb
	 */
	public void setFg_bb(FBoolean Fg_bb) {
		setAttrVal("Fg_bb", Fg_bb);
	}
	/**
	 * 计划执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_plan() {
		return ((FDateTime) getAttrVal("Dt_plan"));
	}
	/**
	 * 计划执行时间
	 * @param Dt_plan
	 */
	public void setDt_plan(FDateTime Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	/**
	 * 执行状态
	 * @return Integer
	 */
	public Integer getEu_su() {
		return ((Integer) getAttrVal("Eu_su"));
	}
	/**
	 * 执行状态
	 * @param Eu_su
	 */
	public void setEu_su(Integer Eu_su) {
		setAttrVal("Eu_su", Eu_su);
	}
	/**
	 * 记账主键
	 * @return String
	 */
	public String getId_cgip() {
		return ((String) getAttrVal("Id_cgip"));
	}
	/**
	 * 记账主键
	 * @param Id_cgip
	 */
	public void setId_cgip(String Id_cgip) {
		setAttrVal("Id_cgip", Id_cgip);
	}
	/**
	 * 结算标志
	 * @return FBoolean
	 */
	public FBoolean getFg_st() {
		return ((FBoolean) getAttrVal("Fg_st"));
	}
	/**
	 * 结算标志
	 * @param Fg_st
	 */
	public void setFg_st(FBoolean Fg_st) {
		setAttrVal("Fg_st", Fg_st);
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
	 * 记账时间
	 * @return String
	 */
	public String getDt_mp_bl() {
		return ((String) getAttrVal("Dt_mp_bl"));
	}
	/**
	 * 记账时间
	 * @param Dt_mp_bl
	 */
	public void setDt_mp_bl(String Dt_mp_bl) {
		setAttrVal("Dt_mp_bl", Dt_mp_bl);
	}
	/**
	 * 时间标志
	 * @return FDateTime
	 */
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal("Sv"));
	}
	/**
	 * 时间标志
	 * @param Sv
	 */
	public void setSv(FDateTime Sv) {
		setAttrVal("Sv", Sv);
	}
}