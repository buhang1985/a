package iih.ci.ord.pres.d;

import iih.ci.ord.pres.d.desc.CiPresDODesc;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.i.IDODesc;
import xap.sys.appfw.orm.desc.DescManager;

/**
 * 药品处方 DO数据 
 * 
 */
public class CiPresDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//药品处方主键标识
	public static final String ID_PRES= "Id_pres";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//患者
	public static final String ID_PATI= "Id_pati";
	//就诊类型
	public static final String ID_ENTP= "Id_entp";
	//就诊类型编码
	public static final String CODE_ENTP= "Code_entp";
	//就诊
	public static final String ID_EN= "Id_en";
	//临床诊断
	public static final String ID_DI= "Id_di";
	//临床诊断明细
	public static final String ID_DIITM= "Id_diitm";
	//诊断编码拼接
	public static final String STR_ID_DI= "Str_id_di";
	//诊断名称拼接
	public static final String STR_NAME_DI= "Str_name_di";
	//服务类型
	public static final String ID_SRVTP= "Id_srvtp";
	//服务类型编码
	public static final String SD_SRVTP= "Sd_srvtp";
	//处方类型
	public static final String ID_PRESTP= "Id_prestp";
	//处方类型编码
	public static final String SD_PRESTP= "Sd_prestp";
	//处方编码
	public static final String CODE= "Code";
	//处方名称
	public static final String NAME= "Name";
	//开立科室
	public static final String ID_DEP_OR= "Id_dep_or";
	//开立医生
	public static final String ID_EMP_OR= "Id_emp_or";
	//开立日期
	public static final String DT_ENTRY= "Dt_entry";
	//婴儿标识
	public static final String FG_BB= "Fg_bb";
	//婴儿序号
	public static final String NO_BB= "No_bb";
	//婴儿
	public static final String ID_BB= "Id_bb";
	//医疗用法
	public static final String ID_ROUTE= "Id_route";
	//用法要求
	public static final String ID_ROUTEDES= "Id_routedes";
	//中药煎法
	public static final String ID_BOIL= "Id_boil";
	//煎法要求
	public static final String ID_BOILDES= "Id_boildes";
	//收费标识
	public static final String FG_CHARGE= "Fg_charge";
	//发药标识
	public static final String FG_DISPENSE= "Fg_dispense";
	//退药类型
	public static final String ID_BACKTP= "Id_backtp";
	//退药类型编码
	public static final String SD_BACKTP= "Sd_backtp";
	//处方退药标识
	public static final String FG_BACK= "Fg_back";
	//医生签名
	public static final String ID_EMP= "Id_emp";
	//打印标识
	public static final String FG_PRN= "Fg_prn";
	//打印次数
	public static final String CNT_PRN= "Cnt_prn";
	//补打标识
	public static final String FG_PRN_ADD= "Fg_prn_add";
	//补打关联处方
	public static final String ID_PRES_REL_ADD= "Id_pres_rel_add";
	//记账状态
	public static final String ID_SU_BL= "Id_su_bl";
	//记账状态编码
	public static final String SD_SU_BL= "Sd_su_bl";
	//配药标识
	public static final String FG_MAKEUP= "Fg_makeup";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//医保处方标志
	public static final String FG_HP_PRES= "Fg_hp_pres";
	//门诊医嘱开立区间id
	public static final String ID_SESSION= "Id_session";
	//执行科室
	public static final String ID_DEP_MP= "Id_dep_mp";
	//开立机构
	public static final String ID_ORG_CREATE= "Id_org_create";
	//基数药标志
	public static final String FG_BASE= "Fg_base";
	//处方字
	public static final String ID_PRESTPWORD= "Id_prestpword";
	//处方字编码
	public static final String SD_PRESTPWORD= "Sd_prestpword";
	//客户扩展字段1
	public static final String DEF1= "Def1";
	//客户扩展字段2
	public static final String DEF2= "Def2";
	//客户扩展字段3
	public static final String DEF3= "Def3";
	//客户扩展字段4
	public static final String DEF4= "Def4";
	//客户扩展字段5
	public static final String DEF5= "Def5";
	//客户扩展字段6
	public static final String DEF6= "Def6";
	//客户扩展字段7
	public static final String DEF7= "Def7";
	//客户扩展字段8
	public static final String DEF8= "Def8";
	//客户扩展字段9
	public static final String DEF9= "Def9";
	//客户扩展字段10
	public static final String DEF10= "Def10";
	//发药窗口号
	public static final String NO_DRUGWIN= "No_drugwin";
	//处方预付费记账标识
	public static final String FG_PREPAY= "Fg_prepay";
	//费用已结算标识
	public static final String FG_BLSETTLED= "Fg_blsettled";
	//毒麻处方号
	public static final String CODE_POIS= "Code_pois";
	//高端商保标识
	public static final String FG_HECOMINSUR= "Fg_hecominsur";
	//高端商保信息串
	public static final String HECOMINSURINFO= "Hecominsurinfo";
	//VIP标识
	public static final String FG_VIP= "Fg_vip";
	//科研标识
	public static final String FG_RESEARCH= "Fg_research";
	//科研项目主键
	public static final String ID_RESEARCHPROJECT= "Id_researchproject";
	//科研项目信息
	public static final String RESEARCHINFO= "Researchinfo";
	//患者体重
	public static final String WEIGHT= "Weight";
	//患者体重单位
	public static final String ID_WEIGHT_UNIT= "Id_weight_unit";
	//院内制剂
	public static final String FG_HOSPITAL_HERBPRES= "Fg_hospital_herbpres";
	//疾病病种ID
	public static final String ID_DSDEF= "Id_dsdef";
	//疾病病种编码
	public static final String CODE_DSDEF= "Code_dsdef";
	//疾病病种名称
	public static final String NAME_DSDEF= "Name_dsdef";
	//名称
	public static final String PRESTP_NAME= "Prestp_name";
	//计量单位名称
	public static final String NAME_WEIGHT_UNIT= "Name_weight_unit";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 药品处方主键标识
	 * @return String
	 */
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}	
	/**
	 * 药品处方主键标识
	 * @param Id_pres
	 */
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
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
	public String getId_pati() {
		return ((String) getAttrVal("Id_pati"));
	}	
	/**
	 * 患者
	 * @param Id_pati
	 */
	public void setId_pati(String Id_pati) {
		setAttrVal("Id_pati", Id_pati);
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
	 * 临床诊断
	 * @return String
	 */
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}	
	/**
	 * 临床诊断
	 * @param Id_di
	 */
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	/**
	 * 临床诊断明细
	 * @return String
	 */
	public String getId_diitm() {
		return ((String) getAttrVal("Id_diitm"));
	}	
	/**
	 * 临床诊断明细
	 * @param Id_diitm
	 */
	public void setId_diitm(String Id_diitm) {
		setAttrVal("Id_diitm", Id_diitm);
	}
	/**
	 * 诊断编码拼接
	 * @return String
	 */
	public String getStr_id_di() {
		return ((String) getAttrVal("Str_id_di"));
	}	
	/**
	 * 诊断编码拼接
	 * @param Str_id_di
	 */
	public void setStr_id_di(String Str_id_di) {
		setAttrVal("Str_id_di", Str_id_di);
	}
	/**
	 * 诊断名称拼接
	 * @return String
	 */
	public String getStr_name_di() {
		return ((String) getAttrVal("Str_name_di"));
	}	
	/**
	 * 诊断名称拼接
	 * @param Str_name_di
	 */
	public void setStr_name_di(String Str_name_di) {
		setAttrVal("Str_name_di", Str_name_di);
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
	 * 处方类型
	 * @return String
	 */
	public String getId_prestp() {
		return ((String) getAttrVal("Id_prestp"));
	}	
	/**
	 * 处方类型
	 * @param Id_prestp
	 */
	public void setId_prestp(String Id_prestp) {
		setAttrVal("Id_prestp", Id_prestp);
	}
	/**
	 * 处方类型编码
	 * @return String
	 */
	public String getSd_prestp() {
		return ((String) getAttrVal("Sd_prestp"));
	}	
	/**
	 * 处方类型编码
	 * @param Sd_prestp
	 */
	public void setSd_prestp(String Sd_prestp) {
		setAttrVal("Sd_prestp", Sd_prestp);
	}
	/**
	 * 处方编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 处方编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 处方名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 处方名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 开立科室
	 * @return String
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}	
	/**
	 * 开立科室
	 * @param Id_dep_or
	 */
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	/**
	 * 开立医生
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}	
	/**
	 * 开立医生
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	/**
	 * 开立日期
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}	
	/**
	 * 开立日期
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 婴儿标识
	 * @return FBoolean
	 */
	public FBoolean getFg_bb() {
		return ((FBoolean) getAttrVal("Fg_bb"));
	}	
	/**
	 * 婴儿标识
	 * @param Fg_bb
	 */
	public void setFg_bb(FBoolean Fg_bb) {
		setAttrVal("Fg_bb", Fg_bb);
	}
	/**
	 * 婴儿序号
	 * @return Integer
	 */
	public Integer getNo_bb() {
		return ((Integer) getAttrVal("No_bb"));
	}	
	/**
	 * 婴儿序号
	 * @param No_bb
	 */
	public void setNo_bb(Integer No_bb) {
		setAttrVal("No_bb", No_bb);
	}
	/**
	 * 婴儿
	 * @return String
	 */
	public String getId_bb() {
		return ((String) getAttrVal("Id_bb"));
	}	
	/**
	 * 婴儿
	 * @param Id_bb
	 */
	public void setId_bb(String Id_bb) {
		setAttrVal("Id_bb", Id_bb);
	}
	/**
	 * 医疗用法
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}	
	/**
	 * 医疗用法
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 用法要求
	 * @return String
	 */
	public String getId_routedes() {
		return ((String) getAttrVal("Id_routedes"));
	}	
	/**
	 * 用法要求
	 * @param Id_routedes
	 */
	public void setId_routedes(String Id_routedes) {
		setAttrVal("Id_routedes", Id_routedes);
	}
	/**
	 * 中药煎法
	 * @return String
	 */
	public String getId_boil() {
		return ((String) getAttrVal("Id_boil"));
	}	
	/**
	 * 中药煎法
	 * @param Id_boil
	 */
	public void setId_boil(String Id_boil) {
		setAttrVal("Id_boil", Id_boil);
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
	 * 收费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_charge() {
		return ((FBoolean) getAttrVal("Fg_charge"));
	}	
	/**
	 * 收费标识
	 * @param Fg_charge
	 */
	public void setFg_charge(FBoolean Fg_charge) {
		setAttrVal("Fg_charge", Fg_charge);
	}
	/**
	 * 发药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_dispense() {
		return ((FBoolean) getAttrVal("Fg_dispense"));
	}	
	/**
	 * 发药标识
	 * @param Fg_dispense
	 */
	public void setFg_dispense(FBoolean Fg_dispense) {
		setAttrVal("Fg_dispense", Fg_dispense);
	}
	/**
	 * 退药类型
	 * @return String
	 */
	public String getId_backtp() {
		return ((String) getAttrVal("Id_backtp"));
	}	
	/**
	 * 退药类型
	 * @param Id_backtp
	 */
	public void setId_backtp(String Id_backtp) {
		setAttrVal("Id_backtp", Id_backtp);
	}
	/**
	 * 退药类型编码
	 * @return String
	 */
	public String getSd_backtp() {
		return ((String) getAttrVal("Sd_backtp"));
	}	
	/**
	 * 退药类型编码
	 * @param Sd_backtp
	 */
	public void setSd_backtp(String Sd_backtp) {
		setAttrVal("Sd_backtp", Sd_backtp);
	}
	/**
	 * 处方退药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_back() {
		return ((FBoolean) getAttrVal("Fg_back"));
	}	
	/**
	 * 处方退药标识
	 * @param Fg_back
	 */
	public void setFg_back(FBoolean Fg_back) {
		setAttrVal("Fg_back", Fg_back);
	}
	/**
	 * 医生签名
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	/**
	 * 医生签名
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 打印标识
	 * @return FBoolean
	 */
	public FBoolean getFg_prn() {
		return ((FBoolean) getAttrVal("Fg_prn"));
	}	
	/**
	 * 打印标识
	 * @param Fg_prn
	 */
	public void setFg_prn(FBoolean Fg_prn) {
		setAttrVal("Fg_prn", Fg_prn);
	}
	/**
	 * 打印次数
	 * @return Integer
	 */
	public Integer getCnt_prn() {
		return ((Integer) getAttrVal("Cnt_prn"));
	}	
	/**
	 * 打印次数
	 * @param Cnt_prn
	 */
	public void setCnt_prn(Integer Cnt_prn) {
		setAttrVal("Cnt_prn", Cnt_prn);
	}
	/**
	 * 补打标识
	 * @return FBoolean
	 */
	public FBoolean getFg_prn_add() {
		return ((FBoolean) getAttrVal("Fg_prn_add"));
	}	
	/**
	 * 补打标识
	 * @param Fg_prn_add
	 */
	public void setFg_prn_add(FBoolean Fg_prn_add) {
		setAttrVal("Fg_prn_add", Fg_prn_add);
	}
	/**
	 * 补打关联处方
	 * @return String
	 */
	public String getId_pres_rel_add() {
		return ((String) getAttrVal("Id_pres_rel_add"));
	}	
	/**
	 * 补打关联处方
	 * @param Id_pres_rel_add
	 */
	public void setId_pres_rel_add(String Id_pres_rel_add) {
		setAttrVal("Id_pres_rel_add", Id_pres_rel_add);
	}
	/**
	 * 记账状态
	 * @return String
	 */
	public String getId_su_bl() {
		return ((String) getAttrVal("Id_su_bl"));
	}	
	/**
	 * 记账状态
	 * @param Id_su_bl
	 */
	public void setId_su_bl(String Id_su_bl) {
		setAttrVal("Id_su_bl", Id_su_bl);
	}
	/**
	 * 记账状态编码
	 * @return String
	 */
	public String getSd_su_bl() {
		return ((String) getAttrVal("Sd_su_bl"));
	}	
	/**
	 * 记账状态编码
	 * @param Sd_su_bl
	 */
	public void setSd_su_bl(String Sd_su_bl) {
		setAttrVal("Sd_su_bl", Sd_su_bl);
	}
	/**
	 * 配药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_makeup() {
		return ((FBoolean) getAttrVal("Fg_makeup"));
	}	
	/**
	 * 配药标识
	 * @param Fg_makeup
	 */
	public void setFg_makeup(FBoolean Fg_makeup) {
		setAttrVal("Fg_makeup", Fg_makeup);
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
	 * 医保处方标志
	 * @return FBoolean
	 */
	public FBoolean getFg_hp_pres() {
		return ((FBoolean) getAttrVal("Fg_hp_pres"));
	}	
	/**
	 * 医保处方标志
	 * @param Fg_hp_pres
	 */
	public void setFg_hp_pres(FBoolean Fg_hp_pres) {
		setAttrVal("Fg_hp_pres", Fg_hp_pres);
	}
	/**
	 * 门诊医嘱开立区间id
	 * @return String
	 */
	public String getId_session() {
		return ((String) getAttrVal("Id_session"));
	}	
	/**
	 * 门诊医嘱开立区间id
	 * @param Id_session
	 */
	public void setId_session(String Id_session) {
		setAttrVal("Id_session", Id_session);
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
	 * 基数药标志
	 * @return FBoolean
	 */
	public FBoolean getFg_base() {
		return ((FBoolean) getAttrVal("Fg_base"));
	}	
	/**
	 * 基数药标志
	 * @param Fg_base
	 */
	public void setFg_base(FBoolean Fg_base) {
		setAttrVal("Fg_base", Fg_base);
	}
	/**
	 * 处方字
	 * @return String
	 */
	public String getId_prestpword() {
		return ((String) getAttrVal("Id_prestpword"));
	}	
	/**
	 * 处方字
	 * @param Id_prestpword
	 */
	public void setId_prestpword(String Id_prestpword) {
		setAttrVal("Id_prestpword", Id_prestpword);
	}
	/**
	 * 处方字编码
	 * @return String
	 */
	public String getSd_prestpword() {
		return ((String) getAttrVal("Sd_prestpword"));
	}	
	/**
	 * 处方字编码
	 * @param Sd_prestpword
	 */
	public void setSd_prestpword(String Sd_prestpword) {
		setAttrVal("Sd_prestpword", Sd_prestpword);
	}
	/**
	 * 客户扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 客户扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 客户扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 客户扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 客户扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 客户扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 客户扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	/**
	 * 客户扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 客户扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	/**
	 * 客户扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 * 客户扩展字段6
	 * @return String
	 */
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}	
	/**
	 * 客户扩展字段6
	 * @param Def6
	 */
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	/**
	 * 客户扩展字段7
	 * @return String
	 */
	public String getDef7() {
		return ((String) getAttrVal("Def7"));
	}	
	/**
	 * 客户扩展字段7
	 * @param Def7
	 */
	public void setDef7(String Def7) {
		setAttrVal("Def7", Def7);
	}
	/**
	 * 客户扩展字段8
	 * @return String
	 */
	public String getDef8() {
		return ((String) getAttrVal("Def8"));
	}	
	/**
	 * 客户扩展字段8
	 * @param Def8
	 */
	public void setDef8(String Def8) {
		setAttrVal("Def8", Def8);
	}
	/**
	 * 客户扩展字段9
	 * @return String
	 */
	public String getDef9() {
		return ((String) getAttrVal("Def9"));
	}	
	/**
	 * 客户扩展字段9
	 * @param Def9
	 */
	public void setDef9(String Def9) {
		setAttrVal("Def9", Def9);
	}
	/**
	 * 客户扩展字段10
	 * @return String
	 */
	public String getDef10() {
		return ((String) getAttrVal("Def10"));
	}	
	/**
	 * 客户扩展字段10
	 * @param Def10
	 */
	public void setDef10(String Def10) {
		setAttrVal("Def10", Def10);
	}
	/**
	 * 发药窗口号
	 * @return String
	 */
	public String getNo_drugwin() {
		return ((String) getAttrVal("No_drugwin"));
	}	
	/**
	 * 发药窗口号
	 * @param No_drugwin
	 */
	public void setNo_drugwin(String No_drugwin) {
		setAttrVal("No_drugwin", No_drugwin);
	}
	/**
	 * 处方预付费记账标识
	 * @return FBoolean
	 */
	public FBoolean getFg_prepay() {
		return ((FBoolean) getAttrVal("Fg_prepay"));
	}	
	/**
	 * 处方预付费记账标识
	 * @param Fg_prepay
	 */
	public void setFg_prepay(FBoolean Fg_prepay) {
		setAttrVal("Fg_prepay", Fg_prepay);
	}
	/**
	 * 费用已结算标识
	 * @return FBoolean
	 */
	public FBoolean getFg_blsettled() {
		return ((FBoolean) getAttrVal("Fg_blsettled"));
	}	
	/**
	 * 费用已结算标识
	 * @param Fg_blsettled
	 */
	public void setFg_blsettled(FBoolean Fg_blsettled) {
		setAttrVal("Fg_blsettled", Fg_blsettled);
	}
	/**
	 * 毒麻处方号
	 * @return String
	 */
	public String getCode_pois() {
		return ((String) getAttrVal("Code_pois"));
	}	
	/**
	 * 毒麻处方号
	 * @param Code_pois
	 */
	public void setCode_pois(String Code_pois) {
		setAttrVal("Code_pois", Code_pois);
	}
	/**
	 * 高端商保标识
	 * @return FBoolean
	 */
	public FBoolean getFg_hecominsur() {
		return ((FBoolean) getAttrVal("Fg_hecominsur"));
	}	
	/**
	 * 高端商保标识
	 * @param Fg_hecominsur
	 */
	public void setFg_hecominsur(FBoolean Fg_hecominsur) {
		setAttrVal("Fg_hecominsur", Fg_hecominsur);
	}
	/**
	 * 高端商保信息串
	 * @return String
	 */
	public String getHecominsurinfo() {
		return ((String) getAttrVal("Hecominsurinfo"));
	}	
	/**
	 * 高端商保信息串
	 * @param Hecominsurinfo
	 */
	public void setHecominsurinfo(String Hecominsurinfo) {
		setAttrVal("Hecominsurinfo", Hecominsurinfo);
	}
	/**
	 * VIP标识
	 * @return FBoolean
	 */
	public FBoolean getFg_vip() {
		return ((FBoolean) getAttrVal("Fg_vip"));
	}	
	/**
	 * VIP标识
	 * @param Fg_vip
	 */
	public void setFg_vip(FBoolean Fg_vip) {
		setAttrVal("Fg_vip", Fg_vip);
	}
	/**
	 * 科研标识
	 * @return FBoolean
	 */
	public FBoolean getFg_research() {
		return ((FBoolean) getAttrVal("Fg_research"));
	}	
	/**
	 * 科研标识
	 * @param Fg_research
	 */
	public void setFg_research(FBoolean Fg_research) {
		setAttrVal("Fg_research", Fg_research);
	}
	/**
	 * 科研项目主键
	 * @return String
	 */
	public String getId_researchproject() {
		return ((String) getAttrVal("Id_researchproject"));
	}	
	/**
	 * 科研项目主键
	 * @param Id_researchproject
	 */
	public void setId_researchproject(String Id_researchproject) {
		setAttrVal("Id_researchproject", Id_researchproject);
	}
	/**
	 * 科研项目信息
	 * @return String
	 */
	public String getResearchinfo() {
		return ((String) getAttrVal("Researchinfo"));
	}	
	/**
	 * 科研项目信息
	 * @param Researchinfo
	 */
	public void setResearchinfo(String Researchinfo) {
		setAttrVal("Researchinfo", Researchinfo);
	}
	/**
	 * 患者体重
	 * @return FDouble
	 */
	public FDouble getWeight() {
		return ((FDouble) getAttrVal("Weight"));
	}	
	/**
	 * 患者体重
	 * @param Weight
	 */
	public void setWeight(FDouble Weight) {
		setAttrVal("Weight", Weight);
	}
	/**
	 * 患者体重单位
	 * @return String
	 */
	public String getId_weight_unit() {
		return ((String) getAttrVal("Id_weight_unit"));
	}	
	/**
	 * 患者体重单位
	 * @param Id_weight_unit
	 */
	public void setId_weight_unit(String Id_weight_unit) {
		setAttrVal("Id_weight_unit", Id_weight_unit);
	}
	/**
	 * 院内制剂
	 * @return FBoolean
	 */
	public FBoolean getFg_hospital_herbpres() {
		return ((FBoolean) getAttrVal("Fg_hospital_herbpres"));
	}	
	/**
	 * 院内制剂
	 * @param Fg_hospital_herbpres
	 */
	public void setFg_hospital_herbpres(FBoolean Fg_hospital_herbpres) {
		setAttrVal("Fg_hospital_herbpres", Fg_hospital_herbpres);
	}
	/**
	 * 疾病病种ID
	 * @return String
	 */
	public String getId_dsdef() {
		return ((String) getAttrVal("Id_dsdef"));
	}	
	/**
	 * 疾病病种ID
	 * @param Id_dsdef
	 */
	public void setId_dsdef(String Id_dsdef) {
		setAttrVal("Id_dsdef", Id_dsdef);
	}
	/**
	 * 疾病病种编码
	 * @return String
	 */
	public String getCode_dsdef() {
		return ((String) getAttrVal("Code_dsdef"));
	}	
	/**
	 * 疾病病种编码
	 * @param Code_dsdef
	 */
	public void setCode_dsdef(String Code_dsdef) {
		setAttrVal("Code_dsdef", Code_dsdef);
	}
	/**
	 * 疾病病种名称
	 * @return String
	 */
	public String getName_dsdef() {
		return ((String) getAttrVal("Name_dsdef"));
	}	
	/**
	 * 疾病病种名称
	 * @param Name_dsdef
	 */
	public void setName_dsdef(String Name_dsdef) {
		setAttrVal("Name_dsdef", Name_dsdef);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getPrestp_name() {
		return ((String) getAttrVal("Prestp_name"));
	}	
	/**
	 * 名称
	 * @param Prestp_name
	 */
	public void setPrestp_name(String Prestp_name) {
		setAttrVal("Prestp_name", Prestp_name);
	}
	/**
	 * 计量单位名称
	 * @return String
	 */
	public String getName_weight_unit() {
		return ((String) getAttrVal("Name_weight_unit"));
	}	
	/**
	 * 计量单位名称
	 * @param Name_weight_unit
	 */
	public void setName_weight_unit(String Name_weight_unit) {
		setAttrVal("Name_weight_unit", Name_weight_unit);
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
		return "Id_pres";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_pres";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiPresDODesc.class);
	}
	
}