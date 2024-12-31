package iih.pe.pbd.pediroom.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pbd.pediroom.d.desc.PeDiDiRoomDODesc;
import java.math.BigDecimal;

/**
 * 体检诊间定义 DO数据 
 * 
 */
public class PeDiDiRoomDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检科室诊间设定主键标识
	public static final String ID_PEDIROOM= "Id_pediroom";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//诊间编码
	public static final String CODE= "Code";
	//诊间名称
	public static final String NAME= "Name";
	//诊间英文名
	public static final String ENAME= "Ename";
	//房间号
	public static final String NO_ROOM= "No_room";
	//性别限制
	public static final String SEXLIMIT= "Sexlimit";
	//默认性别限制
	public static final String SEXLIMIT_INIT= "Sexlimit_init";
	//所属体检科室
	public static final String ID_PEDEPTSET= "Id_pedeptset";
	//所属体检功能区
	public static final String ID_PEFUNCAREA= "Id_pefuncarea";
	//检查耗时（分）
	public static final String TIME_CHK= "Time_chk";
	//最大等候时间
	public static final String MAX_WAIT_TIME= "Max_wait_time";
	//led编号
	public static final String CODE_LED= "Code_led";
	//led名称
	public static final String CAPTION_LED= "Caption_led";
	//地点位置
	public static final String LOCATION= "Location";
	//是否导诊台
	public static final String FG_GUIDESTATION= "Fg_guidestation";
	//有无医生
	public static final String FG_DOCTOR= "Fg_doctor";
	//VIP类型
	public static final String VIPTYPE= "Viptype";
	//序号
	public static final String SORTNO= "Sortno";
	//控制台显示标识
	public static final String FG_SHOW= "Fg_show";
	//工作站类型
	public static final String WSTP= "Wstp";
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
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//体检科室编码
	public static final String CODE_DEP= "Code_dep";
	//体检科室名称
	public static final String NAME_DEP= "Name_dep";
	//功能区名称
	public static final String NAME_FUNCAREA= "Name_funcarea";
	//功能区编码
	public static final String CODE_FUNCAREA= "Code_funcarea";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检科室诊间设定主键标识
	 * @return String
	 */
	public String getId_pediroom() {
		return ((String) getAttrVal("Id_pediroom"));
	}	
	/**
	 * 体检科室诊间设定主键标识
	 * @param Id_pediroom
	 */
	public void setId_pediroom(String Id_pediroom) {
		setAttrVal("Id_pediroom", Id_pediroom);
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
	 * 诊间编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 诊间编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 诊间名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 诊间名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 诊间英文名
	 * @return String
	 */
	public String getEname() {
		return ((String) getAttrVal("Ename"));
	}	
	/**
	 * 诊间英文名
	 * @param Ename
	 */
	public void setEname(String Ename) {
		setAttrVal("Ename", Ename);
	}
	/**
	 * 房间号
	 * @return String
	 */
	public String getNo_room() {
		return ((String) getAttrVal("No_room"));
	}	
	/**
	 * 房间号
	 * @param No_room
	 */
	public void setNo_room(String No_room) {
		setAttrVal("No_room", No_room);
	}
	/**
	 * 性别限制
	 * @return Integer
	 */
	public Integer getSexlimit() {
		return ((Integer) getAttrVal("Sexlimit"));
	}	
	/**
	 * 性别限制
	 * @param Sexlimit
	 */
	public void setSexlimit(Integer Sexlimit) {
		setAttrVal("Sexlimit", Sexlimit);
	}
	/**
	 * 默认性别限制
	 * @return Integer
	 */
	public Integer getSexlimit_init() {
		return ((Integer) getAttrVal("Sexlimit_init"));
	}	
	/**
	 * 默认性别限制
	 * @param Sexlimit_init
	 */
	public void setSexlimit_init(Integer Sexlimit_init) {
		setAttrVal("Sexlimit_init", Sexlimit_init);
	}
	/**
	 * 所属体检科室
	 * @return String
	 */
	public String getId_pedeptset() {
		return ((String) getAttrVal("Id_pedeptset"));
	}	
	/**
	 * 所属体检科室
	 * @param Id_pedeptset
	 */
	public void setId_pedeptset(String Id_pedeptset) {
		setAttrVal("Id_pedeptset", Id_pedeptset);
	}
	/**
	 * 所属体检功能区
	 * @return String
	 */
	public String getId_pefuncarea() {
		return ((String) getAttrVal("Id_pefuncarea"));
	}	
	/**
	 * 所属体检功能区
	 * @param Id_pefuncarea
	 */
	public void setId_pefuncarea(String Id_pefuncarea) {
		setAttrVal("Id_pefuncarea", Id_pefuncarea);
	}
	/**
	 * 检查耗时（分）
	 * @return Integer
	 */
	public Integer getTime_chk() {
		return ((Integer) getAttrVal("Time_chk"));
	}	
	/**
	 * 检查耗时（分）
	 * @param Time_chk
	 */
	public void setTime_chk(Integer Time_chk) {
		setAttrVal("Time_chk", Time_chk);
	}
	/**
	 * 最大等候时间
	 * @return Integer
	 */
	public Integer getMax_wait_time() {
		return ((Integer) getAttrVal("Max_wait_time"));
	}	
	/**
	 * 最大等候时间
	 * @param Max_wait_time
	 */
	public void setMax_wait_time(Integer Max_wait_time) {
		setAttrVal("Max_wait_time", Max_wait_time);
	}
	/**
	 * led编号
	 * @return String
	 */
	public String getCode_led() {
		return ((String) getAttrVal("Code_led"));
	}	
	/**
	 * led编号
	 * @param Code_led
	 */
	public void setCode_led(String Code_led) {
		setAttrVal("Code_led", Code_led);
	}
	/**
	 * led名称
	 * @return String
	 */
	public String getCaption_led() {
		return ((String) getAttrVal("Caption_led"));
	}	
	/**
	 * led名称
	 * @param Caption_led
	 */
	public void setCaption_led(String Caption_led) {
		setAttrVal("Caption_led", Caption_led);
	}
	/**
	 * 地点位置
	 * @return String
	 */
	public String getLocation() {
		return ((String) getAttrVal("Location"));
	}	
	/**
	 * 地点位置
	 * @param Location
	 */
	public void setLocation(String Location) {
		setAttrVal("Location", Location);
	}
	/**
	 * 是否导诊台
	 * @return FBoolean
	 */
	public FBoolean getFg_guidestation() {
		return ((FBoolean) getAttrVal("Fg_guidestation"));
	}	
	/**
	 * 是否导诊台
	 * @param Fg_guidestation
	 */
	public void setFg_guidestation(FBoolean Fg_guidestation) {
		setAttrVal("Fg_guidestation", Fg_guidestation);
	}
	/**
	 * 有无医生
	 * @return FBoolean
	 */
	public FBoolean getFg_doctor() {
		return ((FBoolean) getAttrVal("Fg_doctor"));
	}	
	/**
	 * 有无医生
	 * @param Fg_doctor
	 */
	public void setFg_doctor(FBoolean Fg_doctor) {
		setAttrVal("Fg_doctor", Fg_doctor);
	}
	/**
	 * VIP类型
	 * @return Integer
	 */
	public Integer getViptype() {
		return ((Integer) getAttrVal("Viptype"));
	}	
	/**
	 * VIP类型
	 * @param Viptype
	 */
	public void setViptype(Integer Viptype) {
		setAttrVal("Viptype", Viptype);
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
	 * 控制台显示标识
	 * @return FBoolean
	 */
	public FBoolean getFg_show() {
		return ((FBoolean) getAttrVal("Fg_show"));
	}	
	/**
	 * 控制台显示标识
	 * @param Fg_show
	 */
	public void setFg_show(FBoolean Fg_show) {
		setAttrVal("Fg_show", Fg_show);
	}
	/**
	 * 工作站类型
	 * @return Integer
	 */
	public Integer getWstp() {
		return ((Integer) getAttrVal("Wstp"));
	}	
	/**
	 * 工作站类型
	 * @param Wstp
	 */
	public void setWstp(Integer Wstp) {
		setAttrVal("Wstp", Wstp);
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
	 * 体检科室编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	/**
	 * 体检科室编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 体检科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 体检科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 功能区名称
	 * @return String
	 */
	public String getName_funcarea() {
		return ((String) getAttrVal("Name_funcarea"));
	}	
	/**
	 * 功能区名称
	 * @param Name_funcarea
	 */
	public void setName_funcarea(String Name_funcarea) {
		setAttrVal("Name_funcarea", Name_funcarea);
	}
	/**
	 * 功能区编码
	 * @return String
	 */
	public String getCode_funcarea() {
		return ((String) getAttrVal("Code_funcarea"));
	}	
	/**
	 * 功能区编码
	 * @param Code_funcarea
	 */
	public void setCode_funcarea(String Code_funcarea) {
		setAttrVal("Code_funcarea", Code_funcarea);
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
		return "Id_pediroom";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_bd_diroom";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeDiDiRoomDODesc.class);
	}
	
}