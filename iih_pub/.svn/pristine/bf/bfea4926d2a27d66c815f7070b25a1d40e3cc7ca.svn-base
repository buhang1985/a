package iih.pe.phm.petcmhealth.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.petcmhealth.d.desc.PeTCMHealthDODesc;
import java.math.BigDecimal;

/**
 * 体检中医养生内容 DO数据 
 * 
 */
public class PeTCMHealthDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检中医养生内容主键标识
	public static final String ID_PETCMHEALTH= "Id_petcmhealth";
	//体检中医养生类别ID
	public static final String ID_PETCMHEALTHTP= "Id_petcmhealthtp";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//内容
	public static final String NOTE= "Note";
	//次序
	public static final String SORTNO= "Sortno";
	//启用标识
	public static final String FG_ACTIVE= "Fg_active";
	//编码
	public static final String CODE_TP= "Code_tp";
	//名称
	public static final String NAME_TP= "Name_tp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检中医养生内容主键标识
	 * @return String
	 */
	public String getId_petcmhealth() {
		return ((String) getAttrVal("Id_petcmhealth"));
	}	
	/**
	 * 体检中医养生内容主键标识
	 * @param Id_petcmhealth
	 */
	public void setId_petcmhealth(String Id_petcmhealth) {
		setAttrVal("Id_petcmhealth", Id_petcmhealth);
	}
	/**
	 * 体检中医养生类别ID
	 * @return String
	 */
	public String getId_petcmhealthtp() {
		return ((String) getAttrVal("Id_petcmhealthtp"));
	}	
	/**
	 * 体检中医养生类别ID
	 * @param Id_petcmhealthtp
	 */
	public void setId_petcmhealthtp(String Id_petcmhealthtp) {
		setAttrVal("Id_petcmhealthtp", Id_petcmhealthtp);
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
	/**
	 * 内容
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 内容
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
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
	 * 启用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标识
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_tp() {
		return ((String) getAttrVal("Code_tp"));
	}	
	/**
	 * 编码
	 * @param Code_tp
	 */
	public void setCode_tp(String Code_tp) {
		setAttrVal("Code_tp", Code_tp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_tp() {
		return ((String) getAttrVal("Name_tp"));
	}	
	/**
	 * 名称
	 * @param Name_tp
	 */
	public void setName_tp(String Name_tp) {
		setAttrVal("Name_tp", Name_tp);
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
		return "Id_petcmhealth";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_petcmhealth";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeTCMHealthDODesc.class);
	}
	
}