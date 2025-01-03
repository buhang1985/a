package iih.ci.ord.printmanage.dto;

import java.math.BigDecimal;

import xap.mw.coreitf.d.FDouble;

public class ItemDTO {
	
	/******************************检查项目信息*************************************/
	/**
	 * 检查申请单ID
	 */
	private String Id_ciapprissheet;
	public String getId_ciapprissheet() {
		return Id_ciapprissheet;
	}
	public void setId_ciapprissheet(String id_ciapprissheet) {
		Id_ciapprissheet = id_ciapprissheet;
	}
	/**
	 * 医嘱ID
	 */
	private String Id_or;
	public String getId_or() {
		return Id_or;
	}
	public void setId_or(String id_or) {
		Id_or = id_or;
	}
	/**
	 * 检查分类名称
	 */
	private String Name_srvca;
	public String getName_srvca() {
		return Name_srvca;
	}
	public void setName_srvca(String name_srvca) {
		Name_srvca = name_srvca;
	}
	/**
	 * 服务
	 */
	private String Code_srv;
	public String getCode_srv() {
		return Code_srv;
	}
	public void setCode_srv(String code_srv) {
		Code_srv = code_srv;
	}
	private String Name_srv;
	public String getName_srv() {
		return Name_srv;
	}
	public void setName_srv(String name_srv) {
		Name_srv = name_srv;
	}
	private String Name_srv_ignore;
	public String getName_srv_ignore() {
		return Name_srv_ignore;
	}
	public void setName_srv_ignore(String name_srv_ignore) {
		Name_srv_ignore = name_srv_ignore;
	}
	/**
	 * 标本类型名称
	 */
	private String Name_samptp;
	public String getName_samptp() {
		return Name_samptp;
	}
	public void setName_samptp(String name_samptp) {
		Name_samptp = name_samptp;
	}
	/**
	 * 执行科室
	 */
	private String Name_dep_mp;
	public String getName_dep_mp() {
		return Name_dep_mp;
	}
	public void setName_dep_mp(String name_dep_mp) {
		Name_dep_mp = name_dep_mp;
	}
	/**
	 * 开立医生
	 */
	private String  Name_emp_or;
	public String getName_emp_or() {
		return Name_emp_or;
	}
	public void setName_emp_or(String name_emp_or) {
		Name_emp_or = name_emp_or;
	}
	/**
	 * 开立科室
	 */
	private String  Name_dep_or;
	public String getName_dep_or() {
		return Name_dep_or;
	}
	public void setName_dep_or(String name_dep_or) {
		Name_dep_or = name_dep_or;
	}
	/**
	 * 开立日期
	 */
	private String Dt_entry;
	public String getDt_entry() {
		return Dt_entry;
	}
	public void setDt_entry(String dt_entry) {
		Dt_entry = dt_entry;
	}
	/**
	 * 备注
	 */
	private String Des_labsamp;
	public String getDes_labsamp() {
		return Des_labsamp;
	}
	public void setDes_labsamp(String des_labsamp) {
		Des_labsamp = des_labsamp;
	}
	/**
	 * 金额
	 */
	private FDouble Amount;
	public FDouble getAmount() {
		return Amount;
	}
	public void setAmount(FDouble amount) {
		Amount = amount.setScale(-2, BigDecimal.ROUND_HALF_UP);
	}
	/**
	 * 服务套标识
	 */
	private String Fg_set;
	public String getFg_set() {
		return Fg_set;
	}
	public void setFg_set(String fg_set) {
		Fg_set = fg_set;
	}
	/**
	 * 诊断名称拼接
	 */
	private String Str_name_di;
	public String getStr_name_di() {
		return Str_name_di;
	}
	public void setStr_name_di(String str_name_di) {
		Str_name_di = str_name_di;
	}
	/**
	 * 检查申请号
	 */
	private String No_applyform;
	public String getNo_applyform() {
		return No_applyform;
	}
	public void setNo_applyform(String no_applyform) {
		No_applyform = no_applyform;
	}
	/**
	 * 计划执行时间
	 */
	private String Dt_plan;
	public String getDt_plan() {
		return Dt_plan;
	}
	public void setDt_plan(String dt_plan) {
		Dt_plan = dt_plan;
	}
	/**
	 * 病情描述
	 */
	private String Des_sympsign;
	public String getDes_sympsign() {
		return Des_sympsign;
	}
	public void setDes_sympsign(String des_sympsign) {
		Des_sympsign = des_sympsign;
	}
	/**
	 * 加急标识
	 */
	private String Fg_urgent;
	public String getFg_urgent() {
		return Fg_urgent;
	}
	public void setFg_urgent(String fg_urgent) {
		Fg_urgent = fg_urgent;
	}
	/*
	 * 
	 */
	private String Innercode;
	public String getInnercode() {
		return Innercode;
	}
	public void setInnercode(String innercode) {
		Innercode = innercode;
	}
	/**
	 * 注意事项
	 */
	private String Announcements;
	public String getAnnouncements() {
		return Announcements;
	}
	public void setAnnouncements(String announcements) {
		Announcements = announcements;
	}
	/**
	 * 检查目的名称
	 */
	private String Name_pps;
	public String getName_pps() {
		return Name_pps;
	}
	public void setName_pps(String name_pps) {
		Name_pps = name_pps;
	}
	/**
	 * 检查目的描述	
	 */
	private String Des_pps;
	public String getDes_pps() {
		return Des_pps;
	}
	public void setDes_pps(String des_pps) {
		Des_pps = des_pps;
	}
	/**
	 * 临床症状及体征
	 */
	private String Clinicalzztz;
	public String getClinicalzztz() {
		return Clinicalzztz;
	}
	public void setClinicalzztz(String clinicalzztz) {
		this.Clinicalzztz = clinicalzztz;
	}
	/**
	 * 既往病史
	 */
	private String Pastillness;
	public String getPastillness() {
		return Pastillness;
	}
	public void setPastillness(String pastillness) {
		this.Pastillness = pastillness;
	}
	/**
	 * 其它检查所见
	 */
	private String Auximtexam;
	public String getAuximtexam() {
		return Auximtexam;
	}
	public void setAuximtexam(String auximtexam) {
		this.Auximtexam = auximtexam;
	}
	/**
	 * 检查组织描述
	 */
	private String Biopsy;
	public String getBiopsy() {
		return Biopsy;
	}
	public void setBiopsy(String biopsy) {
		this.Biopsy = biopsy;
	}
	/**
	 * 预付费标识
	 */
	private String Fg_prepay;
	public String getFg_prepay() {
		return Fg_prepay;
	}
	public void setFg_prepay(String fg_prepay) {
		Fg_prepay = fg_prepay;
	}
	/**
	 * 医保标识
	 */
	private String Fg_orhp;
	public String getFg_orhp() {
		return Fg_orhp;
	}
	public void setFg_orhp(String fg_orhp) {
		Fg_orhp = fg_orhp;
	}
	
