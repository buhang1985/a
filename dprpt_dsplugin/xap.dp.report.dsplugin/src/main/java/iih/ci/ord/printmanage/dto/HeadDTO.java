package iih.ci.ord.printmanage.dto;

import java.math.BigDecimal;
import java.util.List;

import xap.mw.coreitf.d.FDouble;

public class HeadDTO {
	
	/****************************患者信息****************************************/
	/**
	 * 患者编码
	 */
	private String Id_pat;
	public String getId_pat() {
		return Id_pat;
	}
	public void setId_pat(String id_pat) {
		this.Id_pat = id_pat;
	}
	/**
	 * 患者编码
	 */
	private String Code_pat;
	public String getCode_pat() {
		return Code_pat;
	}
	public void setCode_pat(String code_pat) {
		this.Code_pat = code_pat;
	}
	/**
	 * 部门编码
	 */
	private String Code_org;
	public String getCode_org() {
		return Code_org;
	}
	public void setCode_org(String code_org) {
		this.Code_org = code_org;
	}
	/**
	 * 二维码
	 */
	private String DataMatrix;
	public String getDataMatrix() {
		return DataMatrix;
	}
	public void setDataMatrix(String datamatrix) {
		this.DataMatrix = datamatrix;
	}
	/**
	 * 所属集团
	 */
	private String Name_grp;
	public String getName_grp() {
		return Name_grp;
	}
	public void setName_grp(String name_grp){
		Name_grp = name_grp;
	}
	/**
	 * 所属组织
	 */
	private String Name_org;
	public String getName_org() {
		return Name_org;
	}
	public void setName_org(String name_org){
		Name_org = name_org;
	}
	
	/**
	 * 所属组织英文名称
	 */
	private String Name_org_en;
	public String getName_org_en() {
		return Name_org_en;
	}
	public void setName_org_en(String name_org_en){
		Name_org_en = name_org_en;
	}
	/**
	 * 所属组织简称
	 */
	private String Name_org_short;
	public String getName_org_short() {
		return Name_org_short;
	}
	public void setName_org_short(String name_org_short){
		Name_org_short = name_org_short;
	} 
	/**
	 * 患者姓名
	 */
	private String Id_pati;
	public String getId_pati() {
		return Id_pati;
	}
	public void setId_pati(String id_pati) {
		Id_pati = id_pati;
	}
	private String Name_pati;
	public String getName_pati() {
		return Name_pati;
	}
	public void setName_pati(String name_pati) {
		Name_pati = name_pati;
	}
	/**
	 * 性别
	 */
	private String Gender_code;
	public String getGender_code() {
		return Gender_code;
	}
	public void setGender_code(String gender_code) {
		Gender_code = gender_code;
	}
	private String Gender;
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	/**
	 * 出生日期
	 */
	private String  Dt_birth;
	public String getDt_birth() {
		return Dt_birth;
	}
	public void setDt_birth(String dt_birth) {
		Dt_birth = dt_birth;
	}
	/**
	 * 年龄
	 */
	private String Age;
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	/**
	 * 身份证号
	 */
	private String Idno;
	public String getIdno() {
		return Idno;
	}
	public void setIdno(String idno) {
		Idno = idno;
	}
	/**
	 * 电话
	 */
	private String Pat_tel;
	public String getPat_tel() {
		return Pat_tel;
	}
	public void setPat_tel(String pat_tel) {
		Pat_tel = pat_tel;
	}
	/**
	 * 工作单位
	 */
	private String  Workunit;
	public String getWorkunit() {
		return Workunit;
	}
	public void setWorkunit(String workunit) {
		Workunit = workunit;
	}
	/**
	 * 代办人
	 */
	private String  Psn_agent;
	public String getPsn_agent() {
		return Psn_agent;
	}
	public void setPsn_agent(String psn_agent) {
		Psn_agent = psn_agent;
	}
	/**
	 * 代办人身份证号
	 */
	private String  Idno_agent;
	public String getIdno_agent() {
		return Idno_agent;
	}
	public void setIdno_agent(String idno_agent) {
		Idno_agent = idno_agent;
	}
	
