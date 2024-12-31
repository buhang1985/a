package iih.ci.ord.printmanage.ciorcost;

import java.math.BigDecimal;

import xap.mw.coreitf.d.FDouble;

/**
 * 诊疗收费清单打印DTO
 */
public class CiorSrvCostDTO {
	
	/**
	 * 打印单据ID
	 */
	private String Id_ciprn;
	
	/******************************服务信息***************************************/
	/**
	 * 服务
	 */
	private String Id_srv;
	private String Name_srv;
	/**
	 * 单价
	 */
	private FDouble Price; 
	/**
	 * 数量
	 */
	private FDouble Amount;
	/**
	 * 总价
	 */
	private FDouble TotalPrice;
	/**
	 * 医疗单位
	 */
	private String Id_medu;
	private String Name_medu;
	/**
	 * 医保计划目录类型
	 */
	private String Id_hpsrvtp;
	private String Sd_hpsrvtp;
	private String Name_hpsrvtp;
	/**
	 * 执行科室ID
	 */
	private String Id_dep_mp;
	private String Name_dep_mp;
	/**
	 * 自费标识
	 */
	public String Fg_selfpay;
	/**
	 * 嘱托（备注）
	 */
	private String Des_or;
	/**
	 * 打印单据明细项目ID
	 */
	private String Id_ciprnitm;
	/**
	 * 频次
	 */
	private String Name_freq;
	/**
	 * 使用天数
	 */
	private String Use_days;
	
	public String getName_freq() {
		return Name_freq;
	}
	public void setName_freq(String name_freq) {
		Name_freq = name_freq;
	}
	public String getUse_days() {
		return Use_days;
	}
	public void setUse_days(String use_days) {
		Use_days = use_days;
	}
	public String getDes_or() {
		return Des_or;
	}
	public void setDes_or(String des_or) {
		Des_or = des_or;
	}
	public String getId_ciprn() {
		return Id_ciprn;
	}
	public void setId_ciprn(String id_ciprn){
		Id_ciprn = id_ciprn;
	}	
	public String getId_srv() {
		return Id_srv;
	}
	public void setId_srv(String id_srv) {
		Id_srv = id_srv;
	}
	public String getName_srv() {
		return Name_srv;
	}
	public void setName_srv(String name_srv) {
		Name_srv = name_srv;
	}
	public FDouble getPrice() {
		return Price;
	}
	public void setPrice(FDouble price) {
		//Price = price.setScale(-2, BigDecimal.ROUND_HALF_UP);
		Price = price;
	}
	public FDouble getAmount() {
		return Amount;
	}
	public void setAmount(FDouble amount) {
		Amount = amount;
	}
	public FDouble getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(FDouble totalprice) {
		TotalPrice = totalprice.setScale(-2, BigDecimal.ROUND_HALF_UP);
	}
	public String getId_medu() {
		return Id_medu;
	}
	public void setId_medu(String id_medu) {
		Id_medu = id_medu;
	}
	public String getName_medu() {
		return Name_medu;
	}
	public void setName_medu(String name_medu) {
		Name_medu = name_medu;
	}
	public String getId_hpsrvtp() {
		return Id_hpsrvtp;
	}
	public void setId_hpsrvtp(String id_hpsrvtp) {
		Id_hpsrvtp = id_hpsrvtp;
	}
	public String getSd_hpsrvtp() {
		return Sd_hpsrvtp;
	}
	public void setSd_hpsrvtp(String sd_hpsrvtp) {
		Sd_hpsrvtp = sd_hpsrvtp;
	}
	public String getName_hpsrvtp() {
		return Name_hpsrvtp;
	}
	public void setName_hpsrvtp(String name_hpsrvtp) {
		Name_hpsrvtp = name_hpsrvtp;
	}
	public String getId_dep_mp() {
		return Id_dep_mp;
	}
	public void setId_dep_mp(String id_dep_mp) {
		Id_dep_mp = id_dep_mp;
	}
	public String getName_dep_mp() {
		return Name_dep_mp;
	}
	public void setName_dep_mp(String name_dep_mp) {
		Name_dep_mp = name_dep_mp;
	}
	public String getId_ciprnitm() {
		return Id_ciprnitm;
	}
	public void setId_ciprnitm(String id_ciprnitm) {
		Id_ciprnitm = id_ciprnitm;
	}
	public String getFg_selfpay() {
		return Fg_selfpay;
	}
	public void setFg_selfpay(String fg_selfpay) {
		Fg_selfpay = fg_selfpay;
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
}
