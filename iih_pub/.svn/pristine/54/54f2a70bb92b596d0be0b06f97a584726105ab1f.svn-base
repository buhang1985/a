package iih.nm.nit.nitpracfb.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nit.nitpracfb.d.desc.NitPracfbItmDODesc;
import java.math.BigDecimal;

/**
 * 实习反馈项目 DO数据 
 * 
 */
public class NitPracfbItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PRAC_FB_ITM= "Id_prac_fb_itm";
	public static final String ID_PRAC_FB= "Id_prac_fb";
	public static final String ID_PRAC_FBTMPL_ITM= "Id_prac_fbtmpl_itm";
	public static final String SD_PRAC_FBTMPL_ITM= "Sd_prac_fbtmpl_itm";
	public static final String NAME_PRAC_FBTMPL_ITM= "Name_prac_fbtmpl_itm";
	public static final String CONTENT= "Content";
	public static final String SC= "Sc";
	public static final String SCORE= "Score";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_prac_fb_itm() {
		return ((String) getAttrVal("Id_prac_fb_itm"));
	}	
	public void setId_prac_fb_itm(String Id_prac_fb_itm) {
		setAttrVal("Id_prac_fb_itm", Id_prac_fb_itm);
	}
	public String getId_prac_fb() {
		return ((String) getAttrVal("Id_prac_fb"));
	}	
	public void setId_prac_fb(String Id_prac_fb) {
		setAttrVal("Id_prac_fb", Id_prac_fb);
	}
	public String getId_prac_fbtmpl_itm() {
		return ((String) getAttrVal("Id_prac_fbtmpl_itm"));
	}	
	public void setId_prac_fbtmpl_itm(String Id_prac_fbtmpl_itm) {
		setAttrVal("Id_prac_fbtmpl_itm", Id_prac_fbtmpl_itm);
	}
	public String getSd_prac_fbtmpl_itm() {
		return ((String) getAttrVal("Sd_prac_fbtmpl_itm"));
	}	
	public void setSd_prac_fbtmpl_itm(String Sd_prac_fbtmpl_itm) {
		setAttrVal("Sd_prac_fbtmpl_itm", Sd_prac_fbtmpl_itm);
	}
	public String getName_prac_fbtmpl_itm() {
		return ((String) getAttrVal("Name_prac_fbtmpl_itm"));
	}	
	public void setName_prac_fbtmpl_itm(String Name_prac_fbtmpl_itm) {
		setAttrVal("Name_prac_fbtmpl_itm", Name_prac_fbtmpl_itm);
	}
	public String getContent() {
		return ((String) getAttrVal("Content"));
	}	
	public void setContent(String Content) {
		setAttrVal("Content", Content);
	}
	public Integer getSc() {
		return ((Integer) getAttrVal("Sc"));
	}	
	public void setSc(Integer Sc) {
		setAttrVal("Sc", Sc);
	}
	public Integer getScore() {
		return ((Integer) getAttrVal("Score"));
	}	
	public void setScore(Integer Score) {
		setAttrVal("Score", Score);
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
		return "Id_prac_fb_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NIT_PRAC_FB_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NitPracfbItmDODesc.class);
	}
	
}