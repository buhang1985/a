package iih.ci.ord.content.listener.base.dto;

/**
 * @code 药品医嘱拼接查询DTO 
 * @author LiYue
 */
public class DrugsOrdContentDTO {
	
	/**
	 * 物品id
	 */
	private String id_mm;
	/**
	 * 药品基本药物范围编码
	 */
	private String sd_basedrugrange;
	
	/**
	 * 【基本药物范围】档案字典增加【显示名称】扩展属性
	 */
	private String CTRL1;

	
	
	public String getId_mm() {
		return id_mm;
	}

	public void setId_mm(String id_mm) {
		this.id_mm = id_mm;
	}

	public String getSd_basedrugrange() {
		return sd_basedrugrange;
	}

	public void setSd_basedrugrange(String sd_basedrugrange) {
		this.sd_basedrugrange = sd_basedrugrange;
	}

	public String getCTRL1() {
		return CTRL1;
	}

	public void setCTRL1(String cTRL1) {
		CTRL1 = cTRL1;
	}

}
