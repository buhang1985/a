package iih.mp.dg.mpdgshetpprntmpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.dg.mpdgshetpprntmpl.d.desc.MpdgShetpPrntmplIitmDODesc;
import java.math.BigDecimal;

/**
 * 药单打印模板关联类型 DO数据 
 * 
 */
public class MpdgShetpPrntmplIitmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SHETP_PRN_ITM= "Id_shetp_prn_itm";
	public static final String ID_DGSHETP_PRNTMPL= "Id_dgshetp_prntmpl";
	public static final String EU_OFREFTP= "Eu_ofreftp";
	public static final String ID_DGSHETP= "Id_dgshetp";
	public static final String FG_AUTOPRINT= "Fg_autoprint";
	public static final String DG_NAME= "Dg_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_shetp_prn_itm() {
		return ((String) getAttrVal("Id_shetp_prn_itm"));
	}	
	public void setId_shetp_prn_itm(String Id_shetp_prn_itm) {
		setAttrVal("Id_shetp_prn_itm", Id_shetp_prn_itm);
	}
	public String getId_dgshetp_prntmpl() {
		return ((String) getAttrVal("Id_dgshetp_prntmpl"));
	}	
	public void setId_dgshetp_prntmpl(String Id_dgshetp_prntmpl) {
		setAttrVal("Id_dgshetp_prntmpl", Id_dgshetp_prntmpl);
	}
	public Integer getEu_ofreftp() {
		return ((Integer) getAttrVal("Eu_ofreftp"));
	}	
	public void setEu_ofreftp(Integer Eu_ofreftp) {
		setAttrVal("Eu_ofreftp", Eu_ofreftp);
	}
	public String getId_dgshetp() {
		return ((String) getAttrVal("Id_dgshetp"));
	}	
	public void setId_dgshetp(String Id_dgshetp) {
		setAttrVal("Id_dgshetp", Id_dgshetp);
	}
	public FBoolean getFg_autoprint() {
		return ((FBoolean) getAttrVal("Fg_autoprint"));
	}	
	public void setFg_autoprint(FBoolean Fg_autoprint) {
		setAttrVal("Fg_autoprint", Fg_autoprint);
	}
	public String getDg_name() {
		return ((String) getAttrVal("Dg_name"));
	}	
	public void setDg_name(String Dg_name) {
		setAttrVal("Dg_name", Dg_name);
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
		return "Id_shetp_prn_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_dg_shetp_prntmpl_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpdgShetpPrntmplIitmDODesc.class);
	}
	
}