package iih.mc.po.pruchase.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mc.po.pruchase.d.desc.McPurchseOrderItmDODesc;
import java.math.BigDecimal;

/**
 * 采购订单明细 DO数据 
 * 
 */
public class McPurchseOrderItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//采购单明细主键
	public static final String ID_POITM= "Id_poitm";
	//库存采购单
	public static final String ID_PO= "Id_po";
	//物品
	public static final String ID_MM= "Id_mm";
	//包装单位
	public static final String ID_MMPKGU_ACTUAL= "Id_mmpkgu_actual";
	//协议价
	public static final String PRI_PROTOCOL= "Pri_protocol";
	//采购价
	public static final String PRI_PO= "Pri_po";
	//数量
	public static final String QUAN_PO= "Quan_po";
	//金额
	public static final String AMT= "Amt";
	//现存量
	public static final String QUAN_BK= "Quan_bk";
	//最高库存
	public static final String NUM_MAX= "Num_max";
	//描述
	public static final String DES= "Des";
	//高低值分类
	public static final String EU_MMCA= "Eu_mmca";
	//临床医嘱
	public static final String ID_OR= "Id_or";
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
	//医嘱名称
	public static final String NAME_OR= "Name_or";
	//执行科室
	public static final String ID_DEP_MP= "Id_dep_mp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 采购单明细主键
	 * @return String
	 */
	public String getId_poitm() {
		return ((String) getAttrVal("Id_poitm"));
	}	
	/**
	 * 采购单明细主键
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
	 * 协议价
	 * @return FDouble
	 */
	public FDouble getPri_protocol() {
		return ((FDouble) getAttrVal("Pri_protocol"));
	}	
	/**
	 * 协议价
	 * @param Pri_protocol
	 */
	public void setPri_protocol(FDouble Pri_protocol) {
		setAttrVal("Pri_protocol", Pri_protocol);
	}
	/**
	 * 采购价
	 * @return FDouble
	 */
	public FDouble getPri_po() {
		return ((FDouble) getAttrVal("Pri_po"));
	}	
	/**
	 * 采购价
	 * @param Pri_po
	 */
	public void setPri_po(FDouble Pri_po) {
		setAttrVal("Pri_po", Pri_po);
	}
	/**
	 * 数量
	 * @return FDouble
	 */
	public FDouble getQuan_po() {
		return ((FDouble) getAttrVal("Quan_po"));
	}	
	/**
	 * 数量
	 * @param Quan_po
	 */
	public void setQuan_po(FDouble Quan_po) {
		setAttrVal("Quan_po", Quan_po);
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
	 * 现存量
	 * @return FDouble
	 */
	public FDouble getQuan_bk() {
		return ((FDouble) getAttrVal("Quan_bk"));
	}	
	/**
	 * 现存量
	 * @param Quan_bk
	 */
	public void setQuan_bk(FDouble Quan_bk) {
		setAttrVal("Quan_bk", Quan_bk);
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
		return "Id_poitm";
	}
	
	@Override
	public String getTableName() {	  
		return "MC_PO_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(McPurchseOrderItmDODesc.class);
	}
	
}