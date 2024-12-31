package iih.ems.einv.emda.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ems.einv.emda.d.desc.EmsDaItmDODesc;
import java.math.BigDecimal;

/**
 * 设备领用申请细目 DO数据 
 * 
 */
public class EmsDaItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//申请细目
	public static final String ID_APITM= "Id_apitm";
	//申请单主键
	public static final String ID_DA= "Id_da";
	//设备库存
	public static final String ID_EMBL= "Id_embl";
	//设备基本信息
	public static final String ID_EM= "Id_em";
	//申请数量
	public static final String REQ_NUM= "Req_num";
	//审核数量
	public static final String APP_NUM= "App_num";
	//备注
	public static final String DES= "Des";
	//设备名称
	public static final String EM_NAME= "Em_name";
	//设备编码
	public static final String EM_CODE= "Em_code";
	//分类树内码
	public static final String EMCA_INRCODE= "Emca_inrcode";
	//资产主键
	public static final String ID_CARD= "Id_card";
	//资产编号
	public static final String CARD_NO= "Card_no";
	//资产名称
	public static final String CARD_NAME= "Card_name";
	//规格
	public static final String SPECS= "Specs";
	//品牌名称
	public static final String BRAND_NAME= "Brand_name";
	//型号
	public static final String MODEL= "Model";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 申请细目
	 * @return String
	 */
	public String getId_apitm() {
		return ((String) getAttrVal("Id_apitm"));
	}	
	/**
	 * 申请细目
	 * @param Id_apitm
	 */
	public void setId_apitm(String Id_apitm) {
		setAttrVal("Id_apitm", Id_apitm);
	}
	/**
	 * 申请单主键
	 * @return String
	 */
	public String getId_da() {
		return ((String) getAttrVal("Id_da"));
	}	
	/**
	 * 申请单主键
	 * @param Id_da
	 */
	public void setId_da(String Id_da) {
		setAttrVal("Id_da", Id_da);
	}
	/**
	 * 设备库存
	 * @return String
	 */
	public String getId_embl() {
		return ((String) getAttrVal("Id_embl"));
	}	
	/**
	 * 设备库存
	 * @param Id_embl
	 */
	public void setId_embl(String Id_embl) {
		setAttrVal("Id_embl", Id_embl);
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
	 * 申请数量
	 * @return Integer
	 */
	public Integer getReq_num() {
		return ((Integer) getAttrVal("Req_num"));
	}	
	/**
	 * 申请数量
	 * @param Req_num
	 */
	public void setReq_num(Integer Req_num) {
		setAttrVal("Req_num", Req_num);
	}
	/**
	 * 审核数量
	 * @return Integer
	 */
	public Integer getApp_num() {
		return ((Integer) getAttrVal("App_num"));
	}	
	/**
	 * 审核数量
	 * @param App_num
	 */
	public void setApp_num(Integer App_num) {
		setAttrVal("App_num", App_num);
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
	 * 设备名称
	 * @return String
	 */
	public String getEm_name() {
		return ((String) getAttrVal("Em_name"));
	}	
	/**
	 * 设备名称
	 * @param Em_name
	 */
	public void setEm_name(String Em_name) {
		setAttrVal("Em_name", Em_name);
	}
	/**
	 * 设备编码
	 * @return String
	 */
	public String getEm_code() {
		return ((String) getAttrVal("Em_code"));
	}	
	/**
	 * 设备编码
	 * @param Em_code
	 */
	public void setEm_code(String Em_code) {
		setAttrVal("Em_code", Em_code);
	}
	/**
	 * 分类树内码
	 * @return String
	 */
	public String getEmca_inrcode() {
		return ((String) getAttrVal("Emca_inrcode"));
	}	
	/**
	 * 分类树内码
	 * @param Emca_inrcode
	 */
	public void setEmca_inrcode(String Emca_inrcode) {
		setAttrVal("Emca_inrcode", Emca_inrcode);
	}
	/**
	 * 资产主键
	 * @return String
	 */
	public String getId_card() {
		return ((String) getAttrVal("Id_card"));
	}	
	/**
	 * 资产主键
	 * @param Id_card
	 */
	public void setId_card(String Id_card) {
		setAttrVal("Id_card", Id_card);
	}
	/**
	 * 资产编号
	 * @return String
	 */
	public String getCard_no() {
		return ((String) getAttrVal("Card_no"));
	}	
	/**
	 * 资产编号
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
		return "Id_apitm";
	}
	
	@Override
	public String getTableName() {	  
		return "ems_da_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmsDaItmDODesc.class);
	}
	
}