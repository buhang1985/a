package iih.bd.srv.medsrv.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.medsrv.d.desc.MedSrvConsDODesc;
import java.math.BigDecimal;

/**
 * 医疗服务会诊属性 DO数据 
 * 
 */
public class MedSrvConsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医疗服务会诊主键
	public static final String ID_SRVCONS= "Id_srvcons";
	//服务
	public static final String ID_SRV= "Id_srv";
	//会诊类型（废弃不用了）
	public static final String ID_CONSTP= "Id_constp";
	//会诊类型编码（废弃不用了）
	public static final String SD_CONSTP= "Sd_constp";
	//是否院内会诊
	public static final String FG_INORG= "Fg_inorg";
	//是否多科室会诊
	public static final String FG_DEPS= "Fg_deps";
	//受邀医生是否职称限制
	public static final String FG_EMPTITLELIMIT= "Fg_emptitlelimit";
	//受邀医生最低职称
	public static final String ID_EMPTITLE= "Id_emptitle";
	//受邀医生最低职称编码
	public static final String SD_EMPTITLE= "Sd_emptitle";
	//是否需科室审批
	public static final String FG_AUDIT_CLIDEP= "Fg_audit_clidep";
	//是否需医务部审批
	public static final String FG_AUDIT_ADMDEP= "Fg_audit_admdep";
	//会诊时效
	public static final String QUAN_CONSTIMELIMIT= "Quan_constimelimit";
	//时效单位
	public static final String ID_UNIT= "Id_unit";
	//加急时效
	public static final String QUAN_URG_CONSTIMELIMIT= "Quan_urg_constimelimit";
	//加急时效单位
	public static final String ID_UNIT_URG= "Id_unit_urg";
	//会诊类型名称
	public static final String NAME_CONSTP= "Name_constp";
	//名称
	public static final String NAME_EMPTITLE= "Name_emptitle";
	//计量单位名称
	public static final String NAME_UNIT= "Name_unit";
	//计量单位名称
	public static final String NAME_UNIT_URG= "Name_unit_urg";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医疗服务会诊主键
	 * @return String
	 */
	public String getId_srvcons() {
		return ((String) getAttrVal("Id_srvcons"));
	}	
	/**
	 * 医疗服务会诊主键
	 * @param Id_srvcons
	 */
	public void setId_srvcons(String Id_srvcons) {
		setAttrVal("Id_srvcons", Id_srvcons);
	}
	/**
	 * 服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 会诊类型（废弃不用了）
	 * @return String
	 */
	public String getId_constp() {
		return ((String) getAttrVal("Id_constp"));
	}	
	/**
	 * 会诊类型（废弃不用了）
	 * @param Id_constp
	 */
	public void setId_constp(String Id_constp) {
		setAttrVal("Id_constp", Id_constp);
	}
	/**
	 * 会诊类型编码（废弃不用了）
	 * @return String
	 */
	public String getSd_constp() {
		return ((String) getAttrVal("Sd_constp"));
	}	
	/**
	 * 会诊类型编码（废弃不用了）
	 * @param Sd_constp
	 */
	public void setSd_constp(String Sd_constp) {
		setAttrVal("Sd_constp", Sd_constp);
	}
	/**
	 * 是否院内会诊
	 * @return FBoolean
	 */
	public FBoolean getFg_inorg() {
		return ((FBoolean) getAttrVal("Fg_inorg"));
	}	
	/**
	 * 是否院内会诊
	 * @param Fg_inorg
	 */
	public void setFg_inorg(FBoolean Fg_inorg) {
		setAttrVal("Fg_inorg", Fg_inorg);
	}
	/**
	 * 是否多科室会诊
	 * @return FBoolean
	 */
	public FBoolean getFg_deps() {
		return ((FBoolean) getAttrVal("Fg_deps"));
	}	
	/**
	 * 是否多科室会诊
	 * @param Fg_deps
	 */
	public void setFg_deps(FBoolean Fg_deps) {
		setAttrVal("Fg_deps", Fg_deps);
	}
	/**
	 * 受邀医生是否职称限制
	 * @return FBoolean
	 */
	public FBoolean getFg_emptitlelimit() {
		return ((FBoolean) getAttrVal("Fg_emptitlelimit"));
	}	
	/**
	 * 受邀医生是否职称限制
	 * @param Fg_emptitlelimit
	 */
	public void setFg_emptitlelimit(FBoolean Fg_emptitlelimit) {
		setAttrVal("Fg_emptitlelimit", Fg_emptitlelimit);
	}
	/**
	 * 受邀医生最低职称
	 * @return String
	 */
	public String getId_emptitle() {
		return ((String) getAttrVal("Id_emptitle"));
	}	
	/**
	 * 受邀医生最低职称
	 * @param Id_emptitle
	 */
	public void setId_emptitle(String Id_emptitle) {
		setAttrVal("Id_emptitle", Id_emptitle);
	}
	/**
	 * 受邀医生最低职称编码
	 * @return String
	 */
	public String getSd_emptitle() {
		return ((String) getAttrVal("Sd_emptitle"));
	}	
	/**
	 * 受邀医生最低职称编码
	 * @param Sd_emptitle
	 */
	public void setSd_emptitle(String Sd_emptitle) {
		setAttrVal("Sd_emptitle", Sd_emptitle);
	}
	/**
	 * 是否需科室审批
	 * @return FBoolean
	 */
	public FBoolean getFg_audit_clidep() {
		return ((FBoolean) getAttrVal("Fg_audit_clidep"));
	}	
	/**
	 * 是否需科室审批
	 * @param Fg_audit_clidep
	 */
	public void setFg_audit_clidep(FBoolean Fg_audit_clidep) {
		setAttrVal("Fg_audit_clidep", Fg_audit_clidep);
	}
	/**
	 * 是否需医务部审批
	 * @return FBoolean
	 */
	public FBoolean getFg_audit_admdep() {
		return ((FBoolean) getAttrVal("Fg_audit_admdep"));
	}	
	/**
	 * 是否需医务部审批
	 * @param Fg_audit_admdep
	 */
	public void setFg_audit_admdep(FBoolean Fg_audit_admdep) {
		setAttrVal("Fg_audit_admdep", Fg_audit_admdep);
	}
	/**
	 * 会诊时效
	 * @return Integer
	 */
	public Integer getQuan_constimelimit() {
		return ((Integer) getAttrVal("Quan_constimelimit"));
	}	
	/**
	 * 会诊时效
	 * @param Quan_constimelimit
	 */
	public void setQuan_constimelimit(Integer Quan_constimelimit) {
		setAttrVal("Quan_constimelimit", Quan_constimelimit);
	}
	/**
	 * 时效单位
	 * @return String
	 */
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}	
	/**
	 * 时效单位
	 * @param Id_unit
	 */
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	/**
	 * 加急时效
	 * @return Integer
	 */
	public Integer getQuan_urg_constimelimit() {
		return ((Integer) getAttrVal("Quan_urg_constimelimit"));
	}	
	/**
	 * 加急时效
	 * @param Quan_urg_constimelimit
	 */
	public void setQuan_urg_constimelimit(Integer Quan_urg_constimelimit) {
		setAttrVal("Quan_urg_constimelimit", Quan_urg_constimelimit);
	}
	/**
	 * 加急时效单位
	 * @return String
	 */
	public String getId_unit_urg() {
		return ((String) getAttrVal("Id_unit_urg"));
	}	
	/**
	 * 加急时效单位
	 * @param Id_unit_urg
	 */
	public void setId_unit_urg(String Id_unit_urg) {
		setAttrVal("Id_unit_urg", Id_unit_urg);
	}
	/**
	 * 会诊类型名称
	 * @return String
	 */
	public String getName_constp() {
		return ((String) getAttrVal("Name_constp"));
	}	
	/**
	 * 会诊类型名称
	 * @param Name_constp
	 */
	public void setName_constp(String Name_constp) {
		setAttrVal("Name_constp", Name_constp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_emptitle() {
		return ((String) getAttrVal("Name_emptitle"));
	}	
	/**
	 * 名称
	 * @param Name_emptitle
	 */
	public void setName_emptitle(String Name_emptitle) {
		setAttrVal("Name_emptitle", Name_emptitle);
	}
	/**
	 * 计量单位名称
	 * @return String
	 */
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}	
	/**
	 * 计量单位名称
	 * @param Name_unit
	 */
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
	}
	/**
	 * 计量单位名称
	 * @return String
	 */
	public String getName_unit_urg() {
		return ((String) getAttrVal("Name_unit_urg"));
	}	
	/**
	 * 计量单位名称
	 * @param Name_unit_urg
	 */
	public void setName_unit_urg(String Name_unit_urg) {
		setAttrVal("Name_unit_urg", Name_unit_urg);
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
		return "Id_srvcons";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_cons";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MedSrvConsDODesc.class);
	}
	
}