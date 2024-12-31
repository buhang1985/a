package iih.pis.ivx.pisivxmsgtext.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pis.ivx.pisivxmsgtext.d.desc.PisivxMsgTextDODesc;
import java.math.BigDecimal;

/**
 * 微信群发文本消息 DO数据 
 * 
 */
public class PisivxMsgTextDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//微信文本消息主键标识
	public static final String ID_PISIVXMSGTEXT= "Id_pisivxmsgtext";
	//内容
	public static final String CONT= "Cont";
	//发送时间
	public static final String DT_SEND= "Dt_send";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 微信文本消息主键标识
	 * @return String
	 */
	public String getId_pisivxmsgtext() {
		return ((String) getAttrVal("Id_pisivxmsgtext"));
	}	
	/**
	 * 微信文本消息主键标识
	 * @param Id_pisivxmsgtext
	 */
	public void setId_pisivxmsgtext(String Id_pisivxmsgtext) {
		setAttrVal("Id_pisivxmsgtext", Id_pisivxmsgtext);
	}
	/**
	 * 内容
	 * @return String
	 */
	public String getCont() {
		return ((String) getAttrVal("Cont"));
	}	
	/**
	 * 内容
	 * @param Cont
	 */
	public void setCont(String Cont) {
		setAttrVal("Cont", Cont);
	}
	/**
	 * 发送时间
	 * @return FDateTime
	 */
	public FDateTime getDt_send() {
		return ((FDateTime) getAttrVal("Dt_send"));
	}	
	/**
	 * 发送时间
	 * @param Dt_send
	 */
	public void setDt_send(FDateTime Dt_send) {
		setAttrVal("Dt_send", Dt_send);
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
		return "Id_pisivxmsgtext";
	}
	
	@Override
	public String getTableName() {	  
		return "pis_ivx_msgtext";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PisivxMsgTextDODesc.class);
	}
	
}