package iih.pe.papt.pereserve.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.papt.pereserve.d.desc.PeReserveDODesc;
import java.math.BigDecimal;

/**
 * 体检预定 DO数据 
 * 
 */
public class PeReserveDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PERESERVE= "Id_pereserve";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String DT_RESERVE= "Dt_reserve";
	public static final String DT_PERESERVE= "Dt_pereserve";
	public static final String ID_PEAPPTTLADDER= "Id_peappttladder";
	public static final String ID_SALE= "Id_sale";
	public static final String PSNS= "Psns";
	public static final String NAME_RESERVE= "Name_reserve";
	public static final String ID_PEPSNBINFO= "Id_pepsnbinfo";
	public static final String ID_PESRVSETDEF= "Id_pesrvsetdef";
	public static final String RMK= "Rmk";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_LADDER= "Code_ladder";
	public static final String NAME_LADDER= "Name_ladder";
	public static final String TIME_BEGIN= "Time_begin";
	public static final String TIME_END= "Time_end";
	public static final String CODE_SALE= "Code_sale";
	public static final String NAME_SALE= "Name_sale";
	public static final String CODE_PSN= "Code_psn";
	public static final String NAME_PSN= "Name_psn";
	public static final String CODE_SET= "Code_set";
	public static final String NAME_SET= "Name_set";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pereserve() {
		return ((String) getAttrVal("Id_pereserve"));
	}	
	public void setId_pereserve(String Id_pereserve) {
		setAttrVal("Id_pereserve", Id_pereserve);
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
	public FDate getDt_reserve() {
		return ((FDate) getAttrVal("Dt_reserve"));
	}	
	public void setDt_reserve(FDate Dt_reserve) {
		setAttrVal("Dt_reserve", Dt_reserve);
	}
	public FDate getDt_pereserve() {
		return ((FDate) getAttrVal("Dt_pereserve"));
	}	
	public void setDt_pereserve(FDate Dt_pereserve) {
		setAttrVal("Dt_pereserve", Dt_pereserve);
	}
	public String getId_peappttladder() {
		return ((String) getAttrVal("Id_peappttladder"));
	}	
	public void setId_peappttladder(String Id_peappttladder) {
		setAttrVal("Id_peappttladder", Id_peappttladder);
	}
	public String getId_sale() {
		return ((String) getAttrVal("Id_sale"));
	}	
	public void setId_sale(String Id_sale) {
		setAttrVal("Id_sale", Id_sale);
	}
	public Integer getPsns() {
		return ((Integer) getAttrVal("Psns"));
	}	
	public void setPsns(Integer Psns) {
		setAttrVal("Psns", Psns);
	}
	public String getName_reserve() {
		return ((String) getAttrVal("Name_reserve"));
	}	
	public void setName_reserve(String Name_reserve) {
		setAttrVal("Name_reserve", Name_reserve);
	}
	public String getId_pepsnbinfo() {
		return ((String) getAttrVal("Id_pepsnbinfo"));
	}	
	public void setId_pepsnbinfo(String Id_pepsnbinfo) {
		setAttrVal("Id_pepsnbinfo", Id_pepsnbinfo);
	}
	public String getId_pesrvsetdef() {
		return ((String) getAttrVal("Id_pesrvsetdef"));
	}	
	public void setId_pesrvsetdef(String Id_pesrvsetdef) {
		setAttrVal("Id_pesrvsetdef", Id_pesrvsetdef);
	}
	public String getRmk() {
		return ((String) getAttrVal("Rmk"));
	}	
	public void setRmk(String Rmk) {
		setAttrVal("Rmk", Rmk);
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
	public String getCode_ladder() {
		return ((String) getAttrVal("Code_ladder"));
	}	
	public void setCode_ladder(String Code_ladder) {
		setAttrVal("Code_ladder", Code_ladder);
	}
	public String getName_ladder() {
		return ((String) getAttrVal("Name_ladder"));
	}	
	public void setName_ladder(String Name_ladder) {
		setAttrVal("Name_ladder", Name_ladder);
	}
	public FTime getTime_begin() {
		return ((FTime) getAttrVal("Time_begin"));
	}	
	public void setTime_begin(FTime Time_begin) {
		setAttrVal("Time_begin", Time_begin);
	}
	public FTime getTime_end() {
		return ((FTime) getAttrVal("Time_end"));
	}	
	public void setTime_end(FTime Time_end) {
		setAttrVal("Time_end", Time_end);
	}
	public String getCode_sale() {
		return ((String) getAttrVal("Code_sale"));
	}	
	public void setCode_sale(String Code_sale) {
		setAttrVal("Code_sale", Code_sale);
	}
	public String getName_sale() {
		return ((String) getAttrVal("Name_sale"));
	}	
	public void setName_sale(String Name_sale) {
		setAttrVal("Name_sale", Name_sale);
	}
	public String getCode_psn() {
		return ((String) getAttrVal("Code_psn"));
	}	
	public void setCode_psn(String Code_psn) {
		setAttrVal("Code_psn", Code_psn);
	}
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}	
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
	}
	public String getCode_set() {
		return ((String) getAttrVal("Code_set"));
	}	
	public void setCode_set(String Code_set) {
		setAttrVal("Code_set", Code_set);
	}
	public String getName_set() {
		return ((String) getAttrVal("Name_set"));
	}	
	public void setName_set(String Name_set) {
		setAttrVal("Name_set", Name_set);
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
		return "Id_pereserve";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_apt_pereserve";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeReserveDODesc.class);
	}
	
}