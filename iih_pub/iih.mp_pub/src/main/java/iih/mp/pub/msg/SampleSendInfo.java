package iih.mp.pub.msg;

import java.util.Date;

/**
 * 标本送检实体类
 * 
 * @author 2016-09-22 xuxing
 *
 */
public class SampleSendInfo {

	private String Code_or;//医嘱编码
	private String No_bar;//标本条码
	private Date Collect_date;//采集日期
	private String Collecter;//采集人编码
	private String Code_dep;//执行科室编码

	public String getCode_or() {
		return this.Code_or;
	}

	public String getNo_bar() {
		return this.No_bar;
	}

	public Date getCollect_date() {
		return this.Collect_date;
	}

	public String getCollecter() {
		return this.Collecter;
	}

	public String getCode_dep() {
		return this.Code_dep;
	}
	
	

	public void setCode_or(String code_or) {
		this.Code_or = code_or;
	}

	public void setNo_bar(String no_bar) {
		this.No_bar = no_bar;
	}

	public void setCollect_date(Date collect_date) {
		this.Collect_date = collect_date;
	}

	public void setCollecter(String collecter) {
		this.Collecter = collecter;
	}

	public void setCode_dep(String code_dep) {
		this.Code_dep = code_dep;
	}
}
