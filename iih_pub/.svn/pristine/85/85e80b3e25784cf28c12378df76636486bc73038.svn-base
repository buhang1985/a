package iih.bd.srv.medsrv.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.medsrv.d.desc.MedSrvRelMrDODesc;
import java.math.BigDecimal;

/**
 * 医疗服务与医疗记录关系 DO数据 
 * 
 */
public class MedSrvRelMrDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SRVRELMR= "Id_srvrelmr";
	public static final String ID_SRV= "Id_srv";
	public static final String ID_DI= "Id_di";
	public static final String ID_MRTP= "Id_mrtp";
	public static final String ID_MRTPL= "Id_mrtpl";
	public static final String ID_SRVRELCD= "Id_srvrelcd";
	public static final String SD_SRVRELCD= "Sd_srvrelcd";
	public static final String SRV_NAME= "Srv_name";
	public static final String DI_NAME= "Di_name";
	public static final String MRTP_NAME= "Mrtp_name";
	public static final String MRTPL_NAME= "Mrtpl_name";
	public static final String SRE_CODE= "Sre_code";
	public static final String SRE_NAME= "Sre_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_srvrelmr() {
		return ((String) getAttrVal("Id_srvrelmr"));
	}	
	public void setId_srvrelmr(String Id_srvrelmr) {
		setAttrVal("Id_srvrelmr", Id_srvrelmr);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}	
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	public String getId_mrtp() {
		return ((String) getAttrVal("Id_mrtp"));
	}	
	public void setId_mrtp(String Id_mrtp) {
		setAttrVal("Id_mrtp", Id_mrtp);
	}
	public String getId_mrtpl() {
		return ((String) getAttrVal("Id_mrtpl"));
	}	
	public void setId_mrtpl(String Id_mrtpl) {
		setAttrVal("Id_mrtpl", Id_mrtpl);
	}
	public String getId_srvrelcd() {
		return ((String) getAttrVal("Id_srvrelcd"));
	}	
	public void setId_srvrelcd(String Id_srvrelcd) {
		setAttrVal("Id_srvrelcd", Id_srvrelcd);
	}
	public String getSd_srvrelcd() {
		return ((String) getAttrVal("Sd_srvrelcd"));
	}	
	public void setSd_srvrelcd(String Sd_srvrelcd) {
		setAttrVal("Sd_srvrelcd", Sd_srvrelcd);
	}
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	public String getDi_name() {
		return ((String) getAttrVal("Di_name"));
	}	
	public void setDi_name(String Di_name) {
		setAttrVal("Di_name", Di_name);
	}
	public String getMrtp_name() {
		return ((String) getAttrVal("Mrtp_name"));
	}	
	public void setMrtp_name(String Mrtp_name) {
		setAttrVal("Mrtp_name", Mrtp_name);
	}
	public String getMrtpl_name() {
		return ((String) getAttrVal("Mrtpl_name"));
	}	
	public void setMrtpl_name(String Mrtpl_name) {
		setAttrVal("Mrtpl_name", Mrtpl_name);
	}
	public String getSre_code() {
		return ((String) getAttrVal("Sre_code"));
	}	
	public void setSre_code(String Sre_code) {
		setAttrVal("Sre_code", Sre_code);
	}
	public String getSre_name() {
		return ((String) getAttrVal("Sre_name"));
	}	
	public void setSre_name(String Sre_name) {
		setAttrVal("Sre_name", Sre_name);
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
		return "Id_srvrelmr";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_rel_mr";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MedSrvRelMrDODesc.class);
	}
	
}