package iih.bl.itf.esoe.d;

import java.util.List;

/**
 * 应急系统--门诊销售单模型
 * @author ly 2019/09/26
 *
 */
public class BlEsoeSaleDTO {

	/**
	 * 销售主键
	 */
	private String id_sale;
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
	private String id_enttp;
	/**
	 * 销售单号
	 */
	private String code_sale;
	/**
	 * 状态
	 */
	private String eu_su_sale;
	/**
	 * 创建结算
	 */
	private String id_st_by;
	/**
	 * 结算集合
	 */
	private List<BlEsoeStoepDTO> stList;
	
	public String getId_sale() {
		return id_sale;
	}
	public void setId_sale(String id_sale) {
		this.id_sale = id_sale;
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
	public String getId_enttp() {
		return id_enttp;
	}
	public void setId_enttp(String id_enttp) {
		this.id_enttp = id_enttp;
	}
	public String getCode_sale() {
		return code_sale;
	}
	public void setCode_sale(String code_sale) {
		this.code_sale = code_sale;
	}
	public String getEu_su_sale() {
		return eu_su_sale;
	}
	public void setEu_su_sale(String eu_su_sale) {
		this.eu_su_sale = eu_su_sale;
	}
	public String getId_st_by() {
		return id_st_by;
	}
	public void setId_st_by(String id_st_by) {
		this.id_st_by = id_st_by;
	}
	public List<BlEsoeStoepDTO> getStList() {
		return stList;
	}
	public void setStList(List<BlEsoeStoepDTO> stList) {
		this.stList = stList;
	}
}
