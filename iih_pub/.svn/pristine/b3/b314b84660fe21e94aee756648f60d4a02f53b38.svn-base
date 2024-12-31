package iih.pis.ivx.pisivxnotice.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pis.ivx.pisivxnotice.d.desc.PisIvxNoticeDODesc;
import java.math.BigDecimal;

/**
 * 微信服务-通知 DO数据 
 * 
 */
public class PisIvxNoticeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//微信通知主键标识
	public static final String ID_PISIVXNOTICE= "Id_pisivxnotice";
	//微信服务通知类型ID
	public static final String ID_PISIVXSETTINGTEMPLATE= "Id_pisivxsettingtemplate";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//通知内容
	public static final String NOTICE= "Notice";
	//通知时间
	public static final String TM_NOTICE= "Tm_notice";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//链接地址
	public static final String LINKURL= "Linkurl";
	//微信账户ID
	public static final String ID_PISIVXACCOUNT= "Id_pisivxaccount";
	//微信就诊人ID
	public static final String ID_PISIVXMEMBER= "Id_pisivxmember";
	//就诊记录ID
	public static final String ID_PISIVXENT= "Id_pisivxent";
	//阅读标识
	public static final String FG_READ= "Fg_read";
	//姓名
	public static final String NAME_PAT= "Name_pat";
	//门诊就诊次数
	public static final String OPTIMES= "Optimes";
	//住院就诊次数
	public static final String IPTIMES= "Iptimes";
	//接诊时间
	public static final String DTACPT= "Dtacpt";
	//就诊ID
	public static final String ENTID= "Entid";
	//就诊类型
	public static final String ENTPCODE= "Entpcode";
	//患者姓名
	public static final String PATNAME= "Patname";
	//就诊科室
	public static final String PHYDEPID= "Phydepid";
	//就诊科室编码
	public static final String PHYDEPCODE= "Phydepcode";
	//状态
	public static final String STATUSCODE= "Statuscode";
	//患者编码
	public static final String PATCODE= "Patcode";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 微信通知主键标识
	 * @return String
	 */
	public String getId_pisivxnotice() {
		return ((String) getAttrVal("Id_pisivxnotice"));
	}	
	/**
	 * 微信通知主键标识
	 * @param Id_pisivxnotice
	 */
	public void setId_pisivxnotice(String Id_pisivxnotice) {
		setAttrVal("Id_pisivxnotice", Id_pisivxnotice);
	}
	/**
	 * 微信服务通知类型ID
	 * @return String
	 */
	public String getId_pisivxsettingtemplate() {
		return ((String) getAttrVal("Id_pisivxsettingtemplate"));
	}	
	/**
	 * 微信服务通知类型ID
	 * @param Id_pisivxsettingtemplate
	 */
	public void setId_pisivxsettingtemplate(String Id_pisivxsettingtemplate) {
		setAttrVal("Id_pisivxsettingtemplate", Id_pisivxsettingtemplate);
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
	 * 通知内容
	 * @return String
	 */
	public String getNotice() {
		return ((String) getAttrVal("Notice"));
	}	
	/**
	 * 通知内容
	 * @param Notice
	 */
	public void setNotice(String Notice) {
		setAttrVal("Notice", Notice);
	}
	/**
	 * 通知时间
	 * @return FDateTime
	 */
	public FDateTime getTm_notice() {
		return ((FDateTime) getAttrVal("Tm_notice"));
	}	
	/**
	 * 通知时间
	 * @param Tm_notice
	 */
	public void setTm_notice(FDateTime Tm_notice) {
		setAttrVal("Tm_notice", Tm_notice);
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
	 * 链接地址
	 * @return String
	 */
	public String getLinkurl() {
		return ((String) getAttrVal("Linkurl"));
	}	
	/**
	 * 链接地址
	 * @param Linkurl
	 */
	public void setLinkurl(String Linkurl) {
		setAttrVal("Linkurl", Linkurl);
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
	 * 微信就诊人ID
	 * @return String
	 */
	public String getId_pisivxmember() {
		return ((String) getAttrVal("Id_pisivxmember"));
	}	
	/**
	 * 微信就诊人ID
	 * @param Id_pisivxmember
	 */
	public void setId_pisivxmember(String Id_pisivxmember) {
		setAttrVal("Id_pisivxmember", Id_pisivxmember);
	}
	/**
	 * 就诊记录ID
	 * @return String
	 */
	public String getId_pisivxent() {
		return ((String) getAttrVal("Id_pisivxent"));
	}	
	/**
	 * 就诊记录ID
	 * @param Id_pisivxent
	 */
	public void setId_pisivxent(String Id_pisivxent) {
		setAttrVal("Id_pisivxent", Id_pisivxent);
	}
	/**
	 * 阅读标识
	 * @return FBoolean
	 */
	public FBoolean getFg_read() {
		return ((FBoolean) getAttrVal("Fg_read"));
	}	
	/**
	 * 阅读标识
	 * @param Fg_read
	 */
	public void setFg_read(FBoolean Fg_read) {
		setAttrVal("Fg_read", Fg_read);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 门诊就诊次数
	 * @return Integer
	 */
	public Integer getOptimes() {
		return ((Integer) getAttrVal("Optimes"));
	}	
	/**
	 * 门诊就诊次数
	 * @param Optimes
	 */
	public void setOptimes(Integer Optimes) {
		setAttrVal("Optimes", Optimes);
	}
	/**
	 * 住院就诊次数
	 * @return Integer
	 */
	public Integer getIptimes() {
		return ((Integer) getAttrVal("Iptimes"));
	}	
	/**
	 * 住院就诊次数
	 * @param Iptimes
	 */
	public void setIptimes(Integer Iptimes) {
		setAttrVal("Iptimes", Iptimes);
	}
	/**
	 * 接诊时间
	 * @return FDateTime
	 */
	public FDateTime getDtacpt() {
		return ((FDateTime) getAttrVal("Dtacpt"));
	}	
	/**
	 * 接诊时间
	 * @param Dtacpt
	 */
	public void setDtacpt(FDateTime Dtacpt) {
		setAttrVal("Dtacpt", Dtacpt);
	}
	/**
	 * 就诊ID
	 * @return String
	 */
	public String getEntid() {
		return ((String) getAttrVal("Entid"));
	}	
	/**
	 * 就诊ID
	 * @param Entid
	 */
	public void setEntid(String Entid) {
		setAttrVal("Entid", Entid);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getEntpcode() {
		return ((String) getAttrVal("Entpcode"));
	}	
	/**
	 * 就诊类型
	 * @param Entpcode
	 */
	public void setEntpcode(String Entpcode) {
		setAttrVal("Entpcode", Entpcode);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPatname() {
		return ((String) getAttrVal("Patname"));
	}	
	/**
	 * 患者姓名
	 * @param Patname
	 */
	public void setPatname(String Patname) {
		setAttrVal("Patname", Patname);
	}
	/**
	 * 就诊科室
	 * @return String
	 */
	public String getPhydepid() {
		return ((String) getAttrVal("Phydepid"));
	}	
	/**
	 * 就诊科室
	 * @param Phydepid
	 */
	public void setPhydepid(String Phydepid) {
		setAttrVal("Phydepid", Phydepid);
	}
	/**
	 * 就诊科室编码
	 * @return String
	 */
	public String getPhydepcode() {
		return ((String) getAttrVal("Phydepcode"));
	}	
	/**
	 * 就诊科室编码
	 * @param Phydepcode
	 */
	public void setPhydepcode(String Phydepcode) {
		setAttrVal("Phydepcode", Phydepcode);
	}
	/**
	 * 状态
	 * @return String
	 */
	public String getStatuscode() {
		return ((String) getAttrVal("Statuscode"));
	}	
	/**
	 * 状态
	 * @param Statuscode
	 */
	public void setStatuscode(String Statuscode) {
		setAttrVal("Statuscode", Statuscode);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getPatcode() {
		return ((String) getAttrVal("Patcode"));
	}	
	/**
	 * 患者编码
	 * @param Patcode
	 */
	public void setPatcode(String Patcode) {
		setAttrVal("Patcode", Patcode);
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
		return "Id_pisivxnotice";
	}
	
	@Override
	public String getTableName() {	  
		return "pis_ivx_notice";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PisIvxNoticeDODesc.class);
	}
	
}