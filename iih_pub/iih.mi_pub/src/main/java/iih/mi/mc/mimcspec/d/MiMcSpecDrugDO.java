package iih.mi.mc.mimcspec.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mi.mc.mimcspec.d.desc.MiMcSpecDrugDODesc;
import java.math.BigDecimal;

/**
 * 医保计划特殊病药品 DO数据 
 * 
 */
public class MiMcSpecDrugDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//特殊病药品id
	public static final String ID_HPSPECDRUG= "Id_hpspecdrug";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//医保计划
	public static final String ID_HP= "Id_hp";
	//特殊病id
	public static final String ID_HPSPEC= "Id_hpspec";
	// 服务id
	public static final String ID_SRV= "Id_srv";
	//物品id
	public static final String ID_MM= "Id_mm";
	//单位
	public static final String ID_UNIT= "Id_unit";
	//控制模式
	public static final String SD_CONTROL= "Sd_control";
	//限制数量
	public static final String QUAN_LIMIT= "Quan_limit";
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
	//拼音
	public static final String PYCODE= "Pycode";
	//简称
	public static final String SHORTNAME= "Shortname";
	//物品编码
	public static final String CODE_MM= "Code_mm";
	//物品名称
	public static final String NAME_MM= "Name_mm";
	//基本包装单位
	public static final String ID_UNIT_PKGBASE= "Id_unit_pkgbase";
	//基本包装单位名称
	public static final String NAME_UNIT_PKGBASE= "Name_unit_pkgbase";
	//物品规格
	public static final String SPEC_MM= "Spec_mm";
	//计量单位编码
	public static final String CODE_UNIT= "Code_unit";
	//计量单位名称
	public static final String NAME_UNIT= "Name_unit";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 特殊病药品id
	 * @return String
	 */
	public String getId_hpspecdrug() {
		return ((String) getAttrVal("Id_hpspecdrug"));
	}	
	/**
	 * 特殊病药品id
	 * @param Id_hpspecdrug
	 */
	public void setId_hpspecdrug(String Id_hpspecdrug) {
		setAttrVal("Id_hpspecdrug", Id_hpspecdrug);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 医保计划
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	/**
	 * 医保计划
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 特殊病id
	 * @return String
	 */
	public String getId_hpspec() {
		return ((String) getAttrVal("Id_hpspec"));
	}	
	/**
	 * 特殊病id
	 * @param Id_hpspec
	 */
	public void setId_hpspec(String Id_hpspec) {
		setAttrVal("Id_hpspec", Id_hpspec);
	}
	/**
	 *  服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 *  服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
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
	 * 控制模式
	 * @return Integer
	 */
	public Integer getSd_control() {
		return ((Integer) getAttrVal("Sd_control"));
	}	
	/**
	 * 控制模式
	 * @param Sd_control
	 */
	public void setSd_control(Integer Sd_control) {
		setAttrVal("Sd_control", Sd_control);
	}
	/**
	 * 限制数量
	 * @return FDouble
	 */
	public FDouble getQuan_limit() {
		return ((FDouble) getAttrVal("Quan_limit"));
	}	
	/**
	 * 限制数量
	 * @param Quan_limit
	 */
	public void setQuan_limit(FDouble Quan_limit) {
		setAttrVal("Quan_limit", Quan_limit);
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
	/**
	 * 拼音
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 简称
	 * @return String
	 */
	public String getShortname() {
		return ((String) getAttrVal("Shortname"));
	}	
	/**
	 * 简称
	 * @param Shortname
	 */
	public void setShortname(String Shortname) {
		setAttrVal("Shortname", Shortname);
	}
	/**
	 * 物品编码
	 * @return String
	 */
	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}	
	/**
	 * 物品编码
	 * @param Code_mm
	 */
	public void setCode_mm(String Code_mm) {
		setAttrVal("Code_mm", Code_mm);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}	
	/**
	 * 物品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 基本包装单位
	 * @return String
	 */
	public String getId_unit_pkgbase() {
		return ((String) getAttrVal("Id_unit_pkgbase"));
	}	
	/**
	 * 基本包装单位
	 * @param Id_unit_pkgbase
	 */
	public void setId_unit_pkgbase(String Id_unit_pkgbase) {
		setAttrVal("Id_unit_pkgbase", Id_unit_pkgbase);
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
	/**
	 * 物品规格
	 * @return String
	 */
	public String getSpec_mm() {
		return ((String) getAttrVal("Spec_mm"));
	}	
	/**
	 * 物品规格
	 * @param Spec_mm
	 */
	public void setSpec_mm(String Spec_mm) {
		setAttrVal("Spec_mm", Spec_mm);
	}
	/**
	 * 计量单位编码
	 * @return String
	 */
	public String getCode_unit() {
		return ((String) getAttrVal("Code_unit"));
	}	
	/**
	 * 计量单位编码
	 * @param Code_unit
	 */
	public void setCode_unit(String Code_unit) {
		setAttrVal("Code_unit", Code_unit);
	}
	/**
	 * 计量单位名称
	 * @return String
	 */
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}	
	/**
	 * 计量单位名称
	 * @param Name_unit
	 */
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
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
		return "Id_hpspecdrug";
	}
	
	@Override
	public String getTableName() {	  
		return "MI_MC_SPEC_DRUG";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MiMcSpecDrugDODesc.class);
	}
	
}