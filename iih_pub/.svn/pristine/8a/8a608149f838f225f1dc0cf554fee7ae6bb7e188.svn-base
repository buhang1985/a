package iih.bd.pp.pripm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.pripm.d.desc.PriPmDODesc;
import java.math.BigDecimal;

/**
 * 付款方式 DO数据 
 * 
 */
public class PriPmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//付款方式主键
	public static final String ID_PM= "Id_pm";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//付款方式类型
	public static final String ID_PMTP= "Id_pmtp";
	//付款方式类型编码
	public static final String SD_PMTP= "Sd_pmtp";
	//付款方式编码
	public static final String CODE= "Code";
	//付款方式名称
	public static final String NAME= "Name";
	//预交金使用优先级
	public static final String PREPAY_LV= "Prepay_lv";
	//零钱标志
	public static final String FG_SMALLCHG= "Fg_smallchg";
	//可现金返还标志
	public static final String FG_BACKCASH= "Fg_backcash";
	//全部支付标志
	public static final String FG_FULLPAY= "Fg_fullpay";
	//交易号标志
	public static final String FG_PAYNO= "Fg_payno";
	//允许（手工）输入标志
	public static final String FG_ALLOWINP= "Fg_allowinp";
	//描述
	public static final String DES= "Des";
	//系统标志
	public static final String FG_SYS= "Fg_sys";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//五笔
	public static final String WBCODE= "Wbcode";
	//拼音
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//原路全额退回标识
	public static final String FG_ORI_RTN= "Fg_ori_rtn";
	//允许半退标识
	public static final String FG_ORI_PRTRTN= "Fg_ori_prtrtn";
	//允许原路退回标识
	public static final String FG_NATIVE_RTN= "Fg_native_rtn";
	//账户名称标志
	public static final String FG_ACCNAME= "Fg_accname";
	//银行转账标志
	public static final String FG_TRANSBLANKACC= "Fg_transblankacc";
	//付款方式类型
	public static final String PMTP_NAME= "Pmtp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 付款方式主键
	 * @return String
	 */
	public String getId_pm() {
		return ((String) getAttrVal("Id_pm"));
	}	
	/**
	 * 付款方式主键
	 * @param Id_pm
	 */
	public void setId_pm(String Id_pm) {
		setAttrVal("Id_pm", Id_pm);
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
	 * 付款方式类型
	 * @return String
	 */
	public String getId_pmtp() {
		return ((String) getAttrVal("Id_pmtp"));
	}	
	/**
	 * 付款方式类型
	 * @param Id_pmtp
	 */
	public void setId_pmtp(String Id_pmtp) {
		setAttrVal("Id_pmtp", Id_pmtp);
	}
	/**
	 * 付款方式类型编码
	 * @return String
	 */
	public String getSd_pmtp() {
		return ((String) getAttrVal("Sd_pmtp"));
	}	
	/**
	 * 付款方式类型编码
	 * @param Sd_pmtp
	 */
	public void setSd_pmtp(String Sd_pmtp) {
		setAttrVal("Sd_pmtp", Sd_pmtp);
	}
	/**
	 * 付款方式编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 付款方式编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 付款方式名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 付款方式名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 预交金使用优先级
	 * @return Integer
	 */
	public Integer getPrepay_lv() {
		return ((Integer) getAttrVal("Prepay_lv"));
	}	
	/**
	 * 预交金使用优先级
	 * @param Prepay_lv
	 */
	public void setPrepay_lv(Integer Prepay_lv) {
		setAttrVal("Prepay_lv", Prepay_lv);
	}
	/**
	 * 零钱标志
	 * @return FBoolean
	 */
	public FBoolean getFg_smallchg() {
		return ((FBoolean) getAttrVal("Fg_smallchg"));
	}	
	/**
	 * 零钱标志
	 * @param Fg_smallchg
	 */
	public void setFg_smallchg(FBoolean Fg_smallchg) {
		setAttrVal("Fg_smallchg", Fg_smallchg);
	}
	/**
	 * 可现金返还标志
	 * @return FBoolean
	 */
	public FBoolean getFg_backcash() {
		return ((FBoolean) getAttrVal("Fg_backcash"));
	}	
	/**
	 * 可现金返还标志
	 * @param Fg_backcash
	 */
	public void setFg_backcash(FBoolean Fg_backcash) {
		setAttrVal("Fg_backcash", Fg_backcash);
	}
	/**
	 * 全部支付标志
	 * @return FBoolean
	 */
	public FBoolean getFg_fullpay() {
		return ((FBoolean) getAttrVal("Fg_fullpay"));
	}	
	/**
	 * 全部支付标志
	 * @param Fg_fullpay
	 */
	public void setFg_fullpay(FBoolean Fg_fullpay) {
		setAttrVal("Fg_fullpay", Fg_fullpay);
	}
	/**
	 * 交易号标志
	 * @return FBoolean
	 */
	public FBoolean getFg_payno() {
		return ((FBoolean) getAttrVal("Fg_payno"));
	}	
	/**
	 * 交易号标志
	 * @param Fg_payno
	 */
	public void setFg_payno(FBoolean Fg_payno) {
		setAttrVal("Fg_payno", Fg_payno);
	}
	/**
	 * 允许（手工）输入标志
	 * @return FBoolean
	 */
	public FBoolean getFg_allowinp() {
		return ((FBoolean) getAttrVal("Fg_allowinp"));
	}	
	/**
	 * 允许（手工）输入标志
	 * @param Fg_allowinp
	 */
	public void setFg_allowinp(FBoolean Fg_allowinp) {
		setAttrVal("Fg_allowinp", Fg_allowinp);
	}
	/**
	 * 描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 系统标志
	 * @return FBoolean
	 */
	public FBoolean getFg_sys() {
		return ((FBoolean) getAttrVal("Fg_sys"));
	}	
	/**
	 * 系统标志
	 * @param Fg_sys
	 */
	public void setFg_sys(FBoolean Fg_sys) {
		setAttrVal("Fg_sys", Fg_sys);
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
	 * 五笔
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 拼音
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	/**
	 * 助记码
	 * @param Mnecode
	 */
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	/**
	 * 原路全额退回标识
	 * @return FBoolean
	 */
	public FBoolean getFg_ori_rtn() {
		return ((FBoolean) getAttrVal("Fg_ori_rtn"));
	}	
	/**
	 * 原路全额退回标识
	 * @param Fg_ori_rtn
	 */
	public void setFg_ori_rtn(FBoolean Fg_ori_rtn) {
		setAttrVal("Fg_ori_rtn", Fg_ori_rtn);
	}
	/**
	 * 允许半退标识
	 * @return FBoolean
	 */
	public FBoolean getFg_ori_prtrtn() {
		return ((FBoolean) getAttrVal("Fg_ori_prtrtn"));
	}	
	/**
	 * 允许半退标识
	 * @param Fg_ori_prtrtn
	 */
	public void setFg_ori_prtrtn(FBoolean Fg_ori_prtrtn) {
		setAttrVal("Fg_ori_prtrtn", Fg_ori_prtrtn);
	}
	/**
	 * 允许原路退回标识
	 * @return FBoolean
	 */
	public FBoolean getFg_native_rtn() {
		return ((FBoolean) getAttrVal("Fg_native_rtn"));
	}	
	/**
	 * 允许原路退回标识
	 * @param Fg_native_rtn
	 */
	public void setFg_native_rtn(FBoolean Fg_native_rtn) {
		setAttrVal("Fg_native_rtn", Fg_native_rtn);
	}
	/**
	 * 账户名称标志
	 * @return FBoolean
	 */
	public FBoolean getFg_accname() {
		return ((FBoolean) getAttrVal("Fg_accname"));
	}	
	/**
	 * 账户名称标志
	 * @param Fg_accname
	 */
	public void setFg_accname(FBoolean Fg_accname) {
		setAttrVal("Fg_accname", Fg_accname);
	}
	/**
	 * 银行转账标志
	 * @return FBoolean
	 */
	public FBoolean getFg_transblankacc() {
		return ((FBoolean) getAttrVal("Fg_transblankacc"));
	}	
	/**
	 * 银行转账标志
	 * @param Fg_transblankacc
	 */
	public void setFg_transblankacc(FBoolean Fg_transblankacc) {
		setAttrVal("Fg_transblankacc", Fg_transblankacc);
	}
	/**
	 * 付款方式类型
	 * @return String
	 */
	public String getPmtp_name() {
		return ((String) getAttrVal("Pmtp_name"));
	}	
	/**
	 * 付款方式类型
	 * @param Pmtp_name
	 */
	public void setPmtp_name(String Pmtp_name) {
		setAttrVal("Pmtp_name", Pmtp_name);
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
		return "Id_pm";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_pri_pm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PriPmDODesc.class);
	}
	
}