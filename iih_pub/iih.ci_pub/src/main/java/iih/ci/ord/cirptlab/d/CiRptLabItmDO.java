package iih.ci.ord.cirptlab.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cirptlab.d.desc.CiRptLabItmDODesc;
import java.math.BigDecimal;

/**
 * 检验报告单明细 DO数据 
 * 
 */
public class CiRptLabItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//检验报告单明细主键
	public static final String ID_RPTLISITM= "Id_rptlisitm";
	//检验报告单主键
	public static final String ID_RPTLAB= "Id_rptlab";
	//检验项目服务
	public static final String ID_SRV= "Id_srv";
	//检验项目名称
	public static final String NAME_SRV= "Name_srv";
	//序号
	public static final String SORTNO= "Sortno";
	//参考值
	public static final String VAL_REFERENCE= "Val_reference";
	//最大值
	public static final String VAL_MAX= "Val_max";
	//最小值
	public static final String VAL_MIN= "Val_min";
	//结果值
	public static final String VAL_RSTRPTLAB= "Val_rstrptlab";
	//单位
	public static final String ID_UNIT= "Id_unit";
	//偏离值id
	public static final String ID_DEVIATE= "Id_deviate";
	//偏离值编码
	public static final String SD_DEVIATE= "Sd_deviate";
	//检验结果值类型
	public static final String SD_RESTRPTLABTP= "Sd_restrptlabtp";
	//检验结果值域
	public static final String VAL_RANGE= "Val_range";
	//单位名称
	public static final String NAME_UNIT= "Name_unit";
	//参考范围
	public static final String REFERENCE_RANGES= "Reference_ranges";
	//lis系统项目code
	public static final String LIS_CODE_SRV= "Lis_code_srv";
	//结果状态sd
	public static final String SD_VAL_STATE= "Sd_val_state";
	//危急值标志
	public static final String FG_CRISIS= "Fg_crisis";
	//结果状态Id
	public static final String ID_VAL_STATE= "Id_val_state";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//简称
	public static final String SHORTNAME= "Shortname";
	//计量单位名称
	public static final String UNIT_NAME= "Unit_name";
	//名称
	public static final String NAME_DEVIATE= "Name_deviate";
	//结果状态名称
	public static final String NAME_VAL_STATE= "Name_val_state";
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
	 * 检验项目服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 检验项目服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 检验项目名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	/**
	 * 检验项目名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
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
	 * 单位
	 * @return String
	 */
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}	
	/**
	 * 单位
	 * @param Id_unit
	 */
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	/**
	 * 偏离值id
	 * @return String
	 */
	public String getId_deviate() {
		return ((String) getAttrVal("Id_deviate"));
	}	
	/**
	 * 偏离值id
	 * @param Id_deviate
	 */
	public void setId_deviate(String Id_deviate) {
		setAttrVal("Id_deviate", Id_deviate);
	}
	/**
	 * 偏离值编码
	 * @return String
	 */
	public String getSd_deviate() {
		return ((String) getAttrVal("Sd_deviate"));
	}	
	/**
	 * 偏离值编码
	 * @param Sd_deviate
	 */
	public void setSd_deviate(String Sd_deviate) {
		setAttrVal("Sd_deviate", Sd_deviate);
	}
	/**
	 * 检验结果值类型
	 * @return String
	 */
	public String getSd_restrptlabtp() {
		return ((String) getAttrVal("Sd_restrptlabtp"));
	}	
	/**
	 * 检验结果值类型
	 * @param Sd_restrptlabtp
	 */
	public void setSd_restrptlabtp(String Sd_restrptlabtp) {
		setAttrVal("Sd_restrptlabtp", Sd_restrptlabtp);
	}
	/**
	 * 检验结果值域
	 * @return String
	 */
	public String getVal_range() {
		return ((String) getAttrVal("Val_range"));
	}	
	/**
	 * 检验结果值域
	 * @param Val_range
	 */
	public void setVal_range(String Val_range) {
		setAttrVal("Val_range", Val_range);
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
	 * 参考范围
	 * @return String
	 */
	public String getReference_ranges() {
		return ((String) getAttrVal("Reference_ranges"));
	}	
	/**
	 * 参考范围
	 * @param Reference_ranges
	 */
	public void setReference_ranges(String Reference_ranges) {
		setAttrVal("Reference_ranges", Reference_ranges);
	}
	/**
	 * lis系统项目code
	 * @return String
	 */
	public String getLis_code_srv() {
		return ((String) getAttrVal("Lis_code_srv"));
	}	
	/**
	 * lis系统项目code
	 * @param Lis_code_srv
	 */
	public void setLis_code_srv(String Lis_code_srv) {
		setAttrVal("Lis_code_srv", Lis_code_srv);
	}
	/**
	 * 结果状态sd
	 * @return String
	 */
	public String getSd_val_state() {
		return ((String) getAttrVal("Sd_val_state"));
	}	
	/**
	 * 结果状态sd
	 * @param Sd_val_state
	 */
	public void setSd_val_state(String Sd_val_state) {
		setAttrVal("Sd_val_state", Sd_val_state);
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
	 * 结果状态Id
	 * @return String
	 */
	public String getId_val_state() {
		return ((String) getAttrVal("Id_val_state"));
	}	
	/**
	 * 结果状态Id
	 * @param Id_val_state
	 */
	public void setId_val_state(String Id_val_state) {
		setAttrVal("Id_val_state", Id_val_state);
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
	 * 简称
	 * @return String
	 */
	public String getShortname() {
		return ((String) getAttrVal("Shortname"));
	}	
	/**
	 * 简称
	 * @param Shortname
	 */
	public void setShortname(String Shortname) {
		setAttrVal("Shortname", Shortname);
	}
	/**
	 * 计量单位名称
	 * @return String
	 */
	public String getUnit_name() {
		return ((String) getAttrVal("Unit_name"));
	}	
	/**
	 * 计量单位名称
	 * @param Unit_name
	 */
	public void setUnit_name(String Unit_name) {
		setAttrVal("Unit_name", Unit_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_deviate() {
		return ((String) getAttrVal("Name_deviate"));
	}	
	/**
	 * 名称
	 * @param Name_deviate
	 */
	public void setName_deviate(String Name_deviate) {
		setAttrVal("Name_deviate", Name_deviate);
	}
	/**
	 * 结果状态名称
	 * @return String
	 */
	public String getName_val_state() {
		return ((String) getAttrVal("Name_val_state"));
	}	
	/**
	 * 结果状态名称
	 * @param Name_val_state
	 */
	public void setName_val_state(String Name_val_state) {
		setAttrVal("Name_val_state", Name_val_state);
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
		return "CI_RPT_LAB_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiRptLabItmDODesc.class);
	}
	
}