package iih.bl.itf.bltranscall.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.itf.bltranscall.d.desc.BlTransCalledRcdDODesc;
import java.math.BigDecimal;

/**
 * 费用对外交易接口调用日志 DO数据 
 * 
 */
public class BlTransCalledRcdDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//费用交易调用记录id
	public static final String ID_TRANSCALL= "Id_transcall";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//接口业务类型
	public static final String EU_ITFTP= "Eu_itftp";
	//患者id
	public static final String ID_PAT= "Id_pat";
	//就诊id
	public static final String ID_ENT= "Id_ent";
	//就诊类型
	public static final String CODE_ENTTP= "Code_enttp";
	//支付主键
	public static final String ID_PAY= "Id_pay";
	//付款方式
	public static final String ID_PM= "Id_pm";
	//交易凭证号
	public static final String VOUCHER_NO= "Voucher_no";
	//第三方交易订单号
	public static final String ORDER_NO= "Order_no";
	//交易成功标识
	public static final String FG_SUCCESS= "Fg_success";
	//交易异常信息
	public static final String ERROR_MSG= "Error_msg";
	//入参
	public static final String INPUT= "Input";
	//出参
	public static final String OUTPUT= "Output";
	//操作人员
	public static final String ID_EMP_OPER= "Id_emp_oper";
	//操作时间
	public static final String DT_OPER= "Dt_oper";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//患者姓名
	public static final String NAME_PI= "Name_pi";
	//患者编码
	public static final String CODE_PI= "Code_pi";
	//付款方式名称
	public static final String NAME_PM= "Name_pm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 费用交易调用记录id
	 * @return String
	 */
	public String getId_transcall() {
		return ((String) getAttrVal("Id_transcall"));
	}	
	/**
	 * 费用交易调用记录id
	 * @param Id_transcall
	 */
	public void setId_transcall(String Id_transcall) {
		setAttrVal("Id_transcall", Id_transcall);
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
	 * 接口业务类型
	 * @return Integer
	 */
	public Integer getEu_itftp() {
		return ((Integer) getAttrVal("Eu_itftp"));
	}	
	/**
	 * 接口业务类型
	 * @param Eu_itftp
	 */
	public void setEu_itftp(Integer Eu_itftp) {
		setAttrVal("Eu_itftp", Eu_itftp);
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
	 * 就诊类型
	 * @return String
	 */
	public String getCode_enttp() {
		return ((String) getAttrVal("Code_enttp"));
	}	
	/**
	 * 就诊类型
	 * @param Code_enttp
	 */
	public void setCode_enttp(String Code_enttp) {
		setAttrVal("Code_enttp", Code_enttp);
	}
	/**
	 * 支付主键
	 * @return String
	 */
	public String getId_pay() {
		return ((String) getAttrVal("Id_pay"));
	}	
	/**
	 * 支付主键
	 * @param Id_pay
	 */
	public void setId_pay(String Id_pay) {
		setAttrVal("Id_pay", Id_pay);
	}
	/**
	 * 付款方式
	 * @return String
	 */
	public String getId_pm() {
		return ((String) getAttrVal("Id_pm"));
	}	
	/**
	 * 付款方式
	 * @param Id_pm
	 */
	public void setId_pm(String Id_pm) {
		setAttrVal("Id_pm", Id_pm);
	}
	/**
	 * 交易凭证号
	 * @return String
	 */
	public String getVoucher_no() {
		return ((String) getAttrVal("Voucher_no"));
	}	
	/**
	 * 交易凭证号
	 * @param Voucher_no
	 */
	public void setVoucher_no(String Voucher_no) {
		setAttrVal("Voucher_no", Voucher_no);
	}
	/**
	 * 第三方交易订单号
	 * @return String
	 */
	public String getOrder_no() {
		return ((String) getAttrVal("Order_no"));
	}	
	/**
	 * 第三方交易订单号
	 * @param Order_no
	 */
	public void setOrder_no(String Order_no) {
		setAttrVal("Order_no", Order_no);
	}
	/**
	 * 交易成功标识
	 * @return FBoolean
	 */
	public FBoolean getFg_success() {
		return ((FBoolean) getAttrVal("Fg_success"));
	}	
	/**
	 * 交易成功标识
	 * @param Fg_success
	 */
	public void setFg_success(FBoolean Fg_success) {
		setAttrVal("Fg_success", Fg_success);
	}
	/**
	 * 交易异常信息
	 * @return String
	 */
	public String getError_msg() {
		return ((String) getAttrVal("Error_msg"));
	}	
	/**
	 * 交易异常信息
	 * @param Error_msg
	 */
	public void setError_msg(String Error_msg) {
		setAttrVal("Error_msg", Error_msg);
	}
	/**
	 * 入参
	 * @return String
	 */
	public String getInput() {
		return ((String) getAttrVal("Input"));
	}	
	/**
	 * 入参
	 * @param Input
	 */
	public void setInput(String Input) {
		setAttrVal("Input", Input);
	}
	/**
	 * 出参
	 * @return String
	 */
	public String getOutput() {
		return ((String) getAttrVal("Output"));
	}	
	/**
	 * 出参
	 * @param Output
	 */
	public void setOutput(String Output) {
		setAttrVal("Output", Output);
	}
	/**
	 * 操作人员
	 * @return String
	 */
	public String getId_emp_oper() {
		return ((String) getAttrVal("Id_emp_oper"));
	}	
	/**
	 * 操作人员
	 * @param Id_emp_oper
	 */
	public void setId_emp_oper(String Id_emp_oper) {
		setAttrVal("Id_emp_oper", Id_emp_oper);
	}
	/**
	 * 操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_oper() {
		return ((FDateTime) getAttrVal("Dt_oper"));
	}	
	/**
	 * 操作时间
	 * @param Dt_oper
	 */
	public void setDt_oper(FDateTime Dt_oper) {
		setAttrVal("Dt_oper", Dt_oper);
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
	 * 患者姓名
	 * @return String
	 */
	public String getName_pi() {
		return ((String) getAttrVal("Name_pi"));
	}	
	/**
	 * 患者姓名
	 * @param Name_pi
	 */
	public void setName_pi(String Name_pi) {
		setAttrVal("Name_pi", Name_pi);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pi() {
		return ((String) getAttrVal("Code_pi"));
	}	
	/**
	 * 患者编码
	 * @param Code_pi
	 */
	public void setCode_pi(String Code_pi) {
		setAttrVal("Code_pi", Code_pi);
	}
	/**
	 * 付款方式名称
	 * @return String
	 */
	public String getName_pm() {
		return ((String) getAttrVal("Name_pm"));
	}	
	/**
	 * 付款方式名称
	 * @param Name_pm
	 */
	public void setName_pm(String Name_pm) {
		setAttrVal("Name_pm", Name_pm);
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
		return "Id_transcall";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_trans_call_rcd";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlTransCalledRcdDODesc.class);
	}
	
}