package iih.bl.inc.blinccanc.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.inc.blinccanc.d.desc.BlIncCancDODesc;
import java.math.BigDecimal;

/**
 * 空白作废票据 DO数据 
 * 
 */
public class BlIncCancDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//发票主键
	public static final String ID_INC= "Id_inc";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//票据分类
	public static final String ID_INCCA= "Id_incca";
	//票据包编号
	public static final String CODE_INCPKG= "Code_incpkg";
	//发票号码
	public static final String INCNO= "Incno";
	//发票作废标志
	public static final String FG_CANC= "Fg_canc";
	//发票作废原因
	public static final String ID_REASON_CANC= "Id_reason_canc";
	//发票作废原因编码
	public static final String SD_REASON_CANC= "Sd_reason_canc";
	//发票作废原因描述
	public static final String DES_REASON_CANC= "Des_reason_canc";
	//发票作废日期
	public static final String DT_CANC= "Dt_canc";
	//发票作废操作人
	public static final String ID_EMP_CANC= "Id_emp_canc";
	//结账标志
	public static final String FG_CC= "Fg_cc";
	//操作员结账
	public static final String ID_CC= "Id_cc";
	//计算机
	public static final String ID_PC= "Id_pc";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//票据领用主键
	public static final String ID_INCISS= "Id_inciss";
	//出票方式
	public static final String EU_PRINTMD= "Eu_printmd";
	//是否电子票纸质票
	public static final String FG_EC_INC= "Fg_ec_inc";
	//票据分类编码
	public static final String INCCACANCCODE= "Inccacanccode";
	//票据分类名称
	public static final String INCCACANCNAME= "Inccacancname";
	//编码
	public static final String REANSONCODE= "Reansoncode";
	//名称
	public static final String REANSONNAME= "Reansonname";
	//人员编码
	public static final String EMPCANCCODE= "Empcanccode";
	//姓名
	public static final String EMPCANCNAME= "Empcancname";
	//票据包编号
	public static final String CODEINCPKG= "Codeincpkg";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 发票主键
	 * @return String
	 */
	public String getId_inc() {
		return ((String) getAttrVal("Id_inc"));
	}	
	/**
	 * 发票主键
	 * @param Id_inc
	 */
	public void setId_inc(String Id_inc) {
		setAttrVal("Id_inc", Id_inc);
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
	 * 票据分类
	 * @return String
	 */
	public String getId_incca() {
		return ((String) getAttrVal("Id_incca"));
	}	
	/**
	 * 票据分类
	 * @param Id_incca
	 */
	public void setId_incca(String Id_incca) {
		setAttrVal("Id_incca", Id_incca);
	}
	/**
	 * 票据包编号
	 * @return String
	 */
	public String getCode_incpkg() {
		return ((String) getAttrVal("Code_incpkg"));
	}	
	/**
	 * 票据包编号
	 * @param Code_incpkg
	 */
	public void setCode_incpkg(String Code_incpkg) {
		setAttrVal("Code_incpkg", Code_incpkg);
	}
	/**
	 * 发票号码
	 * @return String
	 */
	public String getIncno() {
		return ((String) getAttrVal("Incno"));
	}	
	/**
	 * 发票号码
	 * @param Incno
	 */
	public void setIncno(String Incno) {
		setAttrVal("Incno", Incno);
	}
	/**
	 * 发票作废标志
	 * @return FBoolean
	 */
	public FBoolean getFg_canc() {
		return ((FBoolean) getAttrVal("Fg_canc"));
	}	
	/**
	 * 发票作废标志
	 * @param Fg_canc
	 */
	public void setFg_canc(FBoolean Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	/**
	 * 发票作废原因
	 * @return String
	 */
	public String getId_reason_canc() {
		return ((String) getAttrVal("Id_reason_canc"));
	}	
	/**
	 * 发票作废原因
	 * @param Id_reason_canc
	 */
	public void setId_reason_canc(String Id_reason_canc) {
		setAttrVal("Id_reason_canc", Id_reason_canc);
	}
	/**
	 * 发票作废原因编码
	 * @return String
	 */
	public String getSd_reason_canc() {
		return ((String) getAttrVal("Sd_reason_canc"));
	}	
	/**
	 * 发票作废原因编码
	 * @param Sd_reason_canc
	 */
	public void setSd_reason_canc(String Sd_reason_canc) {
		setAttrVal("Sd_reason_canc", Sd_reason_canc);
	}
	/**
	 * 发票作废原因描述
	 * @return String
	 */
	public String getDes_reason_canc() {
		return ((String) getAttrVal("Des_reason_canc"));
	}	
	/**
	 * 发票作废原因描述
	 * @param Des_reason_canc
	 */
	public void setDes_reason_canc(String Des_reason_canc) {
		setAttrVal("Des_reason_canc", Des_reason_canc);
	}
	/**
	 * 发票作废日期
	 * @return FDateTime
	 */
	public FDateTime getDt_canc() {
		return ((FDateTime) getAttrVal("Dt_canc"));
	}	
	/**
	 * 发票作废日期
	 * @param Dt_canc
	 */
	public void setDt_canc(FDateTime Dt_canc) {
		setAttrVal("Dt_canc", Dt_canc);
	}
	/**
	 * 发票作废操作人
	 * @return String
	 */
	public String getId_emp_canc() {
		return ((String) getAttrVal("Id_emp_canc"));
	}	
	/**
	 * 发票作废操作人
	 * @param Id_emp_canc
	 */
	public void setId_emp_canc(String Id_emp_canc) {
		setAttrVal("Id_emp_canc", Id_emp_canc);
	}
	/**
	 * 结账标志
	 * @return FBoolean
	 */
	public FBoolean getFg_cc() {
		return ((FBoolean) getAttrVal("Fg_cc"));
	}	
	/**
	 * 结账标志
	 * @param Fg_cc
	 */
	public void setFg_cc(FBoolean Fg_cc) {
		setAttrVal("Fg_cc", Fg_cc);
	}
	/**
	 * 操作员结账
	 * @return String
	 */
	public String getId_cc() {
		return ((String) getAttrVal("Id_cc"));
	}	
	/**
	 * 操作员结账
	 * @param Id_cc
	 */
	public void setId_cc(String Id_cc) {
		setAttrVal("Id_cc", Id_cc);
	}
	/**
	 * 计算机
	 * @return String
	 */
	public String getId_pc() {
		return ((String) getAttrVal("Id_pc"));
	}	
	/**
	 * 计算机
	 * @param Id_pc
	 */
	public void setId_pc(String Id_pc) {
		setAttrVal("Id_pc", Id_pc);
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
	 * 票据领用主键
	 * @return String
	 */
	public String getId_inciss() {
		return ((String) getAttrVal("Id_inciss"));
	}	
	/**
	 * 票据领用主键
	 * @param Id_inciss
	 */
	public void setId_inciss(String Id_inciss) {
		setAttrVal("Id_inciss", Id_inciss);
	}
	/**
	 * 出票方式
	 * @return String
	 */
	public String getEu_printmd() {
		return ((String) getAttrVal("Eu_printmd"));
	}	
	/**
	 * 出票方式
	 * @param Eu_printmd
	 */
	public void setEu_printmd(String Eu_printmd) {
		setAttrVal("Eu_printmd", Eu_printmd);
	}
	/**
	 * 是否电子票纸质票
	 * @return FBoolean
	 */
	public FBoolean getFg_ec_inc() {
		return ((FBoolean) getAttrVal("Fg_ec_inc"));
	}	
	/**
	 * 是否电子票纸质票
	 * @param Fg_ec_inc
	 */
	public void setFg_ec_inc(FBoolean Fg_ec_inc) {
		setAttrVal("Fg_ec_inc", Fg_ec_inc);
	}
	/**
	 * 票据分类编码
	 * @return String
	 */
	public String getInccacanccode() {
		return ((String) getAttrVal("Inccacanccode"));
	}	
	/**
	 * 票据分类编码
	 * @param Inccacanccode
	 */
	public void setInccacanccode(String Inccacanccode) {
		setAttrVal("Inccacanccode", Inccacanccode);
	}
	/**
	 * 票据分类名称
	 * @return String
	 */
	public String getInccacancname() {
		return ((String) getAttrVal("Inccacancname"));
	}	
	/**
	 * 票据分类名称
	 * @param Inccacancname
	 */
	public void setInccacancname(String Inccacancname) {
		setAttrVal("Inccacancname", Inccacancname);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getReansoncode() {
		return ((String) getAttrVal("Reansoncode"));
	}	
	/**
	 * 编码
	 * @param Reansoncode
	 */
	public void setReansoncode(String Reansoncode) {
		setAttrVal("Reansoncode", Reansoncode);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getReansonname() {
		return ((String) getAttrVal("Reansonname"));
	}	
	/**
	 * 名称
	 * @param Reansonname
	 */
	public void setReansonname(String Reansonname) {
		setAttrVal("Reansonname", Reansonname);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getEmpcanccode() {
		return ((String) getAttrVal("Empcanccode"));
	}	
	/**
	 * 人员编码
	 * @param Empcanccode
	 */
	public void setEmpcanccode(String Empcanccode) {
		setAttrVal("Empcanccode", Empcanccode);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getEmpcancname() {
		return ((String) getAttrVal("Empcancname"));
	}	
	/**
	 * 姓名
	 * @param Empcancname
	 */
	public void setEmpcancname(String Empcancname) {
		setAttrVal("Empcancname", Empcancname);
	}
	/**
	 * 票据包编号
	 * @return String
	 */
	public String getCodeincpkg() {
		return ((String) getAttrVal("Codeincpkg"));
	}	
	/**
	 * 票据包编号
	 * @param Codeincpkg
	 */
	public void setCodeincpkg(String Codeincpkg) {
		setAttrVal("Codeincpkg", Codeincpkg);
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
		return "Id_inc";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_inc_canc";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlIncCancDODesc.class);
	}
	
}