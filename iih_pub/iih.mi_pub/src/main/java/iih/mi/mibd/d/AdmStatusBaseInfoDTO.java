package iih.mi.mibd.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 入院状态DTO DTO数据 
 * 
 */
public class AdmStatusBaseInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 入院主键
	 * @return String
	 */
	public String getId_admstatus() {
		return ((String) getAttrVal("Id_admstatus"));
	}
	/**
	 * 入院主键
	 * @param Id_admstatus
	 */
	public void setId_admstatus(String Id_admstatus) {
		setAttrVal("Id_admstatus", Id_admstatus);
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
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * his编码
	 * @return String
	 */
	public String getHiscode() {
		return ((String) getAttrVal("Hiscode"));
	}
	/**
	 * his编码
	 * @param Hiscode
	 */
	public void setHiscode(String Hiscode) {
		setAttrVal("Hiscode", Hiscode);
	}
	/**
	 * his名称
	 * @return String
	 */
	public String getHisname() {
		return ((String) getAttrVal("Hisname"));
	}
	/**
	 * his名称
	 * @param Hisname
	 */
	public void setHisname(String Hisname) {
		setAttrVal("Hisname", Hisname);
	}
}