	/******************************患者就诊信息***************************************/
	/**
	 * 就诊ID
	 */
	private String Id_en;
	public String getId_en() {
		return Id_en;
	}
	public void setId_en(String id_en) {
		Id_en = id_en;
	}
	/**
	 * 就诊类型
	 */
	private String  Code_entp;
	public String getCode_entp() {
		return Code_entp;
	}
	public void setCode_entp(String code_entp) {
		Code_entp = code_entp;
	}
	/**
	 * 病历号
	 */
	private String Code_amr_oep;
	public String getCode_amr_oep() {
		return Code_amr_oep;
	}
	public void setCode_amr_oep(String code_amr_oep) {
		Code_amr_oep = code_amr_oep;
	}
	/**
	 * 条形码（就诊号）
	 */
	private String Barcode;
	public String getBarcode() {
		return Barcode;
	}
	public void setBarcode(String barcode) {
		Barcode = barcode;
	}
	/**
	 * 医保号
	 */
	private String HpCode;
	public String getHpCode(){
		return HpCode;
	}
	public void setHpCode(String hpCode) {
		HpCode = hpCode;
	}
	/**
	 * 患者就诊卡卡号
	 */
	private String PiCardCode;
	public String getPiCardCode(){
		return PiCardCode;
	}
	public void setPiCardCode(String piCardCode) {
		PiCardCode = piCardCode;
	}
	/**
	 * 诊断名称拼接
	 */
	private String Str_name_di;
	public String getStr_name_di() {
		return Str_name_di;
	}
	public void setStr_name_di(String str_name_di) {
		Str_name_di = str_name_di;
	}
	/**
	 * 就诊次数
	 */
	private Integer Num_pv;
	public Integer getNum_pv() {
		return Num_pv;
	}
	public void setNum_pv(Integer num_pv) {
		Num_pv = num_pv;
	}
	/**
	 * 过敏史
	 */
	private String Des_alcla;
	public String getDes_alcla() {
		return Des_alcla;
	}
	public void setDes_alcla(String des_alcla) {
		Des_alcla = des_alcla;
	}
	/**
	 * 特需门诊标识
	 */
	private String Fg_special;
	public String getFg_special() {
		return Fg_special;
	}
	public void setFg_special(String fg_special) {
		Fg_special = fg_special;
	}
	/**
	 * 医保标识
	 */
	private String Fg_orhp;
	public String getFg_orhp() {
		return Fg_orhp;
	}
	public void setFg_orhp(String fg_orhp) {
		Fg_orhp = fg_orhp;
	}
	/**
	 * 商保持卡记账标识
	 */
	private String Fg_hecominsur;
	public String getFg_hecominsur() {
		return Fg_hecominsur;
	}
	public void setFg_hecominsur(String fg_hecominsur) {
		Fg_hecominsur = fg_hecominsur;
	}
	/**
	 * 高端商保信息
	 */
	private String Hecominsurinfo;
	public String getHecominsurinfo() {
		return Hecominsurinfo;
	}
	public void setHecominsurinfo(String hecominsurinfo) {
		Hecominsurinfo = hecominsurinfo;
	}
	/**
	 * 医保生育标识
	 */
	private String Fg_hpbirth;
	public String getFg_hpbirth() {
		return Fg_hpbirth;
	}
	public void setFg_hpbirth(String fg_hpbirth) {
		Fg_hpbirth = fg_hpbirth;
	}
	/**
	 * VIP标识
	 */
	private String Fg_vip;
	public String getFg_vip() {
		return Fg_vip;
	}
	public void setFg_vip(String fg_vip) {
		Fg_vip = fg_vip;
	}
	/**
	 * 预付费记账标识
	 */
	private String Fg_prepay;
	public String getFg_prepay() {
		return Fg_prepay;
	}
	public void setFg_prepay(String fg_prepay) {
		Fg_prepay = fg_prepay;
	}
	/**
	 * 科研项目名称
	 */
	private String Name_research;
	public String getName_research() {
		return Name_research;
	}
	public void setName_research(String name_research) {
		Name_research = name_research;
	}
	/**
	 * 结算标识
	 */
	private String Fg_blsettled;
	public String getFg_blsettled() {
		return Fg_blsettled;
	}
	public void setFg_blsettled(String fg_blsettled) {
		Fg_blsettled = fg_blsettled;
	}
	/**
	 * 特殊病标识
	 */
	private String Fg_specill;
	public String getFg_specill() {
		return Fg_specill;
	}
	public void setFg_specill(String fg_specill) {
		Fg_specill = fg_specill;
	}
	/**
	 * 导引信息
	 */
	private String Guidance;
	public String getGuidance(){
		return Guidance;
	}
	public void setGuidance(String guidance){
		Guidance = guidance;
	}
	/**
	 * 科室地点
	 */
	private String address;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	/******************************患者住院信息***************************************/
	/**
	 * 病区   
	 */
	private String Unit;
	public String getUnit() {
		return Unit;
	}
	public void setUnit(String unit) {
		Unit = unit;
	}
	/**
	 * 病床号
	 */
	private String Bed_num;
	public String getBed_num() {
		return Bed_num;
	}
	public void setBed_num(String bed_num) {
		Bed_num = bed_num;
	}
	
