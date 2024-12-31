package iih.pe.pitm.penarraterecipe.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.penarraterecipe.d.desc.PeNarrateRecipeItmDODesc;
import java.math.BigDecimal;

/**
 * 体检叙述型营养处方内容 DO数据 
 * 
 */
public class PeNarrateRecipeItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检叙述型营养处方明细主键标识
	public static final String ID_PENARRATERECIPEITM= "Id_penarraterecipeitm";
	//体检叙述型营养处方ID
	public static final String ID_PENARRATERECIPE= "Id_penarraterecipe";
	//食物类别编码
	public static final String SD_FOODCA= "Sd_foodca";
	//食物类别
	public static final String ID_FOODCA= "Id_foodca";
	//推荐食物
	public static final String RECFOOD= "Recfood";
	//推荐量
	public static final String RECQTY= "Recqty";
	//禁忌食物
	public static final String BANFOOD= "Banfood";
	//次序
	public static final String SORTNO= "Sortno";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检叙述型营养处方明细主键标识
	 * @return String
	 */
	public String getId_penarraterecipeitm() {
		return ((String) getAttrVal("Id_penarraterecipeitm"));
	}	
	/**
	 * 体检叙述型营养处方明细主键标识
	 * @param Id_penarraterecipeitm
	 */
	public void setId_penarraterecipeitm(String Id_penarraterecipeitm) {
		setAttrVal("Id_penarraterecipeitm", Id_penarraterecipeitm);
	}
	/**
	 * 体检叙述型营养处方ID
	 * @return String
	 */
	public String getId_penarraterecipe() {
		return ((String) getAttrVal("Id_penarraterecipe"));
	}	
	/**
	 * 体检叙述型营养处方ID
	 * @param Id_penarraterecipe
	 */
	public void setId_penarraterecipe(String Id_penarraterecipe) {
		setAttrVal("Id_penarraterecipe", Id_penarraterecipe);
	}
	/**
	 * 食物类别编码
	 * @return String
	 */
	public String getSd_foodca() {
		return ((String) getAttrVal("Sd_foodca"));
	}	
	/**
	 * 食物类别编码
	 * @param Sd_foodca
	 */
	public void setSd_foodca(String Sd_foodca) {
		setAttrVal("Sd_foodca", Sd_foodca);
	}
	/**
	 * 食物类别
	 * @return String
	 */
	public String getId_foodca() {
		return ((String) getAttrVal("Id_foodca"));
	}	
	/**
	 * 食物类别
	 * @param Id_foodca
	 */
	public void setId_foodca(String Id_foodca) {
		setAttrVal("Id_foodca", Id_foodca);
	}
	/**
	 * 推荐食物
	 * @return String
	 */
	public String getRecfood() {
		return ((String) getAttrVal("Recfood"));
	}	
	/**
	 * 推荐食物
	 * @param Recfood
	 */
	public void setRecfood(String Recfood) {
		setAttrVal("Recfood", Recfood);
	}
	/**
	 * 推荐量
	 * @return String
	 */
	public String getRecqty() {
		return ((String) getAttrVal("Recqty"));
	}	
	/**
	 * 推荐量
	 * @param Recqty
	 */
	public void setRecqty(String Recqty) {
		setAttrVal("Recqty", Recqty);
	}
	/**
	 * 禁忌食物
	 * @return String
	 */
	public String getBanfood() {
		return ((String) getAttrVal("Banfood"));
	}	
	/**
	 * 禁忌食物
	 * @param Banfood
	 */
	public void setBanfood(String Banfood) {
		setAttrVal("Banfood", Banfood);
	}
	/**
	 * 次序
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 次序
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
		return "Id_penarraterecipeitm";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_penarraterecipeitm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeNarrateRecipeItmDODesc.class);
	}
	
}