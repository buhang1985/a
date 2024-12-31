package iih.cssd.dpbd.pkg.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.cssd.dpbd.pkg.d.desc.CssdPkgDODesc;
import java.math.BigDecimal;

/**
 * 消毒包定义 DO数据 
 * 
 */
public class CssdPkgDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//消毒包主键
	public static final String ID_PKG= "Id_pkg";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//包类型主键
	public static final String ID_PKGTP= "Id_pkgtp";
	//包类型编码
	public static final String SD_PKGTP= "Sd_pkgtp";
	//清洗类型主键
	public static final String ID_PKGCLEAN= "Id_pkgclean";
	//清洗类型编码
	public static final String SD_PKGCLEAN= "Sd_pkgclean";
	//灭菌方式主键
	public static final String ID_PKGSTZ= "Id_pkgstz";
	//灭菌方式编码
	public static final String SD_PKGSTZ= "Sd_pkgstz";
	//包装材料主键
	public static final String ID_PKGMTR= "Id_pkgmtr";
	//包装材料编码
	public static final String SD_PKGMTR= "Sd_pkgmtr";
	//包定义分类
	public static final String ID_PKG_CA= "Id_pkg_ca";
	//价格
	public static final String PRICE= "Price";
	//包重量
	public static final String EU_WEIGHT= "Eu_weight";
	//包规格
	public static final String SPEC= "Spec";
	//有效天数
	public static final String DAYS_EFFEC= "Days_effec";
	//启用状态
	public static final String FG_ACTIVE= "Fg_active";
	//包描述
	public static final String NOTE= "Note";
	//五笔码
	public static final String WBCODE= "Wbcode";
	//拼音吗
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//名称
	public static final String NAME_PKGTP= "Name_pkgtp";
	//名称
	public static final String NAME_PKGCLEAN= "Name_pkgclean";
	//名称
	public static final String NAME_PKGSTZ= "Name_pkgstz";
	//名称
	public static final String NAME_PKGMTR= "Name_pkgmtr";
	//名称
	public static final String NAME_PKG_CA= "Name_pkg_ca";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 消毒包主键
	 * @return String
	 */
	public String getId_pkg() {
		return ((String) getAttrVal("Id_pkg"));
	}	
	/**
	 * 消毒包主键
	 * @param Id_pkg
	 */
	public void setId_pkg(String Id_pkg) {
		setAttrVal("Id_pkg", Id_pkg);
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
	 * 包类型主键
	 * @return String
	 */
	public String getId_pkgtp() {
		return ((String) getAttrVal("Id_pkgtp"));
	}	
	/**
	 * 包类型主键
	 * @param Id_pkgtp
	 */
	public void setId_pkgtp(String Id_pkgtp) {
		setAttrVal("Id_pkgtp", Id_pkgtp);
	}
	/**
	 * 包类型编码
	 * @return String
	 */
	public String getSd_pkgtp() {
		return ((String) getAttrVal("Sd_pkgtp"));
	}	
	/**
	 * 包类型编码
	 * @param Sd_pkgtp
	 */
	public void setSd_pkgtp(String Sd_pkgtp) {
		setAttrVal("Sd_pkgtp", Sd_pkgtp);
	}
	/**
	 * 清洗类型主键
	 * @return String
	 */
	public String getId_pkgclean() {
		return ((String) getAttrVal("Id_pkgclean"));
	}	
	/**
	 * 清洗类型主键
	 * @param Id_pkgclean
	 */
	public void setId_pkgclean(String Id_pkgclean) {
		setAttrVal("Id_pkgclean", Id_pkgclean);
	}
	/**
	 * 清洗类型编码
	 * @return String
	 */
	public String getSd_pkgclean() {
		return ((String) getAttrVal("Sd_pkgclean"));
	}	
	/**
	 * 清洗类型编码
	 * @param Sd_pkgclean
	 */
	public void setSd_pkgclean(String Sd_pkgclean) {
		setAttrVal("Sd_pkgclean", Sd_pkgclean);
	}
	/**
	 * 灭菌方式主键
	 * @return String
	 */
	public String getId_pkgstz() {
		return ((String) getAttrVal("Id_pkgstz"));
	}	
	/**
	 * 灭菌方式主键
	 * @param Id_pkgstz
	 */
	public void setId_pkgstz(String Id_pkgstz) {
		setAttrVal("Id_pkgstz", Id_pkgstz);
	}
	/**
	 * 灭菌方式编码
	 * @return String
	 */
	public String getSd_pkgstz() {
		return ((String) getAttrVal("Sd_pkgstz"));
	}	
	/**
	 * 灭菌方式编码
	 * @param Sd_pkgstz
	 */
	public void setSd_pkgstz(String Sd_pkgstz) {
		setAttrVal("Sd_pkgstz", Sd_pkgstz);
	}
	/**
	 * 包装材料主键
	 * @return String
	 */
	public String getId_pkgmtr() {
		return ((String) getAttrVal("Id_pkgmtr"));
	}	
	/**
	 * 包装材料主键
	 * @param Id_pkgmtr
	 */
	public void setId_pkgmtr(String Id_pkgmtr) {
		setAttrVal("Id_pkgmtr", Id_pkgmtr);
	}
	/**
	 * 包装材料编码
	 * @return String
	 */
	public String getSd_pkgmtr() {
		return ((String) getAttrVal("Sd_pkgmtr"));
	}	
	/**
	 * 包装材料编码
	 * @param Sd_pkgmtr
	 */
	public void setSd_pkgmtr(String Sd_pkgmtr) {
		setAttrVal("Sd_pkgmtr", Sd_pkgmtr);
	}
	/**
	 * 包定义分类
	 * @return String
	 */
	public String getId_pkg_ca() {
		return ((String) getAttrVal("Id_pkg_ca"));
	}	
	/**
	 * 包定义分类
	 * @param Id_pkg_ca
	 */
	public void setId_pkg_ca(String Id_pkg_ca) {
		setAttrVal("Id_pkg_ca", Id_pkg_ca);
	}
	/**
	 * 价格
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}	
	/**
	 * 价格
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 包重量
	 * @return Integer
	 */
	public Integer getEu_weight() {
		return ((Integer) getAttrVal("Eu_weight"));
	}	
	/**
	 * 包重量
	 * @param Eu_weight
	 */
	public void setEu_weight(Integer Eu_weight) {
		setAttrVal("Eu_weight", Eu_weight);
	}
	/**
	 * 包规格
	 * @return String
	 */
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}	
	/**
	 * 包规格
	 * @param Spec
	 */
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}
	/**
	 * 有效天数
	 * @return Integer
	 */
	public Integer getDays_effec() {
		return ((Integer) getAttrVal("Days_effec"));
	}	
	/**
	 * 有效天数
	 * @param Days_effec
	 */
	public void setDays_effec(Integer Days_effec) {
		setAttrVal("Days_effec", Days_effec);
	}
	/**
	 * 启用状态
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用状态
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 包描述
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 包描述
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 五笔码
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔码
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 拼音吗
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音吗
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	/**
	 * 助记码
	 * @param Mnecode
	 */
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
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
	public String getName_pkgtp() {
		return ((String) getAttrVal("Name_pkgtp"));
	}	
	/**
	 * 名称
	 * @param Name_pkgtp
	 */
	public void setName_pkgtp(String Name_pkgtp) {
		setAttrVal("Name_pkgtp", Name_pkgtp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_pkgclean() {
		return ((String) getAttrVal("Name_pkgclean"));
	}	
	/**
	 * 名称
	 * @param Name_pkgclean
	 */
	public void setName_pkgclean(String Name_pkgclean) {
		setAttrVal("Name_pkgclean", Name_pkgclean);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_pkgstz() {
		return ((String) getAttrVal("Name_pkgstz"));
	}	
	/**
	 * 名称
	 * @param Name_pkgstz
	 */
	public void setName_pkgstz(String Name_pkgstz) {
		setAttrVal("Name_pkgstz", Name_pkgstz);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_pkgmtr() {
		return ((String) getAttrVal("Name_pkgmtr"));
	}	
	/**
	 * 名称
	 * @param Name_pkgmtr
	 */
	public void setName_pkgmtr(String Name_pkgmtr) {
		setAttrVal("Name_pkgmtr", Name_pkgmtr);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_pkg_ca() {
		return ((String) getAttrVal("Name_pkg_ca"));
	}	
	/**
	 * 名称
	 * @param Name_pkg_ca
	 */
	public void setName_pkg_ca(String Name_pkg_ca) {
		setAttrVal("Name_pkg_ca", Name_pkg_ca);
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
		return "Id_pkg";
	}
	
	@Override
	public String getTableName() {	  
		return "CSSD_PKG";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CssdPkgDODesc.class);
	}
	
}