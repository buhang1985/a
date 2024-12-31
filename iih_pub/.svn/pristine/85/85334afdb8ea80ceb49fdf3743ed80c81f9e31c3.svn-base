package iih.mm.st.stockpriceadjust.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.st.stockpriceadjust.d.desc.StockPriceAdjustDODesc;
import java.math.BigDecimal;

/**
 * 库存调价 DO数据 
 * 
 */
public class StockPriceAdjustDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//库存调价主键
	public static final String ID_STPRI= "Id_stpri";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//库存调价编码
	public static final String CODE= "Code";
	//调价生效日期时间
	public static final String DT_PRI= "Dt_pri";
	//调价员
	public static final String ID_EMP_STPRI= "Id_emp_stpri";
	//调价录入时间
	public static final String DT_STPRI= "Dt_stpri";
	//调价录入日期
	public static final String DT_STPRI_SHORT= "Dt_stpri_short";
	//调价原因
	public static final String PRIREASON= "Prireason";
	//审核员
	public static final String ID_EMP_CHECK= "Id_emp_check";
	//审核日期
	public static final String DT_CHECK= "Dt_check";
	//审核意见
	public static final String APCOMMENTS= "Apcomments";
	//调价状态
	public static final String ID_SU_STPRI= "Id_su_stpri";
	//调价状态编码
	public static final String SD_SU_STPRI= "Sd_su_stpri";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//调价文件号
	public static final String DOC_NO= "Doc_no";
	//物品主键
	public static final String ID_MM= "Id_mm";
	//包装单位_零售
	public static final String ID_MMPKGU_SALES= "Id_mmpkgu_sales";
	//原售价模式
	public static final String ID_PRIMD_OLD= "Id_primd_old";
	//原售价模式编码
	public static final String SD_PRIMD_OLD= "Sd_primd_old";
	//新售价模式
	public static final String ID_PRIMD_NEW= "Id_primd_new";
	//新售价模式编码
	public static final String SD_PRIMD_NEW= "Sd_primd_new";
	//原加成率
	public static final String RATE_OLD= "Rate_old";
	//新加成率
	public static final String RATE_NEW= "Rate_new";
	//原价格_零售
	public static final String PRI_OLD_SALES= "Pri_old_sales";
	//新价格_零售
	public static final String PRI_NEW_SALES= "Pri_new_sales";
	//新价格_进价
	public static final String PRI_NEW_IN= "Pri_new_in";
	//生产厂家
	public static final String SUP_ID= "Sup_id";
	//退库仓库
	public static final String ID_WH_BACK= "Id_wh_back";
	//年月
	public static final String YEAR_MONTH= "Year_month";
	//流程任务ID
	public static final String ID_TASK= "Id_task";
	//流程定义ID
	public static final String ID_PRO_DEF= "Id_pro_def";
	//流程实例ID
	public static final String ID_PRO_INS= "Id_pro_ins";
	//姓名
	public static final String EMP_STPRI_NAME= "Emp_stpri_name";
	//姓名
	public static final String EMP_CHECK_NAME= "Emp_check_name";
	//名称
	public static final String SU_STPRI_NAME= "Su_stpri_name";
	//物品规格
	public static final String MM_SPEC= "Mm_spec";
	//生产厂家名称
	public static final String SUP_NAME= "Sup_name";
	//物品名称
	public static final String MM_NAME= "Mm_name";
	//零售包装单位名称
	public static final String NAME_UNIT_PKGSP= "Name_unit_pkgsp";
	//零售价
	public static final String SALE_PRICE= "Sale_price";
	//生产厂家主键
	public static final String ID_SUP= "Id_sup";
	//物品编码
	public static final String MM_CODE= "Mm_code";
	//包装单位名称
	public static final String SALE_MMPKGUNAME= "Sale_mmpkguname";
	//名称
	public static final String PRIMD_OLD_NAME= "Primd_old_name";
	//名称
	public static final String PRIMD_NEW_NAME= "Primd_new_name";
	//仓库名称
	public static final String WH_NAME= "Wh_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 库存调价主键
	 * @return String
	 */
	public String getId_stpri() {
		return ((String) getAttrVal("Id_stpri"));
	}	
	/**
	 * 库存调价主键
	 * @param Id_stpri
	 */
	public void setId_stpri(String Id_stpri) {
		setAttrVal("Id_stpri", Id_stpri);
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
	 * 库存调价编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 库存调价编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 调价生效日期时间
	 * @return FDateTime
	 */
	public FDateTime getDt_pri() {
		return ((FDateTime) getAttrVal("Dt_pri"));
	}	
	/**
	 * 调价生效日期时间
	 * @param Dt_pri
	 */
	public void setDt_pri(FDateTime Dt_pri) {
		setAttrVal("Dt_pri", Dt_pri);
	}
	/**
	 * 调价员
	 * @return String
	 */
	public String getId_emp_stpri() {
		return ((String) getAttrVal("Id_emp_stpri"));
	}	
	/**
	 * 调价员
	 * @param Id_emp_stpri
	 */
	public void setId_emp_stpri(String Id_emp_stpri) {
		setAttrVal("Id_emp_stpri", Id_emp_stpri);
	}
	/**
	 * 调价录入时间
	 * @return FDateTime
	 */
	public FDateTime getDt_stpri() {
		return ((FDateTime) getAttrVal("Dt_stpri"));
	}	
	/**
	 * 调价录入时间
	 * @param Dt_stpri
	 */
	public void setDt_stpri(FDateTime Dt_stpri) {
		setAttrVal("Dt_stpri", Dt_stpri);
	}
	/**
	 * 调价录入日期
	 * @return FDate
	 */
	public FDate getDt_stpri_short() {
		return ((FDate) getAttrVal("Dt_stpri_short"));
	}	
	/**
	 * 调价录入日期
	 * @param Dt_stpri_short
	 */
	public void setDt_stpri_short(FDate Dt_stpri_short) {
		setAttrVal("Dt_stpri_short", Dt_stpri_short);
	}
	/**
	 * 调价原因
	 * @return String
	 */
	public String getPrireason() {
		return ((String) getAttrVal("Prireason"));
	}	
	/**
	 * 调价原因
	 * @param Prireason
	 */
	public void setPrireason(String Prireason) {
		setAttrVal("Prireason", Prireason);
	}
	/**
	 * 审核员
	 * @return String
	 */
	public String getId_emp_check() {
		return ((String) getAttrVal("Id_emp_check"));
	}	
	/**
	 * 审核员
	 * @param Id_emp_check
	 */
	public void setId_emp_check(String Id_emp_check) {
		setAttrVal("Id_emp_check", Id_emp_check);
	}
	/**
	 * 审核日期
	 * @return FDateTime
	 */
	public FDateTime getDt_check() {
		return ((FDateTime) getAttrVal("Dt_check"));
	}	
	/**
	 * 审核日期
	 * @param Dt_check
	 */
	public void setDt_check(FDateTime Dt_check) {
		setAttrVal("Dt_check", Dt_check);
	}
	/**
	 * 审核意见
	 * @return String
	 */
	public String getApcomments() {
		return ((String) getAttrVal("Apcomments"));
	}	
	/**
	 * 审核意见
	 * @param Apcomments
	 */
	public void setApcomments(String Apcomments) {
		setAttrVal("Apcomments", Apcomments);
	}
	/**
	 * 调价状态
	 * @return String
	 */
	public String getId_su_stpri() {
		return ((String) getAttrVal("Id_su_stpri"));
	}	
	/**
	 * 调价状态
	 * @param Id_su_stpri
	 */
	public void setId_su_stpri(String Id_su_stpri) {
		setAttrVal("Id_su_stpri", Id_su_stpri);
	}
	/**
	 * 调价状态编码
	 * @return String
	 */
	public String getSd_su_stpri() {
		return ((String) getAttrVal("Sd_su_stpri"));
	}	
	/**
	 * 调价状态编码
	 * @param Sd_su_stpri
	 */
	public void setSd_su_stpri(String Sd_su_stpri) {
		setAttrVal("Sd_su_stpri", Sd_su_stpri);
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
	 * 调价文件号
	 * @return String
	 */
	public String getDoc_no() {
		return ((String) getAttrVal("Doc_no"));
	}	
	/**
	 * 调价文件号
	 * @param Doc_no
	 */
	public void setDoc_no(String Doc_no) {
		setAttrVal("Doc_no", Doc_no);
	}
	/**
	 * 物品主键
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 物品主键
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 包装单位_零售
	 * @return String
	 */
	public String getId_mmpkgu_sales() {
		return ((String) getAttrVal("Id_mmpkgu_sales"));
	}	
	/**
	 * 包装单位_零售
	 * @param Id_mmpkgu_sales
	 */
	public void setId_mmpkgu_sales(String Id_mmpkgu_sales) {
		setAttrVal("Id_mmpkgu_sales", Id_mmpkgu_sales);
	}
	/**
	 * 原售价模式
	 * @return String
	 */
	public String getId_primd_old() {
		return ((String) getAttrVal("Id_primd_old"));
	}	
	/**
	 * 原售价模式
	 * @param Id_primd_old
	 */
	public void setId_primd_old(String Id_primd_old) {
		setAttrVal("Id_primd_old", Id_primd_old);
	}
	/**
	 * 原售价模式编码
	 * @return String
	 */
	public String getSd_primd_old() {
		return ((String) getAttrVal("Sd_primd_old"));
	}	
	/**
	 * 原售价模式编码
	 * @param Sd_primd_old
	 */
	public void setSd_primd_old(String Sd_primd_old) {
		setAttrVal("Sd_primd_old", Sd_primd_old);
	}
	/**
	 * 新售价模式
	 * @return String
	 */
	public String getId_primd_new() {
		return ((String) getAttrVal("Id_primd_new"));
	}	
	/**
	 * 新售价模式
	 * @param Id_primd_new
	 */
	public void setId_primd_new(String Id_primd_new) {
		setAttrVal("Id_primd_new", Id_primd_new);
	}
	/**
	 * 新售价模式编码
	 * @return String
	 */
	public String getSd_primd_new() {
		return ((String) getAttrVal("Sd_primd_new"));
	}	
	/**
	 * 新售价模式编码
	 * @param Sd_primd_new
	 */
	public void setSd_primd_new(String Sd_primd_new) {
		setAttrVal("Sd_primd_new", Sd_primd_new);
	}
	/**
	 * 原加成率
	 * @return FDouble
	 */
	public FDouble getRate_old() {
		return ((FDouble) getAttrVal("Rate_old"));
	}	
	/**
	 * 原加成率
	 * @param Rate_old
	 */
	public void setRate_old(FDouble Rate_old) {
		setAttrVal("Rate_old", Rate_old);
	}
	/**
	 * 新加成率
	 * @return FDouble
	 */
	public FDouble getRate_new() {
		return ((FDouble) getAttrVal("Rate_new"));
	}	
	/**
	 * 新加成率
	 * @param Rate_new
	 */
	public void setRate_new(FDouble Rate_new) {
		setAttrVal("Rate_new", Rate_new);
	}
	/**
	 * 原价格_零售
	 * @return FDouble
	 */
	public FDouble getPri_old_sales() {
		return ((FDouble) getAttrVal("Pri_old_sales"));
	}	
	/**
	 * 原价格_零售
	 * @param Pri_old_sales
	 */
	public void setPri_old_sales(FDouble Pri_old_sales) {
		setAttrVal("Pri_old_sales", Pri_old_sales);
	}
	/**
	 * 新价格_零售
	 * @return FDouble
	 */
	public FDouble getPri_new_sales() {
		return ((FDouble) getAttrVal("Pri_new_sales"));
	}	
	/**
	 * 新价格_零售
	 * @param Pri_new_sales
	 */
	public void setPri_new_sales(FDouble Pri_new_sales) {
		setAttrVal("Pri_new_sales", Pri_new_sales);
	}
	/**
	 * 新价格_进价
	 * @return FDouble
	 */
	public FDouble getPri_new_in() {
		return ((FDouble) getAttrVal("Pri_new_in"));
	}	
	/**
	 * 新价格_进价
	 * @param Pri_new_in
	 */
	public void setPri_new_in(FDouble Pri_new_in) {
		setAttrVal("Pri_new_in", Pri_new_in);
	}
	/**
	 * 生产厂家
	 * @return String
	 */
	public String getSup_id() {
		return ((String) getAttrVal("Sup_id"));
	}	
	/**
	 * 生产厂家
	 * @param Sup_id
	 */
	public void setSup_id(String Sup_id) {
		setAttrVal("Sup_id", Sup_id);
	}
	/**
	 * 退库仓库
	 * @return String
	 */
	public String getId_wh_back() {
		return ((String) getAttrVal("Id_wh_back"));
	}	
	/**
	 * 退库仓库
	 * @param Id_wh_back
	 */
	public void setId_wh_back(String Id_wh_back) {
		setAttrVal("Id_wh_back", Id_wh_back);
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
	 * 流程任务ID
	 * @return String
	 */
	public String getId_task() {
		return ((String) getAttrVal("Id_task"));
	}	
	/**
	 * 流程任务ID
	 * @param Id_task
	 */
	public void setId_task(String Id_task) {
		setAttrVal("Id_task", Id_task);
	}
	/**
	 * 流程定义ID
	 * @return String
	 */
	public String getId_pro_def() {
		return ((String) getAttrVal("Id_pro_def"));
	}	
	/**
	 * 流程定义ID
	 * @param Id_pro_def
	 */
	public void setId_pro_def(String Id_pro_def) {
		setAttrVal("Id_pro_def", Id_pro_def);
	}
	/**
	 * 流程实例ID
	 * @return String
	 */
	public String getId_pro_ins() {
		return ((String) getAttrVal("Id_pro_ins"));
	}	
	/**
	 * 流程实例ID
	 * @param Id_pro_ins
	 */
	public void setId_pro_ins(String Id_pro_ins) {
		setAttrVal("Id_pro_ins", Id_pro_ins);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getEmp_stpri_name() {
		return ((String) getAttrVal("Emp_stpri_name"));
	}	
	/**
	 * 姓名
	 * @param Emp_stpri_name
	 */
	public void setEmp_stpri_name(String Emp_stpri_name) {
		setAttrVal("Emp_stpri_name", Emp_stpri_name);
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
	 * 名称
	 * @return String
	 */
	public String getSu_stpri_name() {
		return ((String) getAttrVal("Su_stpri_name"));
	}	
	/**
	 * 名称
	 * @param Su_stpri_name
	 */
	public void setSu_stpri_name(String Su_stpri_name) {
		setAttrVal("Su_stpri_name", Su_stpri_name);
	}
	/**
	 * 物品规格
	 * @return String
	 */
	public String getMm_spec() {
		return ((String) getAttrVal("Mm_spec"));
	}	
	/**
	 * 物品规格
	 * @param Mm_spec
	 */
	public void setMm_spec(String Mm_spec) {
		setAttrVal("Mm_spec", Mm_spec);
	}
	/**
	 * 生产厂家名称
	 * @return String
	 */
	public String getSup_name() {
		return ((String) getAttrVal("Sup_name"));
	}	
	/**
	 * 生产厂家名称
	 * @param Sup_name
	 */
	public void setSup_name(String Sup_name) {
		setAttrVal("Sup_name", Sup_name);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getMm_name() {
		return ((String) getAttrVal("Mm_name"));
	}	
	/**
	 * 物品名称
	 * @param Mm_name
	 */
	public void setMm_name(String Mm_name) {
		setAttrVal("Mm_name", Mm_name);
	}
	/**
	 * 零售包装单位名称
	 * @return String
	 */
	public String getName_unit_pkgsp() {
		return ((String) getAttrVal("Name_unit_pkgsp"));
	}	
	/**
	 * 零售包装单位名称
	 * @param Name_unit_pkgsp
	 */
	public void setName_unit_pkgsp(String Name_unit_pkgsp) {
		setAttrVal("Name_unit_pkgsp", Name_unit_pkgsp);
	}
	/**
	 * 零售价
	 * @return FDouble
	 */
	public FDouble getSale_price() {
		return ((FDouble) getAttrVal("Sale_price"));
	}	
	/**
	 * 零售价
	 * @param Sale_price
	 */
	public void setSale_price(FDouble Sale_price) {
		setAttrVal("Sale_price", Sale_price);
	}
	/**
	 * 生产厂家主键
	 * @return String
	 */
	public String getId_sup() {
		return ((String) getAttrVal("Id_sup"));
	}	
	/**
	 * 生产厂家主键
	 * @param Id_sup
	 */
	public void setId_sup(String Id_sup) {
		setAttrVal("Id_sup", Id_sup);
	}
	/**
	 * 物品编码
	 * @return String
	 */
	public String getMm_code() {
		return ((String) getAttrVal("Mm_code"));
	}	
	/**
	 * 物品编码
	 * @param Mm_code
	 */
	public void setMm_code(String Mm_code) {
		setAttrVal("Mm_code", Mm_code);
	}
	/**
	 * 包装单位名称
	 * @return String
	 */
	public String getSale_mmpkguname() {
		return ((String) getAttrVal("Sale_mmpkguname"));
	}	
	/**
	 * 包装单位名称
	 * @param Sale_mmpkguname
	 */
	public void setSale_mmpkguname(String Sale_mmpkguname) {
		setAttrVal("Sale_mmpkguname", Sale_mmpkguname);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getPrimd_old_name() {
		return ((String) getAttrVal("Primd_old_name"));
	}	
	/**
	 * 名称
	 * @param Primd_old_name
	 */
	public void setPrimd_old_name(String Primd_old_name) {
		setAttrVal("Primd_old_name", Primd_old_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getPrimd_new_name() {
		return ((String) getAttrVal("Primd_new_name"));
	}	
	/**
	 * 名称
	 * @param Primd_new_name
	 */
	public void setPrimd_new_name(String Primd_new_name) {
		setAttrVal("Primd_new_name", Primd_new_name);
	}
	/**
	 * 仓库名称
	 * @return String
	 */
	public String getWh_name() {
		return ((String) getAttrVal("Wh_name"));
	}	
	/**
	 * 仓库名称
	 * @param Wh_name
	 */
	public void setWh_name(String Wh_name) {
		setAttrVal("Wh_name", Wh_name);
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
		return "Id_stpri";
	}
	
	@Override
	public String getTableName() {	  
		return "MM_ST_PRI";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(StockPriceAdjustDODesc.class);
	}
	
}