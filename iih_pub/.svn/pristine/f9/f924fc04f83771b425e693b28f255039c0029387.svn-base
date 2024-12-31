package iih.bd.fc.wf.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.fc.wf.d.desc.WfSrvtpDODesc;
import java.math.BigDecimal;

/**
 * 流程配置_服务类型 DO数据 
 * 
 */
public class WfSrvtpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_WFSRVTP= "Id_wfsrvtp";
	public static final String ID_WF= "Id_wf";
	public static final String ID_SRVTP= "Id_srvtp";
	public static final String SD_SRVTP= "Sd_srvtp";
	public static final String NAME= "Name";
	public static final String INNERCODE= "Innercode";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_wfsrvtp() {
		return ((String) getAttrVal("Id_wfsrvtp"));
	}	
	public void setId_wfsrvtp(String Id_wfsrvtp) {
		setAttrVal("Id_wfsrvtp", Id_wfsrvtp);
	}
	public String getId_wf() {
		return ((String) getAttrVal("Id_wf"));
	}	
	public void setId_wf(String Id_wf) {
		setAttrVal("Id_wf", Id_wf);
	}
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getInnercode() {
		return ((String) getAttrVal("Innercode"));
	}	
	public void setInnercode(String Innercode) {
		setAttrVal("Innercode", Innercode);
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
		return "Id_wfsrvtp";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_WF_SRVTP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(WfSrvtpDODesc.class);
	}
	
}