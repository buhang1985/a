package iih.bd.srv.basemrtplfs.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.basemrtplfs.d.desc.BaseMrTplStreamDODesc;
import java.math.BigDecimal;

/**
 * 医疗记录基础模板流数据 DO数据 
 * 
 */
public class BaseMrTplStreamDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_BASEMRTPLFS= "Id_basemrtplfs";
	public static final String FS= "Fs";
	public static final String XML= "Xml";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_BASEMRTPL= "Id_basemrtpl";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_basemrtplfs() {
		return ((String) getAttrVal("Id_basemrtplfs"));
	}	
	public void setId_basemrtplfs(String Id_basemrtplfs) {
		setAttrVal("Id_basemrtplfs", Id_basemrtplfs);
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
	public String getId_basemrtpl() {
		return ((String) getAttrVal("Id_basemrtpl"));
	}	
	public void setId_basemrtpl(String Id_basemrtpl) {
		setAttrVal("Id_basemrtpl", Id_basemrtpl);
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
		return "Id_basemrtplfs";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_base_mrtpl_fs";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BaseMrTplStreamDODesc.class);
	}
	
}