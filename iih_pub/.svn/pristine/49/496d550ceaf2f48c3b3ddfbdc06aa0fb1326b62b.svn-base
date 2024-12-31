package iih.mi.mc.mimcpatspecdrugalogquando.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mi.mc.mimcpatspecdrugalogquando.d.desc.MiMcPatSpecDrugALogQuanDODesc;
import java.math.BigDecimal;

/**
 * 患者特殊病药品增量日志表 DO数据 
 * 
 */
public class MiMcPatSpecDrugALogQuanDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//患者特殊病药品增量日志表主键
	public static final String ID_MIMCPATSPECDRUGAQUANLOG= "Id_mimcpatspecdrugaquanlog";
	//患者ID
	public static final String ID_PAT= "Id_pat";
	//医保卡卡号
	public static final String NO_HP= "No_hp";
	//物品id
	public static final String ID_MM= "Id_mm";
	//物品单位
	public static final String ID_UNIT= "Id_unit";
	//调整量
	public static final String ADDQUAN= "Addquan";
	//操作时间
	public static final String DT_OPER= "Dt_oper";
	//操作人员
	public static final String ID_OPER_EMP= "Id_oper_emp";
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
	 * 患者特殊病药品增量日志表主键
	 * @return String
	 */
	public String getId_mimcpatspecdrugaquanlog() {
		return ((String) getAttrVal("Id_mimcpatspecdrugaquanlog"));
	}	
	/**
	 * 患者特殊病药品增量日志表主键
	 * @param Id_mimcpatspecdrugaquanlog
	 */
	public void setId_mimcpatspecdrugaquanlog(String Id_mimcpatspecdrugaquanlog) {
		setAttrVal("Id_mimcpatspecdrugaquanlog", Id_mimcpatspecdrugaquanlog);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 医保卡卡号
	 * @return String
	 */
	public String getNo_hp() {
		return ((String) getAttrVal("No_hp"));
	}	
	/**
	 * 医保卡卡号
	 * @param No_hp
	 */
	public void setNo_hp(String No_hp) {
		setAttrVal("No_hp", No_hp);
	}
	/**
	 * 物品id
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 物品id
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 物品单位
	 * @return String
	 */
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}	
	/**
	 * 物品单位
	 * @param Id_unit
	 */
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	/**
	 * 调整量
	 * @return Integer
	 */
	public Integer getAddquan() {
		return ((Integer) getAttrVal("Addquan"));
	}	
	/**
	 * 调整量
	 * @param Addquan
	 */
	public void setAddquan(Integer Addquan) {
		setAttrVal("Addquan", Addquan);
	}
	/**
	 * 操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_oper() {
		return ((FDateTime) getAttrVal("Dt_oper"));
	}	
	/**
	 * 操作时间
	 * @param Dt_oper
	 */
	public void setDt_oper(FDateTime Dt_oper) {
		setAttrVal("Dt_oper", Dt_oper);
	}
	/**
	 * 操作人员
	 * @return String
	 */
	public String getId_oper_emp() {
		return ((String) getAttrVal("Id_oper_emp"));
	}	
	/**
	 * 操作人员
	 * @param Id_oper_emp
	 */
	public void setId_oper_emp(String Id_oper_emp) {
		setAttrVal("Id_oper_emp", Id_oper_emp);
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
		return "Id_mimcpatspecdrugaquanlog";
	}
	
	@Override
	public String getTableName() {	  
		return "mi_hp_pat_spec_drugAQuanlog";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MiMcPatSpecDrugALogQuanDODesc.class);
	}
	
}