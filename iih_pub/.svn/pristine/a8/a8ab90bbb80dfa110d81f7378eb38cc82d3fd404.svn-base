package iih.sc.scp.scplan.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.scp.scplan.d.desc.ScPlanDODesc;
import java.math.BigDecimal;

/**
 * 排班计划 DO数据 
 * 
 */
public class ScPlanDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//计划ID
	public static final String ID_SCPL= "Id_scpl";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//排班类型
	public static final String ID_SCTP= "Id_sctp";
	//排班类型编码
	public static final String SD_SCTP= "Sd_sctp";
	//计划归属部门
	public static final String ID_DEP= "Id_dep";
	//排班服务
	public static final String ID_SCSRV= "Id_scsrv";
	//备用服务
	public static final String ID_OPTSRV= "Id_optsrv";
	//排班资源
	public static final String ID_SCRES= "Id_scres";
	//排班分类
	public static final String ID_SCCA= "Id_scca";
	//计划编码
	public static final String CODE= "Code";
	//计划名称
	public static final String NAME= "Name";
	//计划描述
	public static final String DES= "Des";
	//启用号源池总数
	public static final String SCPOLCN= "Scpolcn";
	//票号模式
	public static final String ID_TICKMD= "Id_tickmd";
	//票号模式编码
	public static final String SD_TICKMD= "Sd_tickmd";
	//生成号位标志
	public static final String FG_TICK= "Fg_tick";
	//优先开放规则
	public static final String ID_APPTRU= "Id_apptru";
	//单个服务时间(分钟)
	public static final String SRVSLOT= "Srvslot";
	//注意事项
	public static final String NOTE= "Note";
	//启用标志
	public static final String FG_ACTIVE= "Fg_active";
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
	//拼音码
	public static final String PYCODE= "Pycode";
	//五笔码
	public static final String WBCODE= "Wbcode";
	//助记符
	public static final String INSTR= "Instr";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//最后排班日期
	public static final String D_LAST_SCH= "D_last_sch";
	//编辑模式
	public static final String EU_EDIT_TP= "Eu_edit_tp";
	//科室参数
	public static final String ID_DEPPARAM= "Id_depparam";
	//版本
	public static final String NAME_VER= "Name_ver";
	//队列工作台
	public static final String ID_QUEBEN= "Id_queben";
	//计算单服务时长
	public static final String SRVSLOT_CAL= "Srvslot_cal";
	//最小刻度
	public static final String SRVSLOT_MIN= "Srvslot_min";
	//规则
	public static final String ID_QUERULE= "Id_querule";
	//预约使用时间类型
	public static final String EU_TIMESLOTTP= "Eu_timeslottp";
	//预约优先级
	public static final String LEVEL_PRI= "Level_pri";
	//号源释放规则
	public static final String ID_RELEASE_RULE= "Id_release_rule";
	//时间核查标志
	public static final String FG_TIMECHK= "Fg_timechk";
	//停止排班标志
	public static final String FG_STOPSCH= "Fg_stopsch";
	//排班所属部门名称
	public static final String NAME_DEP= "Name_dep";
	//排班服务名称
	public static final String NAME_SRV= "Name_srv";
	//排班服务编码
	public static final String CODE_SRV= "Code_srv";
	//备用服务名称
	public static final String NAME_OPTSRV= "Name_optsrv";
	//资源编码
	public static final String CODE_RES= "Code_res";
	//资源名称
	public static final String NAME_RES= "Name_res";
	//排班分类
	public static final String ID_SCCA_SCPL= "Id_scca_scpl";
	//票号模式名称
	public static final String NAME_TICKMD= "Name_tickmd";
	//优先开放规则编码
	public static final String CODE_APPTRU= "Code_apptru";
	//优先开放规则名称
	public static final String NAME_APPTRU= "Name_apptru";
	//优先开放规则类型编码
	public static final String CODE_SCHRULE= "Code_schrule";
	//版本
	public static final String VER= "Ver";
	//工作台名称
	public static final String NAME_QUEBEN= "Name_queben";
	//工作台编码
	public static final String CODE_QUEBEN= "Code_queben";
	//名称
	public static final String NAME_RULE= "Name_rule";
	//编码
	public static final String CODE_RULE= "Code_rule";
	//编码
	public static final String CODE_RELEASE_RULE= "Code_release_rule";
	//名称
	public static final String NAME_RELEASE_RULE= "Name_release_rule";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 计划ID
	 * @return String
	 */
	public String getId_scpl() {
		return ((String) getAttrVal("Id_scpl"));
	}	
	/**
	 * 计划ID
	 * @param Id_scpl
	 */
	public void setId_scpl(String Id_scpl) {
		setAttrVal("Id_scpl", Id_scpl);
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
	 * 排班类型
	 * @return String
	 */
	public String getId_sctp() {
		return ((String) getAttrVal("Id_sctp"));
	}	
	/**
	 * 排班类型
	 * @param Id_sctp
	 */
	public void setId_sctp(String Id_sctp) {
		setAttrVal("Id_sctp", Id_sctp);
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
	 * 计划归属部门
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 计划归属部门
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
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
	 * 备用服务
	 * @return String
	 */
	public String getId_optsrv() {
		return ((String) getAttrVal("Id_optsrv"));
	}	
	/**
	 * 备用服务
	 * @param Id_optsrv
	 */
	public void setId_optsrv(String Id_optsrv) {
		setAttrVal("Id_optsrv", Id_optsrv);
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
	 * 计划编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 计划编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 计划名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 计划名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 计划描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 计划描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 启用号源池总数
	 * @return Integer
	 */
	public Integer getScpolcn() {
		return ((Integer) getAttrVal("Scpolcn"));
	}	
	/**
	 * 启用号源池总数
	 * @param Scpolcn
	 */
	public void setScpolcn(Integer Scpolcn) {
		setAttrVal("Scpolcn", Scpolcn);
	}
	/**
	 * 票号模式
	 * @return String
	 */
	public String getId_tickmd() {
		return ((String) getAttrVal("Id_tickmd"));
	}	
	/**
	 * 票号模式
	 * @param Id_tickmd
	 */
	public void setId_tickmd(String Id_tickmd) {
		setAttrVal("Id_tickmd", Id_tickmd);
	}
	/**
	 * 票号模式编码
	 * @return String
	 */
	public String getSd_tickmd() {
		return ((String) getAttrVal("Sd_tickmd"));
	}	
	/**
	 * 票号模式编码
	 * @param Sd_tickmd
	 */
	public void setSd_tickmd(String Sd_tickmd) {
		setAttrVal("Sd_tickmd", Sd_tickmd);
	}
	/**
	 * 生成号位标志
	 * @return FBoolean
	 */
	public FBoolean getFg_tick() {
		return ((FBoolean) getAttrVal("Fg_tick"));
	}	
	/**
	 * 生成号位标志
	 * @param Fg_tick
	 */
	public void setFg_tick(FBoolean Fg_tick) {
		setAttrVal("Fg_tick", Fg_tick);
	}
	/**
	 * 优先开放规则
	 * @return String
	 */
	public String getId_apptru() {
		return ((String) getAttrVal("Id_apptru"));
	}	
	/**
	 * 优先开放规则
	 * @param Id_apptru
	 */
	public void setId_apptru(String Id_apptru) {
		setAttrVal("Id_apptru", Id_apptru);
	}
	/**
	 * 单个服务时间(分钟)
	 * @return Integer
	 */
	public Integer getSrvslot() {
		return ((Integer) getAttrVal("Srvslot"));
	}	
	/**
	 * 单个服务时间(分钟)
	 * @param Srvslot
	 */
	public void setSrvslot(Integer Srvslot) {
		setAttrVal("Srvslot", Srvslot);
	}
	/**
	 * 注意事项
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 注意事项
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 启用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标志
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
	 * 拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 五笔码
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔码
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 助记符
	 * @return String
	 */
	public String getInstr() {
		return ((String) getAttrVal("Instr"));
	}	
	/**
	 * 助记符
	 * @param Instr
	 */
	public void setInstr(String Instr) {
		setAttrVal("Instr", Instr);
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
	 * 最后排班日期
	 * @return FDate
	 */
	public FDate getD_last_sch() {
		return ((FDate) getAttrVal("D_last_sch"));
	}	
	/**
	 * 最后排班日期
	 * @param D_last_sch
	 */
	public void setD_last_sch(FDate D_last_sch) {
		setAttrVal("D_last_sch", D_last_sch);
	}
	/**
	 * 编辑模式
	 * @return String
	 */
	public String getEu_edit_tp() {
		return ((String) getAttrVal("Eu_edit_tp"));
	}	
	/**
	 * 编辑模式
	 * @param Eu_edit_tp
	 */
	public void setEu_edit_tp(String Eu_edit_tp) {
		setAttrVal("Eu_edit_tp", Eu_edit_tp);
	}
	/**
	 * 科室参数
	 * @return String
	 */
	public String getId_depparam() {
		return ((String) getAttrVal("Id_depparam"));
	}	
	/**
	 * 科室参数
	 * @param Id_depparam
	 */
	public void setId_depparam(String Id_depparam) {
		setAttrVal("Id_depparam", Id_depparam);
	}
	/**
	 * 版本
	 * @return String
	 */
	public String getName_ver() {
		return ((String) getAttrVal("Name_ver"));
	}	
	/**
	 * 版本
	 * @param Name_ver
	 */
	public void setName_ver(String Name_ver) {
		setAttrVal("Name_ver", Name_ver);
	}
	/**
	 * 队列工作台
	 * @return String
	 */
	public String getId_queben() {
		return ((String) getAttrVal("Id_queben"));
	}	
	/**
	 * 队列工作台
	 * @param Id_queben
	 */
	public void setId_queben(String Id_queben) {
		setAttrVal("Id_queben", Id_queben);
	}
	/**
	 * 计算单服务时长
	 * @return FDouble
	 */
	public FDouble getSrvslot_cal() {
		return ((FDouble) getAttrVal("Srvslot_cal"));
	}	
	/**
	 * 计算单服务时长
	 * @param Srvslot_cal
	 */
	public void setSrvslot_cal(FDouble Srvslot_cal) {
		setAttrVal("Srvslot_cal", Srvslot_cal);
	}
	/**
	 * 最小刻度
	 * @return Integer
	 */
	public Integer getSrvslot_min() {
		return ((Integer) getAttrVal("Srvslot_min"));
	}	
	/**
	 * 最小刻度
	 * @param Srvslot_min
	 */
	public void setSrvslot_min(Integer Srvslot_min) {
		setAttrVal("Srvslot_min", Srvslot_min);
	}
	/**
	 * 规则
	 * @return String
	 */
	public String getId_querule() {
		return ((String) getAttrVal("Id_querule"));
	}	
	/**
	 * 规则
	 * @param Id_querule
	 */
	public void setId_querule(String Id_querule) {
		setAttrVal("Id_querule", Id_querule);
	}
	/**
	 * 预约使用时间类型
	 * @return Integer
	 */
	public Integer getEu_timeslottp() {
		return ((Integer) getAttrVal("Eu_timeslottp"));
	}	
	/**
	 * 预约使用时间类型
	 * @param Eu_timeslottp
	 */
	public void setEu_timeslottp(Integer Eu_timeslottp) {
		setAttrVal("Eu_timeslottp", Eu_timeslottp);
	}
	/**
	 * 预约优先级
	 * @return Integer
	 */
	public Integer getLevel_pri() {
		return ((Integer) getAttrVal("Level_pri"));
	}	
	/**
	 * 预约优先级
	 * @param Level_pri
	 */
	public void setLevel_pri(Integer Level_pri) {
		setAttrVal("Level_pri", Level_pri);
	}
	/**
	 * 号源释放规则
	 * @return String
	 */
	public String getId_release_rule() {
		return ((String) getAttrVal("Id_release_rule"));
	}	
	/**
	 * 号源释放规则
	 * @param Id_release_rule
	 */
	public void setId_release_rule(String Id_release_rule) {
		setAttrVal("Id_release_rule", Id_release_rule);
	}
	/**
	 * 时间核查标志
	 * @return FBoolean
	 */
	public FBoolean getFg_timechk() {
		return ((FBoolean) getAttrVal("Fg_timechk"));
	}	
	/**
	 * 时间核查标志
	 * @param Fg_timechk
	 */
	public void setFg_timechk(FBoolean Fg_timechk) {
		setAttrVal("Fg_timechk", Fg_timechk);
	}
	/**
	 * 停止排班标志
	 * @return FBoolean
	 */
	public FBoolean getFg_stopsch() {
		return ((FBoolean) getAttrVal("Fg_stopsch"));
	}	
	/**
	 * 停止排班标志
	 * @param Fg_stopsch
	 */
	public void setFg_stopsch(FBoolean Fg_stopsch) {
		setAttrVal("Fg_stopsch", Fg_stopsch);
	}
	/**
	 * 排班所属部门名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 排班所属部门名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 排班服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	/**
	 * 排班服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 排班服务编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}	
	/**
	 * 排班服务编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 备用服务名称
	 * @return String
	 */
	public String getName_optsrv() {
		return ((String) getAttrVal("Name_optsrv"));
	}	
	/**
	 * 备用服务名称
	 * @param Name_optsrv
	 */
	public void setName_optsrv(String Name_optsrv) {
		setAttrVal("Name_optsrv", Name_optsrv);
	}
	/**
	 * 资源编码
	 * @return String
	 */
	public String getCode_res() {
		return ((String) getAttrVal("Code_res"));
	}	
	/**
	 * 资源编码
	 * @param Code_res
	 */
	public void setCode_res(String Code_res) {
		setAttrVal("Code_res", Code_res);
	}
	/**
	 * 资源名称
	 * @return String
	 */
	public String getName_res() {
		return ((String) getAttrVal("Name_res"));
	}	
	/**
	 * 资源名称
	 * @param Name_res
	 */
	public void setName_res(String Name_res) {
		setAttrVal("Name_res", Name_res);
	}
	/**
	 * 排班分类
	 * @return String
	 */
	public String getId_scca_scpl() {
		return ((String) getAttrVal("Id_scca_scpl"));
	}	
	/**
	 * 排班分类
	 * @param Id_scca_scpl
	 */
	public void setId_scca_scpl(String Id_scca_scpl) {
		setAttrVal("Id_scca_scpl", Id_scca_scpl);
	}
	/**
	 * 票号模式名称
	 * @return String
	 */
	public String getName_tickmd() {
		return ((String) getAttrVal("Name_tickmd"));
	}	
	/**
	 * 票号模式名称
	 * @param Name_tickmd
	 */
	public void setName_tickmd(String Name_tickmd) {
		setAttrVal("Name_tickmd", Name_tickmd);
	}
	/**
	 * 优先开放规则编码
	 * @return String
	 */
	public String getCode_apptru() {
		return ((String) getAttrVal("Code_apptru"));
	}	
	/**
	 * 优先开放规则编码
	 * @param Code_apptru
	 */
	public void setCode_apptru(String Code_apptru) {
		setAttrVal("Code_apptru", Code_apptru);
	}
	/**
	 * 优先开放规则名称
	 * @return String
	 */
	public String getName_apptru() {
		return ((String) getAttrVal("Name_apptru"));
	}	
	/**
	 * 优先开放规则名称
	 * @param Name_apptru
	 */
	public void setName_apptru(String Name_apptru) {
		setAttrVal("Name_apptru", Name_apptru);
	}
	/**
	 * 优先开放规则类型编码
	 * @return String
	 */
	public String getCode_schrule() {
		return ((String) getAttrVal("Code_schrule"));
	}	
	/**
	 * 优先开放规则类型编码
	 * @param Code_schrule
	 */
	public void setCode_schrule(String Code_schrule) {
		setAttrVal("Code_schrule", Code_schrule);
	}
	/**
	 * 版本
	 * @return Integer
	 */
	public Integer getVer() {
		return ((Integer) getAttrVal("Ver"));
	}	
	/**
	 * 版本
	 * @param Ver
	 */
	public void setVer(Integer Ver) {
		setAttrVal("Ver", Ver);
	}
	/**
	 * 工作台名称
	 * @return String
	 */
	public String getName_queben() {
		return ((String) getAttrVal("Name_queben"));
	}	
	/**
	 * 工作台名称
	 * @param Name_queben
	 */
	public void setName_queben(String Name_queben) {
		setAttrVal("Name_queben", Name_queben);
	}
	/**
	 * 工作台编码
	 * @return String
	 */
	public String getCode_queben() {
		return ((String) getAttrVal("Code_queben"));
	}	
	/**
	 * 工作台编码
	 * @param Code_queben
	 */
	public void setCode_queben(String Code_queben) {
		setAttrVal("Code_queben", Code_queben);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_rule() {
		return ((String) getAttrVal("Name_rule"));
	}	
	/**
	 * 名称
	 * @param Name_rule
	 */
	public void setName_rule(String Name_rule) {
		setAttrVal("Name_rule", Name_rule);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_rule() {
		return ((String) getAttrVal("Code_rule"));
	}	
	/**
	 * 编码
	 * @param Code_rule
	 */
	public void setCode_rule(String Code_rule) {
		setAttrVal("Code_rule", Code_rule);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_release_rule() {
		return ((String) getAttrVal("Code_release_rule"));
	}	
	/**
	 * 编码
	 * @param Code_release_rule
	 */
	public void setCode_release_rule(String Code_release_rule) {
		setAttrVal("Code_release_rule", Code_release_rule);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_release_rule() {
		return ((String) getAttrVal("Name_release_rule"));
	}	
	/**
	 * 名称
	 * @param Name_release_rule
	 */
	public void setName_release_rule(String Name_release_rule) {
		setAttrVal("Name_release_rule", Name_release_rule);
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
		return "Id_scpl";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_pl";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScPlanDODesc.class);
	}
	
}