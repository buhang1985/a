package iih.bd.srv.qcconreject.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.qcconreject.d.desc.QcconrejectDODesc;
import java.math.BigDecimal;

/**
 * 病历内容互斥质控 DO数据 
 * 
 */
public class QcconrejectDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_REJECT= "Id_reject";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String ID_MRCACTM= "Id_mrcactm";
	public static final String ID_MRTP= "Id_mrtp";
	public static final String FG_EANBLE= "Fg_eanble";
	public static final String REMARK= "Remark";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_MRCACTM= "Code_mrcactm";
	public static final String NAME_MRCACTM= "Name_mrcactm";
	public static final String CODE_MRTP= "Code_mrtp";
	public static final String NAME_MRTP= "Name_mrtp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_reject() {
		return ((String) getAttrVal("Id_reject"));
	}	
	public void setId_reject(String Id_reject) {
		setAttrVal("Id_reject", Id_reject);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
	public FBoolean getFg_eanble() {
		return ((FBoolean) getAttrVal("Fg_eanble"));
	}	
	public void setFg_eanble(FBoolean Fg_eanble) {
		setAttrVal("Fg_eanble", Fg_eanble);
	}
	public String getRemark() {
		return ((String) getAttrVal("Remark"));
	}	
	public void setRemark(String Remark) {
		setAttrVal("Remark", Remark);
	}
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
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
		return "Id_reject";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mrqc_con_reject";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(QcconrejectDODesc.class);
	}
	
}