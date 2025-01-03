package iih.bd.pp.priusg.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.priusg.d.desc.PriUsgDODesc;
import java.math.BigDecimal;

/**
 * 用法下费用项目对照 DO数据 
 * 
 */
public class PriUsgDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医嘱用法价格主键
	public static final String ID_PRIUSG= "Id_priusg";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//用法类型
	public static final String ID_ROUTE= "Id_route";
	//序号
	public static final String SORTNO= "Sortno";
	//服务项目
	public static final String ID_SRV= "Id_srv";
	//策略范围
	public static final String EU_SCOPE= "Eu_scope";
	//全院对应组织
	public static final String ID_ORG_SCOPE= "Id_org_scope";
	//病区
	public static final String ID_DEP_NUR= "Id_dep_nur";
	//医学单位
	public static final String ID_UNIT= "Id_unit";
	//数量
	public static final String QUAN_MEDU= "Quan_medu";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//参考价格
	public static final String PRI_STD= "Pri_std";
	//关联服务执行流向模式
	public static final String ID_MPDEPCALMD_USG= "Id_mpdepcalmd_usg";
	//关联服务执行流向模式编码
	public static final String SD_MPDEPCALMD_USG= "Sd_mpdepcalmd_usg";
	//服务名称
	public static final String NAME_SRV= "Name_srv";
	//部门名称
	public static final String DEP_NAME= "Dep_name";
	//计量单位名称
	public static final String NAME_UNIT= "Name_unit";
	//关联服务执行流向模式名称
	public static final String NAME_MPDEPCALMD_USG= "Name_mpdepcalmd_usg";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医嘱用法价格主键
	 * @return String
	 */
	public String getId_priusg() {
		return ((String) getAttrVal("Id_priusg"));
	}	
	/**
	 * 医嘱用法价格主键
	 * @param Id_priusg
	 */
	public void setId_priusg(String Id_priusg) {
		setAttrVal("Id_priusg", Id_priusg);
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
	 * 用法类型
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}	
	/**
	 * 用法类型
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
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
	 * 策略范围
	 * @return Integer
	 */
	public Integer getEu_scope() {
		return ((Integer) getAttrVal("Eu_scope"));
	}	
	/**
	 * 策略范围
	 * @param Eu_scope
	 */
	public void setEu_scope(Integer Eu_scope) {
		setAttrVal("Eu_scope", Eu_scope);
	}
	/**
	 * 全院对应组织
	 * @return String
	 */
	public String getId_org_scope() {
		return ((String) getAttrVal("Id_org_scope"));
	}	
	/**
	 * 全院对应组织
	 * @param Id_org_scope
	 */
	public void setId_org_scope(String Id_org_scope) {
		setAttrVal("Id_org_scope", Id_org_scope);
	}
	/**
	 * 病区
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	/**
	 * 病区
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 医学单位
	 * @return String
	 */
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}	
	/**
	 * 医学单位
	 * @param Id_unit
	 */
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	/**
	 * 数量
	 * @return FDouble
	 */
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}	
	/**
	 * 数量
	 * @param Quan_medu
	 */
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
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
	 * 参考价格
	 * @return FDouble
	 */
	public FDouble getPri_std() {
		return ((FDouble) getAttrVal("Pri_std"));
	}	
	/**
	 * 参考价格
	 * @param Pri_std
	 */
	public void setPri_std(FDouble Pri_std) {
		setAttrVal("Pri_std", Pri_std);
	}
	/**
	 * 关联服务执行流向模式
	 * @return String
	 */
	public String getId_mpdepcalmd_usg() {
		return ((String) getAttrVal("Id_mpdepcalmd_usg"));
	}	
	/**
	 * 关联服务执行流向模式
	 * @param Id_mpdepcalmd_usg
	 */
	public void setId_mpdepcalmd_usg(String Id_mpdepcalmd_usg) {
		setAttrVal("Id_mpdepcalmd_usg", Id_mpdepcalmd_usg);
	}
	/**
	 * 关联服务执行流向模式编码
	 * @return String
	 */
	public String getSd_mpdepcalmd_usg() {
		return ((String) getAttrVal("Sd_mpdepcalmd_usg"));
	}	
	/**
	 * 关联服务执行流向模式编码
	 * @param Sd_mpdepcalmd_usg
	 */
	public void setSd_mpdepcalmd_usg(String Sd_mpdepcalmd_usg) {
		setAttrVal("Sd_mpdepcalmd_usg", Sd_mpdepcalmd_usg);
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
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	/**
	 * 部门名称
	 * @param Dep_name
	 */
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
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
	/**
	 * 关联服务执行流向模式名称
	 * @return String
	 */
	public String getName_mpdepcalmd_usg() {
		return ((String) getAttrVal("Name_mpdepcalmd_usg"));
	}	
	/**
	 * 关联服务执行流向模式名称
	 * @param Name_mpdepcalmd_usg
	 */
	public void setName_mpdepcalmd_usg(String Name_mpdepcalmd_usg) {
		setAttrVal("Name_mpdepcalmd_usg", Name_mpdepcalmd_usg);
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
		return "Id_priusg";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_pri_usg";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PriUsgDODesc.class);
	}
	
}