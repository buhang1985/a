package iih.mc.bl.stockbl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mc.bl.stockbl.d.desc.McStockBlDODesc;
import java.math.BigDecimal;

/**
 * 耗材结存 DO数据 
 * 
 */
public class McStockBlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//结存主键
	public static final String ID_BL= "Id_bl";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//仓库
	public static final String ID_WH= "Id_wh";
	//物品
	public static final String ID_MM= "Id_mm";
	//供应商
	public static final String ID_SUP= "Id_sup";
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
	//现存量
	public static final String QUAN_STOCK= "Quan_stock";
	//预留量
	public static final String QUAN_RESERVE= "Quan_reserve";
	//可用量
	public static final String QUAN_USABLE= "Quan_usable";
	//成本金额
	public static final String AMT_COST= "Amt_cost";
	//数据修改标识
	public static final String FG_CHANGED= "Fg_changed";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//高低值分类
	public static final String EU_MMCA= "Eu_mmca";
	//是否代管
	public static final String FG_ESCROW= "Fg_escrow";
	//物品编码
	public static final String MM_CODE= "Mm_code";
	//物品名称
	public static final String MM_NAME= "Mm_name";
	//物品规格
	public static final String MM_SPEC= "Mm_spec";
	//生产厂家名称
	public static final String FACTORY_NAME= "Factory_name";
	//供应商与厂商名称
	public static final String SUP_NAME= "Sup_name";
	//包装单位名称
	public static final String MMPKGUNAME= "Mmpkguname";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
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
	 * 仓库
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	/**
	 * 仓库
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
	 * 现存量
	 * @return FDouble
	 */
	public FDouble getQuan_stock() {
		return ((FDouble) getAttrVal("Quan_stock"));
	}	
	/**
	 * 现存量
	 * @param Quan_stock
	 */
	public void setQuan_stock(FDouble Quan_stock) {
		setAttrVal("Quan_stock", Quan_stock);
	}
	/**
	 * 预留量
	 * @return FDouble
	 */
	public FDouble getQuan_reserve() {
		return ((FDouble) getAttrVal("Quan_reserve"));
	}	
	/**
	 * 预留量
	 * @param Quan_reserve
	 */
	public void setQuan_reserve(FDouble Quan_reserve) {
		setAttrVal("Quan_reserve", Quan_reserve);
	}
	/**
	 * 可用量
	 * @return FDouble
	 */
	public FDouble getQuan_usable() {
		return ((FDouble) getAttrVal("Quan_usable"));
	}	
	/**
	 * 可用量
	 * @param Quan_usable
	 */
	public void setQuan_usable(FDouble Quan_usable) {
		setAttrVal("Quan_usable", Quan_usable);
	}
	/**
	 * 成本金额
	 * @return FDouble
	 */
	public FDouble getAmt_cost() {
		return ((FDouble) getAttrVal("Amt_cost"));
	}	
	/**
	 * 成本金额
	 * @param Amt_cost
	 */
	public void setAmt_cost(FDouble Amt_cost) {
		setAttrVal("Amt_cost", Amt_cost);
	}
	/**
	 * 数据修改标识
	 * @return FBoolean
	 */
	public FBoolean getFg_changed() {
		return ((FBoolean) getAttrVal("Fg_changed"));
	}	
	/**
	 * 数据修改标识
	 * @param Fg_changed
	 */
	public void setFg_changed(FBoolean Fg_changed) {
		setAttrVal("Fg_changed", Fg_changed);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
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
	 * 是否代管
	 * @return FBoolean
	 */
	public FBoolean getFg_escrow() {
		return ((FBoolean) getAttrVal("Fg_escrow"));
	}	
	/**
	 * 是否代管
	 * @param Fg_escrow
	 */
	public void setFg_escrow(FBoolean Fg_escrow) {
		setAttrVal("Fg_escrow", Fg_escrow);
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
		return "Id_bl";
	}
	
	@Override
	public String getTableName() {	  
		return "mc_bl";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(McStockBlDODesc.class);
	}
	
}