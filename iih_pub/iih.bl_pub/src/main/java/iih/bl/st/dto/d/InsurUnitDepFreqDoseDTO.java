package iih.bl.st.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class InsurUnitDepFreqDoseDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医保计划
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保计划
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 单位
	 * @return FArrayList
	 */
	public FArrayList getMeasdocdo() {
		return ((FArrayList) getAttrVal("Measdocdo"));
	}
	/**
	 * 单位
	 * @param Measdocdo
	 */
	public void setMeasdocdo(FArrayList Measdocdo) {
		setAttrVal("Measdocdo", Measdocdo);
	}
	/**
	 * 医保科别
	 * @return FArrayList
	 */
	public FArrayList getHpdepdo() {
		return ((FArrayList) getAttrVal("Hpdepdo"));
	}
	/**
	 * 医保科别
	 * @param Hpdepdo
	 */
	public void setHpdepdo(FArrayList Hpdepdo) {
		setAttrVal("Hpdepdo", Hpdepdo);
	}
	/**
	 * 医保剂型
	 * @return FArrayList
	 */
	public FArrayList getHpdosedo() {
		return ((FArrayList) getAttrVal("Hpdosedo"));
	}
	/**
	 * 医保剂型
	 * @param Hpdosedo
	 */
	public void setHpdosedo(FArrayList Hpdosedo) {
		setAttrVal("Hpdosedo", Hpdosedo);
	}
	/**
	 * 医保频次
	 * @return FArrayList
	 */
	public FArrayList getHpfreqdo() {
		return ((FArrayList) getAttrVal("Hpfreqdo"));
	}
	/**
	 * 医保频次
	 * @param Hpfreqdo
	 */
	public void setHpfreqdo(FArrayList Hpfreqdo) {
		setAttrVal("Hpfreqdo", Hpfreqdo);
	}
	/**
	 * 医保处方
	 * @return FArrayList
	 */
	public FArrayList getHppresdicarr() {
		return ((FArrayList) getAttrVal("Hppresdicarr"));
	}
	/**
	 * 医保处方
	 * @param Hppresdicarr
	 */
	public void setHppresdicarr(FArrayList Hppresdicarr) {
		setAttrVal("Hppresdicarr", Hppresdicarr);
	}
	/**
	 * 医保计划集合
	 * @return FArrayList
	 */
	public FArrayList getHpdo() {
		return ((FArrayList) getAttrVal("Hpdo"));
	}
	/**
	 * 医保计划集合
	 * @param Hpdo
	 */
	public void setHpdo(FArrayList Hpdo) {
		setAttrVal("Hpdo", Hpdo);
	}
	/**
	 * 医保险种
	 * @return FArrayList
	 */
	public FArrayList getBdhpkinddo() {
		return ((FArrayList) getAttrVal("Bdhpkinddo"));
	}
	/**
	 * 医保险种
	 * @param Bdhpkinddo
	 */
	public void setBdhpkinddo(FArrayList Bdhpkinddo) {
		setAttrVal("Bdhpkinddo", Bdhpkinddo);
	}
	/**
	 * 患者价格分类
	 * @return FArrayList
	 */
	public FArrayList getPripatdo() {
		return ((FArrayList) getAttrVal("Pripatdo"));
	}
	/**
	 * 患者价格分类
	 * @param Pripatdo
	 */
	public void setPripatdo(FArrayList Pripatdo) {
		setAttrVal("Pripatdo", Pripatdo);
	}
}