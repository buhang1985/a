package iih.bl.cg.ipfeebill;

import java.util.List;

import xap.mw.coreitf.d.FDouble;

public class DayIpFeeBillDTO {
	
	public String date;//日期
	public String name_pat;//患者名称
	public String code_amr_ip;//住院病历号
	public List<DayIpBillCgInfoDTO> caList;//费用项列表
	public FDouble amt_day;//当日费用合计
	public FDouble amt_pay;//押金（预交金）
	public FDouble amt_std;//费用合计
	public FDouble amt_sur;//余额
    public String name_dep_nur;//当前就诊科室
	public String name_bed;//床号
	public String name_patca;//患者分类
	public FDouble amt_st;//已结算金额（没有时间限制）
	public FDouble amt_nost;//未结算金额（没有时间限制）
	public String id_ent;	
	
	public String getId_ent() {
		return id_ent;
	}
	public void setId_ent(String id_ent) {
		this.id_ent = id_ent;
	}
	public FDouble getAmt_nost() {
		return amt_nost;
	}
	public void setAmt_nost(FDouble amt_nost) {
		this.amt_nost = amt_nost;
	}
	public String getName_dep_nur() {
		return name_dep_nur;
	}
	public void setName_dep_nur(String name_dep_nur) {
		this.name_dep_nur = name_dep_nur;
	}
	public String getName_bed() {
		return name_bed;
	}
	public void setName_bed(String name_bed) {
		this.name_bed = name_bed;
	}
	public String getName_patca() {
		return name_patca;
	}
	public void setName_patca(String name_patca) {
		this.name_patca = name_patca;
	}
	public FDouble getAmt_st() {
		return amt_st;
	}
	public void setAmt_st(FDouble amt_st) {
		this.amt_st = amt_st;
	}
	public void setAmt_sur(FDouble amt_sur) {
		this.amt_sur = amt_sur;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName_pat() {
		return name_pat;
	}
	public void setName_pat(String name_pat) {
		this.name_pat = name_pat;
	}
	public String getCode_amr_ip() {
		return code_amr_ip;
	}
	public void setCode_amr_ip(String code_amr_ip) {
		this.code_amr_ip = code_amr_ip;
	}
	public List<DayIpBillCgInfoDTO> getCaList() {
		return caList;
	}
	public void setCaList(List<DayIpBillCgInfoDTO> caList) {
		this.caList = caList;
	}
	public FDouble getAmt_day() {
		return amt_day;
	}
	public void setAmt_day(FDouble amt_day) {
		this.amt_day = amt_day;
	}
	public FDouble getAmt_pay() {
		return amt_pay;
	}
	public void setAmt_pay(FDouble amt_pay) {
		this.amt_pay = amt_pay;
	}
	public FDouble getAmt_std() {
		return amt_std;
	}
	public void setAmt_std(FDouble amt_std) {
		this.amt_std = amt_std;
	}
	public FDouble getAmt_sur() {
		this.amt_sur = this.amt_pay.sub(this.amt_std);
		return amt_sur;
	}

}
