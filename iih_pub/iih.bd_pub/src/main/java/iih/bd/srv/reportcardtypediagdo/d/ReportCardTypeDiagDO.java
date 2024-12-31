package iih.bd.srv.reportcardtypediagdo.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.reportcardtypediagdo.d.desc.ReportCardTypeDiagDODesc;
import java.math.BigDecimal;

/**
 * 报卡类型关联诊断 DO数据 
 * 
 */
public class ReportCardTypeDiagDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//主键
	public static final String IDBDRCMTPDIAG= "Idbdrcmtpdiag";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//报卡类型外键
	public static final String ID_BD_RCM_TP= "Id_bd_rcm_tp";
	//诊断外键
	public static final String ID_DI= "Id_di";
	//诊断编码
	public static final String CODE_DIAG= "Code_diag";
	//诊断名称
	public static final String NAME_DIAG= "Name_diag";
	//显示序号
	public static final String SORTNO= "Sortno";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//是否提醒填写报卡
	public static final String FG_REMIND= "Fg_remind";
	//报卡类型名称
	public static final String NAME_TYPE= "Name_type";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 主键
	 * @return String
	 */
	public String getIdbdrcmtpdiag() {
		return ((String) getAttrVal("Idbdrcmtpdiag"));
	}	
	/**
	 * 主键
	 * @param Idbdrcmtpdiag
	 */
	public void setIdbdrcmtpdiag(String Idbdrcmtpdiag) {
		setAttrVal("Idbdrcmtpdiag", Idbdrcmtpdiag);
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
	 * 报卡类型外键
	 * @return String
	 */
	public String getId_bd_rcm_tp() {
		return ((String) getAttrVal("Id_bd_rcm_tp"));
	}	
	/**
	 * 报卡类型外键
	 * @param Id_bd_rcm_tp
	 */
	public void setId_bd_rcm_tp(String Id_bd_rcm_tp) {
		setAttrVal("Id_bd_rcm_tp", Id_bd_rcm_tp);
	}
	/**
	 * 诊断外键
	 * @return String
	 */
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}	
	/**
	 * 诊断外键
	 * @param Id_di
	 */
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getCode_diag() {
		return ((String) getAttrVal("Code_diag"));
	}	
	/**
	 * 诊断编码
	 * @param Code_diag
	 */
	public void setCode_diag(String Code_diag) {
		setAttrVal("Code_diag", Code_diag);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName_diag() {
		return ((String) getAttrVal("Name_diag"));
	}	
	/**
	 * 诊断名称
	 * @param Name_diag
	 */
	public void setName_diag(String Name_diag) {
		setAttrVal("Name_diag", Name_diag);
	}
	/**
	 * 显示序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 显示序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
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
	 * 是否提醒填写报卡
	 * @return FBoolean
	 */
	public FBoolean getFg_remind() {
		return ((FBoolean) getAttrVal("Fg_remind"));
	}	
	/**
	 * 是否提醒填写报卡
	 * @param Fg_remind
	 */
	public void setFg_remind(FBoolean Fg_remind) {
		setAttrVal("Fg_remind", Fg_remind);
	}
	/**
	 * 报卡类型名称
	 * @return String
	 */
	public String getName_type() {
		return ((String) getAttrVal("Name_type"));
	}	
	/**
	 * 报卡类型名称
	 * @param Name_type
	 */
	public void setName_type(String Name_type) {
		setAttrVal("Name_type", Name_type);
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
		return "Idbdrcmtpdiag";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_rcm_tp_diag";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ReportCardTypeDiagDODesc.class);
	}
	
}