	/******************************申请单信息*************************************/
	/**
	 * 服务类型
	 */
	private String Sd_srvtp;
	public String getSd_srvtp() {
		return Sd_srvtp;
	}
	public void setSd_srvtp(String sd_srvtp) {
		Sd_srvtp = sd_srvtp;
	}
	/**
	 * 申请单号
	 */
	private String Code;
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	/**
	 * 开立科室
	 */
	private String Name_dep_or;
	public String getName_dep_or() {
		return Name_dep_or;
	}
	public void setName_dep_or(String name_dep_or) {
		Name_dep_or = name_dep_or;
	}
	/**
	 * 开立医生
	 */
	private String Name_emp_or;
	public String getName_emp_or() {
		return Name_emp_or;
	}
	public void setName_emp_or(String name_emp_or) {
		Name_emp_or = name_emp_or;
	}
	/**
	 * 开立日期
	 */
	private String Dt_entry;
	public String getDt_entry() {
		return Dt_entry;
	}
	public void setDt_entry(String dt_entry) {
		Dt_entry = dt_entry;
	}
	/**
	 * 执行科室
	 */
	private String Name_mp_dep;
	public String getName_mp_dep() {
		return Name_mp_dep;
	}
	public void setName_mp_dep(String name_mp_dep) {
		Name_mp_dep = name_mp_dep;
	}
	/**
	 * 总金额
	 */
	private FDouble Amt_total;
	public FDouble getAmt_total() {
		return Amt_total;
	}
	public void setAmt_total(FDouble amt_total) {
		Amt_total = amt_total.setScale(-2, BigDecimal.ROUND_HALF_UP);
	}
	/**
	 * 打印日期
	 */
	private String Dt_print;
	public String getDt_print() {
		return Dt_print;
	}
	public void setDt_print(String dt_print) {
		Dt_print = dt_print;
	}
	/**
	 * 注意事项
	 */
	private String Announcements;
	public String getAnnouncements() {
		return Announcements;
	}
	public void setAnnouncements(String announcements) {
		Announcements = announcements;
	}
	
