package iih.bd.mhi.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医保就诊类型对照DTO DTO数据 
 * 
 */
public class HpEnTpCompDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊类型对照主键
	 * @return String
	 */
	public String getId_entpcomp() {
		return ((String) getAttrVal("Id_entpcomp"));
	}
	/**
	 * 就诊类型对照主键
	 * @param Id_entpcomp
	 */
	public void setId_entpcomp(String Id_entpcomp) {
		setAttrVal("Id_entpcomp", Id_entpcomp);
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
	 * 医保产品编码
	 * @return String
	 */
	public String getHp_code() {
		return ((String) getAttrVal("Hp_code"));
	}
	/**
	 * 医保产品编码
	 * @param Hp_code
	 */
	public void setHp_code(String Hp_code) {
		setAttrVal("Hp_code", Hp_code);
	}
	/**
	 * 医保产品名称
	 * @return String
	 */
	public String getHp_name() {
		return ((String) getAttrVal("Hp_name"));
	}
	/**
	 * 医保产品名称
	 * @param Hp_name
	 */
	public void setHp_name(String Hp_name) {
		setAttrVal("Hp_name", Hp_name);
	}
	/**
	 * 医保就诊类型编码
	 * @return String
	 */
	public String getCode_hpentp() {
		return ((String) getAttrVal("Code_hpentp"));
	}
	/**
	 * 医保就诊类型编码
	 * @param Code_hpentp
	 */
	public void setCode_hpentp(String Code_hpentp) {
		setAttrVal("Code_hpentp", Code_hpentp);
	}
	/**
	 * 医保就诊类型名称
	 * @return String
	 */
	public String getName_hpentp() {
		return ((String) getAttrVal("Name_hpentp"));
	}
	/**
	 * 医保就诊类型名称
	 * @param Name_hpentp
	 */
	public void setName_hpentp(String Name_hpentp) {
		setAttrVal("Name_hpentp", Name_hpentp);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}
	/**
	 * 就诊类型
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
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
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
}