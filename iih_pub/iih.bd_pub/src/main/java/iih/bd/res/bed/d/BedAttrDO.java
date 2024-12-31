package iih.bd.res.bed.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.res.bed.d.desc.BedAttrDODesc;
import java.math.BigDecimal;

/**
 * 床位特征 DO数据 
 * 
 */
public class BedAttrDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//床位属性id
	public static final String ID_BEDATTR= "Id_bedattr";
	//床位id
	public static final String ID_BED= "Id_bed";
	//特征类型id
	public static final String ID_BEDATTR_TP= "Id_bedattr_tp";
	//特征类型编码
	public static final String SD_BEDATTR_TP= "Sd_bedattr_tp";
	//特征类型名称
	public static final String NAME_BEDATTR_TP= "Name_bedattr_tp";
	//特征值
	public static final String VAL= "Val";
	//特征值Id
	public static final String ID_ATTRDEF= "Id_attrdef";
	//特征类型名称
	public static final String BEDATTR_TP_NAME= "Bedattr_tp_name";
	//特征值名称
	public static final String ATTRDEF_NAME= "Attrdef_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 床位属性id
	 * @return String
	 */
	public String getId_bedattr() {
		return ((String) getAttrVal("Id_bedattr"));
	}	
	/**
	 * 床位属性id
	 * @param Id_bedattr
	 */
	public void setId_bedattr(String Id_bedattr) {
		setAttrVal("Id_bedattr", Id_bedattr);
	}
	/**
	 * 床位id
	 * @return String
	 */
	public String getId_bed() {
		return ((String) getAttrVal("Id_bed"));
	}	
	/**
	 * 床位id
	 * @param Id_bed
	 */
	public void setId_bed(String Id_bed) {
		setAttrVal("Id_bed", Id_bed);
	}
	/**
	 * 特征类型id
	 * @return String
	 */
	public String getId_bedattr_tp() {
		return ((String) getAttrVal("Id_bedattr_tp"));
	}	
	/**
	 * 特征类型id
	 * @param Id_bedattr_tp
	 */
	public void setId_bedattr_tp(String Id_bedattr_tp) {
		setAttrVal("Id_bedattr_tp", Id_bedattr_tp);
	}
	/**
	 * 特征类型编码
	 * @return String
	 */
	public String getSd_bedattr_tp() {
		return ((String) getAttrVal("Sd_bedattr_tp"));
	}	
	/**
	 * 特征类型编码
	 * @param Sd_bedattr_tp
	 */
	public void setSd_bedattr_tp(String Sd_bedattr_tp) {
		setAttrVal("Sd_bedattr_tp", Sd_bedattr_tp);
	}
	/**
	 * 特征类型名称
	 * @return String
	 */
	public String getName_bedattr_tp() {
		return ((String) getAttrVal("Name_bedattr_tp"));
	}	
	/**
	 * 特征类型名称
	 * @param Name_bedattr_tp
	 */
	public void setName_bedattr_tp(String Name_bedattr_tp) {
		setAttrVal("Name_bedattr_tp", Name_bedattr_tp);
	}
	/**
	 * 特征值
	 * @return String
	 */
	public String getVal() {
		return ((String) getAttrVal("Val"));
	}	
	/**
	 * 特征值
	 * @param Val
	 */
	public void setVal(String Val) {
		setAttrVal("Val", Val);
	}
	/**
	 * 特征值Id
	 * @return String
	 */
	public String getId_attrdef() {
		return ((String) getAttrVal("Id_attrdef"));
	}	
	/**
	 * 特征值Id
	 * @param Id_attrdef
	 */
	public void setId_attrdef(String Id_attrdef) {
		setAttrVal("Id_attrdef", Id_attrdef);
	}
	/**
	 * 特征类型名称
	 * @return String
	 */
	public String getBedattr_tp_name() {
		return ((String) getAttrVal("Bedattr_tp_name"));
	}	
	/**
	 * 特征类型名称
	 * @param Bedattr_tp_name
	 */
	public void setBedattr_tp_name(String Bedattr_tp_name) {
		setAttrVal("Bedattr_tp_name", Bedattr_tp_name);
	}
	/**
	 * 特征值名称
	 * @return String
	 */
	public String getAttrdef_name() {
		return ((String) getAttrVal("Attrdef_name"));
	}	
	/**
	 * 特征值名称
	 * @param Attrdef_name
	 */
	public void setAttrdef_name(String Attrdef_name) {
		setAttrVal("Attrdef_name", Attrdef_name);
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
		return "Id_bedattr";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_BED_ATTR";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BedAttrDODesc.class);
	}
	
}