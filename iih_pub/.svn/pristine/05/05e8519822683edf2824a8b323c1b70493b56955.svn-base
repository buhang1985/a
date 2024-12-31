package iih.bd.srv.connonationitm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.connonationitm.d.desc.ConnonationItmDODesc;
import java.math.BigDecimal;

/**
 * 内涵质控项目 DO数据 
 * 
 */
public class ConnonationItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//主键
	public static final String ID_CONNONATION_REQ= "Id_connonation_req";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//显示顺序
	public static final String SORTNO= "Sortno";
	//质控项目
	public static final String REQ_CONNO= "Req_conno";
	//质控项目要求
	public static final String REQ_CONNO_TXT= "Req_conno_txt";
	//是否单否项
	public static final String FG_NONE= "Fg_none";
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
	 * 主键
	 * @return String
	 */
	public String getId_connonation_req() {
		return ((String) getAttrVal("Id_connonation_req"));
	}	
	/**
	 * 主键
	 * @param Id_connonation_req
	 */
	public void setId_connonation_req(String Id_connonation_req) {
		setAttrVal("Id_connonation_req", Id_connonation_req);
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
	 * 显示顺序
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}	
	/**
	 * 显示顺序
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 质控项目
	 * @return String
	 */
	public String getReq_conno() {
		return ((String) getAttrVal("Req_conno"));
	}	
	/**
	 * 质控项目
	 * @param Req_conno
	 */
	public void setReq_conno(String Req_conno) {
		setAttrVal("Req_conno", Req_conno);
	}
	/**
	 * 质控项目要求
	 * @return String
	 */
	public String getReq_conno_txt() {
		return ((String) getAttrVal("Req_conno_txt"));
	}	
	/**
	 * 质控项目要求
	 * @param Req_conno_txt
	 */
	public void setReq_conno_txt(String Req_conno_txt) {
		setAttrVal("Req_conno_txt", Req_conno_txt);
	}
	/**
	 * 是否单否项
	 * @return FBoolean
	 */
	public FBoolean getFg_none() {
		return ((FBoolean) getAttrVal("Fg_none"));
	}	
	/**
	 * 是否单否项
	 * @param Fg_none
	 */
	public void setFg_none(FBoolean Fg_none) {
		setAttrVal("Fg_none", Fg_none);
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
		return "Id_connonation_req";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_qa_connonation_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ConnonationItmDODesc.class);
	}
	
}