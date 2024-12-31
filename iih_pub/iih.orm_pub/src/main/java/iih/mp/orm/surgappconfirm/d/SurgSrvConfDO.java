package iih.mp.orm.surgappconfirm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.orm.surgappconfirm.d.desc.SurgSrvConfDODesc;
import java.math.BigDecimal;

/**
 * 手术附加术确认 DO数据 
 * 
 */
public class SurgSrvConfDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_APOPSRVCF= "Id_apopsrvcf";
	public static final String ID_APOPCF= "Id_apopcf";
	public static final String ID_SRV= "Id_srv";
	public static final String DES= "Des";
	public static final String NO_SORT= "No_sort";
	public static final String SRV_CODE= "Srv_code";
	public static final String SRV_NAME= "Srv_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_apopsrvcf() {
		return ((String) getAttrVal("Id_apopsrvcf"));
	}	
	public void setId_apopsrvcf(String Id_apopsrvcf) {
		setAttrVal("Id_apopsrvcf", Id_apopsrvcf);
	}
	public String getId_apopcf() {
		return ((String) getAttrVal("Id_apopcf"));
	}	
	public void setId_apopcf(String Id_apopcf) {
		setAttrVal("Id_apopcf", Id_apopcf);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public Integer getNo_sort() {
		return ((Integer) getAttrVal("No_sort"));
	}	
	public void setNo_sort(Integer No_sort) {
		setAttrVal("No_sort", No_sort);
	}
	public String getSrv_code() {
		return ((String) getAttrVal("Srv_code"));
	}	
	public void setSrv_code(String Srv_code) {
		setAttrVal("Srv_code", Srv_code);
	}
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
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
		return "Id_apopsrvcf";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_orm_sug_srv";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SurgSrvConfDODesc.class);
	}
	
}