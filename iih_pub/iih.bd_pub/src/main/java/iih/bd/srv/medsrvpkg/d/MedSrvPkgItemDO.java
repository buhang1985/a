package iih.bd.srv.medsrvpkg.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.medsrvpkg.d.desc.MedSrvPkgItemDODesc;
import java.math.BigDecimal;

/**
 * 医疗服务包项目 DO数据 
 * 
 */
public class MedSrvPkgItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SRVPKGITM= "Id_srvpkgitm";
	public static final String ID_SRV= "Id_srv";
	public static final String SORTNO= "Sortno";
	public static final String ID_SRV_INPKG= "Id_srv_inpkg";
	public static final String ID_FREQ= "Id_freq";
	public static final String ID_ROUTE= "Id_route";
	public static final String ID_ROUTEDES= "Id_routedes";
	public static final String ID_BOIL= "Id_boil";
	public static final String ID_BOILDES= "Id_boildes";
	public static final String ID_MED= "Id_med";
	public static final String QUAN_MED= "Quan_med";
	public static final String PRICE= "Price";
	public static final String SRV_CODE= "Srv_code";
	public static final String SRV_NAME= "Srv_name";
	public static final String INPK_CODE= "Inpk_code";
	public static final String INPK_NAME= "Inpk_name";
	public static final String FREQ_CODE= "Freq_code";
	public static final String FREQ_NAME= "Freq_name";
	public static final String ROUTE_CODE= "Route_code";
	public static final String ROUTE_NAME= "Route_name";
	public static final String ROUTEDES_CODE= "Routedes_code";
	public static final String ROUTEDES_NAME= "Routedes_name";
	public static final String BOIL_CODE= "Boil_code";
	public static final String BOIL_NAME= "Boil_name";
	public static final String BOILDES_CODE= "Boildes_code";
	public static final String BOILDES_NAME= "Boildes_name";
	public static final String MED_CODE= "Med_code";
	public static final String MED_NAME= "Med_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_srvpkgitm() {
		return ((String) getAttrVal("Id_srvpkgitm"));
	}	
	public void setId_srvpkgitm(String Id_srvpkgitm) {
		setAttrVal("Id_srvpkgitm", Id_srvpkgitm);
	}
	
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	
	public String getId_srv_inpkg() {
		return ((String) getAttrVal("Id_srv_inpkg"));
	}	
	public void setId_srv_inpkg(String Id_srv_inpkg) {
		setAttrVal("Id_srv_inpkg", Id_srv_inpkg);
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
	
	public String getId_routedes() {
		return ((String) getAttrVal("Id_routedes"));
	}	
	public void setId_routedes(String Id_routedes) {
		setAttrVal("Id_routedes", Id_routedes);
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
	
	public String getId_med() {
		return ((String) getAttrVal("Id_med"));
	}	
	public void setId_med(String Id_med) {
		setAttrVal("Id_med", Id_med);
	}
	
	public FDouble getQuan_med() {
		return ((FDouble) getAttrVal("Quan_med"));
	}	
	public void setQuan_med(FDouble Quan_med) {
		setAttrVal("Quan_med", Quan_med);
	}
	
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}	
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	
	public String getSrv_code() {
		return ((String) getAttrVal("Srv_code"));
	}	
	public void setSrv_code(String Srv_code) {
		setAttrVal("Srv_code", Srv_code);
	}
	
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	
	public String getInpk_code() {
		return ((String) getAttrVal("Inpk_code"));
	}	
	public void setInpk_code(String Inpk_code) {
		setAttrVal("Inpk_code", Inpk_code);
	}
	
	public String getInpk_name() {
		return ((String) getAttrVal("Inpk_name"));
	}	
	public void setInpk_name(String Inpk_name) {
		setAttrVal("Inpk_name", Inpk_name);
	}
	
	public String getFreq_code() {
		return ((String) getAttrVal("Freq_code"));
	}	
	public void setFreq_code(String Freq_code) {
		setAttrVal("Freq_code", Freq_code);
	}
	
	public String getFreq_name() {
		return ((String) getAttrVal("Freq_name"));
	}	
	public void setFreq_name(String Freq_name) {
		setAttrVal("Freq_name", Freq_name);
	}
	
	public String getRoute_code() {
		return ((String) getAttrVal("Route_code"));
	}	
	public void setRoute_code(String Route_code) {
		setAttrVal("Route_code", Route_code);
	}
	
	public String getRoute_name() {
		return ((String) getAttrVal("Route_name"));
	}	
	public void setRoute_name(String Route_name) {
		setAttrVal("Route_name", Route_name);
	}
	
	public String getRoutedes_code() {
		return ((String) getAttrVal("Routedes_code"));
	}	
	public void setRoutedes_code(String Routedes_code) {
		setAttrVal("Routedes_code", Routedes_code);
	}
	
	public String getRoutedes_name() {
		return ((String) getAttrVal("Routedes_name"));
	}	
	public void setRoutedes_name(String Routedes_name) {
		setAttrVal("Routedes_name", Routedes_name);
	}
	
	public String getBoil_code() {
		return ((String) getAttrVal("Boil_code"));
	}	
	public void setBoil_code(String Boil_code) {
		setAttrVal("Boil_code", Boil_code);
	}
	
	public String getBoil_name() {
		return ((String) getAttrVal("Boil_name"));
	}	
	public void setBoil_name(String Boil_name) {
		setAttrVal("Boil_name", Boil_name);
	}
	
	public String getBoildes_code() {
		return ((String) getAttrVal("Boildes_code"));
	}	
	public void setBoildes_code(String Boildes_code) {
		setAttrVal("Boildes_code", Boildes_code);
	}
	
	public String getBoildes_name() {
		return ((String) getAttrVal("Boildes_name"));
	}	
	public void setBoildes_name(String Boildes_name) {
		setAttrVal("Boildes_name", Boildes_name);
	}
	
	public String getMed_code() {
		return ((String) getAttrVal("Med_code"));
	}	
	public void setMed_code(String Med_code) {
		setAttrVal("Med_code", Med_code);
	}
	
	public String getMed_name() {
		return ((String) getAttrVal("Med_name"));
	}	
	public void setMed_name(String Med_name) {
		setAttrVal("Med_name", Med_name);
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
		return "Id_srvpkgitm";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_pkg_itm";
	}
	
	@Override
	public IDODesc getDODesc() {		
		return DescManager.getInstance().getDODesc(MedSrvPkgItemDODesc.class);
	}
	
}