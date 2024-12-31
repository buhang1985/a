package iih.ci.rcm;

import xap.mw.core.data.*;
/**
 * 医院感染现患率调查打印 DTO数据 
 * 
 */
public class InfectionprePrintDTO extends BaseDTO {
	private String id_infection;
	private String codePat; 
	private String namePat;
	private String nameSex;
	private String age;
	private String codeAmrIp;
	private String nameBed;
	private String nameDepPhy;
	private String investtime;
	private String modifytime;
	private String idPsn;
	private String serialNumber;
	private String diagnosis;
	private String infectsite;
	private String pathogen;
    private String nosoInfection;  // 医院感染
	
	private String hbsAgPositive; // HBsAg阳性
	private String hcvPositive; // 抗-HCV阳性
	private String hivPositive; // 抗-HIV阳性
	
    private String arteIntubation; // 动静脉插管
	private String urinIntubatton;  //泌尿道插管
	private String ventilatorUse; // 使用呼吸机
	private String intravenous; // 静脉输液
	
	private String antibioticsUse; // 抗菌药物使用
	private String purpose; // 目的
	private String combinedUse; //联用
	private String bactCulture; // 细菌培养
	
	private String operation; // 手术
	private String preUseAntibiotic;  // 术前应用抗生素
	private String surgPharmacy; // 外科手术期用药
	private String surgIncision; // 手术切口
	
	public String getId_infection() {
		return id_infection;
	}
	public void setId_infection(String id_infection) {
		this.id_infection = id_infection;
	}
	public String getCodePat() {
		return codePat;
	}
	public void setCodePat(String codePat) {
		this.codePat = codePat;
	}
	public String getNamePat() {
		return namePat;
	}
	public void setNamePat(String namePat) {
		this.namePat = namePat;
	}
	public String getNameSex() {
		return nameSex;
	}
	public void setNameSex(String nameSex) {
		this.nameSex = nameSex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCodeAmrIp() {
		return codeAmrIp;
	}
	public void setCodeAmrIp(String codeAmrIp) {
		this.codeAmrIp = codeAmrIp;
	}
	public String getNameBed() {
		return nameBed;
	}
	public void setNameBed(String nameBed) {
		this.nameBed = nameBed;
	}
	public String getNameDepPhy() {
		return nameDepPhy;
	}
	public void setNameDepPhy(String nameDepPhy) {
		this.nameDepPhy = nameDepPhy;
	}
	public String getInvesttime() {
		return investtime;
	}
	public void setInvesttime(String investtime) {
		this.investtime = investtime;
	}
	public String getModifytime() {
		return modifytime;
	}
	public void setModifytime(String modifytime) {
		this.modifytime = modifytime;
	}
	public String getIdPsn() {
		return idPsn;
	}
	public void setIdPsn(String idPsn) {
		this.idPsn = idPsn;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getInfectsite() {
		return infectsite;
	}
	public void setInfectsite(String infectsite) {
		this.infectsite = infectsite;
	}
	public String getPathogen() {
		return pathogen;
	}
	public void setPathogen(String pathogen) {
		this.pathogen = pathogen;
	}
	public String getHbsAgPositive() {
		return hbsAgPositive;
	}
	public void setHbsAgPositive(String hbsAgPositive) {
		this.hbsAgPositive = hbsAgPositive;
	}
	public String getHcvPositive() {
		return hcvPositive;
	}
	public void setHcvPositive(String hcvPositive) {
		this.hcvPositive = hcvPositive;
	}
	public String getHivPositive() {
		return hivPositive;
	}
	public void setHivPositive(String hivPositive) {
		this.hivPositive = hivPositive;
	}
	public String getNosoInfection() {
		return nosoInfection;
	}
	public void setNosoInfection(String nosoInfection) {
		this.nosoInfection = nosoInfection;
	}
	public String getArteIntubation() {
		return arteIntubation;
	}
	public void setArteIntubation(String arteIntubation) {
		this.arteIntubation = arteIntubation;
	}
	public String getUrinIntubatton() {
		return urinIntubatton;
	}
	public void setUrinIntubatton(String urinIntubatton) {
		this.urinIntubatton = urinIntubatton;
	}
	public String getVentilatorUse() {
		return ventilatorUse;
	}
	public void setVentilatorUse(String ventilatorUse) {
		this.ventilatorUse = ventilatorUse;
	}
	public String getIntravenous() {
		return intravenous;
	}
	public void setIntravenous(String intravenous) {
		this.intravenous = intravenous;
	}
	public String getAntibioticsUse() {
		return antibioticsUse;
	}
	public void setAntibioticsUse(String antibioticsUse) {
		this.antibioticsUse = antibioticsUse;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getCombinedUse() {
		return combinedUse;
	}
	public void setCombinedUse(String combinedUse) {
		this.combinedUse = combinedUse;
	}
	public String getBactCulture() {
		return bactCulture;
	}
	public void setBactCulture(String bactCulture) {
		this.bactCulture = bactCulture;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getPreUseAntibiotic() {
		return preUseAntibiotic;
	}
	public void setPreUseAntibiotic(String preUseAntibiotic) {
		this.preUseAntibiotic = preUseAntibiotic;
	}
	public String getSurgPharmacy() {
		return surgPharmacy;
	}
	public void setSurgPharmacy(String surgPharmacy) {
		this.surgPharmacy = surgPharmacy;
	}
	public String getSurgIncision() {
		return surgIncision;
	}
	public void setSurgIncision(String surgIncision) {
		this.surgIncision = surgIncision;
	}
}