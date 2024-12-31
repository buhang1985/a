package iih.ci.mrm.healthsystem.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrm.healthsystem.d.desc.ExtractDataDODesc;
import java.math.BigDecimal;

/**
 * 数据抽取任务 DO数据 
 * 
 */
public class ExtractDataDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//数据抽取任务主键
	public static final String ID_EXTRACTDATA= "Id_extractdata";
	//转换分类外键
	public static final String ID_CHG_CLASSIFY= "Id_chg_classify";
	//任务编码
	public static final String CODE_EXTRACTDATA= "Code_extractdata";
	//任务名称
	public static final String NAME_EXTRACTDATA= "Name_extractdata";
	//数据格式
	public static final String DATA_FORMAT= "Data_format";
	//文件格式
	public static final String FILE_FORMAT= "File_format";
	//文件存放位置
	public static final String FILE_URL= "File_url";
	//文件名产生规则
	public static final String FILE_NAME_RULE= "File_name_rule";
	//任务执行类型
	public static final String TASK_TYPE= "Task_type";
	//任务周期单位
	public static final String TASK_PERIOD= "Task_period";
	//执行日
	public static final String TASK_NUMBER= "Task_number";
	//执行日期
	public static final String TASK_DATE= "Task_date";
	//执行时间
	public static final String TASK_TIME= "Task_time";
	//序号
	public static final String SERIAL_NUMBER= "Serial_number";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 数据抽取任务主键
	 * @return String
	 */
	public String getId_extractdata() {
		return ((String) getAttrVal("Id_extractdata"));
	}	
	/**
	 * 数据抽取任务主键
	 * @param Id_extractdata
	 */
	public void setId_extractdata(String Id_extractdata) {
		setAttrVal("Id_extractdata", Id_extractdata);
	}
	/**
	 * 转换分类外键
	 * @return String
	 */
	public String getId_chg_classify() {
		return ((String) getAttrVal("Id_chg_classify"));
	}	
	/**
	 * 转换分类外键
	 * @param Id_chg_classify
	 */
	public void setId_chg_classify(String Id_chg_classify) {
		setAttrVal("Id_chg_classify", Id_chg_classify);
	}
	/**
	 * 任务编码
	 * @return String
	 */
	public String getCode_extractdata() {
		return ((String) getAttrVal("Code_extractdata"));
	}	
	/**
	 * 任务编码
	 * @param Code_extractdata
	 */
	public void setCode_extractdata(String Code_extractdata) {
		setAttrVal("Code_extractdata", Code_extractdata);
	}
	/**
	 * 任务名称
	 * @return String
	 */
	public String getName_extractdata() {
		return ((String) getAttrVal("Name_extractdata"));
	}	
	/**
	 * 任务名称
	 * @param Name_extractdata
	 */
	public void setName_extractdata(String Name_extractdata) {
		setAttrVal("Name_extractdata", Name_extractdata);
	}
	/**
	 * 数据格式
	 * @return String
	 */
	public String getData_format() {
		return ((String) getAttrVal("Data_format"));
	}	
	/**
	 * 数据格式
	 * @param Data_format
	 */
	public void setData_format(String Data_format) {
		setAttrVal("Data_format", Data_format);
	}
	/**
	 * 文件格式
	 * @return String
	 */
	public String getFile_format() {
		return ((String) getAttrVal("File_format"));
	}	
	/**
	 * 文件格式
	 * @param File_format
	 */
	public void setFile_format(String File_format) {
		setAttrVal("File_format", File_format);
	}
	/**
	 * 文件存放位置
	 * @return String
	 */
	public String getFile_url() {
		return ((String) getAttrVal("File_url"));
	}	
	/**
	 * 文件存放位置
	 * @param File_url
	 */
	public void setFile_url(String File_url) {
		setAttrVal("File_url", File_url);
	}
	/**
	 * 文件名产生规则
	 * @return String
	 */
	public String getFile_name_rule() {
		return ((String) getAttrVal("File_name_rule"));
	}	
	/**
	 * 文件名产生规则
	 * @param File_name_rule
	 */
	public void setFile_name_rule(String File_name_rule) {
		setAttrVal("File_name_rule", File_name_rule);
	}
	/**
	 * 任务执行类型
	 * @return String
	 */
	public String getTask_type() {
		return ((String) getAttrVal("Task_type"));
	}	
	/**
	 * 任务执行类型
	 * @param Task_type
	 */
	public void setTask_type(String Task_type) {
		setAttrVal("Task_type", Task_type);
	}
	/**
	 * 任务周期单位
	 * @return String
	 */
	public String getTask_period() {
		return ((String) getAttrVal("Task_period"));
	}	
	/**
	 * 任务周期单位
	 * @param Task_period
	 */
	public void setTask_period(String Task_period) {
		setAttrVal("Task_period", Task_period);
	}
	/**
	 * 执行日
	 * @return Integer
	 */
	public Integer getTask_number() {
		return ((Integer) getAttrVal("Task_number"));
	}	
	/**
	 * 执行日
	 * @param Task_number
	 */
	public void setTask_number(Integer Task_number) {
		setAttrVal("Task_number", Task_number);
	}
	/**
	 * 执行日期
	 * @return String
	 */
	public String getTask_date() {
		return ((String) getAttrVal("Task_date"));
	}	
	/**
	 * 执行日期
	 * @param Task_date
	 */
	public void setTask_date(String Task_date) {
		setAttrVal("Task_date", Task_date);
	}
	/**
	 * 执行时间
	 * @return String
	 */
	public String getTask_time() {
		return ((String) getAttrVal("Task_time"));
	}	
	/**
	 * 执行时间
	 * @param Task_time
	 */
	public void setTask_time(String Task_time) {
		setAttrVal("Task_time", Task_time);
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
		return "Id_extractdata";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mrm_extract";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ExtractDataDODesc.class);
	}
	
}