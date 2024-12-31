package iih.ems.einv.eminsp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ems.einv.eminsp.d.desc.EmsInspItmDODesc;
import java.math.BigDecimal;

/**
 * 大型设备验收单细目 DO数据 
 * 
 */
public class EmsInspItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//验收单细项主键
	public static final String ID_INSPITM= "Id_inspitm";
	//验收单主键
	public static final String ID_INSP= "Id_insp";
	//设备基本信息
	public static final String ID_EM= "Id_em";
	//院内码
	public static final String INNERCODE= "Innercode";
	//单价
	public static final String PRICE= "Price";
	//数量
	public static final String NUM= "Num";
	//总金额
	public static final String AMT= "Amt";
	//厂商条码
	public static final String BARCODE= "Barcode";
	//生产厂商
	public static final String ID_FAC= "Id_fac";
	//设备编码
	public static final String CODE_EM= "Code_em";
	//设备名称
	public static final String NAME_EM= "Name_em";
	//规格
	public static final String SPECS= "Specs";
	//单位
	public static final String ID_UNIT= "Id_unit";
	//设备分类
	public static final String ID_EMCA= "Id_emca";
	//最新单价
	public static final String CURR_PRICE= "Curr_price";
	//品牌名称
	public static final String BRAND_NAME= "Brand_name";
	//英文名
	public static final String ENGLISH_NAME= "English_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 验收单细项主键
	 * @return String
	 */
	public String getId_inspitm() {
		return ((String) getAttrVal("Id_inspitm"));
	}	
	/**
	 * 验收单细项主键
	 * @param Id_inspitm
	 */
	public void setId_inspitm(String Id_inspitm) {
		setAttrVal("Id_inspitm", Id_inspitm);
	}
	/**
	 * 验收单主键
	 * @return String
	 */
	public String getId_insp() {
		return ((String) getAttrVal("Id_insp"));
	}	
	/**
	 * 验收单主键
	 * @param Id_insp
	 */
	public void setId_insp(String Id_insp) {
		setAttrVal("Id_insp", Id_insp);
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
	 * 单价
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}	
	/**
	 * 单价
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 数量
	 * @return Integer
	 */
	public Integer getNum() {
		return ((Integer) getAttrVal("Num"));
	}	
	/**
	 * 数量
	 * @param Num
	 */
	public void setNum(Integer Num) {
		setAttrVal("Num", Num);
	}
	/**
	 * 总金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	/**
	 * 总金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 厂商条码
	 * @return String
	 */
	public String getBarcode() {
		return ((String) getAttrVal("Barcode"));
	}	
	/**
	 * 厂商条码
	 * @param Barcode
	 */
	public void setBarcode(String Barcode) {
		setAttrVal("Barcode", Barcode);
	}
	/**
	 * 生产厂商
	 * @return String
	 */
	public String getId_fac() {
		return ((String) getAttrVal("Id_fac"));
	}	
	/**
	 * 生产厂商
	 * @param Id_fac
	 */
	public void setId_fac(String Id_fac) {
		setAttrVal("Id_fac", Id_fac);
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
	 * 单位
	 * @return String
	 */
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}	
	/**
	 * 单位
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
	 * 最新单价
	 * @return FDouble
	 */
	public FDouble getCurr_price() {
		return ((FDouble) getAttrVal("Curr_price"));
	}	
	/**
	 * 最新单价
	 * @param Curr_price
	 */
	public void setCurr_price(FDouble Curr_price) {
		setAttrVal("Curr_price", Curr_price);
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
	 * 英文名
	 * @return String
	 */
	public String getEnglish_name() {
		return ((String) getAttrVal("English_name"));
	}	
	/**
	 * 英文名
	 * @param English_name
	 */
	public void setEnglish_name(String English_name) {
		setAttrVal("English_name", English_name);
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
		return "Id_inspitm";
	}
	
	@Override
	public String getTableName() {	  
		return "Ems_Insp_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmsInspItmDODesc.class);
	}
	
}