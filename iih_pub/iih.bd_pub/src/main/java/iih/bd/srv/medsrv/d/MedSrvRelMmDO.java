package iih.bd.srv.medsrv.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.medsrv.d.desc.MedSrvRelMmDODesc;
import java.math.BigDecimal;

/**
 * 医疗服务与物品关系 DO数据 
 * 
 */
public class MedSrvRelMmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SRVRELMM= "Id_srvrelmm";
	public static final String ID_SRV= "Id_srv";
	public static final String SORTNO= "Sortno";
	public static final String ID_OWTP= "Id_owtp";
	public static final String SD_OWTP= "Sd_owtp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_DEP= "Id_dep";
	public static final String ID_MM= "Id_mm";
	public static final String SRV_NAME= "Srv_name";
	public static final String OWTP_CODE= "Owtp_code";
	public static final String OWTP_NAME= "Owtp_name";
	public static final String DEPT_NAME= "Dept_name";
	public static final String MM_NAME= "Mm_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_srvrelmm() {
		return ((String) getAttrVal("Id_srvrelmm"));
	}	
	public void setId_srvrelmm(String Id_srvrelmm) {
		setAttrVal("Id_srvrelmm", Id_srvrelmm);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getId_owtp() {
		return ((String) getAttrVal("Id_owtp"));
	}	
	public void setId_owtp(String Id_owtp) {
		setAttrVal("Id_owtp", Id_owtp);
	}
	public String getSd_owtp() {
		return ((String) getAttrVal("Sd_owtp"));
	}	
	public void setSd_owtp(String Sd_owtp) {
		setAttrVal("Sd_owtp", Sd_owtp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	public String getOwtp_code() {
		return ((String) getAttrVal("Owtp_code"));
	}	
	public void setOwtp_code(String Owtp_code) {
		setAttrVal("Owtp_code", Owtp_code);
	}
	public String getOwtp_name() {
		return ((String) getAttrVal("Owtp_name"));
	}	
	public void setOwtp_name(String Owtp_name) {
		setAttrVal("Owtp_name", Owtp_name);
	}
	public String getDept_name() {
		return ((String) getAttrVal("Dept_name"));
	}	
	public void setDept_name(String Dept_name) {
		setAttrVal("Dept_name", Dept_name);
	}
	public String getMm_name() {
		return ((String) getAttrVal("Mm_name"));
	}	
	public void setMm_name(String Mm_name) {
		setAttrVal("Mm_name", Mm_name);
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
		return "Id_srvrelmm";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_rel_mm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MedSrvRelMmDODesc.class);
	}
	
}