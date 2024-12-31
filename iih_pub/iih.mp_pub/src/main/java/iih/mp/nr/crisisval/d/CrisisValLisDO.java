package iih.mp.nr.crisisval.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.nr.crisisval.d.desc.CrisisValLisDODesc;
import java.math.BigDecimal;

/**
 * 检验危急值 DO数据 
 * 
 */
public class CrisisValLisDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//检验危急值ID
	public static final String ID_CRIS_VAL_LIS= "Id_cris_val_lis";
	//危急值ID
	public static final String ID_CRIS_VAL= "Id_cris_val";
	//医嘱ID
	public static final String ID_OR= "Id_or";
	//申请单号
	public static final String NO_APPLYFORM= "No_applyform";
	//危机值项目
	public static final String ID_SRV= "Id_srv";
	//项目编码
	public static final String CODE_SRV= "Code_srv";
	//项目名称
	public static final String NAME_SRV= "Name_srv";
	//项目名称（英）
	public static final String NAME_SRV_EN= "Name_srv_en";
	//结果值
	public static final String VAL= "Val";
	//参考值
	public static final String VAL_REF= "Val_ref";
	//单位
	public static final String NAME_UNIT= "Name_unit";
	//偏离值id
	public static final String ID_DEVIATE= "Id_deviate";
	//偏离值编码
	public static final String SD_DEVIATE= "Sd_deviate";
	//危急值上报描述
	public static final String DESCRIPTIONS= "Descriptions";
	//扩展字段1
	public static final String CTRL1= "Ctrl1";
	//扩展字段2
	public static final String CTRL2= "Ctrl2";
	//扩展字段3
	public static final String CTRL3= "Ctrl3";
	//扩展字段4
	public static final String CTRL4= "Ctrl4";
	//扩展字段5
	public static final String CTRL5= "Ctrl5";
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
	 * 检验危急值ID
	 * @return String
	 */
	public String getId_cris_val_lis() {
		return ((String) getAttrVal("Id_cris_val_lis"));
	}	
	/**
	 * 检验危急值ID
	 * @param Id_cris_val_lis
	 */
	public void setId_cris_val_lis(String Id_cris_val_lis) {
		setAttrVal("Id_cris_val_lis", Id_cris_val_lis);
	}
	/**
	 * 危急值ID
	 * @return String
	 */
	public String getId_cris_val() {
		return ((String) getAttrVal("Id_cris_val"));
	}	
	/**
	 * 危急值ID
	 * @param Id_cris_val
	 */
	public void setId_cris_val(String Id_cris_val) {
		setAttrVal("Id_cris_val", Id_cris_val);
	}
	/**
	 * 医嘱ID
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}	
	/**
	 * 申请单号
	 * @param No_applyform
	 */
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	/**
	 * 危机值项目
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 危机值项目
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 项目编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}	
	/**
	 * 项目编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 项目名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	/**
	 * 项目名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 项目名称（英）
	 * @return String
	 */
	public String getName_srv_en() {
		return ((String) getAttrVal("Name_srv_en"));
	}	
	/**
	 * 项目名称（英）
	 * @param Name_srv_en
	 */
	public void setName_srv_en(String Name_srv_en) {
		setAttrVal("Name_srv_en", Name_srv_en);
	}
	/**
	 * 结果值
	 * @return String
	 */
	public String getVal() {
		return ((String) getAttrVal("Val"));
	}	
	/**
	 * 结果值
	 * @param Val
	 */
	public void setVal(String Val) {
		setAttrVal("Val", Val);
	}
	/**
	 * 参考值
	 * @return String
	 */
	public String getVal_ref() {
		return ((String) getAttrVal("Val_ref"));
	}	
	/**
	 * 参考值
	 * @param Val_ref
	 */
	public void setVal_ref(String Val_ref) {
		setAttrVal("Val_ref", Val_ref);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}	
	/**
	 * 单位
	 * @param Name_unit
	 */
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
	}
	/**
	 * 偏离值id
	 * @return String
	 */
	public String getId_deviate() {
		return ((String) getAttrVal("Id_deviate"));
	}	
	/**
	 * 偏离值id
	 * @param Id_deviate
	 */
	public void setId_deviate(String Id_deviate) {
		setAttrVal("Id_deviate", Id_deviate);
	}
	/**
	 * 偏离值编码
	 * @return String
	 */
	public String getSd_deviate() {
		return ((String) getAttrVal("Sd_deviate"));
	}	
	/**
	 * 偏离值编码
	 * @param Sd_deviate
	 */
	public void setSd_deviate(String Sd_deviate) {
		setAttrVal("Sd_deviate", Sd_deviate);
	}
	/**
	 * 危急值上报描述
	 * @return String
	 */
	public String getDescriptions() {
		return ((String) getAttrVal("Descriptions"));
	}	
	/**
	 * 危急值上报描述
	 * @param Descriptions
	 */
	public void setDescriptions(String Descriptions) {
		setAttrVal("Descriptions", Descriptions);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getCtrl1() {
		return ((String) getAttrVal("Ctrl1"));
	}	
	/**
	 * 扩展字段1
	 * @param Ctrl1
	 */
	public void setCtrl1(String Ctrl1) {
		setAttrVal("Ctrl1", Ctrl1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getCtrl2() {
		return ((String) getAttrVal("Ctrl2"));
	}	
	/**
	 * 扩展字段2
	 * @param Ctrl2
	 */
	public void setCtrl2(String Ctrl2) {
		setAttrVal("Ctrl2", Ctrl2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getCtrl3() {
		return ((String) getAttrVal("Ctrl3"));
	}	
	/**
	 * 扩展字段3
	 * @param Ctrl3
	 */
	public void setCtrl3(String Ctrl3) {
		setAttrVal("Ctrl3", Ctrl3);
	}
	/**
	 * 扩展字段4
	 * @return String
	 */
	public String getCtrl4() {
		return ((String) getAttrVal("Ctrl4"));
	}	
	/**
	 * 扩展字段4
	 * @param Ctrl4
	 */
	public void setCtrl4(String Ctrl4) {
		setAttrVal("Ctrl4", Ctrl4);
	}
	/**
	 * 扩展字段5
	 * @return String
	 */
	public String getCtrl5() {
		return ((String) getAttrVal("Ctrl5"));
	}	
	/**
	 * 扩展字段5
	 * @param Ctrl5
	 */
	public void setCtrl5(String Ctrl5) {
		setAttrVal("Ctrl5", Ctrl5);
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
		return "Id_cris_val_lis";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_cris_val_lis";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CrisisValLisDODesc.class);
	}
	
}