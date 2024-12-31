package iih.ems.eass.emmc.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ems.eass.emmc.d.desc.EmsMcDODesc;
import java.math.BigDecimal;

/**
 * 设备月结 DO数据 
 * 
 */
public class EmsMcDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//月结主键
	public static final String ID_MC= "Id_mc";
	//月结类型
	public static final String ID_MC_TYPE= "Id_mc_type";
	//月结类型编码
	public static final String SD_MC_TYPE= "Sd_mc_type";
	//仓库
	public static final String ID_WH= "Id_wh";
	//所属科室
	public static final String ID_DEPT= "Id_dept";
	//保管科室
	public static final String ID_STOR_DEPT= "Id_stor_dept";
	//会计期间
	public static final String ID_ACCPERIODMONTH= "Id_accperiodmonth";
	//会计年月
	public static final String YEAR_MONTH= "Year_month";
	//月结状态
	public static final String ID_MC_ST= "Id_mc_st";
	//月结状态编码
	public static final String SD_MC_ST= "Sd_mc_st";
	//操作人
	public static final String ID_OPER= "Id_oper";
	//操作时间
	public static final String DT_OPER= "Dt_oper";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//新增资产数量
	public static final String NEW_NUM= "New_num";
	//新增资产金额
	public static final String NEW_COST= "New_cost";
	//月折旧设备数量
	public static final String DE_NUM= "De_num";
	//月折旧金额
	public static final String DE_COST= "De_cost";
	//盘盈数量
	public static final String CHKUP_NUM= "Chkup_num";
	//盘盈金额
	public static final String CHKUP_COST= "Chkup_cost";
	//盘亏数量
	public static final String CHKDOWN_NUM= "Chkdown_num";
	//盘亏金额
	public static final String CHKDOWN_COST= "Chkdown_cost";
	//报损数量
	public static final String DM_NUM= "Dm_num";
	//报损金额
	public static final String DM_CODE= "Dm_code";
	//维修数量
	public static final String REP_NUM= "Rep_num";
	//维修金额
	public static final String REP_COST= "Rep_cost";
	//名称
	public static final String NAME_MCTP= "Name_mctp";
	//仓库名称
	public static final String NAME_WH= "Name_wh";
	//名称
	public static final String NAME_DEPT= "Name_dept";
	//名称
	public static final String NAME_STOR_DEPT= "Name_stor_dept";
	//期间方案名称
	public static final String NAME_ACCPER= "Name_accper";
	//名称
	public static final String NAME_MCST= "Name_mcst";
	//姓名
	public static final String NAME_OPER= "Name_oper";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 月结主键
	 * @return String
	 */
	public String getId_mc() {
		return ((String) getAttrVal("Id_mc"));
	}	
	/**
	 * 月结主键
	 * @param Id_mc
	 */
	public void setId_mc(String Id_mc) {
		setAttrVal("Id_mc", Id_mc);
	}
	/**
	 * 月结类型
	 * @return String
	 */
	public String getId_mc_type() {
		return ((String) getAttrVal("Id_mc_type"));
	}	
	/**
	 * 月结类型
	 * @param Id_mc_type
	 */
	public void setId_mc_type(String Id_mc_type) {
		setAttrVal("Id_mc_type", Id_mc_type);
	}
	/**
	 * 月结类型编码
	 * @return String
	 */
	public String getSd_mc_type() {
		return ((String) getAttrVal("Sd_mc_type"));
	}	
	/**
	 * 月结类型编码
	 * @param Sd_mc_type
	 */
	public void setSd_mc_type(String Sd_mc_type) {
		setAttrVal("Sd_mc_type", Sd_mc_type);
	}
	/**
	 * 仓库
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	/**
	 * 仓库
	 * @param Id_wh
	 */
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	/**
	 * 所属科室
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}	
	/**
	 * 所属科室
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	/**
	 * 保管科室
	 * @return String
	 */
	public String getId_stor_dept() {
		return ((String) getAttrVal("Id_stor_dept"));
	}	
	/**
	 * 保管科室
	 * @param Id_stor_dept
	 */
	public void setId_stor_dept(String Id_stor_dept) {
		setAttrVal("Id_stor_dept", Id_stor_dept);
	}
	/**
	 * 会计期间
	 * @return String
	 */
	public String getId_accperiodmonth() {
		return ((String) getAttrVal("Id_accperiodmonth"));
	}	
	/**
	 * 会计期间
	 * @param Id_accperiodmonth
	 */
	public void setId_accperiodmonth(String Id_accperiodmonth) {
		setAttrVal("Id_accperiodmonth", Id_accperiodmonth);
	}
	/**
	 * 会计年月
	 * @return String
	 */
	public String getYear_month() {
		return ((String) getAttrVal("Year_month"));
	}	
	/**
	 * 会计年月
	 * @param Year_month
	 */
	public void setYear_month(String Year_month) {
		setAttrVal("Year_month", Year_month);
	}
	/**
	 * 月结状态
	 * @return String
	 */
	public String getId_mc_st() {
		return ((String) getAttrVal("Id_mc_st"));
	}	
	/**
	 * 月结状态
	 * @param Id_mc_st
	 */
	public void setId_mc_st(String Id_mc_st) {
		setAttrVal("Id_mc_st", Id_mc_st);
	}
	/**
	 * 月结状态编码
	 * @return String
	 */
	public String getSd_mc_st() {
		return ((String) getAttrVal("Sd_mc_st"));
	}	
	/**
	 * 月结状态编码
	 * @param Sd_mc_st
	 */
	public void setSd_mc_st(String Sd_mc_st) {
		setAttrVal("Sd_mc_st", Sd_mc_st);
	}
	/**
	 * 操作人
	 * @return String
	 */
	public String getId_oper() {
		return ((String) getAttrVal("Id_oper"));
	}	
	/**
	 * 操作人
	 * @param Id_oper
	 */
	public void setId_oper(String Id_oper) {
		setAttrVal("Id_oper", Id_oper);
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
	 * 新增资产数量
	 * @return Integer
	 */
	public Integer getNew_num() {
		return ((Integer) getAttrVal("New_num"));
	}	
	/**
	 * 新增资产数量
	 * @param New_num
	 */
	public void setNew_num(Integer New_num) {
		setAttrVal("New_num", New_num);
	}
	/**
	 * 新增资产金额
	 * @return FDouble
	 */
	public FDouble getNew_cost() {
		return ((FDouble) getAttrVal("New_cost"));
	}	
	/**
	 * 新增资产金额
	 * @param New_cost
	 */
	public void setNew_cost(FDouble New_cost) {
		setAttrVal("New_cost", New_cost);
	}
	/**
	 * 月折旧设备数量
	 * @return String
	 */
	public String getDe_num() {
		return ((String) getAttrVal("De_num"));
	}	
	/**
	 * 月折旧设备数量
	 * @param De_num
	 */
	public void setDe_num(String De_num) {
		setAttrVal("De_num", De_num);
	}
	/**
	 * 月折旧金额
	 * @return String
	 */
	public String getDe_cost() {
		return ((String) getAttrVal("De_cost"));
	}	
	/**
	 * 月折旧金额
	 * @param De_cost
	 */
	public void setDe_cost(String De_cost) {
		setAttrVal("De_cost", De_cost);
	}
	/**
	 * 盘盈数量
	 * @return Integer
	 */
	public Integer getChkup_num() {
		return ((Integer) getAttrVal("Chkup_num"));
	}	
	/**
	 * 盘盈数量
	 * @param Chkup_num
	 */
	public void setChkup_num(Integer Chkup_num) {
		setAttrVal("Chkup_num", Chkup_num);
	}
	/**
	 * 盘盈金额
	 * @return FDouble
	 */
	public FDouble getChkup_cost() {
		return ((FDouble) getAttrVal("Chkup_cost"));
	}	
	/**
	 * 盘盈金额
	 * @param Chkup_cost
	 */
	public void setChkup_cost(FDouble Chkup_cost) {
		setAttrVal("Chkup_cost", Chkup_cost);
	}
	/**
	 * 盘亏数量
	 * @return Integer
	 */
	public Integer getChkdown_num() {
		return ((Integer) getAttrVal("Chkdown_num"));
	}	
	/**
	 * 盘亏数量
	 * @param Chkdown_num
	 */
	public void setChkdown_num(Integer Chkdown_num) {
		setAttrVal("Chkdown_num", Chkdown_num);
	}
	/**
	 * 盘亏金额
	 * @return FDouble
	 */
	public FDouble getChkdown_cost() {
		return ((FDouble) getAttrVal("Chkdown_cost"));
	}	
	/**
	 * 盘亏金额
	 * @param Chkdown_cost
	 */
	public void setChkdown_cost(FDouble Chkdown_cost) {
		setAttrVal("Chkdown_cost", Chkdown_cost);
	}
	/**
	 * 报损数量
	 * @return Integer
	 */
	public Integer getDm_num() {
		return ((Integer) getAttrVal("Dm_num"));
	}	
	/**
	 * 报损数量
	 * @param Dm_num
	 */
	public void setDm_num(Integer Dm_num) {
		setAttrVal("Dm_num", Dm_num);
	}
	/**
	 * 报损金额
	 * @return FDouble
	 */
	public FDouble getDm_code() {
		return ((FDouble) getAttrVal("Dm_code"));
	}	
	/**
	 * 报损金额
	 * @param Dm_code
	 */
	public void setDm_code(FDouble Dm_code) {
		setAttrVal("Dm_code", Dm_code);
	}
	/**
	 * 维修数量
	 * @return Integer
	 */
	public Integer getRep_num() {
		return ((Integer) getAttrVal("Rep_num"));
	}	
	/**
	 * 维修数量
	 * @param Rep_num
	 */
	public void setRep_num(Integer Rep_num) {
		setAttrVal("Rep_num", Rep_num);
	}
	/**
	 * 维修金额
	 * @return FDouble
	 */
	public FDouble getRep_cost() {
		return ((FDouble) getAttrVal("Rep_cost"));
	}	
	/**
	 * 维修金额
	 * @param Rep_cost
	 */
	public void setRep_cost(FDouble Rep_cost) {
		setAttrVal("Rep_cost", Rep_cost);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_mctp() {
		return ((String) getAttrVal("Name_mctp"));
	}	
	/**
	 * 名称
	 * @param Name_mctp
	 */
	public void setName_mctp(String Name_mctp) {
		setAttrVal("Name_mctp", Name_mctp);
	}
	/**
	 * 仓库名称
	 * @return String
	 */
	public String getName_wh() {
		return ((String) getAttrVal("Name_wh"));
	}	
	/**
	 * 仓库名称
	 * @param Name_wh
	 */
	public void setName_wh(String Name_wh) {
		setAttrVal("Name_wh", Name_wh);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}	
	/**
	 * 名称
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_stor_dept() {
		return ((String) getAttrVal("Name_stor_dept"));
	}	
	/**
	 * 名称
	 * @param Name_stor_dept
	 */
	public void setName_stor_dept(String Name_stor_dept) {
		setAttrVal("Name_stor_dept", Name_stor_dept);
	}
	/**
	 * 期间方案名称
	 * @return String
	 */
	public String getName_accper() {
		return ((String) getAttrVal("Name_accper"));
	}	
	/**
	 * 期间方案名称
	 * @param Name_accper
	 */
	public void setName_accper(String Name_accper) {
		setAttrVal("Name_accper", Name_accper);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_mcst() {
		return ((String) getAttrVal("Name_mcst"));
	}	
	/**
	 * 名称
	 * @param Name_mcst
	 */
	public void setName_mcst(String Name_mcst) {
		setAttrVal("Name_mcst", Name_mcst);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_oper() {
		return ((String) getAttrVal("Name_oper"));
	}	
	/**
	 * 姓名
	 * @param Name_oper
	 */
	public void setName_oper(String Name_oper) {
		setAttrVal("Name_oper", Name_oper);
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
		return "Id_mc";
	}
	
	@Override
	public String getTableName() {	  
		return "ems_mc";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmsMcDODesc.class);
	}
	
}