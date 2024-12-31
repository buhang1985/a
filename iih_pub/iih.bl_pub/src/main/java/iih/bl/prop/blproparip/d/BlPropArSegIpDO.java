package iih.bl.prop.blproparip.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.prop.blproparip.d.desc.BlPropArSegIpDODesc;
import java.math.BigDecimal;

/**
 * 应收付款段_住院 DO数据 
 * 
 */
public class BlPropArSegIpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PROPARSEGIP= "Id_proparsegip";
	public static final String ID_PROPARIP= "Id_proparip";
	public static final String ID_PROP= "Id_prop";
	public static final String ID_HPSEG= "Id_hpseg";
	public static final String NAME_HPSEG= "Name_hpseg";
	public static final String AMT_HPSEG= "Amt_hpseg";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_proparsegip() {
		return ((String) getAttrVal("Id_proparsegip"));
	}	
	public void setId_proparsegip(String Id_proparsegip) {
		setAttrVal("Id_proparsegip", Id_proparsegip);
	}
	public String getId_proparip() {
		return ((String) getAttrVal("Id_proparip"));
	}	
	public void setId_proparip(String Id_proparip) {
		setAttrVal("Id_proparip", Id_proparip);
	}
	public String getId_prop() {
		return ((String) getAttrVal("Id_prop"));
	}	
	public void setId_prop(String Id_prop) {
		setAttrVal("Id_prop", Id_prop);
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
		return "Id_proparsegip";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_prop_ar_seg_ip";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlPropArSegIpDODesc.class);
	}
	
}