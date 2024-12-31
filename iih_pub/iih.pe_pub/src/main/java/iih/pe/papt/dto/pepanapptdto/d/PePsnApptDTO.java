package iih.pe.papt.dto.pepanapptdto.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class PePsnApptDTO {

	// 体检预约单主键标识
	@RPCField(id = 1)
	private String id_pepsnappt;
	// 家属标识
	@RPCField(id = 10)
	private boolean fg_family;
	// 加项收费标识
	@RPCField(id = 11)
	private boolean fg_addcharge;
	// 预约时间
	@RPCField(id = 12)
	private String dt_appt;
	// 预约时间段
	@RPCField(id = 13)
	private String id_peappttladder;
	// 体检时间
	@RPCField(id = 14)
	private String dt_pe;
	// 登记日期
	@RPCField(id = 15)
	private String dt_reg;
	// 登记类型编码
	@RPCField(id = 16)
	private String sd_regtp;
	// 后付费体检标识
	@RPCField(id = 17)
	private boolean fg_nopay;
	// VIP标识
	@RPCField(id = 18)
	private boolean fg_vip;
	// 用餐荤素标识
	@RPCField(id = 19)
	private boolean fg_meal;
	// 体检客户ID
	@RPCField(id = 2)
	private String id_pepsnbinfo;
	// 清真饮食
	@RPCField(id = 20)
	private boolean fg_muslim;
	// 收费标识
	@RPCField(id = 21)
	private boolean fg_paid;
	// 体检登记备注
	@RPCField(id = 22)
	private String rmk_pe;
	// 客户姓名
	@RPCField(id = 23)
	private String name_psn;
	// 体检唯一码
	@RPCField(id = 24)
	private String pe_code;
	// 年龄
	@RPCField(id = 25)
	private int age_psn;
	// 体检费用
	@RPCField(id = 26)
	private double charge_pe;
	// 证件类型
	@RPCField(id = 27)
	private String idtp;
	// 存在标识
	@RPCField(id = 28)
	private boolean fg_exist;
	// 整单折扣
	@RPCField(id = 29)
	private double dis_total;
	// 体检套餐ID
	@RPCField(id = 3)
	private String id_pesrvsetdef;
	// 折后费用
	@RPCField(id = 30)
	private double dis_charge;
	// 登记员
	@RPCField(id = 31)
	private String id_registrar;
	// 实际体检标识
	@RPCField(id = 32)
	private boolean fg_check;
	// 首次体检日期
	@RPCField(id = 33)
	private String dt_checked;
	// 导引单打印标识
	@RPCField(id = 34)
	private boolean fg_guiderprint;
	// 条码打印标识
	@RPCField(id = 35)
	private boolean fg_barcodeprint;
	// 客户编码
	@RPCField(id = 36)
	private String code_pat;
	// 就诊次数
	@RPCField(id = 37)
	private String times;
	// 体检客户分组编码
	@RPCField(id = 38)
	private String sd_pemultigroup;
	// 导引单收回
	@RPCField(id = 39)
	private boolean fg_guiderback;
	// 就诊流水号
	@RPCField(id = 4)
	private String id_en;
	// 导引单收回时间
	@RPCField(id = 40)
	private String dt_guiderback;
	// 工种
	@RPCField(id = 41)
	private String profession;
	// 行业
	@RPCField(id = 42)
	private String industry;
	// 单位名称
	@RPCField(id = 43)
	private String company;
	// 在岗时间
	@RPCField(id = 44)
	private String job_time;
	// 工龄
	@RPCField(id = 45)
	private String workingage;
	// 体检次数
	@RPCField(id = 5)
	private int pe_times;
	// 预约会员卡
	@RPCField(id = 6)
	private String no_card;
	// 个人单位标识
	@RPCField(id = 7)
	private boolean fg_petp;
	// 原预约单ID
	@RPCField(id = 8)
	private String id_pepsnappt_former;
	// 体检流程号
	@RPCField(id = 9)
	private String card_pe;

	public String getId_pepsnappt() {
		return id_pepsnappt;
	}

	public void setId_pepsnappt(String id_pepsnappt) {
		this.id_pepsnappt = id_pepsnappt;
	}

	public boolean getFg_family() {
		return fg_family;
	}

	public void setFg_family(boolean fg_family) {
		this.fg_family = fg_family;
	}

	public boolean getFg_addcharge() {
		return fg_addcharge;
	}

	public void setFg_addcharge(boolean fg_addcharge) {
		this.fg_addcharge = fg_addcharge;
	}

	public String getDt_appt() {
		return dt_appt;
	}

	public void setDt_appt(String dt_appt) {
		this.dt_appt = dt_appt;
	}

	public String getId_peappttladder() {
		return id_peappttladder;
	}

	public void setId_peappttladder(String id_peappttladder) {
		this.id_peappttladder = id_peappttladder;
	}

	public String getDt_pe() {
		return dt_pe;
	}

	public void setDt_pe(String dt_pe) {
		this.dt_pe = dt_pe;
	}

	public String getDt_reg() {
		return dt_reg;
	}

	public void setDt_reg(String dt_reg) {
		this.dt_reg = dt_reg;
	}

	public String getSd_regtp() {
		return sd_regtp;
	}

	public void setSd_regtp(String sd_regtp) {
		this.sd_regtp = sd_regtp;
	}

	public boolean getFg_nopay() {
		return fg_nopay;
	}

	public void setFg_nopay(boolean fg_nopay) {
		this.fg_nopay = fg_nopay;
	}

	public boolean getFg_vip() {
		return fg_vip;
	}

	public void setFg_vip(boolean fg_vip) {
		this.fg_vip = fg_vip;
	}

	public boolean getFg_meal() {
		return fg_meal;
	}

	public void setFg_meal(boolean fg_meal) {
		this.fg_meal = fg_meal;
	}

	public String getId_pepsnbinfo() {
		return id_pepsnbinfo;
	}

	public void setId_pepsnbinfo(String id_pepsnbinfo) {
		this.id_pepsnbinfo = id_pepsnbinfo;
	}

	public boolean getFg_muslim() {
		return fg_muslim;
	}

	public void setFg_muslim(boolean fg_muslim) {
		this.fg_muslim = fg_muslim;
	}

	public boolean getFg_paid() {
		return fg_paid;
	}

	public void setFg_paid(boolean fg_paid) {
		this.fg_paid = fg_paid;
	}

	public String getRmk_pe() {
		return rmk_pe;
	}

	public void setRmk_pe(String rmk_pe) {
		this.rmk_pe = rmk_pe;
	}

	public String getName_psn() {
		return name_psn;
	}

	public void setName_psn(String name_psn) {
		this.name_psn = name_psn;
	}

	public String getPe_code() {
		return pe_code;
	}

	public void setPe_code(String pe_code) {
		this.pe_code = pe_code;
	}

	public int getAge_psn() {
		return age_psn;
	}

	public void setAge_psn(int age_psn) {
		this.age_psn = age_psn;
	}

	public double getCharge_pe() {
		return charge_pe;
	}

	public void setCharge_pe(double charge_pe) {
		this.charge_pe = charge_pe;
	}

	public String getIdtp() {
		return idtp;
	}

	public void setIdtp(String idtp) {
		this.idtp = idtp;
	}

	public boolean getFg_exist() {
		return fg_exist;
	}

	public void setFg_exist(boolean fg_exist) {
		this.fg_exist = fg_exist;
	}

	public double getDis_total() {
		return dis_total;
	}

	public void setDis_total(double dis_total) {
		this.dis_total = dis_total;
	}

	public String getId_pesrvsetdef() {
		return id_pesrvsetdef;
	}

	public void setId_pesrvsetdef(String id_pesrvsetdef) {
		this.id_pesrvsetdef = id_pesrvsetdef;
	}

	public double getDis_charge() {
		return dis_charge;
	}

	public void setDis_charge(double dis_charge) {
		this.dis_charge = dis_charge;
	}

	public String getId_registrar() {
		return id_registrar;
	}

	public void setId_registrar(String id_registrar) {
		this.id_registrar = id_registrar;
	}

	public boolean getFg_check() {
		return fg_check;
	}

	public void setFg_check(boolean fg_check) {
		this.fg_check = fg_check;
	}

	public String getDt_checked() {
		return dt_checked;
	}

	public void setDt_checked(String dt_checked) {
		this.dt_checked = dt_checked;
	}

	public boolean getFg_guiderprint() {
		return fg_guiderprint;
	}

	public void setFg_guiderprint(boolean fg_guiderprint) {
		this.fg_guiderprint = fg_guiderprint;
	}

	public boolean getFg_barcodeprint() {
		return fg_barcodeprint;
	}

	public void setFg_barcodeprint(boolean fg_barcodeprint) {
		this.fg_barcodeprint = fg_barcodeprint;
	}

	public String getCode_pat() {
		return code_pat;
	}

	public void setCode_pat(String code_pat) {
		this.code_pat = code_pat;
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public String getSd_pemultigroup() {
		return sd_pemultigroup;
	}

	public void setSd_pemultigroup(String sd_pemultigroup) {
		this.sd_pemultigroup = sd_pemultigroup;
	}

	public boolean getFg_guiderback() {
		return fg_guiderback;
	}

	public void setFg_guiderback(boolean fg_guiderback) {
		this.fg_guiderback = fg_guiderback;
	}

	public String getId_en() {
		return id_en;
	}

	public void setId_en(String id_en) {
		this.id_en = id_en;
	}

	public String getDt_guiderback() {
		return dt_guiderback;
	}

	public void setDt_guiderback(String dt_guiderback) {
		this.dt_guiderback = dt_guiderback;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getJob_time() {
		return job_time;
	}

	public void setJob_time(String job_time) {
		this.job_time = job_time;
	}

	public String getWorkingage() {
		return workingage;
	}

	public void setWorkingage(String workingage) {
		this.workingage = workingage;
	}

	public int getPe_times() {
		return pe_times;
	}

	public void setPe_times(int pe_times) {
		this.pe_times = pe_times;
	}

	public String getNo_card() {
		return no_card;
	}

	public void setNo_card(String no_card) {
		this.no_card = no_card;
	}

	public boolean getFg_petp() {
		return fg_petp;
	}

	public void setFg_petp(boolean fg_petp) {
		this.fg_petp = fg_petp;
	}

	public String getId_pepsnappt_former() {
		return id_pepsnappt_former;
	}

	public void setId_pepsnappt_former(String id_pepsnappt_former) {
		this.id_pepsnappt_former = id_pepsnappt_former;
	}

	public String getCard_pe() {
		return card_pe;
	}

	public void setCard_pe(String card_pe) {
		this.card_pe = card_pe;
	}

}
