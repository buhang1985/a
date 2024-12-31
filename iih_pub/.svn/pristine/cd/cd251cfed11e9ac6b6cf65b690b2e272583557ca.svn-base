package iih.bd.pp.inccasplit.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.inccasplit.d.desc.BdInccaSplitDODesc;
import java.math.BigDecimal;

/**
 * 票据分票设置 DO数据 
 * 
 */
public class BdInccaSplitDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//票据分类自动拆分主键
	public static final String ID_INCCASPLIT= "Id_inccasplit";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//票据分类主键
	public static final String ID_INCCA= "Id_incca";
	//是否允许手工拆票
	public static final String FG_SPLITBYOPER= "Fg_splitbyoper";
	//主票拆票条件
	public static final String ID_SPLIT_CASE= "Id_split_case";
	//主票拆票条件编码
	public static final String SD_SPLIT_CASE= "Sd_split_case";
	//就诊类型
	public static final String CODE_ENTP= "Code_entp";
	//票据显示内容
	public static final String ID_DISPTP= "Id_disptp";
	//票据显示内容编码
	public static final String SD_DISPTP= "Sd_disptp";
	//需要显示医嘱的开单服务类型
	public static final String ID_DISP_CI_SRVTP= "Id_disp_ci_srvtp";
	//需要显示医嘱的开单服务类型编码
	public static final String SD_DISP_CI_SRVTP= "Sd_disp_ci_srvtp";
	//需要显示账单的账单项
	public static final String ID_DISP_INCITM= "Id_disp_incitm";
	//需要显示账单的账单项编码
	public static final String SD_DISP_INCITM= "Sd_disp_incitm";
	//不显示为明细的服务类型
	public static final String ID_DISP_NOTDETAIL_SRVTP= "Id_disp_notdetail_srvtp";
	//不显示为明细的服务类型编码
	public static final String SD_DISP_NOTDETAIL_SRVTP= "Sd_disp_notdetail_srvtp";
	//一页内发票明细最大数量
	public static final String ITMBIGNUM= "Itmbignum";
	//是否按核算联分票
	public static final String FG_SPLITBYACCOUNT= "Fg_splitbyaccount";
	//核算联分组条件
	public static final String ID_SPLIT_ACC_CASE= "Id_split_acc_case";
	//核算联分组条件编码
	public static final String SD_SPLIT_ACC_CASE= "Sd_split_acc_case";
	//核算联数量
	public static final String COUNT_ACCOUNT= "Count_account";
	//核算联显示内容
	public static final String ID_AC_DISPTP= "Id_ac_disptp";
	//核算联显示内容编码
	public static final String SD_AC_DISPTP= "Sd_ac_disptp";
	//系统标志
	public static final String FG_SYS= "Fg_sys";
	//启用标志
	public static final String FG_ACTIVE= "Fg_active";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//自动拆票名称
	public static final String NAME_SPLIT_CASE= "Name_split_case";
	//票据显示名称
	public static final String NAME_DISPTP= "Name_disptp";
	//需要显示医嘱的开单服务类型名称
	public static final String NAME_DISP_CI_SRVTP= "Name_disp_ci_srvtp";
	//票据项目名称
	public static final String NAME_INCITM= "Name_incitm";
	//不显示为明细的服务类型名称
	public static final String NAME_DISP_NOTDETAIL_SRVTP= "Name_disp_notdetail_srvtp";
	//核算联分组条件名称
	public static final String NAME_SPLIT_ACC_CASE= "Name_split_acc_case";
	//核算联显示内容名称
	public static final String NAME_AC_DISPTP= "Name_ac_disptp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 票据分类自动拆分主键
	 * @return String
	 */
	public String getId_inccasplit() {
		return ((String) getAttrVal("Id_inccasplit"));
	}	
	/**
	 * 票据分类自动拆分主键
	 * @param Id_inccasplit
	 */
	public void setId_inccasplit(String Id_inccasplit) {
		setAttrVal("Id_inccasplit", Id_inccasplit);
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
	 * 票据分类主键
	 * @return String
	 */
	public String getId_incca() {
		return ((String) getAttrVal("Id_incca"));
	}	
	/**
	 * 票据分类主键
	 * @param Id_incca
	 */
	public void setId_incca(String Id_incca) {
		setAttrVal("Id_incca", Id_incca);
	}
	/**
	 * 是否允许手工拆票
	 * @return FBoolean
	 */
	public FBoolean getFg_splitbyoper() {
		return ((FBoolean) getAttrVal("Fg_splitbyoper"));
	}	
	/**
	 * 是否允许手工拆票
	 * @param Fg_splitbyoper
	 */
	public void setFg_splitbyoper(FBoolean Fg_splitbyoper) {
		setAttrVal("Fg_splitbyoper", Fg_splitbyoper);
	}
	/**
	 * 主票拆票条件
	 * @return String
	 */
	public String getId_split_case() {
		return ((String) getAttrVal("Id_split_case"));
	}	
	/**
	 * 主票拆票条件
	 * @param Id_split_case
	 */
	public void setId_split_case(String Id_split_case) {
		setAttrVal("Id_split_case", Id_split_case);
	}
	/**
	 * 主票拆票条件编码
	 * @return String
	 */
	public String getSd_split_case() {
		return ((String) getAttrVal("Sd_split_case"));
	}	
	/**
	 * 主票拆票条件编码
	 * @param Sd_split_case
	 */
	public void setSd_split_case(String Sd_split_case) {
		setAttrVal("Sd_split_case", Sd_split_case);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	/**
	 * 就诊类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 票据显示内容
	 * @return String
	 */
	public String getId_disptp() {
		return ((String) getAttrVal("Id_disptp"));
	}	
	/**
	 * 票据显示内容
	 * @param Id_disptp
	 */
	public void setId_disptp(String Id_disptp) {
		setAttrVal("Id_disptp", Id_disptp);
	}
	/**
	 * 票据显示内容编码
	 * @return String
	 */
	public String getSd_disptp() {
		return ((String) getAttrVal("Sd_disptp"));
	}	
	/**
	 * 票据显示内容编码
	 * @param Sd_disptp
	 */
	public void setSd_disptp(String Sd_disptp) {
		setAttrVal("Sd_disptp", Sd_disptp);
	}
	/**
	 * 需要显示医嘱的开单服务类型
	 * @return String
	 */
	public String getId_disp_ci_srvtp() {
		return ((String) getAttrVal("Id_disp_ci_srvtp"));
	}	
	/**
	 * 需要显示医嘱的开单服务类型
	 * @param Id_disp_ci_srvtp
	 */
	public void setId_disp_ci_srvtp(String Id_disp_ci_srvtp) {
		setAttrVal("Id_disp_ci_srvtp", Id_disp_ci_srvtp);
	}
	/**
	 * 需要显示医嘱的开单服务类型编码
	 * @return String
	 */
	public String getSd_disp_ci_srvtp() {
		return ((String) getAttrVal("Sd_disp_ci_srvtp"));
	}	
	/**
	 * 需要显示医嘱的开单服务类型编码
	 * @param Sd_disp_ci_srvtp
	 */
	public void setSd_disp_ci_srvtp(String Sd_disp_ci_srvtp) {
		setAttrVal("Sd_disp_ci_srvtp", Sd_disp_ci_srvtp);
	}
	/**
	 * 需要显示账单的账单项
	 * @return String
	 */
	public String getId_disp_incitm() {
		return ((String) getAttrVal("Id_disp_incitm"));
	}	
	/**
	 * 需要显示账单的账单项
	 * @param Id_disp_incitm
	 */
	public void setId_disp_incitm(String Id_disp_incitm) {
		setAttrVal("Id_disp_incitm", Id_disp_incitm);
	}
	/**
	 * 需要显示账单的账单项编码
	 * @return String
	 */
	public String getSd_disp_incitm() {
		return ((String) getAttrVal("Sd_disp_incitm"));
	}	
	/**
	 * 需要显示账单的账单项编码
	 * @param Sd_disp_incitm
	 */
	public void setSd_disp_incitm(String Sd_disp_incitm) {
		setAttrVal("Sd_disp_incitm", Sd_disp_incitm);
	}
	/**
	 * 不显示为明细的服务类型
	 * @return String
	 */
	public String getId_disp_notdetail_srvtp() {
		return ((String) getAttrVal("Id_disp_notdetail_srvtp"));
	}	
	/**
	 * 不显示为明细的服务类型
	 * @param Id_disp_notdetail_srvtp
	 */
	public void setId_disp_notdetail_srvtp(String Id_disp_notdetail_srvtp) {
		setAttrVal("Id_disp_notdetail_srvtp", Id_disp_notdetail_srvtp);
	}
	/**
	 * 不显示为明细的服务类型编码
	 * @return String
	 */
	public String getSd_disp_notdetail_srvtp() {
		return ((String) getAttrVal("Sd_disp_notdetail_srvtp"));
	}	
	/**
	 * 不显示为明细的服务类型编码
	 * @param Sd_disp_notdetail_srvtp
	 */
	public void setSd_disp_notdetail_srvtp(String Sd_disp_notdetail_srvtp) {
		setAttrVal("Sd_disp_notdetail_srvtp", Sd_disp_notdetail_srvtp);
	}
	/**
	 * 一页内发票明细最大数量
	 * @return Integer
	 */
	public Integer getItmbignum() {
		return ((Integer) getAttrVal("Itmbignum"));
	}	
	/**
	 * 一页内发票明细最大数量
	 * @param Itmbignum
	 */
	public void setItmbignum(Integer Itmbignum) {
		setAttrVal("Itmbignum", Itmbignum);
	}
	/**
	 * 是否按核算联分票
	 * @return FBoolean
	 */
	public FBoolean getFg_splitbyaccount() {
		return ((FBoolean) getAttrVal("Fg_splitbyaccount"));
	}	
	/**
	 * 是否按核算联分票
	 * @param Fg_splitbyaccount
	 */
	public void setFg_splitbyaccount(FBoolean Fg_splitbyaccount) {
		setAttrVal("Fg_splitbyaccount", Fg_splitbyaccount);
	}
	/**
	 * 核算联分组条件
	 * @return String
	 */
	public String getId_split_acc_case() {
		return ((String) getAttrVal("Id_split_acc_case"));
	}	
	/**
	 * 核算联分组条件
	 * @param Id_split_acc_case
	 */
	public void setId_split_acc_case(String Id_split_acc_case) {
		setAttrVal("Id_split_acc_case", Id_split_acc_case);
	}
	/**
	 * 核算联分组条件编码
	 * @return String
	 */
	public String getSd_split_acc_case() {
		return ((String) getAttrVal("Sd_split_acc_case"));
	}	
	/**
	 * 核算联分组条件编码
	 * @param Sd_split_acc_case
	 */
	public void setSd_split_acc_case(String Sd_split_acc_case) {
		setAttrVal("Sd_split_acc_case", Sd_split_acc_case);
	}
	/**
	 * 核算联数量
	 * @return Integer
	 */
	public Integer getCount_account() {
		return ((Integer) getAttrVal("Count_account"));
	}	
	/**
	 * 核算联数量
	 * @param Count_account
	 */
	public void setCount_account(Integer Count_account) {
		setAttrVal("Count_account", Count_account);
	}
	/**
	 * 核算联显示内容
	 * @return String
	 */
	public String getId_ac_disptp() {
		return ((String) getAttrVal("Id_ac_disptp"));
	}	
	/**
	 * 核算联显示内容
	 * @param Id_ac_disptp
	 */
	public void setId_ac_disptp(String Id_ac_disptp) {
		setAttrVal("Id_ac_disptp", Id_ac_disptp);
	}
	/**
	 * 核算联显示内容编码
	 * @return String
	 */
	public String getSd_ac_disptp() {
		return ((String) getAttrVal("Sd_ac_disptp"));
	}	
	/**
	 * 核算联显示内容编码
	 * @param Sd_ac_disptp
	 */
	public void setSd_ac_disptp(String Sd_ac_disptp) {
		setAttrVal("Sd_ac_disptp", Sd_ac_disptp);
	}
	/**
	 * 系统标志
	 * @return FBoolean
	 */
	public FBoolean getFg_sys() {
		return ((FBoolean) getAttrVal("Fg_sys"));
	}	
	/**
	 * 系统标志
	 * @param Fg_sys
	 */
	public void setFg_sys(FBoolean Fg_sys) {
		setAttrVal("Fg_sys", Fg_sys);
	}
	/**
	 * 启用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标志
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
	 * 自动拆票名称
	 * @return String
	 */
	public String getName_split_case() {
		return ((String) getAttrVal("Name_split_case"));
	}	
	/**
	 * 自动拆票名称
	 * @param Name_split_case
	 */
	public void setName_split_case(String Name_split_case) {
		setAttrVal("Name_split_case", Name_split_case);
	}
	/**
	 * 票据显示名称
	 * @return String
	 */
	public String getName_disptp() {
		return ((String) getAttrVal("Name_disptp"));
	}	
	/**
	 * 票据显示名称
	 * @param Name_disptp
	 */
	public void setName_disptp(String Name_disptp) {
		setAttrVal("Name_disptp", Name_disptp);
	}
	/**
	 * 需要显示医嘱的开单服务类型名称
	 * @return String
	 */
	public String getName_disp_ci_srvtp() {
		return ((String) getAttrVal("Name_disp_ci_srvtp"));
	}	
	/**
	 * 需要显示医嘱的开单服务类型名称
	 * @param Name_disp_ci_srvtp
	 */
	public void setName_disp_ci_srvtp(String Name_disp_ci_srvtp) {
		setAttrVal("Name_disp_ci_srvtp", Name_disp_ci_srvtp);
	}
	/**
	 * 票据项目名称
	 * @return String
	 */
	public String getName_incitm() {
		return ((String) getAttrVal("Name_incitm"));
	}	
	/**
	 * 票据项目名称
	 * @param Name_incitm
	 */
	public void setName_incitm(String Name_incitm) {
		setAttrVal("Name_incitm", Name_incitm);
	}
	/**
	 * 不显示为明细的服务类型名称
	 * @return String
	 */
	public String getName_disp_notdetail_srvtp() {
		return ((String) getAttrVal("Name_disp_notdetail_srvtp"));
	}	
	/**
	 * 不显示为明细的服务类型名称
	 * @param Name_disp_notdetail_srvtp
	 */
	public void setName_disp_notdetail_srvtp(String Name_disp_notdetail_srvtp) {
		setAttrVal("Name_disp_notdetail_srvtp", Name_disp_notdetail_srvtp);
	}
	/**
	 * 核算联分组条件名称
	 * @return String
	 */
	public String getName_split_acc_case() {
		return ((String) getAttrVal("Name_split_acc_case"));
	}	
	/**
	 * 核算联分组条件名称
	 * @param Name_split_acc_case
	 */
	public void setName_split_acc_case(String Name_split_acc_case) {
		setAttrVal("Name_split_acc_case", Name_split_acc_case);
	}
	/**
	 * 核算联显示内容名称
	 * @return String
	 */
	public String getName_ac_disptp() {
		return ((String) getAttrVal("Name_ac_disptp"));
	}	
	/**
	 * 核算联显示内容名称
	 * @param Name_ac_disptp
	 */
	public void setName_ac_disptp(String Name_ac_disptp) {
		setAttrVal("Name_ac_disptp", Name_ac_disptp);
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
		return "Id_inccasplit";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_incca_split";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdInccaSplitDODesc.class);
	}
	
}