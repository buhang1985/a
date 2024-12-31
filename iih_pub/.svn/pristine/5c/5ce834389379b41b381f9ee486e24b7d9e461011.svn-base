package iih.mp.mpbd.mprs.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.mpbd.mprs.d.desc.MpRsDepDODesc;
import java.math.BigDecimal;

/**
 * 滚屏适应科室 DO数据 
 * 
 */
public class MpRsDepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//滚屏适应科室ID
	public static final String ID_RS_DEP= "Id_rs_dep";
	//护士站滚屏ID
	public static final String ID_RS= "Id_rs";
	//滚屏适应合适ID
	public static final String ID_DEP= "Id_dep";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//滚屏适应病区名称
	public static final String NAME_RS_DEP= "Name_rs_dep";
	//滚屏适应病区编码
	public static final String CODE_RS_DEP= "Code_rs_dep";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 滚屏适应科室ID
	 * @return String
	 */
	public String getId_rs_dep() {
		return ((String) getAttrVal("Id_rs_dep"));
	}	
	/**
	 * 滚屏适应科室ID
	 * @param Id_rs_dep
	 */
	public void setId_rs_dep(String Id_rs_dep) {
		setAttrVal("Id_rs_dep", Id_rs_dep);
	}
	/**
	 * 护士站滚屏ID
	 * @return String
	 */
	public String getId_rs() {
		return ((String) getAttrVal("Id_rs"));
	}	
	/**
	 * 护士站滚屏ID
	 * @param Id_rs
	 */
	public void setId_rs(String Id_rs) {
		setAttrVal("Id_rs", Id_rs);
	}
	/**
	 * 滚屏适应合适ID
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 滚屏适应合适ID
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 滚屏适应病区名称
	 * @return String
	 */
	public String getName_rs_dep() {
		return ((String) getAttrVal("Name_rs_dep"));
	}	
	/**
	 * 滚屏适应病区名称
	 * @param Name_rs_dep
	 */
	public void setName_rs_dep(String Name_rs_dep) {
		setAttrVal("Name_rs_dep", Name_rs_dep);
	}
	/**
	 * 滚屏适应病区编码
	 * @return String
	 */
	public String getCode_rs_dep() {
		return ((String) getAttrVal("Code_rs_dep"));
	}	
	/**
	 * 滚屏适应病区编码
	 * @param Code_rs_dep
	 */
	public void setCode_rs_dep(String Code_rs_dep) {
		setAttrVal("Code_rs_dep", Code_rs_dep);
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
		return "Id_rs_dep";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_RS_DEP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpRsDepDODesc.class);
	}
	
}