package iih.mp.nr.skdmsg.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.nr.skdmsg.d.desc.MpSkdMsgDODesc;
import java.math.BigDecimal;

/**
 * 护理任务消息 DO数据 
 * 
 */
public class MpSkdMsgDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//任务消息
	public static final String ID_SKD_MSG= "Id_skd_msg";
	//任务
	public static final String ID_SKD= "Id_skd";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//就诊id
	public static final String ID_ENT= "Id_ent";
	//患者id
	public static final String ID_PAT= "Id_pat";
	//标题
	public static final String TITLE= "Title";
	//消息内容
	public static final String MSG= "Msg";
	//序号
	public static final String SORTNO= "Sortno";
	//状态
	public static final String EU_STA= "Eu_sta";
	//执行科室
	public static final String ID_DEP_MP= "Id_dep_mp";
	//严重程度ID
	public static final String ID_LEVEL= "Id_level";
	//严重程度编码
	public static final String SD_LEVEL= "Sd_level";
	//可见范围ID
	public static final String ID_VISRANGE= "Id_visrange";
	//可见范围编码
	public static final String SD_VISRANGE= "Sd_visrange";
	//处理功能节点
	public static final String FUN_CODE= "Fun_code";
	//类名
	public static final String NAME_CLASS= "Name_class";
	//处理人
	public static final String ID_EMP= "Id_emp";
	//处理科室
	public static final String ID_DEP= "Id_dep";
	//操作时间
	public static final String DT_OPER= "Dt_oper";
	//操作科室
	public static final String ID_DEP_OPER= "Id_dep_oper";
	//操作人
	public static final String ID_EMP_OPER= "Id_emp_oper";
	//任务参数Id
	public static final String PARAM_ID= "Param_id";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//提醒时间
	public static final String DT_REMIND= "Dt_remind";
	//任务类型id
	public static final String ID_SKDTP= "Id_skdtp";
	//任务类型sd
	public static final String SD_SKDTP= "Sd_skdtp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 任务消息
	 * @return String
	 */
	public String getId_skd_msg() {
		return ((String) getAttrVal("Id_skd_msg"));
	}	
	/**
	 * 任务消息
	 * @param Id_skd_msg
	 */
	public void setId_skd_msg(String Id_skd_msg) {
		setAttrVal("Id_skd_msg", Id_skd_msg);
	}
	/**
	 * 任务
	 * @return String
	 */
	public String getId_skd() {
		return ((String) getAttrVal("Id_skd"));
	}	
	/**
	 * 任务
	 * @param Id_skd
	 */
	public void setId_skd(String Id_skd) {
		setAttrVal("Id_skd", Id_skd);
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
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 标题
	 * @return String
	 */
	public String getTitle() {
		return ((String) getAttrVal("Title"));
	}	
	/**
	 * 标题
	 * @param Title
	 */
	public void setTitle(String Title) {
		setAttrVal("Title", Title);
	}
	/**
	 * 消息内容
	 * @return String
	 */
	public String getMsg() {
		return ((String) getAttrVal("Msg"));
	}	
	/**
	 * 消息内容
	 * @param Msg
	 */
	public void setMsg(String Msg) {
		setAttrVal("Msg", Msg);
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
	 * 状态
	 * @return Integer
	 */
	public Integer getEu_sta() {
		return ((Integer) getAttrVal("Eu_sta"));
	}	
	/**
	 * 状态
	 * @param Eu_sta
	 */
	public void setEu_sta(Integer Eu_sta) {
		setAttrVal("Eu_sta", Eu_sta);
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
	 * 严重程度ID
	 * @return String
	 */
	public String getId_level() {
		return ((String) getAttrVal("Id_level"));
	}	
	/**
	 * 严重程度ID
	 * @param Id_level
	 */
	public void setId_level(String Id_level) {
		setAttrVal("Id_level", Id_level);
	}
	/**
	 * 严重程度编码
	 * @return String
	 */
	public String getSd_level() {
		return ((String) getAttrVal("Sd_level"));
	}	
	/**
	 * 严重程度编码
	 * @param Sd_level
	 */
	public void setSd_level(String Sd_level) {
		setAttrVal("Sd_level", Sd_level);
	}
	/**
	 * 可见范围ID
	 * @return String
	 */
	public String getId_visrange() {
		return ((String) getAttrVal("Id_visrange"));
	}	
	/**
	 * 可见范围ID
	 * @param Id_visrange
	 */
	public void setId_visrange(String Id_visrange) {
		setAttrVal("Id_visrange", Id_visrange);
	}
	/**
	 * 可见范围编码
	 * @return String
	 */
	public String getSd_visrange() {
		return ((String) getAttrVal("Sd_visrange"));
	}	
	/**
	 * 可见范围编码
	 * @param Sd_visrange
	 */
	public void setSd_visrange(String Sd_visrange) {
		setAttrVal("Sd_visrange", Sd_visrange);
	}
	/**
	 * 处理功能节点
	 * @return String
	 */
	public String getFun_code() {
		return ((String) getAttrVal("Fun_code"));
	}	
	/**
	 * 处理功能节点
	 * @param Fun_code
	 */
	public void setFun_code(String Fun_code) {
		setAttrVal("Fun_code", Fun_code);
	}
	/**
	 * 类名
	 * @return String
	 */
	public String getName_class() {
		return ((String) getAttrVal("Name_class"));
	}	
	/**
	 * 类名
	 * @param Name_class
	 */
	public void setName_class(String Name_class) {
		setAttrVal("Name_class", Name_class);
	}
	/**
	 * 处理人
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	/**
	 * 处理人
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 处理科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 处理科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_oper() {
		return ((FDateTime) getAttrVal("Dt_oper"));
	}	
	/**
	 * 操作时间
	 * @param Dt_oper
	 */
	public void setDt_oper(FDateTime Dt_oper) {
		setAttrVal("Dt_oper", Dt_oper);
	}
	/**
	 * 操作科室
	 * @return String
	 */
	public String getId_dep_oper() {
		return ((String) getAttrVal("Id_dep_oper"));
	}	
	/**
	 * 操作科室
	 * @param Id_dep_oper
	 */
	public void setId_dep_oper(String Id_dep_oper) {
		setAttrVal("Id_dep_oper", Id_dep_oper);
	}
	/**
	 * 操作人
	 * @return String
	 */
	public String getId_emp_oper() {
		return ((String) getAttrVal("Id_emp_oper"));
	}	
	/**
	 * 操作人
	 * @param Id_emp_oper
	 */
	public void setId_emp_oper(String Id_emp_oper) {
		setAttrVal("Id_emp_oper", Id_emp_oper);
	}
	/**
	 * 任务参数Id
	 * @return String
	 */
	public String getParam_id() {
		return ((String) getAttrVal("Param_id"));
	}	
	/**
	 * 任务参数Id
	 * @param Param_id
	 */
	public void setParam_id(String Param_id) {
		setAttrVal("Param_id", Param_id);
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
	 * 提醒时间
	 * @return FDateTime
	 */
	public FDateTime getDt_remind() {
		return ((FDateTime) getAttrVal("Dt_remind"));
	}	
	/**
	 * 提醒时间
	 * @param Dt_remind
	 */
	public void setDt_remind(FDateTime Dt_remind) {
		setAttrVal("Dt_remind", Dt_remind);
	}
	/**
	 * 任务类型id
	 * @return String
	 */
	public String getId_skdtp() {
		return ((String) getAttrVal("Id_skdtp"));
	}	
	/**
	 * 任务类型id
	 * @param Id_skdtp
	 */
	public void setId_skdtp(String Id_skdtp) {
		setAttrVal("Id_skdtp", Id_skdtp);
	}
	/**
	 * 任务类型sd
	 * @return String
	 */
	public String getSd_skdtp() {
		return ((String) getAttrVal("Sd_skdtp"));
	}	
	/**
	 * 任务类型sd
	 * @param Sd_skdtp
	 */
	public void setSd_skdtp(String Sd_skdtp) {
		setAttrVal("Sd_skdtp", Sd_skdtp);
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
		return "Id_skd_msg";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_skd_msg";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpSkdMsgDODesc.class);
	}
	
}