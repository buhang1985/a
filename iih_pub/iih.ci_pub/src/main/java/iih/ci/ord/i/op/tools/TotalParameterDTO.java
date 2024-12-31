package iih.ci.ord.i.op.tools;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/**
 * 总量计算参数 DTO数据
 * 
 */
public class TotalParameterDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 * 
	 * @return String
	 */
	public String getId() {
		return ((String) getAttrVal("Id"));
	}

	/**
	 * 主键
	 * 
	 * @param Id
	 */
	public void setId(String Id) {
		setAttrVal("Id", Id);
	}

	/**
	 * 总量
	 * 
	 * @return FDouble
	 */
	public FDouble getQuen_cur() {
		return ((FDouble) getAttrVal("Quen_cur"));
	}

	/**
	 * 总量
	 * 
	 * @param Quen_cur
	 */
	public void setQuen_cur(FDouble Quen_cur) {
		setAttrVal("Quen_cur", Quen_cur);
	}

	/**
	 * 单次剂量
	 * 
	 * @return FDouble
	 */
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}

	/**
	 * 单次剂量
	 * 
	 * @param Quan_medu
	 */
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}

	/**
	 * 基本包装单位和总量单位间的换算系数
	 * 
	 * @return FDouble
	 */
	public FDouble getFactor() {
		return ((FDouble) getAttrVal("Factor"));
	}

	/**
	 * 基本包装单位和总量单位间的换算系数
	 * 
	 * @param Factor
	 */
	public void setFactor(FDouble Factor) {
		setAttrVal("Factor", Factor);
	}

	/**
	 * 医基系数
	 * 
	 * @return FDouble
	 */
	public FDouble getFactor_mb() {
		return ((FDouble) getAttrVal("Factor_mb"));
	}

	/**
	 * 医基系数
	 * 
	 * @param Factor_mb
	 */
	public void setFactor_mb(FDouble Factor_mb) {
		setAttrVal("Factor_mb", Factor_mb);
	}

	/**
	 * 总次数
	 * 
	 * @return Integer
	 */
	public Integer getTimes() {
		return ((Integer) getAttrVal("Times"));
	}

	/**
	 * 总次数
	 * 
	 * @param Times
	 */
	public void setTimes(Integer Times) {
		setAttrVal("Times", Times);
	}

	/**
	 * 频次id
	 * 
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}

	/**
	 * 频次id
	 * 
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}

	/**
	 * 取整模式
	 * 
	 * @return String
	 */
	public String getSd_mupakgu() {
		return ((String) getAttrVal("Sd_mupakgu"));
	}

	/**
	 * 取整模式
	 * 
	 * @param Sd_mupakgu
	 */
	public void setSd_mupakgu(String Sd_mupakgu) {
		setAttrVal("Sd_mupakgu", Sd_mupakgu);
	}

	/**
	 * 开立天数
	 * 
	 * @return Integer
	 */
	public Integer getUse_day() {
		return ((Integer) getAttrVal("Use_day"));
	}

	/**
	 * 开立天数
	 * 
	 * @param Use_day
	 */
	public void setUse_day(Integer Use_day) {
		setAttrVal("Use_day", Use_day);
	}

	/**
	 * 物品id
	 * 
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}

	/**
	 * 物品id
	 * 
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}

	/**
	 * 总量单位
	 * 
	 * @return String
	 */
	public String getId_unit_sale() {
		return ((String) getAttrVal("Id_unit_sale"));
	}

	/**
	 * 总量单位
	 * 
	 * @param Id_unit_sale
	 */
	public void setId_unit_sale(String Id_unit_sale) {
		setAttrVal("Id_unit_sale", Id_unit_sale);
	}

	/**
	 * 是否出院带药
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_pres_outp() {
		return ((FBoolean) getAttrVal("Fg_pres_outp"));
	}

	/**
	 * 是否出院带药
	 * 
	 * @param Fg_pres_outp
	 */
	public void setFg_pres_outp(FBoolean Fg_pres_outp) {
		setAttrVal("Fg_pres_outp", Fg_pres_outp);
	}

	/**
	 * 扩展字段1
	 * 
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}

	/**
	 * 扩展字段1
	 * 
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}

	/**
	 * 扩展字段2
	 * 
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}

	/**
	 * 扩展字段2
	 * 
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}

	/**
	 * 扩展字段3
	 * 
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}

	/**
	 * 扩展字段3
	 * 
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}

	/**
	 * 扩展字段4
	 * 
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}

	/**
	 * 扩展字段4
	 * 
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 医嘱生效日期
	 * @return FDateTime
	 */
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}	
	/**
	 * 医嘱生效日期
	 * @param Dt_effe
	 */
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
}