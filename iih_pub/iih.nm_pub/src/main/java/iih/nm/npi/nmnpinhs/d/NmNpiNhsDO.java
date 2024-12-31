package iih.nm.npi.nmnpinhs.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.npi.nmnpinhs.d.desc.NmNpiNhsDODesc;
import java.math.BigDecimal;

/**
 * 护理管理_制度维护 DO数据 
 * 
 */
public class NmNpiNhsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//制度维护主键
	public static final String ID_NPI_NHS= "Id_npi_nhs";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//所属类型
	public static final String ID_OWNTP= "Id_owntp";
	//所属类型编码
	public static final String SD_OWNTP= "Sd_owntp";
	//所属科室
	public static final String ID_NBD_DEP= "Id_nbd_dep";
	//关联科室
	public static final String ID_DEP= "Id_dep";
	//名称
	public static final String NAME= "Name";
	//编码
	public static final String CODE= "Code";
	//内容
	public static final String CONTENT= "Content";
	//开始时间
	public static final String DT_BEGIN= "Dt_begin";
	//结束时间
	public static final String DT_END= "Dt_end";
	//是否启用
	public static final String FG_ACTIVE= "Fg_active";
	//版本
	public static final String VERSION= "Version";
	//附件
	public static final String URL= "Url";
	//备注
	public static final String DES= "Des";
	//N创建时间
	public static final String DT_CREATE= "Dt_create";
	//N创建人
	public static final String ID_CREATE_PSN= "Id_create_psn";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//名称
	public static final String NAME_NPI_NHS= "Name_npi_nhs";
	//护理单元名称
	public static final String NAME_NBD_DEP= "Name_nbd_dep";
	//关联科室
	public static final String NAME_DEP= "Name_dep";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 制度维护主键
	 * @return String
	 */
	public String getId_npi_nhs() {
		return ((String) getAttrVal("Id_npi_nhs"));
	}	
	/**
	 * 制度维护主键
	 * @param Id_npi_nhs
	 */
	public void setId_npi_nhs(String Id_npi_nhs) {
		setAttrVal("Id_npi_nhs", Id_npi_nhs);
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
	public String getId_nbd_dep() {
		return ((String) getAttrVal("Id_nbd_dep"));
	}	
	/**
	 * 所属科室
	 * @param Id_nbd_dep
	 */
	public void setId_nbd_dep(String Id_nbd_dep) {
		setAttrVal("Id_nbd_dep", Id_nbd_dep);
	}
	/**
	 * 关联科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 关联科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
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
	 * 内容
	 * @return byte[]
	 */
	public byte[] getContent() {
		return ((byte[]) getAttrVal("Content"));
	}	
	/**
	 * 内容
	 * @param Content
	 */
	public void setContent(byte[] Content) {
		setAttrVal("Content", Content);
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
	 * 结束时间
	 * @return FDate
	 */
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}	
	/**
	 * 结束时间
	 * @param Dt_end
	 */
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
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
	 * 附件
	 * @return String
	 */
	public String getUrl() {
		return ((String) getAttrVal("Url"));
	}	
	/**
	 * 附件
	 * @param Url
	 */
	public void setUrl(String Url) {
		setAttrVal("Url", Url);
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
	 * N创建时间
	 * @return FDateTime
	 */
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}	
	/**
	 * N创建时间
	 * @param Dt_create
	 */
	public void setDt_create(FDateTime Dt_create) {
		setAttrVal("Dt_create", Dt_create);
	}
	/**
	 * N创建人
	 * @return String
	 */
	public String getId_create_psn() {
		return ((String) getAttrVal("Id_create_psn"));
	}	
	/**
	 * N创建人
	 * @param Id_create_psn
	 */
	public void setId_create_psn(String Id_create_psn) {
		setAttrVal("Id_create_psn", Id_create_psn);
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
	public String getName_npi_nhs() {
		return ((String) getAttrVal("Name_npi_nhs"));
	}	
	/**
	 * 名称
	 * @param Name_npi_nhs
	 */
	public void setName_npi_nhs(String Name_npi_nhs) {
		setAttrVal("Name_npi_nhs", Name_npi_nhs);
	}
	/**
	 * 护理单元名称
	 * @return String
	 */
	public String getName_nbd_dep() {
		return ((String) getAttrVal("Name_nbd_dep"));
	}	
	/**
	 * 护理单元名称
	 * @param Name_nbd_dep
	 */
	public void setName_nbd_dep(String Name_nbd_dep) {
		setAttrVal("Name_nbd_dep", Name_nbd_dep);
	}
	/**
	 * 关联科室
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 关联科室
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
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
		return "Id_npi_nhs";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NPI_NHS";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNpiNhsDODesc.class);
	}
	
}