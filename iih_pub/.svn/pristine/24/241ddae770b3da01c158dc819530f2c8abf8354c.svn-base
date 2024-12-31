package iih.pis.ivx.pisivxsetting.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pis.ivx.pisivxsetting.d.desc.PisivxTagsDODesc;
import java.math.BigDecimal;

/**
 * 微信服务-标签 DO数据 
 * 
 */
public class PisivxTagsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//微信服务号标签主键标识
	public static final String ID_PISIVXTAGS= "Id_pisivxtags";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//标签id
	public static final String TAGID= "Tagid";
	//微信服务号配置ID
	public static final String ID_PISIVXSETTING= "Id_pisivxsetting";
	//发布标识
	public static final String FG_RELEASED= "Fg_released";
	//患者标识
	public static final String FG_PAT= "Fg_pat";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 微信服务号标签主键标识
	 * @return String
	 */
	public String getId_pisivxtags() {
		return ((String) getAttrVal("Id_pisivxtags"));
	}	
	/**
	 * 微信服务号标签主键标识
	 * @param Id_pisivxtags
	 */
	public void setId_pisivxtags(String Id_pisivxtags) {
		setAttrVal("Id_pisivxtags", Id_pisivxtags);
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
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 标签id
	 * @return Integer
	 */
	public Integer getTagid() {
		return ((Integer) getAttrVal("Tagid"));
	}	
	/**
	 * 标签id
	 * @param Tagid
	 */
	public void setTagid(Integer Tagid) {
		setAttrVal("Tagid", Tagid);
	}
	/**
	 * 微信服务号配置ID
	 * @return String
	 */
	public String getId_pisivxsetting() {
		return ((String) getAttrVal("Id_pisivxsetting"));
	}	
	/**
	 * 微信服务号配置ID
	 * @param Id_pisivxsetting
	 */
	public void setId_pisivxsetting(String Id_pisivxsetting) {
		setAttrVal("Id_pisivxsetting", Id_pisivxsetting);
	}
	/**
	 * 发布标识
	 * @return FBoolean
	 */
	public FBoolean getFg_released() {
		return ((FBoolean) getAttrVal("Fg_released"));
	}	
	/**
	 * 发布标识
	 * @param Fg_released
	 */
	public void setFg_released(FBoolean Fg_released) {
		setAttrVal("Fg_released", Fg_released);
	}
	/**
	 * 患者标识
	 * @return FBoolean
	 */
	public FBoolean getFg_pat() {
		return ((FBoolean) getAttrVal("Fg_pat"));
	}	
	/**
	 * 患者标识
	 * @param Fg_pat
	 */
	public void setFg_pat(FBoolean Fg_pat) {
		setAttrVal("Fg_pat", Fg_pat);
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
		return "Id_pisivxtags";
	}
	
	@Override
	public String getTableName() {	  
		return "pis_ivx_tags";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PisivxTagsDODesc.class);
	}
	
}