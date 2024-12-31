package iih.pe.por.pecomplain.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.por.pecomplain.d.desc.PeComplainDODesc;
import java.math.BigDecimal;

/**
 * 体检投诉反馈 DO数据 
 * 
 */
public class PeComplainDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检投诉反馈主键标识
	public static final String ID_PECOMPLAIN= "Id_pecomplain";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//体检客户ID
	public static final String ID_PEPSNBINFO= "Id_pepsnbinfo";
	//投诉来源
	public static final String ID_SOURCE= "Id_source";
	//投诉对象
	public static final String ID_TARGET= "Id_target";
	//类型
	public static final String COMPTP= "Comptp";
	//投诉内容
	public static final String COMPCONT= "Compcont";
	//受理日期
	public static final String DT_DEAL= "Dt_deal";
	//结案日期
	public static final String DT_SET= "Dt_set";
	//处理人员
	public static final String ID_DEAL= "Id_deal";
	//处理结果
	public static final String DEALRST= "Dealrst";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//客户编码
	public static final String CODE_PSN= "Code_psn";
	//姓名
	public static final String NAME_PSN= "Name_psn";
	//家庭电话
	public static final String TEL= "Tel";
	//移动电话
	public static final String MOB= "Mob";
	//编码
	public static final String CODE_SOURCE= "Code_source";
	//名称
	public static final String NAME_SOURCE= "Name_source";
	//编码
	public static final String CODE_TARGET= "Code_target";
	//名称
	public static final String NAME_TARGET= "Name_target";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检投诉反馈主键标识
	 * @return String
	 */
	public String getId_pecomplain() {
		return ((String) getAttrVal("Id_pecomplain"));
	}	
	/**
	 * 体检投诉反馈主键标识
	 * @param Id_pecomplain
	 */
	public void setId_pecomplain(String Id_pecomplain) {
		setAttrVal("Id_pecomplain", Id_pecomplain);
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
	 * 体检客户ID
	 * @return String
	 */
	public String getId_pepsnbinfo() {
		return ((String) getAttrVal("Id_pepsnbinfo"));
	}	
	/**
	 * 体检客户ID
	 * @param Id_pepsnbinfo
	 */
	public void setId_pepsnbinfo(String Id_pepsnbinfo) {
		setAttrVal("Id_pepsnbinfo", Id_pepsnbinfo);
	}
	/**
	 * 投诉来源
	 * @return String
	 */
	public String getId_source() {
		return ((String) getAttrVal("Id_source"));
	}	
	/**
	 * 投诉来源
	 * @param Id_source
	 */
	public void setId_source(String Id_source) {
		setAttrVal("Id_source", Id_source);
	}
	/**
	 * 投诉对象
	 * @return String
	 */
	public String getId_target() {
		return ((String) getAttrVal("Id_target"));
	}	
	/**
	 * 投诉对象
	 * @param Id_target
	 */
	public void setId_target(String Id_target) {
		setAttrVal("Id_target", Id_target);
	}
	/**
	 * 类型
	 * @return Integer
	 */
	public Integer getComptp() {
		return ((Integer) getAttrVal("Comptp"));
	}	
	/**
	 * 类型
	 * @param Comptp
	 */
	public void setComptp(Integer Comptp) {
		setAttrVal("Comptp", Comptp);
	}
	/**
	 * 投诉内容
	 * @return String
	 */
	public String getCompcont() {
		return ((String) getAttrVal("Compcont"));
	}	
	/**
	 * 投诉内容
	 * @param Compcont
	 */
	public void setCompcont(String Compcont) {
		setAttrVal("Compcont", Compcont);
	}
	/**
	 * 受理日期
	 * @return FDate
	 */
	public FDate getDt_deal() {
		return ((FDate) getAttrVal("Dt_deal"));
	}	
	/**
	 * 受理日期
	 * @param Dt_deal
	 */
	public void setDt_deal(FDate Dt_deal) {
		setAttrVal("Dt_deal", Dt_deal);
	}
	/**
	 * 结案日期
	 * @return FDate
	 */
	public FDate getDt_set() {
		return ((FDate) getAttrVal("Dt_set"));
	}	
	/**
	 * 结案日期
	 * @param Dt_set
	 */
	public void setDt_set(FDate Dt_set) {
		setAttrVal("Dt_set", Dt_set);
	}
	/**
	 * 处理人员
	 * @return String
	 */
	public String getId_deal() {
		return ((String) getAttrVal("Id_deal"));
	}	
	/**
	 * 处理人员
	 * @param Id_deal
	 */
	public void setId_deal(String Id_deal) {
		setAttrVal("Id_deal", Id_deal);
	}
	/**
	 * 处理结果
	 * @return String
	 */
	public String getDealrst() {
		return ((String) getAttrVal("Dealrst"));
	}	
	/**
	 * 处理结果
	 * @param Dealrst
	 */
	public void setDealrst(String Dealrst) {
		setAttrVal("Dealrst", Dealrst);
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
	 * 客户编码
	 * @return String
	 */
	public String getCode_psn() {
		return ((String) getAttrVal("Code_psn"));
	}	
	/**
	 * 客户编码
	 * @param Code_psn
	 */
	public void setCode_psn(String Code_psn) {
		setAttrVal("Code_psn", Code_psn);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}	
	/**
	 * 姓名
	 * @param Name_psn
	 */
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
	}
	/**
	 * 家庭电话
	 * @return String
	 */
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}	
	/**
	 * 家庭电话
	 * @param Tel
	 */
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	/**
	 * 移动电话
	 * @return String
	 */
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}	
	/**
	 * 移动电话
	 * @param Mob
	 */
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_source() {
		return ((String) getAttrVal("Code_source"));
	}	
	/**
	 * 编码
	 * @param Code_source
	 */
	public void setCode_source(String Code_source) {
		setAttrVal("Code_source", Code_source);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_source() {
		return ((String) getAttrVal("Name_source"));
	}	
	/**
	 * 名称
	 * @param Name_source
	 */
	public void setName_source(String Name_source) {
		setAttrVal("Name_source", Name_source);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_target() {
		return ((String) getAttrVal("Code_target"));
	}	
	/**
	 * 编码
	 * @param Code_target
	 */
	public void setCode_target(String Code_target) {
		setAttrVal("Code_target", Code_target);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_target() {
		return ((String) getAttrVal("Name_target"));
	}	
	/**
	 * 名称
	 * @param Name_target
	 */
	public void setName_target(String Name_target) {
		setAttrVal("Name_target", Name_target);
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
		return "Id_pecomplain";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_or_pecomplain";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeComplainDODesc.class);
	}
	
}