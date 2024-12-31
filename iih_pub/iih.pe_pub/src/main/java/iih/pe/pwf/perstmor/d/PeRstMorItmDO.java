package iih.pe.pwf.perstmor.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pwf.perstmor.d.desc.PeRstMorItmDODesc;
import java.math.BigDecimal;

/**
 * 体检形态学报告结果 DO数据 
 * 
 */
public class PeRstMorItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//形态学报告单明细主键
	public static final String ID_RPTMORITM= "Id_rptmoritm";
	//形态学报告ID
	public static final String ID_PERSTMOR= "Id_perstmor";
	//体检预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//结果值
	public static final String VAL_RSTRPTLAB= "Val_rstrptlab";
	//单位编码
	public static final String CODE_UNIT= "Code_unit";
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
	//骨髓片平均值
	public static final String AVG_VALUE= "Avg_value";
	//骨髓片平均值单位
	public static final String AVG_UNIT= "Avg_unit";
	//骨髓片+/-SD
	public static final String SD_VALUE= "Sd_value";
	//骨髓片+/-SD单位
	public static final String SD_UNIT= "Sd_unit";
	//正常参考范围值
	public static final String NORMAL_VALUE= "Normal_value";
	//正常参考范围值单位
	public static final String NORMAL_UNIT= "Normal_unit";
	//风险值
	public static final String RISK_VALUE= "Risk_value";
	//风险值单位
	public static final String RISK_UNIT= "Risk_unit";
	//年龄风险值
	public static final String AGERISK_VALUE= "Agerisk_value";
	//年龄风险值单位
	public static final String AGERISK_UNIT= "Agerisk_unit";
	//风险截断值
	public static final String RISKTRUNCATION_VALUE= "Risktruncation_value";
	//风险截断值单位
	public static final String RISKTRUNCATION_UNIT= "Risktruncation_unit";
	//校正值
	public static final String CORRECTION_VALUE= "Correction_value";
	//校正值单位
	public static final String CORRECTION_UNIT= "Correction_unit";
	//备注
	public static final String MEMO= "Memo";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 形态学报告单明细主键
	 * @return String
	 */
	public String getId_rptmoritm() {
		return ((String) getAttrVal("Id_rptmoritm"));
	}	
	/**
	 * 形态学报告单明细主键
	 * @param Id_rptmoritm
	 */
	public void setId_rptmoritm(String Id_rptmoritm) {
		setAttrVal("Id_rptmoritm", Id_rptmoritm);
	}
	/**
	 * 形态学报告ID
	 * @return String
	 */
	public String getId_perstmor() {
		return ((String) getAttrVal("Id_perstmor"));
	}	
	/**
	 * 形态学报告ID
	 * @param Id_perstmor
	 */
	public void setId_perstmor(String Id_perstmor) {
		setAttrVal("Id_perstmor", Id_perstmor);
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
	 * 单位编码
	 * @return String
	 */
	public String getCode_unit() {
		return ((String) getAttrVal("Code_unit"));
	}	
	/**
	 * 单位编码
	 * @param Code_unit
	 */
	public void setCode_unit(String Code_unit) {
		setAttrVal("Code_unit", Code_unit);
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
	 * 骨髓片平均值
	 * @return String
	 */
	public String getAvg_value() {
		return ((String) getAttrVal("Avg_value"));
	}	
	/**
	 * 骨髓片平均值
	 * @param Avg_value
	 */
	public void setAvg_value(String Avg_value) {
		setAttrVal("Avg_value", Avg_value);
	}
	/**
	 * 骨髓片平均值单位
	 * @return String
	 */
	public String getAvg_unit() {
		return ((String) getAttrVal("Avg_unit"));
	}	
	/**
	 * 骨髓片平均值单位
	 * @param Avg_unit
	 */
	public void setAvg_unit(String Avg_unit) {
		setAttrVal("Avg_unit", Avg_unit);
	}
	/**
	 * 骨髓片+/-SD
	 * @return String
	 */
	public String getSd_value() {
		return ((String) getAttrVal("Sd_value"));
	}	
	/**
	 * 骨髓片+/-SD
	 * @param Sd_value
	 */
	public void setSd_value(String Sd_value) {
		setAttrVal("Sd_value", Sd_value);
	}
	/**
	 * 骨髓片+/-SD单位
	 * @return String
	 */
	public String getSd_unit() {
		return ((String) getAttrVal("Sd_unit"));
	}	
	/**
	 * 骨髓片+/-SD单位
	 * @param Sd_unit
	 */
	public void setSd_unit(String Sd_unit) {
		setAttrVal("Sd_unit", Sd_unit);
	}
	/**
	 * 正常参考范围值
	 * @return String
	 */
	public String getNormal_value() {
		return ((String) getAttrVal("Normal_value"));
	}	
	/**
	 * 正常参考范围值
	 * @param Normal_value
	 */
	public void setNormal_value(String Normal_value) {
		setAttrVal("Normal_value", Normal_value);
	}
	/**
	 * 正常参考范围值单位
	 * @return String
	 */
	public String getNormal_unit() {
		return ((String) getAttrVal("Normal_unit"));
	}	
	/**
	 * 正常参考范围值单位
	 * @param Normal_unit
	 */
	public void setNormal_unit(String Normal_unit) {
		setAttrVal("Normal_unit", Normal_unit);
	}
	/**
	 * 风险值
	 * @return String
	 */
	public String getRisk_value() {
		return ((String) getAttrVal("Risk_value"));
	}	
	/**
	 * 风险值
	 * @param Risk_value
	 */
	public void setRisk_value(String Risk_value) {
		setAttrVal("Risk_value", Risk_value);
	}
	/**
	 * 风险值单位
	 * @return String
	 */
	public String getRisk_unit() {
		return ((String) getAttrVal("Risk_unit"));
	}	
	/**
	 * 风险值单位
	 * @param Risk_unit
	 */
	public void setRisk_unit(String Risk_unit) {
		setAttrVal("Risk_unit", Risk_unit);
	}
	/**
	 * 年龄风险值
	 * @return String
	 */
	public String getAgerisk_value() {
		return ((String) getAttrVal("Agerisk_value"));
	}	
	/**
	 * 年龄风险值
	 * @param Agerisk_value
	 */
	public void setAgerisk_value(String Agerisk_value) {
		setAttrVal("Agerisk_value", Agerisk_value);
	}
	/**
	 * 年龄风险值单位
	 * @return String
	 */
	public String getAgerisk_unit() {
		return ((String) getAttrVal("Agerisk_unit"));
	}	
	/**
	 * 年龄风险值单位
	 * @param Agerisk_unit
	 */
	public void setAgerisk_unit(String Agerisk_unit) {
		setAttrVal("Agerisk_unit", Agerisk_unit);
	}
	/**
	 * 风险截断值
	 * @return String
	 */
	public String getRisktruncation_value() {
		return ((String) getAttrVal("Risktruncation_value"));
	}	
	/**
	 * 风险截断值
	 * @param Risktruncation_value
	 */
	public void setRisktruncation_value(String Risktruncation_value) {
		setAttrVal("Risktruncation_value", Risktruncation_value);
	}
	/**
	 * 风险截断值单位
	 * @return String
	 */
	public String getRisktruncation_unit() {
		return ((String) getAttrVal("Risktruncation_unit"));
	}	
	/**
	 * 风险截断值单位
	 * @param Risktruncation_unit
	 */
	public void setRisktruncation_unit(String Risktruncation_unit) {
		setAttrVal("Risktruncation_unit", Risktruncation_unit);
	}
	/**
	 * 校正值
	 * @return String
	 */
	public String getCorrection_value() {
		return ((String) getAttrVal("Correction_value"));
	}	
	/**
	 * 校正值
	 * @param Correction_value
	 */
	public void setCorrection_value(String Correction_value) {
		setAttrVal("Correction_value", Correction_value);
	}
	/**
	 * 校正值单位
	 * @return String
	 */
	public String getCorrection_unit() {
		return ((String) getAttrVal("Correction_unit"));
	}	
	/**
	 * 校正值单位
	 * @param Correction_unit
	 */
	public void setCorrection_unit(String Correction_unit) {
		setAttrVal("Correction_unit", Correction_unit);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getMemo() {
		return ((String) getAttrVal("Memo"));
	}	
	/**
	 * 备注
	 * @param Memo
	 */
	public void setMemo(String Memo) {
		setAttrVal("Memo", Memo);
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
		return "Id_rptmoritm";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_wf_perstmoritm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeRstMorItmDODesc.class);
	}
	
}