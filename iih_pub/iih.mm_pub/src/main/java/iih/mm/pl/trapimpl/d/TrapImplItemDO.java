package iih.mm.pl.trapimpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.pl.trapimpl.d.desc.TrapImplItemDODesc;
import java.math.BigDecimal;

/**
 * 调拨明细 DO数据 
 * 
 */
public class TrapImplItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//调拨明细主键
	public static final String ID_PLITM= "Id_plitm";
	//调拨单主键
	public static final String ID_TR= "Id_tr";
	//序号
	public static final String SORTNO= "Sortno";
	//结存主键
	public static final String ID_BL= "Id_bl";
	//物品
	public static final String ID_MM= "Id_mm";
	//转出仓库货位号
	public static final String ID_LOC= "Id_loc";
	//转入仓库货位号
	public static final String ID_LOC_AP= "Id_loc_ap";
	//基本包装单位
	public static final String ID_MMPKGU_BASE= "Id_mmpkgu_base";
	//实际包装单位
	public static final String ID_MMPKGU_ACTUAL= "Id_mmpkgu_actual";
	//零售包装单位
	public static final String ID_MMPKGU_SP= "Id_mmpkgu_sp";
	//生产厂家
	public static final String ID_SUP= "Id_sup";
	//批次
	public static final String BATCH= "Batch";
	//有效期
	public static final String DATE_EXPI= "Date_expi";
	//唯一码（高值耗材）
	public static final String ONLYCODE= "Onlycode";
	//进价_实际单位
	public static final String PRI_ACT= "Pri_act";
	//售价_实际包装
	public static final String PRI_SA= "Pri_sa";
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
	//现存量(转出仓库)
	public static final String QUAN_ST= "Quan_st";
	//实时现存量（转出仓库）
	public static final String QUAN_ST_NOW= "Quan_st_now";
	//描述
	public static final String DES= "Des";
	//物品特性
	public static final String CHARACTER= "Character";
	//售价_零售单位
	public static final String PRI_SALE= "Pri_sale";
	//现存量(转入仓库)
	public static final String QUAN_ST_AP= "Quan_st_ap";
	//医疗服务名称
	public static final String SRV_NAME= "Srv_name";
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
	//转出仓库货位编码
	public static final String LOC_CODE= "Loc_code";
	//转出仓库货位名称
	public static final String LOC_NAME= "Loc_name";
	//转出仓库货位拼音码
	public static final String LOC_PYCODE= "Loc_pycode";
	//转入仓库货位编码
	public static final String LOC_CODE_AP= "Loc_code_ap";
	//转入仓库货位名称
	public static final String LOC_NAME_AP= "Loc_name_ap";
	//转入仓库货位拼音码
	public static final String PYCODE= "Pycode";
	//包装单位名称
	public static final String MMPKGUNAME= "Mmpkguname";
	//包装单位名称
	public static final String POPKGUNAME= "Popkguname";
	//供应商与厂商名称
	public static final String SUP_NAME= "Sup_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 调拨明细主键
	 * @return String
	 */
	public String getId_plitm() {
		return ((String) getAttrVal("Id_plitm"));
	}	
	/**
	 * 调拨明细主键
	 * @param Id_plitm
	 */
	public void setId_plitm(String Id_plitm) {
		setAttrVal("Id_plitm", Id_plitm);
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
	 * 结存主键
	 * @return String
	 */
	public String getId_bl() {
		return ((String) getAttrVal("Id_bl"));
	}	
	/**
	 * 结存主键
	 * @param Id_bl
	 */
	public void setId_bl(String Id_bl) {
		setAttrVal("Id_bl", Id_bl);
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
	 * 转出仓库货位号
	 * @return String
	 */
	public String getId_loc() {
		return ((String) getAttrVal("Id_loc"));
	}	
	/**
	 * 转出仓库货位号
	 * @param Id_loc
	 */
	public void setId_loc(String Id_loc) {
		setAttrVal("Id_loc", Id_loc);
	}
	/**
	 * 转入仓库货位号
	 * @return String
	 */
	public String getId_loc_ap() {
		return ((String) getAttrVal("Id_loc_ap"));
	}	
	/**
	 * 转入仓库货位号
	 * @param Id_loc_ap
	 */
	public void setId_loc_ap(String Id_loc_ap) {
		setAttrVal("Id_loc_ap", Id_loc_ap);
	}
	/**
	 * 基本包装单位
	 * @return String
	 */
	public String getId_mmpkgu_base() {
		return ((String) getAttrVal("Id_mmpkgu_base"));
	}	
	/**
	 * 基本包装单位
	 * @param Id_mmpkgu_base
	 */
	public void setId_mmpkgu_base(String Id_mmpkgu_base) {
		setAttrVal("Id_mmpkgu_base", Id_mmpkgu_base);
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
	 * 零售包装单位
	 * @return String
	 */
	public String getId_mmpkgu_sp() {
		return ((String) getAttrVal("Id_mmpkgu_sp"));
	}	
	/**
	 * 零售包装单位
	 * @param Id_mmpkgu_sp
	 */
	public void setId_mmpkgu_sp(String Id_mmpkgu_sp) {
		setAttrVal("Id_mmpkgu_sp", Id_mmpkgu_sp);
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
	 * 唯一码（高值耗材）
	 * @return String
	 */
	public String getOnlycode() {
		return ((String) getAttrVal("Onlycode"));
	}	
	/**
	 * 唯一码（高值耗材）
	 * @param Onlycode
	 */
	public void setOnlycode(String Onlycode) {
		setAttrVal("Onlycode", Onlycode);
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
	 * 售价_实际包装
	 * @return FDouble
	 */
	public FDouble getPri_sa() {
		return ((FDouble) getAttrVal("Pri_sa"));
	}	
	/**
	 * 售价_实际包装
	 * @param Pri_sa
	 */
	public void setPri_sa(FDouble Pri_sa) {
		setAttrVal("Pri_sa", Pri_sa);
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
	 * 实时现存量（转出仓库）
	 * @return FDouble
	 */
	public FDouble getQuan_st_now() {
		return ((FDouble) getAttrVal("Quan_st_now"));
	}	
	/**
	 * 实时现存量（转出仓库）
	 * @param Quan_st_now
	 */
	public void setQuan_st_now(FDouble Quan_st_now) {
		setAttrVal("Quan_st_now", Quan_st_now);
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
	 * 售价_零售单位
	 * @return FDouble
	 */
	public FDouble getPri_sale() {
		return ((FDouble) getAttrVal("Pri_sale"));
	}	
	/**
	 * 售价_零售单位
	 * @param Pri_sale
	 */
	public void setPri_sale(FDouble Pri_sale) {
		setAttrVal("Pri_sale", Pri_sale);
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
	 * 医疗服务名称
	 * @return String
	 */
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	/**
	 * 医疗服务名称
	 * @param Srv_name
	 */
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
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
	 * 转出仓库货位编码
	 * @return String
	 */
	public String getLoc_code() {
		return ((String) getAttrVal("Loc_code"));
	}	
	/**
	 * 转出仓库货位编码
	 * @param Loc_code
	 */
	public void setLoc_code(String Loc_code) {
		setAttrVal("Loc_code", Loc_code);
	}
	/**
	 * 转出仓库货位名称
	 * @return String
	 */
	public String getLoc_name() {
		return ((String) getAttrVal("Loc_name"));
	}	
	/**
	 * 转出仓库货位名称
	 * @param Loc_name
	 */
	public void setLoc_name(String Loc_name) {
		setAttrVal("Loc_name", Loc_name);
	}
	/**
	 * 转出仓库货位拼音码
	 * @return String
	 */
	public String getLoc_pycode() {
		return ((String) getAttrVal("Loc_pycode"));
	}	
	/**
	 * 转出仓库货位拼音码
	 * @param Loc_pycode
	 */
	public void setLoc_pycode(String Loc_pycode) {
		setAttrVal("Loc_pycode", Loc_pycode);
	}
	/**
	 * 转入仓库货位编码
	 * @return String
	 */
	public String getLoc_code_ap() {
		return ((String) getAttrVal("Loc_code_ap"));
	}	
	/**
	 * 转入仓库货位编码
	 * @param Loc_code_ap
	 */
	public void setLoc_code_ap(String Loc_code_ap) {
		setAttrVal("Loc_code_ap", Loc_code_ap);
	}
	/**
	 * 转入仓库货位名称
	 * @return String
	 */
	public String getLoc_name_ap() {
		return ((String) getAttrVal("Loc_name_ap"));
	}	
	/**
	 * 转入仓库货位名称
	 * @param Loc_name_ap
	 */
	public void setLoc_name_ap(String Loc_name_ap) {
		setAttrVal("Loc_name_ap", Loc_name_ap);
	}
	/**
	 * 转入仓库货位拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 转入仓库货位拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
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
	 * 包装单位名称
	 * @return String
	 */
	public String getPopkguname() {
		return ((String) getAttrVal("Popkguname"));
	}	
	/**
	 * 包装单位名称
	 * @param Popkguname
	 */
	public void setPopkguname(String Popkguname) {
		setAttrVal("Popkguname", Popkguname);
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
		return "Id_plitm";
	}
	
	@Override
	public String getTableName() {	  
		return "MM_TR_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(TrapImplItemDODesc.class);
	}
	
}