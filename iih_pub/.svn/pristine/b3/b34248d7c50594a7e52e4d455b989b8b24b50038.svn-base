package iih.mkr.std.devd.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mkr.std.devd.d.desc.DeValDomainDODesc;
import java.math.BigDecimal;

/**
 * 数据元值域 DO数据 
 * 
 */
public class DeValDomainDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//数据元值域主键
	public static final String ID_DE_VD= "Id_de_vd";
	//数据元
	public static final String ID_DE= "Id_de";
	//值域
	public static final String ID_VD= "Id_vd";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 数据元值域主键
	 * @return String
	 */
	public String getId_de_vd() {
		return ((String) getAttrVal("Id_de_vd"));
	}	
	/**
	 * 数据元值域主键
	 * @param Id_de_vd
	 */
	public void setId_de_vd(String Id_de_vd) {
		setAttrVal("Id_de_vd", Id_de_vd);
	}
	/**
	 * 数据元
	 * @return String
	 */
	public String getId_de() {
		return ((String) getAttrVal("Id_de"));
	}	
	/**
	 * 数据元
	 * @param Id_de
	 */
	public void setId_de(String Id_de) {
		setAttrVal("Id_de", Id_de);
	}
	/**
	 * 值域
	 * @return String
	 */
	public String getId_vd() {
		return ((String) getAttrVal("Id_vd"));
	}	
	/**
	 * 值域
	 * @param Id_vd
	 */
	public void setId_vd(String Id_vd) {
		setAttrVal("Id_vd", Id_vd);
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
		return "Id_de_vd";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_DE_VD";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DeValDomainDODesc.class);
	}
	
}