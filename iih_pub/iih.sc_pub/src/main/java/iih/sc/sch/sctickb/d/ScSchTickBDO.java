package iih.sc.sch.sctickb.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.sch.sctickb.d.desc.ScSchTickBDODesc;
import java.math.BigDecimal;

/**
 * 计划排班_号位B DO数据 
 * 
 */
public class ScSchTickBDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//号位ID
	public static final String ID_TICK= "Id_tick";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//排班
	public static final String ID_SCH= "Id_sch";
	//号段id
	public static final String ID_TICKS= "Id_ticks";
	//号位编码
	public static final String CODE= "Code";
	//号位名称
	public static final String NAME= "Name";
	//票号
	public static final String QUENO= "Queno";
	//预计开始时间
	public static final String T_B= "T_b";
	//预计结束时间
	public static final String T_E= "T_e";
	//已使用标志
	public static final String EU_USED= "Eu_used";
	//可使用范围
	public static final String EU_USESCOPE= "Eu_usescope";
	//启用标志
	public static final String FG_ACTIVE= "Fg_active";
	//加号类型
	public static final String EU_ADD= "Eu_add";
	//排班服务
	public static final String ID_SCSRV= "Id_scsrv";
	//使用号源池号
	public static final String POLNO_USED= "Polno_used";
	//占用者
	public static final String ID_TICK_OCCUPIER= "Id_tick_occupier";
	//客开扩展字段1
	public static final String PRJFLD1= "Prjfld1";
	//客开扩展字段2
	public static final String PRJFLD2= "Prjfld2";
	//客开扩展字段3
	public static final String PRJFLD3= "Prjfld3";
	//客开扩展字段4
	public static final String PRJFLD4= "Prjfld4";
	//客开扩展字段5
	public static final String PRJFLD5= "Prjfld5";
	//客开扩展字段6
	public static final String PRJFLD6= "Prjfld6";
	//加号标识
	public static final String FG_ADD= "Fg_add";
	//保留原因类型id
	public static final String ID_RESERVE_RSN= "Id_reserve_rsn";
	//保留原因类型编码
	public static final String SD_RESERVE_RSN= "Sd_reserve_rsn";
	//保留说明
	public static final String NOTE_RESERVE= "Note_reserve";
	//使用渠道
	public static final String IDS_SCCHL= "Ids_scchl";
	//使用号源池
	public static final String POLNO= "Polno";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//可使用类别细目
	public static final String IDS_KINDITM= "Ids_kinditm";
	//排班服务名称
	public static final String NAME_SRV= "Name_srv";
	//预约渠道编码
	public static final String CODE_SCCHL= "Code_scchl";
	//预约渠道名称
	public static final String NAME_SCCHL= "Name_scchl";
	//编码
	public static final String CODE_KINDITM= "Code_kinditm";
	//名称
	public static final String NAME_KINDITM= "Name_kinditm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 号位ID
	 * @return String
	 */
	public String getId_tick() {
		return ((String) getAttrVal("Id_tick"));
	}	
	/**
	 * 号位ID
	 * @param Id_tick
	 */
	public void setId_tick(String Id_tick) {
		setAttrVal("Id_tick", Id_tick);
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
	 * 排班
	 * @return String
	 */
	public String getId_sch() {
		return ((String) getAttrVal("Id_sch"));
	}	
	/**
	 * 排班
	 * @param Id_sch
	 */
	public void setId_sch(String Id_sch) {
		setAttrVal("Id_sch", Id_sch);
	}
	/**
	 * 号段id
	 * @return String
	 */
	public String getId_ticks() {
		return ((String) getAttrVal("Id_ticks"));
	}	
	/**
	 * 号段id
	 * @param Id_ticks
	 */
	public void setId_ticks(String Id_ticks) {
		setAttrVal("Id_ticks", Id_ticks);
	}
	/**
	 * 号位编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 号位编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 号位名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 号位名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 票号
	 * @return Integer
	 */
	public Integer getQueno() {
		return ((Integer) getAttrVal("Queno"));
	}	
	/**
	 * 票号
	 * @param Queno
	 */
	public void setQueno(Integer Queno) {
		setAttrVal("Queno", Queno);
	}
	/**
	 * 预计开始时间
	 * @return FTime
	 */
	public FTime getT_b() {
		return ((FTime) getAttrVal("T_b"));
	}	
	/**
	 * 预计开始时间
	 * @param T_b
	 */
	public void setT_b(FTime T_b) {
		setAttrVal("T_b", T_b);
	}
	/**
	 * 预计结束时间
	 * @return FTime
	 */
	public FTime getT_e() {
		return ((FTime) getAttrVal("T_e"));
	}	
	/**
	 * 预计结束时间
	 * @param T_e
	 */
	public void setT_e(FTime T_e) {
		setAttrVal("T_e", T_e);
	}
	/**
	 * 已使用标志
	 * @return Integer
	 */
	public Integer getEu_used() {
		return ((Integer) getAttrVal("Eu_used"));
	}	
	/**
	 * 已使用标志
	 * @param Eu_used
	 */
	public void setEu_used(Integer Eu_used) {
		setAttrVal("Eu_used", Eu_used);
	}
	/**
	 * 可使用范围
	 * @return Integer
	 */
	public Integer getEu_usescope() {
		return ((Integer) getAttrVal("Eu_usescope"));
	}	
	/**
	 * 可使用范围
	 * @param Eu_usescope
	 */
	public void setEu_usescope(Integer Eu_usescope) {
		setAttrVal("Eu_usescope", Eu_usescope);
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
	 * 加号类型
	 * @return Integer
	 */
	public Integer getEu_add() {
		return ((Integer) getAttrVal("Eu_add"));
	}	
	/**
	 * 加号类型
	 * @param Eu_add
	 */
	public void setEu_add(Integer Eu_add) {
		setAttrVal("Eu_add", Eu_add);
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
	 * 使用号源池号
	 * @return Integer
	 */
	public Integer getPolno_used() {
		return ((Integer) getAttrVal("Polno_used"));
	}	
	/**
	 * 使用号源池号
	 * @param Polno_used
	 */
	public void setPolno_used(Integer Polno_used) {
		setAttrVal("Polno_used", Polno_used);
	}
	/**
	 * 占用者
	 * @return String
	 */
	public String getId_tick_occupier() {
		return ((String) getAttrVal("Id_tick_occupier"));
	}	
	/**
	 * 占用者
	 * @param Id_tick_occupier
	 */
	public void setId_tick_occupier(String Id_tick_occupier) {
		setAttrVal("Id_tick_occupier", Id_tick_occupier);
	}
	/**
	 * 客开扩展字段1
	 * @return String
	 */
	public String getPrjfld1() {
		return ((String) getAttrVal("Prjfld1"));
	}	
	/**
	 * 客开扩展字段1
	 * @param Prjfld1
	 */
	public void setPrjfld1(String Prjfld1) {
		setAttrVal("Prjfld1", Prjfld1);
	}
	/**
	 * 客开扩展字段2
	 * @return String
	 */
	public String getPrjfld2() {
		return ((String) getAttrVal("Prjfld2"));
	}	
	/**
	 * 客开扩展字段2
	 * @param Prjfld2
	 */
	public void setPrjfld2(String Prjfld2) {
		setAttrVal("Prjfld2", Prjfld2);
	}
	/**
	 * 客开扩展字段3
	 * @return String
	 */
	public String getPrjfld3() {
		return ((String) getAttrVal("Prjfld3"));
	}	
	/**
	 * 客开扩展字段3
	 * @param Prjfld3
	 */
	public void setPrjfld3(String Prjfld3) {
		setAttrVal("Prjfld3", Prjfld3);
	}
	/**
	 * 客开扩展字段4
	 * @return String
	 */
	public String getPrjfld4() {
		return ((String) getAttrVal("Prjfld4"));
	}	
	/**
	 * 客开扩展字段4
	 * @param Prjfld4
	 */
	public void setPrjfld4(String Prjfld4) {
		setAttrVal("Prjfld4", Prjfld4);
	}
	/**
	 * 客开扩展字段5
	 * @return String
	 */
	public String getPrjfld5() {
		return ((String) getAttrVal("Prjfld5"));
	}	
	/**
	 * 客开扩展字段5
	 * @param Prjfld5
	 */
	public void setPrjfld5(String Prjfld5) {
		setAttrVal("Prjfld5", Prjfld5);
	}
	/**
	 * 客开扩展字段6
	 * @return String
	 */
	public String getPrjfld6() {
		return ((String) getAttrVal("Prjfld6"));
	}	
	/**
	 * 客开扩展字段6
	 * @param Prjfld6
	 */
	public void setPrjfld6(String Prjfld6) {
		setAttrVal("Prjfld6", Prjfld6);
	}
	/**
	 * 加号标识
	 * @return FBoolean
	 */
	public FBoolean getFg_add() {
		return ((FBoolean) getAttrVal("Fg_add"));
	}	
	/**
	 * 加号标识
	 * @param Fg_add
	 */
	public void setFg_add(FBoolean Fg_add) {
		setAttrVal("Fg_add", Fg_add);
	}
	/**
	 * 保留原因类型id
	 * @return String
	 */
	public String getId_reserve_rsn() {
		return ((String) getAttrVal("Id_reserve_rsn"));
	}	
	/**
	 * 保留原因类型id
	 * @param Id_reserve_rsn
	 */
	public void setId_reserve_rsn(String Id_reserve_rsn) {
		setAttrVal("Id_reserve_rsn", Id_reserve_rsn);
	}
	/**
	 * 保留原因类型编码
	 * @return String
	 */
	public String getSd_reserve_rsn() {
		return ((String) getAttrVal("Sd_reserve_rsn"));
	}	
	/**
	 * 保留原因类型编码
	 * @param Sd_reserve_rsn
	 */
	public void setSd_reserve_rsn(String Sd_reserve_rsn) {
		setAttrVal("Sd_reserve_rsn", Sd_reserve_rsn);
	}
	/**
	 * 保留说明
	 * @return String
	 */
	public String getNote_reserve() {
		return ((String) getAttrVal("Note_reserve"));
	}	
	/**
	 * 保留说明
	 * @param Note_reserve
	 */
	public void setNote_reserve(String Note_reserve) {
		setAttrVal("Note_reserve", Note_reserve);
	}
	/**
	 * 使用渠道
	 * @return String
	 */
	public String getIds_scchl() {
		return ((String) getAttrVal("Ids_scchl"));
	}	
	/**
	 * 使用渠道
	 * @param Ids_scchl
	 */
	public void setIds_scchl(String Ids_scchl) {
		setAttrVal("Ids_scchl", Ids_scchl);
	}
	/**
	 * 使用号源池
	 * @return Integer
	 */
	public Integer getPolno() {
		return ((Integer) getAttrVal("Polno"));
	}	
	/**
	 * 使用号源池
	 * @param Polno
	 */
	public void setPolno(Integer Polno) {
		setAttrVal("Polno", Polno);
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
	 * 可使用类别细目
	 * @return String
	 */
	public String getIds_kinditm() {
		return ((String) getAttrVal("Ids_kinditm"));
	}	
	/**
	 * 可使用类别细目
	 * @param Ids_kinditm
	 */
	public void setIds_kinditm(String Ids_kinditm) {
		setAttrVal("Ids_kinditm", Ids_kinditm);
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
	 * 预约渠道编码
	 * @return String
	 */
	public String getCode_scchl() {
		return ((String) getAttrVal("Code_scchl"));
	}	
	/**
	 * 预约渠道编码
	 * @param Code_scchl
	 */
	public void setCode_scchl(String Code_scchl) {
		setAttrVal("Code_scchl", Code_scchl);
	}
	/**
	 * 预约渠道名称
	 * @return String
	 */
	public String getName_scchl() {
		return ((String) getAttrVal("Name_scchl"));
	}	
	/**
	 * 预约渠道名称
	 * @param Name_scchl
	 */
	public void setName_scchl(String Name_scchl) {
		setAttrVal("Name_scchl", Name_scchl);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_kinditm() {
		return ((String) getAttrVal("Code_kinditm"));
	}	
	/**
	 * 编码
	 * @param Code_kinditm
	 */
	public void setCode_kinditm(String Code_kinditm) {
		setAttrVal("Code_kinditm", Code_kinditm);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_kinditm() {
		return ((String) getAttrVal("Name_kinditm"));
	}	
	/**
	 * 名称
	 * @param Name_kinditm
	 */
	public void setName_kinditm(String Name_kinditm) {
		setAttrVal("Name_kinditm", Name_kinditm);
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
		return "Id_tick";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_tickb";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScSchTickBDODesc.class);
	}
	
}