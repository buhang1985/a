package iih.bd.cmp.marplan.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.cmp.marplan.d.desc.BdCmpMarChkDODesc;
import java.math.BigDecimal;

/**
 * 营销方案验证介质 DO数据 
 * 
 */
public class BdCmpMarChkDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//营销方案验证介质id
	public static final String ID_MARPLANCHK= "Id_marplanchk";
	//营销方案id
	public static final String ID_MARPLAN= "Id_marplan";
	//验证介质类型
	public static final String ID_KEYTP= "Id_keytp";
	//验证介质类型编码
	public static final String SD_KEYTP= "Sd_keytp";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//编码
	public static final String CODE_KEYTP= "Code_keytp";
	//名称
	public static final String NAME_KEYTP= "Name_keytp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 营销方案验证介质id
	 * @return String
	 */
	public String getId_marplanchk() {
		return ((String) getAttrVal("Id_marplanchk"));
	}	
	/**
	 * 营销方案验证介质id
	 * @param Id_marplanchk
	 */
	public void setId_marplanchk(String Id_marplanchk) {
		setAttrVal("Id_marplanchk", Id_marplanchk);
	}
	/**
	 * 营销方案id
	 * @return String
	 */
	public String getId_marplan() {
		return ((String) getAttrVal("Id_marplan"));
	}	
	/**
	 * 营销方案id
	 * @param Id_marplan
	 */
	public void setId_marplan(String Id_marplan) {
		setAttrVal("Id_marplan", Id_marplan);
	}
	/**
	 * 验证介质类型
	 * @return String
	 */
	public String getId_keytp() {
		return ((String) getAttrVal("Id_keytp"));
	}	
	/**
	 * 验证介质类型
	 * @param Id_keytp
	 */
	public void setId_keytp(String Id_keytp) {
		setAttrVal("Id_keytp", Id_keytp);
	}
	/**
	 * 验证介质类型编码
	 * @return String
	 */
	public String getSd_keytp() {
		return ((String) getAttrVal("Sd_keytp"));
	}	
	/**
	 * 验证介质类型编码
	 * @param Sd_keytp
	 */
	public void setSd_keytp(String Sd_keytp) {
		setAttrVal("Sd_keytp", Sd_keytp);
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
	 * 编码
	 * @return String
	 */
	public String getCode_keytp() {
		return ((String) getAttrVal("Code_keytp"));
	}	
	/**
	 * 编码
	 * @param Code_keytp
	 */
	public void setCode_keytp(String Code_keytp) {
		setAttrVal("Code_keytp", Code_keytp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_keytp() {
		return ((String) getAttrVal("Name_keytp"));
	}	
	/**
	 * 名称
	 * @param Name_keytp
	 */
	public void setName_keytp(String Name_keytp) {
		setAttrVal("Name_keytp", Name_keytp);
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
		return "Id_marplanchk";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mar_chk";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdCmpMarChkDODesc.class);
	}
	
}