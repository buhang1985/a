package iih.dg.ord.printmanage.srv.d;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import xap.mw.coreitf.d.FDouble;

/**
 * 医嘱处方 DTO数据 
 * 
 */
public class OrdPresDTO {
	
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
	 * 打印时间
	 */
	private String dt_print;
	public String getDt_print() {
		return dt_print;
	}
	public void setDt_print(String dt_print) {
		this.dt_print = dt_print;
	}
	/**
	 * 发药人
	 */
	private String Name_Pils;

	public String getName_Pils() {
		return Name_Pils;
	}
	public void setName_Pils(String name_Pils) {
		Name_Pils = name_Pils;
	}
	/**
	 * 处方字： by gh  2018年7月10日
	 */
	private String Name_prestpword;
	public String getName_prestpword() {
		return Name_prestpword;
	}
	public void setName_prestpword(String name_prestpword) {
		Name_prestpword = name_prestpword;
	}
	/****************************患者信息****************************************/
	/**
	 * 所属集团
	 */
	private String Id_grp;
	public String getId_grp() {
		return Id_grp;
	}
	public void setId_grp(String id_grp) {
		Id_grp = id_grp;
	}
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
	private String Id_org;
	public String getId_org() {
		return Id_org;
	}
	public void setId_org(String id_org) {
		Id_org = id_org;
	}
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
	private String  Gender;
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
	private String  Age;
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	/**
	 * 证件名称
	 */
	private String Name_card;
	public String getName_card(){
		return Name_card;
	}
	public void setName_card(String name_card) {
		Name_card = name_card;
	}
	/**
	 * 身份证号
	 */
	private String  Idno;
	public String getIdno() {
		return Idno;
	}
	public void setIdno(String idno) {
		Idno = idno;
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
	/**
	 * 代办人证件名称
	 */
	private String Name_card_agent;
	public String getName_card_agent(){
		return Name_card_agent;
	}
	public void setName_card_agent(String name_card_agent) {
		Name_card_agent = name_card_agent;
	}
	/**
	 * 定点医疗机构编码
	 */
	private String Regnum_org;
	public String getRegnum_org(){
		return Regnum_org;
	}
	public void setRegnum_org(String regnum_org) {
		Regnum_org = regnum_org;
	}
	/**
	 * 婴儿体重
	 */
	private String Weight_baby;
	public String getWeight_baby() {
		return Weight_baby;
	}
	public void setWeight_baby(String weight_baby) {
		Weight_baby = weight_baby;
	}
	/**
	 * 电话
	 */
	private String mobile;
	/**
	 * 区县
	 */
	private String county;
	/**
	 * 地址
	 */
	private String address;
	
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	 * 就诊时间
	 */
	private String Dt_acpt;
	public String getDt_acpt() {
		return Dt_acpt;
	}
	public void setDt_acpt(String dt_acpt) {
		Dt_acpt = dt_acpt;
	}
	/**注射治疗单id_en被code占用 添加id_ent
	 * 就诊ID
	 */
	private String Id_ent;
	public String getId_ent() {
		return Id_ent;
	}
	public void setId_ent(String id_ent) {
		Id_ent = id_ent;
	}
	/**
	 * 初诊复诊
	 */
	private String Fg_first;
	public String getFg_first() {
		return Fg_first;
	}
	public void seFg_first(String fg_first) {
		Patca = fg_first;
	}
	/**
	 * 患者类型  （自费医保）
	 */
	private String Patca;
	public String getPatca() {
		return Patca;
	}
	public void setPatca(String patca) {
		Patca = patca;
	}
	/**
	 * 就诊类型
	 */
	private String Id_entp;
	public String getId_entp() {
		return Id_entp;
	}
	public void setId_entp(String id_entp) {
		Id_entp = id_entp;
	}
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
	private String  Barcode;
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
	 * 就诊号
	 */
	private String Code_en;
	public String getCode_en() {
		return Code_en;
	}
	public void setCode_en(String code_en) {
		Code_en = code_en;
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
	private Integer  Num_pv;
	public Integer getNum_pv() {
		return Num_pv;
	}
	public void setNum_pv(Integer num_pv) {
		Num_pv = num_pv;
	}
	/**
	 * 过敏史
	 */
	private String  Des_alcla;
	public String getDes_alcla() {
		return Des_alcla;
	}
	public void setDes_alcla(String des_alcla) {
		Des_alcla = des_alcla;
	}
	/**
	 * 医保编码
	 */
	private String Sd_hptp;
	public String getSd_hptp() {
		return Sd_hptp;
	}
	public void setSd_hptp(String sd_hptp) {
		Sd_hptp = sd_hptp;
	}
	/**
	 * 患者费别
	 */
	private String Name_patica;
	public String getName_patica() {
		return Name_patica;
	}
	public void setName_patica(String name_patica) {
		Name_patica = name_patica;
	}
	/**
	 * 特殊病标识
	 */
	private String Fg_special;
	public String getFg_special() {
		return Fg_special;
	}
	public void setFg_special(String fg_special) {
		Fg_special = fg_special;
	}
	/**
	 * 特需门诊标识
	 */
	private String Fg_opspecial;
	public String getFg_opspecial() {
		return Fg_opspecial;
	}
	public void setFg_opspecial(String fg_opspecial) {
		Fg_opspecial = fg_opspecial;
	}
	/**
	 * 基数药标识
	 */
	private String Fg_base;
	public String getFg_base() {
		return Fg_base;
	}
	public void setFg_base(String fg_base) {
		Fg_base = fg_base;
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
	
	/**责任医生
	 */
	private String Id_emp_phy;
	public String getId_emp_phy() {
		return Id_emp_phy;
	}
	public void setId_emp_phy(String id_emp_phy) {
		Id_emp_phy = id_emp_phy;
	}
	private String Sd_emp_phy;
	public String getSd_emp_phy() {
		return Sd_emp_phy;
	}
	public void setSd_emp_phy(String sd_emp_phy) {
		Sd_emp_phy = sd_emp_phy;
	}
	
	/**
	 * 责任护士
	 */
	private String Id_emp_nur;
	public String getId_emp_nur() {
		return Id_emp_nur;
	}
	public void setId_emp_nur(String id_emp_nur) {
		Id_emp_nur = id_emp_nur;
	}
	private String Sd_emp_nur;
	public String getSd_emp_nur() {
		return Sd_emp_nur;
	}
	public void setSd_emp_nur(String sd_emp_nur) {
		Sd_emp_nur = sd_emp_nur;
	}
	
	/**
	 * 调剂员
	 */
	private String Id_dispensing_nurse;
	public String getId_dispensing_nurse() {
		return Id_dispensing_nurse;
	}
	public void setId_dispensing_nurse(String id_dispensing_nurse) {
		Id_dispensing_nurse = id_dispensing_nurse;
	}
	
	/******************************发票信息*************************************/
	/**
	 * 发票号
	 */
	private String Incno;
	public String getIncno() {
		return Incno;
	}
	public String getCode_st() {
		return Code_st;
	}
	/**
	 * 结算号
	 */
	private String Code_st;
	public void setIncno(String incno) {
		Incno = incno;
	}
	public void setCode_st(String code_st) {
		Code_st = code_st;
	}
	
	/******************************处方信息*************************************/
	/**
	 * 处方ID
	 */
	private String Id_pres;
	public String getId_pres() {
		return Id_pres;
	}
	public void setId_pres(String id_pres) {
		Id_pres = id_pres;
	}
	/**
	 * 服务类型
	 */
	private String Id_srvtp;
	public String getId_srvtp() {
		return Id_srvtp;
	}
	public void setId_srvtp(String id_srvtp) {
		Id_srvtp = id_srvtp;
	}
	
	private String Sd_srvtp;
	public String getSd_srvtp() {
		return Sd_srvtp;
	}
	public void setSd_srvtp(String sd_srvtp) {
		Sd_srvtp = sd_srvtp;
	}
	/**
	 * 处方类型
	 */
	private String Id_prestp;
	public String getId_prestp() {
		return Id_prestp;
	}
	public void setId_prestp(String id_prestp) {
		Id_prestp = id_prestp;
	}
	private String Sd_prestp;
	public String getSd_prestp() {
		return Sd_prestp;
	}
	public void setSd_prestp(String sd_prestp) {
		Sd_prestp = sd_prestp;
	}
	private String Name_prestp;
	public String getName_prestp() {
		return Name_prestp;
	}
	public void setName_prestp(String name_prestp) {
		Name_prestp = name_prestp;
	}
	/**
	 * 处方号
	 */
	private String Code;
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	
	/**
	 * 处方名称
	 */
	private String Name;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	/**
	 * 开立科室
	 */
	private String  Id_dep_or;public String getId_dep_or() {
		return Id_dep_or;
	}
	public void setId_dep_or(String id_dep_or) {
		Id_dep_or = id_dep_or;
	}
	private String  Name_dep_or;
	public String getName_dep_or() {
		return Name_dep_or;
	}
	public void setName_dep_or(String name_dep_or) {
		Name_dep_or = name_dep_or;
	}
	/**
	 * 开立医生
	 */
	private String  Id_emp_or;
	public String getId_emp_or() {
		return Id_emp_or;
	}
	public void setId_emp_or(String id_emp_or) {
		Id_emp_or = id_emp_or;
	}
	
	private String  Name_emp_or;
	public String getName_emp_or() {
		return Name_emp_or;
	}
	public void setName_emp_or(String name_emp_or) {
		Name_emp_or = name_emp_or;
	}
	/**
	 * 开立日期
	 */
	private String  Dt_entry;
	public String getDt_entry() {
		return Dt_entry;
	}
	public void setDt_entry(String dt_entry) {
		Dt_entry = dt_entry;
	}
	/**
	 * 执行科室
	 */
	private String  Id_dep_mp;
	public String getId_dep_mp() {
		return Id_dep_mp;
	}
	public void setId_dep_mp(String id_dep_mp) {
		Id_dep_mp = id_dep_mp;
	}
	
	private String  Name_dep_mp;
	public String getName_dep_mp() {
		return Name_dep_mp;
	}
	public void setName_dep_mp(String name_dep_mp) {
		Name_dep_mp = name_dep_mp;
	}
	/**
	 * 取药窗口号
	 */
	private String No_Drugwin;
	public String getNo_Drugwin() {
		return No_Drugwin;
	}
	public void setNo_Drugwin(String No_Drugwin) {
		this.No_Drugwin = No_Drugwin;
	}
	/**
	 * 处方字
	 */
	private String Sd_prestpword;
	public String getSd_prestpword() {
		return Sd_prestpword;
	}
	public void setSd_prestpword(String sd_prestpword) {
		Sd_prestpword = sd_prestpword;
	}
	/**
	 * 总金额
	 */
	private FDouble  Amt_total;
	public FDouble getAmt_total() {
		return Amt_total;
	}
	public void setAmt_total(FDouble amt_total) {
		Amt_total = amt_total.setScale(-2, BigDecimal.ROUND_HALF_UP);
	}
	/**
	 * 退药总金额
	 */
	private FDouble  Amt_rtn_total;
	public FDouble getAmt_rtn_total() {
		return Amt_rtn_total;
	}
	public void setAmt_rtn_total(FDouble amt_rtn_total) {
		Amt_rtn_total = amt_rtn_total.setScale(-2, BigDecimal.ROUND_HALF_UP);
	}
	/**
	 * 退药和发药总金额差额
	 */
	private FDouble  Amt_Diff_total;
	public FDouble getAmt_Diff_total() {
		return Amt_Diff_total;
	}
	public void setAmt_Diff_total(FDouble amt_Diff_total) {
		Amt_Diff_total = amt_Diff_total.setScale(-2, BigDecimal.ROUND_HALF_UP);
	}
	/**
	 * 处方药品集合
	 */
	private List<PresDrugDTO> PresDrugList;
	public List<PresDrugDTO> getPresDrugList() {
		return PresDrugList;
	}

	public void setPresDrugList(List<PresDrugDTO> presDrugList) {
		PresDrugList = presDrugList;
		List<PresDrugDTO> presDrugListSymbol = new ArrayList<PresDrugDTO>();
		// 按id_or分组  在此分组 为了西成药加成组标识做准备
		if (presDrugList.size() >= 2) {
			LinkedHashMap<String, List<PresDrugDTO>> map = new LinkedHashMap<>();
			for (PresDrugDTO param : presDrugList) {
				if (!map.containsKey(param.getId_or())) {
					List<PresDrugDTO> list = new ArrayList<>();
					list.add(param);
					map.put(param.getId_or(), list);
				} else {
					map.get(param.getId_or()).add(param);
				}
			}
		
		if (map != null && map.size() > 0) {
			for (String id_or : map.keySet()) {
				List<PresDrugDTO> DrugList = map.get(id_or);
				setPresDrugListSymbol(DrugList);
			}
		}
	} else {
		setPresDrugListSymbol(presDrugList);
	}
	}
	
	/**
	 * 西药处方增加成组标识
	 * @code 
	 * @author LiYue
	 * @date 2019年4月9日,上午10:50:48
	 * @param presDrugList
	 */
	public void setPresDrugListSymbol(List<PresDrugDTO> presDrugList) {
		for (PresDrugDTO presDrugDTO : presDrugList) {
			// 成组符号
			if (presDrugList.size() > 1 && (null == presDrugDTO.getOrders())) {
				if (presDrugDTO.equals(presDrugList.get(0))) {
					presDrugDTO.setName_srv("┍ " + presDrugDTO.getName_srv());
				} else if (presDrugDTO.equals(presDrugList.get(presDrugList.size() - 1))) {
					presDrugDTO.setName_srv("┕ " + presDrugDTO.getName_srv());
				} else {
					presDrugDTO.setName_srv("│ " + presDrugDTO.getName_srv());
				}
			}
		}
	}
	
	/******************************草药处方信息*************************************/
	/**
	 * 草药付数
	 */
	private String  Orders;
	public String getOrders() {
		return Orders;
	}
	public void setOrders(String orders) {
		Orders = orders;
	}
	
	/**
	 * 代煎付数
	 */
	private String Orders_boil;
	public String getOrders_boil() {
		return Orders_boil;
	}
	public void setOrders_boil(String orders_boil) {
		Orders_boil = orders_boil;
	}
	/**
	 * 是否代煎
	 */
	private boolean Fg_boil;
	
	public boolean isFg_boil() {
		return Fg_boil;
	}
	public void setFg_boil(boolean fg_boil) {
		Fg_boil = fg_boil;
	}
	/**
	 * 煎药费
	 */
	private double pri_boil;
	
	public double getPri_boil() {
		return pri_boil;
	}
	public void setPri_boil(double pri_boil) {
		this.pri_boil = pri_boil;
	}
	/**
	 * 草药医嘱备注
	 */
	private String Des_or;
	public String getDes_or() {
		return Des_or;
	}
	public void setDes_or(String des_or) {
		Des_or = des_or;
	}
	/**
	 * 草药信息组合信息
	 */
	private String Herb_info;
	public String getHerb_info() {
		return Herb_info;
	}
	
	public void setHerb_info(String herb_info) {
		Herb_info = herb_info;
	}

	/******************************毒痳处方信息*************************************/
	/**
	 * 毒痳处方号
	 */
	private String Code_drug;
	public String getCode_drug(){
		return Code_drug;
	}
	public void setCode_drug(String code_drug) {
		Code_drug = code_drug;
	}
	/******************************注射治疗单信息*************************************/
	/**
	 * 诊疗执行单主键
	 */
	private String Id_ciapptreatexec;
	public String getId_ciapptreatexec(){
		return Id_ciapptreatexec;
	}
	public void setId_ciapptreatexec(String id_ciapptreatexec) {
		Id_ciapptreatexec = id_ciapptreatexec;
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
	 * 医嘱服务
	 */
	private String Id_srv;
	public String getId_srv() {
		return Id_srv;
	}
	public void setId_srv(String id_srv) {
		Id_srv = id_srv;
	}
	
	private String Name_srv;
	public String getName_srv() {
		return Name_srv;
	}
	public void setName_srv(String name_srv) {
		Name_srv = name_srv;
	}
	/**
	 * 物品名称
	 */
	private String Name_mm;
	public String getName_mm() {
		return Name_mm;
	}
	public void setName_mm(String name_mm) {
		Name_mm = name_mm;
	}
	/**
	 * 规格
	 */
	private String Spec_mm;
	public String getSpec_mm() {
		return Spec_mm;
	}
	public void setSpec_mm(String spec_mm) {
		Spec_mm = spec_mm;
	}
	/**
	 * 数量_当前
	 */
	private double Quan_cur;
	public double getQuan_cur() {
		return Quan_cur;
	}
	public void setQuan_cur(double quan_cur) {
		Quan_cur = quan_cur;
	}
	/**
	 * 零售单位名称
	 */
	private String Name_unit_sale;
	public String getName_unit_sale() {
		return Name_unit_sale;
	}
	public void setName_unit_sale(String name_unit_sale) {
		Name_unit_sale = name_unit_sale;
	}
	/**
	 * 数量_当前
	 */
	private double Quan_med;
	public double getQuan_med() {
		return Quan_med;
	}
	public void setQuan_med(double quan_med) {
		Quan_med = quan_med;
	}
	/**
	 * 零售单位名称
	 */
	private String Name_unit_med;
	public String getName_unit_med() {
		return Name_unit_med;
	}
	public void setName_unit_med(String name_unit_med) {
		Name_unit_med = name_unit_med;
	}
	/**
	 * 频次名称
	 */
	private String Name_freq;
	public String getName_freq() {
		return Name_freq;
	}
	public void setName_freq(String name_freq) {
		Name_freq = name_freq;
	}
	/**
	 * 医疗用法
	 */
	private String Name_route;
	public String getName_route() {
		return Name_route;
	}
	public void setName_route(String name_route) {
		Name_route = name_route;
	}
	/******************************注射治疗单信息*************************************/
	
	/**
	 * 煎药辅料费用（郑州门诊草药处方需求）
	 */
	private double boildesPrice;
	public double getBoildesPrice() {
		return boildesPrice;
	}
	public void setBoildesPrice(double boildesPrice) {
		this.boildesPrice = boildesPrice;
	}
	
/******************************住院医生站草药打印显示住院号*************************************/
	
	/**
	 * bug：127041:住院中药处方应该打印住院号2018000001，不应显示患者编码，需要显示床号
	 * （郑州住院医生站草药处方打印需求）在DTO中增加住院号
	 * liyuelong --2018-07-22
	 */
	private String Code_amr_ip;
	public String getCode_amr_ip() {
		return Code_amr_ip;
	}
	public void setCode_amr_ip(String code_amr_ip) {
		Code_amr_ip = code_amr_ip;
	}
	
	/**
	 * 超量开单原因ID（显示慢病、老年病）
	 */
	private String Id_excessive_reason;
	public String getId_excessive_reason(){
		return Id_excessive_reason;
	}
	public void setId_excessive_reason(String id_excessive_reason){
		Id_excessive_reason = id_excessive_reason;
	}
	
	/**
	 * 超量开单原因code
	 */
	private String Sd_excessive_reason;
	public String getSd_excessive_reason(){
		return Sd_excessive_reason;
	}
	public void setSd_excessive_reason(String sd_excessive_reason){
		Sd_excessive_reason = sd_excessive_reason;
	}
	/**
	 * 医嘱内容 
	 */
	private String Content_or;
	public String getContent_or(){
		return Content_or;
	}
	public void setContent_or(String content_or){
		Content_or = content_or;
	}
	/**
	 * 皮试结果编码
	 */
	public String Sd_rst_skintest;
	public String getSd_rst_skintest(){
		return Sd_rst_skintest;
	}
	public void setSd_rst_skintest(String sd_rst_skintest){
		Sd_rst_skintest = sd_rst_skintest;
	}
	/**
	 * 煎法标识
	 */
	private String Id_boil;
	public String getId_boil() {
		return Id_boil;
	}
	public void setId_boil(String id_boil) {
		Id_boil = id_boil;
	}
	private String Name_boil;
	public String getName_boil() {
		return Name_boil;
	}
	public void setName_boil(String name_boil) {
		Name_boil = name_boil;
	}
}