package iih.en.pv.enfee.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.enfee.d.desc.EnAccountDODesc;
import java.math.BigDecimal;

/**
 * 患者就诊_就诊账户 DO数据 
 * 
 */
public class EnAccountDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//患者就诊账户主键
	public static final String ID_ENTACC= "Id_entacc";
	//患者就诊
	public static final String ID_ENT= "Id_ent";
	//患者
	public static final String ID_PAT= "Id_pat";
	//信用额度
	public static final String AMT_CRED= "Amt_cred";
	//就诊预交金
	public static final String AMT_PREPAY= "Amt_prepay";
	//就诊未结算费用
	public static final String AMT_UNCG= "Amt_uncg";
	//欠费下限
	public static final String AMT_OWELIMIT= "Amt_owelimit";
	//后台划价截止日期
	public static final String DT_BACKCG= "Dt_backcg";
	//后台划价最后操作日期
	public static final String DT_BACKCGLASTACT= "Dt_backcglastact";
	//封账标志
	public static final String FG_FREEZE= "Fg_freeze";
	//机构
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//可报销医保额度
	public static final String AMT_HP= "Amt_hp";
	//总费用
	public static final String AMT_TOTAL= "Amt_total";
	//患者编码
	public static final String PAT_CODE= "Pat_code";
	//患者姓名
	public static final String PAT_NAME= "Pat_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 患者就诊账户主键
	 * @return String
	 */
	public String getId_entacc() {
		return ((String) getAttrVal("Id_entacc"));
	}	
	/**
	 * 患者就诊账户主键
	 * @param Id_entacc
	 */
	public void setId_entacc(String Id_entacc) {
		setAttrVal("Id_entacc", Id_entacc);
	}
	/**
	 * 患者就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 患者就诊
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	 * 信用额度
	 * @return FDouble
	 */
	public FDouble getAmt_cred() {
		return ((FDouble) getAttrVal("Amt_cred"));
	}	
	/**
	 * 信用额度
	 * @param Amt_cred
	 */
	public void setAmt_cred(FDouble Amt_cred) {
		setAttrVal("Amt_cred", Amt_cred);
	}
	/**
	 * 就诊预交金
	 * @return FDouble
	 */
	public FDouble getAmt_prepay() {
		return ((FDouble) getAttrVal("Amt_prepay"));
	}	
	/**
	 * 就诊预交金
	 * @param Amt_prepay
	 */
	public void setAmt_prepay(FDouble Amt_prepay) {
		setAttrVal("Amt_prepay", Amt_prepay);
	}
	/**
	 * 就诊未结算费用
	 * @return FDouble
	 */
	public FDouble getAmt_uncg() {
		return ((FDouble) getAttrVal("Amt_uncg"));
	}	
	/**
	 * 就诊未结算费用
	 * @param Amt_uncg
	 */
	public void setAmt_uncg(FDouble Amt_uncg) {
		setAttrVal("Amt_uncg", Amt_uncg);
	}
	/**
	 * 欠费下限
	 * @return FDouble
	 */
	public FDouble getAmt_owelimit() {
		return ((FDouble) getAttrVal("Amt_owelimit"));
	}	
	/**
	 * 欠费下限
	 * @param Amt_owelimit
	 */
	public void setAmt_owelimit(FDouble Amt_owelimit) {
		setAttrVal("Amt_owelimit", Amt_owelimit);
	}
	/**
	 * 后台划价截止日期
	 * @return FDateTime
	 */
	public FDateTime getDt_backcg() {
		return ((FDateTime) getAttrVal("Dt_backcg"));
	}	
	/**
	 * 后台划价截止日期
	 * @param Dt_backcg
	 */
	public void setDt_backcg(FDateTime Dt_backcg) {
		setAttrVal("Dt_backcg", Dt_backcg);
	}
	/**
	 * 后台划价最后操作日期
	 * @return FDateTime
	 */
	public FDateTime getDt_backcglastact() {
		return ((FDateTime) getAttrVal("Dt_backcglastact"));
	}	
	/**
	 * 后台划价最后操作日期
	 * @param Dt_backcglastact
	 */
	public void setDt_backcglastact(FDateTime Dt_backcglastact) {
		setAttrVal("Dt_backcglastact", Dt_backcglastact);
	}
	/**
	 * 封账标志
	 * @return FBoolean
	 */
	public FBoolean getFg_freeze() {
		return ((FBoolean) getAttrVal("Fg_freeze"));
	}	
	/**
	 * 封账标志
	 * @param Fg_freeze
	 */
	public void setFg_freeze(FBoolean Fg_freeze) {
		setAttrVal("Fg_freeze", Fg_freeze);
	}
	/**
	 * 机构
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 机构
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
	 * 可报销医保额度
	 * @return FDouble
	 */
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}	
	/**
	 * 可报销医保额度
	 * @param Amt_hp
	 */
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
	}
	/**
	 * 总费用
	 * @return FDouble
	 */
	public FDouble getAmt_total() {
		return ((FDouble) getAttrVal("Amt_total"));
	}	
	/**
	 * 总费用
	 * @param Amt_total
	 */
	public void setAmt_total(FDouble Amt_total) {
		setAttrVal("Amt_total", Amt_total);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getPat_code() {
		return ((String) getAttrVal("Pat_code"));
	}	
	/**
	 * 患者编码
	 * @param Pat_code
	 */
	public void setPat_code(String Pat_code) {
		setAttrVal("Pat_code", Pat_code);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}	
	/**
	 * 患者姓名
	 * @param Pat_name
	 */
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
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
		return "Id_entacc";
	}
	
	@Override
	public String getTableName() {	  
		return "en_ent_acc";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EnAccountDODesc.class);
	}
	
}