	/******************************检验标本信息*************************************/
	/**
	 * 检验申请单ID
	 */
	private String Id_ciapplissheet;
	public String getId_ciapplissheet() {
		return Id_ciapplissheet;
	}
	public void setId_ciapplissheet(String id_ciapplissheet) {
		Id_ciapplissheet = id_ciapplissheet;
	}
	
	/******************************病理标本信息*************************************/
	/**
	 * 病理打印申请单ID
	 */
	protected String Id_ciapppathgysheet;
	public String getId_ciapppathgysheet() {
		return Id_ciapppathgysheet;
	}
	public void setId_ciapppathgysheet(String id_ciapppathgysheet) {
		Id_ciapppathgysheet = id_ciapppathgysheet;
	}
	/**
	 * 标本名称
	 */
	protected String Name_labsamp;
	public String getName_labsamp() {
		return Name_labsamp;
	}
	public void setName_labsamp(String name_labsamp) {
		Name_labsamp = name_labsamp;
	}
	/**
	 * 标本部位
	 */
	protected String Body_coll;
	public String getBody_coll() {
		return Body_coll;
	}
	public void setBody_coll(String body_coll) {
		Body_coll = body_coll;
	}
	/**
	 * 检查部位
	 */
	protected String Body_Name;
	public String getBody_Name() {
		return Body_Name;
	}
	public void setBody_Name(String body_Name) {
		Body_Name = body_Name;
	}
	/**
	 * 标本数量
	 */
	protected FDouble Quan_coll;
	public FDouble getQuan_coll() {
		return Quan_coll;
	}
	public void setQuan_coll(FDouble quan_coll) {
		Quan_coll = quan_coll;
	}
	/**
	 * 固定液
	 */
	protected String Fixative;
	public String getFixative() {
		return Fixative;
	}
	public void setFixative(String fixative) {
		Fixative = fixative;
	}
	/**
	 * 标本状态
	 */
	protected String Name_su_labsamp;
	public String getName_su_labsamp() {
		return Name_su_labsamp;
	}
	public void setName_su_labsamp(String name_su_labsamp) {
		Name_su_labsamp = name_su_labsamp;
	}
	/**
	 * 标本签收科室
	 */
	protected String Name_dep_sign;
	public String getName_dep_sign() {
		return Name_dep_sign;
	}
	public void setName_dep_sign(String name_dep_sign) {
		Name_dep_sign = name_dep_sign;
	}
	/**
	 * 标本签收人员
	 */
	protected String Name_emp_sign;
	public String getName_emp_sign() {
		return Name_emp_sign;
	}
	public void setName_emp_sign(String name_emp_sign) {
		Name_emp_sign = name_emp_sign;
	}
	/**
	 * 标本签收时间
	 */
	protected String Dt_sign;
	public String getDt_sign() {
		return Dt_sign;
	}
	public void setDt_sign(String dt_sign) {
		Dt_sign = dt_sign;
	}
	/**
	 * 序号
	 */
	protected Integer Sortno;
	public Integer getSortno() {
		return Sortno;
	}
	public void setSortno(Integer sortno) {
		Sortno = sortno;
	}
	
