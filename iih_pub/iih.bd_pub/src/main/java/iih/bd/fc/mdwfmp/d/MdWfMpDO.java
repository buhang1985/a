package iih.bd.fc.mdwfmp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.fc.mdwfmp.d.desc.MdWfMpDODesc;
import java.math.BigDecimal;

/**
 * 医嘱流向执行参数 DO数据 
 * 
 */
public class MdWfMpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_WFMP= "Id_wfmp";
	public static final String ID_WF= "Id_wf";
	public static final String SD_WFMPARGU= "Sd_wfmpargu";
	public static final String ID_WFMPARGU= "Id_wfmpargu";
	public static final String VAL= "Val";
	public static final String SD_OP= "Sd_op";
	public static final String ID_OP= "Id_op";
	public static final String PARAM_CODE= "Param_code";
	public static final String PARAM_NAME= "Param_name";
	public static final String OP_CODE= "Op_code";
	public static final String OP_NAME= "Op_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_wfmp() {
		return ((String) getAttrVal("Id_wfmp"));
	}	
	public void setId_wfmp(String Id_wfmp) {
		setAttrVal("Id_wfmp", Id_wfmp);
	}
	
	public String getId_wf() {
		return ((String) getAttrVal("Id_wf"));
	}	
	public void setId_wf(String Id_wf) {
		setAttrVal("Id_wf", Id_wf);
	}
	
	public String getSd_wfmpargu() {
		return ((String) getAttrVal("Sd_wfmpargu"));
	}	
	public void setSd_wfmpargu(String Sd_wfmpargu) {
		setAttrVal("Sd_wfmpargu", Sd_wfmpargu);
	}
	
	public String getId_wfmpargu() {
		return ((String) getAttrVal("Id_wfmpargu"));
	}	
	public void setId_wfmpargu(String Id_wfmpargu) {
		setAttrVal("Id_wfmpargu", Id_wfmpargu);
	}
	
	public String getVal() {
		return ((String) getAttrVal("Val"));
	}	
	public void setVal(String Val) {
		setAttrVal("Val", Val);
	}
	
	public String getSd_op() {
		return ((String) getAttrVal("Sd_op"));
	}	
	public void setSd_op(String Sd_op) {
		setAttrVal("Sd_op", Sd_op);
	}
	
	public String getId_op() {
		return ((String) getAttrVal("Id_op"));
	}	
	public void setId_op(String Id_op) {
		setAttrVal("Id_op", Id_op);
	}
	
	public String getParam_code() {
		return ((String) getAttrVal("Param_code"));
	}	
	public void setParam_code(String Param_code) {
		setAttrVal("Param_code", Param_code);
	}
	
	public String getParam_name() {
		return ((String) getAttrVal("Param_name"));
	}	
	public void setParam_name(String Param_name) {
		setAttrVal("Param_name", Param_name);
	}
	
	public String getOp_code() {
		return ((String) getAttrVal("Op_code"));
	}	
	public void setOp_code(String Op_code) {
		setAttrVal("Op_code", Op_code);
	}
	
	public String getOp_name() {
		return ((String) getAttrVal("Op_name"));
	}	
	public void setOp_name(String Op_name) {
		setAttrVal("Op_name", Op_name);
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
		return "Id_wfmp";
	}
	
	@Override
	public String getTableName() {	  
		return "md_wf_mp";
	}
	
	@Override
	public IDODesc getDODesc() {		
		return DescManager.getInstance().getDODesc(MdWfMpDODesc.class);
	}
	
}