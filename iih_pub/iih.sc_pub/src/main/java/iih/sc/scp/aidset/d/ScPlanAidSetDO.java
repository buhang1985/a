package iih.sc.scp.aidset.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.scp.aidset.d.desc.ScPlanAidSetDODesc;
import java.math.BigDecimal;

/**
 * 辅助样本设置 DO数据 
 * 
 */
public class ScPlanAidSetDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SCPLADISET= "Id_scpladiset";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_DAYSLOT= "Id_dayslot";
	public static final String ID_SCPL= "Id_scpl";
	public static final String D_B= "D_b";
	public static final String D_E= "D_e";
	public static final String VAL_MIN= "Val_min";
	public static final String VAL_MAX= "Val_max";
	public static final String EU_VALTP= "Eu_valtp";
	public static final String NUM_AVG_TICK= "Num_avg_tick";
	public static final String FG_PLSELF= "Fg_plself";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_scpladiset() {
		return ((String) getAttrVal("Id_scpladiset"));
	}	
	public void setId_scpladiset(String Id_scpladiset) {
		setAttrVal("Id_scpladiset", Id_scpladiset);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_dayslot() {
		return ((String) getAttrVal("Id_dayslot"));
	}	
	public void setId_dayslot(String Id_dayslot) {
		setAttrVal("Id_dayslot", Id_dayslot);
	}
	public String getId_scpl() {
		return ((String) getAttrVal("Id_scpl"));
	}	
	public void setId_scpl(String Id_scpl) {
		setAttrVal("Id_scpl", Id_scpl);
	}
	public FDate getD_b() {
		return ((FDate) getAttrVal("D_b"));
	}	
	public void setD_b(FDate D_b) {
		setAttrVal("D_b", D_b);
	}
	public FDate getD_e() {
		return ((FDate) getAttrVal("D_e"));
	}	
	public void setD_e(FDate D_e) {
		setAttrVal("D_e", D_e);
	}
	public Integer getVal_min() {
		return ((Integer) getAttrVal("Val_min"));
	}	
	public void setVal_min(Integer Val_min) {
		setAttrVal("Val_min", Val_min);
	}
	public Integer getVal_max() {
		return ((Integer) getAttrVal("Val_max"));
	}	
	public void setVal_max(Integer Val_max) {
		setAttrVal("Val_max", Val_max);
	}
	public Integer getEu_valtp() {
		return ((Integer) getAttrVal("Eu_valtp"));
	}	
	public void setEu_valtp(Integer Eu_valtp) {
		setAttrVal("Eu_valtp", Eu_valtp);
	}
	public Integer getNum_avg_tick() {
		return ((Integer) getAttrVal("Num_avg_tick"));
	}	
	public void setNum_avg_tick(Integer Num_avg_tick) {
		setAttrVal("Num_avg_tick", Num_avg_tick);
	}
	public FBoolean getFg_plself() {
		return ((FBoolean) getAttrVal("Fg_plself"));
	}	
	public void setFg_plself(FBoolean Fg_plself) {
		setAttrVal("Fg_plself", Fg_plself);
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
		return "Id_scpladiset";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_pl_aidset";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScPlanAidSetDODesc.class);
	}
	
}