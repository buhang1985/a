package iih.en.pv.enstatwardsay.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.enstatwardsay.d.desc.EnStatWardDayDesc;
import java.math.BigDecimal;

/**
 * 科室日报 DO数据 
 * 
 */
public class EnStatWardDay extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID= "Id";
	public static final String ID_DEP= "Id_dep";
	public static final String D_STAT= "D_stat";
	public static final String NUM_IN= "Num_in";
	public static final String NUM_OUT= "Num_out";
	public static final String NUM_IN_TRAN= "Num_in_tran";
	public static final String NUM_OUT_TRAN= "Num_out_tran";
	public static final String NUM_PAT= "Num_pat";
	public static final String NUM_BED= "Num_bed";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId() {
		return ((String) getAttrVal("Id"));
	}	
	public void setId(String Id) {
		setAttrVal("Id", Id);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public FDate getD_stat() {
		return ((FDate) getAttrVal("D_stat"));
	}	
	public void setD_stat(FDate D_stat) {
		setAttrVal("D_stat", D_stat);
	}
	public Integer getNum_in() {
		return ((Integer) getAttrVal("Num_in"));
	}	
	public void setNum_in(Integer Num_in) {
		setAttrVal("Num_in", Num_in);
	}
	public Integer getNum_out() {
		return ((Integer) getAttrVal("Num_out"));
	}	
	public void setNum_out(Integer Num_out) {
		setAttrVal("Num_out", Num_out);
	}
	public Integer getNum_in_tran() {
		return ((Integer) getAttrVal("Num_in_tran"));
	}	
	public void setNum_in_tran(Integer Num_in_tran) {
		setAttrVal("Num_in_tran", Num_in_tran);
	}
	public Integer getNum_out_tran() {
		return ((Integer) getAttrVal("Num_out_tran"));
	}	
	public void setNum_out_tran(Integer Num_out_tran) {
		setAttrVal("Num_out_tran", Num_out_tran);
	}
	public Integer getNum_pat() {
		return ((Integer) getAttrVal("Num_pat"));
	}	
	public void setNum_pat(Integer Num_pat) {
		setAttrVal("Num_pat", Num_pat);
	}
	public Integer getNum_bed() {
		return ((Integer) getAttrVal("Num_bed"));
	}	
	public void setNum_bed(Integer Num_bed) {
		setAttrVal("Num_bed", Num_bed);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
		return "Id";
	}
	
	@Override
	public String getTableName() {	  
		return "en_stat_ward_day";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EnStatWardDayDesc.class);
	}
	
}