package iih.pis.mbw.pismbwpat.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pis.mbw.pismbwpat.d.desc.PisMbwPatDODesc;
import java.math.BigDecimal;

/**
 * 就诊患者 DO数据 
 * 
 */
public class PisMbwPatDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//患者用户id
	public static final String ID_MBW_PAT= "Id_mbw_pat";
	//用户外键
	public static final String ID_MBW_USER= "Id_mbw_user";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//患者id
	public static final String ID_PAT= "Id_pat";
	//患者编码
	public static final String CODE_PAT= "Code_pat";
	//就诊编码
	public static final String CODE_ENT= "Code_ent";
	//患者名称
	public static final String NAME_PAT= "Name_pat";
	//电话号
	public static final String TEL= "Tel";
	//与本人关系
	public static final String RELATENUM= "Relatenum";
	//电子就诊卡
	public static final String ECORD= "Ecord";
	//证件类型编码
	public static final String SD_CARDTP= "Sd_cardtp";
	//证件号
	public static final String ID_NUMBER= "Id_number";
	//证件正面
	public static final String PROS_CARD= "Pros_card";
	//证件反面
	public static final String CONS_CARD= "Cons_card";
	//默认就诊人
	public static final String FG_DEFENT= "Fg_defent";
	//出生日期
	public static final String DT_BRITH= "Dt_brith";
	//性别
	public static final String SD_SEX= "Sd_sex";
	//序号
	public static final String SORTNO= "Sortno";
	//说明
	public static final String DES= "Des";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//名称
	public static final String NAME_GRP= "Name_grp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 患者用户id
	 * @return String
	 */
	public String getId_mbw_pat() {
		return ((String) getAttrVal("Id_mbw_pat"));
	}	
	/**
	 * 患者用户id
	 * @param Id_mbw_pat
	 */
	public void setId_mbw_pat(String Id_mbw_pat) {
		setAttrVal("Id_mbw_pat", Id_mbw_pat);
	}
	/**
	 * 用户外键
	 * @return String
	 */
	public String getId_mbw_user() {
		return ((String) getAttrVal("Id_mbw_user"));
	}	
	/**
	 * 用户外键
	 * @param Id_mbw_user
	 */
	public void setId_mbw_user(String Id_mbw_user) {
		setAttrVal("Id_mbw_user", Id_mbw_user);
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
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}	
	/**
	 * 就诊编码
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 患者名称
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 患者名称
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 电话号
	 * @return String
	 */
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}	
	/**
	 * 电话号
	 * @param Tel
	 */
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	/**
	 * 与本人关系
	 * @return String
	 */
	public String getRelatenum() {
		return ((String) getAttrVal("Relatenum"));
	}	
	/**
	 * 与本人关系
	 * @param Relatenum
	 */
	public void setRelatenum(String Relatenum) {
		setAttrVal("Relatenum", Relatenum);
	}
	/**
	 * 电子就诊卡
	 * @return String
	 */
	public String getEcord() {
		return ((String) getAttrVal("Ecord"));
	}	
	/**
	 * 电子就诊卡
	 * @param Ecord
	 */
	public void setEcord(String Ecord) {
		setAttrVal("Ecord", Ecord);
	}
	/**
	 * 证件类型编码
	 * @return String
	 */
	public String getSd_cardtp() {
		return ((String) getAttrVal("Sd_cardtp"));
	}	
	/**
	 * 证件类型编码
	 * @param Sd_cardtp
	 */
	public void setSd_cardtp(String Sd_cardtp) {
		setAttrVal("Sd_cardtp", Sd_cardtp);
	}
	/**
	 * 证件号
	 * @return String
	 */
	public String getId_number() {
		return ((String) getAttrVal("Id_number"));
	}	
	/**
	 * 证件号
	 * @param Id_number
	 */
	public void setId_number(String Id_number) {
		setAttrVal("Id_number", Id_number);
	}
	/**
	 * 证件正面
	 * @return String
	 */
	public String getPros_card() {
		return ((String) getAttrVal("Pros_card"));
	}	
	/**
	 * 证件正面
	 * @param Pros_card
	 */
	public void setPros_card(String Pros_card) {
		setAttrVal("Pros_card", Pros_card);
	}
	/**
	 * 证件反面
	 * @return String
	 */
	public String getCons_card() {
		return ((String) getAttrVal("Cons_card"));
	}	
	/**
	 * 证件反面
	 * @param Cons_card
	 */
	public void setCons_card(String Cons_card) {
		setAttrVal("Cons_card", Cons_card);
	}
	/**
	 * 默认就诊人
	 * @return FBoolean
	 */
	public FBoolean getFg_defent() {
		return ((FBoolean) getAttrVal("Fg_defent"));
	}	
	/**
	 * 默认就诊人
	 * @param Fg_defent
	 */
	public void setFg_defent(FBoolean Fg_defent) {
		setAttrVal("Fg_defent", Fg_defent);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_brith() {
		return ((FDate) getAttrVal("Dt_brith"));
	}	
	/**
	 * 出生日期
	 * @param Dt_brith
	 */
	public void setDt_brith(FDate Dt_brith) {
		setAttrVal("Dt_brith", Dt_brith);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}	
	/**
	 * 性别
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 序号
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 说明
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 说明
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
		return "Id_mbw_pat";
	}
	
	@Override
	public String getTableName() {	  
		return "PIS_mbw_pat";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PisMbwPatDODesc.class);
	}
	
}