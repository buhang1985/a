package iih.pe.pwf.perst.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pwf.perst.d.desc.PeRstDODesc;
import java.math.BigDecimal;

/**
 * 体检结果 DO数据 
 * 
 */
public class PeRstDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检结果主键标识
	public static final String ID_PERST= "Id_perst";
	//体检预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//体检科室编码
	public static final String SD_DEPTSET= "Sd_deptset";
	//所属科室
	public static final String ID_PEDEPTSET= "Id_pedeptset";
	//体检项目编码
	public static final String SD_CATLOG= "Sd_catlog";
	//体检项目ID
	public static final String ID_PESRVBCATLOG= "Id_pesrvbcatlog";
	//体检结果编码
	public static final String SD_ITEM= "Sd_item";
	//体检结果ID
	public static final String ID_PESRVITEM= "Id_pesrvitem";
	//检查结果状态
	public static final String PEITEMSTATUS= "Peitemstatus";
	//检查结果内容
	public static final String RST= "Rst";
	//常用结果ID
	public static final String ID_PITM_RST= "Id_pitm_rst";
	//检查描述
	public static final String DES= "Des";
	//参考范围
	public static final String REF= "Ref";
	//最大值
	public static final String REF_MAX= "Ref_max";
	//最小值
	public static final String REF_MIN= "Ref_min";
	//计量单位
	public static final String UNIT= "Unit";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//异常标识符号
	public static final String MARK= "Mark";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//异常标识
	public static final String FG_ABN= "Fg_abn";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//阳性标识
	public static final String FG_POSI= "Fg_posi";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//录入护士
	public static final String ID_EMP_NUR= "Id_emp_nur";
	//录入科室
	public static final String ID_DEP_NUR= "Id_dep_nur";
	//录入时间
	public static final String DT_NUR= "Dt_nur";
	//检查医生
	public static final String ID_EMP_DOC= "Id_emp_doc";
	//检查科室
	public static final String ID_DEP_DOC= "Id_dep_doc";
	//检查时间
	public static final String DT_DOC= "Dt_doc";
	//显示顺序
	public static final String SORT_SHOW= "Sort_show";
	//预警级别
	public static final String WARNLEVEL= "Warnlevel";
	//异常标识符箭头
	public static final String MARK_ARROW= "Mark_arrow";
	//紧急标识
	public static final String FG_URGENCY= "Fg_urgency";
	//体检科室编码
	public static final String CODE_DEP= "Code_dep";
	//体检科室名称
	public static final String NAME_DEP= "Name_dep";
	//编码
	public static final String CODE_CATLOG= "Code_catlog";
	//名称
	public static final String NAME_CATLOG= "Name_catlog";
	//体检结果编码
	public static final String CODE_ITM= "Code_itm";
	//体检结果名称
	public static final String NAME_ITM= "Name_itm";
	//体检检查小项结果类型
	public static final String RESULTTP= "Resulttp";
	//是否复制
	public static final String FG_COPY= "Fg_copy";
	//有图片附件
	public static final String FG_IMG= "Fg_img";
	//缺省值
	public static final String DEFAULT_VALUE= "Default_value";
	//计算公式
	public static final String FORMULA= "Formula";
	//性别限制
	public static final String SEXLIMIT= "Sexlimit";
	//流程-离开时状态检测
	public static final String WF_LEAVE_CHECK= "Wf_leave_check";
	//流程-延迟检查时间
	public static final String WF_TIME_DELAY= "Wf_time_delay";
	//流程-离开时状态
	public static final String WF_LEAVE_STATUS= "Wf_leave_status";
	//是否异常判断
	public static final String FG_ABN_ITM= "Fg_abn_itm";
	//有效值范围
	public static final String VALID= "Valid";
	//正异常判断规则
	public static final String ID_RULEREF= "Id_ruleref";
	//数据合法性规则
	public static final String ID_RULELEGAL= "Id_rulelegal";
	//序号
	public static final String SORTNO= "Sortno";
	//正常关键字
	public static final String NORMALKEY= "Normalkey";
	//录入可选项编码
	public static final String CODE_OPTS= "Code_opts";
	//录入可选项名称
	public static final String NAME_OPTS= "Name_opts";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检结果主键标识
	 * @return String
	 */
	public String getId_perst() {
		return ((String) getAttrVal("Id_perst"));
	}	
	/**
	 * 体检结果主键标识
	 * @param Id_perst
	 */
	public void setId_perst(String Id_perst) {
		setAttrVal("Id_perst", Id_perst);
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
	 * 体检科室编码
	 * @return String
	 */
	public String getSd_deptset() {
		return ((String) getAttrVal("Sd_deptset"));
	}	
	/**
	 * 体检科室编码
	 * @param Sd_deptset
	 */
	public void setSd_deptset(String Sd_deptset) {
		setAttrVal("Sd_deptset", Sd_deptset);
	}
	/**
	 * 所属科室
	 * @return String
	 */
	public String getId_pedeptset() {
		return ((String) getAttrVal("Id_pedeptset"));
	}	
	/**
	 * 所属科室
	 * @param Id_pedeptset
	 */
	public void setId_pedeptset(String Id_pedeptset) {
		setAttrVal("Id_pedeptset", Id_pedeptset);
	}
	/**
	 * 体检项目编码
	 * @return String
	 */
	public String getSd_catlog() {
		return ((String) getAttrVal("Sd_catlog"));
	}	
	/**
	 * 体检项目编码
	 * @param Sd_catlog
	 */
	public void setSd_catlog(String Sd_catlog) {
		setAttrVal("Sd_catlog", Sd_catlog);
	}
	/**
	 * 体检项目ID
	 * @return String
	 */
	public String getId_pesrvbcatlog() {
		return ((String) getAttrVal("Id_pesrvbcatlog"));
	}	
	/**
	 * 体检项目ID
	 * @param Id_pesrvbcatlog
	 */
	public void setId_pesrvbcatlog(String Id_pesrvbcatlog) {
		setAttrVal("Id_pesrvbcatlog", Id_pesrvbcatlog);
	}
	/**
	 * 体检结果编码
	 * @return String
	 */
	public String getSd_item() {
		return ((String) getAttrVal("Sd_item"));
	}	
	/**
	 * 体检结果编码
	 * @param Sd_item
	 */
	public void setSd_item(String Sd_item) {
		setAttrVal("Sd_item", Sd_item);
	}
	/**
	 * 体检结果ID
	 * @return String
	 */
	public String getId_pesrvitem() {
		return ((String) getAttrVal("Id_pesrvitem"));
	}	
	/**
	 * 体检结果ID
	 * @param Id_pesrvitem
	 */
	public void setId_pesrvitem(String Id_pesrvitem) {
		setAttrVal("Id_pesrvitem", Id_pesrvitem);
	}
	/**
	 * 检查结果状态
	 * @return Integer
	 */
	public Integer getPeitemstatus() {
		return ((Integer) getAttrVal("Peitemstatus"));
	}	
	/**
	 * 检查结果状态
	 * @param Peitemstatus
	 */
	public void setPeitemstatus(Integer Peitemstatus) {
		setAttrVal("Peitemstatus", Peitemstatus);
	}
	/**
	 * 检查结果内容
	 * @return String
	 */
	public String getRst() {
		return ((String) getAttrVal("Rst"));
	}	
	/**
	 * 检查结果内容
	 * @param Rst
	 */
	public void setRst(String Rst) {
		setAttrVal("Rst", Rst);
	}
	/**
	 * 常用结果ID
	 * @return String
	 */
	public String getId_pitm_rst() {
		return ((String) getAttrVal("Id_pitm_rst"));
	}	
	/**
	 * 常用结果ID
	 * @param Id_pitm_rst
	 */
	public void setId_pitm_rst(String Id_pitm_rst) {
		setAttrVal("Id_pitm_rst", Id_pitm_rst);
	}
	/**
	 * 检查描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 检查描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 参考范围
	 * @return String
	 */
	public String getRef() {
		return ((String) getAttrVal("Ref"));
	}	
	/**
	 * 参考范围
	 * @param Ref
	 */
	public void setRef(String Ref) {
		setAttrVal("Ref", Ref);
	}
	/**
	 * 最大值
	 * @return String
	 */
	public String getRef_max() {
		return ((String) getAttrVal("Ref_max"));
	}	
	/**
	 * 最大值
	 * @param Ref_max
	 */
	public void setRef_max(String Ref_max) {
		setAttrVal("Ref_max", Ref_max);
	}
	/**
	 * 最小值
	 * @return String
	 */
	public String getRef_min() {
		return ((String) getAttrVal("Ref_min"));
	}	
	/**
	 * 最小值
	 * @param Ref_min
	 */
	public void setRef_min(String Ref_min) {
		setAttrVal("Ref_min", Ref_min);
	}
	/**
	 * 计量单位
	 * @return String
	 */
	public String getUnit() {
		return ((String) getAttrVal("Unit"));
	}	
	/**
	 * 计量单位
	 * @param Unit
	 */
	public void setUnit(String Unit) {
		setAttrVal("Unit", Unit);
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
	 * 异常标识符号
	 * @return String
	 */
	public String getMark() {
		return ((String) getAttrVal("Mark"));
	}	
	/**
	 * 异常标识符号
	 * @param Mark
	 */
	public void setMark(String Mark) {
		setAttrVal("Mark", Mark);
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
	 * 异常标识
	 * @return FBoolean
	 */
	public FBoolean getFg_abn() {
		return ((FBoolean) getAttrVal("Fg_abn"));
	}	
	/**
	 * 异常标识
	 * @param Fg_abn
	 */
	public void setFg_abn(FBoolean Fg_abn) {
		setAttrVal("Fg_abn", Fg_abn);
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
	 * 阳性标识
	 * @return FBoolean
	 */
	public FBoolean getFg_posi() {
		return ((FBoolean) getAttrVal("Fg_posi"));
	}	
	/**
	 * 阳性标识
	 * @param Fg_posi
	 */
	public void setFg_posi(FBoolean Fg_posi) {
		setAttrVal("Fg_posi", Fg_posi);
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
	 * 录入护士
	 * @return String
	 */
	public String getId_emp_nur() {
		return ((String) getAttrVal("Id_emp_nur"));
	}	
	/**
	 * 录入护士
	 * @param Id_emp_nur
	 */
	public void setId_emp_nur(String Id_emp_nur) {
		setAttrVal("Id_emp_nur", Id_emp_nur);
	}
	/**
	 * 录入科室
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	/**
	 * 录入科室
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 录入时间
	 * @return FDateTime
	 */
	public FDateTime getDt_nur() {
		return ((FDateTime) getAttrVal("Dt_nur"));
	}	
	/**
	 * 录入时间
	 * @param Dt_nur
	 */
	public void setDt_nur(FDateTime Dt_nur) {
		setAttrVal("Dt_nur", Dt_nur);
	}
	/**
	 * 检查医生
	 * @return String
	 */
	public String getId_emp_doc() {
		return ((String) getAttrVal("Id_emp_doc"));
	}	
	/**
	 * 检查医生
	 * @param Id_emp_doc
	 */
	public void setId_emp_doc(String Id_emp_doc) {
		setAttrVal("Id_emp_doc", Id_emp_doc);
	}
	/**
	 * 检查科室
	 * @return String
	 */
	public String getId_dep_doc() {
		return ((String) getAttrVal("Id_dep_doc"));
	}	
	/**
	 * 检查科室
	 * @param Id_dep_doc
	 */
	public void setId_dep_doc(String Id_dep_doc) {
		setAttrVal("Id_dep_doc", Id_dep_doc);
	}
	/**
	 * 检查时间
	 * @return FDateTime
	 */
	public FDateTime getDt_doc() {
		return ((FDateTime) getAttrVal("Dt_doc"));
	}	
	/**
	 * 检查时间
	 * @param Dt_doc
	 */
	public void setDt_doc(FDateTime Dt_doc) {
		setAttrVal("Dt_doc", Dt_doc);
	}
	/**
	 * 显示顺序
	 * @return Integer
	 */
	public Integer getSort_show() {
		return ((Integer) getAttrVal("Sort_show"));
	}	
	/**
	 * 显示顺序
	 * @param Sort_show
	 */
	public void setSort_show(Integer Sort_show) {
		setAttrVal("Sort_show", Sort_show);
	}
	/**
	 * 预警级别
	 * @return Integer
	 */
	public Integer getWarnlevel() {
		return ((Integer) getAttrVal("Warnlevel"));
	}	
	/**
	 * 预警级别
	 * @param Warnlevel
	 */
	public void setWarnlevel(Integer Warnlevel) {
		setAttrVal("Warnlevel", Warnlevel);
	}
	/**
	 * 异常标识符箭头
	 * @return String
	 */
	public String getMark_arrow() {
		return ((String) getAttrVal("Mark_arrow"));
	}	
	/**
	 * 异常标识符箭头
	 * @param Mark_arrow
	 */
	public void setMark_arrow(String Mark_arrow) {
		setAttrVal("Mark_arrow", Mark_arrow);
	}
	/**
	 * 紧急标识
	 * @return FBoolean
	 */
	public FBoolean getFg_urgency() {
		return ((FBoolean) getAttrVal("Fg_urgency"));
	}	
	/**
	 * 紧急标识
	 * @param Fg_urgency
	 */
	public void setFg_urgency(FBoolean Fg_urgency) {
		setAttrVal("Fg_urgency", Fg_urgency);
	}
	/**
	 * 体检科室编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	/**
	 * 体检科室编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 体检科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 体检科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_catlog() {
		return ((String) getAttrVal("Code_catlog"));
	}	
	/**
	 * 编码
	 * @param Code_catlog
	 */
	public void setCode_catlog(String Code_catlog) {
		setAttrVal("Code_catlog", Code_catlog);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_catlog() {
		return ((String) getAttrVal("Name_catlog"));
	}	
	/**
	 * 名称
	 * @param Name_catlog
	 */
	public void setName_catlog(String Name_catlog) {
		setAttrVal("Name_catlog", Name_catlog);
	}
	/**
	 * 体检结果编码
	 * @return String
	 */
	public String getCode_itm() {
		return ((String) getAttrVal("Code_itm"));
	}	
	/**
	 * 体检结果编码
	 * @param Code_itm
	 */
	public void setCode_itm(String Code_itm) {
		setAttrVal("Code_itm", Code_itm);
	}
	/**
	 * 体检结果名称
	 * @return String
	 */
	public String getName_itm() {
		return ((String) getAttrVal("Name_itm"));
	}	
	/**
	 * 体检结果名称
	 * @param Name_itm
	 */
	public void setName_itm(String Name_itm) {
		setAttrVal("Name_itm", Name_itm);
	}
	/**
	 * 体检检查小项结果类型
	 * @return Integer
	 */
	public Integer getResulttp() {
		return ((Integer) getAttrVal("Resulttp"));
	}	
	/**
	 * 体检检查小项结果类型
	 * @param Resulttp
	 */
	public void setResulttp(Integer Resulttp) {
		setAttrVal("Resulttp", Resulttp);
	}
	/**
	 * 是否复制
	 * @return FBoolean
	 */
	public FBoolean getFg_copy() {
		return ((FBoolean) getAttrVal("Fg_copy"));
	}	
	/**
	 * 是否复制
	 * @param Fg_copy
	 */
	public void setFg_copy(FBoolean Fg_copy) {
		setAttrVal("Fg_copy", Fg_copy);
	}
	/**
	 * 有图片附件
	 * @return FBoolean
	 */
	public FBoolean getFg_img() {
		return ((FBoolean) getAttrVal("Fg_img"));
	}	
	/**
	 * 有图片附件
	 * @param Fg_img
	 */
	public void setFg_img(FBoolean Fg_img) {
		setAttrVal("Fg_img", Fg_img);
	}
	/**
	 * 缺省值
	 * @return String
	 */
	public String getDefault_value() {
		return ((String) getAttrVal("Default_value"));
	}	
	/**
	 * 缺省值
	 * @param Default_value
	 */
	public void setDefault_value(String Default_value) {
		setAttrVal("Default_value", Default_value);
	}
	/**
	 * 计算公式
	 * @return String
	 */
	public String getFormula() {
		return ((String) getAttrVal("Formula"));
	}	
	/**
	 * 计算公式
	 * @param Formula
	 */
	public void setFormula(String Formula) {
		setAttrVal("Formula", Formula);
	}
	/**
	 * 性别限制
	 * @return Integer
	 */
	public Integer getSexlimit() {
		return ((Integer) getAttrVal("Sexlimit"));
	}	
	/**
	 * 性别限制
	 * @param Sexlimit
	 */
	public void setSexlimit(Integer Sexlimit) {
		setAttrVal("Sexlimit", Sexlimit);
	}
	/**
	 * 流程-离开时状态检测
	 * @return FBoolean
	 */
	public FBoolean getWf_leave_check() {
		return ((FBoolean) getAttrVal("Wf_leave_check"));
	}	
	/**
	 * 流程-离开时状态检测
	 * @param Wf_leave_check
	 */
	public void setWf_leave_check(FBoolean Wf_leave_check) {
		setAttrVal("Wf_leave_check", Wf_leave_check);
	}
	/**
	 * 流程-延迟检查时间
	 * @return Integer
	 */
	public Integer getWf_time_delay() {
		return ((Integer) getAttrVal("Wf_time_delay"));
	}	
	/**
	 * 流程-延迟检查时间
	 * @param Wf_time_delay
	 */
	public void setWf_time_delay(Integer Wf_time_delay) {
		setAttrVal("Wf_time_delay", Wf_time_delay);
	}
	/**
	 * 流程-离开时状态
	 * @return Integer
	 */
	public Integer getWf_leave_status() {
		return ((Integer) getAttrVal("Wf_leave_status"));
	}	
	/**
	 * 流程-离开时状态
	 * @param Wf_leave_status
	 */
	public void setWf_leave_status(Integer Wf_leave_status) {
		setAttrVal("Wf_leave_status", Wf_leave_status);
	}
	/**
	 * 是否异常判断
	 * @return FBoolean
	 */
	public FBoolean getFg_abn_itm() {
		return ((FBoolean) getAttrVal("Fg_abn_itm"));
	}	
	/**
	 * 是否异常判断
	 * @param Fg_abn_itm
	 */
	public void setFg_abn_itm(FBoolean Fg_abn_itm) {
		setAttrVal("Fg_abn_itm", Fg_abn_itm);
	}
	/**
	 * 有效值范围
	 * @return String
	 */
	public String getValid() {
		return ((String) getAttrVal("Valid"));
	}	
	/**
	 * 有效值范围
	 * @param Valid
	 */
	public void setValid(String Valid) {
		setAttrVal("Valid", Valid);
	}
	/**
	 * 正异常判断规则
	 * @return String
	 */
	public String getId_ruleref() {
		return ((String) getAttrVal("Id_ruleref"));
	}	
	/**
	 * 正异常判断规则
	 * @param Id_ruleref
	 */
	public void setId_ruleref(String Id_ruleref) {
		setAttrVal("Id_ruleref", Id_ruleref);
	}
	/**
	 * 数据合法性规则
	 * @return String
	 */
	public String getId_rulelegal() {
		return ((String) getAttrVal("Id_rulelegal"));
	}	
	/**
	 * 数据合法性规则
	 * @param Id_rulelegal
	 */
	public void setId_rulelegal(String Id_rulelegal) {
		setAttrVal("Id_rulelegal", Id_rulelegal);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 正常关键字
	 * @return String
	 */
	public String getNormalkey() {
		return ((String) getAttrVal("Normalkey"));
	}	
	/**
	 * 正常关键字
	 * @param Normalkey
	 */
	public void setNormalkey(String Normalkey) {
		setAttrVal("Normalkey", Normalkey);
	}
	/**
	 * 录入可选项编码
	 * @return String
	 */
	public String getCode_opts() {
		return ((String) getAttrVal("Code_opts"));
	}	
	/**
	 * 录入可选项编码
	 * @param Code_opts
	 */
	public void setCode_opts(String Code_opts) {
		setAttrVal("Code_opts", Code_opts);
	}
	/**
	 * 录入可选项名称
	 * @return String
	 */
	public String getName_opts() {
		return ((String) getAttrVal("Name_opts"));
	}	
	/**
	 * 录入可选项名称
	 * @param Name_opts
	 */
	public void setName_opts(String Name_opts) {
		setAttrVal("Name_opts", Name_opts);
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
		return "Id_perst";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_wf_perst";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeRstDODesc.class);
	}
	
}