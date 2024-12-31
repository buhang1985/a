package iih.mp.nr.infupr.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.nr.infupr.d.desc.MpInfuPrDODesc;
import java.math.BigDecimal;

/**
 * 输液巡视 DO数据 
 * 
 */
public class MpInfuPrDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//输液巡视主键标识
	public static final String ID_INFU_PR= "Id_infu_pr";
	//医嘱执行计划id
	public static final String ID_OR_PR= "Id_or_pr";
	//输液签主键标识
	public static final String ID_INFUSION_LBL= "Id_infusion_lbl";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//输液执行类型
	public static final String ID_PRTP= "Id_prtp";
	//输液执行类型编码
	public static final String SD_PRTP= "Sd_prtp";
	//滴速
	public static final String IVGTT= "Ivgtt";
	//弃液量
	public static final String NUM_WASTE= "Num_waste";
	//多通路标识
	public static final String FG_MULTI= "Fg_multi";
	//缺药标识
	public static final String FG_DG_STG= "Fg_dg_stg";
	//执行人
	public static final String ID_EMP_MP= "Id_emp_mp";
	//执行科室
	public static final String ID_DEP_MP= "Id_dep_mp";
	//执行时间
	public static final String DT_MP= "Dt_mp";
	//操作人
	public static final String ID_EMP_OPER= "Id_emp_oper";
	//操作科室
	public static final String ID_DEP_OPER= "Id_dep_oper";
	//操作时间
	public static final String DT_OPER= "Dt_oper";
	//备注
	public static final String NOTE= "Note";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//单位
	public static final String ID_UNIT= "Id_unit";
	//单位sd
	public static final String SD_UNIT= "Sd_unit";
	//输液情况id
	public static final String ID_SITUATION= "Id_situation";
	//输液情况sd
	public static final String SD_SITUATION= "Sd_situation";
	//输液执行类型名称
	public static final String NAME_PRTP= "Name_prtp";
	//执行人姓名
	public static final String NAME_EMP_MP= "Name_emp_mp";
	//执行科室名称
	public static final String NAME_DEP_MP= "Name_dep_mp";
	//操作人姓名
	public static final String NAME_EMP_OPER= "Name_emp_oper";
	//操作科室名称
	public static final String NAME_DEP_OPER= "Name_dep_oper";
	//单位名称
	public static final String NAME_UNIT= "Name_unit";
	//名称
	public static final String NAME_SITUATION= "Name_situation";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 输液巡视主键标识
	 * @return String
	 */
	public String getId_infu_pr() {
		return ((String) getAttrVal("Id_infu_pr"));
	}	
	/**
	 * 输液巡视主键标识
	 * @param Id_infu_pr
	 */
	public void setId_infu_pr(String Id_infu_pr) {
		setAttrVal("Id_infu_pr", Id_infu_pr);
	}
	/**
	 * 医嘱执行计划id
	 * @return String
	 */
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}	
	/**
	 * 医嘱执行计划id
	 * @param Id_or_pr
	 */
	public void setId_or_pr(String Id_or_pr) {
		setAttrVal("Id_or_pr", Id_or_pr);
	}
	/**
	 * 输液签主键标识
	 * @return String
	 */
	public String getId_infusion_lbl() {
		return ((String) getAttrVal("Id_infusion_lbl"));
	}	
	/**
	 * 输液签主键标识
	 * @param Id_infusion_lbl
	 */
	public void setId_infusion_lbl(String Id_infusion_lbl) {
		setAttrVal("Id_infusion_lbl", Id_infusion_lbl);
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
	 * 输液执行类型
	 * @return String
	 */
	public String getId_prtp() {
		return ((String) getAttrVal("Id_prtp"));
	}	
	/**
	 * 输液执行类型
	 * @param Id_prtp
	 */
	public void setId_prtp(String Id_prtp) {
		setAttrVal("Id_prtp", Id_prtp);
	}
	/**
	 * 输液执行类型编码
	 * @return String
	 */
	public String getSd_prtp() {
		return ((String) getAttrVal("Sd_prtp"));
	}	
	/**
	 * 输液执行类型编码
	 * @param Sd_prtp
	 */
	public void setSd_prtp(String Sd_prtp) {
		setAttrVal("Sd_prtp", Sd_prtp);
	}
	/**
	 * 滴速
	 * @return String
	 */
	public String getIvgtt() {
		return ((String) getAttrVal("Ivgtt"));
	}	
	/**
	 * 滴速
	 * @param Ivgtt
	 */
	public void setIvgtt(String Ivgtt) {
		setAttrVal("Ivgtt", Ivgtt);
	}
	/**
	 * 弃液量
	 * @return FDouble
	 */
	public FDouble getNum_waste() {
		return ((FDouble) getAttrVal("Num_waste"));
	}	
	/**
	 * 弃液量
	 * @param Num_waste
	 */
	public void setNum_waste(FDouble Num_waste) {
		setAttrVal("Num_waste", Num_waste);
	}
	/**
	 * 多通路标识
	 * @return FBoolean
	 */
	public FBoolean getFg_multi() {
		return ((FBoolean) getAttrVal("Fg_multi"));
	}	
	/**
	 * 多通路标识
	 * @param Fg_multi
	 */
	public void setFg_multi(FBoolean Fg_multi) {
		setAttrVal("Fg_multi", Fg_multi);
	}
	/**
	 * 缺药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_dg_stg() {
		return ((FBoolean) getAttrVal("Fg_dg_stg"));
	}	
	/**
	 * 缺药标识
	 * @param Fg_dg_stg
	 */
	public void setFg_dg_stg(FBoolean Fg_dg_stg) {
		setAttrVal("Fg_dg_stg", Fg_dg_stg);
	}
	/**
	 * 执行人
	 * @return String
	 */
	public String getId_emp_mp() {
		return ((String) getAttrVal("Id_emp_mp"));
	}	
	/**
	 * 执行人
	 * @param Id_emp_mp
	 */
	public void setId_emp_mp(String Id_emp_mp) {
		setAttrVal("Id_emp_mp", Id_emp_mp);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}	
	/**
	 * 执行科室
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp() {
		return ((FDateTime) getAttrVal("Dt_mp"));
	}	
	/**
	 * 执行时间
	 * @param Dt_mp
	 */
	public void setDt_mp(FDateTime Dt_mp) {
		setAttrVal("Dt_mp", Dt_mp);
	}
	/**
	 * 操作人
	 * @return String
	 */
	public String getId_emp_oper() {
		return ((String) getAttrVal("Id_emp_oper"));
	}	
	/**
	 * 操作人
	 * @param Id_emp_oper
	 */
	public void setId_emp_oper(String Id_emp_oper) {
		setAttrVal("Id_emp_oper", Id_emp_oper);
	}
	/**
	 * 操作科室
	 * @return String
	 */
	public String getId_dep_oper() {
		return ((String) getAttrVal("Id_dep_oper"));
	}	
	/**
	 * 操作科室
	 * @param Id_dep_oper
	 */
	public void setId_dep_oper(String Id_dep_oper) {
		setAttrVal("Id_dep_oper", Id_dep_oper);
	}
	/**
	 * 操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_oper() {
		return ((FDateTime) getAttrVal("Dt_oper"));
	}	
	/**
	 * 操作时间
	 * @param Dt_oper
	 */
	public void setDt_oper(FDateTime Dt_oper) {
		setAttrVal("Dt_oper", Dt_oper);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
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
	 * 单位
	 * @return String
	 */
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}	
	/**
	 * 单位
	 * @param Id_unit
	 */
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	/**
	 * 单位sd
	 * @return String
	 */
	public String getSd_unit() {
		return ((String) getAttrVal("Sd_unit"));
	}	
	/**
	 * 单位sd
	 * @param Sd_unit
	 */
	public void setSd_unit(String Sd_unit) {
		setAttrVal("Sd_unit", Sd_unit);
	}
	/**
	 * 输液情况id
	 * @return String
	 */
	public String getId_situation() {
		return ((String) getAttrVal("Id_situation"));
	}	
	/**
	 * 输液情况id
	 * @param Id_situation
	 */
	public void setId_situation(String Id_situation) {
		setAttrVal("Id_situation", Id_situation);
	}
	/**
	 * 输液情况sd
	 * @return String
	 */
	public String getSd_situation() {
		return ((String) getAttrVal("Sd_situation"));
	}	
	/**
	 * 输液情况sd
	 * @param Sd_situation
	 */
	public void setSd_situation(String Sd_situation) {
		setAttrVal("Sd_situation", Sd_situation);
	}
	/**
	 * 输液执行类型名称
	 * @return String
	 */
	public String getName_prtp() {
		return ((String) getAttrVal("Name_prtp"));
	}	
	/**
	 * 输液执行类型名称
	 * @param Name_prtp
	 */
	public void setName_prtp(String Name_prtp) {
		setAttrVal("Name_prtp", Name_prtp);
	}
	/**
	 * 执行人姓名
	 * @return String
	 */
	public String getName_emp_mp() {
		return ((String) getAttrVal("Name_emp_mp"));
	}	
	/**
	 * 执行人姓名
	 * @param Name_emp_mp
	 */
	public void setName_emp_mp(String Name_emp_mp) {
		setAttrVal("Name_emp_mp", Name_emp_mp);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}	
	/**
	 * 执行科室名称
	 * @param Name_dep_mp
	 */
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}
	/**
	 * 操作人姓名
	 * @return String
	 */
	public String getName_emp_oper() {
		return ((String) getAttrVal("Name_emp_oper"));
	}	
	/**
	 * 操作人姓名
	 * @param Name_emp_oper
	 */
	public void setName_emp_oper(String Name_emp_oper) {
		setAttrVal("Name_emp_oper", Name_emp_oper);
	}
	/**
	 * 操作科室名称
	 * @return String
	 */
	public String getName_dep_oper() {
		return ((String) getAttrVal("Name_dep_oper"));
	}	
	/**
	 * 操作科室名称
	 * @param Name_dep_oper
	 */
	public void setName_dep_oper(String Name_dep_oper) {
		setAttrVal("Name_dep_oper", Name_dep_oper);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}	
	/**
	 * 单位名称
	 * @param Name_unit
	 */
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_situation() {
		return ((String) getAttrVal("Name_situation"));
	}	
	/**
	 * 名称
	 * @param Name_situation
	 */
	public void setName_situation(String Name_situation) {
		setAttrVal("Name_situation", Name_situation);
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
		return "Id_infu_pr";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_INFU_PR";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpInfuPrDODesc.class);
	}
	
}