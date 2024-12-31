package iih.ci.rcm;

public class MedicalSharpInjuryPrintDTO {
	private String id_msinjury;
	private String namePat; // 姓名
	private String nameSex; // 性别
	private String nameDepPhy; // 科室
	private String workage; // 工龄
	private String injuryTime; //受伤时间
	private String isVaccinatedHbv; // 被刺伤前是否接种过乙肝疫苗
	private String idTimeVah; // 注射时间
	private String nameWork; // 工作类别
	private String nameDamLoc; // 伤害发生的地点
	private String nameSharp; // 导致伤害发生的锐器物种类
	private String idDamReason; // 伤害发生的原因
	private String initialUser; // 受伤者是锐器的最初使用者
	private String nameSharpPurpose; // 锐器最初是用于什么目的
	private String idMisoperation; // 伤害的发生有无不正确操作
	private String idSharpBlood; // 是否被血污染的锐器物刺伤
	private String bloodBorneDiseases; // 受伤前是否知道病人有无经血液传播的疾病
	private String patientRelated; // 受伤是否与病人有关
	private String idPatHbv; // 有无乙肝
	private String idPatHcv; // 有无丙肝
	private String idPatAids; // 有无艾滋病
	private String idPatSyphilis; // 有无梅毒
	private String hbsagPositive; // 乙肝表面抗原阳性
	private String rprPositive; // RPR阳性
	private String tpPositive; // TP阳性
	private String nameOperStep; // 伤害发生的操作环节
	private String nameWoundTreat; // 受伤后伤口如何处理
	private String idGlove; // 如果受伤部位是手锐器穿透了
	private String idSeverityInjury; // 受伤程度
	private String idSharpUserHandedness; // 锐器使用者习惯
	private String staffLabExamfee; // 员工实验室检查费
	private String patLabExamfee; // 病人实验室检查费
	private String staffTreatfee; // 员工治疗费
	private String patTreatfee; // 病人治疗费
	private String otherExpense; // 其他费用
	private String totalCost; // 总费用
	private String daysOffNum; // 离岗天数
	private String victimProcess; // 受害发生的过程
	
