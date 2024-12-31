package iih.en.pv.out.ws.bean;

import iih.bd.webservice.BaseWsParam;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 床位记录信息
 * 
 * @author liubin
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class EntBedBean extends BaseWsParam implements Serializable {

	/**
     * 
     */
	private static final long serialVersionUID = 1L;
	
	//就诊id
	private String Id_ent = "";

	// 编号
	private String Sortno = "";

	// 床位编码
	private String Code_bed = "";
	
	//床位名称
	private String Name_bed = "";
	
	//床所属病区编码
	private String Code_dep_nur = "";
	
	//床所属病区名称
	private String Name_dep_nur = "";
	
	//床位占用类型编码
	private String Sd_usetype = "";
	
	//床位占用类型名称
	private String Name_usetype= "";
	
	//开始时间
	private String Dt_b = "";
	
	//结束 时间
	private String Dt_e = "";
	
	//最近收费时间
	private String Dt_chg_bill = "";
	

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

	public String getCode_bed() {
		return Code_bed;
	}

	public void setCode_bed(String code_bed) {
		Code_bed = code_bed;
	}

	public String getName_bed() {
		return Name_bed;
	}

	public void setName_bed(String name_bed) {
		Name_bed = name_bed;
	}

	public String getCode_dep_nur() {
		return Code_dep_nur;
	}

	public void setCode_dep_nur(String code_dep_nur) {
		Code_dep_nur = code_dep_nur;
	}

	public String getName_dep_nur() {
		return Name_dep_nur;
	}

	public void setName_dep_nur(String name_dep_nur) {
		Name_dep_nur = name_dep_nur;
	}

	public String getSd_usetype() {
		return Sd_usetype;
	}

	public void setSd_usetype(String sd_usetype) {
		Sd_usetype = sd_usetype;
	}

	public String getName_usetype() {
		return Name_usetype;
	}

	public void setName_usetype(String name_usetype) {
		Name_usetype = name_usetype;
	}

	public String getDt_b() {
		return Dt_b;
	}

	public void setDt_b(String dt_b) {
		Dt_b = dt_b;
	}

	public String getDt_e() {
		return Dt_e;
	}

	public void setDt_e(String dt_e) {
		Dt_e = dt_e;
	}

	public String getDt_chg_bill() {
		return Dt_chg_bill;
	}

	public void setDt_chg_bill(String dt_chg_bill) {
		Dt_chg_bill = dt_chg_bill;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
