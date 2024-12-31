package iih.bl.itf.esoe.d;

/**
 * 
 * 应急系统--门诊记账模型
 * @author ly 2019/09/26
 *
 */
public class BlEsoeCgDTO {

	/**
	 * 记账明细主键
	 */
	private String id_cg;
	/**
	 * 机构
	 */
	private String id_org;
	/**
	 * 患者
	 */
	private String id_pat;
	/**
	 * 就诊
	 */
	private String id_ent;
	/**
	 * 就诊类型
	 */
	private String code_entp;
	/**
	 * 销售单
	 */
	private String id_sale;
	/**
	 * 服务项目类型
	 */
	private String sd_srvtp;
	/**
	 * 服务项目分类
	 */
	private String id_srvca;
	/**
	 * 服务项目
	 */
	private String id_srv;
	/**
	 * 服务项目编码
	 */
	private String code_srv;
	/**
	 * 服务项目名称
	 */
	private String name_srv;
	/**
	 * 服务项目单位
	 */
	private String srvu;
	/**
	 * 账单项编码
	 */
	private String code_inccaitm;
	/**
	 * 账单项名称
	 */
	private String name_inccaitm;
	/**
	 * 价格
	 */
	private double price;
	/**
	 * 价格比例
	 */
	private double ratio_pripat;
	/**
	 * 价格_折扣
	 */
	private double price_ratio;
	/**
	 * 记退费方向
	 */
	private String sd_direct;
	/**
	 * 数量
	 */
	private double quan;
	/**
	 * 已退数量
	 */
	private double quan_ret;
	/**
	 * 标准金额
	 */
	private double amt_std;
	/**
	 * 金额_折扣
	 */
	private double amt_ratio;
	/**
	 * 患者价格类型
	 */
	private String id_pripat;
	/**
	 * 开立机构
	 */
	private String id_org_or;
	/**
	 * 开立科室
	 */
	private String id_dep_or;
	/**
	 * 开立医生
	 */
	private String id_emp_or;
	/**
	 * 执行机构
	 */
	private String id_org_mp;
	/**
	 * 执行科室
	 */
	private String id_dep_mp;
	/**
	 * 服务项目发生日期
	 */
	private String dt_srv;
	/**
	 * 物品标志
	 */
	private String fg_mm;
	/**
	 * 物品
	 */
	private String id_mm;
	/**
	 * 物品类型
	 */
	private String sd_mmtp;
	/**
	 * 物品编码
	 */
	private String code_mm;
	/**
	 * 物品唯一码
	 */
	private String onlycode;
	/**
	 * 物品名称
	 */
	private String name_mm;
	/**
	 * 物品规格
	 */
	private String spec;
	/**
	 * 批准文号/注册号
	 */
	private String apprno;
	/**
	 * 物品包装单位_基本
	 */
	private String pgku_base;
	/**
	 * 物品包装单位_当前
	 */
	private String pgku_cur;
	/**
	 * 零基换算系数
	 */
	private double factor;
	/**
	 * 数量_基本包装
	 */
	private double quan_base;
	/**
	 * 进口分类编码
	 */
	private String sd_abrd;
	/**
	 * 结算标志
	 */
	private String fg_st;
	/**
	 * 结算
	 */
	private String id_stoep;
	/**
	 * 结算日期
	 */
	private String dt_st;
	/**
	 * 已退款标志
	 */
	private String fg_refund;
	/**
	 * 退费关联记账明细主键
	 */
	private String id_par;
	/**
	 * 当前就诊科室
	 */
	private String id_dep_phy;
	/**
	 * 当前责任医生
	 */
	private String id_emp_phy;
	/**
	 * 记账日期时间
	 */
	private String dt_cg;
	/**
	 * 记账机构
	 */
	private String id_org_cg;
	/**
	 * 记账科室
	 */
	private String id_dep_cg;
	/**
	 * 记账人员
	 */
	private String id_emp_cg;
	/**
	 * 上报标志
	 */
	private String rep_state;
	public String getId_cg() {
		return id_cg;
	}
	public void setId_cg(String id_cg) {
		this.id_cg = id_cg;
	}
	public String getId_org() {
		return id_org;
	}
	public void setId_org(String id_org) {
		this.id_org = id_org;
	}
	public String getId_pat() {
		return id_pat;
	}
	public void setId_pat(String id_pat) {
		this.id_pat = id_pat;
	}
	public String getId_ent() {
		return id_ent;
	}
	public void setId_ent(String id_ent) {
		this.id_ent = id_ent;
	}
	public String getCode_entp() {
		return code_entp;
	}
	public void setCode_entp(String code_entp) {
		this.code_entp = code_entp;
	}
	public String getId_sale() {
		return id_sale;
	}
	public void setId_sale(String id_sale) {
		this.id_sale = id_sale;
	}
	public String getSd_srvtp() {
		return sd_srvtp;
	}
	public void setSd_srvtp(String sd_srvtp) {
		this.sd_srvtp = sd_srvtp;
	}
	public String getId_srvca() {
		return id_srvca;
	}
	public void setId_srvca(String id_srvca) {
		this.id_srvca = id_srvca;
	}
	public String getId_srv() {
		return id_srv;
	}
	public void setId_srv(String id_srv) {
		this.id_srv = id_srv;
	}
	public String getCode_srv() {
		return code_srv;
	}
	public void setCode_srv(String code_srv) {
		this.code_srv = code_srv;
	}
	public String getName_srv() {
		return name_srv;
	}
	public void setName_srv(String name_srv) {
		this.name_srv = name_srv;
	}
	public String getSrvu() {
		return srvu;
	}
	public void setSrvu(String srvu) {
		this.srvu = srvu;
	}
	public String getCode_inccaitm() {
		return code_inccaitm;
	}
	public void setCode_inccaitm(String code_inccaitm) {
		this.code_inccaitm = code_inccaitm;
	}
	public String getName_inccaitm() {
		return name_inccaitm;
	}
	public void setName_inccaitm(String name_inccaitm) {
		this.name_inccaitm = name_inccaitm;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getRatio_pripat() {
		return ratio_pripat;
	}
	public void setRatio_pripat(double ratio_pripat) {
		this.ratio_pripat = ratio_pripat;
	}
	public double getPrice_ratio() {
		return price_ratio;
	}
	public void setPrice_ratio(double price_ratio) {
		this.price_ratio = price_ratio;
	}
	public String getSd_direct() {
		return sd_direct;
	}
	public void setSd_direct(String sd_direct) {
		this.sd_direct = sd_direct;
	}
	public double getQuan() {
		return quan;
	}
	public void setQuan(double quan) {
		this.quan = quan;
	}
	public double getQuan_ret() {
		return quan_ret;
	}
	public void setQuan_ret(double quan_ret) {
		this.quan_ret = quan_ret;
	}
	public double getAmt_std() {
		return amt_std;
	}
	public void setAmt_std(double amt_std) {
		this.amt_std = amt_std;
	}
	public double getAmt_ratio() {
		return amt_ratio;
	}
	public void setAmt_ratio(double amt_ratio) {
		this.amt_ratio = amt_ratio;
	}
	public String getId_pripat() {
		return id_pripat;
	}
	public void setId_pripat(String id_pripat) {
		this.id_pripat = id_pripat;
	}
	public String getId_org_or() {
		return id_org_or;
	}
	public void setId_org_or(String id_org_or) {
		this.id_org_or = id_org_or;
	}
	public String getId_dep_or() {
		return id_dep_or;
	}
	public void setId_dep_or(String id_dep_or) {
		this.id_dep_or = id_dep_or;
	}
	public String getId_emp_or() {
		return id_emp_or;
	}
	public void setId_emp_or(String id_emp_or) {
		this.id_emp_or = id_emp_or;
	}
	public String getId_org_mp() {
		return id_org_mp;
	}
	public void setId_org_mp(String id_org_mp) {
		this.id_org_mp = id_org_mp;
	}
	public String getId_dep_mp() {
		return id_dep_mp;
	}
	public void setId_dep_mp(String id_dep_mp) {
		this.id_dep_mp = id_dep_mp;
	}
	public String getDt_srv() {
		return dt_srv;
	}
	public void setDt_srv(String dt_srv) {
		this.dt_srv = dt_srv;
	}
	public String getFg_mm() {
		return fg_mm;
	}
	public void setFg_mm(String fg_mm) {
		this.fg_mm = fg_mm;
	}
	public String getId_mm() {
		return id_mm;
	}
	public void setId_mm(String id_mm) {
		this.id_mm = id_mm;
	}
	public String getSd_mmtp() {
		return sd_mmtp;
	}
	public void setSd_mmtp(String sd_mmtp) {
		this.sd_mmtp = sd_mmtp;
	}
	public String getCode_mm() {
		return code_mm;
	}
	public void setCode_mm(String code_mm) {
		this.code_mm = code_mm;
	}
	public String getOnlycode() {
		return onlycode;
	}
	public void setOnlycode(String onlycode) {
		this.onlycode = onlycode;
	}
	public String getName_mm() {
		return name_mm;
	}
	public void setName_mm(String name_mm) {
		this.name_mm = name_mm;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getApprno() {
		return apprno;
	}
	public void setApprno(String apprno) {
		this.apprno = apprno;
	}
	public String getPgku_base() {
		return pgku_base;
	}
	public void setPgku_base(String pgku_base) {
		this.pgku_base = pgku_base;
	}
	public String getPgku_cur() {
		return pgku_cur;
	}
	public void setPgku_cur(String pgku_cur) {
		this.pgku_cur = pgku_cur;
	}
	public double getFactor() {
		return factor;
	}
	public void setFactor(double factor) {
		this.factor = factor;
	}
	public double getQuan_base() {
		return quan_base;
	}
	public void setQuan_base(double quan_base) {
		this.quan_base = quan_base;
	}
	public String getSd_abrd() {
		return sd_abrd;
	}
	public void setSd_abrd(String sd_abrd) {
		this.sd_abrd = sd_abrd;
	}
	public String getFg_st() {
		return fg_st;
	}
	public void setFg_st(String fg_st) {
		this.fg_st = fg_st;
	}
	public String getId_stoep() {
		return id_stoep;
	}
	public void setId_stoep(String id_stoep) {
		this.id_stoep = id_stoep;
	}
	public String getDt_st() {
		return dt_st;
	}
	public void setDt_st(String dt_st) {
		this.dt_st = dt_st;
	}
	public String getFg_refund() {
		return fg_refund;
	}
	public void setFg_refund(String fg_refund) {
		this.fg_refund = fg_refund;
	}
	public String getId_par() {
		return id_par;
	}
	public void setId_par(String id_par) {
		this.id_par = id_par;
	}
	public String getId_dep_phy() {
		return id_dep_phy;
	}
	public void setId_dep_phy(String id_dep_phy) {
		this.id_dep_phy = id_dep_phy;
	}
	public String getId_emp_phy() {
		return id_emp_phy;
	}
	public void setId_emp_phy(String id_emp_phy) {
		this.id_emp_phy = id_emp_phy;
	}
	public String getDt_cg() {
		return dt_cg;
	}
	public void setDt_cg(String dt_cg) {
		this.dt_cg = dt_cg;
	}
	public String getId_org_cg() {
		return id_org_cg;
	}
	public void setId_org_cg(String id_org_cg) {
		this.id_org_cg = id_org_cg;
	}
	public String getId_dep_cg() {
		return id_dep_cg;
	}
	public void setId_dep_cg(String id_dep_cg) {
		this.id_dep_cg = id_dep_cg;
	}
	public String getId_emp_cg() {
		return id_emp_cg;
	}
	public void setId_emp_cg(String id_emp_cg) {
		this.id_emp_cg = id_emp_cg;
	}
	public String getRep_state() {
		return rep_state;
	}
	public void setRep_state(String rep_state) {
		this.rep_state = rep_state;
	}
}
