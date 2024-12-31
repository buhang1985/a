package iih.mi.bd.didefcompinfo.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医保诊断对照 DTO数据 
 * 
 */
public class DiDefCompInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 诊断主键
	 * @return String
	 */
	public String getId_didef() {
		return ((String) getAttrVal("Id_didef"));
	}
	/**
	 * 诊断主键
	 * @param Id_didef
	 */
	public void setId_didef(String Id_didef) {
		setAttrVal("Id_didef", Id_didef);
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
	 * his诊断编码
	 * @return String
	 */
	public String getCode_di_his() {
		return ((String) getAttrVal("Code_di_his"));
	}
	/**
	 * his诊断编码
	 * @param Code_di_his
	 */
	public void setCode_di_his(String Code_di_his) {
		setAttrVal("Code_di_his", Code_di_his);
	}
	/**
	 * his诊断名称
	 * @return String
	 */
	public String getName_di_his() {
		return ((String) getAttrVal("Name_di_his"));
	}
	/**
	 * his诊断名称
	 * @param Name_di_his
	 */
	public void setName_di_his(String Name_di_his) {
		setAttrVal("Name_di_his", Name_di_his);
	}
	/**
	 * 医保诊断编码
	 * @return String
	 */
	public String getCode_di_hp() {
		return ((String) getAttrVal("Code_di_hp"));
	}
	/**
	 * 医保诊断编码
	 * @param Code_di_hp
	 */
	public void setCode_di_hp(String Code_di_hp) {
		setAttrVal("Code_di_hp", Code_di_hp);
	}
	/**
	 * 医保诊断名称
	 * @return String
	 */
	public String getName_di_hp() {
		return ((String) getAttrVal("Name_di_hp"));
	}
	/**
	 * 医保诊断名称
	 * @param Name_di_hp
	 */
	public void setName_di_hp(String Name_di_hp) {
		setAttrVal("Name_di_hp", Name_di_hp);
	}
}