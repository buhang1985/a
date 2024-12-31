package iih.mi.biz.mirecordstrecord.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mi.biz.mirecordstrecord.d.desc.MiOrderStRecordDODesc;
import java.math.BigDecimal;

/**
 * 医保交易结算状态关系表 DO数据 
 * 
 */
public class MiOrderStRecordDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//订单结算关系id
	public static final String ID_ORDERSTRECORD= "Id_orderstrecord";
	//医保订单id
	public static final String ID_ORDERRECORD= "Id_orderrecord";
	//集团id
	public static final String ID_GRP= "Id_grp";
	//组织id
	public static final String ID_ORG= "Id_org";
	//患者id
	public static final String ID_PAT= "Id_pat";
	//医保卡号
	public static final String HP_NO= "Hp_no";
	//医保计划
	public static final String ID_HP= "Id_hp";
	//结算号
	public static final String CODE_ST= "Code_st";
	//结算方向
	public static final String EU_DIRECT= "Eu_direct";
	//原始交易记录id
	public static final String ID_ROOT= "Id_root";
	//交易记录id
	public static final String ID_PARENT= "Id_parent";
	//医保登记流水号
	public static final String REGISTER_NO= "Register_no";
	//医保交易流水号
	public static final String TRADE_NO= "Trade_no";
	//交易状态
	public static final String EU_STATUS= "Eu_status";
	//是否锁定
	public static final String FG_LOCK= "Fg_lock";
	//订单日期
	public static final String DT_ORDER= "Dt_order";
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
	 * 订单结算关系id
	 * @return String
	 */
	public String getId_orderstrecord() {
		return ((String) getAttrVal("Id_orderstrecord"));
	}	
	/**
	 * 订单结算关系id
	 * @param Id_orderstrecord
	 */
	public void setId_orderstrecord(String Id_orderstrecord) {
		setAttrVal("Id_orderstrecord", Id_orderstrecord);
	}
	/**
	 * 医保订单id
	 * @return String
	 */
	public String getId_orderrecord() {
		return ((String) getAttrVal("Id_orderrecord"));
	}	
	/**
	 * 医保订单id
	 * @param Id_orderrecord
	 */
	public void setId_orderrecord(String Id_orderrecord) {
		setAttrVal("Id_orderrecord", Id_orderrecord);
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
	 * 医保卡号
	 * @return String
	 */
	public String getHp_no() {
		return ((String) getAttrVal("Hp_no"));
	}	
	/**
	 * 医保卡号
	 * @param Hp_no
	 */
	public void setHp_no(String Hp_no) {
		setAttrVal("Hp_no", Hp_no);
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
	 * 结算方向
	 * @return Integer
	 */
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}	
	/**
	 * 结算方向
	 * @param Eu_direct
	 */
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	/**
	 * 原始交易记录id
	 * @return String
	 */
	public String getId_root() {
		return ((String) getAttrVal("Id_root"));
	}	
	/**
	 * 原始交易记录id
	 * @param Id_root
	 */
	public void setId_root(String Id_root) {
		setAttrVal("Id_root", Id_root);
	}
	/**
	 * 交易记录id
	 * @return String
	 */
	public String getId_parent() {
		return ((String) getAttrVal("Id_parent"));
	}	
	/**
	 * 交易记录id
	 * @param Id_parent
	 */
	public void setId_parent(String Id_parent) {
		setAttrVal("Id_parent", Id_parent);
	}
	/**
	 * 医保登记流水号
	 * @return String
	 */
	public String getRegister_no() {
		return ((String) getAttrVal("Register_no"));
	}	
	/**
	 * 医保登记流水号
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
	 * 交易状态
	 * @return Integer
	 */
	public Integer getEu_status() {
		return ((Integer) getAttrVal("Eu_status"));
	}	
	/**
	 * 交易状态
	 * @param Eu_status
	 */
	public void setEu_status(Integer Eu_status) {
		setAttrVal("Eu_status", Eu_status);
	}
	/**
	 * 是否锁定
	 * @return FBoolean
	 */
	public FBoolean getFg_lock() {
		return ((FBoolean) getAttrVal("Fg_lock"));
	}	
	/**
	 * 是否锁定
	 * @param Fg_lock
	 */
	public void setFg_lock(FBoolean Fg_lock) {
		setAttrVal("Fg_lock", Fg_lock);
	}
	/**
	 * 订单日期
	 * @return FDateTime
	 */
	public FDateTime getDt_order() {
		return ((FDateTime) getAttrVal("Dt_order"));
	}	
	/**
	 * 订单日期
	 * @param Dt_order
	 */
	public void setDt_order(FDateTime Dt_order) {
		setAttrVal("Dt_order", Dt_order);
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
		return "Id_orderstrecord";
	}
	
	@Override
	public String getTableName() {	  
		return "mi_order_st_record";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MiOrderStRecordDODesc.class);
	}
	
}