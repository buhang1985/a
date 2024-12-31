package iih.pe.pbd.peappttladder.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pbd.peappttladder.d.desc.PeAppttLadderDODesc;
import java.math.BigDecimal;

/**
 * 体检预约时间段定义 DO数据 
 * 
 */
public class PeAppttLadderDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEAPPTTLADDER= "Id_peappttladder";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String TIME_BEGIN= "Time_begin";
	public static final String TIME_END= "Time_end";
	public static final String SORTNO= "Sortno";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String DES= "Des";
	public static final String PSNLIMIT= "Psnlimit";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_peappttladder() {
		return ((String) getAttrVal("Id_peappttladder"));
	}	
	public void setId_peappttladder(String Id_peappttladder) {
		setAttrVal("Id_peappttladder", Id_peappttladder);
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
	public FTime getTime_begin() {
		return ((FTime) getAttrVal("Time_begin"));
	}	
	public void setTime_begin(FTime Time_begin) {
		setAttrVal("Time_begin", Time_begin);
	}
	public FTime getTime_end() {
		return ((FTime) getAttrVal("Time_end"));
	}	
	public void setTime_end(FTime Time_end) {
		setAttrVal("Time_end", Time_end);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public Integer getPsnlimit() {
		return ((Integer) getAttrVal("Psnlimit"));
	}	
	public void setPsnlimit(Integer Psnlimit) {
		setAttrVal("Psnlimit", Psnlimit);
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
		return "Id_peappttladder";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_bd_peappttladder";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeAppttLadderDODesc.class);
	}
	
}