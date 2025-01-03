package iih.ci.rcm;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 
 * @author tangws
 * @date 2017年3月30日 下午3:04:17
 *
 */
public class ContagionPrintDTO {
	private String id_contagion;// 报告卡ID
	
	private String id_form;//formid

	private String cardNum;// 卡片编号

	private String cardType;// 报卡类别

	private String patName;// 患者姓名

	private String patFamily;// 患者家长

	private String certificate;// 有效证件号

	private String patSex;// 患者性别

	private String birth;// 患者出生日期

	private String age;// 年龄

	private String ageUnit;// 年龄单位

	private String workplace;// 工作单位

	private String contact;// 联系方式

	private String patBelong;// 病人属于

	private String nowAddress;// 现住址

	private String province;// 省

	private String city;// 市

	private String area;// 区县

	private String towns;// 乡镇

	private String village;// 村

	private String houseNum;// 门牌号

	private String residence;// 戶籍地址

	private String residenceProvince;

	private String residenceCity;

	private String residenceCounty;
	
	private String rtowns;

	private String rvillage;

	private String rhouseNum;

	private String houseAddr;// 入院科室名称

	private String hprovince;// 户籍省

	private String harea;// 户籍区县

	private String hcity;// 户籍市;

	private String peopleType;// 人群分类
	
	private String rqfl_name;
	
	private String rqfl_code;

	private String morbidityDate;// 发病日期

	private String diagnoseDate;// 诊断日期

	private String deadDate;// 死亡日期

	private String caseType;// 病历分类

	private String caseTyp;// 病情分类

	private String acontagion;// 甲类传染病

	private String bcontagion;// 乙类传染病

	private String eu_ylcrb_name;// 乙类传染病（其它）

	private String ccontagion;// 丙类传染病

	private String eu_blcrb_name;// 丙类传染病（其它）

	private String qcontagion;// 其它传染病

	private String name_other_diseases;// 其它类传染病（其它）

	private String alike;// 相同症状

	private String diseaseName;// 订正病名

	private String returnRe;// 退卡原因

	private String repotrby;// 报告单位

	private String phone;// 联系电话

	private String doctor;// 报卡医生

	private String madeTime;// 填卡日期

	private String conment;// 备注
	
	private String docdep;// 报告科室

	private List<ContagionAids> aidsList;// 艾滋病附卡

	private List<ContagionStdDTO> stdList;// 性病附卡

	private List<ContagionHBDTO> hbList;// 乙肝附卡

	private List<SysphilisDTO> syList;// 梅毒附卡

	private List<ContagionHFMDTO> hfmdList;// 手足口病附卡

	private List<CondylomaDTO> caList;// 尖锐湿疣附卡
	
	private List<ContagionNCPDTO> ncpList;// 新冠肺炎附卡

	public String getId_contagion() {
		return id_contagion;
	}

	public void setId_contagion(String id_contagion) {
		this.id_contagion = id_contagion;
	}

	public String getId_form() {
		return id_form;
	}

	public void setId_form(String id_form) {
		this.id_form = id_form;
	}
	
	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getPatName() {
		return patName;
	}

	public void setPatName(String patName) {
		this.patName = patName;
	}

	public String getPatFamily() {
		return patFamily;
	}

