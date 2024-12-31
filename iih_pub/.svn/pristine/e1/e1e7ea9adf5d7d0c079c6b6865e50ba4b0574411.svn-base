package iih.ci.ord.ciappdiriveorreldo.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.ciappdiriveorreldo.d.desc.CiAppDiriveOrRelDODesc;
import java.math.BigDecimal;

/**
 * 管理单据派生医嘱关联关系 DO数据 
 * 
 */
public class CiAppDiriveOrRelDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//派生医嘱关联关系主键
	public static final String ID_CIAPPDIRIVEORREL= "Id_ciappdiriveorrel";
	//关联类型
	public static final String SD_APPRELTP= "Sd_appreltp";
	//单据主键
	public static final String ID_APP= "Id_app";
	//派生医嘱主键
	public static final String ID_RELOR= "Id_relor";
	//医嘱名称
	public static final String NAME_OR= "Name_or";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 派生医嘱关联关系主键
	 * @return String
	 */
	public String getId_ciappdiriveorrel() {
		return ((String) getAttrVal("Id_ciappdiriveorrel"));
	}	
	/**
	 * 派生医嘱关联关系主键
	 * @param Id_ciappdiriveorrel
	 */
	public void setId_ciappdiriveorrel(String Id_ciappdiriveorrel) {
		setAttrVal("Id_ciappdiriveorrel", Id_ciappdiriveorrel);
	}
	/**
	 * 关联类型
	 * @return String
	 */
	public String getSd_appreltp() {
		return ((String) getAttrVal("Sd_appreltp"));
	}	
	/**
	 * 关联类型
	 * @param Sd_appreltp
	 */
	public void setSd_appreltp(String Sd_appreltp) {
		setAttrVal("Sd_appreltp", Sd_appreltp);
	}
	/**
	 * 单据主键
	 * @return String
	 */
	public String getId_app() {
		return ((String) getAttrVal("Id_app"));
	}	
	/**
	 * 单据主键
	 * @param Id_app
	 */
	public void setId_app(String Id_app) {
		setAttrVal("Id_app", Id_app);
	}
	/**
	 * 派生医嘱主键
	 * @return String
	 */
	public String getId_relor() {
		return ((String) getAttrVal("Id_relor"));
	}	
	/**
	 * 派生医嘱主键
	 * @param Id_relor
	 */
	public void setId_relor(String Id_relor) {
		setAttrVal("Id_relor", Id_relor);
	}
	/**
	 * 医嘱名称
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}	
	/**
	 * 医嘱名称
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
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
		return "Id_ciappdiriveorrel";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_APP_DIRIVE_OR_REL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiAppDiriveOrRelDODesc.class);
	}
	
}