package iih.pe.pwf.perstlis.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pwf.perstlis.d.desc.PeRstLisItmDODesc;
import java.math.BigDecimal;

/**
 * 体检检验报告结果 DO数据 
 * 
 */
public class PeRstLisItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//检验报告单明细主键
	public static final String ID_RPTLISITM= "Id_rptlisitm";
	//检验报告单主键
	public static final String ID_RPTLAB= "Id_rptlab";
	//体检预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//参考值
	public static final String VAL_REFERENCE= "Val_reference";
	//最大值
	public static final String VAL_MAX= "Val_max";
	//最小值
	public static final String VAL_MIN= "Val_min";
	//结果值
	public static final String VAL_RSTRPTLAB= "Val_rstrptlab";
	//单位名称
	public static final String NAME_UNIT= "Name_unit";
	//危急值标志
	public static final String FG_CRISIS= "Fg_crisis";
	//客户编码
	public static final String CODE_PAT= "Code_pat";
	//申请单
	public static final String NO_APPLYFORM= "No_applyform";
	//检查分组
	public static final String EXAMINAIM= "Examinaim";
	//标本号
	public static final String SAMPLENO= "Sampleno";
	//标本类型
	public static final String SAMPLETYPE= "Sampletype";
	//检验员编码
	public static final String CODE_EMP= "Code_emp";
	//检验设备
	public static final String NAME_INSMT= "Name_insmt";
	//报告日期
	public static final String DT_RPTLAB= "Dt_rptlab";
	//设备编码
	public static final String SD_INSMT= "Sd_insmt";
	//科室编码
	public static final String CODE_DEP= "Code_dep";
	//项目编码
	public static final String CODE_SRV= "Code_srv";
	//项目名称
	public static final String NAME_SRV= "Name_srv";
	//打印序号
	public static final String PRINTORD= "Printord";
	//原始异常标识
	public static final String CODE_DEVIATE= "Code_deviate";
	//异常标识名称
	public static final String NAME_DEVIATE= "Name_deviate";
	//异常标识
	public static final String MARK_DEVIATE= "Mark_deviate";
	//箭头标识
	public static final String MARK_ARROW= "Mark_arrow";
	//检验人
	public static final String REPORTOR= "Reportor";
	//检验人编码
	public static final String CODE_REPORTOR= "Code_reportor";
	//审核人
	public static final String VERIFIER= "Verifier";
	//审核人编码
	public static final String CODE_VERIFIER= "Code_verifier";
	//审核日期
	public static final String DT_RPTVER= "Dt_rptver";
	//检查分组编码
	public static final String CODE_EXAMGROUP= "Code_examgroup";
	//检查分组名称
	public static final String NAME_EXAMGROUP= "Name_examgroup";
	//就诊类型编码
	public static final String CODE_ENTP= "Code_entp";
	//就诊类型名称
	public static final String NAME_ENTP= "Name_entp";
	//录入标识
	public static final String FG_INPUT= "Fg_input";
	//录入时间
	public static final String DT_INPUT= "Dt_input";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 检验报告单明细主键
	 * @return String
	 */
	public String getId_rptlisitm() {
		return ((String) getAttrVal("Id_rptlisitm"));
	}	
	/**
	 * 检验报告单明细主键
	 * @param Id_rptlisitm
	 */
	public void setId_rptlisitm(String Id_rptlisitm) {
		setAttrVal("Id_rptlisitm", Id_rptlisitm);
	}
	/**
	 * 检验报告单主键
	 * @return String
	 */
	public String getId_rptlab() {
		return ((String) getAttrVal("Id_rptlab"));
	}	
	/**
	 * 检验报告单主键
	 * @param Id_rptlab
	 */
	public void setId_rptlab(String Id_rptlab) {
		setAttrVal("Id_rptlab", Id_rptlab);
	}
	/**
	 * 体检预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	/**
	 * 体检预约单ID
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	/**
	 * 参考值
	 * @return String
	 */
	public String getVal_reference() {
		return ((String) getAttrVal("Val_reference"));
	}	
	/**
	 * 参考值
	 * @param Val_reference
	 */
	public void setVal_reference(String Val_reference) {
		setAttrVal("Val_reference", Val_reference);
	}
	/**
	 * 最大值
	 * @return String
	 */
	public String getVal_max() {
		return ((String) getAttrVal("Val_max"));
	}	
	/**
	 * 最大值
	 * @param Val_max
	 */
	public void setVal_max(String Val_max) {
		setAttrVal("Val_max", Val_max);
	}
	/**
	 * 最小值
	 * @return String
	 */
	public String getVal_min() {
		return ((String) getAttrVal("Val_min"));
	}	
	/**
	 * 最小值
	 * @param Val_min
	 */
	public void setVal_min(String Val_min) {
		setAttrVal("Val_min", Val_min);
	}
	/**
	 * 结果值
	 * @return String
	 */
	public String getVal_rstrptlab() {
		return ((String) getAttrVal("Val_rstrptlab"));
	}	
	/**
	 * 结果值
	 * @param Val_rstrptlab
	 */
	public void setVal_rstrptlab(String Val_rstrptlab) {
		setAttrVal("Val_rstrptlab", Val_rstrptlab);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}	
	/**
	 * 单位名称
	 * @param Name_unit
	 */
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
	}
	/**
	 * 危急值标志
	 * @return FBoolean
	 */
	public FBoolean getFg_crisis() {
		return ((FBoolean) getAttrVal("Fg_crisis"));
	}	
	/**
	 * 危急值标志
	 * @param Fg_crisis
	 */
	public void setFg_crisis(FBoolean Fg_crisis) {
		setAttrVal("Fg_crisis", Fg_crisis);
	}
	/**
	 * 客户编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	/**
	 * 客户编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 申请单
	 * @return String
	 */
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}	
	/**
	 * 申请单
	 * @param No_applyform
	 */
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	/**
	 * 检查分组
	 * @return String
	 */
	public String getExaminaim() {
		return ((String) getAttrVal("Examinaim"));
	}	
	/**
	 * 检查分组
	 * @param Examinaim
	 */
	public void setExaminaim(String Examinaim) {
		setAttrVal("Examinaim", Examinaim);
	}
	/**
	 * 标本号
	 * @return String
	 */
	public String getSampleno() {
		return ((String) getAttrVal("Sampleno"));
	}	
	/**
	 * 标本号
	 * @param Sampleno
	 */
	public void setSampleno(String Sampleno) {
		setAttrVal("Sampleno", Sampleno);
	}
	/**
	 * 标本类型
	 * @return String
	 */
	public String getSampletype() {
		return ((String) getAttrVal("Sampletype"));
	}	
	/**
	 * 标本类型
	 * @param Sampletype
	 */
	public void setSampletype(String Sampletype) {
		setAttrVal("Sampletype", Sampletype);
	}
	/**
	 * 检验员编码
	 * @return String
	 */
	public String getCode_emp() {
		return ((String) getAttrVal("Code_emp"));
	}	
	/**
	 * 检验员编码
	 * @param Code_emp
	 */
	public void setCode_emp(String Code_emp) {
		setAttrVal("Code_emp", Code_emp);
	}
	/**
	 * 检验设备
	 * @return String
	 */
	public String getName_insmt() {
		return ((String) getAttrVal("Name_insmt"));
	}	
	/**
	 * 检验设备
	 * @param Name_insmt
	 */
	public void setName_insmt(String Name_insmt) {
		setAttrVal("Name_insmt", Name_insmt);
	}
	/**
	 * 报告日期
	 * @return String
	 */
	public String getDt_rptlab() {
		return ((String) getAttrVal("Dt_rptlab"));
	}	
	/**
	 * 报告日期
	 * @param Dt_rptlab
	 */
	public void setDt_rptlab(String Dt_rptlab) {
		setAttrVal("Dt_rptlab", Dt_rptlab);
	}
	/**
	 * 设备编码
	 * @return String
	 */
	public String getSd_insmt() {
		return ((String) getAttrVal("Sd_insmt"));
	}	
	/**
	 * 设备编码
	 * @param Sd_insmt
	 */
	public void setSd_insmt(String Sd_insmt) {
		setAttrVal("Sd_insmt", Sd_insmt);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	/**
	 * 科室编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 项目编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}	
	/**
	 * 项目编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 项目名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	/**
	 * 项目名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 打印序号
	 * @return Integer
	 */
	public Integer getPrintord() {
		return ((Integer) getAttrVal("Printord"));
	}	
	/**
	 * 打印序号
	 * @param Printord
	 */
	public void setPrintord(Integer Printord) {
		setAttrVal("Printord", Printord);
	}
	/**
	 * 原始异常标识
	 * @return String
	 */
	public String getCode_deviate() {
		return ((String) getAttrVal("Code_deviate"));
	}	
	/**
	 * 原始异常标识
	 * @param Code_deviate
	 */
	public void setCode_deviate(String Code_deviate) {
		setAttrVal("Code_deviate", Code_deviate);
	}
	/**
	 * 异常标识名称
	 * @return String
	 */
	public String getName_deviate() {
		return ((String) getAttrVal("Name_deviate"));
	}	
	/**
	 * 异常标识名称
	 * @param Name_deviate
	 */
	public void setName_deviate(String Name_deviate) {
		setAttrVal("Name_deviate", Name_deviate);
	}
	/**
	 * 异常标识
	 * @return String
	 */
	public String getMark_deviate() {
		return ((String) getAttrVal("Mark_deviate"));
	}	
	/**
	 * 异常标识
	 * @param Mark_deviate
	 */
	public void setMark_deviate(String Mark_deviate) {
		setAttrVal("Mark_deviate", Mark_deviate);
	}
	/**
	 * 箭头标识
	 * @return String
	 */
	public String getMark_arrow() {
		return ((String) getAttrVal("Mark_arrow"));
	}	
	/**
	 * 箭头标识
	 * @param Mark_arrow
	 */
	public void setMark_arrow(String Mark_arrow) {
		setAttrVal("Mark_arrow", Mark_arrow);
	}
	/**
	 * 检验人
	 * @return String
	 */
	public String getReportor() {
		return ((String) getAttrVal("Reportor"));
	}	
	/**
	 * 检验人
	 * @param Reportor
	 */
	public void setReportor(String Reportor) {
		setAttrVal("Reportor", Reportor);
	}
	/**
	 * 检验人编码
	 * @return String
	 */
	public String getCode_reportor() {
		return ((String) getAttrVal("Code_reportor"));
	}	
	/**
	 * 检验人编码
	 * @param Code_reportor
	 */
	public void setCode_reportor(String Code_reportor) {
		setAttrVal("Code_reportor", Code_reportor);
	}
	/**
	 * 审核人
	 * @return String
	 */
	public String getVerifier() {
		return ((String) getAttrVal("Verifier"));
	}	
	/**
	 * 审核人
	 * @param Verifier
	 */
	public void setVerifier(String Verifier) {
		setAttrVal("Verifier", Verifier);
	}
	/**
	 * 审核人编码
	 * @return String
	 */
	public String getCode_verifier() {
		return ((String) getAttrVal("Code_verifier"));
	}	
	/**
	 * 审核人编码
	 * @param Code_verifier
	 */
	public void setCode_verifier(String Code_verifier) {
		setAttrVal("Code_verifier", Code_verifier);
	}
	/**
	 * 审核日期
	 * @return String
	 */
	public String getDt_rptver() {
		return ((String) getAttrVal("Dt_rptver"));
	}	
	/**
	 * 审核日期
	 * @param Dt_rptver
	 */
	public void setDt_rptver(String Dt_rptver) {
		setAttrVal("Dt_rptver", Dt_rptver);
	}
	/**
	 * 检查分组编码
	 * @return String
	 */
	public String getCode_examgroup() {
		return ((String) getAttrVal("Code_examgroup"));
	}	
	/**
	 * 检查分组编码
	 * @param Code_examgroup
	 */
	public void setCode_examgroup(String Code_examgroup) {
		setAttrVal("Code_examgroup", Code_examgroup);
	}
	/**
	 * 检查分组名称
	 * @return String
	 */
	public String getName_examgroup() {
		return ((String) getAttrVal("Name_examgroup"));
	}	
	/**
	 * 检查分组名称
	 * @param Name_examgroup
	 */
	public void setName_examgroup(String Name_examgroup) {
		setAttrVal("Name_examgroup", Name_examgroup);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 就诊类型名称
	 * @return String
	 */
	public String getName_entp() {
		return ((String) getAttrVal("Name_entp"));
	}	
	/**
	 * 就诊类型名称
	 * @param Name_entp
	 */
	public void setName_entp(String Name_entp) {
		setAttrVal("Name_entp", Name_entp);
	}
	/**
	 * 录入标识
	 * @return FBoolean
	 */
	public FBoolean getFg_input() {
		return ((FBoolean) getAttrVal("Fg_input"));
	}	
	/**
	 * 录入标识
	 * @param Fg_input
	 */
	public void setFg_input(FBoolean Fg_input) {
		setAttrVal("Fg_input", Fg_input);
	}
	/**
	 * 录入时间
	 * @return FDateTime
	 */
	public FDateTime getDt_input() {
		return ((FDateTime) getAttrVal("Dt_input"));
	}	
	/**
	 * 录入时间
	 * @param Dt_input
	 */
	public void setDt_input(FDateTime Dt_input) {
		setAttrVal("Dt_input", Dt_input);
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
		return "Id_rptlisitm";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_wf_perstlisitm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeRstLisItmDODesc.class);
	}
	
}