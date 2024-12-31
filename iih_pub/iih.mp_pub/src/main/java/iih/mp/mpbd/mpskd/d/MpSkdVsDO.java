package iih.mp.mpbd.mpskd.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.mpbd.mpskd.d.desc.MpSkdVsDODesc;
import java.math.BigDecimal;

/**
 * 生命体征 DO数据 
 * 
 */
public class MpSkdVsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体征规则
	public static final String ID_SKD_VS= "Id_skd_vs";
	//护理任务
	public static final String ID_SKD= "Id_skd";
	//生命体征服务
	public static final String ID_SRV= "Id_srv";
	//值类型
	public static final String VALTYPE= "Valtype";
	//文本值
	public static final String VAL= "Val";
	//最小值
	public static final String VAL_MIN= "Val_min";
	//最大值
	public static final String VAL_MAX= "Val_max";
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
	//生命体征服务
	public static final String NAME_SRV= "Name_srv";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体征规则
	 * @return String
	 */
	public String getId_skd_vs() {
		return ((String) getAttrVal("Id_skd_vs"));
	}	
	/**
	 * 体征规则
	 * @param Id_skd_vs
	 */
	public void setId_skd_vs(String Id_skd_vs) {
		setAttrVal("Id_skd_vs", Id_skd_vs);
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
	 * 生命体征服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 生命体征服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 值类型
	 * @return Integer
	 */
	public Integer getValtype() {
		return ((Integer) getAttrVal("Valtype"));
	}	
	/**
	 * 值类型
	 * @param Valtype
	 */
	public void setValtype(Integer Valtype) {
		setAttrVal("Valtype", Valtype);
	}
	/**
	 * 文本值
	 * @return String
	 */
	public String getVal() {
		return ((String) getAttrVal("Val"));
	}	
	/**
	 * 文本值
	 * @param Val
	 */
	public void setVal(String Val) {
		setAttrVal("Val", Val);
	}
	/**
	 * 最小值
	 * @return FDouble
	 */
	public FDouble getVal_min() {
		return ((FDouble) getAttrVal("Val_min"));
	}	
	/**
	 * 最小值
	 * @param Val_min
	 */
	public void setVal_min(FDouble Val_min) {
		setAttrVal("Val_min", Val_min);
	}
	/**
	 * 最大值
	 * @return FDouble
	 */
	public FDouble getVal_max() {
		return ((FDouble) getAttrVal("Val_max"));
	}	
	/**
	 * 最大值
	 * @param Val_max
	 */
	public void setVal_max(FDouble Val_max) {
		setAttrVal("Val_max", Val_max);
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
	 * 生命体征服务
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	/**
	 * 生命体征服务
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
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
		return "Id_skd_vs";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_skd_vs";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpSkdVsDODesc.class);
	}
	
}