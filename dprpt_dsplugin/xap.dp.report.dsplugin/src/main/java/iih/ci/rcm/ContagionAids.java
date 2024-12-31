package iih.ci.rcm;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 
 * @author tangws
 * @date 2016年5月10日 下午7:33:37
 *
 */
public class ContagionAids {
	private String diseaseName;// 疾病名称
	private String contactHistory;// 接触史
	private String stdHistory;// 性病史
	private String infection;// 感染途径
	private String sampSource;// 样本来源
	private String concluson;// 实验室检测结论
	private String comfirmDate;// 确诊时间

	// 第二次改版新增字段
	private String card_no;
	private String pat_name;
	private String parent_name;
	private String name_marry;
	private String culture;
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
	private String comfirm_unit;// 确诊单位
	private String report_doctor;
	private String report_date;

	// 第三次改版新增字段 用于接触史
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

	// 第四次改版 主卡变动

	// 第五次改版新增字段
	private String nation;
	private String hjszd;
	private String infection_way_other;
	private String sd_infection_way_other;
	private String aids_confirm_date;
	private String report_unit;
	private String report_phone;
	private String note;

	private String backup_field1;
	private String backup_field2;// 接触史name
	private String backup_field3;
	private String backup_field4;
	private String backup_field5;
	private String backup_field6;
	private String backup_field7;
	private String backup_field8;
	private String backup_field9;
	private String backup_field10;

	private String prop1;
	private String prop2;
	private String prop3;
	private String prop4;
	private String prop5;
	private String prop6;
	private String prop7;
	private String prop8;
	private String prop9;
	private String prop10;
	private String prop11;
	private String prop12;

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getHjszd() {
		return hjszd;
	}

	public void setHjszd(String hjszd) {
		this.hjszd = hjszd;
	}

	public String getInfection_way_other() {
		return infection_way_other;
	}

	public void setInfection_way_other(String infection_way_other) {
		this.infection_way_other = infection_way_other;
	}

	public String getSd_infection_way_other() {
		return sd_infection_way_other;
	}

	public void setSd_infection_way_other(String sd_infection_way_other) {
		this.sd_infection_way_other = sd_infection_way_other;
	}

	public String getAids_confirm_date() {
		return aids_confirm_date;
	}

	public void setAids_confirm_date(String aids_confirm_date)
			throws ParseException {
		// 修改显示格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		date = sdf.parse(aids_confirm_date);
		if (date != null) {
			DateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
			String str = format.format(date);
			this.aids_confirm_date = str;
		} else {
			this.aids_confirm_date = aids_confirm_date;
		}
		// this.aids_confirm_date = aids_confirm_date;
	}

	public String getReport_unit() {
		return report_unit;
	}

	public void setReport_unit(String report_unit) {
		this.report_unit = report_unit;
	}

	public String getReport_phone() {
		return report_phone;
	}

	public void setReport_phone(String report_phone) {
		this.report_phone = report_phone;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getBackup_field1() {
		return backup_field1;
	}

	public void setBackup_field1(String backup_field1) {
		this.backup_field1 = backup_field1;
	}

	public String getBackup_field2() {
		return backup_field2;
	}

	public void setBackup_field2(String backup_field2) {
		this.backup_field2 = backup_field2;
	}

	public String getBackup_field3() {
		return backup_field3;
	}

	public void setBackup_field3(String backup_field3) {
		this.backup_field3 = backup_field3;
	}

	public String getBackup_field4() {
		return backup_field4;
	}

	public void setBackup_field4(String backup_field4) {
		this.backup_field4 = backup_field4;
	}

	public String getBackup_field5() {
		return backup_field5;
	}

	public void setBackup_field5(String backup_field5) {
		this.backup_field5 = backup_field5;
	}

	public String getBackup_field6() {
		return backup_field6;
	}

	public void setBackup_field6(String backup_field6) {
		this.backup_field6 = backup_field6;
	}

	public String getBackup_field7() {
		return backup_field7;
	}

	public void setBackup_field7(String backup_field7) {
		this.backup_field7 = backup_field7;
	}

	public String getBackup_field8() {
		return backup_field8;
	}

	public void setBackup_field8(String backup_field8) {
		this.backup_field8 = backup_field8;
	}

	public String getBackup_field9() {
		return backup_field9;
	}

	public void setBackup_field9(String backup_field9) {
		this.backup_field9 = backup_field9;
	}

	public String getBackup_field10() {
		return backup_field10;
	}

	public void setBackup_field10(String backup_field10) {
		this.backup_field10 = backup_field10;
	}

	public String getProp1() {
		return prop1;
	}

	public void setProp1(String prop1) {
		this.prop1 = prop1;
	}

	public String getProp2() {
		return prop2;
	}

	public void setProp2(String prop2) {
		this.prop2 = prop2;
	}

	public String getProp3() {
		return prop3;
	}

	public void setProp3(String prop3) {
		this.prop3 = prop3;
	}

	public String getProp4() {
		return prop4;
	}

	public void setProp4(String prop4) {
		this.prop4 = prop4;
	}

	public String getProp5() {
		return prop5;
	}

	public void setProp5(String prop5) {
		this.prop5 = prop5;
	}

	public String getProp6() {
		return prop6;
	}

	public void setProp6(String prop6) {
		this.prop6 = prop6;
	}

	public String getProp7() {
		return prop7;
	}

	public void setProp7(String prop7) {
		this.prop7 = prop7;
	}

	public String getProp8() {
		return prop8;
	}

	public void setProp8(String prop8) {
		this.prop8 = prop8;
	}

	public String getProp9() {
		return prop9;
	}

	public void setProp9(String prop9) {
		this.prop9 = prop9;
	}

	public String getProp10() {
		return prop10;
	}

	public void setProp10(String prop10) {
		this.prop10 = prop10;
	}

	public String getProp11() {
		return prop11;
	}

	public void setProp11(String prop11) {
		this.prop11 = prop11;
	}

	public String getProp12() {
		return prop12;
	}

	public void setProp12(String prop12) {
		this.prop12 = prop12;
	}

	public String getDiseaseName() {
		return diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
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

	public String getComfirmDate() {
		return comfirmDate;
	}

	public void setComfirmDate(String comfirmDate) throws ParseException {
		// 修改显示格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		date = sdf.parse(comfirmDate);
		if (date != null) {
			DateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
			String str = format.format(date);
			this.comfirmDate = str;
		} else {
			this.comfirmDate = comfirmDate;
		}
		// this.comfirmDate = comfirmDate;
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
		//this.report_date = report_date;
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

}
