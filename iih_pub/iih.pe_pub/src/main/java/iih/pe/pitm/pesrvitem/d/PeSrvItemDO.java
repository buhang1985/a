package iih.pe.pitm.pesrvitem.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.pesrvitem.d.desc.PeSrvItemDODesc;
import java.math.BigDecimal;

/**
 * 体检结果定义 DO数据 
 * 
 */
public class PeSrvItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检结果主键标识
	public static final String ID_PESRVITEM= "Id_pesrvitem";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//所属科室
	public static final String ID_PEDEPTSET= "Id_pedeptset";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//简称
	public static final String NAME_SHORT= "Name_short";
	//英文名
	public static final String ENAME= "Ename";
	//序号
	public static final String SORTNO= "Sortno";
	//体检检查小项结果类型
	public static final String RESULTTP= "Resulttp";
	//缺省值
	public static final String DEFAULT_VALUE= "Default_value";
	//缺省状态
	public static final String DEFAULT_STATUS= "Default_status";
	//计量单位
	public static final String UNIT= "Unit";
	//小数位数
	public static final String DIGIT= "Digit";
	//计算公式
	public static final String FORMULA= "Formula";
	//性别限制
	public static final String SEXLIMIT= "Sexlimit";
	//参考范围
	public static final String REFERENCE= "Reference";
	//有效值范围
	public static final String VALID= "Valid";
	//临床意义
	public static final String ITM_INTRODUCTION= "Itm_introduction";
	//诊断分组标识
	public static final String DIAG_GROUP= "Diag_group";
	//是否异常判断
	public static final String FG_ABN= "Fg_abn";
	//总检显示标识
	public static final String FG_OVAL_SHOW= "Fg_oval_show";
	//流程-检查时长
	public static final String CHKDURATION= "Chkduration";
	//流程-空腹项目
	public static final String WF_BEFORE_MEAL= "Wf_before_meal";
	//流程-延迟检查时间
	public static final String WF_TIME_DELAY= "Wf_time_delay";
	//流程-离开时状态检测
	public static final String WF_LEAVE_CHECK= "Wf_leave_check";
	//流程-离开时状态
	public static final String WF_LEAVE_STATUS= "Wf_leave_status";
	//报告-打印标识
	public static final String FG_RP_PRINT= "Fg_rp_print";
	//报告-打印次序
	public static final String RP_PRINTORDER= "Rp_printorder";
	//报告-分组
	public static final String ID_PESRVRPTGRP= "Id_pesrvrptgrp";
	//是否复制
	public static final String FG_COPY= "Fg_copy";
	//有图片附件
	public static final String FG_IMG= "Fg_img";
	//正异常判断规则
	public static final String ID_RULEREF= "Id_ruleref";
	//数据合法性规则
	public static final String ID_RULELEGAL= "Id_rulelegal";
	//五笔
	public static final String WBCODE= "Wbcode";
	//拼音
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//客户扩展字段1
	public static final String DEF1= "Def1";
	//客户扩展字段2
	public static final String DEF2= "Def2";
	//客户扩展字段3
	public static final String DEF3= "Def3";
	//客户扩展字段4
	public static final String DEF4= "Def4";
	//客户扩展字段5
	public static final String DEF5= "Def5";
	//客户扩展字段6
	public static final String DEF6= "Def6";
	//客户扩展字段7
	public static final String DEF7= "Def7";
	//客户扩展字段8
	public static final String DEF8= "Def8";
	//客户扩展字段9
	public static final String DEF9= "Def9";
	//客户扩展字段10
	public static final String DEF10= "Def10";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//报告分组编码
	public static final String SD_RPTPART= "Sd_rptpart";
	//报告分组ID
	public static final String ID_RPTPART= "Id_rptpart";
	//启用标识
	public static final String FG_ACTIVE= "Fg_active";
	//正常关键字
	public static final String NORMALKEY= "Normalkey";
	//报告模板
	public static final String RPTTEMP= "Rpttemp";
	//法律保护项
	public static final String FG_LEGAL= "Fg_legal";
	//合法低值
	public static final String VALID_LOW= "Valid_low";
	//合法高值
	public static final String VALID_HIGH= "Valid_high";
	//体检科室名称
	public static final String NAME_DEPT= "Name_dept";
	//体检科室编码
	public static final String CODE_DEPT= "Code_dept";
	//体检报告分组编码
	public static final String CODE_RPG= "Code_rpg";
	//体检报告分组名称
	public static final String NAME_RPG= "Name_rpg";
	//正异常规则名称
	public static final String NAME_RULEREF= "Name_ruleref";
	//正异常规则编码
	public static final String CODE_RULEREF= "Code_ruleref";
	//合法性规则名称
	public static final String NAME_RULELEGAL= "Name_rulelegal";
	//合法性规则编码
	public static final String CODE_RULELEGAL= "Code_rulelegal";
	//编码
	public static final String CODE_RPTPART= "Code_rptpart";
	//名称
	public static final String NAME_RPTPART= "Name_rptpart";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检结果主键标识
	 * @return String
	 */
	public String getId_pesrvitem() {
		return ((String) getAttrVal("Id_pesrvitem"));
	}	
	/**
	 * 体检结果主键标识
	 * @param Id_pesrvitem
	 */
	public void setId_pesrvitem(String Id_pesrvitem) {
		setAttrVal("Id_pesrvitem", Id_pesrvitem);
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
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 简称
	 * @return String
	 */
	public String getName_short() {
		return ((String) getAttrVal("Name_short"));
	}	
	/**
	 * 简称
	 * @param Name_short
	 */
	public void setName_short(String Name_short) {
		setAttrVal("Name_short", Name_short);
	}
	/**
	 * 英文名
	 * @return String
	 */
	public String getEname() {
		return ((String) getAttrVal("Ename"));
	}	
	/**
	 * 英文名
	 * @param Ename
	 */
	public void setEname(String Ename) {
		setAttrVal("Ename", Ename);
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
	 * 缺省状态
	 * @return Integer
	 */
	public Integer getDefault_status() {
		return ((Integer) getAttrVal("Default_status"));
	}	
	/**
	 * 缺省状态
	 * @param Default_status
	 */
	public void setDefault_status(Integer Default_status) {
		setAttrVal("Default_status", Default_status);
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
	 * 小数位数
	 * @return Integer
	 */
	public Integer getDigit() {
		return ((Integer) getAttrVal("Digit"));
	}	
	/**
	 * 小数位数
	 * @param Digit
	 */
	public void setDigit(Integer Digit) {
		setAttrVal("Digit", Digit);
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
	 * 参考范围
	 * @return String
	 */
	public String getReference() {
		return ((String) getAttrVal("Reference"));
	}	
	/**
	 * 参考范围
	 * @param Reference
	 */
	public void setReference(String Reference) {
		setAttrVal("Reference", Reference);
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
	 * 临床意义
	 * @return String
	 */
	public String getItm_introduction() {
		return ((String) getAttrVal("Itm_introduction"));
	}	
	/**
	 * 临床意义
	 * @param Itm_introduction
	 */
	public void setItm_introduction(String Itm_introduction) {
		setAttrVal("Itm_introduction", Itm_introduction);
	}
	/**
	 * 诊断分组标识
	 * @return Integer
	 */
	public Integer getDiag_group() {
		return ((Integer) getAttrVal("Diag_group"));
	}	
	/**
	 * 诊断分组标识
	 * @param Diag_group
	 */
	public void setDiag_group(Integer Diag_group) {
		setAttrVal("Diag_group", Diag_group);
	}
	/**
	 * 是否异常判断
	 * @return FBoolean
	 */
	public FBoolean getFg_abn() {
		return ((FBoolean) getAttrVal("Fg_abn"));
	}	
	/**
	 * 是否异常判断
	 * @param Fg_abn
	 */
	public void setFg_abn(FBoolean Fg_abn) {
		setAttrVal("Fg_abn", Fg_abn);
	}
	/**
	 * 总检显示标识
	 * @return FBoolean
	 */
	public FBoolean getFg_oval_show() {
		return ((FBoolean) getAttrVal("Fg_oval_show"));
	}	
	/**
	 * 总检显示标识
	 * @param Fg_oval_show
	 */
	public void setFg_oval_show(FBoolean Fg_oval_show) {
		setAttrVal("Fg_oval_show", Fg_oval_show);
	}
	/**
	 * 流程-检查时长
	 * @return Integer
	 */
	public Integer getChkduration() {
		return ((Integer) getAttrVal("Chkduration"));
	}	
	/**
	 * 流程-检查时长
	 * @param Chkduration
	 */
	public void setChkduration(Integer Chkduration) {
		setAttrVal("Chkduration", Chkduration);
	}
	/**
	 * 流程-空腹项目
	 * @return FBoolean
	 */
	public FBoolean getWf_before_meal() {
		return ((FBoolean) getAttrVal("Wf_before_meal"));
	}	
	/**
	 * 流程-空腹项目
	 * @param Wf_before_meal
	 */
	public void setWf_before_meal(FBoolean Wf_before_meal) {
		setAttrVal("Wf_before_meal", Wf_before_meal);
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
	 * 报告-打印标识
	 * @return FBoolean
	 */
	public FBoolean getFg_rp_print() {
		return ((FBoolean) getAttrVal("Fg_rp_print"));
	}	
	/**
	 * 报告-打印标识
	 * @param Fg_rp_print
	 */
	public void setFg_rp_print(FBoolean Fg_rp_print) {
		setAttrVal("Fg_rp_print", Fg_rp_print);
	}
	/**
	 * 报告-打印次序
	 * @return Integer
	 */
	public Integer getRp_printorder() {
		return ((Integer) getAttrVal("Rp_printorder"));
	}	
	/**
	 * 报告-打印次序
	 * @param Rp_printorder
	 */
	public void setRp_printorder(Integer Rp_printorder) {
		setAttrVal("Rp_printorder", Rp_printorder);
	}
	/**
	 * 报告-分组
	 * @return String
	 */
	public String getId_pesrvrptgrp() {
		return ((String) getAttrVal("Id_pesrvrptgrp"));
	}	
	/**
	 * 报告-分组
	 * @param Id_pesrvrptgrp
	 */
	public void setId_pesrvrptgrp(String Id_pesrvrptgrp) {
		setAttrVal("Id_pesrvrptgrp", Id_pesrvrptgrp);
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
	 * 客户扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 客户扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 客户扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 客户扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 客户扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 客户扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 客户扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	/**
	 * 客户扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 客户扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	/**
	 * 客户扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 * 客户扩展字段6
	 * @return String
	 */
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}	
	/**
	 * 客户扩展字段6
	 * @param Def6
	 */
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	/**
	 * 客户扩展字段7
	 * @return String
	 */
	public String getDef7() {
		return ((String) getAttrVal("Def7"));
	}	
	/**
	 * 客户扩展字段7
	 * @param Def7
	 */
	public void setDef7(String Def7) {
		setAttrVal("Def7", Def7);
	}
	/**
	 * 客户扩展字段8
	 * @return String
	 */
	public String getDef8() {
		return ((String) getAttrVal("Def8"));
	}	
	/**
	 * 客户扩展字段8
	 * @param Def8
	 */
	public void setDef8(String Def8) {
		setAttrVal("Def8", Def8);
	}
	/**
	 * 客户扩展字段9
	 * @return String
	 */
	public String getDef9() {
		return ((String) getAttrVal("Def9"));
	}	
	/**
	 * 客户扩展字段9
	 * @param Def9
	 */
	public void setDef9(String Def9) {
		setAttrVal("Def9", Def9);
	}
	/**
	 * 客户扩展字段10
	 * @return String
	 */
	public String getDef10() {
		return ((String) getAttrVal("Def10"));
	}	
	/**
	 * 客户扩展字段10
	 * @param Def10
	 */
	public void setDef10(String Def10) {
		setAttrVal("Def10", Def10);
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
	 * 报告分组编码
	 * @return String
	 */
	public String getSd_rptpart() {
		return ((String) getAttrVal("Sd_rptpart"));
	}	
	/**
	 * 报告分组编码
	 * @param Sd_rptpart
	 */
	public void setSd_rptpart(String Sd_rptpart) {
		setAttrVal("Sd_rptpart", Sd_rptpart);
	}
	/**
	 * 报告分组ID
	 * @return String
	 */
	public String getId_rptpart() {
		return ((String) getAttrVal("Id_rptpart"));
	}	
	/**
	 * 报告分组ID
	 * @param Id_rptpart
	 */
	public void setId_rptpart(String Id_rptpart) {
		setAttrVal("Id_rptpart", Id_rptpart);
	}
	/**
	 * 启用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标识
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
	 * 报告模板
	 * @return String
	 */
	public String getRpttemp() {
		return ((String) getAttrVal("Rpttemp"));
	}	
	/**
	 * 报告模板
	 * @param Rpttemp
	 */
	public void setRpttemp(String Rpttemp) {
		setAttrVal("Rpttemp", Rpttemp);
	}
	/**
	 * 法律保护项
	 * @return FBoolean
	 */
	public FBoolean getFg_legal() {
		return ((FBoolean) getAttrVal("Fg_legal"));
	}	
	/**
	 * 法律保护项
	 * @param Fg_legal
	 */
	public void setFg_legal(FBoolean Fg_legal) {
		setAttrVal("Fg_legal", Fg_legal);
	}
	/**
	 * 合法低值
	 * @return FDouble
	 */
	public FDouble getValid_low() {
		return ((FDouble) getAttrVal("Valid_low"));
	}	
	/**
	 * 合法低值
	 * @param Valid_low
	 */
	public void setValid_low(FDouble Valid_low) {
		setAttrVal("Valid_low", Valid_low);
	}
	/**
	 * 合法高值
	 * @return FDouble
	 */
	public FDouble getValid_high() {
		return ((FDouble) getAttrVal("Valid_high"));
	}	
	/**
	 * 合法高值
	 * @param Valid_high
	 */
	public void setValid_high(FDouble Valid_high) {
		setAttrVal("Valid_high", Valid_high);
	}
	/**
	 * 体检科室名称
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}	
	/**
	 * 体检科室名称
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	/**
	 * 体检科室编码
	 * @return String
	 */
	public String getCode_dept() {
		return ((String) getAttrVal("Code_dept"));
	}	
	/**
	 * 体检科室编码
	 * @param Code_dept
	 */
	public void setCode_dept(String Code_dept) {
		setAttrVal("Code_dept", Code_dept);
	}
	/**
	 * 体检报告分组编码
	 * @return String
	 */
	public String getCode_rpg() {
		return ((String) getAttrVal("Code_rpg"));
	}	
	/**
	 * 体检报告分组编码
	 * @param Code_rpg
	 */
	public void setCode_rpg(String Code_rpg) {
		setAttrVal("Code_rpg", Code_rpg);
	}
	/**
	 * 体检报告分组名称
	 * @return String
	 */
	public String getName_rpg() {
		return ((String) getAttrVal("Name_rpg"));
	}	
	/**
	 * 体检报告分组名称
	 * @param Name_rpg
	 */
	public void setName_rpg(String Name_rpg) {
		setAttrVal("Name_rpg", Name_rpg);
	}
	/**
	 * 正异常规则名称
	 * @return String
	 */
	public String getName_ruleref() {
		return ((String) getAttrVal("Name_ruleref"));
	}	
	/**
	 * 正异常规则名称
	 * @param Name_ruleref
	 */
	public void setName_ruleref(String Name_ruleref) {
		setAttrVal("Name_ruleref", Name_ruleref);
	}
	/**
	 * 正异常规则编码
	 * @return String
	 */
	public String getCode_ruleref() {
		return ((String) getAttrVal("Code_ruleref"));
	}	
	/**
	 * 正异常规则编码
	 * @param Code_ruleref
	 */
	public void setCode_ruleref(String Code_ruleref) {
		setAttrVal("Code_ruleref", Code_ruleref);
	}
	/**
	 * 合法性规则名称
	 * @return String
	 */
	public String getName_rulelegal() {
		return ((String) getAttrVal("Name_rulelegal"));
	}	
	/**
	 * 合法性规则名称
	 * @param Name_rulelegal
	 */
	public void setName_rulelegal(String Name_rulelegal) {
		setAttrVal("Name_rulelegal", Name_rulelegal);
	}
	/**
	 * 合法性规则编码
	 * @return String
	 */
	public String getCode_rulelegal() {
		return ((String) getAttrVal("Code_rulelegal"));
	}	
	/**
	 * 合法性规则编码
	 * @param Code_rulelegal
	 */
	public void setCode_rulelegal(String Code_rulelegal) {
		setAttrVal("Code_rulelegal", Code_rulelegal);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_rptpart() {
		return ((String) getAttrVal("Code_rptpart"));
	}	
	/**
	 * 编码
	 * @param Code_rptpart
	 */
	public void setCode_rptpart(String Code_rptpart) {
		setAttrVal("Code_rptpart", Code_rptpart);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_rptpart() {
		return ((String) getAttrVal("Name_rptpart"));
	}	
	/**
	 * 名称
	 * @param Name_rptpart
	 */
	public void setName_rptpart(String Name_rptpart) {
		setAttrVal("Name_rptpart", Name_rptpart);
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
		return "Id_pesrvitem";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_pesrvitem";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeSrvItemDODesc.class);
	}
	
}