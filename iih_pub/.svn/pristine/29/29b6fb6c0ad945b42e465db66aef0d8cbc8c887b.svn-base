package iih.sc.sch.sclock.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.sch.sclock.d.desc.ScSchLockDODesc;
import java.math.BigDecimal;

/**
 * 号位锁定表 DO数据 
 * 
 */
public class ScSchLockDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//锁号表主键
	public static final String ID_SCLOCK= "Id_sclock";
	//会话id
	public static final String ID_SESSION= "Id_session";
	//患者id
	public static final String ID_PAT= "Id_pat";
	//使用锁就诊id
	public static final String ID_ENT= "Id_ent";
	//排班id
	public static final String ID_SCH= "Id_sch";
	//服务id
	public static final String ID_SRV= "Id_srv";
	//使用锁医嘱id
	public static final String ID_OR= "Id_or";
	//渠道id
	public static final String ID_CHL= "Id_chl";
	//号位id
	public static final String ID_TICK= "Id_tick";
	//锁开始时间
	public static final String DT_B_LOCK= "Dt_b_lock";
	//锁结束时间
	public static final String DT_E_LOCK= "Dt_e_lock";
	//锁释放标志
	public static final String FG_UNLOCK= "Fg_unlock";
	//使用标志
	public static final String FG_USED= "Fg_used";
	//操作人
	public static final String ID_EMP= "Id_emp";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 锁号表主键
	 * @return String
	 */
	public String getId_sclock() {
		return ((String) getAttrVal("Id_sclock"));
	}	
	/**
	 * 锁号表主键
	 * @param Id_sclock
	 */
	public void setId_sclock(String Id_sclock) {
		setAttrVal("Id_sclock", Id_sclock);
	}
	/**
	 * 会话id
	 * @return String
	 */
	public String getId_session() {
		return ((String) getAttrVal("Id_session"));
	}	
	/**
	 * 会话id
	 * @param Id_session
	 */
	public void setId_session(String Id_session) {
		setAttrVal("Id_session", Id_session);
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
	 * 使用锁就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 使用锁就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 排班id
	 * @return String
	 */
	public String getId_sch() {
		return ((String) getAttrVal("Id_sch"));
	}	
	/**
	 * 排班id
	 * @param Id_sch
	 */
	public void setId_sch(String Id_sch) {
		setAttrVal("Id_sch", Id_sch);
	}
	/**
	 * 服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 使用锁医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 使用锁医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 渠道id
	 * @return String
	 */
	public String getId_chl() {
		return ((String) getAttrVal("Id_chl"));
	}	
	/**
	 * 渠道id
	 * @param Id_chl
	 */
	public void setId_chl(String Id_chl) {
		setAttrVal("Id_chl", Id_chl);
	}
	/**
	 * 号位id
	 * @return String
	 */
	public String getId_tick() {
		return ((String) getAttrVal("Id_tick"));
	}	
	/**
	 * 号位id
	 * @param Id_tick
	 */
	public void setId_tick(String Id_tick) {
		setAttrVal("Id_tick", Id_tick);
	}
	/**
	 * 锁开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_b_lock() {
		return ((FDateTime) getAttrVal("Dt_b_lock"));
	}	
	/**
	 * 锁开始时间
	 * @param Dt_b_lock
	 */
	public void setDt_b_lock(FDateTime Dt_b_lock) {
		setAttrVal("Dt_b_lock", Dt_b_lock);
	}
	/**
	 * 锁结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_e_lock() {
		return ((FDateTime) getAttrVal("Dt_e_lock"));
	}	
	/**
	 * 锁结束时间
	 * @param Dt_e_lock
	 */
	public void setDt_e_lock(FDateTime Dt_e_lock) {
		setAttrVal("Dt_e_lock", Dt_e_lock);
	}
	/**
	 * 锁释放标志
	 * @return FBoolean
	 */
	public FBoolean getFg_unlock() {
		return ((FBoolean) getAttrVal("Fg_unlock"));
	}	
	/**
	 * 锁释放标志
	 * @param Fg_unlock
	 */
	public void setFg_unlock(FBoolean Fg_unlock) {
		setAttrVal("Fg_unlock", Fg_unlock);
	}
	/**
	 * 使用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_used() {
		return ((FBoolean) getAttrVal("Fg_used"));
	}	
	/**
	 * 使用标志
	 * @param Fg_used
	 */
	public void setFg_used(FBoolean Fg_used) {
		setAttrVal("Fg_used", Fg_used);
	}
	/**
	 * 操作人
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	/**
	 * 操作人
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
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
		return "Id_sclock";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_sch_lock";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScSchLockDODesc.class);
	}
	
}