package iih.mi.bd.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 出院状态对照 DTO数据 
 * 
 */
public class DischargedStatusCompDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 对照主键
	 * @return String
	 */
	public String getId_comp() {
		return ((String) getAttrVal("Id_comp"));
	}
	/**
	 * 对照主键
	 * @param Id_comp
	 */
	public void setId_comp(String Id_comp) {
		setAttrVal("Id_comp", Id_comp);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 医保产品主键
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保产品主键
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 医保出院状态编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 医保出院状态编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 医保出院状态名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 医保出院状态名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 疾病转归主键
	 * @return String
	 */
	public String getId_leveldise() {
		return ((String) getAttrVal("Id_leveldise"));
	}
	/**
	 * 疾病转归主键
	 * @param Id_leveldise
	 */
	public void setId_leveldise(String Id_leveldise) {
		setAttrVal("Id_leveldise", Id_leveldise);
	}
	/**
	 * 疾病转归编码
	 * @return String
	 */
	public String getCode_leveldise() {
		return ((String) getAttrVal("Code_leveldise"));
	}
	/**
	 * 疾病转归编码
	 * @param Code_leveldise
	 */
	public void setCode_leveldise(String Code_leveldise) {
		setAttrVal("Code_leveldise", Code_leveldise);
	}
	/**
	 * 疾病转归名称
	 * @return String
	 */
	public String getName_leveldise() {
		return ((String) getAttrVal("Name_leveldise"));
	}
	/**
	 * 疾病转归名称
	 * @param Name_leveldise
	 */
	public void setName_leveldise(String Name_leveldise) {
		setAttrVal("Name_leveldise", Name_leveldise);
	}
}