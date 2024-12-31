package iih.bl.st.blstaroep.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.st.blstaroep.d.desc.BlStArSegOepDODesc;
import java.math.BigDecimal;

/**
 * 医疗费用门急体结算应收付款段 DO数据 
 * 
 */
public class BlStArSegOepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_STARSEG= "Id_starseg";
	public static final String ID_STAR= "Id_star";
	public static final String ID_ST= "Id_st";
	public static final String ID_HPSEG= "Id_hpseg";
	public static final String NAME_HPSEG= "Name_hpseg";
	public static final String AMT_HPSEG= "Amt_hpseg";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_starseg() {
		return ((String) getAttrVal("Id_starseg"));
	}	
	public void setId_starseg(String Id_starseg) {
		setAttrVal("Id_starseg", Id_starseg);
	}
	
	public String getId_star() {
		return ((String) getAttrVal("Id_star"));
	}	
	public void setId_star(String Id_star) {
		setAttrVal("Id_star", Id_star);
	}
	
	public String getId_st() {
		return ((String) getAttrVal("Id_st"));
	}	
	public void setId_st(String Id_st) {
		setAttrVal("Id_st", Id_st);
	}
	
	public String getId_hpseg() {
		return ((String) getAttrVal("Id_hpseg"));
	}	
	public void setId_hpseg(String Id_hpseg) {
		setAttrVal("Id_hpseg", Id_hpseg);
	}
	
	public String getName_hpseg() {
		return ((String) getAttrVal("Name_hpseg"));
	}	
	public void setName_hpseg(String Name_hpseg) {
		setAttrVal("Name_hpseg", Name_hpseg);
	}
	
	public FDouble getAmt_hpseg() {
		return ((FDouble) getAttrVal("Amt_hpseg"));
	}	
	public void setAmt_hpseg(FDouble Amt_hpseg) {
		setAttrVal("Amt_hpseg", Amt_hpseg);
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
		return "Id_starseg";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_st_ar_seg_oep";
	}
	
	@Override
	public IDODesc getDODesc() {		
		return DescManager.getInstance().getDODesc(BlStArSegOepDODesc.class);
	}
	
}