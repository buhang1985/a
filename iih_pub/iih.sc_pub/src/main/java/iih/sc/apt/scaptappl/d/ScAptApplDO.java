package iih.sc.apt.scaptappl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.apt.scaptappl.d.desc.ScAptApplDODesc;
import java.math.BigDecimal;

/**
 * 计划排班_预约_申请 DO数据 
 * 
 */
public class ScAptApplDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//预约申请ID
	public static final String ID_APTAPPL= "Id_aptappl";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//排班类型编码
	public static final String SD_SCTP= "Sd_sctp";
	//排班分类
	public static final String ID_SCCA= "Id_scca";
	//预约申请编码
	public static final String CODE= "Code";
	//预约申请名称
	public static final String NAME= "Name";
	//预约申请描述
	public static final String DES= "Des";
	//患者
	public static final String ID_PI= "Id_pi";
	//患者姓名
	public static final String PINAME= "Piname";
	//患者性别编码
	public static final String SD_SEX= "Sd_sex";
	//患者性别
	public static final String ID_SEX= "Id_sex";
	//患者出生日期
	public static final String D_PI= "D_pi";
	//患者手机号码
	public static final String PIMOBILE= "Pimobile";
	//医嘱
	public static final String ID_OR= "Id_or";
	//住院通知单
	public static final String ID_EN_IPNOTICE= "Id_en_ipnotice";
	//优先级
	public static final String PRIORITY= "Priority";
	//预约申请开始日期
	public static final String D_B= "D_b";
	//预约申请结束日期
	public static final String D_E= "D_e";
	//排班服务
	public static final String ID_SCSRV= "Id_scsrv";
	//排班资源
	public static final String ID_SCRES= "Id_scres";
	//预约申请部门
	public static final String ID_DEP_APPL= "Id_dep_appl";
	//预约申请人员
	public static final String ID_EMP_APPL= "Id_emp_appl";
	//预约申请操作日期
	public static final String DT_APPL= "Dt_appl";
	//预约完成标志
	public static final String FG_COMFIRM= "Fg_comfirm";
	//对应预约
	public static final String ID_SCAPT= "Id_scapt";
	//取消标识
	public static final String FG_CANC= "Fg_canc";
	//取消人员
	public static final String ID_EMP_CANC= "Id_emp_canc";
	//取消时间
	public static final String DT_CANC= "Dt_canc";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//紧急标识
	public static final String FG_URGENT= "Fg_urgent";
	//就诊类型id
	public static final String ID_ENTP= "Id_entp";
	//就诊类型编码
	public static final String CODE_ENTP= "Code_entp";
	//就诊id
	public static final String ID_ENT= "Id_ent";
	//医嘱内容
	public static final String CONTENT_OR= "Content_or";
	//预约模式
	public static final String EU_APTMD= "Eu_aptmd";
	//日期分组
	public static final String ID_DAYSLOT= "Id_dayslot";
	//ci转入申请号
	public static final String APPLYNO= "Applyno";
	//医疗项目
	public static final String ID_SRV= "Id_srv";
	//执行科室
	public static final String ID_DEP_MP= "Id_dep_mp";
	//预约预计开始日期时间
	public static final String DT_B= "Dt_b";
	//预约 预计结束日期时间
	public static final String DT_E= "Dt_e";
	//医嘱开立时间
	public static final String DT_EFFE_OR= "Dt_effe_or";
	//是否收费
	public static final String FG_BL= "Fg_bl";
	//手术部位id
	public static final String ID_SURGICAL_SITE= "Id_surgical_site";
	//手术部位编码
	public static final String SD_SURGICAL_SITE= "Sd_surgical_site";
	//申请单来源
	public static final String SD_SYS_FROM= "Sd_sys_from";
	//预约类型
	public static final String SD_APTMD= "Sd_aptmd";
	//医嘱号
	public static final String CODE_OR= "Code_or";
	//医保支付标识
	public static final String FG_HP= "Fg_hp";
	//就诊次数
	public static final String TIMES= "Times";
	//到诊登记标志
	public static final String FG_REG_ARV= "Fg_reg_arv";
	//已取消执行标志
	public static final String FG_CANC_EXEC= "Fg_canc_exec";
	//合单标志
	public static final String FG_MULTOR= "Fg_multor";
	//患者姓名
	public static final String PI_NAME= "Pi_name";
	//名称
	public static final String SEX_NAME= "Sex_name";
	//排班服务名称
	public static final String SCSRV_NAME= "Scsrv_name";
	//资源名称
	public static final String SCRES_NAME= "Scres_name";
	//名称
	public static final String DEP_NAME= "Dep_name";
	//姓名
	public static final String NAME_EMP= "Name_emp";
	//人员编码
	public static final String CODE_EMP= "Code_emp";
	//名称
	public static final String SURGICAL_NAME= "Surgical_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 预约申请ID
	 * @return String
	 */
	public String getId_aptappl() {
		return ((String) getAttrVal("Id_aptappl"));
	}	
	/**
	 * 预约申请ID
	 * @param Id_aptappl
	 */
	public void setId_aptappl(String Id_aptappl) {
		setAttrVal("Id_aptappl", Id_aptappl);
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
	 * 机构
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 机构
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 排班类型编码
	 * @return String
	 */
	public String getSd_sctp() {
		return ((String) getAttrVal("Sd_sctp"));
	}	
	/**
	 * 排班类型编码
	 * @param Sd_sctp
	 */
	public void setSd_sctp(String Sd_sctp) {
		setAttrVal("Sd_sctp", Sd_sctp);
	}
	/**
	 * 排班分类
	 * @return String
	 */
	public String getId_scca() {
		return ((String) getAttrVal("Id_scca"));
	}	
	/**
	 * 排班分类
	 * @param Id_scca
	 */
	public void setId_scca(String Id_scca) {
		setAttrVal("Id_scca", Id_scca);
	}
	/**
	 * 预约申请编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 预约申请编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 预约申请名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 预约申请名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 预约申请描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 预约申请描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pi() {
		return ((String) getAttrVal("Id_pi"));
	}	
	/**
	 * 患者
	 * @param Id_pi
	 */
	public void setId_pi(String Id_pi) {
		setAttrVal("Id_pi", Id_pi);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPiname() {
		return ((String) getAttrVal("Piname"));
	}	
	/**
	 * 患者姓名
	 * @param Piname
	 */
	public void setPiname(String Piname) {
		setAttrVal("Piname", Piname);
	}
	/**
	 * 患者性别编码
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}	
	/**
	 * 患者性别编码
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 患者性别
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}	
	/**
	 * 患者性别
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	/**
	 * 患者出生日期
	 * @return FDate
	 */
	public FDate getD_pi() {
		return ((FDate) getAttrVal("D_pi"));
	}	
	/**
	 * 患者出生日期
	 * @param D_pi
	 */
	public void setD_pi(FDate D_pi) {
		setAttrVal("D_pi", D_pi);
	}
	/**
	 * 患者手机号码
	 * @return String
	 */
	public String getPimobile() {
		return ((String) getAttrVal("Pimobile"));
	}	
	/**
	 * 患者手机号码
	 * @param Pimobile
	 */
	public void setPimobile(String Pimobile) {
		setAttrVal("Pimobile", Pimobile);
	}
	/**
	 * 医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 住院通知单
	 * @return String
	 */
	public String getId_en_ipnotice() {
		return ((String) getAttrVal("Id_en_ipnotice"));
	}	
	/**
	 * 住院通知单
	 * @param Id_en_ipnotice
	 */
	public void setId_en_ipnotice(String Id_en_ipnotice) {
		setAttrVal("Id_en_ipnotice", Id_en_ipnotice);
	}
	/**
	 * 优先级
	 * @return Integer
	 */
	public Integer getPriority() {
		return ((Integer) getAttrVal("Priority"));
	}	
	/**
	 * 优先级
	 * @param Priority
	 */
	public void setPriority(Integer Priority) {
		setAttrVal("Priority", Priority);
	}
	/**
	 * 预约申请开始日期
	 * @return FDate
	 */
	public FDate getD_b() {
		return ((FDate) getAttrVal("D_b"));
	}	
	/**
	 * 预约申请开始日期
	 * @param D_b
	 */
	public void setD_b(FDate D_b) {
		setAttrVal("D_b", D_b);
	}
	/**
	 * 预约申请结束日期
	 * @return FDate
	 */
	public FDate getD_e() {
		return ((FDate) getAttrVal("D_e"));
	}	
	/**
	 * 预约申请结束日期
	 * @param D_e
	 */
	public void setD_e(FDate D_e) {
		setAttrVal("D_e", D_e);
	}
	/**
	 * 排班服务
	 * @return String
	 */
	public String getId_scsrv() {
		return ((String) getAttrVal("Id_scsrv"));
	}	
	/**
	 * 排班服务
	 * @param Id_scsrv
	 */
	public void setId_scsrv(String Id_scsrv) {
		setAttrVal("Id_scsrv", Id_scsrv);
	}
	/**
	 * 排班资源
	 * @return String
	 */
	public String getId_scres() {
		return ((String) getAttrVal("Id_scres"));
	}	
	/**
	 * 排班资源
	 * @param Id_scres
	 */
	public void setId_scres(String Id_scres) {
		setAttrVal("Id_scres", Id_scres);
	}
	/**
	 * 预约申请部门
	 * @return String
	 */
	public String getId_dep_appl() {
		return ((String) getAttrVal("Id_dep_appl"));
	}	
	/**
	 * 预约申请部门
	 * @param Id_dep_appl
	 */
	public void setId_dep_appl(String Id_dep_appl) {
		setAttrVal("Id_dep_appl", Id_dep_appl);
	}
	/**
	 * 预约申请人员
	 * @return String
	 */
	public String getId_emp_appl() {
		return ((String) getAttrVal("Id_emp_appl"));
	}	
	/**
	 * 预约申请人员
	 * @param Id_emp_appl
	 */
	public void setId_emp_appl(String Id_emp_appl) {
		setAttrVal("Id_emp_appl", Id_emp_appl);
	}
	/**
	 * 预约申请操作日期
	 * @return FDateTime
	 */
	public FDateTime getDt_appl() {
		return ((FDateTime) getAttrVal("Dt_appl"));
	}	
	/**
	 * 预约申请操作日期
	 * @param Dt_appl
	 */
	public void setDt_appl(FDateTime Dt_appl) {
		setAttrVal("Dt_appl", Dt_appl);
	}
	/**
	 * 预约完成标志
	 * @return FBoolean
	 */
	public FBoolean getFg_comfirm() {
		return ((FBoolean) getAttrVal("Fg_comfirm"));
	}	
	/**
	 * 预约完成标志
	 * @param Fg_comfirm
	 */
	public void setFg_comfirm(FBoolean Fg_comfirm) {
		setAttrVal("Fg_comfirm", Fg_comfirm);
	}
	/**
	 * 对应预约
	 * @return String
	 */
	public String getId_scapt() {
		return ((String) getAttrVal("Id_scapt"));
	}	
	/**
	 * 对应预约
	 * @param Id_scapt
	 */
	public void setId_scapt(String Id_scapt) {
		setAttrVal("Id_scapt", Id_scapt);
	}
	/**
	 * 取消标识
	 * @return FBoolean
	 */
	public FBoolean getFg_canc() {
		return ((FBoolean) getAttrVal("Fg_canc"));
	}	
	/**
	 * 取消标识
	 * @param Fg_canc
	 */
	public void setFg_canc(FBoolean Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	/**
	 * 取消人员
	 * @return String
	 */
	public String getId_emp_canc() {
		return ((String) getAttrVal("Id_emp_canc"));
	}	
	/**
	 * 取消人员
	 * @param Id_emp_canc
	 */
	public void setId_emp_canc(String Id_emp_canc) {
		setAttrVal("Id_emp_canc", Id_emp_canc);
	}
	/**
	 * 取消时间
	 * @return FDateTime
	 */
	public FDateTime getDt_canc() {
		return ((FDateTime) getAttrVal("Dt_canc"));
	}	
	/**
	 * 取消时间
	 * @param Dt_canc
	 */
	public void setDt_canc(FDateTime Dt_canc) {
		setAttrVal("Dt_canc", Dt_canc);
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
	 * 紧急标识
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}	
	/**
	 * 紧急标识
	 * @param Fg_urgent
	 */
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	/**
	 * 就诊类型id
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	/**
	 * 就诊类型id
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
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	 * 预约模式
	 * @return Integer
	 */
	public Integer getEu_aptmd() {
		return ((Integer) getAttrVal("Eu_aptmd"));
	}	
	/**
	 * 预约模式
	 * @param Eu_aptmd
	 */
	public void setEu_aptmd(Integer Eu_aptmd) {
		setAttrVal("Eu_aptmd", Eu_aptmd);
	}
	/**
	 * 日期分组
	 * @return String
	 */
	public String getId_dayslot() {
		return ((String) getAttrVal("Id_dayslot"));
	}	
	/**
	 * 日期分组
	 * @param Id_dayslot
	 */
	public void setId_dayslot(String Id_dayslot) {
		setAttrVal("Id_dayslot", Id_dayslot);
	}
	/**
	 * ci转入申请号
	 * @return String
	 */
	public String getApplyno() {
		return ((String) getAttrVal("Applyno"));
	}	
	/**
	 * ci转入申请号
	 * @param Applyno
	 */
	public void setApplyno(String Applyno) {
		setAttrVal("Applyno", Applyno);
	}
	/**
	 * 医疗项目
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 医疗项目
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
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
	 * 预约预计开始日期时间
	 * @return FDateTime
	 */
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}	
	/**
	 * 预约预计开始日期时间
	 * @param Dt_b
	 */
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 预约 预计结束日期时间
	 * @return FDateTime
	 */
	public FDateTime getDt_e() {
		return ((FDateTime) getAttrVal("Dt_e"));
	}	
	/**
	 * 预约 预计结束日期时间
	 * @param Dt_e
	 */
	public void setDt_e(FDateTime Dt_e) {
		setAttrVal("Dt_e", Dt_e);
	}
	/**
	 * 医嘱开立时间
	 * @return FDateTime
	 */
	public FDateTime getDt_effe_or() {
		return ((FDateTime) getAttrVal("Dt_effe_or"));
	}	
	/**
	 * 医嘱开立时间
	 * @param Dt_effe_or
	 */
	public void setDt_effe_or(FDateTime Dt_effe_or) {
		setAttrVal("Dt_effe_or", Dt_effe_or);
	}
	/**
	 * 是否收费
	 * @return FBoolean
	 */
	public FBoolean getFg_bl() {
		return ((FBoolean) getAttrVal("Fg_bl"));
	}	
	/**
	 * 是否收费
	 * @param Fg_bl
	 */
	public void setFg_bl(FBoolean Fg_bl) {
		setAttrVal("Fg_bl", Fg_bl);
	}
	/**
	 * 手术部位id
	 * @return String
	 */
	public String getId_surgical_site() {
		return ((String) getAttrVal("Id_surgical_site"));
	}	
	/**
	 * 手术部位id
	 * @param Id_surgical_site
	 */
	public void setId_surgical_site(String Id_surgical_site) {
		setAttrVal("Id_surgical_site", Id_surgical_site);
	}
	/**
	 * 手术部位编码
	 * @return String
	 */
	public String getSd_surgical_site() {
		return ((String) getAttrVal("Sd_surgical_site"));
	}	
	/**
	 * 手术部位编码
	 * @param Sd_surgical_site
	 */
	public void setSd_surgical_site(String Sd_surgical_site) {
		setAttrVal("Sd_surgical_site", Sd_surgical_site);
	}
	/**
	 * 申请单来源
	 * @return String
	 */
	public String getSd_sys_from() {
		return ((String) getAttrVal("Sd_sys_from"));
	}	
	/**
	 * 申请单来源
	 * @param Sd_sys_from
	 */
	public void setSd_sys_from(String Sd_sys_from) {
		setAttrVal("Sd_sys_from", Sd_sys_from);
	}
	/**
	 * 预约类型
	 * @return String
	 */
	public String getSd_aptmd() {
		return ((String) getAttrVal("Sd_aptmd"));
	}	
	/**
	 * 预约类型
	 * @param Sd_aptmd
	 */
	public void setSd_aptmd(String Sd_aptmd) {
		setAttrVal("Sd_aptmd", Sd_aptmd);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}	
	/**
	 * 医嘱号
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 医保支付标识
	 * @return FBoolean
	 */
	public FBoolean getFg_hp() {
		return ((FBoolean) getAttrVal("Fg_hp"));
	}	
	/**
	 * 医保支付标识
	 * @param Fg_hp
	 */
	public void setFg_hp(FBoolean Fg_hp) {
		setAttrVal("Fg_hp", Fg_hp);
	}
	/**
	 * 就诊次数
	 * @return String
	 */
	public String getTimes() {
		return ((String) getAttrVal("Times"));
	}	
	/**
	 * 就诊次数
	 * @param Times
	 */
	public void setTimes(String Times) {
		setAttrVal("Times", Times);
	}
	/**
	 * 到诊登记标志
	 * @return FBoolean
	 */
	public FBoolean getFg_reg_arv() {
		return ((FBoolean) getAttrVal("Fg_reg_arv"));
	}	
	/**
	 * 到诊登记标志
	 * @param Fg_reg_arv
	 */
	public void setFg_reg_arv(FBoolean Fg_reg_arv) {
		setAttrVal("Fg_reg_arv", Fg_reg_arv);
	}
	/**
	 * 已取消执行标志
	 * @return FBoolean
	 */
	public FBoolean getFg_canc_exec() {
		return ((FBoolean) getAttrVal("Fg_canc_exec"));
	}	
	/**
	 * 已取消执行标志
	 * @param Fg_canc_exec
	 */
	public void setFg_canc_exec(FBoolean Fg_canc_exec) {
		setAttrVal("Fg_canc_exec", Fg_canc_exec);
	}
	/**
	 * 合单标志
	 * @return FBoolean
	 */
	public FBoolean getFg_multor() {
		return ((FBoolean) getAttrVal("Fg_multor"));
	}	
	/**
	 * 合单标志
	 * @param Fg_multor
	 */
	public void setFg_multor(FBoolean Fg_multor) {
		setAttrVal("Fg_multor", Fg_multor);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPi_name() {
		return ((String) getAttrVal("Pi_name"));
	}	
	/**
	 * 患者姓名
	 * @param Pi_name
	 */
	public void setPi_name(String Pi_name) {
		setAttrVal("Pi_name", Pi_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSex_name() {
		return ((String) getAttrVal("Sex_name"));
	}	
	/**
	 * 名称
	 * @param Sex_name
	 */
	public void setSex_name(String Sex_name) {
		setAttrVal("Sex_name", Sex_name);
	}
	/**
	 * 排班服务名称
	 * @return String
	 */
	public String getScsrv_name() {
		return ((String) getAttrVal("Scsrv_name"));
	}	
	/**
	 * 排班服务名称
	 * @param Scsrv_name
	 */
	public void setScsrv_name(String Scsrv_name) {
		setAttrVal("Scsrv_name", Scsrv_name);
	}
	/**
	 * 资源名称
	 * @return String
	 */
	public String getScres_name() {
		return ((String) getAttrVal("Scres_name"));
	}	
	/**
	 * 资源名称
	 * @param Scres_name
	 */
	public void setScres_name(String Scres_name) {
		setAttrVal("Scres_name", Scres_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	/**
	 * 名称
	 * @param Dep_name
	 */
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}	
	/**
	 * 姓名
	 * @param Name_emp
	 */
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getCode_emp() {
		return ((String) getAttrVal("Code_emp"));
	}	
	/**
	 * 人员编码
	 * @param Code_emp
	 */
	public void setCode_emp(String Code_emp) {
		setAttrVal("Code_emp", Code_emp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSurgical_name() {
		return ((String) getAttrVal("Surgical_name"));
	}	
	/**
	 * 名称
	 * @param Surgical_name
	 */
	public void setSurgical_name(String Surgical_name) {
		setAttrVal("Surgical_name", Surgical_name);
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
		return "Id_aptappl";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_apt_appl";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScAptApplDODesc.class);
	}
	
}