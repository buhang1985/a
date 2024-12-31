package iih.ci.mr.nu.pipeslip.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.pipeslip.d.desc.PipeSlipCritDODesc;
import java.math.BigDecimal;

/**
 * 管道滑脱因素及护理措施 DO数据 
 * 
 */
public class PipeSlipCritDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PIPE_SLIPE_CRIT= "Id_pipe_slipe_crit";
	public static final String ID_PIPE_SLIPE= "Id_pipe_slipe";
	public static final String ID_PRO_TYPE= "Id_pro_type";
	public static final String SCORE= "Score";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pipe_slipe_crit() {
		return ((String) getAttrVal("Id_pipe_slipe_crit"));
	}	
	public void setId_pipe_slipe_crit(String Id_pipe_slipe_crit) {
		setAttrVal("Id_pipe_slipe_crit", Id_pipe_slipe_crit);
	}
	public String getId_pipe_slipe() {
		return ((String) getAttrVal("Id_pipe_slipe"));
	}	
	public void setId_pipe_slipe(String Id_pipe_slipe) {
		setAttrVal("Id_pipe_slipe", Id_pipe_slipe);
	}
	public String getId_pro_type() {
		return ((String) getAttrVal("Id_pro_type"));
	}	
	public void setId_pro_type(String Id_pro_type) {
		setAttrVal("Id_pro_type", Id_pro_type);
	}
	public Integer getScore() {
		return ((Integer) getAttrVal("Score"));
	}	
	public void setScore(Integer Score) {
		setAttrVal("Score", Score);
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
		return "Id_pipe_slipe_crit";
	}
	
	@Override
	public String getTableName() {	  
		return "MR_NU_PIPESLIPCRIT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PipeSlipCritDODesc.class);
	}
	
}