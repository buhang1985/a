package iih.en.pv.inpatient.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.inpatient.d.desc.EmgStayDODesc;
import java.math.BigDecimal;

/**
 * 出留观 DO数据 
 * 
 */
public class EmgStayDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_EMGSTAY= "Id_emgstay";
	public static final String ID_ENT= "Id_ent";
	public static final String EU_OUT_WAY= "Eu_out_way";
	public static final String OUT_SENSE= "Out_sense";
	public static final String SD_GOWHERE= "Sd_gowhere";
	public static final String DT_LEAVE= "Dt_leave";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_emgstay() {
		return ((String) getAttrVal("Id_emgstay"));
	}	
	public void setId_emgstay(String Id_emgstay) {
		setAttrVal("Id_emgstay", Id_emgstay);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getEu_out_way() {
		return ((String) getAttrVal("Eu_out_way"));
	}	
	public void setEu_out_way(String Eu_out_way) {
		setAttrVal("Eu_out_way", Eu_out_way);
	}
	public String getOut_sense() {
		return ((String) getAttrVal("Out_sense"));
	}	
	public void setOut_sense(String Out_sense) {
		setAttrVal("Out_sense", Out_sense);
	}
	public String getSd_gowhere() {
		return ((String) getAttrVal("Sd_gowhere"));
	}	
	public void setSd_gowhere(String Sd_gowhere) {
		setAttrVal("Sd_gowhere", Sd_gowhere);
	}
	public FDateTime getDt_leave() {
		return ((FDateTime) getAttrVal("Dt_leave"));
	}	
	public void setDt_leave(FDateTime Dt_leave) {
		setAttrVal("Dt_leave", Dt_leave);
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
		return "Id_emgstay";
	}
	
	@Override
	public String getTableName() {	  
		return "en_ent_ip_emgstay";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmgStayDODesc.class);
	}
	
}