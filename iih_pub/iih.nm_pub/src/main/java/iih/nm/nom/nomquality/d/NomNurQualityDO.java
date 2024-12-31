package iih.nm.nom.nomquality.d;

import iih.nm.nom.nomquality.d.desc.NomNurQualityDODesc;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.i.IDODesc;
import xap.sys.appfw.orm.desc.DescManager;

/**
 * 护理质量管理 DO数据 
 * 
 */
public class NomNurQualityDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NOM_NURQUALITY= "Id_nom_nurquality";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String FALL_RANDINSPECT= "Fall_randinspect";
	public static final String FALL_EVAL= "Fall_eval";
	public static final String PRESS_RANDINSPECT= "Press_randinspect";
	public static final String PRESS_EVAL= "Press_eval";
	public static final String PRESS= "Press";
	public static final String FALL= "Fall";
	public static final String INFU= "Infu";
	public static final String INFU_REACT= "Infu_react";
	public static final String TRANSFUSION= "Transfusion";
	public static final String TRANSFU_REACT= "Transfu_react";
	public static final String ADVERSE_EVENT= "Adverse_event";
	public static final String ADVERSE_EVENTI= "Adverse_eventi";
	public static final String ADVERSE_EVENTII= "Adverse_eventii";
	public static final String ADVERSE_EVENTIII= "Adverse_eventiii";
	public static final String ADVERSE_EVENTIV= "Adverse_eventiv";
	public static final String IMP_DELIVERY= "Imp_delivery";
	public static final String IMP_QUALIFIED= "Imp_qualified";
	public static final String EMERGENCY= "Emergency";
	public static final String COM_EMERGENCY= "Com_emergency";
	public static final String OPERATION= "Operation";
	public static final String OPERAT_QUALIFIED= "Operat_qualified";
	public static final String PROCE_SPECIF= "Proce_specif";
	public static final String PROCE_QUALIFIED= "Proce_qualified";
	public static final String HEALTH_EDU_ITEM= "Health_edu_item";
	public static final String KNOWN_HEALTH_EDU= "Known_health_edu";
	public static final String NUR_SPECIF= "Nur_specif";
	public static final String NUR_SPECIF_TRUTH= "Nur_specif_truth";
	public static final String CHECK_BEGINTIME= "Check_begintime";
	public static final String CHECK_ENDTIME= "Check_endtime";
	public static final String CHECK_MONTH= "Check_month";
	public static final String FG_COMFIRM= "Fg_comfirm";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nom_nurquality() {
		return ((String) getAttrVal("Id_nom_nurquality"));
	}	
	public void setId_nom_nurquality(String Id_nom_nurquality) {
		setAttrVal("Id_nom_nurquality", Id_nom_nurquality);
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
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	public Integer getFall_randinspect() {
		return ((Integer) getAttrVal("Fall_randinspect"));
	}	
	public void setFall_randinspect(Integer Fall_randinspect) {
		setAttrVal("Fall_randinspect", Fall_randinspect);
	}
	public Integer getFall_eval() {
		return ((Integer) getAttrVal("Fall_eval"));
	}	
	public void setFall_eval(Integer Fall_eval) {
		setAttrVal("Fall_eval", Fall_eval);
	}
	public Integer getPress_randinspect() {
		return ((Integer) getAttrVal("Press_randinspect"));
	}	
	public void setPress_randinspect(Integer Press_randinspect) {
		setAttrVal("Press_randinspect", Press_randinspect);
	}
	public Integer getPress_eval() {
		return ((Integer) getAttrVal("Press_eval"));
	}	
	public void setPress_eval(Integer Press_eval) {
		setAttrVal("Press_eval", Press_eval);
	}
	public Integer getPress() {
		return ((Integer) getAttrVal("Press"));
	}	
	public void setPress(Integer Press) {
		setAttrVal("Press", Press);
	}
	public Integer getFall() {
		return ((Integer) getAttrVal("Fall"));
	}	
	public void setFall(Integer Fall) {
		setAttrVal("Fall", Fall);
	}
	public Integer getInfu() {
		return ((Integer) getAttrVal("Infu"));
	}	
	public void setInfu(Integer Infu) {
		setAttrVal("Infu", Infu);
	}
	public Integer getInfu_react() {
		return ((Integer) getAttrVal("Infu_react"));
	}	
	public void setInfu_react(Integer Infu_react) {
		setAttrVal("Infu_react", Infu_react);
	}
	public Integer getTransfusion() {
		return ((Integer) getAttrVal("Transfusion"));
	}	
	public void setTransfusion(Integer Transfusion) {
		setAttrVal("Transfusion", Transfusion);
	}
	public Integer getTransfu_react() {
		return ((Integer) getAttrVal("Transfu_react"));
	}	
	public void setTransfu_react(Integer Transfu_react) {
		setAttrVal("Transfu_react", Transfu_react);
	}
	public Integer getAdverse_event() {
		return ((Integer) getAttrVal("Adverse_event"));
	}	
	public void setAdverse_event(Integer Adverse_event) {
		setAttrVal("Adverse_event", Adverse_event);
	}
	public Integer getAdverse_eventi() {
		return ((Integer) getAttrVal("Adverse_eventi"));
	}	
	public void setAdverse_eventi(Integer Adverse_eventi) {
		setAttrVal("Adverse_eventi", Adverse_eventi);
	}
	public Integer getAdverse_eventii() {
		return ((Integer) getAttrVal("Adverse_eventii"));
	}	
	public void setAdverse_eventii(Integer Adverse_eventii) {
		setAttrVal("Adverse_eventii", Adverse_eventii);
	}
	public Integer getAdverse_eventiii() {
		return ((Integer) getAttrVal("Adverse_eventiii"));
	}	
	public void setAdverse_eventiii(Integer Adverse_eventiii) {
		setAttrVal("Adverse_eventiii", Adverse_eventiii);
	}
	public Integer getAdverse_eventiv() {
		return ((Integer) getAttrVal("Adverse_eventiv"));
	}	
	public void setAdverse_eventiv(Integer Adverse_eventiv) {
		setAttrVal("Adverse_eventiv", Adverse_eventiv);
	}
	public Integer getImp_delivery() {
		return ((Integer) getAttrVal("Imp_delivery"));
	}	
	public void setImp_delivery(Integer Imp_delivery) {
		setAttrVal("Imp_delivery", Imp_delivery);
	}
	public Integer getImp_qualified() {
		return ((Integer) getAttrVal("Imp_qualified"));
	}	
	public void setImp_qualified(Integer Imp_qualified) {
		setAttrVal("Imp_qualified", Imp_qualified);
	}
	public Integer getEmergency() {
		return ((Integer) getAttrVal("Emergency"));
	}	
	public void setEmergency(Integer Emergency) {
		setAttrVal("Emergency", Emergency);
	}
	public Integer getCom_emergency() {
		return ((Integer) getAttrVal("Com_emergency"));
	}	
	public void setCom_emergency(Integer Com_emergency) {
		setAttrVal("Com_emergency", Com_emergency);
	}
	public Integer getOperation() {
		return ((Integer) getAttrVal("Operation"));
	}	
	public void setOperation(Integer Operation) {
		setAttrVal("Operation", Operation);
	}
	public Integer getOperat_qualified() {
		return ((Integer) getAttrVal("Operat_qualified"));
	}	
	public void setOperat_qualified(Integer Operat_qualified) {
		setAttrVal("Operat_qualified", Operat_qualified);
	}
	public Integer getProce_specif() {
		return ((Integer) getAttrVal("Proce_specif"));
	}	
	public void setProce_specif(Integer Proce_specif) {
		setAttrVal("Proce_specif", Proce_specif);
	}
	public Integer getProce_qualified() {
		return ((Integer) getAttrVal("Proce_qualified"));
	}	
	public void setProce_qualified(Integer Proce_qualified) {
		setAttrVal("Proce_qualified", Proce_qualified);
	}
	public Integer getHealth_edu_item() {
		return ((Integer) getAttrVal("Health_edu_item"));
	}	
	public void setHealth_edu_item(Integer Health_edu_item) {
		setAttrVal("Health_edu_item", Health_edu_item);
	}
	public Integer getKnown_health_edu() {
		return ((Integer) getAttrVal("Known_health_edu"));
	}	
	public void setKnown_health_edu(Integer Known_health_edu) {
		setAttrVal("Known_health_edu", Known_health_edu);
	}
	public Integer getNur_specif() {
		return ((Integer) getAttrVal("Nur_specif"));
	}	
	public void setNur_specif(Integer Nur_specif) {
		setAttrVal("Nur_specif", Nur_specif);
	}
	public Integer getNur_specif_truth() {
		return ((Integer) getAttrVal("Nur_specif_truth"));
	}	
	public void setNur_specif_truth(Integer Nur_specif_truth) {
		setAttrVal("Nur_specif_truth", Nur_specif_truth);
	}
	public FDate getCheck_begintime() {
		return ((FDate) getAttrVal("Check_begintime"));
	}	
	public void setCheck_begintime(FDate Check_begintime) {
		setAttrVal("Check_begintime", Check_begintime);
	}
	public FDate getCheck_endtime() {
		return ((FDate) getAttrVal("Check_endtime"));
	}	
	public void setCheck_endtime(FDate Check_endtime) {
		setAttrVal("Check_endtime", Check_endtime);
	}
	public FDate getCheck_month() {
		return ((FDate) getAttrVal("Check_month"));
	}	
	public void setCheck_month(FDate Check_month) {
		setAttrVal("Check_month", Check_month);
	}
	public FBoolean getFg_comfirm() {
		return ((FBoolean) getAttrVal("Fg_comfirm"));
	}	
	public void setFg_comfirm(FBoolean Fg_comfirm) {
		setAttrVal("Fg_comfirm", Fg_comfirm);
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
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
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
		return "Id_nom_nurquality";
	}
	
	@Override
	public String getTableName() {	  
		return "nom_nur_quality";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NomNurQualityDODesc.class);
	}
	
}