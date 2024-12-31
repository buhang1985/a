package iih.bd.pp.pripmscene.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.pripmscene.d.desc.PriPmSceneDODesc;
import java.math.BigDecimal;

/**
 * 付款方式使用场景 DO数据 
 * 
 */
public class PriPmSceneDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//付款方式使用场景主键
	public static final String ID_PMSCENE= "Id_pmscene";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//付款方式
	public static final String ID_PM= "Id_pm";
	//使用场景
	public static final String ID_SCENE= "Id_scene";
	//使用场景编码
	public static final String SD_SCENE= "Sd_scene";
	//默认使用方式
	public static final String FG_DEFAULT= "Fg_default";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//付款方式编码
	public static final String CODE_PRIPM= "Code_pripm";
	//付款方式名称
	public static final String NAME_PRIPM= "Name_pripm";
	//编码
	public static final String CODE_SCENE= "Code_scene";
	//名称
	public static final String NAME_SCENE= "Name_scene";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 付款方式使用场景主键
	 * @return String
	 */
	public String getId_pmscene() {
		return ((String) getAttrVal("Id_pmscene"));
	}	
	/**
	 * 付款方式使用场景主键
	 * @param Id_pmscene
	 */
	public void setId_pmscene(String Id_pmscene) {
		setAttrVal("Id_pmscene", Id_pmscene);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 付款方式
	 * @return String
	 */
	public String getId_pm() {
		return ((String) getAttrVal("Id_pm"));
	}	
	/**
	 * 付款方式
	 * @param Id_pm
	 */
	public void setId_pm(String Id_pm) {
		setAttrVal("Id_pm", Id_pm);
	}
	/**
	 * 使用场景
	 * @return String
	 */
	public String getId_scene() {
		return ((String) getAttrVal("Id_scene"));
	}	
	/**
	 * 使用场景
	 * @param Id_scene
	 */
	public void setId_scene(String Id_scene) {
		setAttrVal("Id_scene", Id_scene);
	}
	/**
	 * 使用场景编码
	 * @return String
	 */
	public String getSd_scene() {
		return ((String) getAttrVal("Sd_scene"));
	}	
	/**
	 * 使用场景编码
	 * @param Sd_scene
	 */
	public void setSd_scene(String Sd_scene) {
		setAttrVal("Sd_scene", Sd_scene);
	}
	/**
	 * 默认使用方式
	 * @return FBoolean
	 */
	public FBoolean getFg_default() {
		return ((FBoolean) getAttrVal("Fg_default"));
	}	
	/**
	 * 默认使用方式
	 * @param Fg_default
	 */
	public void setFg_default(FBoolean Fg_default) {
		setAttrVal("Fg_default", Fg_default);
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
	 * 付款方式编码
	 * @return String
	 */
	public String getCode_pripm() {
		return ((String) getAttrVal("Code_pripm"));
	}	
	/**
	 * 付款方式编码
	 * @param Code_pripm
	 */
	public void setCode_pripm(String Code_pripm) {
		setAttrVal("Code_pripm", Code_pripm);
	}
	/**
	 * 付款方式名称
	 * @return String
	 */
	public String getName_pripm() {
		return ((String) getAttrVal("Name_pripm"));
	}	
	/**
	 * 付款方式名称
	 * @param Name_pripm
	 */
	public void setName_pripm(String Name_pripm) {
		setAttrVal("Name_pripm", Name_pripm);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_scene() {
		return ((String) getAttrVal("Code_scene"));
	}	
	/**
	 * 编码
	 * @param Code_scene
	 */
	public void setCode_scene(String Code_scene) {
		setAttrVal("Code_scene", Code_scene);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_scene() {
		return ((String) getAttrVal("Name_scene"));
	}	
	/**
	 * 名称
	 * @param Name_scene
	 */
	public void setName_scene(String Name_scene) {
		setAttrVal("Name_scene", Name_scene);
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
		return "Id_pmscene";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_pri_pm_scene";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PriPmSceneDODesc.class);
	}
	
}