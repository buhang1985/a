package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院病理联系人dto DTO数据 
 * 
 */
public class IEIpPathContactDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 联系人id
	 * @return String
	 */
	public String getId_contact() {
		return ((String) getAttrVal("Id_contact"));
	}
	/**
	 * 联系人id
	 * @param Id_contact
	 */
	public void setId_contact(String Id_contact) {
		setAttrVal("Id_contact", Id_contact);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_patient() {
		return ((String) getAttrVal("Id_patient"));
	}
	/**
	 * 患者id
	 * @param Id_patient
	 */
	public void setId_patient(String Id_patient) {
		setAttrVal("Id_patient", Id_patient);
	}
	/**
	 * 联系人电话
	 * @return String
	 */
	public String getContacttelephone() {
		return ((String) getAttrVal("Contacttelephone"));
	}
	/**
	 * 联系人电话
	 * @param Contacttelephone
	 */
	public void setContacttelephone(String Contacttelephone) {
		setAttrVal("Contacttelephone", Contacttelephone);
	}
	/**
	 * 联系人姓名
	 * @return String
	 */
	public String getContactname() {
		return ((String) getAttrVal("Contactname"));
	}
	/**
	 * 联系人姓名
	 * @param Contactname
	 */
	public void setContactname(String Contactname) {
		setAttrVal("Contactname", Contactname);
	}
}