package iih.bd.mhi.hpdetailuploadexclude.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.mhi.hpdetailuploadexclude.d.desc.HpDetailUploadExcludeDODesc;
import java.math.BigDecimal;

/**
 * 医保项目明细上传排斥 DO数据 
 * 
 */
public class HpDetailUploadExcludeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//排斥项主键
	public static final String ID_HPSRVUPDOADEXLUDE= "Id_hpsrvupdoadexlude";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//医保产品
	public static final String ID_HP= "Id_hp";
	//所属类型
	public static final String ID_OWTP= "Id_owtp";
	//所属类型编码
	public static final String SD_OWTP= "Sd_owtp";
	//服务项目
	public static final String ID_SRV= "Id_srv";
	//所属科室
	public static final String ID_DEP= "Id_dep";
	//就诊类型
	public static final String ID_ENTP= "Id_entp";
	//启用标识
	public static final String FG_ACTIVE= "Fg_active";
	//备注
	public static final String NOTE= "Note";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//医保产品编码
	public static final String HP_CODE= "Hp_code";
	//医保产品名称
	public static final String HP_NAME= "Hp_name";
	//所属类型名称
	public static final String OWTP_NAME= "Owtp_name";
	//服务编码
	public static final String SRV_CODE= "Srv_code";
	//服务名称
	public static final String SRV_NAME= "Srv_name";
	//所属科室编码
	public static final String DEP_CODE= "Dep_code";
	//所属科室名称
	public static final String DEP_NAME= "Dep_name";
	//就诊类型名称
	public static final String ENTP_NAME= "Entp_name";
	//就诊类型编码
	public static final String ENTP_CODE= "Entp_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 排斥项主键
	 * @return String
	 */
	public String getId_hpsrvupdoadexlude() {
		return ((String) getAttrVal("Id_hpsrvupdoadexlude"));
	}	
	/**
	 * 排斥项主键
	 * @param Id_hpsrvupdoadexlude
	 */
	public void setId_hpsrvupdoadexlude(String Id_hpsrvupdoadexlude) {
		setAttrVal("Id_hpsrvupdoadexlude", Id_hpsrvupdoadexlude);
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
	 * 医保产品
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	/**
	 * 医保产品
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 所属类型
	 * @return String
	 */
	public String getId_owtp() {
		return ((String) getAttrVal("Id_owtp"));
	}	
	/**
	 * 所属类型
	 * @param Id_owtp
	 */
	public void setId_owtp(String Id_owtp) {
		setAttrVal("Id_owtp", Id_owtp);
	}
	/**
	 * 所属类型编码
	 * @return String
	 */
	public String getSd_owtp() {
		return ((String) getAttrVal("Sd_owtp"));
	}	
	/**
	 * 所属类型编码
	 * @param Sd_owtp
	 */
	public void setSd_owtp(String Sd_owtp) {
		setAttrVal("Sd_owtp", Sd_owtp);
	}
	/**
	 * 服务项目
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 服务项目
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
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
	 * 就诊类型
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	/**
	 * 就诊类型
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	/**
	 * 启用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标识
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
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
	 * 医保产品编码
	 * @return String
	 */
	public String getHp_code() {
		return ((String) getAttrVal("Hp_code"));
	}	
	/**
	 * 医保产品编码
	 * @param Hp_code
	 */
	public void setHp_code(String Hp_code) {
		setAttrVal("Hp_code", Hp_code);
	}
	/**
	 * 医保产品名称
	 * @return String
	 */
	public String getHp_name() {
		return ((String) getAttrVal("Hp_name"));
	}	
	/**
	 * 医保产品名称
	 * @param Hp_name
	 */
	public void setHp_name(String Hp_name) {
		setAttrVal("Hp_name", Hp_name);
	}
	/**
	 * 所属类型名称
	 * @return String
	 */
	public String getOwtp_name() {
		return ((String) getAttrVal("Owtp_name"));
	}	
	/**
	 * 所属类型名称
	 * @param Owtp_name
	 */
	public void setOwtp_name(String Owtp_name) {
		setAttrVal("Owtp_name", Owtp_name);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getSrv_code() {
		return ((String) getAttrVal("Srv_code"));
	}	
	/**
	 * 服务编码
	 * @param Srv_code
	 */
	public void setSrv_code(String Srv_code) {
		setAttrVal("Srv_code", Srv_code);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	/**
	 * 服务名称
	 * @param Srv_name
	 */
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	/**
	 * 所属科室编码
	 * @return String
	 */
	public String getDep_code() {
		return ((String) getAttrVal("Dep_code"));
	}	
	/**
	 * 所属科室编码
	 * @param Dep_code
	 */
	public void setDep_code(String Dep_code) {
		setAttrVal("Dep_code", Dep_code);
	}
	/**
	 * 所属科室名称
	 * @return String
	 */
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	/**
	 * 所属科室名称
	 * @param Dep_name
	 */
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	/**
	 * 就诊类型名称
	 * @return String
	 */
	public String getEntp_name() {
		return ((String) getAttrVal("Entp_name"));
	}	
	/**
	 * 就诊类型名称
	 * @param Entp_name
	 */
	public void setEntp_name(String Entp_name) {
		setAttrVal("Entp_name", Entp_name);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getEntp_code() {
		return ((String) getAttrVal("Entp_code"));
	}	
	/**
	 * 就诊类型编码
	 * @param Entp_code
	 */
	public void setEntp_code(String Entp_code) {
		setAttrVal("Entp_code", Entp_code);
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
		return "Id_hpsrvupdoadexlude";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_HP_SRV_UPLOAD_EXCLUDE";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpDetailUploadExcludeDODesc.class);
	}
	
}