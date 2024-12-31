package iih.pi.reg.patamrcode.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.reg.patamrcode.d.desc.PiPatAmrCodeDODesc;
import java.math.BigDecimal;

/**
 * 患者病案编码 DO数据 
 * 
 */
public class PiPatAmrCodeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//患者病案编码主键
	public static final String ID_PATAMRCODE= "Id_patamrcode";
	//集团id
	public static final String ID_GRP= "Id_grp";
	//组织id
	public static final String ID_ORG= "Id_org";
	//患者id
	public static final String ID_PAT= "Id_pat";
	//病案类型
	public static final String ID_PATAMRTP= "Id_patamrtp";
	//病案类型编码
	public static final String SD_PATAMRTP= "Sd_patamrtp";
	//病案号码
	public static final String CODE= "Code";
	//使用次数
	public static final String CNT_USE= "Cnt_use";
	//建立日期
	public static final String DT_CREATE= "Dt_create";
	//建立科室
	public static final String ID_DEPCREATE= "Id_depcreate";
	//建立人员
	public static final String ID_EMPCREATE= "Id_empcreate";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 患者病案编码主键
	 * @return String
	 */
	public String getId_patamrcode() {
		return ((String) getAttrVal("Id_patamrcode"));
	}	
	/**
	 * 患者病案编码主键
	 * @param Id_patamrcode
	 */
	public void setId_patamrcode(String Id_patamrcode) {
		setAttrVal("Id_patamrcode", Id_patamrcode);
	}
	/**
	 * 集团id
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团id
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 组织id
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织id
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 病案类型
	 * @return String
	 */
	public String getId_patamrtp() {
		return ((String) getAttrVal("Id_patamrtp"));
	}	
	/**
	 * 病案类型
	 * @param Id_patamrtp
	 */
	public void setId_patamrtp(String Id_patamrtp) {
		setAttrVal("Id_patamrtp", Id_patamrtp);
	}
	/**
	 * 病案类型编码
	 * @return String
	 */
	public String getSd_patamrtp() {
		return ((String) getAttrVal("Sd_patamrtp"));
	}	
	/**
	 * 病案类型编码
	 * @param Sd_patamrtp
	 */
	public void setSd_patamrtp(String Sd_patamrtp) {
		setAttrVal("Sd_patamrtp", Sd_patamrtp);
	}
	/**
	 * 病案号码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 病案号码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 使用次数
	 * @return Integer
	 */
	public Integer getCnt_use() {
		return ((Integer) getAttrVal("Cnt_use"));
	}	
	/**
	 * 使用次数
	 * @param Cnt_use
	 */
	public void setCnt_use(Integer Cnt_use) {
		setAttrVal("Cnt_use", Cnt_use);
	}
	/**
	 * 建立日期
	 * @return FDateTime
	 */
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}	
	/**
	 * 建立日期
	 * @param Dt_create
	 */
	public void setDt_create(FDateTime Dt_create) {
		setAttrVal("Dt_create", Dt_create);
	}
	/**
	 * 建立科室
	 * @return String
	 */
	public String getId_depcreate() {
		return ((String) getAttrVal("Id_depcreate"));
	}	
	/**
	 * 建立科室
	 * @param Id_depcreate
	 */
	public void setId_depcreate(String Id_depcreate) {
		setAttrVal("Id_depcreate", Id_depcreate);
	}
	/**
	 * 建立人员
	 * @return String
	 */
	public String getId_empcreate() {
		return ((String) getAttrVal("Id_empcreate"));
	}	
	/**
	 * 建立人员
	 * @param Id_empcreate
	 */
	public void setId_empcreate(String Id_empcreate) {
		setAttrVal("Id_empcreate", Id_empcreate);
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
		return "Id_patamrcode";
	}
	
	@Override
	public String getTableName() {	  
		return "pi_pat_amr_code";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PiPatAmrCodeDODesc.class);
	}
	
}