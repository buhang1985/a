package iih.nm.nhr.nmnurfurstu.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.nmnurfurstu.d.desc.NmNurFurstuDODesc;
import java.math.BigDecimal;

/**
 * 人员进修 DO数据 
 * 
 */
public class NmNurFurstuDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//联系人主键
	public static final String ID_NUR_FURSTU= "Id_nur_furstu";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//护理人员
	public static final String ID_NUR= "Id_nur";
	//开始时间
	public static final String DT_BEGIN= "Dt_begin";
	//结束时间
	public static final String DT_END= "Dt_end";
	//进修医院
	public static final String NAME_HOS_STU= "Name_hos_stu";
	//进修专业
	public static final String NAME_MAJOR_STU= "Name_major_stu";
	//进修内容
	public static final String CONTENT_STU= "Content_stu";
	//进修地点
	public static final String ADDR_STU= "Addr_stu";
	//职称id
	public static final String ID_JOBTITLE= "Id_jobtitle";
	//职称编码
	public static final String SD_JOBTITLE= "Sd_jobtitle";
	//职务id
	public static final String ID_DUTY= "Id_duty";
	//职务编码
	public static final String SD_DUTY= "Sd_duty";
	//护士层级id
	public static final String ID_NUR_LVL= "Id_nur_lvl";
	//护士层级编码
	public static final String SD_NUR_LVL= "Sd_nur_lvl";
	//进修成果
	public static final String RESULT_STU= "Result_stu";
	//备注
	public static final String DES= "Des";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//名称
	public static final String NAME_GRP= "Name_grp";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//人员姓名
	public static final String NAME_NUR= "Name_nur";
	//名称
	public static final String NAME_JOBTITLE= "Name_jobtitle";
	//名称
	public static final String NAME_DUTY= "Name_duty";
	//名称
	public static final String NAME_LVL= "Name_lvl";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 联系人主键
	 * @return String
	 */
	public String getId_nur_furstu() {
		return ((String) getAttrVal("Id_nur_furstu"));
	}	
	/**
	 * 联系人主键
	 * @param Id_nur_furstu
	 */
	public void setId_nur_furstu(String Id_nur_furstu) {
		setAttrVal("Id_nur_furstu", Id_nur_furstu);
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
	 * 护理人员
	 * @return String
	 */
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	/**
	 * 护理人员
	 * @param Id_nur
	 */
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}	
	/**
	 * 开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	/**
	 * 结束时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 进修医院
	 * @return String
	 */
	public String getName_hos_stu() {
		return ((String) getAttrVal("Name_hos_stu"));
	}	
	/**
	 * 进修医院
	 * @param Name_hos_stu
	 */
	public void setName_hos_stu(String Name_hos_stu) {
		setAttrVal("Name_hos_stu", Name_hos_stu);
	}
	/**
	 * 进修专业
	 * @return String
	 */
	public String getName_major_stu() {
		return ((String) getAttrVal("Name_major_stu"));
	}	
	/**
	 * 进修专业
	 * @param Name_major_stu
	 */
	public void setName_major_stu(String Name_major_stu) {
		setAttrVal("Name_major_stu", Name_major_stu);
	}
	/**
	 * 进修内容
	 * @return String
	 */
	public String getContent_stu() {
		return ((String) getAttrVal("Content_stu"));
	}	
	/**
	 * 进修内容
	 * @param Content_stu
	 */
	public void setContent_stu(String Content_stu) {
		setAttrVal("Content_stu", Content_stu);
	}
	/**
	 * 进修地点
	 * @return String
	 */
	public String getAddr_stu() {
		return ((String) getAttrVal("Addr_stu"));
	}	
	/**
	 * 进修地点
	 * @param Addr_stu
	 */
	public void setAddr_stu(String Addr_stu) {
		setAttrVal("Addr_stu", Addr_stu);
	}
	/**
	 * 职称id
	 * @return String
	 */
	public String getId_jobtitle() {
		return ((String) getAttrVal("Id_jobtitle"));
	}	
	/**
	 * 职称id
	 * @param Id_jobtitle
	 */
	public void setId_jobtitle(String Id_jobtitle) {
		setAttrVal("Id_jobtitle", Id_jobtitle);
	}
	/**
	 * 职称编码
	 * @return String
	 */
	public String getSd_jobtitle() {
		return ((String) getAttrVal("Sd_jobtitle"));
	}	
	/**
	 * 职称编码
	 * @param Sd_jobtitle
	 */
	public void setSd_jobtitle(String Sd_jobtitle) {
		setAttrVal("Sd_jobtitle", Sd_jobtitle);
	}
	/**
	 * 职务id
	 * @return String
	 */
	public String getId_duty() {
		return ((String) getAttrVal("Id_duty"));
	}	
	/**
	 * 职务id
	 * @param Id_duty
	 */
	public void setId_duty(String Id_duty) {
		setAttrVal("Id_duty", Id_duty);
	}
	/**
	 * 职务编码
	 * @return String
	 */
	public String getSd_duty() {
		return ((String) getAttrVal("Sd_duty"));
	}	
	/**
	 * 职务编码
	 * @param Sd_duty
	 */
	public void setSd_duty(String Sd_duty) {
		setAttrVal("Sd_duty", Sd_duty);
	}
	/**
	 * 护士层级id
	 * @return String
	 */
	public String getId_nur_lvl() {
		return ((String) getAttrVal("Id_nur_lvl"));
	}	
	/**
	 * 护士层级id
	 * @param Id_nur_lvl
	 */
	public void setId_nur_lvl(String Id_nur_lvl) {
		setAttrVal("Id_nur_lvl", Id_nur_lvl);
	}
	/**
	 * 护士层级编码
	 * @return String
	 */
	public String getSd_nur_lvl() {
		return ((String) getAttrVal("Sd_nur_lvl"));
	}	
	/**
	 * 护士层级编码
	 * @param Sd_nur_lvl
	 */
	public void setSd_nur_lvl(String Sd_nur_lvl) {
		setAttrVal("Sd_nur_lvl", Sd_nur_lvl);
	}
	/**
	 * 进修成果
	 * @return String
	 */
	public String getResult_stu() {
		return ((String) getAttrVal("Result_stu"));
	}	
	/**
	 * 进修成果
	 * @param Result_stu
	 */
	public void setResult_stu(String Result_stu) {
		setAttrVal("Result_stu", Result_stu);
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
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	/**
	 * 名称
	 * @param Name_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	/**
	 * 组织名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 人员姓名
	 * @return String
	 */
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	/**
	 * 人员姓名
	 * @param Name_nur
	 */
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_jobtitle() {
		return ((String) getAttrVal("Name_jobtitle"));
	}	
	/**
	 * 名称
	 * @param Name_jobtitle
	 */
	public void setName_jobtitle(String Name_jobtitle) {
		setAttrVal("Name_jobtitle", Name_jobtitle);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_duty() {
		return ((String) getAttrVal("Name_duty"));
	}	
	/**
	 * 名称
	 * @param Name_duty
	 */
	public void setName_duty(String Name_duty) {
		setAttrVal("Name_duty", Name_duty);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_lvl() {
		return ((String) getAttrVal("Name_lvl"));
	}	
	/**
	 * 名称
	 * @param Name_lvl
	 */
	public void setName_lvl(String Name_lvl) {
		setAttrVal("Name_lvl", Name_lvl);
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
		return "Id_nur_furstu";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NHR_NUR_FURSTU";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNurFurstuDODesc.class);
	}
	
}