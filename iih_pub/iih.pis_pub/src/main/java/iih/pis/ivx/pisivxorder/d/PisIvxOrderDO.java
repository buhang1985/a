package iih.pis.ivx.pisivxorder.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pis.ivx.pisivxorder.d.desc.PisIvxOrderDODesc;
import java.math.BigDecimal;

/**
 * 微信处方订单 DO数据 
 * 
 */
public class PisIvxOrderDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//微信处方订单主键标识
	public static final String ID_PISIVXORDER= "Id_pisivxorder";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//displaynam4
	public static final String ORDERNO= "Orderno";
	//displaynam5
	public static final String DT_ORDER= "Dt_order";
	//displaynam6
	public static final String TOTALFEE= "Totalfee";
	//displaynam7
	public static final String TRADENO= "Tradeno";
	//displaynam8
	public static final String OPENID= "Openid";
	//displaynam9
	public static final String FNO= "Fno";
	//displaynam10
	public static final String APPLYPEOPLE= "Applypeople";
	//displaynam11
	public static final String APPLYPHONE= "Applyphone";
	//displaynam12
	public static final String APPLYSOCIAL= "Applysocial";
	//displaynam13
	public static final String ID_PAT= "Id_pat";
	//displaynam14
	public static final String TIMES= "Times";
	//displaynam15
	public static final String NAME_PAT= "Name_pat";
	//displaynam16
	public static final String SEX_PAT= "Sex_pat";
	//displaynam17
	public static final String ID_CODE= "Id_code";
	//displaynam18
	public static final String BIRTHDATE= "Birthdate";
	//displaynam19
	public static final String MOB= "Mob";
	//displaynam20
	public static final String ST_ORDER= "St_order";
	//displaynam21
	public static final String ST_FEE= "St_fee";
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
	 * 微信处方订单主键标识
	 * @return String
	 */
	public String getId_pisivxorder() {
		return ((String) getAttrVal("Id_pisivxorder"));
	}	
	/**
	 * 微信处方订单主键标识
	 * @param Id_pisivxorder
	 */
	public void setId_pisivxorder(String Id_pisivxorder) {
		setAttrVal("Id_pisivxorder", Id_pisivxorder);
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
	 * displaynam4
	 * @return String
	 */
	public String getOrderno() {
		return ((String) getAttrVal("Orderno"));
	}	
	/**
	 * displaynam4
	 * @param Orderno
	 */
	public void setOrderno(String Orderno) {
		setAttrVal("Orderno", Orderno);
	}
	/**
	 * displaynam5
	 * @return String
	 */
	public String getDt_order() {
		return ((String) getAttrVal("Dt_order"));
	}	
	/**
	 * displaynam5
	 * @param Dt_order
	 */
	public void setDt_order(String Dt_order) {
		setAttrVal("Dt_order", Dt_order);
	}
	/**
	 * displaynam6
	 * @return String
	 */
	public String getTotalfee() {
		return ((String) getAttrVal("Totalfee"));
	}	
	/**
	 * displaynam6
	 * @param Totalfee
	 */
	public void setTotalfee(String Totalfee) {
		setAttrVal("Totalfee", Totalfee);
	}
	/**
	 * displaynam7
	 * @return String
	 */
	public String getTradeno() {
		return ((String) getAttrVal("Tradeno"));
	}	
	/**
	 * displaynam7
	 * @param Tradeno
	 */
	public void setTradeno(String Tradeno) {
		setAttrVal("Tradeno", Tradeno);
	}
	/**
	 * displaynam8
	 * @return String
	 */
	public String getOpenid() {
		return ((String) getAttrVal("Openid"));
	}	
	/**
	 * displaynam8
	 * @param Openid
	 */
	public void setOpenid(String Openid) {
		setAttrVal("Openid", Openid);
	}
	/**
	 * displaynam9
	 * @return String
	 */
	public String getFno() {
		return ((String) getAttrVal("Fno"));
	}	
	/**
	 * displaynam9
	 * @param Fno
	 */
	public void setFno(String Fno) {
		setAttrVal("Fno", Fno);
	}
	/**
	 * displaynam10
	 * @return String
	 */
	public String getApplypeople() {
		return ((String) getAttrVal("Applypeople"));
	}	
	/**
	 * displaynam10
	 * @param Applypeople
	 */
	public void setApplypeople(String Applypeople) {
		setAttrVal("Applypeople", Applypeople);
	}
	/**
	 * displaynam11
	 * @return String
	 */
	public String getApplyphone() {
		return ((String) getAttrVal("Applyphone"));
	}	
	/**
	 * displaynam11
	 * @param Applyphone
	 */
	public void setApplyphone(String Applyphone) {
		setAttrVal("Applyphone", Applyphone);
	}
	/**
	 * displaynam12
	 * @return String
	 */
	public String getApplysocial() {
		return ((String) getAttrVal("Applysocial"));
	}	
	/**
	 * displaynam12
	 * @param Applysocial
	 */
	public void setApplysocial(String Applysocial) {
		setAttrVal("Applysocial", Applysocial);
	}
	/**
	 * displaynam13
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * displaynam13
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * displaynam14
	 * @return String
	 */
	public String getTimes() {
		return ((String) getAttrVal("Times"));
	}	
	/**
	 * displaynam14
	 * @param Times
	 */
	public void setTimes(String Times) {
		setAttrVal("Times", Times);
	}
	/**
	 * displaynam15
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * displaynam15
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * displaynam16
	 * @return String
	 */
	public String getSex_pat() {
		return ((String) getAttrVal("Sex_pat"));
	}	
	/**
	 * displaynam16
	 * @param Sex_pat
	 */
	public void setSex_pat(String Sex_pat) {
		setAttrVal("Sex_pat", Sex_pat);
	}
	/**
	 * displaynam17
	 * @return String
	 */
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}	
	/**
	 * displaynam17
	 * @param Id_code
	 */
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
	}
	/**
	 * displaynam18
	 * @return String
	 */
	public String getBirthdate() {
		return ((String) getAttrVal("Birthdate"));
	}	
	/**
	 * displaynam18
	 * @param Birthdate
	 */
	public void setBirthdate(String Birthdate) {
		setAttrVal("Birthdate", Birthdate);
	}
	/**
	 * displaynam19
	 * @return String
	 */
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}	
	/**
	 * displaynam19
	 * @param Mob
	 */
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}
	/**
	 * displaynam20
	 * @return String
	 */
	public String getSt_order() {
		return ((String) getAttrVal("St_order"));
	}	
	/**
	 * displaynam20
	 * @param St_order
	 */
	public void setSt_order(String St_order) {
		setAttrVal("St_order", St_order);
	}
	/**
	 * displaynam21
	 * @return String
	 */
	public String getSt_fee() {
		return ((String) getAttrVal("St_fee"));
	}	
	/**
	 * displaynam21
	 * @param St_fee
	 */
	public void setSt_fee(String St_fee) {
		setAttrVal("St_fee", St_fee);
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
		return "Id_pisivxorder";
	}
	
	@Override
	public String getTableName() {	  
		return "pis_ivx_pisivxorder";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PisIvxOrderDODesc.class);
	}
	
}