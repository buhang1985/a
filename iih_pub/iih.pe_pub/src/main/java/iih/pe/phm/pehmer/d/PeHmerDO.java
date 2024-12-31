package iih.pe.phm.pehmer.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.pehmer.d.desc.PeHmerDODesc;
import java.math.BigDecimal;

/**
 * 体检健康管理师 DO数据 
 * 
 */
public class PeHmerDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检健康管理师主键标识
	public static final String ID_PEHMER= "Id_pehmer";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//编码
	public static final String SD_USER= "Sd_user";
	//健康管理师ID
	public static final String ID_USER= "Id_user";
	//上午接待人数
	public static final String NOVAM= "Novam";
	//下午接待人数
	public static final String NOVPM= "Novpm";
	//可用标识
	public static final String FG_ACTIVE= "Fg_active";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//健康管理师编码
	public static final String CODE= "Code";
	//健康管理师姓名
	public static final String NAME= "Name";
	//用户编码
	public static final String CODE_HMER= "Code_hmer";
	//用户名称
	public static final String NAME_HMER= "Name_hmer";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检健康管理师主键标识
	 * @return String
	 */
	public String getId_pehmer() {
		return ((String) getAttrVal("Id_pehmer"));
	}	
	/**
	 * 体检健康管理师主键标识
	 * @param Id_pehmer
	 */
	public void setId_pehmer(String Id_pehmer) {
		setAttrVal("Id_pehmer", Id_pehmer);
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
	 * 编码
	 * @return String
	 */
	public String getSd_user() {
		return ((String) getAttrVal("Sd_user"));
	}	
	/**
	 * 编码
	 * @param Sd_user
	 */
	public void setSd_user(String Sd_user) {
		setAttrVal("Sd_user", Sd_user);
	}
	/**
	 * 健康管理师ID
	 * @return String
	 */
	public String getId_user() {
		return ((String) getAttrVal("Id_user"));
	}	
	/**
	 * 健康管理师ID
	 * @param Id_user
	 */
	public void setId_user(String Id_user) {
		setAttrVal("Id_user", Id_user);
	}
	/**
	 * 上午接待人数
	 * @return Integer
	 */
	public Integer getNovam() {
		return ((Integer) getAttrVal("Novam"));
	}	
	/**
	 * 上午接待人数
	 * @param Novam
	 */
	public void setNovam(Integer Novam) {
		setAttrVal("Novam", Novam);
	}
	/**
	 * 下午接待人数
	 * @return Integer
	 */
	public Integer getNovpm() {
		return ((Integer) getAttrVal("Novpm"));
	}	
	/**
	 * 下午接待人数
	 * @param Novpm
	 */
	public void setNovpm(Integer Novpm) {
		setAttrVal("Novpm", Novpm);
	}
	/**
	 * 可用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 可用标识
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
	 * 健康管理师编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 健康管理师编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 健康管理师姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 健康管理师姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getCode_hmer() {
		return ((String) getAttrVal("Code_hmer"));
	}	
	/**
	 * 用户编码
	 * @param Code_hmer
	 */
	public void setCode_hmer(String Code_hmer) {
		setAttrVal("Code_hmer", Code_hmer);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getName_hmer() {
		return ((String) getAttrVal("Name_hmer"));
	}	
	/**
	 * 用户名称
	 * @param Name_hmer
	 */
	public void setName_hmer(String Name_hmer) {
		setAttrVal("Name_hmer", Name_hmer);
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
		return "Id_pehmer";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_hmer";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeHmerDODesc.class);
	}
	
}