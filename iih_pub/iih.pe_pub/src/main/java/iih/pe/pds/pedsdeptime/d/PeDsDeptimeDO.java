package iih.pe.pds.pedsdeptime.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pds.pedsdeptime.d.desc.PeDsDeptimeDODesc;
import java.math.BigDecimal;

/**
 * 体检科室检查时间优化 DO数据 
 * 
 */
public class PeDsDeptimeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEDSDEPTIME= "Id_pedsdeptime";
	public static final String ID_PEDSDEPTIME_PAR= "Id_pedsdeptime_par";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String DT_BEGIN= "Dt_begin";
	public static final String DT_END= "Dt_end";
	public static final String FG_OPTIMIZE= "Fg_optimize";
	public static final String DT_OPTIMIZE= "Dt_optimize";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pedsdeptime() {
		return ((String) getAttrVal("Id_pedsdeptime"));
	}	
	public void setId_pedsdeptime(String Id_pedsdeptime) {
		setAttrVal("Id_pedsdeptime", Id_pedsdeptime);
	}
	public String getId_pedsdeptime_par() {
		return ((String) getAttrVal("Id_pedsdeptime_par"));
	}	
	public void setId_pedsdeptime_par(String Id_pedsdeptime_par) {
		setAttrVal("Id_pedsdeptime_par", Id_pedsdeptime_par);
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
	public FDate getDt_begin() {
		return ((FDate) getAttrVal("Dt_begin"));
	}	
	public void setDt_begin(FDate Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	public FBoolean getFg_optimize() {
		return ((FBoolean) getAttrVal("Fg_optimize"));
	}	
	public void setFg_optimize(FBoolean Fg_optimize) {
		setAttrVal("Fg_optimize", Fg_optimize);
	}
	public FDate getDt_optimize() {
		return ((FDate) getAttrVal("Dt_optimize"));
	}	
	public void setDt_optimize(FDate Dt_optimize) {
		setAttrVal("Dt_optimize", Dt_optimize);
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
		return "Id_pedsdeptime";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_ds_pedsdeptime";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeDsDeptimeDODesc.class);
	}
	
}