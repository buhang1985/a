package iih.bd.srv.ext.medsrvvalidate.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.ext.medsrvvalidate.d.desc.MedSrvValidateResultDesc;
import java.math.BigDecimal;

/**
 * 服务校验结果 DO数据 
 * 
 */
public class MedSrvValidateResult extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_RESULT= "Id_result";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_SRV= "Id_srv";
	public static final String ID_MM= "Id_mm";
	public static final String ID_SRVCA= "Id_srvca";
	public static final String CODE_SRVCA= "Code_srvca";
	public static final String ID_SRVTP= "Id_srvtp";
	public static final String SD_SRVTP= "Sd_srvtp";
	public static final String DATA_SOURCE= "Data_source";
	public static final String RESULT_TYPE= "Result_type";
	public static final String VALIDATE_RESULT= "Validate_result";
	public static final String CODE_SRV= "Code_srv";
	public static final String NAME_SRV= "Name_srv";
	public static final String CODE_MM= "Code_mm";
	public static final String ID_MMCA= "Id_mmca";
	public static final String SD_MMTP= "Sd_mmtp";
	public static final String ID_MMTP= "Id_mmtp";
	public static final String NAME_MM= "Name_mm";
	public static final String NAME_SRVCA= "Name_srvca";
	public static final String NAME_SRVTP= "Name_srvtp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_result() {
		return ((String) getAttrVal("Id_result"));
	}	
	public void setId_result(String Id_result) {
		setAttrVal("Id_result", Id_result);
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
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}	
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	public String getCode_srvca() {
		return ((String) getAttrVal("Code_srvca"));
	}	
	public void setCode_srvca(String Code_srvca) {
		setAttrVal("Code_srvca", Code_srvca);
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
	public String getData_source() {
		return ((String) getAttrVal("Data_source"));
	}	
	public void setData_source(String Data_source) {
		setAttrVal("Data_source", Data_source);
	}
	public String getResult_type() {
		return ((String) getAttrVal("Result_type"));
	}	
	public void setResult_type(String Result_type) {
		setAttrVal("Result_type", Result_type);
	}
	public String getValidate_result() {
		return ((String) getAttrVal("Validate_result"));
	}	
	public void setValidate_result(String Validate_result) {
		setAttrVal("Validate_result", Validate_result);
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
	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}	
	public void setCode_mm(String Code_mm) {
		setAttrVal("Code_mm", Code_mm);
	}
	public String getId_mmca() {
		return ((String) getAttrVal("Id_mmca"));
	}	
	public void setId_mmca(String Id_mmca) {
		setAttrVal("Id_mmca", Id_mmca);
	}
	public String getSd_mmtp() {
		return ((String) getAttrVal("Sd_mmtp"));
	}	
	public void setSd_mmtp(String Sd_mmtp) {
		setAttrVal("Sd_mmtp", Sd_mmtp);
	}
	public String getId_mmtp() {
		return ((String) getAttrVal("Id_mmtp"));
	}	
	public void setId_mmtp(String Id_mmtp) {
		setAttrVal("Id_mmtp", Id_mmtp);
	}
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}	
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	public String getName_srvca() {
		return ((String) getAttrVal("Name_srvca"));
	}	
	public void setName_srvca(String Name_srvca) {
		setAttrVal("Name_srvca", Name_srvca);
	}
	public String getName_srvtp() {
		return ((String) getAttrVal("Name_srvtp"));
	}	
	public void setName_srvtp(String Name_srvtp) {
		setAttrVal("Name_srvtp", Name_srvtp);
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
		return "Id_result";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_validate_result";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MedSrvValidateResultDesc.class);
	}
	
}