package iih.bd.fc.quesite.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.fc.quesite.d.desc.QueSiteDODesc;
import java.math.BigDecimal;

/**
 * 队列工作点 DO数据 
 * 
 */
public class QueSiteDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//就诊队列工作点主键
	public static final String ID_QUESITE= "Id_quesite";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//队列
	public static final String ID_QUE= "Id_que";
	//工作点编码
	public static final String CODE= "Code";
	//工作点名称
	public static final String NAME= "Name";
	//工作点简称
	public static final String SHORTNAME= "Shortname";
	//工作点描述
	public static final String DES= "Des";
	//计算机工作站
	public static final String ID_PC= "Id_pc";
	//工作点类型编码
	public static final String SD_QUESITETP= "Sd_quesitetp";
	//工作点类型
	public static final String ID_QUESITETP= "Id_quesitetp";
	//申请量
	public static final String APPLY_MAX= "Apply_max";
	//上屏数量
	public static final String CALL_NUM= "Call_num";
	//屏幕地址
	public static final String ADDR_BOARD= "Addr_board";
	//暂停有效开始日期时间
	public static final String DATE_B_PAUSE= "Date_b_pause";
	//暂停有效结束日期时间
	public static final String DATE_E_PAUSE= "Date_e_pause";
	//五笔
	public static final String WBCODE= "Wbcode";
	//拼音
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//工作台
	public static final String ID_QUEBEN= "Id_queben";
	//使用员工
	public static final String ID_EMP= "Id_emp";
	//科室
	public static final String ID_DEP= "Id_dep";
	//可使用科室
	public static final String IDS_DEP_ENABLE= "Ids_dep_enable";
	//分诊规则
	public static final String ID_QUERULE= "Id_querule";
	//启用
	public static final String FG_ACTIVE= "Fg_active";
	//工作点状态
	public static final String EU_PAUSE= "Eu_pause";
	//叫号器终端地址
	public static final String ADDR_CALLERTERM= "Addr_callerterm";
	//诊间
	public static final String ROOM= "Room";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//显示屏id
	public static final String ID_BRD= "Id_brd";
	//队列编码
	public static final String CODE_QUE= "Code_que";
	//队列名称
	public static final String NAME_QUE= "Name_que";
	//计算机工作站编码
	public static final String PC_CODE= "Pc_code";
	//计算机工作站名称
	public static final String PC_NAME= "Pc_name";
	//工作台编码
	public static final String BEN_CODE= "Ben_code";
	//工作台名称
	public static final String BEN_NAME= "Ben_name";
	//人员编码
	public static final String EMP_CODE= "Emp_code";
	//姓名
	public static final String EMP_NAME= "Emp_name";
	//编码
	public static final String DEP_CODE= "Dep_code";
	//名称
	public static final String DEP_NAME= "Dep_name";
	//编码
	public static final String DEPS_CODE= "Deps_code";
	//名称
	public static final String DEPS_NAME= "Deps_name";
	//名称
	public static final String NAME_RULE= "Name_rule";
	//唯一地址
	public static final String ADDR_BRD= "Addr_brd";
	//大屏自身PC
	public static final String ID_PC_BRD= "Id_pc_brd";
	//名称
	public static final String NAME_BRD= "Name_brd";
	//编码
	public static final String CODE_BRD= "Code_brd";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 就诊队列工作点主键
	 * @return String
	 */
	public String getId_quesite() {
		return ((String) getAttrVal("Id_quesite"));
	}	
	/**
	 * 就诊队列工作点主键
	 * @param Id_quesite
	 */
	public void setId_quesite(String Id_quesite) {
		setAttrVal("Id_quesite", Id_quesite);
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
	 * 队列
	 * @return String
	 */
	public String getId_que() {
		return ((String) getAttrVal("Id_que"));
	}	
	/**
	 * 队列
	 * @param Id_que
	 */
	public void setId_que(String Id_que) {
		setAttrVal("Id_que", Id_que);
	}
	/**
	 * 工作点编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 工作点编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 工作点名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 工作点名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 工作点简称
	 * @return String
	 */
	public String getShortname() {
		return ((String) getAttrVal("Shortname"));
	}	
	/**
	 * 工作点简称
	 * @param Shortname
	 */
	public void setShortname(String Shortname) {
		setAttrVal("Shortname", Shortname);
	}
	/**
	 * 工作点描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 工作点描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 计算机工作站
	 * @return String
	 */
	public String getId_pc() {
		return ((String) getAttrVal("Id_pc"));
	}	
	/**
	 * 计算机工作站
	 * @param Id_pc
	 */
	public void setId_pc(String Id_pc) {
		setAttrVal("Id_pc", Id_pc);
	}
	/**
	 * 工作点类型编码
	 * @return String
	 */
	public String getSd_quesitetp() {
		return ((String) getAttrVal("Sd_quesitetp"));
	}	
	/**
	 * 工作点类型编码
	 * @param Sd_quesitetp
	 */
	public void setSd_quesitetp(String Sd_quesitetp) {
		setAttrVal("Sd_quesitetp", Sd_quesitetp);
	}
	/**
	 * 工作点类型
	 * @return String
	 */
	public String getId_quesitetp() {
		return ((String) getAttrVal("Id_quesitetp"));
	}	
	/**
	 * 工作点类型
	 * @param Id_quesitetp
	 */
	public void setId_quesitetp(String Id_quesitetp) {
		setAttrVal("Id_quesitetp", Id_quesitetp);
	}
	/**
	 * 申请量
	 * @return Integer
	 */
	public Integer getApply_max() {
		return ((Integer) getAttrVal("Apply_max"));
	}	
	/**
	 * 申请量
	 * @param Apply_max
	 */
	public void setApply_max(Integer Apply_max) {
		setAttrVal("Apply_max", Apply_max);
	}
	/**
	 * 上屏数量
	 * @return Integer
	 */
	public Integer getCall_num() {
		return ((Integer) getAttrVal("Call_num"));
	}	
	/**
	 * 上屏数量
	 * @param Call_num
	 */
	public void setCall_num(Integer Call_num) {
		setAttrVal("Call_num", Call_num);
	}
	/**
	 * 屏幕地址
	 * @return String
	 */
	public String getAddr_board() {
		return ((String) getAttrVal("Addr_board"));
	}	
	/**
	 * 屏幕地址
	 * @param Addr_board
	 */
	public void setAddr_board(String Addr_board) {
		setAttrVal("Addr_board", Addr_board);
	}
	/**
	 * 暂停有效开始日期时间
	 * @return FDateTime
	 */
	public FDateTime getDate_b_pause() {
		return ((FDateTime) getAttrVal("Date_b_pause"));
	}	
	/**
	 * 暂停有效开始日期时间
	 * @param Date_b_pause
	 */
	public void setDate_b_pause(FDateTime Date_b_pause) {
		setAttrVal("Date_b_pause", Date_b_pause);
	}
	/**
	 * 暂停有效结束日期时间
	 * @return FDateTime
	 */
	public FDateTime getDate_e_pause() {
		return ((FDateTime) getAttrVal("Date_e_pause"));
	}	
	/**
	 * 暂停有效结束日期时间
	 * @param Date_e_pause
	 */
	public void setDate_e_pause(FDateTime Date_e_pause) {
		setAttrVal("Date_e_pause", Date_e_pause);
	}
	/**
	 * 五笔
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 拼音
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	/**
	 * 助记码
	 * @param Mnecode
	 */
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	/**
	 * 工作台
	 * @return String
	 */
	public String getId_queben() {
		return ((String) getAttrVal("Id_queben"));
	}	
	/**
	 * 工作台
	 * @param Id_queben
	 */
	public void setId_queben(String Id_queben) {
		setAttrVal("Id_queben", Id_queben);
	}
	/**
	 * 使用员工
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	/**
	 * 使用员工
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 可使用科室
	 * @return String
	 */
	public String getIds_dep_enable() {
		return ((String) getAttrVal("Ids_dep_enable"));
	}	
	/**
	 * 可使用科室
	 * @param Ids_dep_enable
	 */
	public void setIds_dep_enable(String Ids_dep_enable) {
		setAttrVal("Ids_dep_enable", Ids_dep_enable);
	}
	/**
	 * 分诊规则
	 * @return String
	 */
	public String getId_querule() {
		return ((String) getAttrVal("Id_querule"));
	}	
	/**
	 * 分诊规则
	 * @param Id_querule
	 */
	public void setId_querule(String Id_querule) {
		setAttrVal("Id_querule", Id_querule);
	}
	/**
	 * 启用
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 工作点状态
	 * @return String
	 */
	public String getEu_pause() {
		return ((String) getAttrVal("Eu_pause"));
	}	
	/**
	 * 工作点状态
	 * @param Eu_pause
	 */
	public void setEu_pause(String Eu_pause) {
		setAttrVal("Eu_pause", Eu_pause);
	}
	/**
	 * 叫号器终端地址
	 * @return String
	 */
	public String getAddr_callerterm() {
		return ((String) getAttrVal("Addr_callerterm"));
	}	
	/**
	 * 叫号器终端地址
	 * @param Addr_callerterm
	 */
	public void setAddr_callerterm(String Addr_callerterm) {
		setAttrVal("Addr_callerterm", Addr_callerterm);
	}
	/**
	 * 诊间
	 * @return String
	 */
	public String getRoom() {
		return ((String) getAttrVal("Room"));
	}	
	/**
	 * 诊间
	 * @param Room
	 */
	public void setRoom(String Room) {
		setAttrVal("Room", Room);
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
	 * 显示屏id
	 * @return String
	 */
	public String getId_brd() {
		return ((String) getAttrVal("Id_brd"));
	}	
	/**
	 * 显示屏id
	 * @param Id_brd
	 */
	public void setId_brd(String Id_brd) {
		setAttrVal("Id_brd", Id_brd);
	}
	/**
	 * 队列编码
	 * @return String
	 */
	public String getCode_que() {
		return ((String) getAttrVal("Code_que"));
	}	
	/**
	 * 队列编码
	 * @param Code_que
	 */
	public void setCode_que(String Code_que) {
		setAttrVal("Code_que", Code_que);
	}
	/**
	 * 队列名称
	 * @return String
	 */
	public String getName_que() {
		return ((String) getAttrVal("Name_que"));
	}	
	/**
	 * 队列名称
	 * @param Name_que
	 */
	public void setName_que(String Name_que) {
		setAttrVal("Name_que", Name_que);
	}
	/**
	 * 计算机工作站编码
	 * @return String
	 */
	public String getPc_code() {
		return ((String) getAttrVal("Pc_code"));
	}	
	/**
	 * 计算机工作站编码
	 * @param Pc_code
	 */
	public void setPc_code(String Pc_code) {
		setAttrVal("Pc_code", Pc_code);
	}
	/**
	 * 计算机工作站名称
	 * @return String
	 */
	public String getPc_name() {
		return ((String) getAttrVal("Pc_name"));
	}	
	/**
	 * 计算机工作站名称
	 * @param Pc_name
	 */
	public void setPc_name(String Pc_name) {
		setAttrVal("Pc_name", Pc_name);
	}
	/**
	 * 工作台编码
	 * @return String
	 */
	public String getBen_code() {
		return ((String) getAttrVal("Ben_code"));
	}	
	/**
	 * 工作台编码
	 * @param Ben_code
	 */
	public void setBen_code(String Ben_code) {
		setAttrVal("Ben_code", Ben_code);
	}
	/**
	 * 工作台名称
	 * @return String
	 */
	public String getBen_name() {
		return ((String) getAttrVal("Ben_name"));
	}	
	/**
	 * 工作台名称
	 * @param Ben_name
	 */
	public void setBen_name(String Ben_name) {
		setAttrVal("Ben_name", Ben_name);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getEmp_code() {
		return ((String) getAttrVal("Emp_code"));
	}	
	/**
	 * 人员编码
	 * @param Emp_code
	 */
	public void setEmp_code(String Emp_code) {
		setAttrVal("Emp_code", Emp_code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getEmp_name() {
		return ((String) getAttrVal("Emp_name"));
	}	
	/**
	 * 姓名
	 * @param Emp_name
	 */
	public void setEmp_name(String Emp_name) {
		setAttrVal("Emp_name", Emp_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDep_code() {
		return ((String) getAttrVal("Dep_code"));
	}	
	/**
	 * 编码
	 * @param Dep_code
	 */
	public void setDep_code(String Dep_code) {
		setAttrVal("Dep_code", Dep_code);
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
	 * 编码
	 * @return String
	 */
	public String getDeps_code() {
		return ((String) getAttrVal("Deps_code"));
	}	
	/**
	 * 编码
	 * @param Deps_code
	 */
	public void setDeps_code(String Deps_code) {
		setAttrVal("Deps_code", Deps_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDeps_name() {
		return ((String) getAttrVal("Deps_name"));
	}	
	/**
	 * 名称
	 * @param Deps_name
	 */
	public void setDeps_name(String Deps_name) {
		setAttrVal("Deps_name", Deps_name);
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
	 * 唯一地址
	 * @return String
	 */
	public String getAddr_brd() {
		return ((String) getAttrVal("Addr_brd"));
	}	
	/**
	 * 唯一地址
	 * @param Addr_brd
	 */
	public void setAddr_brd(String Addr_brd) {
		setAttrVal("Addr_brd", Addr_brd);
	}
	/**
	 * 大屏自身PC
	 * @return String
	 */
	public String getId_pc_brd() {
		return ((String) getAttrVal("Id_pc_brd"));
	}	
	/**
	 * 大屏自身PC
	 * @param Id_pc_brd
	 */
	public void setId_pc_brd(String Id_pc_brd) {
		setAttrVal("Id_pc_brd", Id_pc_brd);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_brd() {
		return ((String) getAttrVal("Name_brd"));
	}	
	/**
	 * 名称
	 * @param Name_brd
	 */
	public void setName_brd(String Name_brd) {
		setAttrVal("Name_brd", Name_brd);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_brd() {
		return ((String) getAttrVal("Code_brd"));
	}	
	/**
	 * 编码
	 * @param Code_brd
	 */
	public void setCode_brd(String Code_brd) {
		setAttrVal("Code_brd", Code_brd);
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
		return "Id_quesite";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_que_site";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(QueSiteDODesc.class);
	}
	
}