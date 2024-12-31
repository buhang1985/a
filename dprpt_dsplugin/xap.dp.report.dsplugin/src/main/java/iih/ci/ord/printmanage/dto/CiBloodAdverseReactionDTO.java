package iih.ci.ord.printmanage.dto;

import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 输血不良反应回报单DTO
 * 
 * @author LiYue
 *  2018年2月7日
 */
public class CiBloodAdverseReactionDTO {
	
	
	/******************************患者信息***************************************
	 *
	 * 
	 */
	/*
	 * 患者姓名  患者基本信息
	 */
	private String Id_pat;
	private String Name_pat;//name
	/*
	 * 患者性别   自定义档案
	 */
	private String Id_sex;
	private String Name_sex;
	/*
	 * 患者年龄
	 */
	private String Age;
	private String Dt_birth ;
	/*
	 * 是否生孕
	 * 孕几
	 * 产几
	 */
	private FBoolean Fg_pregnant;
	private Integer Pregnant;
	private Integer Birth;
	
	/*
	 * 配药护士
	 */
	private String Id_dispensing_nurse;
	private String Sd_dispensing_nurse;
	/*
	 * 穿刺护士ID
	 */
	private String Id_paracent_nurse;
	private String Sd_paracent_nurse;
	/*
	 * 病房护士长ID
	 */
	private String Id_ward_nurse;
	private String Sd_ward_nurse;
	/*
	 * 医生ID
	 */
	private String Id_psndoc;
	private String Sd_psndoc;
	
	
	/**************************患者就诊信息**************************************************
	 * 
	 */
	/*
	 * 疾病诊断
	 */
	private String Id_disease_diagnosis;
	private String Sd_disease_diagnosis;
	/*
	 * 手术
	 */
	private String Id_operate;
    private String Sd_operate;
	/*
	 * 科别 
	 */
	private String Id_dep;
	private String Sd_dep;
	/*
	 * 门诊号
	 */
	private String Op_no;
	
	/*
	 * 其他
	 */
	private String Oth;
	/*
	 * 患者临床表现*****************************************************************************
	 */
	
	/*
	 *  ℃
	 */
	private String Def41;
	/*
	 * 发热
	 */
	private String Def1;	
	/*
	 * 畏寒
	 */
	private String Def2;
	/*
	 * 寒战
	 */
	private String Def3;
	/*
	 * 呕吐
	 */
	private String Def4;
	/*
	 * 头痛
	 */
	private String Def5;
	/*
	 * 出汗
	 */
	private String Def6;
	/*
	 * 脸色苍白
	 */
	private String Def7;
	/*
	 * 皮肤荨麻疹
	 */
	private String Def8;
	/*
	 * 胸闷
	 */
	private String Def9;
	/*
	 * 腰酸
	 */
	private String Def10;
	/*
	 * 背痛
	 */
	private String Def11;
	/*
	 * 脉搏
	 */
	private String Def12;
	/*
	 * 血压
	 */
	private String Def13;
	/*
	 * 昏迷
	 */
	private String Def14;
	/*
	 * 四肢麻木
	 */
	private String Def15;
	/*
	 * 血红蛋白尿
	 */
	private String Def16;
	/*
	 * 黄痘
	 */
	private String Def17;
	/*
	 * 尿少
	 */
	private String Def18;
	/*
	 * 闭尿
	 */
	
	/*
	 *****************************************************************************
	 */
	private String Def19;
	/*
	 * 其他表现
	 */
	private String Def20;
	/*
	 * 医嘱给予
	 */
	private String Def21;
	/*
	 * 有无输血史
	 */
	private FBoolean Fg_blood_his;
	/*
	 * 患者血型
	 */
	private String Id_bloodtype_pat;
	private String Sd_bloodtype_pat;
	/*
	 * 供血血型     自定义档案
	 */
	private String Id_bloodtype_sipply;
	private String Sd_bloodtype_sipply;
	/*
	 * RH血型     自定义档案
	 */
	private String Id_rh;
	private String Sd_rh;
	/*
	 * 反应时间
	 */
	private FDateTime Reaction_time;
	/*
	 * 血袋储血号
	 */
	private String Blood_bag_no;
	/*
	 * 血液采集时间
	 */
	private FDateTime Collection_time;
	
