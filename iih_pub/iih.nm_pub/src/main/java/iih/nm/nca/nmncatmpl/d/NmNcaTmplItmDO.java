package iih.nm.nca.nmncatmpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nca.nmncatmpl.d.desc.NmNcaTmplItmDODesc;
import java.math.BigDecimal;

/**
 * 满意度调查模板项目 DO数据 
 * 
 */
public class NmNcaTmplItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NCA_TMPL_ITM= "Id_nca_tmpl_itm";
	public static final String ID_NCA_TMPL= "Id_nca_tmpl";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String CONTENT= "Content";
	public static final String SORTNO= "Sortno";
	public static final String SCORE= "Score";
	public static final String DES= "Des";
	public static final String CTR1= "Ctr1";
	public static final String CTR2= "Ctr2";
	public static final String CTR3= "Ctr3";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nca_tmpl_itm() {
		return ((String) getAttrVal("Id_nca_tmpl_itm"));
	}	
	public void setId_nca_tmpl_itm(String Id_nca_tmpl_itm) {
		setAttrVal("Id_nca_tmpl_itm", Id_nca_tmpl_itm);
	}
	public String getId_nca_tmpl() {
		return ((String) getAttrVal("Id_nca_tmpl"));
	}	
	public void setId_nca_tmpl(String Id_nca_tmpl) {
		setAttrVal("Id_nca_tmpl", Id_nca_tmpl);
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
	public String getContent() {
		return ((String) getAttrVal("Content"));
	}	
	public void setContent(String Content) {
		setAttrVal("Content", Content);
	}
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}	
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public FDouble getScore() {
		return ((FDouble) getAttrVal("Score"));
	}	
	public void setScore(FDouble Score) {
		setAttrVal("Score", Score);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getCtr1() {
		return ((String) getAttrVal("Ctr1"));
	}	
	public void setCtr1(String Ctr1) {
		setAttrVal("Ctr1", Ctr1);
	}
	public String getCtr2() {
		return ((String) getAttrVal("Ctr2"));
	}	
	public void setCtr2(String Ctr2) {
		setAttrVal("Ctr2", Ctr2);
	}
	public String getCtr3() {
		return ((String) getAttrVal("Ctr3"));
	}	
	public void setCtr3(String Ctr3) {
		setAttrVal("Ctr3", Ctr3);
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
		return "Id_nca_tmpl_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NCA_TMPL_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNcaTmplItmDODesc.class);
	}
	
}