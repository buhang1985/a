package iih.mp.orm.surgappconfirm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.orm.surgappconfirm.d.desc.SurgMmConfDODesc;
import java.math.BigDecimal;

/**
 * 手术卫材确认 DO数据 
 * 
 */
public class SurgMmConfDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_APOPMMCF= "Id_apopmmcf";
	public static final String ID_APOPCF= "Id_apopcf";
	public static final String ID_MM= "Id_mm";
	public static final String QUAN_CUR= "Quan_cur";
	public static final String NO_SORT= "No_sort";
	public static final String ID_SRV= "Id_srv";
	public static final String ID_SRVTP= "Id_srvtp";
	public static final String SD_SRVTP= "Sd_srvtp";
	public static final String ID_UNIT= "Id_unit";
	public static final String CONDITION= "Condition";
	public static final String MM_CODE= "Mm_code";
	public static final String MM_NAME= "Mm_name";
	public static final String MM_SPEC= "Mm_spec";
	public static final String SUP_NAME= "Sup_name";
	public static final String ID_SUP= "Id_sup";
	public static final String SRV_CODE= "Srv_code";
	public static final String SRV_NAME= "Srv_name";
	public static final String SRVTP_CODE= "Srvtp_code";
	public static final String SRVTP_NAME= "Srvtp_name";
	public static final String UNIT_NAME= "Unit_name";
	public static final String UNIT_CODE= "Unit_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_apopmmcf() {
		return ((String) getAttrVal("Id_apopmmcf"));
	}	
	public void setId_apopmmcf(String Id_apopmmcf) {
		setAttrVal("Id_apopmmcf", Id_apopmmcf);
	}
	public String getId_apopcf() {
		return ((String) getAttrVal("Id_apopcf"));
	}	
	public void setId_apopcf(String Id_apopcf) {
		setAttrVal("Id_apopcf", Id_apopcf);
	}
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	public Integer getQuan_cur() {
		return ((Integer) getAttrVal("Quan_cur"));
	}	
	public void setQuan_cur(Integer Quan_cur) {
		setAttrVal("Quan_cur", Quan_cur);
	}
	public Integer getNo_sort() {
		return ((Integer) getAttrVal("No_sort"));
	}	
	public void setNo_sort(Integer No_sort) {
		setAttrVal("No_sort", No_sort);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}	
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	public Integer getCondition() {
		return ((Integer) getAttrVal("Condition"));
	}	
	public void setCondition(Integer Condition) {
		setAttrVal("Condition", Condition);
	}
	public String getMm_code() {
		return ((String) getAttrVal("Mm_code"));
	}	
	public void setMm_code(String Mm_code) {
		setAttrVal("Mm_code", Mm_code);
	}
	public String getMm_name() {
		return ((String) getAttrVal("Mm_name"));
	}	
	public void setMm_name(String Mm_name) {
		setAttrVal("Mm_name", Mm_name);
	}
	public String getMm_spec() {
		return ((String) getAttrVal("Mm_spec"));
	}	
	public void setMm_spec(String Mm_spec) {
		setAttrVal("Mm_spec", Mm_spec);
	}
	public String getSup_name() {
		return ((String) getAttrVal("Sup_name"));
	}	
	public void setSup_name(String Sup_name) {
		setAttrVal("Sup_name", Sup_name);
	}
	public String getId_sup() {
		return ((String) getAttrVal("Id_sup"));
	}	
	public void setId_sup(String Id_sup) {
		setAttrVal("Id_sup", Id_sup);
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
	public String getSrvtp_code() {
		return ((String) getAttrVal("Srvtp_code"));
	}	
	public void setSrvtp_code(String Srvtp_code) {
		setAttrVal("Srvtp_code", Srvtp_code);
	}
	public String getSrvtp_name() {
		return ((String) getAttrVal("Srvtp_name"));
	}	
	public void setSrvtp_name(String Srvtp_name) {
		setAttrVal("Srvtp_name", Srvtp_name);
	}
	public String getUnit_name() {
		return ((String) getAttrVal("Unit_name"));
	}	
	public void setUnit_name(String Unit_name) {
		setAttrVal("Unit_name", Unit_name);
	}
	public String getUnit_code() {
		return ((String) getAttrVal("Unit_code"));
	}	
	public void setUnit_code(String Unit_code) {
		setAttrVal("Unit_code", Unit_code);
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
		return "Id_apopmmcf";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_orm_sug_mm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SurgMmConfDODesc.class);
	}
	
}