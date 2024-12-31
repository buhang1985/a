package iih.ci.rcm;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CondylomaDTO {
	private String disease;// 疾病名称
	private String contactHistory;// 接触史
	private String stdHistory;// 性病史
	private String infection;// 感染途径
	private String sampSource;// 样本来源
	private String concluson;// 实验室检测结论
	private String alike;//

	// 第二次改版新增字段
	private String card_no;
	private String pat_name;
	private String parent_name;
	private String name_marry;
	private String nation;
	private String culture;
	private String name_hjsy;
	private String hjdz;
	private String province;
	private String city;
	private String county;
	private String town;
	private String village;
	private String house_no;
	private String case1;
	private String case2;
	private String case3;
	private String case4;// 接触史“其它”
	private String comfirm_date;// 确诊日期
	private String comfirm_unit;// 确诊单位
	private String report_doctor;
	private String report_date;

	private String pro1;
	private String pro2;
	private String pro3;
	private String pro4;
	private String pro5;
	private String pro6;
	private String pro7;
	private String pro8;
	private String pro9;
	private String pro10;

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getContactHistory() {
		return contactHistory;
	}

	public void setContactHistory(String contactHistory) {
		this.contactHistory = contactHistory;
	}

	public String getStdHistory() {
		return stdHistory;
	}

	public void setStdHistory(String stdHistory) {
		this.stdHistory = stdHistory;
	}

	public String getInfection() {
		return infection;
	}

	public void setInfection(String infection) {
		this.infection = infection;
	}

	public String getSampSource() {
		return sampSource;
	}

	public void setSampSource(String sampSource) {
		this.sampSource = sampSource;
	}

	public String getConcluson() {
		return concluson;
	}

	public void setConcluson(String concluson) {
		this.concluson = concluson;
	}

	public String getAlike() {
		return alike;
	}

	public void setAlike(String alike) {
		this.alike = alike;
	}

	public String getCard_no() {
		return card_no;
	}

	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}

	public String getPat_name() {
		return pat_name;
	}

	public void setPat_name(String pat_name) {
		this.pat_name = pat_name;
	}

	public String getParent_name() {
		return parent_name;
	}

	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}

	public String getName_marry() {
		return name_marry;
	}

	public void setName_marry(String name_marry) {
		this.name_marry = name_marry;
	}

	public String getCulture() {
		return culture;
	}

	public void setCulture(String culture) {
		this.culture = culture;
	}

	public String getName_hjsy() {
		return name_hjsy;
	}

	public void setName_hjsy(String name_hjsy) {
		this.name_hjsy = name_hjsy;
	}

	public String getHjdz() {
		return hjdz;
	}

	public void setHjdz(String hjdz) {
		this.hjdz = hjdz;
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

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getHouse_no() {
		return house_no;
	}

	public void setHouse_no(String house_no) {
		this.house_no = house_no;
	}

	public String getCase1() {
		return case1;
	}

	public void setCase1(String case1) {
		this.case1 = case1;
	}

	public String getCase2() {
		return case2;
	}

	public void setCase2(String case2) {
		this.case2 = case2;
	}

	public String getCase3() {
		return case3;
	}

	public void setCase3(String case3) {
		this.case3 = case3;
	}

	public String getCase4() {
		return case4;
	}

	public void setCase4(String case4) {
		this.case4 = case4;
	}

	public String getComfirm_date() {
		return comfirm_date;
	}

	public void setComfirm_date(String comfirm_date) throws ParseException {
		// 修改显示格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		date = sdf.parse(comfirm_date);
		if (date != null) {
			DateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
			String str = format.format(date);
			this.comfirm_date = str;
		} else {
			this.comfirm_date = comfirm_date;
		}
		// this.comfirm_date = comfirm_date;
	}

	public String getComfirm_unit() {
		return comfirm_unit;
	}

	public void setComfirm_unit(String comfirm_unit) {
		this.comfirm_unit = comfirm_unit;
	}

	public String getReport_doctor() {
		return report_doctor;
	}

	public void setReport_doctor(String report_doctor) {
		this.report_doctor = report_doctor;
	}

	public String getReport_date() {
		return report_date;
	}

	public void setReport_date(String report_date) throws ParseException {
		// 修改显示格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		date = sdf.parse(report_date);
		if (date != null) {
			DateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
			String str = format.format(date);
			this.report_date = str;
		} else {
			this.report_date = report_date;
		}
		// this.report_date = report_date;
	}

	public String getPro1() {
		return pro1;
	}

	public void setPro1(String pro1) {
		this.pro1 = pro1;
	}

	public String getPro2() {
		return pro2;
	}

	public void setPro2(String pro2) {
		this.pro2 = pro2;
	}

	public String getPro3() {
		return pro3;
	}

	public void setPro3(String pro3) {
		this.pro3 = pro3;
	}

	public String getPro4() {
		return pro4;
	}

	public void setPro4(String pro4) {
		this.pro4 = pro4;
	}

	public String getPro5() {
		return pro5;
	}

	public void setPro5(String pro5) {
		this.pro5 = pro5;
	}

	public String getPro6() {
		return pro6;
	}

	public void setPro6(String pro6) {
		this.pro6 = pro6;
	}

	public String getPro7() {
		return pro7;
	}

	public void setPro7(String pro7) {
		this.pro7 = pro7;
	}

	public String getPro8() {
		return pro8;
	}

	public void setPro8(String pro8) {
		this.pro8 = pro8;
	}

	public String getPro9() {
		return pro9;
	}

	public void setPro9(String pro9) {
		this.pro9 = pro9;
	}

	public String getPro10() {
		return pro10;
	}

	public void setPro10(String pro10) {
		this.pro10 = pro10;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

}
