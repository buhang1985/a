package iih.mp.nr.quanbedmodifyrecord.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.nr.quanbedmodifyrecord.d.desc.QuanBedModifyRecordDODesc;
import java.math.BigDecimal;

/**
 * 修改床旁余量记录 DO数据 
 * 
 */
public class QuanBedModifyRecordDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//修改床旁余量记录主键
	public static final String ID_QUANBEDMODITYRECORD= "Id_quanbedmodityrecord";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//医嘱id
	public static final String ID_OR= "Id_or";
	//医嘱服务项目
	public static final String ID_ORSRV= "Id_orsrv";
	//修改人员姓名
	public static final String ID_PSN= "Id_psn";
	//修改时间
	public static final String DT_MODIFY= "Dt_modify";
	//修改前余量
	public static final String QUAN_BEFORE= "Quan_before";
	//修改后余量
	public static final String QUAN_AFTER= "Quan_after";
	//修改方式
	public static final String ENUM_QUAN= "Enum_quan";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//服务项目名称
	public static final String NAME_SRV= "Name_srv";
	//姓名
	public static final String NAME_QUAN= "Name_quan";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 修改床旁余量记录主键
	 * @return String
	 */
	public String getId_quanbedmodityrecord() {
		return ((String) getAttrVal("Id_quanbedmodityrecord"));
	}	
	/**
	 * 修改床旁余量记录主键
	 * @param Id_quanbedmodityrecord
	 */
	public void setId_quanbedmodityrecord(String Id_quanbedmodityrecord) {
		setAttrVal("Id_quanbedmodityrecord", Id_quanbedmodityrecord);
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
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医嘱服务项目
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}	
	/**
	 * 医嘱服务项目
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 修改人员姓名
	 * @return String
	 */
	public String getId_psn() {
		return ((String) getAttrVal("Id_psn"));
	}	
	/**
	 * 修改人员姓名
	 * @param Id_psn
	 */
	public void setId_psn(String Id_psn) {
		setAttrVal("Id_psn", Id_psn);
	}
	/**
	 * 修改时间
	 * @return FDateTime
	 */
	public FDateTime getDt_modify() {
		return ((FDateTime) getAttrVal("Dt_modify"));
	}	
	/**
	 * 修改时间
	 * @param Dt_modify
	 */
	public void setDt_modify(FDateTime Dt_modify) {
		setAttrVal("Dt_modify", Dt_modify);
	}
	/**
	 * 修改前余量
	 * @return FDouble
	 */
	public FDouble getQuan_before() {
		return ((FDouble) getAttrVal("Quan_before"));
	}	
	/**
	 * 修改前余量
	 * @param Quan_before
	 */
	public void setQuan_before(FDouble Quan_before) {
		setAttrVal("Quan_before", Quan_before);
	}
	/**
	 * 修改后余量
	 * @return FDouble
	 */
	public FDouble getQuan_after() {
		return ((FDouble) getAttrVal("Quan_after"));
	}	
	/**
	 * 修改后余量
	 * @param Quan_after
	 */
	public void setQuan_after(FDouble Quan_after) {
		setAttrVal("Quan_after", Quan_after);
	}
	/**
	 * 修改方式
	 * @return Integer
	 */
	public Integer getEnum_quan() {
		return ((Integer) getAttrVal("Enum_quan"));
	}	
	/**
	 * 修改方式
	 * @param Enum_quan
	 */
	public void setEnum_quan(Integer Enum_quan) {
		setAttrVal("Enum_quan", Enum_quan);
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
	 * 服务项目名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	/**
	 * 服务项目名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_quan() {
		return ((String) getAttrVal("Name_quan"));
	}	
	/**
	 * 姓名
	 * @param Name_quan
	 */
	public void setName_quan(String Name_quan) {
		setAttrVal("Name_quan", Name_quan);
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
		return "Id_quanbedmodityrecord";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_quan_rcd";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(QuanBedModifyRecordDODesc.class);
	}
	
}