	/**
	 * 注意事项：地点
	 */
	private String PlaceNOTICE;
	/**
	 * 注意事项:患者
	 */
	private String PatNOTICE;
	/**
	 * 注意事项：手机
	 */
	private String PhoneNOTICE;
	public String getPlaceNOTICE() {
		return PlaceNOTICE;
	}
	public void setPlaceNOTICE(String placeNOTICE) {
		PlaceNOTICE = placeNOTICE;
	}
	public String getPatNOTICE() {
		return PatNOTICE;
	}
	public void setPatNOTICE(String patNOTICE) {
		PatNOTICE = patNOTICE;
	}
	public String getPhoneNOTICE() {
		return PhoneNOTICE;
	}
	public void setPhoneNOTICE(String phoneNOTICE) {
		PhoneNOTICE = phoneNOTICE;
	}
	/******************************检验申请单信息*************************************/
	/**
	 * 检验申请单ID
	 */
	private String Id_ciapplissheet;
	public String getId_ciapplissheet() {
		return Id_ciapplissheet;
	}
	public void setId_ciapplissheet(String id_ciapplissheet) {
		Id_ciapplissheet = id_ciapplissheet;
	}
	/**
	 * 标本采集时间
	 */
	private String Name_sampcoltime;
	public String getName_sampcoltime() {
		return Name_sampcoltime;
	}
	public void setName_sampcoltime(String name_sampcoltime) {
		Name_sampcoltime = name_sampcoltime;
	}
	/**
	 * 标本采集时间类型
	 */
	private String Sd_sampcollecttimetp;
	public String getSd_sampcollecttimetp() {
		return Sd_sampcollecttimetp;
	}
	public void setSd_sampcollecttimetp(String sd_sampcollecttimetp) {
		Sd_sampcollecttimetp = sd_sampcollecttimetp;
	}
	/**
	 * 项目DO集合
	 */
	private List<ItemDTO> Itemdtolist;
	public List<ItemDTO> getItemdtolist() {
		return Itemdtolist;
	}
	public void setItemdtolist(List<ItemDTO> itemdtolist) {
		this.Itemdtolist = itemdtolist;
	}
	
	/******************************检查申请单信息*************************************/
	/**
	 * 检查申请单ID
	 */
	private String Id_ciapprissheet;
	public String getId_ciapprissheet() {
		return Id_ciapprissheet;
	}
	public void setId_ciapprissheet(String id_ciapprissheet) {
		Id_ciapprissheet = id_ciapprissheet;
	}
	/**
	 * 医嘱ID
	 */
	private String Id_or;
	public String getId_or() {
		return Id_or;
	}
	public void setId_or(String id_or) {
		Id_or = id_or;
	}
	/**
	 * 检查分类名称
	 */
	private String Name_srvca;
	public String getName_srvca() {
		return Name_srvca;
	}
	public void setName_srvca(String name_srvca) {
		Name_srvca = name_srvca;
	}
	/**
	 *  服务类型名称
	 */
	private String Name_srvtp;
	public String getName_srvtp() {
		return Name_srvtp;
	}
	public void setName_srvtp(String name_srvtp) {
		Name_srvtp = name_srvtp;
	}
	/**
	 * 服务名称
	 */
	private String Name_srv;
	public String getName_srv() {
		return Name_srv;
	}
	public void setName_srv(String name_srv) {
		Name_srv = name_srv;
	}
	/**
	 * 	服务名称（不加身体部位）
	 */
	private String Name_srv_ignore;
	public String getName_srv_ignore() {
		return Name_srv_ignore;
	}
	public void setName_srv_ignore(String name_srv_ignore) {
		Name_srv_ignore = name_srv_ignore;
	}
	/**
	 * 服务套标识
	 */
	private String Fg_set;
	public String getFg_set() {
		return Fg_set;
	}
	public void setFg_set(String fg_set) {
		Fg_set = fg_set;
	}
	/**
	 * 检查申请单号
	 */
	private String No_applyform;
	public String getNo_applyform() {
		return No_applyform;
	}
	public void setNo_applyform(String no_applyform) {
		No_applyform = no_applyform;
	}
	/**
	 * 加急标识
	 */
	private String Fg_urgent;
	public String getFg_urgent() {
		return Fg_urgent;
	}
	public void setFg_urgent(String fg_urgent) {
		Fg_urgent = fg_urgent;
	}
	/**
	 * 检查目的名称
	 */
	private String Name_pps;
	public String getName_pps() {
		return Name_pps;
	}
	public void setName_pps(String name_pps) {
		Name_pps = name_pps;
	}
	/**
	 * 检查目的描述	
	 */
	private String Des_pps;
	public String getDes_pps() {
		return Des_pps;
	}
	public void setDes_pps(String des_pps) {
		Des_pps = des_pps;
	}
	/**
	 * 检查组织描述
	 */
	private String Biopsy;
	public String getBiopsy() {
		return Biopsy;
	}
	public void setBiopsy(String biopsy) {
		this.Biopsy = biopsy;
	}
	/**
	 * 病情描述
	 */
	private String Des_sympsign;
	public String getDes_sympsign() {
		return Des_sympsign;
	}
	public void setDes_sympsign(String des_sympsign) {
		Des_sympsign = des_sympsign;
	}
	/**
	 * 临床症状及体征
	 */
	private String Clinicalzztz;
	public String getClinicalzztz() {
		return Clinicalzztz;
	}
	public void setClinicalzztz(String clinicalzztz) {
		this.Clinicalzztz = clinicalzztz;
	}
	/**
	 * 既往病史
	 */
	private String Pastillness;
	public String getPastillness() {
		return Pastillness;
	}
	public void setPastillness(String pastillness) {
		this.Pastillness = pastillness;
	}
	/**
	 * 其它检查所见
	 */
	private String Auximtexam;
	public String getAuximtexam() {
		return Auximtexam;
	}
	public void setAuximtexam(String auximtexam) {
		this.Auximtexam = auximtexam;
	}
	/**
	 * 计划执行时间
	 */
	private String Dt_plan;
	public String getDt_plan() {
		return Dt_plan;
	}
	public void setDt_plan(String dt_plan) {
		Dt_plan = dt_plan;
	}
	
