package iih.bd.mm.mmcawareinfo.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.mm.mmcawareinfo.d.desc.MmcawareinfoDODesc;
import java.math.BigDecimal;

/**
 * 物品基本分类与仓库关系 DO数据 
 * 
 */
public class MmcawareinfoDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MMCAWH= "Id_mmcawh";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_WH= "Id_wh";
	public static final String MAXSTNUM= "Maxstnum";
	public static final String LOWSTNUM= "Lowstnum";
	public static final String ID_MMPKGUTP= "Id_mmpkgutp";
	public static final String ID_WH_SRV= "Id_wh_srv";
	public static final String ID_DEP= "Id_dep";
	public static final String ID_MMCA= "Id_mmca";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String WH_NAME= "Wh_name";
	public static final String MMPKGUTPNAME= "Mmpkgutpname";
	public static final String SRV_NAME= "Srv_name";
	public static final String DEP_NAME= "Dep_name";
	public static final String DEP_CODE= "Dep_code";
	public static final String MMCA_NAME= "Mmca_name";
	public static final String MMCA_CODE= "Mmca_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mmcawh() {
		return ((String) getAttrVal("Id_mmcawh"));
	}	
	public void setId_mmcawh(String Id_mmcawh) {
		setAttrVal("Id_mmcawh", Id_mmcawh);
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
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	public FDouble getMaxstnum() {
		return ((FDouble) getAttrVal("Maxstnum"));
	}	
	public void setMaxstnum(FDouble Maxstnum) {
		setAttrVal("Maxstnum", Maxstnum);
	}
	public FDouble getLowstnum() {
		return ((FDouble) getAttrVal("Lowstnum"));
	}	
	public void setLowstnum(FDouble Lowstnum) {
		setAttrVal("Lowstnum", Lowstnum);
	}
	public String getId_mmpkgutp() {
		return ((String) getAttrVal("Id_mmpkgutp"));
	}	
	public void setId_mmpkgutp(String Id_mmpkgutp) {
		setAttrVal("Id_mmpkgutp", Id_mmpkgutp);
	}
	public String getId_wh_srv() {
		return ((String) getAttrVal("Id_wh_srv"));
	}	
	public void setId_wh_srv(String Id_wh_srv) {
		setAttrVal("Id_wh_srv", Id_wh_srv);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public String getId_mmca() {
		return ((String) getAttrVal("Id_mmca"));
	}	
	public void setId_mmca(String Id_mmca) {
		setAttrVal("Id_mmca", Id_mmca);
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
	public String getWh_name() {
		return ((String) getAttrVal("Wh_name"));
	}	
	public void setWh_name(String Wh_name) {
		setAttrVal("Wh_name", Wh_name);
	}
	public String getMmpkgutpname() {
		return ((String) getAttrVal("Mmpkgutpname"));
	}	
	public void setMmpkgutpname(String Mmpkgutpname) {
		setAttrVal("Mmpkgutpname", Mmpkgutpname);
	}
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	public String getDep_code() {
		return ((String) getAttrVal("Dep_code"));
	}	
	public void setDep_code(String Dep_code) {
		setAttrVal("Dep_code", Dep_code);
	}
	public String getMmca_name() {
		return ((String) getAttrVal("Mmca_name"));
	}	
	public void setMmca_name(String Mmca_name) {
		setAttrVal("Mmca_name", Mmca_name);
	}
	public String getMmca_code() {
		return ((String) getAttrVal("Mmca_code"));
	}	
	public void setMmca_code(String Mmca_code) {
		setAttrVal("Mmca_code", Mmca_code);
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
		return "Id_mmcawh";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_MM_CAWH";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MmcawareinfoDODesc.class);
	}
	
}