package iih.bd.srv.medsrv.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.medsrv.d.desc.MedSrvDietDODesc;
import java.math.BigDecimal;

/**
 * 医疗服务膳食属性 DO数据 
 * 
 */
public class MedSrvDietDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//膳食项目主键
	public static final String ID_SRVDIET= "Id_srvdiet";
	//医疗服务项目
	public static final String ID_SRV= "Id_srv";
	//膳食指标主键串
	public static final String ID_DIETINDEXS= "Id_dietindexs";
	//膳食指标编码串
	public static final String SD_DIETINDEXS= "Sd_dietindexs";
	//服务名称
	public static final String SRV_NAME= "Srv_name";
	//服务编码
	public static final String SRV_CODE= "Srv_code";
	//膳食指标名称串
	public static final String DIET_NAME= "Diet_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 膳食项目主键
	 * @return String
	 */
	public String getId_srvdiet() {
		return ((String) getAttrVal("Id_srvdiet"));
	}	
	/**
	 * 膳食项目主键
	 * @param Id_srvdiet
	 */
	public void setId_srvdiet(String Id_srvdiet) {
		setAttrVal("Id_srvdiet", Id_srvdiet);
	}
	/**
	 * 医疗服务项目
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 医疗服务项目
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 膳食指标主键串
	 * @return String
	 */
	public String getId_dietindexs() {
		return ((String) getAttrVal("Id_dietindexs"));
	}	
	/**
	 * 膳食指标主键串
	 * @param Id_dietindexs
	 */
	public void setId_dietindexs(String Id_dietindexs) {
		setAttrVal("Id_dietindexs", Id_dietindexs);
	}
	/**
	 * 膳食指标编码串
	 * @return String
	 */
	public String getSd_dietindexs() {
		return ((String) getAttrVal("Sd_dietindexs"));
	}	
	/**
	 * 膳食指标编码串
	 * @param Sd_dietindexs
	 */
	public void setSd_dietindexs(String Sd_dietindexs) {
		setAttrVal("Sd_dietindexs", Sd_dietindexs);
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
	 * 膳食指标名称串
	 * @return String
	 */
	public String getDiet_name() {
		return ((String) getAttrVal("Diet_name"));
	}	
	/**
	 * 膳食指标名称串
	 * @param Diet_name
	 */
	public void setDiet_name(String Diet_name) {
		setAttrVal("Diet_name", Diet_name);
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
		return "Id_srvdiet";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_diet";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MedSrvDietDODesc.class);
	}
	
}