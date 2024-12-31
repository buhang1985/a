package iih.mp.mpbd.mpskd.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.mpbd.mpskd.d.desc.MpSkdOrDODesc;
import java.math.BigDecimal;

/**
 * 医嘱 DO数据 
 * 
 */
public class MpSkdOrDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医嘱规则
	public static final String ID_SKD_OR= "Id_skd_or";
	//护理任务
	public static final String ID_SKD= "Id_skd";
	//医疗服务类型
	public static final String ID_SRVTP= "Id_srvtp";
	//医疗服务类型编码
	public static final String SD_SRVTP= "Sd_srvtp";
	//医疗服务
	public static final String ID_SRV= "Id_srv";
	//用法对应参数
	public static final String CODE_ROUTE_PARAM= "Code_route_param";
	//频次
	public static final String ID_FREQ= "Id_freq";
	//扩展字段1
	public static final String DEF1= "Def1";
	//扩展字段2
	public static final String DEF2= "Def2";
	//扩展字段3
	public static final String DEF3= "Def3";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//护理任务
	public static final String NAME_SKD= "Name_skd";
	//医疗服务类型
	public static final String NAME_SRVTP= "Name_srvtp";
	//医疗服务
	public static final String NAME_SRV= "Name_srv";
	//频次
	public static final String NAME_FREQ= "Name_freq";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医嘱规则
	 * @return String
	 */
	public String getId_skd_or() {
		return ((String) getAttrVal("Id_skd_or"));
	}	
	/**
	 * 医嘱规则
	 * @param Id_skd_or
	 */
	public void setId_skd_or(String Id_skd_or) {
		setAttrVal("Id_skd_or", Id_skd_or);
	}
	/**
	 * 护理任务
	 * @return String
	 */
	public String getId_skd() {
		return ((String) getAttrVal("Id_skd"));
	}	
	/**
	 * 护理任务
	 * @param Id_skd
	 */
	public void setId_skd(String Id_skd) {
		setAttrVal("Id_skd", Id_skd);
	}
	/**
	 * 医疗服务类型
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	/**
	 * 医疗服务类型
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 医疗服务类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	/**
	 * 医疗服务类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 医疗服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 医疗服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 用法对应参数
	 * @return String
	 */
	public String getCode_route_param() {
		return ((String) getAttrVal("Code_route_param"));
	}	
	/**
	 * 用法对应参数
	 * @param Code_route_param
	 */
	public void setCode_route_param(String Code_route_param) {
		setAttrVal("Code_route_param", Code_route_param);
	}
	/**
	 * 频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}	
	/**
	 * 频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
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
	 * 护理任务
	 * @return String
	 */
	public String getName_skd() {
		return ((String) getAttrVal("Name_skd"));
	}	
	/**
	 * 护理任务
	 * @param Name_skd
	 */
	public void setName_skd(String Name_skd) {
		setAttrVal("Name_skd", Name_skd);
	}
	/**
	 * 医疗服务类型
	 * @return String
	 */
	public String getName_srvtp() {
		return ((String) getAttrVal("Name_srvtp"));
	}	
	/**
	 * 医疗服务类型
	 * @param Name_srvtp
	 */
	public void setName_srvtp(String Name_srvtp) {
		setAttrVal("Name_srvtp", Name_srvtp);
	}
	/**
	 * 医疗服务
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	/**
	 * 医疗服务
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 频次
	 * @return String
	 */
	public String getName_freq() {
		return ((String) getAttrVal("Name_freq"));
	}	
	/**
	 * 频次
	 * @param Name_freq
	 */
	public void setName_freq(String Name_freq) {
		setAttrVal("Name_freq", Name_freq);
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
		return "Id_skd_or";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_skd_or";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpSkdOrDODesc.class);
	}
	
}