package iih.ems.eass.emshift.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ems.eass.emshift.d.desc.EmsEmShiftDODesc;
import java.math.BigDecimal;

/**
 * 设备资产保管变更 DO数据 
 * 
 */
public class EmsEmShiftDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//保管变更主键
	public static final String ID_SFT= "Id_sft";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//现保管科室
	public static final String ID_DEPT_NEW= "Id_dept_new";
	//现保管等级
	public static final String ID_LEVEL_NEW= "Id_level_new";
	//现保管等级编码
	public static final String SD_LEVEL_NEW= "Sd_level_new";
	//现保管人员
	public static final String ID_EMP_NEW= "Id_emp_new";
	//现领用日期
	public static final String DT_GET_NEW= "Dt_get_new";
	//经手人
	public static final String ID_DEAL_OPER= "Id_deal_oper";
	//备注
	public static final String REMARK= "Remark";
	//保管变更单状态
	public static final String ID_STATE= "Id_state";
	//保管变更单状态编码
	public static final String SD_STATE= "Sd_state";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//变更单号
	public static final String CODE= "Code";
	//变更单名称
	public static final String NAME= "Name";
	//保管仓库
	public static final String ID_WH= "Id_wh";
	//现使用科室
	public static final String ID_STOR_NEW= "Id_stor_new";
	//名称
	public static final String NAME_DEPT_NEW= "Name_dept_new";
	//名称
	public static final String NAME_LEVEL_NEW= "Name_level_new";
	//姓名
	public static final String NAME_STOR_NEW= "Name_stor_new";
	//姓名
	public static final String NAME_DEAL_OPER= "Name_deal_oper";
	//名称
	public static final String NAME_STATE= "Name_state";
	//仓库名称
	public static final String NAME_WH= "Name_wh";
	//使用科室名称
	public static final String NAME_STOR= "Name_stor";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 保管变更主键
	 * @return String
	 */
	public String getId_sft() {
		return ((String) getAttrVal("Id_sft"));
	}	
	/**
	 * 保管变更主键
	 * @param Id_sft
	 */
	public void setId_sft(String Id_sft) {
		setAttrVal("Id_sft", Id_sft);
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
	 * 现保管科室
	 * @return String
	 */
	public String getId_dept_new() {
		return ((String) getAttrVal("Id_dept_new"));
	}	
	/**
	 * 现保管科室
	 * @param Id_dept_new
	 */
	public void setId_dept_new(String Id_dept_new) {
		setAttrVal("Id_dept_new", Id_dept_new);
	}
	/**
	 * 现保管等级
	 * @return String
	 */
	public String getId_level_new() {
		return ((String) getAttrVal("Id_level_new"));
	}	
	/**
	 * 现保管等级
	 * @param Id_level_new
	 */
	public void setId_level_new(String Id_level_new) {
		setAttrVal("Id_level_new", Id_level_new);
	}
	/**
	 * 现保管等级编码
	 * @return String
	 */
	public String getSd_level_new() {
		return ((String) getAttrVal("Sd_level_new"));
	}	
	/**
	 * 现保管等级编码
	 * @param Sd_level_new
	 */
	public void setSd_level_new(String Sd_level_new) {
		setAttrVal("Sd_level_new", Sd_level_new);
	}
	/**
	 * 现保管人员
	 * @return String
	 */
	public String getId_emp_new() {
		return ((String) getAttrVal("Id_emp_new"));
	}	
	/**
	 * 现保管人员
	 * @param Id_emp_new
	 */
	public void setId_emp_new(String Id_emp_new) {
		setAttrVal("Id_emp_new", Id_emp_new);
	}
	/**
	 * 现领用日期
	 * @return FDate
	 */
	public FDate getDt_get_new() {
		return ((FDate) getAttrVal("Dt_get_new"));
	}	
	/**
	 * 现领用日期
	 * @param Dt_get_new
	 */
	public void setDt_get_new(FDate Dt_get_new) {
		setAttrVal("Dt_get_new", Dt_get_new);
	}
	/**
	 * 经手人
	 * @return String
	 */
	public String getId_deal_oper() {
		return ((String) getAttrVal("Id_deal_oper"));
	}	
	/**
	 * 经手人
	 * @param Id_deal_oper
	 */
	public void setId_deal_oper(String Id_deal_oper) {
		setAttrVal("Id_deal_oper", Id_deal_oper);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getRemark() {
		return ((String) getAttrVal("Remark"));
	}	
	/**
	 * 备注
	 * @param Remark
	 */
	public void setRemark(String Remark) {
		setAttrVal("Remark", Remark);
	}
	/**
	 * 保管变更单状态
	 * @return String
	 */
	public String getId_state() {
		return ((String) getAttrVal("Id_state"));
	}	
	/**
	 * 保管变更单状态
	 * @param Id_state
	 */
	public void setId_state(String Id_state) {
		setAttrVal("Id_state", Id_state);
	}
	/**
	 * 保管变更单状态编码
	 * @return String
	 */
	public String getSd_state() {
		return ((String) getAttrVal("Sd_state"));
	}	
	/**
	 * 保管变更单状态编码
	 * @param Sd_state
	 */
	public void setSd_state(String Sd_state) {
		setAttrVal("Sd_state", Sd_state);
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
	 * 变更单号
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 变更单号
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 变更单名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 变更单名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 保管仓库
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	/**
	 * 保管仓库
	 * @param Id_wh
	 */
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	/**
	 * 现使用科室
	 * @return String
	 */
	public String getId_stor_new() {
		return ((String) getAttrVal("Id_stor_new"));
	}	
	/**
	 * 现使用科室
	 * @param Id_stor_new
	 */
	public void setId_stor_new(String Id_stor_new) {
		setAttrVal("Id_stor_new", Id_stor_new);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dept_new() {
		return ((String) getAttrVal("Name_dept_new"));
	}	
	/**
	 * 名称
	 * @param Name_dept_new
	 */
	public void setName_dept_new(String Name_dept_new) {
		setAttrVal("Name_dept_new", Name_dept_new);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_level_new() {
		return ((String) getAttrVal("Name_level_new"));
	}	
	/**
	 * 名称
	 * @param Name_level_new
	 */
	public void setName_level_new(String Name_level_new) {
		setAttrVal("Name_level_new", Name_level_new);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_stor_new() {
		return ((String) getAttrVal("Name_stor_new"));
	}	
	/**
	 * 姓名
	 * @param Name_stor_new
	 */
	public void setName_stor_new(String Name_stor_new) {
		setAttrVal("Name_stor_new", Name_stor_new);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_deal_oper() {
		return ((String) getAttrVal("Name_deal_oper"));
	}	
	/**
	 * 姓名
	 * @param Name_deal_oper
	 */
	public void setName_deal_oper(String Name_deal_oper) {
		setAttrVal("Name_deal_oper", Name_deal_oper);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_state() {
		return ((String) getAttrVal("Name_state"));
	}	
	/**
	 * 名称
	 * @param Name_state
	 */
	public void setName_state(String Name_state) {
		setAttrVal("Name_state", Name_state);
	}
	/**
	 * 仓库名称
	 * @return String
	 */
	public String getName_wh() {
		return ((String) getAttrVal("Name_wh"));
	}	
	/**
	 * 仓库名称
	 * @param Name_wh
	 */
	public void setName_wh(String Name_wh) {
		setAttrVal("Name_wh", Name_wh);
	}
	/**
	 * 使用科室名称
	 * @return String
	 */
	public String getName_stor() {
		return ((String) getAttrVal("Name_stor"));
	}	
	/**
	 * 使用科室名称
	 * @param Name_stor
	 */
	public void setName_stor(String Name_stor) {
		setAttrVal("Name_stor", Name_stor);
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
		return "Id_sft";
	}
	
	@Override
	public String getTableName() {	  
		return "ems_sft";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmsEmShiftDODesc.class);
	}
	
}