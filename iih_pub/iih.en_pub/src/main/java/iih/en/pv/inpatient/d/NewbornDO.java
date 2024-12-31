package iih.en.pv.inpatient.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.inpatient.d.desc.NewbornDODesc;
import java.math.BigDecimal;

/**
 * 新生儿记录 DO数据 
 * 
 */
public class NewbornDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//新生儿记录id
	public static final String ID_ENTNB= "Id_entnb";
	//新生就诊id
	public static final String ID_ENT_BB= "Id_ent_bb";
	//新生儿患者id
	public static final String ID_PAT_BB= "Id_pat_bb";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//母亲就诊id
	public static final String ID_ENT_MOM= "Id_ent_mom";
	//母亲患者id
	public static final String ID_PAT_MOM= "Id_pat_mom";
	//婴儿序号
	public static final String NO_BB= "No_bb";
	//婴儿姓名
	public static final String NAME_BB= "Name_bb";
	//性别id
	public static final String ID_SEX= "Id_sex";
	//性别编码
	public static final String SD_SEX= "Sd_sex";
	//出生证编号
	public static final String NO_BIRTHCERT= "No_birthcert";
	//出生时间
	public static final String DT_BIRTH= "Dt_birth";
	//胎龄(周)
	public static final String GESTATION= "Gestation";
	//胎龄显示
	public static final String GESTATION_DIS= "Gestation_dis";
	//健康状况id
	public static final String ID_NEWBB_HEALTH= "Id_newbb_health";
	//健康状况编码
	public static final String SD_NEWBB_HEALTH= "Sd_newbb_health";
	//体重
	public static final String WEIGHT= "Weight";
	//身高
	public static final String HEIGHT= "Height";
	//分娩方式id
	public static final String ID_BIRTHTP= "Id_birthtp";
	//分娩方式编码
	public static final String SD_BIRTHTP= "Sd_birthtp";
	//父亲姓名
	public static final String NAME_DAD= "Name_dad";
	//父亲年龄
	public static final String AGE_DAD= "Age_dad";
	//父亲国籍id
	public static final String ID_COUNTRY_DAD= "Id_country_dad";
	//父亲国籍编码
	public static final String SD_COUNTRY_DAD= "Sd_country_dad";
	//父亲民族id
	public static final String ID_NATION_DAD= "Id_nation_dad";
	//父亲民族编码
	public static final String SD_NATION_DAD= "Sd_nation_dad";
	//父亲证件类型id
	public static final String ID_IDTP_DAD= "Id_idtp_dad";
	//父亲证件类型编码
	public static final String SD_IDTP_DAD= "Sd_idtp_dad";
	//父亲证件号
	public static final String NO_ID_DAD= "No_id_dad";
	//登记人员
	public static final String ID_EMP_REG= "Id_emp_reg";
	//登记日期
	public static final String DT_REG= "Dt_reg";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//入院体重
	public static final String WEIGHT_REG= "Weight_reg";
	//分离标志
	public static final String FG_SEPA= "Fg_sepa";
	//名称
	public static final String NAME_SEX= "Name_sex";
	//名称
	public static final String NAME_HEALTHY= "Name_healthy";
	//名称
	public static final String NAME_BIRTHTP= "Name_birthtp";
	//名称
	public static final String NAME_COUNTRY= "Name_country";
	//名称
	public static final String NAME_NATION= "Name_nation";
	//名称
	public static final String NAME_IDTP= "Name_idtp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 新生儿记录id
	 * @return String
	 */
	public String getId_entnb() {
		return ((String) getAttrVal("Id_entnb"));
	}	
	/**
	 * 新生儿记录id
	 * @param Id_entnb
	 */
	public void setId_entnb(String Id_entnb) {
		setAttrVal("Id_entnb", Id_entnb);
	}
	/**
	 * 新生就诊id
	 * @return String
	 */
	public String getId_ent_bb() {
		return ((String) getAttrVal("Id_ent_bb"));
	}	
	/**
	 * 新生就诊id
	 * @param Id_ent_bb
	 */
	public void setId_ent_bb(String Id_ent_bb) {
		setAttrVal("Id_ent_bb", Id_ent_bb);
	}
	/**
	 * 新生儿患者id
	 * @return String
	 */
	public String getId_pat_bb() {
		return ((String) getAttrVal("Id_pat_bb"));
	}	
	/**
	 * 新生儿患者id
	 * @param Id_pat_bb
	 */
	public void setId_pat_bb(String Id_pat_bb) {
		setAttrVal("Id_pat_bb", Id_pat_bb);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 母亲就诊id
	 * @return String
	 */
	public String getId_ent_mom() {
		return ((String) getAttrVal("Id_ent_mom"));
	}	
	/**
	 * 母亲就诊id
	 * @param Id_ent_mom
	 */
	public void setId_ent_mom(String Id_ent_mom) {
		setAttrVal("Id_ent_mom", Id_ent_mom);
	}
	/**
	 * 母亲患者id
	 * @return String
	 */
	public String getId_pat_mom() {
		return ((String) getAttrVal("Id_pat_mom"));
	}	
	/**
	 * 母亲患者id
	 * @param Id_pat_mom
	 */
	public void setId_pat_mom(String Id_pat_mom) {
		setAttrVal("Id_pat_mom", Id_pat_mom);
	}
	/**
	 * 婴儿序号
	 * @return Integer
	 */
	public Integer getNo_bb() {
		return ((Integer) getAttrVal("No_bb"));
	}	
	/**
	 * 婴儿序号
	 * @param No_bb
	 */
	public void setNo_bb(Integer No_bb) {
		setAttrVal("No_bb", No_bb);
	}
	/**
	 * 婴儿姓名
	 * @return String
	 */
	public String getName_bb() {
		return ((String) getAttrVal("Name_bb"));
	}	
	/**
	 * 婴儿姓名
	 * @param Name_bb
	 */
	public void setName_bb(String Name_bb) {
		setAttrVal("Name_bb", Name_bb);
	}
	/**
	 * 性别id
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}	
	/**
	 * 性别id
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}	
	/**
	 * 性别编码
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 出生证编号
	 * @return String
	 */
	public String getNo_birthcert() {
		return ((String) getAttrVal("No_birthcert"));
	}	
	/**
	 * 出生证编号
	 * @param No_birthcert
	 */
	public void setNo_birthcert(String No_birthcert) {
		setAttrVal("No_birthcert", No_birthcert);
	}
	/**
	 * 出生时间
	 * @return FDateTime
	 */
	public FDateTime getDt_birth() {
		return ((FDateTime) getAttrVal("Dt_birth"));
	}	
	/**
	 * 出生时间
	 * @param Dt_birth
	 */
	public void setDt_birth(FDateTime Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 胎龄(周)
	 * @return FDouble
	 */
	public FDouble getGestation() {
		return ((FDouble) getAttrVal("Gestation"));
	}	
	/**
	 * 胎龄(周)
	 * @param Gestation
	 */
	public void setGestation(FDouble Gestation) {
		setAttrVal("Gestation", Gestation);
	}
	/**
	 * 胎龄显示
	 * @return String
	 */
	public String getGestation_dis() {
		return ((String) getAttrVal("Gestation_dis"));
	}	
	/**
	 * 胎龄显示
	 * @param Gestation_dis
	 */
	public void setGestation_dis(String Gestation_dis) {
		setAttrVal("Gestation_dis", Gestation_dis);
	}
	/**
	 * 健康状况id
	 * @return String
	 */
	public String getId_newbb_health() {
		return ((String) getAttrVal("Id_newbb_health"));
	}	
	/**
	 * 健康状况id
	 * @param Id_newbb_health
	 */
	public void setId_newbb_health(String Id_newbb_health) {
		setAttrVal("Id_newbb_health", Id_newbb_health);
	}
	/**
	 * 健康状况编码
	 * @return String
	 */
	public String getSd_newbb_health() {
		return ((String) getAttrVal("Sd_newbb_health"));
	}	
	/**
	 * 健康状况编码
	 * @param Sd_newbb_health
	 */
	public void setSd_newbb_health(String Sd_newbb_health) {
		setAttrVal("Sd_newbb_health", Sd_newbb_health);
	}
	/**
	 * 体重
	 * @return FDouble
	 */
	public FDouble getWeight() {
		return ((FDouble) getAttrVal("Weight"));
	}	
	/**
	 * 体重
	 * @param Weight
	 */
	public void setWeight(FDouble Weight) {
		setAttrVal("Weight", Weight);
	}
	/**
	 * 身高
	 * @return FDouble
	 */
	public FDouble getHeight() {
		return ((FDouble) getAttrVal("Height"));
	}	
	/**
	 * 身高
	 * @param Height
	 */
	public void setHeight(FDouble Height) {
		setAttrVal("Height", Height);
	}
	/**
	 * 分娩方式id
	 * @return String
	 */
	public String getId_birthtp() {
		return ((String) getAttrVal("Id_birthtp"));
	}	
	/**
	 * 分娩方式id
	 * @param Id_birthtp
	 */
	public void setId_birthtp(String Id_birthtp) {
		setAttrVal("Id_birthtp", Id_birthtp);
	}
	/**
	 * 分娩方式编码
	 * @return String
	 */
	public String getSd_birthtp() {
		return ((String) getAttrVal("Sd_birthtp"));
	}	
	/**
	 * 分娩方式编码
	 * @param Sd_birthtp
	 */
	public void setSd_birthtp(String Sd_birthtp) {
		setAttrVal("Sd_birthtp", Sd_birthtp);
	}
	/**
	 * 父亲姓名
	 * @return String
	 */
	public String getName_dad() {
		return ((String) getAttrVal("Name_dad"));
	}	
	/**
	 * 父亲姓名
	 * @param Name_dad
	 */
	public void setName_dad(String Name_dad) {
		setAttrVal("Name_dad", Name_dad);
	}
	/**
	 * 父亲年龄
	 * @return String
	 */
	public String getAge_dad() {
		return ((String) getAttrVal("Age_dad"));
	}	
	/**
	 * 父亲年龄
	 * @param Age_dad
	 */
	public void setAge_dad(String Age_dad) {
		setAttrVal("Age_dad", Age_dad);
	}
	/**
	 * 父亲国籍id
	 * @return String
	 */
	public String getId_country_dad() {
		return ((String) getAttrVal("Id_country_dad"));
	}	
	/**
	 * 父亲国籍id
	 * @param Id_country_dad
	 */
	public void setId_country_dad(String Id_country_dad) {
		setAttrVal("Id_country_dad", Id_country_dad);
	}
	/**
	 * 父亲国籍编码
	 * @return String
	 */
	public String getSd_country_dad() {
		return ((String) getAttrVal("Sd_country_dad"));
	}	
	/**
	 * 父亲国籍编码
	 * @param Sd_country_dad
	 */
	public void setSd_country_dad(String Sd_country_dad) {
		setAttrVal("Sd_country_dad", Sd_country_dad);
	}
	/**
	 * 父亲民族id
	 * @return String
	 */
	public String getId_nation_dad() {
		return ((String) getAttrVal("Id_nation_dad"));
	}	
	/**
	 * 父亲民族id
	 * @param Id_nation_dad
	 */
	public void setId_nation_dad(String Id_nation_dad) {
		setAttrVal("Id_nation_dad", Id_nation_dad);
	}
	/**
	 * 父亲民族编码
	 * @return String
	 */
	public String getSd_nation_dad() {
		return ((String) getAttrVal("Sd_nation_dad"));
	}	
	/**
	 * 父亲民族编码
	 * @param Sd_nation_dad
	 */
	public void setSd_nation_dad(String Sd_nation_dad) {
		setAttrVal("Sd_nation_dad", Sd_nation_dad);
	}
	/**
	 * 父亲证件类型id
	 * @return String
	 */
	public String getId_idtp_dad() {
		return ((String) getAttrVal("Id_idtp_dad"));
	}	
	/**
	 * 父亲证件类型id
	 * @param Id_idtp_dad
	 */
	public void setId_idtp_dad(String Id_idtp_dad) {
		setAttrVal("Id_idtp_dad", Id_idtp_dad);
	}
	/**
	 * 父亲证件类型编码
	 * @return String
	 */
	public String getSd_idtp_dad() {
		return ((String) getAttrVal("Sd_idtp_dad"));
	}	
	/**
	 * 父亲证件类型编码
	 * @param Sd_idtp_dad
	 */
	public void setSd_idtp_dad(String Sd_idtp_dad) {
		setAttrVal("Sd_idtp_dad", Sd_idtp_dad);
	}
	/**
	 * 父亲证件号
	 * @return String
	 */
	public String getNo_id_dad() {
		return ((String) getAttrVal("No_id_dad"));
	}	
	/**
	 * 父亲证件号
	 * @param No_id_dad
	 */
	public void setNo_id_dad(String No_id_dad) {
		setAttrVal("No_id_dad", No_id_dad);
	}
	/**
	 * 登记人员
	 * @return String
	 */
	public String getId_emp_reg() {
		return ((String) getAttrVal("Id_emp_reg"));
	}	
	/**
	 * 登记人员
	 * @param Id_emp_reg
	 */
	public void setId_emp_reg(String Id_emp_reg) {
		setAttrVal("Id_emp_reg", Id_emp_reg);
	}
	/**
	 * 登记日期
	 * @return FDateTime
	 */
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}	
	/**
	 * 登记日期
	 * @param Dt_reg
	 */
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 入院体重
	 * @return FDouble
	 */
	public FDouble getWeight_reg() {
		return ((FDouble) getAttrVal("Weight_reg"));
	}	
	/**
	 * 入院体重
	 * @param Weight_reg
	 */
	public void setWeight_reg(FDouble Weight_reg) {
		setAttrVal("Weight_reg", Weight_reg);
	}
	/**
	 * 分离标志
	 * @return FBoolean
	 */
	public FBoolean getFg_sepa() {
		return ((FBoolean) getAttrVal("Fg_sepa"));
	}	
	/**
	 * 分离标志
	 * @param Fg_sepa
	 */
	public void setFg_sepa(FBoolean Fg_sepa) {
		setAttrVal("Fg_sepa", Fg_sepa);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	/**
	 * 名称
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_healthy() {
		return ((String) getAttrVal("Name_healthy"));
	}	
	/**
	 * 名称
	 * @param Name_healthy
	 */
	public void setName_healthy(String Name_healthy) {
		setAttrVal("Name_healthy", Name_healthy);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_birthtp() {
		return ((String) getAttrVal("Name_birthtp"));
	}	
	/**
	 * 名称
	 * @param Name_birthtp
	 */
	public void setName_birthtp(String Name_birthtp) {
		setAttrVal("Name_birthtp", Name_birthtp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_country() {
		return ((String) getAttrVal("Name_country"));
	}	
	/**
	 * 名称
	 * @param Name_country
	 */
	public void setName_country(String Name_country) {
		setAttrVal("Name_country", Name_country);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_nation() {
		return ((String) getAttrVal("Name_nation"));
	}	
	/**
	 * 名称
	 * @param Name_nation
	 */
	public void setName_nation(String Name_nation) {
		setAttrVal("Name_nation", Name_nation);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_idtp() {
		return ((String) getAttrVal("Name_idtp"));
	}	
	/**
	 * 名称
	 * @param Name_idtp
	 */
	public void setName_idtp(String Name_idtp) {
		setAttrVal("Name_idtp", Name_idtp);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_entnb";
	}
	
	@Override
	public String getTableName() {	  
		return "EN_ENT_NB";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NewbornDODesc.class);
	}
	
}