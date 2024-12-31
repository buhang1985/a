package iih.mm.st.stockpriceadjust.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.st.stockpriceadjust.d.desc.StockPriceAdjustItmDODesc;
import java.math.BigDecimal;

/**
 * 库存调价明细 DO数据 
 * 
 */
public class StockPriceAdjustItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//库存调价明细主键
	public static final String ID_STPRIITM= "Id_stpriitm";
	//库存调价
	public static final String ID_STPRI= "Id_stpri";
	//结存外键
	public static final String ID_BL= "Id_bl";
	//序号
	public static final String SORTNO= "Sortno";
	//库存地点
	public static final String ID_WH= "Id_wh";
	//物品
	public static final String ID_MM= "Id_mm";
	//批次
	public static final String BATCH= "Batch";
	//失效期
	public static final String DATE_EXPI= "Date_expi";
	//唯一码
	public static final String ONLYCODE= "Onlycode";
	//零售包装单位
	public static final String ID_MMPKGU_SALES= "Id_mmpkgu_sales";
	//进价_零售包装单位
	public static final String PRI_ACT= "Pri_act";
	//新进价_零售包装单位
	public static final String PRI_NEW_ACT= "Pri_new_act";
	//原售价_零售包装单位
	public static final String PRI_OLD_SALES= "Pri_old_sales";
	//新价格_零售包装
	public static final String PRI_NEW_SALES= "Pri_new_sales";
	//结存数量_零售
	public static final String QUAN= "Quan";
	//描述
	public static final String DES= "Des";
	//是否调价
	public static final String FG_ADJUST= "Fg_adjust";
	//仓库名称
	public static final String WH_NAME= "Wh_name";
	//物品名称
	public static final String MM_NAME= "Mm_name";
	//物品规格
	public static final String MM_SPEC= "Mm_spec";
	//物品编码
	public static final String MM_CODE= "Mm_code";
	//包装单位名称
	public static final String MMPKGU_SALES_NAME= "Mmpkgu_sales_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 库存调价明细主键
	 * @return String
	 */
	public String getId_stpriitm() {
		return ((String) getAttrVal("Id_stpriitm"));
	}	
	/**
	 * 库存调价明细主键
	 * @param Id_stpriitm
	 */
	public void setId_stpriitm(String Id_stpriitm) {
		setAttrVal("Id_stpriitm", Id_stpriitm);
	}
	/**
	 * 库存调价
	 * @return String
	 */
	public String getId_stpri() {
		return ((String) getAttrVal("Id_stpri"));
	}	
	/**
	 * 库存调价
	 * @param Id_stpri
	 */
	public void setId_stpri(String Id_stpri) {
		setAttrVal("Id_stpri", Id_stpri);
	}
	/**
	 * 结存外键
	 * @return String
	 */
	public String getId_bl() {
		return ((String) getAttrVal("Id_bl"));
	}	
	/**
	 * 结存外键
	 * @param Id_bl
	 */
	public void setId_bl(String Id_bl) {
		setAttrVal("Id_bl", Id_bl);
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
	 * 库存地点
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	/**
	 * 库存地点
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
	 * 零售包装单位
	 * @return String
	 */
	public String getId_mmpkgu_sales() {
		return ((String) getAttrVal("Id_mmpkgu_sales"));
	}	
	/**
	 * 零售包装单位
	 * @param Id_mmpkgu_sales
	 */
	public void setId_mmpkgu_sales(String Id_mmpkgu_sales) {
		setAttrVal("Id_mmpkgu_sales", Id_mmpkgu_sales);
	}
	/**
	 * 进价_零售包装单位
	 * @return FDouble
	 */
	public FDouble getPri_act() {
		return ((FDouble) getAttrVal("Pri_act"));
	}	
	/**
	 * 进价_零售包装单位
	 * @param Pri_act
	 */
	public void setPri_act(FDouble Pri_act) {
		setAttrVal("Pri_act", Pri_act);
	}
	/**
	 * 新进价_零售包装单位
	 * @return FDouble
	 */
	public FDouble getPri_new_act() {
		return ((FDouble) getAttrVal("Pri_new_act"));
	}	
	/**
	 * 新进价_零售包装单位
	 * @param Pri_new_act
	 */
	public void setPri_new_act(FDouble Pri_new_act) {
		setAttrVal("Pri_new_act", Pri_new_act);
	}
	/**
	 * 原售价_零售包装单位
	 * @return FDouble
	 */
	public FDouble getPri_old_sales() {
		return ((FDouble) getAttrVal("Pri_old_sales"));
	}	
	/**
	 * 原售价_零售包装单位
	 * @param Pri_old_sales
	 */
	public void setPri_old_sales(FDouble Pri_old_sales) {
		setAttrVal("Pri_old_sales", Pri_old_sales);
	}
	/**
	 * 新价格_零售包装
	 * @return FDouble
	 */
	public FDouble getPri_new_sales() {
		return ((FDouble) getAttrVal("Pri_new_sales"));
	}	
	/**
	 * 新价格_零售包装
	 * @param Pri_new_sales
	 */
	public void setPri_new_sales(FDouble Pri_new_sales) {
		setAttrVal("Pri_new_sales", Pri_new_sales);
	}
	/**
	 * 结存数量_零售
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}	
	/**
	 * 结存数量_零售
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
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
	 * 是否调价
	 * @return FBoolean
	 */
	public FBoolean getFg_adjust() {
		return ((FBoolean) getAttrVal("Fg_adjust"));
	}	
	/**
	 * 是否调价
	 * @param Fg_adjust
	 */
	public void setFg_adjust(FBoolean Fg_adjust) {
		setAttrVal("Fg_adjust", Fg_adjust);
	}
	/**
	 * 仓库名称
	 * @return String
	 */
	public String getWh_name() {
		return ((String) getAttrVal("Wh_name"));
	}	
	/**
	 * 仓库名称
	 * @param Wh_name
	 */
	public void setWh_name(String Wh_name) {
		setAttrVal("Wh_name", Wh_name);
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
	 * 包装单位名称
	 * @return String
	 */
	public String getMmpkgu_sales_name() {
		return ((String) getAttrVal("Mmpkgu_sales_name"));
	}	
	/**
	 * 包装单位名称
	 * @param Mmpkgu_sales_name
	 */
	public void setMmpkgu_sales_name(String Mmpkgu_sales_name) {
		setAttrVal("Mmpkgu_sales_name", Mmpkgu_sales_name);
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
		return "Id_stpriitm";
	}
	
	@Override
	public String getTableName() {	  
		return "MM_ST_PRI_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(StockPriceAdjustItmDODesc.class);
	}
	
}