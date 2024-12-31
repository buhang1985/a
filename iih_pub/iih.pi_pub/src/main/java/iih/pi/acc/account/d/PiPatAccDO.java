package iih.pi.acc.account.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.acc.account.d.desc.PiPatAccDODesc;
import java.math.BigDecimal;

/**
 * 患者账户 DO数据 
 * 
 */
public class PiPatAccDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//患者账户ID
	public static final String ID_PATACC= "Id_patacc";
	//患者
	public static final String ID_PAT= "Id_pat";
	//账户编码
	public static final String CODE= "Code";
	//账户名称
	public static final String NAME= "Name";
	//预交金金额
	public static final String PREPAY= "Prepay";
	//信用额度
	public static final String CRED= "Cred";
	//消费_授权
	public static final String ACC_LOCK= "Acc_lock";
	//账户状态编码
	public static final String SD_ACCSTA= "Sd_accsta";
	//账户状态
	public static final String ID_ACCSTA= "Id_accsta";
	//有效标志
	public static final String FG_ACTIVE= "Fg_active";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//信用分类额度
	public static final String PATCRED= "Patcred";
	//机构
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//预交金金额_留观
	public static final String PREPAY_EMGSTAY= "Prepay_emgstay";
	//消费_授权_留观
	public static final String ACC_LOCK_EMGSTAY= "Acc_lock_emgstay";
	//留观_信用度
	public static final String CRED_EMGSTAY= "Cred_emgstay";
	//留观_封账标志
	public static final String FG_FREEZE_EMGSTAY= "Fg_freeze_emgstay";
	//患者编码
	public static final String PAT_CODE= "Pat_code";
	//患者姓名
	public static final String PAT_NAME= "Pat_name";
	//编码
	public static final String ID_ACCSTA_CODE= "Id_accsta_code";
	//名称
	public static final String ID_ACCSTA_NAME= "Id_accsta_name";
	//用户名称
	public static final String CREBY_NAME= "Creby_name";
	//用户编码
	public static final String CREBY_CODE= "Creby_code";
	//用户名称
	public static final String MODFIBY_NAME= "Modfiby_name";
	//用户编码
	public static final String MODFIBY_CODE= "Modfiby_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 患者账户ID
	 * @return String
	 */
	public String getId_patacc() {
		return ((String) getAttrVal("Id_patacc"));
	}	
	/**
	 * 患者账户ID
	 * @param Id_patacc
	 */
	public void setId_patacc(String Id_patacc) {
		setAttrVal("Id_patacc", Id_patacc);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 账户编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 账户编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 账户名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 账户名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 预交金金额
	 * @return FDouble
	 */
	public FDouble getPrepay() {
		return ((FDouble) getAttrVal("Prepay"));
	}	
	/**
	 * 预交金金额
	 * @param Prepay
	 */
	public void setPrepay(FDouble Prepay) {
		setAttrVal("Prepay", Prepay);
	}
	/**
	 * 信用额度
	 * @return FDouble
	 */
	public FDouble getCred() {
		return ((FDouble) getAttrVal("Cred"));
	}	
	/**
	 * 信用额度
	 * @param Cred
	 */
	public void setCred(FDouble Cred) {
		setAttrVal("Cred", Cred);
	}
	/**
	 * 消费_授权
	 * @return FDouble
	 */
	public FDouble getAcc_lock() {
		return ((FDouble) getAttrVal("Acc_lock"));
	}	
	/**
	 * 消费_授权
	 * @param Acc_lock
	 */
	public void setAcc_lock(FDouble Acc_lock) {
		setAttrVal("Acc_lock", Acc_lock);
	}
	/**
	 * 账户状态编码
	 * @return String
	 */
	public String getSd_accsta() {
		return ((String) getAttrVal("Sd_accsta"));
	}	
	/**
	 * 账户状态编码
	 * @param Sd_accsta
	 */
	public void setSd_accsta(String Sd_accsta) {
		setAttrVal("Sd_accsta", Sd_accsta);
	}
	/**
	 * 账户状态
	 * @return String
	 */
	public String getId_accsta() {
		return ((String) getAttrVal("Id_accsta"));
	}	
	/**
	 * 账户状态
	 * @param Id_accsta
	 */
	public void setId_accsta(String Id_accsta) {
		setAttrVal("Id_accsta", Id_accsta);
	}
	/**
	 * 有效标志
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 有效标志
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
	 * 信用分类额度
	 * @return FDouble
	 */
	public FDouble getPatcred() {
		return ((FDouble) getAttrVal("Patcred"));
	}	
	/**
	 * 信用分类额度
	 * @param Patcred
	 */
	public void setPatcred(FDouble Patcred) {
		setAttrVal("Patcred", Patcred);
	}
	/**
	 * 机构
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 机构
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
	 * 预交金金额_留观
	 * @return FDouble
	 */
	public FDouble getPrepay_emgstay() {
		return ((FDouble) getAttrVal("Prepay_emgstay"));
	}	
	/**
	 * 预交金金额_留观
	 * @param Prepay_emgstay
	 */
	public void setPrepay_emgstay(FDouble Prepay_emgstay) {
		setAttrVal("Prepay_emgstay", Prepay_emgstay);
	}
	/**
	 * 消费_授权_留观
	 * @return FDouble
	 */
	public FDouble getAcc_lock_emgstay() {
		return ((FDouble) getAttrVal("Acc_lock_emgstay"));
	}	
	/**
	 * 消费_授权_留观
	 * @param Acc_lock_emgstay
	 */
	public void setAcc_lock_emgstay(FDouble Acc_lock_emgstay) {
		setAttrVal("Acc_lock_emgstay", Acc_lock_emgstay);
	}
	/**
	 * 留观_信用度
	 * @return FDouble
	 */
	public FDouble getCred_emgstay() {
		return ((FDouble) getAttrVal("Cred_emgstay"));
	}	
	/**
	 * 留观_信用度
	 * @param Cred_emgstay
	 */
	public void setCred_emgstay(FDouble Cred_emgstay) {
		setAttrVal("Cred_emgstay", Cred_emgstay);
	}
	/**
	 * 留观_封账标志
	 * @return FBoolean
	 */
	public FBoolean getFg_freeze_emgstay() {
		return ((FBoolean) getAttrVal("Fg_freeze_emgstay"));
	}	
	/**
	 * 留观_封账标志
	 * @param Fg_freeze_emgstay
	 */
	public void setFg_freeze_emgstay(FBoolean Fg_freeze_emgstay) {
		setAttrVal("Fg_freeze_emgstay", Fg_freeze_emgstay);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getPat_code() {
		return ((String) getAttrVal("Pat_code"));
	}	
	/**
	 * 患者编码
	 * @param Pat_code
	 */
	public void setPat_code(String Pat_code) {
		setAttrVal("Pat_code", Pat_code);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}	
	/**
	 * 患者姓名
	 * @param Pat_name
	 */
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getId_accsta_code() {
		return ((String) getAttrVal("Id_accsta_code"));
	}	
	/**
	 * 编码
	 * @param Id_accsta_code
	 */
	public void setId_accsta_code(String Id_accsta_code) {
		setAttrVal("Id_accsta_code", Id_accsta_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getId_accsta_name() {
		return ((String) getAttrVal("Id_accsta_name"));
	}	
	/**
	 * 名称
	 * @param Id_accsta_name
	 */
	public void setId_accsta_name(String Id_accsta_name) {
		setAttrVal("Id_accsta_name", Id_accsta_name);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getCreby_name() {
		return ((String) getAttrVal("Creby_name"));
	}	
	/**
	 * 用户名称
	 * @param Creby_name
	 */
	public void setCreby_name(String Creby_name) {
		setAttrVal("Creby_name", Creby_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getCreby_code() {
		return ((String) getAttrVal("Creby_code"));
	}	
	/**
	 * 用户编码
	 * @param Creby_code
	 */
	public void setCreby_code(String Creby_code) {
		setAttrVal("Creby_code", Creby_code);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getModfiby_name() {
		return ((String) getAttrVal("Modfiby_name"));
	}	
	/**
	 * 用户名称
	 * @param Modfiby_name
	 */
	public void setModfiby_name(String Modfiby_name) {
		setAttrVal("Modfiby_name", Modfiby_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getModfiby_code() {
		return ((String) getAttrVal("Modfiby_code"));
	}	
	/**
	 * 用户编码
	 * @param Modfiby_code
	 */
	public void setModfiby_code(String Modfiby_code) {
		setAttrVal("Modfiby_code", Modfiby_code);
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
		return "Id_patacc";
	}
	
	@Override
	public String getTableName() {	  
		return "pi_pat_acc";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PiPatAccDODesc.class);
	}
	
}