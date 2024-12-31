package iih.bd.srv.ortpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.ortpl.d.desc.OrTplItmDtDODesc;
import java.math.BigDecimal;

/**
 * 医嘱模板项目明细 DO数据 
 * 
 */
public class OrTplItmDtDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SRVORTPLORSRV= "Id_srvortplorsrv";
	public static final String SORTNO= "Sortno";
	public static final String ID_SRVORTPLOR= "Id_srvortplor";
	public static final String ID_SRV= "Id_srv";
	public static final String ID_SRVTP= "Id_srvtp";
	public static final String SD_SRVTP= "Sd_srvtp";
	public static final String ID_MM= "Id_mm";
	public static final String ID_FREQ= "Id_freq";
	public static final String ID_ROUTE= "Id_route";
	public static final String ID_UNIT_MED= "Id_unit_med";
	public static final String QUAN_MED= "Quan_med";
	public static final String ID_BOIL= "Id_boil";
	public static final String ID_BOILDES= "Id_boildes";
	public static final String FG_CHECK= "Fg_check";
	public static final String NAME_SRV= "Name_srv";
	public static final String CODE_SRV= "Code_srv";
	public static final String CODE_SRVTPL= "Code_srvtpl";
	public static final String NAME_SRVTPL= "Name_srvtpl";
	public static final String CODE_MM= "Code_mm";
	public static final String NAME_MM= "Name_mm";
	public static final String NAME_FREQ= "Name_freq";
	public static final String CODE_FREQ= "Code_freq";
	public static final String CODE_ROUTE= "Code_route";
	public static final String NAME_ROUTE= "Name_route";
	public static final String NAME_UNIT_MED= "Name_unit_med";
	public static final String CODE_UNIT_MED= "Code_unit_med";
	public static final String NAME_BOIL= "Name_boil";
	public static final String NAME_BOILDES= "Name_boildes";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_srvortplorsrv() {
		return ((String) getAttrVal("Id_srvortplorsrv"));
	}	
	public void setId_srvortplorsrv(String Id_srvortplorsrv) {
		setAttrVal("Id_srvortplorsrv", Id_srvortplorsrv);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getId_srvortplor() {
		return ((String) getAttrVal("Id_srvortplor"));
	}	
	public void setId_srvortplor(String Id_srvortplor) {
		setAttrVal("Id_srvortplor", Id_srvortplor);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
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
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}	
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}	
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	public String getId_unit_med() {
		return ((String) getAttrVal("Id_unit_med"));
	}	
	public void setId_unit_med(String Id_unit_med) {
		setAttrVal("Id_unit_med", Id_unit_med);
	}
	public FDouble getQuan_med() {
		return ((FDouble) getAttrVal("Quan_med"));
	}	
	public void setQuan_med(FDouble Quan_med) {
		setAttrVal("Quan_med", Quan_med);
	}
	public String getId_boil() {
		return ((String) getAttrVal("Id_boil"));
	}	
	public void setId_boil(String Id_boil) {
		setAttrVal("Id_boil", Id_boil);
	}
	public String getId_boildes() {
		return ((String) getAttrVal("Id_boildes"));
	}	
	public void setId_boildes(String Id_boildes) {
		setAttrVal("Id_boildes", Id_boildes);
	}
	public FBoolean getFg_check() {
		return ((FBoolean) getAttrVal("Fg_check"));
	}	
	public void setFg_check(FBoolean Fg_check) {
		setAttrVal("Fg_check", Fg_check);
	}
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}	
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	public String getCode_srvtpl() {
		return ((String) getAttrVal("Code_srvtpl"));
	}	
	public void setCode_srvtpl(String Code_srvtpl) {
		setAttrVal("Code_srvtpl", Code_srvtpl);
	}
	public String getName_srvtpl() {
		return ((String) getAttrVal("Name_srvtpl"));
	}	
	public void setName_srvtpl(String Name_srvtpl) {
		setAttrVal("Name_srvtpl", Name_srvtpl);
	}
	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}	
	public void setCode_mm(String Code_mm) {
		setAttrVal("Code_mm", Code_mm);
	}
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}	
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	public String getName_freq() {
		return ((String) getAttrVal("Name_freq"));
	}	
	public void setName_freq(String Name_freq) {
		setAttrVal("Name_freq", Name_freq);
	}
	public String getCode_freq() {
		return ((String) getAttrVal("Code_freq"));
	}	
	public void setCode_freq(String Code_freq) {
		setAttrVal("Code_freq", Code_freq);
	}
	public String getCode_route() {
		return ((String) getAttrVal("Code_route"));
	}	
	public void setCode_route(String Code_route) {
		setAttrVal("Code_route", Code_route);
	}
	public String getName_route() {
		return ((String) getAttrVal("Name_route"));
	}	
	public void setName_route(String Name_route) {
		setAttrVal("Name_route", Name_route);
	}
	public String getName_unit_med() {
		return ((String) getAttrVal("Name_unit_med"));
	}	
	public void setName_unit_med(String Name_unit_med) {
		setAttrVal("Name_unit_med", Name_unit_med);
	}
	public String getCode_unit_med() {
		return ((String) getAttrVal("Code_unit_med"));
	}	
	public void setCode_unit_med(String Code_unit_med) {
		setAttrVal("Code_unit_med", Code_unit_med);
	}
	public String getName_boil() {
		return ((String) getAttrVal("Name_boil"));
	}	
	public void setName_boil(String Name_boil) {
		setAttrVal("Name_boil", Name_boil);
	}
	public String getName_boildes() {
		return ((String) getAttrVal("Name_boildes"));
	}	
	public void setName_boildes(String Name_boildes) {
		setAttrVal("Name_boildes", Name_boildes);
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
		return "Id_srvortplorsrv";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_ortpl_or_srv";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrTplItmDtDODesc.class);
	}
	
}