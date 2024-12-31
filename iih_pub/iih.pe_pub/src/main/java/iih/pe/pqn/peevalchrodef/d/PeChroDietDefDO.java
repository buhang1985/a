package iih.pe.pqn.peevalchrodef.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.peevalchrodef.d.desc.PeChroDietDefDODesc;
import java.math.BigDecimal;

/**
 * 体检慢性病饮食处方定义 DO数据 
 * 
 */
public class PeChroDietDefDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检慢性病关联饮食处方定义主键标识
	public static final String ID_PECHRODIETDEF= "Id_pechrodietdef";
	//体检慢性病定义ID
	public static final String ID_PEEVALCHRODEF= "Id_peevalchrodef";
	//体检叙述型营养处方ID
	public static final String ID_PENARRATERECIPE= "Id_penarraterecipe";
	//编码
	public static final String CODE_DIET= "Code_diet";
	//名称
	public static final String NAME_DIET= "Name_diet";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检慢性病关联饮食处方定义主键标识
	 * @return String
	 */
	public String getId_pechrodietdef() {
		return ((String) getAttrVal("Id_pechrodietdef"));
	}	
	/**
	 * 体检慢性病关联饮食处方定义主键标识
	 * @param Id_pechrodietdef
	 */
	public void setId_pechrodietdef(String Id_pechrodietdef) {
		setAttrVal("Id_pechrodietdef", Id_pechrodietdef);
	}
	/**
	 * 体检慢性病定义ID
	 * @return String
	 */
	public String getId_peevalchrodef() {
		return ((String) getAttrVal("Id_peevalchrodef"));
	}	
	/**
	 * 体检慢性病定义ID
	 * @param Id_peevalchrodef
	 */
	public void setId_peevalchrodef(String Id_peevalchrodef) {
		setAttrVal("Id_peevalchrodef", Id_peevalchrodef);
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
	 * 编码
	 * @return String
	 */
	public String getCode_diet() {
		return ((String) getAttrVal("Code_diet"));
	}	
	/**
	 * 编码
	 * @param Code_diet
	 */
	public void setCode_diet(String Code_diet) {
		setAttrVal("Code_diet", Code_diet);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_diet() {
		return ((String) getAttrVal("Name_diet"));
	}	
	/**
	 * 名称
	 * @param Name_diet
	 */
	public void setName_diet(String Name_diet) {
		setAttrVal("Name_diet", Name_diet);
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
		return "Id_pechrodietdef";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_pechrodietdef";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeChroDietDefDODesc.class);
	}
	
}