package iih.cssd.dpus.dfprecy.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.cssd.dpus.dfprecy.d.desc.DfpRecyItmDoDesc;
import java.math.BigDecimal;

/**
 * 回收消毒包子项 DO数据 
 * 
 */
public class DfpRecyItmDo extends BaseDO {
	private static final long serialVersionUID = 1L;

	//收消毒包子项目主键
	public static final String ID_DFP_RECY_ITM= "Id_dfp_recy_itm";
	//回收消毒包主键
	public static final String ID_DFP_RECY= "Id_dfp_recy";
	//请领子项主键
	public static final String ID_DFP_APP_ITEM= "Id_dfp_app_item";
	//消毒包主键
	public static final String ID_DFP= "Id_dfp";
	//消毒包编码
	public static final String CODE= "Code";
	//消毒包名称
	public static final String NAME= "Name";
	//识别码
	public static final String NO_BAR= "No_bar";
	//包类型
	public static final String SD_PKGTP= "Sd_pkgtp";
	//清洗类型
	public static final String SD_PKGCLEAN= "Sd_pkgclean";
	//灭菌方式
	public static final String SD_PKGSTZ= "Sd_pkgstz";
	//包装材料
	public static final String SD_PKGMTR= "Sd_pkgmtr";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//名称
	public static final String NAME_DFP= "Name_dfp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 收消毒包子项目主键
	 * @return String
	 */
	public String getId_dfp_recy_itm() {
		return ((String) getAttrVal("Id_dfp_recy_itm"));
	}	
	/**
	 * 收消毒包子项目主键
	 * @param Id_dfp_recy_itm
	 */
	public void setId_dfp_recy_itm(String Id_dfp_recy_itm) {
		setAttrVal("Id_dfp_recy_itm", Id_dfp_recy_itm);
	}
	/**
	 * 回收消毒包主键
	 * @return String
	 */
	public String getId_dfp_recy() {
		return ((String) getAttrVal("Id_dfp_recy"));
	}	
	/**
	 * 回收消毒包主键
	 * @param Id_dfp_recy
	 */
	public void setId_dfp_recy(String Id_dfp_recy) {
		setAttrVal("Id_dfp_recy", Id_dfp_recy);
	}
	/**
	 * 请领子项主键
	 * @return String
	 */
	public String getId_dfp_app_item() {
		return ((String) getAttrVal("Id_dfp_app_item"));
	}	
	/**
	 * 请领子项主键
	 * @param Id_dfp_app_item
	 */
	public void setId_dfp_app_item(String Id_dfp_app_item) {
		setAttrVal("Id_dfp_app_item", Id_dfp_app_item);
	}
	/**
	 * 消毒包主键
	 * @return String
	 */
	public String getId_dfp() {
		return ((String) getAttrVal("Id_dfp"));
	}	
	/**
	 * 消毒包主键
	 * @param Id_dfp
	 */
	public void setId_dfp(String Id_dfp) {
		setAttrVal("Id_dfp", Id_dfp);
	}
	/**
	 * 消毒包编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 消毒包编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 消毒包名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 消毒包名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 识别码
	 * @return String
	 */
	public String getNo_bar() {
		return ((String) getAttrVal("No_bar"));
	}	
	/**
	 * 识别码
	 * @param No_bar
	 */
	public void setNo_bar(String No_bar) {
		setAttrVal("No_bar", No_bar);
	}
	/**
	 * 包类型
	 * @return String
	 */
	public String getSd_pkgtp() {
		return ((String) getAttrVal("Sd_pkgtp"));
	}	
	/**
	 * 包类型
	 * @param Sd_pkgtp
	 */
	public void setSd_pkgtp(String Sd_pkgtp) {
		setAttrVal("Sd_pkgtp", Sd_pkgtp);
	}
	/**
	 * 清洗类型
	 * @return String
	 */
	public String getSd_pkgclean() {
		return ((String) getAttrVal("Sd_pkgclean"));
	}	
	/**
	 * 清洗类型
	 * @param Sd_pkgclean
	 */
	public void setSd_pkgclean(String Sd_pkgclean) {
		setAttrVal("Sd_pkgclean", Sd_pkgclean);
	}
	/**
	 * 灭菌方式
	 * @return String
	 */
	public String getSd_pkgstz() {
		return ((String) getAttrVal("Sd_pkgstz"));
	}	
	/**
	 * 灭菌方式
	 * @param Sd_pkgstz
	 */
	public void setSd_pkgstz(String Sd_pkgstz) {
		setAttrVal("Sd_pkgstz", Sd_pkgstz);
	}
	/**
	 * 包装材料
	 * @return String
	 */
	public String getSd_pkgmtr() {
		return ((String) getAttrVal("Sd_pkgmtr"));
	}	
	/**
	 * 包装材料
	 * @param Sd_pkgmtr
	 */
	public void setSd_pkgmtr(String Sd_pkgmtr) {
		setAttrVal("Sd_pkgmtr", Sd_pkgmtr);
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
	 * 名称
	 * @return String
	 */
	public String getName_dfp() {
		return ((String) getAttrVal("Name_dfp"));
	}	
	/**
	 * 名称
	 * @param Name_dfp
	 */
	public void setName_dfp(String Name_dfp) {
		setAttrVal("Name_dfp", Name_dfp);
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
		return "Id_dfp_recy_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "CSSD_DFP_RECY_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DfpRecyItmDoDesc.class);
	}
	
}