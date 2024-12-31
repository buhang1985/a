package iih.bd.fc.orpltpmatch.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.fc.orpltpmatch.d.desc.OrpltpMatchAttrDODesc;
import java.math.BigDecimal;

/**
 * 医嘱闭环匹配属性 DO数据 
 * 
 */
public class OrpltpMatchAttrDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//闭环匹配属性
	public static final String ID_ORPLTP_MATCH_ATTR= "Id_orpltp_match_attr";
	//闭环匹配
	public static final String ID_ORPLTP_MATCH= "Id_orpltp_match";
	//属性类型
	public static final String EU_ATTR= "Eu_attr";
	//医疗服务ID
	public static final String ID_SRV= "Id_srv";
	//部门ID
	public static final String ID_DEP= "Id_dep";
	//领药方式
	public static final String ID_UDIDDM= "Id_udiddm";
	//就诊科室ID
	public static final String ID_DEP_PHY= "Id_dep_phy";
	//护理单元ID
	public static final String ID_DEP_NUR= "Id_dep_nur";
	//编码
	public static final String CODE= "Code";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//服务名称
	public static final String NAME_SRV= "Name_srv";
	//部门名称
	public static final String NAME_DEP= "Name_dep";
	//领药方式名称
	public static final String NAME_DUIDDM= "Name_duiddm";
	//领药方式编码
	public static final String CODE_DUIDDM= "Code_duiddm";
	//就诊科室名称
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	//护理单元名称
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 闭环匹配属性
	 * @return String
	 */
	public String getId_orpltp_match_attr() {
		return ((String) getAttrVal("Id_orpltp_match_attr"));
	}	
	/**
	 * 闭环匹配属性
	 * @param Id_orpltp_match_attr
	 */
	public void setId_orpltp_match_attr(String Id_orpltp_match_attr) {
		setAttrVal("Id_orpltp_match_attr", Id_orpltp_match_attr);
	}
	/**
	 * 闭环匹配
	 * @return String
	 */
	public String getId_orpltp_match() {
		return ((String) getAttrVal("Id_orpltp_match"));
	}	
	/**
	 * 闭环匹配
	 * @param Id_orpltp_match
	 */
	public void setId_orpltp_match(String Id_orpltp_match) {
		setAttrVal("Id_orpltp_match", Id_orpltp_match);
	}
	/**
	 * 属性类型
	 * @return Integer
	 */
	public Integer getEu_attr() {
		return ((Integer) getAttrVal("Eu_attr"));
	}	
	/**
	 * 属性类型
	 * @param Eu_attr
	 */
	public void setEu_attr(Integer Eu_attr) {
		setAttrVal("Eu_attr", Eu_attr);
	}
	/**
	 * 医疗服务ID
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 医疗服务ID
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 部门ID
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 部门ID
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 领药方式
	 * @return String
	 */
	public String getId_udiddm() {
		return ((String) getAttrVal("Id_udiddm"));
	}	
	/**
	 * 领药方式
	 * @param Id_udiddm
	 */
	public void setId_udiddm(String Id_udiddm) {
		setAttrVal("Id_udiddm", Id_udiddm);
	}
	/**
	 * 就诊科室ID
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}	
	/**
	 * 就诊科室ID
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 护理单元ID
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	/**
	 * 护理单元ID
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
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
	 * 部门名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 部门名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 领药方式名称
	 * @return String
	 */
	public String getName_duiddm() {
		return ((String) getAttrVal("Name_duiddm"));
	}	
	/**
	 * 领药方式名称
	 * @param Name_duiddm
	 */
	public void setName_duiddm(String Name_duiddm) {
		setAttrVal("Name_duiddm", Name_duiddm);
	}
	/**
	 * 领药方式编码
	 * @return String
	 */
	public String getCode_duiddm() {
		return ((String) getAttrVal("Code_duiddm"));
	}	
	/**
	 * 领药方式编码
	 * @param Code_duiddm
	 */
	public void setCode_duiddm(String Code_duiddm) {
		setAttrVal("Code_duiddm", Code_duiddm);
	}
	/**
	 * 就诊科室名称
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}	
	/**
	 * 就诊科室名称
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	/**
	 * 护理单元名称
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	/**
	 * 护理单元名称
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
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
		return "Id_orpltp_match_attr";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_orpltp_match_attr";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrpltpMatchAttrDODesc.class);
	}
	
}