package iih.pe.pitm.perstdidef.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.perstdidef.d.desc.PeDiagDocDODesc;
import java.math.BigDecimal;

/**
 * 体检诊断定义_医生模板 DO数据 
 * 
 */
public class PeDiagDocDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检医生诊断模板主键标识
	public static final String ID_PEDIAGDOC= "Id_pediagdoc";
	//体检诊断ID
	public static final String ID_PERSTDIDEF= "Id_perstdidef";
	//诊断编码
	public static final String CODE= "Code";
	//诊断名称
	public static final String NAME= "Name";
	//总检医生建议
	public static final String ADVICE= "Advice";
	//专科医生建议
	public static final String ADVICE_DOC= "Advice_doc";
	//医生ID
	public static final String ID_DOC= "Id_doc";
	//诊断编码
	public static final String CODE_DIAG= "Code_diag";
	//诊断名称
	public static final String NAME_DIAG= "Name_diag";
	//用户编码
	public static final String CODE_DOC= "Code_doc";
	//用户名称
	public static final String NAME_DOC= "Name_doc";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检医生诊断模板主键标识
	 * @return String
	 */
	public String getId_pediagdoc() {
		return ((String) getAttrVal("Id_pediagdoc"));
	}	
	/**
	 * 体检医生诊断模板主键标识
	 * @param Id_pediagdoc
	 */
	public void setId_pediagdoc(String Id_pediagdoc) {
		setAttrVal("Id_pediagdoc", Id_pediagdoc);
	}
	/**
	 * 体检诊断ID
	 * @return String
	 */
	public String getId_perstdidef() {
		return ((String) getAttrVal("Id_perstdidef"));
	}	
	/**
	 * 体检诊断ID
	 * @param Id_perstdidef
	 */
	public void setId_perstdidef(String Id_perstdidef) {
		setAttrVal("Id_perstdidef", Id_perstdidef);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 诊断编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 诊断名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 总检医生建议
	 * @return String
	 */
	public String getAdvice() {
		return ((String) getAttrVal("Advice"));
	}	
	/**
	 * 总检医生建议
	 * @param Advice
	 */
	public void setAdvice(String Advice) {
		setAttrVal("Advice", Advice);
	}
	/**
	 * 专科医生建议
	 * @return String
	 */
	public String getAdvice_doc() {
		return ((String) getAttrVal("Advice_doc"));
	}	
	/**
	 * 专科医生建议
	 * @param Advice_doc
	 */
	public void setAdvice_doc(String Advice_doc) {
		setAttrVal("Advice_doc", Advice_doc);
	}
	/**
	 * 医生ID
	 * @return String
	 */
	public String getId_doc() {
		return ((String) getAttrVal("Id_doc"));
	}	
	/**
	 * 医生ID
	 * @param Id_doc
	 */
	public void setId_doc(String Id_doc) {
		setAttrVal("Id_doc", Id_doc);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getCode_diag() {
		return ((String) getAttrVal("Code_diag"));
	}	
	/**
	 * 诊断编码
	 * @param Code_diag
	 */
	public void setCode_diag(String Code_diag) {
		setAttrVal("Code_diag", Code_diag);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName_diag() {
		return ((String) getAttrVal("Name_diag"));
	}	
	/**
	 * 诊断名称
	 * @param Name_diag
	 */
	public void setName_diag(String Name_diag) {
		setAttrVal("Name_diag", Name_diag);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getCode_doc() {
		return ((String) getAttrVal("Code_doc"));
	}	
	/**
	 * 用户编码
	 * @param Code_doc
	 */
	public void setCode_doc(String Code_doc) {
		setAttrVal("Code_doc", Code_doc);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getName_doc() {
		return ((String) getAttrVal("Name_doc"));
	}	
	/**
	 * 用户名称
	 * @param Name_doc
	 */
	public void setName_doc(String Name_doc) {
		setAttrVal("Name_doc", Name_doc);
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
		return "Id_pediagdoc";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_pediagdoc";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeDiagDocDODesc.class);
	}
	
}