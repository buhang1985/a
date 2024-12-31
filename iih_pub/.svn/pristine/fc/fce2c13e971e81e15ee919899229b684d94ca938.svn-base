package iih.pe.pitm.pesrvitem.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.pesrvitem.d.desc.PeSrvitmSuggDODesc;
import java.math.BigDecimal;

/**
 * 体检结果与建议关联 DO数据 
 * 
 */
public class PeSrvitmSuggDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检检查结果关联建议主键标识
	public static final String ID_PESRVITMSUGG= "Id_pesrvitmsugg";
	//体检结果ID
	public static final String ID_PESRVITEM= "Id_pesrvitem";
	//关联建议ID
	public static final String ID_PERSTSUGGDEF= "Id_perstsuggdef";
	//建议名称
	public static final String NAME_SUGG= "Name_sugg";
	//建议编码
	public static final String CODE_SUGG= "Code_sugg";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检检查结果关联建议主键标识
	 * @return String
	 */
	public String getId_pesrvitmsugg() {
		return ((String) getAttrVal("Id_pesrvitmsugg"));
	}	
	/**
	 * 体检检查结果关联建议主键标识
	 * @param Id_pesrvitmsugg
	 */
	public void setId_pesrvitmsugg(String Id_pesrvitmsugg) {
		setAttrVal("Id_pesrvitmsugg", Id_pesrvitmsugg);
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
	 * 关联建议ID
	 * @return String
	 */
	public String getId_perstsuggdef() {
		return ((String) getAttrVal("Id_perstsuggdef"));
	}	
	/**
	 * 关联建议ID
	 * @param Id_perstsuggdef
	 */
	public void setId_perstsuggdef(String Id_perstsuggdef) {
		setAttrVal("Id_perstsuggdef", Id_perstsuggdef);
	}
	/**
	 * 建议名称
	 * @return String
	 */
	public String getName_sugg() {
		return ((String) getAttrVal("Name_sugg"));
	}	
	/**
	 * 建议名称
	 * @param Name_sugg
	 */
	public void setName_sugg(String Name_sugg) {
		setAttrVal("Name_sugg", Name_sugg);
	}
	/**
	 * 建议编码
	 * @return String
	 */
	public String getCode_sugg() {
		return ((String) getAttrVal("Code_sugg"));
	}	
	/**
	 * 建议编码
	 * @param Code_sugg
	 */
	public void setCode_sugg(String Code_sugg) {
		setAttrVal("Code_sugg", Code_sugg);
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
		return "Id_pesrvitmsugg";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_peitmsugg";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeSrvitmSuggDODesc.class);
	}
	
}