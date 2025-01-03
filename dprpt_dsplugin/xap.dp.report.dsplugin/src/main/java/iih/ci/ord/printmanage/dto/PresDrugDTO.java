package iih.ci.ord.printmanage.dto;

import xap.mw.coreitf.d.FDouble;

/**
 * 处方药品 DTO数据 
 * 
 */
public class PresDrugDTO {

	/******************************服务信息*************************************/
	
	
	/**
	 * 药品基本药物范围编码
	 */
	private String sd_basedrugrange;
	
	/**
	 * 药品基本药物范围名称
	 */
	private String Name_basedrugrange;
	
	/**
	 * 【基本药物范围】档案字典增加【显示名称】扩展属性
	 */
	private String CTRL1;
	
	/**
	 * 处方
	 */
	private String Id_pres;
	public String getId_pres() {
		return Id_pres;
	}
	public void setId_pres(String id_pres) {
		Id_pres = id_pres;
	}
	/**
	 * 医嘱
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
	private String Id_orsrv;
	public String getId_orsrv() {
		return Id_orsrv;
	}
	public void setId_orsrv(String id_orsrv) {
		Id_orsrv = id_orsrv;
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
	 * 医疗服务
	 */
	private String Id_srv;
	public String getId_srv() {
		return Id_srv;
	}

	public void setId_srv(String id_srv) {
		Id_srv = id_srv;
	}	
	private String Code_srv;
	public String getCode_srv() {
		return Code_srv;
	}
	public void setCode_srv(String code_srv) {
		Code_srv = code_srv;
	}
	private String Name_srv;
	public String getName_srv() {
		return Name_srv;
	}
	public void setName_srv(String name_srv) {
		Name_srv = name_srv;
	}
	/**
	 * 医嘱频次
	 */
	private String Id_freq;
	public String getId_freq() {
		return Id_freq;
	}
	public void setId_freq(String id_freq) {
		Id_freq = id_freq;
	}

	private String Name_freq;
	public String getName_freq() {
		return Name_freq;
	}
	public void setName_freq(String name_freq) {
		Name_freq = name_freq;
	}
	/*
	 * 频次显示名称
	 */
	private String Code_disp;
	
	public String getCode_disp() {
		return Code_disp;
	}
	public void setCode_disp(String code_disp) {
		Code_disp = code_disp;
	}
	/**
	 * 费用标识
	 */
	private boolean Fg_bl;
	public boolean getFg_bl() {
		return Fg_bl;
	}
	public void setFg_bl(boolean fg_bl) {
		Fg_bl = fg_bl;
	}
	/**
	 * 参考价格
	 */
	private FDouble Price;
	public FDouble getPrice() {
		return Price;
	}
	public void setPrice(FDouble price) {
		//Price = price.setScale(-2, BigDecimal.ROUND_HALF_UP);
		Price = price;
	}
	/**
	 * 医嘱备注
	 */
	private String Des_or;
	public String getDes_or() {
		return this.Des_or;
	}	
	public void setDes_or(String Des_or) {
		this.Des_or = Des_or;
	}
	/**
	 * 序号
	 */
	private String Sortno;
	public String getSortno(){
		return this.Sortno;
	}
	public void setSortno(String Sortno){
		this.Sortno = Sortno;
	}
	/**
	 * 是否皮试标识
	 */
	private boolean Fg_skintest;
	public boolean getFg_skintest() {
		return this.Fg_skintest;
	}	
	public void setFg_skintest(boolean Fg_skintest) {
		this.Fg_skintest = Fg_skintest;
	}
	/******************************西药服务信息*************************************/
	/**
	 * 物品
	 */
	private String Id_mm;
	public String getId_mm() {
		return Id_mm;
	}

