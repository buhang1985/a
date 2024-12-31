package iih.ci.rcm.specimen.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.specimen.d.desc.SpecimenDODesc;
import java.math.BigDecimal;

/**
 * ICU病例监测_标本 DO数据 
 * 
 */
public class SpecimenDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//标本主键
	public static final String ID_SPECIMENPK= "Id_specimenpk";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//导管主键
	public static final String ID_CATHETER= "Id_catheter";
	//标本
	public static final String ID_SPECIMEN= "Id_specimen";
	//标本编码
	public static final String SD_SPECIMEN= "Sd_specimen";
	//标本名称
	public static final String NAME_SPECIMEN= "Name_specimen";
	//感染部位
	public static final String ID_INFE_SITE= "Id_infe_site";
	//感染部位编码
	public static final String SD_INFE_SITE= "Sd_infe_site";
	//感染部位名称
	public static final String NAME_INFE_SITE= "Name_infe_site";
	//送检日期
	public static final String SUBMISSION_DATE= "Submission_date";
	//检验方法
	public static final String ID_TEST_METHOD= "Id_test_method";
	//检验方法编码
	public static final String SD_TEST_METHOD= "Sd_test_method";
	//检验方法名称
	public static final String NAME_TEST_METHOD= "Name_test_method";
	//白细胞数
	public static final String COUNE_WHITEBLOODCELL= "Coune_whitebloodcell";
	//报警时间
	public static final String TIMES_ALARM= "Times_alarm";
	//检验结果
	public static final String ID_SPE_TEST_RESULT= "Id_spe_test_result";
	//检验结果编码
	public static final String SD_SPE_TEST_RESULT= "Sd_spe_test_result";
	//检验结果名称
	public static final String NAME_SPE_TEST_RESULT= "Name_spe_test_result";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//组织编码
	public static final String ORG_CODE= "Org_code";
	//组织名称
	public static final String ORG_NAME= "Org_name";
	//编码
	public static final String GRP_CODE= "Grp_code";
	//名称
	public static final String GRP_NAME= "Grp_name";
	//编码
	public static final String SPECIMEN_CODE= "Specimen_code";
	//名称
	public static final String SPECIMEN_NAME= "Specimen_name";
	//编码
	public static final String INFE_SITE_CODE= "Infe_site_code";
	//名称
	public static final String INFE_SITE_NAME= "Infe_site_name";
	//编码
	public static final String TEST_METHOD_CODE= "Test_method_code";
	//名称
	public static final String TEST_METHOD_NAME= "Test_method_name";
	//编码
	public static final String SPE_TEST_RESULT_CODE= "Spe_test_result_code";
	//名称
	public static final String SPE_TEST_RESULT_NAME= "Spe_test_result_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 标本主键
	 * @return String
	 */
	public String getId_specimenpk() {
		return ((String) getAttrVal("Id_specimenpk"));
	}	
	/**
	 * 标本主键
	 * @param Id_specimenpk
	 */
	public void setId_specimenpk(String Id_specimenpk) {
		setAttrVal("Id_specimenpk", Id_specimenpk);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 导管主键
	 * @return String
	 */
	public String getId_catheter() {
		return ((String) getAttrVal("Id_catheter"));
	}	
	/**
	 * 导管主键
	 * @param Id_catheter
	 */
	public void setId_catheter(String Id_catheter) {
		setAttrVal("Id_catheter", Id_catheter);
	}
	/**
	 * 标本
	 * @return String
	 */
	public String getId_specimen() {
		return ((String) getAttrVal("Id_specimen"));
	}	
	/**
	 * 标本
	 * @param Id_specimen
	 */
	public void setId_specimen(String Id_specimen) {
		setAttrVal("Id_specimen", Id_specimen);
	}
	/**
	 * 标本编码
	 * @return String
	 */
	public String getSd_specimen() {
		return ((String) getAttrVal("Sd_specimen"));
	}	
	/**
	 * 标本编码
	 * @param Sd_specimen
	 */
	public void setSd_specimen(String Sd_specimen) {
		setAttrVal("Sd_specimen", Sd_specimen);
	}
	/**
	 * 标本名称
	 * @return String
	 */
	public String getName_specimen() {
		return ((String) getAttrVal("Name_specimen"));
	}	
	/**
	 * 标本名称
	 * @param Name_specimen
	 */
	public void setName_specimen(String Name_specimen) {
		setAttrVal("Name_specimen", Name_specimen);
	}
	/**
	 * 感染部位
	 * @return String
	 */
	public String getId_infe_site() {
		return ((String) getAttrVal("Id_infe_site"));
	}	
	/**
	 * 感染部位
	 * @param Id_infe_site
	 */
	public void setId_infe_site(String Id_infe_site) {
		setAttrVal("Id_infe_site", Id_infe_site);
	}
	/**
	 * 感染部位编码
	 * @return String
	 */
	public String getSd_infe_site() {
		return ((String) getAttrVal("Sd_infe_site"));
	}	
	/**
	 * 感染部位编码
	 * @param Sd_infe_site
	 */
	public void setSd_infe_site(String Sd_infe_site) {
		setAttrVal("Sd_infe_site", Sd_infe_site);
	}
	/**
	 * 感染部位名称
	 * @return String
	 */
	public String getName_infe_site() {
		return ((String) getAttrVal("Name_infe_site"));
	}	
	/**
	 * 感染部位名称
	 * @param Name_infe_site
	 */
	public void setName_infe_site(String Name_infe_site) {
		setAttrVal("Name_infe_site", Name_infe_site);
	}
	/**
	 * 送检日期
	 * @return FDate
	 */
	public FDate getSubmission_date() {
		return ((FDate) getAttrVal("Submission_date"));
	}	
	/**
	 * 送检日期
	 * @param Submission_date
	 */
	public void setSubmission_date(FDate Submission_date) {
		setAttrVal("Submission_date", Submission_date);
	}
	/**
	 * 检验方法
	 * @return String
	 */
	public String getId_test_method() {
		return ((String) getAttrVal("Id_test_method"));
	}	
	/**
	 * 检验方法
	 * @param Id_test_method
	 */
	public void setId_test_method(String Id_test_method) {
		setAttrVal("Id_test_method", Id_test_method);
	}
	/**
	 * 检验方法编码
	 * @return String
	 */
	public String getSd_test_method() {
		return ((String) getAttrVal("Sd_test_method"));
	}	
	/**
	 * 检验方法编码
	 * @param Sd_test_method
	 */
	public void setSd_test_method(String Sd_test_method) {
		setAttrVal("Sd_test_method", Sd_test_method);
	}
	/**
	 * 检验方法名称
	 * @return String
	 */
	public String getName_test_method() {
		return ((String) getAttrVal("Name_test_method"));
	}	
	/**
	 * 检验方法名称
	 * @param Name_test_method
	 */
	public void setName_test_method(String Name_test_method) {
		setAttrVal("Name_test_method", Name_test_method);
	}
	/**
	 * 白细胞数
	 * @return FDouble
	 */
	public FDouble getCoune_whitebloodcell() {
		return ((FDouble) getAttrVal("Coune_whitebloodcell"));
	}	
	/**
	 * 白细胞数
	 * @param Coune_whitebloodcell
	 */
	public void setCoune_whitebloodcell(FDouble Coune_whitebloodcell) {
		setAttrVal("Coune_whitebloodcell", Coune_whitebloodcell);
	}
	/**
	 * 报警时间
	 * @return FDouble
	 */
	public FDouble getTimes_alarm() {
		return ((FDouble) getAttrVal("Times_alarm"));
	}	
	/**
	 * 报警时间
	 * @param Times_alarm
	 */
	public void setTimes_alarm(FDouble Times_alarm) {
		setAttrVal("Times_alarm", Times_alarm);
	}
	/**
	 * 检验结果
	 * @return String
	 */
	public String getId_spe_test_result() {
		return ((String) getAttrVal("Id_spe_test_result"));
	}	
	/**
	 * 检验结果
	 * @param Id_spe_test_result
	 */
	public void setId_spe_test_result(String Id_spe_test_result) {
		setAttrVal("Id_spe_test_result", Id_spe_test_result);
	}
	/**
	 * 检验结果编码
	 * @return String
	 */
	public String getSd_spe_test_result() {
		return ((String) getAttrVal("Sd_spe_test_result"));
	}	
	/**
	 * 检验结果编码
	 * @param Sd_spe_test_result
	 */
	public void setSd_spe_test_result(String Sd_spe_test_result) {
		setAttrVal("Sd_spe_test_result", Sd_spe_test_result);
	}
	/**
	 * 检验结果名称
	 * @return String
	 */
	public String getName_spe_test_result() {
		return ((String) getAttrVal("Name_spe_test_result"));
	}	
	/**
	 * 检验结果名称
	 * @param Name_spe_test_result
	 */
	public void setName_spe_test_result(String Name_spe_test_result) {
		setAttrVal("Name_spe_test_result", Name_spe_test_result);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 组织编码
	 * @return String
	 */
	public String getOrg_code() {
		return ((String) getAttrVal("Org_code"));
	}	
	/**
	 * 组织编码
	 * @param Org_code
	 */
	public void setOrg_code(String Org_code) {
		setAttrVal("Org_code", Org_code);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	/**
	 * 组织名称
	 * @param Org_name
	 */
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getGrp_code() {
		return ((String) getAttrVal("Grp_code"));
	}	
	/**
	 * 编码
	 * @param Grp_code
	 */
	public void setGrp_code(String Grp_code) {
		setAttrVal("Grp_code", Grp_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getGrp_name() {
		return ((String) getAttrVal("Grp_name"));
	}	
	/**
	 * 名称
	 * @param Grp_name
	 */
	public void setGrp_name(String Grp_name) {
		setAttrVal("Grp_name", Grp_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSpecimen_code() {
		return ((String) getAttrVal("Specimen_code"));
	}	
	/**
	 * 编码
	 * @param Specimen_code
	 */
	public void setSpecimen_code(String Specimen_code) {
		setAttrVal("Specimen_code", Specimen_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSpecimen_name() {
		return ((String) getAttrVal("Specimen_name"));
	}	
	/**
	 * 名称
	 * @param Specimen_name
	 */
	public void setSpecimen_name(String Specimen_name) {
		setAttrVal("Specimen_name", Specimen_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getInfe_site_code() {
		return ((String) getAttrVal("Infe_site_code"));
	}	
	/**
	 * 编码
	 * @param Infe_site_code
	 */
	public void setInfe_site_code(String Infe_site_code) {
		setAttrVal("Infe_site_code", Infe_site_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getInfe_site_name() {
		return ((String) getAttrVal("Infe_site_name"));
	}	
	/**
	 * 名称
	 * @param Infe_site_name
	 */
	public void setInfe_site_name(String Infe_site_name) {
		setAttrVal("Infe_site_name", Infe_site_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getTest_method_code() {
		return ((String) getAttrVal("Test_method_code"));
	}	
	/**
	 * 编码
	 * @param Test_method_code
	 */
	public void setTest_method_code(String Test_method_code) {
		setAttrVal("Test_method_code", Test_method_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getTest_method_name() {
		return ((String) getAttrVal("Test_method_name"));
	}	
	/**
	 * 名称
	 * @param Test_method_name
	 */
	public void setTest_method_name(String Test_method_name) {
		setAttrVal("Test_method_name", Test_method_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSpe_test_result_code() {
		return ((String) getAttrVal("Spe_test_result_code"));
	}	
	/**
	 * 编码
	 * @param Spe_test_result_code
	 */
	public void setSpe_test_result_code(String Spe_test_result_code) {
		setAttrVal("Spe_test_result_code", Spe_test_result_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSpe_test_result_name() {
		return ((String) getAttrVal("Spe_test_result_name"));
	}	
	/**
	 * 名称
	 * @param Spe_test_result_name
	 */
	public void setSpe_test_result_name(String Spe_test_result_name) {
		setAttrVal("Spe_test_result_name", Spe_test_result_name);
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
		return "Id_specimenpk";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_rcm_spe";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SpecimenDODesc.class);
	}
	
}