package iih.nm.nhr.nhrsitenet.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.nhrsitenet.d.desc.NmNhrSiTenetDODesc;
import java.math.BigDecimal;

/**
 * 排班规则 DO数据 
 * 
 */
public class NmNhrSiTenetDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//排班原则主键
	public static final String ID_NHR_SI_TENET= "Id_nhr_si_tenet";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//原则摘要
	public static final String TENET_ABSTR= "Tenet_abstr";
	//原则内容
	public static final String TENET_CONTENT= "Tenet_content";
	//开始时间
	public static final String DT_BEGIN= "Dt_begin";
	//备注
	public static final String DES= "Des";
	//所属类型
	public static final String ID_OWNTP= "Id_owntp";
	//所属类型编码
	public static final String SD_OWNTP= "Sd_owntp";
	//所属科室
	public static final String ID_DEP= "Id_dep";
	//所属科室编码
	public static final String SD_DEP= "Sd_dep";
	//创建日期
	public static final String DT_CREAT= "Dt_creat";
	//登记人
	public static final String ID_REG_PSN= "Id_reg_psn";
	//登记人编码
	public static final String SD_REG_PSN= "Sd_reg_psn";
	//登记时间
	public static final String DT_REG= "Dt_reg";
	//是否启用
	public static final String FG_ACTIVE= "Fg_active";
	//版本
	public static final String VERSION= "Version";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//名称
	public static final String NAME_OWNTP= "Name_owntp";
	//名称
	public static final String NAME_DEP= "Name_dep";
	//姓名
	public static final String NAME_REG_PSN= "Name_reg_psn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 排班原则主键
	 * @return String
	 */
	public String getId_nhr_si_tenet() {
		return ((String) getAttrVal("Id_nhr_si_tenet"));
	}	
	/**
	 * 排班原则主键
	 * @param Id_nhr_si_tenet
	 */
	public void setId_nhr_si_tenet(String Id_nhr_si_tenet) {
		setAttrVal("Id_nhr_si_tenet", Id_nhr_si_tenet);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 原则摘要
	 * @return String
	 */
	public String getTenet_abstr() {
		return ((String) getAttrVal("Tenet_abstr"));
	}	
	/**
	 * 原则摘要
	 * @param Tenet_abstr
	 */
	public void setTenet_abstr(String Tenet_abstr) {
		setAttrVal("Tenet_abstr", Tenet_abstr);
	}
	/**
	 * 原则内容
	 * @return String
	 */
	public String getTenet_content() {
		return ((String) getAttrVal("Tenet_content"));
	}	
	/**
	 * 原则内容
	 * @param Tenet_content
	 */
	public void setTenet_content(String Tenet_content) {
		setAttrVal("Tenet_content", Tenet_content);
	}
	/**
	 * 开始时间
	 * @return FDate
	 */
	public FDate getDt_begin() {
		return ((FDate) getAttrVal("Dt_begin"));
	}	
	/**
	 * 开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(FDate Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
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
	 * 所属类型
	 * @return String
	 */
	public String getId_owntp() {
		return ((String) getAttrVal("Id_owntp"));
	}	
	/**
	 * 所属类型
	 * @param Id_owntp
	 */
	public void setId_owntp(String Id_owntp) {
		setAttrVal("Id_owntp", Id_owntp);
	}
	/**
	 * 所属类型编码
	 * @return String
	 */
	public String getSd_owntp() {
		return ((String) getAttrVal("Sd_owntp"));
	}	
	/**
	 * 所属类型编码
	 * @param Sd_owntp
	 */
	public void setSd_owntp(String Sd_owntp) {
		setAttrVal("Sd_owntp", Sd_owntp);
	}
	/**
	 * 所属科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 所属科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 所属科室编码
	 * @return String
	 */
	public String getSd_dep() {
		return ((String) getAttrVal("Sd_dep"));
	}	
	/**
	 * 所属科室编码
	 * @param Sd_dep
	 */
	public void setSd_dep(String Sd_dep) {
		setAttrVal("Sd_dep", Sd_dep);
	}
	/**
	 * 创建日期
	 * @return FDateTime
	 */
	public FDateTime getDt_creat() {
		return ((FDateTime) getAttrVal("Dt_creat"));
	}	
	/**
	 * 创建日期
	 * @param Dt_creat
	 */
	public void setDt_creat(FDateTime Dt_creat) {
		setAttrVal("Dt_creat", Dt_creat);
	}
	/**
	 * 登记人
	 * @return String
	 */
	public String getId_reg_psn() {
		return ((String) getAttrVal("Id_reg_psn"));
	}	
	/**
	 * 登记人
	 * @param Id_reg_psn
	 */
	public void setId_reg_psn(String Id_reg_psn) {
		setAttrVal("Id_reg_psn", Id_reg_psn);
	}
	/**
	 * 登记人编码
	 * @return String
	 */
	public String getSd_reg_psn() {
		return ((String) getAttrVal("Sd_reg_psn"));
	}	
	/**
	 * 登记人编码
	 * @param Sd_reg_psn
	 */
	public void setSd_reg_psn(String Sd_reg_psn) {
		setAttrVal("Sd_reg_psn", Sd_reg_psn);
	}
	/**
	 * 登记时间
	 * @return FDateTime
	 */
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}	
	/**
	 * 登记时间
	 * @param Dt_reg
	 */
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
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
	 * 版本
	 * @return String
	 */
	public String getVersion() {
		return ((String) getAttrVal("Version"));
	}	
	/**
	 * 版本
	 * @param Version
	 */
	public void setVersion(String Version) {
		setAttrVal("Version", Version);
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
	public String getName_owntp() {
		return ((String) getAttrVal("Name_owntp"));
	}	
	/**
	 * 名称
	 * @param Name_owntp
	 */
	public void setName_owntp(String Name_owntp) {
		setAttrVal("Name_owntp", Name_owntp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_reg_psn() {
		return ((String) getAttrVal("Name_reg_psn"));
	}	
	/**
	 * 姓名
	 * @param Name_reg_psn
	 */
	public void setName_reg_psn(String Name_reg_psn) {
		setAttrVal("Name_reg_psn", Name_reg_psn);
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
		return "Id_nhr_si_tenet";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NHR_SI_TENET";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNhrSiTenetDODesc.class);
	}
	
}