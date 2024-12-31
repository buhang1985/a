package iih.sc.scp.scplweek.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.scp.scplweek.d.desc.ScPlanWeekEnDODesc;
import java.math.BigDecimal;

/**
 * 计划排班_计划_周_就诊 DO数据 
 * 
 */
public class ScPlanWeekEnDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SCPLWEEKEN= "Id_scplweeken";
	public static final String ID_SCPLWEEK= "Id_scplweek";
	public static final String ID_ENTP= "Id_entp";
	public static final String SD_ENTP= "Sd_entp";
	public static final String SCPOLCN= "Scpolcn";
	public static final String QUAN= "Quan";
	public static final String CODE_ENTP= "Code_entp";
	public static final String NAME_ENTP= "Name_entp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_scplweeken() {
		return ((String) getAttrVal("Id_scplweeken"));
	}	
	public void setId_scplweeken(String Id_scplweeken) {
		setAttrVal("Id_scplweeken", Id_scplweeken);
	}
	public String getId_scplweek() {
		return ((String) getAttrVal("Id_scplweek"));
	}	
	public void setId_scplweek(String Id_scplweek) {
		setAttrVal("Id_scplweek", Id_scplweek);
	}
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	public String getSd_entp() {
		return ((String) getAttrVal("Sd_entp"));
	}	
	public void setSd_entp(String Sd_entp) {
		setAttrVal("Sd_entp", Sd_entp);
	}
	public Integer getScpolcn() {
		return ((Integer) getAttrVal("Scpolcn"));
	}	
	public void setScpolcn(Integer Scpolcn) {
		setAttrVal("Scpolcn", Scpolcn);
	}
	public Integer getQuan() {
		return ((Integer) getAttrVal("Quan"));
	}	
	public void setQuan(Integer Quan) {
		setAttrVal("Quan", Quan);
	}
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	public String getName_entp() {
		return ((String) getAttrVal("Name_entp"));
	}	
	public void setName_entp(String Name_entp) {
		setAttrVal("Name_entp", Name_entp);
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
		return "Id_scplweeken";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_pl_week_en";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScPlanWeekEnDODesc.class);
	}
	
}