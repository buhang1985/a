package iih.ci.ord.app.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.app.d.desc.CiAppBtItemSheetDODesc;
import java.math.BigDecimal;

/**
 * 备血观察检验指标 DO数据 
 * 
 */
public class CiAppBtItemSheetDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CIAPPBTSHEET_ITEM= "Id_ciappbtsheet_item";
	public static final String ID_APBTOBSINDEX= "Id_apbtobsindex";
	public static final String ID_CIAPPBTSHEET= "Id_ciappbtsheet";
	public static final String ID_SRV= "Id_srv";
	public static final String CODE_SRV= "Code_srv";
	public static final String NAME_SRV= "Name_srv";
	public static final String VAL_RSTRPTLA= "Val_rstrptla";
	public static final String ID_UNIT= "Id_unit";
	public static final String NAME_UNIT= "Name_unit";
	public static final String VAL_RESTRPTLAB= "Val_restrptlab";
	public static final String SD_RESTRPTLABTP= "Sd_restrptlabtp";
	public static final String ID_RESTRPTLABTP= "Id_restrptlabtp";
	public static final String REPORTTIME= "Reporttime";
	public static final String BARCODE= "Barcode";
	public static final String FG_ALLOWEMPTY= "Fg_allowempty";
	public static final String SORTNO= "Sortno";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ciappbtsheet_item() {
		return ((String) getAttrVal("Id_ciappbtsheet_item"));
	}	
	public void setId_ciappbtsheet_item(String Id_ciappbtsheet_item) {
		setAttrVal("Id_ciappbtsheet_item", Id_ciappbtsheet_item);
	}
	public String getId_apbtobsindex() {
		return ((String) getAttrVal("Id_apbtobsindex"));
	}	
	public void setId_apbtobsindex(String Id_apbtobsindex) {
		setAttrVal("Id_apbtobsindex", Id_apbtobsindex);
	}
	public String getId_ciappbtsheet() {
		return ((String) getAttrVal("Id_ciappbtsheet"));
	}	
	public void setId_ciappbtsheet(String Id_ciappbtsheet) {
		setAttrVal("Id_ciappbtsheet", Id_ciappbtsheet);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}	
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	public String getVal_rstrptla() {
		return ((String) getAttrVal("Val_rstrptla"));
	}	
	public void setVal_rstrptla(String Val_rstrptla) {
		setAttrVal("Val_rstrptla", Val_rstrptla);
	}
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}	
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}	
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
	}
	public String getVal_restrptlab() {
		return ((String) getAttrVal("Val_restrptlab"));
	}	
	public void setVal_restrptlab(String Val_restrptlab) {
		setAttrVal("Val_restrptlab", Val_restrptlab);
	}
	public String getSd_restrptlabtp() {
		return ((String) getAttrVal("Sd_restrptlabtp"));
	}	
	public void setSd_restrptlabtp(String Sd_restrptlabtp) {
		setAttrVal("Sd_restrptlabtp", Sd_restrptlabtp);
	}
	public String getId_restrptlabtp() {
		return ((String) getAttrVal("Id_restrptlabtp"));
	}	
	public void setId_restrptlabtp(String Id_restrptlabtp) {
		setAttrVal("Id_restrptlabtp", Id_restrptlabtp);
	}
	public FDateTime getReporttime() {
		return ((FDateTime) getAttrVal("Reporttime"));
	}	
	public void setReporttime(FDateTime Reporttime) {
		setAttrVal("Reporttime", Reporttime);
	}
	public String getBarcode() {
		return ((String) getAttrVal("Barcode"));
	}	
	public void setBarcode(String Barcode) {
		setAttrVal("Barcode", Barcode);
	}
	public FBoolean getFg_allowempty() {
		return ((FBoolean) getAttrVal("Fg_allowempty"));
	}	
	public void setFg_allowempty(FBoolean Fg_allowempty) {
		setAttrVal("Fg_allowempty", Fg_allowempty);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
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
		return "Id_ciappbtsheet_item";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_app_bt_item";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiAppBtItemSheetDODesc.class);
	}
	
}