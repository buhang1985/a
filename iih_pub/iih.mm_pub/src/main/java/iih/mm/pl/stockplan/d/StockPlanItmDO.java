package iih.mm.pl.stockplan.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.pl.stockplan.d.desc.StockPlanItmDODesc;
import java.math.BigDecimal;

/**
 * 库存计划明细 DO数据 
 * 
 */
public class StockPlanItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//库存计划明细主键
	public static final String ID_PLITM= "Id_plitm";
	//库存计划
	public static final String ID_PL= "Id_pl";
	//序号
	public static final String SORTNO= "Sortno";
	//物品
	public static final String ID_MM= "Id_mm";
	//采购单生成标志
	public static final String FG_PO= "Fg_po";
	//对应采购单
	public static final String ID_PO= "Id_po";
	//对应采购单明细
	public static final String ID_POITM= "Id_poitm";
	//计划/采购数量_基本
	public static final String QUAN_PL_BASE= "Quan_pl_base";
	//计划/采购数量_实际
	public static final String QUAN_PL_ACTUAL= "Quan_pl_actual";
	//基本包装单位
	public static final String ID_MMPKGU_BASE= "Id_mmpkgu_base";
	//实际包装单位
	public static final String ID_MMPKGU_ACTUAL= "Id_mmpkgu_actual";
	//入库价_实际单位
	public static final String PRI_ACT= "Pri_act";
	//金额
	public static final String AMT= "Amt";
	//换算系数
	public static final String FACTOR= "Factor";
	//供应商
	public static final String ID_SUP= "Id_sup";
	//需要日期
	public static final String DATE_REQR= "Date_reqr";
	//描述
	public static final String DES= "Des";
	//现库存量或消耗量
	public static final String NUM_ACTUAL= "Num_actual";
	//最高库存
	public static final String NUM_MAX= "Num_max";
	//最低库存
	public static final String NUM_LOW= "Num_low";
	//参考数量
	public static final String NUM_REF= "Num_ref";
	//各药房库存
	public static final String NUM_PHARMACY= "Num_pharmacy";
	//本月销量
	public static final String CURR_SALENUM= "Curr_salenum";
	//上月销量
	public static final String PRE_SALENUM= "Pre_salenum";
	//上上月销量
	public static final String LAST_SALENUM= "Last_salenum";
	//近7天消耗
	public static final String SEV_SALENUM= "Sev_salenum";
	//医疗服务名称
	public static final String SRV_NAME= "Srv_name";
	//采购单位
	public static final String PKGU_PO_NAME= "Pkgu_po_name";
	//采购单位系数
	public static final String PO_FACTOR= "Po_factor";
	//物品规格
	public static final String MM_SPEC= "Mm_spec";
	//物品名称
	public static final String MM_NAME= "Mm_name";
	//生产厂家名称
	public static final String FACTORY_NAME= "Factory_name";
	//拼音
	public static final String MM_PYCODE= "Mm_pycode";
	//物品编码
	public static final String MM_CODE= "Mm_code";
	//服务项目外键
	public static final String ID_SRV= "Id_srv";
	//当前批准文号/注册号
	public static final String MM_APPRNO= "Mm_apprno";
	//包装单位名称
	public static final String MMPKGUNAME= "Mmpkguname";
	//供应商与厂商名称
	public static final String SUP_NAME= "Sup_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 库存计划明细主键
	 * @return String
	 */
	public String getId_plitm() {
		return ((String) getAttrVal("Id_plitm"));
	}	
	/**
	 * 库存计划明细主键
	 * @param Id_plitm
	 */
	public void setId_plitm(String Id_plitm) {
		setAttrVal("Id_plitm", Id_plitm);
	}
	/**
	 * 库存计划
	 * @return String
	 */
	public String getId_pl() {
		return ((String) getAttrVal("Id_pl"));
	}	
	/**
	 * 库存计划
	 * @param Id_pl
	 */
	public void setId_pl(String Id_pl) {
		setAttrVal("Id_pl", Id_pl);
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
	 * 采购单生成标志
	 * @return FBoolean
	 */
	public FBoolean getFg_po() {
		return ((FBoolean) getAttrVal("Fg_po"));
	}	
	/**
	 * 采购单生成标志
	 * @param Fg_po
	 */
	public void setFg_po(FBoolean Fg_po) {
		setAttrVal("Fg_po", Fg_po);
	}
	/**
	 * 对应采购单
	 * @return String
	 */
	public String getId_po() {
		return ((String) getAttrVal("Id_po"));
	}	
	/**
	 * 对应采购单
	 * @param Id_po
	 */
	public void setId_po(String Id_po) {
		setAttrVal("Id_po", Id_po);
	}
	/**
	 * 对应采购单明细
	 * @return String
	 */
	public String getId_poitm() {
		return ((String) getAttrVal("Id_poitm"));
	}	
	/**
	 * 对应采购单明细
	 * @param Id_poitm
	 */
	public void setId_poitm(String Id_poitm) {
		setAttrVal("Id_poitm", Id_poitm);
	}
	/**
	 * 计划/采购数量_基本
	 * @return FDouble
	 */
	public FDouble getQuan_pl_base() {
		return ((FDouble) getAttrVal("Quan_pl_base"));
	}	
	/**
	 * 计划/采购数量_基本
	 * @param Quan_pl_base
	 */
	public void setQuan_pl_base(FDouble Quan_pl_base) {
		setAttrVal("Quan_pl_base", Quan_pl_base);
	}
	/**
	 * 计划/采购数量_实际
	 * @return FDouble
	 */
	public FDouble getQuan_pl_actual() {
		return ((FDouble) getAttrVal("Quan_pl_actual"));
	}	
	/**
	 * 计划/采购数量_实际
	 * @param Quan_pl_actual
	 */
	public void setQuan_pl_actual(FDouble Quan_pl_actual) {
		setAttrVal("Quan_pl_actual", Quan_pl_actual);
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
	 * 入库价_实际单位
	 * @return FDouble
	 */
	public FDouble getPri_act() {
		return ((FDouble) getAttrVal("Pri_act"));
	}	
	/**
	 * 入库价_实际单位
	 * @param Pri_act
	 */
	public void setPri_act(FDouble Pri_act) {
		setAttrVal("Pri_act", Pri_act);
	}
	/**
	 * 金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	/**
	 * 金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
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
	 * 需要日期
	 * @return FDate
	 */
	public FDate getDate_reqr() {
		return ((FDate) getAttrVal("Date_reqr"));
	}	
	/**
	 * 需要日期
	 * @param Date_reqr
	 */
	public void setDate_reqr(FDate Date_reqr) {
		setAttrVal("Date_reqr", Date_reqr);
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
	 * 现库存量或消耗量
	 * @return FDouble
	 */
	public FDouble getNum_actual() {
		return ((FDouble) getAttrVal("Num_actual"));
	}	
	/**
	 * 现库存量或消耗量
	 * @param Num_actual
	 */
	public void setNum_actual(FDouble Num_actual) {
		setAttrVal("Num_actual", Num_actual);
	}
	/**
	 * 最高库存
	 * @return FDouble
	 */
	public FDouble getNum_max() {
		return ((FDouble) getAttrVal("Num_max"));
	}	
	/**
	 * 最高库存
	 * @param Num_max
	 */
	public void setNum_max(FDouble Num_max) {
		setAttrVal("Num_max", Num_max);
	}
	/**
	 * 最低库存
	 * @return FDouble
	 */
	public FDouble getNum_low() {
		return ((FDouble) getAttrVal("Num_low"));
	}	
	/**
	 * 最低库存
	 * @param Num_low
	 */
	public void setNum_low(FDouble Num_low) {
		setAttrVal("Num_low", Num_low);
	}
	/**
	 * 参考数量
	 * @return FDouble
	 */
	public FDouble getNum_ref() {
		return ((FDouble) getAttrVal("Num_ref"));
	}	
	/**
	 * 参考数量
	 * @param Num_ref
	 */
	public void setNum_ref(FDouble Num_ref) {
		setAttrVal("Num_ref", Num_ref);
	}
	/**
	 * 各药房库存
	 * @return FDouble
	 */
	public FDouble getNum_pharmacy() {
		return ((FDouble) getAttrVal("Num_pharmacy"));
	}	
	/**
	 * 各药房库存
	 * @param Num_pharmacy
	 */
	public void setNum_pharmacy(FDouble Num_pharmacy) {
		setAttrVal("Num_pharmacy", Num_pharmacy);
	}
	/**
	 * 本月销量
	 * @return FDouble
	 */
	public FDouble getCurr_salenum() {
		return ((FDouble) getAttrVal("Curr_salenum"));
	}	
	/**
	 * 本月销量
	 * @param Curr_salenum
	 */
	public void setCurr_salenum(FDouble Curr_salenum) {
		setAttrVal("Curr_salenum", Curr_salenum);
	}
	/**
	 * 上月销量
	 * @return FDouble
	 */
	public FDouble getPre_salenum() {
		return ((FDouble) getAttrVal("Pre_salenum"));
	}	
	/**
	 * 上月销量
	 * @param Pre_salenum
	 */
	public void setPre_salenum(FDouble Pre_salenum) {
		setAttrVal("Pre_salenum", Pre_salenum);
	}
	/**
	 * 上上月销量
	 * @return FDouble
	 */
	public FDouble getLast_salenum() {
		return ((FDouble) getAttrVal("Last_salenum"));
	}	
	/**
	 * 上上月销量
	 * @param Last_salenum
	 */
	public void setLast_salenum(FDouble Last_salenum) {
		setAttrVal("Last_salenum", Last_salenum);
	}
	/**
	 * 近7天消耗
	 * @return FDouble
	 */
	public FDouble getSev_salenum() {
		return ((FDouble) getAttrVal("Sev_salenum"));
	}	
	/**
	 * 近7天消耗
	 * @param Sev_salenum
	 */
	public void setSev_salenum(FDouble Sev_salenum) {
		setAttrVal("Sev_salenum", Sev_salenum);
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
	 * 当前批准文号/注册号
	 * @return String
	 */
	public String getMm_apprno() {
		return ((String) getAttrVal("Mm_apprno"));
	}	
	/**
	 * 当前批准文号/注册号
	 * @param Mm_apprno
	 */
	public void setMm_apprno(String Mm_apprno) {
		setAttrVal("Mm_apprno", Mm_apprno);
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
		return "Id_plitm";
	}
	
	@Override
	public String getTableName() {	  
		return "MM_PL_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(StockPlanItmDODesc.class);
	}
	
}