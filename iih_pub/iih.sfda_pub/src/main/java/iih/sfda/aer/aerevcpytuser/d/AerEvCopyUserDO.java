package iih.sfda.aer.aerevcpytuser.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sfda.aer.aerevcpytuser.d.desc.AerEvCopyUserDODesc;
import java.math.BigDecimal;

/**
 * 事件抄送人员 DO数据 
 * 
 */
public class AerEvCopyUserDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//抄送人员标识
	public static final String ID_AER_EV_COPYUSER= "Id_aer_ev_copyuser";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//事件标识
	public static final String ID_AER_EV= "Id_aer_ev";
	//人员标识
	public static final String ID_USER= "Id_user";
	//操作时间
	public static final String DT_OPER= "Dt_oper";
	//操作人
	public static final String ID_OPER_USER= "Id_oper_user";
	//备注
	public static final String DES= "Des";
	//扩展字段1
	public static final String CTRL1= "Ctrl1";
	//扩展字段2
	public static final String CTRL2= "Ctrl2";
	//扩展字段3
	public static final String CTRL3= "Ctrl3";
	//扩展字段4
	public static final String CTRL4= "Ctrl4";
	//扩展字段5
	public static final String CTRL5= "Ctrl5";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//名称
	public static final String NAME_GRP= "Name_grp";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//用户名称
	public static final String NAME_USER= "Name_user";
	//用户名称
	public static final String NAME_OPER_USER= "Name_oper_user";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 抄送人员标识
	 * @return String
	 */
	public String getId_aer_ev_copyuser() {
		return ((String) getAttrVal("Id_aer_ev_copyuser"));
	}	
	/**
	 * 抄送人员标识
	 * @param Id_aer_ev_copyuser
	 */
	public void setId_aer_ev_copyuser(String Id_aer_ev_copyuser) {
		setAttrVal("Id_aer_ev_copyuser", Id_aer_ev_copyuser);
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
	 * 事件标识
	 * @return String
	 */
	public String getId_aer_ev() {
		return ((String) getAttrVal("Id_aer_ev"));
	}	
	/**
	 * 事件标识
	 * @param Id_aer_ev
	 */
	public void setId_aer_ev(String Id_aer_ev) {
		setAttrVal("Id_aer_ev", Id_aer_ev);
	}
	/**
	 * 人员标识
	 * @return String
	 */
	public String getId_user() {
		return ((String) getAttrVal("Id_user"));
	}	
	/**
	 * 人员标识
	 * @param Id_user
	 */
	public void setId_user(String Id_user) {
		setAttrVal("Id_user", Id_user);
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
	 * 操作人
	 * @return String
	 */
	public String getId_oper_user() {
		return ((String) getAttrVal("Id_oper_user"));
	}	
	/**
	 * 操作人
	 * @param Id_oper_user
	 */
	public void setId_oper_user(String Id_oper_user) {
		setAttrVal("Id_oper_user", Id_oper_user);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 备注
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getCtrl1() {
		return ((String) getAttrVal("Ctrl1"));
	}	
	/**
	 * 扩展字段1
	 * @param Ctrl1
	 */
	public void setCtrl1(String Ctrl1) {
		setAttrVal("Ctrl1", Ctrl1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getCtrl2() {
		return ((String) getAttrVal("Ctrl2"));
	}	
	/**
	 * 扩展字段2
	 * @param Ctrl2
	 */
	public void setCtrl2(String Ctrl2) {
		setAttrVal("Ctrl2", Ctrl2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getCtrl3() {
		return ((String) getAttrVal("Ctrl3"));
	}	
	/**
	 * 扩展字段3
	 * @param Ctrl3
	 */
	public void setCtrl3(String Ctrl3) {
		setAttrVal("Ctrl3", Ctrl3);
	}
	/**
	 * 扩展字段4
	 * @return String
	 */
	public String getCtrl4() {
		return ((String) getAttrVal("Ctrl4"));
	}	
	/**
	 * 扩展字段4
	 * @param Ctrl4
	 */
	public void setCtrl4(String Ctrl4) {
		setAttrVal("Ctrl4", Ctrl4);
	}
	/**
	 * 扩展字段5
	 * @return String
	 */
	public String getCtrl5() {
		return ((String) getAttrVal("Ctrl5"));
	}	
	/**
	 * 扩展字段5
	 * @param Ctrl5
	 */
	public void setCtrl5(String Ctrl5) {
		setAttrVal("Ctrl5", Ctrl5);
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
	 * 名称
	 * @return String
	 */
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	/**
	 * 名称
	 * @param Name_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	/**
	 * 组织名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getName_user() {
		return ((String) getAttrVal("Name_user"));
	}	
	/**
	 * 用户名称
	 * @param Name_user
	 */
	public void setName_user(String Name_user) {
		setAttrVal("Name_user", Name_user);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getName_oper_user() {
		return ((String) getAttrVal("Name_oper_user"));
	}	
	/**
	 * 用户名称
	 * @param Name_oper_user
	 */
	public void setName_oper_user(String Name_oper_user) {
		setAttrVal("Name_oper_user", Name_oper_user);
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
		return "Id_aer_ev_copyuser";
	}
	
	@Override
	public String getTableName() {	  
		return "SFDA_AER_EV_COPYUSER";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AerEvCopyUserDODesc.class);
	}
	
}