	/******************************治疗申请单信息*************************************/
	/**
	 * 医疗计量单位
	 */
	private String Name_medu;
	public String getName_medu(){
		return Name_medu;
	}
	public void setName_medu(String name_medu) {
		Name_medu = name_medu;
	}
	/**
	 * 执行次数
	 */
	private String Times_cur;
	public String getTimes_cur(){
		return Times_cur;
	}
	public void setTimes_cur(String times_cur){
		Times_cur = times_cur;
	}
	
	/******************************病理申请单信息*************************************/
	/**
	 * 病理打印申请单ID
	 */
	protected String Id_ciapppathgysheet;
	public String getId_ciapppathgysheet() {
		return Id_ciapppathgysheet;
	}
	public void setId_ciapppathgysheet(String id_ciapppathgysheet) {
		Id_ciapppathgysheet = id_ciapppathgysheet;
	}
	/**
	 * 病理申请单ID
	 */
//	protected String Id_appathgy;
//	public String getId_appathgy() {
//		return Id_appathgy;
//	}
//	public void setId_appathgy(String id_appathgy) {
//		Id_appathgy = id_appathgy;
//	}
	/**
	 * 病理号
	 */
	protected String No_pathgy;
	public String getNo_pathgy() {
		return No_pathgy;
	}
	public void setNo_pathgy(String no_pathgy) {
		No_pathgy = no_pathgy;
	}
	/**
	 * 标本类型ID
	 */
	protected String Id_samptp;
	public String getId_samptp() {
		return Id_samptp;
	}
	public void setId_samptp(String id_samptp) {
		Id_samptp = id_samptp;
	}
	/**
	 * 标本类型编码
	 */
	protected String Sd_samptp;
	public String getSd_samptp() {
		return Sd_samptp;
	}
	public void setSd_samptp(String sd_samptp) {
		Sd_samptp = sd_samptp;
	}
	/**
	 * 标本类型名称
	 */
	protected String Name_samptp;
	public String getName_samptp() {
		return Name_samptp;
	}
	public void setName_samptp(String name_samptp) {
		Name_samptp = name_samptp;
	}
	/**
	 * 标本数量
	 */
	protected FDouble Quan_coll;
	public FDouble getQuan_coll() {
		return Quan_coll;
	}
	public void setQuan_coll(FDouble quan_coll) {
		Quan_coll = quan_coll;
	}
	/**
	 * 标本采集方法ID
	 */
	protected String Id_colltp;
	public String getId_colltp() {
		return Id_colltp;
	}
	public void setId_colltp(String id_colltp) {
		Id_colltp = id_colltp;
	}
	/**
	 * 标本采集方法编码
	 */
	protected String Sd_colltp;
	public String getSd_colltp() {
		return Sd_colltp;
	}
	public void setSd_colltp(String sd_colltp) {
		Sd_colltp = sd_colltp;
	}
	/**
	 * 标本说明
	 */
	protected String Des_labsamp;
	public String getDes_labsamp() {
		return Des_labsamp;
	}
	public void setDes_labsamp(String des_labsamp) {
		Des_labsamp = des_labsamp;
	}
	/**
	 * 采集所见
	 */
	protected String Collectdes;
	public String getCollectdes() {
		return Collectdes;
	}
	public void setCollectdes(String collectdes) {
		Collectdes = collectdes;
	}
	/**
	 * 采集者
	 */
	protected String Name_emp_coll;
	public String getName_emp_coll() {
		return Name_emp_coll;
	}
	public void setName_emp_coll(String name_emp_coll) {
		Name_emp_coll = name_emp_coll;
	}
	/**
	 * 采集科室
	 */
	protected String Name_dep_coll;
	public String getName_dep_coll() {
		return Name_dep_coll;
	}
	public void setName_dep_coll(String name_dep_coll) {
		Name_dep_coll = name_dep_coll;
	}
	/**
	 * 采集时间
	 */
	protected String Dt_coll;
	public String getDt_coll() {
		return Dt_coll;
	}
	public void setDt_coll(String dt_coll) {
		Dt_coll = dt_coll;
	}
	/**
	 * 报告发布时间
	 */
	protected String Dt_rptpathgy;
	public String getDt_rptpathgy() {
		return Dt_rptpathgy;
	}
	public void setDt_rptpathgy(String dt_rptpathgy) {
		Dt_rptpathgy = dt_rptpathgy;
	}	
	/**
	 * 外院标识
	 */
	protected String Fg_outer;
	public String getFg_outer() {
		return Fg_outer;
	}
	public void setFg_outer(String fg_outer) {
		Fg_outer = fg_outer;
	}
	/**
	 * 既往病理号
	 */
	protected String No_pathgy_old;
	public String getNo_pathgy_old() {
		return No_pathgy_old;
	}
	public void setNo_pathgy_old(String no_pathgy_old) {
		No_pathgy_old = no_pathgy_old;
	}
	/**
	 * 既往检查日期
	 */
	protected String Dt_pathgy_old;
	public String getDt_pathgy_old() {
		return Dt_pathgy_old;
	}
	public void setDt_pathgy_old(String dt_pathgy_old) {
		Dt_pathgy_old = dt_pathgy_old;
	}
	/**
	 * 既往检查诊断
	 */
	protected String Di_pathgy_old;
	public String getDi_pathgy_old() {
		return Di_pathgy_old;
	}
	public void setDi_pathgy_old(String di_pathgy_old) {
		Di_pathgy_old = di_pathgy_old;
	}
	/**
	 * 加急标识
	 */
	protected String Org_pathgy_old;
	public String getOrg_pathgy_old() {
		return Org_pathgy_old;
	}
	public void setOrg_pathgy_old(String org_pathgy_old) {
		Org_pathgy_old = org_pathgy_old;
	}
	
