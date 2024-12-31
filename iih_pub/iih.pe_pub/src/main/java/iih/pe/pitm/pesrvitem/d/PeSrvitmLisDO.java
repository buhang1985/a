package iih.pe.pitm.pesrvitem.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.pesrvitem.d.desc.PeSrvitmLisDODesc;
import java.math.BigDecimal;

/**
 * 体检结果LIS对应 DO数据 
 * 
 */
public class PeSrvitmLisDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检结果检验对应主键标识
	public static final String ID_PEITMLIS= "Id_peitmlis";
	//体检结果ID
	public static final String ID_PESRVITEM= "Id_pesrvitem";
	//检验系统项目ID
	public static final String ID_PEITFLISITM= "Id_peitflisitm";
	//结果编码
	public static final String CODE_ITEM= "Code_item";
	//检验项目编码
	public static final String CODE_LIS= "Code_lis";
	//编码
	public static final String ITEM_CODE= "Item_code";
	//名称
	public static final String ITEM_NAME= "Item_name";
	//缩写
	public static final String ITEM_ABBR= "Item_abbr";
	//标本名称
	public static final String SAMPLE_NAME= "Sample_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检结果检验对应主键标识
	 * @return String
	 */
	public String getId_peitmlis() {
		return ((String) getAttrVal("Id_peitmlis"));
	}	
	/**
	 * 体检结果检验对应主键标识
	 * @param Id_peitmlis
	 */
	public void setId_peitmlis(String Id_peitmlis) {
		setAttrVal("Id_peitmlis", Id_peitmlis);
	}
	/**
	 * 体检结果ID
	 * @return String
	 */
	public String getId_pesrvitem() {
		return ((String) getAttrVal("Id_pesrvitem"));
	}	
	/**
	 * 体检结果ID
	 * @param Id_pesrvitem
	 */
	public void setId_pesrvitem(String Id_pesrvitem) {
		setAttrVal("Id_pesrvitem", Id_pesrvitem);
	}
	/**
	 * 检验系统项目ID
	 * @return String
	 */
	public String getId_peitflisitm() {
		return ((String) getAttrVal("Id_peitflisitm"));
	}	
	/**
	 * 检验系统项目ID
	 * @param Id_peitflisitm
	 */
	public void setId_peitflisitm(String Id_peitflisitm) {
		setAttrVal("Id_peitflisitm", Id_peitflisitm);
	}
	/**
	 * 结果编码
	 * @return String
	 */
	public String getCode_item() {
		return ((String) getAttrVal("Code_item"));
	}	
	/**
	 * 结果编码
	 * @param Code_item
	 */
	public void setCode_item(String Code_item) {
		setAttrVal("Code_item", Code_item);
	}
	/**
	 * 检验项目编码
	 * @return String
	 */
	public String getCode_lis() {
		return ((String) getAttrVal("Code_lis"));
	}	
	/**
	 * 检验项目编码
	 * @param Code_lis
	 */
	public void setCode_lis(String Code_lis) {
		setAttrVal("Code_lis", Code_lis);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getItem_code() {
		return ((String) getAttrVal("Item_code"));
	}	
	/**
	 * 编码
	 * @param Item_code
	 */
	public void setItem_code(String Item_code) {
		setAttrVal("Item_code", Item_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getItem_name() {
		return ((String) getAttrVal("Item_name"));
	}	
	/**
	 * 名称
	 * @param Item_name
	 */
	public void setItem_name(String Item_name) {
		setAttrVal("Item_name", Item_name);
	}
	/**
	 * 缩写
	 * @return String
	 */
	public String getItem_abbr() {
		return ((String) getAttrVal("Item_abbr"));
	}	
	/**
	 * 缩写
	 * @param Item_abbr
	 */
	public void setItem_abbr(String Item_abbr) {
		setAttrVal("Item_abbr", Item_abbr);
	}
	/**
	 * 标本名称
	 * @return String
	 */
	public String getSample_name() {
		return ((String) getAttrVal("Sample_name"));
	}	
	/**
	 * 标本名称
	 * @param Sample_name
	 */
	public void setSample_name(String Sample_name) {
		setAttrVal("Sample_name", Sample_name);
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
		return "Id_peitmlis";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_peitmlis";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeSrvitmLisDODesc.class);
	}
	
}