package iih.bd.srv.condi.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.condi.d.desc.ConDiDODesc;
import java.math.BigDecimal;

/**
 * 传染病对应诊断 DO数据 
 * 
 */
public class ConDiDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//主键
	public static final String ID_BD_CONDI= "Id_bd_condi";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//传染病分类主键
	public static final String ID_UDIDOCLIST= "Id_udidoclist";
	//传染病分类编码
	public static final String SD_UDIDOCLIST= "Sd_udidoclist";
	//传染病分类名称
	public static final String NAME_UDIDOCLIST= "Name_udidoclist";
	//甲类传染病主键
	public static final String ID_UDIDOC_J= "Id_udidoc_j";
	//甲类传染病编码
	public static final String SD_UDIDOC_J= "Sd_udidoc_j";
	//甲类传染病名称
	public static final String NAME_UDIDOC_J= "Name_udidoc_j";
	//乙类传染病主键
	public static final String ID_UDIDOC_Y= "Id_udidoc_y";
	//乙类传染病编码
	public static final String SD_UDIDOC_Y= "Sd_udidoc_y";
	//乙类传染病名称
	public static final String NAME_UDIDOC_Y= "Name_udidoc_y";
	//丙类传染病主键
	public static final String ID_UDIDOC_B= "Id_udidoc_b";
	//丙类传染病编码
	public static final String SD_UDIDOC_B= "Sd_udidoc_b";
	//丙类传染病名称
	public static final String NAME_UDIDOC_B= "Name_udidoc_b";
	//其他传染病主键
	public static final String ID_UDIDOC_Q= "Id_udidoc_q";
	//其他传染病编码
	public static final String SD_UDIDOC_Q= "Sd_udidoc_q";
	//其他传染病名称
	public static final String NAME_UDIDOC_D= "Name_udidoc_d";
	//诊断主键
	public static final String ID_DIDEF= "Id_didef";
	//诊断编码
	public static final String SD_DIDEF= "Sd_didef";
	//诊断名称
	public static final String NAME_DIDEF= "Name_didef";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//组织编码
	public static final String ORG_CODE= "Org_code";
	//组织名称
	public static final String ORG_NAME= "Org_name";
	//编码
	public static final String GRP_CODE= "Grp_code";
	//名称
	public static final String GRP_NAME= "Grp_name";
	//编码
	public static final String UDIDOC_J_CODE= "Udidoc_j_code";
	//名称
	public static final String UDIDOC_J_NAME= "Udidoc_j_name";
	//编码
	public static final String UDIDOC_Y_CODE= "Udidoc_y_code";
	//名称
	public static final String UDIDOC_Y_NAME= "Udidoc_y_name";
	//编码
	public static final String UDIDOC_B_CODE= "Udidoc_b_code";
	//名称
	public static final String UDIDOC_B_NAME= "Udidoc_b_name";
	//编码
	public static final String UDIDOC_Q_CODE= "Udidoc_q_code";
	//名称
	public static final String UDIDOC_Q_NAME= "Udidoc_q_name";
	//诊断编码
	public static final String DIDEF_CODE= "Didef_code";
	//诊断名称
	public static final String DIDEF_NAME= "Didef_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_bd_condi() {
		return ((String) getAttrVal("Id_bd_condi"));
	}	
	/**
	 * 主键
	 * @param Id_bd_condi
	 */
	public void setId_bd_condi(String Id_bd_condi) {
		setAttrVal("Id_bd_condi", Id_bd_condi);
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
	 * 传染病分类主键
	 * @return String
	 */
	public String getId_udidoclist() {
		return ((String) getAttrVal("Id_udidoclist"));
	}	
	/**
	 * 传染病分类主键
	 * @param Id_udidoclist
	 */
	public void setId_udidoclist(String Id_udidoclist) {
		setAttrVal("Id_udidoclist", Id_udidoclist);
	}
	/**
	 * 传染病分类编码
	 * @return String
	 */
	public String getSd_udidoclist() {
		return ((String) getAttrVal("Sd_udidoclist"));
	}	
	/**
	 * 传染病分类编码
	 * @param Sd_udidoclist
	 */
	public void setSd_udidoclist(String Sd_udidoclist) {
		setAttrVal("Sd_udidoclist", Sd_udidoclist);
	}
	/**
	 * 传染病分类名称
	 * @return String
	 */
	public String getName_udidoclist() {
		return ((String) getAttrVal("Name_udidoclist"));
	}	
	/**
	 * 传染病分类名称
	 * @param Name_udidoclist
	 */
	public void setName_udidoclist(String Name_udidoclist) {
		setAttrVal("Name_udidoclist", Name_udidoclist);
	}
	/**
	 * 甲类传染病主键
	 * @return String
	 */
	public String getId_udidoc_j() {
		return ((String) getAttrVal("Id_udidoc_j"));
	}	
	/**
	 * 甲类传染病主键
	 * @param Id_udidoc_j
	 */
	public void setId_udidoc_j(String Id_udidoc_j) {
		setAttrVal("Id_udidoc_j", Id_udidoc_j);
	}
	/**
	 * 甲类传染病编码
	 * @return String
	 */
	public String getSd_udidoc_j() {
		return ((String) getAttrVal("Sd_udidoc_j"));
	}	
	/**
	 * 甲类传染病编码
	 * @param Sd_udidoc_j
	 */
	public void setSd_udidoc_j(String Sd_udidoc_j) {
		setAttrVal("Sd_udidoc_j", Sd_udidoc_j);
	}
	/**
	 * 甲类传染病名称
	 * @return String
	 */
	public String getName_udidoc_j() {
		return ((String) getAttrVal("Name_udidoc_j"));
	}	
	/**
	 * 甲类传染病名称
	 * @param Name_udidoc_j
	 */
	public void setName_udidoc_j(String Name_udidoc_j) {
		setAttrVal("Name_udidoc_j", Name_udidoc_j);
	}
	/**
	 * 乙类传染病主键
	 * @return String
	 */
	public String getId_udidoc_y() {
		return ((String) getAttrVal("Id_udidoc_y"));
	}	
	/**
	 * 乙类传染病主键
	 * @param Id_udidoc_y
	 */
	public void setId_udidoc_y(String Id_udidoc_y) {
		setAttrVal("Id_udidoc_y", Id_udidoc_y);
	}
	/**
	 * 乙类传染病编码
	 * @return String
	 */
	public String getSd_udidoc_y() {
		return ((String) getAttrVal("Sd_udidoc_y"));
	}	
	/**
	 * 乙类传染病编码
	 * @param Sd_udidoc_y
	 */
	public void setSd_udidoc_y(String Sd_udidoc_y) {
		setAttrVal("Sd_udidoc_y", Sd_udidoc_y);
	}
	/**
	 * 乙类传染病名称
	 * @return String
	 */
	public String getName_udidoc_y() {
		return ((String) getAttrVal("Name_udidoc_y"));
	}	
	/**
	 * 乙类传染病名称
	 * @param Name_udidoc_y
	 */
	public void setName_udidoc_y(String Name_udidoc_y) {
		setAttrVal("Name_udidoc_y", Name_udidoc_y);
	}
	/**
	 * 丙类传染病主键
	 * @return String
	 */
	public String getId_udidoc_b() {
		return ((String) getAttrVal("Id_udidoc_b"));
	}	
	/**
	 * 丙类传染病主键
	 * @param Id_udidoc_b
	 */
	public void setId_udidoc_b(String Id_udidoc_b) {
		setAttrVal("Id_udidoc_b", Id_udidoc_b);
	}
	/**
	 * 丙类传染病编码
	 * @return String
	 */
	public String getSd_udidoc_b() {
		return ((String) getAttrVal("Sd_udidoc_b"));
	}	
	/**
	 * 丙类传染病编码
	 * @param Sd_udidoc_b
	 */
	public void setSd_udidoc_b(String Sd_udidoc_b) {
		setAttrVal("Sd_udidoc_b", Sd_udidoc_b);
	}
	/**
	 * 丙类传染病名称
	 * @return String
	 */
	public String getName_udidoc_b() {
		return ((String) getAttrVal("Name_udidoc_b"));
	}	
	/**
	 * 丙类传染病名称
	 * @param Name_udidoc_b
	 */
	public void setName_udidoc_b(String Name_udidoc_b) {
		setAttrVal("Name_udidoc_b", Name_udidoc_b);
	}
	/**
	 * 其他传染病主键
	 * @return String
	 */
	public String getId_udidoc_q() {
		return ((String) getAttrVal("Id_udidoc_q"));
	}	
	/**
	 * 其他传染病主键
	 * @param Id_udidoc_q
	 */
	public void setId_udidoc_q(String Id_udidoc_q) {
		setAttrVal("Id_udidoc_q", Id_udidoc_q);
	}
	/**
	 * 其他传染病编码
	 * @return String
	 */
	public String getSd_udidoc_q() {
		return ((String) getAttrVal("Sd_udidoc_q"));
	}	
	/**
	 * 其他传染病编码
	 * @param Sd_udidoc_q
	 */
	public void setSd_udidoc_q(String Sd_udidoc_q) {
		setAttrVal("Sd_udidoc_q", Sd_udidoc_q);
	}
	/**
	 * 其他传染病名称
	 * @return String
	 */
	public String getName_udidoc_d() {
		return ((String) getAttrVal("Name_udidoc_d"));
	}	
	/**
	 * 其他传染病名称
	 * @param Name_udidoc_d
	 */
	public void setName_udidoc_d(String Name_udidoc_d) {
		setAttrVal("Name_udidoc_d", Name_udidoc_d);
	}
	/**
	 * 诊断主键
	 * @return String
	 */
	public String getId_didef() {
		return ((String) getAttrVal("Id_didef"));
	}	
	/**
	 * 诊断主键
	 * @param Id_didef
	 */
	public void setId_didef(String Id_didef) {
		setAttrVal("Id_didef", Id_didef);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getSd_didef() {
		return ((String) getAttrVal("Sd_didef"));
	}	
	/**
	 * 诊断编码
	 * @param Sd_didef
	 */
	public void setSd_didef(String Sd_didef) {
		setAttrVal("Sd_didef", Sd_didef);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName_didef() {
		return ((String) getAttrVal("Name_didef"));
	}	
	/**
	 * 诊断名称
	 * @param Name_didef
	 */
	public void setName_didef(String Name_didef) {
		setAttrVal("Name_didef", Name_didef);
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
	 * 组织编码
	 * @return String
	 */
	public String getOrg_code() {
		return ((String) getAttrVal("Org_code"));
	}	
	/**
	 * 组织编码
	 * @param Org_code
	 */
	public void setOrg_code(String Org_code) {
		setAttrVal("Org_code", Org_code);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	/**
	 * 组织名称
	 * @param Org_name
	 */
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getGrp_code() {
		return ((String) getAttrVal("Grp_code"));
	}	
	/**
	 * 编码
	 * @param Grp_code
	 */
	public void setGrp_code(String Grp_code) {
		setAttrVal("Grp_code", Grp_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getGrp_name() {
		return ((String) getAttrVal("Grp_name"));
	}	
	/**
	 * 名称
	 * @param Grp_name
	 */
	public void setGrp_name(String Grp_name) {
		setAttrVal("Grp_name", Grp_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getUdidoc_j_code() {
		return ((String) getAttrVal("Udidoc_j_code"));
	}	
	/**
	 * 编码
	 * @param Udidoc_j_code
	 */
	public void setUdidoc_j_code(String Udidoc_j_code) {
		setAttrVal("Udidoc_j_code", Udidoc_j_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getUdidoc_j_name() {
		return ((String) getAttrVal("Udidoc_j_name"));
	}	
	/**
	 * 名称
	 * @param Udidoc_j_name
	 */
	public void setUdidoc_j_name(String Udidoc_j_name) {
		setAttrVal("Udidoc_j_name", Udidoc_j_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getUdidoc_y_code() {
		return ((String) getAttrVal("Udidoc_y_code"));
	}	
	/**
	 * 编码
	 * @param Udidoc_y_code
	 */
	public void setUdidoc_y_code(String Udidoc_y_code) {
		setAttrVal("Udidoc_y_code", Udidoc_y_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getUdidoc_y_name() {
		return ((String) getAttrVal("Udidoc_y_name"));
	}	
	/**
	 * 名称
	 * @param Udidoc_y_name
	 */
	public void setUdidoc_y_name(String Udidoc_y_name) {
		setAttrVal("Udidoc_y_name", Udidoc_y_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getUdidoc_b_code() {
		return ((String) getAttrVal("Udidoc_b_code"));
	}	
	/**
	 * 编码
	 * @param Udidoc_b_code
	 */
	public void setUdidoc_b_code(String Udidoc_b_code) {
		setAttrVal("Udidoc_b_code", Udidoc_b_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getUdidoc_b_name() {
		return ((String) getAttrVal("Udidoc_b_name"));
	}	
	/**
	 * 名称
	 * @param Udidoc_b_name
	 */
	public void setUdidoc_b_name(String Udidoc_b_name) {
		setAttrVal("Udidoc_b_name", Udidoc_b_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getUdidoc_q_code() {
		return ((String) getAttrVal("Udidoc_q_code"));
	}	
	/**
	 * 编码
	 * @param Udidoc_q_code
	 */
	public void setUdidoc_q_code(String Udidoc_q_code) {
		setAttrVal("Udidoc_q_code", Udidoc_q_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getUdidoc_q_name() {
		return ((String) getAttrVal("Udidoc_q_name"));
	}	
	/**
	 * 名称
	 * @param Udidoc_q_name
	 */
	public void setUdidoc_q_name(String Udidoc_q_name) {
		setAttrVal("Udidoc_q_name", Udidoc_q_name);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getDidef_code() {
		return ((String) getAttrVal("Didef_code"));
	}	
	/**
	 * 诊断编码
	 * @param Didef_code
	 */
	public void setDidef_code(String Didef_code) {
		setAttrVal("Didef_code", Didef_code);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getDidef_name() {
		return ((String) getAttrVal("Didef_name"));
	}	
	/**
	 * 诊断名称
	 * @param Didef_name
	 */
	public void setDidef_name(String Didef_name) {
		setAttrVal("Didef_name", Didef_name);
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
		return "Id_bd_condi";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_contagion_di";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ConDiDODesc.class);
	}
	
}