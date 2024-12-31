package iih.en.pv.out.d;

/**
 * 挂号信息
 * 
 * @author liubin
 *
 */
public class EnOpRegistBean {
	/**
	 * 就诊id
	 */
	private String id_ent;
	/**
	 * 集团id
	 */
	private String id_grp;
	/**
	 * 组织id
	 */
	private String id_org;
	/**
	 * 患者id
	 */
	private String id_pat;
	/**
	 * 就诊类型编码
	 */
	private String code_entp;
	/**
	 * 就诊流水号
	 */
	private String code;
	/**
	 * 患者姓名
	 */
	private String name_pat;
	/**
	 * 性别编码
	 */
	private String sd_sex_pat;
	/**
	 * 婚姻状况编码
	 */
	private String sd_mari_pat;
	/**
	 * 出生日期 yyyy-MM-dd 
	 */
	private String dt_birth_pat;
	/**
	 * 联系号码
	 */
	private String telno_pat;
	/**
	 * 现住址详细地址
	 */
	private String addr_pat;
	/**
	 * 现住址区县码
	 */
	private String sd_admdiv_addr;
	/**
	 * 挂号日期    yyyy-MM-dd 00:00:00
	 */
	private String dt_entry;
	/**
	 * 插入记录时间   yyyy-MM-dd hh:mm:ss
	 */
	private String dt_insert;
	/**
	 * 接诊科室id
	 */ 
	private String id_dep_phy;
	/**
	 * 接诊医生id
	 */
	private String id_emp_phy;
	/**
	 * 挂号科室id
	 */
	private String id_dep_reg;
	/**
	 * 挂号医生id
	 */
	private String id_emp_reg;
	/**
	 * 挂号员id
	 */
	private String id_emp_oper;
	/**
	 * 患者分类id
	 */
	private String Id_patca;
	/**
	 * 价格分类id
	 */
	private String Id_pripat;
	/**
	 * 取消标识   Y/N
	 */
	private String fg_canc;
	/**
	 * 取消人员id
	 */
	private String id_emp_canc;
	/**
	 * 取消时间  yyyy-MM-dd hh:mm:ss
	 */
	private String dt_canc; 
	/**
	 * 门诊档案号
	 */
	private String code_amr_oep;
	/**
	 * 挂号号别类型
	 */
	private String sd_srvtp;
	/**
	 * 挂号有效期开始时间 yyyy-MM-dd hh:mm:ss
	 */
	private String dt_valid_b; 
	/**
	 * 挂号有效期结束时间 yyyy-MM-dd hh:mm:ss
	 */
	private String dt_valid_e;
	/**
	 * 排班id
	 */
	private String id_sch;
	/**
	 * 日期分组id
	 */
	private String id_dayslot;
	/**
	 * 排班资源id
	 */
	private String id_scres;
	/**
	 * 排班服务id
	 */
	private String id_scsrv;
	/**
	 * 记账标识  Y/N
	 */
	private String fg_cg;
	/**
	 * 记账id
	 */
	private String id_cg;
	/**
	 * 结算标识  Y/N
	 */
	private String fg_st;

