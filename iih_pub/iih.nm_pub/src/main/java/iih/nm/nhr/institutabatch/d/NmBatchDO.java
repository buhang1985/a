package iih.nm.nhr.institutabatch.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.institutabatch.d.desc.NmBatchDODesc;
import java.math.BigDecimal;

/**
 * 实习批次 DO数据 
 * 
 */
public class NmBatchDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_BATCH= "Id_batch";
	public static final String ID_STU_ORG= "Id_stu_org";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String NAME= "Name";
	public static final String NO_BATCH= "No_batch";
	public static final String YEAR= "Year";
	public static final String ID_EDUCATION= "Id_education";
	public static final String SD_EDUCATION= "Sd_education";
	public static final String DT_BEGIN= "Dt_begin";
	public static final String DT_END= "Dt_end";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
	public static final String NAME_HEAD= "Name_head";
	public static final String TEL_HEAD= "Tel_head";
	public static final String NAME_CONTACT= "Name_contact";
	public static final String TEL_CONTACT= "Tel_contact";
	public static final String ID_EMP_REG= "Id_emp_reg";
	public static final String DT_REG= "Dt_reg";
	public static final String DES= "Des";
	public static final String NAME_STU_ORG= "Name_stu_org";
	public static final String CODE_STU_ORG= "Code_stu_org";
	public static final String NAME_ORG= "Name_org";
	public static final String NAME_GRP= "Name_grp";
	public static final String CODE_EDUCATE= "Code_educate";
	public static final String NAME_EDUCATE= "Name_educate";
	public static final String NAME_EMP_REG= "Name_emp_reg";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_batch() {
		return ((String) getAttrVal("Id_batch"));
	}	
	public void setId_batch(String Id_batch) {
		setAttrVal("Id_batch", Id_batch);
	}
	public String getId_stu_org() {
		return ((String) getAttrVal("Id_stu_org"));
	}	
	public void setId_stu_org(String Id_stu_org) {
		setAttrVal("Id_stu_org", Id_stu_org);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getNo_batch() {
		return ((String) getAttrVal("No_batch"));
	}	
	public void setNo_batch(String No_batch) {
		setAttrVal("No_batch", No_batch);
	}
	public Integer getYear() {
		return ((Integer) getAttrVal("Year"));
	}	
	public void setYear(Integer Year) {
		setAttrVal("Year", Year);
	}
	public String getId_education() {
		return ((String) getAttrVal("Id_education"));
	}	
	public void setId_education(String Id_education) {
		setAttrVal("Id_education", Id_education);
	}
	public String getSd_education() {
		return ((String) getAttrVal("Sd_education"));
	}	
	public void setSd_education(String Sd_education) {
		setAttrVal("Sd_education", Sd_education);
	}
	public FDate getDt_begin() {
		return ((FDate) getAttrVal("Dt_begin"));
	}	
	public void setDt_begin(FDate Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	public String getName_head() {
		return ((String) getAttrVal("Name_head"));
	}	
	public void setName_head(String Name_head) {
		setAttrVal("Name_head", Name_head);
	}
	public String getTel_head() {
		return ((String) getAttrVal("Tel_head"));
	}	
	public void setTel_head(String Tel_head) {
		setAttrVal("Tel_head", Tel_head);
	}
	public String getName_contact() {
		return ((String) getAttrVal("Name_contact"));
	}	
	public void setName_contact(String Name_contact) {
		setAttrVal("Name_contact", Name_contact);
	}
	public String getTel_contact() {
		return ((String) getAttrVal("Tel_contact"));
	}	
	public void setTel_contact(String Tel_contact) {
		setAttrVal("Tel_contact", Tel_contact);
	}
	public String getId_emp_reg() {
		return ((String) getAttrVal("Id_emp_reg"));
	}	
	public void setId_emp_reg(String Id_emp_reg) {
		setAttrVal("Id_emp_reg", Id_emp_reg);
	}
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}	
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getName_stu_org() {
		return ((String) getAttrVal("Name_stu_org"));
	}	
	public void setName_stu_org(String Name_stu_org) {
		setAttrVal("Name_stu_org", Name_stu_org);
	}
	public String getCode_stu_org() {
		return ((String) getAttrVal("Code_stu_org"));
	}	
	public void setCode_stu_org(String Code_stu_org) {
		setAttrVal("Code_stu_org", Code_stu_org);
	}
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	public String getCode_educate() {
		return ((String) getAttrVal("Code_educate"));
	}	
	public void setCode_educate(String Code_educate) {
		setAttrVal("Code_educate", Code_educate);
	}
	public String getName_educate() {
		return ((String) getAttrVal("Name_educate"));
	}	
	public void setName_educate(String Name_educate) {
		setAttrVal("Name_educate", Name_educate);
	}
	public String getName_emp_reg() {
		return ((String) getAttrVal("Name_emp_reg"));
	}	
	public void setName_emp_reg(String Name_emp_reg) {
		setAttrVal("Name_emp_reg", Name_emp_reg);
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
		return "Id_batch";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_BATCH";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmBatchDODesc.class);
	}
	
}