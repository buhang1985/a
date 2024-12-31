package iih.bd.srv.qcconreject.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.qcconreject.d.desc.QcconrejectitemDODesc;
import java.math.BigDecimal;

/**
 * 病历内容互斥项目 DO数据 
 * 
 */
public class QcconrejectitemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ITEM= "Id_item";
	public static final String ID_REJECT= "Id_reject";
	public static final String ID_SEGMENT= "Id_segment";
	public static final String ID_ELEMENT= "Id_element";
	public static final String KEY_WORD= "Key_word";
	public static final String TIP_TEXT= "Tip_text";
	public static final String REJECT_RULE= "Reject_rule";
	public static final String REMARK= "Remark";
	public static final String NAME_DG= "Name_dg";
	public static final String CODE_DG= "Code_dg";
	public static final String CODE_DE= "Code_de";
	public static final String NAME_DE= "Name_de";
	public static final String CD_STD= "Cd_std";
	public static final String CODE_RULE= "Code_rule";
	public static final String NAME_RULE= "Name_rule";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_item() {
		return ((String) getAttrVal("Id_item"));
	}	
	public void setId_item(String Id_item) {
		setAttrVal("Id_item", Id_item);
	}
	public String getId_reject() {
		return ((String) getAttrVal("Id_reject"));
	}	
	public void setId_reject(String Id_reject) {
		setAttrVal("Id_reject", Id_reject);
	}
	public String getId_segment() {
		return ((String) getAttrVal("Id_segment"));
	}	
	public void setId_segment(String Id_segment) {
		setAttrVal("Id_segment", Id_segment);
	}
	public String getId_element() {
		return ((String) getAttrVal("Id_element"));
	}	
	public void setId_element(String Id_element) {
		setAttrVal("Id_element", Id_element);
	}
	public String getKey_word() {
		return ((String) getAttrVal("Key_word"));
	}	
	public void setKey_word(String Key_word) {
		setAttrVal("Key_word", Key_word);
	}
	public String getTip_text() {
		return ((String) getAttrVal("Tip_text"));
	}	
	public void setTip_text(String Tip_text) {
		setAttrVal("Tip_text", Tip_text);
	}
	public String getReject_rule() {
		return ((String) getAttrVal("Reject_rule"));
	}	
	public void setReject_rule(String Reject_rule) {
		setAttrVal("Reject_rule", Reject_rule);
	}
	public String getRemark() {
		return ((String) getAttrVal("Remark"));
	}	
	public void setRemark(String Remark) {
		setAttrVal("Remark", Remark);
	}
	public String getName_dg() {
		return ((String) getAttrVal("Name_dg"));
	}	
	public void setName_dg(String Name_dg) {
		setAttrVal("Name_dg", Name_dg);
	}
	public String getCode_dg() {
		return ((String) getAttrVal("Code_dg"));
	}	
	public void setCode_dg(String Code_dg) {
		setAttrVal("Code_dg", Code_dg);
	}
	public String getCode_de() {
		return ((String) getAttrVal("Code_de"));
	}	
	public void setCode_de(String Code_de) {
		setAttrVal("Code_de", Code_de);
	}
	public String getName_de() {
		return ((String) getAttrVal("Name_de"));
	}	
	public void setName_de(String Name_de) {
		setAttrVal("Name_de", Name_de);
	}
	public String getCd_std() {
		return ((String) getAttrVal("Cd_std"));
	}	
	public void setCd_std(String Cd_std) {
		setAttrVal("Cd_std", Cd_std);
	}
	public String getCode_rule() {
		return ((String) getAttrVal("Code_rule"));
	}	
	public void setCode_rule(String Code_rule) {
		setAttrVal("Code_rule", Code_rule);
	}
	public String getName_rule() {
		return ((String) getAttrVal("Name_rule"));
	}	
	public void setName_rule(String Name_rule) {
		setAttrVal("Name_rule", Name_rule);
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
		return "Id_item";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mrqc_con_reject_item";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(QcconrejectitemDODesc.class);
	}
	
}