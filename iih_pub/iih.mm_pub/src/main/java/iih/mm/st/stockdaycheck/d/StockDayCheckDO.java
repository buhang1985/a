package iih.mm.st.stockdaycheck.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.st.stockdaycheck.d.desc.StockDayCheckDODesc;
import java.math.BigDecimal;

/**
 * 药房日点账 DO数据 
 * 
 */
public class StockDayCheckDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//日点账主键
	public static final String ID_DAYCHECK= "Id_daycheck";
	//物品自定义分类项目
	public static final String ID_MMCAUSITM= "Id_mmcausitm";
	//日点账仓库
	public static final String ID_WH= "Id_wh";
	//编码
	public static final String CODE= "Code";
	//统计开始时间
	public static final String DT_BEGIN= "Dt_begin";
	//统计结束时间
	public static final String DT_END= "Dt_end";
	//日点账时间
	public static final String DT_DCK= "Dt_dck";
	//日点账人
	public static final String ID_EMP_DCK= "Id_emp_dck";
	//审核时间
	public static final String DT_CHECK= "Dt_check";
	//审核人
	public static final String ID_EMP_CHECK= "Id_emp_check";
	//审核意见
	public static final String AUDITOPINION= "Auditopinion";
	//日点账状态
	public static final String ID_SU_DCK= "Id_su_dck";
	//日点账状态编码
	public static final String SD_SU_DCK= "Sd_su_dck";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//物品自定义分类项目名称
	public static final String MMCAUSITM_NAME= "Mmcausitm_name";
	//仓库名称
	public static final String WH_NAME= "Wh_name";
	//日点账人姓名
	public static final String DCK_NAME= "Dck_name";
	//审核人姓名
	public static final String CHECK_NAME= "Check_name";
	//名称
	public static final String SU_DCK_NAME= "Su_dck_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 日点账主键
	 * @return String
	 */
	public String getId_daycheck() {
		return ((String) getAttrVal("Id_daycheck"));
	}	
	/**
	 * 日点账主键
	 * @param Id_daycheck
	 */
	public void setId_daycheck(String Id_daycheck) {
		setAttrVal("Id_daycheck", Id_daycheck);
	}
	/**
	 * 物品自定义分类项目
	 * @return String
	 */
	public String getId_mmcausitm() {
		return ((String) getAttrVal("Id_mmcausitm"));
	}	
	/**
	 * 物品自定义分类项目
	 * @param Id_mmcausitm
	 */
	public void setId_mmcausitm(String Id_mmcausitm) {
		setAttrVal("Id_mmcausitm", Id_mmcausitm);
	}
	/**
	 * 日点账仓库
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	/**
	 * 日点账仓库
	 * @param Id_wh
	 */
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 统计开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}	
	/**
	 * 统计开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 统计结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	/**
	 * 统计结束时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 日点账时间
	 * @return FDateTime
	 */
	public FDateTime getDt_dck() {
		return ((FDateTime) getAttrVal("Dt_dck"));
	}	
	/**
	 * 日点账时间
	 * @param Dt_dck
	 */
	public void setDt_dck(FDateTime Dt_dck) {
		setAttrVal("Dt_dck", Dt_dck);
	}
	/**
	 * 日点账人
	 * @return String
	 */
	public String getId_emp_dck() {
		return ((String) getAttrVal("Id_emp_dck"));
	}	
	/**
	 * 日点账人
	 * @param Id_emp_dck
	 */
	public void setId_emp_dck(String Id_emp_dck) {
		setAttrVal("Id_emp_dck", Id_emp_dck);
	}
	/**
	 * 审核时间
	 * @return FDateTime
	 */
	public FDateTime getDt_check() {
		return ((FDateTime) getAttrVal("Dt_check"));
	}	
	/**
	 * 审核时间
	 * @param Dt_check
	 */
	public void setDt_check(FDateTime Dt_check) {
		setAttrVal("Dt_check", Dt_check);
	}
	/**
	 * 审核人
	 * @return String
	 */
	public String getId_emp_check() {
		return ((String) getAttrVal("Id_emp_check"));
	}	
	/**
	 * 审核人
	 * @param Id_emp_check
	 */
	public void setId_emp_check(String Id_emp_check) {
		setAttrVal("Id_emp_check", Id_emp_check);
	}
	/**
	 * 审核意见
	 * @return String
	 */
	public String getAuditopinion() {
		return ((String) getAttrVal("Auditopinion"));
	}	
	/**
	 * 审核意见
	 * @param Auditopinion
	 */
	public void setAuditopinion(String Auditopinion) {
		setAttrVal("Auditopinion", Auditopinion);
	}
	/**
	 * 日点账状态
	 * @return String
	 */
	public String getId_su_dck() {
		return ((String) getAttrVal("Id_su_dck"));
	}	
	/**
	 * 日点账状态
	 * @param Id_su_dck
	 */
	public void setId_su_dck(String Id_su_dck) {
		setAttrVal("Id_su_dck", Id_su_dck);
	}
	/**
	 * 日点账状态编码
	 * @return String
	 */
	public String getSd_su_dck() {
		return ((String) getAttrVal("Sd_su_dck"));
	}	
	/**
	 * 日点账状态编码
	 * @param Sd_su_dck
	 */
	public void setSd_su_dck(String Sd_su_dck) {
		setAttrVal("Sd_su_dck", Sd_su_dck);
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
	 * 物品自定义分类项目名称
	 * @return String
	 */
	public String getMmcausitm_name() {
		return ((String) getAttrVal("Mmcausitm_name"));
	}	
	/**
	 * 物品自定义分类项目名称
	 * @param Mmcausitm_name
	 */
	public void setMmcausitm_name(String Mmcausitm_name) {
		setAttrVal("Mmcausitm_name", Mmcausitm_name);
	}
	/**
	 * 仓库名称
	 * @return String
	 */
	public String getWh_name() {
		return ((String) getAttrVal("Wh_name"));
	}	
	/**
	 * 仓库名称
	 * @param Wh_name
	 */
	public void setWh_name(String Wh_name) {
		setAttrVal("Wh_name", Wh_name);
	}
	/**
	 * 日点账人姓名
	 * @return String
	 */
	public String getDck_name() {
		return ((String) getAttrVal("Dck_name"));
	}	
	/**
	 * 日点账人姓名
	 * @param Dck_name
	 */
	public void setDck_name(String Dck_name) {
		setAttrVal("Dck_name", Dck_name);
	}
	/**
	 * 审核人姓名
	 * @return String
	 */
	public String getCheck_name() {
		return ((String) getAttrVal("Check_name"));
	}	
	/**
	 * 审核人姓名
	 * @param Check_name
	 */
	public void setCheck_name(String Check_name) {
		setAttrVal("Check_name", Check_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSu_dck_name() {
		return ((String) getAttrVal("Su_dck_name"));
	}	
	/**
	 * 名称
	 * @param Su_dck_name
	 */
	public void setSu_dck_name(String Su_dck_name) {
		setAttrVal("Su_dck_name", Su_dck_name);
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
		return "Id_daycheck";
	}
	
	@Override
	public String getTableName() {	  
		return "MM_ST_DAYCHECK";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(StockDayCheckDODesc.class);
	}
	
}