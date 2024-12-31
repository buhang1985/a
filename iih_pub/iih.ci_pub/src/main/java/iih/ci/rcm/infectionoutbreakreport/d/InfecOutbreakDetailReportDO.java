package iih.ci.rcm.infectionoutbreakreport.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.infectionoutbreakreport.d.desc.InfecOutbreakDetailReportDODesc;
import java.math.BigDecimal;

/**
 * 医院感染暴发详情报告登记表 DO数据 
 * 
 */
public class InfecOutbreakDetailReportDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医院感染暴发详情报告主键
	public static final String ID_INFEOUTDETAILRE= "Id_infeoutdetailre";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//院感上报主键
	public static final String ID_HOSPITALREPORT= "Id_hospitalreport";
	//院感暴发报告外键
	public static final String ID_INFEOUTRE= "Id_infeoutre";
	//组织编码
	public static final String ORG_CODE= "Org_code";
	//组织名称
	public static final String ORG_NAME= "Org_name";
	//名称
	public static final String GRP_NAME= "Grp_name";
	//编码
	public static final String GRP_CODE= "Grp_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医院感染暴发详情报告主键
	 * @return String
	 */
	public String getId_infeoutdetailre() {
		return ((String) getAttrVal("Id_infeoutdetailre"));
	}	
	/**
	 * 医院感染暴发详情报告主键
	 * @param Id_infeoutdetailre
	 */
	public void setId_infeoutdetailre(String Id_infeoutdetailre) {
		setAttrVal("Id_infeoutdetailre", Id_infeoutdetailre);
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
	 * 院感上报主键
	 * @return String
	 */
	public String getId_hospitalreport() {
		return ((String) getAttrVal("Id_hospitalreport"));
	}	
	/**
	 * 院感上报主键
	 * @param Id_hospitalreport
	 */
	public void setId_hospitalreport(String Id_hospitalreport) {
		setAttrVal("Id_hospitalreport", Id_hospitalreport);
	}
	/**
	 * 院感暴发报告外键
	 * @return String
	 */
	public String getId_infeoutre() {
		return ((String) getAttrVal("Id_infeoutre"));
	}	
	/**
	 * 院感暴发报告外键
	 * @param Id_infeoutre
	 */
	public void setId_infeoutre(String Id_infeoutre) {
		setAttrVal("Id_infeoutre", Id_infeoutre);
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
		return "Id_infeoutdetailre";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_infeout_detail_report";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(InfecOutbreakDetailReportDODesc.class);
	}
	
}