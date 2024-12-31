package iih.bd.mm.materialnames.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.mm.materialnames.d.desc.MaterialsDODesc;
import java.math.BigDecimal;

/**
 * 药品通用名对应药品 DO数据 
 * 
 */
public class MaterialsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//主键
	public static final String ID_MATERIALLIST= "Id_materiallist";
	//药品通用名
	public static final String ID_MATERIALNAME= "Id_materialname";
	//药品
	public static final String ID_MM= "Id_mm";
	//物品编码
	public static final String MM_CODE= "Mm_code";
	//物品名称
	public static final String MM_NAME= "Mm_name";
	//物品规格
	public static final String MM_SPEC= "Mm_spec";
	//皮试标志
	public static final String MM_FG_SKIN= "Mm_fg_skin";
	//生产厂家名称
	public static final String MM_SUP_NAME= "Mm_sup_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_materiallist() {
		return ((String) getAttrVal("Id_materiallist"));
	}	
	/**
	 * 主键
	 * @param Id_materiallist
	 */
	public void setId_materiallist(String Id_materiallist) {
		setAttrVal("Id_materiallist", Id_materiallist);
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
	 * 药品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 药品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 物品编码
	 * @return String
	 */
	public String getMm_code() {
		return ((String) getAttrVal("Mm_code"));
	}	
	/**
	 * 物品编码
	 * @param Mm_code
	 */
	public void setMm_code(String Mm_code) {
		setAttrVal("Mm_code", Mm_code);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getMm_name() {
		return ((String) getAttrVal("Mm_name"));
	}	
	/**
	 * 物品名称
	 * @param Mm_name
	 */
	public void setMm_name(String Mm_name) {
		setAttrVal("Mm_name", Mm_name);
	}
	/**
	 * 物品规格
	 * @return String
	 */
	public String getMm_spec() {
		return ((String) getAttrVal("Mm_spec"));
	}	
	/**
	 * 物品规格
	 * @param Mm_spec
	 */
	public void setMm_spec(String Mm_spec) {
		setAttrVal("Mm_spec", Mm_spec);
	}
	/**
	 * 皮试标志
	 * @return FBoolean
	 */
	public FBoolean getMm_fg_skin() {
		return ((FBoolean) getAttrVal("Mm_fg_skin"));
	}	
	/**
	 * 皮试标志
	 * @param Mm_fg_skin
	 */
	public void setMm_fg_skin(FBoolean Mm_fg_skin) {
		setAttrVal("Mm_fg_skin", Mm_fg_skin);
	}
	/**
	 * 生产厂家名称
	 * @return String
	 */
	public String getMm_sup_name() {
		return ((String) getAttrVal("Mm_sup_name"));
	}	
	/**
	 * 生产厂家名称
	 * @param Mm_sup_name
	 */
	public void setMm_sup_name(String Mm_sup_name) {
		setAttrVal("Mm_sup_name", Mm_sup_name);
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
		return "Id_materiallist";
	}
	
	@Override
	public String getTableName() {	  
		return "default";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MaterialsDODesc.class);
	}
	
}