package iih.bl.st.blprepaysrcpmoep.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.st.blprepaysrcpmoep.d.desc.BlPrepaySrcpmOepDODesc;
import java.math.BigDecimal;

/**
 * 收付款_预交金_费用来源_门急体 DO数据 
 * 
 */
public class BlPrepaySrcpmOepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PREPAYSRCPMOEP= "Id_prepaysrcpmoep";
	public static final String ID_PAYITMPATOEP= "Id_payitmpatoep";
	public static final String AMT= "Amt";
	public static final String ID_PM_SRC= "Id_pm_src";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_prepaysrcpmoep() {
		return ((String) getAttrVal("Id_prepaysrcpmoep"));
	}	
	public void setId_prepaysrcpmoep(String Id_prepaysrcpmoep) {
		setAttrVal("Id_prepaysrcpmoep", Id_prepaysrcpmoep);
	}
	public String getId_payitmpatoep() {
		return ((String) getAttrVal("Id_payitmpatoep"));
	}	
	public void setId_payitmpatoep(String Id_payitmpatoep) {
		setAttrVal("Id_payitmpatoep", Id_payitmpatoep);
	}
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	public String getId_pm_src() {
		return ((String) getAttrVal("Id_pm_src"));
	}	
	public void setId_pm_src(String Id_pm_src) {
		setAttrVal("Id_pm_src", Id_pm_src);
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
		return "Id_prepaysrcpmoep";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_prepay_srcpm_oep";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlPrepaySrcpmOepDODesc.class);
	}
	
}