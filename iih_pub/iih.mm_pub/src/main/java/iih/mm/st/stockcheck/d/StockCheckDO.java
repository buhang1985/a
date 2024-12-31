package iih.mm.st.stockcheck.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.st.stockcheck.d.desc.StockCheckDODesc;
import java.math.BigDecimal;

/**
 * 库存盘点 DO数据 
 * 
 */
public class StockCheckDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//库存盘点主键
	public static final String ID_STTK= "Id_sttk";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//库存盘点类型
	public static final String ID_STTKTP= "Id_sttktp";
	//库存盘点类型编码
	public static final String SD_STTKTP= "Sd_sttktp";
	//医疗物品基本分类
	public static final String IDS_MMCA= "Ids_mmca";
	//是否批次盘点
	public static final String FG_BATCH= "Fg_batch";
	//是否按货位
	public static final String FG_LOC= "Fg_loc";
	//库存盘点编码
	public static final String CODE= "Code";
	//库存盘点名称
	public static final String NAME= "Name";
	//库存盘点描述
	public static final String DES= "Des";
	//盘点部门
	public static final String ID_DEP= "Id_dep";
	//盘点库存地点
	public static final String ID_WH= "Id_wh";
	//包装单位类型
	public static final String ID_MMPKGUTP= "Id_mmpkgutp";
	//盘点日期时间
	public static final String DT_TK= "Dt_tk";
	//盘点日期
	public static final String DT_TK_SHORT= "Dt_tk_short";
	//盘点人员
	public static final String ID_EMP_STTK= "Id_emp_sttk";
	//制单人员
	public static final String ID_EMP_SINGLE= "Id_emp_single";
	//审核人员
	public static final String ID_EMP_CHECK= "Id_emp_check";
	//审核时间
	public static final String DT_CHECK= "Dt_check";
	//审批意见
	public static final String APCOMMENTS= "Apcomments";
	//年月
	public static final String YEAR_MONTH= "Year_month";
	//盘点状态
	public static final String ID_SU_STTK= "Id_su_sttk";
	//盘点状态编码
	public static final String SD_SU_STTK= "Sd_su_sttk";
	//入库单据主键
	public static final String ID_IN= "Id_in";
	//出库单据主键
	public static final String ID_OUT= "Id_out";
	//零结存是否生单
	public static final String FG_CREATE= "Fg_create";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//拆分组别(条数)
	public static final String GRPNUM= "Grpnum";
	//账面量总金额
	public static final String TOTAL_QUAN_BK_ACTUAL= "Total_quan_bk_actual";
	//实物量总金额
	public static final String TOTAL_QUAN_ACTUAL= "Total_quan_actual";
	//盈亏量总金额
	public static final String TOTAL_DIFF_ACTUAL= "Total_diff_actual";
	//选择范围
	public static final String IS_SELECT= "Is_select";
	//库存盘点类型名称
	public static final String STTKTP_NAME= "Sttktp_name";
	//基本分类名称
	public static final String MMCA_NAME= "Mmca_name";
	//盘点仓库名称
	public static final String WH_NAME= "Wh_name";
	//包装单位类型名称
	public static final String MMPKGUTP_NAME= "Mmpkgutp_name";
	//盘点人员姓名
	public static final String EMP_STTK_NAME= "Emp_sttk_name";
	//制单人姓名
	public static final String EMP_SINGLE_NAME= "Emp_single_name";
	//姓名
	public static final String EMP_CHECK_NAME= "Emp_check_name";
	//盘点状态名称
	public static final String SU_STTK_NAME= "Su_sttk_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 库存盘点主键
	 * @return String
	 */
	public String getId_sttk() {
		return ((String) getAttrVal("Id_sttk"));
	}	
	/**
	 * 库存盘点主键
	 * @param Id_sttk
	 */
	public void setId_sttk(String Id_sttk) {
		setAttrVal("Id_sttk", Id_sttk);
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
	 * 机构
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 机构
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 库存盘点类型
	 * @return String
	 */
	public String getId_sttktp() {
		return ((String) getAttrVal("Id_sttktp"));
	}	
	/**
	 * 库存盘点类型
	 * @param Id_sttktp
	 */
	public void setId_sttktp(String Id_sttktp) {
		setAttrVal("Id_sttktp", Id_sttktp);
	}
	/**
	 * 库存盘点类型编码
	 * @return String
	 */
	public String getSd_sttktp() {
		return ((String) getAttrVal("Sd_sttktp"));
	}	
	/**
	 * 库存盘点类型编码
	 * @param Sd_sttktp
	 */
	public void setSd_sttktp(String Sd_sttktp) {
		setAttrVal("Sd_sttktp", Sd_sttktp);
	}
	/**
	 * 医疗物品基本分类
	 * @return String
	 */
	public String getIds_mmca() {
		return ((String) getAttrVal("Ids_mmca"));
	}	
	/**
	 * 医疗物品基本分类
	 * @param Ids_mmca
	 */
	public void setIds_mmca(String Ids_mmca) {
		setAttrVal("Ids_mmca", Ids_mmca);
	}
	/**
	 * 是否批次盘点
	 * @return FBoolean
	 */
	public FBoolean getFg_batch() {
		return ((FBoolean) getAttrVal("Fg_batch"));
	}	
	/**
	 * 是否批次盘点
	 * @param Fg_batch
	 */
	public void setFg_batch(FBoolean Fg_batch) {
		setAttrVal("Fg_batch", Fg_batch);
	}
	/**
	 * 是否按货位
	 * @return FBoolean
	 */
	public FBoolean getFg_loc() {
		return ((FBoolean) getAttrVal("Fg_loc"));
	}	
	/**
	 * 是否按货位
	 * @param Fg_loc
	 */
	public void setFg_loc(FBoolean Fg_loc) {
		setAttrVal("Fg_loc", Fg_loc);
	}
	/**
	 * 库存盘点编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 库存盘点编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 库存盘点名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 库存盘点名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 库存盘点描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 库存盘点描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 盘点部门
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 盘点部门
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 盘点库存地点
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	/**
	 * 盘点库存地点
	 * @param Id_wh
	 */
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	/**
	 * 包装单位类型
	 * @return String
	 */
	public String getId_mmpkgutp() {
		return ((String) getAttrVal("Id_mmpkgutp"));
	}	
	/**
	 * 包装单位类型
	 * @param Id_mmpkgutp
	 */
	public void setId_mmpkgutp(String Id_mmpkgutp) {
		setAttrVal("Id_mmpkgutp", Id_mmpkgutp);
	}
	/**
	 * 盘点日期时间
	 * @return FDateTime
	 */
	public FDateTime getDt_tk() {
		return ((FDateTime) getAttrVal("Dt_tk"));
	}	
	/**
	 * 盘点日期时间
	 * @param Dt_tk
	 */
	public void setDt_tk(FDateTime Dt_tk) {
		setAttrVal("Dt_tk", Dt_tk);
	}
	/**
	 * 盘点日期
	 * @return FDate
	 */
	public FDate getDt_tk_short() {
		return ((FDate) getAttrVal("Dt_tk_short"));
	}	
	/**
	 * 盘点日期
	 * @param Dt_tk_short
	 */
	public void setDt_tk_short(FDate Dt_tk_short) {
		setAttrVal("Dt_tk_short", Dt_tk_short);
	}
	/**
	 * 盘点人员
	 * @return String
	 */
	public String getId_emp_sttk() {
		return ((String) getAttrVal("Id_emp_sttk"));
	}	
	/**
	 * 盘点人员
	 * @param Id_emp_sttk
	 */
	public void setId_emp_sttk(String Id_emp_sttk) {
		setAttrVal("Id_emp_sttk", Id_emp_sttk);
	}
	/**
	 * 制单人员
	 * @return String
	 */
	public String getId_emp_single() {
		return ((String) getAttrVal("Id_emp_single"));
	}	
	/**
	 * 制单人员
	 * @param Id_emp_single
	 */
	public void setId_emp_single(String Id_emp_single) {
		setAttrVal("Id_emp_single", Id_emp_single);
	}
	/**
	 * 审核人员
	 * @return String
	 */
	public String getId_emp_check() {
		return ((String) getAttrVal("Id_emp_check"));
	}	
	/**
	 * 审核人员
	 * @param Id_emp_check
	 */
	public void setId_emp_check(String Id_emp_check) {
		setAttrVal("Id_emp_check", Id_emp_check);
	}
	/**
	 * 审核时间
	 * @return FDateTime
	 */
	public FDateTime getDt_check() {
		return ((FDateTime) getAttrVal("Dt_check"));
	}	
	/**
	 * 审核时间
	 * @param Dt_check
	 */
	public void setDt_check(FDateTime Dt_check) {
		setAttrVal("Dt_check", Dt_check);
	}
	/**
	 * 审批意见
	 * @return String
	 */
	public String getApcomments() {
		return ((String) getAttrVal("Apcomments"));
	}	
	/**
	 * 审批意见
	 * @param Apcomments
	 */
	public void setApcomments(String Apcomments) {
		setAttrVal("Apcomments", Apcomments);
	}
	/**
	 * 年月
	 * @return String
	 */
	public String getYear_month() {
		return ((String) getAttrVal("Year_month"));
	}	
	/**
	 * 年月
	 * @param Year_month
	 */
	public void setYear_month(String Year_month) {
		setAttrVal("Year_month", Year_month);
	}
	/**
	 * 盘点状态
	 * @return String
	 */
	public String getId_su_sttk() {
		return ((String) getAttrVal("Id_su_sttk"));
	}	
	/**
	 * 盘点状态
	 * @param Id_su_sttk
	 */
	public void setId_su_sttk(String Id_su_sttk) {
		setAttrVal("Id_su_sttk", Id_su_sttk);
	}
	/**
	 * 盘点状态编码
	 * @return String
	 */
	public String getSd_su_sttk() {
		return ((String) getAttrVal("Sd_su_sttk"));
	}	
	/**
	 * 盘点状态编码
	 * @param Sd_su_sttk
	 */
	public void setSd_su_sttk(String Sd_su_sttk) {
		setAttrVal("Sd_su_sttk", Sd_su_sttk);
	}
	/**
	 * 入库单据主键
	 * @return String
	 */
	public String getId_in() {
		return ((String) getAttrVal("Id_in"));
	}	
	/**
	 * 入库单据主键
	 * @param Id_in
	 */
	public void setId_in(String Id_in) {
		setAttrVal("Id_in", Id_in);
	}
	/**
	 * 出库单据主键
	 * @return String
	 */
	public String getId_out() {
		return ((String) getAttrVal("Id_out"));
	}	
	/**
	 * 出库单据主键
	 * @param Id_out
	 */
	public void setId_out(String Id_out) {
		setAttrVal("Id_out", Id_out);
	}
	/**
	 * 零结存是否生单
	 * @return FBoolean
	 */
	public FBoolean getFg_create() {
		return ((FBoolean) getAttrVal("Fg_create"));
	}	
	/**
	 * 零结存是否生单
	 * @param Fg_create
	 */
	public void setFg_create(FBoolean Fg_create) {
		setAttrVal("Fg_create", Fg_create);
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
	 * 拆分组别(条数)
	 * @return Integer
	 */
	public Integer getGrpnum() {
		return ((Integer) getAttrVal("Grpnum"));
	}	
	/**
	 * 拆分组别(条数)
	 * @param Grpnum
	 */
	public void setGrpnum(Integer Grpnum) {
		setAttrVal("Grpnum", Grpnum);
	}
	/**
	 * 账面量总金额
	 * @return FDouble
	 */
	public FDouble getTotal_quan_bk_actual() {
		return ((FDouble) getAttrVal("Total_quan_bk_actual"));
	}	
	/**
	 * 账面量总金额
	 * @param Total_quan_bk_actual
	 */
	public void setTotal_quan_bk_actual(FDouble Total_quan_bk_actual) {
		setAttrVal("Total_quan_bk_actual", Total_quan_bk_actual);
	}
	/**
	 * 实物量总金额
	 * @return FDouble
	 */
	public FDouble getTotal_quan_actual() {
		return ((FDouble) getAttrVal("Total_quan_actual"));
	}	
	/**
	 * 实物量总金额
	 * @param Total_quan_actual
	 */
	public void setTotal_quan_actual(FDouble Total_quan_actual) {
		setAttrVal("Total_quan_actual", Total_quan_actual);
	}
	/**
	 * 盈亏量总金额
	 * @return FDouble
	 */
	public FDouble getTotal_diff_actual() {
		return ((FDouble) getAttrVal("Total_diff_actual"));
	}	
	/**
	 * 盈亏量总金额
	 * @param Total_diff_actual
	 */
	public void setTotal_diff_actual(FDouble Total_diff_actual) {
		setAttrVal("Total_diff_actual", Total_diff_actual);
	}
	/**
	 * 选择范围
	 * @return Integer
	 */
	public Integer getIs_select() {
		return ((Integer) getAttrVal("Is_select"));
	}	
	/**
	 * 选择范围
	 * @param Is_select
	 */
	public void setIs_select(Integer Is_select) {
		setAttrVal("Is_select", Is_select);
	}
	/**
	 * 库存盘点类型名称
	 * @return String
	 */
	public String getSttktp_name() {
		return ((String) getAttrVal("Sttktp_name"));
	}	
	/**
	 * 库存盘点类型名称
	 * @param Sttktp_name
	 */
	public void setSttktp_name(String Sttktp_name) {
		setAttrVal("Sttktp_name", Sttktp_name);
	}
	/**
	 * 基本分类名称
	 * @return String
	 */
	public String getMmca_name() {
		return ((String) getAttrVal("Mmca_name"));
	}	
	/**
	 * 基本分类名称
	 * @param Mmca_name
	 */
	public void setMmca_name(String Mmca_name) {
		setAttrVal("Mmca_name", Mmca_name);
	}
	/**
	 * 盘点仓库名称
	 * @return String
	 */
	public String getWh_name() {
		return ((String) getAttrVal("Wh_name"));
	}	
	/**
	 * 盘点仓库名称
	 * @param Wh_name
	 */
	public void setWh_name(String Wh_name) {
		setAttrVal("Wh_name", Wh_name);
	}
	/**
	 * 包装单位类型名称
	 * @return String
	 */
	public String getMmpkgutp_name() {
		return ((String) getAttrVal("Mmpkgutp_name"));
	}	
	/**
	 * 包装单位类型名称
	 * @param Mmpkgutp_name
	 */
	public void setMmpkgutp_name(String Mmpkgutp_name) {
		setAttrVal("Mmpkgutp_name", Mmpkgutp_name);
	}
	/**
	 * 盘点人员姓名
	 * @return String
	 */
	public String getEmp_sttk_name() {
		return ((String) getAttrVal("Emp_sttk_name"));
	}	
	/**
	 * 盘点人员姓名
	 * @param Emp_sttk_name
	 */
	public void setEmp_sttk_name(String Emp_sttk_name) {
		setAttrVal("Emp_sttk_name", Emp_sttk_name);
	}
	/**
	 * 制单人姓名
	 * @return String
	 */
	public String getEmp_single_name() {
		return ((String) getAttrVal("Emp_single_name"));
	}	
	/**
	 * 制单人姓名
	 * @param Emp_single_name
	 */
	public void setEmp_single_name(String Emp_single_name) {
		setAttrVal("Emp_single_name", Emp_single_name);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getEmp_check_name() {
		return ((String) getAttrVal("Emp_check_name"));
	}	
	/**
	 * 姓名
	 * @param Emp_check_name
	 */
	public void setEmp_check_name(String Emp_check_name) {
		setAttrVal("Emp_check_name", Emp_check_name);
	}
	/**
	 * 盘点状态名称
	 * @return String
	 */
	public String getSu_sttk_name() {
		return ((String) getAttrVal("Su_sttk_name"));
	}	
	/**
	 * 盘点状态名称
	 * @param Su_sttk_name
	 */
	public void setSu_sttk_name(String Su_sttk_name) {
		setAttrVal("Su_sttk_name", Su_sttk_name);
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
		return "Id_sttk";
	}
	
	@Override
	public String getTableName() {	  
		return "MM_ST_TK";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(StockCheckDODesc.class);
	}
	
}