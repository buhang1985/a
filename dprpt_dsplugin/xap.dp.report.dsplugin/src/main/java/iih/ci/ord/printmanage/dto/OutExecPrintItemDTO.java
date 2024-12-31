package iih.ci.ord.printmanage.dto;

import java.math.BigDecimal;

import xap.mw.coreitf.d.FDouble;

public class OutExecPrintItemDTO {

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
	 * 服务
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
	 * 数量
	 */
	private FDouble Quan_total_medu;
	public FDouble getQuan_total_medu() {
		return Quan_total_medu;
	}
	public void setQuan_total_medu(FDouble quan_total_medu) {
		Quan_total_medu = quan_total_medu.setScale(0, BigDecimal.ROUND_HALF_UP);;
	}
	
	/**
	 * 医疗单位
	 */
	private String Id_medu;
	public String getId_medu() {
		return Id_medu;
	}
	public void setId_medu(String id_medu) {
		Id_medu = id_medu;
	}
	private String Name_medu;
	public String getName_medu() {
		return Name_medu;
	}
	public void setName_medu(String name_medu) {
		Name_medu = name_medu;
	}
	
	/**
	 * 单价
	 */
	private FDouble Pri;
	public FDouble getPri() {
		return Pri;
	}
	public void setPri(FDouble pri) {
		Pri = pri.setScale(-2, BigDecimal.ROUND_HALF_UP);
	}
	
	/**
	 * 金额
	 */
	private FDouble Amount;
	public FDouble getAmount() {
		return Amount;
	}
	public void setAmount(FDouble amount) {
		Amount = amount == null ? null : amount.setScale(-2, BigDecimal.ROUND_HALF_UP);
	}
	
	/**
	 * 标准单价
	 */
	private FDouble Pri_std;
	public FDouble getPri_std() {
		return Pri_std;
	}
	public void setPri_std(FDouble pri_std) {
		Pri_std = pri_std.setScale(-2, BigDecimal.ROUND_HALF_UP);
	}
	
	/**
	 * 标准金额
	 */
	private FDouble Amount_std;
	public FDouble getAmount_std() {
		return Amount_std;
	}
	public void setAmount_std(FDouble amount_std) {
		Amount_std = amount_std.setScale(-2, BigDecimal.ROUND_HALF_UP);
	}
	
	/**
	 * 记账状态
	 */
	private String Id_su_bl;
	public String getId_su_bl() {
		return Id_su_bl;
	}
	public void setId_su_bl(String id_su_bl) {
		Id_su_bl = id_su_bl;
	}
	private String Name_su_bl;
	public String getName_su_bl() {
		return Name_su_bl;
	}
	public void setName_su_bl(String name_su_bl) {
		Name_su_bl = name_su_bl;
	}
}
