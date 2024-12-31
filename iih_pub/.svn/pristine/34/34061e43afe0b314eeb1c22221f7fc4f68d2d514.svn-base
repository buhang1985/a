package iih.bd.srv.medsrvbloodquancanap.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.medsrvbloodquancanap.d.desc.MedsrvbloodquancanapDODesc;
import java.math.BigDecimal;

/**
 * 医疗服务_血液可申请血量 DO数据 
 * 
 */
public class MedsrvbloodquancanapDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SRVBLODQUANCANAP= "Id_srvblodquancanap";
	public static final String ID_SRV= "Id_srv";
	public static final String QUAN_BLOOD= "Quan_blood";
	public static final String ID_UNIT_QUAN_BLOOD= "Id_unit_quan_blood";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String SRV_NAME= "Srv_name";
	public static final String UNIT_NAME= "Unit_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_srvblodquancanap() {
		return ((String) getAttrVal("Id_srvblodquancanap"));
	}	
	public void setId_srvblodquancanap(String Id_srvblodquancanap) {
		setAttrVal("Id_srvblodquancanap", Id_srvblodquancanap);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public FDouble getQuan_blood() {
		return ((FDouble) getAttrVal("Quan_blood"));
	}	
	public void setQuan_blood(FDouble Quan_blood) {
		setAttrVal("Quan_blood", Quan_blood);
	}
	public String getId_unit_quan_blood() {
		return ((String) getAttrVal("Id_unit_quan_blood"));
	}	
	public void setId_unit_quan_blood(String Id_unit_quan_blood) {
		setAttrVal("Id_unit_quan_blood", Id_unit_quan_blood);
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
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	public String getUnit_name() {
		return ((String) getAttrVal("Unit_name"));
	}	
	public void setUnit_name(String Unit_name) {
		setAttrVal("Unit_name", Unit_name);
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
		return "Id_srvblodquancanap";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_SRV_BLOODQUAN_CANAPPLY";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MedsrvbloodquancanapDODesc.class);
	}
	
}