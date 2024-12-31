package iih.mm.po.purchase.dto;

import xap.mw.coreitf.d.FDouble;

public class PlanItemDTO {
	/**
	 * 物品ID
	 */
	private String id_mm;
	
	/**
	 * 计划采购数量_基本单位
	 */
	private FDouble quan_pl_base;
	
	/**
	 * 计划采购数量_实际单位
	 */
	private FDouble quan_pl_actual;
	
	/**
	 * 基本包装单位ID
	 */
	private String id_mmpkgu_base;
	
	/**
	 * 界面包装单位ID
	 */
	private String id_mmpkgu_actual;
	
	/**
	 * 界面包装单位与基本单位换算率
	 * @return
	 */
	private FDouble factor;
	
	public String getId_mm() {
		return id_mm;
	}

	public void setId_mm(String id_mm) {
		this.id_mm = id_mm;
	}

	public FDouble getQuan_pl_base() {
		return quan_pl_base;
	}

	public void setQuan_pl_base(FDouble quan_pl_base) {
		this.quan_pl_base = quan_pl_base;
	}

	public FDouble getQuan_pl_actual() {
		return quan_pl_actual;
	}

	public void setQuan_pl_actual(FDouble quan_pl_actual) {
		this.quan_pl_actual = quan_pl_actual;
	}

	public String getId_mmpkgu_base() {
		return id_mmpkgu_base;
	}

	public void setId_mmpkgu_base(String id_mmpkgu_base) {
		this.id_mmpkgu_base = id_mmpkgu_base;
	}

	public String getId_mmpkgu_actual() {
		return id_mmpkgu_actual;
	}

	public void setId_mmpkgu_actual(String id_mmpkgu_actual) {
		this.id_mmpkgu_actual = id_mmpkgu_actual;
	}

	public FDouble getFactor() {
		return factor;
	}

	public void setFactor(FDouble factor) {
		this.factor = factor;
	}

}
