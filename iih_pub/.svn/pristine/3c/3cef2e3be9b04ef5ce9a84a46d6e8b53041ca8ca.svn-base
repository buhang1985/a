package iih.bd.mm.meterial.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.mm.meterial.d.desc.MMPackageUnitDODesc;
import java.math.BigDecimal;

/**
 * 医疗物品_包装单位集 DO数据 
 * 
 */
public class MMPackageUnitDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医疗物品包装单位主键
	public static final String ID_MMPKGU= "Id_mmpkgu";
	//物品
	public static final String ID_MM= "Id_mm";
	//包装单位类型
	public static final String ID_MMPKGUTP= "Id_mmpkgutp";
	//包装单位
	public static final String ID_UNIT_PKG= "Id_unit_pkg";
	//换算系数
	public static final String FACTOR= "Factor";
	//包装单位性质编码
	public static final String SD_MMPKGUPRO= "Sd_mmpkgupro";
	//包装单位性质
	public static final String ID_MMPKGUPRO= "Id_mmpkgupro";
	//包装单位名称
	public static final String MMPKGUNAME= "Mmpkguname";
	//预住院发药包装单位
	public static final String EN_PIPPKGTP= "En_pippkgtp";
	//住院发药包装单位
	public static final String EN_IPPKGTP= "En_ippkgtp";
	//门诊发药包装单位
	public static final String EN_OPPKGTP= "En_oppkgtp";
	//急诊流水发药包装单位
	public static final String EN_ERPKGTP= "En_erpkgtp";
	//急诊抢救发药包装单位
	public static final String EN_ER1PKGTP= "En_er1pkgtp";
	//急诊留观发药包装单位
	public static final String EN_ER2PKGTP= "En_er2pkgtp";
	//体检发药包装单位
	public static final String EN_PEPKGTP= "En_pepkgtp";
	//家庭发药包装单位
	public static final String EN_FMPKGTP= "En_fmpkgtp";
	//物品名称
	public static final String M_NAME= "M_name";
	//包装单位类型名称
	public static final String MMPKGUTP_NAME= "Mmpkgutp_name";
	//住院发药包装单位
	public static final String EN_IPPKGTP_REF= "En_ippkgtp_ref";
	//门诊发药包装单位
	public static final String EN_OPPKGTP_REF= "En_oppkgtp_ref";
	//急诊发药包装单位
	public static final String EN_ERPKGTP_REF= "En_erpkgtp_ref";
	//体检发药包装单位
	public static final String EN_PEPKGTP_REF= "En_pepkgtp_ref";
	//家庭发药包装单位
	public static final String EN_FMPKGTP_REF= "En_fmpkgtp_ref";
	//包装单位名称
	public static final String UNIT_PKG_NAME= "Unit_pkg_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医疗物品包装单位主键
	 * @return String
	 */
	public String getId_mmpkgu() {
		return ((String) getAttrVal("Id_mmpkgu"));
	}	
	/**
	 * 医疗物品包装单位主键
	 * @param Id_mmpkgu
	 */
	public void setId_mmpkgu(String Id_mmpkgu) {
		setAttrVal("Id_mmpkgu", Id_mmpkgu);
	}
	/**
	 * 物品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 物品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 包装单位类型
	 * @return String
	 */
	public String getId_mmpkgutp() {
		return ((String) getAttrVal("Id_mmpkgutp"));
	}	
	/**
	 * 包装单位类型
	 * @param Id_mmpkgutp
	 */
	public void setId_mmpkgutp(String Id_mmpkgutp) {
		setAttrVal("Id_mmpkgutp", Id_mmpkgutp);
	}
	/**
	 * 包装单位
	 * @return String
	 */
	public String getId_unit_pkg() {
		return ((String) getAttrVal("Id_unit_pkg"));
	}	
	/**
	 * 包装单位
	 * @param Id_unit_pkg
	 */
	public void setId_unit_pkg(String Id_unit_pkg) {
		setAttrVal("Id_unit_pkg", Id_unit_pkg);
	}
	/**
	 * 换算系数
	 * @return FDouble
	 */
	public FDouble getFactor() {
		return ((FDouble) getAttrVal("Factor"));
	}	
	/**
	 * 换算系数
	 * @param Factor
	 */
	public void setFactor(FDouble Factor) {
		setAttrVal("Factor", Factor);
	}
	/**
	 * 包装单位性质编码
	 * @return String
	 */
	public String getSd_mmpkgupro() {
		return ((String) getAttrVal("Sd_mmpkgupro"));
	}	
	/**
	 * 包装单位性质编码
	 * @param Sd_mmpkgupro
	 */
	public void setSd_mmpkgupro(String Sd_mmpkgupro) {
		setAttrVal("Sd_mmpkgupro", Sd_mmpkgupro);
	}
	/**
	 * 包装单位性质
	 * @return String
	 */
	public String getId_mmpkgupro() {
		return ((String) getAttrVal("Id_mmpkgupro"));
	}	
	/**
	 * 包装单位性质
	 * @param Id_mmpkgupro
	 */
	public void setId_mmpkgupro(String Id_mmpkgupro) {
		setAttrVal("Id_mmpkgupro", Id_mmpkgupro);
	}
	/**
	 * 包装单位名称
	 * @return String
	 */
	public String getMmpkguname() {
		return ((String) getAttrVal("Mmpkguname"));
	}	
	/**
	 * 包装单位名称
	 * @param Mmpkguname
	 */
	public void setMmpkguname(String Mmpkguname) {
		setAttrVal("Mmpkguname", Mmpkguname);
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
	 * 物品名称
	 * @return String
	 */
	public String getM_name() {
		return ((String) getAttrVal("M_name"));
	}	
	/**
	 * 物品名称
	 * @param M_name
	 */
	public void setM_name(String M_name) {
		setAttrVal("M_name", M_name);
	}
	/**
	 * 包装单位类型名称
	 * @return String
	 */
	public String getMmpkgutp_name() {
		return ((String) getAttrVal("Mmpkgutp_name"));
	}	
	/**
	 * 包装单位类型名称
	 * @param Mmpkgutp_name
	 */
	public void setMmpkgutp_name(String Mmpkgutp_name) {
		setAttrVal("Mmpkgutp_name", Mmpkgutp_name);
	}
	/**
	 * 住院发药包装单位
	 * @return Integer
	 */
	public Integer getEn_ippkgtp_ref() {
		return ((Integer) getAttrVal("En_ippkgtp_ref"));
	}	
	/**
	 * 住院发药包装单位
	 * @param En_ippkgtp_ref
	 */
	public void setEn_ippkgtp_ref(Integer En_ippkgtp_ref) {
		setAttrVal("En_ippkgtp_ref", En_ippkgtp_ref);
	}
	/**
	 * 门诊发药包装单位
	 * @return Integer
	 */
	public Integer getEn_oppkgtp_ref() {
		return ((Integer) getAttrVal("En_oppkgtp_ref"));
	}	
	/**
	 * 门诊发药包装单位
	 * @param En_oppkgtp_ref
	 */
	public void setEn_oppkgtp_ref(Integer En_oppkgtp_ref) {
		setAttrVal("En_oppkgtp_ref", En_oppkgtp_ref);
	}
	/**
	 * 急诊发药包装单位
	 * @return Integer
	 */
	public Integer getEn_erpkgtp_ref() {
		return ((Integer) getAttrVal("En_erpkgtp_ref"));
	}	
	/**
	 * 急诊发药包装单位
	 * @param En_erpkgtp_ref
	 */
	public void setEn_erpkgtp_ref(Integer En_erpkgtp_ref) {
		setAttrVal("En_erpkgtp_ref", En_erpkgtp_ref);
	}
	/**
	 * 体检发药包装单位
	 * @return Integer
	 */
	public Integer getEn_pepkgtp_ref() {
		return ((Integer) getAttrVal("En_pepkgtp_ref"));
	}	
	/**
	 * 体检发药包装单位
	 * @param En_pepkgtp_ref
	 */
	public void setEn_pepkgtp_ref(Integer En_pepkgtp_ref) {
		setAttrVal("En_pepkgtp_ref", En_pepkgtp_ref);
	}
	/**
	 * 家庭发药包装单位
	 * @return Integer
	 */
	public Integer getEn_fmpkgtp_ref() {
		return ((Integer) getAttrVal("En_fmpkgtp_ref"));
	}	
	/**
	 * 家庭发药包装单位
	 * @param En_fmpkgtp_ref
	 */
	public void setEn_fmpkgtp_ref(Integer En_fmpkgtp_ref) {
		setAttrVal("En_fmpkgtp_ref", En_fmpkgtp_ref);
	}
	/**
	 * 包装单位名称
	 * @return String
	 */
	public String getUnit_pkg_name() {
		return ((String) getAttrVal("Unit_pkg_name"));
	}	
	/**
	 * 包装单位名称
	 * @param Unit_pkg_name
	 */
	public void setUnit_pkg_name(String Unit_pkg_name) {
		setAttrVal("Unit_pkg_name", Unit_pkg_name);
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
		return "Id_mmpkgu";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_MM_PKGU";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MMPackageUnitDODesc.class);
	}
	
}