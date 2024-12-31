package iih.bd.srv.outputtemplate.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.outputtemplate.d.desc.OutputTemplateMedRedTypeDODesc;
import java.math.BigDecimal;

/**
 * 输出模板对应病案类型 DO数据 
 * 
 */
public class OutputTemplateMedRedTypeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_BD_MRM_PP_TP= "Id_bd_mrm_pp_tp";
	public static final String ID_BD_MRM_PT= "Id_bd_mrm_pt";
	public static final String ID_BD_MRM_TP= "Id_bd_mrm_tp";
	public static final String OUTPUTTEMPLATE_NAME= "Outputtemplate_name";
	public static final String OUTPUTTEMPLATE_CODE= "Outputtemplate_code";
	public static final String MRMTYPE_NAME= "Mrmtype_name";
	public static final String MRMTYPE_CODE= "Mrmtype_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_bd_mrm_pp_tp() {
		return ((String) getAttrVal("Id_bd_mrm_pp_tp"));
	}	
	public void setId_bd_mrm_pp_tp(String Id_bd_mrm_pp_tp) {
		setAttrVal("Id_bd_mrm_pp_tp", Id_bd_mrm_pp_tp);
	}
	public String getId_bd_mrm_pt() {
		return ((String) getAttrVal("Id_bd_mrm_pt"));
	}	
	public void setId_bd_mrm_pt(String Id_bd_mrm_pt) {
		setAttrVal("Id_bd_mrm_pt", Id_bd_mrm_pt);
	}
	public String getId_bd_mrm_tp() {
		return ((String) getAttrVal("Id_bd_mrm_tp"));
	}	
	public void setId_bd_mrm_tp(String Id_bd_mrm_tp) {
		setAttrVal("Id_bd_mrm_tp", Id_bd_mrm_tp);
	}
	public String getOutputtemplate_name() {
		return ((String) getAttrVal("Outputtemplate_name"));
	}	
	public void setOutputtemplate_name(String Outputtemplate_name) {
		setAttrVal("Outputtemplate_name", Outputtemplate_name);
	}
	public String getOutputtemplate_code() {
		return ((String) getAttrVal("Outputtemplate_code"));
	}	
	public void setOutputtemplate_code(String Outputtemplate_code) {
		setAttrVal("Outputtemplate_code", Outputtemplate_code);
	}
	public String getMrmtype_name() {
		return ((String) getAttrVal("Mrmtype_name"));
	}	
	public void setMrmtype_name(String Mrmtype_name) {
		setAttrVal("Mrmtype_name", Mrmtype_name);
	}
	public String getMrmtype_code() {
		return ((String) getAttrVal("Mrmtype_code"));
	}	
	public void setMrmtype_code(String Mrmtype_code) {
		setAttrVal("Mrmtype_code", Mrmtype_code);
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
		return "Id_bd_mrm_pp_tp";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mrm_pt_tp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OutputTemplateMedRedTypeDODesc.class);
	}
	
}