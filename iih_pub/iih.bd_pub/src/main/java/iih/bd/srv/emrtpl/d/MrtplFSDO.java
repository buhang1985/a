package iih.bd.srv.emrtpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.emrtpl.d.desc.MrtplFSDODesc;
import java.math.BigDecimal;

/**
 * 基础数据_医疗服务 DO数据 
 * 
 */
public class MrtplFSDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MRTPLFS= "Id_mrtplfs";
	public static final String FS= "Fs";
	public static final String XML= "Xml";
	public static final String ID_MRTPL= "Id_mrtpl";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mrtplfs() {
		return ((String) getAttrVal("Id_mrtplfs"));
	}	
	public void setId_mrtplfs(String Id_mrtplfs) {
		setAttrVal("Id_mrtplfs", Id_mrtplfs);
	}
	
	public String getFs() {
		return ((String) getAttrVal("Fs"));
	}	
	public void setFs(String Fs) {
		setAttrVal("Fs", Fs);
	}
	
	public String getXml() {
		return ((String) getAttrVal("Xml"));
	}	
	public void setXml(String Xml) {
		setAttrVal("Xml", Xml);
	}
	
	public String getId_mrtpl() {
		return ((String) getAttrVal("Id_mrtpl"));
	}	
	public void setId_mrtpl(String Id_mrtpl) {
		setAttrVal("Id_mrtpl", Id_mrtpl);
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
		return "Id_mrtplfs";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_MRTPL_FS";
	}
	
	@Override
	public IDODesc getDODesc() {		
		return DescManager.getInstance().getDODesc(MrtplFSDODesc.class);
	}
	
}