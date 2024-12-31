package iih.mm.qy.stockcheckinfo.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.qy.stockcheckinfo.d.desc.StockChkQueryViewDesc;
import java.math.BigDecimal;

/**
 * 盘点单查询 DO数据 
 * 
 */
public class StockChkQueryView extends BaseDO {
	private static final long serialVersionUID = 1L;

	//库存盘点主键
	public static final String ID_STTK= "Id_sttk";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//盘点单号
	public static final String STTK_CODE= "Sttk_code";
	//盘点类型
	public static final String ID_STTKTP= "Id_sttktp";
	//盘点仓库
	public static final String ID_WH= "Id_wh";
	//物品
	public static final String ID_MM= "Id_mm";
	//批次
	public static final String BATCH= "Batch";
	//有效期
	public static final String DATE_EXPI= "Date_expi";
	//包装单位
	public static final String ID_MMPKGU_ACTUAL= "Id_mmpkgu_actual";
	//售价
	public static final String PRI_SA= "Pri_sa";
	//进价
	public static final String PRI_ACT= "Pri_act";
	//账面数量
	public static final String QUAN_BK_ACTUAL= "Quan_bk_actual";
	//实盘数量
	public static final String QUAN_ACTUAL= "Quan_actual";
	//盈亏数量
	public static final String DIFF_ACTUAL= "Diff_actual";
	//盈亏金额
	public static final String AMT= "Amt";
	//差异说明
	public static final String DIFF_REASON= "Diff_reason";
	//是否盈亏
	public static final String FG_DIFF= "Fg_diff";
	//盘点时间
	public static final String DT_TK= "Dt_tk";
	//盘点日期
	public static final String DT_TK_SHORT= "Dt_tk_short";
	//盘点人员
	public static final String ID_EMP_STTK= "Id_emp_sttk";
	//单据状态
	public static final String ID_SU_STTK= "Id_su_sttk";
	//盘点描述
	public static final String DES= "Des";
	//盘点类型
	public static final String STTKTP_NAME= "Sttktp_name";
	//盘点仓库
	public static final String WH_NAME= "Wh_name";
	//物品名称
	public static final String MM_NAME= "Mm_name";
	//物品规格
	public static final String MM_SPEC= "Mm_spec";
	//物品编码
	public static final String MM_CODE= "Mm_code";
	//包装单位名称
	public static final String MMPKGUNAME= "Mmpkguname";
	//盘点人员
	public static final String EMPSTTK_NAME= "Empsttk_name";
	//盘点单状态
	public static final String STTK_NAME= "Sttk_name";
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
	 * 盘点单号
	 * @return String
	 */
	public String getSttk_code() {
		return ((String) getAttrVal("Sttk_code"));
	}	
	/**
	 * 盘点单号
	 * @param Sttk_code
	 */
	public void setSttk_code(String Sttk_code) {
		setAttrVal("Sttk_code", Sttk_code);
	}
	/**
	 * 盘点类型
	 * @return String
	 */
	public String getId_sttktp() {
		return ((String) getAttrVal("Id_sttktp"));
	}	
	/**
	 * 盘点类型
	 * @param Id_sttktp
	 */
	public void setId_sttktp(String Id_sttktp) {
		setAttrVal("Id_sttktp", Id_sttktp);
	}
	/**
	 * 盘点仓库
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	/**
	 * 盘点仓库
	 * @param Id_wh
	 */
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
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
	 * 售价
	 * @return FDouble
	 */
	public FDouble getPri_sa() {
		return ((FDouble) getAttrVal("Pri_sa"));
	}	
	/**
	 * 售价
	 * @param Pri_sa
	 */
	public void setPri_sa(FDouble Pri_sa) {
		setAttrVal("Pri_sa", Pri_sa);
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
	 * 账面数量
	 * @return FDouble
	 */
	public FDouble getQuan_bk_actual() {
		return ((FDouble) getAttrVal("Quan_bk_actual"));
	}	
	/**
	 * 账面数量
	 * @param Quan_bk_actual
	 */
	public void setQuan_bk_actual(FDouble Quan_bk_actual) {
		setAttrVal("Quan_bk_actual", Quan_bk_actual);
	}
	/**
	 * 实盘数量
	 * @return FDouble
	 */
	public FDouble getQuan_actual() {
		return ((FDouble) getAttrVal("Quan_actual"));
	}	
	/**
	 * 实盘数量
	 * @param Quan_actual
	 */
	public void setQuan_actual(FDouble Quan_actual) {
		setAttrVal("Quan_actual", Quan_actual);
	}
	/**
	 * 盈亏数量
	 * @return FDouble
	 */
	public FDouble getDiff_actual() {
		return ((FDouble) getAttrVal("Diff_actual"));
	}	
	/**
	 * 盈亏数量
	 * @param Diff_actual
	 */
	public void setDiff_actual(FDouble Diff_actual) {
		setAttrVal("Diff_actual", Diff_actual);
	}
	/**
	 * 盈亏金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	/**
	 * 盈亏金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 差异说明
	 * @return String
	 */
	public String getDiff_reason() {
		return ((String) getAttrVal("Diff_reason"));
	}	
	/**
	 * 差异说明
	 * @param Diff_reason
	 */
	public void setDiff_reason(String Diff_reason) {
		setAttrVal("Diff_reason", Diff_reason);
	}
	/**
	 * 是否盈亏
	 * @return FBoolean
	 */
	public FBoolean getFg_diff() {
		return ((FBoolean) getAttrVal("Fg_diff"));
	}	
	/**
	 * 是否盈亏
	 * @param Fg_diff
	 */
	public void setFg_diff(FBoolean Fg_diff) {
		setAttrVal("Fg_diff", Fg_diff);
	}
	/**
	 * 盘点时间
	 * @return FDateTime
	 */
	public FDateTime getDt_tk() {
		return ((FDateTime) getAttrVal("Dt_tk"));
	}	
	/**
	 * 盘点时间
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
	 * 单据状态
	 * @return String
	 */
	public String getId_su_sttk() {
		return ((String) getAttrVal("Id_su_sttk"));
	}	
	/**
	 * 单据状态
	 * @param Id_su_sttk
	 */
	public void setId_su_sttk(String Id_su_sttk) {
		setAttrVal("Id_su_sttk", Id_su_sttk);
	}
	/**
	 * 盘点描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 盘点描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 盘点类型
	 * @return String
	 */
	public String getSttktp_name() {
		return ((String) getAttrVal("Sttktp_name"));
	}	
	/**
	 * 盘点类型
	 * @param Sttktp_name
	 */
	public void setSttktp_name(String Sttktp_name) {
		setAttrVal("Sttktp_name", Sttktp_name);
	}
	/**
	 * 盘点仓库
	 * @return String
	 */
	public String getWh_name() {
		return ((String) getAttrVal("Wh_name"));
	}	
	/**
	 * 盘点仓库
	 * @param Wh_name
	 */
	public void setWh_name(String Wh_name) {
		setAttrVal("Wh_name", Wh_name);
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
	 * 盘点人员
	 * @return String
	 */
	public String getEmpsttk_name() {
		return ((String) getAttrVal("Empsttk_name"));
	}	
	/**
	 * 盘点人员
	 * @param Empsttk_name
	 */
	public void setEmpsttk_name(String Empsttk_name) {
		setAttrVal("Empsttk_name", Empsttk_name);
	}
	/**
	 * 盘点单状态
	 * @return String
	 */
	public String getSttk_name() {
		return ((String) getAttrVal("Sttk_name"));
	}	
	/**
	 * 盘点单状态
	 * @param Sttk_name
	 */
	public void setSttk_name(String Sttk_name) {
		setAttrVal("Sttk_name", Sttk_name);
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
		return "V_MM_STTK_QUERY";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(StockChkQueryViewDesc.class);
	}
	
}