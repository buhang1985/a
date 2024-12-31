package iih.nm.nca.satsrvyrecord.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nca.satsrvyrecord.d.desc.NmNcaSrvyItemDODesc;
import java.math.BigDecimal;

/**
 * 满意度调查记录明细 DO数据 
 * 
 */
public class NmNcaSrvyItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NCA_SRVY_ITM= "Id_nca_srvy_itm";
	public static final String ID_NCA_SRVY= "Id_nca_srvy";
	public static final String ID_NCA_TMPL_ITM= "Id_nca_tmpl_itm";
	public static final String ID_NCA_TMPL_OPTA= "Id_nca_tmpl_opta";
	public static final String SORTNO= "Sortno";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CONTENT_NCA_TMPL_ITM= "Content_nca_tmpl_itm";
	public static final String NAME_NCA_TMPL_OPTA= "Name_nca_tmpl_opta";
	public static final String SCORE_NCA_TMPL_OPTA= "Score_nca_tmpl_opta";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nca_srvy_itm() {
		return ((String) getAttrVal("Id_nca_srvy_itm"));
	}	
	public void setId_nca_srvy_itm(String Id_nca_srvy_itm) {
		setAttrVal("Id_nca_srvy_itm", Id_nca_srvy_itm);
	}
	public String getId_nca_srvy() {
		return ((String) getAttrVal("Id_nca_srvy"));
	}	
	public void setId_nca_srvy(String Id_nca_srvy) {
		setAttrVal("Id_nca_srvy", Id_nca_srvy);
	}
	public String getId_nca_tmpl_itm() {
		return ((String) getAttrVal("Id_nca_tmpl_itm"));
	}	
	public void setId_nca_tmpl_itm(String Id_nca_tmpl_itm) {
		setAttrVal("Id_nca_tmpl_itm", Id_nca_tmpl_itm);
	}
	public String getId_nca_tmpl_opta() {
		return ((String) getAttrVal("Id_nca_tmpl_opta"));
	}	
	public void setId_nca_tmpl_opta(String Id_nca_tmpl_opta) {
		setAttrVal("Id_nca_tmpl_opta", Id_nca_tmpl_opta);
	}
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}	
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	public String getContent_nca_tmpl_itm() {
		return ((String) getAttrVal("Content_nca_tmpl_itm"));
	}	
	public void setContent_nca_tmpl_itm(String Content_nca_tmpl_itm) {
		setAttrVal("Content_nca_tmpl_itm", Content_nca_tmpl_itm);
	}
	public String getName_nca_tmpl_opta() {
		return ((String) getAttrVal("Name_nca_tmpl_opta"));
	}	
	public void setName_nca_tmpl_opta(String Name_nca_tmpl_opta) {
		setAttrVal("Name_nca_tmpl_opta", Name_nca_tmpl_opta);
	}
	public FDouble getScore_nca_tmpl_opta() {
		return ((FDouble) getAttrVal("Score_nca_tmpl_opta"));
	}	
	public void setScore_nca_tmpl_opta(FDouble Score_nca_tmpl_opta) {
		setAttrVal("Score_nca_tmpl_opta", Score_nca_tmpl_opta);
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
		return "Id_nca_srvy_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NCA_SRVY_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNcaSrvyItemDODesc.class);
	}
	
}