	public String getId_ent() {
		return id_ent;
	}
	public void setId_ent(String id_ent) {
		this.id_ent = id_ent;
	}
	public String getId_grp() {
		return id_grp;
	}
	public void setId_grp(String id_grp) {
		this.id_grp = id_grp;
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
	public String getCode_entp() {
		return code_entp;
	}
	public void setCode_entp(String code_entp) {
		this.code_entp = code_entp;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName_pat() {
		return name_pat;
	}
	public void setName_pat(String name_pat) {
		this.name_pat = name_pat;
	}
	public String getSd_sex_pat() {
		return sd_sex_pat;
	}
	public void setSd_sex_pat(String sd_sex_pat) {
		this.sd_sex_pat = sd_sex_pat;
	}
	public String getSd_mari_pat() {
		return sd_mari_pat;
	}
	public void setSd_mari_pat(String sd_mari_pat) {
		this.sd_mari_pat = sd_mari_pat;
	}
	public String getDt_birth_pat() {
		return dt_birth_pat;
	}
	public void setDt_birth_pat(String dt_birth_pat) {
		this.dt_birth_pat = dt_birth_pat;
	}
	public String getTelno_pat() {
		return telno_pat;
	}
	public void setTelno_pat(String telno_pat) {
		this.telno_pat = telno_pat;
	}
	public String getAddr_pat() {
		return addr_pat;
	}
	public void setAddr_pat(String addr_pat) {
		this.addr_pat = addr_pat;
	}
	public String getSd_admdiv_addr() {
		return sd_admdiv_addr;
	}
	public void setSd_admdiv_addr(String sd_admdiv_addr) {
		this.sd_admdiv_addr = sd_admdiv_addr;
	}
	public String getDt_entry() {
		return dt_entry;
	}
	public void setDt_entry(String dt_entry) {
		this.dt_entry = dt_entry;
	}
	public String getDt_insert() {
		return dt_insert;
	}
	public void setDt_insert(String dt_insert) {
		this.dt_insert = dt_insert;
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
	public String getId_emp_oper() {
		return id_emp_oper;
	}
	public void setId_emp_oper(String id_emp_oper) {
		this.id_emp_oper = id_emp_oper;
	}
	public String getId_patca() {
		return Id_patca;
	}
	public void setId_patca(String id_patca) {
		Id_patca = id_patca;
	}
	public String getId_pripat() {
		return Id_pripat;
	}
	public void setId_pripat(String id_pripat) {
		Id_pripat = id_pripat;
	}
	public String getFg_canc() {
		return fg_canc;
	}
	public void setFg_canc(String fg_canc) {
		this.fg_canc = fg_canc;
	}
	public String getId_emp_canc() {
		return id_emp_canc;
	}
	public void setId_emp_canc(String id_emp_canc) {
		this.id_emp_canc = id_emp_canc;
	}
	public String getDt_canc() {
		return dt_canc;
	}
	public void setDt_canc(String dt_canc) {
		this.dt_canc = dt_canc;
	}
	public String getCode_amr_oep() {
		return code_amr_oep;
	}
	public void setCode_amr_oep(String code_amr_oep) {
		this.code_amr_oep = code_amr_oep;
	}
	public String getSd_srvtp() {
		return sd_srvtp;
	}
	public void setSd_srvtp(String sd_srvtp) {
		this.sd_srvtp = sd_srvtp;
	}
	public String getDt_valid_b() {
		return dt_valid_b;
	}
	public void setDt_valid_b(String dt_valid_b) {
		this.dt_valid_b = dt_valid_b;
	}
	public String getDt_valid_e() {
		return dt_valid_e;
	}
	public void setDt_valid_e(String dt_valid_e) {
		this.dt_valid_e = dt_valid_e;
	}
	public String getId_sch() {
		return id_sch;
	}
	public void setId_sch(String id_sch) {
		this.id_sch = id_sch;
	}
	public String getId_dayslot() {
		return id_dayslot;
	}
	public void setId_dayslot(String id_dayslot) {
		this.id_dayslot = id_dayslot;
	}
	public String getId_scres() {
		return id_scres;
	}
	public void setId_scres(String id_scres) {
		this.id_scres = id_scres;
	}
	public String getId_scsrv() {
		return id_scsrv;
	}
	public void setId_scsrv(String id_scsrv) {
		this.id_scsrv = id_scsrv;
	}
	public String getFg_cg() {
		return fg_cg;
	}
	public void setFg_cg(String fg_cg) {
		this.fg_cg = fg_cg;
	}
	public String getId_cg() {
		return id_cg;
	}
	public void setId_cg(String id_cg) {
		this.id_cg = id_cg;
	}
	public String getFg_st() {
		return fg_st;
	}
	public void setFg_st(String fg_st) {
		this.fg_st = fg_st;
	}
	public String getId_dep_reg() {
		return id_dep_reg;
	}
	public void setId_dep_reg(String id_dep_reg) {
		this.id_dep_reg = id_dep_reg;
	}
	public String getId_emp_reg() {
		return id_emp_reg;
	}
	public void setId_emp_reg(String id_emp_reg) {
		this.id_emp_reg = id_emp_reg;
	}
}