	/******************************客户拓展字段*************************************/
	public String Def1;//客户扩展字段1
	public String Def2;//客户扩展字段2
	public String Def3;//客户扩展字段3
	public String Def4;//客户扩展字段4
	public String Def5;//客户扩展字段5
	public String Def6;//客户扩展字段6
	public String Def7;//客户扩展字段7
	public String Def8;//客户扩展字段8
	public String Def9;//客户扩展字段9
	public String Def10;//客户扩展字段10
	public String Def11;//客户扩展字段11
	public String Def12;//客户扩展字段12
	public String Def13;//客户扩展字段13
	public String Def14;//客户扩展字段14
	public String Def15;//客户扩展字段15
	public String Def16;//客户扩展字段16
	public String Def17;//客户扩展字段17
	public String Def18;//客户扩展字段18
	public String Def19;//客户扩展字段19
	public String Def20;//客户扩展字段20
	public String Def21;//客户扩展字段21
	public String Def22;//客户扩展字段22
	public String Def23;//客户扩展字段23
	public String Def24;//客户扩展字段24
	public String Def25;//客户扩展字段25
	public String Def26;//客户扩展字段26
	public String Def27;//客户扩展字段27
	public String Def28;//客户扩展字段28
	public String Def29;//客户扩展字段29
	public String Def30;//客户扩展字段30
	public String Def31;//客户扩展字段31
	public String Def32;//客户扩展字段32
	public String Def33;//客户扩展字段33
	public String Def34;//客户扩展字段34
	public String Def35;//客户扩展字段35
	public String Def36;//客户扩展字段36
	public String Def37;//客户扩展字段37
	public String Def38;//客户扩展字段38
	public String Def39;//客户扩展字段39
	public String Def40;//客户扩展字段40
	public String Def41;//客户扩展字段41
	public String Def42;//客户扩展字段42
	public String Def43;//客户扩展字段43
	public String Def44;//客户扩展字段44
	public String Def45;//客户扩展字段45
	public String Def46;//客户扩展字段46
	public String Def47;//客户扩展字段47
	public String Def48;//客户扩展字段48
	public String Def49;//客户扩展字段49
	public String Def50;//客户扩展字段50

