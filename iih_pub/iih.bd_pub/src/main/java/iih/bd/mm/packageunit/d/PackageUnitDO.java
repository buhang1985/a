package iih.bd.mm.packageunit.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.mm.packageunit.d.desc.PackageUnitDODesc;
import java.math.BigDecimal;

/**
 * 医疗物品_包装单位类型 DO数据 
 * 
 */
public class PackageUnitDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//包装单位类型主键
	public static final String ID_MMPKGUTP= "Id_mmpkgutp";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//包装单位类型编码
	public static final String CODE= "Code";
	//包装单位类型名称
	public static final String NAME= "Name";
	//拼音码
	public static final String PYCODE= "Pycode";
	//五笔码
	public static final String WBCODE= "Wbcode";
	//输入符
	public static final String INSTR= "Instr";
	//预住院发药包装单位
	public static final String EN_PIPPKGTP= "En_pippkgtp";
	//住院发药包装单位
	public static final String EN_IPPKGTP= "En_ippkgtp";
	//门诊发药包装单位
	public static final String EN_OPPKGTP= "En_oppkgtp";
	//急诊流水发药包装单位
	public static final String EN_ERPKGTP= "En_erpkgtp";
	//体检发药包装单位
	public static final String EN_PEPKGTP= "En_pepkgtp";
	//家庭发药包装单位
	public static final String EN_FMPKGTP= "En_fmpkgtp";
	//启用标志
	public static final String FG_ACTIVE= "Fg_active";
	//系统标志
	public static final String FLAG_SYS= "Flag_sys";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//急诊抢救发药包装单位
	public static final String EN_ER1PKGTP= "En_er1pkgtp";
	//急诊留观发药包装单位
	public static final String EN_ER2PKGTP= "En_er2pkgtp";
	//机构
	public static final String ORG_NAME= "Org_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 包装单位类型主键
	 * @return String
	 */
	public String getId_mmpkgutp() {
		return ((String) getAttrVal("Id_mmpkgutp"));
	}	
	/**
	 * 包装单位类型主键
	 * @param Id_mmpkgutp
	 */
	public void setId_mmpkgutp(String Id_mmpkgutp) {
		setAttrVal("Id_mmpkgutp", Id_mmpkgutp);
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
	 * 包装单位类型编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 包装单位类型编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 包装单位类型名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 包装单位类型名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
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
	 * 输入符
	 * @return String
	 */
	public String getInstr() {
		return ((String) getAttrVal("Instr"));
	}	
	/**
	 * 输入符
	 * @param Instr
	 */
	public void setInstr(String Instr) {
		setAttrVal("Instr", Instr);
	}
	/**
	 * 预住院发药包装单位
	 * @return Integer
	 */
	public Integer getEn_pippkgtp() {
		return ((Integer) getAttrVal("En_pippkgtp"));
	}	
	/**
	 * 预住院发药包装单位
	 * @param En_pippkgtp
	 */
	public void setEn_pippkgtp(Integer En_pippkgtp) {
		setAttrVal("En_pippkgtp", En_pippkgtp);
	}
	/**
	 * 住院发药包装单位
	 * @return Integer
	 */
	public Integer getEn_ippkgtp() {
		return ((Integer) getAttrVal("En_ippkgtp"));
	}	
	/**
	 * 住院发药包装单位
	 * @param En_ippkgtp
	 */
	public void setEn_ippkgtp(Integer En_ippkgtp) {
		setAttrVal("En_ippkgtp", En_ippkgtp);
	}
	/**
	 * 门诊发药包装单位
	 * @return Integer
	 */
	public Integer getEn_oppkgtp() {
		return ((Integer) getAttrVal("En_oppkgtp"));
	}	
	/**
	 * 门诊发药包装单位
	 * @param En_oppkgtp
	 */
	public void setEn_oppkgtp(Integer En_oppkgtp) {
		setAttrVal("En_oppkgtp", En_oppkgtp);
	}
	/**
	 * 急诊流水发药包装单位
	 * @return Integer
	 */
	public Integer getEn_erpkgtp() {
		return ((Integer) getAttrVal("En_erpkgtp"));
	}	
	/**
	 * 急诊流水发药包装单位
	 * @param En_erpkgtp
	 */
	public void setEn_erpkgtp(Integer En_erpkgtp) {
		setAttrVal("En_erpkgtp", En_erpkgtp);
	}
	/**
	 * 体检发药包装单位
	 * @return Integer
	 */
	public Integer getEn_pepkgtp() {
		return ((Integer) getAttrVal("En_pepkgtp"));
	}	
	/**
	 * 体检发药包装单位
	 * @param En_pepkgtp
	 */
	public void setEn_pepkgtp(Integer En_pepkgtp) {
		setAttrVal("En_pepkgtp", En_pepkgtp);
	}
	/**
	 * 家庭发药包装单位
	 * @return Integer
	 */
	public Integer getEn_fmpkgtp() {
		return ((Integer) getAttrVal("En_fmpkgtp"));
	}	
	/**
	 * 家庭发药包装单位
	 * @param En_fmpkgtp
	 */
	public void setEn_fmpkgtp(Integer En_fmpkgtp) {
		setAttrVal("En_fmpkgtp", En_fmpkgtp);
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
	 * 系统标志
	 * @return FBoolean
	 */
	public FBoolean getFlag_sys() {
		return ((FBoolean) getAttrVal("Flag_sys"));
	}	
	/**
	 * 系统标志
	 * @param Flag_sys
	 */
	public void setFlag_sys(FBoolean Flag_sys) {
		setAttrVal("Flag_sys", Flag_sys);
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
	 * 急诊抢救发药包装单位
	 * @return Integer
	 */
	public Integer getEn_er1pkgtp() {
		return ((Integer) getAttrVal("En_er1pkgtp"));
	}	
	/**
	 * 急诊抢救发药包装单位
	 * @param En_er1pkgtp
	 */
	public void setEn_er1pkgtp(Integer En_er1pkgtp) {
		setAttrVal("En_er1pkgtp", En_er1pkgtp);
	}
	/**
	 * 急诊留观发药包装单位
	 * @return Integer
	 */
	public Integer getEn_er2pkgtp() {
		return ((Integer) getAttrVal("En_er2pkgtp"));
	}	
	/**
	 * 急诊留观发药包装单位
	 * @param En_er2pkgtp
	 */
	public void setEn_er2pkgtp(Integer En_er2pkgtp) {
		setAttrVal("En_er2pkgtp", En_er2pkgtp);
	}
	/**
	 * 机构
	 * @return String
	 */
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	/**
	 * 机构
	 * @param Org_name
	 */
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
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
		return "Id_mmpkgutp";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_MM_PKGUTP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PackageUnitDODesc.class);
	}
	
}