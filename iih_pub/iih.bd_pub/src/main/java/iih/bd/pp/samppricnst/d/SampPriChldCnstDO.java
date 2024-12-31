package iih.bd.pp.samppricnst.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.samppricnst.d.desc.SampPriChldCnstDODesc;
import java.math.BigDecimal;

/**
 * 儿童标本费用对照 DO数据 
 * 
 */
public class SampPriChldCnstDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//儿童标本费用对照主键
	public static final String ID_CHLD_CNST= "Id_chld_cnst";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//基础服务
	public static final String ID_SRV_BASE= "Id_srv_base";
	//对照服务
	public static final String ID_SRV= "Id_srv";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//基础服务名称
	public static final String NAME_BASE= "Name_base";
	//对照服务名称
	public static final String NAME_SRV= "Name_srv";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 儿童标本费用对照主键
	 * @return String
	 */
	public String getId_chld_cnst() {
		return ((String) getAttrVal("Id_chld_cnst"));
	}	
	/**
	 * 儿童标本费用对照主键
	 * @param Id_chld_cnst
	 */
	public void setId_chld_cnst(String Id_chld_cnst) {
		setAttrVal("Id_chld_cnst", Id_chld_cnst);
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
	 * 基础服务
	 * @return String
	 */
	public String getId_srv_base() {
		return ((String) getAttrVal("Id_srv_base"));
	}	
	/**
	 * 基础服务
	 * @param Id_srv_base
	 */
	public void setId_srv_base(String Id_srv_base) {
		setAttrVal("Id_srv_base", Id_srv_base);
	}
	/**
	 * 对照服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 对照服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
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
	 * 基础服务名称
	 * @return String
	 */
	public String getName_base() {
		return ((String) getAttrVal("Name_base"));
	}	
	/**
	 * 基础服务名称
	 * @param Name_base
	 */
	public void setName_base(String Name_base) {
		setAttrVal("Name_base", Name_base);
	}
	/**
	 * 对照服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	/**
	 * 对照服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
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
		return "Id_chld_cnst";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_samp_pri_chldcnst";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SampPriChldCnstDODesc.class);
	}
	
}