	/*
	 * 输血种类
	 */
	private String Id_bloodtype_tran;
	private String Sd_bloodtype_tran;
	/*
	 * 血袋规格   自定义档案
	 */
	private String Id_blood_spec;
	private String Sd_blood_spec;
	/*
	 * 有无输血不良反应  不良反应种类
	 */
	private FBoolean Fg_tran_blood_bad_reaction;
	/*
	 * 不良反应:发热
	 */
	private FBoolean Fg_fever;
	/*
	 *  不良反应:过敏
	 */
	private FBoolean Fg_allergy;
	/*
	 * 不良反应:溶血
	 */
	private FBoolean Fg_hemolysis;
	/*
	 * 不良反应:细菌污染
	 */
	private FBoolean Fg_bacterium_contaminate;
	/*
	 * 不良反应:其他
	 */
	private FBoolean Fg_oth;
	/*
	 * 取血时间 
	 */
	private String Def22;
	/*
	 *  输血时间
	 */
	private String Def23;
	/*
	 *  取血人
	 */
	private String Def24;
	/*
	 *  输血前核对人
	 */
	private String Def25;
	/*
	 *  穿刺人
	 */
	private String Def26;
	/*
	 *  取回后
	 */
	private String Def27;
	/*
	 *  放置于
	 */
	private String Def28;
	/*
	 *  分钟输入
	 */
	private String Def29;
	/*
	 *  已输入
	 */
	private String Def30;
	/*
	 *  输血速度
	 */
	private String Def31;
	/*
	 *  送检时间
	 */
	private String Def32;
	/*
	 *  血制品送检结果
	 */
	private String Def40;
	/*
	 *  原因分析
	 */
	private String Def33;
	/*
	 *  pnlReaction
	 */
	private String Def34;
	/*
	 *  不良反应处理情况
	 */
	private String Def35;
	/*
	 *  不良反应所致结果
	 */
	private String Def36;
	/*
	 *  死亡原因
	 */
	private String Def37;
	/*
	 *  死亡时间
	 */
	private String Def38;
	/*
	 *  输血科处理情况
	 */
	private String Def39;
	/*
	 *  填报人
	 */
	private String Reporter;
	/*
	 *  填报时间
	 */
	private FDateTime Report_time;
	/*
	 *  输血科签字
	 */
	private String Dept_sign;
	/*
	 *  签字时间
	 */
	private  FDateTime time;
	/*
	 *  拓展字段
	 */
	public String getId_pat() {
		return Id_pat;
	}
	public void setId_pat(String id_pat) {
		Id_pat = id_pat;
	}
	public String getName_pat() {
		return Name_pat;
	}
	public void setName_pat(String name_pat) {
		Name_pat = name_pat;
	}
	public String getId_sex() {
		return Id_sex;
	}
	public void setId_sex(String id_sex) {
		Id_sex = id_sex;
	}
	public String getName_sex() {
		return Name_sex;
	}
	public void setName_sex(String name_sex) {
		Name_sex = name_sex;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getDt_birth() {
		return Dt_birth;
	}
	public void setDt_birth(String Dt_birth) {
		this.Dt_birth= Dt_birth;
	}
	public FBoolean getFg_pregnant() {
		return Fg_pregnant;
	}
	public void setFg_pregnant(FBoolean fg_pregnant) {
		Fg_pregnant = fg_pregnant;
	}
	public Integer getPregnant() {
		return Pregnant;
	}
	public void setPregnant(Integer pregnant) {
		Pregnant = pregnant;
	}
	public Integer getBirth() {
		return Birth;
	}
	public void setBirth(Integer birth) {
		Birth = birth;
	}
	public String getId_dispensing_nurse() {
		return Id_dispensing_nurse;
	}
	public void setId_dispensing_nurse(String id_dispensing_nurse) {
		Id_dispensing_nurse = id_dispensing_nurse;
	}
	public String getSd_dispensing_nurse() {
		return Sd_dispensing_nurse;
	}
	public void setSd_dispensing_nurse(String sd_dispensing_nurse) {
		Sd_dispensing_nurse = sd_dispensing_nurse;
	}
	public String getId_paracent_nurse() {
		return Id_paracent_nurse;
	}
	public void setId_paracent_nurse(String id_paracent_nurse) {
		Id_paracent_nurse = id_paracent_nurse;
	}
	public String getSd_paracent_nurse() {
		return Sd_paracent_nurse;
	}
	public void setSd_paracent_nurse(String sd_paracent_nurse) {
		Sd_paracent_nurse = sd_paracent_nurse;
	}
	public String getId_ward_nurse() {
		return Id_ward_nurse;
	}
	public void setId_ward_nurse(String id_ward_nurse) {
		Id_ward_nurse = id_ward_nurse;
	}
	public String getSd_ward_nurse() {
		return Sd_ward_nurse;
	}
	public void setSd_ward_nurse(String sd_ward_nurse) {
		Sd_ward_nurse = sd_ward_nurse;
	}
	public String getId_psndoc() {
		return Id_psndoc;
	}
	public void setId_psndoc(String id_psndoc) {
		Id_psndoc = id_psndoc;
	}
	public String getSd_psndoc() {
		return Sd_psndoc;
	}
	public void setSd_psndoc(String sd_psndoc) {
		Sd_psndoc = sd_psndoc;
	}
	public String getId_disease_diagnosis() {
		return Id_disease_diagnosis;
	}
	public void setId_disease_diagnosis(String id_disease_diagnosis) {
		Id_disease_diagnosis = id_disease_diagnosis;
	}
	public String getSd_disease_diagnosis() {
		return Sd_disease_diagnosis;
	}
	public void setSd_disease_diagnosis(String sd_disease_diagnosis) {
		Sd_disease_diagnosis = sd_disease_diagnosis;
	}
	public String getId_operate() {
		return Id_operate;
	}
	public void setId_operate(String id_operate) {
		Id_operate = id_operate;
	}
	public String getSd_operate() {
		return Sd_operate;
	}
	public void setSd_operate(String sd_operate) {
		Sd_operate = sd_operate;
	}
	public String getId_dep() {
		return Id_dep;
	}
	public void setId_dep(String id_dep) {
		Id_dep = id_dep;
	}
	public String getSd_dep() {
		return Sd_dep;
	}
	public void setSd_dep(String sd_dep) {
		Sd_dep = sd_dep;
	}
	public String getOp_no() {
		return Op_no;
	}
	public void setOp_no(String op_no) {
		Op_no = op_no;
	}
	public String getOth() {
		return Oth;
	}
	public void setOth(String oth) {
		Oth = oth;
	}
	public String getDef41() {
		return Def41;
	}
	public void setDef41(String def41) {
		Def41 = def41;
	}
	public String getDef1() {
		return Def1;
	}
	public void setDef1(String def1) {
		Def1 = def1;
	}
	public String getDef2() {
		return Def2;
	}
	public void setDef2(String def2) {
		Def2 = def2;
	}
	public String getDef3() {
		return Def3;
	}
	public void setDef3(String def3) {
		Def3 = def3;
	}
	public String getDef4() {
		return Def4;
	}
	public void setDef4(String def4) {
		Def4 = def4;
	}
	public String getDef5() {
		return Def5;
	}
	public void setDef5(String def5) {
		Def5 = def5;
	}
	public String getDef6() {
		return Def6;
	}
	public void setDef6(String def6) {
		Def6 = def6;
	}
	public String getDef7() {
		return Def7;
	}
	public void setDef7(String def7) {
		Def7 = def7;
	}
	public String getDef8() {
		return Def8;
	}
	public void setDef8(String def8) {
		Def8 = def8;
	}
	public String getDef9() {
		return Def9;
	}
	public void setDef9(String def9) {
		Def9 = def9;
	}
	public String getDef10() {
		return Def10;
	}
	public void setDef10(String def10) {
		Def10 = def10;
	}
	public String getDef11() {
		return Def11;
	}
	public void setDef11(String def11) {
		Def11 = def11;
	}
	public String getDef12() {
		return Def12;
	}
	public void setDef12(String def12) {
		Def12 = def12;
	}
	public String getDef13() {
		return Def13;
	}
	public void setDef13(String def13) {
		Def13 = def13;
	}
	public String getDef14() {
		return Def14;
	}
	public void setDef14(String def14) {
		Def14 = def14;
	}
	public String getDef15() {
		return Def15;
	}
	public void setDef15(String def15) {
		Def15 = def15;
	}
	public String getDef16() {
		return Def16;
	}
	public void setDef16(String def16) {
		Def16 = def16;
	}
	public String getDef17() {
		return Def17;
	}
	public void setDef17(String def17) {
		Def17 = def17;
	}
	public String getDef18() {
		return Def18;
	}
	public void setDef18(String def18) {
		Def18 = def18;
	}
	public String getDef19() {
		return Def19;
	}
	public void setDef19(String def19) {
		Def19 = def19;
	}
	public String getDef20() {
		return Def20;
	}
	public void setDef20(String def20) {
		Def20 = def20;
	}
	public String getDef21() {
		return Def21;
	}
	public void setDef21(String def21) {
		Def21 = def21;
	}
	public FBoolean getFg_blood_his() {
		return Fg_blood_his;
	}
	public void setFg_blood_his(FBoolean fg_blood_his) {
		Fg_blood_his = fg_blood_his;
	}
	public String getId_bloodtype_pat() {
		return Id_bloodtype_pat;
	}
	public void setId_bloodtype_pat(String id_bloodtype_pat) {
		Id_bloodtype_pat = id_bloodtype_pat;
	}
	public String getSd_bloodtype_pat() {
		return Sd_bloodtype_pat;
	}
	public void setSd_bloodtype_pat(String sd_bloodtype_pat) {
		Sd_bloodtype_pat = sd_bloodtype_pat;
	}
	public String getId_bloodtype_sipply() {
		return Id_bloodtype_sipply;
	}
	public void setId_bloodtype_sipply(String id_bloodtype_sipply) {
		Id_bloodtype_sipply = id_bloodtype_sipply;
	}
	public String getSd_bloodtype_sipply() {
		return Sd_bloodtype_sipply;
	}
	public void setSd_bloodtype_sipply(String sd_bloodtype_sipply) {
		Sd_bloodtype_sipply = sd_bloodtype_sipply;
	}
	public String getId_rh() {
		return Id_rh;
	}
	public void setId_rh(String id_rh) {
		Id_rh = id_rh;
	}
	public String getSd_rh() {
		return Sd_rh;
	}
	public void setSd_rh(String sd_rh) {
		Sd_rh = sd_rh;
	}
	public FDateTime getReaction_time() {
		return Reaction_time;
	}
	public void setReaction_time(FDateTime reaction_time) {
		Reaction_time = reaction_time;
	}
	public String getBlood_bag_no() {
		return Blood_bag_no;
	}
	public void setBlood_bag_no(String blood_bag_no) {
		Blood_bag_no = blood_bag_no;
	}
	public FDateTime getCollection_time() {
		return Collection_time;
	}
	public void setCollection_time(FDateTime collection_time) {
		Collection_time = collection_time;
	}
	public String getId_bloodtype_tran() {
		return Id_bloodtype_tran;
	}
	public void setId_bloodtype_tran(String id_bloodtype_tran) {
		Id_bloodtype_tran = id_bloodtype_tran;
	}
	public String getSd_bloodtype_tran() {
		return Sd_bloodtype_tran;
	}
	public void setSd_bloodtype_tran(String sd_bloodtype_tran) {
		Sd_bloodtype_tran = sd_bloodtype_tran;
	}
	public String getId_blood_spec() {
		return Id_blood_spec;
	}
	public void setId_blood_spec(String id_blood_spec) {
		Id_blood_spec = id_blood_spec;
	}
	public String getSd_blood_spec() {
		return Sd_blood_spec;
	}
	public void setSd_blood_spec(String sd_blood_spec) {
		Sd_blood_spec = sd_blood_spec;
	}
	public FBoolean getFg_tran_blood_bad_reaction() {
		return Fg_tran_blood_bad_reaction;
	}
	public void setFg_tran_blood_bad_reaction(FBoolean fg_tran_blood_bad_reaction) {
		Fg_tran_blood_bad_reaction = fg_tran_blood_bad_reaction;
	}
	public FBoolean getFg_fever() {
		return Fg_fever;
	}
	public void setFg_fever(FBoolean fg_fever) {
		Fg_fever = fg_fever;
	}
	public FBoolean getFg_allergy() {
		return Fg_allergy;
	}
	public void setFg_allergy(FBoolean fg_allergy) {
		Fg_allergy = fg_allergy;
	}
	public FBoolean getFg_hemolysis() {
		return Fg_hemolysis;
	}
	public void setFg_hemolysis(FBoolean fg_hemolysis) {
		Fg_hemolysis = fg_hemolysis;
	}
	public FBoolean getFg_bacterium_contaminate() {
		return Fg_bacterium_contaminate;
	}
	public void setFg_bacterium_contaminate(FBoolean fg_bacterium_contaminate) {
		Fg_bacterium_contaminate = fg_bacterium_contaminate;
	}
	public FBoolean getFg_oth() {
		return Fg_oth;
	}
	public void setFg_oth(FBoolean fg_oth) {
		Fg_oth = fg_oth;
	}
	public String getDef22() {
		return Def22;
	}
	public void setDef22(String def22) {
		Def22 = def22;
	}
	public String getDef23() {
		return Def23;
	}
	public void setDef23(String def23) {
		Def23 = def23;
	}
	public String getDef24() {
		return Def24;
	}
	public void setDef24(String def24) {
		Def24 = def24;
	}
	public String getDef25() {
		return Def25;
	}
	public void setDef25(String def25) {
		Def25 = def25;
	}
	public String getDef26() {
		return Def26;
	}
	public void setDef26(String def26) {
		Def26 = def26;
	}
	public String getDef27() {
		return Def27;
	}
	public void setDef27(String def27) {
		Def27 = def27;
	}
	public String getDef28() {
		return Def28;
	}
	public void setDef28(String def28) {
		Def28 = def28;
	}
	public String getDef29() {
		return Def29;
	}
	public void setDef29(String def29) {
		Def29 = def29;
	}
	public String getDef30() {
		return Def30;
	}
	public void setDef30(String def30) {
		Def30 = def30;
	}
	public String getDef31() {
		return Def31;
	}
	public void setDef31(String def31) {
		Def31 = def31;
	}
	public String getDef32() {
		return Def32;
	}
	public void setDef32(String def32) {
		Def32 = def32;
	}
	public String getDef40() {
		return Def40;
	}
	public void setDef40(String def40) {
		Def40 = def40;
	}
	public String getDef33() {
		return Def33;
	}
	public void setDef33(String def33) {
		Def33 = def33;
	}
	public String getDef34() {
		return Def34;
	}
	public void setDef34(String def34) {
		Def34 = def34;
	}
	public String getDef35() {
		return Def35;
	}
	public void setDef35(String def35) {
		Def35 = def35;
	}
	public String getDef36() {
		return Def36;
	}
	public void setDef36(String def36) {
		Def36 = def36;
	}
	public String getDef37() {
		return Def37;
	}
	public void setDef37(String def37) {
		Def37 = def37;
	}
	public String getDef38() {
		return Def38;
	}
	public void setDef38(String def38) {
		Def38 = def38;
	}
	public String getDef39() {
		return Def39;
	}
	public void setDef39(String def39) {
		Def39 = def39;
	}
	public String getReporter() {
		return Reporter;
	}
	public void setReporter(String reporter) {
		Reporter = reporter;
	}
	public FDateTime getReport_time() {
		return Report_time;
	}
	public void setReport_time(FDateTime report_time) {
		Report_time = report_time;
	}
	public String getDept_sign() {
		return Dept_sign;
	}
	public void setDept_sign(String dept_sign) {
		Dept_sign = dept_sign;
	}
	public FDateTime getTime() {
		return time;
	}
	public void setTime(FDateTime time) {
		this.time = time;
	}
	

	
	

}
