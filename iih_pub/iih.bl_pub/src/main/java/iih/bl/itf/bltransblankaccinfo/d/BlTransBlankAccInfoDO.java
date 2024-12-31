package iih.bl.itf.bltransblankaccinfo.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.itf.bltransblankaccinfo.d.desc.BlTransBlankAccInfoDODesc;
import java.math.BigDecimal;

/**
 * 转账信息表 DO数据 
 * 
 */
public class BlTransBlankAccInfoDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//转账信息表主键
	public static final String ID_TRANSBLANKACCINFO= "Id_transblankaccinfo";
	//患者id
	public static final String ID_PAT= "Id_pat";
	//就诊id
	public static final String ID_ENT= "Id_ent";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//就诊类型编码
	public static final String CODE_ENTTP= "Code_enttp";
	//就诊类型id
	public static final String ID_ENTTP= "Id_enttp";
	//转账时间
	public static final String DT_TANSACC= "Dt_tansacc";
	//转账人
	public static final String ID_EMP_TRANSACC= "Id_emp_transacc";
	//转账人所在组织
	public static final String ID_EMP_ORG= "Id_emp_org";
	//转账人所在集团
	public static final String ID_EMP_GRP= "Id_emp_grp";
	//预交金id
	public static final String ID_PREPAY= "Id_prepay";
	//住院收付款明细id
	public static final String ID_PAYITMPATIP= "Id_payitmpatip";
	//转账成功标志
	public static final String FG_SUCC= "Fg_succ";
	//转入账户
	public static final String NO_CC= "No_cc";
	//转入银行名称
	public static final String BANK_NAME= "Bank_name";
	//转入联行号
	public static final String BANK_ID_CODE= "Bank_id_code";
	//转账金额
	public static final String AMT= "Amt";
	//转账入参
	public static final String INPUTINFO= "Inputinfo";
	//转账出参
	public static final String OUTPUTINFO= "Outputinfo";
	//转账流水号
	public static final String TRANSACC_NO= "Transacc_no";
	//患者姓名
	public static final String NAME= "Name";
	//患者编码
	public static final String CODE= "Code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 转账信息表主键
	 * @return String
	 */
	public String getId_transblankaccinfo() {
		return ((String) getAttrVal("Id_transblankaccinfo"));
	}	
	/**
	 * 转账信息表主键
	 * @param Id_transblankaccinfo
	 */
	public void setId_transblankaccinfo(String Id_transblankaccinfo) {
		setAttrVal("Id_transblankaccinfo", Id_transblankaccinfo);
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
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_enttp() {
		return ((String) getAttrVal("Code_enttp"));
	}	
	/**
	 * 就诊类型编码
	 * @param Code_enttp
	 */
	public void setCode_enttp(String Code_enttp) {
		setAttrVal("Code_enttp", Code_enttp);
	}
	/**
	 * 就诊类型id
	 * @return String
	 */
	public String getId_enttp() {
		return ((String) getAttrVal("Id_enttp"));
	}	
	/**
	 * 就诊类型id
	 * @param Id_enttp
	 */
	public void setId_enttp(String Id_enttp) {
		setAttrVal("Id_enttp", Id_enttp);
	}
	/**
	 * 转账时间
	 * @return FDateTime
	 */
	public FDateTime getDt_tansacc() {
		return ((FDateTime) getAttrVal("Dt_tansacc"));
	}	
	/**
	 * 转账时间
	 * @param Dt_tansacc
	 */
	public void setDt_tansacc(FDateTime Dt_tansacc) {
		setAttrVal("Dt_tansacc", Dt_tansacc);
	}
	/**
	 * 转账人
	 * @return String
	 */
	public String getId_emp_transacc() {
		return ((String) getAttrVal("Id_emp_transacc"));
	}	
	/**
	 * 转账人
	 * @param Id_emp_transacc
	 */
	public void setId_emp_transacc(String Id_emp_transacc) {
		setAttrVal("Id_emp_transacc", Id_emp_transacc);
	}
	/**
	 * 转账人所在组织
	 * @return String
	 */
	public String getId_emp_org() {
		return ((String) getAttrVal("Id_emp_org"));
	}	
	/**
	 * 转账人所在组织
	 * @param Id_emp_org
	 */
	public void setId_emp_org(String Id_emp_org) {
		setAttrVal("Id_emp_org", Id_emp_org);
	}
	/**
	 * 转账人所在集团
	 * @return String
	 */
	public String getId_emp_grp() {
		return ((String) getAttrVal("Id_emp_grp"));
	}	
	/**
	 * 转账人所在集团
	 * @param Id_emp_grp
	 */
	public void setId_emp_grp(String Id_emp_grp) {
		setAttrVal("Id_emp_grp", Id_emp_grp);
	}
	/**
	 * 预交金id
	 * @return String
	 */
	public String getId_prepay() {
		return ((String) getAttrVal("Id_prepay"));
	}	
	/**
	 * 预交金id
	 * @param Id_prepay
	 */
	public void setId_prepay(String Id_prepay) {
		setAttrVal("Id_prepay", Id_prepay);
	}
	/**
	 * 住院收付款明细id
	 * @return String
	 */
	public String getId_payitmpatip() {
		return ((String) getAttrVal("Id_payitmpatip"));
	}	
	/**
	 * 住院收付款明细id
	 * @param Id_payitmpatip
	 */
	public void setId_payitmpatip(String Id_payitmpatip) {
		setAttrVal("Id_payitmpatip", Id_payitmpatip);
	}
	/**
	 * 转账成功标志
	 * @return FBoolean
	 */
	public FBoolean getFg_succ() {
		return ((FBoolean) getAttrVal("Fg_succ"));
	}	
	/**
	 * 转账成功标志
	 * @param Fg_succ
	 */
	public void setFg_succ(FBoolean Fg_succ) {
		setAttrVal("Fg_succ", Fg_succ);
	}
	/**
	 * 转入账户
	 * @return String
	 */
	public String getNo_cc() {
		return ((String) getAttrVal("No_cc"));
	}	
	/**
	 * 转入账户
	 * @param No_cc
	 */
	public void setNo_cc(String No_cc) {
		setAttrVal("No_cc", No_cc);
	}
	/**
	 * 转入银行名称
	 * @return String
	 */
	public String getBank_name() {
		return ((String) getAttrVal("Bank_name"));
	}	
	/**
	 * 转入银行名称
	 * @param Bank_name
	 */
	public void setBank_name(String Bank_name) {
		setAttrVal("Bank_name", Bank_name);
	}
	/**
	 * 转入联行号
	 * @return String
	 */
	public String getBank_id_code() {
		return ((String) getAttrVal("Bank_id_code"));
	}	
	/**
	 * 转入联行号
	 * @param Bank_id_code
	 */
	public void setBank_id_code(String Bank_id_code) {
		setAttrVal("Bank_id_code", Bank_id_code);
	}
	/**
	 * 转账金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	/**
	 * 转账金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 转账入参
	 * @return String
	 */
	public String getInputinfo() {
		return ((String) getAttrVal("Inputinfo"));
	}	
	/**
	 * 转账入参
	 * @param Inputinfo
	 */
	public void setInputinfo(String Inputinfo) {
		setAttrVal("Inputinfo", Inputinfo);
	}
	/**
	 * 转账出参
	 * @return String
	 */
	public String getOutputinfo() {
		return ((String) getAttrVal("Outputinfo"));
	}	
	/**
	 * 转账出参
	 * @param Outputinfo
	 */
	public void setOutputinfo(String Outputinfo) {
		setAttrVal("Outputinfo", Outputinfo);
	}
	/**
	 * 转账流水号
	 * @return String
	 */
	public String getTransacc_no() {
		return ((String) getAttrVal("Transacc_no"));
	}	
	/**
	 * 转账流水号
	 * @param Transacc_no
	 */
	public void setTransacc_no(String Transacc_no) {
		setAttrVal("Transacc_no", Transacc_no);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 患者姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 患者编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
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
		return "Id_transblankaccinfo";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_transBlankAcc_info";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlTransBlankAccInfoDODesc.class);
	}
	
}