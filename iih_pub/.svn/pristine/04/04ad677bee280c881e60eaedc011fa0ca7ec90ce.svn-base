package iih.ci.rcm.consite.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.consite.d.desc.ConSiteDODesc;
import java.math.BigDecimal;

/**
 * 院感感染部位 DO数据 
 * 
 */
public class ConSiteDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//感染部位主键ID
	public static final String ID_SITE= "Id_site";
	//院感上报主卡主键
	public static final String ID_HOSPITALREPORT= "Id_hospitalreport";
	//感染日期
	public static final String INFECTEDATE= "Infectedate";
	//感染部位
	public static final String ID_INFECTE_SITE= "Id_infecte_site";
	//感染部位编码
	public static final String SD_INFECTE_SITE= "Sd_infecte_site";
	//感染部位名称
	public static final String NAME_INFECTE_SITE= "Name_infecte_site";
	//感染部位其他
	public static final String INFECTE_SITE_OTHER= "Infecte_site_other";
	//感染诊断
	public static final String ID_DI_INFECTION= "Id_di_infection";
	//感染诊断编码
	public static final String SD_DI_INFECTION= "Sd_di_infection";
	//感染诊断名称
	public static final String NAME_DI_INFECTION= "Name_di_infection";
	//侵袭性操作
	public static final String ID_INVA_OPER= "Id_inva_oper";
	//侵袭性操作编码
	public static final String SD_INVA_OPER= "Sd_inva_oper";
	//侵袭性操作名称
	public static final String NAME_INVA_OPER= "Name_inva_oper";
	//侵袭性操作其它选项
	public static final String OTHER_INVA_OPER= "Other_inva_oper";
	//报告科室
	public static final String ID_REPORT_DEPT= "Id_report_dept";
	//报告科室名称
	public static final String NAME_REPORT_DEPT= "Name_report_dept";
	//报告科室编码
	public static final String SD_REPORT_DEPT= "Sd_report_dept";
	//填报人
	public static final String ID_REPORT_PERSON= "Id_report_person";
	//填报人姓名
	public static final String NAME_REPORT_PERSON= "Name_report_person";
	//填报人编码
	public static final String SD_REPORT_PERSON= "Sd_report_person";
	//填报日期
	public static final String DT_REPORT= "Dt_report";
	//操作
	public static final String OPERATION= "Operation";
	//备用字段1
	public static final String BACKUP_FILED1= "Backup_filed1";
	//备用字段2
	public static final String BACKUP_FILED2= "Backup_filed2";
	//备用字段3
	public static final String BACKUP_FILED3= "Backup_filed3";
	//备用字段4
	public static final String BACKUP_FILED4= "Backup_filed4";
	//备用字段5
	public static final String BACKUP_FILED5= "Backup_filed5";
	//名称
	public static final String INFECTE_SITE_NAME= "Infecte_site_name";
	//编码
	public static final String INFECTE_SITE_CODE= "Infecte_site_code";
	//编码
	public static final String DI_INFECTION_CODE= "Di_infection_code";
	//名称
	public static final String DI_INFECTION_NAME= "Di_infection_name";
	//编码
	public static final String INVA_OPER_CODE= "Inva_oper_code";
	//名称
	public static final String INVA_OPER_NAME= "Inva_oper_name";
	//编码
	public static final String REPORT_DEPT_CODE= "Report_dept_code";
	//名称
	public static final String REPORT_DEPT_NAME= "Report_dept_name";
	//人员编码
	public static final String REPORT_PERSON_CODE= "Report_person_code";
	//姓名
	public static final String REPORT_PERSON_NAME= "Report_person_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 感染部位主键ID
	 * @return String
	 */
	public String getId_site() {
		return ((String) getAttrVal("Id_site"));
	}	
	/**
	 * 感染部位主键ID
	 * @param Id_site
	 */
	public void setId_site(String Id_site) {
		setAttrVal("Id_site", Id_site);
	}
	/**
	 * 院感上报主卡主键
	 * @return String
	 */
	public String getId_hospitalreport() {
		return ((String) getAttrVal("Id_hospitalreport"));
	}	
	/**
	 * 院感上报主卡主键
	 * @param Id_hospitalreport
	 */
	public void setId_hospitalreport(String Id_hospitalreport) {
		setAttrVal("Id_hospitalreport", Id_hospitalreport);
	}
	/**
	 * 感染日期
	 * @return FDate
	 */
	public FDate getInfectedate() {
		return ((FDate) getAttrVal("Infectedate"));
	}	
	/**
	 * 感染日期
	 * @param Infectedate
	 */
	public void setInfectedate(FDate Infectedate) {
		setAttrVal("Infectedate", Infectedate);
	}
	/**
	 * 感染部位
	 * @return String
	 */
	public String getId_infecte_site() {
		return ((String) getAttrVal("Id_infecte_site"));
	}	
	/**
	 * 感染部位
	 * @param Id_infecte_site
	 */
	public void setId_infecte_site(String Id_infecte_site) {
		setAttrVal("Id_infecte_site", Id_infecte_site);
	}
	/**
	 * 感染部位编码
	 * @return String
	 */
	public String getSd_infecte_site() {
		return ((String) getAttrVal("Sd_infecte_site"));
	}	
	/**
	 * 感染部位编码
	 * @param Sd_infecte_site
	 */
	public void setSd_infecte_site(String Sd_infecte_site) {
		setAttrVal("Sd_infecte_site", Sd_infecte_site);
	}
	/**
	 * 感染部位名称
	 * @return String
	 */
	public String getName_infecte_site() {
		return ((String) getAttrVal("Name_infecte_site"));
	}	
	/**
	 * 感染部位名称
	 * @param Name_infecte_site
	 */
	public void setName_infecte_site(String Name_infecte_site) {
		setAttrVal("Name_infecte_site", Name_infecte_site);
	}
	/**
	 * 感染部位其他
	 * @return String
	 */
	public String getInfecte_site_other() {
		return ((String) getAttrVal("Infecte_site_other"));
	}	
	/**
	 * 感染部位其他
	 * @param Infecte_site_other
	 */
	public void setInfecte_site_other(String Infecte_site_other) {
		setAttrVal("Infecte_site_other", Infecte_site_other);
	}
	/**
	 * 感染诊断
	 * @return String
	 */
	public String getId_di_infection() {
		return ((String) getAttrVal("Id_di_infection"));
	}	
	/**
	 * 感染诊断
	 * @param Id_di_infection
	 */
	public void setId_di_infection(String Id_di_infection) {
		setAttrVal("Id_di_infection", Id_di_infection);
	}
	/**
	 * 感染诊断编码
	 * @return String
	 */
	public String getSd_di_infection() {
		return ((String) getAttrVal("Sd_di_infection"));
	}	
	/**
	 * 感染诊断编码
	 * @param Sd_di_infection
	 */
	public void setSd_di_infection(String Sd_di_infection) {
		setAttrVal("Sd_di_infection", Sd_di_infection);
	}
	/**
	 * 感染诊断名称
	 * @return String
	 */
	public String getName_di_infection() {
		return ((String) getAttrVal("Name_di_infection"));
	}	
	/**
	 * 感染诊断名称
	 * @param Name_di_infection
	 */
	public void setName_di_infection(String Name_di_infection) {
		setAttrVal("Name_di_infection", Name_di_infection);
	}
	/**
	 * 侵袭性操作
	 * @return String
	 */
	public String getId_inva_oper() {
		return ((String) getAttrVal("Id_inva_oper"));
	}	
	/**
	 * 侵袭性操作
	 * @param Id_inva_oper
	 */
	public void setId_inva_oper(String Id_inva_oper) {
		setAttrVal("Id_inva_oper", Id_inva_oper);
	}
	/**
	 * 侵袭性操作编码
	 * @return String
	 */
	public String getSd_inva_oper() {
		return ((String) getAttrVal("Sd_inva_oper"));
	}	
	/**
	 * 侵袭性操作编码
	 * @param Sd_inva_oper
	 */
	public void setSd_inva_oper(String Sd_inva_oper) {
		setAttrVal("Sd_inva_oper", Sd_inva_oper);
	}
	/**
	 * 侵袭性操作名称
	 * @return String
	 */
	public String getName_inva_oper() {
		return ((String) getAttrVal("Name_inva_oper"));
	}	
	/**
	 * 侵袭性操作名称
	 * @param Name_inva_oper
	 */
	public void setName_inva_oper(String Name_inva_oper) {
		setAttrVal("Name_inva_oper", Name_inva_oper);
	}
	/**
	 * 侵袭性操作其它选项
	 * @return String
	 */
	public String getOther_inva_oper() {
		return ((String) getAttrVal("Other_inva_oper"));
	}	
	/**
	 * 侵袭性操作其它选项
	 * @param Other_inva_oper
	 */
	public void setOther_inva_oper(String Other_inva_oper) {
		setAttrVal("Other_inva_oper", Other_inva_oper);
	}
	/**
	 * 报告科室
	 * @return String
	 */
	public String getId_report_dept() {
		return ((String) getAttrVal("Id_report_dept"));
	}	
	/**
	 * 报告科室
	 * @param Id_report_dept
	 */
	public void setId_report_dept(String Id_report_dept) {
		setAttrVal("Id_report_dept", Id_report_dept);
	}
	/**
	 * 报告科室名称
	 * @return String
	 */
	public String getName_report_dept() {
		return ((String) getAttrVal("Name_report_dept"));
	}	
	/**
	 * 报告科室名称
	 * @param Name_report_dept
	 */
	public void setName_report_dept(String Name_report_dept) {
		setAttrVal("Name_report_dept", Name_report_dept);
	}
	/**
	 * 报告科室编码
	 * @return String
	 */
	public String getSd_report_dept() {
		return ((String) getAttrVal("Sd_report_dept"));
	}	
	/**
	 * 报告科室编码
	 * @param Sd_report_dept
	 */
	public void setSd_report_dept(String Sd_report_dept) {
		setAttrVal("Sd_report_dept", Sd_report_dept);
	}
	/**
	 * 填报人
	 * @return String
	 */
	public String getId_report_person() {
		return ((String) getAttrVal("Id_report_person"));
	}	
	/**
	 * 填报人
	 * @param Id_report_person
	 */
	public void setId_report_person(String Id_report_person) {
		setAttrVal("Id_report_person", Id_report_person);
	}
	/**
	 * 填报人姓名
	 * @return String
	 */
	public String getName_report_person() {
		return ((String) getAttrVal("Name_report_person"));
	}	
	/**
	 * 填报人姓名
	 * @param Name_report_person
	 */
	public void setName_report_person(String Name_report_person) {
		setAttrVal("Name_report_person", Name_report_person);
	}
	/**
	 * 填报人编码
	 * @return String
	 */
	public String getSd_report_person() {
		return ((String) getAttrVal("Sd_report_person"));
	}	
	/**
	 * 填报人编码
	 * @param Sd_report_person
	 */
	public void setSd_report_person(String Sd_report_person) {
		setAttrVal("Sd_report_person", Sd_report_person);
	}
	/**
	 * 填报日期
	 * @return String
	 */
	public String getDt_report() {
		return ((String) getAttrVal("Dt_report"));
	}	
	/**
	 * 填报日期
	 * @param Dt_report
	 */
	public void setDt_report(String Dt_report) {
		setAttrVal("Dt_report", Dt_report);
	}
	/**
	 * 操作
	 * @return String
	 */
	public String getOperation() {
		return ((String) getAttrVal("Operation"));
	}	
	/**
	 * 操作
	 * @param Operation
	 */
	public void setOperation(String Operation) {
		setAttrVal("Operation", Operation);
	}
	/**
	 * 备用字段1
	 * @return String
	 */
	public String getBackup_filed1() {
		return ((String) getAttrVal("Backup_filed1"));
	}	
	/**
	 * 备用字段1
	 * @param Backup_filed1
	 */
	public void setBackup_filed1(String Backup_filed1) {
		setAttrVal("Backup_filed1", Backup_filed1);
	}
	/**
	 * 备用字段2
	 * @return String
	 */
	public String getBackup_filed2() {
		return ((String) getAttrVal("Backup_filed2"));
	}	
	/**
	 * 备用字段2
	 * @param Backup_filed2
	 */
	public void setBackup_filed2(String Backup_filed2) {
		setAttrVal("Backup_filed2", Backup_filed2);
	}
	/**
	 * 备用字段3
	 * @return String
	 */
	public String getBackup_filed3() {
		return ((String) getAttrVal("Backup_filed3"));
	}	
	/**
	 * 备用字段3
	 * @param Backup_filed3
	 */
	public void setBackup_filed3(String Backup_filed3) {
		setAttrVal("Backup_filed3", Backup_filed3);
	}
	/**
	 * 备用字段4
	 * @return String
	 */
	public String getBackup_filed4() {
		return ((String) getAttrVal("Backup_filed4"));
	}	
	/**
	 * 备用字段4
	 * @param Backup_filed4
	 */
	public void setBackup_filed4(String Backup_filed4) {
		setAttrVal("Backup_filed4", Backup_filed4);
	}
	/**
	 * 备用字段5
	 * @return String
	 */
	public String getBackup_filed5() {
		return ((String) getAttrVal("Backup_filed5"));
	}	
	/**
	 * 备用字段5
	 * @param Backup_filed5
	 */
	public void setBackup_filed5(String Backup_filed5) {
		setAttrVal("Backup_filed5", Backup_filed5);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getInfecte_site_name() {
		return ((String) getAttrVal("Infecte_site_name"));
	}	
	/**
	 * 名称
	 * @param Infecte_site_name
	 */
	public void setInfecte_site_name(String Infecte_site_name) {
		setAttrVal("Infecte_site_name", Infecte_site_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getInfecte_site_code() {
		return ((String) getAttrVal("Infecte_site_code"));
	}	
	/**
	 * 编码
	 * @param Infecte_site_code
	 */
	public void setInfecte_site_code(String Infecte_site_code) {
		setAttrVal("Infecte_site_code", Infecte_site_code);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDi_infection_code() {
		return ((String) getAttrVal("Di_infection_code"));
	}	
	/**
	 * 编码
	 * @param Di_infection_code
	 */
	public void setDi_infection_code(String Di_infection_code) {
		setAttrVal("Di_infection_code", Di_infection_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDi_infection_name() {
		return ((String) getAttrVal("Di_infection_name"));
	}	
	/**
	 * 名称
	 * @param Di_infection_name
	 */
	public void setDi_infection_name(String Di_infection_name) {
		setAttrVal("Di_infection_name", Di_infection_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getInva_oper_code() {
		return ((String) getAttrVal("Inva_oper_code"));
	}	
	/**
	 * 编码
	 * @param Inva_oper_code
	 */
	public void setInva_oper_code(String Inva_oper_code) {
		setAttrVal("Inva_oper_code", Inva_oper_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getInva_oper_name() {
		return ((String) getAttrVal("Inva_oper_name"));
	}	
	/**
	 * 名称
	 * @param Inva_oper_name
	 */
	public void setInva_oper_name(String Inva_oper_name) {
		setAttrVal("Inva_oper_name", Inva_oper_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getReport_dept_code() {
		return ((String) getAttrVal("Report_dept_code"));
	}	
	/**
	 * 编码
	 * @param Report_dept_code
	 */
	public void setReport_dept_code(String Report_dept_code) {
		setAttrVal("Report_dept_code", Report_dept_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getReport_dept_name() {
		return ((String) getAttrVal("Report_dept_name"));
	}	
	/**
	 * 名称
	 * @param Report_dept_name
	 */
	public void setReport_dept_name(String Report_dept_name) {
		setAttrVal("Report_dept_name", Report_dept_name);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getReport_person_code() {
		return ((String) getAttrVal("Report_person_code"));
	}	
	/**
	 * 人员编码
	 * @param Report_person_code
	 */
	public void setReport_person_code(String Report_person_code) {
		setAttrVal("Report_person_code", Report_person_code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getReport_person_name() {
		return ((String) getAttrVal("Report_person_name"));
	}	
	/**
	 * 姓名
	 * @param Report_person_name
	 */
	public void setReport_person_name(String Report_person_name) {
		setAttrVal("Report_person_name", Report_person_name);
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
		return "Id_site";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_CONTAGION_SITE";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ConSiteDODesc.class);
	}
	
}