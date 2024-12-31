package iih.nm.nit.nmnitgrpplpsn.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nit.nmnitgrpplpsn.d.desc.NmNitPsnCycRecDODesc;
import java.math.BigDecimal;

/**
 * 护理管理_人员实习轮转记录 DO数据 
 * 
 */
public class NmNitPsnCycRecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//人员实习记录主键
	public static final String ID_NIT_PSN_CYCREC= "Id_nit_psn_cycrec";
	//实习人员外键
	public static final String ID_NIT_PSNINFO= "Id_nit_psninfo";
	//实习小组计划外键
	public static final String ID_NIT_GRPPL= "Id_nit_grppl";
	//实习小组计划人员外键
	public static final String ID_NIT_GRPPL_PSN= "Id_nit_grppl_psn";
	//护理单元
	public static final String ID_DEP_NUR= "Id_dep_nur";
	//关联科室
	public static final String ID_DEP= "Id_dep";
	//是否评价
	public static final String FG_ASS= "Fg_ass";
	//开始日期
	public static final String DT_BEGIN= "Dt_begin";
	//结束日期
	public static final String DT_END= "Dt_end";
	//带教老师
	public static final String ID_TCH_PSN= "Id_tch_psn";
	//理论成绩
	public static final String GRADE= "Grade";
	//理论成绩等级
	public static final String ID_GRD_LVL= "Id_grd_lvl";
	//理论成绩等级编码
	public static final String SD_GRP_LVL= "Sd_grp_lvl";
	//实操成绩
	public static final String ACT_GRADE= "Act_grade";
	//实操成绩等级
	public static final String ID_ACT_GRADE= "Id_act_grade";
	//实操成绩等级编码
	public static final String SD_ACT_GRADE= "Sd_act_grade";
	//评优
	public static final String ID_APPRA= "Id_appra";
	//评优编码
	public static final String SD_APPRA= "Sd_appra";
	//登记人
	public static final String ID_REG_PSN= "Id_reg_psn";
	//登记时间
	public static final String DT_REG= "Dt_reg";
	//描述
	public static final String DES= "Des";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//姓名
	public static final String NAME_NITPSNINFO= "Name_nitpsninfo";
	//护理单元名称
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	//名称
	public static final String NAME_DEP= "Name_dep";
	//人员姓名
	public static final String NAME_TCH_PSN= "Name_tch_psn";
	//名称
	public static final String NAME_GRD_LVL= "Name_grd_lvl";
	//名称
	public static final String NAME_ACT_GRADE= "Name_act_grade";
	//名称
	public static final String NAME_APPRA= "Name_appra";
	//人员姓名
	public static final String NAME_REG_PSN= "Name_reg_psn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 人员实习记录主键
	 * @return String
	 */
	public String getId_nit_psn_cycrec() {
		return ((String) getAttrVal("Id_nit_psn_cycrec"));
	}	
	/**
	 * 人员实习记录主键
	 * @param Id_nit_psn_cycrec
	 */
	public void setId_nit_psn_cycrec(String Id_nit_psn_cycrec) {
		setAttrVal("Id_nit_psn_cycrec", Id_nit_psn_cycrec);
	}
	/**
	 * 实习人员外键
	 * @return String
	 */
	public String getId_nit_psninfo() {
		return ((String) getAttrVal("Id_nit_psninfo"));
	}	
	/**
	 * 实习人员外键
	 * @param Id_nit_psninfo
	 */
	public void setId_nit_psninfo(String Id_nit_psninfo) {
		setAttrVal("Id_nit_psninfo", Id_nit_psninfo);
	}
	/**
	 * 实习小组计划外键
	 * @return String
	 */
	public String getId_nit_grppl() {
		return ((String) getAttrVal("Id_nit_grppl"));
	}	
	/**
	 * 实习小组计划外键
	 * @param Id_nit_grppl
	 */
	public void setId_nit_grppl(String Id_nit_grppl) {
		setAttrVal("Id_nit_grppl", Id_nit_grppl);
	}
	/**
	 * 实习小组计划人员外键
	 * @return String
	 */
	public String getId_nit_grppl_psn() {
		return ((String) getAttrVal("Id_nit_grppl_psn"));
	}	
	/**
	 * 实习小组计划人员外键
	 * @param Id_nit_grppl_psn
	 */
	public void setId_nit_grppl_psn(String Id_nit_grppl_psn) {
		setAttrVal("Id_nit_grppl_psn", Id_nit_grppl_psn);
	}
	/**
	 * 护理单元
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	/**
	 * 护理单元
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 关联科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 关联科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 是否评价
	 * @return FBoolean
	 */
	public FBoolean getFg_ass() {
		return ((FBoolean) getAttrVal("Fg_ass"));
	}	
	/**
	 * 是否评价
	 * @param Fg_ass
	 */
	public void setFg_ass(FBoolean Fg_ass) {
		setAttrVal("Fg_ass", Fg_ass);
	}
	/**
	 * 开始日期
	 * @return FDate
	 */
	public FDate getDt_begin() {
		return ((FDate) getAttrVal("Dt_begin"));
	}	
	/**
	 * 开始日期
	 * @param Dt_begin
	 */
	public void setDt_begin(FDate Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 结束日期
	 * @return FDate
	 */
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}	
	/**
	 * 结束日期
	 * @param Dt_end
	 */
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 带教老师
	 * @return String
	 */
	public String getId_tch_psn() {
		return ((String) getAttrVal("Id_tch_psn"));
	}	
	/**
	 * 带教老师
	 * @param Id_tch_psn
	 */
	public void setId_tch_psn(String Id_tch_psn) {
		setAttrVal("Id_tch_psn", Id_tch_psn);
	}
	/**
	 * 理论成绩
	 * @return FDouble
	 */
	public FDouble getGrade() {
		return ((FDouble) getAttrVal("Grade"));
	}	
	/**
	 * 理论成绩
	 * @param Grade
	 */
	public void setGrade(FDouble Grade) {
		setAttrVal("Grade", Grade);
	}
	/**
	 * 理论成绩等级
	 * @return String
	 */
	public String getId_grd_lvl() {
		return ((String) getAttrVal("Id_grd_lvl"));
	}	
	/**
	 * 理论成绩等级
	 * @param Id_grd_lvl
	 */
	public void setId_grd_lvl(String Id_grd_lvl) {
		setAttrVal("Id_grd_lvl", Id_grd_lvl);
	}
	/**
	 * 理论成绩等级编码
	 * @return String
	 */
	public String getSd_grp_lvl() {
		return ((String) getAttrVal("Sd_grp_lvl"));
	}	
	/**
	 * 理论成绩等级编码
	 * @param Sd_grp_lvl
	 */
	public void setSd_grp_lvl(String Sd_grp_lvl) {
		setAttrVal("Sd_grp_lvl", Sd_grp_lvl);
	}
	/**
	 * 实操成绩
	 * @return FDouble
	 */
	public FDouble getAct_grade() {
		return ((FDouble) getAttrVal("Act_grade"));
	}	
	/**
	 * 实操成绩
	 * @param Act_grade
	 */
	public void setAct_grade(FDouble Act_grade) {
		setAttrVal("Act_grade", Act_grade);
	}
	/**
	 * 实操成绩等级
	 * @return String
	 */
	public String getId_act_grade() {
		return ((String) getAttrVal("Id_act_grade"));
	}	
	/**
	 * 实操成绩等级
	 * @param Id_act_grade
	 */
	public void setId_act_grade(String Id_act_grade) {
		setAttrVal("Id_act_grade", Id_act_grade);
	}
	/**
	 * 实操成绩等级编码
	 * @return String
	 */
	public String getSd_act_grade() {
		return ((String) getAttrVal("Sd_act_grade"));
	}	
	/**
	 * 实操成绩等级编码
	 * @param Sd_act_grade
	 */
	public void setSd_act_grade(String Sd_act_grade) {
		setAttrVal("Sd_act_grade", Sd_act_grade);
	}
	/**
	 * 评优
	 * @return String
	 */
	public String getId_appra() {
		return ((String) getAttrVal("Id_appra"));
	}	
	/**
	 * 评优
	 * @param Id_appra
	 */
	public void setId_appra(String Id_appra) {
		setAttrVal("Id_appra", Id_appra);
	}
	/**
	 * 评优编码
	 * @return String
	 */
	public String getSd_appra() {
		return ((String) getAttrVal("Sd_appra"));
	}	
	/**
	 * 评优编码
	 * @param Sd_appra
	 */
	public void setSd_appra(String Sd_appra) {
		setAttrVal("Sd_appra", Sd_appra);
	}
	/**
	 * 登记人
	 * @return String
	 */
	public String getId_reg_psn() {
		return ((String) getAttrVal("Id_reg_psn"));
	}	
	/**
	 * 登记人
	 * @param Id_reg_psn
	 */
	public void setId_reg_psn(String Id_reg_psn) {
		setAttrVal("Id_reg_psn", Id_reg_psn);
	}
	/**
	 * 登记时间
	 * @return FDateTime
	 */
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}	
	/**
	 * 登记时间
	 * @param Dt_reg
	 */
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
	}
	/**
	 * 描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	 * 姓名
	 * @return String
	 */
	public String getName_nitpsninfo() {
		return ((String) getAttrVal("Name_nitpsninfo"));
	}	
	/**
	 * 姓名
	 * @param Name_nitpsninfo
	 */
	public void setName_nitpsninfo(String Name_nitpsninfo) {
		setAttrVal("Name_nitpsninfo", Name_nitpsninfo);
	}
	/**
	 * 护理单元名称
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	/**
	 * 护理单元名称
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 人员姓名
	 * @return String
	 */
	public String getName_tch_psn() {
		return ((String) getAttrVal("Name_tch_psn"));
	}	
	/**
	 * 人员姓名
	 * @param Name_tch_psn
	 */
	public void setName_tch_psn(String Name_tch_psn) {
		setAttrVal("Name_tch_psn", Name_tch_psn);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_grd_lvl() {
		return ((String) getAttrVal("Name_grd_lvl"));
	}	
	/**
	 * 名称
	 * @param Name_grd_lvl
	 */
	public void setName_grd_lvl(String Name_grd_lvl) {
		setAttrVal("Name_grd_lvl", Name_grd_lvl);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_act_grade() {
		return ((String) getAttrVal("Name_act_grade"));
	}	
	/**
	 * 名称
	 * @param Name_act_grade
	 */
	public void setName_act_grade(String Name_act_grade) {
		setAttrVal("Name_act_grade", Name_act_grade);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_appra() {
		return ((String) getAttrVal("Name_appra"));
	}	
	/**
	 * 名称
	 * @param Name_appra
	 */
	public void setName_appra(String Name_appra) {
		setAttrVal("Name_appra", Name_appra);
	}
	/**
	 * 人员姓名
	 * @return String
	 */
	public String getName_reg_psn() {
		return ((String) getAttrVal("Name_reg_psn"));
	}	
	/**
	 * 人员姓名
	 * @param Name_reg_psn
	 */
	public void setName_reg_psn(String Name_reg_psn) {
		setAttrVal("Name_reg_psn", Name_reg_psn);
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
		return "Id_nit_psn_cycrec";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NIT_PSN_CYCREC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNitPsnCycRecDODesc.class);
	}
	
}