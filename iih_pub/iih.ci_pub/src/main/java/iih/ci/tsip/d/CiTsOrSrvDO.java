package iih.ci.tsip.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.tsip.d.desc.CiTsOrSrvDODesc;
import java.math.BigDecimal;

/**
 * 治疗方案医嘱服务项目 DO数据 
 * 
 */
public class CiTsOrSrvDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医嘱服务项目ID
	public static final String ID_TSORSRV= "Id_tsorsrv";
	//治疗方案医嘱ID
	public static final String ID_TSOR= "Id_tsor";
	//患者
	public static final String ID_PAT= "Id_pat";
	//就诊
	public static final String ID_EN= "Id_en";
	//就诊类型编码
	public static final String SD_ENTP= "Sd_entp";
	//序号
	public static final String SORTNO= "Sortno";
	//服务类型编码
	public static final String SD_SRVTP= "Sd_srvtp";
	//服务项目
	public static final String ID_SRV= "Id_srv";
	//服务编码
	public static final String CODE_SRV= "Code_srv";
	//服务项目名称
	public static final String NAME= "Name";
	//服务项目分类
	public static final String ID_SRVCA= "Id_srvca";
	//数值_医疗单位
	public static final String QUAN_MEDU= "Quan_medu";
	//医疗单位
	public static final String ID_MEDU= "Id_medu";
	//服务总量
	public static final String QUAN_TOTAL_MEDU= "Quan_total_medu";
	//医嘱用法
	public static final String ID_ROUTE= "Id_route";
	//医嘱用法要求
	public static final String ID_ROUTEDES= "Id_routedes";
	//医嘱频次
	public static final String ID_FREQ= "Id_freq";
	//煎法要求
	public static final String ID_BOILDES= "Id_boildes";
	//服务备注
	public static final String SRV_DES= "Srv_des";
	//自定义服务标识
	public static final String FG_SELFSRV= "Fg_selfsrv";
	//服务项目开立机构	
	public static final String ID_ORG_SRV= "Id_org_srv";
	//服务项目开立科室	
	public static final String ID_DEP_SRV= "Id_dep_srv";
	//服务项目开立病区	
	public static final String ID_DEP_NUR_SRV= "Id_dep_nur_srv";
	//服务项目开立人员
	public static final String ID_EMP_SRV= "Id_emp_srv";
	//服务项目开立时间	
	public static final String DT_CREATE= "Dt_create";
	//医生医疗组	        
	public static final String ID_WG_OR= "Id_wg_or";
	//执行机构
	public static final String ID_ORG_MP= "Id_org_mp";
	//执行科室
	public static final String ID_DEP_MP= "Id_dep_mp";
	//执行科室来源模式	
	public static final String SD_DEP_MP= "Sd_dep_mp";
	//医嘱标识
	public static final String FG_OR= "Fg_or";
	//物品标识
	public static final String FG_MM= "Fg_mm";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//计量单位名称
	public static final String MEDU_NAME= "Medu_name";
	//用法要求
	public static final String ROUTEDES_NAME= "Routedes_name";
	//组织名称
	public static final String ORG_OR_NAME= "Org_or_name";
	//名称
	public static final String DEPT_OR_NAME= "Dept_or_name";
	//姓名
	public static final String EMP_PHY_NAME= "Emp_phy_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医嘱服务项目ID
	 * @return String
	 */
	public String getId_tsorsrv() {
		return ((String) getAttrVal("Id_tsorsrv"));
	}	
	/**
	 * 医嘱服务项目ID
	 * @param Id_tsorsrv
	 */
	public void setId_tsorsrv(String Id_tsorsrv) {
		setAttrVal("Id_tsorsrv", Id_tsorsrv);
	}
	/**
	 * 治疗方案医嘱ID
	 * @return String
	 */
	public String getId_tsor() {
		return ((String) getAttrVal("Id_tsor"));
	}	
	/**
	 * 治疗方案医嘱ID
	 * @param Id_tsor
	 */
	public void setId_tsor(String Id_tsor) {
		setAttrVal("Id_tsor", Id_tsor);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}	
	/**
	 * 就诊
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getSd_entp() {
		return ((String) getAttrVal("Sd_entp"));
	}	
	/**
	 * 就诊类型编码
	 * @param Sd_entp
	 */
	public void setSd_entp(String Sd_entp) {
		setAttrVal("Sd_entp", Sd_entp);
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
	 * 服务项目名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 服务项目名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 服务项目分类
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}	
	/**
	 * 服务项目分类
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	/**
	 * 数值_医疗单位
	 * @return FDouble
	 */
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}	
	/**
	 * 数值_医疗单位
	 * @param Quan_medu
	 */
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	/**
	 * 医疗单位
	 * @return String
	 */
	public String getId_medu() {
		return ((String) getAttrVal("Id_medu"));
	}	
	/**
	 * 医疗单位
	 * @param Id_medu
	 */
	public void setId_medu(String Id_medu) {
		setAttrVal("Id_medu", Id_medu);
	}
	/**
	 * 服务总量
	 * @return FDouble
	 */
	public FDouble getQuan_total_medu() {
		return ((FDouble) getAttrVal("Quan_total_medu"));
	}	
	/**
	 * 服务总量
	 * @param Quan_total_medu
	 */
	public void setQuan_total_medu(FDouble Quan_total_medu) {
		setAttrVal("Quan_total_medu", Quan_total_medu);
	}
	/**
	 * 医嘱用法
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}	
	/**
	 * 医嘱用法
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 医嘱用法要求
	 * @return String
	 */
	public String getId_routedes() {
		return ((String) getAttrVal("Id_routedes"));
	}	
	/**
	 * 医嘱用法要求
	 * @param Id_routedes
	 */
	public void setId_routedes(String Id_routedes) {
		setAttrVal("Id_routedes", Id_routedes);
	}
	/**
	 * 医嘱频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}	
	/**
	 * 医嘱频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 煎法要求
	 * @return String
	 */
	public String getId_boildes() {
		return ((String) getAttrVal("Id_boildes"));
	}	
	/**
	 * 煎法要求
	 * @param Id_boildes
	 */
	public void setId_boildes(String Id_boildes) {
		setAttrVal("Id_boildes", Id_boildes);
	}
	/**
	 * 服务备注
	 * @return String
	 */
	public String getSrv_des() {
		return ((String) getAttrVal("Srv_des"));
	}	
	/**
	 * 服务备注
	 * @param Srv_des
	 */
	public void setSrv_des(String Srv_des) {
		setAttrVal("Srv_des", Srv_des);
	}
	/**
	 * 自定义服务标识
	 * @return FBoolean
	 */
	public FBoolean getFg_selfsrv() {
		return ((FBoolean) getAttrVal("Fg_selfsrv"));
	}	
	/**
	 * 自定义服务标识
	 * @param Fg_selfsrv
	 */
	public void setFg_selfsrv(FBoolean Fg_selfsrv) {
		setAttrVal("Fg_selfsrv", Fg_selfsrv);
	}
	/**
	 * 服务项目开立机构	
	 * @return String
	 */
	public String getId_org_srv() {
		return ((String) getAttrVal("Id_org_srv"));
	}	
	/**
	 * 服务项目开立机构	
	 * @param Id_org_srv
	 */
	public void setId_org_srv(String Id_org_srv) {
		setAttrVal("Id_org_srv", Id_org_srv);
	}
	/**
	 * 服务项目开立科室	
	 * @return String
	 */
	public String getId_dep_srv() {
		return ((String) getAttrVal("Id_dep_srv"));
	}	
	/**
	 * 服务项目开立科室	
	 * @param Id_dep_srv
	 */
	public void setId_dep_srv(String Id_dep_srv) {
		setAttrVal("Id_dep_srv", Id_dep_srv);
	}
	/**
	 * 服务项目开立病区	
	 * @return String
	 */
	public String getId_dep_nur_srv() {
		return ((String) getAttrVal("Id_dep_nur_srv"));
	}	
	/**
	 * 服务项目开立病区	
	 * @param Id_dep_nur_srv
	 */
	public void setId_dep_nur_srv(String Id_dep_nur_srv) {
		setAttrVal("Id_dep_nur_srv", Id_dep_nur_srv);
	}
	/**
	 * 服务项目开立人员
	 * @return String
	 */
	public String getId_emp_srv() {
		return ((String) getAttrVal("Id_emp_srv"));
	}	
	/**
	 * 服务项目开立人员
	 * @param Id_emp_srv
	 */
	public void setId_emp_srv(String Id_emp_srv) {
		setAttrVal("Id_emp_srv", Id_emp_srv);
	}
	/**
	 * 服务项目开立时间	
	 * @return FDateTime
	 */
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}	
	/**
	 * 服务项目开立时间	
	 * @param Dt_create
	 */
	public void setDt_create(FDateTime Dt_create) {
		setAttrVal("Dt_create", Dt_create);
	}
	/**
	 * 医生医疗组	        
	 * @return String
	 */
	public String getId_wg_or() {
		return ((String) getAttrVal("Id_wg_or"));
	}	
	/**
	 * 医生医疗组	        
	 * @param Id_wg_or
	 */
	public void setId_wg_or(String Id_wg_or) {
		setAttrVal("Id_wg_or", Id_wg_or);
	}
	/**
	 * 执行机构
	 * @return String
	 */
	public String getId_org_mp() {
		return ((String) getAttrVal("Id_org_mp"));
	}	
	/**
	 * 执行机构
	 * @param Id_org_mp
	 */
	public void setId_org_mp(String Id_org_mp) {
		setAttrVal("Id_org_mp", Id_org_mp);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}	
	/**
	 * 执行科室
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 执行科室来源模式	
	 * @return String
	 */
	public String getSd_dep_mp() {
		return ((String) getAttrVal("Sd_dep_mp"));
	}	
	/**
	 * 执行科室来源模式	
	 * @param Sd_dep_mp
	 */
	public void setSd_dep_mp(String Sd_dep_mp) {
		setAttrVal("Sd_dep_mp", Sd_dep_mp);
	}
	/**
	 * 医嘱标识
	 * @return FBoolean
	 */
	public FBoolean getFg_or() {
		return ((FBoolean) getAttrVal("Fg_or"));
	}	
	/**
	 * 医嘱标识
	 * @param Fg_or
	 */
	public void setFg_or(FBoolean Fg_or) {
		setAttrVal("Fg_or", Fg_or);
	}
	/**
	 * 物品标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mm() {
		return ((FBoolean) getAttrVal("Fg_mm"));
	}	
	/**
	 * 物品标识
	 * @param Fg_mm
	 */
	public void setFg_mm(FBoolean Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
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
	 * 计量单位名称
	 * @return String
	 */
	public String getMedu_name() {
		return ((String) getAttrVal("Medu_name"));
	}	
	/**
	 * 计量单位名称
	 * @param Medu_name
	 */
	public void setMedu_name(String Medu_name) {
		setAttrVal("Medu_name", Medu_name);
	}
	/**
	 * 用法要求
	 * @return String
	 */
	public String getRoutedes_name() {
		return ((String) getAttrVal("Routedes_name"));
	}	
	/**
	 * 用法要求
	 * @param Routedes_name
	 */
	public void setRoutedes_name(String Routedes_name) {
		setAttrVal("Routedes_name", Routedes_name);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getOrg_or_name() {
		return ((String) getAttrVal("Org_or_name"));
	}	
	/**
	 * 组织名称
	 * @param Org_or_name
	 */
	public void setOrg_or_name(String Org_or_name) {
		setAttrVal("Org_or_name", Org_or_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDept_or_name() {
		return ((String) getAttrVal("Dept_or_name"));
	}	
	/**
	 * 名称
	 * @param Dept_or_name
	 */
	public void setDept_or_name(String Dept_or_name) {
		setAttrVal("Dept_or_name", Dept_or_name);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getEmp_phy_name() {
		return ((String) getAttrVal("Emp_phy_name"));
	}	
	/**
	 * 姓名
	 * @param Emp_phy_name
	 */
	public void setEmp_phy_name(String Emp_phy_name) {
		setAttrVal("Emp_phy_name", Emp_phy_name);
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
		return "Id_tsorsrv";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_ts_or_srv";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiTsOrSrvDODesc.class);
	}
	
}