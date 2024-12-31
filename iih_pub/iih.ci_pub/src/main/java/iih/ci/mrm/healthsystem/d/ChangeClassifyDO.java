package iih.ci.mrm.healthsystem.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrm.healthsystem.d.desc.ChangeClassifyDODesc;
import java.math.BigDecimal;

/**
 * 转换分类 DO数据 
 * 
 */
public class ChangeClassifyDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//转换分类主键
	public static final String ID_CHG_CLASSIFY= "Id_chg_classify";
	//集团id
	public static final String ID_GRP= "Id_grp";
	//组织id
	public static final String ID_ORG= "Id_org";
	//转换分类编码
	public static final String CODE_CHG_CLASSIFY= "Code_chg_classify";
	//转换分类名称
	public static final String NAME_CHG_CLASSIFY= "Name_chg_classify";
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
	 * 转换分类主键
	 * @return String
	 */
	public String getId_chg_classify() {
		return ((String) getAttrVal("Id_chg_classify"));
	}	
	/**
	 * 转换分类主键
	 * @param Id_chg_classify
	 */
	public void setId_chg_classify(String Id_chg_classify) {
		setAttrVal("Id_chg_classify", Id_chg_classify);
	}
	/**
	 * 集团id
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团id
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 组织id
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织id
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 转换分类编码
	 * @return String
	 */
	public String getCode_chg_classify() {
		return ((String) getAttrVal("Code_chg_classify"));
	}	
	/**
	 * 转换分类编码
	 * @param Code_chg_classify
	 */
	public void setCode_chg_classify(String Code_chg_classify) {
		setAttrVal("Code_chg_classify", Code_chg_classify);
	}
	/**
	 * 转换分类名称
	 * @return String
	 */
	public String getName_chg_classify() {
		return ((String) getAttrVal("Name_chg_classify"));
	}	
	/**
	 * 转换分类名称
	 * @param Name_chg_classify
	 */
	public void setName_chg_classify(String Name_chg_classify) {
		setAttrVal("Name_chg_classify", Name_chg_classify);
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
		return "Id_chg_classify";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mrm_chg_classify";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ChangeClassifyDODesc.class);
	}
	
}