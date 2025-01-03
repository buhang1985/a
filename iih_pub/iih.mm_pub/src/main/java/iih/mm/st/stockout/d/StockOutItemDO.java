package iih.mm.st.stockout.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.st.stockout.d.desc.StockOutItemDODesc;
import java.math.BigDecimal;

/**
 * 出库单明细 DO数据 
 * 
 */
public class StockOutItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//出库单明细主键
	public static final String ID_OUTITM= "Id_outitm";
	//出库单据主键
	public static final String ID_OUT= "Id_out";
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
	//零售包装单位
	public static final String ID_MMPKGU_SP= "Id_mmpkgu_sp";
	//数量_实际包装
	public static final String QUAN_ACTUAL= "Quan_actual";
	//供应商
	public static final String ID_SUP= "Id_sup";
	//批次
	public static final String BATCH= "Batch";
	//有效期
	public static final String DATE_EXPI= "Date_expi";
	//售价_实际单位
	public static final String PRI_SA= "Pri_sa";
	//批次售价_实际单位	
	public static final String PRI_SA_BATCH= "Pri_sa_batch";
	//入库价_实际单位
	public static final String PRI_ACT= "Pri_act";
	//金额_进价
	public static final String AMT= "Amt";
	//描述
	public static final String DES= "Des";
	//唯一码（高值耗材）
	public static final String ONLYCODE= "Onlycode";
	//实际扣率
	public static final String RATE_ACTUAL= "Rate_actual";
	//物品特性
	public static final String CHARACTER= "Character";
	//费用记账主键
	public static final String ID_SOURCE= "Id_source";
	//减免标识
	public static final String FG_FREE= "Fg_free";
	//可用量
	public static final String NUM_ACTUAL= "Num_actual";
	//领用量
	public static final String NUM_RECEIVE= "Num_receive";
	//零售价_零售单位
	public static final String PRI_SALE= "Pri_sale";
	//医疗服务
	public static final String SRV_NAME= "Srv_name";
	//物品名称
	public static final String MM_NAME= "Mm_name";
	//物品规格
	public static final String MM_SPEC= "Mm_spec";
	//是否批次管理
	public static final String MMFG_BATCH= "Mmfg_batch";
	//是否价格管理
	public static final String MMFG_PRICE= "Mmfg_price";
	//拼音
	public static final String MM_PYCODE= "Mm_pycode";
	//服务项目外键
	public static final String ID_SRV= "Id_srv";
	//物品编码
	public static final String MM_CODE= "Mm_code";
	//当前批准文号/注册号
	public static final String MM_APPRNO= "Mm_apprno";
	//货位名称
	public static final String LOC_NAME= "Loc_name";
	//货位编码
	public static final String LOC_CODE= "Loc_code";
	//货位拼音码
	public static final String LOC_PYCODE= "Loc_pycode";
	//包装单位名称
	public static final String ACPKGUNAME= "Acpkguname";
	//包装单位名称
	public static final String POPKGUNAME= "Popkguname";
	//供应商与厂商名称
	public static final String SUP_NAME= "Sup_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 出库单明细主键
	 * @return String
	 */
	public String getId_outitm() {
		return ((String) getAttrVal("Id_outitm"));
	}	
	/**
	 * 出库单明细主键
	 * @param Id_outitm
	 */
	public void setId_outitm(String Id_outitm) {
		setAttrVal("Id_outitm", Id_outitm);
	}
	/**
	 * 出库单据主键
	 * @return String
	 */
	public String getId_out() {
		return ((String) getAttrVal("Id_out"));
	}	
	/**
	 * 出库单据主键
	 * @param Id_out
	 */
	public void setId_out(String Id_out) {
		setAttrVal("Id_out", Id_out);
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
	 * 批次售价_实际单位	
	 * @return FDouble
	 */
	public FDouble getPri_sa_batch() {
		return ((FDouble) getAttrVal("Pri_sa_batch"));
	}	
	/**
	 * 批次售价_实际单位	
	 * @param Pri_sa_batch
	 */
	public void setPri_sa_batch(FDouble Pri_sa_batch) {
		setAttrVal("Pri_sa_batch", Pri_sa_batch);
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
	 * 金额_进价
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	/**
	 * 金额_进价
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
	 * 费用记账主键
	 * @return String
	 */
	public String getId_source() {
		return ((String) getAttrVal("Id_source"));
	}	
	/**
	 * 费用记账主键
	 * @param Id_source
	 */
	public void setId_source(String Id_source) {
		setAttrVal("Id_source", Id_source);
	}
	/**
	 * 减免标识
	 * @return FBoolean
	 */
	public FBoolean getFg_free() {
		return ((FBoolean) getAttrVal("Fg_free"));
	}	
	/**
	 * 减免标识
	 * @param Fg_free
	 */
	public void setFg_free(FBoolean Fg_free) {
		setAttrVal("Fg_free", Fg_free);
	}
	/**
	 * 可用量
	 * @return FDouble
	 */
	public FDouble getNum_actual() {
		return ((FDouble) getAttrVal("Num_actual"));
	}	
	/**
	 * 可用量
	 * @param Num_actual
	 */
	public void setNum_actual(FDouble Num_actual) {
		setAttrVal("Num_actual", Num_actual);
	}
	/**
	 * 领用量
	 * @return FDouble
	 */
	public FDouble getNum_receive() {
		return ((FDouble) getAttrVal("Num_receive"));
	}	
	/**
	 * 领用量
	 * @param Num_receive
	 */
	public void setNum_receive(FDouble Num_receive) {
		setAttrVal("Num_receive", Num_receive);
	}
	/**
	 * 零售价_零售单位
	 * @return FDouble
	 */
	public FDouble getPri_sale() {
		return ((FDouble) getAttrVal("Pri_sale"));
	}	
	/**
	 * 零售价_零售单位
	 * @param Pri_sale
	 */
	public void setPri_sale(FDouble Pri_sale) {
		setAttrVal("Pri_sale", Pri_sale);
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
	 * 是否批次管理
	 * @return FBoolean
	 */
	public FBoolean getMmfg_batch() {
		return ((FBoolean) getAttrVal("Mmfg_batch"));
	}	
	/**
	 * 是否批次管理
	 * @param Mmfg_batch
	 */
	public void setMmfg_batch(FBoolean Mmfg_batch) {
		setAttrVal("Mmfg_batch", Mmfg_batch);
	}
	/**
	 * 是否价格管理
	 * @return FBoolean
	 */
	public FBoolean getMmfg_price() {
		return ((FBoolean) getAttrVal("Mmfg_price"));
	}	
	/**
	 * 是否价格管理
	 * @param Mmfg_price
	 */
	public void setMmfg_price(FBoolean Mmfg_price) {
		setAttrVal("Mmfg_price", Mmfg_price);
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
		return "Id_outitm";
	}
	
	@Override
	public String getTableName() {	  
		return "MM_OUT_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(StockOutItemDODesc.class);
	}
	
}