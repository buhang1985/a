package iih.pe.pwf.pelogrst.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pwf.pelogrst.d.desc.PeLogRstDODesc;
import java.math.BigDecimal;

/**
 * 体检结果操作日志 DO数据 
 * 
 */
public class PeLogRstDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检结果日志标识
	public static final String ID_PELOGRST= "Id_pelogrst";
	//体检预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//体检结果ID
	public static final String ID_PERST= "Id_perst";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//操作类型
	public static final String OPTP= "Optp";
	//修改内容
	public static final String LOGCON= "Logcon";
	//原始值
	public static final String VAL_ORG= "Val_org";
	//新值
	public static final String VAL_NEW= "Val_new";
	//操作员姓名
	public static final String OPERATOR= "Operator";
	//操作员ID
	public static final String ID_OPERATOR= "Id_operator";
	//操作时间
	public static final String DT_OP= "Dt_op";
	//操作客户端电脑IP
	public static final String IP_PC= "Ip_pc";
	//操作客户端电脑名称
	public static final String NAME_PC= "Name_pc";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//体检项目结果ID
	public static final String ID_PESRVITEM= "Id_pesrvitem";
	//体检项目目录ID
	public static final String ID_PESRVBCATLOG= "Id_pesrvbcatlog";
	//体检唯一码
	public static final String PE_CODE= "Pe_code";
	//客户姓名
	public static final String NAME_PSN= "Name_psn";
	//年龄
	public static final String AGE_PSN= "Age_psn";
	//性别
	public static final String SEX= "Sex";
	//体检时间
	public static final String DT_PE= "Dt_pe";
	//体检状态
	public static final String PESTATUS= "Pestatus";
	//体检登记备注
	public static final String RMK_PE= "Rmk_pe";
	//用户编码
	public static final String CODE_OPERATOR= "Code_operator";
	//用户名称
	public static final String NAME_OPERATOR= "Name_operator";
	//名称
	public static final String NAME_ITEM= "Name_item";
	//编码
	public static final String CODE_ITEM= "Code_item";
	//编码
	public static final String CODE_CATLOG= "Code_catlog";
	//名称
	public static final String NAME_CATLOG= "Name_catlog";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检结果日志标识
	 * @return String
	 */
	public String getId_pelogrst() {
		return ((String) getAttrVal("Id_pelogrst"));
	}	
	/**
	 * 体检结果日志标识
	 * @param Id_pelogrst
	 */
	public void setId_pelogrst(String Id_pelogrst) {
		setAttrVal("Id_pelogrst", Id_pelogrst);
	}
	/**
	 * 体检预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	/**
	 * 体检预约单ID
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	/**
	 * 体检结果ID
	 * @return String
	 */
	public String getId_perst() {
		return ((String) getAttrVal("Id_perst"));
	}	
	/**
	 * 体检结果ID
	 * @param Id_perst
	 */
	public void setId_perst(String Id_perst) {
		setAttrVal("Id_perst", Id_perst);
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
	 * 操作类型
	 * @return Integer
	 */
	public Integer getOptp() {
		return ((Integer) getAttrVal("Optp"));
	}	
	/**
	 * 操作类型
	 * @param Optp
	 */
	public void setOptp(Integer Optp) {
		setAttrVal("Optp", Optp);
	}
	/**
	 * 修改内容
	 * @return Integer
	 */
	public Integer getLogcon() {
		return ((Integer) getAttrVal("Logcon"));
	}	
	/**
	 * 修改内容
	 * @param Logcon
	 */
	public void setLogcon(Integer Logcon) {
		setAttrVal("Logcon", Logcon);
	}
	/**
	 * 原始值
	 * @return String
	 */
	public String getVal_org() {
		return ((String) getAttrVal("Val_org"));
	}	
	/**
	 * 原始值
	 * @param Val_org
	 */
	public void setVal_org(String Val_org) {
		setAttrVal("Val_org", Val_org);
	}
	/**
	 * 新值
	 * @return String
	 */
	public String getVal_new() {
		return ((String) getAttrVal("Val_new"));
	}	
	/**
	 * 新值
	 * @param Val_new
	 */
	public void setVal_new(String Val_new) {
		setAttrVal("Val_new", Val_new);
	}
	/**
	 * 操作员姓名
	 * @return String
	 */
	public String getOperator() {
		return ((String) getAttrVal("Operator"));
	}	
	/**
	 * 操作员姓名
	 * @param Operator
	 */
	public void setOperator(String Operator) {
		setAttrVal("Operator", Operator);
	}
	/**
	 * 操作员ID
	 * @return String
	 */
	public String getId_operator() {
		return ((String) getAttrVal("Id_operator"));
	}	
	/**
	 * 操作员ID
	 * @param Id_operator
	 */
	public void setId_operator(String Id_operator) {
		setAttrVal("Id_operator", Id_operator);
	}
	/**
	 * 操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_op() {
		return ((FDateTime) getAttrVal("Dt_op"));
	}	
	/**
	 * 操作时间
	 * @param Dt_op
	 */
	public void setDt_op(FDateTime Dt_op) {
		setAttrVal("Dt_op", Dt_op);
	}
	/**
	 * 操作客户端电脑IP
	 * @return String
	 */
	public String getIp_pc() {
		return ((String) getAttrVal("Ip_pc"));
	}	
	/**
	 * 操作客户端电脑IP
	 * @param Ip_pc
	 */
	public void setIp_pc(String Ip_pc) {
		setAttrVal("Ip_pc", Ip_pc);
	}
	/**
	 * 操作客户端电脑名称
	 * @return String
	 */
	public String getName_pc() {
		return ((String) getAttrVal("Name_pc"));
	}	
	/**
	 * 操作客户端电脑名称
	 * @param Name_pc
	 */
	public void setName_pc(String Name_pc) {
		setAttrVal("Name_pc", Name_pc);
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
	 * 体检项目结果ID
	 * @return String
	 */
	public String getId_pesrvitem() {
		return ((String) getAttrVal("Id_pesrvitem"));
	}	
	/**
	 * 体检项目结果ID
	 * @param Id_pesrvitem
	 */
	public void setId_pesrvitem(String Id_pesrvitem) {
		setAttrVal("Id_pesrvitem", Id_pesrvitem);
	}
	/**
	 * 体检项目目录ID
	 * @return String
	 */
	public String getId_pesrvbcatlog() {
		return ((String) getAttrVal("Id_pesrvbcatlog"));
	}	
	/**
	 * 体检项目目录ID
	 * @param Id_pesrvbcatlog
	 */
	public void setId_pesrvbcatlog(String Id_pesrvbcatlog) {
		setAttrVal("Id_pesrvbcatlog", Id_pesrvbcatlog);
	}
	/**
	 * 体检唯一码
	 * @return String
	 */
	public String getPe_code() {
		return ((String) getAttrVal("Pe_code"));
	}	
	/**
	 * 体检唯一码
	 * @param Pe_code
	 */
	public void setPe_code(String Pe_code) {
		setAttrVal("Pe_code", Pe_code);
	}
	/**
	 * 客户姓名
	 * @return String
	 */
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}	
	/**
	 * 客户姓名
	 * @param Name_psn
	 */
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
	}
	/**
	 * 年龄
	 * @return Integer
	 */
	public Integer getAge_psn() {
		return ((Integer) getAttrVal("Age_psn"));
	}	
	/**
	 * 年龄
	 * @param Age_psn
	 */
	public void setAge_psn(Integer Age_psn) {
		setAttrVal("Age_psn", Age_psn);
	}
	/**
	 * 性别
	 * @return Integer
	 */
	public Integer getSex() {
		return ((Integer) getAttrVal("Sex"));
	}	
	/**
	 * 性别
	 * @param Sex
	 */
	public void setSex(Integer Sex) {
		setAttrVal("Sex", Sex);
	}
	/**
	 * 体检时间
	 * @return FDate
	 */
	public FDate getDt_pe() {
		return ((FDate) getAttrVal("Dt_pe"));
	}	
	/**
	 * 体检时间
	 * @param Dt_pe
	 */
	public void setDt_pe(FDate Dt_pe) {
		setAttrVal("Dt_pe", Dt_pe);
	}
	/**
	 * 体检状态
	 * @return Integer
	 */
	public Integer getPestatus() {
		return ((Integer) getAttrVal("Pestatus"));
	}	
	/**
	 * 体检状态
	 * @param Pestatus
	 */
	public void setPestatus(Integer Pestatus) {
		setAttrVal("Pestatus", Pestatus);
	}
	/**
	 * 体检登记备注
	 * @return String
	 */
	public String getRmk_pe() {
		return ((String) getAttrVal("Rmk_pe"));
	}	
	/**
	 * 体检登记备注
	 * @param Rmk_pe
	 */
	public void setRmk_pe(String Rmk_pe) {
		setAttrVal("Rmk_pe", Rmk_pe);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getCode_operator() {
		return ((String) getAttrVal("Code_operator"));
	}	
	/**
	 * 用户编码
	 * @param Code_operator
	 */
	public void setCode_operator(String Code_operator) {
		setAttrVal("Code_operator", Code_operator);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getName_operator() {
		return ((String) getAttrVal("Name_operator"));
	}	
	/**
	 * 用户名称
	 * @param Name_operator
	 */
	public void setName_operator(String Name_operator) {
		setAttrVal("Name_operator", Name_operator);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_item() {
		return ((String) getAttrVal("Name_item"));
	}	
	/**
	 * 名称
	 * @param Name_item
	 */
	public void setName_item(String Name_item) {
		setAttrVal("Name_item", Name_item);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_item() {
		return ((String) getAttrVal("Code_item"));
	}	
	/**
	 * 编码
	 * @param Code_item
	 */
	public void setCode_item(String Code_item) {
		setAttrVal("Code_item", Code_item);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_catlog() {
		return ((String) getAttrVal("Code_catlog"));
	}	
	/**
	 * 编码
	 * @param Code_catlog
	 */
	public void setCode_catlog(String Code_catlog) {
		setAttrVal("Code_catlog", Code_catlog);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_catlog() {
		return ((String) getAttrVal("Name_catlog"));
	}	
	/**
	 * 名称
	 * @param Name_catlog
	 */
	public void setName_catlog(String Name_catlog) {
		setAttrVal("Name_catlog", Name_catlog);
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
		return "Id_pelogrst";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_log_pelogrst";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeLogRstDODesc.class);
	}
	
}