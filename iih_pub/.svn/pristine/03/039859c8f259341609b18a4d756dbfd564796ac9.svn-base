package iih.pis.ivx.pisivxsetting.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pis.ivx.pisivxsetting.d.desc.PisIvxSettingLocationDODesc;
import java.math.BigDecimal;

/**
 * 微信服务-医院位置坐标 DO数据 
 * 
 */
public class PisIvxSettingLocationDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//微信医院坐标主键标识
	public static final String ID_PISIVXSETTINGLOCATION= "Id_pisivxsettinglocation";
	//微信服务号配置ID
	public static final String ID_PISIVXSETTING= "Id_pisivxsetting";
	//院区编码
	public static final String CODE= "Code";
	//院区名称
	public static final String NAME= "Name";
	//位置
	public static final String LOCATION= "Location";
	//经度
	public static final String LONGITUDE= "Longitude";
	//纬度
	public static final String LATITUDE= "Latitude";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 微信医院坐标主键标识
	 * @return String
	 */
	public String getId_pisivxsettinglocation() {
		return ((String) getAttrVal("Id_pisivxsettinglocation"));
	}	
	/**
	 * 微信医院坐标主键标识
	 * @param Id_pisivxsettinglocation
	 */
	public void setId_pisivxsettinglocation(String Id_pisivxsettinglocation) {
		setAttrVal("Id_pisivxsettinglocation", Id_pisivxsettinglocation);
	}
	/**
	 * 微信服务号配置ID
	 * @return String
	 */
	public String getId_pisivxsetting() {
		return ((String) getAttrVal("Id_pisivxsetting"));
	}	
	/**
	 * 微信服务号配置ID
	 * @param Id_pisivxsetting
	 */
	public void setId_pisivxsetting(String Id_pisivxsetting) {
		setAttrVal("Id_pisivxsetting", Id_pisivxsetting);
	}
	/**
	 * 院区编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 院区编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 院区名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 院区名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 位置
	 * @return String
	 */
	public String getLocation() {
		return ((String) getAttrVal("Location"));
	}	
	/**
	 * 位置
	 * @param Location
	 */
	public void setLocation(String Location) {
		setAttrVal("Location", Location);
	}
	/**
	 * 经度
	 * @return String
	 */
	public String getLongitude() {
		return ((String) getAttrVal("Longitude"));
	}	
	/**
	 * 经度
	 * @param Longitude
	 */
	public void setLongitude(String Longitude) {
		setAttrVal("Longitude", Longitude);
	}
	/**
	 * 纬度
	 * @return String
	 */
	public String getLatitude() {
		return ((String) getAttrVal("Latitude"));
	}	
	/**
	 * 纬度
	 * @param Latitude
	 */
	public void setLatitude(String Latitude) {
		setAttrVal("Latitude", Latitude);
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
		return "Id_pisivxsettinglocation";
	}
	
	@Override
	public String getTableName() {	  
		return "pis_ivx_settinglocation";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PisIvxSettingLocationDODesc.class);
	}
	
}