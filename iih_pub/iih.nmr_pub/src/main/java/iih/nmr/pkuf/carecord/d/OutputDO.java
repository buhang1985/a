package iih.nmr.pkuf.carecord.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.pkuf.carecord.d.desc.OutputDODesc;
import java.math.BigDecimal;

/**
 * 排出量 DO数据 
 * 
 */
public class OutputDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//排出量主键
	public static final String ID_OUTPUT= "Id_output";
	//护理记录单主键
	public static final String ID_CARECORD= "Id_carecord";
	//排出名称id
	public static final String ID_DISCHARG_NAME= "Id_discharg_name";
	//排出名称
	public static final String NAME_DISCHARG_NAME= "Name_discharg_name";
	//排出名称编码
	public static final String SD_DISCHARG_NAME= "Sd_discharg_name";
	//排出部位
	public static final String DISCHARG_AREA= "Discharg_area";
	//排出量
	public static final String DISCHARG_AMOUNT= "Discharg_amount";
	//排出单位
	public static final String ID_DISCHARG_UNIT= "Id_discharg_unit";
	//排出单位编码
	public static final String SD_DISCHARG_UNIT= "Sd_discharg_unit";
	//颜色id
	public static final String ID_COLOR= "Id_color";
	//颜色
	public static final String NAME_COLOR= "Name_color";
	//颜色编码
	public static final String SD_COLOR= "Sd_color";
	//性状id
	public static final String ID_CHARACTER= "Id_character";
	//性状
	public static final String NAME_CHARACTER= "Name_character";
	//性状编码
	public static final String SD_CHARACTER= "Sd_character";
	//状况
	public static final String CONDITION= "Condition";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//单位
	public static final String NAME_DISCHARG_UNIT= "Name_discharg_unit";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 排出量主键
	 * @return String
	 */
	public String getId_output() {
		return ((String) getAttrVal("Id_output"));
	}	
	/**
	 * 排出量主键
	 * @param Id_output
	 */
	public void setId_output(String Id_output) {
		setAttrVal("Id_output", Id_output);
	}
	/**
	 * 护理记录单主键
	 * @return String
	 */
	public String getId_carecord() {
		return ((String) getAttrVal("Id_carecord"));
	}	
	/**
	 * 护理记录单主键
	 * @param Id_carecord
	 */
	public void setId_carecord(String Id_carecord) {
		setAttrVal("Id_carecord", Id_carecord);
	}
	/**
	 * 排出名称id
	 * @return String
	 */
	public String getId_discharg_name() {
		return ((String) getAttrVal("Id_discharg_name"));
	}	
	/**
	 * 排出名称id
	 * @param Id_discharg_name
	 */
	public void setId_discharg_name(String Id_discharg_name) {
		setAttrVal("Id_discharg_name", Id_discharg_name);
	}
	/**
	 * 排出名称
	 * @return String
	 */
	public String getName_discharg_name() {
		return ((String) getAttrVal("Name_discharg_name"));
	}	
	/**
	 * 排出名称
	 * @param Name_discharg_name
	 */
	public void setName_discharg_name(String Name_discharg_name) {
		setAttrVal("Name_discharg_name", Name_discharg_name);
	}
	/**
	 * 排出名称编码
	 * @return String
	 */
	public String getSd_discharg_name() {
		return ((String) getAttrVal("Sd_discharg_name"));
	}	
	/**
	 * 排出名称编码
	 * @param Sd_discharg_name
	 */
	public void setSd_discharg_name(String Sd_discharg_name) {
		setAttrVal("Sd_discharg_name", Sd_discharg_name);
	}
	/**
	 * 排出部位
	 * @return String
	 */
	public String getDischarg_area() {
		return ((String) getAttrVal("Discharg_area"));
	}	
	/**
	 * 排出部位
	 * @param Discharg_area
	 */
	public void setDischarg_area(String Discharg_area) {
		setAttrVal("Discharg_area", Discharg_area);
	}
	/**
	 * 排出量
	 * @return String
	 */
	public String getDischarg_amount() {
		return ((String) getAttrVal("Discharg_amount"));
	}	
	/**
	 * 排出量
	 * @param Discharg_amount
	 */
	public void setDischarg_amount(String Discharg_amount) {
		setAttrVal("Discharg_amount", Discharg_amount);
	}
	/**
	 * 排出单位
	 * @return String
	 */
	public String getId_discharg_unit() {
		return ((String) getAttrVal("Id_discharg_unit"));
	}	
	/**
	 * 排出单位
	 * @param Id_discharg_unit
	 */
	public void setId_discharg_unit(String Id_discharg_unit) {
		setAttrVal("Id_discharg_unit", Id_discharg_unit);
	}
	/**
	 * 排出单位编码
	 * @return String
	 */
	public String getSd_discharg_unit() {
		return ((String) getAttrVal("Sd_discharg_unit"));
	}	
	/**
	 * 排出单位编码
	 * @param Sd_discharg_unit
	 */
	public void setSd_discharg_unit(String Sd_discharg_unit) {
		setAttrVal("Sd_discharg_unit", Sd_discharg_unit);
	}
	/**
	 * 颜色id
	 * @return String
	 */
	public String getId_color() {
		return ((String) getAttrVal("Id_color"));
	}	
	/**
	 * 颜色id
	 * @param Id_color
	 */
	public void setId_color(String Id_color) {
		setAttrVal("Id_color", Id_color);
	}
	/**
	 * 颜色
	 * @return String
	 */
	public String getName_color() {
		return ((String) getAttrVal("Name_color"));
	}	
	/**
	 * 颜色
	 * @param Name_color
	 */
	public void setName_color(String Name_color) {
		setAttrVal("Name_color", Name_color);
	}
	/**
	 * 颜色编码
	 * @return String
	 */
	public String getSd_color() {
		return ((String) getAttrVal("Sd_color"));
	}	
	/**
	 * 颜色编码
	 * @param Sd_color
	 */
	public void setSd_color(String Sd_color) {
		setAttrVal("Sd_color", Sd_color);
	}
	/**
	 * 性状id
	 * @return String
	 */
	public String getId_character() {
		return ((String) getAttrVal("Id_character"));
	}	
	/**
	 * 性状id
	 * @param Id_character
	 */
	public void setId_character(String Id_character) {
		setAttrVal("Id_character", Id_character);
	}
	/**
	 * 性状
	 * @return String
	 */
	public String getName_character() {
		return ((String) getAttrVal("Name_character"));
	}	
	/**
	 * 性状
	 * @param Name_character
	 */
	public void setName_character(String Name_character) {
		setAttrVal("Name_character", Name_character);
	}
	/**
	 * 性状编码
	 * @return String
	 */
	public String getSd_character() {
		return ((String) getAttrVal("Sd_character"));
	}	
	/**
	 * 性状编码
	 * @param Sd_character
	 */
	public void setSd_character(String Sd_character) {
		setAttrVal("Sd_character", Sd_character);
	}
	/**
	 * 状况
	 * @return String
	 */
	public String getCondition() {
		return ((String) getAttrVal("Condition"));
	}	
	/**
	 * 状况
	 * @param Condition
	 */
	public void setCondition(String Condition) {
		setAttrVal("Condition", Condition);
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
	 * 单位
	 * @return String
	 */
	public String getName_discharg_unit() {
		return ((String) getAttrVal("Name_discharg_unit"));
	}	
	/**
	 * 单位
	 * @param Name_discharg_unit
	 */
	public void setName_discharg_unit(String Name_discharg_unit) {
		setAttrVal("Name_discharg_unit", Name_discharg_unit);
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
		return "Id_output";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_PKUF_OUTPUT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OutputDODesc.class);
	}
	
}