	public String getDef1() {
		return Def1;
	}
	public void setDef1(String def1) {
		this.Def1 = def1;
	}
	public String getDef2() {
		return Def2;
	}
	public void setDef2(String def2) {
		this.Def2 = def2;
	}
	public String getDef3() {
		return Def3;
	}
	public void setDef3(String def3) {
		this.Def3 = def3;
	}
	public String getDef4() {
		return Def4;
	}
	public void setDef4(String def4) {
		this.Def4 = def4;
	}
	public String getDef5() {
		return Def5;
	}
	public void setDef5(String def5) {
		this.Def5 = def5;
	}
	public String getDef6() {
		return Def6;
	}
	public void setDef6(String def6) {
		this.Def6 = def6;
	}
	public String getDef7() {
		return Def7;
	}
	public void setDef7(String def7) {
		this.Def7 = def7;
	}
	public String getDef8() {
		return Def8;
	}
	public void setDef8(String def8) {
		this.Def8 = def8;
	}
	public String getDef9() {
		return Def9;
	}
	public void setDef9(String def9) {
		this.Def9 = def9;
	}
	public String getDef10() {
		return Def10;
	}
	public void setDef10(String def10) {
		this.Def10 = def10;
	}
	public String getDef11() {
		return Def11;
	}
	public void setDef11(String def11) {
		this.Def11 = def11;
	}
	public String getDef12() {
		return Def12;
	}
	public void setDef12(String def12) {
		this.Def12 = def12;
	}
	public String getDef13() {
		return Def13;
	}
	public void setDef13(String def13) {
		this.Def13 = def13;
	}
	public String getDef14() {
		return Def14;
	}
	public void setDef14(String def14) {
		this.Def14 = def14;
	}
	public String getDef15() {
		return Def15;
	}
	public void setDef15(String def15) {
		this.Def15 = def15;
	}
	public String getDef16() {
		return Def16;
	}
	public void setDef16(String def16) {
		this.Def16 = def16;
	}
	public String getDef17() {
		return Def17;
	}
	public void setDef17(String def17) {
		this.Def17 = def17;
	}
	public String getDef18() {
		return Def18;
	}
	public void setDef18(String def18) {
		this.Def18 = def18;
	}
	public String getDef19() {
		return Def19;
	}
	public void setDef19(String def19) {
		this.Def19 = def19;
	}
	public String getDef20() {
		return Def20;
	}
	public void setDef20(String def20) {
		this.Def20 = def20;
	}
	public String getDef21() {
		return Def21;
	}
	public void setDef21(String def21) {
		this.Def21 = def21;
	}
	public String getDef22() {
		return Def22;
	}
	public void setDef22(String def22) {
		this.Def22 = def22;
	}
	public String getDef23() {
		return Def23;
	}
	public void setDef23(String def23) {
		this.Def23 = def23;
	}
	public String getDef24() {
		return Def24;
	}
	public void setDef24(String def24) {
		this.Def24 = def24;
	}
	public String getDef25() {
		return Def25;
	}
	public void setDef25(String def25) {
		this.Def25 = def25;
	}
	public String getDef26() {
		return Def26;
	}
	public void setDef26(String def26) {
		this.Def26 = def26;
	}
	public String getDef27() {
		return Def27;
	}
	public void setDef27(String def27) {
		this.Def27 = def27;
	}
	public String getDef28() {
		return Def28;
	}
	public void setDef28(String def28) {
		this.Def28 = def28;
	}
	public String getDef29() {
		return Def29;
	}
	public void setDef29(String def29) {
		this.Def29 = def29;
	}
	public String getDef30() {
		return Def30;
	}
	public void setDef30(String def30) {
		this.Def30 = def30;
	}
	public String getDef31() {
		return Def31;
	}
	public void setDef31(String def31) {
		this.Def31 = def31;
	}
	public String getDef32() {
		return Def32;
	}
	public void setDef32(String def32) {
		this.Def32 = def32;
	}
	public String getDef33() {
		return Def33;
	}
	public void setDef33(String def33) {
		this.Def33 = def33;
	}
	public String getDef34() {
		return Def34;
	}
	public void setDef34(String def34) {
		this.Def34 = def34;
	}
	public String getDef35() {
		return Def35;
	}
	public void setDef35(String def35) {
		this.Def35 = def35;
	}
	public String getDef36() {
		return Def36;
	}
	public void setDef36(String def36) {
		this.Def36 = def36;
	}
	public String getDef37() {
		return Def37;
	}
	public void setDef37(String def37) {
		this.Def37 = def37;
	}
	public String getDef38() {
		return Def38;
	}
	public void setDef38(String def38) {
		this.Def38 = def38;
	}
	public String getDef39() {
		return Def39;
	}
	public void setDef39(String def39) {
		this.Def39 = def39;
	}
	public String getDef40() {
		return Def40;
	}
	public void setDef40(String def40) {
		this.Def40 = def40;
	}
	public String getDef41() {
		return Def41;
	}
	public void setDef41(String def41) {
		this.Def41 = def41;
	}
	public String getDef42() {
		return Def42;
	}
	public void setDef42(String def42) {
		this.Def42 = def42;
	}
	public String getDef43() {
		return Def43;
	}
	public void setDef43(String def43) {
		this.Def43 = def43;
	}
	public String getDef44() {
		return Def44;
	}
	public void setDef44(String def44) {
		this.Def44 = def44;
	}
	public String getDef45() {
		return Def45;
	}
	public void setDef45(String def45) {
		this.Def45 = def45;
	}
	public String getDef46() {
		return Def46;
	}
	public void setDef46(String def46) {
		this.Def46 = def46;
	}
	public String getDef47() {
		return Def47;
	}
	public void setDef47(String def47) {
		this.Def47 = def47;
	}
	public String getDef48() {
		return Def48;
	}
	public void setDef48(String def48) {
		this.Def48 = def48;
	}
	public String getDef49() {
		return Def49;
	}
	public void setDef49(String def49) {
		this.Def49 = def49;
	}
	public String getDef50() {
		return Def50;
	}
	public void setDef50(String def50) {
		this.Def50 = def50;
	}
}
