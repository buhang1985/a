package iih.mp.mpbd.oporcfg.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.mpbd.oporcfg.d.desc.MpOpCfgDODesc;
import java.math.BigDecimal;

/**
 * 门急诊医嘱执行配置 DO数据 
 * 
 */
public class MpOpCfgDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_OPOR_CFG= "Id_opor_cfg";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String ID_ORPLTP= "Id_orpltp";
	public static final String ID_SRVTP= "Id_srvtp";
	public static final String SD_SRVTP= "Sd_srvtp";
	public static final String ID_MPROUTE= "Id_mproute";
	public static final String SD_MPROUTE= "Sd_mproute";
	public static final String ROUTEPARAM= "Routeparam";
	public static final String RPT_PATH= "Rpt_path";
	public static final String FG_REG_PRNT= "Fg_reg_prnt";
	public static final String ID_BILLFORM= "Id_billform";
	public static final String ID_EXECTP= "Id_exectp";
	public static final String SD_EXECTP= "Sd_exectp";
	public static final String ID_EXECTP_DEF= "Id_exectp_def";
	public static final String SD_EXECTP_DEF= "Sd_exectp_def";
	public static final String WIDTH= "Width";
	public static final String HEIGH= "Heigh";
	public static final String ID_PRNT_PARAM= "Id_prnt_param";
	public static final String CODE_PRNT_PARAM= "Code_prnt_param";
	public static final String DEF1= "Def1";
	public static final String DEF2= "Def2";
	public static final String DEF3= "Def3";
	public static final String DEF4= "Def4";
	public static final String DEF5= "Def5";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_ORPLTP= "Name_orpltp";
	public static final String NAME_SRVTP= "Name_srvtp";
	public static final String NAME_MPROUTE= "Name_mproute";
	public static final String BILLFORMCAPTION= "Billformcaption";
	public static final String NAME_EXETP= "Name_exetp";
	public static final String NAME_EXECTP_DEF= "Name_exectp_def";
	public static final String CODE_OPER= "Code_oper";
	public static final String PARAMNAME= "Paramname";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_opor_cfg() {
		return ((String) getAttrVal("Id_opor_cfg"));
	}	
	public void setId_opor_cfg(String Id_opor_cfg) {
		setAttrVal("Id_opor_cfg", Id_opor_cfg);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getId_orpltp() {
		return ((String) getAttrVal("Id_orpltp"));
	}	
	public void setId_orpltp(String Id_orpltp) {
		setAttrVal("Id_orpltp", Id_orpltp);
	}
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	public String getId_mproute() {
		return ((String) getAttrVal("Id_mproute"));
	}	
	public void setId_mproute(String Id_mproute) {
		setAttrVal("Id_mproute", Id_mproute);
	}
	public String getSd_mproute() {
		return ((String) getAttrVal("Sd_mproute"));
	}	
	public void setSd_mproute(String Sd_mproute) {
		setAttrVal("Sd_mproute", Sd_mproute);
	}
	public String getRouteparam() {
		return ((String) getAttrVal("Routeparam"));
	}	
	public void setRouteparam(String Routeparam) {
		setAttrVal("Routeparam", Routeparam);
	}
	public String getRpt_path() {
		return ((String) getAttrVal("Rpt_path"));
	}	
	public void setRpt_path(String Rpt_path) {
		setAttrVal("Rpt_path", Rpt_path);
	}
	public FBoolean getFg_reg_prnt() {
		return ((FBoolean) getAttrVal("Fg_reg_prnt"));
	}	
	public void setFg_reg_prnt(FBoolean Fg_reg_prnt) {
		setAttrVal("Fg_reg_prnt", Fg_reg_prnt);
	}
	public String getId_billform() {
		return ((String) getAttrVal("Id_billform"));
	}	
	public void setId_billform(String Id_billform) {
		setAttrVal("Id_billform", Id_billform);
	}
	public String getId_exectp() {
		return ((String) getAttrVal("Id_exectp"));
	}	
	public void setId_exectp(String Id_exectp) {
		setAttrVal("Id_exectp", Id_exectp);
	}
	public String getSd_exectp() {
		return ((String) getAttrVal("Sd_exectp"));
	}	
	public void setSd_exectp(String Sd_exectp) {
		setAttrVal("Sd_exectp", Sd_exectp);
	}
	public String getId_exectp_def() {
		return ((String) getAttrVal("Id_exectp_def"));
	}	
	public void setId_exectp_def(String Id_exectp_def) {
		setAttrVal("Id_exectp_def", Id_exectp_def);
	}
	public String getSd_exectp_def() {
		return ((String) getAttrVal("Sd_exectp_def"));
	}	
	public void setSd_exectp_def(String Sd_exectp_def) {
		setAttrVal("Sd_exectp_def", Sd_exectp_def);
	}
	public Integer getWidth() {
		return ((Integer) getAttrVal("Width"));
	}	
	public void setWidth(Integer Width) {
		setAttrVal("Width", Width);
	}
	public Integer getHeigh() {
		return ((Integer) getAttrVal("Heigh"));
	}	
	public void setHeigh(Integer Heigh) {
		setAttrVal("Heigh", Heigh);
	}
	public String getId_prnt_param() {
		return ((String) getAttrVal("Id_prnt_param"));
	}	
	public void setId_prnt_param(String Id_prnt_param) {
		setAttrVal("Id_prnt_param", Id_prnt_param);
	}
	public String getCode_prnt_param() {
		return ((String) getAttrVal("Code_prnt_param"));
	}	
	public void setCode_prnt_param(String Code_prnt_param) {
		setAttrVal("Code_prnt_param", Code_prnt_param);
	}
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	public String getName_orpltp() {
		return ((String) getAttrVal("Name_orpltp"));
	}	
	public void setName_orpltp(String Name_orpltp) {
		setAttrVal("Name_orpltp", Name_orpltp);
	}
	public String getName_srvtp() {
		return ((String) getAttrVal("Name_srvtp"));
	}	
	public void setName_srvtp(String Name_srvtp) {
		setAttrVal("Name_srvtp", Name_srvtp);
	}
	public String getName_mproute() {
		return ((String) getAttrVal("Name_mproute"));
	}	
	public void setName_mproute(String Name_mproute) {
		setAttrVal("Name_mproute", Name_mproute);
	}
	public String getBillformcaption() {
		return ((String) getAttrVal("Billformcaption"));
	}	
	public void setBillformcaption(String Billformcaption) {
		setAttrVal("Billformcaption", Billformcaption);
	}
	public String getName_exetp() {
		return ((String) getAttrVal("Name_exetp"));
	}	
	public void setName_exetp(String Name_exetp) {
		setAttrVal("Name_exetp", Name_exetp);
	}
	public String getName_exectp_def() {
		return ((String) getAttrVal("Name_exectp_def"));
	}	
	public void setName_exectp_def(String Name_exectp_def) {
		setAttrVal("Name_exectp_def", Name_exectp_def);
	}
	public String getCode_oper() {
		return ((String) getAttrVal("Code_oper"));
	}	
	public void setCode_oper(String Code_oper) {
		setAttrVal("Code_oper", Code_oper);
	}
	public String getParamname() {
		return ((String) getAttrVal("Paramname"));
	}	
	public void setParamname(String Paramname) {
		setAttrVal("Paramname", Paramname);
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
		return "Id_opor_cfg";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_OPOR_CFG";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpOpCfgDODesc.class);
	}
	
}