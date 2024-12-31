package iih.mi.bd.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医保剂型对照 DTO数据 
 * 
 */
public class DosageCompInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医保剂型主键
	 * @return String
	 */
	public String getId_hp_dosage() {
		return ((String) getAttrVal("Id_hp_dosage"));
	}
	/**
	 * 医保剂型主键
	 * @param Id_hp_dosage
	 */
	public void setId_hp_dosage(String Id_hp_dosage) {
		setAttrVal("Id_hp_dosage", Id_hp_dosage);
	}
	/**
	 * 医保产品
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保产品
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 医保剂型编码
	 * @return String
	 */
	public String getCode_dosage_hp() {
		return ((String) getAttrVal("Code_dosage_hp"));
	}
	/**
	 * 医保剂型编码
	 * @param Code_dosage_hp
	 */
	public void setCode_dosage_hp(String Code_dosage_hp) {
		setAttrVal("Code_dosage_hp", Code_dosage_hp);
	}
	/**
	 * 医保剂型名称
	 * @return String
	 */
	public String getName_dosage_hp() {
		return ((String) getAttrVal("Name_dosage_hp"));
	}
	/**
	 * 医保剂型名称
	 * @param Name_dosage_hp
	 */
	public void setName_dosage_hp(String Name_dosage_hp) {
		setAttrVal("Name_dosage_hp", Name_dosage_hp);
	}
	/**
	 * 剂型id
	 * @return String
	 */
	public String getId_dosage_his() {
		return ((String) getAttrVal("Id_dosage_his"));
	}
	/**
	 * 剂型id
	 * @param Id_dosage_his
	 */
	public void setId_dosage_his(String Id_dosage_his) {
		setAttrVal("Id_dosage_his", Id_dosage_his);
	}
	/**
	 * 剂型编码
	 * @return String
	 */
	public String getSd_dosage_his() {
		return ((String) getAttrVal("Sd_dosage_his"));
	}
	/**
	 * 剂型编码
	 * @param Sd_dosage_his
	 */
	public void setSd_dosage_his(String Sd_dosage_his) {
		setAttrVal("Sd_dosage_his", Sd_dosage_his);
	}
}