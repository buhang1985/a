package iih.bd.res.workstation.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.res.workstation.d.desc.WorkStationParamDODesc;
import java.math.BigDecimal;

/**
 * 计算机工作站参数 DO数据 
 * 
 */
public class WorkStationParamDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PCPARA= "Id_pcpara";
	public static final String ID_PC= "Id_pc";
	public static final String ID_XPPARA= "Id_xppara";
	public static final String VAL= "Val";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String NOTE= "Note";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pcpara() {
		return ((String) getAttrVal("Id_pcpara"));
	}	
	public void setId_pcpara(String Id_pcpara) {
		setAttrVal("Id_pcpara", Id_pcpara);
	}
	public String getId_pc() {
		return ((String) getAttrVal("Id_pc"));
	}	
	public void setId_pc(String Id_pc) {
		setAttrVal("Id_pc", Id_pc);
	}
	public String getId_xppara() {
		return ((String) getAttrVal("Id_xppara"));
	}	
	public void setId_xppara(String Id_xppara) {
		setAttrVal("Id_xppara", Id_xppara);
	}
	public String getVal() {
		return ((String) getAttrVal("Val"));
	}	
	public void setVal(String Val) {
		setAttrVal("Val", Val);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
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
		return "Id_pcpara";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_pc_para";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(WorkStationParamDODesc.class);
	}
	
}