package iih.ci.mr.cimrsource.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.cimrsource.d.desc.CiMrSourceDODesc;
import java.math.BigDecimal;

/**
 * 病历源内容 DO数据 
 * 
 */
public class CiMrSourceDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//主键
	public static final String ID_CI_MR_SOU= "Id_ci_mr_sou";
	//病历主键
	public static final String ID_MR= "Id_mr";
	//源名称
	public static final String NAME_SOU= "Name_sou";
	//源ID
	public static final String ID_SOU= "Id_sou";
	//属性ID
	public static final String ID_PRO= "Id_pro";
	//属性名称
	public static final String NAME_PRO= "Name_pro";
	//内容
	public static final String CONTENT= "Content";
	//参照内容
	public static final String REFCONTENT= "Refcontent";
	//是否参照
	public static final String FG_REF= "Fg_ref";
	//数据来源ID
	public static final String ID_SOURCE= "Id_source";
	//数据来源SD
	public static final String SD_SOURCE= "Sd_source";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_ci_mr_sou() {
		return ((String) getAttrVal("Id_ci_mr_sou"));
	}	
	/**
	 * 主键
	 * @param Id_ci_mr_sou
	 */
	public void setId_ci_mr_sou(String Id_ci_mr_sou) {
		setAttrVal("Id_ci_mr_sou", Id_ci_mr_sou);
	}
	/**
	 * 病历主键
	 * @return String
	 */
	public String getId_mr() {
		return ((String) getAttrVal("Id_mr"));
	}	
	/**
	 * 病历主键
	 * @param Id_mr
	 */
	public void setId_mr(String Id_mr) {
		setAttrVal("Id_mr", Id_mr);
	}
	/**
	 * 源名称
	 * @return String
	 */
	public String getName_sou() {
		return ((String) getAttrVal("Name_sou"));
	}	
	/**
	 * 源名称
	 * @param Name_sou
	 */
	public void setName_sou(String Name_sou) {
		setAttrVal("Name_sou", Name_sou);
	}
	/**
	 * 源ID
	 * @return String
	 */
	public String getId_sou() {
		return ((String) getAttrVal("Id_sou"));
	}	
	/**
	 * 源ID
	 * @param Id_sou
	 */
	public void setId_sou(String Id_sou) {
		setAttrVal("Id_sou", Id_sou);
	}
	/**
	 * 属性ID
	 * @return String
	 */
	public String getId_pro() {
		return ((String) getAttrVal("Id_pro"));
	}	
	/**
	 * 属性ID
	 * @param Id_pro
	 */
	public void setId_pro(String Id_pro) {
		setAttrVal("Id_pro", Id_pro);
	}
	/**
	 * 属性名称
	 * @return String
	 */
	public String getName_pro() {
		return ((String) getAttrVal("Name_pro"));
	}	
	/**
	 * 属性名称
	 * @param Name_pro
	 */
	public void setName_pro(String Name_pro) {
		setAttrVal("Name_pro", Name_pro);
	}
	/**
	 * 内容
	 * @return String
	 */
	public String getContent() {
		return ((String) getAttrVal("Content"));
	}	
	/**
	 * 内容
	 * @param Content
	 */
	public void setContent(String Content) {
		setAttrVal("Content", Content);
	}
	/**
	 * 参照内容
	 * @return String
	 */
	public String getRefcontent() {
		return ((String) getAttrVal("Refcontent"));
	}	
	/**
	 * 参照内容
	 * @param Refcontent
	 */
	public void setRefcontent(String Refcontent) {
		setAttrVal("Refcontent", Refcontent);
	}
	/**
	 * 是否参照
	 * @return FBoolean
	 */
	public FBoolean getFg_ref() {
		return ((FBoolean) getAttrVal("Fg_ref"));
	}	
	/**
	 * 是否参照
	 * @param Fg_ref
	 */
	public void setFg_ref(FBoolean Fg_ref) {
		setAttrVal("Fg_ref", Fg_ref);
	}
	/**
	 * 数据来源ID
	 * @return String
	 */
	public String getId_source() {
		return ((String) getAttrVal("Id_source"));
	}	
	/**
	 * 数据来源ID
	 * @param Id_source
	 */
	public void setId_source(String Id_source) {
		setAttrVal("Id_source", Id_source);
	}
	/**
	 * 数据来源SD
	 * @return String
	 */
	public String getSd_source() {
		return ((String) getAttrVal("Sd_source"));
	}	
	/**
	 * 数据来源SD
	 * @param Sd_source
	 */
	public void setSd_source(String Sd_source) {
		setAttrVal("Sd_source", Sd_source);
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
		return "Id_ci_mr_sou";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_source";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrSourceDODesc.class);
	}
	
}