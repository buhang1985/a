package iih.bd.fc.orpltpmatch.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.fc.orpltpmatch.d.desc.OrpltpMatchDODesc;
import java.math.BigDecimal;

/**
 * 医嘱闭环匹配 DO数据 
 * 
 */
public class OrpltpMatchDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医嘱闭环参数ID 
	public static final String ID_ORPLTP_MATCH= "Id_orpltp_match";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//医嘱闭环
	public static final String ID_ORPLTP= "Id_orpltp";
	//就诊类型
	public static final String ID_ENTP= "Id_entp";
	//就诊类型编码
	public static final String CODE_ENTP= "Code_entp";
	//服务类型
	public static final String ID_SRVTP= "Id_srvtp";
	//服务类型编码
	public static final String SD_SRVTP= "Sd_srvtp";
	//服务项目
	public static final String ID_SRV= "Id_srv";
	//药品执行用法ID
	public static final String ID_MP_ROUTE= "Id_mp_route";
	//药品执行用法编码
	public static final String SD_MP_ROUTE= "Sd_mp_route";
	//皮试类型
	public static final String EU_SKINTEST= "Eu_skintest";
	//在院执行标记
	public static final String EU_MP_IN= "Eu_mp_in";
	//出院带药标识
	public static final String EU_PRES_OUTP= "Eu_pres_outp";
	//退药标识
	public static final String EU_FG_BACK= "Eu_fg_back";
	//在院整领标识
	public static final String EU_WHOLEPACK= "Eu_wholepack";
	//医疗服务
	public static final String EU_SRV= "Eu_srv";
	//开单部门关系ID
	public static final String ID_DEP_REL= "Id_dep_rel";
	//开单部门关系编码
	public static final String SD_DEP_REL= "Sd_dep_rel";
	//开单科室
	public static final String EU_DEP_OR= "Eu_dep_or";
	//就诊科室限制
	public static final String EU_DEP_PHY= "Eu_dep_phy";
	//护理单元限制
	public static final String EU_DEP_NUR= "Eu_dep_nur";
	//领药方式
	public static final String EU_DDM= "Eu_ddm";
	//闭环描述
	public static final String ORPLTP_DES= "Orpltp_des";
	//医嘱匹配权重信息
	public static final String ORPLTP_POWER= "Orpltp_power";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//医嘱执行闭环类型编码
	public static final String CODE_ORPLTP= "Code_orpltp";
	//医嘱执行闭环类型名称
	public static final String NAME_ORPLTP= "Name_orpltp";
	//就诊类型名称
	public static final String NAME_ENTP= "Name_entp";
	//名称
	public static final String NAME_SRVTP= "Name_srvtp";
	//服务编码
	public static final String CODE_SRV= "Code_srv";
	//服务名称
	public static final String NAME_SRV= "Name_srv";
	//名称
	public static final String NAME_MPROUTE= "Name_mproute";
	//扩展字段1
	public static final String CODE_PARAM= "Code_param";
	//开单部门关系名称
	public static final String NAME_RELDEP= "Name_reldep";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医嘱闭环参数ID 
	 * @return String
	 */
	public String getId_orpltp_match() {
		return ((String) getAttrVal("Id_orpltp_match"));
	}	
	/**
	 * 医嘱闭环参数ID 
	 * @param Id_orpltp_match
	 */
	public void setId_orpltp_match(String Id_orpltp_match) {
		setAttrVal("Id_orpltp_match", Id_orpltp_match);
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
	 * 医嘱闭环
	 * @return String
	 */
	public String getId_orpltp() {
		return ((String) getAttrVal("Id_orpltp"));
	}	
	/**
	 * 医嘱闭环
	 * @param Id_orpltp
	 */
	public void setId_orpltp(String Id_orpltp) {
		setAttrVal("Id_orpltp", Id_orpltp);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	/**
	 * 就诊类型
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	/**
	 * 服务类型
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 服务类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	/**
	 * 服务类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 服务项目
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 服务项目
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 药品执行用法ID
	 * @return String
	 */
	public String getId_mp_route() {
		return ((String) getAttrVal("Id_mp_route"));
	}	
	/**
	 * 药品执行用法ID
	 * @param Id_mp_route
	 */
	public void setId_mp_route(String Id_mp_route) {
		setAttrVal("Id_mp_route", Id_mp_route);
	}
	/**
	 * 药品执行用法编码
	 * @return String
	 */
	public String getSd_mp_route() {
		return ((String) getAttrVal("Sd_mp_route"));
	}	
	/**
	 * 药品执行用法编码
	 * @param Sd_mp_route
	 */
	public void setSd_mp_route(String Sd_mp_route) {
		setAttrVal("Sd_mp_route", Sd_mp_route);
	}
	/**
	 * 皮试类型
	 * @return Integer
	 */
	public Integer getEu_skintest() {
		return ((Integer) getAttrVal("Eu_skintest"));
	}	
	/**
	 * 皮试类型
	 * @param Eu_skintest
	 */
	public void setEu_skintest(Integer Eu_skintest) {
		setAttrVal("Eu_skintest", Eu_skintest);
	}
	/**
	 * 在院执行标记
	 * @return Integer
	 */
	public Integer getEu_mp_in() {
		return ((Integer) getAttrVal("Eu_mp_in"));
	}	
	/**
	 * 在院执行标记
	 * @param Eu_mp_in
	 */
	public void setEu_mp_in(Integer Eu_mp_in) {
		setAttrVal("Eu_mp_in", Eu_mp_in);
	}
	/**
	 * 出院带药标识
	 * @return Integer
	 */
	public Integer getEu_pres_outp() {
		return ((Integer) getAttrVal("Eu_pres_outp"));
	}	
	/**
	 * 出院带药标识
	 * @param Eu_pres_outp
	 */
	public void setEu_pres_outp(Integer Eu_pres_outp) {
		setAttrVal("Eu_pres_outp", Eu_pres_outp);
	}
	/**
	 * 退药标识
	 * @return Integer
	 */
	public Integer getEu_fg_back() {
		return ((Integer) getAttrVal("Eu_fg_back"));
	}	
	/**
	 * 退药标识
	 * @param Eu_fg_back
	 */
	public void setEu_fg_back(Integer Eu_fg_back) {
		setAttrVal("Eu_fg_back", Eu_fg_back);
	}
	/**
	 * 在院整领标识
	 * @return Integer
	 */
	public Integer getEu_wholepack() {
		return ((Integer) getAttrVal("Eu_wholepack"));
	}	
	/**
	 * 在院整领标识
	 * @param Eu_wholepack
	 */
	public void setEu_wholepack(Integer Eu_wholepack) {
		setAttrVal("Eu_wholepack", Eu_wholepack);
	}
	/**
	 * 医疗服务
	 * @return Integer
	 */
	public Integer getEu_srv() {
		return ((Integer) getAttrVal("Eu_srv"));
	}	
	/**
	 * 医疗服务
	 * @param Eu_srv
	 */
	public void setEu_srv(Integer Eu_srv) {
		setAttrVal("Eu_srv", Eu_srv);
	}
	/**
	 * 开单部门关系ID
	 * @return String
	 */
	public String getId_dep_rel() {
		return ((String) getAttrVal("Id_dep_rel"));
	}	
	/**
	 * 开单部门关系ID
	 * @param Id_dep_rel
	 */
	public void setId_dep_rel(String Id_dep_rel) {
		setAttrVal("Id_dep_rel", Id_dep_rel);
	}
	/**
	 * 开单部门关系编码
	 * @return String
	 */
	public String getSd_dep_rel() {
		return ((String) getAttrVal("Sd_dep_rel"));
	}	
	/**
	 * 开单部门关系编码
	 * @param Sd_dep_rel
	 */
	public void setSd_dep_rel(String Sd_dep_rel) {
		setAttrVal("Sd_dep_rel", Sd_dep_rel);
	}
	/**
	 * 开单科室
	 * @return Integer
	 */
	public Integer getEu_dep_or() {
		return ((Integer) getAttrVal("Eu_dep_or"));
	}	
	/**
	 * 开单科室
	 * @param Eu_dep_or
	 */
	public void setEu_dep_or(Integer Eu_dep_or) {
		setAttrVal("Eu_dep_or", Eu_dep_or);
	}
	/**
	 * 就诊科室限制
	 * @return Integer
	 */
	public Integer getEu_dep_phy() {
		return ((Integer) getAttrVal("Eu_dep_phy"));
	}	
	/**
	 * 就诊科室限制
	 * @param Eu_dep_phy
	 */
	public void setEu_dep_phy(Integer Eu_dep_phy) {
		setAttrVal("Eu_dep_phy", Eu_dep_phy);
	}
	/**
	 * 护理单元限制
	 * @return Integer
	 */
	public Integer getEu_dep_nur() {
		return ((Integer) getAttrVal("Eu_dep_nur"));
	}	
	/**
	 * 护理单元限制
	 * @param Eu_dep_nur
	 */
	public void setEu_dep_nur(Integer Eu_dep_nur) {
		setAttrVal("Eu_dep_nur", Eu_dep_nur);
	}
	/**
	 * 领药方式
	 * @return Integer
	 */
	public Integer getEu_ddm() {
		return ((Integer) getAttrVal("Eu_ddm"));
	}	
	/**
	 * 领药方式
	 * @param Eu_ddm
	 */
	public void setEu_ddm(Integer Eu_ddm) {
		setAttrVal("Eu_ddm", Eu_ddm);
	}
	/**
	 * 闭环描述
	 * @return String
	 */
	public String getOrpltp_des() {
		return ((String) getAttrVal("Orpltp_des"));
	}	
	/**
	 * 闭环描述
	 * @param Orpltp_des
	 */
	public void setOrpltp_des(String Orpltp_des) {
		setAttrVal("Orpltp_des", Orpltp_des);
	}
	/**
	 * 医嘱匹配权重信息
	 * @return Integer
	 */
	public Integer getOrpltp_power() {
		return ((Integer) getAttrVal("Orpltp_power"));
	}	
	/**
	 * 医嘱匹配权重信息
	 * @param Orpltp_power
	 */
	public void setOrpltp_power(Integer Orpltp_power) {
		setAttrVal("Orpltp_power", Orpltp_power);
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
	 * 医嘱执行闭环类型编码
	 * @return String
	 */
	public String getCode_orpltp() {
		return ((String) getAttrVal("Code_orpltp"));
	}	
	/**
	 * 医嘱执行闭环类型编码
	 * @param Code_orpltp
	 */
	public void setCode_orpltp(String Code_orpltp) {
		setAttrVal("Code_orpltp", Code_orpltp);
	}
	/**
	 * 医嘱执行闭环类型名称
	 * @return String
	 */
	public String getName_orpltp() {
		return ((String) getAttrVal("Name_orpltp"));
	}	
	/**
	 * 医嘱执行闭环类型名称
	 * @param Name_orpltp
	 */
	public void setName_orpltp(String Name_orpltp) {
		setAttrVal("Name_orpltp", Name_orpltp);
	}
	/**
	 * 就诊类型名称
	 * @return String
	 */
	public String getName_entp() {
		return ((String) getAttrVal("Name_entp"));
	}	
	/**
	 * 就诊类型名称
	 * @param Name_entp
	 */
	public void setName_entp(String Name_entp) {
		setAttrVal("Name_entp", Name_entp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_srvtp() {
		return ((String) getAttrVal("Name_srvtp"));
	}	
	/**
	 * 名称
	 * @param Name_srvtp
	 */
	public void setName_srvtp(String Name_srvtp) {
		setAttrVal("Name_srvtp", Name_srvtp);
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
	 * 名称
	 * @return String
	 */
	public String getName_mproute() {
		return ((String) getAttrVal("Name_mproute"));
	}	
	/**
	 * 名称
	 * @param Name_mproute
	 */
	public void setName_mproute(String Name_mproute) {
		setAttrVal("Name_mproute", Name_mproute);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getCode_param() {
		return ((String) getAttrVal("Code_param"));
	}	
	/**
	 * 扩展字段1
	 * @param Code_param
	 */
	public void setCode_param(String Code_param) {
		setAttrVal("Code_param", Code_param);
	}
	/**
	 * 开单部门关系名称
	 * @return String
	 */
	public String getName_reldep() {
		return ((String) getAttrVal("Name_reldep"));
	}	
	/**
	 * 开单部门关系名称
	 * @param Name_reldep
	 */
	public void setName_reldep(String Name_reldep) {
		setAttrVal("Name_reldep", Name_reldep);
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
		return "Id_orpltp_match";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_orpltp_match";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrpltpMatchDODesc.class);
	}
	
}