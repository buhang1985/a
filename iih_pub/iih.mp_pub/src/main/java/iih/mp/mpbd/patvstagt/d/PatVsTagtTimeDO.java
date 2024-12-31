package iih.mp.mpbd.patvstagt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.mpbd.patvstagt.d.desc.PatVsTagtTimeDODesc;
import java.math.BigDecimal;

/**
 * 患者体征指标采集时刻 DO数据 
 * 
 */
public class PatVsTagtTimeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//患者体征指标采集点
	public static final String ID_VS_TAGT_TIME= "Id_vs_tagt_time";
	//患者体征指标
	public static final String ID_VS_TAGT= "Id_vs_tagt";
	//序号
	public static final String SORTNO= "Sortno";
	//测量时间ID
	public static final String ID_TIME= "Id_time";
	//测量时间编码
	public static final String SD_TIME= "Sd_time";
	//采集时刻点
	public static final String TIME_VS= "Time_vs";
	//扩展字段1
	public static final String DEF1= "Def1";
	//扩展字段2
	public static final String DEF2= "Def2";
	//扩展字段3
	public static final String DEF3= "Def3";
	//扩展字段4
	public static final String DEF4= "Def4";
	//扩展字段5
	public static final String DEF5= "Def5";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//测量时间名称
	public static final String NAME_TIME= "Name_time";
	//测量时间点
	public static final String CTRL1= "Ctrl1";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 患者体征指标采集点
	 * @return String
	 */
	public String getId_vs_tagt_time() {
		return ((String) getAttrVal("Id_vs_tagt_time"));
	}	
	/**
	 * 患者体征指标采集点
	 * @param Id_vs_tagt_time
	 */
	public void setId_vs_tagt_time(String Id_vs_tagt_time) {
		setAttrVal("Id_vs_tagt_time", Id_vs_tagt_time);
	}
	/**
	 * 患者体征指标
	 * @return String
	 */
	public String getId_vs_tagt() {
		return ((String) getAttrVal("Id_vs_tagt"));
	}	
	/**
	 * 患者体征指标
	 * @param Id_vs_tagt
	 */
	public void setId_vs_tagt(String Id_vs_tagt) {
		setAttrVal("Id_vs_tagt", Id_vs_tagt);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 测量时间ID
	 * @return String
	 */
	public String getId_time() {
		return ((String) getAttrVal("Id_time"));
	}	
	/**
	 * 测量时间ID
	 * @param Id_time
	 */
	public void setId_time(String Id_time) {
		setAttrVal("Id_time", Id_time);
	}
	/**
	 * 测量时间编码
	 * @return String
	 */
	public String getSd_time() {
		return ((String) getAttrVal("Sd_time"));
	}	
	/**
	 * 测量时间编码
	 * @param Sd_time
	 */
	public void setSd_time(String Sd_time) {
		setAttrVal("Sd_time", Sd_time);
	}
	/**
	 * 采集时刻点
	 * @return FTime
	 */
	public FTime getTime_vs() {
		return ((FTime) getAttrVal("Time_vs"));
	}	
	/**
	 * 采集时刻点
	 * @param Time_vs
	 */
	public void setTime_vs(FTime Time_vs) {
		setAttrVal("Time_vs", Time_vs);
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
	 * 扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	/**
	 * 扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	/**
	 * 扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
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
	 * 测量时间名称
	 * @return String
	 */
	public String getName_time() {
		return ((String) getAttrVal("Name_time"));
	}	
	/**
	 * 测量时间名称
	 * @param Name_time
	 */
	public void setName_time(String Name_time) {
		setAttrVal("Name_time", Name_time);
	}
	/**
	 * 测量时间点
	 * @return String
	 */
	public String getCtrl1() {
		return ((String) getAttrVal("Ctrl1"));
	}	
	/**
	 * 测量时间点
	 * @param Ctrl1
	 */
	public void setCtrl1(String Ctrl1) {
		setAttrVal("Ctrl1", Ctrl1);
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
		return "Id_vs_tagt_time";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_vs_tagt_time";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PatVsTagtTimeDODesc.class);
	}
	
}