package iih.ci.ord.ciorder.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import java.math.BigDecimal;

/**
 * 临床医嘱 DO数据 
 * 
 */
public class CiOrderDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医嘱主键标识
	public static final String ID_OR= "Id_or";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//患者
	public static final String ID_PAT= "Id_pat";
	//就诊
	public static final String ID_EN= "Id_en";
	//就诊类型
	public static final String ID_ENTP= "Id_entp";
	//就诊类型编码
	public static final String CODE_ENTP= "Code_entp";
	//医嘱类型
	public static final String ID_SRVTP= "Id_srvtp";
	//医嘱类型编码
	public static final String SD_SRVTP= "Sd_srvtp";
	//服务
	public static final String ID_SRV= "Id_srv";
	//服务套标识
	public static final String FG_SET= "Fg_set";
	//医疗服务包
	public static final String ID_SRV_PKG= "Id_srv_pkg";
	//长临标识
	public static final String FG_LONG= "Fg_long";
	//医嘱编码
	public static final String CODE_OR= "Code_or";
	//医嘱内容
	public static final String CONTENT_OR= "Content_or";
	//备注(当前使用)
	public static final String DES_OR= "Des_or";
	//医嘱频次
	public static final String ID_FREQ= "Id_freq";
	//医嘱付数
	public static final String ORDERS= "Orders";
	//代煎标识
	public static final String FG_BOIL= "Fg_boil";
	//代煎付数
	public static final String ORDERS_BOIL= "Orders_boil";
	//医嘱用法
	public static final String ID_ROUTE= "Id_route";
	//医嘱用法要求
	public static final String ID_ROUTEDES= "Id_routedes";
	//煎法
	public static final String ID_BOIL= "Id_boil";
	//煎法要求
	public static final String ID_BOILDES= "Id_boildes";
	//医嘱天数
	public static final String DAYS_OR= "Days_or";
	//医嘱状态
	public static final String ID_SU_OR= "Id_su_or";
	//医嘱状态编码
	public static final String SD_SU_OR= "Sd_su_or";
	//执行状态
	public static final String ID_SU_MP= "Id_su_mp";
	//执行状态编码
	public static final String SD_SU_MP= "Sd_su_mp";
	//记账状态
	public static final String ID_SU_BL= "Id_su_bl";
	//记账状态编码
	public static final String SD_SU_BL= "Sd_su_bl";
	//开立机构
	public static final String ID_ORG_OR= "Id_org_or";
	//开立部门
	public static final String ID_DEP_OR= "Id_dep_or";
	//开立医疗组
	public static final String ID_WG_OR= "Id_wg_or";
	//开立医生
	public static final String ID_EMP_OR= "Id_emp_or";
	//开立日期
	public static final String DT_ENTRY= "Dt_entry";
	//签署标识
	public static final String FG_SIGN= "Fg_sign";
	//签署医生
	public static final String ID_EMP_SIGN= "Id_emp_sign";
	//签署部门
	public static final String ID_DEP_SIGN= "Id_dep_sign";
	//签署日期
	public static final String DT_SIGN= "Dt_sign";
	//医嘱生效日期
	public static final String DT_EFFE= "Dt_effe";
	//医嘱结束时间
	public static final String DT_END= "Dt_end";
	//医嘱过期时间
	public static final String DT_INVALID= "Dt_invalid";
	//核对标识
	public static final String FG_CHK= "Fg_chk";
	//核对护士
	public static final String ID_EMP_CHK= "Id_emp_chk";
	//核对病区
	public static final String ID_DEP_CHK= "Id_dep_chk";
	//核对日期
	public static final String DT_CHK= "Dt_chk";
	//停止标识
	public static final String FG_STOP= "Fg_stop";
	//停止医生
	public static final String ID_EMP_STOP= "Id_emp_stop";
	//停止科室
	public static final String ID_DEP_STOP= "Id_dep_stop";
	//停止日期(记录设置医嘱结束日期的时间)
	public static final String DT_STOP= "Dt_stop";
	//停止核对标识
	public static final String FG_CHK_STOP= "Fg_chk_stop";
	//停止核对护士
	public static final String ID_EMP_CHK_STOP= "Id_emp_chk_stop";
	//停止核对病区
	public static final String ID_DEP_CHK_STOP= "Id_dep_chk_stop";
	//停止核对日期
	public static final String DT_CHK_STOP= "Dt_chk_stop";
	//作废标识
	public static final String FG_CANC= "Fg_canc";
	//作废医生
	public static final String ID_EMP_CANC= "Id_emp_canc";
	//作废科室
	public static final String ID_DEP_CANC= "Id_dep_canc";
	//作废日期
	public static final String DT_CANC= "Dt_canc";
	//作废核对标识
	public static final String FG_CHK_CANC= "Fg_chk_canc";
	//作废核对护士
	public static final String ID_EMP_CHK_CANC= "Id_emp_chk_canc";
	//作废核对病区
	public static final String ID_DEP_CHK_CANC= "Id_dep_chk_canc";
	//作废核对日期
	public static final String DT_CHK_CANC= "Dt_chk_canc";
	//备用医嘱标识
	public static final String FG_PMOR= "Fg_pmor";
	//备用医嘱使用条件描述
	public static final String DES_PMOR= "Des_pmor";
	//备用医嘱启用标识
	public static final String FG_ACTIVE_PM= "Fg_active_pm";
	//关联类型
	public static final String ID_RELTP= "Id_reltp";
	//关联类型编码
	public static final String SD_RELTP= "Sd_reltp";
	//对应关联医嘱id
	public static final String ID_OR_REL= "Id_or_rel";
	//婴儿标识
	public static final String FG_BB= "Fg_bb";
	//婴儿序号
	public static final String NO_BB= "No_bb";
	//临床路径控制标识
	public static final String FG_CTLCP= "Fg_ctlcp";
	//医疗记录联动标识
	public static final String FG_MR= "Fg_mr";
	//皮试标识
	public static final String FG_SKINTEST= "Fg_skintest";
	//在院执行标识
	public static final String FG_MP_IN= "Fg_mp_in";
	//在院执行次数
	public static final String TIMES_MP_IN= "Times_mp_in";
	//床边执行标识
	public static final String FG_MP_BED= "Fg_mp_bed";
	//医嘱备注（已经废弃）
	public static final String NOTE_OR= "Note_or";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//药师审核状态
	public static final String EU_VERIFY_PHARM= "Eu_verify_pharm";
	//药师审核建议
	public static final String DES_VERIFY_PHARM= "Des_verify_pharm";
	//药师审核异常级别
	public static final String ID_EXCEP_LEVEL_PHARM= "Id_excep_level_pharm";
	//药师审核异常级别编码
	public static final String SD_EXCEP_LEVEL_PHARM= "Sd_excep_level_pharm";
	//合理用药审核结果
	public static final String DES_VERIFY_SYS= "Des_verify_sys";
	//合理用药审核异常级别
	public static final String ID_EXCEP_LEVEL_SYS= "Id_excep_level_sys";
	//合理用药审核异常级别编码
	public static final String SD_EXCEP_LEVEL_SYS= "Sd_excep_level_sys";
	//审核药师
	public static final String ID_EMP_VERIFY_PHARM= "Id_emp_verify_pharm";
	//药师审核时间
	public static final String DT_VERIFY_PHARM= "Dt_verify_pharm";
	//医师反馈意见
	public static final String DES_BK_PHARM= "Des_bk_pharm";
	//医师反馈时间
	public static final String DT_BK_PHARM= "Dt_bk_pharm";
	//反馈医师
	public static final String ID_EMP_BK_PHARM= "Id_emp_bk_pharm";
	//服务包标识
	public static final String FG_PKG= "Fg_pkg";
	//长临
	public static final String STR_LONG= "Str_long";
	//医嘱名称
	public static final String NAME_OR= "Name_or";
	//首日执行次数
	public static final String QUAN_FIRDAY_MP= "Quan_firday_mp";
	//医嘱单标识
	public static final String FG_OR_FORM= "Fg_or_form";
	//不皮试原因（废弃不用了）
	public static final String ID_SKINTEST_SKIP_REASON= "Id_skintest_skip_reason";
	//不皮试原因编码（废弃不用了）
	public static final String SD_SKINTEST_SKIP_REASON= "Sd_skintest_skip_reason";
	//出院带药标识
	public static final String FG_PRES_OUTP= "Fg_pres_outp";
	//医疗单URL
	public static final String FUNCCLASSSTR= "Funcclassstr";
	//医疗单
	public static final String ID_SRVOF= "Id_srvof";
	//申请单号
	public static final String APPLYNO= "Applyno";
	//最近生成日期
	public static final String DT_LAST_BL= "Dt_last_bl";
	//加急标识
	public static final String FG_URGENT= "Fg_urgent";
	//医嘱综合状态
	public static final String ORD_COLLIGATE= "Ord_colligate";
	//金额
	public static final String AMOUNT= "Amount";
	//医嘱结果（废弃不用了）（集成平台处方撤回使用）
	public static final String RESULT= "Result";
	//医嘱执行闭环类型
	public static final String ID_ORPLTP= "Id_orpltp";
	//服务基本分类
	public static final String ID_SRVCA= "Id_srvca";
	//次数
	public static final String TIMES_CUR= "Times_cur";
	//医嘱结果
	public static final String ID_ORRSTTP= "Id_orrsttp";
	//医嘱结果编码
	public static final String SD_ORRSTTP= "Sd_orrsttp";
	//执行科室
	public static final String ID_DEP_MP= "Id_dep_mp";
	//最近执行时间
	public static final String DT_LAST_MP= "Dt_last_mp";
	//医学单位
	public static final String ID_UNIT_MED= "Id_unit_med";
	//医学单位数量
	public static final String QUAN_MEDU= "Quan_medu";
	//服务分类内码
	public static final String INNERCODE_SRVCA= "Innercode_srvca";
	//医嘱不可取消标识
	public static final String FG_UNCANCELABLE= "Fg_uncancelable";
	//医保适应症判断标识枚举
	public static final String EU_HPINDICJUDGE= "Eu_hpindicjudge";
	//非径内医生界面判断
	public static final String EU_UNCPORDOCTORJUDGE= "Eu_uncpordoctorjudge";
	//非径内医嘱判断标识枚举
	public static final String EU_UNCPORJUDGE= "Eu_uncporjudge";
	//径外医嘱使用原因
	public static final String REASON_UNCPORUSE= "Reason_uncporuse";
	//医嘱目的
	public static final String PURPOSE_OR= "Purpose_or";
	//刷新到病历标识
	public static final String FG_FLUSH2MR= "Fg_flush2mr";
	//可退费标识
	public static final String FG_FEERTNABLE= "Fg_feertnable";
	//简化的流程标识
	public static final String FG_QUICKWFLOW= "Fg_quickwflow";
	//医嘱来源方式类型
	public static final String EU_ORSRCMDTP= "Eu_orsrcmdtp";
	//医嘱来源主标识
	public static final String ID_ORSRC_MAIN= "Id_orsrc_main";
	//医嘱来源子标识
	public static final String ID_ORSRC_SUB= "Id_orsrc_sub";
	//医嘱来源孙标识
	public static final String ID_ORSRC_SUBSUB= "Id_orsrc_subsub";
	//基本医保判断结果数据信息
	public static final String BHPJUDGERST= "Bhpjudgerst";
	//基本医保判断结果数据信息描述
	public static final String DES_BHPJUDGERST= "Des_bhpjudgerst";
	//VIP标识
	public static final String FG_VIP= "Fg_vip";
	//医嘱预付费记账标识
	public static final String FG_PREPAY= "Fg_prepay";
	//临床项目医保标识
	public static final String FG_ORHP= "Fg_orhp";
	//费用冲账类型
	public static final String EU_FEEREVERSETP= "Eu_feereversetp";
	//医保细规则提示信息
	public static final String MDICALINFO= "Mdicalinfo";
	//超量开单原因id
	public static final String ID_EXCESSIVE_REASON= "Id_excessive_reason";
	//超量开单原因sd
	public static final String SD_EXCESSIVE_REASON= "Sd_excessive_reason";
	//医嘱总金额
	public static final String OR_TOTAL_PRI= "Or_total_pri";
	//总量开单方式
	public static final String SD_TOTALOPENMODE= "Sd_totalopenmode";
	//医嘱排序
	public static final String SORTNO= "Sortno";
	//是否多次执行
	public static final String ISMULEXEC= "Ismulexec";
	//是否多量开单
	public static final String ISMULDOSE= "Ismuldose";
	//科研标识
	public static final String FG_RESEARCH= "Fg_research";
	//科研项目主键
	public static final String ID_RESEARCHPROJECT= "Id_researchproject";
	//科研项目编码
	public static final String CODE_RESEARCHPROJECT= "Code_researchproject";
	//草药院内制剂
	public static final String FG_HOSPITAL_HERBPRES= "Fg_hospital_herbpres";
	//产房使用
	public static final String FG_DELIVERYROOM_USE= "Fg_deliveryroom_use";
	//错误级别
	public static final String ERROR_LEVEL= "Error_level";
	//错误信息描述
	public static final String ERROR_DES= "Error_des";
	//护士核对拒绝确认类型
	public static final String EU_REFUSECHECKTP= "Eu_refusechecktp";
	//拒绝确认标志
	public static final String FG_REFUSECHECK= "Fg_refusecheck";
	//拒绝确认人
	public static final String ID_EMP_REFUSECHECK= "Id_emp_refusecheck";
	//拒绝确认时间
	public static final String DT_REFUSECHECK= "Dt_refusecheck";
	//单位支付标志
	public static final String FG_PAY_UNIT= "Fg_pay_unit";
	//开单病区
	public static final String ID_DEP_NUR_OR= "Id_dep_nur_or";
	//复核标识
	public static final String FG_RECHECK= "Fg_recheck";
	//复核护士
	public static final String ID_EMP_RECHECK= "Id_emp_recheck";
	//复核时间
	public static final String DT_RECHECK= "Dt_recheck";
	//是否需要特殊级抗菌药审批
	public static final String FG_SPEC_ANTI_APPROVE= "Fg_spec_anti_approve";
	//特殊级抗菌药审批结果
	public static final String SD_SPEC_ANTI_APPROVE= "Sd_spec_anti_approve";
	//第二和对人主键
	public static final String ID_EMP_SECOND_CHK= "Id_emp_second_chk";
	//打印到医嘱单
	public static final String FG_PRN= "Fg_prn";
	//医嘱来源功能id
	public static final String ID_ORSRCFUN= "Id_orsrcfun";
	//医嘱来源功能sd
	public static final String SD_ORSRCFUN= "Sd_orsrcfun";
	//手术状态
	public static final String OPERATION_STATUS= "Operation_status";
	//是否感染科会诊
	public static final String FG_INFECT_DEP_CONS= "Fg_infect_dep_cons";
	//诊断定义中的主键
	public static final String ID_DIDEF= "Id_didef";
	//诊断名称（考虑存在自定义诊断的情况，所以 ）
	public static final String NAME_DIDEF= "Name_didef";
	//超额原因
	public static final String MORE_MONEY_REASON= "More_money_reason";
	//提醒护士确认消息id
	public static final String ID_MESSAGE= "Id_message";
	//滴速
	public static final String ID_DRIPSPEED= "Id_dripspeed";
	//滴速名称
	public static final String NAME_DRIPSPEED= "Name_dripspeed";
	//领药方式ID
	public static final String ID_DRUGDELIVERYMETHOD= "Id_drugdeliverymethod";
	//领药方式编码
	public static final String SD_DRUGDELIVERYMETHOD= "Sd_drugdeliverymethod";
	//领药方式名称
	public static final String NAME_DRUGDELIVERYMETHOD= "Name_drugdeliverymethod";
	//在院整领标识
	public static final String FG_WHOLEPACK= "Fg_wholepack";
	//医保判断方式
	public static final String EU_HPJUDGE= "Eu_hpjudge";
	//医保判断结果
	public static final String EU_ORHP= "Eu_orhp";
	//退药标识
	public static final String FG_BACK= "Fg_back";
	//关联原发药医嘱ID
	public static final String ID_OR_SRC= "Id_or_src";
	//医嘱需审批标志
	public static final String FG_APPROVE_OR= "Fg_approve_or";
	//医嘱审批类型
	public static final String SD_APPRIVETPS_OR= "Sd_apprivetps_or";
	//提交审批标志
	public static final String FG_APPROVE_SUBMIT= "Fg_approve_submit";
	//审批结果
	public static final String EU_APPROVE_OR= "Eu_approve_or";
	//医嘱可流向科室字符串
	public static final String ID_MP_DEPTS= "Id_mp_depts";
	//患者姓名
	public static final String PAT_NAME= "Pat_name";
	//性别
	public static final String PAT_ID_SEX= "Pat_id_sex";
	//出生日期
	public static final String PAT_DT_BIRTH= "Pat_dt_birth";
	//性别编码
	public static final String PAT_SD_SEX= "Pat_sd_sex";
	//当前就诊科室
	public static final String ID_DEP_NS= "Id_dep_ns";
	//当前医疗组
	public static final String ID_WG_NS= "Id_wg_ns";
	//当前护理单元
	public static final String ID_DEP_NUR= "Id_dep_nur";
	//就诊类型名称
	public static final String ENTP_NAME= "Entp_name";
	//名称
	public static final String SRVTP_NAME= "Srvtp_name";
	//服务名称
	public static final String SRV_PKG_NAME= "Srv_pkg_name";
	//频次名称
	public static final String FREQ_NAME= "Freq_name";
	//频次周期数
	public static final String FREQUNITCT= "Frequnitct";
	//频次周期下次数
	public static final String FREQCT= "Freqct";
	//频次周期类型编码
	public static final String SD_FREQUNITCT= "Sd_frequnitct";
	//显示编码
	public static final String CODE_DISP= "Code_disp";
	//用法名称
	public static final String ROUTE_NAME= "Route_name";
	//用法要求
	public static final String ROUTEDES_NAME= "Routedes_name";
	//煎法名称
	public static final String BOIL_NAME= "Boil_name";
	//煎法要求
	public static final String BOILDES_NAME= "Boildes_name";
	//名称
	public static final String SU_OR_NAME= "Su_or_name";
	//名称
	public static final String SD_SU_NAME= "Sd_su_name";
	//组织名称
	public static final String ORG_OR_NAME= "Org_or_name";
	//名称
	public static final String DEPT_OR_NAME= "Dept_or_name";
	//业务组名称
	public static final String WG_OR_NAME= "Wg_or_name";
	//姓名
	public static final String EMP_PHY_NAME= "Emp_phy_name";
	//姓名
	public static final String EMP_SIGN_NAME= "Emp_sign_name";
	//名称
	public static final String DEP_SIGN_NAME= "Dep_sign_name";
	//姓名
	public static final String EMP_CHK_NAME= "Emp_chk_name";
	//名称
	public static final String DEP_NUR_NAME= "Dep_nur_name";
	//姓名
	public static final String EMP_STOP_NAME= "Emp_stop_name";
	//名称
	public static final String DEP_STOP_NAME= "Dep_stop_name";
	//姓名
	public static final String EMP_CHK_STOP_NAME= "Emp_chk_stop_name";
	//姓名
	public static final String EMP_CANC_NAME= "Emp_canc_name";
	//名称
	public static final String DEP_CANC_NAME= "Dep_canc_name";
	//姓名
	public static final String EMP_CHK_CANC_NAME= "Emp_chk_canc_name";
	//名称
	public static final String DEP_CHK_CANC_NAME= "Dep_chk_canc_name";
	//名称
	public static final String RELTP_NAME= "Reltp_name";
	//医嘱名称
	public static final String OR_REL_NAME= "Or_rel_name";
	//名称
	public static final String NAME_DEP_MP= "Name_dep_mp";
	//计量单位名称
	public static final String NAME_UNIT_MED= "Name_unit_med";
	//名称
	public static final String NAME_EXCESSIVE_REASON= "Name_excessive_reason";
	//科研项目名称
	public static final String NAME_RESEARCHPROJECT= "Name_researchproject";
	//科研项目密码
	public static final String PASSWORD= "Password";
	//姓名
	public static final String NAME_EMP_SECOND_CHK= "Name_emp_second_chk";
	//诊断编码
	public static final String CODE_DIDEF= "Code_didef";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医嘱主键标识
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 医嘱主键标识
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
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
	 * 医嘱类型
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	/**
	 * 医嘱类型
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
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
	 * 医疗服务包
	 * @return String
	 */
	public String getId_srv_pkg() {
		return ((String) getAttrVal("Id_srv_pkg"));
	}	
	/**
	 * 医疗服务包
	 * @param Id_srv_pkg
	 */
	public void setId_srv_pkg(String Id_srv_pkg) {
		setAttrVal("Id_srv_pkg", Id_srv_pkg);
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
	 * 备注(当前使用)
	 * @return String
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}	
	/**
	 * 备注(当前使用)
	 * @param Des_or
	 */
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
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
	 * 代煎标识
	 * @return FBoolean
	 */
	public FBoolean getFg_boil() {
		return ((FBoolean) getAttrVal("Fg_boil"));
	}	
	/**
	 * 代煎标识
	 * @param Fg_boil
	 */
	public void setFg_boil(FBoolean Fg_boil) {
		setAttrVal("Fg_boil", Fg_boil);
	}
	/**
	 * 代煎付数
	 * @return Integer
	 */
	public Integer getOrders_boil() {
		return ((Integer) getAttrVal("Orders_boil"));
	}	
	/**
	 * 代煎付数
	 * @param Orders_boil
	 */
	public void setOrders_boil(Integer Orders_boil) {
		setAttrVal("Orders_boil", Orders_boil);
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
	 * 医嘱状态
	 * @return String
	 */
	public String getId_su_or() {
		return ((String) getAttrVal("Id_su_or"));
	}	
	/**
	 * 医嘱状态
	 * @param Id_su_or
	 */
	public void setId_su_or(String Id_su_or) {
		setAttrVal("Id_su_or", Id_su_or);
	}
	/**
	 * 医嘱状态编码
	 * @return String
	 */
	public String getSd_su_or() {
		return ((String) getAttrVal("Sd_su_or"));
	}	
	/**
	 * 医嘱状态编码
	 * @param Sd_su_or
	 */
	public void setSd_su_or(String Sd_su_or) {
		setAttrVal("Sd_su_or", Sd_su_or);
	}
	/**
	 * 执行状态
	 * @return String
	 */
	public String getId_su_mp() {
		return ((String) getAttrVal("Id_su_mp"));
	}	
	/**
	 * 执行状态
	 * @param Id_su_mp
	 */
	public void setId_su_mp(String Id_su_mp) {
		setAttrVal("Id_su_mp", Id_su_mp);
	}
	/**
	 * 执行状态编码
	 * @return String
	 */
	public String getSd_su_mp() {
		return ((String) getAttrVal("Sd_su_mp"));
	}	
	/**
	 * 执行状态编码
	 * @param Sd_su_mp
	 */
	public void setSd_su_mp(String Sd_su_mp) {
		setAttrVal("Sd_su_mp", Sd_su_mp);
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
	 * 开立机构
	 * @return String
	 */
	public String getId_org_or() {
		return ((String) getAttrVal("Id_org_or"));
	}	
	/**
	 * 开立机构
	 * @param Id_org_or
	 */
	public void setId_org_or(String Id_org_or) {
		setAttrVal("Id_org_or", Id_org_or);
	}
	/**
	 * 开立部门
	 * @return String
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}	
	/**
	 * 开立部门
	 * @param Id_dep_or
	 */
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	/**
	 * 开立医疗组
	 * @return String
	 */
	public String getId_wg_or() {
		return ((String) getAttrVal("Id_wg_or"));
	}	
	/**
	 * 开立医疗组
	 * @param Id_wg_or
	 */
	public void setId_wg_or(String Id_wg_or) {
		setAttrVal("Id_wg_or", Id_wg_or);
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
	 * 医嘱过期时间
	 * @return FDateTime
	 */
	public FDateTime getDt_invalid() {
		return ((FDateTime) getAttrVal("Dt_invalid"));
	}	
	/**
	 * 医嘱过期时间
	 * @param Dt_invalid
	 */
	public void setDt_invalid(FDateTime Dt_invalid) {
		setAttrVal("Dt_invalid", Dt_invalid);
	}
	/**
	 * 核对标识
	 * @return FBoolean
	 */
	public FBoolean getFg_chk() {
		return ((FBoolean) getAttrVal("Fg_chk"));
	}	
	/**
	 * 核对标识
	 * @param Fg_chk
	 */
	public void setFg_chk(FBoolean Fg_chk) {
		setAttrVal("Fg_chk", Fg_chk);
	}
	/**
	 * 核对护士
	 * @return String
	 */
	public String getId_emp_chk() {
		return ((String) getAttrVal("Id_emp_chk"));
	}	
	/**
	 * 核对护士
	 * @param Id_emp_chk
	 */
	public void setId_emp_chk(String Id_emp_chk) {
		setAttrVal("Id_emp_chk", Id_emp_chk);
	}
	/**
	 * 核对病区
	 * @return String
	 */
	public String getId_dep_chk() {
		return ((String) getAttrVal("Id_dep_chk"));
	}	
	/**
	 * 核对病区
	 * @param Id_dep_chk
	 */
	public void setId_dep_chk(String Id_dep_chk) {
		setAttrVal("Id_dep_chk", Id_dep_chk);
	}
	/**
	 * 核对日期
	 * @return FDateTime
	 */
	public FDateTime getDt_chk() {
		return ((FDateTime) getAttrVal("Dt_chk"));
	}	
	/**
	 * 核对日期
	 * @param Dt_chk
	 */
	public void setDt_chk(FDateTime Dt_chk) {
		setAttrVal("Dt_chk", Dt_chk);
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
	 * 停止日期(记录设置医嘱结束日期的时间)
	 * @return FDateTime
	 */
	public FDateTime getDt_stop() {
		return ((FDateTime) getAttrVal("Dt_stop"));
	}	
	/**
	 * 停止日期(记录设置医嘱结束日期的时间)
	 * @param Dt_stop
	 */
	public void setDt_stop(FDateTime Dt_stop) {
		setAttrVal("Dt_stop", Dt_stop);
	}
	/**
	 * 停止核对标识
	 * @return FBoolean
	 */
	public FBoolean getFg_chk_stop() {
		return ((FBoolean) getAttrVal("Fg_chk_stop"));
	}	
	/**
	 * 停止核对标识
	 * @param Fg_chk_stop
	 */
	public void setFg_chk_stop(FBoolean Fg_chk_stop) {
		setAttrVal("Fg_chk_stop", Fg_chk_stop);
	}
	/**
	 * 停止核对护士
	 * @return String
	 */
	public String getId_emp_chk_stop() {
		return ((String) getAttrVal("Id_emp_chk_stop"));
	}	
	/**
	 * 停止核对护士
	 * @param Id_emp_chk_stop
	 */
	public void setId_emp_chk_stop(String Id_emp_chk_stop) {
		setAttrVal("Id_emp_chk_stop", Id_emp_chk_stop);
	}
	/**
	 * 停止核对病区
	 * @return String
	 */
	public String getId_dep_chk_stop() {
		return ((String) getAttrVal("Id_dep_chk_stop"));
	}	
	/**
	 * 停止核对病区
	 * @param Id_dep_chk_stop
	 */
	public void setId_dep_chk_stop(String Id_dep_chk_stop) {
		setAttrVal("Id_dep_chk_stop", Id_dep_chk_stop);
	}
	/**
	 * 停止核对日期
	 * @return FDateTime
	 */
	public FDateTime getDt_chk_stop() {
		return ((FDateTime) getAttrVal("Dt_chk_stop"));
	}	
	/**
	 * 停止核对日期
	 * @param Dt_chk_stop
	 */
	public void setDt_chk_stop(FDateTime Dt_chk_stop) {
		setAttrVal("Dt_chk_stop", Dt_chk_stop);
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
	 * 作废核对标识
	 * @return FBoolean
	 */
	public FBoolean getFg_chk_canc() {
		return ((FBoolean) getAttrVal("Fg_chk_canc"));
	}	
	/**
	 * 作废核对标识
	 * @param Fg_chk_canc
	 */
	public void setFg_chk_canc(FBoolean Fg_chk_canc) {
		setAttrVal("Fg_chk_canc", Fg_chk_canc);
	}
	/**
	 * 作废核对护士
	 * @return String
	 */
	public String getId_emp_chk_canc() {
		return ((String) getAttrVal("Id_emp_chk_canc"));
	}	
	/**
	 * 作废核对护士
	 * @param Id_emp_chk_canc
	 */
	public void setId_emp_chk_canc(String Id_emp_chk_canc) {
		setAttrVal("Id_emp_chk_canc", Id_emp_chk_canc);
	}
	/**
	 * 作废核对病区
	 * @return String
	 */
	public String getId_dep_chk_canc() {
		return ((String) getAttrVal("Id_dep_chk_canc"));
	}	
	/**
	 * 作废核对病区
	 * @param Id_dep_chk_canc
	 */
	public void setId_dep_chk_canc(String Id_dep_chk_canc) {
		setAttrVal("Id_dep_chk_canc", Id_dep_chk_canc);
	}
	/**
	 * 作废核对日期
	 * @return FDateTime
	 */
	public FDateTime getDt_chk_canc() {
		return ((FDateTime) getAttrVal("Dt_chk_canc"));
	}	
	/**
	 * 作废核对日期
	 * @param Dt_chk_canc
	 */
	public void setDt_chk_canc(FDateTime Dt_chk_canc) {
		setAttrVal("Dt_chk_canc", Dt_chk_canc);
	}
	/**
	 * 备用医嘱标识
	 * @return FBoolean
	 */
	public FBoolean getFg_pmor() {
		return ((FBoolean) getAttrVal("Fg_pmor"));
	}	
	/**
	 * 备用医嘱标识
	 * @param Fg_pmor
	 */
	public void setFg_pmor(FBoolean Fg_pmor) {
		setAttrVal("Fg_pmor", Fg_pmor);
	}
	/**
	 * 备用医嘱使用条件描述
	 * @return String
	 */
	public String getDes_pmor() {
		return ((String) getAttrVal("Des_pmor"));
	}	
	/**
	 * 备用医嘱使用条件描述
	 * @param Des_pmor
	 */
	public void setDes_pmor(String Des_pmor) {
		setAttrVal("Des_pmor", Des_pmor);
	}
	/**
	 * 备用医嘱启用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active_pm() {
		return ((FBoolean) getAttrVal("Fg_active_pm"));
	}	
	/**
	 * 备用医嘱启用标识
	 * @param Fg_active_pm
	 */
	public void setFg_active_pm(FBoolean Fg_active_pm) {
		setAttrVal("Fg_active_pm", Fg_active_pm);
	}
	/**
	 * 关联类型
	 * @return String
	 */
	public String getId_reltp() {
		return ((String) getAttrVal("Id_reltp"));
	}	
	/**
	 * 关联类型
	 * @param Id_reltp
	 */
	public void setId_reltp(String Id_reltp) {
		setAttrVal("Id_reltp", Id_reltp);
	}
	/**
	 * 关联类型编码
	 * @return String
	 */
	public String getSd_reltp() {
		return ((String) getAttrVal("Sd_reltp"));
	}	
	/**
	 * 关联类型编码
	 * @param Sd_reltp
	 */
	public void setSd_reltp(String Sd_reltp) {
		setAttrVal("Sd_reltp", Sd_reltp);
	}
	/**
	 * 对应关联医嘱id
	 * @return String
	 */
	public String getId_or_rel() {
		return ((String) getAttrVal("Id_or_rel"));
	}	
	/**
	 * 对应关联医嘱id
	 * @param Id_or_rel
	 */
	public void setId_or_rel(String Id_or_rel) {
		setAttrVal("Id_or_rel", Id_or_rel);
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
	 * 临床路径控制标识
	 * @return FBoolean
	 */
	public FBoolean getFg_ctlcp() {
		return ((FBoolean) getAttrVal("Fg_ctlcp"));
	}	
	/**
	 * 临床路径控制标识
	 * @param Fg_ctlcp
	 */
	public void setFg_ctlcp(FBoolean Fg_ctlcp) {
		setAttrVal("Fg_ctlcp", Fg_ctlcp);
	}
	/**
	 * 医疗记录联动标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mr() {
		return ((FBoolean) getAttrVal("Fg_mr"));
	}	
	/**
	 * 医疗记录联动标识
	 * @param Fg_mr
	 */
	public void setFg_mr(FBoolean Fg_mr) {
		setAttrVal("Fg_mr", Fg_mr);
	}
	/**
	 * 皮试标识
	 * @return FBoolean
	 */
	public FBoolean getFg_skintest() {
		return ((FBoolean) getAttrVal("Fg_skintest"));
	}	
	/**
	 * 皮试标识
	 * @param Fg_skintest
	 */
	public void setFg_skintest(FBoolean Fg_skintest) {
		setAttrVal("Fg_skintest", Fg_skintest);
	}
	/**
	 * 在院执行标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mp_in() {
		return ((FBoolean) getAttrVal("Fg_mp_in"));
	}	
	/**
	 * 在院执行标识
	 * @param Fg_mp_in
	 */
	public void setFg_mp_in(FBoolean Fg_mp_in) {
		setAttrVal("Fg_mp_in", Fg_mp_in);
	}
	/**
	 * 在院执行次数
	 * @return Integer
	 */
	public Integer getTimes_mp_in() {
		return ((Integer) getAttrVal("Times_mp_in"));
	}	
	/**
	 * 在院执行次数
	 * @param Times_mp_in
	 */
	public void setTimes_mp_in(Integer Times_mp_in) {
		setAttrVal("Times_mp_in", Times_mp_in);
	}
	/**
	 * 床边执行标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mp_bed() {
		return ((FBoolean) getAttrVal("Fg_mp_bed"));
	}	
	/**
	 * 床边执行标识
	 * @param Fg_mp_bed
	 */
	public void setFg_mp_bed(FBoolean Fg_mp_bed) {
		setAttrVal("Fg_mp_bed", Fg_mp_bed);
	}
	/**
	 * 医嘱备注（已经废弃）
	 * @return String
	 */
	public String getNote_or() {
		return ((String) getAttrVal("Note_or"));
	}	
	/**
	 * 医嘱备注（已经废弃）
	 * @param Note_or
	 */
	public void setNote_or(String Note_or) {
		setAttrVal("Note_or", Note_or);
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
	 * 药师审核状态
	 * @return Integer
	 */
	public Integer getEu_verify_pharm() {
		return ((Integer) getAttrVal("Eu_verify_pharm"));
	}	
	/**
	 * 药师审核状态
	 * @param Eu_verify_pharm
	 */
	public void setEu_verify_pharm(Integer Eu_verify_pharm) {
		setAttrVal("Eu_verify_pharm", Eu_verify_pharm);
	}
	/**
	 * 药师审核建议
	 * @return String
	 */
	public String getDes_verify_pharm() {
		return ((String) getAttrVal("Des_verify_pharm"));
	}	
	/**
	 * 药师审核建议
	 * @param Des_verify_pharm
	 */
	public void setDes_verify_pharm(String Des_verify_pharm) {
		setAttrVal("Des_verify_pharm", Des_verify_pharm);
	}
	/**
	 * 药师审核异常级别
	 * @return String
	 */
	public String getId_excep_level_pharm() {
		return ((String) getAttrVal("Id_excep_level_pharm"));
	}	
	/**
	 * 药师审核异常级别
	 * @param Id_excep_level_pharm
	 */
	public void setId_excep_level_pharm(String Id_excep_level_pharm) {
		setAttrVal("Id_excep_level_pharm", Id_excep_level_pharm);
	}
	/**
	 * 药师审核异常级别编码
	 * @return String
	 */
	public String getSd_excep_level_pharm() {
		return ((String) getAttrVal("Sd_excep_level_pharm"));
	}	
	/**
	 * 药师审核异常级别编码
	 * @param Sd_excep_level_pharm
	 */
	public void setSd_excep_level_pharm(String Sd_excep_level_pharm) {
		setAttrVal("Sd_excep_level_pharm", Sd_excep_level_pharm);
	}
	/**
	 * 合理用药审核结果
	 * @return String
	 */
	public String getDes_verify_sys() {
		return ((String) getAttrVal("Des_verify_sys"));
	}	
	/**
	 * 合理用药审核结果
	 * @param Des_verify_sys
	 */
	public void setDes_verify_sys(String Des_verify_sys) {
		setAttrVal("Des_verify_sys", Des_verify_sys);
	}
	/**
	 * 合理用药审核异常级别
	 * @return String
	 */
	public String getId_excep_level_sys() {
		return ((String) getAttrVal("Id_excep_level_sys"));
	}	
	/**
	 * 合理用药审核异常级别
	 * @param Id_excep_level_sys
	 */
	public void setId_excep_level_sys(String Id_excep_level_sys) {
		setAttrVal("Id_excep_level_sys", Id_excep_level_sys);
	}
	/**
	 * 合理用药审核异常级别编码
	 * @return String
	 */
	public String getSd_excep_level_sys() {
		return ((String) getAttrVal("Sd_excep_level_sys"));
	}	
	/**
	 * 合理用药审核异常级别编码
	 * @param Sd_excep_level_sys
	 */
	public void setSd_excep_level_sys(String Sd_excep_level_sys) {
		setAttrVal("Sd_excep_level_sys", Sd_excep_level_sys);
	}
	/**
	 * 审核药师
	 * @return String
	 */
	public String getId_emp_verify_pharm() {
		return ((String) getAttrVal("Id_emp_verify_pharm"));
	}	
	/**
	 * 审核药师
	 * @param Id_emp_verify_pharm
	 */
	public void setId_emp_verify_pharm(String Id_emp_verify_pharm) {
		setAttrVal("Id_emp_verify_pharm", Id_emp_verify_pharm);
	}
	/**
	 * 药师审核时间
	 * @return FDateTime
	 */
	public FDateTime getDt_verify_pharm() {
		return ((FDateTime) getAttrVal("Dt_verify_pharm"));
	}	
	/**
	 * 药师审核时间
	 * @param Dt_verify_pharm
	 */
	public void setDt_verify_pharm(FDateTime Dt_verify_pharm) {
		setAttrVal("Dt_verify_pharm", Dt_verify_pharm);
	}
	/**
	 * 医师反馈意见
	 * @return String
	 */
	public String getDes_bk_pharm() {
		return ((String) getAttrVal("Des_bk_pharm"));
	}	
	/**
	 * 医师反馈意见
	 * @param Des_bk_pharm
	 */
	public void setDes_bk_pharm(String Des_bk_pharm) {
		setAttrVal("Des_bk_pharm", Des_bk_pharm);
	}
	/**
	 * 医师反馈时间
	 * @return FDateTime
	 */
	public FDateTime getDt_bk_pharm() {
		return ((FDateTime) getAttrVal("Dt_bk_pharm"));
	}	
	/**
	 * 医师反馈时间
	 * @param Dt_bk_pharm
	 */
	public void setDt_bk_pharm(FDateTime Dt_bk_pharm) {
		setAttrVal("Dt_bk_pharm", Dt_bk_pharm);
	}
	/**
	 * 反馈医师
	 * @return String
	 */
	public String getId_emp_bk_pharm() {
		return ((String) getAttrVal("Id_emp_bk_pharm"));
	}	
	/**
	 * 反馈医师
	 * @param Id_emp_bk_pharm
	 */
	public void setId_emp_bk_pharm(String Id_emp_bk_pharm) {
		setAttrVal("Id_emp_bk_pharm", Id_emp_bk_pharm);
	}
	/**
	 * 服务包标识
	 * @return FBoolean
	 */
	public FBoolean getFg_pkg() {
		return ((FBoolean) getAttrVal("Fg_pkg"));
	}	
	/**
	 * 服务包标识
	 * @param Fg_pkg
	 */
	public void setFg_pkg(FBoolean Fg_pkg) {
		setAttrVal("Fg_pkg", Fg_pkg);
	}
	/**
	 * 长临
	 * @return String
	 */
	public String getStr_long() {
		return ((String) getAttrVal("Str_long"));
	}	
	/**
	 * 长临
	 * @param Str_long
	 */
	public void setStr_long(String Str_long) {
		setAttrVal("Str_long", Str_long);
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
	 * 首日执行次数
	 * @return Integer
	 */
	public Integer getQuan_firday_mp() {
		return ((Integer) getAttrVal("Quan_firday_mp"));
	}	
	/**
	 * 首日执行次数
	 * @param Quan_firday_mp
	 */
	public void setQuan_firday_mp(Integer Quan_firday_mp) {
		setAttrVal("Quan_firday_mp", Quan_firday_mp);
	}
	/**
	 * 医嘱单标识
	 * @return FBoolean
	 */
	public FBoolean getFg_or_form() {
		return ((FBoolean) getAttrVal("Fg_or_form"));
	}	
	/**
	 * 医嘱单标识
	 * @param Fg_or_form
	 */
	public void setFg_or_form(FBoolean Fg_or_form) {
		setAttrVal("Fg_or_form", Fg_or_form);
	}
	/**
	 * 不皮试原因（废弃不用了）
	 * @return String
	 */
	public String getId_skintest_skip_reason() {
		return ((String) getAttrVal("Id_skintest_skip_reason"));
	}	
	/**
	 * 不皮试原因（废弃不用了）
	 * @param Id_skintest_skip_reason
	 */
	public void setId_skintest_skip_reason(String Id_skintest_skip_reason) {
		setAttrVal("Id_skintest_skip_reason", Id_skintest_skip_reason);
	}
	/**
	 * 不皮试原因编码（废弃不用了）
	 * @return String
	 */
	public String getSd_skintest_skip_reason() {
		return ((String) getAttrVal("Sd_skintest_skip_reason"));
	}	
	/**
	 * 不皮试原因编码（废弃不用了）
	 * @param Sd_skintest_skip_reason
	 */
	public void setSd_skintest_skip_reason(String Sd_skintest_skip_reason) {
		setAttrVal("Sd_skintest_skip_reason", Sd_skintest_skip_reason);
	}
	/**
	 * 出院带药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_pres_outp() {
		return ((FBoolean) getAttrVal("Fg_pres_outp"));
	}	
	/**
	 * 出院带药标识
	 * @param Fg_pres_outp
	 */
	public void setFg_pres_outp(FBoolean Fg_pres_outp) {
		setAttrVal("Fg_pres_outp", Fg_pres_outp);
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
	 * 申请单号
	 * @return String
	 */
	public String getApplyno() {
		return ((String) getAttrVal("Applyno"));
	}	
	/**
	 * 申请单号
	 * @param Applyno
	 */
	public void setApplyno(String Applyno) {
		setAttrVal("Applyno", Applyno);
	}
	/**
	 * 最近生成日期
	 * @return FDateTime
	 */
	public FDateTime getDt_last_bl() {
		return ((FDateTime) getAttrVal("Dt_last_bl"));
	}	
	/**
	 * 最近生成日期
	 * @param Dt_last_bl
	 */
	public void setDt_last_bl(FDateTime Dt_last_bl) {
		setAttrVal("Dt_last_bl", Dt_last_bl);
	}
	/**
	 * 加急标识
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}	
	/**
	 * 加急标识
	 * @param Fg_urgent
	 */
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	/**
	 * 医嘱综合状态
	 * @return String
	 */
	public String getOrd_colligate() {
		return ((String) getAttrVal("Ord_colligate"));
	}	
	/**
	 * 医嘱综合状态
	 * @param Ord_colligate
	 */
	public void setOrd_colligate(String Ord_colligate) {
		setAttrVal("Ord_colligate", Ord_colligate);
	}
	/**
	 * 金额
	 * @return FDouble
	 */
	public FDouble getAmount() {
		return ((FDouble) getAttrVal("Amount"));
	}	
	/**
	 * 金额
	 * @param Amount
	 */
	public void setAmount(FDouble Amount) {
		setAttrVal("Amount", Amount);
	}
	/**
	 * 医嘱结果（废弃不用了）（集成平台处方撤回使用）
	 * @return String
	 */
	public String getResult() {
		return ((String) getAttrVal("Result"));
	}	
	/**
	 * 医嘱结果（废弃不用了）（集成平台处方撤回使用）
	 * @param Result
	 */
	public void setResult(String Result) {
		setAttrVal("Result", Result);
	}
	/**
	 * 医嘱执行闭环类型
	 * @return String
	 */
	public String getId_orpltp() {
		return ((String) getAttrVal("Id_orpltp"));
	}	
	/**
	 * 医嘱执行闭环类型
	 * @param Id_orpltp
	 */
	public void setId_orpltp(String Id_orpltp) {
		setAttrVal("Id_orpltp", Id_orpltp);
	}
	/**
	 * 服务基本分类
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}	
	/**
	 * 服务基本分类
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
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
	 * 医嘱结果
	 * @return String
	 */
	public String getId_orrsttp() {
		return ((String) getAttrVal("Id_orrsttp"));
	}	
	/**
	 * 医嘱结果
	 * @param Id_orrsttp
	 */
	public void setId_orrsttp(String Id_orrsttp) {
		setAttrVal("Id_orrsttp", Id_orrsttp);
	}
	/**
	 * 医嘱结果编码
	 * @return String
	 */
	public String getSd_orrsttp() {
		return ((String) getAttrVal("Sd_orrsttp"));
	}	
	/**
	 * 医嘱结果编码
	 * @param Sd_orrsttp
	 */
	public void setSd_orrsttp(String Sd_orrsttp) {
		setAttrVal("Sd_orrsttp", Sd_orrsttp);
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
	 * 最近执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_last_mp() {
		return ((FDateTime) getAttrVal("Dt_last_mp"));
	}	
	/**
	 * 最近执行时间
	 * @param Dt_last_mp
	 */
	public void setDt_last_mp(FDateTime Dt_last_mp) {
		setAttrVal("Dt_last_mp", Dt_last_mp);
	}
	/**
	 * 医学单位
	 * @return String
	 */
	public String getId_unit_med() {
		return ((String) getAttrVal("Id_unit_med"));
	}	
	/**
	 * 医学单位
	 * @param Id_unit_med
	 */
	public void setId_unit_med(String Id_unit_med) {
		setAttrVal("Id_unit_med", Id_unit_med);
	}
	/**
	 * 医学单位数量
	 * @return FDouble
	 */
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}	
	/**
	 * 医学单位数量
	 * @param Quan_medu
	 */
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	/**
	 * 服务分类内码
	 * @return String
	 */
	public String getInnercode_srvca() {
		return ((String) getAttrVal("Innercode_srvca"));
	}	
	/**
	 * 服务分类内码
	 * @param Innercode_srvca
	 */
	public void setInnercode_srvca(String Innercode_srvca) {
		setAttrVal("Innercode_srvca", Innercode_srvca);
	}
	/**
	 * 医嘱不可取消标识
	 * @return FBoolean
	 */
	public FBoolean getFg_uncancelable() {
		return ((FBoolean) getAttrVal("Fg_uncancelable"));
	}	
	/**
	 * 医嘱不可取消标识
	 * @param Fg_uncancelable
	 */
	public void setFg_uncancelable(FBoolean Fg_uncancelable) {
		setAttrVal("Fg_uncancelable", Fg_uncancelable);
	}
	/**
	 * 医保适应症判断标识枚举
	 * @return Integer
	 */
	public Integer getEu_hpindicjudge() {
		return ((Integer) getAttrVal("Eu_hpindicjudge"));
	}	
	/**
	 * 医保适应症判断标识枚举
	 * @param Eu_hpindicjudge
	 */
	public void setEu_hpindicjudge(Integer Eu_hpindicjudge) {
		setAttrVal("Eu_hpindicjudge", Eu_hpindicjudge);
	}
	/**
	 * 非径内医生界面判断
	 * @return Integer
	 */
	public Integer getEu_uncpordoctorjudge() {
		return ((Integer) getAttrVal("Eu_uncpordoctorjudge"));
	}	
	/**
	 * 非径内医生界面判断
	 * @param Eu_uncpordoctorjudge
	 */
	public void setEu_uncpordoctorjudge(Integer Eu_uncpordoctorjudge) {
		setAttrVal("Eu_uncpordoctorjudge", Eu_uncpordoctorjudge);
	}
	/**
	 * 非径内医嘱判断标识枚举
	 * @return Integer
	 */
	public Integer getEu_uncporjudge() {
		return ((Integer) getAttrVal("Eu_uncporjudge"));
	}	
	/**
	 * 非径内医嘱判断标识枚举
	 * @param Eu_uncporjudge
	 */
	public void setEu_uncporjudge(Integer Eu_uncporjudge) {
		setAttrVal("Eu_uncporjudge", Eu_uncporjudge);
	}
	/**
	 * 径外医嘱使用原因
	 * @return String
	 */
	public String getReason_uncporuse() {
		return ((String) getAttrVal("Reason_uncporuse"));
	}	
	/**
	 * 径外医嘱使用原因
	 * @param Reason_uncporuse
	 */
	public void setReason_uncporuse(String Reason_uncporuse) {
		setAttrVal("Reason_uncporuse", Reason_uncporuse);
	}
	/**
	 * 医嘱目的
	 * @return String
	 */
	public String getPurpose_or() {
		return ((String) getAttrVal("Purpose_or"));
	}	
	/**
	 * 医嘱目的
	 * @param Purpose_or
	 */
	public void setPurpose_or(String Purpose_or) {
		setAttrVal("Purpose_or", Purpose_or);
	}
	/**
	 * 刷新到病历标识
	 * @return FBoolean
	 */
	public FBoolean getFg_flush2mr() {
		return ((FBoolean) getAttrVal("Fg_flush2mr"));
	}	
	/**
	 * 刷新到病历标识
	 * @param Fg_flush2mr
	 */
	public void setFg_flush2mr(FBoolean Fg_flush2mr) {
		setAttrVal("Fg_flush2mr", Fg_flush2mr);
	}
	/**
	 * 可退费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_feertnable() {
		return ((FBoolean) getAttrVal("Fg_feertnable"));
	}	
	/**
	 * 可退费标识
	 * @param Fg_feertnable
	 */
	public void setFg_feertnable(FBoolean Fg_feertnable) {
		setAttrVal("Fg_feertnable", Fg_feertnable);
	}
	/**
	 * 简化的流程标识
	 * @return FBoolean
	 */
	public FBoolean getFg_quickwflow() {
		return ((FBoolean) getAttrVal("Fg_quickwflow"));
	}	
	/**
	 * 简化的流程标识
	 * @param Fg_quickwflow
	 */
	public void setFg_quickwflow(FBoolean Fg_quickwflow) {
		setAttrVal("Fg_quickwflow", Fg_quickwflow);
	}
	/**
	 * 医嘱来源方式类型
	 * @return String
	 */
	public String getEu_orsrcmdtp() {
		return ((String) getAttrVal("Eu_orsrcmdtp"));
	}	
	/**
	 * 医嘱来源方式类型
	 * @param Eu_orsrcmdtp
	 */
	public void setEu_orsrcmdtp(String Eu_orsrcmdtp) {
		setAttrVal("Eu_orsrcmdtp", Eu_orsrcmdtp);
	}
	/**
	 * 医嘱来源主标识
	 * @return String
	 */
	public String getId_orsrc_main() {
		return ((String) getAttrVal("Id_orsrc_main"));
	}	
	/**
	 * 医嘱来源主标识
	 * @param Id_orsrc_main
	 */
	public void setId_orsrc_main(String Id_orsrc_main) {
		setAttrVal("Id_orsrc_main", Id_orsrc_main);
	}
	/**
	 * 医嘱来源子标识
	 * @return String
	 */
	public String getId_orsrc_sub() {
		return ((String) getAttrVal("Id_orsrc_sub"));
	}	
	/**
	 * 医嘱来源子标识
	 * @param Id_orsrc_sub
	 */
	public void setId_orsrc_sub(String Id_orsrc_sub) {
		setAttrVal("Id_orsrc_sub", Id_orsrc_sub);
	}
	/**
	 * 医嘱来源孙标识
	 * @return String
	 */
	public String getId_orsrc_subsub() {
		return ((String) getAttrVal("Id_orsrc_subsub"));
	}	
	/**
	 * 医嘱来源孙标识
	 * @param Id_orsrc_subsub
	 */
	public void setId_orsrc_subsub(String Id_orsrc_subsub) {
		setAttrVal("Id_orsrc_subsub", Id_orsrc_subsub);
	}
	/**
	 * 基本医保判断结果数据信息
	 * @return String
	 */
	public String getBhpjudgerst() {
		return ((String) getAttrVal("Bhpjudgerst"));
	}	
	/**
	 * 基本医保判断结果数据信息
	 * @param Bhpjudgerst
	 */
	public void setBhpjudgerst(String Bhpjudgerst) {
		setAttrVal("Bhpjudgerst", Bhpjudgerst);
	}
	/**
	 * 基本医保判断结果数据信息描述
	 * @return String
	 */
	public String getDes_bhpjudgerst() {
		return ((String) getAttrVal("Des_bhpjudgerst"));
	}	
	/**
	 * 基本医保判断结果数据信息描述
	 * @param Des_bhpjudgerst
	 */
	public void setDes_bhpjudgerst(String Des_bhpjudgerst) {
		setAttrVal("Des_bhpjudgerst", Des_bhpjudgerst);
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
	 * 医嘱预付费记账标识
	 * @return FBoolean
	 */
	public FBoolean getFg_prepay() {
		return ((FBoolean) getAttrVal("Fg_prepay"));
	}	
	/**
	 * 医嘱预付费记账标识
	 * @param Fg_prepay
	 */
	public void setFg_prepay(FBoolean Fg_prepay) {
		setAttrVal("Fg_prepay", Fg_prepay);
	}
	/**
	 * 临床项目医保标识
	 * @return FBoolean
	 */
	public FBoolean getFg_orhp() {
		return ((FBoolean) getAttrVal("Fg_orhp"));
	}	
	/**
	 * 临床项目医保标识
	 * @param Fg_orhp
	 */
	public void setFg_orhp(FBoolean Fg_orhp) {
		setAttrVal("Fg_orhp", Fg_orhp);
	}
	/**
	 * 费用冲账类型
	 * @return Integer
	 */
	public Integer getEu_feereversetp() {
		return ((Integer) getAttrVal("Eu_feereversetp"));
	}	
	/**
	 * 费用冲账类型
	 * @param Eu_feereversetp
	 */
	public void setEu_feereversetp(Integer Eu_feereversetp) {
		setAttrVal("Eu_feereversetp", Eu_feereversetp);
	}
	/**
	 * 医保细规则提示信息
	 * @return String
	 */
	public String getMdicalinfo() {
		return ((String) getAttrVal("Mdicalinfo"));
	}	
	/**
	 * 医保细规则提示信息
	 * @param Mdicalinfo
	 */
	public void setMdicalinfo(String Mdicalinfo) {
		setAttrVal("Mdicalinfo", Mdicalinfo);
	}
	/**
	 * 超量开单原因id
	 * @return String
	 */
	public String getId_excessive_reason() {
		return ((String) getAttrVal("Id_excessive_reason"));
	}	
	/**
	 * 超量开单原因id
	 * @param Id_excessive_reason
	 */
	public void setId_excessive_reason(String Id_excessive_reason) {
		setAttrVal("Id_excessive_reason", Id_excessive_reason);
	}
	/**
	 * 超量开单原因sd
	 * @return String
	 */
	public String getSd_excessive_reason() {
		return ((String) getAttrVal("Sd_excessive_reason"));
	}	
	/**
	 * 超量开单原因sd
	 * @param Sd_excessive_reason
	 */
	public void setSd_excessive_reason(String Sd_excessive_reason) {
		setAttrVal("Sd_excessive_reason", Sd_excessive_reason);
	}
	/**
	 * 医嘱总金额
	 * @return String
	 */
	public String getOr_total_pri() {
		return ((String) getAttrVal("Or_total_pri"));
	}	
	/**
	 * 医嘱总金额
	 * @param Or_total_pri
	 */
	public void setOr_total_pri(String Or_total_pri) {
		setAttrVal("Or_total_pri", Or_total_pri);
	}
	/**
	 * 总量开单方式
	 * @return String
	 */
	public String getSd_totalopenmode() {
		return ((String) getAttrVal("Sd_totalopenmode"));
	}	
	/**
	 * 总量开单方式
	 * @param Sd_totalopenmode
	 */
	public void setSd_totalopenmode(String Sd_totalopenmode) {
		setAttrVal("Sd_totalopenmode", Sd_totalopenmode);
	}
	/**
	 * 医嘱排序
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 医嘱排序
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 是否多次执行
	 * @return FBoolean
	 */
	public FBoolean getIsmulexec() {
		return ((FBoolean) getAttrVal("Ismulexec"));
	}	
	/**
	 * 是否多次执行
	 * @param Ismulexec
	 */
	public void setIsmulexec(FBoolean Ismulexec) {
		setAttrVal("Ismulexec", Ismulexec);
	}
	/**
	 * 是否多量开单
	 * @return FBoolean
	 */
	public FBoolean getIsmuldose() {
		return ((FBoolean) getAttrVal("Ismuldose"));
	}	
	/**
	 * 是否多量开单
	 * @param Ismuldose
	 */
	public void setIsmuldose(FBoolean Ismuldose) {
		setAttrVal("Ismuldose", Ismuldose);
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
	 * 科研项目编码
	 * @return String
	 */
	public String getCode_researchproject() {
		return ((String) getAttrVal("Code_researchproject"));
	}	
	/**
	 * 科研项目编码
	 * @param Code_researchproject
	 */
	public void setCode_researchproject(String Code_researchproject) {
		setAttrVal("Code_researchproject", Code_researchproject);
	}
	/**
	 * 草药院内制剂
	 * @return FBoolean
	 */
	public FBoolean getFg_hospital_herbpres() {
		return ((FBoolean) getAttrVal("Fg_hospital_herbpres"));
	}	
	/**
	 * 草药院内制剂
	 * @param Fg_hospital_herbpres
	 */
	public void setFg_hospital_herbpres(FBoolean Fg_hospital_herbpres) {
		setAttrVal("Fg_hospital_herbpres", Fg_hospital_herbpres);
	}
	/**
	 * 产房使用
	 * @return FBoolean
	 */
	public FBoolean getFg_deliveryroom_use() {
		return ((FBoolean) getAttrVal("Fg_deliveryroom_use"));
	}	
	/**
	 * 产房使用
	 * @param Fg_deliveryroom_use
	 */
	public void setFg_deliveryroom_use(FBoolean Fg_deliveryroom_use) {
		setAttrVal("Fg_deliveryroom_use", Fg_deliveryroom_use);
	}
	/**
	 * 错误级别
	 * @return String
	 */
	public String getError_level() {
		return ((String) getAttrVal("Error_level"));
	}	
	/**
	 * 错误级别
	 * @param Error_level
	 */
	public void setError_level(String Error_level) {
		setAttrVal("Error_level", Error_level);
	}
	/**
	 * 错误信息描述
	 * @return String
	 */
	public String getError_des() {
		return ((String) getAttrVal("Error_des"));
	}	
	/**
	 * 错误信息描述
	 * @param Error_des
	 */
	public void setError_des(String Error_des) {
		setAttrVal("Error_des", Error_des);
	}
	/**
	 * 护士核对拒绝确认类型
	 * @return String
	 */
	public String getEu_refusechecktp() {
		return ((String) getAttrVal("Eu_refusechecktp"));
	}	
	/**
	 * 护士核对拒绝确认类型
	 * @param Eu_refusechecktp
	 */
	public void setEu_refusechecktp(String Eu_refusechecktp) {
		setAttrVal("Eu_refusechecktp", Eu_refusechecktp);
	}
	/**
	 * 拒绝确认标志
	 * @return FBoolean
	 */
	public FBoolean getFg_refusecheck() {
		return ((FBoolean) getAttrVal("Fg_refusecheck"));
	}	
	/**
	 * 拒绝确认标志
	 * @param Fg_refusecheck
	 */
	public void setFg_refusecheck(FBoolean Fg_refusecheck) {
		setAttrVal("Fg_refusecheck", Fg_refusecheck);
	}
	/**
	 * 拒绝确认人
	 * @return String
	 */
	public String getId_emp_refusecheck() {
		return ((String) getAttrVal("Id_emp_refusecheck"));
	}	
	/**
	 * 拒绝确认人
	 * @param Id_emp_refusecheck
	 */
	public void setId_emp_refusecheck(String Id_emp_refusecheck) {
		setAttrVal("Id_emp_refusecheck", Id_emp_refusecheck);
	}
	/**
	 * 拒绝确认时间
	 * @return FDateTime
	 */
	public FDateTime getDt_refusecheck() {
		return ((FDateTime) getAttrVal("Dt_refusecheck"));
	}	
	/**
	 * 拒绝确认时间
	 * @param Dt_refusecheck
	 */
	public void setDt_refusecheck(FDateTime Dt_refusecheck) {
		setAttrVal("Dt_refusecheck", Dt_refusecheck);
	}
	/**
	 * 单位支付标志
	 * @return FBoolean
	 */
	public FBoolean getFg_pay_unit() {
		return ((FBoolean) getAttrVal("Fg_pay_unit"));
	}	
	/**
	 * 单位支付标志
	 * @param Fg_pay_unit
	 */
	public void setFg_pay_unit(FBoolean Fg_pay_unit) {
		setAttrVal("Fg_pay_unit", Fg_pay_unit);
	}
	/**
	 * 开单病区
	 * @return String
	 */
	public String getId_dep_nur_or() {
		return ((String) getAttrVal("Id_dep_nur_or"));
	}	
	/**
	 * 开单病区
	 * @param Id_dep_nur_or
	 */
	public void setId_dep_nur_or(String Id_dep_nur_or) {
		setAttrVal("Id_dep_nur_or", Id_dep_nur_or);
	}
	/**
	 * 复核标识
	 * @return FBoolean
	 */
	public FBoolean getFg_recheck() {
		return ((FBoolean) getAttrVal("Fg_recheck"));
	}	
	/**
	 * 复核标识
	 * @param Fg_recheck
	 */
	public void setFg_recheck(FBoolean Fg_recheck) {
		setAttrVal("Fg_recheck", Fg_recheck);
	}
	/**
	 * 复核护士
	 * @return String
	 */
	public String getId_emp_recheck() {
		return ((String) getAttrVal("Id_emp_recheck"));
	}	
	/**
	 * 复核护士
	 * @param Id_emp_recheck
	 */
	public void setId_emp_recheck(String Id_emp_recheck) {
		setAttrVal("Id_emp_recheck", Id_emp_recheck);
	}
	/**
	 * 复核时间
	 * @return FDateTime
	 */
	public FDateTime getDt_recheck() {
		return ((FDateTime) getAttrVal("Dt_recheck"));
	}	
	/**
	 * 复核时间
	 * @param Dt_recheck
	 */
	public void setDt_recheck(FDateTime Dt_recheck) {
		setAttrVal("Dt_recheck", Dt_recheck);
	}
	/**
	 * 是否需要特殊级抗菌药审批
	 * @return FBoolean
	 */
	public FBoolean getFg_spec_anti_approve() {
		return ((FBoolean) getAttrVal("Fg_spec_anti_approve"));
	}	
	/**
	 * 是否需要特殊级抗菌药审批
	 * @param Fg_spec_anti_approve
	 */
	public void setFg_spec_anti_approve(FBoolean Fg_spec_anti_approve) {
		setAttrVal("Fg_spec_anti_approve", Fg_spec_anti_approve);
	}
	/**
	 * 特殊级抗菌药审批结果
	 * @return String
	 */
	public String getSd_spec_anti_approve() {
		return ((String) getAttrVal("Sd_spec_anti_approve"));
	}	
	/**
	 * 特殊级抗菌药审批结果
	 * @param Sd_spec_anti_approve
	 */
	public void setSd_spec_anti_approve(String Sd_spec_anti_approve) {
		setAttrVal("Sd_spec_anti_approve", Sd_spec_anti_approve);
	}
	/**
	 * 第二和对人主键
	 * @return String
	 */
	public String getId_emp_second_chk() {
		return ((String) getAttrVal("Id_emp_second_chk"));
	}	
	/**
	 * 第二和对人主键
	 * @param Id_emp_second_chk
	 */
	public void setId_emp_second_chk(String Id_emp_second_chk) {
		setAttrVal("Id_emp_second_chk", Id_emp_second_chk);
	}
	/**
	 * 打印到医嘱单
	 * @return FBoolean
	 */
	public FBoolean getFg_prn() {
		return ((FBoolean) getAttrVal("Fg_prn"));
	}	
	/**
	 * 打印到医嘱单
	 * @param Fg_prn
	 */
	public void setFg_prn(FBoolean Fg_prn) {
		setAttrVal("Fg_prn", Fg_prn);
	}
	/**
	 * 医嘱来源功能id
	 * @return String
	 */
	public String getId_orsrcfun() {
		return ((String) getAttrVal("Id_orsrcfun"));
	}	
	/**
	 * 医嘱来源功能id
	 * @param Id_orsrcfun
	 */
	public void setId_orsrcfun(String Id_orsrcfun) {
		setAttrVal("Id_orsrcfun", Id_orsrcfun);
	}
	/**
	 * 医嘱来源功能sd
	 * @return String
	 */
	public String getSd_orsrcfun() {
		return ((String) getAttrVal("Sd_orsrcfun"));
	}	
	/**
	 * 医嘱来源功能sd
	 * @param Sd_orsrcfun
	 */
	public void setSd_orsrcfun(String Sd_orsrcfun) {
		setAttrVal("Sd_orsrcfun", Sd_orsrcfun);
	}
	/**
	 * 手术状态
	 * @return String
	 */
	public String getOperation_status() {
		return ((String) getAttrVal("Operation_status"));
	}	
	/**
	 * 手术状态
	 * @param Operation_status
	 */
	public void setOperation_status(String Operation_status) {
		setAttrVal("Operation_status", Operation_status);
	}
	/**
	 * 是否感染科会诊
	 * @return FBoolean
	 */
	public FBoolean getFg_infect_dep_cons() {
		return ((FBoolean) getAttrVal("Fg_infect_dep_cons"));
	}	
	/**
	 * 是否感染科会诊
	 * @param Fg_infect_dep_cons
	 */
	public void setFg_infect_dep_cons(FBoolean Fg_infect_dep_cons) {
		setAttrVal("Fg_infect_dep_cons", Fg_infect_dep_cons);
	}
	/**
	 * 诊断定义中的主键
	 * @return String
	 */
	public String getId_didef() {
		return ((String) getAttrVal("Id_didef"));
	}	
	/**
	 * 诊断定义中的主键
	 * @param Id_didef
	 */
	public void setId_didef(String Id_didef) {
		setAttrVal("Id_didef", Id_didef);
	}
	/**
	 * 诊断名称（考虑存在自定义诊断的情况，所以 ）
	 * @return String
	 */
	public String getName_didef() {
		return ((String) getAttrVal("Name_didef"));
	}	
	/**
	 * 诊断名称（考虑存在自定义诊断的情况，所以 ）
	 * @param Name_didef
	 */
	public void setName_didef(String Name_didef) {
		setAttrVal("Name_didef", Name_didef);
	}
	/**
	 * 超额原因
	 * @return String
	 */
	public String getMore_money_reason() {
		return ((String) getAttrVal("More_money_reason"));
	}	
	/**
	 * 超额原因
	 * @param More_money_reason
	 */
	public void setMore_money_reason(String More_money_reason) {
		setAttrVal("More_money_reason", More_money_reason);
	}
	/**
	 * 提醒护士确认消息id
	 * @return String
	 */
	public String getId_message() {
		return ((String) getAttrVal("Id_message"));
	}	
	/**
	 * 提醒护士确认消息id
	 * @param Id_message
	 */
	public void setId_message(String Id_message) {
		setAttrVal("Id_message", Id_message);
	}
	/**
	 * 滴速
	 * @return String
	 */
	public String getId_dripspeed() {
		return ((String) getAttrVal("Id_dripspeed"));
	}	
	/**
	 * 滴速
	 * @param Id_dripspeed
	 */
	public void setId_dripspeed(String Id_dripspeed) {
		setAttrVal("Id_dripspeed", Id_dripspeed);
	}
	/**
	 * 滴速名称
	 * @return String
	 */
	public String getName_dripspeed() {
		return ((String) getAttrVal("Name_dripspeed"));
	}	
	/**
	 * 滴速名称
	 * @param Name_dripspeed
	 */
	public void setName_dripspeed(String Name_dripspeed) {
		setAttrVal("Name_dripspeed", Name_dripspeed);
	}
	/**
	 * 领药方式ID
	 * @return String
	 */
	public String getId_drugdeliverymethod() {
		return ((String) getAttrVal("Id_drugdeliverymethod"));
	}	
	/**
	 * 领药方式ID
	 * @param Id_drugdeliverymethod
	 */
	public void setId_drugdeliverymethod(String Id_drugdeliverymethod) {
		setAttrVal("Id_drugdeliverymethod", Id_drugdeliverymethod);
	}
	/**
	 * 领药方式编码
	 * @return String
	 */
	public String getSd_drugdeliverymethod() {
		return ((String) getAttrVal("Sd_drugdeliverymethod"));
	}	
	/**
	 * 领药方式编码
	 * @param Sd_drugdeliverymethod
	 */
	public void setSd_drugdeliverymethod(String Sd_drugdeliverymethod) {
		setAttrVal("Sd_drugdeliverymethod", Sd_drugdeliverymethod);
	}
	/**
	 * 领药方式名称
	 * @return String
	 */
	public String getName_drugdeliverymethod() {
		return ((String) getAttrVal("Name_drugdeliverymethod"));
	}	
	/**
	 * 领药方式名称
	 * @param Name_drugdeliverymethod
	 */
	public void setName_drugdeliverymethod(String Name_drugdeliverymethod) {
		setAttrVal("Name_drugdeliverymethod", Name_drugdeliverymethod);
	}
	/**
	 * 在院整领标识
	 * @return FBoolean
	 */
	public FBoolean getFg_wholepack() {
		return ((FBoolean) getAttrVal("Fg_wholepack"));
	}	
	/**
	 * 在院整领标识
	 * @param Fg_wholepack
	 */
	public void setFg_wholepack(FBoolean Fg_wholepack) {
		setAttrVal("Fg_wholepack", Fg_wholepack);
	}
	/**
	 * 医保判断方式
	 * @return String
	 */
	public String getEu_hpjudge() {
		return ((String) getAttrVal("Eu_hpjudge"));
	}	
	/**
	 * 医保判断方式
	 * @param Eu_hpjudge
	 */
	public void setEu_hpjudge(String Eu_hpjudge) {
		setAttrVal("Eu_hpjudge", Eu_hpjudge);
	}
	/**
	 * 医保判断结果
	 * @return String
	 */
	public String getEu_orhp() {
		return ((String) getAttrVal("Eu_orhp"));
	}	
	/**
	 * 医保判断结果
	 * @param Eu_orhp
	 */
	public void setEu_orhp(String Eu_orhp) {
		setAttrVal("Eu_orhp", Eu_orhp);
	}
	/**
	 * 退药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_back() {
		return ((FBoolean) getAttrVal("Fg_back"));
	}	
	/**
	 * 退药标识
	 * @param Fg_back
	 */
	public void setFg_back(FBoolean Fg_back) {
		setAttrVal("Fg_back", Fg_back);
	}
	/**
	 * 关联原发药医嘱ID
	 * @return String
	 */
	public String getId_or_src() {
		return ((String) getAttrVal("Id_or_src"));
	}	
	/**
	 * 关联原发药医嘱ID
	 * @param Id_or_src
	 */
	public void setId_or_src(String Id_or_src) {
		setAttrVal("Id_or_src", Id_or_src);
	}
	/**
	 * 医嘱需审批标志
	 * @return FBoolean
	 */
	public FBoolean getFg_approve_or() {
		return ((FBoolean) getAttrVal("Fg_approve_or"));
	}	
	/**
	 * 医嘱需审批标志
	 * @param Fg_approve_or
	 */
	public void setFg_approve_or(FBoolean Fg_approve_or) {
		setAttrVal("Fg_approve_or", Fg_approve_or);
	}
	/**
	 * 医嘱审批类型
	 * @return String
	 */
	public String getSd_apprivetps_or() {
		return ((String) getAttrVal("Sd_apprivetps_or"));
	}	
	/**
	 * 医嘱审批类型
	 * @param Sd_apprivetps_or
	 */
	public void setSd_apprivetps_or(String Sd_apprivetps_or) {
		setAttrVal("Sd_apprivetps_or", Sd_apprivetps_or);
	}
	/**
	 * 提交审批标志
	 * @return FBoolean
	 */
	public FBoolean getFg_approve_submit() {
		return ((FBoolean) getAttrVal("Fg_approve_submit"));
	}	
	/**
	 * 提交审批标志
	 * @param Fg_approve_submit
	 */
	public void setFg_approve_submit(FBoolean Fg_approve_submit) {
		setAttrVal("Fg_approve_submit", Fg_approve_submit);
	}
	/**
	 * 审批结果
	 * @return String
	 */
	public String getEu_approve_or() {
		return ((String) getAttrVal("Eu_approve_or"));
	}	
	/**
	 * 审批结果
	 * @param Eu_approve_or
	 */
	public void setEu_approve_or(String Eu_approve_or) {
		setAttrVal("Eu_approve_or", Eu_approve_or);
	}
	/**
	 * 医嘱可流向科室字符串
	 * @return String
	 */
	public String getId_mp_depts() {
		return ((String) getAttrVal("Id_mp_depts"));
	}	
	/**
	 * 医嘱可流向科室字符串
	 * @param Id_mp_depts
	 */
	public void setId_mp_depts(String Id_mp_depts) {
		setAttrVal("Id_mp_depts", Id_mp_depts);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}	
	/**
	 * 患者姓名
	 * @param Pat_name
	 */
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getPat_id_sex() {
		return ((String) getAttrVal("Pat_id_sex"));
	}	
	/**
	 * 性别
	 * @param Pat_id_sex
	 */
	public void setPat_id_sex(String Pat_id_sex) {
		setAttrVal("Pat_id_sex", Pat_id_sex);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getPat_dt_birth() {
		return ((FDate) getAttrVal("Pat_dt_birth"));
	}	
	/**
	 * 出生日期
	 * @param Pat_dt_birth
	 */
	public void setPat_dt_birth(FDate Pat_dt_birth) {
		setAttrVal("Pat_dt_birth", Pat_dt_birth);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getPat_sd_sex() {
		return ((String) getAttrVal("Pat_sd_sex"));
	}	
	/**
	 * 性别编码
	 * @param Pat_sd_sex
	 */
	public void setPat_sd_sex(String Pat_sd_sex) {
		setAttrVal("Pat_sd_sex", Pat_sd_sex);
	}
	/**
	 * 当前就诊科室
	 * @return String
	 */
	public String getId_dep_ns() {
		return ((String) getAttrVal("Id_dep_ns"));
	}	
	/**
	 * 当前就诊科室
	 * @param Id_dep_ns
	 */
	public void setId_dep_ns(String Id_dep_ns) {
		setAttrVal("Id_dep_ns", Id_dep_ns);
	}
	/**
	 * 当前医疗组
	 * @return String
	 */
	public String getId_wg_ns() {
		return ((String) getAttrVal("Id_wg_ns"));
	}	
	/**
	 * 当前医疗组
	 * @param Id_wg_ns
	 */
	public void setId_wg_ns(String Id_wg_ns) {
		setAttrVal("Id_wg_ns", Id_wg_ns);
	}
	/**
	 * 当前护理单元
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	/**
	 * 当前护理单元
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 就诊类型名称
	 * @return String
	 */
	public String getEntp_name() {
		return ((String) getAttrVal("Entp_name"));
	}	
	/**
	 * 就诊类型名称
	 * @param Entp_name
	 */
	public void setEntp_name(String Entp_name) {
		setAttrVal("Entp_name", Entp_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSrvtp_name() {
		return ((String) getAttrVal("Srvtp_name"));
	}	
	/**
	 * 名称
	 * @param Srvtp_name
	 */
	public void setSrvtp_name(String Srvtp_name) {
		setAttrVal("Srvtp_name", Srvtp_name);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getSrv_pkg_name() {
		return ((String) getAttrVal("Srv_pkg_name"));
	}	
	/**
	 * 服务名称
	 * @param Srv_pkg_name
	 */
	public void setSrv_pkg_name(String Srv_pkg_name) {
		setAttrVal("Srv_pkg_name", Srv_pkg_name);
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
	 * 频次周期数
	 * @return Integer
	 */
	public Integer getFrequnitct() {
		return ((Integer) getAttrVal("Frequnitct"));
	}	
	/**
	 * 频次周期数
	 * @param Frequnitct
	 */
	public void setFrequnitct(Integer Frequnitct) {
		setAttrVal("Frequnitct", Frequnitct);
	}
	/**
	 * 频次周期下次数
	 * @return Integer
	 */
	public Integer getFreqct() {
		return ((Integer) getAttrVal("Freqct"));
	}	
	/**
	 * 频次周期下次数
	 * @param Freqct
	 */
	public void setFreqct(Integer Freqct) {
		setAttrVal("Freqct", Freqct);
	}
	/**
	 * 频次周期类型编码
	 * @return String
	 */
	public String getSd_frequnitct() {
		return ((String) getAttrVal("Sd_frequnitct"));
	}	
	/**
	 * 频次周期类型编码
	 * @param Sd_frequnitct
	 */
	public void setSd_frequnitct(String Sd_frequnitct) {
		setAttrVal("Sd_frequnitct", Sd_frequnitct);
	}
	/**
	 * 显示编码
	 * @return String
	 */
	public String getCode_disp() {
		return ((String) getAttrVal("Code_disp"));
	}	
	/**
	 * 显示编码
	 * @param Code_disp
	 */
	public void setCode_disp(String Code_disp) {
		setAttrVal("Code_disp", Code_disp);
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
	 * 名称
	 * @return String
	 */
	public String getSu_or_name() {
		return ((String) getAttrVal("Su_or_name"));
	}	
	/**
	 * 名称
	 * @param Su_or_name
	 */
	public void setSu_or_name(String Su_or_name) {
		setAttrVal("Su_or_name", Su_or_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSd_su_name() {
		return ((String) getAttrVal("Sd_su_name"));
	}	
	/**
	 * 名称
	 * @param Sd_su_name
	 */
	public void setSd_su_name(String Sd_su_name) {
		setAttrVal("Sd_su_name", Sd_su_name);
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
	 * 业务组名称
	 * @return String
	 */
	public String getWg_or_name() {
		return ((String) getAttrVal("Wg_or_name"));
	}	
	/**
	 * 业务组名称
	 * @param Wg_or_name
	 */
	public void setWg_or_name(String Wg_or_name) {
		setAttrVal("Wg_or_name", Wg_or_name);
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
	public String getEmp_chk_name() {
		return ((String) getAttrVal("Emp_chk_name"));
	}	
	/**
	 * 姓名
	 * @param Emp_chk_name
	 */
	public void setEmp_chk_name(String Emp_chk_name) {
		setAttrVal("Emp_chk_name", Emp_chk_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDep_nur_name() {
		return ((String) getAttrVal("Dep_nur_name"));
	}	
	/**
	 * 名称
	 * @param Dep_nur_name
	 */
	public void setDep_nur_name(String Dep_nur_name) {
		setAttrVal("Dep_nur_name", Dep_nur_name);
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
	 * 姓名
	 * @return String
	 */
	public String getEmp_chk_stop_name() {
		return ((String) getAttrVal("Emp_chk_stop_name"));
	}	
	/**
	 * 姓名
	 * @param Emp_chk_stop_name
	 */
	public void setEmp_chk_stop_name(String Emp_chk_stop_name) {
		setAttrVal("Emp_chk_stop_name", Emp_chk_stop_name);
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
	public String getEmp_chk_canc_name() {
		return ((String) getAttrVal("Emp_chk_canc_name"));
	}	
	/**
	 * 姓名
	 * @param Emp_chk_canc_name
	 */
	public void setEmp_chk_canc_name(String Emp_chk_canc_name) {
		setAttrVal("Emp_chk_canc_name", Emp_chk_canc_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDep_chk_canc_name() {
		return ((String) getAttrVal("Dep_chk_canc_name"));
	}	
	/**
	 * 名称
	 * @param Dep_chk_canc_name
	 */
	public void setDep_chk_canc_name(String Dep_chk_canc_name) {
		setAttrVal("Dep_chk_canc_name", Dep_chk_canc_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getReltp_name() {
		return ((String) getAttrVal("Reltp_name"));
	}	
	/**
	 * 名称
	 * @param Reltp_name
	 */
	public void setReltp_name(String Reltp_name) {
		setAttrVal("Reltp_name", Reltp_name);
	}
	/**
	 * 医嘱名称
	 * @return String
	 */
	public String getOr_rel_name() {
		return ((String) getAttrVal("Or_rel_name"));
	}	
	/**
	 * 医嘱名称
	 * @param Or_rel_name
	 */
	public void setOr_rel_name(String Or_rel_name) {
		setAttrVal("Or_rel_name", Or_rel_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}	
	/**
	 * 名称
	 * @param Name_dep_mp
	 */
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}
	/**
	 * 计量单位名称
	 * @return String
	 */
	public String getName_unit_med() {
		return ((String) getAttrVal("Name_unit_med"));
	}	
	/**
	 * 计量单位名称
	 * @param Name_unit_med
	 */
	public void setName_unit_med(String Name_unit_med) {
		setAttrVal("Name_unit_med", Name_unit_med);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_excessive_reason() {
		return ((String) getAttrVal("Name_excessive_reason"));
	}	
	/**
	 * 名称
	 * @param Name_excessive_reason
	 */
	public void setName_excessive_reason(String Name_excessive_reason) {
		setAttrVal("Name_excessive_reason", Name_excessive_reason);
	}
	/**
	 * 科研项目名称
	 * @return String
	 */
	public String getName_researchproject() {
		return ((String) getAttrVal("Name_researchproject"));
	}	
	/**
	 * 科研项目名称
	 * @param Name_researchproject
	 */
	public void setName_researchproject(String Name_researchproject) {
		setAttrVal("Name_researchproject", Name_researchproject);
	}
	/**
	 * 科研项目密码
	 * @return String
	 */
	public String getPassword() {
		return ((String) getAttrVal("Password"));
	}	
	/**
	 * 科研项目密码
	 * @param Password
	 */
	public void setPassword(String Password) {
		setAttrVal("Password", Password);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_emp_second_chk() {
		return ((String) getAttrVal("Name_emp_second_chk"));
	}	
	/**
	 * 姓名
	 * @param Name_emp_second_chk
	 */
	public void setName_emp_second_chk(String Name_emp_second_chk) {
		setAttrVal("Name_emp_second_chk", Name_emp_second_chk);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getCode_didef() {
		return ((String) getAttrVal("Code_didef"));
	}	
	/**
	 * 诊断编码
	 * @param Code_didef
	 */
	public void setCode_didef(String Code_didef) {
		setAttrVal("Code_didef", Code_didef);
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
		return "Id_or";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_order";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiOrderDODesc.class);
	}
	
}