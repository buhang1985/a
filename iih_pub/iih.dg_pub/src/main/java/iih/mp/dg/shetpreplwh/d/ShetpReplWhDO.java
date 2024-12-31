package iih.mp.dg.shetpreplwh.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.dg.shetpreplwh.d.desc.ShetpReplWhDODesc;
import java.math.BigDecimal;

/**
 * 首日代替药单药房配置 DO数据 
 * 
 */
public class ShetpReplWhDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//首日代替药单药房主键
	public static final String ID_DGSHETPREPLWH= "Id_dgshetpreplwh";
	//集团
	public static final String ID_GROUP= "Id_group";
	//组织
	public static final String ID_ORG= "Id_org";
	//代替药单
	public static final String ID_SHETP_REPL= "Id_shetp_repl";
	//病区
	public static final String ID_DEP= "Id_dep";
	//药房
	public static final String ID_DEP_WH= "Id_dep_wh";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//替代药单名称
	public static final String NAME_SHETP_REPL= "Name_shetp_repl";
	//替代药单编码
	public static final String CODE_SHETP_REPL= "Code_shetp_repl";
	//病区编码
	public static final String CODE_DEP= "Code_dep";
	//病区名称
	public static final String NAME_DEP= "Name_dep";
	//药房编码
	public static final String CODE_DEPWH= "Code_depwh";
	//药房名称
	public static final String NAME_DEPWH= "Name_depwh";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 首日代替药单药房主键
	 * @return String
	 */
	public String getId_dgshetpreplwh() {
		return ((String) getAttrVal("Id_dgshetpreplwh"));
	}	
	/**
	 * 首日代替药单药房主键
	 * @param Id_dgshetpreplwh
	 */
	public void setId_dgshetpreplwh(String Id_dgshetpreplwh) {
		setAttrVal("Id_dgshetpreplwh", Id_dgshetpreplwh);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_group() {
		return ((String) getAttrVal("Id_group"));
	}	
	/**
	 * 集团
	 * @param Id_group
	 */
	public void setId_group(String Id_group) {
		setAttrVal("Id_group", Id_group);
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
	 * 代替药单
	 * @return String
	 */
	public String getId_shetp_repl() {
		return ((String) getAttrVal("Id_shetp_repl"));
	}	
	/**
	 * 代替药单
	 * @param Id_shetp_repl
	 */
	public void setId_shetp_repl(String Id_shetp_repl) {
		setAttrVal("Id_shetp_repl", Id_shetp_repl);
	}
	/**
	 * 病区
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 病区
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 药房
	 * @return String
	 */
	public String getId_dep_wh() {
		return ((String) getAttrVal("Id_dep_wh"));
	}	
	/**
	 * 药房
	 * @param Id_dep_wh
	 */
	public void setId_dep_wh(String Id_dep_wh) {
		setAttrVal("Id_dep_wh", Id_dep_wh);
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
	 * 替代药单名称
	 * @return String
	 */
	public String getName_shetp_repl() {
		return ((String) getAttrVal("Name_shetp_repl"));
	}	
	/**
	 * 替代药单名称
	 * @param Name_shetp_repl
	 */
	public void setName_shetp_repl(String Name_shetp_repl) {
		setAttrVal("Name_shetp_repl", Name_shetp_repl);
	}
	/**
	 * 替代药单编码
	 * @return String
	 */
	public String getCode_shetp_repl() {
		return ((String) getAttrVal("Code_shetp_repl"));
	}	
	/**
	 * 替代药单编码
	 * @param Code_shetp_repl
	 */
	public void setCode_shetp_repl(String Code_shetp_repl) {
		setAttrVal("Code_shetp_repl", Code_shetp_repl);
	}
	/**
	 * 病区编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	/**
	 * 病区编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 病区名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 病区名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 药房编码
	 * @return String
	 */
	public String getCode_depwh() {
		return ((String) getAttrVal("Code_depwh"));
	}	
	/**
	 * 药房编码
	 * @param Code_depwh
	 */
	public void setCode_depwh(String Code_depwh) {
		setAttrVal("Code_depwh", Code_depwh);
	}
	/**
	 * 药房名称
	 * @return String
	 */
	public String getName_depwh() {
		return ((String) getAttrVal("Name_depwh"));
	}	
	/**
	 * 药房名称
	 * @param Name_depwh
	 */
	public void setName_depwh(String Name_depwh) {
		setAttrVal("Name_depwh", Name_depwh);
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
		return "Id_dgshetpreplwh";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_dg_shetp_replwh";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ShetpReplWhDODesc.class);
	}
	
}