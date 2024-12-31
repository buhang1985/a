package iih.mi.bd.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 就诊类型基础信息DTO DTO数据 
 * 
 */
public class EnTpBaseInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊主键
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}
	/**
	 * 就诊主键
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
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
	 * 医保产品就诊类型编码
	 * @return String
	 */
	public String getCode_hpentp() {
		return ((String) getAttrVal("Code_hpentp"));
	}
	/**
	 * 医保产品就诊类型编码
	 * @param Code_hpentp
	 */
	public void setCode_hpentp(String Code_hpentp) {
		setAttrVal("Code_hpentp", Code_hpentp);
	}
	/**
	 * 医保产品就诊类型名称
	 * @return String
	 */
	public String getName_hpentp() {
		return ((String) getAttrVal("Name_hpentp"));
	}
	/**
	 * 医保产品就诊类型名称
	 * @param Name_hpentp
	 */
	public void setName_hpentp(String Name_hpentp) {
		setAttrVal("Name_hpentp", Name_hpentp);
	}
	/**
	 * HIS就诊类型编码
	 * @return String
	 */
	public String getEntp_code() {
		return ((String) getAttrVal("Entp_code"));
	}
	/**
	 * HIS就诊类型编码
	 * @param Entp_code
	 */
	public void setEntp_code(String Entp_code) {
		setAttrVal("Entp_code", Entp_code);
	}
	/**
	 * HIS就诊类型名称
	 * @return String
	 */
	public String getEntp_name() {
		return ((String) getAttrVal("Entp_name"));
	}
	/**
	 * HIS就诊类型名称
	 * @param Entp_name
	 */
	public void setEntp_name(String Entp_name) {
		setAttrVal("Entp_name", Entp_name);
	}
}