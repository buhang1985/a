package iih.ci.tsip.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.tsip.d.desc.CiTsOrDODesc;
import java.math.BigDecimal;

/**
 * 治疗方案医嘱 DO数据 
 * 
 */
public class CiTsOrDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//治疗方案医嘱ID
	public static final String ID_TSOR= "Id_tsor";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//患者
	public static final String ID_PAT= "Id_pat";
	//就诊
	public static final String ID_EN= "Id_en";
	//就诊类型编码
	public static final String SD_ENTP= "Sd_entp";
	//医嘱类型编码
	public static final String SD_SRVTP= "Sd_srvtp";
	//服务
	public static final String ID_SRV= "Id_srv";
	//服务套标识
	public static final String FG_SET= "Fg_set";
	//长临标识
	public static final String FG_LONG= "Fg_long";
	//医嘱编码
	public static final String CODE_OR= "Code_or";
	//医嘱内容
	public static final String CONTENT_OR= "Content_or";
	//医嘱名称
	public static final String NAME_OR= "Name_or";
	//医嘱频次
	public static final String ID_FREQ= "Id_freq";
	//医嘱用法
	public static final String ID_ROUTE= "Id_route";
	//医嘱用法要求
	public static final String ID_ROUTEDES= "Id_routedes";
	//医嘱天数
	public static final String DAYS_OR= "Days_or";
	//煎法
	public static final String ID_BOIL= "Id_boil";
	//医嘱付数
	public static final String ORDERS= "Orders";
	//次数
	public static final String TIMES_CUR= "Times_cur";
	//最近生成日期时间
	public static final String DT_BL_LAST= "Dt_bl_last";
	//方案医嘱来源方式
	public static final String EU_TSORSRCMDTP= "Eu_tsorsrcmdtp";
	//方案医嘱状态
	public static final String SD_SU_TS_OR= "Sd_su_ts_or";
	//方案医嘱生成状态
	public static final String SD_SU_TS_MP= "Sd_su_ts_mp";
	//医嘱生效日期
	public static final String DT_EFFE= "Dt_effe";
	//医嘱结束时间
	public static final String DT_END= "Dt_end";
	//备注
	public static final String DES_OR= "Des_or";
	//医疗单
	public static final String ID_SRVOF= "Id_srvof";
	//医疗单URL
	public static final String FUNCCLASSSTR= "Funcclassstr";
	//开立机构
	public static final String ID_ORG_CREATE= "Id_org_create";
	//开立部门
	public static final String ID_DEP_CREATE= "Id_dep_create";
	//开立医疗组
	public static final String ID_WG_CREATE= "Id_wg_create";
	//开立医生
	public static final String ID_EMP_CREATE= "Id_emp_create";
	//开立病区
	public static final String ID_DEP_NUR_CREATE= "Id_dep_nur_create";
	//开立日期
	public static final String DT_CREATE= "Dt_create";
	//签署标识
	public static final String FG_SIGN= "Fg_sign";
	//签署医生
	public static final String ID_EMP_SIGN= "Id_emp_sign";
	//签署日期
	public static final String DT_SIGN= "Dt_sign";
	//签署部门
	public static final String ID_DEP_SIGN= "Id_dep_sign";
	//停止标识
	public static final String FG_STOP= "Fg_stop";
	//停止医生
	public static final String ID_EMP_STOP= "Id_emp_stop";
	//停止科室
	public static final String ID_DEP_STOP= "Id_dep_stop";
	//停止日期
	public static final String DT_STOP= "Dt_stop";
	//作废标识
	public static final String FG_CANC= "Fg_canc";
	//作废科室
	public static final String ID_DEP_CANC= "Id_dep_canc";
	//作废医生
	public static final String ID_EMP_CANC= "Id_emp_canc";
	//作废日期
	public static final String DT_CANC= "Dt_canc";
	//执行机构
	public static final String ID_ORG_MP= "Id_org_mp";
	//执行科室
	public static final String ID_DEP_MP= "Id_dep_mp";
	//临床诊断
	public static final String ID_DI_DEF= "Id_di_def";
	//申请单号
	public static final String NO_APPLYFORM= "No_applyform";
	//方案类型
	public static final String SD_TSTP= "Sd_tstp";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//用法要求
	public static final String ROUTEDES_NAME= "Routedes_name";
	//组织名称
	public static final String ORG_OR_NAME= "Org_or_name";
	//名称
	public static final String DEPT_OR_NAME= "Dept_or_name";
	//姓名
	public static final String EMP_PHY_NAME= "Emp_phy_name";
	//姓名
	public static final String EMP_SIGN_NAME= "Emp_sign_name";
	//名称
	public static final String DEP_SIGN_NAME= "Dep_sign_name";
	//姓名
	public static final String EMP_STOP_NAME= "Emp_stop_name";
	//名称
	public static final String DEP_STOP_NAME= "Dep_stop_name";
	//名称
	public static final String DEP_CANC_NAME= "Dep_canc_name";
	//姓名
	public static final String EMP_CANC_NAME= "Emp_canc_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
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
	 * 医嘱类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	/**
	 * 医嘱类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 服务套标识
	 * @return FBoolean
	 */
	public FBoolean getFg_set() {
		return ((FBoolean) getAttrVal("Fg_set"));
	}	
	/**
	 * 服务套标识
	 * @param Fg_set
	 */
	public void setFg_set(FBoolean Fg_set) {
		setAttrVal("Fg_set", Fg_set);
	}
	/**
	 * 长临标识
	 * @return FBoolean
	 */
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}	
	/**
	 * 长临标识
	 * @param Fg_long
	 */
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	/**
	 * 医嘱编码
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}	
	/**
	 * 医嘱编码
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}	
	/**
	 * 医嘱内容
	 * @param Content_or
	 */
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
	}
	/**
	 * 医嘱名称
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}	
	/**
	 * 医嘱名称
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
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
	 * 医嘱天数
	 * @return Integer
	 */
	public Integer getDays_or() {
		return ((Integer) getAttrVal("Days_or"));
	}	
	/**
	 * 医嘱天数
	 * @param Days_or
	 */
	public void setDays_or(Integer Days_or) {
		setAttrVal("Days_or", Days_or);
	}
	/**
	 * 煎法
	 * @return String
	 */
	public String getId_boil() {
		return ((String) getAttrVal("Id_boil"));
	}	
	/**
	 * 煎法
	 * @param Id_boil
	 */
	public void setId_boil(String Id_boil) {
		setAttrVal("Id_boil", Id_boil);
	}
	/**
	 * 医嘱付数
	 * @return Integer
	 */
	public Integer getOrders() {
		return ((Integer) getAttrVal("Orders"));
	}	
	/**
	 * 医嘱付数
	 * @param Orders
	 */
	public void setOrders(Integer Orders) {
		setAttrVal("Orders", Orders);
	}
	/**
	 * 次数
	 * @return Integer
	 */
	public Integer getTimes_cur() {
		return ((Integer) getAttrVal("Times_cur"));
	}	
	/**
	 * 次数
	 * @param Times_cur
	 */
	public void setTimes_cur(Integer Times_cur) {
		setAttrVal("Times_cur", Times_cur);
	}
	/**
	 * 最近生成日期时间
	 * @return FDateTime
	 */
	public FDateTime getDt_bl_last() {
		return ((FDateTime) getAttrVal("Dt_bl_last"));
	}	
	/**
	 * 最近生成日期时间
	 * @param Dt_bl_last
	 */
	public void setDt_bl_last(FDateTime Dt_bl_last) {
		setAttrVal("Dt_bl_last", Dt_bl_last);
	}
	/**
	 * 方案医嘱来源方式
	 * @return String
	 */
	public String getEu_tsorsrcmdtp() {
		return ((String) getAttrVal("Eu_tsorsrcmdtp"));
	}	
	/**
	 * 方案医嘱来源方式
	 * @param Eu_tsorsrcmdtp
	 */
	public void setEu_tsorsrcmdtp(String Eu_tsorsrcmdtp) {
		setAttrVal("Eu_tsorsrcmdtp", Eu_tsorsrcmdtp);
	}
	/**
	 * 方案医嘱状态
	 * @return String
	 */
	public String getSd_su_ts_or() {
		return ((String) getAttrVal("Sd_su_ts_or"));
	}	
	/**
	 * 方案医嘱状态
	 * @param Sd_su_ts_or
	 */
	public void setSd_su_ts_or(String Sd_su_ts_or) {
		setAttrVal("Sd_su_ts_or", Sd_su_ts_or);
	}
	/**
	 * 方案医嘱生成状态
	 * @return String
	 */
	public String getSd_su_ts_mp() {
		return ((String) getAttrVal("Sd_su_ts_mp"));
	}	
	/**
	 * 方案医嘱生成状态
	 * @param Sd_su_ts_mp
	 */
	public void setSd_su_ts_mp(String Sd_su_ts_mp) {
		setAttrVal("Sd_su_ts_mp", Sd_su_ts_mp);
	}
	/**
	 * 医嘱生效日期
	 * @return FDateTime
	 */
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}	
	/**
	 * 医嘱生效日期
	 * @param Dt_effe
	 */
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 医嘱结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	/**
	 * 医嘱结束时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}	
	/**
	 * 备注
	 * @param Des_or
	 */
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}
	/**
	 * 医疗单
	 * @return String
	 */
	public String getId_srvof() {
		return ((String) getAttrVal("Id_srvof"));
	}	
	/**
	 * 医疗单
	 * @param Id_srvof
	 */
	public void setId_srvof(String Id_srvof) {
		setAttrVal("Id_srvof", Id_srvof);
	}
	/**
	 * 医疗单URL
	 * @return String
	 */
	public String getFuncclassstr() {
		return ((String) getAttrVal("Funcclassstr"));
	}	
	/**
	 * 医疗单URL
	 * @param Funcclassstr
	 */
	public void setFuncclassstr(String Funcclassstr) {
		setAttrVal("Funcclassstr", Funcclassstr);
	}
	/**
	 * 开立机构
	 * @return String
	 */
	public String getId_org_create() {
		return ((String) getAttrVal("Id_org_create"));
	}	
	/**
	 * 开立机构
	 * @param Id_org_create
	 */
	public void setId_org_create(String Id_org_create) {
		setAttrVal("Id_org_create", Id_org_create);
	}
	/**
	 * 开立部门
	 * @return String
	 */
	public String getId_dep_create() {
		return ((String) getAttrVal("Id_dep_create"));
	}	
	/**
	 * 开立部门
	 * @param Id_dep_create
	 */
	public void setId_dep_create(String Id_dep_create) {
		setAttrVal("Id_dep_create", Id_dep_create);
	}
	/**
	 * 开立医疗组
	 * @return String
	 */
	public String getId_wg_create() {
		return ((String) getAttrVal("Id_wg_create"));
	}	
	/**
	 * 开立医疗组
	 * @param Id_wg_create
	 */
	public void setId_wg_create(String Id_wg_create) {
		setAttrVal("Id_wg_create", Id_wg_create);
	}
	/**
	 * 开立医生
	 * @return String
	 */
	public String getId_emp_create() {
		return ((String) getAttrVal("Id_emp_create"));
	}	
	/**
	 * 开立医生
	 * @param Id_emp_create
	 */
	public void setId_emp_create(String Id_emp_create) {
		setAttrVal("Id_emp_create", Id_emp_create);
	}
	/**
	 * 开立病区
	 * @return String
	 */
	public String getId_dep_nur_create() {
		return ((String) getAttrVal("Id_dep_nur_create"));
	}	
	/**
	 * 开立病区
	 * @param Id_dep_nur_create
	 */
	public void setId_dep_nur_create(String Id_dep_nur_create) {
		setAttrVal("Id_dep_nur_create", Id_dep_nur_create);
	}
	/**
	 * 开立日期
	 * @return FDateTime
	 */
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}	
	/**
	 * 开立日期
	 * @param Dt_create
	 */
	public void setDt_create(FDateTime Dt_create) {
		setAttrVal("Dt_create", Dt_create);
	}
	/**
	 * 签署标识
	 * @return FBoolean
	 */
	public FBoolean getFg_sign() {
		return ((FBoolean) getAttrVal("Fg_sign"));
	}	
	/**
	 * 签署标识
	 * @param Fg_sign
	 */
	public void setFg_sign(FBoolean Fg_sign) {
		setAttrVal("Fg_sign", Fg_sign);
	}
	/**
	 * 签署医生
	 * @return String
	 */
	public String getId_emp_sign() {
		return ((String) getAttrVal("Id_emp_sign"));
	}	
	/**
	 * 签署医生
	 * @param Id_emp_sign
	 */
	public void setId_emp_sign(String Id_emp_sign) {
		setAttrVal("Id_emp_sign", Id_emp_sign);
	}
	/**
	 * 签署日期
	 * @return FDateTime
	 */
	public FDateTime getDt_sign() {
		return ((FDateTime) getAttrVal("Dt_sign"));
	}	
	/**
	 * 签署日期
	 * @param Dt_sign
	 */
	public void setDt_sign(FDateTime Dt_sign) {
		setAttrVal("Dt_sign", Dt_sign);
	}
	/**
	 * 签署部门
	 * @return String
	 */
	public String getId_dep_sign() {
		return ((String) getAttrVal("Id_dep_sign"));
	}	
	/**
	 * 签署部门
	 * @param Id_dep_sign
	 */
	public void setId_dep_sign(String Id_dep_sign) {
		setAttrVal("Id_dep_sign", Id_dep_sign);
	}
	/**
	 * 停止标识
	 * @return FBoolean
	 */
	public FBoolean getFg_stop() {
		return ((FBoolean) getAttrVal("Fg_stop"));
	}	
	/**
	 * 停止标识
	 * @param Fg_stop
	 */
	public void setFg_stop(FBoolean Fg_stop) {
		setAttrVal("Fg_stop", Fg_stop);
	}
	/**
	 * 停止医生
	 * @return String
	 */
	public String getId_emp_stop() {
		return ((String) getAttrVal("Id_emp_stop"));
	}	
	/**
	 * 停止医生
	 * @param Id_emp_stop
	 */
	public void setId_emp_stop(String Id_emp_stop) {
		setAttrVal("Id_emp_stop", Id_emp_stop);
	}
	/**
	 * 停止科室
	 * @return String
	 */
	public String getId_dep_stop() {
		return ((String) getAttrVal("Id_dep_stop"));
	}	
	/**
	 * 停止科室
	 * @param Id_dep_stop
	 */
	public void setId_dep_stop(String Id_dep_stop) {
		setAttrVal("Id_dep_stop", Id_dep_stop);
	}
	/**
	 * 停止日期
	 * @return FDateTime
	 */
	public FDateTime getDt_stop() {
		return ((FDateTime) getAttrVal("Dt_stop"));
	}	
	/**
	 * 停止日期
	 * @param Dt_stop
	 */
	public void setDt_stop(FDateTime Dt_stop) {
		setAttrVal("Dt_stop", Dt_stop);
	}
	/**
	 * 作废标识
	 * @return FBoolean
	 */
	public FBoolean getFg_canc() {
		return ((FBoolean) getAttrVal("Fg_canc"));
	}	
	/**
	 * 作废标识
	 * @param Fg_canc
	 */
	public void setFg_canc(FBoolean Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	/**
	 * 作废科室
	 * @return String
	 */
	public String getId_dep_canc() {
		return ((String) getAttrVal("Id_dep_canc"));
	}	
	/**
	 * 作废科室
	 * @param Id_dep_canc
	 */
	public void setId_dep_canc(String Id_dep_canc) {
		setAttrVal("Id_dep_canc", Id_dep_canc);
	}
	/**
	 * 作废医生
	 * @return String
	 */
	public String getId_emp_canc() {
		return ((String) getAttrVal("Id_emp_canc"));
	}	
	/**
	 * 作废医生
	 * @param Id_emp_canc
	 */
	public void setId_emp_canc(String Id_emp_canc) {
		setAttrVal("Id_emp_canc", Id_emp_canc);
	}
	/**
	 * 作废日期
	 * @return FDateTime
	 */
	public FDateTime getDt_canc() {
		return ((FDateTime) getAttrVal("Dt_canc"));
	}	
	/**
	 * 作废日期
	 * @param Dt_canc
	 */
	public void setDt_canc(FDateTime Dt_canc) {
		setAttrVal("Dt_canc", Dt_canc);
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
	 * 临床诊断
	 * @return String
	 */
	public String getId_di_def() {
		return ((String) getAttrVal("Id_di_def"));
	}	
	/**
	 * 临床诊断
	 * @param Id_di_def
	 */
	public void setId_di_def(String Id_di_def) {
		setAttrVal("Id_di_def", Id_di_def);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}	
	/**
	 * 申请单号
	 * @param No_applyform
	 */
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	/**
	 * 方案类型
	 * @return String
	 */
	public String getSd_tstp() {
		return ((String) getAttrVal("Sd_tstp"));
	}	
	/**
	 * 方案类型
	 * @param Sd_tstp
	 */
	public void setSd_tstp(String Sd_tstp) {
		setAttrVal("Sd_tstp", Sd_tstp);
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
	/**
	 * 姓名
	 * @return String
	 */
	public String getEmp_sign_name() {
		return ((String) getAttrVal("Emp_sign_name"));
	}	
	/**
	 * 姓名
	 * @param Emp_sign_name
	 */
	public void setEmp_sign_name(String Emp_sign_name) {
		setAttrVal("Emp_sign_name", Emp_sign_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDep_sign_name() {
		return ((String) getAttrVal("Dep_sign_name"));
	}	
	/**
	 * 名称
	 * @param Dep_sign_name
	 */
	public void setDep_sign_name(String Dep_sign_name) {
		setAttrVal("Dep_sign_name", Dep_sign_name);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getEmp_stop_name() {
		return ((String) getAttrVal("Emp_stop_name"));
	}	
	/**
	 * 姓名
	 * @param Emp_stop_name
	 */
	public void setEmp_stop_name(String Emp_stop_name) {
		setAttrVal("Emp_stop_name", Emp_stop_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDep_stop_name() {
		return ((String) getAttrVal("Dep_stop_name"));
	}	
	/**
	 * 名称
	 * @param Dep_stop_name
	 */
	public void setDep_stop_name(String Dep_stop_name) {
		setAttrVal("Dep_stop_name", Dep_stop_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDep_canc_name() {
		return ((String) getAttrVal("Dep_canc_name"));
	}	
	/**
	 * 名称
	 * @param Dep_canc_name
	 */
	public void setDep_canc_name(String Dep_canc_name) {
		setAttrVal("Dep_canc_name", Dep_canc_name);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getEmp_canc_name() {
		return ((String) getAttrVal("Emp_canc_name"));
	}	
	/**
	 * 姓名
	 * @param Emp_canc_name
	 */
	public void setEmp_canc_name(String Emp_canc_name) {
		setAttrVal("Emp_canc_name", Emp_canc_name);
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
		return "Id_tsor";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_ts_or";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiTsOrDODesc.class);
	}
	
}