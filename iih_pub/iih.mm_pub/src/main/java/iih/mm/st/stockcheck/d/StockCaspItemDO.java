package iih.mm.st.stockcheck.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.st.stockcheck.d.desc.StockCaspItemDODesc;
import java.math.BigDecimal;

/**
 * 货位盘点明细 DO数据 
 * 
 */
public class StockCaspItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//库存盘点明细主键
	public static final String ID_STTKITM= "Id_sttkitm";
	//库存盘点
	public static final String ID_STTK= "Id_sttk";
	//序号
	public static final String SORTNO= "Sortno";
	//结存主键
	public static final String ID_BL= "Id_bl";
	//物品
	public static final String ID_MM= "Id_mm";
	//货位号
	public static final String ID_LOC= "Id_loc";
	//基本包装单位
	public static final String ID_MMPKGU_BASE= "Id_mmpkgu_base";
	//实际包装单位
	public static final String ID_MMPKGU_ACTUAL= "Id_mmpkgu_actual";
	//批次
	public static final String BATCH= "Batch";
	//失效期
	public static final String DATE_EXPI= "Date_expi";
	//唯一码
	public static final String ONLYCODE= "Onlycode";
	//换算系数
	public static final String FACTOR= "Factor";
	//进价_基本单位
	public static final String PRI_BASE= "Pri_base";
	//进价_实际单位
	public static final String PRI_ACT= "Pri_act";
	//售价_基本单位
	public static final String PRI_SA_BASE= "Pri_sa_base";
	//售价_实际单位
	public static final String PRI_SA= "Pri_sa";
	//账面数量_实际包装
	public static final String QUAN_BK_ACTUAL= "Quan_bk_actual";
	//大包装单位
	public static final String ID_MMPKGU_BIG= "Id_mmpkgu_big";
	//实物数量_大包装单位
	public static final String QUAN_ACTUAL_BIG= "Quan_actual_big";
	//小包装单位
	public static final String ID_MMPKGU_SMALL= "Id_mmpkgu_small";
	//实物数量_小包装单位
	public static final String QUAN_ACTUAL_SMALL= "Quan_actual_small";
	//实物数量_实际包装
	public static final String QUAN_ACTUAL= "Quan_actual";
	//预留数量_实际包装
	public static final String QUAN_RESERVE= "Quan_reserve";
	//盈亏数量_ 实际包装
	public static final String DIFF_ACTUAL= "Diff_actual";
	//账面数量_基本单位
	public static final String QUAN_BASE= "Quan_base";
	//盈亏金额
	public static final String AMT= "Amt";
	//清点人员
	public static final String ID_EMP_STTK= "Id_emp_sttk";
	//差异原因
	public static final String DIFF_REASON= "Diff_reason";
	//描述
	public static final String DES= "Des";
	//组别身份
	public static final String GRPIDENTIFY= "Grpidentify";
	//物品分类
	public static final String NAME_MMCA= "Name_mmca";
	//基本药物范围
	public static final String NAME_BASEDRUGRANGE= "Name_basedrugrange";
	//原包装单位
	public static final String ID_PKGU_ORI= "Id_pkgu_ori";
	//剂型id
	public static final String ID_DOSAGE= "Id_dosage";
	//通用名
	public static final String SRV_NAME= "Srv_name";
	//通用名拼音码
	public static final String SRV_PYCODE= "Srv_pycode";
	//物品名称
	public static final String MM_NAME= "Mm_name";
	//物品规格
	public static final String MM_SPEC= "Mm_spec";
	//物品编码
	public static final String MM_CODE= "Mm_code";
	//拼音
	public static final String MM_PYCODE= "Mm_pycode";
	//打印名称
	public static final String PRINTNAME= "Printname";
	//货位编码
	public static final String LOC_CODE= "Loc_code";
	//货位名称
	public static final String LOC_NAME= "Loc_name";
	//货位拼音码
	public static final String LOC_PYCODE= "Loc_pycode";
	//实际包装单位
	public static final String MMPKGUNAME= "Mmpkguname";
	//包装单位名称
	public static final String MMPKGU_BIG_NAME= "Mmpkgu_big_name";
	//包装单位名称
	public static final String MMPKGU_SMALL_NAME= "Mmpkgu_small_name";
	//清点人员
	public static final String STTK_NAME= "Sttk_name";
	//剂型名称
	public static final String DOSAGE_NAME= "Dosage_name";
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
	 * 库存盘点
	 * @return String
	 */
	public String getId_sttk() {
		return ((String) getAttrVal("Id_sttk"));
	}	
	/**
	 * 库存盘点
	 * @param Id_sttk
	 */
	public void setId_sttk(String Id_sttk) {
		setAttrVal("Id_sttk", Id_sttk);
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
	 * 货位号
	 * @return String
	 */
	public String getId_loc() {
		return ((String) getAttrVal("Id_loc"));
	}	
	/**
	 * 货位号
	 * @param Id_loc
	 */
	public void setId_loc(String Id_loc) {
		setAttrVal("Id_loc", Id_loc);
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
	 * 失效期
	 * @return FDate
	 */
	public FDate getDate_expi() {
		return ((FDate) getAttrVal("Date_expi"));
	}	
	/**
	 * 失效期
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
	 * 换算系数
	 * @return FDouble
	 */
	public FDouble getFactor() {
		return ((FDouble) getAttrVal("Factor"));
	}	
	/**
	 * 换算系数
	 * @param Factor
	 */
	public void setFactor(FDouble Factor) {
		setAttrVal("Factor", Factor);
	}
	/**
	 * 进价_基本单位
	 * @return FDouble
	 */
	public FDouble getPri_base() {
		return ((FDouble) getAttrVal("Pri_base"));
	}	
	/**
	 * 进价_基本单位
	 * @param Pri_base
	 */
	public void setPri_base(FDouble Pri_base) {
		setAttrVal("Pri_base", Pri_base);
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
	 * 售价_基本单位
	 * @return FDouble
	 */
	public FDouble getPri_sa_base() {
		return ((FDouble) getAttrVal("Pri_sa_base"));
	}	
	/**
	 * 售价_基本单位
	 * @param Pri_sa_base
	 */
	public void setPri_sa_base(FDouble Pri_sa_base) {
		setAttrVal("Pri_sa_base", Pri_sa_base);
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
	 * 账面数量_实际包装
	 * @return FDouble
	 */
	public FDouble getQuan_bk_actual() {
		return ((FDouble) getAttrVal("Quan_bk_actual"));
	}	
	/**
	 * 账面数量_实际包装
	 * @param Quan_bk_actual
	 */
	public void setQuan_bk_actual(FDouble Quan_bk_actual) {
		setAttrVal("Quan_bk_actual", Quan_bk_actual);
	}
	/**
	 * 大包装单位
	 * @return String
	 */
	public String getId_mmpkgu_big() {
		return ((String) getAttrVal("Id_mmpkgu_big"));
	}	
	/**
	 * 大包装单位
	 * @param Id_mmpkgu_big
	 */
	public void setId_mmpkgu_big(String Id_mmpkgu_big) {
		setAttrVal("Id_mmpkgu_big", Id_mmpkgu_big);
	}
	/**
	 * 实物数量_大包装单位
	 * @return FDouble
	 */
	public FDouble getQuan_actual_big() {
		return ((FDouble) getAttrVal("Quan_actual_big"));
	}	
	/**
	 * 实物数量_大包装单位
	 * @param Quan_actual_big
	 */
	public void setQuan_actual_big(FDouble Quan_actual_big) {
		setAttrVal("Quan_actual_big", Quan_actual_big);
	}
	/**
	 * 小包装单位
	 * @return String
	 */
	public String getId_mmpkgu_small() {
		return ((String) getAttrVal("Id_mmpkgu_small"));
	}	
	/**
	 * 小包装单位
	 * @param Id_mmpkgu_small
	 */
	public void setId_mmpkgu_small(String Id_mmpkgu_small) {
		setAttrVal("Id_mmpkgu_small", Id_mmpkgu_small);
	}
	/**
	 * 实物数量_小包装单位
	 * @return FDouble
	 */
	public FDouble getQuan_actual_small() {
		return ((FDouble) getAttrVal("Quan_actual_small"));
	}	
	/**
	 * 实物数量_小包装单位
	 * @param Quan_actual_small
	 */
	public void setQuan_actual_small(FDouble Quan_actual_small) {
		setAttrVal("Quan_actual_small", Quan_actual_small);
	}
	/**
	 * 实物数量_实际包装
	 * @return FDouble
	 */
	public FDouble getQuan_actual() {
		return ((FDouble) getAttrVal("Quan_actual"));
	}	
	/**
	 * 实物数量_实际包装
	 * @param Quan_actual
	 */
	public void setQuan_actual(FDouble Quan_actual) {
		setAttrVal("Quan_actual", Quan_actual);
	}
	/**
	 * 预留数量_实际包装
	 * @return FDouble
	 */
	public FDouble getQuan_reserve() {
		return ((FDouble) getAttrVal("Quan_reserve"));
	}	
	/**
	 * 预留数量_实际包装
	 * @param Quan_reserve
	 */
	public void setQuan_reserve(FDouble Quan_reserve) {
		setAttrVal("Quan_reserve", Quan_reserve);
	}
	/**
	 * 盈亏数量_ 实际包装
	 * @return FDouble
	 */
	public FDouble getDiff_actual() {
		return ((FDouble) getAttrVal("Diff_actual"));
	}	
	/**
	 * 盈亏数量_ 实际包装
	 * @param Diff_actual
	 */
	public void setDiff_actual(FDouble Diff_actual) {
		setAttrVal("Diff_actual", Diff_actual);
	}
	/**
	 * 账面数量_基本单位
	 * @return FDouble
	 */
	public FDouble getQuan_base() {
		return ((FDouble) getAttrVal("Quan_base"));
	}	
	/**
	 * 账面数量_基本单位
	 * @param Quan_base
	 */
	public void setQuan_base(FDouble Quan_base) {
		setAttrVal("Quan_base", Quan_base);
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
	 * 组别身份
	 * @return String
	 */
	public String getGrpidentify() {
		return ((String) getAttrVal("Grpidentify"));
	}	
	/**
	 * 组别身份
	 * @param Grpidentify
	 */
	public void setGrpidentify(String Grpidentify) {
		setAttrVal("Grpidentify", Grpidentify);
	}
	/**
	 * 物品分类
	 * @return String
	 */
	public String getName_mmca() {
		return ((String) getAttrVal("Name_mmca"));
	}	
	/**
	 * 物品分类
	 * @param Name_mmca
	 */
	public void setName_mmca(String Name_mmca) {
		setAttrVal("Name_mmca", Name_mmca);
	}
	/**
	 * 基本药物范围
	 * @return String
	 */
	public String getName_basedrugrange() {
		return ((String) getAttrVal("Name_basedrugrange"));
	}	
	/**
	 * 基本药物范围
	 * @param Name_basedrugrange
	 */
	public void setName_basedrugrange(String Name_basedrugrange) {
		setAttrVal("Name_basedrugrange", Name_basedrugrange);
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
	 * 剂型id
	 * @return String
	 */
	public String getId_dosage() {
		return ((String) getAttrVal("Id_dosage"));
	}	
	/**
	 * 剂型id
	 * @param Id_dosage
	 */
	public void setId_dosage(String Id_dosage) {
		setAttrVal("Id_dosage", Id_dosage);
	}
	/**
	 * 通用名
	 * @return String
	 */
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	/**
	 * 通用名
	 * @param Srv_name
	 */
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	/**
	 * 通用名拼音码
	 * @return String
	 */
	public String getSrv_pycode() {
		return ((String) getAttrVal("Srv_pycode"));
	}	
	/**
	 * 通用名拼音码
	 * @param Srv_pycode
	 */
	public void setSrv_pycode(String Srv_pycode) {
		setAttrVal("Srv_pycode", Srv_pycode);
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
	 * 打印名称
	 * @return String
	 */
	public String getPrintname() {
		return ((String) getAttrVal("Printname"));
	}	
	/**
	 * 打印名称
	 * @param Printname
	 */
	public void setPrintname(String Printname) {
		setAttrVal("Printname", Printname);
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
	 * 货位名称
	 * @return String
	 */
	public String getLoc_name() {
		return ((String) getAttrVal("Loc_name"));
	}	
	/**
	 * 货位名称
	 * @param Loc_name
	 */
	public void setLoc_name(String Loc_name) {
		setAttrVal("Loc_name", Loc_name);
	}
	/**
	 * 货位拼音码
	 * @return String
	 */
	public String getLoc_pycode() {
		return ((String) getAttrVal("Loc_pycode"));
	}	
	/**
	 * 货位拼音码
	 * @param Loc_pycode
	 */
	public void setLoc_pycode(String Loc_pycode) {
		setAttrVal("Loc_pycode", Loc_pycode);
	}
	/**
	 * 实际包装单位
	 * @return String
	 */
	public String getMmpkguname() {
		return ((String) getAttrVal("Mmpkguname"));
	}	
	/**
	 * 实际包装单位
	 * @param Mmpkguname
	 */
	public void setMmpkguname(String Mmpkguname) {
		setAttrVal("Mmpkguname", Mmpkguname);
	}
	/**
	 * 包装单位名称
	 * @return String
	 */
	public String getMmpkgu_big_name() {
		return ((String) getAttrVal("Mmpkgu_big_name"));
	}	
	/**
	 * 包装单位名称
	 * @param Mmpkgu_big_name
	 */
	public void setMmpkgu_big_name(String Mmpkgu_big_name) {
		setAttrVal("Mmpkgu_big_name", Mmpkgu_big_name);
	}
	/**
	 * 包装单位名称
	 * @return String
	 */
	public String getMmpkgu_small_name() {
		return ((String) getAttrVal("Mmpkgu_small_name"));
	}	
	/**
	 * 包装单位名称
	 * @param Mmpkgu_small_name
	 */
	public void setMmpkgu_small_name(String Mmpkgu_small_name) {
		setAttrVal("Mmpkgu_small_name", Mmpkgu_small_name);
	}
	/**
	 * 清点人员
	 * @return String
	 */
	public String getSttk_name() {
		return ((String) getAttrVal("Sttk_name"));
	}	
	/**
	 * 清点人员
	 * @param Sttk_name
	 */
	public void setSttk_name(String Sttk_name) {
		setAttrVal("Sttk_name", Sttk_name);
	}
	/**
	 * 剂型名称
	 * @return String
	 */
	public String getDosage_name() {
		return ((String) getAttrVal("Dosage_name"));
	}	
	/**
	 * 剂型名称
	 * @param Dosage_name
	 */
	public void setDosage_name(String Dosage_name) {
		setAttrVal("Dosage_name", Dosage_name);
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
		return "MM_ST_TK_LOC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(StockCaspItemDODesc.class);
	}
	
}