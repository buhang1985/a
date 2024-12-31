package iih.pe.por.pecorpcharge.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.por.pecorpcharge.d.desc.PeCorpChargeDODesc;
import java.math.BigDecimal;

/**
 * 体检团体费用结账单 DO数据 
 * 
 */
public class PeCorpChargeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检团体结账主键标识
	public static final String ID_PECORPCHARGE= "Id_pecorpcharge";
	//体检团体结账父ID
	public static final String ID_PECORPCHARGE_PAR= "Id_pecorpcharge_par";
	//体检团体预约ID
	public static final String ID_PECORPAPPT= "Id_pecorpappt";
	//体检单位ID
	public static final String ID_PECORPBINFO= "Id_pecorpbinfo";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//结账名称
	public static final String NAME= "Name";
	//发票抬头
	public static final String INVOCETITLE= "Invocetitle";
	//结账时间
	public static final String DT_CHARGE= "Dt_charge";
	//结账日期
	public static final String DT_CHGDT= "Dt_chgdt";
	//结账标识
	public static final String FG_CHARGED= "Fg_charged";
	//备注
	public static final String NOTE= "Note";
	//结账唯一码
	public static final String PE_CHARGE_CODE= "Pe_charge_code";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//体检开始日期
	public static final String DT_PE_BEGIN= "Dt_pe_begin";
	//体检截止日期
	public static final String DT_PE_END= "Dt_pe_end";
	//单位编码
	public static final String CODE_CORP= "Code_corp";
	//单位名称
	public static final String NAME_CORP= "Name_corp";
	//门诊ID
	public static final String ID_CUST= "Id_cust";
	//门诊就诊ID
	public static final String ID_PAT= "Id_pat";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检团体结账主键标识
	 * @return String
	 */
	public String getId_pecorpcharge() {
		return ((String) getAttrVal("Id_pecorpcharge"));
	}	
	/**
	 * 体检团体结账主键标识
	 * @param Id_pecorpcharge
	 */
	public void setId_pecorpcharge(String Id_pecorpcharge) {
		setAttrVal("Id_pecorpcharge", Id_pecorpcharge);
	}
	/**
	 * 体检团体结账父ID
	 * @return String
	 */
	public String getId_pecorpcharge_par() {
		return ((String) getAttrVal("Id_pecorpcharge_par"));
	}	
	/**
	 * 体检团体结账父ID
	 * @param Id_pecorpcharge_par
	 */
	public void setId_pecorpcharge_par(String Id_pecorpcharge_par) {
		setAttrVal("Id_pecorpcharge_par", Id_pecorpcharge_par);
	}
	/**
	 * 体检团体预约ID
	 * @return String
	 */
	public String getId_pecorpappt() {
		return ((String) getAttrVal("Id_pecorpappt"));
	}	
	/**
	 * 体检团体预约ID
	 * @param Id_pecorpappt
	 */
	public void setId_pecorpappt(String Id_pecorpappt) {
		setAttrVal("Id_pecorpappt", Id_pecorpappt);
	}
	/**
	 * 体检单位ID
	 * @return String
	 */
	public String getId_pecorpbinfo() {
		return ((String) getAttrVal("Id_pecorpbinfo"));
	}	
	/**
	 * 体检单位ID
	 * @param Id_pecorpbinfo
	 */
	public void setId_pecorpbinfo(String Id_pecorpbinfo) {
		setAttrVal("Id_pecorpbinfo", Id_pecorpbinfo);
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
	 * 结账名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 结账名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 发票抬头
	 * @return String
	 */
	public String getInvocetitle() {
		return ((String) getAttrVal("Invocetitle"));
	}	
	/**
	 * 发票抬头
	 * @param Invocetitle
	 */
	public void setInvocetitle(String Invocetitle) {
		setAttrVal("Invocetitle", Invocetitle);
	}
	/**
	 * 结账时间
	 * @return FDateTime
	 */
	public FDateTime getDt_charge() {
		return ((FDateTime) getAttrVal("Dt_charge"));
	}	
	/**
	 * 结账时间
	 * @param Dt_charge
	 */
	public void setDt_charge(FDateTime Dt_charge) {
		setAttrVal("Dt_charge", Dt_charge);
	}
	/**
	 * 结账日期
	 * @return FDate
	 */
	public FDate getDt_chgdt() {
		return ((FDate) getAttrVal("Dt_chgdt"));
	}	
	/**
	 * 结账日期
	 * @param Dt_chgdt
	 */
	public void setDt_chgdt(FDate Dt_chgdt) {
		setAttrVal("Dt_chgdt", Dt_chgdt);
	}
	/**
	 * 结账标识
	 * @return FBoolean
	 */
	public FBoolean getFg_charged() {
		return ((FBoolean) getAttrVal("Fg_charged"));
	}	
	/**
	 * 结账标识
	 * @param Fg_charged
	 */
	public void setFg_charged(FBoolean Fg_charged) {
		setAttrVal("Fg_charged", Fg_charged);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 结账唯一码
	 * @return String
	 */
	public String getPe_charge_code() {
		return ((String) getAttrVal("Pe_charge_code"));
	}	
	/**
	 * 结账唯一码
	 * @param Pe_charge_code
	 */
	public void setPe_charge_code(String Pe_charge_code) {
		setAttrVal("Pe_charge_code", Pe_charge_code);
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
	 * 体检开始日期
	 * @return FDate
	 */
	public FDate getDt_pe_begin() {
		return ((FDate) getAttrVal("Dt_pe_begin"));
	}	
	/**
	 * 体检开始日期
	 * @param Dt_pe_begin
	 */
	public void setDt_pe_begin(FDate Dt_pe_begin) {
		setAttrVal("Dt_pe_begin", Dt_pe_begin);
	}
	/**
	 * 体检截止日期
	 * @return FDate
	 */
	public FDate getDt_pe_end() {
		return ((FDate) getAttrVal("Dt_pe_end"));
	}	
	/**
	 * 体检截止日期
	 * @param Dt_pe_end
	 */
	public void setDt_pe_end(FDate Dt_pe_end) {
		setAttrVal("Dt_pe_end", Dt_pe_end);
	}
	/**
	 * 单位编码
	 * @return String
	 */
	public String getCode_corp() {
		return ((String) getAttrVal("Code_corp"));
	}	
	/**
	 * 单位编码
	 * @param Code_corp
	 */
	public void setCode_corp(String Code_corp) {
		setAttrVal("Code_corp", Code_corp);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getName_corp() {
		return ((String) getAttrVal("Name_corp"));
	}	
	/**
	 * 单位名称
	 * @param Name_corp
	 */
	public void setName_corp(String Name_corp) {
		setAttrVal("Name_corp", Name_corp);
	}
	/**
	 * 门诊ID
	 * @return String
	 */
	public String getId_cust() {
		return ((String) getAttrVal("Id_cust"));
	}	
	/**
	 * 门诊ID
	 * @param Id_cust
	 */
	public void setId_cust(String Id_cust) {
		setAttrVal("Id_cust", Id_cust);
	}
	/**
	 * 门诊就诊ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 门诊就诊ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
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
		return "Id_pecorpcharge";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_or_pecorpcharge";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeCorpChargeDODesc.class);
	}
	
}