	public void setPatFamily(String patFamily) {
		this.patFamily = patFamily;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getPatSex() {
		return patSex;
	}

	public void setPatSex(String patSex) {
		this.patSex = patSex;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null; 		
		date = sdf.parse(birth);		
		if(date!=null)
		{
			DateFormat format = new SimpleDateFormat("yyyy年MM月dd日");   			  
			String str = format.format(date);
			this.birth = str;			
		}else
		{
			this.birth = birth;			
		}
		//this.birth = birth;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAgeUnit() {
		return ageUnit;
	}

	public void setAgeUnit(String ageUnit) {
		this.ageUnit = ageUnit;
	}

	public String getWorkplace() {
		return workplace;
	}

	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPatBelong() {
		return patBelong;
	}

	public void setPatBelong(String patBelong) {
		this.patBelong = patBelong;
	}

	public String getNowAddress() {
		return nowAddress;
	}

	public void setNowAddress(String nowAddress) {
		this.nowAddress = nowAddress;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getTowns() {
		return towns;
	}

	public void setTowns(String towns) {
		this.towns = towns;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}

	public String getRtowns() {
		return rtowns;
	}

	public void setRtowns(String rtowns) {
		this.rtowns = rtowns;
	}

	public String getRvillage() {
		return rvillage;
	}

	public void setRvillage(String rvillage) {
		this.rvillage = rvillage;
	}

	public String getRhouseNum() {
		return rhouseNum;
	}

	public void setRhouseNum(String rhouseNum) {
		this.rhouseNum = rhouseNum;
	}

	
	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public String getResidenceProvince() {
		return residenceProvince;
	}

	public void setResidenceProvince(String residenceProvince) {
		this.residenceProvince = residenceProvince;
	}

	public String getResidenceCity() {
		return residenceCity;
	}

	public void setResidenceCity(String residenceCity) {
		this.residenceCity = residenceCity;
	}

	public String getResidenceCounty() {
		return residenceCounty;
	}

	public void setResidenceCounty(String residenceCounty) {
		this.residenceCounty = residenceCounty;
	}

	public String getHouseAddr() {
		return houseAddr;
	}

	public void setHouseAddr(String houseAddr) {
		this.houseAddr = houseAddr;
	}

	public String getHprovince() {
		return hprovince;
	}

	public void setHprovince(String hprovince) {
		this.hprovince = hprovince;
	}

	public String getHarea() {
		return harea;
	}

	public void setHarea(String harea) {
		this.harea = harea;
	}

	public String getHcity() {
		return hcity;
	}

	public void setHcity(String hcity) {
		this.hcity = hcity;
	}

	public String getPeopleType() {
		return peopleType;
	}

	public void setPeopleType(String peopleType) {
		this.peopleType = peopleType;
	}
	
	public String getRqfl_code(){
		return rqfl_code;
	}

	public void setRqfl_code(String rqfl_code){
		this.rqfl_code = rqfl_code;
	}
	
	public String getRqfl_name(){
		return rqfl_name;
	}

	public void setRqfl_name(String rqfl_name){
		this.rqfl_name = rqfl_name;
	}
	
	public String getMorbidityDate() {
		return morbidityDate;
	}

	public void setMorbidityDate(String morbidityDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null; 		
		date = sdf.parse(morbidityDate);		
		if(date!=null)
		{
			DateFormat format = new SimpleDateFormat("yyyy年MM月dd日");   			  
			String str = format.format(date);
			this.morbidityDate = str;			
		}else
		{
			this.morbidityDate = morbidityDate;			
		}
	}

	public String getDiagnoseDate() {
		return diagnoseDate;
	}

	public void setDiagnoseDate(String diagnoseDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
		java.util.Date date = null; 		
		date = sdf.parse(diagnoseDate);		
		if(date!=null)
		{
			DateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH时");   			  
			String str = format.format(date);
			this.diagnoseDate = str;			
		}else
		{
			this.diagnoseDate = diagnoseDate;			
		}
		//this.diagnoseDate = diagnoseDate;
	}

	public String getDeadDate() {
		return deadDate;
	}

	public void setDeadDate(String deadDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null; 		
		date = sdf.parse(deadDate);		
		if(date!=null)
		{
			DateFormat format = new SimpleDateFormat("yyyy年MM月dd日");   			  
			String str = format.format(date);
			this.deadDate = str;			
		}else
		{
			this.deadDate = deadDate;			
		}
		//this.deadDate = deadDate;
	}

	public String getCaseType() {
		return caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	public String getAcontagion() {
		return acontagion;
	}

	public void setAcontagion(String acontagion) {
		this.acontagion = acontagion;
	}

	public String getBcontagion() {
		return bcontagion;
	}

	public void setBcontagion(String bcontagion) {
		this.bcontagion = bcontagion;
	}

	public String getCcontagion() {
		return ccontagion;
	}

	public void setCcontagion(String ccontagion) {
		this.ccontagion = ccontagion;
	}

	public String getQcontagion() {
		return qcontagion;
	}

	public void setQcontagion(String qcontagion) {
		this.qcontagion = qcontagion;
	}

	public String getEu_ylcrb_name() {
		return eu_ylcrb_name;
	}

	public void setEu_ylcrb_name(String eu_ylcrb_name) {
		this.eu_ylcrb_name = eu_ylcrb_name;
	}

	public String getEu_blcrb_name() {
		return eu_blcrb_name;
	}

	public void setEu_blcrb_name(String eu_blcrb_name) {
		this.eu_blcrb_name = eu_blcrb_name;
	}

	public String getName_other_diseases() {
		return name_other_diseases;
	}

	public void setName_other_diseases(String name_other_diseases) {
		this.name_other_diseases = name_other_diseases;
	}

	public String getDiseaseName() {
		return diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public String getReturnRe() {
		return returnRe;
	}

	public void setReturnRe(String returnRe) {
		this.returnRe = returnRe;
	}

	public String getRepotrby() {
		return repotrby;
	}

	public void setRepotrby(String repotrby) {
		this.repotrby = repotrby;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public String getDocdep() {
		return docdep;
	}

	public void setDocdep(String doctor) {
		this.docdep = doctor;
	}

	public String getAlike() {
		return alike;
	}

	public void setAlike(String alike) {
		this.alike = alike;
	}

	public String getMadeTime() {
		return madeTime;
	}

	public void setMadeTime(String madeTime) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null; 		
		date = sdf.parse(madeTime);		
		if(date!=null)
		{
			DateFormat format = new SimpleDateFormat("yyyy年MM月dd日");   			  
			String str = format.format(date);
			this.madeTime = str;			
		}else
		{
			this.madeTime = madeTime;			
		}
		//this.madeTime = madeTime;
	}

	public String getConment() {
		return conment;
	}

	public void setConment(String conment) {
		this.conment = conment;
	}

	public List<ContagionAids> getAidsList() {
		return aidsList;
	}

	public void setAidsList(List<ContagionAids> aidsList) {
		this.aidsList = aidsList;
	}

	public List<SysphilisDTO> getSyList() {
		return syList;
	}

	public void setSyList(List<SysphilisDTO> syList) {
		this.syList = syList;
	}

	public List<ContagionHFMDTO> getHfmdList() {
		return hfmdList;
	}

	public void setHfmdList(List<ContagionHFMDTO> hfmdList) {
		this.hfmdList = hfmdList;
	}

	public List<ContagionStdDTO> getStdList() {
		return stdList;
	}

	public void setStdList(List<ContagionStdDTO> stdList) {
		this.stdList = stdList;
	}

	public List<ContagionHBDTO> getHbList() {
		return hbList;
	}

	public void setHbList(List<ContagionHBDTO> hbList) {
		this.hbList = hbList;
	}

	public List<CondylomaDTO> getCaList() {
		return caList;
	}

	public void setCaList(List<CondylomaDTO> caList) {
		this.caList = caList;
	}

	public String getCaseTyp() {
		return caseTyp;
	}

	public void setCaseTyp(String caseTyp) {
		this.caseTyp = caseTyp;
	}
	
	public List<ContagionNCPDTO> getNcpList() {
		return ncpList;
	}

	public void setNcpList(List<ContagionNCPDTO> ncpList) {
		this.ncpList = ncpList;
	}
}
