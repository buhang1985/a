package iih.ci.ord.skintest.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.skintest.d.desc.CiSkinTestRstDODesc;
import java.math.BigDecimal;

/**
 * 皮试结果记录 DO数据 
 * 
 */
public class CiSkinTestRstDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//皮试结果主键标识
	public static final String ID_SKINTEST= "Id_skintest";
	//医嘱
	public static final String ID_OR= "Id_or";
	//皮试结果
	public static final String ID_RST_SKINTEST= "Id_rst_skintest";
	//皮试结果编码
	public static final String SD_RST_SKINTEST= "Sd_rst_skintest";
	//皮试开始时间
	public static final String DT_BEGIN= "Dt_begin";
	//皮试录入人
	public static final String ID_EMP_CREATE= "Id_emp_create";
	//皮试录入时间
	public static final String DT_CREATE= "Dt_create";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//确认人
	public static final String CONFIRMBY= "Confirmby";
	//修改原因
	public static final String REASON= "Reason";
	//备注
	public static final String DES= "Des";
	//等待时间
	public static final String WAITTIME= "Waittime";
	//名称
	public static final String SKINRES_NAME= "Skinres_name";
	//编码
	public static final String SKINRES_CODE= "Skinres_code";
	public static final String ID_UDIDOCLIST= "Id_udidoclist";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 皮试结果主键标识
	 * @return String
	 */
	public String getId_skintest() {
		return ((String) getAttrVal("Id_skintest"));
	}	
	/**
	 * 皮试结果主键标识
	 * @param Id_skintest
	 */
	public void setId_skintest(String Id_skintest) {
		setAttrVal("Id_skintest", Id_skintest);
	}
	/**
	 * 医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 皮试结果
	 * @return String
	 */
	public String getId_rst_skintest() {
		return ((String) getAttrVal("Id_rst_skintest"));
	}	
	/**
	 * 皮试结果
	 * @param Id_rst_skintest
	 */
	public void setId_rst_skintest(String Id_rst_skintest) {
		setAttrVal("Id_rst_skintest", Id_rst_skintest);
	}
	/**
	 * 皮试结果编码
	 * @return String
	 */
	public String getSd_rst_skintest() {
		return ((String) getAttrVal("Sd_rst_skintest"));
	}	
	/**
	 * 皮试结果编码
	 * @param Sd_rst_skintest
	 */
	public void setSd_rst_skintest(String Sd_rst_skintest) {
		setAttrVal("Sd_rst_skintest", Sd_rst_skintest);
	}
	/**
	 * 皮试开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}	
	/**
	 * 皮试开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 皮试录入人
	 * @return String
	 */
	public String getId_emp_create() {
		return ((String) getAttrVal("Id_emp_create"));
	}	
	/**
	 * 皮试录入人
	 * @param Id_emp_create
	 */
	public void setId_emp_create(String Id_emp_create) {
		setAttrVal("Id_emp_create", Id_emp_create);
	}
	/**
	 * 皮试录入时间
	 * @return FDateTime
	 */
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}	
	/**
	 * 皮试录入时间
	 * @param Dt_create
	 */
	public void setDt_create(FDateTime Dt_create) {
		setAttrVal("Dt_create", Dt_create);
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
	 * 确认人
	 * @return String
	 */
	public String getConfirmby() {
		return ((String) getAttrVal("Confirmby"));
	}	
	/**
	 * 确认人
	 * @param Confirmby
	 */
	public void setConfirmby(String Confirmby) {
		setAttrVal("Confirmby", Confirmby);
	}
	/**
	 * 修改原因
	 * @return String
	 */
	public String getReason() {
		return ((String) getAttrVal("Reason"));
	}	
	/**
	 * 修改原因
	 * @param Reason
	 */
	public void setReason(String Reason) {
		setAttrVal("Reason", Reason);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 备注
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 等待时间
	 * @return String
	 */
	public String getWaittime() {
		return ((String) getAttrVal("Waittime"));
	}	
	/**
	 * 等待时间
	 * @param Waittime
	 */
	public void setWaittime(String Waittime) {
		setAttrVal("Waittime", Waittime);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSkinres_name() {
		return ((String) getAttrVal("Skinres_name"));
	}	
	/**
	 * 名称
	 * @param Skinres_name
	 */
	public void setSkinres_name(String Skinres_name) {
		setAttrVal("Skinres_name", Skinres_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSkinres_code() {
		return ((String) getAttrVal("Skinres_code"));
	}	
	/**
	 * 编码
	 * @param Skinres_code
	 */
	public void setSkinres_code(String Skinres_code) {
		setAttrVal("Skinres_code", Skinres_code);
	}
	public String getId_udidoclist() {
		return ((String) getAttrVal("Id_udidoclist"));
	}	
	public void setId_udidoclist(String Id_udidoclist) {
		setAttrVal("Id_udidoclist", Id_udidoclist);
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
		return "Id_skintest";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_skin_test";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiSkinTestRstDODesc.class);
	}
	
}