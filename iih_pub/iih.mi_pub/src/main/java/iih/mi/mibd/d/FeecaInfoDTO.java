package iih.mi.mibd.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 费用对照dto DTO数据 
 * 
 */
public class FeecaInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 费用字典主键
	 * @return String
	 */
	public String getId_feeca() {
		return ((String) getAttrVal("Id_feeca"));
	}
	/**
	 * 费用字典主键
	 * @param Id_feeca
	 */
	public void setId_feeca(String Id_feeca) {
		setAttrVal("Id_feeca", Id_feeca);
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
	 * 门诊账单项
	 * @return String
	 */
	public String getOep_name() {
		return ((String) getAttrVal("Oep_name"));
	}
	/**
	 * 门诊账单项
	 * @param Oep_name
	 */
	public void setOep_name(String Oep_name) {
		setAttrVal("Oep_name", Oep_name);
	}
	/**
	 * 住院账单项
	 * @return String
	 */
	public String getIp_name() {
		return ((String) getAttrVal("Ip_name"));
	}
	/**
	 * 住院账单项
	 * @param Ip_name
	 */
	public void setIp_name(String Ip_name) {
		setAttrVal("Ip_name", Ip_name);
	}
}