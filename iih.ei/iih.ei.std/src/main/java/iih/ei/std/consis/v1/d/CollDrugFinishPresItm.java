package iih.ei.std.consis.v1.d;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class CollDrugFinishPresItm {

	@XmlElement(name = "ADVICE_CODE")
	private String id_or;
	@XmlElement(name = "DRUG_CODE")
	private String code_drug;
	@XmlElement(name = "QUANTITY")
	private String quan;

	public String getId_or() {
		return id_or;
	}

	public void setId_or(String id_or) {
		this.id_or = id_or;
	}

	public String getCode_drug() {
		return code_drug;
	}

	public void setCode_drug(String code_drug) {
		this.code_drug = code_drug;
	}

	public String getQuan() {
		return quan;
	}

	public void setQuan(String quan) {
		this.quan = quan;
	}
}
