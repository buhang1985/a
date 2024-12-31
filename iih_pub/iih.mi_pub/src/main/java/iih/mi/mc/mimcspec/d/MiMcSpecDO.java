package iih.mi.mc.mimcspec.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mi.mc.mimcspec.d.desc.MiMcSpecDODesc;
import java.math.BigDecimal;

/**
 * 医保特殊病 DO数据 
 * 
 */
public class MiMcSpecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医保计划特殊病主键
	public static final String ID_HPSPEC= "Id_hpspec";
	//医保计划
	public static final String ID_HP= "Id_hp";
	//特殊病诊断id
	public static final String ID_DIDEF= "Id_didef";
	//特殊病诊断编码
	public static final String CODE_DI= "Code_di";
	//特殊病病种ID
	public static final String ID_DSDEF= "Id_dsdef";
	//特殊病病种编码
	public static final String CODE_DS= "Code_ds";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//医保计划名称
	public static final String NAME= "Name";
	//诊断编码
	public static final String CODEDI= "Codedi";
	//诊断名称
	public static final String NAMEDI= "Namedi";
	//病种编码
	public static final String CODEDS= "Codeds";
	//病种名称
	public static final String NAMEDS= "Nameds";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医保计划特殊病主键
	 * @return String
	 */
	public String getId_hpspec() {
		return ((String) getAttrVal("Id_hpspec"));
	}	
	/**
	 * 医保计划特殊病主键
	 * @param Id_hpspec
	 */
	public void setId_hpspec(String Id_hpspec) {
		setAttrVal("Id_hpspec", Id_hpspec);
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
	 * 特殊病诊断id
	 * @return String
	 */
	public String getId_didef() {
		return ((String) getAttrVal("Id_didef"));
	}	
	/**
	 * 特殊病诊断id
	 * @param Id_didef
	 */
	public void setId_didef(String Id_didef) {
		setAttrVal("Id_didef", Id_didef);
	}
	/**
	 * 特殊病诊断编码
	 * @return String
	 */
	public String getCode_di() {
		return ((String) getAttrVal("Code_di"));
	}	
	/**
	 * 特殊病诊断编码
	 * @param Code_di
	 */
	public void setCode_di(String Code_di) {
		setAttrVal("Code_di", Code_di);
	}
	/**
	 * 特殊病病种ID
	 * @return String
	 */
	public String getId_dsdef() {
		return ((String) getAttrVal("Id_dsdef"));
	}	
	/**
	 * 特殊病病种ID
	 * @param Id_dsdef
	 */
	public void setId_dsdef(String Id_dsdef) {
		setAttrVal("Id_dsdef", Id_dsdef);
	}
	/**
	 * 特殊病病种编码
	 * @return String
	 */
	public String getCode_ds() {
		return ((String) getAttrVal("Code_ds"));
	}	
	/**
	 * 特殊病病种编码
	 * @param Code_ds
	 */
	public void setCode_ds(String Code_ds) {
		setAttrVal("Code_ds", Code_ds);
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
	 * @return String
	 */
	public String getCreatedtime() {
		return ((String) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(String Createdtime) {
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
	 * @return String
	 */
	public String getModifiedtime() {
		return ((String) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(String Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 医保计划名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 医保计划名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getCodedi() {
		return ((String) getAttrVal("Codedi"));
	}	
	/**
	 * 诊断编码
	 * @param Codedi
	 */
	public void setCodedi(String Codedi) {
		setAttrVal("Codedi", Codedi);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getNamedi() {
		return ((String) getAttrVal("Namedi"));
	}	
	/**
	 * 诊断名称
	 * @param Namedi
	 */
	public void setNamedi(String Namedi) {
		setAttrVal("Namedi", Namedi);
	}
	/**
	 * 病种编码
	 * @return String
	 */
	public String getCodeds() {
		return ((String) getAttrVal("Codeds"));
	}	
	/**
	 * 病种编码
	 * @param Codeds
	 */
	public void setCodeds(String Codeds) {
		setAttrVal("Codeds", Codeds);
	}
	/**
	 * 病种名称
	 * @return String
	 */
	public String getNameds() {
		return ((String) getAttrVal("Nameds"));
	}	
	/**
	 * 病种名称
	 * @param Nameds
	 */
	public void setNameds(String Nameds) {
		setAttrVal("Nameds", Nameds);
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
		return "Id_hpspec";
	}
	
	@Override
	public String getTableName() {	  
		return "MI_MC_SPEC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MiMcSpecDODesc.class);
	}
	
}