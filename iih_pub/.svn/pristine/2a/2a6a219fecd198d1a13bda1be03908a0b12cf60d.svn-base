package iih.ci.mrm.healthsystem.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrm.healthsystem.d.desc.DocContrastDODesc;
import java.math.BigDecimal;

/**
 * 表转换 DO数据 
 * 
 */
public class DocContrastDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//表转换主键
	public static final String ID_DOC_COMPARISON= "Id_doc_comparison";
	//对照外键（废弃）
	public static final String ID_COMPARISON= "Id_comparison";
	//对照类型（废弃）
	public static final String COMPARISON_TYPE= "Comparison_type";
	//文档编码_源（废弃）
	public static final String DOCCODE_SOURCE= "Doccode_source";
	//文档名称_源（废弃）
	public static final String DOCNAME_SOURCE= "Docname_source";
	//文档编码_目标（废弃）
	public static final String DOCCODE_GOAL= "Doccode_goal";
	//文档名称_目标（废弃）
	public static final String DOCNAME_GOAL= "Docname_goal";
	//数据抽取任务外键
	public static final String ID_EXTRACTDATA= "Id_extractdata";
	//转换编码
	public static final String CODE_DOC_COMPARISON= "Code_doc_comparison";
	//转换名称
	public static final String NAME_DOC_COMPARISON= "Name_doc_comparison";
	//查询类型
	public static final String QUERY_TYPE= "Query_type";
	//目标表名
	public static final String NAME_TAB_GOAL= "Name_tab_goal";
	//目标表存在时是否清空原有数据
	public static final String FG_CLEAR= "Fg_clear";
	//失败时是否终止任务
	public static final String FG_STOP= "Fg_stop";
	//查询方案
	public static final String QUERY_PLAN= "Query_plan";
	//序号
	public static final String SERIAL_NUMBER= "Serial_number";
	//数据抽取任务编码
	public static final String CODE_EXTRACTDATA= "Code_extractdata";
	//数据抽取任务名称
	public static final String NAME_EXTRACTDATA= "Name_extractdata";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 表转换主键
	 * @return String
	 */
	public String getId_doc_comparison() {
		return ((String) getAttrVal("Id_doc_comparison"));
	}	
	/**
	 * 表转换主键
	 * @param Id_doc_comparison
	 */
	public void setId_doc_comparison(String Id_doc_comparison) {
		setAttrVal("Id_doc_comparison", Id_doc_comparison);
	}
	/**
	 * 对照外键（废弃）
	 * @return String
	 */
	public String getId_comparison() {
		return ((String) getAttrVal("Id_comparison"));
	}	
	/**
	 * 对照外键（废弃）
	 * @param Id_comparison
	 */
	public void setId_comparison(String Id_comparison) {
		setAttrVal("Id_comparison", Id_comparison);
	}
	/**
	 * 对照类型（废弃）
	 * @return String
	 */
	public String getComparison_type() {
		return ((String) getAttrVal("Comparison_type"));
	}	
	/**
	 * 对照类型（废弃）
	 * @param Comparison_type
	 */
	public void setComparison_type(String Comparison_type) {
		setAttrVal("Comparison_type", Comparison_type);
	}
	/**
	 * 文档编码_源（废弃）
	 * @return String
	 */
	public String getDoccode_source() {
		return ((String) getAttrVal("Doccode_source"));
	}	
	/**
	 * 文档编码_源（废弃）
	 * @param Doccode_source
	 */
	public void setDoccode_source(String Doccode_source) {
		setAttrVal("Doccode_source", Doccode_source);
	}
	/**
	 * 文档名称_源（废弃）
	 * @return String
	 */
	public String getDocname_source() {
		return ((String) getAttrVal("Docname_source"));
	}	
	/**
	 * 文档名称_源（废弃）
	 * @param Docname_source
	 */
	public void setDocname_source(String Docname_source) {
		setAttrVal("Docname_source", Docname_source);
	}
	/**
	 * 文档编码_目标（废弃）
	 * @return String
	 */
	public String getDoccode_goal() {
		return ((String) getAttrVal("Doccode_goal"));
	}	
	/**
	 * 文档编码_目标（废弃）
	 * @param Doccode_goal
	 */
	public void setDoccode_goal(String Doccode_goal) {
		setAttrVal("Doccode_goal", Doccode_goal);
	}
	/**
	 * 文档名称_目标（废弃）
	 * @return String
	 */
	public String getDocname_goal() {
		return ((String) getAttrVal("Docname_goal"));
	}	
	/**
	 * 文档名称_目标（废弃）
	 * @param Docname_goal
	 */
	public void setDocname_goal(String Docname_goal) {
		setAttrVal("Docname_goal", Docname_goal);
	}
	/**
	 * 数据抽取任务外键
	 * @return String
	 */
	public String getId_extractdata() {
		return ((String) getAttrVal("Id_extractdata"));
	}	
	/**
	 * 数据抽取任务外键
	 * @param Id_extractdata
	 */
	public void setId_extractdata(String Id_extractdata) {
		setAttrVal("Id_extractdata", Id_extractdata);
	}
	/**
	 * 转换编码
	 * @return String
	 */
	public String getCode_doc_comparison() {
		return ((String) getAttrVal("Code_doc_comparison"));
	}	
	/**
	 * 转换编码
	 * @param Code_doc_comparison
	 */
	public void setCode_doc_comparison(String Code_doc_comparison) {
		setAttrVal("Code_doc_comparison", Code_doc_comparison);
	}
	/**
	 * 转换名称
	 * @return String
	 */
	public String getName_doc_comparison() {
		return ((String) getAttrVal("Name_doc_comparison"));
	}	
	/**
	 * 转换名称
	 * @param Name_doc_comparison
	 */
	public void setName_doc_comparison(String Name_doc_comparison) {
		setAttrVal("Name_doc_comparison", Name_doc_comparison);
	}
	/**
	 * 查询类型
	 * @return String
	 */
	public String getQuery_type() {
		return ((String) getAttrVal("Query_type"));
	}	
	/**
	 * 查询类型
	 * @param Query_type
	 */
	public void setQuery_type(String Query_type) {
		setAttrVal("Query_type", Query_type);
	}
	/**
	 * 目标表名
	 * @return String
	 */
	public String getName_tab_goal() {
		return ((String) getAttrVal("Name_tab_goal"));
	}	
	/**
	 * 目标表名
	 * @param Name_tab_goal
	 */
	public void setName_tab_goal(String Name_tab_goal) {
		setAttrVal("Name_tab_goal", Name_tab_goal);
	}
	/**
	 * 目标表存在时是否清空原有数据
	 * @return FBoolean
	 */
	public FBoolean getFg_clear() {
		return ((FBoolean) getAttrVal("Fg_clear"));
	}	
	/**
	 * 目标表存在时是否清空原有数据
	 * @param Fg_clear
	 */
	public void setFg_clear(FBoolean Fg_clear) {
		setAttrVal("Fg_clear", Fg_clear);
	}
	/**
	 * 失败时是否终止任务
	 * @return FBoolean
	 */
	public FBoolean getFg_stop() {
		return ((FBoolean) getAttrVal("Fg_stop"));
	}	
	/**
	 * 失败时是否终止任务
	 * @param Fg_stop
	 */
	public void setFg_stop(FBoolean Fg_stop) {
		setAttrVal("Fg_stop", Fg_stop);
	}
	/**
	 * 查询方案
	 * @return String
	 */
	public String getQuery_plan() {
		return ((String) getAttrVal("Query_plan"));
	}	
	/**
	 * 查询方案
	 * @param Query_plan
	 */
	public void setQuery_plan(String Query_plan) {
		setAttrVal("Query_plan", Query_plan);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSerial_number() {
		return ((Integer) getAttrVal("Serial_number"));
	}	
	/**
	 * 序号
	 * @param Serial_number
	 */
	public void setSerial_number(Integer Serial_number) {
		setAttrVal("Serial_number", Serial_number);
	}
	/**
	 * 数据抽取任务编码
	 * @return String
	 */
	public String getCode_extractdata() {
		return ((String) getAttrVal("Code_extractdata"));
	}	
	/**
	 * 数据抽取任务编码
	 * @param Code_extractdata
	 */
	public void setCode_extractdata(String Code_extractdata) {
		setAttrVal("Code_extractdata", Code_extractdata);
	}
	/**
	 * 数据抽取任务名称
	 * @return String
	 */
	public String getName_extractdata() {
		return ((String) getAttrVal("Name_extractdata"));
	}	
	/**
	 * 数据抽取任务名称
	 * @param Name_extractdata
	 */
	public void setName_extractdata(String Name_extractdata) {
		setAttrVal("Name_extractdata", Name_extractdata);
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
		return "Id_doc_comparison";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mrm_doc_contrast";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DocContrastDODesc.class);
	}
	
}