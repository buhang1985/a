package iih.nmr.ha.tcho.ipevalsigle.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.ha.tcho.ipevalsigle.d.desc.TchoEvaluateItmDODesc;
import java.math.BigDecimal;

/**
 * 住院患者健康教育评价单 DO数据 
 * 
 */
public class TchoEvaluateItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_EVALSGL_ITM= "Id_evalsgl_itm";
	public static final String ID_EVALSGL= "Id_evalsgl";
	public static final String ID_ITEM= "Id_item";
	public static final String SD_ITEM= "Sd_item";
	public static final String ID_ITEM_PAR= "Id_item_par";
	public static final String ID_NUR= "Id_nur";
	public static final String DT_EVAL= "Dt_eval";
	public static final String DT_EVALUATE= "Dt_evaluate";
	public static final String EU_REPEAT= "Eu_repeat";
	public static final String EU_BACKIN= "Eu_backin";
	public static final String ID_WAY= "Id_way";
	public static final String SD_WAY= "Sd_way";
	public static final String ID_OBJECT= "Id_object";
	public static final String SD_OBJECT= "Sd_object";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_ITEM= "Name_item";
	public static final String NAME_ITEM_PAR= "Name_item_par";
	public static final String NAME_NUR= "Name_nur";
	public static final String NAME_WAY= "Name_way";
	public static final String NAME_OBJECT= "Name_object";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_evalsgl_itm() {
		return ((String) getAttrVal("Id_evalsgl_itm"));
	}	
	public void setId_evalsgl_itm(String Id_evalsgl_itm) {
		setAttrVal("Id_evalsgl_itm", Id_evalsgl_itm);
	}
	public String getId_evalsgl() {
		return ((String) getAttrVal("Id_evalsgl"));
	}	
	public void setId_evalsgl(String Id_evalsgl) {
		setAttrVal("Id_evalsgl", Id_evalsgl);
	}
	public String getId_item() {
		return ((String) getAttrVal("Id_item"));
	}	
	public void setId_item(String Id_item) {
		setAttrVal("Id_item", Id_item);
	}
	public String getSd_item() {
		return ((String) getAttrVal("Sd_item"));
	}	
	public void setSd_item(String Sd_item) {
		setAttrVal("Sd_item", Sd_item);
	}
	public String getId_item_par() {
		return ((String) getAttrVal("Id_item_par"));
	}	
	public void setId_item_par(String Id_item_par) {
		setAttrVal("Id_item_par", Id_item_par);
	}
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	public FDateTime getDt_eval() {
		return ((FDateTime) getAttrVal("Dt_eval"));
	}	
	public void setDt_eval(FDateTime Dt_eval) {
		setAttrVal("Dt_eval", Dt_eval);
	}
	public FDateTime getDt_evaluate() {
		return ((FDateTime) getAttrVal("Dt_evaluate"));
	}	
	public void setDt_evaluate(FDateTime Dt_evaluate) {
		setAttrVal("Dt_evaluate", Dt_evaluate);
	}
	public Integer getEu_repeat() {
		return ((Integer) getAttrVal("Eu_repeat"));
	}	
	public void setEu_repeat(Integer Eu_repeat) {
		setAttrVal("Eu_repeat", Eu_repeat);
	}
	public Integer getEu_backin() {
		return ((Integer) getAttrVal("Eu_backin"));
	}	
	public void setEu_backin(Integer Eu_backin) {
		setAttrVal("Eu_backin", Eu_backin);
	}
	public String getId_way() {
		return ((String) getAttrVal("Id_way"));
	}	
	public void setId_way(String Id_way) {
		setAttrVal("Id_way", Id_way);
	}
	public String getSd_way() {
		return ((String) getAttrVal("Sd_way"));
	}	
	public void setSd_way(String Sd_way) {
		setAttrVal("Sd_way", Sd_way);
	}
	public String getId_object() {
		return ((String) getAttrVal("Id_object"));
	}	
	public void setId_object(String Id_object) {
		setAttrVal("Id_object", Id_object);
	}
	public String getSd_object() {
		return ((String) getAttrVal("Sd_object"));
	}	
	public void setSd_object(String Sd_object) {
		setAttrVal("Sd_object", Sd_object);
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
	public String getName_item() {
		return ((String) getAttrVal("Name_item"));
	}	
	public void setName_item(String Name_item) {
		setAttrVal("Name_item", Name_item);
	}
	public String getName_item_par() {
		return ((String) getAttrVal("Name_item_par"));
	}	
	public void setName_item_par(String Name_item_par) {
		setAttrVal("Name_item_par", Name_item_par);
	}
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	public String getName_way() {
		return ((String) getAttrVal("Name_way"));
	}	
	public void setName_way(String Name_way) {
		setAttrVal("Name_way", Name_way);
	}
	public String getName_object() {
		return ((String) getAttrVal("Name_object"));
	}	
	public void setName_object(String Name_object) {
		setAttrVal("Name_object", Name_object);
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
		return "Id_evalsgl_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "NRM_HA_TCHO_EVLASGL_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(TchoEvaluateItmDODesc.class);
	}
	
}