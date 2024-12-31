package iih.ci.tsip.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.tsip.d.desc.CiTsApLabDODesc;
import java.math.BigDecimal;

/**
 * 治疗方案检验申请 DO数据 
 * 
 */
public class CiTsApLabDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//治疗方案检验申请ID
	public static final String ID_TSAPLAB= "Id_tsaplab";
	//治疗方案医嘱ID
	public static final String ID_TSOR= "Id_tsor";
	//标本类型ID
	public static final String ID_SAMPTP= "Id_samptp";
	//标本类型SD
	public static final String SD_SAMPTP= "Sd_samptp";
	//标本类型名称
	public static final String NAME_SAMPTP= "Name_samptp";
	//标本采集时间ID
	public static final String ID_SAMPCOLTIME= "Id_sampcoltime";
	//标本采集时间
	public static final String NAME_SAMPCOLTIME= "Name_sampcoltime";
	//标本采集时间类型ID
	public static final String ID_SAMPCOLLECTTIMETP= "Id_sampcollecttimetp";
	//标本采集时间类型编码
	public static final String SD_SAMPCOLLECTTIMETP= "Sd_sampcollecttimetp";
	//标本采集时长
	public static final String LEN_SAMPCOLTIME= "Len_sampcoltime";
	//标本采集时长单位
	public static final String ID_UNIT_SAMPCOLTIME= "Id_unit_sampcoltime";
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
	 * 治疗方案检验申请ID
	 * @return String
	 */
	public String getId_tsaplab() {
		return ((String) getAttrVal("Id_tsaplab"));
	}	
	/**
	 * 治疗方案检验申请ID
	 * @param Id_tsaplab
	 */
	public void setId_tsaplab(String Id_tsaplab) {
		setAttrVal("Id_tsaplab", Id_tsaplab);
	}
	/**
	 * 治疗方案医嘱ID
	 * @return String
	 */
	public String getId_tsor() {
		return ((String) getAttrVal("Id_tsor"));
	}	
	/**
	 * 治疗方案医嘱ID
	 * @param Id_tsor
	 */
	public void setId_tsor(String Id_tsor) {
		setAttrVal("Id_tsor", Id_tsor);
	}
	/**
	 * 标本类型ID
	 * @return String
	 */
	public String getId_samptp() {
		return ((String) getAttrVal("Id_samptp"));
	}	
	/**
	 * 标本类型ID
	 * @param Id_samptp
	 */
	public void setId_samptp(String Id_samptp) {
		setAttrVal("Id_samptp", Id_samptp);
	}
	/**
	 * 标本类型SD
	 * @return String
	 */
	public String getSd_samptp() {
		return ((String) getAttrVal("Sd_samptp"));
	}	
	/**
	 * 标本类型SD
	 * @param Sd_samptp
	 */
	public void setSd_samptp(String Sd_samptp) {
		setAttrVal("Sd_samptp", Sd_samptp);
	}
	/**
	 * 标本类型名称
	 * @return String
	 */
	public String getName_samptp() {
		return ((String) getAttrVal("Name_samptp"));
	}	
	/**
	 * 标本类型名称
	 * @param Name_samptp
	 */
	public void setName_samptp(String Name_samptp) {
		setAttrVal("Name_samptp", Name_samptp);
	}
	/**
	 * 标本采集时间ID
	 * @return String
	 */
	public String getId_sampcoltime() {
		return ((String) getAttrVal("Id_sampcoltime"));
	}	
	/**
	 * 标本采集时间ID
	 * @param Id_sampcoltime
	 */
	public void setId_sampcoltime(String Id_sampcoltime) {
		setAttrVal("Id_sampcoltime", Id_sampcoltime);
	}
	/**
	 * 标本采集时间
	 * @return String
	 */
	public String getName_sampcoltime() {
		return ((String) getAttrVal("Name_sampcoltime"));
	}	
	/**
	 * 标本采集时间
	 * @param Name_sampcoltime
	 */
	public void setName_sampcoltime(String Name_sampcoltime) {
		setAttrVal("Name_sampcoltime", Name_sampcoltime);
	}
	/**
	 * 标本采集时间类型ID
	 * @return String
	 */
	public String getId_sampcollecttimetp() {
		return ((String) getAttrVal("Id_sampcollecttimetp"));
	}	
	/**
	 * 标本采集时间类型ID
	 * @param Id_sampcollecttimetp
	 */
	public void setId_sampcollecttimetp(String Id_sampcollecttimetp) {
		setAttrVal("Id_sampcollecttimetp", Id_sampcollecttimetp);
	}
	/**
	 * 标本采集时间类型编码
	 * @return String
	 */
	public String getSd_sampcollecttimetp() {
		return ((String) getAttrVal("Sd_sampcollecttimetp"));
	}	
	/**
	 * 标本采集时间类型编码
	 * @param Sd_sampcollecttimetp
	 */
	public void setSd_sampcollecttimetp(String Sd_sampcollecttimetp) {
		setAttrVal("Sd_sampcollecttimetp", Sd_sampcollecttimetp);
	}
	/**
	 * 标本采集时长
	 * @return FDouble
	 */
	public FDouble getLen_sampcoltime() {
		return ((FDouble) getAttrVal("Len_sampcoltime"));
	}	
	/**
	 * 标本采集时长
	 * @param Len_sampcoltime
	 */
	public void setLen_sampcoltime(FDouble Len_sampcoltime) {
		setAttrVal("Len_sampcoltime", Len_sampcoltime);
	}
	/**
	 * 标本采集时长单位
	 * @return String
	 */
	public String getId_unit_sampcoltime() {
		return ((String) getAttrVal("Id_unit_sampcoltime"));
	}	
	/**
	 * 标本采集时长单位
	 * @param Id_unit_sampcoltime
	 */
	public void setId_unit_sampcoltime(String Id_unit_sampcoltime) {
		setAttrVal("Id_unit_sampcoltime", Id_unit_sampcoltime);
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
		return "Id_tsaplab";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_ts_ap_lab";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiTsApLabDODesc.class);
	}
	
}