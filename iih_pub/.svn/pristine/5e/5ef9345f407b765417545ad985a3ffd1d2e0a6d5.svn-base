package iih.bd.mm.custcategoryitem.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.mm.custcategoryitem.d.desc.CustCategoryItemRelDODesc;
import java.math.BigDecimal;

/**
 * 医疗物品_自定义分类项目关系 DO数据 
 * 
 */
public class CustCategoryItemRelDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//自定义分类项目对照主键
	public static final String ID_MMCAUSITMREL= "Id_mmcausitmrel";
	//自定义分类项目主键
	public static final String ID_MMCAUSITM= "Id_mmcausitm";
	//分类或物品
	public static final String ID_MMUSCAMM= "Id_mmuscamm";
	//分类或物品编码
	public static final String SD_MMUSCAMM= "Sd_mmuscamm";
	//物品或基本分类ID
	public static final String ID_MMORCA= "Id_mmorca";
	//物品或基本分类名称
	public static final String NAME_MMORCA= "Name_mmorca";
	//自定义分类系数
	public static final String ID_FACTOR= "Id_factor";
	//自定义分类系数编码
	public static final String SD_FACTOR= "Sd_factor";
	//分类或物品
	public static final String MMUSCAMM_NAME= "Mmuscamm_name";
	//系数
	public static final String FACTOR_NAME= "Factor_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 自定义分类项目对照主键
	 * @return String
	 */
	public String getId_mmcausitmrel() {
		return ((String) getAttrVal("Id_mmcausitmrel"));
	}	
	/**
	 * 自定义分类项目对照主键
	 * @param Id_mmcausitmrel
	 */
	public void setId_mmcausitmrel(String Id_mmcausitmrel) {
		setAttrVal("Id_mmcausitmrel", Id_mmcausitmrel);
	}
	/**
	 * 自定义分类项目主键
	 * @return String
	 */
	public String getId_mmcausitm() {
		return ((String) getAttrVal("Id_mmcausitm"));
	}	
	/**
	 * 自定义分类项目主键
	 * @param Id_mmcausitm
	 */
	public void setId_mmcausitm(String Id_mmcausitm) {
		setAttrVal("Id_mmcausitm", Id_mmcausitm);
	}
	/**
	 * 分类或物品
	 * @return String
	 */
	public String getId_mmuscamm() {
		return ((String) getAttrVal("Id_mmuscamm"));
	}	
	/**
	 * 分类或物品
	 * @param Id_mmuscamm
	 */
	public void setId_mmuscamm(String Id_mmuscamm) {
		setAttrVal("Id_mmuscamm", Id_mmuscamm);
	}
	/**
	 * 分类或物品编码
	 * @return String
	 */
	public String getSd_mmuscamm() {
		return ((String) getAttrVal("Sd_mmuscamm"));
	}	
	/**
	 * 分类或物品编码
	 * @param Sd_mmuscamm
	 */
	public void setSd_mmuscamm(String Sd_mmuscamm) {
		setAttrVal("Sd_mmuscamm", Sd_mmuscamm);
	}
	/**
	 * 物品或基本分类ID
	 * @return String
	 */
	public String getId_mmorca() {
		return ((String) getAttrVal("Id_mmorca"));
	}	
	/**
	 * 物品或基本分类ID
	 * @param Id_mmorca
	 */
	public void setId_mmorca(String Id_mmorca) {
		setAttrVal("Id_mmorca", Id_mmorca);
	}
	/**
	 * 物品或基本分类名称
	 * @return String
	 */
	public String getName_mmorca() {
		return ((String) getAttrVal("Name_mmorca"));
	}	
	/**
	 * 物品或基本分类名称
	 * @param Name_mmorca
	 */
	public void setName_mmorca(String Name_mmorca) {
		setAttrVal("Name_mmorca", Name_mmorca);
	}
	/**
	 * 自定义分类系数
	 * @return String
	 */
	public String getId_factor() {
		return ((String) getAttrVal("Id_factor"));
	}	
	/**
	 * 自定义分类系数
	 * @param Id_factor
	 */
	public void setId_factor(String Id_factor) {
		setAttrVal("Id_factor", Id_factor);
	}
	/**
	 * 自定义分类系数编码
	 * @return String
	 */
	public String getSd_factor() {
		return ((String) getAttrVal("Sd_factor"));
	}	
	/**
	 * 自定义分类系数编码
	 * @param Sd_factor
	 */
	public void setSd_factor(String Sd_factor) {
		setAttrVal("Sd_factor", Sd_factor);
	}
	/**
	 * 分类或物品
	 * @return String
	 */
	public String getMmuscamm_name() {
		return ((String) getAttrVal("Mmuscamm_name"));
	}	
	/**
	 * 分类或物品
	 * @param Mmuscamm_name
	 */
	public void setMmuscamm_name(String Mmuscamm_name) {
		setAttrVal("Mmuscamm_name", Mmuscamm_name);
	}
	/**
	 * 系数
	 * @return String
	 */
	public String getFactor_name() {
		return ((String) getAttrVal("Factor_name"));
	}	
	/**
	 * 系数
	 * @param Factor_name
	 */
	public void setFactor_name(String Factor_name) {
		setAttrVal("Factor_name", Factor_name);
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
		return "Id_mmcausitmrel";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_MMCA_US_ITM_REL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CustCategoryItemRelDODesc.class);
	}
	
}