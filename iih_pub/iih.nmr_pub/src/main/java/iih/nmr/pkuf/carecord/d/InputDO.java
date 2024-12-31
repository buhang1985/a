package iih.nmr.pkuf.carecord.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.pkuf.carecord.d.desc.InputDODesc;
import java.math.BigDecimal;

/**
 * 摄入量 DO数据 
 * 
 */
public class InputDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//摄入量主键
	public static final String ID_INPUT= "Id_input";
	//护理记录单主键
	public static final String ID_CARECORD= "Id_carecord";
	//摄入名称id
	public static final String ID_INGESTION_NAME= "Id_ingestion_name";
	//摄入名称
	public static final String NAME_INGESTION_NAME= "Name_ingestion_name";
	//摄入名称编码
	public static final String SD_INGESTION_NAME= "Sd_ingestion_name";
	//摄入量
	public static final String INGESTION_AMOUNT= "Ingestion_amount";
	//摄入单位id
	public static final String ID_DISCHARG_UNIT_IN= "Id_discharg_unit_in";
	//摄入单位编码
	public static final String SD_DISCHARG_UNIT_IN= "Sd_discharg_unit_in";
	//摄入途径
	public static final String WAY= "Way";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//摄入单位
	public static final String NAME_INGESTION_UNIT_IN= "Name_ingestion_unit_in";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 摄入量主键
	 * @return String
	 */
	public String getId_input() {
		return ((String) getAttrVal("Id_input"));
	}	
	/**
	 * 摄入量主键
	 * @param Id_input
	 */
	public void setId_input(String Id_input) {
		setAttrVal("Id_input", Id_input);
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
	 * 摄入名称id
	 * @return String
	 */
	public String getId_ingestion_name() {
		return ((String) getAttrVal("Id_ingestion_name"));
	}	
	/**
	 * 摄入名称id
	 * @param Id_ingestion_name
	 */
	public void setId_ingestion_name(String Id_ingestion_name) {
		setAttrVal("Id_ingestion_name", Id_ingestion_name);
	}
	/**
	 * 摄入名称
	 * @return String
	 */
	public String getName_ingestion_name() {
		return ((String) getAttrVal("Name_ingestion_name"));
	}	
	/**
	 * 摄入名称
	 * @param Name_ingestion_name
	 */
	public void setName_ingestion_name(String Name_ingestion_name) {
		setAttrVal("Name_ingestion_name", Name_ingestion_name);
	}
	/**
	 * 摄入名称编码
	 * @return String
	 */
	public String getSd_ingestion_name() {
		return ((String) getAttrVal("Sd_ingestion_name"));
	}	
	/**
	 * 摄入名称编码
	 * @param Sd_ingestion_name
	 */
	public void setSd_ingestion_name(String Sd_ingestion_name) {
		setAttrVal("Sd_ingestion_name", Sd_ingestion_name);
	}
	/**
	 * 摄入量
	 * @return String
	 */
	public String getIngestion_amount() {
		return ((String) getAttrVal("Ingestion_amount"));
	}	
	/**
	 * 摄入量
	 * @param Ingestion_amount
	 */
	public void setIngestion_amount(String Ingestion_amount) {
		setAttrVal("Ingestion_amount", Ingestion_amount);
	}
	/**
	 * 摄入单位id
	 * @return String
	 */
	public String getId_discharg_unit_in() {
		return ((String) getAttrVal("Id_discharg_unit_in"));
	}	
	/**
	 * 摄入单位id
	 * @param Id_discharg_unit_in
	 */
	public void setId_discharg_unit_in(String Id_discharg_unit_in) {
		setAttrVal("Id_discharg_unit_in", Id_discharg_unit_in);
	}
	/**
	 * 摄入单位编码
	 * @return String
	 */
	public String getSd_discharg_unit_in() {
		return ((String) getAttrVal("Sd_discharg_unit_in"));
	}	
	/**
	 * 摄入单位编码
	 * @param Sd_discharg_unit_in
	 */
	public void setSd_discharg_unit_in(String Sd_discharg_unit_in) {
		setAttrVal("Sd_discharg_unit_in", Sd_discharg_unit_in);
	}
	/**
	 * 摄入途径
	 * @return String
	 */
	public String getWay() {
		return ((String) getAttrVal("Way"));
	}	
	/**
	 * 摄入途径
	 * @param Way
	 */
	public void setWay(String Way) {
		setAttrVal("Way", Way);
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
	 * 摄入单位
	 * @return String
	 */
	public String getName_ingestion_unit_in() {
		return ((String) getAttrVal("Name_ingestion_unit_in"));
	}	
	/**
	 * 摄入单位
	 * @param Name_ingestion_unit_in
	 */
	public void setName_ingestion_unit_in(String Name_ingestion_unit_in) {
		setAttrVal("Name_ingestion_unit_in", Name_ingestion_unit_in);
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
		return "Id_input";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_PKUF_INPUT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(InputDODesc.class);
	}
	
}