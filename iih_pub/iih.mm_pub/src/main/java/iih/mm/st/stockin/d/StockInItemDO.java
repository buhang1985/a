package iih.mm.st.stockin.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.st.stockin.d.desc.StockInItemDODesc;
import java.math.BigDecimal;

/**
 * 入库单明细 DO数据 
 * 
 */
public class StockInItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//入库单明细主键
	public static final String ID_INITM= "Id_initm";
	//入库单据主键
	public static final String ID_IN= "Id_in";
	//序号
	public static final String SORTNO= "Sortno";
	//原始发票号
	public static final String ORIG_CODE= "Orig_code";
	//原始发票日期
	public static final String DT_ORIG= "Dt_orig";
	//物品
	public static final String ID_MM= "Id_mm";
	//基本包装单位
	public static final String ID_MMPKGU_BASE= "Id_mmpkgu_base";
	//实际包装单位
	public static final String ID_MMPKGU_ACTUAL= "Id_mmpkgu_actual";
	//数量_实际包装
	public static final String QUAN_ACTUAL= "Quan_actual";
	//供应商
	public static final String ID_SUP= "Id_sup";
	//批次
	public static final String BATCH= "Batch";
	//有效期
	public static final String DATE_EXPI= "Date_expi";
	//零售包装单位
	public static final String ID_MMPKGU_SP= "Id_mmpkgu_sp";
	//采购价格_实际单位
	public static final String PRI_PO= "Pri_po";
	//入库价_实际单位
	public static final String PRI_ACT= "Pri_act";
	//售价_实际单位
	public static final String PRI_SA= "Pri_sa";
	//金额_成本
	public static final String AMT= "Amt";
	//描述
	public static final String DES= "Des";
	//采购单
	public static final String ID_PO= "Id_po";
	//采购单明细单
	public static final String ID_POITM= "Id_poitm";
	//已付款标志
	public static final String FG_PAY= "Fg_pay";
	//开发票标志
	public static final String FG_INV= "Fg_inv";
	//发票号
	public static final String INC= "Inc";
	//唯一码（高值耗材）
	public static final String ONLYCODE= "Onlycode";
	//实际扣率
	public static final String RATE_ACTUAL= "Rate_actual";
	//物品特性
	public static final String CHARACTER= "Character";
	//已出库数量_基本
	public static final String QUAN_ST_BASE= "Quan_st_base";
	//已完成出库标志
	public static final String FG_FINISH= "Fg_finish";
	//售价_零售单位
	public static final String PRI_SALE= "Pri_sale";
	//结存主键
	public static final String ID_BL= "Id_bl";
	//结算明细(生成结算回冲关系数据用)
	public static final String ID_BANLITM= "Id_banlitm";
	//最高库存
	public static final String NUM_MAX= "Num_max";
	//现库存量
	public static final String NUM_ACTUAL= "Num_actual";
	//医疗服务
	public static final String SRV_NAME= "Srv_name";
	//发货码(扫码入库使用)
	public static final String STORCODE= "Storcode";
	//物品名称
	public static final String MM_NAME= "Mm_name";
	//物品规格
	public static final String MM_SPEC= "Mm_spec";
	//物品是否批次管理
	public static final String MM_FG_BATCH= "Mm_fg_batch";
	//物品编码
	public static final String MM_CODE= "Mm_code";
	//拼音
	public static final String MM_PYCODE= "Mm_pycode";
	//当前批准文号/注册号
	public static final String MM_APPRNO= "Mm_apprno";
	//服务项目外键
	public static final String ID_SRV= "Id_srv";
	//是否效期管理
	public static final String MM_FG_EFFECTIVE= "Mm_fg_effective";
	//包装单位名称
	public static final String ACPKGUNAME= "Acpkguname";
	//供应商与厂商名称
	public static final String SUP_NAME= "Sup_name";
	//包装单位名称
	public static final String POPKGUNAME= "Popkguname";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 入库单明细主键
	 * @return String
	 */
	public String getId_initm() {
		return ((String) getAttrVal("Id_initm"));
	}	
	/**
	 * 入库单明细主键
	 * @param Id_initm
	 */
	public void setId_initm(String Id_initm) {
		setAttrVal("Id_initm", Id_initm);
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
	 * 原始发票号
	 * @return String
	 */
	public String getOrig_code() {
		return ((String) getAttrVal("Orig_code"));
	}	
	/**
	 * 原始发票号
	 * @param Orig_code
	 */
	public void setOrig_code(String Orig_code) {
		setAttrVal("Orig_code", Orig_code);
	}
	/**
	 * 原始发票日期
	 * @return FDate
	 */
	public FDate getDt_orig() {
		return ((FDate) getAttrVal("Dt_orig"));
	}	
	/**
	 * 原始发票日期
	 * @param Dt_orig
	 */
	public void setDt_orig(FDate Dt_orig) {
		setAttrVal("Dt_orig", Dt_orig);
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
	 * 数量_实际包装
	 * @return FDouble
	 */
	public FDouble getQuan_actual() {
		return ((FDouble) getAttrVal("Quan_actual"));
	}	
	/**
	 * 数量_实际包装
	 * @param Quan_actual
	 */
	public void setQuan_actual(FDouble Quan_actual) {
		setAttrVal("Quan_actual", Quan_actual);
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
	 * 采购价格_实际单位
	 * @return FDouble
	 */
	public FDouble getPri_po() {
		return ((FDouble) getAttrVal("Pri_po"));
	}	
	/**
	 * 采购价格_实际单位
	 * @param Pri_po
	 */
	public void setPri_po(FDouble Pri_po) {
		setAttrVal("Pri_po", Pri_po);
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
	 * 采购单
	 * @return String
	 */
	public String getId_po() {
		return ((String) getAttrVal("Id_po"));
	}	
	/**
	 * 采购单
	 * @param Id_po
	 */
	public void setId_po(String Id_po) {
		setAttrVal("Id_po", Id_po);
	}
	/**
	 * 采购单明细单
	 * @return String
	 */
	public String getId_poitm() {
		return ((String) getAttrVal("Id_poitm"));
	}	
	/**
	 * 采购单明细单
	 * @param Id_poitm
	 */
	public void setId_poitm(String Id_poitm) {
		setAttrVal("Id_poitm", Id_poitm);
	}
	/**
	 * 已付款标志
	 * @return FBoolean
	 */
	public FBoolean getFg_pay() {
		return ((FBoolean) getAttrVal("Fg_pay"));
	}	
	/**
	 * 已付款标志
	 * @param Fg_pay
	 */
	public void setFg_pay(FBoolean Fg_pay) {
		setAttrVal("Fg_pay", Fg_pay);
	}
	/**
	 * 开发票标志
	 * @return FBoolean
	 */
	public FBoolean getFg_inv() {
		return ((FBoolean) getAttrVal("Fg_inv"));
	}	
	/**
	 * 开发票标志
	 * @param Fg_inv
	 */
	public void setFg_inv(FBoolean Fg_inv) {
		setAttrVal("Fg_inv", Fg_inv);
	}
	/**
	 * 发票号
	 * @return String
	 */
	public String getInc() {
		return ((String) getAttrVal("Inc"));
	}	
	/**
	 * 发票号
	 * @param Inc
	 */
	public void setInc(String Inc) {
		setAttrVal("Inc", Inc);
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
	 * 实际扣率
	 * @return FDouble
	 */
	public FDouble getRate_actual() {
		return ((FDouble) getAttrVal("Rate_actual"));
	}	
	/**
	 * 实际扣率
	 * @param Rate_actual
	 */
	public void setRate_actual(FDouble Rate_actual) {
		setAttrVal("Rate_actual", Rate_actual);
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
	 * 已出库数量_基本
	 * @return FDouble
	 */
	public FDouble getQuan_st_base() {
		return ((FDouble) getAttrVal("Quan_st_base"));
	}	
	/**
	 * 已出库数量_基本
	 * @param Quan_st_base
	 */
	public void setQuan_st_base(FDouble Quan_st_base) {
		setAttrVal("Quan_st_base", Quan_st_base);
	}
	/**
	 * 已完成出库标志
	 * @return FBoolean
	 */
	public FBoolean getFg_finish() {
		return ((FBoolean) getAttrVal("Fg_finish"));
	}	
	/**
	 * 已完成出库标志
	 * @param Fg_finish
	 */
	public void setFg_finish(FBoolean Fg_finish) {
		setAttrVal("Fg_finish", Fg_finish);
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
	 * 结算明细(生成结算回冲关系数据用)
	 * @return String
	 */
	public String getId_banlitm() {
		return ((String) getAttrVal("Id_banlitm"));
	}	
	/**
	 * 结算明细(生成结算回冲关系数据用)
	 * @param Id_banlitm
	 */
	public void setId_banlitm(String Id_banlitm) {
		setAttrVal("Id_banlitm", Id_banlitm);
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
	 * 现库存量
	 * @return FDouble
	 */
	public FDouble getNum_actual() {
		return ((FDouble) getAttrVal("Num_actual"));
	}	
	/**
	 * 现库存量
	 * @param Num_actual
	 */
	public void setNum_actual(FDouble Num_actual) {
		setAttrVal("Num_actual", Num_actual);
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
	 * 发货码(扫码入库使用)
	 * @return String
	 */
	public String getStorcode() {
		return ((String) getAttrVal("Storcode"));
	}	
	/**
	 * 发货码(扫码入库使用)
	 * @param Storcode
	 */
	public void setStorcode(String Storcode) {
		setAttrVal("Storcode", Storcode);
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
	 * 物品是否批次管理
	 * @return FBoolean
	 */
	public FBoolean getMm_fg_batch() {
		return ((FBoolean) getAttrVal("Mm_fg_batch"));
	}	
	/**
	 * 物品是否批次管理
	 * @param Mm_fg_batch
	 */
	public void setMm_fg_batch(FBoolean Mm_fg_batch) {
		setAttrVal("Mm_fg_batch", Mm_fg_batch);
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
	 * 是否效期管理
	 * @return FBoolean
	 */
	public FBoolean getMm_fg_effective() {
		return ((FBoolean) getAttrVal("Mm_fg_effective"));
	}	
	/**
	 * 是否效期管理
	 * @param Mm_fg_effective
	 */
	public void setMm_fg_effective(FBoolean Mm_fg_effective) {
		setAttrVal("Mm_fg_effective", Mm_fg_effective);
	}
	/**
	 * 包装单位名称
	 * @return String
	 */
	public String getAcpkguname() {
		return ((String) getAttrVal("Acpkguname"));
	}	
	/**
	 * 包装单位名称
	 * @param Acpkguname
	 */
	public void setAcpkguname(String Acpkguname) {
		setAttrVal("Acpkguname", Acpkguname);
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
		return "Id_initm";
	}
	
	@Override
	public String getTableName() {	  
		return "MM_IN_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(StockInItemDODesc.class);
	}
	
}