package iih.ei.std.d.v1.en.ipenthpinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院患者医保信息item DTO数据 
 * 
 */
public class IpEntHpInfoItemsDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 编号
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}	
	/**
	 * 编号
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 医保类型
	 * @return String
	 */
	public String getSd_hptp() {
		return ((String) getAttrVal("Sd_hptp"));
	}	
	/**
	 * 医保类型
	 * @param Sd_hptp
	 */
	public void setSd_hptp(String Sd_hptp) {
		setAttrVal("Sd_hptp", Sd_hptp);
	}
	/**
	 * 医保计划编码
	 * @return String
	 */
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}	
	/**
	 * 医保计划编码
	 * @param Code_hp
	 */
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	/**
	 * 医保计划名称
	 * @return String
	 */
	public String getName_hp() {
		return ((String) getAttrVal("Name_hp"));
	}	
	/**
	 * 医保计划名称
	 * @param Name_hp
	 */
	public void setName_hp(String Name_hp) {
		setAttrVal("Name_hp", Name_hp);
	}
	/**
	 * 医保号
	 * @return String
	 */
	public String getNo_hp() {
		return ((String) getAttrVal("No_hp"));
	}	
	/**
	 * 医保号
	 * @param No_hp
	 */
	public void setNo_hp(String No_hp) {
		setAttrVal("No_hp", No_hp);
	}
	/**
	 * 个人编号
	 * @return String
	 */
	public String getPersonno() {
		return ((String) getAttrVal("Personno"));
	}	
	/**
	 * 个人编号
	 * @param Personno
	 */
	public void setPersonno(String Personno) {
		setAttrVal("Personno", Personno);
	}
	/**
	 * 主医保标识
	 * @return String
	 */
	public String getFg_maj() {
		return ((String) getAttrVal("Fg_maj"));
	}	
	/**
	 * 主医保标识
	 * @param Fg_maj
	 */
	public void setFg_maj(String Fg_maj) {
		setAttrVal("Fg_maj", Fg_maj);
	}
	/**
	 * 持卡结算标识
	 * @return String
	 */
	public String getFg_hp_card() {
		return ((String) getAttrVal("Fg_hp_card"));
	}	
	/**
	 * 持卡结算标识
	 * @param Fg_hp_card
	 */
	public void setFg_hp_card(String Fg_hp_card) {
		setAttrVal("Fg_hp_card", Fg_hp_card);
	}
	/**
	 * 医保基金支付标识
	 * @return String
	 */
	public String getFg_fundpay() {
		return ((String) getAttrVal("Fg_fundpay"));
	}	
	/**
	 * 医保基金支付标识
	 * @param Fg_fundpay
	 */
	public void setFg_fundpay(String Fg_fundpay) {
		setAttrVal("Fg_fundpay", Fg_fundpay);
	}
	/**
	 * 特病标识
	 * @return String
	 */
	public String getFg_hpspcl() {
		return ((String) getAttrVal("Fg_hpspcl"));
	}	
	/**
	 * 特病标识
	 * @param Fg_hpspcl
	 */
	public void setFg_hpspcl(String Fg_hpspcl) {
		setAttrVal("Fg_hpspcl", Fg_hpspcl);
	}
	/**
	 * 险种编码
	 * @return String
	 */
	public String getCode_hpkind() {
		return ((String) getAttrVal("Code_hpkind"));
	}	
	/**
	 * 险种编码
	 * @param Code_hpkind
	 */
	public void setCode_hpkind(String Code_hpkind) {
		setAttrVal("Code_hpkind", Code_hpkind);
	}
	/**
	 * 医保身份编码
	 * @return String
	 */
	public String getCode_hppatca() {
		return ((String) getAttrVal("Code_hppatca"));
	}	
	/**
	 * 医保身份编码
	 * @param Code_hppatca
	 */
	public void setCode_hppatca(String Code_hppatca) {
		setAttrVal("Code_hppatca", Code_hppatca);
	}
	/**
	 * 医保统筹区域
	 * @return String
	 */
	public String getCode_hparea() {
		return ((String) getAttrVal("Code_hparea"));
	}	
	/**
	 * 医保统筹区域
	 * @param Code_hparea
	 */
	public void setCode_hparea(String Code_hparea) {
		setAttrVal("Code_hparea", Code_hparea);
	}
	/**
	 * 医疗类别
	 * @return String
	 */
	public String getCode_hpmedkind() {
		return ((String) getAttrVal("Code_hpmedkind"));
	}	
	/**
	 * 医疗类别
	 * @param Code_hpmedkind
	 */
	public void setCode_hpmedkind(String Code_hpmedkind) {
		setAttrVal("Code_hpmedkind", Code_hpmedkind);
	}
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
}