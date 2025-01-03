package iih.mm.po.purchase.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.po.purchase.d.desc.PurchseOrderItmDODesc;
import java.math.BigDecimal;

/**
 * 库存采购明细 DO数据 
 * 
 */
public class PurchseOrderItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//库存采购明细主键
	public static final String ID_POITM= "Id_poitm";
	//库存采购单
	public static final String ID_PO= "Id_po";
	//序号
	public static final String SORTNO= "Sortno";
	//物品
	public static final String ID_MM= "Id_mm";
	//包装单位_实际
	public static final String ID_MMPKGU_ACTUAL= "Id_mmpkgu_actual";
	//包装单位_基本
	public static final String ID_MMPKGU_BASE= "Id_mmpkgu_base";
	//换算系数_当前与基本
	public static final String FACTOR_AB= "Factor_ab";
	//已采购数量
	public static final String QUAN_PURCHASED= "Quan_purchased";
	//采购数量_当前
	public static final String QUAN_PO_ACTUAL= "Quan_po_actual";
	//采购单价_当前
	public static final String PRICE_PO= "Price_po";
	//描述
	public static final String DES= "Des";
	//采购金额
	public static final String AMT= "Amt";
	//协议单价
	public static final String PRICE_PROTOCOL= "Price_protocol";
	//现库存量
	public static final String NUM_ACTUAL= "Num_actual";
	//最高库存
	public static final String NUM_MAX= "Num_max";
	//医疗服务名称
	public static final String SRV_NAME= "Srv_name";
	//采购单位系数
	public static final String PO_FACTOR= "Po_factor";
	//本月销量
	public static final String QUAN_CURMON= "Quan_curmon";
	//上月销量
	public static final String QUAN_2NDMON= "Quan_2ndmon";
	//上上月销量
	public static final String QUAN_3RDMON= "Quan_3rdmon";
	//物品规格
	public static final String MM_SPEC= "Mm_spec";
	//物品名称
	public static final String MM_NAME= "Mm_name";
	//是否批次管理
	public static final String MM_FG_BATCH= "Mm_fg_batch";
	//是否价格管理
	public static final String MM_FG_PRICE= "Mm_fg_price";
	//生产厂家名称
	public static final String FACTORY_NAME= "Factory_name";
	//服务项目外键
	public static final String ID_SRV= "Id_srv";
	//物品编码
	public static final String MM_CODE= "Mm_code";
	//当前批准文号/注册号
	public static final String MM_APPRNO= "Mm_apprno";
	//包装单位
	public static final String MMPKGUNAME_ACTUAL= "Mmpkguname_actual";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 库存采购明细主键
	 * @return String
	 */
	public String getId_poitm() {
		return ((String) getAttrVal("Id_poitm"));
	}	
	/**
	 * 库存采购明细主键
	 * @param Id_poitm
	 */
	public void setId_poitm(String Id_poitm) {
		setAttrVal("Id_poitm", Id_poitm);
	}
	/**
	 * 库存采购单
	 * @return String
	 */
	public String getId_po() {
		return ((String) getAttrVal("Id_po"));
	}	
	/**
	 * 库存采购单
	 * @param Id_po
	 */
	public void setId_po(String Id_po) {
		setAttrVal("Id_po", Id_po);
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
	 * 包装单位_实际
	 * @return String
	 */
	public String getId_mmpkgu_actual() {
		return ((String) getAttrVal("Id_mmpkgu_actual"));
	}	
	/**
	 * 包装单位_实际
	 * @param Id_mmpkgu_actual
	 */
	public void setId_mmpkgu_actual(String Id_mmpkgu_actual) {
		setAttrVal("Id_mmpkgu_actual", Id_mmpkgu_actual);
	}
	/**
	 * 包装单位_基本
	 * @return String
	 */
	public String getId_mmpkgu_base() {
		return ((String) getAttrVal("Id_mmpkgu_base"));
	}	
	/**
	 * 包装单位_基本
	 * @param Id_mmpkgu_base
	 */
	public void setId_mmpkgu_base(String Id_mmpkgu_base) {
		setAttrVal("Id_mmpkgu_base", Id_mmpkgu_base);
	}
	/**
	 * 换算系数_当前与基本
	 * @return FDouble
	 */
	public FDouble getFactor_ab() {
		return ((FDouble) getAttrVal("Factor_ab"));
	}	
	/**
	 * 换算系数_当前与基本
	 * @param Factor_ab
	 */
	public void setFactor_ab(FDouble Factor_ab) {
		setAttrVal("Factor_ab", Factor_ab);
	}
	/**
	 * 已采购数量
	 * @return FDouble
	 */
	public FDouble getQuan_purchased() {
		return ((FDouble) getAttrVal("Quan_purchased"));
	}	
	/**
	 * 已采购数量
	 * @param Quan_purchased
	 */
	public void setQuan_purchased(FDouble Quan_purchased) {
		setAttrVal("Quan_purchased", Quan_purchased);
	}
	/**
	 * 采购数量_当前
	 * @return FDouble
	 */
	public FDouble getQuan_po_actual() {
		return ((FDouble) getAttrVal("Quan_po_actual"));
	}	
	/**
	 * 采购数量_当前
	 * @param Quan_po_actual
	 */
	public void setQuan_po_actual(FDouble Quan_po_actual) {
		setAttrVal("Quan_po_actual", Quan_po_actual);
	}
	/**
	 * 采购单价_当前
	 * @return FDouble
	 */
	public FDouble getPrice_po() {
		return ((FDouble) getAttrVal("Price_po"));
	}	
	/**
	 * 采购单价_当前
	 * @param Price_po
	 */
	public void setPrice_po(FDouble Price_po) {
		setAttrVal("Price_po", Price_po);
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
	 * 采购金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	/**
	 * 采购金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 协议单价
	 * @return FDouble
	 */
	public FDouble getPrice_protocol() {
		return ((FDouble) getAttrVal("Price_protocol"));
	}	
	/**
	 * 协议单价
	 * @param Price_protocol
	 */
	public void setPrice_protocol(FDouble Price_protocol) {
		setAttrVal("Price_protocol", Price_protocol);
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
	 * 本月销量
	 * @return FDouble
	 */
	public FDouble getQuan_curmon() {
		return ((FDouble) getAttrVal("Quan_curmon"));
	}	
	/**
	 * 本月销量
	 * @param Quan_curmon
	 */
	public void setQuan_curmon(FDouble Quan_curmon) {
		setAttrVal("Quan_curmon", Quan_curmon);
	}
	/**
	 * 上月销量
	 * @return FDouble
	 */
	public FDouble getQuan_2ndmon() {
		return ((FDouble) getAttrVal("Quan_2ndmon"));
	}	
	/**
	 * 上月销量
	 * @param Quan_2ndmon
	 */
	public void setQuan_2ndmon(FDouble Quan_2ndmon) {
		setAttrVal("Quan_2ndmon", Quan_2ndmon);
	}
	/**
	 * 上上月销量
	 * @return FDouble
	 */
	public FDouble getQuan_3rdmon() {
		return ((FDouble) getAttrVal("Quan_3rdmon"));
	}	
	/**
	 * 上上月销量
	 * @param Quan_3rdmon
	 */
	public void setQuan_3rdmon(FDouble Quan_3rdmon) {
		setAttrVal("Quan_3rdmon", Quan_3rdmon);
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
	 * 是否批次管理
	 * @return FBoolean
	 */
	public FBoolean getMm_fg_batch() {
		return ((FBoolean) getAttrVal("Mm_fg_batch"));
	}	
	/**
	 * 是否批次管理
	 * @param Mm_fg_batch
	 */
	public void setMm_fg_batch(FBoolean Mm_fg_batch) {
		setAttrVal("Mm_fg_batch", Mm_fg_batch);
	}
	/**
	 * 是否价格管理
	 * @return FBoolean
	 */
	public FBoolean getMm_fg_price() {
		return ((FBoolean) getAttrVal("Mm_fg_price"));
	}	
	/**
	 * 是否价格管理
	 * @param Mm_fg_price
	 */
	public void setMm_fg_price(FBoolean Mm_fg_price) {
		setAttrVal("Mm_fg_price", Mm_fg_price);
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
	 * 包装单位
	 * @return String
	 */
	public String getMmpkguname_actual() {
		return ((String) getAttrVal("Mmpkguname_actual"));
	}	
	/**
	 * 包装单位
	 * @param Mmpkguname_actual
	 */
	public void setMmpkguname_actual(String Mmpkguname_actual) {
		setAttrVal("Mmpkguname_actual", Mmpkguname_actual);
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
		return "Id_poitm";
	}
	
	@Override
	public String getTableName() {	  
		return "MM_PO_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PurchseOrderItmDODesc.class);
	}
	
}