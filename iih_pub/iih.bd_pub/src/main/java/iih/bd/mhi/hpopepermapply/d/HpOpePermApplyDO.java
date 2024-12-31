package iih.bd.mhi.hpopepermapply.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.mhi.hpopepermapply.d.desc.HpOpePermApplyDODesc;
import java.math.BigDecimal;

/**
 * 操作员 DO数据 
 * 
 */
public class HpOpePermApplyDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HPOPER= "Id_hpoper";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_HP= "Id_hp";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String PWD= "Pwd";
	public static final String DMICODE= "Dmicode";
	public static final String SRVORGTP= "Srvorgtp";
	public static final String MEDORGCA= "Medorgca";
	public static final String LV_CHARGE= "Lv_charge";
	public static final String LV_HOSPITAL= "Lv_hospital";
	public static final String SRVORG_NAME= "Srvorg_name";
	public static final String GROUP_CODE= "Group_code";
	public static final String GROUP_NAME= "Group_name";
	public static final String USERNAME= "Username";
	public static final String DEPTCODE= "Deptcode";
	public static final String USE_TIME= "Use_time";
	public static final String STAMPNUM= "Stampnum";
	public static final String NOW_INVOICE_NUM= "Now_invoice_num";
	public static final String MAX_INVOICE_NUM= "Max_invoice_num";
	public static final String LAST_SETTLEMENT= "Last_settlement";
	public static final String FG_MODIFITYPWD= "Fg_modifitypwd";
	public static final String FG_OPCHARGE= "Fg_opcharge";
	public static final String FG_OSUM= "Fg_osum";
	public static final String FG_ODCHARGE= "Fg_odcharge";
	public static final String FG_OHZCHARGE= "Fg_ohzcharge";
	public static final String FG_OFREFERRAL= "Fg_ofreferral";
	public static final String FG_HBCONTROL= "Fg_hbcontrol";
	public static final String FG_OSHOSPITAL= "Fg_oshospital";
	public static final String OSTATE= "Ostate";
	public static final String DT_BEGIN= "Dt_begin";
	public static final String DT_END= "Dt_end";
	public static final String DES= "Des";
	public static final String OPER_NAME= "Oper_name";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String HP_CODE= "Hp_code";
	public static final String HP_NAME= "Hp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_hpoper() {
		return ((String) getAttrVal("Id_hpoper"));
	}	
	public void setId_hpoper(String Id_hpoper) {
		setAttrVal("Id_hpoper", Id_hpoper);
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
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
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
	public String getPwd() {
		return ((String) getAttrVal("Pwd"));
	}	
	public void setPwd(String Pwd) {
		setAttrVal("Pwd", Pwd);
	}
	public String getDmicode() {
		return ((String) getAttrVal("Dmicode"));
	}	
	public void setDmicode(String Dmicode) {
		setAttrVal("Dmicode", Dmicode);
	}
	public Integer getSrvorgtp() {
		return ((Integer) getAttrVal("Srvorgtp"));
	}	
	public void setSrvorgtp(Integer Srvorgtp) {
		setAttrVal("Srvorgtp", Srvorgtp);
	}
	public Integer getMedorgca() {
		return ((Integer) getAttrVal("Medorgca"));
	}	
	public void setMedorgca(Integer Medorgca) {
		setAttrVal("Medorgca", Medorgca);
	}
	public Integer getLv_charge() {
		return ((Integer) getAttrVal("Lv_charge"));
	}	
	public void setLv_charge(Integer Lv_charge) {
		setAttrVal("Lv_charge", Lv_charge);
	}
	public Integer getLv_hospital() {
		return ((Integer) getAttrVal("Lv_hospital"));
	}	
	public void setLv_hospital(Integer Lv_hospital) {
		setAttrVal("Lv_hospital", Lv_hospital);
	}
	public String getSrvorg_name() {
		return ((String) getAttrVal("Srvorg_name"));
	}	
	public void setSrvorg_name(String Srvorg_name) {
		setAttrVal("Srvorg_name", Srvorg_name);
	}
	public String getGroup_code() {
		return ((String) getAttrVal("Group_code"));
	}	
	public void setGroup_code(String Group_code) {
		setAttrVal("Group_code", Group_code);
	}
	public String getGroup_name() {
		return ((String) getAttrVal("Group_name"));
	}	
	public void setGroup_name(String Group_name) {
		setAttrVal("Group_name", Group_name);
	}
	public String getUsername() {
		return ((String) getAttrVal("Username"));
	}	
	public void setUsername(String Username) {
		setAttrVal("Username", Username);
	}
	public String getDeptcode() {
		return ((String) getAttrVal("Deptcode"));
	}	
	public void setDeptcode(String Deptcode) {
		setAttrVal("Deptcode", Deptcode);
	}
	public FDateTime getUse_time() {
		return ((FDateTime) getAttrVal("Use_time"));
	}	
	public void setUse_time(FDateTime Use_time) {
		setAttrVal("Use_time", Use_time);
	}
	public String getStampnum() {
		return ((String) getAttrVal("Stampnum"));
	}	
	public void setStampnum(String Stampnum) {
		setAttrVal("Stampnum", Stampnum);
	}
	public String getNow_invoice_num() {
		return ((String) getAttrVal("Now_invoice_num"));
	}	
	public void setNow_invoice_num(String Now_invoice_num) {
		setAttrVal("Now_invoice_num", Now_invoice_num);
	}
	public String getMax_invoice_num() {
		return ((String) getAttrVal("Max_invoice_num"));
	}	
	public void setMax_invoice_num(String Max_invoice_num) {
		setAttrVal("Max_invoice_num", Max_invoice_num);
	}
	public String getLast_settlement() {
		return ((String) getAttrVal("Last_settlement"));
	}	
	public void setLast_settlement(String Last_settlement) {
		setAttrVal("Last_settlement", Last_settlement);
	}
	public FBoolean getFg_modifitypwd() {
		return ((FBoolean) getAttrVal("Fg_modifitypwd"));
	}	
	public void setFg_modifitypwd(FBoolean Fg_modifitypwd) {
		setAttrVal("Fg_modifitypwd", Fg_modifitypwd);
	}
	public FBoolean getFg_opcharge() {
		return ((FBoolean) getAttrVal("Fg_opcharge"));
	}	
	public void setFg_opcharge(FBoolean Fg_opcharge) {
		setAttrVal("Fg_opcharge", Fg_opcharge);
	}
	public FBoolean getFg_osum() {
		return ((FBoolean) getAttrVal("Fg_osum"));
	}	
	public void setFg_osum(FBoolean Fg_osum) {
		setAttrVal("Fg_osum", Fg_osum);
	}
	public FBoolean getFg_odcharge() {
		return ((FBoolean) getAttrVal("Fg_odcharge"));
	}	
	public void setFg_odcharge(FBoolean Fg_odcharge) {
		setAttrVal("Fg_odcharge", Fg_odcharge);
	}
	public FBoolean getFg_ohzcharge() {
		return ((FBoolean) getAttrVal("Fg_ohzcharge"));
	}	
	public void setFg_ohzcharge(FBoolean Fg_ohzcharge) {
		setAttrVal("Fg_ohzcharge", Fg_ohzcharge);
	}
	public FBoolean getFg_ofreferral() {
		return ((FBoolean) getAttrVal("Fg_ofreferral"));
	}	
	public void setFg_ofreferral(FBoolean Fg_ofreferral) {
		setAttrVal("Fg_ofreferral", Fg_ofreferral);
	}
	public FBoolean getFg_hbcontrol() {
		return ((FBoolean) getAttrVal("Fg_hbcontrol"));
	}	
	public void setFg_hbcontrol(FBoolean Fg_hbcontrol) {
		setAttrVal("Fg_hbcontrol", Fg_hbcontrol);
	}
	public FBoolean getFg_oshospital() {
		return ((FBoolean) getAttrVal("Fg_oshospital"));
	}	
	public void setFg_oshospital(FBoolean Fg_oshospital) {
		setAttrVal("Fg_oshospital", Fg_oshospital);
	}
	public Integer getOstate() {
		return ((Integer) getAttrVal("Ostate"));
	}	
	public void setOstate(Integer Ostate) {
		setAttrVal("Ostate", Ostate);
	}
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}	
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getOper_name() {
		return ((String) getAttrVal("Oper_name"));
	}	
	public void setOper_name(String Oper_name) {
		setAttrVal("Oper_name", Oper_name);
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
	public String getHp_code() {
		return ((String) getAttrVal("Hp_code"));
	}	
	public void setHp_code(String Hp_code) {
		setAttrVal("Hp_code", Hp_code);
	}
	public String getHp_name() {
		return ((String) getAttrVal("Hp_name"));
	}	
	public void setHp_name(String Hp_name) {
		setAttrVal("Hp_name", Hp_name);
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
		return "Id_hpoper";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_MHI_OPER";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpOpePermApplyDODesc.class);
	}
	
}