package iih.sc.sch.reg.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 资源统计信息DTO DTO数据 
 * 
 */
public class ResStatsDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 科室id
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 科室id
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 排班日期
	 * @return FDate
	 */
	public FDate getD_sc() {
		return ((FDate) getAttrVal("D_sc"));
	}
	/**
	 * 排班日期
	 * @param D_sc
	 */
	public void setD_sc(FDate D_sc) {
		setAttrVal("D_sc", D_sc);
	}
	/**
	 * 午别id
	 * @return String
	 */
	public String getId_dayslot() {
		return ((String) getAttrVal("Id_dayslot"));
	}
	/**
	 * 午别id
	 * @param Id_dayslot
	 */
	public void setId_dayslot(String Id_dayslot) {
		setAttrVal("Id_dayslot", Id_dayslot);
	}
	/**
	 * 午别
	 * @return String
	 */
	public String getName_dayslot() {
		return ((String) getAttrVal("Name_dayslot"));
	}
	/**
	 * 午别
	 * @param Name_dayslot
	 */
	public void setName_dayslot(String Name_dayslot) {
		setAttrVal("Name_dayslot", Name_dayslot);
	}
	/**
	 * 普通号数量
	 * @return Integer
	 */
	public Integer getQuan_ord() {
		return ((Integer) getAttrVal("Quan_ord"));
	}
	/**
	 * 普通号数量
	 * @param Quan_ord
	 */
	public void setQuan_ord(Integer Quan_ord) {
		setAttrVal("Quan_ord", Quan_ord);
	}
	/**
	 * 专家号数量
	 * @return Integer
	 */
	public Integer getQuan_expert() {
		return ((Integer) getAttrVal("Quan_expert"));
	}
	/**
	 * 专家号数量
	 * @param Quan_expert
	 */
	public void setQuan_expert(Integer Quan_expert) {
		setAttrVal("Quan_expert", Quan_expert);
	}
	/**
	 * 特需专家号数量
	 * @return Integer
	 */
	public Integer getQuan_vip() {
		return ((Integer) getAttrVal("Quan_vip"));
	}
	/**
	 * 特需专家号数量
	 * @param Quan_vip
	 */
	public void setQuan_vip(Integer Quan_vip) {
		setAttrVal("Quan_vip", Quan_vip);
	}
	/**
	 * 是否用完
	 * @return FBoolean
	 */
	public FBoolean getFg_usedup() {
		return ((FBoolean) getAttrVal("Fg_usedup"));
	}
	/**
	 * 是否用完
	 * @param Fg_usedup
	 */
	public void setFg_usedup(FBoolean Fg_usedup) {
		setAttrVal("Fg_usedup", Fg_usedup);
	}
}