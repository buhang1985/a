package iih.ems.einv.emin.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ems.einv.emin.d.desc.EmsInItmDODesc;
import java.math.BigDecimal;

/**
 * 设备入库细目 DO数据 
 * 
 */
public class EmsInItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//入库单细目
	public static final String ID_INITM= "Id_initm";
	//入库单
	public static final String ID_IN= "Id_in";
	//设备基本信息
	public static final String ID_EM= "Id_em";
	//院内码
	public static final String INNERCODE= "Innercode";
	//首次入库库存ID
	public static final String ID_EMBL= "Id_embl";
	//出厂编号
	public static final String BARCODE= "Barcode";
	//生产日期
	public static final String DT_FAC= "Dt_fac";
	//入库数量
	public static final String IN_NUM= "In_num";
	//单价
	public static final String BUY_PRICE= "Buy_price";
	//购买总金额
	public static final String BUY_COST= "Buy_cost";
	//已折旧月份
	public static final String LESS_MONTH= "Less_month";
	//折旧年限
	public static final String DE_YEAR= "De_year";
	//发票号码
	public static final String INV_NO= "Inv_no";
	//发票日期
	public static final String DT_INV= "Dt_inv";
	//凭证号码
	public static final String VOUCHER_NO= "Voucher_no";
	//产地
	public static final String PRODUCING_AREA= "Producing_area";
	//品牌名称
	public static final String BRAND_NAME= "Brand_name";
	//是否新设备
	public static final String FG_NEW= "Fg_new";
	//是否需要付款
	public static final String FG_PAY= "Fg_pay";
	//供货商结算流水号
	public static final String ID_PAY= "Id_pay";
	//卡片流水号
	public static final String ID_CARD= "Id_card";
	//是否固定资产
	public static final String FG_FIXED= "Fg_fixed";
	//使用年限
	public static final String USEFULLIFE= "Usefullife";
	//凭证字
	public static final String VOUCHER_WORD= "Voucher_word";
	//备注
	public static final String DES= "Des";
	//条码是否已经打印
	public static final String FG_PRINTED= "Fg_printed";
	//包装单位
	public static final String ID_UNIT= "Id_unit";
	//设备分类
	public static final String ID_EMCA= "Id_emca";
	//批次
	public static final String BATCH= "Batch";
	//分类树码
	public static final String EMCA_INRCODE= "Emca_inrcode";
	//原入库数量
	public static final String RIN_NUM= "Rin_num";
	//已退数量
	public static final String RTNED_NUM= "Rtned_num";
	//原入库单明细
	public static final String ID_RESITM= "Id_resitm";
	//设备名称
	public static final String NAME_EM= "Name_em";
	//设备编码
	public static final String CODE_EM= "Code_em";
	//规格
	public static final String SPECS_EM= "Specs_em";
	//英文名
	public static final String ENGLISH_NAME_C= "English_name_c";
	//卡片名称
	public static final String NAME_CARD= "Name_card";
	//卡片编号
	public static final String CARD_NO= "Card_no";
	//包装单位类型编码
	public static final String CODE_UNIT= "Code_unit";
	//包装单位类型名称
	public static final String NAME_UNIT= "Name_unit";
	//名称
	public static final String NAME_EMCA= "Name_emca";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 入库单细目
	 * @return String
	 */
	public String getId_initm() {
		return ((String) getAttrVal("Id_initm"));
	}	
	/**
	 * 入库单细目
	 * @param Id_initm
	 */
	public void setId_initm(String Id_initm) {
		setAttrVal("Id_initm", Id_initm);
	}
	/**
	 * 入库单
	 * @return String
	 */
	public String getId_in() {
		return ((String) getAttrVal("Id_in"));
	}	
	/**
	 * 入库单
	 * @param Id_in
	 */
	public void setId_in(String Id_in) {
		setAttrVal("Id_in", Id_in);
	}
	/**
	 * 设备基本信息
	 * @return String
	 */
	public String getId_em() {
		return ((String) getAttrVal("Id_em"));
	}	
	/**
	 * 设备基本信息
	 * @param Id_em
	 */
	public void setId_em(String Id_em) {
		setAttrVal("Id_em", Id_em);
	}
	/**
	 * 院内码
	 * @return String
	 */
	public String getInnercode() {
		return ((String) getAttrVal("Innercode"));
	}	
	/**
	 * 院内码
	 * @param Innercode
	 */
	public void setInnercode(String Innercode) {
		setAttrVal("Innercode", Innercode);
	}
	/**
	 * 首次入库库存ID
	 * @return String
	 */
	public String getId_embl() {
		return ((String) getAttrVal("Id_embl"));
	}	
	/**
	 * 首次入库库存ID
	 * @param Id_embl
	 */
	public void setId_embl(String Id_embl) {
		setAttrVal("Id_embl", Id_embl);
	}
	/**
	 * 出厂编号
	 * @return String
	 */
	public String getBarcode() {
		return ((String) getAttrVal("Barcode"));
	}	
	/**
	 * 出厂编号
	 * @param Barcode
	 */
	public void setBarcode(String Barcode) {
		setAttrVal("Barcode", Barcode);
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
	 * 入库数量
	 * @return Integer
	 */
	public Integer getIn_num() {
		return ((Integer) getAttrVal("In_num"));
	}	
	/**
	 * 入库数量
	 * @param In_num
	 */
	public void setIn_num(Integer In_num) {
		setAttrVal("In_num", In_num);
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
	 * 购买总金额
	 * @return FDouble
	 */
	public FDouble getBuy_cost() {
		return ((FDouble) getAttrVal("Buy_cost"));
	}	
	/**
	 * 购买总金额
	 * @param Buy_cost
	 */
	public void setBuy_cost(FDouble Buy_cost) {
		setAttrVal("Buy_cost", Buy_cost);
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
	 * 发票日期
	 * @return FDate
	 */
	public FDate getDt_inv() {
		return ((FDate) getAttrVal("Dt_inv"));
	}	
	/**
	 * 发票日期
	 * @param Dt_inv
	 */
	public void setDt_inv(FDate Dt_inv) {
		setAttrVal("Dt_inv", Dt_inv);
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
	 * 产地
	 * @return String
	 */
	public String getProducing_area() {
		return ((String) getAttrVal("Producing_area"));
	}	
	/**
	 * 产地
	 * @param Producing_area
	 */
	public void setProducing_area(String Producing_area) {
		setAttrVal("Producing_area", Producing_area);
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
	 * 是否需要付款
	 * @return FBoolean
	 */
	public FBoolean getFg_pay() {
		return ((FBoolean) getAttrVal("Fg_pay"));
	}	
	/**
	 * 是否需要付款
	 * @param Fg_pay
	 */
	public void setFg_pay(FBoolean Fg_pay) {
		setAttrVal("Fg_pay", Fg_pay);
	}
	/**
	 * 供货商结算流水号
	 * @return String
	 */
	public String getId_pay() {
		return ((String) getAttrVal("Id_pay"));
	}	
	/**
	 * 供货商结算流水号
	 * @param Id_pay
	 */
	public void setId_pay(String Id_pay) {
		setAttrVal("Id_pay", Id_pay);
	}
	/**
	 * 卡片流水号
	 * @return String
	 */
	public String getId_card() {
		return ((String) getAttrVal("Id_card"));
	}	
	/**
	 * 卡片流水号
	 * @param Id_card
	 */
	public void setId_card(String Id_card) {
		setAttrVal("Id_card", Id_card);
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
	 * @return String
	 */
	public String getUsefullife() {
		return ((String) getAttrVal("Usefullife"));
	}	
	/**
	 * 使用年限
	 * @param Usefullife
	 */
	public void setUsefullife(String Usefullife) {
		setAttrVal("Usefullife", Usefullife);
	}
	/**
	 * 凭证字
	 * @return String
	 */
	public String getVoucher_word() {
		return ((String) getAttrVal("Voucher_word"));
	}	
	/**
	 * 凭证字
	 * @param Voucher_word
	 */
	public void setVoucher_word(String Voucher_word) {
		setAttrVal("Voucher_word", Voucher_word);
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
	 * 包装单位
	 * @return String
	 */
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}	
	/**
	 * 包装单位
	 * @param Id_unit
	 */
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	/**
	 * 设备分类
	 * @return String
	 */
	public String getId_emca() {
		return ((String) getAttrVal("Id_emca"));
	}	
	/**
	 * 设备分类
	 * @param Id_emca
	 */
	public void setId_emca(String Id_emca) {
		setAttrVal("Id_emca", Id_emca);
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
	 * 分类树码
	 * @return String
	 */
	public String getEmca_inrcode() {
		return ((String) getAttrVal("Emca_inrcode"));
	}	
	/**
	 * 分类树码
	 * @param Emca_inrcode
	 */
	public void setEmca_inrcode(String Emca_inrcode) {
		setAttrVal("Emca_inrcode", Emca_inrcode);
	}
	/**
	 * 原入库数量
	 * @return Integer
	 */
	public Integer getRin_num() {
		return ((Integer) getAttrVal("Rin_num"));
	}	
	/**
	 * 原入库数量
	 * @param Rin_num
	 */
	public void setRin_num(Integer Rin_num) {
		setAttrVal("Rin_num", Rin_num);
	}
	/**
	 * 已退数量
	 * @return Integer
	 */
	public Integer getRtned_num() {
		return ((Integer) getAttrVal("Rtned_num"));
	}	
	/**
	 * 已退数量
	 * @param Rtned_num
	 */
	public void setRtned_num(Integer Rtned_num) {
		setAttrVal("Rtned_num", Rtned_num);
	}
	/**
	 * 原入库单明细
	 * @return String
	 */
	public String getId_resitm() {
		return ((String) getAttrVal("Id_resitm"));
	}	
	/**
	 * 原入库单明细
	 * @param Id_resitm
	 */
	public void setId_resitm(String Id_resitm) {
		setAttrVal("Id_resitm", Id_resitm);
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
	 * 设备编码
	 * @return String
	 */
	public String getCode_em() {
		return ((String) getAttrVal("Code_em"));
	}	
	/**
	 * 设备编码
	 * @param Code_em
	 */
	public void setCode_em(String Code_em) {
		setAttrVal("Code_em", Code_em);
	}
	/**
	 * 规格
	 * @return String
	 */
	public String getSpecs_em() {
		return ((String) getAttrVal("Specs_em"));
	}	
	/**
	 * 规格
	 * @param Specs_em
	 */
	public void setSpecs_em(String Specs_em) {
		setAttrVal("Specs_em", Specs_em);
	}
	/**
	 * 英文名
	 * @return String
	 */
	public String getEnglish_name_c() {
		return ((String) getAttrVal("English_name_c"));
	}	
	/**
	 * 英文名
	 * @param English_name_c
	 */
	public void setEnglish_name_c(String English_name_c) {
		setAttrVal("English_name_c", English_name_c);
	}
	/**
	 * 卡片名称
	 * @return String
	 */
	public String getName_card() {
		return ((String) getAttrVal("Name_card"));
	}	
	/**
	 * 卡片名称
	 * @param Name_card
	 */
	public void setName_card(String Name_card) {
		setAttrVal("Name_card", Name_card);
	}
	/**
	 * 卡片编号
	 * @return String
	 */
	public String getCard_no() {
		return ((String) getAttrVal("Card_no"));
	}	
	/**
	 * 卡片编号
	 * @param Card_no
	 */
	public void setCard_no(String Card_no) {
		setAttrVal("Card_no", Card_no);
	}
	/**
	 * 包装单位类型编码
	 * @return String
	 */
	public String getCode_unit() {
		return ((String) getAttrVal("Code_unit"));
	}	
	/**
	 * 包装单位类型编码
	 * @param Code_unit
	 */
	public void setCode_unit(String Code_unit) {
		setAttrVal("Code_unit", Code_unit);
	}
	/**
	 * 包装单位类型名称
	 * @return String
	 */
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}	
	/**
	 * 包装单位类型名称
	 * @param Name_unit
	 */
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
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
		return "Id_initm";
	}
	
	@Override
	public String getTableName() {	  
		return "ems_in_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmsInItmDODesc.class);
	}
	
}