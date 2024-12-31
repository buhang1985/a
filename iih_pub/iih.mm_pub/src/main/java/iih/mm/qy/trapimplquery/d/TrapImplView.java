package iih.mm.qy.trapimplquery.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.qy.trapimplquery.d.desc.TrapImplViewDesc;
import java.math.BigDecimal;

/**
 * 调拨查询 DO数据 
 * 
 */
public class TrapImplView extends BaseDO {
	private static final long serialVersionUID = 1L;

	//调拨明细主键
	public static final String ID_TRITM= "Id_tritm";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织机构
	public static final String ID_ORG= "Id_org";
	//调拨单主键
	public static final String ID_TR= "Id_tr";
	//调拨单号
	public static final String TR_CODE= "Tr_code";
	//转出仓库
	public static final String ID_WH= "Id_wh";
	//转入仓库
	public static final String ID_WH_AP= "Id_wh_ap";
	//物品
	public static final String ID_MM= "Id_mm";
	//包装单位
	public static final String ID_MMPKGU_ACTUAL= "Id_mmpkgu_actual";
	//进价
	public static final String PRI_ACT= "Pri_act";
	//申请数量
	public static final String QUAN_DA_ACT= "Quan_da_act";
	//实发数量
	public static final String QUAN= "Quan";
	//金额_实发
	public static final String AMT= "Amt";
	//调拨单状态
	public static final String ID_TR_PL= "Id_tr_pl";
	//制单人
	public static final String ID_EMP_ST= "Id_emp_st";
	//制单时间
	public static final String DT_ST= "Dt_st";
	//制单日期
	public static final String DT_ST_SHORT= "Dt_st_short";
	//确认人
	public static final String ID_EMP_CONF= "Id_emp_conf";
	//确认时间
	public static final String DT_CONF= "Dt_conf";
	//生产厂家
	public static final String ID_FACTORY= "Id_factory";
	//售价_实际单位
	public static final String PRI_SA= "Pri_sa";
	//金额_售价
	public static final String AMT_SA= "Amt_sa";
	//合计金额_成本
	public static final String AMT_SUM= "Amt_sum";
	//合计金额_售价
	public static final String AMT_SUM_SA= "Amt_sum_sa";
	//合计金额_成本_当前页
	public static final String AMT_SUM_CURPAGE= "Amt_sum_curpage";
	//合计金额_售价_当前页
	public static final String AMT_SUM_SA_CURPAGE= "Amt_sum_sa_curpage";
	//合计实发数量
	public static final String QUAN_SUM= "Quan_sum";
	//合计实发数量_当前页
	public static final String QUAN_SUM_CURPAGE= "Quan_sum_curpage";
	//服务名
	public static final String SRV_NAME= "Srv_name";
	//打印名
	public static final String PRINTNAME= "Printname";
	//组织名称
	public static final String ORG_NAME= "Org_name";
	//仓库名称
	public static final String WH_NAME= "Wh_name";
	//仓库名称
	public static final String WHAP_NAME= "Whap_name";
	//物品名称
	public static final String MM_NAME= "Mm_name";
	//物品规格
	public static final String MM_SPEC= "Mm_spec";
	//包装单位名称
	public static final String MMPKGUNAME= "Mmpkguname";
	//名称
	public static final String TRPL_NAME= "Trpl_name";
	//姓名
	public static final String EMPST_NAME= "Empst_name";
	//姓名
	public static final String EMPCONF_NAME= "Empconf_name";
	//供应商与厂商名称
	public static final String FACTORY_NAME= "Factory_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 调拨明细主键
	 * @return String
	 */
	public String getId_tritm() {
		return ((String) getAttrVal("Id_tritm"));
	}	
	/**
	 * 调拨明细主键
	 * @param Id_tritm
	 */
	public void setId_tritm(String Id_tritm) {
		setAttrVal("Id_tritm", Id_tritm);
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
	 * 组织机构
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织机构
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 调拨单主键
	 * @return String
	 */
	public String getId_tr() {
		return ((String) getAttrVal("Id_tr"));
	}	
	/**
	 * 调拨单主键
	 * @param Id_tr
	 */
	public void setId_tr(String Id_tr) {
		setAttrVal("Id_tr", Id_tr);
	}
	/**
	 * 调拨单号
	 * @return String
	 */
	public String getTr_code() {
		return ((String) getAttrVal("Tr_code"));
	}	
	/**
	 * 调拨单号
	 * @param Tr_code
	 */
	public void setTr_code(String Tr_code) {
		setAttrVal("Tr_code", Tr_code);
	}
	/**
	 * 转出仓库
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	/**
	 * 转出仓库
	 * @param Id_wh
	 */
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	/**
	 * 转入仓库
	 * @return String
	 */
	public String getId_wh_ap() {
		return ((String) getAttrVal("Id_wh_ap"));
	}	
	/**
	 * 转入仓库
	 * @param Id_wh_ap
	 */
	public void setId_wh_ap(String Id_wh_ap) {
		setAttrVal("Id_wh_ap", Id_wh_ap);
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
	 * 包装单位
	 * @return String
	 */
	public String getId_mmpkgu_actual() {
		return ((String) getAttrVal("Id_mmpkgu_actual"));
	}	
	/**
	 * 包装单位
	 * @param Id_mmpkgu_actual
	 */
	public void setId_mmpkgu_actual(String Id_mmpkgu_actual) {
		setAttrVal("Id_mmpkgu_actual", Id_mmpkgu_actual);
	}
	/**
	 * 进价
	 * @return FDouble
	 */
	public FDouble getPri_act() {
		return ((FDouble) getAttrVal("Pri_act"));
	}	
	/**
	 * 进价
	 * @param Pri_act
	 */
	public void setPri_act(FDouble Pri_act) {
		setAttrVal("Pri_act", Pri_act);
	}
	/**
	 * 申请数量
	 * @return FDouble
	 */
	public FDouble getQuan_da_act() {
		return ((FDouble) getAttrVal("Quan_da_act"));
	}	
	/**
	 * 申请数量
	 * @param Quan_da_act
	 */
	public void setQuan_da_act(FDouble Quan_da_act) {
		setAttrVal("Quan_da_act", Quan_da_act);
	}
	/**
	 * 实发数量
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}	
	/**
	 * 实发数量
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 金额_实发
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	/**
	 * 金额_实发
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 调拨单状态
	 * @return String
	 */
	public String getId_tr_pl() {
		return ((String) getAttrVal("Id_tr_pl"));
	}	
	/**
	 * 调拨单状态
	 * @param Id_tr_pl
	 */
	public void setId_tr_pl(String Id_tr_pl) {
		setAttrVal("Id_tr_pl", Id_tr_pl);
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
	 * 确认时间
	 * @return FDateTime
	 */
	public FDateTime getDt_conf() {
		return ((FDateTime) getAttrVal("Dt_conf"));
	}	
	/**
	 * 确认时间
	 * @param Dt_conf
	 */
	public void setDt_conf(FDateTime Dt_conf) {
		setAttrVal("Dt_conf", Dt_conf);
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
	 * 合计实发数量
	 * @return FDouble
	 */
	public FDouble getQuan_sum() {
		return ((FDouble) getAttrVal("Quan_sum"));
	}	
	/**
	 * 合计实发数量
	 * @param Quan_sum
	 */
	public void setQuan_sum(FDouble Quan_sum) {
		setAttrVal("Quan_sum", Quan_sum);
	}
	/**
	 * 合计实发数量_当前页
	 * @return FDouble
	 */
	public FDouble getQuan_sum_curpage() {
		return ((FDouble) getAttrVal("Quan_sum_curpage"));
	}	
	/**
	 * 合计实发数量_当前页
	 * @param Quan_sum_curpage
	 */
	public void setQuan_sum_curpage(FDouble Quan_sum_curpage) {
		setAttrVal("Quan_sum_curpage", Quan_sum_curpage);
	}
	/**
	 * 服务名
	 * @return String
	 */
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	/**
	 * 服务名
	 * @param Srv_name
	 */
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	/**
	 * 打印名
	 * @return String
	 */
	public String getPrintname() {
		return ((String) getAttrVal("Printname"));
	}	
	/**
	 * 打印名
	 * @param Printname
	 */
	public void setPrintname(String Printname) {
		setAttrVal("Printname", Printname);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	/**
	 * 组织名称
	 * @param Org_name
	 */
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
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
	 * 仓库名称
	 * @return String
	 */
	public String getWhap_name() {
		return ((String) getAttrVal("Whap_name"));
	}	
	/**
	 * 仓库名称
	 * @param Whap_name
	 */
	public void setWhap_name(String Whap_name) {
		setAttrVal("Whap_name", Whap_name);
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
	 * 包装单位名称
	 * @return String
	 */
	public String getMmpkguname() {
		return ((String) getAttrVal("Mmpkguname"));
	}	
	/**
	 * 包装单位名称
	 * @param Mmpkguname
	 */
	public void setMmpkguname(String Mmpkguname) {
		setAttrVal("Mmpkguname", Mmpkguname);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getTrpl_name() {
		return ((String) getAttrVal("Trpl_name"));
	}	
	/**
	 * 名称
	 * @param Trpl_name
	 */
	public void setTrpl_name(String Trpl_name) {
		setAttrVal("Trpl_name", Trpl_name);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getEmpst_name() {
		return ((String) getAttrVal("Empst_name"));
	}	
	/**
	 * 姓名
	 * @param Empst_name
	 */
	public void setEmpst_name(String Empst_name) {
		setAttrVal("Empst_name", Empst_name);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getEmpconf_name() {
		return ((String) getAttrVal("Empconf_name"));
	}	
	/**
	 * 姓名
	 * @param Empconf_name
	 */
	public void setEmpconf_name(String Empconf_name) {
		setAttrVal("Empconf_name", Empconf_name);
	}
	/**
	 * 供应商与厂商名称
	 * @return String
	 */
	public String getFactory_name() {
		return ((String) getAttrVal("Factory_name"));
	}	
	/**
	 * 供应商与厂商名称
	 * @param Factory_name
	 */
	public void setFactory_name(String Factory_name) {
		setAttrVal("Factory_name", Factory_name);
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
		return "Id_tritm";
	}
	
	@Override
	public String getTableName() {	  
		return "V_MM_TRAPIMPL_QUERY";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(TrapImplViewDesc.class);
	}
	
}