package iih.ci.mi.ord.i.meta;

import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

public class OrdSrvRuleParamDTO extends OrdSrvIndicParamDTO{

	private static final long serialVersionUID = 1L;
	/**
	 * 频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * 频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	
	/**
	 * 剂型
	 * @return String
	 */
	public String getId_dosage() {
		return ((String) getAttrVal("Id_dosage"));
	}
	/**
	 * 剂型
	 * @param Id_dosage
	 */
	public void setId_dosage(String Id_dosage) {
		setAttrVal("Id_dosage", Id_dosage);
	}
	
	/**
	 * 当前物品持有天数
	 * @return Integer
	 */
	public Integer getDays_available() {
		return ((Integer) getAttrVal("Days_available"));
	}	
	/**
	 * 当前物品持有天数
	 * @param Days_available
	 */
	public void setDays_available(Integer Days_available) {
		setAttrVal("Days_available", Days_available);
	}
	
	/**
	 * 换算系数
	 * @return Integer
	 */
	public FDouble getFactor() {
		return ((FDouble) getAttrVal("Factor"));
	}	
	/**
	 * 换算系数
	 * @param Factor
	 */
	public void setFactor(FDouble Factor) {
		setAttrVal("Factor", Factor);
	}
	
	/**
	 * 换算系数_医疗基本
	 * @return Integer
	 */
	public FDouble getFactor_mb() {
		return ((FDouble) getAttrVal("Factor_mb"));
	}	
	/**
	 * 换算系数_医疗基本
	 * @param Factor_mb
	 */
	public void setFactor_mb(FDouble Factor_mb) {
		setAttrVal("Factor_mb", Factor_mb);
	}
	
	/**
	 * 总量_当前包装
	 * @return FDouble
	 */
	public FDouble getQuan_cur() {
		return ((FDouble) getAttrVal("Quan_cur"));
	}	
	/**
	 * 总量_当前包装
	 * @param Quan_cur
	 */
	public void setQuan_cur(FDouble Quan_cur) {
		setAttrVal("Quan_cur", Quan_cur);
	}
	/**
	 * 当前包装单位
	 * @return String
	 */
	public String getId_pgku_cur() {
		return ((String) getAttrVal("Id_pgku_cur"));
	}	
	/**
	 * 当前包装单位
	 * @param Id_pgku_cur
	 */
	public void setId_pgku_cur(String Id_pgku_cur) {
		setAttrVal("Id_pgku_cur", Id_pgku_cur);
	}
	
	/**
	 * 计量单位名称
	 * @return String
	 */
	public String getName_pgku_cur() {
		return ((String) getAttrVal("Name_pgku_cur"));
	}	
	/**
	 * 计量单位名称
	 * @param Name_pgku_cur
	 */
	public void setName_pgku_cur(String Name_pgku_cur) {
		setAttrVal("Name_pgku_cur", Name_pgku_cur);
	}
	
	/**
	 * 物品标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mm() {
		return ((FBoolean) getAttrVal("Fg_mm"));
	}	
	/**
	 * 物品标识
	 * @param Fg_mm
	 */
	public void setFg_mm(FBoolean Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
	}
	    
	/**
	 * 特殊病药品标识
	 * @return Integer
	 */
	public FBoolean getFg_specill() {
		return ((FBoolean) getAttrVal("Fg_specill"));
	}	
	/**
	 * 特殊病药品标识
	 * @param Factor_mb
	 */
	public void setFg_specill(FBoolean Fg_specill) {
		setAttrVal("Fg_specill", Fg_specill);
	}
}
