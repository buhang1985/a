package iih.bd.srv.qcmraddrule.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.qcmraddrule.d.desc.QcmraddpreruleDODesc;
import java.math.BigDecimal;

/**
 * 病历新建规则前提 DO数据 
 * 
 */
public class QcmraddpreruleDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PRERULE= "Id_prerule";
	public static final String ID_RULE= "Id_rule";
	public static final String ID_MRCACTM= "Id_mrcactm";
	public static final String ID_MRTP= "Id_mrtp";
	public static final String FG_MUST_EXIST= "Fg_must_exist";
	public static final String TIP_TEXT= "Tip_text";
	public static final String REMARK= "Remark";
	public static final String CODE_MRCACTM= "Code_mrcactm";
	public static final String NAME_MRCACTM= "Name_mrcactm";
	public static final String CODE_MRTP= "Code_mrtp";
	public static final String NAME_MRTP= "Name_mrtp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_prerule() {
		return ((String) getAttrVal("Id_prerule"));
	}	
	public void setId_prerule(String Id_prerule) {
		setAttrVal("Id_prerule", Id_prerule);
	}
	public String getId_rule() {
		return ((String) getAttrVal("Id_rule"));
	}	
	public void setId_rule(String Id_rule) {
		setAttrVal("Id_rule", Id_rule);
	}
	public String getId_mrcactm() {
		return ((String) getAttrVal("Id_mrcactm"));
	}	
	public void setId_mrcactm(String Id_mrcactm) {
		setAttrVal("Id_mrcactm", Id_mrcactm);
	}
	public String getId_mrtp() {
		return ((String) getAttrVal("Id_mrtp"));
	}	
	public void setId_mrtp(String Id_mrtp) {
		setAttrVal("Id_mrtp", Id_mrtp);
	}
	public FBoolean getFg_must_exist() {
		return ((FBoolean) getAttrVal("Fg_must_exist"));
	}	
	public void setFg_must_exist(FBoolean Fg_must_exist) {
		setAttrVal("Fg_must_exist", Fg_must_exist);
	}
	public String getTip_text() {
		return ((String) getAttrVal("Tip_text"));
	}	
	public void setTip_text(String Tip_text) {
		setAttrVal("Tip_text", Tip_text);
	}
	public String getRemark() {
		return ((String) getAttrVal("Remark"));
	}	
	public void setRemark(String Remark) {
		setAttrVal("Remark", Remark);
	}
	public String getCode_mrcactm() {
		return ((String) getAttrVal("Code_mrcactm"));
	}	
	public void setCode_mrcactm(String Code_mrcactm) {
		setAttrVal("Code_mrcactm", Code_mrcactm);
	}
	public String getName_mrcactm() {
		return ((String) getAttrVal("Name_mrcactm"));
	}	
	public void setName_mrcactm(String Name_mrcactm) {
		setAttrVal("Name_mrcactm", Name_mrcactm);
	}
	public String getCode_mrtp() {
		return ((String) getAttrVal("Code_mrtp"));
	}	
	public void setCode_mrtp(String Code_mrtp) {
		setAttrVal("Code_mrtp", Code_mrtp);
	}
	public String getName_mrtp() {
		return ((String) getAttrVal("Name_mrtp"));
	}	
	public void setName_mrtp(String Name_mrtp) {
		setAttrVal("Name_mrtp", Name_mrtp);
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
		return "Id_prerule";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_qc_add_prerule";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(QcmraddpreruleDODesc.class);
	}
	
}