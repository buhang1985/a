package iih.bd.srv.diagcatectm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.diagcatectm.d.desc.DiCaCtmItmRelDODesc;
import java.math.BigDecimal;

/**
 * 疾病诊断自定义分类项目关系 DO数据 
 * 
 */
public class DiCaCtmItmRelDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DICACTMITMREL= "Id_dicactmitmrel";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_DICACTMITM= "Id_dicactmitm";
	public static final String EU_DICATP= "Eu_dicatp";
	public static final String ID_DI= "Id_di";
	public static final String ID_DICA= "Id_dica";
	public static final String EU_DIRECT= "Eu_direct";
	public static final String DI_NAME= "Di_name";
	public static final String DI_CODE= "Di_code";
	public static final String DICA_NAME= "Dica_name";
	public static final String DICA_CODE= "Dica_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_dicactmitmrel() {
		return ((String) getAttrVal("Id_dicactmitmrel"));
	}	
	public void setId_dicactmitmrel(String Id_dicactmitmrel) {
		setAttrVal("Id_dicactmitmrel", Id_dicactmitmrel);
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
	public String getId_dicactmitm() {
		return ((String) getAttrVal("Id_dicactmitm"));
	}	
	public void setId_dicactmitm(String Id_dicactmitm) {
		setAttrVal("Id_dicactmitm", Id_dicactmitm);
	}
	public String getEu_dicatp() {
		return ((String) getAttrVal("Eu_dicatp"));
	}	
	public void setEu_dicatp(String Eu_dicatp) {
		setAttrVal("Eu_dicatp", Eu_dicatp);
	}
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}	
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	public String getId_dica() {
		return ((String) getAttrVal("Id_dica"));
	}	
	public void setId_dica(String Id_dica) {
		setAttrVal("Id_dica", Id_dica);
	}
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}	
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	public String getDi_name() {
		return ((String) getAttrVal("Di_name"));
	}	
	public void setDi_name(String Di_name) {
		setAttrVal("Di_name", Di_name);
	}
	public String getDi_code() {
		return ((String) getAttrVal("Di_code"));
	}	
	public void setDi_code(String Di_code) {
		setAttrVal("Di_code", Di_code);
	}
	public String getDica_name() {
		return ((String) getAttrVal("Dica_name"));
	}	
	public void setDica_name(String Dica_name) {
		setAttrVal("Dica_name", Dica_name);
	}
	public String getDica_code() {
		return ((String) getAttrVal("Dica_code"));
	}	
	public void setDica_code(String Dica_code) {
		setAttrVal("Dica_code", Dica_code);
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
		return "Id_dicactmitmrel";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_dica_ctm_itm_rel";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DiCaCtmItmRelDODesc.class);
	}
	
}