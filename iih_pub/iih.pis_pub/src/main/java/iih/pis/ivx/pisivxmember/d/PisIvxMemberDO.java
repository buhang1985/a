package iih.pis.ivx.pisivxmember.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pis.ivx.pisivxmember.d.desc.PisIvxMemberDODesc;
import java.math.BigDecimal;

/**
 * 微信就诊人管理 DO数据 
 * 
 */
public class PisIvxMemberDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//微信就诊人主键标识
	public static final String ID_PISIVXMEMBER= "Id_pisivxmember";
	//微信账户ID
	public static final String ID_PISIVXACCOUNT= "Id_pisivxaccount";
	//绑定序号
	public static final String SORTNO= "Sortno";
	//患者ID
	public static final String ID_PAT= "Id_pat";
	//姓名
	public static final String NAME= "Name";
	//性别编码
	public static final String SD_SEX= "Sd_sex";
	//性别
	public static final String NAME_SEX= "Name_sex";
	//出生日期
	public static final String DT_BIRTH= "Dt_birth";
	//出生日期(时分秒)
	public static final String DT_BIRTH_HMS= "Dt_birth_hms";
	//主身份标志类型
	public static final String ID_IDTP= "Id_idtp";
	//主身份标志类型编码
	public static final String SD_IDTP= "Sd_idtp";
	//主身份标识号码
	public static final String ID_CODE= "Id_code";
	//年龄
	public static final String AGE= "Age";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//移动电话
	public static final String MOB= "Mob";
	//HIS患者编号
	public static final String PATCODE= "Patcode";
	//就诊卡号
	public static final String CARDCODE= "Cardcode";
	//住院号
	public static final String IPCODE= "Ipcode";
	//绑定标识
	public static final String FG_BIND= "Fg_bind";
	//电子就诊卡号
	public static final String ECARDNO= "Ecardno";
	//关系
	public static final String REL= "Rel";
	//默认就诊人
	public static final String FG_DEF= "Fg_def";
	//参保机构代码
	public static final String INSUREDORGCODE= "Insuredorgcode";
	//患者医保卡号
	public static final String MEDINSCODE= "Medinscode";
	//微信唯一码
	public static final String OPENID= "Openid";
	//编码
	public static final String CODE_ID= "Code_id";
	//名称
	public static final String NAME_ID= "Name_id";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 微信就诊人主键标识
	 * @return String
	 */
	public String getId_pisivxmember() {
		return ((String) getAttrVal("Id_pisivxmember"));
	}	
	/**
	 * 微信就诊人主键标识
	 * @param Id_pisivxmember
	 */
	public void setId_pisivxmember(String Id_pisivxmember) {
		setAttrVal("Id_pisivxmember", Id_pisivxmember);
	}
	/**
	 * 微信账户ID
	 * @return String
	 */
	public String getId_pisivxaccount() {
		return ((String) getAttrVal("Id_pisivxaccount"));
	}	
	/**
	 * 微信账户ID
	 * @param Id_pisivxaccount
	 */
	public void setId_pisivxaccount(String Id_pisivxaccount) {
		setAttrVal("Id_pisivxaccount", Id_pisivxaccount);
	}
	/**
	 * 绑定序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 绑定序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}	
	/**
	 * 性别编码
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	/**
	 * 性别
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}	
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 出生日期(时分秒)
	 * @return FDateTime
	 */
	public FDateTime getDt_birth_hms() {
		return ((FDateTime) getAttrVal("Dt_birth_hms"));
	}	
	/**
	 * 出生日期(时分秒)
	 * @param Dt_birth_hms
	 */
	public void setDt_birth_hms(FDateTime Dt_birth_hms) {
		setAttrVal("Dt_birth_hms", Dt_birth_hms);
	}
	/**
	 * 主身份标志类型
	 * @return String
	 */
	public String getId_idtp() {
		return ((String) getAttrVal("Id_idtp"));
	}	
	/**
	 * 主身份标志类型
	 * @param Id_idtp
	 */
	public void setId_idtp(String Id_idtp) {
		setAttrVal("Id_idtp", Id_idtp);
	}
	/**
	 * 主身份标志类型编码
	 * @return String
	 */
	public String getSd_idtp() {
		return ((String) getAttrVal("Sd_idtp"));
	}	
	/**
	 * 主身份标志类型编码
	 * @param Sd_idtp
	 */
	public void setSd_idtp(String Sd_idtp) {
		setAttrVal("Sd_idtp", Sd_idtp);
	}
	/**
	 * 主身份标识号码
	 * @return String
	 */
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}	
	/**
	 * 主身份标识号码
	 * @param Id_code
	 */
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
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
	 * 移动电话
	 * @return String
	 */
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}	
	/**
	 * 移动电话
	 * @param Mob
	 */
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}
	/**
	 * HIS患者编号
	 * @return String
	 */
	public String getPatcode() {
		return ((String) getAttrVal("Patcode"));
	}	
	/**
	 * HIS患者编号
	 * @param Patcode
	 */
	public void setPatcode(String Patcode) {
		setAttrVal("Patcode", Patcode);
	}
	/**
	 * 就诊卡号
	 * @return String
	 */
	public String getCardcode() {
		return ((String) getAttrVal("Cardcode"));
	}	
	/**
	 * 就诊卡号
	 * @param Cardcode
	 */
	public void setCardcode(String Cardcode) {
		setAttrVal("Cardcode", Cardcode);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getIpcode() {
		return ((String) getAttrVal("Ipcode"));
	}	
	/**
	 * 住院号
	 * @param Ipcode
	 */
	public void setIpcode(String Ipcode) {
		setAttrVal("Ipcode", Ipcode);
	}
	/**
	 * 绑定标识
	 * @return FBoolean
	 */
	public FBoolean getFg_bind() {
		return ((FBoolean) getAttrVal("Fg_bind"));
	}	
	/**
	 * 绑定标识
	 * @param Fg_bind
	 */
	public void setFg_bind(FBoolean Fg_bind) {
		setAttrVal("Fg_bind", Fg_bind);
	}
	/**
	 * 电子就诊卡号
	 * @return String
	 */
	public String getEcardno() {
		return ((String) getAttrVal("Ecardno"));
	}	
	/**
	 * 电子就诊卡号
	 * @param Ecardno
	 */
	public void setEcardno(String Ecardno) {
		setAttrVal("Ecardno", Ecardno);
	}
	/**
	 * 关系
	 * @return Integer
	 */
	public Integer getRel() {
		return ((Integer) getAttrVal("Rel"));
	}	
	/**
	 * 关系
	 * @param Rel
	 */
	public void setRel(Integer Rel) {
		setAttrVal("Rel", Rel);
	}
	/**
	 * 默认就诊人
	 * @return FBoolean
	 */
	public FBoolean getFg_def() {
		return ((FBoolean) getAttrVal("Fg_def"));
	}	
	/**
	 * 默认就诊人
	 * @param Fg_def
	 */
	public void setFg_def(FBoolean Fg_def) {
		setAttrVal("Fg_def", Fg_def);
	}
	/**
	 * 参保机构代码
	 * @return String
	 */
	public String getInsuredorgcode() {
		return ((String) getAttrVal("Insuredorgcode"));
	}	
	/**
	 * 参保机构代码
	 * @param Insuredorgcode
	 */
	public void setInsuredorgcode(String Insuredorgcode) {
		setAttrVal("Insuredorgcode", Insuredorgcode);
	}
	/**
	 * 患者医保卡号
	 * @return String
	 */
	public String getMedinscode() {
		return ((String) getAttrVal("Medinscode"));
	}	
	/**
	 * 患者医保卡号
	 * @param Medinscode
	 */
	public void setMedinscode(String Medinscode) {
		setAttrVal("Medinscode", Medinscode);
	}
	/**
	 * 微信唯一码
	 * @return String
	 */
	public String getOpenid() {
		return ((String) getAttrVal("Openid"));
	}	
	/**
	 * 微信唯一码
	 * @param Openid
	 */
	public void setOpenid(String Openid) {
		setAttrVal("Openid", Openid);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_id() {
		return ((String) getAttrVal("Code_id"));
	}	
	/**
	 * 编码
	 * @param Code_id
	 */
	public void setCode_id(String Code_id) {
		setAttrVal("Code_id", Code_id);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_id() {
		return ((String) getAttrVal("Name_id"));
	}	
	/**
	 * 名称
	 * @param Name_id
	 */
	public void setName_id(String Name_id) {
		setAttrVal("Name_id", Name_id);
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
		return "Id_pisivxmember";
	}
	
	@Override
	public String getTableName() {	  
		return "pis_ivx_member";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PisIvxMemberDODesc.class);
	}
	
}