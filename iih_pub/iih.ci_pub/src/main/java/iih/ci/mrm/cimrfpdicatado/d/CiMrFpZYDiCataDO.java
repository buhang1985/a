package iih.ci.mrm.cimrfpdicatado.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrm.cimrfpdicatado.d.desc.CiMrFpZYDiCataDODesc;
import java.math.BigDecimal;

/**
 * 病案编目中医诊断 DO数据 
 * 
 */
public class CiMrFpZYDiCataDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MRFPZYDI= "Id_mrfpzydi";
	public static final String SORTNO= "Sortno";
	public static final String ID_DI= "Id_di";
	public static final String SD_DI= "Sd_di";
	public static final String NAME_DI= "Name_di";
	public static final String ID_DISLVL_INP= "Id_dislvl_inp";
	public static final String NAME_DISLVL_INP= "Name_dislvl_inp";
	public static final String ID_DI_TYPE= "Id_di_type";
	public static final String SD_DI_TYPE= "Sd_di_type";
	public static final String NAME_DI_TYPE= "Name_di_type";
	public static final String ID_MRFPDI= "Id_mrfpdi";
	public static final String ID_SYNDROME= "Id_syndrome";
	public static final String SD_SYNDROME= "Sd_syndrome";
	public static final String NAME_SYNDROME= "Name_syndrome";
	public static final String FG_MAINDI= "Fg_maindi";
	public static final String ID_TREATMENT_OUTCOME= "Id_treatment_outcome";
	public static final String NAME_TREATMENT_OUTCOME= "Name_treatment_outcome";
	public static final String SD_TREATMENT_OUTCOME= "Sd_treatment_outcome";
	public static final String SD_DI_CODE= "Sd_di_code";
	public static final String DI_NAME= "Di_name";
	public static final String DI_TYPE_CODE= "Di_type_code";
	public static final String DI_TYPE_NAME= "Di_type_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mrfpzydi() {
		return ((String) getAttrVal("Id_mrfpzydi"));
	}	
	public void setId_mrfpzydi(String Id_mrfpzydi) {
		setAttrVal("Id_mrfpzydi", Id_mrfpzydi);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}	
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	public String getSd_di() {
		return ((String) getAttrVal("Sd_di"));
	}	
	public void setSd_di(String Sd_di) {
		setAttrVal("Sd_di", Sd_di);
	}
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}	
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
	}
	public Integer getId_dislvl_inp() {
		return ((Integer) getAttrVal("Id_dislvl_inp"));
	}	
	public void setId_dislvl_inp(Integer Id_dislvl_inp) {
		setAttrVal("Id_dislvl_inp", Id_dislvl_inp);
	}
	public String getName_dislvl_inp() {
		return ((String) getAttrVal("Name_dislvl_inp"));
	}	
	public void setName_dislvl_inp(String Name_dislvl_inp) {
		setAttrVal("Name_dislvl_inp", Name_dislvl_inp);
	}
	public String getId_di_type() {
		return ((String) getAttrVal("Id_di_type"));
	}	
	public void setId_di_type(String Id_di_type) {
		setAttrVal("Id_di_type", Id_di_type);
	}
	public String getSd_di_type() {
		return ((String) getAttrVal("Sd_di_type"));
	}	
	public void setSd_di_type(String Sd_di_type) {
		setAttrVal("Sd_di_type", Sd_di_type);
	}
	public String getName_di_type() {
		return ((String) getAttrVal("Name_di_type"));
	}	
	public void setName_di_type(String Name_di_type) {
		setAttrVal("Name_di_type", Name_di_type);
	}
	public String getId_mrfpdi() {
		return ((String) getAttrVal("Id_mrfpdi"));
	}	
	public void setId_mrfpdi(String Id_mrfpdi) {
		setAttrVal("Id_mrfpdi", Id_mrfpdi);
	}
	public String getId_syndrome() {
		return ((String) getAttrVal("Id_syndrome"));
	}	
	public void setId_syndrome(String Id_syndrome) {
		setAttrVal("Id_syndrome", Id_syndrome);
	}
	public String getSd_syndrome() {
		return ((String) getAttrVal("Sd_syndrome"));
	}	
	public void setSd_syndrome(String Sd_syndrome) {
		setAttrVal("Sd_syndrome", Sd_syndrome);
	}
	public String getName_syndrome() {
		return ((String) getAttrVal("Name_syndrome"));
	}	
	public void setName_syndrome(String Name_syndrome) {
		setAttrVal("Name_syndrome", Name_syndrome);
	}
	public FBoolean getFg_maindi() {
		return ((FBoolean) getAttrVal("Fg_maindi"));
	}	
	public void setFg_maindi(FBoolean Fg_maindi) {
		setAttrVal("Fg_maindi", Fg_maindi);
	}
	public String getId_treatment_outcome() {
		return ((String) getAttrVal("Id_treatment_outcome"));
	}	
	public void setId_treatment_outcome(String Id_treatment_outcome) {
		setAttrVal("Id_treatment_outcome", Id_treatment_outcome);
	}
	public String getName_treatment_outcome() {
		return ((String) getAttrVal("Name_treatment_outcome"));
	}	
	public void setName_treatment_outcome(String Name_treatment_outcome) {
		setAttrVal("Name_treatment_outcome", Name_treatment_outcome);
	}
	public String getSd_treatment_outcome() {
		return ((String) getAttrVal("Sd_treatment_outcome"));
	}	
	public void setSd_treatment_outcome(String Sd_treatment_outcome) {
		setAttrVal("Sd_treatment_outcome", Sd_treatment_outcome);
	}
	public String getSd_di_code() {
		return ((String) getAttrVal("Sd_di_code"));
	}	
	public void setSd_di_code(String Sd_di_code) {
		setAttrVal("Sd_di_code", Sd_di_code);
	}
	public String getDi_name() {
		return ((String) getAttrVal("Di_name"));
	}	
	public void setDi_name(String Di_name) {
		setAttrVal("Di_name", Di_name);
	}
	public String getDi_type_code() {
		return ((String) getAttrVal("Di_type_code"));
	}	
	public void setDi_type_code(String Di_type_code) {
		setAttrVal("Di_type_code", Di_type_code);
	}
	public String getDi_type_name() {
		return ((String) getAttrVal("Di_type_name"));
	}	
	public void setDi_type_name(String Di_type_name) {
		setAttrVal("Di_type_name", Di_type_name);
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
		return "Id_mrfpzydi";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_FP_ZYDI_Cata";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrFpZYDiCataDODesc.class);
	}
	
}