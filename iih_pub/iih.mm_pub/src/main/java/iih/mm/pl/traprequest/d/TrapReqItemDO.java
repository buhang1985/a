package iih.mm.pl.traprequest.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.pl.traprequest.d.desc.TrapReqItemDODesc;
import java.math.BigDecimal;

/**
 * 调拨申请明细 DO数据 
 * 
 */
public class TrapReqItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//调拨明细主键
	public static final String ID_TRAPITM= "Id_trapitm";
	//调拨申请单
	public static final String ID_TRAP= "Id_trap";
	//序号
	public static final String SORTNO= "Sortno";
	//物品
	public static final String ID_MM= "Id_mm";
	//实际包装单位
	public static final String ID_MMPKGU_ACTUAL= "Id_mmpkgu_actual";
	//生产厂家
	public static final String ID_SUP= "Id_sup";
	//进价_实际单位
	public static final String PRI_ACT= "Pri_act";
	//售价_实际单位
	public static final String PRI_SA= "Pri_sa";
	//现存量(转出仓库)
	public static final String QUAN_ST= "Quan_st";
	//现存量(转入仓库)
	public static final String QUAN_ST_AP= "Quan_st_ap";
	//原包装单位
	public static final String ID_PKGU_ORI= "Id_pkgu_ori";
	//申请数量_实际单位
	public static final String QUAN_DA_ACT= "Quan_da_act";
	//金额_申请
	public static final String AMT_DA= "Amt_da";
	//实发数量
	public static final String QUAN= "Quan";
	//金额_实发
	public static final String AMT= "Amt";
	//描述
	public static final String DES= "Des";
	//物品特性
	public static final String CHARACTER= "Character";
	//前1日用量
	public static final String DOSAGE_ONEDAY= "Dosage_oneday";
	//前3日用量
	public static final String DOSAGE_THREEDAY= "Dosage_threeday";
	//前10日用量
	public static final String DOSAGE_TENDAY= "Dosage_tenday";
	//1周用量
	public static final String DOSAGE_WEEK= "Dosage_week";
	//1月用量
	public static final String DOSAGE_MONTH= "Dosage_month";
	//上一次请领日期
	public static final String REQUESTDAY_ONE= "Requestday_one";
	//上一次请领数量
	public static final String REQUESTNUM_ONE= "Requestnum_one";
	//上二次请领日期
	public static final String REQUESTDAY_TWO= "Requestday_two";
	//上二次请领数量
	public static final String REQUESTNUM_TWO= "Requestnum_two";
	//上三次请领日期
	public static final String REQUESTDAY_THREE= "Requestday_three";
	//上三次请领数量
	public static final String REQUESTNUM_THREE= "Requestnum_three";
	//医疗服务
	public static final String SRV_NAME= "Srv_name";
	//采购单位
	public static final String PKGU_PO_NAME= "Pkgu_po_name";
	//采购单位系数
	public static final String PO_FACTOR= "Po_factor";
	//转入仓库货位编码
	public static final String INLOC_CODE= "Inloc_code";
	//转入仓库货位名称
	public static final String INLOC_NAME= "Inloc_name";
	//警告标识
	public static final String SD_WARN= "Sd_warn";
	//物品名称
	public static final String MM_NAME= "Mm_name";
	//物品规格
	public static final String MM_SPEC= "Mm_spec";
	//拼音
	public static final String MM_PYCODE= "Mm_pycode";
	//服务项目外键
	public static final String ID_SRV= "Id_srv";
	//物品编码
	public static final String MM_CODE= "Mm_code";
	//包装单位名称
	public static final String MMPKGUNAME= "Mmpkguname";
	//供应商与厂商名称
	public static final String SUP_NAME= "Sup_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 调拨明细主键
	 * @return String
	 */
	public String getId_trapitm() {
		return ((String) getAttrVal("Id_trapitm"));
	}	
	/**
	 * 调拨明细主键
	 * @param Id_trapitm
	 */
	public void setId_trapitm(String Id_trapitm) {
		setAttrVal("Id_trapitm", Id_trapitm);
	}
	/**
	 * 调拨申请单
	 * @return String
	 */
	public String getId_trap() {
		return ((String) getAttrVal("Id_trap"));
	}	
	/**
	 * 调拨申请单
	 * @param Id_trap
	 */
	public void setId_trap(String Id_trap) {
		setAttrVal("Id_trap", Id_trap);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
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
	 * 生产厂家
	 * @return String
	 */
	public String getId_sup() {
		return ((String) getAttrVal("Id_sup"));
	}	
	/**
	 * 生产厂家
	 * @param Id_sup
	 */
	public void setId_sup(String Id_sup) {
		setAttrVal("Id_sup", Id_sup);
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
	 * 现存量(转出仓库)
	 * @return FDouble
	 */
	public FDouble getQuan_st() {
		return ((FDouble) getAttrVal("Quan_st"));
	}	
	/**
	 * 现存量(转出仓库)
	 * @param Quan_st
	 */
	public void setQuan_st(FDouble Quan_st) {
		setAttrVal("Quan_st", Quan_st);
	}
	/**
	 * 现存量(转入仓库)
	 * @return FDouble
	 */
	public FDouble getQuan_st_ap() {
		return ((FDouble) getAttrVal("Quan_st_ap"));
	}	
	/**
	 * 现存量(转入仓库)
	 * @param Quan_st_ap
	 */
	public void setQuan_st_ap(FDouble Quan_st_ap) {
		setAttrVal("Quan_st_ap", Quan_st_ap);
	}
	/**
	 * 原包装单位
	 * @return String
	 */
	public String getId_pkgu_ori() {
		return ((String) getAttrVal("Id_pkgu_ori"));
	}	
	/**
	 * 原包装单位
	 * @param Id_pkgu_ori
	 */
	public void setId_pkgu_ori(String Id_pkgu_ori) {
		setAttrVal("Id_pkgu_ori", Id_pkgu_ori);
	}
	/**
	 * 申请数量_实际单位
	 * @return FDouble
	 */
	public FDouble getQuan_da_act() {
		return ((FDouble) getAttrVal("Quan_da_act"));
	}	
	/**
	 * 申请数量_实际单位
	 * @param Quan_da_act
	 */
	public void setQuan_da_act(FDouble Quan_da_act) {
		setAttrVal("Quan_da_act", Quan_da_act);
	}
	/**
	 * 金额_申请
	 * @return FDouble
	 */
	public FDouble getAmt_da() {
		return ((FDouble) getAttrVal("Amt_da"));
	}	
	/**
	 * 金额_申请
	 * @param Amt_da
	 */
	public void setAmt_da(FDouble Amt_da) {
		setAttrVal("Amt_da", Amt_da);
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
	 * 前1日用量
	 * @return FDouble
	 */
	public FDouble getDosage_oneday() {
		return ((FDouble) getAttrVal("Dosage_oneday"));
	}	
	/**
	 * 前1日用量
	 * @param Dosage_oneday
	 */
	public void setDosage_oneday(FDouble Dosage_oneday) {
		setAttrVal("Dosage_oneday", Dosage_oneday);
	}
	/**
	 * 前3日用量
	 * @return FDouble
	 */
	public FDouble getDosage_threeday() {
		return ((FDouble) getAttrVal("Dosage_threeday"));
	}	
	/**
	 * 前3日用量
	 * @param Dosage_threeday
	 */
	public void setDosage_threeday(FDouble Dosage_threeday) {
		setAttrVal("Dosage_threeday", Dosage_threeday);
	}
	/**
	 * 前10日用量
	 * @return FDouble
	 */
	public FDouble getDosage_tenday() {
		return ((FDouble) getAttrVal("Dosage_tenday"));
	}	
	/**
	 * 前10日用量
	 * @param Dosage_tenday
	 */
	public void setDosage_tenday(FDouble Dosage_tenday) {
		setAttrVal("Dosage_tenday", Dosage_tenday);
	}
	/**
	 * 1周用量
	 * @return FDouble
	 */
	public FDouble getDosage_week() {
		return ((FDouble) getAttrVal("Dosage_week"));
	}	
	/**
	 * 1周用量
	 * @param Dosage_week
	 */
	public void setDosage_week(FDouble Dosage_week) {
		setAttrVal("Dosage_week", Dosage_week);
	}
	/**
	 * 1月用量
	 * @return FDouble
	 */
	public FDouble getDosage_month() {
		return ((FDouble) getAttrVal("Dosage_month"));
	}	
	/**
	 * 1月用量
	 * @param Dosage_month
	 */
	public void setDosage_month(FDouble Dosage_month) {
		setAttrVal("Dosage_month", Dosage_month);
	}
	/**
	 * 上一次请领日期
	 * @return FDateTime
	 */
	public FDateTime getRequestday_one() {
		return ((FDateTime) getAttrVal("Requestday_one"));
	}	
	/**
	 * 上一次请领日期
	 * @param Requestday_one
	 */
	public void setRequestday_one(FDateTime Requestday_one) {
		setAttrVal("Requestday_one", Requestday_one);
	}
	/**
	 * 上一次请领数量
	 * @return FDouble
	 */
	public FDouble getRequestnum_one() {
		return ((FDouble) getAttrVal("Requestnum_one"));
	}	
	/**
	 * 上一次请领数量
	 * @param Requestnum_one
	 */
	public void setRequestnum_one(FDouble Requestnum_one) {
		setAttrVal("Requestnum_one", Requestnum_one);
	}
	/**
	 * 上二次请领日期
	 * @return FDateTime
	 */
	public FDateTime getRequestday_two() {
		return ((FDateTime) getAttrVal("Requestday_two"));
	}	
	/**
	 * 上二次请领日期
	 * @param Requestday_two
	 */
	public void setRequestday_two(FDateTime Requestday_two) {
		setAttrVal("Requestday_two", Requestday_two);
	}
	/**
	 * 上二次请领数量
	 * @return FDouble
	 */
	public FDouble getRequestnum_two() {
		return ((FDouble) getAttrVal("Requestnum_two"));
	}	
	/**
	 * 上二次请领数量
	 * @param Requestnum_two
	 */
	public void setRequestnum_two(FDouble Requestnum_two) {
		setAttrVal("Requestnum_two", Requestnum_two);
	}
	/**
	 * 上三次请领日期
	 * @return FDateTime
	 */
	public FDateTime getRequestday_three() {
		return ((FDateTime) getAttrVal("Requestday_three"));
	}	
	/**
	 * 上三次请领日期
	 * @param Requestday_three
	 */
	public void setRequestday_three(FDateTime Requestday_three) {
		setAttrVal("Requestday_three", Requestday_three);
	}
	/**
	 * 上三次请领数量
	 * @return FDouble
	 */
	public FDouble getRequestnum_three() {
		return ((FDouble) getAttrVal("Requestnum_three"));
	}	
	/**
	 * 上三次请领数量
	 * @param Requestnum_three
	 */
	public void setRequestnum_three(FDouble Requestnum_three) {
		setAttrVal("Requestnum_three", Requestnum_three);
	}
	/**
	 * 医疗服务
	 * @return String
	 */
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	/**
	 * 医疗服务
	 * @param Srv_name
	 */
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	/**
	 * 采购单位
	 * @return String
	 */
	public String getPkgu_po_name() {
		return ((String) getAttrVal("Pkgu_po_name"));
	}	
	/**
	 * 采购单位
	 * @param Pkgu_po_name
	 */
	public void setPkgu_po_name(String Pkgu_po_name) {
		setAttrVal("Pkgu_po_name", Pkgu_po_name);
	}
	/**
	 * 采购单位系数
	 * @return FDouble
	 */
	public FDouble getPo_factor() {
		return ((FDouble) getAttrVal("Po_factor"));
	}	
	/**
	 * 采购单位系数
	 * @param Po_factor
	 */
	public void setPo_factor(FDouble Po_factor) {
		setAttrVal("Po_factor", Po_factor);
	}
	/**
	 * 转入仓库货位编码
	 * @return String
	 */
	public String getInloc_code() {
		return ((String) getAttrVal("Inloc_code"));
	}	
	/**
	 * 转入仓库货位编码
	 * @param Inloc_code
	 */
	public void setInloc_code(String Inloc_code) {
		setAttrVal("Inloc_code", Inloc_code);
	}
	/**
	 * 转入仓库货位名称
	 * @return String
	 */
	public String getInloc_name() {
		return ((String) getAttrVal("Inloc_name"));
	}	
	/**
	 * 转入仓库货位名称
	 * @param Inloc_name
	 */
	public void setInloc_name(String Inloc_name) {
		setAttrVal("Inloc_name", Inloc_name);
	}
	/**
	 * 警告标识
	 * @return String
	 */
	public String getSd_warn() {
		return ((String) getAttrVal("Sd_warn"));
	}	
	/**
	 * 警告标识
	 * @param Sd_warn
	 */
	public void setSd_warn(String Sd_warn) {
		setAttrVal("Sd_warn", Sd_warn);
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
	 * 拼音
	 * @return String
	 */
	public String getMm_pycode() {
		return ((String) getAttrVal("Mm_pycode"));
	}	
	/**
	 * 拼音
	 * @param Mm_pycode
	 */
	public void setMm_pycode(String Mm_pycode) {
		setAttrVal("Mm_pycode", Mm_pycode);
	}
	/**
	 * 服务项目外键
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 服务项目外键
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
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
	 * 供应商与厂商名称
	 * @return String
	 */
	public String getSup_name() {
		return ((String) getAttrVal("Sup_name"));
	}	
	/**
	 * 供应商与厂商名称
	 * @param Sup_name
	 */
	public void setSup_name(String Sup_name) {
		setAttrVal("Sup_name", Sup_name);
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
		return "Id_trapitm";
	}
	
	@Override
	public String getTableName() {	  
		return "MM_TRAP_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(TrapReqItemDODesc.class);
	}
	
}