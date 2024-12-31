package iih.ci.rcm;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ContagionHBDTO {
	private String HBsAgyxsj;
	private String sccxygzz;
	private String bcalt;
	private String khbjc;
	private String gcjcjg;
	private String hfqxq;

	private String card_no;
	private String pat_name;
	private String parent_name;
	private String hjdz;
	private String province;
	private String city;
	private String county;
	private String town;
	private String village;
	private String house_no;

	public String getHBsAgyxsj() {
		return HBsAgyxsj;
	}

	public void setHBsAgyxsj(String hBsAgyxsj) {
		HBsAgyxsj = hBsAgyxsj;
	}

	public String getSccxygzz() {
		return sccxygzz;
	}

	public void setSccxygzz(String sccxygzz) throws ParseException {
		// 修改显示格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		date = sdf.parse(sccxygzz);
		if (date != null) {
			DateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
			String str = format.format(date);
			this.sccxygzz = str;
		} else {
			this.sccxygzz = sccxygzz;
		}
		//this.sccxygzz = sccxygzz;
	}

	public String getBcalt() {
		return bcalt;
	}

	public void setBcalt(String bcalt) {
		this.bcalt = bcalt;
	}

	public String getKhbjc() {
		return khbjc;
	}

	public void setKhbjc(String khbjc) {
		this.khbjc = khbjc;
	}

	public String getGcjcjg() {
		return gcjcjg;
	}

	public void setGcjcjg(String gcjcjg) {
		this.gcjcjg = gcjcjg;
	}

	public String getHfqxq() {
		return hfqxq;
	}

	public void setHfqxq(String hfqxq) {
		this.hfqxq = hfqxq;
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

}
