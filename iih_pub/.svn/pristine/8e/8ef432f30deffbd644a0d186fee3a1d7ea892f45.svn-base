package iih.mi.biz.mihporsharelog.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mi.biz.mihporsharelog.d.desc.MiHpOrShareLogDODesc;
import java.math.BigDecimal;

/**
 * 医保共享日志 DO数据 
 * 
 */
public class MiHpOrShareLogDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医嘱信息共享消息主键
	public static final String ID_HPORSHARELOG= "Id_hporsharelog";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//患者
	public static final String ID_PAT= "Id_pat";
	//医保号
	public static final String CODE_HP= "Code_hp";
	//消息传输日期
	public static final String DT_MESSAGE= "Dt_message";
	//医保输人参数
	public static final String INPUTINFO= "Inputinfo";
	//医保输出参数
	public static final String OUTPUTINFO= "Outputinfo";
	//患者姓名
	public static final String NAME_PAT= "Name_pat";
	//患者编码
	public static final String CODE_PAT= "Code_pat";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医嘱信息共享消息主键
	 * @return String
	 */
	public String getId_hporsharelog() {
		return ((String) getAttrVal("Id_hporsharelog"));
	}	
	/**
	 * 医嘱信息共享消息主键
	 * @param Id_hporsharelog
	 */
	public void setId_hporsharelog(String Id_hporsharelog) {
		setAttrVal("Id_hporsharelog", Id_hporsharelog);
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
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 医保号
	 * @return String
	 */
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}	
	/**
	 * 医保号
	 * @param Code_hp
	 */
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	/**
	 * 消息传输日期
	 * @return FDateTime
	 */
	public FDateTime getDt_message() {
		return ((FDateTime) getAttrVal("Dt_message"));
	}	
	/**
	 * 消息传输日期
	 * @param Dt_message
	 */
	public void setDt_message(FDateTime Dt_message) {
		setAttrVal("Dt_message", Dt_message);
	}
	/**
	 * 医保输人参数
	 * @return String
	 */
	public String getInputinfo() {
		return ((String) getAttrVal("Inputinfo"));
	}	
	/**
	 * 医保输人参数
	 * @param Inputinfo
	 */
	public void setInputinfo(String Inputinfo) {
		setAttrVal("Inputinfo", Inputinfo);
	}
	/**
	 * 医保输出参数
	 * @return String
	 */
	public String getOutputinfo() {
		return ((String) getAttrVal("Outputinfo"));
	}	
	/**
	 * 医保输出参数
	 * @param Outputinfo
	 */
	public void setOutputinfo(String Outputinfo) {
		setAttrVal("Outputinfo", Outputinfo);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
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
		return "Id_hporsharelog";
	}
	
	@Override
	public String getTableName() {	  
		return "MI_OR_SHARE_LOG";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MiHpOrShareLogDODesc.class);
	}
	
}