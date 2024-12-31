package iih.cssd.dpp.dfploss.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.cssd.dpp.dfploss.d.desc.DfpLossDODesc;
import java.math.BigDecimal;

/**
 * 消毒包损失登记 DO数据 
 * 
 */
public class DfpLossDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//损失主键标识
	public static final String ID_DFP_LOSS= "Id_dfp_loss";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//消毒包
	public static final String ID_DFP= "Id_dfp";
	//损失状态ID
	public static final String ID_STATUS= "Id_status";
	//损失状态编码
	public static final String SD_STATUS= "Sd_status";
	//登记科室
	public static final String ID_DEP_REG= "Id_dep_reg";
	//登记人
	public static final String ID_EMP_REG= "Id_emp_reg";
	//登记时间
	public static final String DT_REG= "Dt_reg";
	//损失备注
	public static final String NOTE= "Note";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//识别码
	public static final String NO_BAR= "No_bar";
	//损失状态名称
	public static final String NAME_STATUS= "Name_status";
	//登记科室名称
	public static final String NAME_DEP_REG= "Name_dep_reg";
	//登记人姓名
	public static final String NAME_EMP_REG= "Name_emp_reg";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 损失主键标识
	 * @return String
	 */
	public String getId_dfp_loss() {
		return ((String) getAttrVal("Id_dfp_loss"));
	}	
	/**
	 * 损失主键标识
	 * @param Id_dfp_loss
	 */
	public void setId_dfp_loss(String Id_dfp_loss) {
		setAttrVal("Id_dfp_loss", Id_dfp_loss);
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
	 * 消毒包
	 * @return String
	 */
	public String getId_dfp() {
		return ((String) getAttrVal("Id_dfp"));
	}	
	/**
	 * 消毒包
	 * @param Id_dfp
	 */
	public void setId_dfp(String Id_dfp) {
		setAttrVal("Id_dfp", Id_dfp);
	}
	/**
	 * 损失状态ID
	 * @return String
	 */
	public String getId_status() {
		return ((String) getAttrVal("Id_status"));
	}	
	/**
	 * 损失状态ID
	 * @param Id_status
	 */
	public void setId_status(String Id_status) {
		setAttrVal("Id_status", Id_status);
	}
	/**
	 * 损失状态编码
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}	
	/**
	 * 损失状态编码
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 登记科室
	 * @return String
	 */
	public String getId_dep_reg() {
		return ((String) getAttrVal("Id_dep_reg"));
	}	
	/**
	 * 登记科室
	 * @param Id_dep_reg
	 */
	public void setId_dep_reg(String Id_dep_reg) {
		setAttrVal("Id_dep_reg", Id_dep_reg);
	}
	/**
	 * 登记人
	 * @return String
	 */
	public String getId_emp_reg() {
		return ((String) getAttrVal("Id_emp_reg"));
	}	
	/**
	 * 登记人
	 * @param Id_emp_reg
	 */
	public void setId_emp_reg(String Id_emp_reg) {
		setAttrVal("Id_emp_reg", Id_emp_reg);
	}
	/**
	 * 登记时间
	 * @return FDateTime
	 */
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}	
	/**
	 * 登记时间
	 * @param Dt_reg
	 */
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
	}
	/**
	 * 损失备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 损失备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
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
	 * 识别码
	 * @return String
	 */
	public String getNo_bar() {
		return ((String) getAttrVal("No_bar"));
	}	
	/**
	 * 识别码
	 * @param No_bar
	 */
	public void setNo_bar(String No_bar) {
		setAttrVal("No_bar", No_bar);
	}
	/**
	 * 损失状态名称
	 * @return String
	 */
	public String getName_status() {
		return ((String) getAttrVal("Name_status"));
	}	
	/**
	 * 损失状态名称
	 * @param Name_status
	 */
	public void setName_status(String Name_status) {
		setAttrVal("Name_status", Name_status);
	}
	/**
	 * 登记科室名称
	 * @return String
	 */
	public String getName_dep_reg() {
		return ((String) getAttrVal("Name_dep_reg"));
	}	
	/**
	 * 登记科室名称
	 * @param Name_dep_reg
	 */
	public void setName_dep_reg(String Name_dep_reg) {
		setAttrVal("Name_dep_reg", Name_dep_reg);
	}
	/**
	 * 登记人姓名
	 * @return String
	 */
	public String getName_emp_reg() {
		return ((String) getAttrVal("Name_emp_reg"));
	}	
	/**
	 * 登记人姓名
	 * @param Name_emp_reg
	 */
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
		return "Id_dfp_loss";
	}
	
	@Override
	public String getTableName() {	  
		return "cssd_dfp_loss";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DfpLossDODesc.class);
	}
	
}