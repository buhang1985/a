package iih.en.pv.out.ws.bean;

import iih.bd.webservice.BaseWsParam;

import java.io.Serializable;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 医保信息
 * 
 * @author liubin
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class EntHpBean extends BaseWsParam implements Serializable {

	/**
     * 
     */
	private static final long serialVersionUID = 1L;
	
	//就诊编号
	private String Id_ent = "";
	
	//编号
	private String Sortno = "";
	
	//医保类型 
	private String Sd_hptp = "";
	
	//医保计划编码
	private String Code_hp = "";
	

	//医保计划名称
	private String Name_hp = "";
	
	//医保号
	private String No_hp = "";
	
	//个人编码
	private String Personno = "";
	
	//主医保标识
	private String Fg_maj = "";
	
	//持卡结算标识
	private String Fg_hp_card = "";
	
	//医保基金支付表示
	private String Fg_fundpay = "";
	
	//特病标识 
	private String Fg_hpspcl = "";
	
	//险种标识
	private String Code_hpkind = "";
	
	//医保身份编码
	private String Code_hppatca = "";
	
	//医保统筹区域
	private String Code_hparea = "";
	
	//医疗类别
	private String Code_hpmedkind = "";
	
	public String getId_ent() {
		return Id_ent;
	}

	public void setId_ent(String id_ent) {
		Id_ent = id_ent;
	}

	public String getSortno() {
		return Sortno;
	}

	public void setSortno(String sortno) {
		Sortno = sortno;
	}

	public String getSd_hptp() {
		return Sd_hptp;
	}

	public void setSd_hptp(String sd_hptp) {
		Sd_hptp = sd_hptp;
	}

	public String getCode_hp() {
		return Code_hp;
	}

	public void setCode_hp(String code_hp) {
		Code_hp = code_hp;
	}

	public String getName_hp() {
		return Name_hp;
	}

	public void setName_hp(String name_hp) {
		Name_hp = name_hp;
	}

	public String getNo_hp() {
		return No_hp;
	}

	public void setNo_hp(String no_hp) {
		No_hp = no_hp;
	}

	public String getPersonno() {
		return Personno;
	}

	public void setPersonno(String personno) {
		Personno = personno;
	}

	public String getFg_maj() {
		return Fg_maj;
	}

	public void setFg_maj(String fg_maj) {
		Fg_maj = fg_maj;
	}

	public String getFg_hp_card() {
		return Fg_hp_card;
	}

	public void setFg_hp_card(String fg_hp_card) {
		Fg_hp_card = fg_hp_card;
	}

	public String getFg_fundpay() {
		return Fg_fundpay;
	}

	public void setFg_fundpay(String fg_fundpay) {
		Fg_fundpay = fg_fundpay;
	}

	public String getFg_hpspcl() {
		return Fg_hpspcl;
	}

	public void setFg_hpspcl(String fg_hpspcl) {
		Fg_hpspcl = fg_hpspcl;
	}

	public String getCode_hpkind() {
		return Code_hpkind;
	}

	public void setCode_hpkind(String code_hpkind) {
		Code_hpkind = code_hpkind;
	}

	public String getCode_hppatca() {
		return Code_hppatca;
	}

	public void setCode_hppatca(String code_hppatca) {
		Code_hppatca = code_hppatca;
	}

	public String getCode_hparea() {
		return Code_hparea;
	}

	public void setCode_hparea(String code_hparea) {
		Code_hparea = code_hparea;
	}

	public String getCode_hpmedkind() {
		return Code_hpmedkind;
	}

	public void setCode_hpmedkind(String code_hpmedkind) {
		Code_hpmedkind = code_hpmedkind;
	}

		
	
}
