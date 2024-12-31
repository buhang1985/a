package iih.en.pv.out.ws.bean;

import iih.bd.webservice.BaseWsParam;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 就诊状况信息
 * 
 * @author liubin
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class EntStateBean extends BaseWsParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//就诊id
	private String Id_ent = "";

	// 状况类型编码
	private String Sd_enstatetp = "";

	// 状况类型名称
	private String Name_enstatetp = "";

	// 状况值
	private String Val = "";

	// 状况值名称
	private String Name = "";

	// 发生时间
	private String Dt_occ = "";

	public String getId_ent() {
		return Id_ent;
	}

	public void setId_ent(String id_ent) {
		Id_ent = id_ent;
	}

	public String getSd_enstatetp() {
		return Sd_enstatetp;
	}

	public void setSd_enstatetp(String sd_enstatetp) {
		Sd_enstatetp = sd_enstatetp;
	}

	public String getName_enstatetp() {
		return Name_enstatetp;
	}

	public void setName_enstatetp(String name_enstatetp) {
		Name_enstatetp = name_enstatetp;
	}

	public String getVal() {
		return Val;
	}

	public void setVal(String val) {
		Val = val;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDt_occ() {
		return Dt_occ;
	}

	public void setDt_occ(String dt_occ) {
		Dt_occ = dt_occ;
	}

	@Override
	public String toString() {
		return "EntStateBean [Id_ent=" + Id_ent + ", Sd_enstatetp=" + Sd_enstatetp + ", Name_enstatetp="
				+ Name_enstatetp + ", Val=" + Val + ", Name=" + Name + ", Dt_occ=" + Dt_occ + "]";
	}
	
}
