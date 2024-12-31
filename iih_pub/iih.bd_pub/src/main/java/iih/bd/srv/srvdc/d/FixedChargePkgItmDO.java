package iih.bd.srv.srvdc.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.srvdc.d.desc.FixedChargePkgItmDODesc;
import java.math.BigDecimal;

/**
 * 收费包固定收费明细 DO数据 
 * 
 */
public class FixedChargePkgItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//固定收费包项目主键标识
	public static final String ID_SRVDCITM= "Id_srvdcitm";
	//固定收费包
	public static final String ID_SRVDC= "Id_srvdc";
	//服务
	public static final String ID_SRV= "Id_srv";
	//数量
	public static final String QUAN= "Quan";
	//物品
	public static final String ID_MM= "Id_mm";
	//单位
	public static final String ID_UNIT= "Id_unit";
	//编码
	public static final String SRVDC_CODE= "Srvdc_code";
	//名称
	public static final String SRVDC_NAME= "Srvdc_name";
	//服务编码
	public static final String SRV_CODE= "Srv_code";
	//服务名称
	public static final String SRV_NAME= "Srv_name";
	//医疗物品标识
	public static final String FG_MM= "Fg_mm";
	//物品编码
	public static final String MM_CODE= "Mm_code";
	//物品名称
	public static final String MM_NAME= "Mm_name";
	//计量单位编码
	public static final String UNIT_CODE= "Unit_code";
	//计量单位名称
	public static final String UNIT_NAME= "Unit_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 固定收费包项目主键标识
	 * @return String
	 */
	public String getId_srvdcitm() {
		return ((String) getAttrVal("Id_srvdcitm"));
	}	
	/**
	 * 固定收费包项目主键标识
	 * @param Id_srvdcitm
	 */
	public void setId_srvdcitm(String Id_srvdcitm) {
		setAttrVal("Id_srvdcitm", Id_srvdcitm);
	}
	/**
	 * 固定收费包
	 * @return String
	 */
	public String getId_srvdc() {
		return ((String) getAttrVal("Id_srvdc"));
	}	
	/**
	 * 固定收费包
	 * @param Id_srvdc
	 */
	public void setId_srvdc(String Id_srvdc) {
		setAttrVal("Id_srvdc", Id_srvdc);
	}
	/**
	 * 服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 数量
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}	
	/**
	 * 数量
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 物品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 物品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}	
	/**
	 * 单位
	 * @param Id_unit
	 */
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSrvdc_code() {
		return ((String) getAttrVal("Srvdc_code"));
	}	
	/**
	 * 编码
	 * @param Srvdc_code
	 */
	public void setSrvdc_code(String Srvdc_code) {
		setAttrVal("Srvdc_code", Srvdc_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSrvdc_name() {
		return ((String) getAttrVal("Srvdc_name"));
	}	
	/**
	 * 名称
	 * @param Srvdc_name
	 */
	public void setSrvdc_name(String Srvdc_name) {
		setAttrVal("Srvdc_name", Srvdc_name);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getSrv_code() {
		return ((String) getAttrVal("Srv_code"));
	}	
	/**
	 * 服务编码
	 * @param Srv_code
	 */
	public void setSrv_code(String Srv_code) {
		setAttrVal("Srv_code", Srv_code);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	/**
	 * 服务名称
	 * @param Srv_name
	 */
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	/**
	 * 医疗物品标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mm() {
		return ((FBoolean) getAttrVal("Fg_mm"));
	}	
	/**
	 * 医疗物品标识
	 * @param Fg_mm
	 */
	public void setFg_mm(FBoolean Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
	}
	/**
	 * 物品编码
	 * @return String
	 */
	public String getMm_code() {
		return ((String) getAttrVal("Mm_code"));
	}	
	/**
	 * 物品编码
	 * @param Mm_code
	 */
	public void setMm_code(String Mm_code) {
		setAttrVal("Mm_code", Mm_code);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getMm_name() {
		return ((String) getAttrVal("Mm_name"));
	}	
	/**
	 * 物品名称
	 * @param Mm_name
	 */
	public void setMm_name(String Mm_name) {
		setAttrVal("Mm_name", Mm_name);
	}
	/**
	 * 计量单位编码
	 * @return String
	 */
	public String getUnit_code() {
		return ((String) getAttrVal("Unit_code"));
	}	
	/**
	 * 计量单位编码
	 * @param Unit_code
	 */
	public void setUnit_code(String Unit_code) {
		setAttrVal("Unit_code", Unit_code);
	}
	/**
	 * 计量单位名称
	 * @return String
	 */
	public String getUnit_name() {
		return ((String) getAttrVal("Unit_name"));
	}	
	/**
	 * 计量单位名称
	 * @param Unit_name
	 */
	public void setUnit_name(String Unit_name) {
		setAttrVal("Unit_name", Unit_name);
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
		return "Id_srvdcitm";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_dc_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(FixedChargePkgItmDODesc.class);
	}
	
}