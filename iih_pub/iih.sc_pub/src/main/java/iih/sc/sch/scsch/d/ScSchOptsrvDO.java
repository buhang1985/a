package iih.sc.sch.scsch.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.sch.scsch.d.desc.ScSchOptsrvDODesc;
import java.math.BigDecimal;

/**
 * 计划排班_排班_服务 DO数据 
 * 
 */
public class ScSchOptsrvDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//排班备用服务id
	public static final String ID_SCHOPTSRV= "Id_schoptsrv";
	//排班id
	public static final String ID_SCH= "Id_sch";
	//排班服务
	public static final String ID_SCSRV= "Id_scsrv";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 排班备用服务id
	 * @return String
	 */
	public String getId_schoptsrv() {
		return ((String) getAttrVal("Id_schoptsrv"));
	}	
	/**
	 * 排班备用服务id
	 * @param Id_schoptsrv
	 */
	public void setId_schoptsrv(String Id_schoptsrv) {
		setAttrVal("Id_schoptsrv", Id_schoptsrv);
	}
	/**
	 * 排班id
	 * @return String
	 */
	public String getId_sch() {
		return ((String) getAttrVal("Id_sch"));
	}	
	/**
	 * 排班id
	 * @param Id_sch
	 */
	public void setId_sch(String Id_sch) {
		setAttrVal("Id_sch", Id_sch);
	}
	/**
	 * 排班服务
	 * @return String
	 */
	public String getId_scsrv() {
		return ((String) getAttrVal("Id_scsrv"));
	}	
	/**
	 * 排班服务
	 * @param Id_scsrv
	 */
	public void setId_scsrv(String Id_scsrv) {
		setAttrVal("Id_scsrv", Id_scsrv);
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
		return "Id_schoptsrv";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_sch_optsrv";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScSchOptsrvDODesc.class);
	}
	
}