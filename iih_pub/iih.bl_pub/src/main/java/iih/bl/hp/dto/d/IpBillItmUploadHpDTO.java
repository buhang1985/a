package iih.bl.hp.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院医保处方明细上传 DTO数据 
 * 
 */
public class IpBillItmUploadHpDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊主键
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊主键
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者主键
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者主键
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
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
	 * 医保产品
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保产品
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 标准单价
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 标准单价
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 折扣价格
	 * @return FDouble
	 */
	public FDouble getPrice_ratio() {
		return ((FDouble) getAttrVal("Price_ratio"));
	}
	/**
	 * 折扣价格
	 * @param Price_ratio
	 */
	public void setPrice_ratio(FDouble Price_ratio) {
		setAttrVal("Price_ratio", Price_ratio);
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
	 * 服务主键
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务主键
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getSrvu() {
		return ((String) getAttrVal("Srvu"));
	}
	/**
	 * 单位
	 * @param Srvu
	 */
	public void setSrvu(String Srvu) {
		setAttrVal("Srvu", Srvu);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getName_srvu() {
		return ((String) getAttrVal("Name_srvu"));
	}
	/**
	 * 单位名称
	 * @param Name_srvu
	 */
	public void setName_srvu(String Name_srvu) {
		setAttrVal("Name_srvu", Name_srvu);
	}
	/**
	 * 医生姓名
	 * @return String
	 */
	public String getName_emp_or() {
		return ((String) getAttrVal("Name_emp_or"));
	}
	/**
	 * 医生姓名
	 * @param Name_emp_or
	 */
	public void setName_emp_or(String Name_emp_or) {
		setAttrVal("Name_emp_or", Name_emp_or);
	}
	/**
	 * 开单科室
	 * @return String
	 */
	public String getName_dep_or() {
		return ((String) getAttrVal("Name_dep_or"));
	}
	/**
	 * 开单科室
	 * @param Name_dep_or
	 */
	public void setName_dep_or(String Name_dep_or) {
		setAttrVal("Name_dep_or", Name_dep_or);
	}
	/**
	 * 医生主键
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}
	/**
	 * 医生主键
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	/**
	 * 操作人员
	 * @return String
	 */
	public String getOperator() {
		return ((String) getAttrVal("Operator"));
	}
	/**
	 * 操作人员
	 * @param Operator
	 */
	public void setOperator(String Operator) {
		setAttrVal("Operator", Operator);
	}
	/**
	 * 金额
	 * @return FDouble
	 */
	public FDouble getAmt_ratio() {
		return ((FDouble) getAttrVal("Amt_ratio"));
	}
	/**
	 * 金额
	 * @param Amt_ratio
	 */
	public void setAmt_ratio(FDouble Amt_ratio) {
		setAttrVal("Amt_ratio", Amt_ratio);
	}
	/**
	 * 是否医保
	 * @return FBoolean
	 */
	public FBoolean getFg_hp() {
		return ((FBoolean) getAttrVal("Fg_hp"));
	}
	/**
	 * 是否医保
	 * @param Fg_hp
	 */
	public void setFg_hp(FBoolean Fg_hp) {
		setAttrVal("Fg_hp", Fg_hp);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 就诊号
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 方向
	 * @return Integer
	 */
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}
	/**
	 * 方向
	 * @param Eu_direct
	 */
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
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
	 * 服务类型主键
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}
	/**
	 * 服务类型主键
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 服务日期
	 * @return FDateTime
	 */
	public FDateTime getDt_srv() {
		return ((FDateTime) getAttrVal("Dt_srv"));
	}
	/**
	 * 服务日期
	 * @param Dt_srv
	 */
	public void setDt_srv(FDateTime Dt_srv) {
		setAttrVal("Dt_srv", Dt_srv);
	}
	/**
	 * 服务类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 物品主键
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品主键
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
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
	 * 医嘱服务主键
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱服务主键
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
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
	 * 是否新生儿
	 * @return FBoolean
	 */
	public FBoolean getFg_bb() {
		return ((FBoolean) getAttrVal("Fg_bb"));
	}
	/**
	 * 是否新生儿
	 * @param Fg_bb
	 */
	public void setFg_bb(FBoolean Fg_bb) {
		setAttrVal("Fg_bb", Fg_bb);
	}
	/**
	 * 母亲就诊主键
	 * @return String
	 */
	public String getId_ent_mom() {
		return ((String) getAttrVal("Id_ent_mom"));
	}
	/**
	 * 母亲就诊主键
	 * @param Id_ent_mom
	 */
	public void setId_ent_mom(String Id_ent_mom) {
		setAttrVal("Id_ent_mom", Id_ent_mom);
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
	 * 是否物品
	 * @return FBoolean
	 */
	public FBoolean getFg_mm() {
		return ((FBoolean) getAttrVal("Fg_mm"));
	}
	/**
	 * 是否物品
	 * @param Fg_mm
	 */
	public void setFg_mm(FBoolean Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
	}
	/**
	 * 记账关系ID
	 * @return String
	 */
	public String getId_cgpar() {
		return ((String) getAttrVal("Id_cgpar"));
	}
	/**
	 * 记账关系ID
	 * @param Id_cgpar
	 */
	public void setId_cgpar(String Id_cgpar) {
		setAttrVal("Id_cgpar", Id_cgpar);
	}
	/**
	 * 方向名称
	 * @return String
	 */
	public String getEu_name() {
		return ((String) getAttrVal("Eu_name"));
	}
	/**
	 * 方向名称
	 * @param Eu_name
	 */
	public void setEu_name(String Eu_name) {
		setAttrVal("Eu_name", Eu_name);
	}
	/**
	 * 收费等级
	 * @return String
	 */
	public String getName_chargegrade() {
		return ((String) getAttrVal("Name_chargegrade"));
	}
	/**
	 * 收费等级
	 * @param Name_chargegrade
	 */
	public void setName_chargegrade(String Name_chargegrade) {
		setAttrVal("Name_chargegrade", Name_chargegrade);
	}
	/**
	 * 医保金额
	 * @return FDouble
	 */
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}
	/**
	 * 医保金额
	 * @param Amt_hp
	 */
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
	}
	/**
	 * 自理金额
	 * @return FDouble
	 */
	public FDouble getAmt_pat() {
		return ((FDouble) getAttrVal("Amt_pat"));
	}
	/**
	 * 自理金额
	 * @param Amt_pat
	 */
	public void setAmt_pat(FDouble Amt_pat) {
		setAttrVal("Amt_pat", Amt_pat);
	}
	/**
	 * 单复方标志
	 * @return FBoolean
	 */
	public FBoolean getFg_single() {
		return ((FBoolean) getAttrVal("Fg_single"));
	}
	/**
	 * 单复方标志
	 * @param Fg_single
	 */
	public void setFg_single(FBoolean Fg_single) {
		setAttrVal("Fg_single", Fg_single);
	}
	/**
	 * 剂型
	 * @return String
	 */
	public String getId_dosage() {
		return ((String) getAttrVal("Id_dosage"));
	}
	/**
	 * 剂型
	 * @param Id_dosage
	 */
	public void setId_dosage(String Id_dosage) {
		setAttrVal("Id_dosage", Id_dosage);
	}
	/**
	 * 药物剂型代码
	 * @return String
	 */
	public String getName_dosage() {
		return ((String) getAttrVal("Name_dosage"));
	}
	/**
	 * 药物剂型代码
	 * @param Name_dosage
	 */
	public void setName_dosage(String Name_dosage) {
		setAttrVal("Name_dosage", Name_dosage);
	}
	/**
	 * 用量
	 * @return FDouble
	 */
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}
	/**
	 * 用量
	 * @param Quan_medu
	 */
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	/**
	 * 用量单位
	 * @return String
	 */
	public String getMeduunit_name() {
		return ((String) getAttrVal("Meduunit_name"));
	}
	/**
	 * 用量单位
	 * @param Meduunit_name
	 */
	public void setMeduunit_name(String Meduunit_name) {
		setAttrVal("Meduunit_name", Meduunit_name);
	}
	/**
	 * 频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * 频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 医嘱频次名称
	 * @return String
	 */
	public String getName_freq() {
		return ((String) getAttrVal("Name_freq"));
	}
	/**
	 * 医嘱频次名称
	 * @param Name_freq
	 */
	public void setName_freq(String Name_freq) {
		setAttrVal("Name_freq", Name_freq);
	}
	/**
	 * 用药天数
	 * @return Integer
	 */
	public Integer getDays() {
		return ((Integer) getAttrVal("Days"));
	}
	/**
	 * 用药天数
	 * @param Days
	 */
	public void setDays(Integer Days) {
		setAttrVal("Days", Days);
	}
	/**
	 * 用法主键
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}
	/**
	 * 用法主键
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 用法名称
	 * @return String
	 */
	public String getName_route() {
		return ((String) getAttrVal("Name_route"));
	}
	/**
	 * 用法名称
	 * @param Name_route
	 */
	public void setName_route(String Name_route) {
		setAttrVal("Name_route", Name_route);
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
	 * 计费时间
	 * @return FDateTime
	 */
	public FDateTime getDt_cg() {
		return ((FDateTime) getAttrVal("Dt_cg"));
	}
	/**
	 * 计费时间
	 * @param Dt_cg
	 */
	public void setDt_cg(FDateTime Dt_cg) {
		setAttrVal("Dt_cg", Dt_cg);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getCode_dep_or() {
		return ((String) getAttrVal("Code_dep_or"));
	}
	/**
	 * 科室编码
	 * @param Code_dep_or
	 */
	public void setCode_dep_or(String Code_dep_or) {
		setAttrVal("Code_dep_or", Code_dep_or);
	}
	/**
	 * 超出治疗方案自付金额
	 * @return FDouble
	 */
	public FDouble getAmt_czl_payzf() {
		return ((FDouble) getAttrVal("Amt_czl_payzf"));
	}
	/**
	 * 超出治疗方案自付金额
	 * @param Amt_czl_payzf
	 */
	public void setAmt_czl_payzf(FDouble Amt_czl_payzf) {
		setAttrVal("Amt_czl_payzf", Amt_czl_payzf);
	}
	/**
	 * 自费金额
	 * @return FDouble
	 */
	public FDouble getAmt_payzf() {
		return ((FDouble) getAttrVal("Amt_payzf"));
	}
	/**
	 * 自费金额
	 * @param Amt_payzf
	 */
	public void setAmt_payzf(FDouble Amt_payzf) {
		setAttrVal("Amt_payzf", Amt_payzf);
	}
	/**
	 * 超限价自付金额
	 * @return FDouble
	 */
	public FDouble getAmt_cxj_payzf() {
		return ((FDouble) getAttrVal("Amt_cxj_payzf"));
	}
	/**
	 * 超限价自付金额
	 * @param Amt_cxj_payzf
	 */
	public void setAmt_cxj_payzf(FDouble Amt_cxj_payzf) {
		setAttrVal("Amt_cxj_payzf", Amt_cxj_payzf);
	}
	/**
	 * 收费类别
	 * @return String
	 */
	public String getCode_ca() {
		return ((String) getAttrVal("Code_ca"));
	}
	/**
	 * 收费类别
	 * @param Code_ca
	 */
	public void setCode_ca(String Code_ca) {
		setAttrVal("Code_ca", Code_ca);
	}
	/**
	 * 全额自费标志
	 * @return FBoolean
	 */
	public FBoolean getFg_selfpay() {
		return ((FBoolean) getAttrVal("Fg_selfpay"));
	}
	/**
	 * 全额自费标志
	 * @param Fg_selfpay
	 */
	public void setFg_selfpay(FBoolean Fg_selfpay) {
		setAttrVal("Fg_selfpay", Fg_selfpay);
	}
	/**
	 * 自理比例
	 * @return FDouble
	 */
	public FDouble getRate_payzl() {
		return ((FDouble) getAttrVal("Rate_payzl"));
	}
	/**
	 * 自理比例
	 * @param Rate_payzl
	 */
	public void setRate_payzl(FDouble Rate_payzl) {
		setAttrVal("Rate_payzl", Rate_payzl);
	}
	/**
	 * 限价
	 * @return FDouble
	 */
	public FDouble getLimited_pri() {
		return ((FDouble) getAttrVal("Limited_pri"));
	}
	/**
	 * 限价
	 * @param Limited_pri
	 */
	public void setLimited_pri(FDouble Limited_pri) {
		setAttrVal("Limited_pri", Limited_pri);
	}
	/**
	 * 医保中心编码
	 * @return String
	 */
	public String getHp_srvcode() {
		return ((String) getAttrVal("Hp_srvcode"));
	}
	/**
	 * 医保中心编码
	 * @param Hp_srvcode
	 */
	public void setHp_srvcode(String Hp_srvcode) {
		setAttrVal("Hp_srvcode", Hp_srvcode);
	}
	/**
	 * 医保项目类型
	 * @return String
	 */
	public String getEu_hpsrvtp() {
		return ((String) getAttrVal("Eu_hpsrvtp"));
	}
	/**
	 * 医保项目类型
	 * @param Eu_hpsrvtp
	 */
	public void setEu_hpsrvtp(String Eu_hpsrvtp) {
		setAttrVal("Eu_hpsrvtp", Eu_hpsrvtp);
	}
	/**
	 * 医保项目名称
	 * @return String
	 */
	public String getHp_srvname() {
		return ((String) getAttrVal("Hp_srvname"));
	}
	/**
	 * 医保项目名称
	 * @param Hp_srvname
	 */
	public void setHp_srvname(String Hp_srvname) {
		setAttrVal("Hp_srvname", Hp_srvname);
	}
	/**
	 * 自费原因备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 自费原因备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 金额汇总
	 * @return FDouble
	 */
	public FDouble getAmtsum() {
		return ((FDouble) getAttrVal("Amtsum"));
	}
	/**
	 * 金额汇总
	 * @param Amtsum
	 */
	public void setAmtsum(FDouble Amtsum) {
		setAttrVal("Amtsum", Amtsum);
	}
	/**
	 * 自费金额汇总
	 * @return FDouble
	 */
	public FDouble getZfamtsum() {
		return ((FDouble) getAttrVal("Zfamtsum"));
	}
	/**
	 * 自费金额汇总
	 * @param Zfamtsum
	 */
	public void setZfamtsum(FDouble Zfamtsum) {
		setAttrVal("Zfamtsum", Zfamtsum);
	}
	/**
	 * 自理金额汇总
	 * @return FDouble
	 */
	public FDouble getZlamtsum() {
		return ((FDouble) getAttrVal("Zlamtsum"));
	}
	/**
	 * 自理金额汇总
	 * @param Zlamtsum
	 */
	public void setZlamtsum(FDouble Zlamtsum) {
		setAttrVal("Zlamtsum", Zlamtsum);
	}
	/**
	 * 超限价自付金额汇总
	 * @return FDouble
	 */
	public FDouble getCxjamtsum() {
		return ((FDouble) getAttrVal("Cxjamtsum"));
	}
	/**
	 * 超限价自付金额汇总
	 * @param Cxjamtsum
	 */
	public void setCxjamtsum(FDouble Cxjamtsum) {
		setAttrVal("Cxjamtsum", Cxjamtsum);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getCode_dep_mp() {
		return ((String) getAttrVal("Code_dep_mp"));
	}
	/**
	 * 执行科室名称
	 * @param Code_dep_mp
	 */
	public void setCode_dep_mp(String Code_dep_mp) {
		setAttrVal("Code_dep_mp", Code_dep_mp);
	}
	/**
	 * 执行科室编码
	 * @return String
	 */
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}
	/**
	 * 执行科室编码
	 * @param Name_dep_mp
	 */
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}
	/**
	 * 医师无处方权自费
	 * @return String
	 */
	public String getPresauth_self() {
		return ((String) getAttrVal("Presauth_self"));
	}
	/**
	 * 医师无处方权自费
	 * @param Presauth_self
	 */
	public void setPresauth_self(String Presauth_self) {
		setAttrVal("Presauth_self", Presauth_self);
	}
	/**
	 * 记账明细流水号
	 * @return String
	 */
	public String getCode_cg() {
		return ((String) getAttrVal("Code_cg"));
	}
	/**
	 * 记账明细流水号
	 * @param Code_cg
	 */
	public void setCode_cg(String Code_cg) {
		setAttrVal("Code_cg", Code_cg);
	}
	/**
	 * 退费标识
	 * @return String
	 */
	public String getFg_refund() {
		return ((String) getAttrVal("Fg_refund"));
	}
	/**
	 * 退费标识
	 * @param Fg_refund
	 */
	public void setFg_refund(String Fg_refund) {
		setAttrVal("Fg_refund", Fg_refund);
	}
}