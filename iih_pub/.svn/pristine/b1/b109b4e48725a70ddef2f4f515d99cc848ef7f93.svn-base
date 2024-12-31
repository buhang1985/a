package iih.sc.scbd.schedulesrv.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.scbd.schedulesrv.d.desc.ScheduleSrvRelDODesc;
import java.math.BigDecimal;

/**
 * 排班资源对照 DO数据 
 * 
 */
public class ScheduleSrvRelDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SCSRVREL= "Id_scsrvrel";
	public static final String ID_SCSRV= "Id_scsrv";
	public static final String ID_MDSRV= "Id_mdsrv";
	public static final String FG_MAJ= "Fg_maj";
	public static final String SRVSLOT= "Srvslot";
	public static final String NAME_KINDITM= "Name_kinditm";
	public static final String NAME_SCSRV= "Name_scsrv";
	public static final String CODE_SCSRV= "Code_scsrv";
	public static final String CODE_MDSRV= "Code_mdsrv";
	public static final String NAME_MDSRV= "Name_mdsrv";
	public static final String SD_SRVTP= "Sd_srvtp";
	public static final String ID_SRVTP= "Id_srvtp";
	public static final String PRI_MDSRV= "Pri_mdsrv";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_scsrvrel() {
		return ((String) getAttrVal("Id_scsrvrel"));
	}	
	public void setId_scsrvrel(String Id_scsrvrel) {
		setAttrVal("Id_scsrvrel", Id_scsrvrel);
	}
	public String getId_scsrv() {
		return ((String) getAttrVal("Id_scsrv"));
	}	
	public void setId_scsrv(String Id_scsrv) {
		setAttrVal("Id_scsrv", Id_scsrv);
	}
	public String getId_mdsrv() {
		return ((String) getAttrVal("Id_mdsrv"));
	}	
	public void setId_mdsrv(String Id_mdsrv) {
		setAttrVal("Id_mdsrv", Id_mdsrv);
	}
	public FBoolean getFg_maj() {
		return ((FBoolean) getAttrVal("Fg_maj"));
	}	
	public void setFg_maj(FBoolean Fg_maj) {
		setAttrVal("Fg_maj", Fg_maj);
	}
	public Integer getSrvslot() {
		return ((Integer) getAttrVal("Srvslot"));
	}	
	public void setSrvslot(Integer Srvslot) {
		setAttrVal("Srvslot", Srvslot);
	}
	public String getName_kinditm() {
		return ((String) getAttrVal("Name_kinditm"));
	}	
	public void setName_kinditm(String Name_kinditm) {
		setAttrVal("Name_kinditm", Name_kinditm);
	}
	public String getName_scsrv() {
		return ((String) getAttrVal("Name_scsrv"));
	}	
	public void setName_scsrv(String Name_scsrv) {
		setAttrVal("Name_scsrv", Name_scsrv);
	}
	public String getCode_scsrv() {
		return ((String) getAttrVal("Code_scsrv"));
	}	
	public void setCode_scsrv(String Code_scsrv) {
		setAttrVal("Code_scsrv", Code_scsrv);
	}
	public String getCode_mdsrv() {
		return ((String) getAttrVal("Code_mdsrv"));
	}	
	public void setCode_mdsrv(String Code_mdsrv) {
		setAttrVal("Code_mdsrv", Code_mdsrv);
	}
	public String getName_mdsrv() {
		return ((String) getAttrVal("Name_mdsrv"));
	}	
	public void setName_mdsrv(String Name_mdsrv) {
		setAttrVal("Name_mdsrv", Name_mdsrv);
	}
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	public FDouble getPri_mdsrv() {
		return ((FDouble) getAttrVal("Pri_mdsrv"));
	}	
	public void setPri_mdsrv(FDouble Pri_mdsrv) {
		setAttrVal("Pri_mdsrv", Pri_mdsrv);
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
		return "Id_scsrvrel";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_srv_rel";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScheduleSrvRelDODesc.class);
	}
	
}