package iih.bl.st.blpaypatoep.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.st.blpaypatoep.d.desc.BlPayPatOepDODesc;
import java.math.BigDecimal;

/**
 * 门急诊患者收付款 DO数据 
 * 
 */
public class BlPayPatOepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//患者收付款主键
	public static final String ID_PAYPATOEP= "Id_paypatoep";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//就诊类型
	public static final String ID_ENTTP= "Id_enttp";
	//就诊类型编码
	public static final String CODE_ENTTP= "Code_enttp";
	//患者收付款类型
	public static final String ID_PAYTP= "Id_paytp";
	//患者收付款类型编码
	public static final String SD_PAYTP= "Sd_paytp";
	//患者
	public static final String ID_PAT= "Id_pat";
	//收退款方向
	public static final String EU_DIRECT= "Eu_direct";
	//收退款金额
	public static final String AMT= "Amt";
	//收付款日期
	public static final String DT_PAY= "Dt_pay";
	//收付款机构
	public static final String ID_ORG_PAY= "Id_org_pay";
	//收付款部门
	public static final String ID_DEP_PAY= "Id_dep_pay";
	//收付款人员
	public static final String ID_EMP_PAY= "Id_emp_pay";
	//操作员结账标志
	public static final String FG_CC= "Fg_cc";
	//操作员结账
	public static final String ID_CC= "Id_cc";
	//备注
	public static final String NOTE= "Note";
	//收付款终端类型ID
	public static final String ID_PTTP= "Id_pttp";
	//收付款终端类型
	public static final String SD_PTTP= "Sd_pttp";
	//体检流水号
	public static final String PECODE= "Pecode";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//就诊类型名称
	public static final String ENTPNAME= "Entpname";
	//就诊类型编码
	public static final String ENTPCODE= "Entpcode";
	//编码
	public static final String PAYTP_CODE= "Paytp_code";
	//名称
	public static final String PAYTP_NAME= "Paytp_name";
	//患者编码
	public static final String PATCODE= "Patcode";
	//患者姓名
	public static final String PATNAME= "Patname";
	//编码
	public static final String DEPTCODE= "Deptcode";
	//名称
	public static final String DEPTNAME= "Deptname";
	//人员编码
	public static final String EMPPAYCODE= "Emppaycode";
	//姓名
	public static final String EMPPAYNAME= "Emppayname";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 患者收付款主键
	 * @return String
	 */
	public String getId_paypatoep() {
		return ((String) getAttrVal("Id_paypatoep"));
	}	
	/**
	 * 患者收付款主键
	 * @param Id_paypatoep
	 */
	public void setId_paypatoep(String Id_paypatoep) {
		setAttrVal("Id_paypatoep", Id_paypatoep);
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
	 * 就诊类型
	 * @return String
	 */
	public String getId_enttp() {
		return ((String) getAttrVal("Id_enttp"));
	}	
	/**
	 * 就诊类型
	 * @param Id_enttp
	 */
	public void setId_enttp(String Id_enttp) {
		setAttrVal("Id_enttp", Id_enttp);
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
	 * 患者收付款类型
	 * @return String
	 */
	public String getId_paytp() {
		return ((String) getAttrVal("Id_paytp"));
	}	
	/**
	 * 患者收付款类型
	 * @param Id_paytp
	 */
	public void setId_paytp(String Id_paytp) {
		setAttrVal("Id_paytp", Id_paytp);
	}
	/**
	 * 患者收付款类型编码
	 * @return String
	 */
	public String getSd_paytp() {
		return ((String) getAttrVal("Sd_paytp"));
	}	
	/**
	 * 患者收付款类型编码
	 * @param Sd_paytp
	 */
	public void setSd_paytp(String Sd_paytp) {
		setAttrVal("Sd_paytp", Sd_paytp);
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
	 * 收退款方向
	 * @return Integer
	 */
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}	
	/**
	 * 收退款方向
	 * @param Eu_direct
	 */
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	/**
	 * 收退款金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	/**
	 * 收退款金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 收付款日期
	 * @return FDateTime
	 */
	public FDateTime getDt_pay() {
		return ((FDateTime) getAttrVal("Dt_pay"));
	}	
	/**
	 * 收付款日期
	 * @param Dt_pay
	 */
	public void setDt_pay(FDateTime Dt_pay) {
		setAttrVal("Dt_pay", Dt_pay);
	}
	/**
	 * 收付款机构
	 * @return String
	 */
	public String getId_org_pay() {
		return ((String) getAttrVal("Id_org_pay"));
	}	
	/**
	 * 收付款机构
	 * @param Id_org_pay
	 */
	public void setId_org_pay(String Id_org_pay) {
		setAttrVal("Id_org_pay", Id_org_pay);
	}
	/**
	 * 收付款部门
	 * @return String
	 */
	public String getId_dep_pay() {
		return ((String) getAttrVal("Id_dep_pay"));
	}	
	/**
	 * 收付款部门
	 * @param Id_dep_pay
	 */
	public void setId_dep_pay(String Id_dep_pay) {
		setAttrVal("Id_dep_pay", Id_dep_pay);
	}
	/**
	 * 收付款人员
	 * @return String
	 */
	public String getId_emp_pay() {
		return ((String) getAttrVal("Id_emp_pay"));
	}	
	/**
	 * 收付款人员
	 * @param Id_emp_pay
	 */
	public void setId_emp_pay(String Id_emp_pay) {
		setAttrVal("Id_emp_pay", Id_emp_pay);
	}
	/**
	 * 操作员结账标志
	 * @return FBoolean
	 */
	public FBoolean getFg_cc() {
		return ((FBoolean) getAttrVal("Fg_cc"));
	}	
	/**
	 * 操作员结账标志
	 * @param Fg_cc
	 */
	public void setFg_cc(FBoolean Fg_cc) {
		setAttrVal("Fg_cc", Fg_cc);
	}
	/**
	 * 操作员结账
	 * @return String
	 */
	public String getId_cc() {
		return ((String) getAttrVal("Id_cc"));
	}	
	/**
	 * 操作员结账
	 * @param Id_cc
	 */
	public void setId_cc(String Id_cc) {
		setAttrVal("Id_cc", Id_cc);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 收付款终端类型ID
	 * @return String
	 */
	public String getId_pttp() {
		return ((String) getAttrVal("Id_pttp"));
	}	
	/**
	 * 收付款终端类型ID
	 * @param Id_pttp
	 */
	public void setId_pttp(String Id_pttp) {
		setAttrVal("Id_pttp", Id_pttp);
	}
	/**
	 * 收付款终端类型
	 * @return String
	 */
	public String getSd_pttp() {
		return ((String) getAttrVal("Sd_pttp"));
	}	
	/**
	 * 收付款终端类型
	 * @param Sd_pttp
	 */
	public void setSd_pttp(String Sd_pttp) {
		setAttrVal("Sd_pttp", Sd_pttp);
	}
	/**
	 * 体检流水号
	 * @return String
	 */
	public String getPecode() {
		return ((String) getAttrVal("Pecode"));
	}	
	/**
	 * 体检流水号
	 * @param Pecode
	 */
	public void setPecode(String Pecode) {
		setAttrVal("Pecode", Pecode);
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
	 * 就诊类型名称
	 * @return String
	 */
	public String getEntpname() {
		return ((String) getAttrVal("Entpname"));
	}	
	/**
	 * 就诊类型名称
	 * @param Entpname
	 */
	public void setEntpname(String Entpname) {
		setAttrVal("Entpname", Entpname);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getEntpcode() {
		return ((String) getAttrVal("Entpcode"));
	}	
	/**
	 * 就诊类型编码
	 * @param Entpcode
	 */
	public void setEntpcode(String Entpcode) {
		setAttrVal("Entpcode", Entpcode);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getPaytp_code() {
		return ((String) getAttrVal("Paytp_code"));
	}	
	/**
	 * 编码
	 * @param Paytp_code
	 */
	public void setPaytp_code(String Paytp_code) {
		setAttrVal("Paytp_code", Paytp_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getPaytp_name() {
		return ((String) getAttrVal("Paytp_name"));
	}	
	/**
	 * 名称
	 * @param Paytp_name
	 */
	public void setPaytp_name(String Paytp_name) {
		setAttrVal("Paytp_name", Paytp_name);
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
	 * 编码
	 * @return String
	 */
	public String getDeptcode() {
		return ((String) getAttrVal("Deptcode"));
	}	
	/**
	 * 编码
	 * @param Deptcode
	 */
	public void setDeptcode(String Deptcode) {
		setAttrVal("Deptcode", Deptcode);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDeptname() {
		return ((String) getAttrVal("Deptname"));
	}	
	/**
	 * 名称
	 * @param Deptname
	 */
	public void setDeptname(String Deptname) {
		setAttrVal("Deptname", Deptname);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getEmppaycode() {
		return ((String) getAttrVal("Emppaycode"));
	}	
	/**
	 * 人员编码
	 * @param Emppaycode
	 */
	public void setEmppaycode(String Emppaycode) {
		setAttrVal("Emppaycode", Emppaycode);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getEmppayname() {
		return ((String) getAttrVal("Emppayname"));
	}	
	/**
	 * 姓名
	 * @param Emppayname
	 */
	public void setEmppayname(String Emppayname) {
		setAttrVal("Emppayname", Emppayname);
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
		return "Id_paypatoep";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_pay_pat_oep";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlPayPatOepDODesc.class);
	}
	
}