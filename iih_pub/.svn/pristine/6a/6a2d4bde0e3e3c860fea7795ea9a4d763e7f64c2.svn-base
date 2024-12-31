package iih.mkr.ms.mkrms.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mkr.ms.mkrms.d.desc.MkrMsEnblEntpDODesc;
import java.math.BigDecimal;

/**
 * 组套与适用就诊类型关系 DO数据 
 * 
 */
public class MkrMsEnblEntpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MSENT= "Id_msent";
	public static final String ID_MS= "Id_ms";
	public static final String ID_ENTP= "Id_entp";
	public static final String CODE_ENTP= "Code_entp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_msent() {
		return ((String) getAttrVal("Id_msent"));
	}	
	public void setId_msent(String Id_msent) {
		setAttrVal("Id_msent", Id_msent);
	}
	public String getId_ms() {
		return ((String) getAttrVal("Id_ms"));
	}	
	public void setId_ms(String Id_ms) {
		setAttrVal("Id_ms", Id_ms);
	}
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
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
		return "Id_msent";
	}
	
	@Override
	public String getTableName() {	  
		return "MKR_MS_ENBL_ENTP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MkrMsEnblEntpDODesc.class);
	}
	
}