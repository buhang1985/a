package iih.bd.srv.emrimg.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.emrimg.d.desc.EmrImgAliasDODesc;
import java.math.BigDecimal;

/**
 * 医疗记录图片别名集 DO数据 
 * 
 */
public class EmrImgAliasDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_IMAGEALS= "Id_imageals";
	public static final String ID_IMAGE= "Id_image";
	public static final String ALIAS= "Alias";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_imageals() {
		return ((String) getAttrVal("Id_imageals"));
	}	
	public void setId_imageals(String Id_imageals) {
		setAttrVal("Id_imageals", Id_imageals);
	}
	public String getId_image() {
		return ((String) getAttrVal("Id_image"));
	}	
	public void setId_image(String Id_image) {
		setAttrVal("Id_image", Id_image);
	}
	public String getAlias() {
		return ((String) getAttrVal("Alias"));
	}	
	public void setAlias(String Alias) {
		setAttrVal("Alias", Alias);
	}
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
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
		return "Id_imageals";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_image_als";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmrImgAliasDODesc.class);
	}
	
}