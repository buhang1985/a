package iih.mc.mc.stockperinit.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mc.mc.stockperinit.d.desc.McStockPerInitItemDODesc;
import java.math.BigDecimal;

/**
 * 耗材期初明细 DO数据 
 * 
 */
public class McStockPerInitItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//期初明细主键
	public static final String ID_INIITM= "Id_iniitm";
	//期初主键
	public static final String ID_INI= "Id_ini";
	//物品
	public static final String ID_MM= "Id_mm";
	//物品分类
	public static final String ID_MMCA= "Id_mmca";
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
	//账面数量
	public static final String QUAN_BK= "Quan_bk";
	//金额
	public static final String AMT_COST= "Amt_cost";
	//描述
	public static final String DES= "Des";
	//低高值分类
	public static final String EU_MMCA= "Eu_mmca";
	//物品编码
	public static final String MM_CODE= "Mm_code";
	//物品名称
	public static final String MM_NAME= "Mm_name";
	//物品规格
	public static final String MM_SPEC= "Mm_spec";
	//生产厂家名称
	public static final String FACTORY_NAME= "Factory_name";
	//基本分类名称
	public static final String MMCA_NAME= "Mmca_name";
	//供应商与厂商名称
	public static final String SUP_NAME= "Sup_name";
	//包装单位名称
	public static final String MMPKGUNAME= "Mmpkguname";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 期初明细主键
	 * @return String
	 */
	public String getId_iniitm() {
		return ((String) getAttrVal("Id_iniitm"));
	}	
	/**
	 * 期初明细主键
	 * @param Id_iniitm
	 */
	public void setId_iniitm(String Id_iniitm) {
		setAttrVal("Id_iniitm", Id_iniitm);
	}
	/**
	 * 期初主键
	 * @return String
	 */
	public String getId_ini() {
		return ((String) getAttrVal("Id_ini"));
	}	
	/**
	 * 期初主键
	 * @param Id_ini
	 */
	public void setId_ini(String Id_ini) {
		setAttrVal("Id_ini", Id_ini);
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
	 * 物品分类
	 * @return String
	 */
	public String getId_mmca() {
		return ((String) getAttrVal("Id_mmca"));
	}	
	/**
	 * 物品分类
	 * @param Id_mmca
	 */
	public void setId_mmca(String Id_mmca) {
		setAttrVal("Id_mmca", Id_mmca);
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
	 * 金额
	 * @return FDouble
	 */
	public FDouble getAmt_cost() {
		return ((FDouble) getAttrVal("Amt_cost"));
	}	
	/**
	 * 金额
	 * @param Amt_cost
	 */
	public void setAmt_cost(FDouble Amt_cost) {
		setAttrVal("Amt_cost", Amt_cost);
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
	 * 低高值分类
	 * @return Integer
	 */
	public Integer getEu_mmca() {
		return ((Integer) getAttrVal("Eu_mmca"));
	}	
	/**
	 * 低高值分类
	 * @param Eu_mmca
	 */
	public void setEu_mmca(Integer Eu_mmca) {
		setAttrVal("Eu_mmca", Eu_mmca);
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
	 * 基本分类名称
	 * @return String
	 */
	public String getMmca_name() {
		return ((String) getAttrVal("Mmca_name"));
	}	
	/**
	 * 基本分类名称
	 * @param Mmca_name
	 */
	public void setMmca_name(String Mmca_name) {
		setAttrVal("Mmca_name", Mmca_name);
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
		return "Id_iniitm";
	}
	
	@Override
	public String getTableName() {	  
		return "MC_INI_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(McStockPerInitItemDODesc.class);
	}
	
}