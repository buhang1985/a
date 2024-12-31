package iih.mi.bd.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医保档案对照DTO DTO数据 
 * 
 */
public class MiUdidocCompDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 档案主键
	 * @return String
	 */
	public String getId_miudidoc() {
		return ((String) getAttrVal("Id_miudidoc"));
	}
	/**
	 * 档案主键
	 * @param Id_miudidoc
	 */
	public void setId_miudidoc(String Id_miudidoc) {
		setAttrVal("Id_miudidoc", Id_miudidoc);
	}
	/**
	 * 医保主键
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保主键
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 档案类型
	 * @return String
	 */
	public String getId_miudidoclist() {
		return ((String) getAttrVal("Id_miudidoclist"));
	}
	/**
	 * 档案类型
	 * @param Id_miudidoclist
	 */
	public void setId_miudidoclist(String Id_miudidoclist) {
		setAttrVal("Id_miudidoclist", Id_miudidoclist);
	}
	/**
	 * his编码
	 * @return String
	 */
	public String getCode_his() {
		return ((String) getAttrVal("Code_his"));
	}
	/**
	 * his编码
	 * @param Code_his
	 */
	public void setCode_his(String Code_his) {
		setAttrVal("Code_his", Code_his);
	}
	/**
	 * his名称
	 * @return String
	 */
	public String getName_his() {
		return ((String) getAttrVal("Name_his"));
	}
	/**
	 * his名称
	 * @param Name_his
	 */
	public void setName_his(String Name_his) {
		setAttrVal("Name_his", Name_his);
	}
	/**
	 * 医保编码
	 * @return String
	 */
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}
	/**
	 * 医保编码
	 * @param Code_hp
	 */
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	/**
	 * 医保名称
	 * @return String
	 */
	public String getName_hp() {
		return ((String) getAttrVal("Name_hp"));
	}
	/**
	 * 医保名称
	 * @param Name_hp
	 */
	public void setName_hp(String Name_hp) {
		setAttrVal("Name_hp", Name_hp);
	}
}