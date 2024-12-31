package iih.bl.st.dto.bloepcharge.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊收费调入dto DTO数据 
 * 
 */
public class BlOepChargeInputDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 记账id
	 * @return String
	 */
	public String getId_cgitmoep() {
		return ((String) getAttrVal("Id_cgitmoep"));
	}
	/**
	 * 记账id
	 * @param Id_cgitmoep
	 */
	public void setId_cgitmoep(String Id_cgitmoep) {
		setAttrVal("Id_cgitmoep", Id_cgitmoep);
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
	 * 就诊编码
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 就诊编码
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getId_enttp() {
		return ((String) getAttrVal("Id_enttp"));
	}
	/**
	 * 就诊类型
	 * @param Id_enttp
	 */
	public void setId_enttp(String Id_enttp) {
		setAttrVal("Id_enttp", Id_enttp);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_enttp() {
		return ((String) getAttrVal("Code_enttp"));
	}
	/**
	 * 就诊类型编码
	 * @param Code_enttp
	 */
	public void setCode_enttp(String Code_enttp) {
		setAttrVal("Code_enttp", Code_enttp);
	}
	/**
	 * 处方
	 * @return String
	 */
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}
	/**
	 * 处方
	 * @param Id_pres
	 */
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
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
	 * 医嘱服务类型
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 医嘱服务类型
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
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
	 * 医嘱内容
	 * @return String
	 */
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}
	/**
	 * 医嘱内容
	 * @param Content_or
	 */
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getApplyno() {
		return ((String) getAttrVal("Applyno"));
	}
	/**
	 * 申请单号
	 * @param Applyno
	 */
	public void setApplyno(String Applyno) {
		setAttrVal("Applyno", Applyno);
	}
	/**
	 * 处方单号
	 * @return String
	 */
	public String getPres_code() {
		return ((String) getAttrVal("Pres_code"));
	}
	/**
	 * 处方单号
	 * @param Pres_code
	 */
	public void setPres_code(String Pres_code) {
		setAttrVal("Pres_code", Pres_code);
	}
	/**
	 * 单据号
	 * @return String
	 */
	public String getCode_bill() {
		return ((String) getAttrVal("Code_bill"));
	}
	/**
	 * 单据号
	 * @param Code_bill
	 */
	public void setCode_bill(String Code_bill) {
		setAttrVal("Code_bill", Code_bill);
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
	 * 开立时间
	 * @return FDateTime
	 */
	public FDateTime getDt_or() {
		return ((FDateTime) getAttrVal("Dt_or"));
	}
	/**
	 * 开立时间
	 * @param Dt_or
	 */
	public void setDt_or(FDateTime Dt_or) {
		setAttrVal("Dt_or", Dt_or);
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
	 * 服务项目id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务项目id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
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
	 * 服务项目编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}
	/**
	 * 服务项目编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 服务项目名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 服务项目名称
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
	 * 标准价格
	 * @return FDouble
	 */
	public FDouble getPrice_std() {
		return ((FDouble) getAttrVal("Price_std"));
	}
	/**
	 * 标准价格
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
	 * 金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}
	/**
	 * 金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 折扣金额
	 * @return FDouble
	 */
	public FDouble getAmt_ratio() {
		return ((FDouble) getAttrVal("Amt_ratio"));
	}
	/**
	 * 折扣金额
	 * @param Amt_ratio
	 */
	public void setAmt_ratio(FDouble Amt_ratio) {
		setAttrVal("Amt_ratio", Amt_ratio);
	}
	/**
	 * 患者自付金额
	 * @return FDouble
	 */
	public FDouble getAmt_pat() {
		return ((FDouble) getAttrVal("Amt_pat"));
	}
	/**
	 * 患者自付金额
	 * @param Amt_pat
	 */
	public void setAmt_pat(FDouble Amt_pat) {
		setAttrVal("Amt_pat", Amt_pat);
	}
	/**
	 * 金额_医保计划
	 * @return FDouble
	 */
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}
	/**
	 * 金额_医保计划
	 * @param Amt_hp
	 */
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
	}
	/**
	 * 标准金额
	 * @return FDouble
	 */
	public FDouble getAmt_std() {
		return ((FDouble) getAttrVal("Amt_std"));
	}
	/**
	 * 标准金额
	 * @param Amt_std
	 */
	public void setAmt_std(FDouble Amt_std) {
		setAttrVal("Amt_std", Amt_std);
	}
	/**
	 * 医保个人编号
	 * @return String
	 */
	public String getPerson_code() {
		return ((String) getAttrVal("Person_code"));
	}
	/**
	 * 医保个人编号
	 * @param Person_code
	 */
	public void setPerson_code(String Person_code) {
		setAttrVal("Person_code", Person_code);
	}
	/**
	 * 个人账户余额
	 * @return FDouble
	 */
	public FDouble getAmt_psn() {
		return ((FDouble) getAttrVal("Amt_psn"));
	}
	/**
	 * 个人账户余额
	 * @param Amt_psn
	 */
	public void setAmt_psn(FDouble Amt_psn) {
		setAttrVal("Amt_psn", Amt_psn);
	}
	/**
	 * 服务项目单位
	 * @return String
	 */
	public String getSrvu() {
		return ((String) getAttrVal("Srvu"));
	}
	/**
	 * 服务项目单位
	 * @param Srvu
	 */
	public void setSrvu(String Srvu) {
		setAttrVal("Srvu", Srvu);
	}
	/**
	 * 服务单位名称
	 * @return String
	 */
	public String getSrvu_name() {
		return ((String) getAttrVal("Srvu_name"));
	}
	/**
	 * 服务单位名称
	 * @param Srvu_name
	 */
	public void setSrvu_name(String Srvu_name) {
		setAttrVal("Srvu_name", Srvu_name);
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
	 * 物品编码
	 * @return String
	 */
	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}
	/**
	 * 物品编码
	 * @param Code_mm
	 */
	public void setCode_mm(String Code_mm) {
		setAttrVal("Code_mm", Code_mm);
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
	 * 当前包装单位
	 * @return String
	 */
	public String getId_pgku_cur() {
		return ((String) getAttrVal("Id_pgku_cur"));
	}
	/**
	 * 当前包装单位
	 * @param Id_pgku_cur
	 */
	public void setId_pgku_cur(String Id_pgku_cur) {
		setAttrVal("Id_pgku_cur", Id_pgku_cur);
	}
	/**
	 * 基本包装单位
	 * @return String
	 */
	public String getId_pgku_base() {
		return ((String) getAttrVal("Id_pgku_base"));
	}
	/**
	 * 基本包装单位
	 * @param Id_pgku_base
	 */
	public void setId_pgku_base(String Id_pgku_base) {
		setAttrVal("Id_pgku_base", Id_pgku_base);
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
	 * 开立科室名称
	 * @return String
	 */
	public String getName_dep_or() {
		return ((String) getAttrVal("Name_dep_or"));
	}
	/**
	 * 开立科室名称
	 * @param Name_dep_or
	 */
	public void setName_dep_or(String Name_dep_or) {
		setAttrVal("Name_dep_or", Name_dep_or);
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
	 * 开立医生名称
	 * @return String
	 */
	public String getName_emp_or() {
		return ((String) getAttrVal("Name_emp_or"));
	}
	/**
	 * 开立医生名称
	 * @param Name_emp_or
	 */
	public void setName_emp_or(String Name_emp_or) {
		setAttrVal("Name_emp_or", Name_emp_or);
	}
	/**
	 * 记账日期
	 * @return FDateTime
	 */
	public FDateTime getDt_cg() {
		return ((FDateTime) getAttrVal("Dt_cg"));
	}
	/**
	 * 记账日期
	 * @param Dt_cg
	 */
	public void setDt_cg(FDateTime Dt_cg) {
		setAttrVal("Dt_cg", Dt_cg);
	}
	/**
	 * 就诊来源
	 * @return Integer
	 */
	public Integer getEu_srctp() {
		return ((Integer) getAttrVal("Eu_srctp"));
	}
	/**
	 * 就诊来源
	 * @param Eu_srctp
	 */
	public void setEu_srctp(Integer Eu_srctp) {
		setAttrVal("Eu_srctp", Eu_srctp);
	}
	/**
	 * 价格分类
	 * @return String
	 */
	public String getId_pripat() {
		return ((String) getAttrVal("Id_pripat"));
	}
	/**
	 * 价格分类
	 * @param Id_pripat
	 */
	public void setId_pripat(String Id_pripat) {
		setAttrVal("Id_pripat", Id_pripat);
	}
	/**
	 * 价格分类名称
	 * @return String
	 */
	public String getId_pripat_name() {
		return ((String) getAttrVal("Id_pripat_name"));
	}
	/**
	 * 价格分类名称
	 * @param Id_pripat_name
	 */
	public void setId_pripat_name(String Id_pripat_name) {
		setAttrVal("Id_pripat_name", Id_pripat_name);
	}
	/**
	 * 患者分类
	 * @return String
	 */
	public String getId_paticate() {
		return ((String) getAttrVal("Id_paticate"));
	}
	/**
	 * 患者分类
	 * @param Id_paticate
	 */
	public void setId_paticate(String Id_paticate) {
		setAttrVal("Id_paticate", Id_paticate);
	}
	/**
	 * 患者分类名称
	 * @return String
	 */
	public String getId_paticate_name() {
		return ((String) getAttrVal("Id_paticate_name"));
	}
	/**
	 * 患者分类名称
	 * @param Id_paticate_name
	 */
	public void setId_paticate_name(String Id_paticate_name) {
		setAttrVal("Id_paticate_name", Id_paticate_name);
	}
	/**
	 * 计费模式
	 * @return Integer
	 */
	public Integer getEu_blmd() {
		return ((Integer) getAttrVal("Eu_blmd"));
	}
	/**
	 * 计费模式
	 * @param Eu_blmd
	 */
	public void setEu_blmd(Integer Eu_blmd) {
		setAttrVal("Eu_blmd", Eu_blmd);
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
	 * 体检号
	 * @return String
	 */
	public String getPe_code() {
		return ((String) getAttrVal("Pe_code"));
	}
	/**
	 * 体检号
	 * @param Pe_code
	 */
	public void setPe_code(String Pe_code) {
		setAttrVal("Pe_code", Pe_code);
	}
	/**
	 * 体检项目主键
	 * @return String
	 */
	public String getId_pesrv() {
		return ((String) getAttrVal("Id_pesrv"));
	}
	/**
	 * 体检项目主键
	 * @param Id_pesrv
	 */
	public void setId_pesrv(String Id_pesrv) {
		setAttrVal("Id_pesrv", Id_pesrv);
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
	 * 执行人员名称
	 * @return String
	 */
	public String getName_emp_cg() {
		return ((String) getAttrVal("Name_emp_cg"));
	}
	/**
	 * 执行人员名称
	 * @param Name_emp_cg
	 */
	public void setName_emp_cg(String Name_emp_cg) {
		setAttrVal("Name_emp_cg", Name_emp_cg);
	}
	/**
	 * 医保计划
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保计划
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 医保自付比例
	 * @return String
	 */
	public String getRatio_hp() {
		return ((String) getAttrVal("Ratio_hp"));
	}
	/**
	 * 医保自付比例
	 * @param Ratio_hp
	 */
	public void setRatio_hp(String Ratio_hp) {
		setAttrVal("Ratio_hp", Ratio_hp);
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
	 * 已经医保上传标志
	 * @return FBoolean
	 */
	public FBoolean getFg_hp() {
		return ((FBoolean) getAttrVal("Fg_hp"));
	}
	/**
	 * 已经医保上传标志
	 * @param Fg_hp
	 */
	public void setFg_hp(FBoolean Fg_hp) {
		setAttrVal("Fg_hp", Fg_hp);
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
	 * 医保结算类型sd
	 * @return String
	 */
	public String getSd_hpsttp() {
		return ((String) getAttrVal("Sd_hpsttp"));
	}
	/**
	 * 医保结算类型sd
	 * @param Sd_hpsttp
	 */
	public void setSd_hpsttp(String Sd_hpsttp) {
		setAttrVal("Sd_hpsttp", Sd_hpsttp);
	}
	/**
	 * 挂起标识
	 * @return FBoolean
	 */
	public FBoolean getFg_susp() {
		return ((FBoolean) getAttrVal("Fg_susp"));
	}
	/**
	 * 挂起标识
	 * @param Fg_susp
	 */
	public void setFg_susp(FBoolean Fg_susp) {
		setAttrVal("Fg_susp", Fg_susp);
	}
	/**
	 * 预交金记账标识
	 * @return FBoolean
	 */
	public FBoolean getFg_acc() {
		return ((FBoolean) getAttrVal("Fg_acc"));
	}
	/**
	 * 预交金记账标识
	 * @param Fg_acc
	 */
	public void setFg_acc(FBoolean Fg_acc) {
		setAttrVal("Fg_acc", Fg_acc);
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
	 * 账单项ID
	 * @return String
	 */
	public String getId_inccaitm() {
		return ((String) getAttrVal("Id_inccaitm"));
	}
	/**
	 * 账单项ID
	 * @param Id_inccaitm
	 */
	public void setId_inccaitm(String Id_inccaitm) {
		setAttrVal("Id_inccaitm", Id_inccaitm);
	}
	/**
	 * 账单想名称
	 * @return String
	 */
	public String getName_inccaitm() {
		return ((String) getAttrVal("Name_inccaitm"));
	}
	/**
	 * 账单想名称
	 * @param Name_inccaitm
	 */
	public void setName_inccaitm(String Name_inccaitm) {
		setAttrVal("Name_inccaitm", Name_inccaitm);
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
	 * 就诊次数据
	 * @return String
	 */
	public String getTimes_op() {
		return ((String) getAttrVal("Times_op"));
	}
	/**
	 * 就诊次数据
	 * @param Times_op
	 */
	public void setTimes_op(String Times_op) {
		setAttrVal("Times_op", Times_op);
	}
	/**
	 * 诊断ID
	 * @return String
	 */
	public String getId_didef() {
		return ((String) getAttrVal("Id_didef"));
	}
	/**
	 * 诊断ID
	 * @param Id_didef
	 */
	public void setId_didef(String Id_didef) {
		setAttrVal("Id_didef", Id_didef);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName_didef() {
		return ((String) getAttrVal("Name_didef"));
	}
	/**
	 * 诊断名称
	 * @param Name_didef
	 */
	public void setName_didef(String Name_didef) {
		setAttrVal("Name_didef", Name_didef);
	}
	/**
	 * 记账编码
	 * @return String
	 */
	public String getCode_cg() {
		return ((String) getAttrVal("Code_cg"));
	}
	/**
	 * 记账编码
	 * @param Code_cg
	 */
	public void setCode_cg(String Code_cg) {
		setAttrVal("Code_cg", Code_cg);
	}
	/**
	 * 医嘱签署时间
	 * @return FDateTime
	 */
	public FDateTime getDt_sign() {
		return ((FDateTime) getAttrVal("Dt_sign"));
	}
	/**
	 * 医嘱签署时间
	 * @param Dt_sign
	 */
	public void setDt_sign(FDateTime Dt_sign) {
		setAttrVal("Dt_sign", Dt_sign);
	}
	/**
	 * 医疗单类型
	 * @return String
	 */
	public String getPrntype() {
		return ((String) getAttrVal("Prntype"));
	}
	/**
	 * 医疗单类型
	 * @param Prntype
	 */
	public void setPrntype(String Prntype) {
		setAttrVal("Prntype", Prntype);
	}
}