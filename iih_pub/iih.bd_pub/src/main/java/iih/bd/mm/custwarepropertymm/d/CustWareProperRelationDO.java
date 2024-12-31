package iih.bd.mm.custwarepropertymm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.mm.custwarepropertymm.d.desc.CustWareProperRelationDODesc;
import java.math.BigDecimal;

/**
 * 仓库与医疗物品自定义分类关系 DO数据 
 * 
 */
public class CustWareProperRelationDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//仓库与自定义属性id
	public static final String ID_WHPROPERTY= "Id_whproperty";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//仓库
	public static final String ID_WH= "Id_wh";
	//序号
	public static final String SORTNO= "Sortno";
	//描述
	public static final String DES= "Des";
	//仓库与医疗物品自定义分类关系
	public static final String ID_MMCAUSITM= "Id_mmcausitm";
	//是否启用
	public static final String FG_ACTIVE= "Fg_active";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//仓库名称
	public static final String WH_NAME= "Wh_name";
	//项目编码
	public static final String CUST_CODE= "Cust_code";
	//项目名称
	public static final String CUST_NAME= "Cust_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 仓库与自定义属性id
	 * @return String
	 */
	public String getId_whproperty() {
		return ((String) getAttrVal("Id_whproperty"));
	}	
	/**
	 * 仓库与自定义属性id
	 * @param Id_whproperty
	 */
	public void setId_whproperty(String Id_whproperty) {
		setAttrVal("Id_whproperty", Id_whproperty);
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
	 * 仓库
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	/**
	 * 仓库
	 * @param Id_wh
	 */
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
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
	 * 描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 仓库与医疗物品自定义分类关系
	 * @return String
	 */
	public String getId_mmcausitm() {
		return ((String) getAttrVal("Id_mmcausitm"));
	}	
	/**
	 * 仓库与医疗物品自定义分类关系
	 * @param Id_mmcausitm
	 */
	public void setId_mmcausitm(String Id_mmcausitm) {
		setAttrVal("Id_mmcausitm", Id_mmcausitm);
	}
	/**
	 * 是否启用
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 是否启用
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
	 * 仓库名称
	 * @return String
	 */
	public String getWh_name() {
		return ((String) getAttrVal("Wh_name"));
	}	
	/**
	 * 仓库名称
	 * @param Wh_name
	 */
	public void setWh_name(String Wh_name) {
		setAttrVal("Wh_name", Wh_name);
	}
	/**
	 * 项目编码
	 * @return String
	 */
	public String getCust_code() {
		return ((String) getAttrVal("Cust_code"));
	}	
	/**
	 * 项目编码
	 * @param Cust_code
	 */
	public void setCust_code(String Cust_code) {
		setAttrVal("Cust_code", Cust_code);
	}
	/**
	 * 项目名称
	 * @return String
	 */
	public String getCust_name() {
		return ((String) getAttrVal("Cust_name"));
	}	
	/**
	 * 项目名称
	 * @param Cust_name
	 */
	public void setCust_name(String Cust_name) {
		setAttrVal("Cust_name", Cust_name);
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
		return "Id_whproperty";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_cust_mmca_wh";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CustWareProperRelationDODesc.class);
	}
	
}