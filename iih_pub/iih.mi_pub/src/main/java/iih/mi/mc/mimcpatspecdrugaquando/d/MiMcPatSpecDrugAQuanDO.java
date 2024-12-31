package iih.mi.mc.mimcpatspecdrugaquando.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mi.mc.mimcpatspecdrugaquando.d.desc.MiMcPatSpecDrugAQuanDODesc;
import java.math.BigDecimal;

/**
 * 患者特殊病药品增量表 DO数据 
 * 
 */
public class MiMcPatSpecDrugAQuanDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//患者特殊病药品增量表主键
	public static final String ID_MIMCPATSPECDRUGAQUAN= "Id_mimcpatspecdrugaquan";
	//医保特殊病患者诊断
	public static final String ID_MIMCPATSPECDI= "Id_mimcpatspecdi";
	//患者ID
	public static final String ID_PAT= "Id_pat";
	//医保卡卡号
	public static final String NO_HP= "No_hp";
	//物品ID
	public static final String ID_MM= "Id_mm";
	//物品单位
	public static final String ID_UNIT= "Id_unit";
	//总增量
	public static final String ADDQUAN= "Addquan";
	//开始时间
	public static final String DT_B= "Dt_b";
	//结束时间
	public static final String DT_E= "Dt_e";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//医保特殊病患者
	public static final String ID_HPPATSPEC= "Id_hppatspec";
	//物品编码
	public static final String CODE= "Code";
	//物品名称
	public static final String NAME= "Name";
	//物品描述
	public static final String DES= "Des";
	//物品规格
	public static final String SPEC= "Spec";
	//基本包装单位名称
	public static final String NAME_UNIT_PKGBASE= "Name_unit_pkgbase";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 患者特殊病药品增量表主键
	 * @return String
	 */
	public String getId_mimcpatspecdrugaquan() {
		return ((String) getAttrVal("Id_mimcpatspecdrugaquan"));
	}	
	/**
	 * 患者特殊病药品增量表主键
	 * @param Id_mimcpatspecdrugaquan
	 */
	public void setId_mimcpatspecdrugaquan(String Id_mimcpatspecdrugaquan) {
		setAttrVal("Id_mimcpatspecdrugaquan", Id_mimcpatspecdrugaquan);
	}
	/**
	 * 医保特殊病患者诊断
	 * @return String
	 */
	public String getId_mimcpatspecdi() {
		return ((String) getAttrVal("Id_mimcpatspecdi"));
	}	
	/**
	 * 医保特殊病患者诊断
	 * @param Id_mimcpatspecdi
	 */
	public void setId_mimcpatspecdi(String Id_mimcpatspecdi) {
		setAttrVal("Id_mimcpatspecdi", Id_mimcpatspecdi);
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
	 * 物品ID
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 物品ID
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
	 * 总增量
	 * @return FDouble
	 */
	public FDouble getAddquan() {
		return ((FDouble) getAttrVal("Addquan"));
	}	
	/**
	 * 总增量
	 * @param Addquan
	 */
	public void setAddquan(FDouble Addquan) {
		setAttrVal("Addquan", Addquan);
	}
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}	
	/**
	 * 开始时间
	 * @param Dt_b
	 */
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_e() {
		return ((FDateTime) getAttrVal("Dt_e"));
	}	
	/**
	 * 结束时间
	 * @param Dt_e
	 */
	public void setDt_e(FDateTime Dt_e) {
		setAttrVal("Dt_e", Dt_e);
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
	 * 医保特殊病患者
	 * @return String
	 */
	public String getId_hppatspec() {
		return ((String) getAttrVal("Id_hppatspec"));
	}	
	/**
	 * 医保特殊病患者
	 * @param Id_hppatspec
	 */
	public void setId_hppatspec(String Id_hppatspec) {
		setAttrVal("Id_hppatspec", Id_hppatspec);
	}
	/**
	 * 物品编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 物品编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 物品名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 物品描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 物品描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 物品规格
	 * @return String
	 */
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}	
	/**
	 * 物品规格
	 * @param Spec
	 */
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}
	/**
	 * 基本包装单位名称
	 * @return String
	 */
	public String getName_unit_pkgbase() {
		return ((String) getAttrVal("Name_unit_pkgbase"));
	}	
	/**
	 * 基本包装单位名称
	 * @param Name_unit_pkgbase
	 */
	public void setName_unit_pkgbase(String Name_unit_pkgbase) {
		setAttrVal("Name_unit_pkgbase", Name_unit_pkgbase);
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
		return "Id_mimcpatspecdrugaquan";
	}
	
	@Override
	public String getTableName() {	  
		return "mi_mc_pat_spec_drugAQuan";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MiMcPatSpecDrugAQuanDODesc.class);
	}
	
}