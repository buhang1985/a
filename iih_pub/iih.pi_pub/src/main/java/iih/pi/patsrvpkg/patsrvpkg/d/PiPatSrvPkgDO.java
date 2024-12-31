package iih.pi.patsrvpkg.patsrvpkg.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.patsrvpkg.patsrvpkg.d.desc.PiPatSrvPkgDODesc;
import java.math.BigDecimal;

/**
 * 患者服务包 DO数据 
 * 
 */
public class PiPatSrvPkgDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PATSRVPKG= "Id_patsrvpkg";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_SRVPKG= "Id_srvpkg";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String ID_BL= "Id_bl";
	public static final String SD_BL= "Sd_bl";
	public static final String FG_REEN= "Fg_reen";
	public static final String FG_ENTP_OP= "Fg_entp_op";
	public static final String FG_ENTP_IP= "Fg_entp_ip";
	public static final String FG_ENTP_ER= "Fg_entp_er";
	public static final String FG_USE_ER1= "Fg_use_er1";
	public static final String FG_USE_ER2= "Fg_use_er2";
	public static final String FG_ENTP_PE= "Fg_entp_pe";
	public static final String FG_ENTP_FM= "Fg_entp_fm";
	public static final String DT_SALE= "Dt_sale";
	public static final String ID_EMP_SALE= "Id_emp_sale";
	public static final String DT_B= "Dt_b";
	public static final String FG_PAY= "Fg_pay";
	public static final String FG_END= "Fg_end";
	public static final String EU_CLOSEMD= "Eu_closemd";
	public static final String DT_END= "Dt_end";
	public static final String ID_EMP_END= "Id_emp_end";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_patsrvpkg() {
		return ((String) getAttrVal("Id_patsrvpkg"));
	}	
	public void setId_patsrvpkg(String Id_patsrvpkg) {
		setAttrVal("Id_patsrvpkg", Id_patsrvpkg);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_srvpkg() {
		return ((String) getAttrVal("Id_srvpkg"));
	}	
	public void setId_srvpkg(String Id_srvpkg) {
		setAttrVal("Id_srvpkg", Id_srvpkg);
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
	public String getId_bl() {
		return ((String) getAttrVal("Id_bl"));
	}	
	public void setId_bl(String Id_bl) {
		setAttrVal("Id_bl", Id_bl);
	}
	public String getSd_bl() {
		return ((String) getAttrVal("Sd_bl"));
	}	
	public void setSd_bl(String Sd_bl) {
		setAttrVal("Sd_bl", Sd_bl);
	}
	public FBoolean getFg_reen() {
		return ((FBoolean) getAttrVal("Fg_reen"));
	}	
	public void setFg_reen(FBoolean Fg_reen) {
		setAttrVal("Fg_reen", Fg_reen);
	}
	public FBoolean getFg_entp_op() {
		return ((FBoolean) getAttrVal("Fg_entp_op"));
	}	
	public void setFg_entp_op(FBoolean Fg_entp_op) {
		setAttrVal("Fg_entp_op", Fg_entp_op);
	}
	public FBoolean getFg_entp_ip() {
		return ((FBoolean) getAttrVal("Fg_entp_ip"));
	}	
	public void setFg_entp_ip(FBoolean Fg_entp_ip) {
		setAttrVal("Fg_entp_ip", Fg_entp_ip);
	}
	public FBoolean getFg_entp_er() {
		return ((FBoolean) getAttrVal("Fg_entp_er"));
	}	
	public void setFg_entp_er(FBoolean Fg_entp_er) {
		setAttrVal("Fg_entp_er", Fg_entp_er);
	}
	public FBoolean getFg_use_er1() {
		return ((FBoolean) getAttrVal("Fg_use_er1"));
	}	
	public void setFg_use_er1(FBoolean Fg_use_er1) {
		setAttrVal("Fg_use_er1", Fg_use_er1);
	}
	public FBoolean getFg_use_er2() {
		return ((FBoolean) getAttrVal("Fg_use_er2"));
	}	
	public void setFg_use_er2(FBoolean Fg_use_er2) {
		setAttrVal("Fg_use_er2", Fg_use_er2);
	}
	public FBoolean getFg_entp_pe() {
		return ((FBoolean) getAttrVal("Fg_entp_pe"));
	}	
	public void setFg_entp_pe(FBoolean Fg_entp_pe) {
		setAttrVal("Fg_entp_pe", Fg_entp_pe);
	}
	public FBoolean getFg_entp_fm() {
		return ((FBoolean) getAttrVal("Fg_entp_fm"));
	}	
	public void setFg_entp_fm(FBoolean Fg_entp_fm) {
		setAttrVal("Fg_entp_fm", Fg_entp_fm);
	}
	public FDateTime getDt_sale() {
		return ((FDateTime) getAttrVal("Dt_sale"));
	}	
	public void setDt_sale(FDateTime Dt_sale) {
		setAttrVal("Dt_sale", Dt_sale);
	}
	public String getId_emp_sale() {
		return ((String) getAttrVal("Id_emp_sale"));
	}	
	public void setId_emp_sale(String Id_emp_sale) {
		setAttrVal("Id_emp_sale", Id_emp_sale);
	}
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}	
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	public FBoolean getFg_pay() {
		return ((FBoolean) getAttrVal("Fg_pay"));
	}	
	public void setFg_pay(FBoolean Fg_pay) {
		setAttrVal("Fg_pay", Fg_pay);
	}
	public FBoolean getFg_end() {
		return ((FBoolean) getAttrVal("Fg_end"));
	}	
	public void setFg_end(FBoolean Fg_end) {
		setAttrVal("Fg_end", Fg_end);
	}
	public Integer getEu_closemd() {
		return ((Integer) getAttrVal("Eu_closemd"));
	}	
	public void setEu_closemd(Integer Eu_closemd) {
		setAttrVal("Eu_closemd", Eu_closemd);
	}
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	public String getId_emp_end() {
		return ((String) getAttrVal("Id_emp_end"));
	}	
	public void setId_emp_end(String Id_emp_end) {
		setAttrVal("Id_emp_end", Id_emp_end);
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
		return "Id_patsrvpkg";
	}
	
	@Override
	public String getTableName() {	  
		return "pi_pat_srv_pkg";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PiPatSrvPkgDODesc.class);
	}
	
}