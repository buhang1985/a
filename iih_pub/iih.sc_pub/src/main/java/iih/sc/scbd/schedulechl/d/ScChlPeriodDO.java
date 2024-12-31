package iih.sc.scbd.schedulechl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.scbd.schedulechl.d.desc.ScChlPeriodDODesc;
import java.math.BigDecimal;

/**
 * 预约渠道期间 DO数据 
 * 
 */
public class ScChlPeriodDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SCCHLPERIOD= "Id_scchlperiod";
	public static final String ID_SCCHL= "Id_scchl";
	public static final String ID_SCTP= "Id_sctp";
	public static final String SD_SCTP= "Sd_sctp";
	public static final String DAYS= "Days";
	public static final String BEGIN_TIME= "Begin_time";
	public static final String FG_HOLIDAY_EXCL= "Fg_holiday_excl";
	public static final String END_TIME_VAL= "End_time_val";
	public static final String EU_END_TIME_UNIT= "Eu_end_time_unit";
	public static final String DEF1= "Def1";
	public static final String DEF2= "Def2";
	public static final String DEF3= "Def3";
	public static final String DEF4= "Def4";
	public static final String DEF5= "Def5";
	public static final String DEF6= "Def6";
	public static final String ID_PERIOD_TP= "Id_period_tp";
	public static final String SD_PERIOD_TP= "Sd_period_tp";
	public static final String NUM_DAY= "Num_day";
	public static final String NUM_HOUR= "Num_hour";
	public static final String CODE_SCTP= "Code_sctp";
	public static final String NAME_SCTP= "Name_sctp";
	public static final String NAME_PERIOD_TP= "Name_period_tp";
	public static final String CODE_PERIOD_TP= "Code_period_tp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_scchlperiod() {
		return ((String) getAttrVal("Id_scchlperiod"));
	}	
	public void setId_scchlperiod(String Id_scchlperiod) {
		setAttrVal("Id_scchlperiod", Id_scchlperiod);
	}
	public String getId_scchl() {
		return ((String) getAttrVal("Id_scchl"));
	}	
	public void setId_scchl(String Id_scchl) {
		setAttrVal("Id_scchl", Id_scchl);
	}
	public String getId_sctp() {
		return ((String) getAttrVal("Id_sctp"));
	}	
	public void setId_sctp(String Id_sctp) {
		setAttrVal("Id_sctp", Id_sctp);
	}
	public String getSd_sctp() {
		return ((String) getAttrVal("Sd_sctp"));
	}	
	public void setSd_sctp(String Sd_sctp) {
		setAttrVal("Sd_sctp", Sd_sctp);
	}
	public Integer getDays() {
		return ((Integer) getAttrVal("Days"));
	}	
	public void setDays(Integer Days) {
		setAttrVal("Days", Days);
	}
	public Integer getBegin_time() {
		return ((Integer) getAttrVal("Begin_time"));
	}	
	public void setBegin_time(Integer Begin_time) {
		setAttrVal("Begin_time", Begin_time);
	}
	public FBoolean getFg_holiday_excl() {
		return ((FBoolean) getAttrVal("Fg_holiday_excl"));
	}	
	public void setFg_holiday_excl(FBoolean Fg_holiday_excl) {
		setAttrVal("Fg_holiday_excl", Fg_holiday_excl);
	}
	public Integer getEnd_time_val() {
		return ((Integer) getAttrVal("End_time_val"));
	}	
	public void setEnd_time_val(Integer End_time_val) {
		setAttrVal("End_time_val", End_time_val);
	}
	public Integer getEu_end_time_unit() {
		return ((Integer) getAttrVal("Eu_end_time_unit"));
	}	
	public void setEu_end_time_unit(Integer Eu_end_time_unit) {
		setAttrVal("Eu_end_time_unit", Eu_end_time_unit);
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
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}	
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	public String getId_period_tp() {
		return ((String) getAttrVal("Id_period_tp"));
	}	
	public void setId_period_tp(String Id_period_tp) {
		setAttrVal("Id_period_tp", Id_period_tp);
	}
	public String getSd_period_tp() {
		return ((String) getAttrVal("Sd_period_tp"));
	}	
	public void setSd_period_tp(String Sd_period_tp) {
		setAttrVal("Sd_period_tp", Sd_period_tp);
	}
	public Integer getNum_day() {
		return ((Integer) getAttrVal("Num_day"));
	}	
	public void setNum_day(Integer Num_day) {
		setAttrVal("Num_day", Num_day);
	}
	public Integer getNum_hour() {
		return ((Integer) getAttrVal("Num_hour"));
	}	
	public void setNum_hour(Integer Num_hour) {
		setAttrVal("Num_hour", Num_hour);
	}
	public String getCode_sctp() {
		return ((String) getAttrVal("Code_sctp"));
	}	
	public void setCode_sctp(String Code_sctp) {
		setAttrVal("Code_sctp", Code_sctp);
	}
	public String getName_sctp() {
		return ((String) getAttrVal("Name_sctp"));
	}	
	public void setName_sctp(String Name_sctp) {
		setAttrVal("Name_sctp", Name_sctp);
	}
	public String getName_period_tp() {
		return ((String) getAttrVal("Name_period_tp"));
	}	
	public void setName_period_tp(String Name_period_tp) {
		setAttrVal("Name_period_tp", Name_period_tp);
	}
	public String getCode_period_tp() {
		return ((String) getAttrVal("Code_period_tp"));
	}	
	public void setCode_period_tp(String Code_period_tp) {
		setAttrVal("Code_period_tp", Code_period_tp);
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
		return "Id_scchlperiod";
	}
	
	@Override
	public String getTableName() {	  
		return "SC_CHL_PERIOD";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScChlPeriodDODesc.class);
	}
	
}