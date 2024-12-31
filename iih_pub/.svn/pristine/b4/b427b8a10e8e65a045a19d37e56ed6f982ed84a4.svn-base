package iih.mi.biz.mitransrecord.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mi.biz.mitransrecord.d.desc.MiTransRecordDODesc;
import java.math.BigDecimal;

/**
 * 医保交易记录 DO数据 
 * 
 */
public class MiTransRecordDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//交易记录id
	public static final String ID_TRANSRECORD= "Id_transrecord";
	//集团id
	public static final String ID_GRP= "Id_grp";
	//组织id
	public static final String ID_ORG= "Id_org";
	//患者id
	public static final String ID_PAT= "Id_pat";
	//医保计划
	public static final String ID_HP= "Id_hp";
	//结算号
	public static final String CODE_ST= "Code_st";
	//医保交互产生功能点描述
	public static final String SRCFUNC_DES= "Srcfunc_des";
	//医保业务类型编码
	public static final String CODE_BUSINESS= "Code_business";
	//医保业务类型名称
	public static final String NAME_BUSINESS= "Name_business";
	//医保登记号
	public static final String REGISTER_NO= "Register_no";
	//医保交易流水号
	public static final String TRADE_NO= "Trade_no";
	//交易日期
	public static final String DT_TRANS= "Dt_trans";
	//交易入参
	public static final String INPUTINFO= "Inputinfo";
	//交易出参
	public static final String OUTPUTINFO= "Outputinfo";
	//是否真实交易
	public static final String FG_REAL= "Fg_real";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//患者编码
	public static final String CODE_PAT= "Code_pat";
	//患者姓名
	public static final String NAME_PAT= "Name_pat";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 交易记录id
	 * @return String
	 */
	public String getId_transrecord() {
		return ((String) getAttrVal("Id_transrecord"));
	}	
	/**
	 * 交易记录id
	 * @param Id_transrecord
	 */
	public void setId_transrecord(String Id_transrecord) {
		setAttrVal("Id_transrecord", Id_transrecord);
	}
	/**
	 * 集团id
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团id
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 组织id
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织id
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 医保计划
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	/**
	 * 医保计划
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 结算号
	 * @return String
	 */
	public String getCode_st() {
		return ((String) getAttrVal("Code_st"));
	}	
	/**
	 * 结算号
	 * @param Code_st
	 */
	public void setCode_st(String Code_st) {
		setAttrVal("Code_st", Code_st);
	}
	/**
	 * 医保交互产生功能点描述
	 * @return Integer
	 */
	public Integer getSrcfunc_des() {
		return ((Integer) getAttrVal("Srcfunc_des"));
	}	
	/**
	 * 医保交互产生功能点描述
	 * @param Srcfunc_des
	 */
	public void setSrcfunc_des(Integer Srcfunc_des) {
		setAttrVal("Srcfunc_des", Srcfunc_des);
	}
	/**
	 * 医保业务类型编码
	 * @return Integer
	 */
	public Integer getCode_business() {
		return ((Integer) getAttrVal("Code_business"));
	}	
	/**
	 * 医保业务类型编码
	 * @param Code_business
	 */
	public void setCode_business(Integer Code_business) {
		setAttrVal("Code_business", Code_business);
	}
	/**
	 * 医保业务类型名称
	 * @return String
	 */
	public String getName_business() {
		return ((String) getAttrVal("Name_business"));
	}	
	/**
	 * 医保业务类型名称
	 * @param Name_business
	 */
	public void setName_business(String Name_business) {
		setAttrVal("Name_business", Name_business);
	}
	/**
	 * 医保登记号
	 * @return String
	 */
	public String getRegister_no() {
		return ((String) getAttrVal("Register_no"));
	}	
	/**
	 * 医保登记号
	 * @param Register_no
	 */
	public void setRegister_no(String Register_no) {
		setAttrVal("Register_no", Register_no);
	}
	/**
	 * 医保交易流水号
	 * @return String
	 */
	public String getTrade_no() {
		return ((String) getAttrVal("Trade_no"));
	}	
	/**
	 * 医保交易流水号
	 * @param Trade_no
	 */
	public void setTrade_no(String Trade_no) {
		setAttrVal("Trade_no", Trade_no);
	}
	/**
	 * 交易日期
	 * @return FDateTime
	 */
	public FDateTime getDt_trans() {
		return ((FDateTime) getAttrVal("Dt_trans"));
	}	
	/**
	 * 交易日期
	 * @param Dt_trans
	 */
	public void setDt_trans(FDateTime Dt_trans) {
		setAttrVal("Dt_trans", Dt_trans);
	}
	/**
	 * 交易入参
	 * @return String
	 */
	public String getInputinfo() {
		return ((String) getAttrVal("Inputinfo"));
	}	
	/**
	 * 交易入参
	 * @param Inputinfo
	 */
	public void setInputinfo(String Inputinfo) {
		setAttrVal("Inputinfo", Inputinfo);
	}
	/**
	 * 交易出参
	 * @return String
	 */
	public String getOutputinfo() {
		return ((String) getAttrVal("Outputinfo"));
	}	
	/**
	 * 交易出参
	 * @param Outputinfo
	 */
	public void setOutputinfo(String Outputinfo) {
		setAttrVal("Outputinfo", Outputinfo);
	}
	/**
	 * 是否真实交易
	 * @return FBoolean
	 */
	public FBoolean getFg_real() {
		return ((FBoolean) getAttrVal("Fg_real"));
	}	
	/**
	 * 是否真实交易
	 * @param Fg_real
	 */
	public void setFg_real(FBoolean Fg_real) {
		setAttrVal("Fg_real", Fg_real);
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
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
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
		return "Id_transrecord";
	}
	
	@Override
	public String getTableName() {	  
		return "mi_trans_record";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MiTransRecordDODesc.class);
	}
	
}