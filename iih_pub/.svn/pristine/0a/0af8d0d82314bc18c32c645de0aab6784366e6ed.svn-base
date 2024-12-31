package iih.mp.dg.opintf.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.dg.opintf.d.desc.OpPresStatusIntfDODesc;
import java.math.BigDecimal;

/**
 * 国药用处方获取实体 DO数据 
 * 
 */
public class OpPresStatusIntfDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_KEY= "Id_key";
	public static final String ID_DGPRESST= "Id_dgpresst";
	public static final String DISP_UUID= "Disp_uuid";
	public static final String DT_IF_DISP= "Dt_if_disp";
	public static final String OP_UUID= "Op_uuid";
	public static final String DT_IF_OP= "Dt_if_op";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_key() {
		return ((String) getAttrVal("Id_key"));
	}	
	public void setId_key(String Id_key) {
		setAttrVal("Id_key", Id_key);
	}
	public String getId_dgpresst() {
		return ((String) getAttrVal("Id_dgpresst"));
	}	
	public void setId_dgpresst(String Id_dgpresst) {
		setAttrVal("Id_dgpresst", Id_dgpresst);
	}
	public String getDisp_uuid() {
		return ((String) getAttrVal("Disp_uuid"));
	}	
	public void setDisp_uuid(String Disp_uuid) {
		setAttrVal("Disp_uuid", Disp_uuid);
	}
	public FDateTime getDt_if_disp() {
		return ((FDateTime) getAttrVal("Dt_if_disp"));
	}	
	public void setDt_if_disp(FDateTime Dt_if_disp) {
		setAttrVal("Dt_if_disp", Dt_if_disp);
	}
	public String getOp_uuid() {
		return ((String) getAttrVal("Op_uuid"));
	}	
	public void setOp_uuid(String Op_uuid) {
		setAttrVal("Op_uuid", Op_uuid);
	}
	public FDateTime getDt_if_op() {
		return ((FDateTime) getAttrVal("Dt_if_op"));
	}	
	public void setDt_if_op(FDateTime Dt_if_op) {
		setAttrVal("Dt_if_op", Dt_if_op);
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
		return "Id_key";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_dg_presst_intf";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OpPresStatusIntfDODesc.class);
	}
	
}