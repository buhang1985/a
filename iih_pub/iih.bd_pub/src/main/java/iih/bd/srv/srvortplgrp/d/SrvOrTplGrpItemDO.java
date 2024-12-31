package iih.bd.srv.srvortplgrp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.srvortplgrp.d.desc.SrvOrTplGrpItemDODesc;
import java.math.BigDecimal;

/**
 * 医疗服务_医嘱模板项目 DO数据 
 * 
 */
public class SrvOrTplGrpItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SRVORTPLITM= "Id_srvortplitm";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_SRVORTPL= "Id_srvortpl";
	public static final String SORTNO= "Sortno";
	public static final String ID_SRVORTPLGR= "Id_srvortplgr";
	public static final String ID_SRV= "Id_srv";
	public static final String ID_USG= "Id_usg";
	public static final String ID_FREQ= "Id_freq";
	public static final String ID_UNIT_MED= "Id_unit_med";
	public static final String QUAN_MED= "Quan_med";
	public static final String FG_LONG= "Fg_long";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_srvortplitm() {
		return ((String) getAttrVal("Id_srvortplitm"));
	}	
	public void setId_srvortplitm(String Id_srvortplitm) {
		setAttrVal("Id_srvortplitm", Id_srvortplitm);
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
	
	public String getId_srvortpl() {
		return ((String) getAttrVal("Id_srvortpl"));
	}	
	public void setId_srvortpl(String Id_srvortpl) {
		setAttrVal("Id_srvortpl", Id_srvortpl);
	}
	
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}	
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	
	public String getId_srvortplgr() {
		return ((String) getAttrVal("Id_srvortplgr"));
	}	
	public void setId_srvortplgr(String Id_srvortplgr) {
		setAttrVal("Id_srvortplgr", Id_srvortplgr);
	}
	
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	
	public String getId_usg() {
		return ((String) getAttrVal("Id_usg"));
	}	
	public void setId_usg(String Id_usg) {
		setAttrVal("Id_usg", Id_usg);
	}
	
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}	
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	
	public String getId_unit_med() {
		return ((String) getAttrVal("Id_unit_med"));
	}	
	public void setId_unit_med(String Id_unit_med) {
		setAttrVal("Id_unit_med", Id_unit_med);
	}
	
	public String getQuan_med() {
		return ((String) getAttrVal("Quan_med"));
	}	
	public void setQuan_med(String Quan_med) {
		setAttrVal("Quan_med", Quan_med);
	}
	
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}	
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
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
		return "Id_srvortplitm";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_or_tpl_itm";
	}
	
	@Override
	public IDODesc getDODesc() {		
		return DescManager.getInstance().getDODesc(SrvOrTplGrpItemDODesc.class);
	}
	
}