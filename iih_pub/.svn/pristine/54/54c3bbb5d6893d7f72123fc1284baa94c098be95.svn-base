package iih.pe.por.pecoupon.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.por.pecoupon.d.desc.PeCouponDODesc;
import java.math.BigDecimal;

/**
 * 体检卷定义 DO数据 
 * 
 */
public class PeCouponDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检卷主键标识
	public static final String ID_PECOUPON= "Id_pecoupon";
	//体检卷父ID
	public static final String ID_PECOUPON_PAR= "Id_pecoupon_par";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//原始金额
	public static final String PRI_ORIGINAL= "Pri_original";
	//实际金额
	public static final String PRI_REAL= "Pri_real";
	//有效日期
	public static final String DT_EXPIRATION= "Dt_expiration";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检卷主键标识
	 * @return String
	 */
	public String getId_pecoupon() {
		return ((String) getAttrVal("Id_pecoupon"));
	}	
	/**
	 * 体检卷主键标识
	 * @param Id_pecoupon
	 */
	public void setId_pecoupon(String Id_pecoupon) {
		setAttrVal("Id_pecoupon", Id_pecoupon);
	}
	/**
	 * 体检卷父ID
	 * @return String
	 */
	public String getId_pecoupon_par() {
		return ((String) getAttrVal("Id_pecoupon_par"));
	}	
	/**
	 * 体检卷父ID
	 * @param Id_pecoupon_par
	 */
	public void setId_pecoupon_par(String Id_pecoupon_par) {
		setAttrVal("Id_pecoupon_par", Id_pecoupon_par);
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
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
	 * 原始金额
	 * @return FDouble
	 */
	public FDouble getPri_original() {
		return ((FDouble) getAttrVal("Pri_original"));
	}	
	/**
	 * 原始金额
	 * @param Pri_original
	 */
	public void setPri_original(FDouble Pri_original) {
		setAttrVal("Pri_original", Pri_original);
	}
	/**
	 * 实际金额
	 * @return FDouble
	 */
	public FDouble getPri_real() {
		return ((FDouble) getAttrVal("Pri_real"));
	}	
	/**
	 * 实际金额
	 * @param Pri_real
	 */
	public void setPri_real(FDouble Pri_real) {
		setAttrVal("Pri_real", Pri_real);
	}
	/**
	 * 有效日期
	 * @return FDate
	 */
	public FDate getDt_expiration() {
		return ((FDate) getAttrVal("Dt_expiration"));
	}	
	/**
	 * 有效日期
	 * @param Dt_expiration
	 */
	public void setDt_expiration(FDate Dt_expiration) {
		setAttrVal("Dt_expiration", Dt_expiration);
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
		return "Id_pecoupon";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_or_pecoupon";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeCouponDODesc.class);
	}
	
}