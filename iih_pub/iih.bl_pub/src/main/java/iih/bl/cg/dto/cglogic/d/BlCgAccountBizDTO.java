package iih.bl.cg.dto.cglogic.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 记账数据dto(业务处理) DTO数据 
 * 
 */
public class BlCgAccountBizDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
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
	 * 患者价格分类
	 * @return String
	 */
	public String getId_pripat() {
		return ((String) getAttrVal("Id_pripat"));
	}
	/**
	 * 患者价格分类
	 * @param Id_pripat
	 */
	public void setId_pripat(String Id_pripat) {
		setAttrVal("Id_pripat", Id_pripat);
	}
	/**
	 * 医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医嘱服务
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱服务
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 医嘱标识
	 * @return FBoolean
	 */
	public FBoolean getFg_or() {
		return ((FBoolean) getAttrVal("Fg_or"));
	}
	/**
	 * 医嘱标识
	 * @param Fg_or
	 */
	public void setFg_or(FBoolean Fg_or) {
		setAttrVal("Fg_or", Fg_or);
	}
	/**
	 * 服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 医嘱中服务
	 * @return String
	 */
	public String getId_srv_or() {
		return ((String) getAttrVal("Id_srv_or"));
	}
	/**
	 * 医嘱中服务
	 * @param Id_srv_or
	 */
	public void setId_srv_or(String Id_srv_or) {
		setAttrVal("Id_srv_or", Id_srv_or);
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
	 * 医嘱执行计划
	 * @return String
	 */
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}
	/**
	 * 医嘱执行计划
	 * @param Id_or_pr
	 */
	public void setId_or_pr(String Id_or_pr) {
		setAttrVal("Id_or_pr", Id_or_pr);
	}
	/**
	 * 医嘱服务执行计划
	 * @return String
	 */
	public String getId_or_prsrv() {
		return ((String) getAttrVal("Id_or_prsrv"));
	}
	/**
	 * 医嘱服务执行计划
	 * @param Id_or_prsrv
	 */
	public void setId_or_prsrv(String Id_or_prsrv) {
		setAttrVal("Id_or_prsrv", Id_or_prsrv);
	}
	/**
	 * 物品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 物品管理标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mm() {
		return ((FBoolean) getAttrVal("Fg_mm"));
	}
	/**
	 * 物品管理标识
	 * @param Fg_mm
	 */
	public void setFg_mm(FBoolean Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
	}
	/**
	 * 服务单位
	 * @return String
	 */
	public String getId_unit_srv() {
		return ((String) getAttrVal("Id_unit_srv"));
	}
	/**
	 * 服务单位
	 * @param Id_unit_srv
	 */
	public void setId_unit_srv(String Id_unit_srv) {
		setAttrVal("Id_unit_srv", Id_unit_srv);
	}
	/**
	 * 物品单位
	 * @return String
	 */
	public String getId_pkgu_cur() {
		return ((String) getAttrVal("Id_pkgu_cur"));
	}
	/**
	 * 物品单位
	 * @param Id_pkgu_cur
	 */
	public void setId_pkgu_cur(String Id_pkgu_cur) {
		setAttrVal("Id_pkgu_cur", Id_pkgu_cur);
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
	 * 标准价
	 * @return FDouble
	 */
	public FDouble getPrice_std() {
		return ((FDouble) getAttrVal("Price_std"));
	}
	/**
	 * 标准价
	 * @param Price_std
	 */
	public void setPrice_std(FDouble Price_std) {
		setAttrVal("Price_std", Price_std);
	}
	/**
	 * 折扣价
	 * @return FDouble
	 */
	public FDouble getPrice_ratio() {
		return ((FDouble) getAttrVal("Price_ratio"));
	}
	/**
	 * 折扣价
	 * @param Price_ratio
	 */
	public void setPrice_ratio(FDouble Price_ratio) {
		setAttrVal("Price_ratio", Price_ratio);
	}
	/**
	 * 价格比例
	 * @return FDouble
	 */
	public FDouble getRatio_pripat() {
		return ((FDouble) getAttrVal("Ratio_pripat"));
	}
	/**
	 * 价格比例
	 * @param Ratio_pripat
	 */
	public void setRatio_pripat(FDouble Ratio_pripat) {
		setAttrVal("Ratio_pripat", Ratio_pripat);
	}
	/**
	 * 唯一码
	 * @return String
	 */
	public String getOnly_code() {
		return ((String) getAttrVal("Only_code"));
	}
	/**
	 * 唯一码
	 * @param Only_code
	 */
	public void setOnly_code(String Only_code) {
		setAttrVal("Only_code", Only_code);
	}
	/**
	 * 批次
	 * @return String
	 */
	public String getBatch() {
		return ((String) getAttrVal("Batch"));
	}
	/**
	 * 批次
	 * @param Batch
	 */
	public void setBatch(String Batch) {
		setAttrVal("Batch", Batch);
	}
	/**
	 * 记账方向
	 * @return Integer
	 */
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}
	/**
	 * 记账方向
	 * @param Eu_direct
	 */
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	/**
	 * 开立科室
	 * @return String
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}
	/**
	 * 开立科室
	 * @param Id_dep_or
	 */
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	/**
	 * 开立医生
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}
	/**
	 * 开立医生
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
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
	 * 执行药房
	 * @return String
	 */
	public String getId_dep_wh() {
		return ((String) getAttrVal("Id_dep_wh"));
	}
	/**
	 * 执行药房
	 * @param Id_dep_wh
	 */
	public void setId_dep_wh(String Id_dep_wh) {
		setAttrVal("Id_dep_wh", Id_dep_wh);
	}
	/**
	 * 补费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_addfee() {
		return ((FBoolean) getAttrVal("Fg_addfee"));
	}
	/**
	 * 补费标识
	 * @param Fg_addfee
	 */
	public void setFg_addfee(FBoolean Fg_addfee) {
		setAttrVal("Fg_addfee", Fg_addfee);
	}
	/**
	 * 婴儿标识
	 * @return FBoolean
	 */
	public FBoolean getFg_bb() {
		return ((FBoolean) getAttrVal("Fg_bb"));
	}
	/**
	 * 婴儿标识
	 * @param Fg_bb
	 */
	public void setFg_bb(FBoolean Fg_bb) {
		setAttrVal("Fg_bb", Fg_bb);
	}
	/**
	 * 婴儿编号
	 * @return Integer
	 */
	public Integer getNo_bb() {
		return ((Integer) getAttrVal("No_bb"));
	}
	/**
	 * 婴儿编号
	 * @param No_bb
	 */
	public void setNo_bb(Integer No_bb) {
		setAttrVal("No_bb", No_bb);
	}
	/**
	 * 母亲就诊id
	 * @return String
	 */
	public String getId_ent_mm() {
		return ((String) getAttrVal("Id_ent_mm"));
	}
	/**
	 * 母亲就诊id
	 * @param Id_ent_mm
	 */
	public void setId_ent_mm(String Id_ent_mm) {
		setAttrVal("Id_ent_mm", Id_ent_mm);
	}
	/**
	 * 是否单位支付
	 * @return FBoolean
	 */
	public FBoolean getFg_pay_unit() {
		return ((FBoolean) getAttrVal("Fg_pay_unit"));
	}
	/**
	 * 是否单位支付
	 * @param Fg_pay_unit
	 */
	public void setFg_pay_unit(FBoolean Fg_pay_unit) {
		setAttrVal("Fg_pay_unit", Fg_pay_unit);
	}
	/**
	 * 就诊床位id
	 * @return String
	 */
	public String getId_entbed() {
		return ((String) getAttrVal("Id_entbed"));
	}
	/**
	 * 就诊床位id
	 * @param Id_entbed
	 */
	public void setId_entbed(String Id_entbed) {
		setAttrVal("Id_entbed", Id_entbed);
	}
	/**
	 * 就诊固定费用id
	 * @return String
	 */
	public String getId_entdcg() {
		return ((String) getAttrVal("Id_entdcg"));
	}
	/**
	 * 就诊固定费用id
	 * @param Id_entdcg
	 */
	public void setId_entdcg(String Id_entdcg) {
		setAttrVal("Id_entdcg", Id_entdcg);
	}
	/**
	 * 划价方式
	 * @return Integer
	 */
	public Integer getEu_blmd() {
		return ((Integer) getAttrVal("Eu_blmd"));
	}
	/**
	 * 划价方式
	 * @param Eu_blmd
	 */
	public void setEu_blmd(Integer Eu_blmd) {
		setAttrVal("Eu_blmd", Eu_blmd);
	}
	/**
	 * 体检流水号
	 * @return String
	 */
	public String getPecode() {
		return ((String) getAttrVal("Pecode"));
	}
	/**
	 * 体检流水号
	 * @param Pecode
	 */
	public void setPecode(String Pecode) {
		setAttrVal("Pecode", Pecode);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 明细记账时间
	 * @return FDateTime
	 */
	public FDateTime getDt_cg_detail() {
		return ((FDateTime) getAttrVal("Dt_cg_detail"));
	}
	/**
	 * 明细记账时间
	 * @param Dt_cg_detail
	 */
	public void setDt_cg_detail(FDateTime Dt_cg_detail) {
		setAttrVal("Dt_cg_detail", Dt_cg_detail);
	}
	/**
	 * 明细记账人员
	 * @return String
	 */
	public String getId_emp_cg_detail() {
		return ((String) getAttrVal("Id_emp_cg_detail"));
	}
	/**
	 * 明细记账人员
	 * @param Id_emp_cg_detail
	 */
	public void setId_emp_cg_detail(String Id_emp_cg_detail) {
		setAttrVal("Id_emp_cg_detail", Id_emp_cg_detail);
	}
	/**
	 * 明细记账科室
	 * @return String
	 */
	public String getId_dep_cg_detail() {
		return ((String) getAttrVal("Id_dep_cg_detail"));
	}
	/**
	 * 明细记账科室
	 * @param Id_dep_cg_detail
	 */
	public void setId_dep_cg_detail(String Id_dep_cg_detail) {
		setAttrVal("Id_dep_cg_detail", Id_dep_cg_detail);
	}
	/**
	 * 减免标识
	 * @return FBoolean
	 */
	public FBoolean getFg_free() {
		return ((FBoolean) getAttrVal("Fg_free"));
	}
	/**
	 * 减免标识
	 * @param Fg_free
	 */
	public void setFg_free(FBoolean Fg_free) {
		setAttrVal("Fg_free", Fg_free);
	}
	/**
	 * 医保计划主键
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保计划主键
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
}