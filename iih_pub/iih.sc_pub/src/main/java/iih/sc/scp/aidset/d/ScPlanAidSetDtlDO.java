package iih.sc.scp.aidset.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.scp.aidset.d.desc.ScPlanAidSetDtlDODesc;
import java.math.BigDecimal;

/**
 * 辅助样本设置_结果 DO数据 
 * 
 */
public class ScPlanAidSetDtlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SCPLAIDSETDTL= "Id_scplaidsetdtl";
	public static final String ID_SCPLADISET= "Id_scpladiset";
	public static final String TICKNO= "Tickno";
	public static final String PERIOD= "Period";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_scplaidsetdtl() {
		return ((String) getAttrVal("Id_scplaidsetdtl"));
	}	
	public void setId_scplaidsetdtl(String Id_scplaidsetdtl) {
		setAttrVal("Id_scplaidsetdtl", Id_scplaidsetdtl);
	}
	public String getId_scpladiset() {
		return ((String) getAttrVal("Id_scpladiset"));
	}	
	public void setId_scpladiset(String Id_scpladiset) {
		setAttrVal("Id_scpladiset", Id_scpladiset);
	}
	public Integer getTickno() {
		return ((Integer) getAttrVal("Tickno"));
	}	
	public void setTickno(Integer Tickno) {
		setAttrVal("Tickno", Tickno);
	}
	public Integer getPeriod() {
		return ((Integer) getAttrVal("Period"));
	}	
	public void setPeriod(Integer Period) {
		setAttrVal("Period", Period);
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
		return "Id_scplaidsetdtl";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_pl_aidset_del";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScPlanAidSetDtlDODesc.class);
	}
	
}