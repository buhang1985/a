package iih.mc.st.stockin.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mc.st.stockin.d.desc.McStockInItemDODesc;
import java.math.BigDecimal;

/**
 * 耗材入库单明细 DO数据 
 * 
 */
public class McStockInItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//入库单明细主键
	public static final String ID_INITM= "Id_initm";
	//入库单主键
	public static final String ID_IN= "Id_in";
	//结存主键
	public static final String ID_BL= "Id_bl";
	//物品
	public static final String ID_MM= "Id_mm";
	//唯一码
	public static final String ONLYCODE= "Onlycode";
	//批次
	public static final String BATCH= "Batch";
	//失效期
	public static final String DATE_EXPI= "Date_expi";
	//采购单价
	public static final String PRI_PO= "Pri_po";
	//进价
	public static final String PRI_ACT= "Pri_act";
	//售价
	public static final String PRI_SA= "Pri_sa";
	//零售单价
	public static final String PRI_SALE= "Pri_sale";
	//实际包装单位
	public static final String ID_MMPKGU_ACTUAL= "Id_mmpkgu_actual";
	//数量
	public static final String QUAN_ACTUAL= "Quan_actual";
	//金额
	public static final String AMT= "Amt";
	//账面数量
	public static final String QUAN_BK= "Quan_bk";
	//描述
	public static final String DES= "Des";
	//采购发票结算明细主键
	public static final String ID_BANLITEM= "Id_banlitem";
	//高低值分类
	public static final String EU_MMCA= "Eu_mmca";
	//供应商条码
	public static final String SUP_BCODE= "Sup_bcode";
	//原始发票号
	public static final String ORIG_CODE= "Orig_code";
	//开发票标志
	public static final String FG_INV= "Fg_inv";
	//临床医嘱
	public static final String ID_OR= "Id_or";
	//高值验收单细目id
	public static final String ID_INSPITEM= "Id_inspitem";
	//生产许可证号
	public static final String PRO_LICENSE= "Pro_license";
	//物品编码
	public static final String MM_CODE= "Mm_code";
	//物品名称
	public static final String MM_NAME= "Mm_name";
	//物品规格
	public static final String MM_SPEC= "Mm_spec";
	//生产厂家名称
	public static final String FACTORY_NAME= "Factory_name";
	//是否批次管理
	public static final String FG_BATCH= "Fg_batch";
	//包装单位名称
	public static final String MMPKGUNAME= "Mmpkguname";
	//医嘱名称
	public static final String NAME_OR= "Name_or";
	//执行科室
	public static final String ID_DEP_MP= "Id_dep_mp";
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
	 * 入库单主键
	 * @return String
	 */
	public String getId_in() {
		return ((String) getAttrVal("Id_in"));
	}	
	/**
	 * 入库单主键
	 * @param Id_in
	 */
	public void setId_in(String Id_in) {
		setAttrVal("Id_in", Id_in);
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
	 * 采购单价
	 * @return FDouble
	 */
	public FDouble getPri_po() {
		return ((FDouble) getAttrVal("Pri_po"));
	}	
	/**
	 * 采购单价
	 * @param Pri_po
	 */
	public void setPri_po(FDouble Pri_po) {
		setAttrVal("Pri_po", Pri_po);
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
	 * 零售单价
	 * @return FDouble
	 */
	public FDouble getPri_sale() {
		return ((FDouble) getAttrVal("Pri_sale"));
	}	
	/**
	 * 零售单价
	 * @param Pri_sale
	 */
	public void setPri_sale(FDouble Pri_sale) {
		setAttrVal("Pri_sale", Pri_sale);
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
	 * 数量
	 * @return FDouble
	 */
	public FDouble getQuan_actual() {
		return ((FDouble) getAttrVal("Quan_actual"));
	}	
	/**
	 * 数量
	 * @param Quan_actual
	 */
	public void setQuan_actual(FDouble Quan_actual) {
		setAttrVal("Quan_actual", Quan_actual);
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
	 * 账面数量
	 * @return FDouble
	 */
	public FDouble getQuan_bk() {
		return ((FDouble) getAttrVal("Quan_bk"));
	}	
	/**
	 * 账面数量
	 * @param Quan_bk
	 */
	public void setQuan_bk(FDouble Quan_bk) {
		setAttrVal("Quan_bk", Quan_bk);
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
	 * 采购发票结算明细主键
	 * @return String
	 */
	public String getId_banlitem() {
		return ((String) getAttrVal("Id_banlitem"));
	}	
	/**
	 * 采购发票结算明细主键
	 * @param Id_banlitem
	 */
	public void setId_banlitem(String Id_banlitem) {
		setAttrVal("Id_banlitem", Id_banlitem);
	}
	/**
	 * 高低值分类
	 * @return Integer
	 */
	public Integer getEu_mmca() {
		return ((Integer) getAttrVal("Eu_mmca"));
	}	
	/**
	 * 高低值分类
	 * @param Eu_mmca
	 */
	public void setEu_mmca(Integer Eu_mmca) {
		setAttrVal("Eu_mmca", Eu_mmca);
	}
	/**
	 * 供应商条码
	 * @return String
	 */
	public String getSup_bcode() {
		return ((String) getAttrVal("Sup_bcode"));
	}	
	/**
	 * 供应商条码
	 * @param Sup_bcode
	 */
	public void setSup_bcode(String Sup_bcode) {
		setAttrVal("Sup_bcode", Sup_bcode);
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
	 * 临床医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 临床医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 高值验收单细目id
	 * @return String
	 */
	public String getId_inspitem() {
		return ((String) getAttrVal("Id_inspitem"));
	}	
	/**
	 * 高值验收单细目id
	 * @param Id_inspitem
	 */
	public void setId_inspitem(String Id_inspitem) {
		setAttrVal("Id_inspitem", Id_inspitem);
	}
	/**
	 * 生产许可证号
	 * @return String
	 */
	public String getPro_license() {
		return ((String) getAttrVal("Pro_license"));
	}	
	/**
	 * 生产许可证号
	 * @param Pro_license
	 */
	public void setPro_license(String Pro_license) {
		setAttrVal("Pro_license", Pro_license);
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
	 * 是否批次管理
	 * @return FBoolean
	 */
	public FBoolean getFg_batch() {
		return ((FBoolean) getAttrVal("Fg_batch"));
	}	
	/**
	 * 是否批次管理
	 * @param Fg_batch
	 */
	public void setFg_batch(FBoolean Fg_batch) {
		setAttrVal("Fg_batch", Fg_batch);
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
	 * 医嘱名称
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}	
	/**
	 * 医嘱名称
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}	
	/**
	 * 执行科室
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
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
		return "mc_in_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(McStockInItemDODesc.class);
	}
	
}