	public String getId_msinjury() {
		return id_msinjury;
	}
	public void setId_msinjury(String id_msinjury) {
		this.id_msinjury = id_msinjury;
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
	public String getNameDepPhy() {
		return nameDepPhy;
	}
	public void setNameDepPhy(String nameDepPhy) {
		this.nameDepPhy = nameDepPhy;
	}
	public String getWorkage() {
		return workage;
	}
	public void setWorkage(String workage) {
		this.workage = workage;
	}
	public String getInjuryTime() {
		return injuryTime;
	}
	public void setInjuryTime(String injuryTime) {
		this.injuryTime = injuryTime;
	}
	public String getIsVaccinatedHbv() {
		return isVaccinatedHbv;
	}
	public void setIsVaccinatedHbv(String isVaccinatedHbv) {
		this.isVaccinatedHbv = isVaccinatedHbv;
	}
	public String getIdTimeVah() {
		return idTimeVah;
	}
	public void setIdTimeVah(String idTimeVah) {
		this.idTimeVah = idTimeVah;
	}
	public String getNameWork() {
		return nameWork;
	}
	public void setNameWork(String nameWork) {
		this.nameWork = nameWork;
	}
	public String getNameDamLoc() {
		return nameDamLoc;
	}
	public void setNameDamLoc(String nameDamLoc) {
		this.nameDamLoc = nameDamLoc;
	}
	public String getNameSharp() {
		return nameSharp;
	}
	public void setNameSharp(String nameSharp) {
		this.nameSharp = nameSharp;
	}
	public String getIdDamReason() {
		return idDamReason;
	}
	public void setIdDamReason(String idDamReason) {
		this.idDamReason = idDamReason;
	}
	public String getInitialUser() {
		return initialUser;
	}
	public void setInitialUser(String initialUser) {
		this.initialUser = initialUser;
	}
	public String getNameSharpPurpose() {
		return nameSharpPurpose;
	}
	public void setNameSharpPurpose(String nameSharpPurpose) {
		this.nameSharpPurpose = nameSharpPurpose;
	}
	public String getIdMisoperation() {
		return idMisoperation;
	}
	public void setIdMisoperation(String idMisoperation) {
		this.idMisoperation = idMisoperation;
	}
	public String getIdSharpBlood() {
		return idSharpBlood;
	}
	public void setIdSharpBlood(String idSharpBlood) {
		this.idSharpBlood = idSharpBlood;
	}
	public String getBloodBorneDiseases() {
		return bloodBorneDiseases;
	}
	public void setBloodBorneDiseases(String bloodBorneDiseases) {
		this.bloodBorneDiseases = bloodBorneDiseases;
	}
	public String getPatientRelated() {
		return patientRelated;
	}
	public void setPatientRelated(String patientRelated) {
		this.patientRelated = patientRelated;
	}
	public String getIdPatHbv() {
		return idPatHbv;
	}
	public void setIdPatHbv(String idPatHbv) {
		this.idPatHbv = idPatHbv;
	}
	public String getIdPatHcv() {
		return idPatHcv;
	}
	public void setIdPatHcv(String idPatHcv) {
		this.idPatHcv = idPatHcv;
	}
	public String getIdPatAids() {
		return idPatAids;
	}
	public void setIdPatAids(String idPatAids) {
		this.idPatAids = idPatAids;
	}
	public String getIdPatSyphilis() {
		return idPatSyphilis;
	}
	public void setIdPatSyphilis(String idPatSyphilis) {
		this.idPatSyphilis = idPatSyphilis;
	}
	public String getHbsagPositive() {
		return hbsagPositive;
	}
	public void setHbsagPositive(String hbsagPositive) {
		this.hbsagPositive = hbsagPositive;
	}
	public String getRprPositive() {
		return rprPositive;
	}
	public void setRprPositive(String rprPositive) {
		this.rprPositive = rprPositive;
	}
	public String getTpPositive() {
		return tpPositive;
	}
	public void setTpPositive(String tpPositive) {
		this.tpPositive = tpPositive;
	}
	public String getNameOperStep() {
		return nameOperStep;
	}
	public void setNameOperStep(String nameOperStep) {
		this.nameOperStep = nameOperStep;
	}
	public String getNameWoundTreat() {
		return nameWoundTreat;
	}
	public void setNameWoundTreat(String nameWoundTreat) {
		this.nameWoundTreat = nameWoundTreat;
	}
	public String getIdGlove() {
		return idGlove;
	}
	public void setIdGlove(String idGlove) {
		this.idGlove = idGlove;
	}
	public String getIdSeverityInjury() {
		return idSeverityInjury;
	}
	public void setIdSeverityInjury(String idSeverityInjury) {
		this.idSeverityInjury = idSeverityInjury;
	}
	public String getIdSharpUserHandedness() {
		return idSharpUserHandedness;
	}
	public void setIdSharpUserHandedness(String idSharpUserHandedness) {
		this.idSharpUserHandedness = idSharpUserHandedness;
	}
	public String getStaffLabExamfee() {
		return staffLabExamfee;
	}
	public void setStaffLabExamfee(String staffLabExamfee) {
		this.staffLabExamfee = staffLabExamfee;
	}
	public String getPatLabExamfee() {
		return patLabExamfee;
	}
	public void setPatLabExamfee(String patLabExamfee) {
		this.patLabExamfee = patLabExamfee;
	}
	public String getStaffTreatfee() {
		return staffTreatfee;
	}
	public void setStaffTreatfee(String staffTreatfee) {
		this.staffTreatfee = staffTreatfee;
	}
	public String getPatTreatfee() {
		return patTreatfee;
	}
	public void setPatTreatfee(String patTreatfee) {
		this.patTreatfee = patTreatfee;
	}
	public String getOtherExpense() {
		return otherExpense;
	}
	public void setOtherExpense(String otherExpense) {
		this.otherExpense = otherExpense;
	}
	public String getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}
	public String getDaysOffNum() {
		return daysOffNum;
	}
	public void setDaysOffNum(String daysOffNum) {
		this.daysOffNum = daysOffNum;
	}
	public String getVictimProcess() {
		return victimProcess;
	}
	public void setVictimProcess(String victimProcess) {
		this.victimProcess = victimProcess;
	}
}
