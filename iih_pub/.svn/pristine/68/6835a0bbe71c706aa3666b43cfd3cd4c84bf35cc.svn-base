package iih.bd.srv.mrtplsec.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.mrtplsec.d.desc.MrTplSegFsDODesc;
import java.math.BigDecimal;

/**
 * 医疗记录模板片段流数据 DO数据 
 * 
 */
public class MrTplSegFsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MRTPLSECFS= "Id_mrtplsecfs";
	public static final String ID_MRTPLSEC= "Id_mrtplsec";
	public static final String FS= "Fs";
	public static final String XML= "Xml";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mrtplsecfs() {
		return ((String) getAttrVal("Id_mrtplsecfs"));
	}	
	public void setId_mrtplsecfs(String Id_mrtplsecfs) {
		setAttrVal("Id_mrtplsecfs", Id_mrtplsecfs);
	}
	public String getId_mrtplsec() {
		return ((String) getAttrVal("Id_mrtplsec"));
	}	
	public void setId_mrtplsec(String Id_mrtplsec) {
		setAttrVal("Id_mrtplsec", Id_mrtplsec);
	}
	public byte[] getFs() {
		return ((byte[]) getAttrVal("Fs"));
	}	
	public void setFs(byte[] Fs) {
		setAttrVal("Fs", Fs);
	}
	public byte[] getXml() {
		return ((byte[]) getAttrVal("Xml"));
	}	
	public void setXml(byte[] Xml) {
		setAttrVal("Xml", Xml);
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
		return "Id_mrtplsecfs";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mrtpl_sec_fs";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MrTplSegFsDODesc.class);
	}
	
}