	public void setId_mm(String id_mm) {
		Id_mm = id_mm;
	}
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
	private FDouble Quan_cur;
	public FDouble getQuan_cur() {
		return Quan_cur;
	}
	public void setQuan_cur(FDouble quan_cur) {
		Quan_cur = quan_cur;
	}
	/**
	 * 退药数量_当前
	 */
	private FDouble Quan_cur_rtn;
	public FDouble getQuan_cur_rtn() {
		return Quan_cur_rtn;
	}
	public void setQuan_cur_rtn(FDouble quan_cur_rtn) {
		Quan_cur_rtn = quan_cur_rtn;
	}
	/**
	 * 退药金额_当前
	 */
	private FDouble Amt_rtn;
	public FDouble getAmt_rtn() {
		return Amt_rtn;
	}
	public void setAmt_rtn(FDouble amt_rtn) {
		Amt_rtn = amt_rtn;
	}
	/**
	 * 金额_当前
	 */
	private FDouble Amt;
	public FDouble getAmt() {
		return Amt;
	}
	public void setAmt(FDouble amt) {
		Amt = amt;
	}
	/**
	 * 零售单位
	 */
	private String Id_unit_sale;
	public String getId_unit_sale() {
		return Id_unit_sale;
	}
	public void setId_unit_sale(String id_unit_sale) {
		Id_unit_sale = id_unit_sale;
	}

	private String Name_unit_sale;
	public String getName_unit_sale() {
		return Name_unit_sale;
	}
	public void setName_unit_sale(String name_unit_sale) {
		Name_unit_sale = name_unit_sale;
	}
	/**
	 * 基本包装数量
	 */
	private FDouble Quan_num_base;
	public FDouble getQuan_num_base() {
		return Quan_num_base;
	}

	public void setQuan_num_base(FDouble quan_num_base) {
		Quan_num_base = quan_num_base;
	}
	/**
	 * 基数（String类型，西药处方和毒麻处方中，单次剂量显示逻辑调整为:当基本包装单位对应的数值为分数时，显示医学单位和医学数量；当基本包装单位对应的数值不为分数时，显示基本包装单位和基本包装单位对应的数量。）
	 */
	private String Quan_den_base;
	public String getQuan_den_base() {
		return Quan_den_base;
	}

	public void setQuan_den_base(String quan_den_base) {
		Quan_den_base = quan_den_base;
	}
	
	/**
	 * 基本包装单位
	 */
	private String Name_unit_base;
	public String getName_unit_base() {
		return Name_unit_base;
	}

	public void setName_unit_base(String name_unit_base) {
		Name_unit_base = name_unit_base;
	}
	/**
	 * 用法
	 */
	private String Id_route;
	public String getId_route() {
		return Id_route;
	}
	public void setId_route(String id_route) {
		Id_route = id_route;
	}

	private String Name_route;
	public String getName_route() {
		return Name_route;
	}
	public void setName_route(String name_route) {
		Name_route = name_route;
	}
	/**
	 * 用法要求
	 */
	private String Id_routedes;
	public String getId_routedes() {
		return Id_routedes;
	}
	public void setId_routedes(String id_routedes) {
		Id_routedes = id_routedes;
	}

	private String Name_routedes;
	public String getName_routedes() {
		return Name_routedes;
	}
	public void setName_routedes(String name_routedes) {
		Name_routedes = name_routedes;
	}
	/**
	 * 用量
	 */
	private String Des_uselevel;
	public String getDes_uselevel() {
		return Des_uselevel;
	}
	public void setDes_uselevel(String des_uselevel) {
		Des_uselevel = des_uselevel;
	}
	/**
	 * 当前剂量
	 */
	private  FDouble  Quan_medu_cur;
	
	/**
	 * 当前剂量单位
	 */
	private  String   Id_medu_cur;
	
