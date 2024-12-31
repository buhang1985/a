package iih.mc.st.mcoutrel.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mc.st.mcoutrel.d.desc.McOutRelDODesc;
import java.math.BigDecimal;

/**
 * 高值出库关联 DO数据 
 * 
 */
public class McOutRelDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//主键
	public static final String ID_REL= "Id_rel";
	//代销库出库主键
	public static final String ID_OUT= "Id_out";
	//代销库出库细目主键
	public static final String ID_OUT_ITM= "Id_out_itm";
	//正式库入库主键
	public static final String ID_INZS= "Id_inzs";
	//正式结存ID
	public static final String ID_BLZS= "Id_blzs";
	//正式库入库细目主键
	public static final String ID_INZS_ITM= "Id_inzs_itm";
	//正式库出库主键
	public static final String ID_OUTZS= "Id_outzs";
	//正式库出库细目主键
	public static final String ID_OUTZS_ITM= "Id_outzs_itm";
	//代销结存ID
	public static final String ID_BLDX= "Id_bldx";
	//唯一码
	public static final String ONLYCODE= "Onlycode";
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
	 * 主键
	 * @return String
	 */
	public String getId_rel() {
		return ((String) getAttrVal("Id_rel"));
	}	
	/**
	 * 主键
	 * @param Id_rel
	 */
	public void setId_rel(String Id_rel) {
		setAttrVal("Id_rel", Id_rel);
	}
	/**
	 * 代销库出库主键
	 * @return String
	 */
	public String getId_out() {
		return ((String) getAttrVal("Id_out"));
	}	
	/**
	 * 代销库出库主键
	 * @param Id_out
	 */
	public void setId_out(String Id_out) {
		setAttrVal("Id_out", Id_out);
	}
	/**
	 * 代销库出库细目主键
	 * @return String
	 */
	public String getId_out_itm() {
		return ((String) getAttrVal("Id_out_itm"));
	}	
	/**
	 * 代销库出库细目主键
	 * @param Id_out_itm
	 */
	public void setId_out_itm(String Id_out_itm) {
		setAttrVal("Id_out_itm", Id_out_itm);
	}
	/**
	 * 正式库入库主键
	 * @return String
	 */
	public String getId_inzs() {
		return ((String) getAttrVal("Id_inzs"));
	}	
	/**
	 * 正式库入库主键
	 * @param Id_inzs
	 */
	public void setId_inzs(String Id_inzs) {
		setAttrVal("Id_inzs", Id_inzs);
	}
	/**
	 * 正式结存ID
	 * @return String
	 */
	public String getId_blzs() {
		return ((String) getAttrVal("Id_blzs"));
	}	
	/**
	 * 正式结存ID
	 * @param Id_blzs
	 */
	public void setId_blzs(String Id_blzs) {
		setAttrVal("Id_blzs", Id_blzs);
	}
	/**
	 * 正式库入库细目主键
	 * @return String
	 */
	public String getId_inzs_itm() {
		return ((String) getAttrVal("Id_inzs_itm"));
	}	
	/**
	 * 正式库入库细目主键
	 * @param Id_inzs_itm
	 */
	public void setId_inzs_itm(String Id_inzs_itm) {
		setAttrVal("Id_inzs_itm", Id_inzs_itm);
	}
	/**
	 * 正式库出库主键
	 * @return String
	 */
	public String getId_outzs() {
		return ((String) getAttrVal("Id_outzs"));
	}	
	/**
	 * 正式库出库主键
	 * @param Id_outzs
	 */
	public void setId_outzs(String Id_outzs) {
		setAttrVal("Id_outzs", Id_outzs);
	}
	/**
	 * 正式库出库细目主键
	 * @return String
	 */
	public String getId_outzs_itm() {
		return ((String) getAttrVal("Id_outzs_itm"));
	}	
	/**
	 * 正式库出库细目主键
	 * @param Id_outzs_itm
	 */
	public void setId_outzs_itm(String Id_outzs_itm) {
		setAttrVal("Id_outzs_itm", Id_outzs_itm);
	}
	/**
	 * 代销结存ID
	 * @return String
	 */
	public String getId_bldx() {
		return ((String) getAttrVal("Id_bldx"));
	}	
	/**
	 * 代销结存ID
	 * @param Id_bldx
	 */
	public void setId_bldx(String Id_bldx) {
		setAttrVal("Id_bldx", Id_bldx);
	}
	/**
	 * 唯一码
	 * @return String
	 */
	public String getOnlycode() {
		return ((String) getAttrVal("Onlycode"));
	}	
	/**
	 * 唯一码
	 * @param Onlycode
	 */
	public void setOnlycode(String Onlycode) {
		setAttrVal("Onlycode", Onlycode);
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
		return "Id_rel";
	}
	
	@Override
	public String getTableName() {	  
		return "mc_out_rel";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(McOutRelDODesc.class);
	}
	
}