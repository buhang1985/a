package iih.mm.qy.stockoutinfo.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.qy.stockoutinfo.d.desc.StockOutQueryViewDesc;
import java.math.BigDecimal;

/**
 * 物品出库信息查询 DO数据 
 * 
 */
public class StockOutQueryView extends BaseDO {
	private static final long serialVersionUID = 1L;

	//出库主键
	public static final String ID_OUT= "Id_out";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//红蓝字标志
	public static final String RED_BLUE= "Red_blue";
	//交易分类
	public static final String ID_MMSTCA= "Id_mmstca";
	//出库单号
	public static final String STOUT_CODE= "Stout_code";
	//出库仓库
	public static final String ID_WH= "Id_wh";
	//开单科室
	public static final String ID_DEP_OR= "Id_dep_or";
	//领用部门
	public static final String ID_DEP= "Id_dep";
	//供应商
	public static final String ID_SUP= "Id_sup";
	//单据状态
	public static final String ID_SU_ST= "Id_su_st";
	//年月
	public static final String YEAR_MONTH= "Year_month";
	//制单人
	public static final String ID_EMP_ST= "Id_emp_st";
	//制单时间
	public static final String DT_ST= "Dt_st";
	//制单日期
	public static final String DT_ST_SHORT= "Dt_st_short";
	//确认人
	public static final String ID_EMP_CONF= "Id_emp_conf";
	//确认日期
	public static final String DT_CONF= "Dt_conf";
	//物品
	public static final String ID_MM= "Id_mm";
	//医疗物品类型
	public static final String ID_MMTP= "Id_mmtp";
	//物品分类
	public static final String ID_MMCA= "Id_mmca";
	//医疗服务
	public static final String ID_SRV= "Id_srv";
	//生产厂家
	public static final String ID_FACTORY= "Id_factory";
	//实际包装单位
	public static final String ID_MMPKGU_ACTUAL= "Id_mmpkgu_actual";
	//批次
	public static final String BATCH= "Batch";
	//有效期
	public static final String DATE_EXPI= "Date_expi";
	//唯一码
	public static final String ONLYCODE= "Onlycode";
	//物品特性
	public static final String CHARACTER= "Character";
	//进价_实际单位
	public static final String PRI_ACT= "Pri_act";
	//售价_实际单位
	public static final String PRI_SA= "Pri_sa";
	//批次售价_实际单位
	public static final String PRI_SA_BATCH= "Pri_sa_batch";
	//数量_实际单位
	public static final String QUAN_ACTUAL= "Quan_actual";
	//金额_成本
	public static final String AMT= "Amt";
	//金额_售价
	public static final String AMT_SA= "Amt_sa";
	//金额_批次售价
	public static final String AMT_SA_BATCH= "Amt_sa_batch";
	//售价是否差异(出库售价和批次售价)
	public static final String FG_SA_DIFF= "Fg_sa_diff";
	//数量总和
	public static final String QUAN_SUM= "Quan_sum";
	//合计金额_成本
	public static final String AMT_SUM= "Amt_sum";
	//合计金额_售价
	public static final String AMT_SUM_SA= "Amt_sum_sa";
	//数量总和_当前页
	public static final String QUAN_SUM_CURPAGE= "Quan_sum_curpage";
	//合计金额_成本_当前页
	public static final String AMT_SUM_CURPAGE= "Amt_sum_curpage";
	//合计金额_售价_当前页
	public static final String AMT_SUM_SA_CURPAGE= "Amt_sum_sa_curpage";
	//减免标识
	public static final String FG_FREE= "Fg_free";
	//机构名
	public static final String ORG_NAME= "Org_name";
	//库存交易分类名称
	public static final String MMSTCA_NAME= "Mmstca_name";
	//仓库名称
	public static final String WH_NAME= "Wh_name";
	//开单科室名称名称
	public static final String DEP_OR_NAME= "Dep_or_name";
	//领用部门名
	public static final String DEP_NAME= "Dep_name";
	//供应商名
	public static final String SUP_NAME= "Sup_name";
	//单据状态名
	public static final String SUST_NAME= "Sust_name";
	//制单人名
	public static final String EMPST_NAME= "Empst_name";
	//确认人名
	public static final String EMPCONF_NAME= "Empconf_name";
	//物品名称
	public static final String MM_NAME= "Mm_name";
	//物品规格
	public static final String MM_SPEC= "Mm_spec";
	//物品编码
	public static final String MM_CODE= "Mm_code";
	//医疗物品类型名称
	public static final String MMTP_NAME= "Mmtp_name";
	//物品分类名
	public static final String MMCA_NAME= "Mmca_name";
	//服务名称
	public static final String SRV_NAME= "Srv_name";
	//生产厂家名
	public static final String FACTORY_NAME= "Factory_name";
	//包装单位名称
	public static final String PKGACT_NAME= "Pkgact_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 出库主键
	 * @return String
	 */
	public String getId_out() {
		return ((String) getAttrVal("Id_out"));
	}	
	/**
	 * 出库主键
	 * @param Id_out
	 */
	public void setId_out(String Id_out) {
		setAttrVal("Id_out", Id_out);
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
	 * 红蓝字标志
	 * @return FBoolean
	 */
	public FBoolean getRed_blue() {
		return ((FBoolean) getAttrVal("Red_blue"));
	}	
	/**
	 * 红蓝字标志
	 * @param Red_blue
	 */
	public void setRed_blue(FBoolean Red_blue) {
		setAttrVal("Red_blue", Red_blue);
	}
	/**
	 * 交易分类
	 * @return String
	 */
	public String getId_mmstca() {
		return ((String) getAttrVal("Id_mmstca"));
	}	
	/**
	 * 交易分类
	 * @param Id_mmstca
	 */
	public void setId_mmstca(String Id_mmstca) {
		setAttrVal("Id_mmstca", Id_mmstca);
	}
	/**
	 * 出库单号
	 * @return String
	 */
	public String getStout_code() {
		return ((String) getAttrVal("Stout_code"));
	}	
	/**
	 * 出库单号
	 * @param Stout_code
	 */
	public void setStout_code(String Stout_code) {
		setAttrVal("Stout_code", Stout_code);
	}
	/**
	 * 出库仓库
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	/**
	 * 出库仓库
	 * @param Id_wh
	 */
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	/**
	 * 开单科室
	 * @return String
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}	
	/**
	 * 开单科室
	 * @param Id_dep_or
	 */
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	/**
	 * 领用部门
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 领用部门
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 供应商
	 * @return String
	 */
	public String getId_sup() {
		return ((String) getAttrVal("Id_sup"));
	}	
	/**
	 * 供应商
	 * @param Id_sup
	 */
	public void setId_sup(String Id_sup) {
		setAttrVal("Id_sup", Id_sup);
	}
	/**
	 * 单据状态
	 * @return String
	 */
	public String getId_su_st() {
		return ((String) getAttrVal("Id_su_st"));
	}	
	/**
	 * 单据状态
	 * @param Id_su_st
	 */
	public void setId_su_st(String Id_su_st) {
		setAttrVal("Id_su_st", Id_su_st);
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
	 * 制单人
	 * @return String
	 */
	public String getId_emp_st() {
		return ((String) getAttrVal("Id_emp_st"));
	}	
	/**
	 * 制单人
	 * @param Id_emp_st
	 */
	public void setId_emp_st(String Id_emp_st) {
		setAttrVal("Id_emp_st", Id_emp_st);
	}
	/**
	 * 制单时间
	 * @return FDateTime
	 */
	public FDateTime getDt_st() {
		return ((FDateTime) getAttrVal("Dt_st"));
	}	
	/**
	 * 制单时间
	 * @param Dt_st
	 */
	public void setDt_st(FDateTime Dt_st) {
		setAttrVal("Dt_st", Dt_st);
	}
	/**
	 * 制单日期
	 * @return FDate
	 */
	public FDate getDt_st_short() {
		return ((FDate) getAttrVal("Dt_st_short"));
	}	
	/**
	 * 制单日期
	 * @param Dt_st_short
	 */
	public void setDt_st_short(FDate Dt_st_short) {
		setAttrVal("Dt_st_short", Dt_st_short);
	}
	/**
	 * 确认人
	 * @return String
	 */
	public String getId_emp_conf() {
		return ((String) getAttrVal("Id_emp_conf"));
	}	
	/**
	 * 确认人
	 * @param Id_emp_conf
	 */
	public void setId_emp_conf(String Id_emp_conf) {
		setAttrVal("Id_emp_conf", Id_emp_conf);
	}
	/**
	 * 确认日期
	 * @return FDateTime
	 */
	public FDateTime getDt_conf() {
		return ((FDateTime) getAttrVal("Dt_conf"));
	}	
	/**
	 * 确认日期
	 * @param Dt_conf
	 */
	public void setDt_conf(FDateTime Dt_conf) {
		setAttrVal("Dt_conf", Dt_conf);
	}
	/**
	 * 物品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 物品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 医疗物品类型
	 * @return String
	 */
	public String getId_mmtp() {
		return ((String) getAttrVal("Id_mmtp"));
	}	
	/**
	 * 医疗物品类型
	 * @param Id_mmtp
	 */
	public void setId_mmtp(String Id_mmtp) {
		setAttrVal("Id_mmtp", Id_mmtp);
	}
	/**
	 * 物品分类
	 * @return String
	 */
	public String getId_mmca() {
		return ((String) getAttrVal("Id_mmca"));
	}	
	/**
	 * 物品分类
	 * @param Id_mmca
	 */
	public void setId_mmca(String Id_mmca) {
		setAttrVal("Id_mmca", Id_mmca);
	}
	/**
	 * 医疗服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 医疗服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 生产厂家
	 * @return String
	 */
	public String getId_factory() {
		return ((String) getAttrVal("Id_factory"));
	}	
	/**
	 * 生产厂家
	 * @param Id_factory
	 */
	public void setId_factory(String Id_factory) {
		setAttrVal("Id_factory", Id_factory);
	}
	/**
	 * 实际包装单位
	 * @return String
	 */
	public String getId_mmpkgu_actual() {
		return ((String) getAttrVal("Id_mmpkgu_actual"));
	}	
	/**
	 * 实际包装单位
	 * @param Id_mmpkgu_actual
	 */
	public void setId_mmpkgu_actual(String Id_mmpkgu_actual) {
		setAttrVal("Id_mmpkgu_actual", Id_mmpkgu_actual);
	}
	/**
	 * 批次
	 * @return String
	 */
	public String getBatch() {
		return ((String) getAttrVal("Batch"));
	}	
	/**
	 * 批次
	 * @param Batch
	 */
	public void setBatch(String Batch) {
		setAttrVal("Batch", Batch);
	}
	/**
	 * 有效期
	 * @return FDate
	 */
	public FDate getDate_expi() {
		return ((FDate) getAttrVal("Date_expi"));
	}	
	/**
	 * 有效期
	 * @param Date_expi
	 */
	public void setDate_expi(FDate Date_expi) {
		setAttrVal("Date_expi", Date_expi);
	}
	/**
	 * 唯一码
	 * @return String
	 */
	public String getOnlycode() {
		return ((String) getAttrVal("Onlycode"));
	}	
	/**
	 * 唯一码
	 * @param Onlycode
	 */
	public void setOnlycode(String Onlycode) {
		setAttrVal("Onlycode", Onlycode);
	}
	/**
	 * 物品特性
	 * @return String
	 */
	public String getCharacter() {
		return ((String) getAttrVal("Character"));
	}	
	/**
	 * 物品特性
	 * @param Character
	 */
	public void setCharacter(String Character) {
		setAttrVal("Character", Character);
	}
	/**
	 * 进价_实际单位
	 * @return FDouble
	 */
	public FDouble getPri_act() {
		return ((FDouble) getAttrVal("Pri_act"));
	}	
	/**
	 * 进价_实际单位
	 * @param Pri_act
	 */
	public void setPri_act(FDouble Pri_act) {
		setAttrVal("Pri_act", Pri_act);
	}
	/**
	 * 售价_实际单位
	 * @return FDouble
	 */
	public FDouble getPri_sa() {
		return ((FDouble) getAttrVal("Pri_sa"));
	}	
	/**
	 * 售价_实际单位
	 * @param Pri_sa
	 */
	public void setPri_sa(FDouble Pri_sa) {
		setAttrVal("Pri_sa", Pri_sa);
	}
	/**
	 * 批次售价_实际单位
	 * @return FDouble
	 */
	public FDouble getPri_sa_batch() {
		return ((FDouble) getAttrVal("Pri_sa_batch"));
	}	
	/**
	 * 批次售价_实际单位
	 * @param Pri_sa_batch
	 */
	public void setPri_sa_batch(FDouble Pri_sa_batch) {
		setAttrVal("Pri_sa_batch", Pri_sa_batch);
	}
	/**
	 * 数量_实际单位
	 * @return FDouble
	 */
	public FDouble getQuan_actual() {
		return ((FDouble) getAttrVal("Quan_actual"));
	}	
	/**
	 * 数量_实际单位
	 * @param Quan_actual
	 */
	public void setQuan_actual(FDouble Quan_actual) {
		setAttrVal("Quan_actual", Quan_actual);
	}
	/**
	 * 金额_成本
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	/**
	 * 金额_成本
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 金额_售价
	 * @return FDouble
	 */
	public FDouble getAmt_sa() {
		return ((FDouble) getAttrVal("Amt_sa"));
	}	
	/**
	 * 金额_售价
	 * @param Amt_sa
	 */
	public void setAmt_sa(FDouble Amt_sa) {
		setAttrVal("Amt_sa", Amt_sa);
	}
	/**
	 * 金额_批次售价
	 * @return FDouble
	 */
	public FDouble getAmt_sa_batch() {
		return ((FDouble) getAttrVal("Amt_sa_batch"));
	}	
	/**
	 * 金额_批次售价
	 * @param Amt_sa_batch
	 */
	public void setAmt_sa_batch(FDouble Amt_sa_batch) {
		setAttrVal("Amt_sa_batch", Amt_sa_batch);
	}
	/**
	 * 售价是否差异(出库售价和批次售价)
	 * @return FBoolean
	 */
	public FBoolean getFg_sa_diff() {
		return ((FBoolean) getAttrVal("Fg_sa_diff"));
	}	
	/**
	 * 售价是否差异(出库售价和批次售价)
	 * @param Fg_sa_diff
	 */
	public void setFg_sa_diff(FBoolean Fg_sa_diff) {
		setAttrVal("Fg_sa_diff", Fg_sa_diff);
	}
	/**
	 * 数量总和
	 * @return FDouble
	 */
	public FDouble getQuan_sum() {
		return ((FDouble) getAttrVal("Quan_sum"));
	}	
	/**
	 * 数量总和
	 * @param Quan_sum
	 */
	public void setQuan_sum(FDouble Quan_sum) {
		setAttrVal("Quan_sum", Quan_sum);
	}
	/**
	 * 合计金额_成本
	 * @return FDouble
	 */
	public FDouble getAmt_sum() {
		return ((FDouble) getAttrVal("Amt_sum"));
	}	
	/**
	 * 合计金额_成本
	 * @param Amt_sum
	 */
	public void setAmt_sum(FDouble Amt_sum) {
		setAttrVal("Amt_sum", Amt_sum);
	}
	/**
	 * 合计金额_售价
	 * @return FDouble
	 */
	public FDouble getAmt_sum_sa() {
		return ((FDouble) getAttrVal("Amt_sum_sa"));
	}	
	/**
	 * 合计金额_售价
	 * @param Amt_sum_sa
	 */
	public void setAmt_sum_sa(FDouble Amt_sum_sa) {
		setAttrVal("Amt_sum_sa", Amt_sum_sa);
	}
	/**
	 * 数量总和_当前页
	 * @return FDouble
	 */
	public FDouble getQuan_sum_curpage() {
		return ((FDouble) getAttrVal("Quan_sum_curpage"));
	}	
	/**
	 * 数量总和_当前页
	 * @param Quan_sum_curpage
	 */
	public void setQuan_sum_curpage(FDouble Quan_sum_curpage) {
		setAttrVal("Quan_sum_curpage", Quan_sum_curpage);
	}
	/**
	 * 合计金额_成本_当前页
	 * @return FDouble
	 */
	public FDouble getAmt_sum_curpage() {
		return ((FDouble) getAttrVal("Amt_sum_curpage"));
	}	
	/**
	 * 合计金额_成本_当前页
	 * @param Amt_sum_curpage
	 */
	public void setAmt_sum_curpage(FDouble Amt_sum_curpage) {
		setAttrVal("Amt_sum_curpage", Amt_sum_curpage);
	}
	/**
	 * 合计金额_售价_当前页
	 * @return FDouble
	 */
	public FDouble getAmt_sum_sa_curpage() {
		return ((FDouble) getAttrVal("Amt_sum_sa_curpage"));
	}	
	/**
	 * 合计金额_售价_当前页
	 * @param Amt_sum_sa_curpage
	 */
	public void setAmt_sum_sa_curpage(FDouble Amt_sum_sa_curpage) {
		setAttrVal("Amt_sum_sa_curpage", Amt_sum_sa_curpage);
	}
	/**
	 * 减免标识
	 * @return FBoolean
	 */
	public FBoolean getFg_free() {
		return ((FBoolean) getAttrVal("Fg_free"));
	}	
	/**
	 * 减免标识
	 * @param Fg_free
	 */
	public void setFg_free(FBoolean Fg_free) {
		setAttrVal("Fg_free", Fg_free);
	}
	/**
	 * 机构名
	 * @return String
	 */
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	/**
	 * 机构名
	 * @param Org_name
	 */
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	/**
	 * 库存交易分类名称
	 * @return String
	 */
	public String getMmstca_name() {
		return ((String) getAttrVal("Mmstca_name"));
	}	
	/**
	 * 库存交易分类名称
	 * @param Mmstca_name
	 */
	public void setMmstca_name(String Mmstca_name) {
		setAttrVal("Mmstca_name", Mmstca_name);
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
	/**
	 * 开单科室名称名称
	 * @return String
	 */
	public String getDep_or_name() {
		return ((String) getAttrVal("Dep_or_name"));
	}	
	/**
	 * 开单科室名称名称
	 * @param Dep_or_name
	 */
	public void setDep_or_name(String Dep_or_name) {
		setAttrVal("Dep_or_name", Dep_or_name);
	}
	/**
	 * 领用部门名
	 * @return String
	 */
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	/**
	 * 领用部门名
	 * @param Dep_name
	 */
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	/**
	 * 供应商名
	 * @return String
	 */
	public String getSup_name() {
		return ((String) getAttrVal("Sup_name"));
	}	
	/**
	 * 供应商名
	 * @param Sup_name
	 */
	public void setSup_name(String Sup_name) {
		setAttrVal("Sup_name", Sup_name);
	}
	/**
	 * 单据状态名
	 * @return String
	 */
	public String getSust_name() {
		return ((String) getAttrVal("Sust_name"));
	}	
	/**
	 * 单据状态名
	 * @param Sust_name
	 */
	public void setSust_name(String Sust_name) {
		setAttrVal("Sust_name", Sust_name);
	}
	/**
	 * 制单人名
	 * @return String
	 */
	public String getEmpst_name() {
		return ((String) getAttrVal("Empst_name"));
	}	
	/**
	 * 制单人名
	 * @param Empst_name
	 */
	public void setEmpst_name(String Empst_name) {
		setAttrVal("Empst_name", Empst_name);
	}
	/**
	 * 确认人名
	 * @return String
	 */
	public String getEmpconf_name() {
		return ((String) getAttrVal("Empconf_name"));
	}	
	/**
	 * 确认人名
	 * @param Empconf_name
	 */
	public void setEmpconf_name(String Empconf_name) {
		setAttrVal("Empconf_name", Empconf_name);
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
	 * 医疗物品类型名称
	 * @return String
	 */
	public String getMmtp_name() {
		return ((String) getAttrVal("Mmtp_name"));
	}	
	/**
	 * 医疗物品类型名称
	 * @param Mmtp_name
	 */
	public void setMmtp_name(String Mmtp_name) {
		setAttrVal("Mmtp_name", Mmtp_name);
	}
	/**
	 * 物品分类名
	 * @return String
	 */
	public String getMmca_name() {
		return ((String) getAttrVal("Mmca_name"));
	}	
	/**
	 * 物品分类名
	 * @param Mmca_name
	 */
	public void setMmca_name(String Mmca_name) {
		setAttrVal("Mmca_name", Mmca_name);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	/**
	 * 服务名称
	 * @param Srv_name
	 */
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	/**
	 * 生产厂家名
	 * @return String
	 */
	public String getFactory_name() {
		return ((String) getAttrVal("Factory_name"));
	}	
	/**
	 * 生产厂家名
	 * @param Factory_name
	 */
	public void setFactory_name(String Factory_name) {
		setAttrVal("Factory_name", Factory_name);
	}
	/**
	 * 包装单位名称
	 * @return String
	 */
	public String getPkgact_name() {
		return ((String) getAttrVal("Pkgact_name"));
	}	
	/**
	 * 包装单位名称
	 * @param Pkgact_name
	 */
	public void setPkgact_name(String Pkgact_name) {
		setAttrVal("Pkgact_name", Pkgact_name);
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
		return "Id_out";
	}
	
	@Override
	public String getTableName() {	  
		return "V_MM_STOUT_QUERY";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(StockOutQueryViewDesc.class);
	}
	
}