package iih.pe.phm.pedietplan.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.pedietplan.d.desc.PeDietRecipeDODesc;
import java.math.BigDecimal;

/**
 * 体检饮食处方 DO数据 
 * 
 */
public class PeDietRecipeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检饮食处方主键标识
	public static final String ID_PEDIETRECIPE= "Id_pedietrecipe";
	//体检饮食计划ID
	public static final String ID_PEDIETPLAN= "Id_pedietplan";
	//饮食处方ID
	public static final String ID_PENARRATERECIPE= "Id_penarraterecipe";
	//处方内容
	public static final String PRESCRIPTION= "Prescription";
	//序号
	public static final String SORTNO= "Sortno";
	//编码
	public static final String CODE_RECIPE= "Code_recipe";
	//名称
	public static final String NAME_RECIPE= "Name_recipe";
	//处方内容
	public static final String PRESCRIPTION_RECIPE= "Prescription_recipe";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检饮食处方主键标识
	 * @return String
	 */
	public String getId_pedietrecipe() {
		return ((String) getAttrVal("Id_pedietrecipe"));
	}	
	/**
	 * 体检饮食处方主键标识
	 * @param Id_pedietrecipe
	 */
	public void setId_pedietrecipe(String Id_pedietrecipe) {
		setAttrVal("Id_pedietrecipe", Id_pedietrecipe);
	}
	/**
	 * 体检饮食计划ID
	 * @return String
	 */
	public String getId_pedietplan() {
		return ((String) getAttrVal("Id_pedietplan"));
	}	
	/**
	 * 体检饮食计划ID
	 * @param Id_pedietplan
	 */
	public void setId_pedietplan(String Id_pedietplan) {
		setAttrVal("Id_pedietplan", Id_pedietplan);
	}
	/**
	 * 饮食处方ID
	 * @return String
	 */
	public String getId_penarraterecipe() {
		return ((String) getAttrVal("Id_penarraterecipe"));
	}	
	/**
	 * 饮食处方ID
	 * @param Id_penarraterecipe
	 */
	public void setId_penarraterecipe(String Id_penarraterecipe) {
		setAttrVal("Id_penarraterecipe", Id_penarraterecipe);
	}
	/**
	 * 处方内容
	 * @return String
	 */
	public String getPrescription() {
		return ((String) getAttrVal("Prescription"));
	}	
	/**
	 * 处方内容
	 * @param Prescription
	 */
	public void setPrescription(String Prescription) {
		setAttrVal("Prescription", Prescription);
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
	 * 编码
	 * @return String
	 */
	public String getCode_recipe() {
		return ((String) getAttrVal("Code_recipe"));
	}	
	/**
	 * 编码
	 * @param Code_recipe
	 */
	public void setCode_recipe(String Code_recipe) {
		setAttrVal("Code_recipe", Code_recipe);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_recipe() {
		return ((String) getAttrVal("Name_recipe"));
	}	
	/**
	 * 名称
	 * @param Name_recipe
	 */
	public void setName_recipe(String Name_recipe) {
		setAttrVal("Name_recipe", Name_recipe);
	}
	/**
	 * 处方内容
	 * @return String
	 */
	public String getPrescription_recipe() {
		return ((String) getAttrVal("Prescription_recipe"));
	}	
	/**
	 * 处方内容
	 * @param Prescription_recipe
	 */
	public void setPrescription_recipe(String Prescription_recipe) {
		setAttrVal("Prescription_recipe", Prescription_recipe);
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
		return "Id_pedietrecipe";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_pedietrecipe";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeDietRecipeDODesc.class);
	}
	
}