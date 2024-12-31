package iih.en.pv.vt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.vt.d.desc.EnVtSrvDODesc;
import java.math.BigDecimal;

/**
 * 就诊_体征明细 DO数据 
 * 
 */
public class EnVtSrvDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体征明细id
	public static final String ID_ENVTSRV= "Id_envtsrv";
	//体征id
	public static final String ID_ENVT= "Id_envt";
	//就诊id
	public static final String ID_ENT= "Id_ent";
	//服务id
	public static final String ID_SRV= "Id_srv";
	//值0
	public static final String VAL0= "Val0";
	//值1
	public static final String VAL1= "Val1";
	//值2
	public static final String VAL2= "Val2";
	//值3
	public static final String VAL3= "Val3";
	//值4
	public static final String VAL4= "Val4";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//服务编码
	public static final String CODE_SRV= "Code_srv";
	//服务名称
	public static final String NAME_SRV= "Name_srv";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体征明细id
	 * @return String
	 */
	public String getId_envtsrv() {
		return ((String) getAttrVal("Id_envtsrv"));
	}	
	/**
	 * 体征明细id
	 * @param Id_envtsrv
	 */
	public void setId_envtsrv(String Id_envtsrv) {
		setAttrVal("Id_envtsrv", Id_envtsrv);
	}
	/**
	 * 体征id
	 * @return String
	 */
	public String getId_envt() {
		return ((String) getAttrVal("Id_envt"));
	}	
	/**
	 * 体征id
	 * @param Id_envt
	 */
	public void setId_envt(String Id_envt) {
		setAttrVal("Id_envt", Id_envt);
	}
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 值0
	 * @return String
	 */
	public String getVal0() {
		return ((String) getAttrVal("Val0"));
	}	
	/**
	 * 值0
	 * @param Val0
	 */
	public void setVal0(String Val0) {
		setAttrVal("Val0", Val0);
	}
	/**
	 * 值1
	 * @return String
	 */
	public String getVal1() {
		return ((String) getAttrVal("Val1"));
	}	
	/**
	 * 值1
	 * @param Val1
	 */
	public void setVal1(String Val1) {
		setAttrVal("Val1", Val1);
	}
	/**
	 * 值2
	 * @return String
	 */
	public String getVal2() {
		return ((String) getAttrVal("Val2"));
	}	
	/**
	 * 值2
	 * @param Val2
	 */
	public void setVal2(String Val2) {
		setAttrVal("Val2", Val2);
	}
	/**
	 * 值3
	 * @return String
	 */
	public String getVal3() {
		return ((String) getAttrVal("Val3"));
	}	
	/**
	 * 值3
	 * @param Val3
	 */
	public void setVal3(String Val3) {
		setAttrVal("Val3", Val3);
	}
	/**
	 * 值4
	 * @return String
	 */
	public String getVal4() {
		return ((String) getAttrVal("Val4"));
	}	
	/**
	 * 值4
	 * @param Val4
	 */
	public void setVal4(String Val4) {
		setAttrVal("Val4", Val4);
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
	 * 服务编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}	
	/**
	 * 服务编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	/**
	 * 服务名称
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
		return "Id_envtsrv";
	}
	
	@Override
	public String getTableName() {	  
		return "EN_VT_SRV";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EnVtSrvDODesc.class);
	}
	
}