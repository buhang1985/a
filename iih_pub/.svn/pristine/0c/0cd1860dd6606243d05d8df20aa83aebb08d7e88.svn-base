package iih.bd.srv.medsrv.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.medsrv.d.desc.MedSrvSetItemDODesc;
import java.math.BigDecimal;

/**
 * 医疗服务套项目定义 DO数据 
 * 
 */
public class MedSrvSetItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//服务套项目主键标识
	public static final String ID_SRVSETDEF= "Id_srvsetdef";
	//服务
	public static final String ID_SRV_ITM= "Id_srv_itm";
	//序号
	public static final String SORTNO= "Sortno";
	//所属服务套
	public static final String ID_SRV= "Id_srv";
	//描述
	public static final String DES= "Des";
	//成员角色
	public static final String ID_SRVSETROLE= "Id_srvsetrole";
	//成员角色编码
	public static final String SD_SRVSETROLE= "Sd_srvsetrole";
	//医学单位数值_默认
	public static final String QUAN_MEDU= "Quan_medu";
	//医学单位
	public static final String ID_MEDU= "Id_medu";
	//频次_默认（废弃不用了）
	public static final String ID_FREQ= "Id_freq";
	//用法_默认
	public static final String ID_ROUTE= "Id_route";
	//用法要求_默认
	public static final String ID_ROUTEDES= "Id_routedes";
	//煎法_默认
	public static final String ID_BOIL= "Id_boil";
	//煎法要求_默认
	public static final String ID_BOILDES= "Id_boildes";
	//临床标识
	public static final String FG_CLINICAL= "Fg_clinical";
	//临床价格计算标识
	public static final String FG_CLINICAL_BL= "Fg_clinical_bl";
	//可选标识
	public static final String FG_EDIT= "Fg_edit";
	//开单是否默认选中
	public static final String FG_CHECK_DEF= "Fg_check_def";
	//启用标识
	public static final String FG_ACTIVE= "Fg_active";
	//执行科室计算方式
	public static final String ID_MPDEPCALMD= "Id_mpdepcalmd";
	//执行科室计算方式编码
	public static final String SD_MPDEPCALMD= "Sd_mpdepcalmd";
	//执行科室固定值
	public static final String ID_DEP_MP= "Id_dep_mp";
	//服务名称
	public static final String SET_NAME= "Set_name";
	//服务名称
	public static final String SRV_NAME= "Srv_name";
	//服务编码
	public static final String SRV_CODE= "Srv_code";
	//编码
	public static final String ROLE_CODE= "Role_code";
	//名称
	public static final String ROLE_NAME= "Role_name";
	//计量单位名称
	public static final String MEDU_NAME= "Medu_name";
	//计量单位编码
	public static final String MEDU_CODE= "Medu_code";
	//频次编码
	public static final String FREQ_CODE= "Freq_code";
	//频次名称
	public static final String FREQ_NAME= "Freq_name";
	//用法编码
	public static final String ROUTE_CODE= "Route_code";
	//用法名称
	public static final String ROUTE_NAME= "Route_name";
	//助记码
	public static final String ROUTE_MNECODE= "Route_mnecode";
	//用法要求编码
	public static final String ROUTEDES_CODE= "Routedes_code";
	//用法要求
	public static final String ROUTEDES_NAME= "Routedes_name";
	//助记码
	public static final String ROUTEDES_MNECODE= "Routedes_mnecode";
	//煎法编码
	public static final String BOIL_CODE= "Boil_code";
	//煎法名称
	public static final String BOIL_NAME= "Boil_name";
	//助记码
	public static final String BOIL_MNECODE= "Boil_mnecode";
	//煎法要求编码
	public static final String BOILDES_CODE= "Boildes_code";
	//煎法要求
	public static final String BOILDES_NAME= "Boildes_name";
	//助记码
	public static final String BOILDES_MNECODE= "Boildes_mnecode";
	//名称
	public static final String NAME_MPDEPCALMD= "Name_mpdepcalmd";
	//名称
	public static final String NAME_MP_DEP= "Name_mp_dep";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 服务套项目主键标识
	 * @return String
	 */
	public String getId_srvsetdef() {
		return ((String) getAttrVal("Id_srvsetdef"));
	}	
	/**
	 * 服务套项目主键标识
	 * @param Id_srvsetdef
	 */
	public void setId_srvsetdef(String Id_srvsetdef) {
		setAttrVal("Id_srvsetdef", Id_srvsetdef);
	}
	/**
	 * 服务
	 * @return String
	 */
	public String getId_srv_itm() {
		return ((String) getAttrVal("Id_srv_itm"));
	}	
	/**
	 * 服务
	 * @param Id_srv_itm
	 */
	public void setId_srv_itm(String Id_srv_itm) {
		setAttrVal("Id_srv_itm", Id_srv_itm);
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
	 * 所属服务套
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 所属服务套
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 成员角色
	 * @return String
	 */
	public String getId_srvsetrole() {
		return ((String) getAttrVal("Id_srvsetrole"));
	}	
	/**
	 * 成员角色
	 * @param Id_srvsetrole
	 */
	public void setId_srvsetrole(String Id_srvsetrole) {
		setAttrVal("Id_srvsetrole", Id_srvsetrole);
	}
	/**
	 * 成员角色编码
	 * @return String
	 */
	public String getSd_srvsetrole() {
		return ((String) getAttrVal("Sd_srvsetrole"));
	}	
	/**
	 * 成员角色编码
	 * @param Sd_srvsetrole
	 */
	public void setSd_srvsetrole(String Sd_srvsetrole) {
		setAttrVal("Sd_srvsetrole", Sd_srvsetrole);
	}
	/**
	 * 医学单位数值_默认
	 * @return FDouble
	 */
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}	
	/**
	 * 医学单位数值_默认
	 * @param Quan_medu
	 */
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	/**
	 * 医学单位
	 * @return String
	 */
	public String getId_medu() {
		return ((String) getAttrVal("Id_medu"));
	}	
	/**
	 * 医学单位
	 * @param Id_medu
	 */
	public void setId_medu(String Id_medu) {
		setAttrVal("Id_medu", Id_medu);
	}
	/**
	 * 频次_默认（废弃不用了）
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}	
	/**
	 * 频次_默认（废弃不用了）
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 用法_默认
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}	
	/**
	 * 用法_默认
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 用法要求_默认
	 * @return String
	 */
	public String getId_routedes() {
		return ((String) getAttrVal("Id_routedes"));
	}	
	/**
	 * 用法要求_默认
	 * @param Id_routedes
	 */
	public void setId_routedes(String Id_routedes) {
		setAttrVal("Id_routedes", Id_routedes);
	}
	/**
	 * 煎法_默认
	 * @return String
	 */
	public String getId_boil() {
		return ((String) getAttrVal("Id_boil"));
	}	
	/**
	 * 煎法_默认
	 * @param Id_boil
	 */
	public void setId_boil(String Id_boil) {
		setAttrVal("Id_boil", Id_boil);
	}
	/**
	 * 煎法要求_默认
	 * @return String
	 */
	public String getId_boildes() {
		return ((String) getAttrVal("Id_boildes"));
	}	
	/**
	 * 煎法要求_默认
	 * @param Id_boildes
	 */
	public void setId_boildes(String Id_boildes) {
		setAttrVal("Id_boildes", Id_boildes);
	}
	/**
	 * 临床标识
	 * @return FBoolean
	 */
	public FBoolean getFg_clinical() {
		return ((FBoolean) getAttrVal("Fg_clinical"));
	}	
	/**
	 * 临床标识
	 * @param Fg_clinical
	 */
	public void setFg_clinical(FBoolean Fg_clinical) {
		setAttrVal("Fg_clinical", Fg_clinical);
	}
	/**
	 * 临床价格计算标识
	 * @return FBoolean
	 */
	public FBoolean getFg_clinical_bl() {
		return ((FBoolean) getAttrVal("Fg_clinical_bl"));
	}	
	/**
	 * 临床价格计算标识
	 * @param Fg_clinical_bl
	 */
	public void setFg_clinical_bl(FBoolean Fg_clinical_bl) {
		setAttrVal("Fg_clinical_bl", Fg_clinical_bl);
	}
	/**
	 * 可选标识
	 * @return FBoolean
	 */
	public FBoolean getFg_edit() {
		return ((FBoolean) getAttrVal("Fg_edit"));
	}	
	/**
	 * 可选标识
	 * @param Fg_edit
	 */
	public void setFg_edit(FBoolean Fg_edit) {
		setAttrVal("Fg_edit", Fg_edit);
	}
	/**
	 * 开单是否默认选中
	 * @return FBoolean
	 */
	public FBoolean getFg_check_def() {
		return ((FBoolean) getAttrVal("Fg_check_def"));
	}	
	/**
	 * 开单是否默认选中
	 * @param Fg_check_def
	 */
	public void setFg_check_def(FBoolean Fg_check_def) {
		setAttrVal("Fg_check_def", Fg_check_def);
	}
	/**
	 * 启用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标识
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 执行科室计算方式
	 * @return String
	 */
	public String getId_mpdepcalmd() {
		return ((String) getAttrVal("Id_mpdepcalmd"));
	}	
	/**
	 * 执行科室计算方式
	 * @param Id_mpdepcalmd
	 */
	public void setId_mpdepcalmd(String Id_mpdepcalmd) {
		setAttrVal("Id_mpdepcalmd", Id_mpdepcalmd);
	}
	/**
	 * 执行科室计算方式编码
	 * @return String
	 */
	public String getSd_mpdepcalmd() {
		return ((String) getAttrVal("Sd_mpdepcalmd"));
	}	
	/**
	 * 执行科室计算方式编码
	 * @param Sd_mpdepcalmd
	 */
	public void setSd_mpdepcalmd(String Sd_mpdepcalmd) {
		setAttrVal("Sd_mpdepcalmd", Sd_mpdepcalmd);
	}
	/**
	 * 执行科室固定值
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}	
	/**
	 * 执行科室固定值
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getSet_name() {
		return ((String) getAttrVal("Set_name"));
	}	
	/**
	 * 服务名称
	 * @param Set_name
	 */
	public void setSet_name(String Set_name) {
		setAttrVal("Set_name", Set_name);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	/**
	 * 服务名称
	 * @param Srv_name
	 */
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getSrv_code() {
		return ((String) getAttrVal("Srv_code"));
	}	
	/**
	 * 服务编码
	 * @param Srv_code
	 */
	public void setSrv_code(String Srv_code) {
		setAttrVal("Srv_code", Srv_code);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getRole_code() {
		return ((String) getAttrVal("Role_code"));
	}	
	/**
	 * 编码
	 * @param Role_code
	 */
	public void setRole_code(String Role_code) {
		setAttrVal("Role_code", Role_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getRole_name() {
		return ((String) getAttrVal("Role_name"));
	}	
	/**
	 * 名称
	 * @param Role_name
	 */
	public void setRole_name(String Role_name) {
		setAttrVal("Role_name", Role_name);
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
	 * 计量单位编码
	 * @return String
	 */
	public String getMedu_code() {
		return ((String) getAttrVal("Medu_code"));
	}	
	/**
	 * 计量单位编码
	 * @param Medu_code
	 */
	public void setMedu_code(String Medu_code) {
		setAttrVal("Medu_code", Medu_code);
	}
	/**
	 * 频次编码
	 * @return String
	 */
	public String getFreq_code() {
		return ((String) getAttrVal("Freq_code"));
	}	
	/**
	 * 频次编码
	 * @param Freq_code
	 */
	public void setFreq_code(String Freq_code) {
		setAttrVal("Freq_code", Freq_code);
	}
	/**
	 * 频次名称
	 * @return String
	 */
	public String getFreq_name() {
		return ((String) getAttrVal("Freq_name"));
	}	
	/**
	 * 频次名称
	 * @param Freq_name
	 */
	public void setFreq_name(String Freq_name) {
		setAttrVal("Freq_name", Freq_name);
	}
	/**
	 * 用法编码
	 * @return String
	 */
	public String getRoute_code() {
		return ((String) getAttrVal("Route_code"));
	}	
	/**
	 * 用法编码
	 * @param Route_code
	 */
	public void setRoute_code(String Route_code) {
		setAttrVal("Route_code", Route_code);
	}
	/**
	 * 用法名称
	 * @return String
	 */
	public String getRoute_name() {
		return ((String) getAttrVal("Route_name"));
	}	
	/**
	 * 用法名称
	 * @param Route_name
	 */
	public void setRoute_name(String Route_name) {
		setAttrVal("Route_name", Route_name);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getRoute_mnecode() {
		return ((String) getAttrVal("Route_mnecode"));
	}	
	/**
	 * 助记码
	 * @param Route_mnecode
	 */
	public void setRoute_mnecode(String Route_mnecode) {
		setAttrVal("Route_mnecode", Route_mnecode);
	}
	/**
	 * 用法要求编码
	 * @return String
	 */
	public String getRoutedes_code() {
		return ((String) getAttrVal("Routedes_code"));
	}	
	/**
	 * 用法要求编码
	 * @param Routedes_code
	 */
	public void setRoutedes_code(String Routedes_code) {
		setAttrVal("Routedes_code", Routedes_code);
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
	 * 助记码
	 * @return String
	 */
	public String getRoutedes_mnecode() {
		return ((String) getAttrVal("Routedes_mnecode"));
	}	
	/**
	 * 助记码
	 * @param Routedes_mnecode
	 */
	public void setRoutedes_mnecode(String Routedes_mnecode) {
		setAttrVal("Routedes_mnecode", Routedes_mnecode);
	}
	/**
	 * 煎法编码
	 * @return String
	 */
	public String getBoil_code() {
		return ((String) getAttrVal("Boil_code"));
	}	
	/**
	 * 煎法编码
	 * @param Boil_code
	 */
	public void setBoil_code(String Boil_code) {
		setAttrVal("Boil_code", Boil_code);
	}
	/**
	 * 煎法名称
	 * @return String
	 */
	public String getBoil_name() {
		return ((String) getAttrVal("Boil_name"));
	}	
	/**
	 * 煎法名称
	 * @param Boil_name
	 */
	public void setBoil_name(String Boil_name) {
		setAttrVal("Boil_name", Boil_name);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getBoil_mnecode() {
		return ((String) getAttrVal("Boil_mnecode"));
	}	
	/**
	 * 助记码
	 * @param Boil_mnecode
	 */
	public void setBoil_mnecode(String Boil_mnecode) {
		setAttrVal("Boil_mnecode", Boil_mnecode);
	}
	/**
	 * 煎法要求编码
	 * @return String
	 */
	public String getBoildes_code() {
		return ((String) getAttrVal("Boildes_code"));
	}	
	/**
	 * 煎法要求编码
	 * @param Boildes_code
	 */
	public void setBoildes_code(String Boildes_code) {
		setAttrVal("Boildes_code", Boildes_code);
	}
	/**
	 * 煎法要求
	 * @return String
	 */
	public String getBoildes_name() {
		return ((String) getAttrVal("Boildes_name"));
	}	
	/**
	 * 煎法要求
	 * @param Boildes_name
	 */
	public void setBoildes_name(String Boildes_name) {
		setAttrVal("Boildes_name", Boildes_name);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getBoildes_mnecode() {
		return ((String) getAttrVal("Boildes_mnecode"));
	}	
	/**
	 * 助记码
	 * @param Boildes_mnecode
	 */
	public void setBoildes_mnecode(String Boildes_mnecode) {
		setAttrVal("Boildes_mnecode", Boildes_mnecode);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_mpdepcalmd() {
		return ((String) getAttrVal("Name_mpdepcalmd"));
	}	
	/**
	 * 名称
	 * @param Name_mpdepcalmd
	 */
	public void setName_mpdepcalmd(String Name_mpdepcalmd) {
		setAttrVal("Name_mpdepcalmd", Name_mpdepcalmd);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_mp_dep() {
		return ((String) getAttrVal("Name_mp_dep"));
	}	
	/**
	 * 名称
	 * @param Name_mp_dep
	 */
	public void setName_mp_dep(String Name_mp_dep) {
		setAttrVal("Name_mp_dep", Name_mp_dep);
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
		return "Id_srvsetdef";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srvset_def";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MedSrvSetItemDODesc.class);
	}
	
}