package iih.bd.cmp.marplan.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.cmp.marplan.d.desc.BdCmpMarCtrDODesc;
import java.math.BigDecimal;

/**
 * 营销方案的限制 DO数据 
 * 
 */
public class BdCmpMarCtrDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//营销方案限制id
	public static final String ID_MARPLANCTR= "Id_marplanctr";
	//营销方案id
	public static final String ID_MARPLAN= "Id_marplan";
	//限制指标
	public static final String ID_MARPLANCTRITM= "Id_marplanctritm";
	//限制指标编码
	public static final String SD_MARPLANCTRITM= "Sd_marplanctritm";
	//限制值
	public static final String VALUE= "Value";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//编码
	public static final String CODE_MARPLANCTRITM= "Code_marplanctritm";
	//名称
	public static final String NAME_MARPLANCTRITM= "Name_marplanctritm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 营销方案限制id
	 * @return String
	 */
	public String getId_marplanctr() {
		return ((String) getAttrVal("Id_marplanctr"));
	}	
	/**
	 * 营销方案限制id
	 * @param Id_marplanctr
	 */
	public void setId_marplanctr(String Id_marplanctr) {
		setAttrVal("Id_marplanctr", Id_marplanctr);
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
	 * 限制指标
	 * @return String
	 */
	public String getId_marplanctritm() {
		return ((String) getAttrVal("Id_marplanctritm"));
	}	
	/**
	 * 限制指标
	 * @param Id_marplanctritm
	 */
	public void setId_marplanctritm(String Id_marplanctritm) {
		setAttrVal("Id_marplanctritm", Id_marplanctritm);
	}
	/**
	 * 限制指标编码
	 * @return String
	 */
	public String getSd_marplanctritm() {
		return ((String) getAttrVal("Sd_marplanctritm"));
	}	
	/**
	 * 限制指标编码
	 * @param Sd_marplanctritm
	 */
	public void setSd_marplanctritm(String Sd_marplanctritm) {
		setAttrVal("Sd_marplanctritm", Sd_marplanctritm);
	}
	/**
	 * 限制值
	 * @return String
	 */
	public String getValue() {
		return ((String) getAttrVal("Value"));
	}	
	/**
	 * 限制值
	 * @param Value
	 */
	public void setValue(String Value) {
		setAttrVal("Value", Value);
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
	public String getCode_marplanctritm() {
		return ((String) getAttrVal("Code_marplanctritm"));
	}	
	/**
	 * 编码
	 * @param Code_marplanctritm
	 */
	public void setCode_marplanctritm(String Code_marplanctritm) {
		setAttrVal("Code_marplanctritm", Code_marplanctritm);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_marplanctritm() {
		return ((String) getAttrVal("Name_marplanctritm"));
	}	
	/**
	 * 名称
	 * @param Name_marplanctritm
	 */
	public void setName_marplanctritm(String Name_marplanctritm) {
		setAttrVal("Name_marplanctritm", Name_marplanctritm);
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
		return "Id_marplanctr";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mar_ctr";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdCmpMarCtrDODesc.class);
	}
	
}