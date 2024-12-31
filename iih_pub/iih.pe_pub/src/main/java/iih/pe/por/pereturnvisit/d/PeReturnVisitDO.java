package iih.pe.por.pereturnvisit.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.por.pereturnvisit.d.desc.PeReturnVisitDODesc;
import java.math.BigDecimal;

/**
 * 体检客户回访 DO数据 
 * 
 */
public class PeReturnVisitDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检客户回访主键标识
	public static final String ID_PERETURNVISIT= "Id_pereturnvisit";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//回访日期
	public static final String DT_RETURNVISIT= "Dt_returnvisit";
	//客服人员
	public static final String ID_CSPERSON= "Id_csperson";
	//您的销售员的服务评价
	public static final String SALESPERSON= "Salesperson";
	//用户编码
	public static final String CODE_CS= "Code_cs";
	//用户名称
	public static final String NAME_CS= "Name_cs";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检客户回访主键标识
	 * @return String
	 */
	public String getId_pereturnvisit() {
		return ((String) getAttrVal("Id_pereturnvisit"));
	}	
	/**
	 * 体检客户回访主键标识
	 * @param Id_pereturnvisit
	 */
	public void setId_pereturnvisit(String Id_pereturnvisit) {
		setAttrVal("Id_pereturnvisit", Id_pereturnvisit);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 回访日期
	 * @return FDate
	 */
	public FDate getDt_returnvisit() {
		return ((FDate) getAttrVal("Dt_returnvisit"));
	}	
	/**
	 * 回访日期
	 * @param Dt_returnvisit
	 */
	public void setDt_returnvisit(FDate Dt_returnvisit) {
		setAttrVal("Dt_returnvisit", Dt_returnvisit);
	}
	/**
	 * 客服人员
	 * @return String
	 */
	public String getId_csperson() {
		return ((String) getAttrVal("Id_csperson"));
	}	
	/**
	 * 客服人员
	 * @param Id_csperson
	 */
	public void setId_csperson(String Id_csperson) {
		setAttrVal("Id_csperson", Id_csperson);
	}
	/**
	 * 您的销售员的服务评价
	 * @return String
	 */
	public String getSalesperson() {
		return ((String) getAttrVal("Salesperson"));
	}	
	/**
	 * 您的销售员的服务评价
	 * @param Salesperson
	 */
	public void setSalesperson(String Salesperson) {
		setAttrVal("Salesperson", Salesperson);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getCode_cs() {
		return ((String) getAttrVal("Code_cs"));
	}	
	/**
	 * 用户编码
	 * @param Code_cs
	 */
	public void setCode_cs(String Code_cs) {
		setAttrVal("Code_cs", Code_cs);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getName_cs() {
		return ((String) getAttrVal("Name_cs"));
	}	
	/**
	 * 用户名称
	 * @param Name_cs
	 */
	public void setName_cs(String Name_cs) {
		setAttrVal("Name_cs", Name_cs);
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
		return "Id_pereturnvisit";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_or_pereturnvisit";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeReturnVisitDODesc.class);
	}
	
}