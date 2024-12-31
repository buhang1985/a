package iih.bl.hp.hptransactah.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.hp.hptransactah.d.desc.HpTransActItmAhDODesc;
import java.math.BigDecimal;

/**
 * 安徽医保交易明细 DO数据 
 * 
 */
public class HpTransActItmAhDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_TRANSACTITMNEUSOFTAH= "Id_transactitmneusoftah";
	public static final String ID_TRANSACTNEUSOFTAH= "Id_transactneusoftah";
	public static final String ID_CGITM= "Id_cgitm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_transactitmneusoftah() {
		return ((String) getAttrVal("Id_transactitmneusoftah"));
	}	
	public void setId_transactitmneusoftah(String Id_transactitmneusoftah) {
		setAttrVal("Id_transactitmneusoftah", Id_transactitmneusoftah);
	}
	public String getId_transactneusoftah() {
		return ((String) getAttrVal("Id_transactneusoftah"));
	}	
	public void setId_transactneusoftah(String Id_transactneusoftah) {
		setAttrVal("Id_transactneusoftah", Id_transactneusoftah);
	}
	public String getId_cgitm() {
		return ((String) getAttrVal("Id_cgitm"));
	}	
	public void setId_cgitm(String Id_cgitm) {
		setAttrVal("Id_cgitm", Id_cgitm);
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
		return "Id_transactitmneusoftah";
	}
	
	@Override
	public String getTableName() {	  
		return "hp_transact_itm_neusoft_ah";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpTransActItmAhDODesc.class);
	}
	
}