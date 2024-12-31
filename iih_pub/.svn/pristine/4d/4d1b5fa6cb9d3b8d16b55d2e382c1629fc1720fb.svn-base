package iih.en.pv.enres.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.enres.d.desc.EnExtDODesc;
import java.math.BigDecimal;

/**
 * 患者就诊扩展 DO数据 
 * 
 */
public class EnExtDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//ID
	public static final String ID_ENTEXT= "Id_entext";
	//就诊id
	public static final String ID_ENT= "Id_ent";
	//患者id
	public static final String ID_PAT= "Id_pat";
	//体重(KG)
	public static final String WEIGHT= "Weight";
	//身高(CM)
	public static final String HEIGHT= "Height";
	//挂号接诊类型
	public static final String SD_REGEXTP= "Sd_regextp";
	//扩展说明
	public static final String NOTE_EX= "Note_ex";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * ID
	 * @return String
	 */
	public String getId_entext() {
		return ((String) getAttrVal("Id_entext"));
	}	
	/**
	 * ID
	 * @param Id_entext
	 */
	public void setId_entext(String Id_entext) {
		setAttrVal("Id_entext", Id_entext);
	}
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 体重(KG)
	 * @return FDouble
	 */
	public FDouble getWeight() {
		return ((FDouble) getAttrVal("Weight"));
	}	
	/**
	 * 体重(KG)
	 * @param Weight
	 */
	public void setWeight(FDouble Weight) {
		setAttrVal("Weight", Weight);
	}
	/**
	 * 身高(CM)
	 * @return FDouble
	 */
	public FDouble getHeight() {
		return ((FDouble) getAttrVal("Height"));
	}	
	/**
	 * 身高(CM)
	 * @param Height
	 */
	public void setHeight(FDouble Height) {
		setAttrVal("Height", Height);
	}
	/**
	 * 挂号接诊类型
	 * @return String
	 */
	public String getSd_regextp() {
		return ((String) getAttrVal("Sd_regextp"));
	}	
	/**
	 * 挂号接诊类型
	 * @param Sd_regextp
	 */
	public void setSd_regextp(String Sd_regextp) {
		setAttrVal("Sd_regextp", Sd_regextp);
	}
	/**
	 * 扩展说明
	 * @return String
	 */
	public String getNote_ex() {
		return ((String) getAttrVal("Note_ex"));
	}	
	/**
	 * 扩展说明
	 * @param Note_ex
	 */
	public void setNote_ex(String Note_ex) {
		setAttrVal("Note_ex", Note_ex);
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
		return "Id_entext";
	}
	
	@Override
	public String getTableName() {	  
		return "EN_ENT_EXT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EnExtDODesc.class);
	}
	
}