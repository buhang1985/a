package iih.pis.ivx.pisivxfeedback.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pis.ivx.pisivxfeedback.d.desc.PisivxFeedbackDODesc;
import java.math.BigDecimal;

/**
 * 微信服务号需求反馈 DO数据 
 * 
 */
public class PisivxFeedbackDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//微信服务号患者反馈主键标识
	public static final String ID_PISIVXFEEDBACK= "Id_pisivxfeedback";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//就诊人ID
	public static final String ID_PISIVXMEMBER= "Id_pisivxmember";
	//微信账户ID
	public static final String ID_PISIVXACCOUNT= "Id_pisivxaccount";
	//反馈内容
	public static final String FEEDBACK= "Feedback";
	//反馈日期
	public static final String DT_FD= "Dt_fd";
	//姓名
	public static final String NAME_PAT= "Name_pat";
	//年龄
	public static final String AGE= "Age";
	//移动电话
	public static final String MOB= "Mob";
	//性别
	public static final String NAME_SEX= "Name_sex";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 微信服务号患者反馈主键标识
	 * @return String
	 */
	public String getId_pisivxfeedback() {
		return ((String) getAttrVal("Id_pisivxfeedback"));
	}	
	/**
	 * 微信服务号患者反馈主键标识
	 * @param Id_pisivxfeedback
	 */
	public void setId_pisivxfeedback(String Id_pisivxfeedback) {
		setAttrVal("Id_pisivxfeedback", Id_pisivxfeedback);
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
	 * 就诊人ID
	 * @return String
	 */
	public String getId_pisivxmember() {
		return ((String) getAttrVal("Id_pisivxmember"));
	}	
	/**
	 * 就诊人ID
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
	 * 反馈内容
	 * @return String
	 */
	public String getFeedback() {
		return ((String) getAttrVal("Feedback"));
	}	
	/**
	 * 反馈内容
	 * @param Feedback
	 */
	public void setFeedback(String Feedback) {
		setAttrVal("Feedback", Feedback);
	}
	/**
	 * 反馈日期
	 * @return FDateTime
	 */
	public FDateTime getDt_fd() {
		return ((FDateTime) getAttrVal("Dt_fd"));
	}	
	/**
	 * 反馈日期
	 * @param Dt_fd
	 */
	public void setDt_fd(FDateTime Dt_fd) {
		setAttrVal("Dt_fd", Dt_fd);
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
		return "Id_pisivxfeedback";
	}
	
	@Override
	public String getTableName() {	  
		return "pis_ivx_feedback";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PisivxFeedbackDODesc.class);
	}
	
}