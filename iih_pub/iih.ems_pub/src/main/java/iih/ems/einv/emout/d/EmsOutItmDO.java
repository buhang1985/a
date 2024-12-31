package iih.ems.einv.emout.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ems.einv.emout.d.desc.EmsOutItmDODesc;
import java.math.BigDecimal;

/**
 * 设备出库单明细 DO数据 
 * 
 */
public class EmsOutItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//出库单明细流水号
	public static final String ID_OUTITEM= "Id_outitem";
	//出库单号
	public static final String ID_OUT= "Id_out";
	//资产卡主键
	public static final String ID_CARD= "Id_card";
	//资产卡号
	public static final String CARD_NO= "Card_no";
	//资产名称
	public static final String CARD_NAME= "Card_name";
	//设备编号
	public static final String ID_EM= "Id_em";
	//出厂编号
	public static final String FAC_CODE= "Fac_code";
	//生产日期
	public static final String DT_FAC= "Dt_fac";
	//出库数量
	public static final String OUT_NUM= "Out_num";
	//单价
	public static final String BUY_PRICE= "Buy_price";
	//出库总金额
	public static final String COST= "Cost";
	//已折旧月份
	public static final String LESS_MONTH= "Less_month";
	//折旧年限
	public static final String DE_YEAR= "De_year";
	//发票号码
	public static final String INV_NO= "Inv_no";
	//凭证号码
	public static final String VOUCHER_NO= "Voucher_no";
	//品牌名称
	public static final String BRAND_NAME= "Brand_name";
	//是否新设备
	public static final String FG_NEW= "Fg_new";
	//批次号
	public static final String BATCH= "Batch";
	//是否固定资产
	public static final String FG_FIXED= "Fg_fixed";
	//使用年限
	public static final String USEFULLIFE= "Usefullife";
	//备注
	public static final String DES= "Des";
	//条码是否已经打印
	public static final String FG_PRINTED= "Fg_printed";
	//对应库存id
	public static final String ID_BL= "Id_bl";
	//树内码
	public static final String EMCA_INRCODE= "Emca_inrcode";
	//分类编号
	public static final String ID_EMCA= "Id_emca";
	//设备名称
	public static final String NAME_EM= "Name_em";
	//规格
	public static final String SPECS= "Specs";
	//型号
	public static final String MODEL= "Model";
	//名称
	public static final String NAME_EMCA= "Name_emca";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 出库单明细流水号
	 * @return String
	 */
	public String getId_outitem() {
		return ((String) getAttrVal("Id_outitem"));
	}	
	/**
	 * 出库单明细流水号
	 * @param Id_outitem
	 */
	public void setId_outitem(String Id_outitem) {
		setAttrVal("Id_outitem", Id_outitem);
	}
	/**
	 * 出库单号
	 * @return String
	 */
	public String getId_out() {
		return ((String) getAttrVal("Id_out"));
	}	
	/**
	 * 出库单号
	 * @param Id_out
	 */
	public void setId_out(String Id_out) {
		setAttrVal("Id_out", Id_out);
	}
	/**
	 * 资产卡主键
	 * @return String
	 */
	public String getId_card() {
		return ((String) getAttrVal("Id_card"));
	}	
	/**
	 * 资产卡主键
	 * @param Id_card
	 */
	public void setId_card(String Id_card) {
		setAttrVal("Id_card", Id_card);
	}
	/**
	 * 资产卡号
	 * @return String
	 */
	public String getCard_no() {
		return ((String) getAttrVal("Card_no"));
	}	
	/**
	 * 资产卡号
	 * @param Card_no
	 */
	public void setCard_no(String Card_no) {
		setAttrVal("Card_no", Card_no);
	}
	/**
	 * 资产名称
	 * @return String
	 */
	public String getCard_name() {
		return ((String) getAttrVal("Card_name"));
	}	
	/**
	 * 资产名称
	 * @param Card_name
	 */
	public void setCard_name(String Card_name) {
		setAttrVal("Card_name", Card_name);
	}
	/**
	 * 设备编号
	 * @return String
	 */
	public String getId_em() {
		return ((String) getAttrVal("Id_em"));
	}	
	/**
	 * 设备编号
	 * @param Id_em
	 */
	public void setId_em(String Id_em) {
		setAttrVal("Id_em", Id_em);
	}
	/**
	 * 出厂编号
	 * @return String
	 */
	public String getFac_code() {
		return ((String) getAttrVal("Fac_code"));
	}	
	/**
	 * 出厂编号
	 * @param Fac_code
	 */
	public void setFac_code(String Fac_code) {
		setAttrVal("Fac_code", Fac_code);
	}
	/**
	 * 生产日期
	 * @return FDate
	 */
	public FDate getDt_fac() {
		return ((FDate) getAttrVal("Dt_fac"));
	}	
	/**
	 * 生产日期
	 * @param Dt_fac
	 */
	public void setDt_fac(FDate Dt_fac) {
		setAttrVal("Dt_fac", Dt_fac);
	}
	/**
	 * 出库数量
	 * @return Integer
	 */
	public Integer getOut_num() {
		return ((Integer) getAttrVal("Out_num"));
	}	
	/**
	 * 出库数量
	 * @param Out_num
	 */
	public void setOut_num(Integer Out_num) {
		setAttrVal("Out_num", Out_num);
	}
	/**
	 * 单价
	 * @return FDouble
	 */
	public FDouble getBuy_price() {
		return ((FDouble) getAttrVal("Buy_price"));
	}	
	/**
	 * 单价
	 * @param Buy_price
	 */
	public void setBuy_price(FDouble Buy_price) {
		setAttrVal("Buy_price", Buy_price);
	}
	/**
	 * 出库总金额
	 * @return FDouble
	 */
	public FDouble getCost() {
		return ((FDouble) getAttrVal("Cost"));
	}	
	/**
	 * 出库总金额
	 * @param Cost
	 */
	public void setCost(FDouble Cost) {
		setAttrVal("Cost", Cost);
	}
	/**
	 * 已折旧月份
	 * @return Integer
	 */
	public Integer getLess_month() {
		return ((Integer) getAttrVal("Less_month"));
	}	
	/**
	 * 已折旧月份
	 * @param Less_month
	 */
	public void setLess_month(Integer Less_month) {
		setAttrVal("Less_month", Less_month);
	}
	/**
	 * 折旧年限
	 * @return Integer
	 */
	public Integer getDe_year() {
		return ((Integer) getAttrVal("De_year"));
	}	
	/**
	 * 折旧年限
	 * @param De_year
	 */
	public void setDe_year(Integer De_year) {
		setAttrVal("De_year", De_year);
	}
	/**
	 * 发票号码
	 * @return String
	 */
	public String getInv_no() {
		return ((String) getAttrVal("Inv_no"));
	}	
	/**
	 * 发票号码
	 * @param Inv_no
	 */
	public void setInv_no(String Inv_no) {
		setAttrVal("Inv_no", Inv_no);
	}
	/**
	 * 凭证号码
	 * @return String
	 */
	public String getVoucher_no() {
		return ((String) getAttrVal("Voucher_no"));
	}	
	/**
	 * 凭证号码
	 * @param Voucher_no
	 */
	public void setVoucher_no(String Voucher_no) {
		setAttrVal("Voucher_no", Voucher_no);
	}
	/**
	 * 品牌名称
	 * @return String
	 */
	public String getBrand_name() {
		return ((String) getAttrVal("Brand_name"));
	}	
	/**
	 * 品牌名称
	 * @param Brand_name
	 */
	public void setBrand_name(String Brand_name) {
		setAttrVal("Brand_name", Brand_name);
	}
	/**
	 * 是否新设备
	 * @return FBoolean
	 */
	public FBoolean getFg_new() {
		return ((FBoolean) getAttrVal("Fg_new"));
	}	
	/**
	 * 是否新设备
	 * @param Fg_new
	 */
	public void setFg_new(FBoolean Fg_new) {
		setAttrVal("Fg_new", Fg_new);
	}
	/**
	 * 批次号
	 * @return String
	 */
	public String getBatch() {
		return ((String) getAttrVal("Batch"));
	}	
	/**
	 * 批次号
	 * @param Batch
	 */
	public void setBatch(String Batch) {
		setAttrVal("Batch", Batch);
	}
	/**
	 * 是否固定资产
	 * @return FBoolean
	 */
	public FBoolean getFg_fixed() {
		return ((FBoolean) getAttrVal("Fg_fixed"));
	}	
	/**
	 * 是否固定资产
	 * @param Fg_fixed
	 */
	public void setFg_fixed(FBoolean Fg_fixed) {
		setAttrVal("Fg_fixed", Fg_fixed);
	}
	/**
	 * 使用年限
	 * @return Integer
	 */
	public Integer getUsefullife() {
		return ((Integer) getAttrVal("Usefullife"));
	}	
	/**
	 * 使用年限
	 * @param Usefullife
	 */
	public void setUsefullife(Integer Usefullife) {
		setAttrVal("Usefullife", Usefullife);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 备注
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 条码是否已经打印
	 * @return FBoolean
	 */
	public FBoolean getFg_printed() {
		return ((FBoolean) getAttrVal("Fg_printed"));
	}	
	/**
	 * 条码是否已经打印
	 * @param Fg_printed
	 */
	public void setFg_printed(FBoolean Fg_printed) {
		setAttrVal("Fg_printed", Fg_printed);
	}
	/**
	 * 对应库存id
	 * @return String
	 */
	public String getId_bl() {
		return ((String) getAttrVal("Id_bl"));
	}	
	/**
	 * 对应库存id
	 * @param Id_bl
	 */
	public void setId_bl(String Id_bl) {
		setAttrVal("Id_bl", Id_bl);
	}
	/**
	 * 树内码
	 * @return String
	 */
	public String getEmca_inrcode() {
		return ((String) getAttrVal("Emca_inrcode"));
	}	
	/**
	 * 树内码
	 * @param Emca_inrcode
	 */
	public void setEmca_inrcode(String Emca_inrcode) {
		setAttrVal("Emca_inrcode", Emca_inrcode);
	}
	/**
	 * 分类编号
	 * @return String
	 */
	public String getId_emca() {
		return ((String) getAttrVal("Id_emca"));
	}	
	/**
	 * 分类编号
	 * @param Id_emca
	 */
	public void setId_emca(String Id_emca) {
		setAttrVal("Id_emca", Id_emca);
	}
	/**
	 * 设备名称
	 * @return String
	 */
	public String getName_em() {
		return ((String) getAttrVal("Name_em"));
	}	
	/**
	 * 设备名称
	 * @param Name_em
	 */
	public void setName_em(String Name_em) {
		setAttrVal("Name_em", Name_em);
	}
	/**
	 * 规格
	 * @return String
	 */
	public String getSpecs() {
		return ((String) getAttrVal("Specs"));
	}	
	/**
	 * 规格
	 * @param Specs
	 */
	public void setSpecs(String Specs) {
		setAttrVal("Specs", Specs);
	}
	/**
	 * 型号
	 * @return String
	 */
	public String getModel() {
		return ((String) getAttrVal("Model"));
	}	
	/**
	 * 型号
	 * @param Model
	 */
	public void setModel(String Model) {
		setAttrVal("Model", Model);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_emca() {
		return ((String) getAttrVal("Name_emca"));
	}	
	/**
	 * 名称
	 * @param Name_emca
	 */
	public void setName_emca(String Name_emca) {
		setAttrVal("Name_emca", Name_emca);
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
		return "Id_outitem";
	}
	
	@Override
	public String getTableName() {	  
		return "ems_out_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmsOutItmDODesc.class);
	}
	
}