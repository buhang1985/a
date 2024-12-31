package iih.pe.pbd.qrycond.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pbd.qrycond.d.desc.QryCondItmDODesc;
import java.math.BigDecimal;

/**
 * 查询条件项目 DO数据 
 * 
 */
public class QryCondItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_QRY_COND_ITM= "Id_qry_cond_itm";
	public static final String ID_QRY_COND= "Id_qry_cond";
	public static final String ID_CONDTP= "Id_condtp";
	public static final String SD_CONDTP= "Sd_condtp";
	public static final String ID_OPERATP= "Id_operatp";
	public static final String SD_OPERATP= "Sd_operatp";
	public static final String ID_VAL= "Id_val";
	public static final String VAL= "Val";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_CONDTP= "Name_condtp";
	public static final String FILTER_CONDITON= "Filter_conditon";
	public static final String FILTER_RELATION= "Filter_relation";
	public static final String NAME_OPERATP= "Name_operatp";
	public static final String FILTER_CONDTP= "Filter_condtp";
	public static final String NAME_VAL= "Name_val";
	public static final String VAL_CODE= "Val_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_qry_cond_itm() {
		return ((String) getAttrVal("Id_qry_cond_itm"));
	}	
	public void setId_qry_cond_itm(String Id_qry_cond_itm) {
		setAttrVal("Id_qry_cond_itm", Id_qry_cond_itm);
	}
	public String getId_qry_cond() {
		return ((String) getAttrVal("Id_qry_cond"));
	}	
	public void setId_qry_cond(String Id_qry_cond) {
		setAttrVal("Id_qry_cond", Id_qry_cond);
	}
	public String getId_condtp() {
		return ((String) getAttrVal("Id_condtp"));
	}	
	public void setId_condtp(String Id_condtp) {
		setAttrVal("Id_condtp", Id_condtp);
	}
	public String getSd_condtp() {
		return ((String) getAttrVal("Sd_condtp"));
	}	
	public void setSd_condtp(String Sd_condtp) {
		setAttrVal("Sd_condtp", Sd_condtp);
	}
	public String getId_operatp() {
		return ((String) getAttrVal("Id_operatp"));
	}	
	public void setId_operatp(String Id_operatp) {
		setAttrVal("Id_operatp", Id_operatp);
	}
	public String getSd_operatp() {
		return ((String) getAttrVal("Sd_operatp"));
	}	
	public void setSd_operatp(String Sd_operatp) {
		setAttrVal("Sd_operatp", Sd_operatp);
	}
	public String getId_val() {
		return ((String) getAttrVal("Id_val"));
	}	
	public void setId_val(String Id_val) {
		setAttrVal("Id_val", Id_val);
	}
	public FDouble getVal() {
		return ((FDouble) getAttrVal("Val"));
	}	
	public void setVal(FDouble Val) {
		setAttrVal("Val", Val);
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
	public String getName_condtp() {
		return ((String) getAttrVal("Name_condtp"));
	}	
	public void setName_condtp(String Name_condtp) {
		setAttrVal("Name_condtp", Name_condtp);
	}
	public String getFilter_conditon() {
		return ((String) getAttrVal("Filter_conditon"));
	}	
	public void setFilter_conditon(String Filter_conditon) {
		setAttrVal("Filter_conditon", Filter_conditon);
	}
	public String getFilter_relation() {
		return ((String) getAttrVal("Filter_relation"));
	}	
	public void setFilter_relation(String Filter_relation) {
		setAttrVal("Filter_relation", Filter_relation);
	}
	public String getName_operatp() {
		return ((String) getAttrVal("Name_operatp"));
	}	
	public void setName_operatp(String Name_operatp) {
		setAttrVal("Name_operatp", Name_operatp);
	}
	public String getFilter_condtp() {
		return ((String) getAttrVal("Filter_condtp"));
	}	
	public void setFilter_condtp(String Filter_condtp) {
		setAttrVal("Filter_condtp", Filter_condtp);
	}
	public String getName_val() {
		return ((String) getAttrVal("Name_val"));
	}	
	public void setName_val(String Name_val) {
		setAttrVal("Name_val", Name_val);
	}
	public String getVal_code() {
		return ((String) getAttrVal("Val_code"));
	}	
	public void setVal_code(String Val_code) {
		setAttrVal("Val_code", Val_code);
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
		return "Id_qry_cond_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "PE_PBD_QYR_COND_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(QryCondItmDODesc.class);
	}
	
}