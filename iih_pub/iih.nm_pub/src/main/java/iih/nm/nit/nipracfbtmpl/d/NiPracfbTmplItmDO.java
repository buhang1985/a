package iih.nm.nit.nipracfbtmpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nit.nipracfbtmpl.d.desc.NiPracfbTmplItmDODesc;
import java.math.BigDecimal;

/**
 * 实习反馈模板项目 DO数据 
 * 
 */
public class NiPracfbTmplItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//实习反馈模板项目主键
	public static final String ID_PRAC_FBTMPL_ITM= "Id_prac_fbtmpl_itm";
	//实习反馈模板外键
	public static final String ID_PRAC_FBTMPL= "Id_prac_fbtmpl";
	//评价项目
	public static final String ID_FBITM= "Id_fbitm";
	//评价项目编码
	public static final String SD_FBITM= "Sd_fbitm";
	//评价内容
	public static final String FB_CONTENT= "Fb_content";
	//分值
	public static final String SCORE= "Score";
	//备注
	public static final String DES= "Des";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//名称
	public static final String NAME_FBITM= "Name_fbitm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 实习反馈模板项目主键
	 * @return String
	 */
	public String getId_prac_fbtmpl_itm() {
		return ((String) getAttrVal("Id_prac_fbtmpl_itm"));
	}	
	/**
	 * 实习反馈模板项目主键
	 * @param Id_prac_fbtmpl_itm
	 */
	public void setId_prac_fbtmpl_itm(String Id_prac_fbtmpl_itm) {
		setAttrVal("Id_prac_fbtmpl_itm", Id_prac_fbtmpl_itm);
	}
	/**
	 * 实习反馈模板外键
	 * @return String
	 */
	public String getId_prac_fbtmpl() {
		return ((String) getAttrVal("Id_prac_fbtmpl"));
	}	
	/**
	 * 实习反馈模板外键
	 * @param Id_prac_fbtmpl
	 */
	public void setId_prac_fbtmpl(String Id_prac_fbtmpl) {
		setAttrVal("Id_prac_fbtmpl", Id_prac_fbtmpl);
	}
	/**
	 * 评价项目
	 * @return String
	 */
	public String getId_fbitm() {
		return ((String) getAttrVal("Id_fbitm"));
	}	
	/**
	 * 评价项目
	 * @param Id_fbitm
	 */
	public void setId_fbitm(String Id_fbitm) {
		setAttrVal("Id_fbitm", Id_fbitm);
	}
	/**
	 * 评价项目编码
	 * @return String
	 */
	public String getSd_fbitm() {
		return ((String) getAttrVal("Sd_fbitm"));
	}	
	/**
	 * 评价项目编码
	 * @param Sd_fbitm
	 */
	public void setSd_fbitm(String Sd_fbitm) {
		setAttrVal("Sd_fbitm", Sd_fbitm);
	}
	/**
	 * 评价内容
	 * @return String
	 */
	public String getFb_content() {
		return ((String) getAttrVal("Fb_content"));
	}	
	/**
	 * 评价内容
	 * @param Fb_content
	 */
	public void setFb_content(String Fb_content) {
		setAttrVal("Fb_content", Fb_content);
	}
	/**
	 * 分值
	 * @return Integer
	 */
	public Integer getScore() {
		return ((Integer) getAttrVal("Score"));
	}	
	/**
	 * 分值
	 * @param Score
	 */
	public void setScore(Integer Score) {
		setAttrVal("Score", Score);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 备注
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	public String getName_fbitm() {
		return ((String) getAttrVal("Name_fbitm"));
	}	
	/**
	 * 名称
	 * @param Name_fbitm
	 */
	public void setName_fbitm(String Name_fbitm) {
		setAttrVal("Name_fbitm", Name_fbitm);
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
		return "Id_prac_fbtmpl_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NIT_PRAC_FBTMPL_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NiPracfbTmplItmDODesc.class);
	}
	
}