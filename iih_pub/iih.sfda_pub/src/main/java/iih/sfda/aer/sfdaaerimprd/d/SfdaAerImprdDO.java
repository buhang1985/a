package iih.sfda.aer.sfdaaerimprd.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sfda.aer.sfdaaerimprd.d.desc.SfdaAerImprdDODesc;
import java.math.BigDecimal;

/**
 * 受损害对象 DO数据 
 * 
 */
public class SfdaAerImprdDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//受损对象主键
	public static final String ID_AER_EV_IMPRD= "Id_aer_ev_imprd";
	//不良事件标识
	public static final String ID_AER_EV= "Id_aer_ev";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//受损害者类型
	public static final String ID_SFDA_IMPRD_TP= "Id_sfda_imprd_tp";
	//受损害者类型编码
	public static final String SD_SFDA_IMPRD_TP= "Sd_sfda_imprd_tp";
	//患者id
	public static final String ID_PAT= "Id_pat";
	//患者性别
	public static final String ID_SEX_PAT= "Id_sex_pat";
	//患者性别编码
	public static final String SD_SEX_PAT= "Sd_sex_pat";
	//患者家属姓名
	public static final String NAME_PAT_FAM= "Name_pat_fam";
	//与患者关系
	public static final String PAT_RELAT= "Pat_relat";
	//出生日期
	public static final String DT_BIRTH= "Dt_birth";
	//体重
	public static final String WGHT= "Wght";
	//联系电话
	public static final String TELL= "Tell";
	//是否为高风险患者
	public static final String FG_ISHR= "Fg_ishr";
	//就诊类型
	public static final String ID_ENTTP= "Id_enttp";
	//就诊类型编码
	public static final String SD_ENTTP= "Sd_enttp";
	//就诊日期
	public static final String DT_ENT= "Dt_ent";
	//住院号
	public static final String CODE_AMR_IP= "Code_amr_ip";
	//就诊号
	public static final String CODE_ENT= "Code_ent";
	//主诊医生
	public static final String ID_ATD_DCT= "Id_atd_dct";
	//员工标识
	public static final String ID_PSNDOC= "Id_psndoc";
	//所属科室id
	public static final String ID_DEP= "Id_dep";
	//备注
	public static final String DES= "Des";
	//扩展字段1
	public static final String EXT1= "Ext1";
	//扩展字段2
	public static final String EXT2= "Ext2";
	//扩展字段3
	public static final String EXT3= "Ext3";
	//扩展字段4
	public static final String EXT4= "Ext4";
	//扩展字段5
	public static final String EXT5= "Ext5";
	//扩展字段6
	public static final String EXT6= "Ext6";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//诊断
	public static final String NAME_DIDEF_DIS= "Name_didef_dis";
	//护理级别
	public static final String ID_NUR_LVL= "Id_nur_lvl";
	//文化程度
	public static final String ID_EDU= "Id_edu";
	//年龄
	public static final String AGE= "Age";
	//名称
	public static final String NAME_GRP= "Name_grp";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//名称
	public static final String NAME_SFDA_IMPRD_TP= "Name_sfda_imprd_tp";
	//患者姓名
	public static final String NAME_PAT= "Name_pat";
	//性别
	public static final String NAME_SEX_PAT= "Name_sex_pat";
	//就诊类型名称
	public static final String NAME_ENTTP= "Name_enttp";
	//主治医生
	public static final String NAME_ATD_DCT= "Name_atd_dct";
	//姓名
	public static final String NAME_PSNDOC= "Name_psndoc";
	//科室名称
	public static final String NAME_DEP= "Name_dep";
	//护理级别
	public static final String NAME_NUR_LVL= "Name_nur_lvl";
	//文化程度
	public static final String NAME_EDU= "Name_edu";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 受损对象主键
	 * @return String
	 */
	public String getId_aer_ev_imprd() {
		return ((String) getAttrVal("Id_aer_ev_imprd"));
	}	
	/**
	 * 受损对象主键
	 * @param Id_aer_ev_imprd
	 */
	public void setId_aer_ev_imprd(String Id_aer_ev_imprd) {
		setAttrVal("Id_aer_ev_imprd", Id_aer_ev_imprd);
	}
	/**
	 * 不良事件标识
	 * @return String
	 */
	public String getId_aer_ev() {
		return ((String) getAttrVal("Id_aer_ev"));
	}	
	/**
	 * 不良事件标识
	 * @param Id_aer_ev
	 */
	public void setId_aer_ev(String Id_aer_ev) {
		setAttrVal("Id_aer_ev", Id_aer_ev);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 受损害者类型
	 * @return String
	 */
	public String getId_sfda_imprd_tp() {
		return ((String) getAttrVal("Id_sfda_imprd_tp"));
	}	
	/**
	 * 受损害者类型
	 * @param Id_sfda_imprd_tp
	 */
	public void setId_sfda_imprd_tp(String Id_sfda_imprd_tp) {
		setAttrVal("Id_sfda_imprd_tp", Id_sfda_imprd_tp);
	}
	/**
	 * 受损害者类型编码
	 * @return String
	 */
	public String getSd_sfda_imprd_tp() {
		return ((String) getAttrVal("Sd_sfda_imprd_tp"));
	}	
	/**
	 * 受损害者类型编码
	 * @param Sd_sfda_imprd_tp
	 */
	public void setSd_sfda_imprd_tp(String Sd_sfda_imprd_tp) {
		setAttrVal("Sd_sfda_imprd_tp", Sd_sfda_imprd_tp);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者性别
	 * @return String
	 */
	public String getId_sex_pat() {
		return ((String) getAttrVal("Id_sex_pat"));
	}	
	/**
	 * 患者性别
	 * @param Id_sex_pat
	 */
	public void setId_sex_pat(String Id_sex_pat) {
		setAttrVal("Id_sex_pat", Id_sex_pat);
	}
	/**
	 * 患者性别编码
	 * @return String
	 */
	public String getSd_sex_pat() {
		return ((String) getAttrVal("Sd_sex_pat"));
	}	
	/**
	 * 患者性别编码
	 * @param Sd_sex_pat
	 */
	public void setSd_sex_pat(String Sd_sex_pat) {
		setAttrVal("Sd_sex_pat", Sd_sex_pat);
	}
	/**
	 * 患者家属姓名
	 * @return String
	 */
	public String getName_pat_fam() {
		return ((String) getAttrVal("Name_pat_fam"));
	}	
	/**
	 * 患者家属姓名
	 * @param Name_pat_fam
	 */
	public void setName_pat_fam(String Name_pat_fam) {
		setAttrVal("Name_pat_fam", Name_pat_fam);
	}
	/**
	 * 与患者关系
	 * @return String
	 */
	public String getPat_relat() {
		return ((String) getAttrVal("Pat_relat"));
	}	
	/**
	 * 与患者关系
	 * @param Pat_relat
	 */
	public void setPat_relat(String Pat_relat) {
		setAttrVal("Pat_relat", Pat_relat);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}	
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 体重
	 * @return FDouble
	 */
	public FDouble getWght() {
		return ((FDouble) getAttrVal("Wght"));
	}	
	/**
	 * 体重
	 * @param Wght
	 */
	public void setWght(FDouble Wght) {
		setAttrVal("Wght", Wght);
	}
	/**
	 * 联系电话
	 * @return String
	 */
	public String getTell() {
		return ((String) getAttrVal("Tell"));
	}	
	/**
	 * 联系电话
	 * @param Tell
	 */
	public void setTell(String Tell) {
		setAttrVal("Tell", Tell);
	}
	/**
	 * 是否为高风险患者
	 * @return FBoolean
	 */
	public FBoolean getFg_ishr() {
		return ((FBoolean) getAttrVal("Fg_ishr"));
	}	
	/**
	 * 是否为高风险患者
	 * @param Fg_ishr
	 */
	public void setFg_ishr(FBoolean Fg_ishr) {
		setAttrVal("Fg_ishr", Fg_ishr);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getId_enttp() {
		return ((String) getAttrVal("Id_enttp"));
	}	
	/**
	 * 就诊类型
	 * @param Id_enttp
	 */
	public void setId_enttp(String Id_enttp) {
		setAttrVal("Id_enttp", Id_enttp);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getSd_enttp() {
		return ((String) getAttrVal("Sd_enttp"));
	}	
	/**
	 * 就诊类型编码
	 * @param Sd_enttp
	 */
	public void setSd_enttp(String Sd_enttp) {
		setAttrVal("Sd_enttp", Sd_enttp);
	}
	/**
	 * 就诊日期
	 * @return FDate
	 */
	public FDate getDt_ent() {
		return ((FDate) getAttrVal("Dt_ent"));
	}	
	/**
	 * 就诊日期
	 * @param Dt_ent
	 */
	public void setDt_ent(FDate Dt_ent) {
		setAttrVal("Dt_ent", Dt_ent);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	/**
	 * 住院号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}	
	/**
	 * 就诊号
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 主诊医生
	 * @return String
	 */
	public String getId_atd_dct() {
		return ((String) getAttrVal("Id_atd_dct"));
	}	
	/**
	 * 主诊医生
	 * @param Id_atd_dct
	 */
	public void setId_atd_dct(String Id_atd_dct) {
		setAttrVal("Id_atd_dct", Id_atd_dct);
	}
	/**
	 * 员工标识
	 * @return String
	 */
	public String getId_psndoc() {
		return ((String) getAttrVal("Id_psndoc"));
	}	
	/**
	 * 员工标识
	 * @param Id_psndoc
	 */
	public void setId_psndoc(String Id_psndoc) {
		setAttrVal("Id_psndoc", Id_psndoc);
	}
	/**
	 * 所属科室id
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 所属科室id
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 备注
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getExt1() {
		return ((String) getAttrVal("Ext1"));
	}	
	/**
	 * 扩展字段1
	 * @param Ext1
	 */
	public void setExt1(String Ext1) {
		setAttrVal("Ext1", Ext1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getExt2() {
		return ((String) getAttrVal("Ext2"));
	}	
	/**
	 * 扩展字段2
	 * @param Ext2
	 */
	public void setExt2(String Ext2) {
		setAttrVal("Ext2", Ext2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getExt3() {
		return ((String) getAttrVal("Ext3"));
	}	
	/**
	 * 扩展字段3
	 * @param Ext3
	 */
	public void setExt3(String Ext3) {
		setAttrVal("Ext3", Ext3);
	}
	/**
	 * 扩展字段4
	 * @return String
	 */
	public String getExt4() {
		return ((String) getAttrVal("Ext4"));
	}	
	/**
	 * 扩展字段4
	 * @param Ext4
	 */
	public void setExt4(String Ext4) {
		setAttrVal("Ext4", Ext4);
	}
	/**
	 * 扩展字段5
	 * @return String
	 */
	public String getExt5() {
		return ((String) getAttrVal("Ext5"));
	}	
	/**
	 * 扩展字段5
	 * @param Ext5
	 */
	public void setExt5(String Ext5) {
		setAttrVal("Ext5", Ext5);
	}
	/**
	 * 扩展字段6
	 * @return String
	 */
	public String getExt6() {
		return ((String) getAttrVal("Ext6"));
	}	
	/**
	 * 扩展字段6
	 * @param Ext6
	 */
	public void setExt6(String Ext6) {
		setAttrVal("Ext6", Ext6);
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
	 * 诊断
	 * @return String
	 */
	public String getName_didef_dis() {
		return ((String) getAttrVal("Name_didef_dis"));
	}	
	/**
	 * 诊断
	 * @param Name_didef_dis
	 */
	public void setName_didef_dis(String Name_didef_dis) {
		setAttrVal("Name_didef_dis", Name_didef_dis);
	}
	/**
	 * 护理级别
	 * @return String
	 */
	public String getId_nur_lvl() {
		return ((String) getAttrVal("Id_nur_lvl"));
	}	
	/**
	 * 护理级别
	 * @param Id_nur_lvl
	 */
	public void setId_nur_lvl(String Id_nur_lvl) {
		setAttrVal("Id_nur_lvl", Id_nur_lvl);
	}
	/**
	 * 文化程度
	 * @return String
	 */
	public String getId_edu() {
		return ((String) getAttrVal("Id_edu"));
	}	
	/**
	 * 文化程度
	 * @param Id_edu
	 */
	public void setId_edu(String Id_edu) {
		setAttrVal("Id_edu", Id_edu);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	/**
	 * 名称
	 * @param Name_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	/**
	 * 组织名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_sfda_imprd_tp() {
		return ((String) getAttrVal("Name_sfda_imprd_tp"));
	}	
	/**
	 * 名称
	 * @param Name_sfda_imprd_tp
	 */
	public void setName_sfda_imprd_tp(String Name_sfda_imprd_tp) {
		setAttrVal("Name_sfda_imprd_tp", Name_sfda_imprd_tp);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getName_sex_pat() {
		return ((String) getAttrVal("Name_sex_pat"));
	}	
	/**
	 * 性别
	 * @param Name_sex_pat
	 */
	public void setName_sex_pat(String Name_sex_pat) {
		setAttrVal("Name_sex_pat", Name_sex_pat);
	}
	/**
	 * 就诊类型名称
	 * @return String
	 */
	public String getName_enttp() {
		return ((String) getAttrVal("Name_enttp"));
	}	
	/**
	 * 就诊类型名称
	 * @param Name_enttp
	 */
	public void setName_enttp(String Name_enttp) {
		setAttrVal("Name_enttp", Name_enttp);
	}
	/**
	 * 主治医生
	 * @return String
	 */
	public String getName_atd_dct() {
		return ((String) getAttrVal("Name_atd_dct"));
	}	
	/**
	 * 主治医生
	 * @param Name_atd_dct
	 */
	public void setName_atd_dct(String Name_atd_dct) {
		setAttrVal("Name_atd_dct", Name_atd_dct);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_psndoc() {
		return ((String) getAttrVal("Name_psndoc"));
	}	
	/**
	 * 姓名
	 * @param Name_psndoc
	 */
	public void setName_psndoc(String Name_psndoc) {
		setAttrVal("Name_psndoc", Name_psndoc);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 护理级别
	 * @return String
	 */
	public String getName_nur_lvl() {
		return ((String) getAttrVal("Name_nur_lvl"));
	}	
	/**
	 * 护理级别
	 * @param Name_nur_lvl
	 */
	public void setName_nur_lvl(String Name_nur_lvl) {
		setAttrVal("Name_nur_lvl", Name_nur_lvl);
	}
	/**
	 * 文化程度
	 * @return String
	 */
	public String getName_edu() {
		return ((String) getAttrVal("Name_edu"));
	}	
	/**
	 * 文化程度
	 * @param Name_edu
	 */
	public void setName_edu(String Name_edu) {
		setAttrVal("Name_edu", Name_edu);
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
		return "Id_aer_ev_imprd";
	}
	
	@Override
	public String getTableName() {	  
		return "SFDA_AER_IMPRD";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SfdaAerImprdDODesc.class);
	}
	
}