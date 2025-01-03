package iih.pi.dic.cardtype.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者卡信息 DTO数据 
 * 
 */
public class CardDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 卡ID
	 * @return String
	 */
	public String getId_patcard() {
		return ((String) getAttrVal("Id_patcard"));
	}
	/**
	 * 卡ID
	 * @param Id_patcard
	 */
	public void setId_patcard(String Id_patcard) {
		setAttrVal("Id_patcard", Id_patcard);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 卡类型ID
	 * @return String
	 */
	public String getId_patcardtp() {
		return ((String) getAttrVal("Id_patcardtp"));
	}
	/**
	 * 卡类型ID
	 * @param Id_patcardtp
	 */
	public void setId_patcardtp(String Id_patcardtp) {
		setAttrVal("Id_patcardtp", Id_patcardtp);
	}
	/**
	 * 卡类型编码
	 * @return String
	 */
	public String getPatcardtpcode() {
		return ((String) getAttrVal("Patcardtpcode"));
	}
	/**
	 * 卡类型编码
	 * @param Patcardtpcode
	 */
	public void setPatcardtpcode(String Patcardtpcode) {
		setAttrVal("Patcardtpcode", Patcardtpcode);
	}
	/**
	 * 卡类型名称
	 * @return String
	 */
	public String getPatcardtpname() {
		return ((String) getAttrVal("Patcardtpname"));
	}
	/**
	 * 卡类型名称
	 * @param Patcardtpname
	 */
	public void setPatcardtpname(String Patcardtpname) {
		setAttrVal("Patcardtpname", Patcardtpname);
	}
	/**
	 * 卡性质ID
	 * @return String
	 */
	public String getId_cardtp() {
		return ((String) getAttrVal("Id_cardtp"));
	}
	/**
	 * 卡性质ID
	 * @param Id_cardtp
	 */
	public void setId_cardtp(String Id_cardtp) {
		setAttrVal("Id_cardtp", Id_cardtp);
	}
	/**
	 * 卡性质名称
	 * @return String
	 */
	public String getCardtpname() {
		return ((String) getAttrVal("Cardtpname"));
	}
	/**
	 * 卡性质名称
	 * @param Cardtpname
	 */
	public void setCardtpname(String Cardtpname) {
		setAttrVal("Cardtpname", Cardtpname);
	}
	/**
	 * 卡号
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 卡号
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 默认标识
	 * @return FBoolean
	 */
	public FBoolean getFg_def() {
		return ((FBoolean) getAttrVal("Fg_def"));
	}
	/**
	 * 默认标识
	 * @param Fg_def
	 */
	public void setFg_def(FBoolean Fg_def) {
		setAttrVal("Fg_def", Fg_def);
	}
	/**
	 * 有效开始日期
	 * @return FDate
	 */
	public FDate getDt_b() {
		return ((FDate) getAttrVal("Dt_b"));
	}
	/**
	 * 有效开始日期
	 * @param Dt_b
	 */
	public void setDt_b(FDate Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 有效结束日期
	 * @return FDate
	 */
	public FDate getDt_e() {
		return ((FDate) getAttrVal("Dt_e"));
	}
	/**
	 * 有效结束日期
	 * @param Dt_e
	 */
	public void setDt_e(FDate Dt_e) {
		setAttrVal("Dt_e", Dt_e);
	}
	/**
	 * 使用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_act() {
		return ((FBoolean) getAttrVal("Fg_act"));
	}
	/**
	 * 使用标志
	 * @param Fg_act
	 */
	public void setFg_act(FBoolean Fg_act) {
		setAttrVal("Fg_act", Fg_act);
	}
	/**
	 * 卡状态ID
	 * @return String
	 */
	public String getId_cardsu() {
		return ((String) getAttrVal("Id_cardsu"));
	}
	/**
	 * 卡状态ID
	 * @param Id_cardsu
	 */
	public void setId_cardsu(String Id_cardsu) {
		setAttrVal("Id_cardsu", Id_cardsu);
	}
	/**
	 * 卡状态名称
	 * @return String
	 */
	public String getCardsuname() {
		return ((String) getAttrVal("Cardsuname"));
	}
	/**
	 * 卡状态名称
	 * @param Cardsuname
	 */
	public void setCardsuname(String Cardsuname) {
		setAttrVal("Cardsuname", Cardsuname);
	}
	/**
	 * 卡主键
	 * @return String
	 */
	public String getId_card() {
		return ((String) getAttrVal("Id_card"));
	}
	/**
	 * 卡主键
	 * @param Id_card
	 */
	public void setId_card(String Id_card) {
		setAttrVal("Id_card", Id_card);
	}
	/**
	 * 患者编号
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编号
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
}