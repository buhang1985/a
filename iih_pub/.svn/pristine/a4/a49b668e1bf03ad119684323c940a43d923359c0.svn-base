package iih.mp.mpbd.mpskd.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.mpbd.mpskd.d.desc.MpSkdDODesc;
import java.math.BigDecimal;

/**
 * 护理任务定义 DO数据 
 * 
 */
public class MpSkdDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//护理任务主键
	public static final String ID_SKD= "Id_skd";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//触发原因
	public static final String NAME_TRIGGER= "Name_trigger";
	//显示内容模板
	public static final String CONTENT_TMPL= "Content_tmpl";
	//所属类型
	public static final String ID_OWNTP= "Id_owntp";
	//所属类型编码
	public static final String SD_OWNTP= "Sd_owntp";
	//所属科室
	public static final String ID_DEP= "Id_dep";
	//任务类型
	public static final String ID_SKDTP= "Id_skdtp";
	//任务类型编码
	public static final String SD_SKDTP= "Sd_skdtp";
	//严重级别
	public static final String ID_LEVEL= "Id_level";
	//严重级别编码
	public static final String SD_LEVEL= "Sd_level";
	//处理次数
	public static final String TIMES= "Times";
	//处理周期
	public static final String CYCLE= "Cycle";
	//周期单位
	public static final String ID_UNIT= "Id_unit";
	//可见范围
	public static final String ID_VISRANGE= "Id_visrange";
	//可见范围编码
	public static final String SD_VISRANGE= "Sd_visrange";
	//是否发送事件
	public static final String FG_EVENT= "Fg_event";
	//发送事件
	public static final String ID_EVENT= "Id_event";
	//事件编码
	public static final String SD_EVENT= "Sd_event";
	//启用标志
	public static final String FG_ACTIVE= "Fg_active";
	//备注信息
	public static final String NOTE= "Note";
	//扩展字段1
	public static final String DEF1= "Def1";
	//扩展字段2
	public static final String DEF2= "Def2";
	//扩展字段3
	public static final String DEF3= "Def3";
	//扩展字段4
	public static final String DEF4= "Def4";
	//扩展字段5
	public static final String DEF5= "Def5";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//所属类型
	public static final String NAME_OWNTP= "Name_owntp";
	//所属科室
	public static final String NAME_DEP= "Name_dep";
	//任务类型
	public static final String NAME_SKDTP= "Name_skdtp";
	//严重级别
	public static final String NAME_LEVEL= "Name_level";
	//周期单位
	public static final String NAME_UNIT= "Name_unit";
	//可见范围
	public static final String NAME_VISRANGE= "Name_visrange";
	//事件
	public static final String NAME_EVENT= "Name_event";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 护理任务主键
	 * @return String
	 */
	public String getId_skd() {
		return ((String) getAttrVal("Id_skd"));
	}	
	/**
	 * 护理任务主键
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
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 触发原因
	 * @return String
	 */
	public String getName_trigger() {
		return ((String) getAttrVal("Name_trigger"));
	}	
	/**
	 * 触发原因
	 * @param Name_trigger
	 */
	public void setName_trigger(String Name_trigger) {
		setAttrVal("Name_trigger", Name_trigger);
	}
	/**
	 * 显示内容模板
	 * @return String
	 */
	public String getContent_tmpl() {
		return ((String) getAttrVal("Content_tmpl"));
	}	
	/**
	 * 显示内容模板
	 * @param Content_tmpl
	 */
	public void setContent_tmpl(String Content_tmpl) {
		setAttrVal("Content_tmpl", Content_tmpl);
	}
	/**
	 * 所属类型
	 * @return String
	 */
	public String getId_owntp() {
		return ((String) getAttrVal("Id_owntp"));
	}	
	/**
	 * 所属类型
	 * @param Id_owntp
	 */
	public void setId_owntp(String Id_owntp) {
		setAttrVal("Id_owntp", Id_owntp);
	}
	/**
	 * 所属类型编码
	 * @return String
	 */
	public String getSd_owntp() {
		return ((String) getAttrVal("Sd_owntp"));
	}	
	/**
	 * 所属类型编码
	 * @param Sd_owntp
	 */
	public void setSd_owntp(String Sd_owntp) {
		setAttrVal("Sd_owntp", Sd_owntp);
	}
	/**
	 * 所属科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 所属科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 任务类型
	 * @return String
	 */
	public String getId_skdtp() {
		return ((String) getAttrVal("Id_skdtp"));
	}	
	/**
	 * 任务类型
	 * @param Id_skdtp
	 */
	public void setId_skdtp(String Id_skdtp) {
		setAttrVal("Id_skdtp", Id_skdtp);
	}
	/**
	 * 任务类型编码
	 * @return String
	 */
	public String getSd_skdtp() {
		return ((String) getAttrVal("Sd_skdtp"));
	}	
	/**
	 * 任务类型编码
	 * @param Sd_skdtp
	 */
	public void setSd_skdtp(String Sd_skdtp) {
		setAttrVal("Sd_skdtp", Sd_skdtp);
	}
	/**
	 * 严重级别
	 * @return String
	 */
	public String getId_level() {
		return ((String) getAttrVal("Id_level"));
	}	
	/**
	 * 严重级别
	 * @param Id_level
	 */
	public void setId_level(String Id_level) {
		setAttrVal("Id_level", Id_level);
	}
	/**
	 * 严重级别编码
	 * @return String
	 */
	public String getSd_level() {
		return ((String) getAttrVal("Sd_level"));
	}	
	/**
	 * 严重级别编码
	 * @param Sd_level
	 */
	public void setSd_level(String Sd_level) {
		setAttrVal("Sd_level", Sd_level);
	}
	/**
	 * 处理次数
	 * @return Integer
	 */
	public Integer getTimes() {
		return ((Integer) getAttrVal("Times"));
	}	
	/**
	 * 处理次数
	 * @param Times
	 */
	public void setTimes(Integer Times) {
		setAttrVal("Times", Times);
	}
	/**
	 * 处理周期
	 * @return Integer
	 */
	public Integer getCycle() {
		return ((Integer) getAttrVal("Cycle"));
	}	
	/**
	 * 处理周期
	 * @param Cycle
	 */
	public void setCycle(Integer Cycle) {
		setAttrVal("Cycle", Cycle);
	}
	/**
	 * 周期单位
	 * @return String
	 */
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}	
	/**
	 * 周期单位
	 * @param Id_unit
	 */
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	/**
	 * 可见范围
	 * @return String
	 */
	public String getId_visrange() {
		return ((String) getAttrVal("Id_visrange"));
	}	
	/**
	 * 可见范围
	 * @param Id_visrange
	 */
	public void setId_visrange(String Id_visrange) {
		setAttrVal("Id_visrange", Id_visrange);
	}
	/**
	 * 可见范围编码
	 * @return Integer
	 */
	public Integer getSd_visrange() {
		return ((Integer) getAttrVal("Sd_visrange"));
	}	
	/**
	 * 可见范围编码
	 * @param Sd_visrange
	 */
	public void setSd_visrange(Integer Sd_visrange) {
		setAttrVal("Sd_visrange", Sd_visrange);
	}
	/**
	 * 是否发送事件
	 * @return FBoolean
	 */
	public FBoolean getFg_event() {
		return ((FBoolean) getAttrVal("Fg_event"));
	}	
	/**
	 * 是否发送事件
	 * @param Fg_event
	 */
	public void setFg_event(FBoolean Fg_event) {
		setAttrVal("Fg_event", Fg_event);
	}
	/**
	 * 发送事件
	 * @return String
	 */
	public String getId_event() {
		return ((String) getAttrVal("Id_event"));
	}	
	/**
	 * 发送事件
	 * @param Id_event
	 */
	public void setId_event(String Id_event) {
		setAttrVal("Id_event", Id_event);
	}
	/**
	 * 事件编码
	 * @return String
	 */
	public String getSd_event() {
		return ((String) getAttrVal("Sd_event"));
	}	
	/**
	 * 事件编码
	 * @param Sd_event
	 */
	public void setSd_event(String Sd_event) {
		setAttrVal("Sd_event", Sd_event);
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
	 * 备注信息
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 备注信息
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	/**
	 * 扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	/**
	 * 扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
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
	 * 所属类型
	 * @return String
	 */
	public String getName_owntp() {
		return ((String) getAttrVal("Name_owntp"));
	}	
	/**
	 * 所属类型
	 * @param Name_owntp
	 */
	public void setName_owntp(String Name_owntp) {
		setAttrVal("Name_owntp", Name_owntp);
	}
	/**
	 * 所属科室
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 所属科室
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 任务类型
	 * @return String
	 */
	public String getName_skdtp() {
		return ((String) getAttrVal("Name_skdtp"));
	}	
	/**
	 * 任务类型
	 * @param Name_skdtp
	 */
	public void setName_skdtp(String Name_skdtp) {
		setAttrVal("Name_skdtp", Name_skdtp);
	}
	/**
	 * 严重级别
	 * @return String
	 */
	public String getName_level() {
		return ((String) getAttrVal("Name_level"));
	}	
	/**
	 * 严重级别
	 * @param Name_level
	 */
	public void setName_level(String Name_level) {
		setAttrVal("Name_level", Name_level);
	}
	/**
	 * 周期单位
	 * @return String
	 */
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}	
	/**
	 * 周期单位
	 * @param Name_unit
	 */
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
	}
	/**
	 * 可见范围
	 * @return String
	 */
	public String getName_visrange() {
		return ((String) getAttrVal("Name_visrange"));
	}	
	/**
	 * 可见范围
	 * @param Name_visrange
	 */
	public void setName_visrange(String Name_visrange) {
		setAttrVal("Name_visrange", Name_visrange);
	}
	/**
	 * 事件
	 * @return String
	 */
	public String getName_event() {
		return ((String) getAttrVal("Name_event"));
	}	
	/**
	 * 事件
	 * @param Name_event
	 */
	public void setName_event(String Name_event) {
		setAttrVal("Name_event", Name_event);
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
		return "Id_skd";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_skd";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpSkdDODesc.class);
	}
	
}