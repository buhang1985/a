package iih.bd.bs.holiday.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.bs.holiday.d.desc.HolidayDODesc;
import java.math.BigDecimal;

/**
 * 假日定义 DO数据 
 * 
 */
public class HolidayDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//假日定义主键标识
	public static final String ID_HOLIDAY= "Id_holiday";
	//假日类别
	public static final String ID_HOLIDAYCATE= "Id_holidaycate";
	//所属集团
	public static final String ID_GROUP= "Id_group";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//假日年度
	public static final String HOLIDAYYEAR= "Holidayyear";
	//备注
	public static final String DES= "Des";
	//开始时间
	public static final String STARTTIME= "Starttime";
	//结束时间
	public static final String ENDTIME= "Endtime";
	//是否分时假日
	public static final String ISDEFTIME= "Isdeftime";
	//对调班别日期一
	public static final String SWITCH1= "Switch1";
	//对调至班别日期一
	public static final String SWITCH1TO= "Switch1to";
	//对调班别日期二
	public static final String SWITCH2= "Switch2";
	//对调班至别日期二
	public static final String SWITCH2TO= "Switch2to";
	//对调班别日期三
	public static final String SWITCH3= "Switch3";
	//对调至班别日期三
	public static final String SWITCH3TO= "Switch3to";
	//对调班别日期四
	public static final String SWITCH4= "Switch4";
	//对调至班别日期四
	public static final String SWITCH4TO= "Switch4to";
	//对调班别日期五
	public static final String SWITCH5= "Switch5";
	//对调至班别日期五
	public static final String SWITCH5TO= "Switch5to";
	//对调班别日期六
	public static final String SWITCH6= "Switch6";
	//对调至班别日期六
	public static final String SWITCH6TO= "Switch6to";
	//对调班别日期七
	public static final String SWITCH7= "Switch7";
	//对调至班别日期七
	public static final String SWITCH7TO= "Switch7to";
	//对调班别日期八
	public static final String SWITCH8= "Switch8";
	//对调至班别日期八
	public static final String SWITCH8TO= "Switch8to";
	//是否适用全部人员
	public static final String ISALLPSN= "Isallpsn";
	//公式显示字段
	public static final String FORMULARSTR= "Formularstr";
	//公式定义
	public static final String FORMULA= "Formula";
	//数据来源方式
	public static final String DATAFROMTYPE= "Datafromtype";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//编码
	public static final String HOLIDAY_CODE= "Holiday_code";
	//名称
	public static final String HOLIDAY_NAME= "Holiday_name";
	//编码
	public static final String GRPCODE= "Grpcode";
	//名称
	public static final String GRPNAME= "Grpname";
	//组织编码
	public static final String ORGCODE= "Orgcode";
	//组织名称
	public static final String ORGNAME= "Orgname";
	//用户名称
	public static final String CREATEDBY_NAME= "Createdby_name";
	//用户编码
	public static final String CREATEDBY_CODE= "Createdby_code";
	//用户名称
	public static final String MODIFIEDBY_NAME= "Modifiedby_name";
	//用户编码
	public static final String MODIFIEDBY_CODE= "Modifiedby_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 假日定义主键标识
	 * @return String
	 */
	public String getId_holiday() {
		return ((String) getAttrVal("Id_holiday"));
	}	
	/**
	 * 假日定义主键标识
	 * @param Id_holiday
	 */
	public void setId_holiday(String Id_holiday) {
		setAttrVal("Id_holiday", Id_holiday);
	}
	/**
	 * 假日类别
	 * @return String
	 */
	public String getId_holidaycate() {
		return ((String) getAttrVal("Id_holidaycate"));
	}	
	/**
	 * 假日类别
	 * @param Id_holidaycate
	 */
	public void setId_holidaycate(String Id_holidaycate) {
		setAttrVal("Id_holidaycate", Id_holidaycate);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_group() {
		return ((String) getAttrVal("Id_group"));
	}	
	/**
	 * 所属集团
	 * @param Id_group
	 */
	public void setId_group(String Id_group) {
		setAttrVal("Id_group", Id_group);
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
	 * 假日年度
	 * @return String
	 */
	public String getHolidayyear() {
		return ((String) getAttrVal("Holidayyear"));
	}	
	/**
	 * 假日年度
	 * @param Holidayyear
	 */
	public void setHolidayyear(String Holidayyear) {
		setAttrVal("Holidayyear", Holidayyear);
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
	 * 开始时间
	 * @return FDate
	 */
	public FDate getStarttime() {
		return ((FDate) getAttrVal("Starttime"));
	}	
	/**
	 * 开始时间
	 * @param Starttime
	 */
	public void setStarttime(FDate Starttime) {
		setAttrVal("Starttime", Starttime);
	}
	/**
	 * 结束时间
	 * @return FDate
	 */
	public FDate getEndtime() {
		return ((FDate) getAttrVal("Endtime"));
	}	
	/**
	 * 结束时间
	 * @param Endtime
	 */
	public void setEndtime(FDate Endtime) {
		setAttrVal("Endtime", Endtime);
	}
	/**
	 * 是否分时假日
	 * @return FBoolean
	 */
	public FBoolean getIsdeftime() {
		return ((FBoolean) getAttrVal("Isdeftime"));
	}	
	/**
	 * 是否分时假日
	 * @param Isdeftime
	 */
	public void setIsdeftime(FBoolean Isdeftime) {
		setAttrVal("Isdeftime", Isdeftime);
	}
	/**
	 * 对调班别日期一
	 * @return FDate
	 */
	public FDate getSwitch1() {
		return ((FDate) getAttrVal("Switch1"));
	}	
	/**
	 * 对调班别日期一
	 * @param Switch1
	 */
	public void setSwitch1(FDate Switch1) {
		setAttrVal("Switch1", Switch1);
	}
	/**
	 * 对调至班别日期一
	 * @return FDate
	 */
	public FDate getSwitch1to() {
		return ((FDate) getAttrVal("Switch1to"));
	}	
	/**
	 * 对调至班别日期一
	 * @param Switch1to
	 */
	public void setSwitch1to(FDate Switch1to) {
		setAttrVal("Switch1to", Switch1to);
	}
	/**
	 * 对调班别日期二
	 * @return FDate
	 */
	public FDate getSwitch2() {
		return ((FDate) getAttrVal("Switch2"));
	}	
	/**
	 * 对调班别日期二
	 * @param Switch2
	 */
	public void setSwitch2(FDate Switch2) {
		setAttrVal("Switch2", Switch2);
	}
	/**
	 * 对调班至别日期二
	 * @return FDate
	 */
	public FDate getSwitch2to() {
		return ((FDate) getAttrVal("Switch2to"));
	}	
	/**
	 * 对调班至别日期二
	 * @param Switch2to
	 */
	public void setSwitch2to(FDate Switch2to) {
		setAttrVal("Switch2to", Switch2to);
	}
	/**
	 * 对调班别日期三
	 * @return FDate
	 */
	public FDate getSwitch3() {
		return ((FDate) getAttrVal("Switch3"));
	}	
	/**
	 * 对调班别日期三
	 * @param Switch3
	 */
	public void setSwitch3(FDate Switch3) {
		setAttrVal("Switch3", Switch3);
	}
	/**
	 * 对调至班别日期三
	 * @return FDate
	 */
	public FDate getSwitch3to() {
		return ((FDate) getAttrVal("Switch3to"));
	}	
	/**
	 * 对调至班别日期三
	 * @param Switch3to
	 */
	public void setSwitch3to(FDate Switch3to) {
		setAttrVal("Switch3to", Switch3to);
	}
	/**
	 * 对调班别日期四
	 * @return FDate
	 */
	public FDate getSwitch4() {
		return ((FDate) getAttrVal("Switch4"));
	}	
	/**
	 * 对调班别日期四
	 * @param Switch4
	 */
	public void setSwitch4(FDate Switch4) {
		setAttrVal("Switch4", Switch4);
	}
	/**
	 * 对调至班别日期四
	 * @return FDate
	 */
	public FDate getSwitch4to() {
		return ((FDate) getAttrVal("Switch4to"));
	}	
	/**
	 * 对调至班别日期四
	 * @param Switch4to
	 */
	public void setSwitch4to(FDate Switch4to) {
		setAttrVal("Switch4to", Switch4to);
	}
	/**
	 * 对调班别日期五
	 * @return FDate
	 */
	public FDate getSwitch5() {
		return ((FDate) getAttrVal("Switch5"));
	}	
	/**
	 * 对调班别日期五
	 * @param Switch5
	 */
	public void setSwitch5(FDate Switch5) {
		setAttrVal("Switch5", Switch5);
	}
	/**
	 * 对调至班别日期五
	 * @return FDate
	 */
	public FDate getSwitch5to() {
		return ((FDate) getAttrVal("Switch5to"));
	}	
	/**
	 * 对调至班别日期五
	 * @param Switch5to
	 */
	public void setSwitch5to(FDate Switch5to) {
		setAttrVal("Switch5to", Switch5to);
	}
	/**
	 * 对调班别日期六
	 * @return FDate
	 */
	public FDate getSwitch6() {
		return ((FDate) getAttrVal("Switch6"));
	}	
	/**
	 * 对调班别日期六
	 * @param Switch6
	 */
	public void setSwitch6(FDate Switch6) {
		setAttrVal("Switch6", Switch6);
	}
	/**
	 * 对调至班别日期六
	 * @return FDate
	 */
	public FDate getSwitch6to() {
		return ((FDate) getAttrVal("Switch6to"));
	}	
	/**
	 * 对调至班别日期六
	 * @param Switch6to
	 */
	public void setSwitch6to(FDate Switch6to) {
		setAttrVal("Switch6to", Switch6to);
	}
	/**
	 * 对调班别日期七
	 * @return FDate
	 */
	public FDate getSwitch7() {
		return ((FDate) getAttrVal("Switch7"));
	}	
	/**
	 * 对调班别日期七
	 * @param Switch7
	 */
	public void setSwitch7(FDate Switch7) {
		setAttrVal("Switch7", Switch7);
	}
	/**
	 * 对调至班别日期七
	 * @return FDate
	 */
	public FDate getSwitch7to() {
		return ((FDate) getAttrVal("Switch7to"));
	}	
	/**
	 * 对调至班别日期七
	 * @param Switch7to
	 */
	public void setSwitch7to(FDate Switch7to) {
		setAttrVal("Switch7to", Switch7to);
	}
	/**
	 * 对调班别日期八
	 * @return FDate
	 */
	public FDate getSwitch8() {
		return ((FDate) getAttrVal("Switch8"));
	}	
	/**
	 * 对调班别日期八
	 * @param Switch8
	 */
	public void setSwitch8(FDate Switch8) {
		setAttrVal("Switch8", Switch8);
	}
	/**
	 * 对调至班别日期八
	 * @return FDate
	 */
	public FDate getSwitch8to() {
		return ((FDate) getAttrVal("Switch8to"));
	}	
	/**
	 * 对调至班别日期八
	 * @param Switch8to
	 */
	public void setSwitch8to(FDate Switch8to) {
		setAttrVal("Switch8to", Switch8to);
	}
	/**
	 * 是否适用全部人员
	 * @return FBoolean
	 */
	public FBoolean getIsallpsn() {
		return ((FBoolean) getAttrVal("Isallpsn"));
	}	
	/**
	 * 是否适用全部人员
	 * @param Isallpsn
	 */
	public void setIsallpsn(FBoolean Isallpsn) {
		setAttrVal("Isallpsn", Isallpsn);
	}
	/**
	 * 公式显示字段
	 * @return String
	 */
	public String getFormularstr() {
		return ((String) getAttrVal("Formularstr"));
	}	
	/**
	 * 公式显示字段
	 * @param Formularstr
	 */
	public void setFormularstr(String Formularstr) {
		setAttrVal("Formularstr", Formularstr);
	}
	/**
	 * 公式定义
	 * @return String
	 */
	public String getFormula() {
		return ((String) getAttrVal("Formula"));
	}	
	/**
	 * 公式定义
	 * @param Formula
	 */
	public void setFormula(String Formula) {
		setAttrVal("Formula", Formula);
	}
	/**
	 * 数据来源方式
	 * @return Integer
	 */
	public Integer getDatafromtype() {
		return ((Integer) getAttrVal("Datafromtype"));
	}	
	/**
	 * 数据来源方式
	 * @param Datafromtype
	 */
	public void setDatafromtype(Integer Datafromtype) {
		setAttrVal("Datafromtype", Datafromtype);
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
	 * 编码
	 * @return String
	 */
	public String getHoliday_code() {
		return ((String) getAttrVal("Holiday_code"));
	}	
	/**
	 * 编码
	 * @param Holiday_code
	 */
	public void setHoliday_code(String Holiday_code) {
		setAttrVal("Holiday_code", Holiday_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHoliday_name() {
		return ((String) getAttrVal("Holiday_name"));
	}	
	/**
	 * 名称
	 * @param Holiday_name
	 */
	public void setHoliday_name(String Holiday_name) {
		setAttrVal("Holiday_name", Holiday_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getGrpcode() {
		return ((String) getAttrVal("Grpcode"));
	}	
	/**
	 * 编码
	 * @param Grpcode
	 */
	public void setGrpcode(String Grpcode) {
		setAttrVal("Grpcode", Grpcode);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getGrpname() {
		return ((String) getAttrVal("Grpname"));
	}	
	/**
	 * 名称
	 * @param Grpname
	 */
	public void setGrpname(String Grpname) {
		setAttrVal("Grpname", Grpname);
	}
	/**
	 * 组织编码
	 * @return String
	 */
	public String getOrgcode() {
		return ((String) getAttrVal("Orgcode"));
	}	
	/**
	 * 组织编码
	 * @param Orgcode
	 */
	public void setOrgcode(String Orgcode) {
		setAttrVal("Orgcode", Orgcode);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getOrgname() {
		return ((String) getAttrVal("Orgname"));
	}	
	/**
	 * 组织名称
	 * @param Orgname
	 */
	public void setOrgname(String Orgname) {
		setAttrVal("Orgname", Orgname);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getCreatedby_name() {
		return ((String) getAttrVal("Createdby_name"));
	}	
	/**
	 * 用户名称
	 * @param Createdby_name
	 */
	public void setCreatedby_name(String Createdby_name) {
		setAttrVal("Createdby_name", Createdby_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getCreatedby_code() {
		return ((String) getAttrVal("Createdby_code"));
	}	
	/**
	 * 用户编码
	 * @param Createdby_code
	 */
	public void setCreatedby_code(String Createdby_code) {
		setAttrVal("Createdby_code", Createdby_code);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getModifiedby_name() {
		return ((String) getAttrVal("Modifiedby_name"));
	}	
	/**
	 * 用户名称
	 * @param Modifiedby_name
	 */
	public void setModifiedby_name(String Modifiedby_name) {
		setAttrVal("Modifiedby_name", Modifiedby_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getModifiedby_code() {
		return ((String) getAttrVal("Modifiedby_code"));
	}	
	/**
	 * 用户编码
	 * @param Modifiedby_code
	 */
	public void setModifiedby_code(String Modifiedby_code) {
		setAttrVal("Modifiedby_code", Modifiedby_code);
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
		return "Id_holiday";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_holiday";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HolidayDODesc.class);
	}
	
}