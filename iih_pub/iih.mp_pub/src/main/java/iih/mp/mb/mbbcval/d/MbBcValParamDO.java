package iih.mp.mb.mbbcval.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.mb.mbbcval.d.desc.MbBcValParamDODesc;
import java.math.BigDecimal;

/**
 * 条码对照参数 DO数据 
 * 
 */
public class MbBcValParamDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MB_BC_VAL_PARAM= "Id_mb_bc_val_param";
	public static final String ID_MB_BC_VAL= "Id_mb_bc_val";
	public static final String VAL_PARAM= "Val_param";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mb_bc_val_param() {
		return ((String) getAttrVal("Id_mb_bc_val_param"));
	}	
	public void setId_mb_bc_val_param(String Id_mb_bc_val_param) {
		setAttrVal("Id_mb_bc_val_param", Id_mb_bc_val_param);
	}
	public String getId_mb_bc_val() {
		return ((String) getAttrVal("Id_mb_bc_val"));
	}	
	public void setId_mb_bc_val(String Id_mb_bc_val) {
		setAttrVal("Id_mb_bc_val", Id_mb_bc_val);
	}
	public String getVal_param() {
		return ((String) getAttrVal("Val_param"));
	}	
	public void setVal_param(String Val_param) {
		setAttrVal("Val_param", Val_param);
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
		return "Id_mb_bc_val_param";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_MB_BC_VAL_PARAM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MbBcValParamDODesc.class);
	}
	
}