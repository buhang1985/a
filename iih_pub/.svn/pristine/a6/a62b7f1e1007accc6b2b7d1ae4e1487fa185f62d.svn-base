package iih.ci.ord.doctorstationprinter.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.doctorstationprinter.d.desc.DoctorstationprinterDODesc;
import java.math.BigDecimal;

/**
 * 医生站处方打印机设置 DO数据 
 * 
 */
public class DoctorstationprinterDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//主键
	public static final String ID_PRINTER= "Id_printer";
	//集团
	public static final String ID_ORG= "Id_org";
	//组织
	public static final String ID_GROUP= "Id_group";
	//适用范围
	public static final String APPLYSCOPE= "Applyscope";
	//计算机
	public static final String COMPUTER= "Computer";
	//医生站
	public static final String DOCTORSTATION= "Doctorstation";
	//处方模板类型
	public static final String PRESTYPE= "Prestype";
	//打印机
	public static final String PRINTER= "Printer";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_printer() {
		return ((String) getAttrVal("Id_printer"));
	}	
	/**
	 * 主键
	 * @param Id_printer
	 */
	public void setId_printer(String Id_printer) {
		setAttrVal("Id_printer", Id_printer);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 集团
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_group() {
		return ((String) getAttrVal("Id_group"));
	}	
	/**
	 * 组织
	 * @param Id_group
	 */
	public void setId_group(String Id_group) {
		setAttrVal("Id_group", Id_group);
	}
	/**
	 * 适用范围
	 * @return String
	 */
	public String getApplyscope() {
		return ((String) getAttrVal("Applyscope"));
	}	
	/**
	 * 适用范围
	 * @param Applyscope
	 */
	public void setApplyscope(String Applyscope) {
		setAttrVal("Applyscope", Applyscope);
	}
	/**
	 * 计算机
	 * @return String
	 */
	public String getComputer() {
		return ((String) getAttrVal("Computer"));
	}	
	/**
	 * 计算机
	 * @param Computer
	 */
	public void setComputer(String Computer) {
		setAttrVal("Computer", Computer);
	}
	/**
	 * 医生站
	 * @return String
	 */
	public String getDoctorstation() {
		return ((String) getAttrVal("Doctorstation"));
	}	
	/**
	 * 医生站
	 * @param Doctorstation
	 */
	public void setDoctorstation(String Doctorstation) {
		setAttrVal("Doctorstation", Doctorstation);
	}
	/**
	 * 处方模板类型
	 * @return String
	 */
	public String getPrestype() {
		return ((String) getAttrVal("Prestype"));
	}	
	/**
	 * 处方模板类型
	 * @param Prestype
	 */
	public void setPrestype(String Prestype) {
		setAttrVal("Prestype", Prestype);
	}
	/**
	 * 打印机
	 * @return String
	 */
	public String getPrinter() {
		return ((String) getAttrVal("Printer"));
	}	
	/**
	 * 打印机
	 * @param Printer
	 */
	public void setPrinter(String Printer) {
		setAttrVal("Printer", Printer);
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
		return "Id_printer";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_printer";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DoctorstationprinterDODesc.class);
	}
	
}