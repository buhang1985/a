package iih.nm.nit.nmnitgrpplpsn.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nit.nmnitgrpplpsn.d.desc.NmNitGrpPlPsnDODesc;
import java.math.BigDecimal;

/**
 * 护理管理_实习小组计划_人员 DO数据 
 * 
 */
public class NmNitGrpPlPsnDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//计划参与人员主键
	public static final String ID_NIT_GRPPL_PSN= "Id_nit_grppl_psn";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//实习小组计划外键
	public static final String ID_NIT_GRPPL= "Id_nit_grppl";
	//实习人员外键
	public static final String ID_NIT_PSNINFO= "Id_nit_psninfo";
	//是否开启
	public static final String FG_ACTIVE= "Fg_active";
	//组长标识
	public static final String FG_HEADER= "Fg_header";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//名称
	public static final String NAME_GRP= "Name_grp";
	//姓名
	public static final String NAME_PSNINFO= "Name_psninfo";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 计划参与人员主键
	 * @return String
	 */
	public String getId_nit_grppl_psn() {
		return ((String) getAttrVal("Id_nit_grppl_psn"));
	}	
	/**
	 * 计划参与人员主键
	 * @param Id_nit_grppl_psn
	 */
	public void setId_nit_grppl_psn(String Id_nit_grppl_psn) {
		setAttrVal("Id_nit_grppl_psn", Id_nit_grppl_psn);
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
	 * 实习小组计划外键
	 * @return String
	 */
	public String getId_nit_grppl() {
		return ((String) getAttrVal("Id_nit_grppl"));
	}	
	/**
	 * 实习小组计划外键
	 * @param Id_nit_grppl
	 */
	public void setId_nit_grppl(String Id_nit_grppl) {
		setAttrVal("Id_nit_grppl", Id_nit_grppl);
	}
	/**
	 * 实习人员外键
	 * @return String
	 */
	public String getId_nit_psninfo() {
		return ((String) getAttrVal("Id_nit_psninfo"));
	}	
	/**
	 * 实习人员外键
	 * @param Id_nit_psninfo
	 */
	public void setId_nit_psninfo(String Id_nit_psninfo) {
		setAttrVal("Id_nit_psninfo", Id_nit_psninfo);
	}
	/**
	 * 是否开启
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 是否开启
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 组长标识
	 * @return FBoolean
	 */
	public FBoolean getFg_header() {
		return ((FBoolean) getAttrVal("Fg_header"));
	}	
	/**
	 * 组长标识
	 * @param Fg_header
	 */
	public void setFg_header(FBoolean Fg_header) {
		setAttrVal("Fg_header", Fg_header);
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
	 * 姓名
	 * @return String
	 */
	public String getName_psninfo() {
		return ((String) getAttrVal("Name_psninfo"));
	}	
	/**
	 * 姓名
	 * @param Name_psninfo
	 */
	public void setName_psninfo(String Name_psninfo) {
		setAttrVal("Name_psninfo", Name_psninfo);
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
		return "Id_nit_grppl_psn";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NIT_GRPPL_PSN";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNitGrpPlPsnDODesc.class);
	}
	
}