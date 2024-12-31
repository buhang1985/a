package iih.pe.papt.dto.perecomdto.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class PerecomDTO {

	// 体检日期
	@RPCField(id = 1)
	private String dt_pe;
	// 体重指数(BMI)
	@RPCField(id = 10)
	private String bmi;
	// 腰臀比(%)
	@RPCField(id = 11)
	private String yaotun;
	// 收缩压
	@RPCField(id = 2)
	private String shousuo;
	// 舒张压
	@RPCField(id = 3)
	private String shuzhang;
	// 高血压病史
	@RPCField(id = 4)
	private String gaoxueya;
	// 胆固醇
	@RPCField(id = 5)
	private String danguchun;
	// 甘油三脂
	@RPCField(id = 6)
	private String ganyousanzhi;
	// 高密度脂蛋白
	@RPCField(id = 7)
	private String gaomidu;
	// 低密度脂蛋白
	@RPCField(id = 8)
	private String dimidu;
	// 空腹血糖
	@RPCField(id = 9)
	private String xuetang;

	public String getDt_pe() {
		return dt_pe;
	}

	public void setDt_pe(String dt_pe) {
		this.dt_pe = dt_pe;
	}

	public String getBmi() {
		return bmi;
	}

	public void setBmi(String bmi) {
		this.bmi = bmi;
	}

	public String getYaotun() {
		return yaotun;
	}

	public void setYaotun(String yaotun) {
		this.yaotun = yaotun;
	}

	public String getShousuo() {
		return shousuo;
	}

	public void setShousuo(String shousuo) {
		this.shousuo = shousuo;
	}

	public String getShuzhang() {
		return shuzhang;
	}

	public void setShuzhang(String shuzhang) {
		this.shuzhang = shuzhang;
	}

	public String getGaoxueya() {
		return gaoxueya;
	}

	public void setGaoxueya(String gaoxueya) {
		this.gaoxueya = gaoxueya;
	}

	public String getDanguchun() {
		return danguchun;
	}

	public void setDanguchun(String danguchun) {
		this.danguchun = danguchun;
	}

	public String getGanyousanzhi() {
		return ganyousanzhi;
	}

	public void setGanyousanzhi(String ganyousanzhi) {
		this.ganyousanzhi = ganyousanzhi;
	}

	public String getGaomidu() {
		return gaomidu;
	}

	public void setGaomidu(String gaomidu) {
		this.gaomidu = gaomidu;
	}

	public String getDimidu() {
		return dimidu;
	}

	public void setDimidu(String dimidu) {
		this.dimidu = dimidu;
	}

	public String getXuetang() {
		return xuetang;
	}

	public void setXuetang(String xuetang) {
		this.xuetang = xuetang;
	}

}
