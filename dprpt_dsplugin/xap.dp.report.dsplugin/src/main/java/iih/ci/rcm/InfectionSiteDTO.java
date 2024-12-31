package iih.ci.rcm;

public class InfectionSiteDTO {

	private String serialNumber;// 诊断序号
	private String nameDiDiagnosis;// 诊断
	private String nameInfecteSite;// 医院感染部位
	private String namePathogen;// 病原体
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getNameDiDiagnosis() {
		return nameDiDiagnosis;
	}
	public void setNameDiDiagnosis(String nameDiDiagnosis) {
		this.nameDiDiagnosis = nameDiDiagnosis;
	}
	public String getNameInfecteSite() {
		return nameInfecteSite;
	}
	public void setNameInfecteSite(String nameInfecteSite) {
		this.nameInfecteSite = nameInfecteSite;
	}
	public String getNamePathogen() {
		return namePathogen;
	}
	public void setNamePathogen(String namePathogen) {
		this.namePathogen = namePathogen;
	}
	
}
