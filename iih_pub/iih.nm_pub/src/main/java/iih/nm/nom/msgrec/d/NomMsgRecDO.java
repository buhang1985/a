package iih.nm.nom.msgrec.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nom.msgrec.d.desc.NomMsgRecDODesc;
import java.math.BigDecimal;

/**
 * 病区事物消息记录 DO数据 
 * 
 */
public class NomMsgRecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NOM_MSG= "Id_nom_msg";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String TITLE= "Title";
	public static final String ID_MSGTP= "Id_msgtp";
	public static final String CONTENT= "Content";
	public static final String ID_SEND_PSN= "Id_send_psn";
	public static final String DT_SEND= "Dt_send";
	public static final String ID_RECEIVE_PSN= "Id_receive_psn";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_MSGTP= "Name_msgtp";
	public static final String CODE_MSGTP= "Code_msgtp";
	public static final String NAME_SEND_PSN= "Name_send_psn";
	public static final String NAME_RECEIVE_PSN= "Name_receive_psn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nom_msg() {
		return ((String) getAttrVal("Id_nom_msg"));
	}	
	public void setId_nom_msg(String Id_nom_msg) {
		setAttrVal("Id_nom_msg", Id_nom_msg);
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
	public String getTitle() {
		return ((String) getAttrVal("Title"));
	}	
	public void setTitle(String Title) {
		setAttrVal("Title", Title);
	}
	public String getId_msgtp() {
		return ((String) getAttrVal("Id_msgtp"));
	}	
	public void setId_msgtp(String Id_msgtp) {
		setAttrVal("Id_msgtp", Id_msgtp);
	}
	public String getContent() {
		return ((String) getAttrVal("Content"));
	}	
	public void setContent(String Content) {
		setAttrVal("Content", Content);
	}
	public String getId_send_psn() {
		return ((String) getAttrVal("Id_send_psn"));
	}	
	public void setId_send_psn(String Id_send_psn) {
		setAttrVal("Id_send_psn", Id_send_psn);
	}
	public FDateTime getDt_send() {
		return ((FDateTime) getAttrVal("Dt_send"));
	}	
	public void setDt_send(FDateTime Dt_send) {
		setAttrVal("Dt_send", Dt_send);
	}
	public String getId_receive_psn() {
		return ((String) getAttrVal("Id_receive_psn"));
	}	
	public void setId_receive_psn(String Id_receive_psn) {
		setAttrVal("Id_receive_psn", Id_receive_psn);
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
	public String getName_msgtp() {
		return ((String) getAttrVal("Name_msgtp"));
	}	
	public void setName_msgtp(String Name_msgtp) {
		setAttrVal("Name_msgtp", Name_msgtp);
	}
	public String getCode_msgtp() {
		return ((String) getAttrVal("Code_msgtp"));
	}	
	public void setCode_msgtp(String Code_msgtp) {
		setAttrVal("Code_msgtp", Code_msgtp);
	}
	public String getName_send_psn() {
		return ((String) getAttrVal("Name_send_psn"));
	}	
	public void setName_send_psn(String Name_send_psn) {
		setAttrVal("Name_send_psn", Name_send_psn);
	}
	public String getName_receive_psn() {
		return ((String) getAttrVal("Name_receive_psn"));
	}	
	public void setName_receive_psn(String Name_receive_psn) {
		setAttrVal("Name_receive_psn", Name_receive_psn);
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
		return "Id_nom_msg";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NOM_MSGREC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NomMsgRecDODesc.class);
	}
	
}