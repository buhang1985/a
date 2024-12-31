package iih.pe.por.peorder.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.por.peorder.d.desc.PeOrderDODesc;
import java.math.BigDecimal;

/**
 * 体检销售订单 DO数据 
 * 
 */
public class PeOrderDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检销售订单主键标识
	public static final String ID_PEORDER= "Id_peorder";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//销售日期
	public static final String DT_SALE= "Dt_sale";
	//销售员ID
	public static final String ID_SALEMAN= "Id_saleman";
	//个人团体标识
	public static final String FG_PSN= "Fg_psn";
	//合同金额
	public static final String CONTRACT_AMOUNT= "Contract_amount";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//合同内容
	public static final String CONTRACT_CONTENT= "Contract_content";
	//订单状态
	public static final String ST_ORDER= "St_order";
	//审核日期
	public static final String DT_AUDIT= "Dt_audit";
	//审核人
	public static final String ID_AUDIT= "Id_audit";
	//用户名称
	public static final String NAME_SALE= "Name_sale";
	//用户编码
	public static final String CODE_SALE= "Code_sale";
	//用户名称
	public static final String NAME_AUDIT= "Name_audit";
	//用户编码
	public static final String CODE_AUDIT= "Code_audit";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检销售订单主键标识
	 * @return String
	 */
	public String getId_peorder() {
		return ((String) getAttrVal("Id_peorder"));
	}	
	/**
	 * 体检销售订单主键标识
	 * @param Id_peorder
	 */
	public void setId_peorder(String Id_peorder) {
		setAttrVal("Id_peorder", Id_peorder);
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
	 * 销售日期
	 * @return FDate
	 */
	public FDate getDt_sale() {
		return ((FDate) getAttrVal("Dt_sale"));
	}	
	/**
	 * 销售日期
	 * @param Dt_sale
	 */
	public void setDt_sale(FDate Dt_sale) {
		setAttrVal("Dt_sale", Dt_sale);
	}
	/**
	 * 销售员ID
	 * @return String
	 */
	public String getId_saleman() {
		return ((String) getAttrVal("Id_saleman"));
	}	
	/**
	 * 销售员ID
	 * @param Id_saleman
	 */
	public void setId_saleman(String Id_saleman) {
		setAttrVal("Id_saleman", Id_saleman);
	}
	/**
	 * 个人团体标识
	 * @return FBoolean
	 */
	public FBoolean getFg_psn() {
		return ((FBoolean) getAttrVal("Fg_psn"));
	}	
	/**
	 * 个人团体标识
	 * @param Fg_psn
	 */
	public void setFg_psn(FBoolean Fg_psn) {
		setAttrVal("Fg_psn", Fg_psn);
	}
	/**
	 * 合同金额
	 * @return FDouble
	 */
	public FDouble getContract_amount() {
		return ((FDouble) getAttrVal("Contract_amount"));
	}	
	/**
	 * 合同金额
	 * @param Contract_amount
	 */
	public void setContract_amount(FDouble Contract_amount) {
		setAttrVal("Contract_amount", Contract_amount);
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
	 * 合同内容
	 * @return String
	 */
	public String getContract_content() {
		return ((String) getAttrVal("Contract_content"));
	}	
	/**
	 * 合同内容
	 * @param Contract_content
	 */
	public void setContract_content(String Contract_content) {
		setAttrVal("Contract_content", Contract_content);
	}
	/**
	 * 订单状态
	 * @return String
	 */
	public String getSt_order() {
		return ((String) getAttrVal("St_order"));
	}	
	/**
	 * 订单状态
	 * @param St_order
	 */
	public void setSt_order(String St_order) {
		setAttrVal("St_order", St_order);
	}
	/**
	 * 审核日期
	 * @return FDate
	 */
	public FDate getDt_audit() {
		return ((FDate) getAttrVal("Dt_audit"));
	}	
	/**
	 * 审核日期
	 * @param Dt_audit
	 */
	public void setDt_audit(FDate Dt_audit) {
		setAttrVal("Dt_audit", Dt_audit);
	}
	/**
	 * 审核人
	 * @return String
	 */
	public String getId_audit() {
		return ((String) getAttrVal("Id_audit"));
	}	
	/**
	 * 审核人
	 * @param Id_audit
	 */
	public void setId_audit(String Id_audit) {
		setAttrVal("Id_audit", Id_audit);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getName_sale() {
		return ((String) getAttrVal("Name_sale"));
	}	
	/**
	 * 用户名称
	 * @param Name_sale
	 */
	public void setName_sale(String Name_sale) {
		setAttrVal("Name_sale", Name_sale);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getCode_sale() {
		return ((String) getAttrVal("Code_sale"));
	}	
	/**
	 * 用户编码
	 * @param Code_sale
	 */
	public void setCode_sale(String Code_sale) {
		setAttrVal("Code_sale", Code_sale);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getName_audit() {
		return ((String) getAttrVal("Name_audit"));
	}	
	/**
	 * 用户名称
	 * @param Name_audit
	 */
	public void setName_audit(String Name_audit) {
		setAttrVal("Name_audit", Name_audit);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getCode_audit() {
		return ((String) getAttrVal("Code_audit"));
	}	
	/**
	 * 用户编码
	 * @param Code_audit
	 */
	public void setCode_audit(String Code_audit) {
		setAttrVal("Code_audit", Code_audit);
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
		return "Id_peorder";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_or_order";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeOrderDODesc.class);
	}
	
}