	/**
	 * 住院号(郑州骨伤 需求)
	 */
	protected String Code_amr_ip;
	public String getCode_amr_ip() {
		return Code_amr_ip;
	}
	public void setCode_amr_ip(String code_amr_ip) {
		Code_amr_ip = code_amr_ip;
	}
	

	/******************************客户拓展字段*************************************/
	public String Def1;//客户扩展字段1
	public String Def2;//客户扩展字段2
	public String Def3;//客户扩展字段3
	public String Def4;//客户扩展字段4
	public String Def5;//客户扩展字段5
	public String Def6;//客户扩展字段6
	public String Def7;//客户扩展字段7
	public String Def8;//客户扩展字段8
	public String Def9;//客户扩展字段9
	public String Def10;//客户扩展字段10
	public String Def11;//客户扩展字段11
	public String Def12;//客户扩展字段12
	public String Def13;//客户扩展字段13
	public String Def14;//客户扩展字段14
	public String Def15;//客户扩展字段15
	public String Def16;//客户扩展字段16
	public String Def17;//客户扩展字段17
	public String Def18;//客户扩展字段18
	public String Def19;//客户扩展字段19
	public String Def20;//客户扩展字段20
	public String Def21;//客户扩展字段21
	public String Def22;//客户扩展字段22
	public String Def23;//客户扩展字段23
	public String Def24;//客户扩展字段24
	public String Def25;//客户扩展字段25
	public String Def26;//客户扩展字段26
	public String Def27;//客户扩展字段27
	public String Def28;//客户扩展字段28
	public String Def29;//客户扩展字段29
	public String Def30;//客户扩展字段30
	public String Def31;//客户扩展字段31
	public String Def32;//客户扩展字段32
	public String Def33;//客户扩展字段33
	public String Def34;//客户扩展字段34
	public String Def35;//客户扩展字段35
	public String Def36;//客户扩展字段36
	public String Def37;//客户扩展字段37
	public String Def38;//客户扩展字段38
	public String Def39;//客户扩展字段39
	public String Def40;//客户扩展字段40
	public String Def41;//客户扩展字段41
	public String Def42;//客户扩展字段42
	public String Def43;//客户扩展字段43
	public String Def44;//客户扩展字段44
	public String Def45;//客户扩展字段45
	public String Def46;//客户扩展字段46
	public String Def47;//客户扩展字段47
	public String Def48;//客户扩展字段48
	public String Def49;//客户扩展字段49
	public String Def50;//客户扩展字段50

