package iih.bd.srv.mrtplvt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.mrtplvt.d.desc.MrtplVtItmDODesc;
import java.math.BigDecimal;

/**
 * 生命体征测量项目 DO数据 
 * 
 */
public class MrtplVtItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MRTPLVTITM= "Id_mrtplvtitm";
	public static final String ID_MRTPLVT= "Id_mrtplvt";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String SORTNO= "Sortno";
	public static final String ID_SRV= "Id_srv";
	public static final String ID_FREQ= "Id_freq";
	public static final String DEF1= "Def1";
	public static final String DEF2= "Def2";
	public static final String DEF3= "Def3";
	public static final String SRV_CODE= "Srv_code";
	public static final String SRV_NAME= "Srv_name";
	public static final String FREQ_CODE= "Freq_code";
	public static final String FREQ_NAME= "Freq_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mrtplvtitm() {
		return ((String) getAttrVal("Id_mrtplvtitm"));
	}	
	public void setId_mrtplvtitm(String Id_mrtplvtitm) {
		setAttrVal("Id_mrtplvtitm", Id_mrtplvtitm);
	}
	public String getId_mrtplvt() {
		return ((String) getAttrVal("Id_mrtplvt"));
	}	
	public void setId_mrtplvt(String Id_mrtplvt) {
		setAttrVal("Id_mrtplvt", Id_mrtplvt);
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
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}	
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
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
		return "Id_mrtplvtitm";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mrtpl_vt_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MrtplVtItmDODesc.class);
	}
	
}