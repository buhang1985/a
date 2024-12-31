package iih.pe.pitm.perules.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.perules.d.desc.PeRuleItemDODesc;
import java.math.BigDecimal;

/**
 * 体检规则相关项目结果 DO数据 
 * 
 */
public class PeRuleItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检规则关联项目主键标识
	public static final String ID_PERULEITEM= "Id_peruleitem";
	//体检异常判断规则ID
	public static final String ID_PERULEDEF= "Id_peruledef";
	//体检结果主键标识
	public static final String ID_PESRVITEM= "Id_pesrvitem";
	//结果类型
	public static final String RESULTTP= "Resulttp";
	//编码
	public static final String CODE_SRVITM= "Code_srvitm";
	//名称
	public static final String NAME_SRVITM= "Name_srvitm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检规则关联项目主键标识
	 * @return String
	 */
	public String getId_peruleitem() {
		return ((String) getAttrVal("Id_peruleitem"));
	}	
	/**
	 * 体检规则关联项目主键标识
	 * @param Id_peruleitem
	 */
	public void setId_peruleitem(String Id_peruleitem) {
		setAttrVal("Id_peruleitem", Id_peruleitem);
	}
	/**
	 * 体检异常判断规则ID
	 * @return String
	 */
	public String getId_peruledef() {
		return ((String) getAttrVal("Id_peruledef"));
	}	
	/**
	 * 体检异常判断规则ID
	 * @param Id_peruledef
	 */
	public void setId_peruledef(String Id_peruledef) {
		setAttrVal("Id_peruledef", Id_peruledef);
	}
	/**
	 * 体检结果主键标识
	 * @return String
	 */
	public String getId_pesrvitem() {
		return ((String) getAttrVal("Id_pesrvitem"));
	}	
	/**
	 * 体检结果主键标识
	 * @param Id_pesrvitem
	 */
	public void setId_pesrvitem(String Id_pesrvitem) {
		setAttrVal("Id_pesrvitem", Id_pesrvitem);
	}
	/**
	 * 结果类型
	 * @return Integer
	 */
	public Integer getResulttp() {
		return ((Integer) getAttrVal("Resulttp"));
	}	
	/**
	 * 结果类型
	 * @param Resulttp
	 */
	public void setResulttp(Integer Resulttp) {
		setAttrVal("Resulttp", Resulttp);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_srvitm() {
		return ((String) getAttrVal("Code_srvitm"));
	}	
	/**
	 * 编码
	 * @param Code_srvitm
	 */
	public void setCode_srvitm(String Code_srvitm) {
		setAttrVal("Code_srvitm", Code_srvitm);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_srvitm() {
		return ((String) getAttrVal("Name_srvitm"));
	}	
	/**
	 * 名称
	 * @param Name_srvitm
	 */
	public void setName_srvitm(String Name_srvitm) {
		setAttrVal("Name_srvitm", Name_srvitm);
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
		return "Id_peruleitem";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_peruleitem";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeRuleItemDODesc.class);
	}
	
}