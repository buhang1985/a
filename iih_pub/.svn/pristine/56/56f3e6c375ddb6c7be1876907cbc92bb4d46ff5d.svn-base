package iih.mp.mpbd.docmemo.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.mpbd.docmemo.d.desc.DocMemoFileDODesc;
import java.math.BigDecimal;

/**
 * 备忘录文件 DO数据 
 * 
 */
public class DocMemoFileDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MEFI= "Id_mefi";
	public static final String ID_MEMO= "Id_memo";
	public static final String CONTENTTYPE= "Contenttype";
	public static final String FILENAME= "Filename";
	public static final String DT_ACT= "Dt_act";
	public static final String FILEEXTNAME= "Fileextname";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mefi() {
		return ((String) getAttrVal("Id_mefi"));
	}	
	public void setId_mefi(String Id_mefi) {
		setAttrVal("Id_mefi", Id_mefi);
	}
	public String getId_memo() {
		return ((String) getAttrVal("Id_memo"));
	}	
	public void setId_memo(String Id_memo) {
		setAttrVal("Id_memo", Id_memo);
	}
	public String getContenttype() {
		return ((String) getAttrVal("Contenttype"));
	}	
	public void setContenttype(String Contenttype) {
		setAttrVal("Contenttype", Contenttype);
	}
	public String getFilename() {
		return ((String) getAttrVal("Filename"));
	}	
	public void setFilename(String Filename) {
		setAttrVal("Filename", Filename);
	}
	public FDateTime getDt_act() {
		return ((FDateTime) getAttrVal("Dt_act"));
	}	
	public void setDt_act(FDateTime Dt_act) {
		setAttrVal("Dt_act", Dt_act);
	}
	public String getFileextname() {
		return ((String) getAttrVal("Fileextname"));
	}	
	public void setFileextname(String Fileextname) {
		setAttrVal("Fileextname", Fileextname);
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
		return "Id_mefi";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_mb_dcfi";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DocMemoFileDODesc.class);
	}
	
}