	public String getDef1() {
		return Def1;
	}
	public void setDef1(String def1) {
		this.Def1 = def1;
	}
	public String getDef2() {
		return Def2;
	}
	public void setDef2(String def2) {
		this.Def2 = def2;
	}
	public String getDef3() {
		return Def3;
	}
	public void setDef3(String def3) {
		this.Def3 = def3;
	}
	public String getDef4() {
		return Def4;
	}
	public void setDef4(String def4) {
		this.Def4 = def4;
	}
	public String getDef5() {
		return Def5;
	}
	public void setDef5(String def5) {
		this.Def5 = def5;
	}
	public String getDef6() {
		return Def6;
	}
	public void setDef6(String def6) {
		this.Def6 = def6;
	}
	public String getDef7() {
		return Def7;
	}
	public void setDef7(String def7) {
		this.Def7 = def7;
	}
	public String getDef8() {
		return Def8;
	}
	public void setDef8(String def8) {
		this.Def8 = def8;
	}
	public String getDef9() {
		return Def9;
	}
	public void setDef9(String def9) {
		this.Def9 = def9;
	}
	public String getDef10() {
		return Def10;
	}
	public void setDef10(String def10) {
		this.Def10 = def10;
	}
	public String getDef11() {
		return Def11;
	}
	public void setDef11(String def11) {
		this.Def11 = def11;
	}
	public String getDef12() {
		return Def12;
	}
	public void setDef12(String def12) {
		this.Def12 = def12;
	}
	public String getDef13() {
		return Def13;
	}
	public void setDef13(String def13) {
		this.Def13 = def13;
	}
	public String getDef14() {
		return Def14;
	}
	public void setDef14(String def14) {
		this.Def14 = def14;
	}
	public String getDef15() {
		return Def15;
	}
	public void setDef15(String def15) {
		this.Def15 = def15;
	}
	public String getDef16() {
		return Def16;
	}
	public void setDef16(String def16) {
		this.Def16 = def16;
	}
	public String getDef17() {
		return Def17;
	}
	public void setDef17(String def17) {
		this.Def17 = def17;
	}
	public String getDef18() {
		return Def18;
	}
	public void setDef18(String def18) {
		this.Def18 = def18;
	}
	public String getDef19() {
		return Def19;
	}
	public void setDef19(String def19) {
		this.Def19 = def19;
	}
	public String getDef20() {
		return Def20;
	}
	public void setDef20(String def20) {
		this.Def20 = def20;
	}
	public String getDef21() {
		return Def21;
	}
	public void setDef21(String def21) {
		this.Def21 = def21;
	}
	public String getDef22() {
		return Def22;
	}
	public void setDef22(String def22) {
		this.Def22 = def22;
	}
	public String getDef23() {
		return Def23;
	}
	public void setDef23(String def23) {
		this.Def23 = def23;
	}
	public String getDef24() {
		return Def24;
	}
	public void setDef24(String def24) {
		this.Def24 = def24;
	}
	public String getDef25() {
		return Def25;
	}
	public void setDef25(String def25) {
		this.Def25 = def25;
	}
	public String getDef26() {
		return Def26;
	}
	public void setDef26(String def26) {
		this.Def26 = def26;
	}
	public String getDef27() {
		return Def27;
	}
	public void setDef27(String def27) {
		this.Def27 = def27;
	}
	public String getDef28() {
		return Def28;
	}
	public void setDef28(String def28) {
		this.Def28 = def28;
	}
	public String getDef29() {
		return Def29;
	}
	public void setDef29(String def29) {
		this.Def29 = def29;
	}
	public String getDef30() {
		return Def30;
	}
	public void setDef30(String def30) {
		this.Def30 = def30;
	}
	public String getDef31() {
		return Def31;
	}
	public void setDef31(String def31) {
		this.Def31 = def31;
	}
	public String getDef32() {
		return Def32;
	}
	public void setDef32(String def32) {
		this.Def32 = def32;
	}
	public String getDef33() {
		return Def33;
	}
	public void setDef33(String def33) {
		this.Def33 = def33;
	}
	public String getDef34() {
		return Def34;
	}
	public void setDef34(String def34) {
		this.Def34 = def34;
	}
	public String getDef35() {
		return Def35;
	}
	public void setDef35(String def35) {
		this.Def35 = def35;
	}
	public String getDef36() {
		return Def36;
	}
	public void setDef36(String def36) {
		this.Def36 = def36;
	}
	public String getDef37() {
		return Def37;
	}
	public void setDef37(String def37) {
		this.Def37 = def37;
	}
	public String getDef38() {
		return Def38;
	}
	public void setDef38(String def38) {
		this.Def38 = def38;
	}
	public String getDef39() {
		return Def39;
	}
	public void setDef39(String def39) {
		this.Def39 = def39;
	}
	public String getDef40() {
		return Def40;
	}
	public void setDef40(String def40) {
		this.Def40 = def40;
	}
	public String getDef41() {
		return Def41;
	}
	public void setDef41(String def41) {
		this.Def41 = def41;
	}
	public String getDef42() {
		return Def42;
	}
	public void setDef42(String def42) {
		this.Def42 = def42;
	}
	public String getDef43() {
		return Def43;
	}
	public void setDef43(String def43) {
		this.Def43 = def43;
	}
	public String getDef44() {
		return Def44;
	}
	public void setDef44(String def44) {
		this.Def44 = def44;
	}
	public String getDef45() {
		return Def45;
	}
	public void setDef45(String def45) {
		this.Def45 = def45;
	}
	public String getDef46() {
		return Def46;
	}
	public void setDef46(String def46) {
		this.Def46 = def46;
	}
	public String getDef47() {
		return Def47;
	}
	public void setDef47(String def47) {
		this.Def47 = def47;
	}
	public String getDef48() {
		return Def48;
	}
	public void setDef48(String def48) {
		this.Def48 = def48;
	}
	public String getDef49() {
		return Def49;
	}
	public void setDef49(String def49) {
		this.Def49 = def49;
	}
	public String getDef50() {
		return Def50;
	}
	public void setDef50(String def50) {
		this.Def50 = def50;
	}
}