	public FDouble getQuan_medu_cur() {
		return Quan_medu_cur;
	}
	public void setQuan_medu_cur(FDouble quan_medu_cur) {
		Quan_medu_cur = quan_medu_cur;
	}
	public String getId_medu_cur() {
		return Id_medu_cur;
	}
	public void setId_medu_cur(String id_medu_cur) {
		Id_medu_cur = id_medu_cur;
	}
	/**
	 * 医保目录_药品
	 */
	private String Name_hpsrvtp;
	public String getName_hpsrvtp() {
		return Name_hpsrvtp;
	}
	public void setName_hpsrvtp(String name_hpsrvtp) {
		Name_hpsrvtp = name_hpsrvtp;
	}
	/******************************草药服务信息*************************************/
	/**
	 * 数量_医疗单位
	 */
	private FDouble Quan_med;
	public FDouble getQuan_med() {
		return Quan_med;
	}
	public void setQuan_med(FDouble quan_med) {
		Quan_med = quan_med;
	}
	/**
	 * 医疗单位
	 */
	private String Id_unit_med;
	public String getId_unit_med() {
		return Id_unit_med;
	}
	public void setId_unit_med(String id_unit_med) {
		Id_unit_med = id_unit_med;
	}
	private String Name_unit_med;
	public String getName_unit_med() {
		return Name_unit_med;
	}

	public void setName_unit_med(String name_unit_med) {
		Name_unit_med = name_unit_med;
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
	/**
	 * 煎法要求
	 */
	private String Id_boildes;
	public String getId_boildes() {
		return Id_boildes;
	}
	public void setId_boildes(String id_boildes) {
		Id_boildes = id_boildes;
	}
	private String Name_boildes;
	public String getName_boildes() {
		return Name_boildes;
	}
	public void setName_boildes(String name_boildes) {
		Name_boildes = name_boildes;
	}
	/**
	 * 草药付数（处方信息）
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
	/******************************处方信息*************************************/
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
	
	/******************************注射治疗单*************************************/
	/**
	 * 诊疗执行单主键
	 */
	public String Id_ciapptreatexec;
	public String getId_ciapptreatexec(){
		return Id_ciapptreatexec;
	}
	public void setId_ciapptreatexec(String id_ciapptreatexec) {
		Id_ciapptreatexec = id_ciapptreatexec;
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
	 * 皮试结果名称
	 */
	public String Name_skintest_rst;
	public String getName_skintest_rst(){
		return Name_skintest_rst;
	}
	public void setName_skintest_rst(String Name_skintest_rst){
		this.Name_skintest_rst = Name_skintest_rst;
	}
	/**
	 * 药品类别
	 */
	private String Sd_mmtp;
	public String getSd_mmtp(){
		return this.Sd_mmtp;
	}
	public void setSd_mmtp(String Sd_mmtp){
		this.Sd_mmtp = Sd_mmtp;
	}
	/**
	 * 滴速
	 */
	private String Dripspeed;
	public String getDripspeed() {
		return Dripspeed;
	}
	public void setDripspeed(String dripspeed) {
		Dripspeed = dripspeed;
	}
	/**
	 * 天数
	 */
	private String Use_days;
	public String getUse_days() {
		return Use_days;
	}
	public void setUse_days(String use_days) {
		Use_days = use_days;
	}
	/**
	 * 诊断名称
	 */
	private String Name_didef;
	public String getName_didef() {
		return Name_didef;
	}
	public void setName_didef(String name_didef) {
		Name_didef = name_didef;
	}
	/**
	 * 超量开单原因
	 */
	private String Name_excessive_reason;
	public String getName_excessive_reason() {
		return Name_excessive_reason;
	}
	public void setName_excessive_reason(String name_excessive_reason) {
		Name_excessive_reason = name_excessive_reason;
	}

	/**
	 * 生产厂家
	 */
	private String Sup_name;
	public String getSup_name() {
		return Sup_name;
	}
	public void setSup_name(String sup_name) {
		Sup_name = sup_name;
	}
	
	public String getSd_basedrugrange() {
		return sd_basedrugrange;
	}
	public void setSd_basedrugrange(String sd_basedrugrange) {
		this.sd_basedrugrange = sd_basedrugrange;
	}
	public String getName_basedrugrange() {
		return Name_basedrugrange;
	}
	public void setName_basedrugrange(String name_basedrugrange) {
		Name_basedrugrange = name_basedrugrange;
	}
	public String getCTRL1() {
		return CTRL1;
	}
	public void setCTRL1(String cTRL1) {
		CTRL1 = cTRL1;
	}
}