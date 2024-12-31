package iih.mkr.ms.mscacust.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mkr.ms.mscacust.d.desc.MkrMscaCtmMsDODesc;
import java.math.BigDecimal;

/**
 * 组套自定义分类与组套定义关系 DO数据 
 * 
 */
public class MkrMscaCtmMsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CACTM_MS= "Id_cactm_ms";
	public static final String ID_CACTM= "Id_cactm";
	public static final String ID_MS= "Id_ms";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_cactm_ms() {
		return ((String) getAttrVal("Id_cactm_ms"));
	}	
	public void setId_cactm_ms(String Id_cactm_ms) {
		setAttrVal("Id_cactm_ms", Id_cactm_ms);
	}
	public String getId_cactm() {
		return ((String) getAttrVal("Id_cactm"));
	}	
	public void setId_cactm(String Id_cactm) {
		setAttrVal("Id_cactm", Id_cactm);
	}
	public String getId_ms() {
		return ((String) getAttrVal("Id_ms"));
	}	
	public void setId_ms(String Id_ms) {
		setAttrVal("Id_ms", Id_ms);
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
		return "Id_cactm_ms";
	}
	
	@Override
	public String getTableName() {	  
		return "MKR_MSCACTM_MS";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MkrMscaCtmMsDODesc.class);
	}
	
}