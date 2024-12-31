package iih.bd.mm.materialnames.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.mm.materialnames.d.desc.MnCodeSetDODesc;
import java.math.BigDecimal;

/**
 * 药品通用名编码集 DO数据 
 * 
 */
public class MnCodeSetDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//服务项目编码主键标识
	public static final String ID_CODESET= "Id_codeset";
	//药品通用名
	public static final String ID_MATERIALNAME= "Id_materialname";
	//对照编码标准
	public static final String ID_CDSTD= "Id_cdstd";
	//对照编码标准编码
	public static final String SD_CDSTD= "Sd_cdstd";
	//编码
	public static final String CODE= "Code";
	//对照编码标准名称
	public static final String NAME_CDSTD= "Name_cdstd";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 服务项目编码主键标识
	 * @return String
	 */
	public String getId_codeset() {
		return ((String) getAttrVal("Id_codeset"));
	}	
	/**
	 * 服务项目编码主键标识
	 * @param Id_codeset
	 */
	public void setId_codeset(String Id_codeset) {
		setAttrVal("Id_codeset", Id_codeset);
	}
	/**
	 * 药品通用名
	 * @return String
	 */
	public String getId_materialname() {
		return ((String) getAttrVal("Id_materialname"));
	}	
	/**
	 * 药品通用名
	 * @param Id_materialname
	 */
	public void setId_materialname(String Id_materialname) {
		setAttrVal("Id_materialname", Id_materialname);
	}
	/**
	 * 对照编码标准
	 * @return String
	 */
	public String getId_cdstd() {
		return ((String) getAttrVal("Id_cdstd"));
	}	
	/**
	 * 对照编码标准
	 * @param Id_cdstd
	 */
	public void setId_cdstd(String Id_cdstd) {
		setAttrVal("Id_cdstd", Id_cdstd);
	}
	/**
	 * 对照编码标准编码
	 * @return String
	 */
	public String getSd_cdstd() {
		return ((String) getAttrVal("Sd_cdstd"));
	}	
	/**
	 * 对照编码标准编码
	 * @param Sd_cdstd
	 */
	public void setSd_cdstd(String Sd_cdstd) {
		setAttrVal("Sd_cdstd", Sd_cdstd);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 对照编码标准名称
	 * @return String
	 */
	public String getName_cdstd() {
		return ((String) getAttrVal("Name_cdstd"));
	}	
	/**
	 * 对照编码标准名称
	 * @param Name_cdstd
	 */
	public void setName_cdstd(String Name_cdstd) {
		setAttrVal("Name_cdstd", Name_cdstd);
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
		return "Id_codeset";
	}
	
	@Override
	public String getTableName() {	  
		return "default";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MnCodeSetDODesc.class);
	}
	
}