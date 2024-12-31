package iih.mc.st.stockcheck.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mc.st.stockcheck.d.desc.McStockCaspItemDODesc;
import java.math.BigDecimal;

/**
 * 库存盘点货位明细 DO数据 
 * 
 */
public class McStockCaspItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//库存盘点明细主键
	public static final String ID_STTKITM= "Id_sttkitm";
	//库存盘点主键
	public static final String ID_STTK= "Id_sttk";
	//组别
	public static final String GRPNUM= "Grpnum";
	//组别码
	public static final String GRPIDENTIFY= "Grpidentify";
	//货位
	public static final String ID_LOC= "Id_loc";
	//结存主键
	public static final String ID_BL= "Id_bl";
	//物品
	public static final String ID_MM= "Id_mm";
	//唯一码
	public static final String ONLYCODE= "Onlycode";
	//批次
	public static final String BATCH= "Batch";
	//有效期
	public static final String DATE_EXPI= "Date_expi";
	//进价
	public static final String PRI_ACT= "Pri_act";
	//售价
	public static final String PRI_SA= "Pri_sa";
	//包装单位
	public static final String ID_MMPKGU_ACTUAL= "Id_mmpkgu_actual";
	//账面数量
	public static final String QUAN_BK_ACTUAL= "Quan_bk_actual";
	//实盘数量
	public static final String QUAN_ACTUAL= "Quan_actual";
	//盈亏数量
	public static final String DIFF_ACTUAL= "Diff_actual";
	//盈亏金额
	public static final String AMT= "Amt";
	//清点人员
	public static final String ID_EMP_STTK= "Id_emp_sttk";
	//差异原因
	public static final String DIFF_REASON= "Diff_reason";
	//耗材分类
	public static final String EU_MMCA= "Eu_mmca";
	//货位编码
	public static final String LOC_CODE= "Loc_code";
	//物品编码
	public static final String MM_CODE= "Mm_code";
	//物品名称
	public static final String MM_NAME= "Mm_name";
	//物品规格
	public static final String MM_SPEC= "Mm_spec";
	//生产厂家名称
	public static final String FACTORY_NAME= "Factory_name";
	//包装单位名称
	public static final String MMPKGUNAME= "Mmpkguname";
	//清点人员姓名
	public static final String EMPSTTK_NAME= "Empsttk_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 库存盘点明细主键
	 * @return String
	 */
	public String getId_sttkitm() {
		return ((String) getAttrVal("Id_sttkitm"));
	}	
	/**
	 * 库存盘点明细主键
	 * @param Id_sttkitm
	 */
	public void setId_sttkitm(String Id_sttkitm) {
		setAttrVal("Id_sttkitm", Id_sttkitm);
	}
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
	 * 组别
	 * @return Integer
	 */
	public Integer getGrpnum() {
		return ((Integer) getAttrVal("Grpnum"));
	}	
	/**
	 * 组别
	 * @param Grpnum
	 */
	public void setGrpnum(Integer Grpnum) {
		setAttrVal("Grpnum", Grpnum);
	}
	/**
	 * 组别码
	 * @return String
	 */
	public String getGrpidentify() {
		return ((String) getAttrVal("Grpidentify"));
	}	
	/**
	 * 组别码
	 * @param Grpidentify
	 */
	public void setGrpidentify(String Grpidentify) {
		setAttrVal("Grpidentify", Grpidentify);
	}
	/**
	 * 货位
	 * @return String
	 */
	public String getId_loc() {
		return ((String) getAttrVal("Id_loc"));
	}	
	/**
	 * 货位
	 * @param Id_loc
	 */
	public void setId_loc(String Id_loc) {
		setAttrVal("Id_loc", Id_loc);
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
	 * 清点人员
	 * @return String
	 */
	public String getId_emp_sttk() {
		return ((String) getAttrVal("Id_emp_sttk"));
	}	
	/**
	 * 清点人员
	 * @param Id_emp_sttk
	 */
	public void setId_emp_sttk(String Id_emp_sttk) {
		setAttrVal("Id_emp_sttk", Id_emp_sttk);
	}
	/**
	 * 差异原因
	 * @return String
	 */
	public String getDiff_reason() {
		return ((String) getAttrVal("Diff_reason"));
	}	
	/**
	 * 差异原因
	 * @param Diff_reason
	 */
	public void setDiff_reason(String Diff_reason) {
		setAttrVal("Diff_reason", Diff_reason);
	}
	/**
	 * 耗材分类
	 * @return Integer
	 */
	public Integer getEu_mmca() {
		return ((Integer) getAttrVal("Eu_mmca"));
	}	
	/**
	 * 耗材分类
	 * @param Eu_mmca
	 */
	public void setEu_mmca(Integer Eu_mmca) {
		setAttrVal("Eu_mmca", Eu_mmca);
	}
	/**
	 * 货位编码
	 * @return String
	 */
	public String getLoc_code() {
		return ((String) getAttrVal("Loc_code"));
	}	
	/**
	 * 货位编码
	 * @param Loc_code
	 */
	public void setLoc_code(String Loc_code) {
		setAttrVal("Loc_code", Loc_code);
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
	 * 生产厂家名称
	 * @return String
	 */
	public String getFactory_name() {
		return ((String) getAttrVal("Factory_name"));
	}	
	/**
	 * 生产厂家名称
	 * @param Factory_name
	 */
	public void setFactory_name(String Factory_name) {
		setAttrVal("Factory_name", Factory_name);
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
	 * 清点人员姓名
	 * @return String
	 */
	public String getEmpsttk_name() {
		return ((String) getAttrVal("Empsttk_name"));
	}	
	/**
	 * 清点人员姓名
	 * @param Empsttk_name
	 */
	public void setEmpsttk_name(String Empsttk_name) {
		setAttrVal("Empsttk_name", Empsttk_name);
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
		return "Id_sttkitm";
	}
	
	@Override
	public String getTableName() {	  
		return "MC_ST_TK_LOC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(McStockCaspItemDODesc.class);
	}
	
}