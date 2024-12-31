package iih.nm.net.examqucarel.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.net.examqucarel.d.desc.ExamQuCaRelDODesc;
import java.math.BigDecimal;

/**
 * 试题类别与试题关系 DO数据 
 * 
 */
public class ExamQuCaRelDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_QU_CA_REL= "Id_qu_ca_rel";
	public static final String ID_QU_CA= "Id_qu_ca";
	public static final String ID_QU= "Id_qu";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_QU_CA= "Name_qu_ca";
	public static final String CONTENT= "Content";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_qu_ca_rel() {
		return ((String) getAttrVal("Id_qu_ca_rel"));
	}	
	public void setId_qu_ca_rel(String Id_qu_ca_rel) {
		setAttrVal("Id_qu_ca_rel", Id_qu_ca_rel);
	}
	public String getId_qu_ca() {
		return ((String) getAttrVal("Id_qu_ca"));
	}	
	public void setId_qu_ca(String Id_qu_ca) {
		setAttrVal("Id_qu_ca", Id_qu_ca);
	}
	public String getId_qu() {
		return ((String) getAttrVal("Id_qu"));
	}	
	public void setId_qu(String Id_qu) {
		setAttrVal("Id_qu", Id_qu);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	public String getName_qu_ca() {
		return ((String) getAttrVal("Name_qu_ca"));
	}	
	public void setName_qu_ca(String Name_qu_ca) {
		setAttrVal("Name_qu_ca", Name_qu_ca);
	}
	public String getContent() {
		return ((String) getAttrVal("Content"));
	}	
	public void setContent(String Content) {
		setAttrVal("Content", Content);
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
		return "Id_qu_ca_rel";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_EXAM_QU_CA_REL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ExamQuCaRelDODesc.class);
	}
	
}