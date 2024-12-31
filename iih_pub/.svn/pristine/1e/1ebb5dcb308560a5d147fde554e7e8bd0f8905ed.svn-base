package iih.mi.biz.mihptransact.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mi.biz.mihptransact.d.desc.MiHpTransActItmDODesc;
import java.math.BigDecimal;

/**
 * 安徽医保交易明细 DO数据 
 * 
 */
public class MiHpTransActItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HPTRANSACTITM= "Id_hptransactitm";
	public static final String ID_HPTRANSACT= "Id_hptransact";
	public static final String ID_CGITM= "Id_cgitm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_hptransactitm() {
		return ((String) getAttrVal("Id_hptransactitm"));
	}	
	public void setId_hptransactitm(String Id_hptransactitm) {
		setAttrVal("Id_hptransactitm", Id_hptransactitm);
	}
	public String getId_hptransact() {
		return ((String) getAttrVal("Id_hptransact"));
	}	
	public void setId_hptransact(String Id_hptransact) {
		setAttrVal("Id_hptransact", Id_hptransact);
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
		return "Id_hptransactitm";
	}
	
	@Override
	public String getTableName() {	  
		return "mi_hptransactitm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MiHpTransActItmDODesc.class);
	}
	
}