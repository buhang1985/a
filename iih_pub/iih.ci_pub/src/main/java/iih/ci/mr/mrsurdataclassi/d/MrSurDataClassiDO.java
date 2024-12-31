package iih.ci.mr.mrsurdataclassi.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.mrsurdataclassi.d.desc.MrSurDataClassiDODesc;
import java.math.BigDecimal;

/**
 * 病历手术资料分类 DO数据 
 * 
 */
public class MrSurDataClassiDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//病历手术资料分类主键
	public static final String ID_SURDATA_CLASSI= "Id_surdata_classi";
	//就诊号
	public static final String ID_ENT= "Id_ent";
	//医疗记录类型
	public static final String ID_MRCACTM= "Id_mrcactm";
	//手术名称
	public static final String NAME_OPERATION= "Name_operation";
	//手术编码
	public static final String CODE_OPERATION= "Code_operation";
	//计划手术时间
	public static final String TIME_OPERATION= "Time_operation";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//医疗记录类型编码
	public static final String MRTP_CODE= "Mrtp_code";
	//医疗记录类型名称
	public static final String MRTP_NAME= "Mrtp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 病历手术资料分类主键
	 * @return String
	 */
	public String getId_surdata_classi() {
		return ((String) getAttrVal("Id_surdata_classi"));
	}	
	/**
	 * 病历手术资料分类主键
	 * @param Id_surdata_classi
	 */
	public void setId_surdata_classi(String Id_surdata_classi) {
		setAttrVal("Id_surdata_classi", Id_surdata_classi);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊号
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 医疗记录类型
	 * @return String
	 */
	public String getId_mrcactm() {
		return ((String) getAttrVal("Id_mrcactm"));
	}	
	/**
	 * 医疗记录类型
	 * @param Id_mrcactm
	 */
	public void setId_mrcactm(String Id_mrcactm) {
		setAttrVal("Id_mrcactm", Id_mrcactm);
	}
	/**
	 * 手术名称
	 * @return String
	 */
	public String getName_operation() {
		return ((String) getAttrVal("Name_operation"));
	}	
	/**
	 * 手术名称
	 * @param Name_operation
	 */
	public void setName_operation(String Name_operation) {
		setAttrVal("Name_operation", Name_operation);
	}
	/**
	 * 手术编码
	 * @return String
	 */
	public String getCode_operation() {
		return ((String) getAttrVal("Code_operation"));
	}	
	/**
	 * 手术编码
	 * @param Code_operation
	 */
	public void setCode_operation(String Code_operation) {
		setAttrVal("Code_operation", Code_operation);
	}
	/**
	 * 计划手术时间
	 * @return FDateTime
	 */
	public FDateTime getTime_operation() {
		return ((FDateTime) getAttrVal("Time_operation"));
	}	
	/**
	 * 计划手术时间
	 * @param Time_operation
	 */
	public void setTime_operation(FDateTime Time_operation) {
		setAttrVal("Time_operation", Time_operation);
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
	 * 医疗记录类型编码
	 * @return String
	 */
	public String getMrtp_code() {
		return ((String) getAttrVal("Mrtp_code"));
	}	
	/**
	 * 医疗记录类型编码
	 * @param Mrtp_code
	 */
	public void setMrtp_code(String Mrtp_code) {
		setAttrVal("Mrtp_code", Mrtp_code);
	}
	/**
	 * 医疗记录类型名称
	 * @return String
	 */
	public String getMrtp_name() {
		return ((String) getAttrVal("Mrtp_name"));
	}	
	/**
	 * 医疗记录类型名称
	 * @param Mrtp_name
	 */
	public void setMrtp_name(String Mrtp_name) {
		setAttrVal("Mrtp_name", Mrtp_name);
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
		return "Id_surdata_classi";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_surdata_classi";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MrSurDataClassiDODesc.class);
	}
	
}