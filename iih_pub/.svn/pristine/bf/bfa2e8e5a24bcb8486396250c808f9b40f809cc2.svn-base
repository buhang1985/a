package iih.pe.por.pepsnbinfo.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.por.pepsnbinfo.d.desc.PePsnBInfoPriDODesc;
import java.math.BigDecimal;

/**
 * 体检客户个人隐私 DO数据 
 * 
 */
public class PePsnBInfoPriDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检客户隐私主键标识
	public static final String ID_PEPSNBINFOPRI= "Id_pepsnbinfopri";
	//体检客户ID
	public static final String ID_PEPSNBINFO= "Id_pepsnbinfo";
	//体检隐私ID
	public static final String ID_PEPRIVACY= "Id_peprivacy";
	//隐私
	public static final String PRIVACY= "Privacy";
	//备注
	public static final String NOTE= "Note";
	//名称
	public static final String NAME_PRIVACY= "Name_privacy";
	//编码
	public static final String CODE_PRIVACY= "Code_privacy";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检客户隐私主键标识
	 * @return String
	 */
	public String getId_pepsnbinfopri() {
		return ((String) getAttrVal("Id_pepsnbinfopri"));
	}	
	/**
	 * 体检客户隐私主键标识
	 * @param Id_pepsnbinfopri
	 */
	public void setId_pepsnbinfopri(String Id_pepsnbinfopri) {
		setAttrVal("Id_pepsnbinfopri", Id_pepsnbinfopri);
	}
	/**
	 * 体检客户ID
	 * @return String
	 */
	public String getId_pepsnbinfo() {
		return ((String) getAttrVal("Id_pepsnbinfo"));
	}	
	/**
	 * 体检客户ID
	 * @param Id_pepsnbinfo
	 */
	public void setId_pepsnbinfo(String Id_pepsnbinfo) {
		setAttrVal("Id_pepsnbinfo", Id_pepsnbinfo);
	}
	/**
	 * 体检隐私ID
	 * @return String
	 */
	public String getId_peprivacy() {
		return ((String) getAttrVal("Id_peprivacy"));
	}	
	/**
	 * 体检隐私ID
	 * @param Id_peprivacy
	 */
	public void setId_peprivacy(String Id_peprivacy) {
		setAttrVal("Id_peprivacy", Id_peprivacy);
	}
	/**
	 * 隐私
	 * @return FBoolean
	 */
	public FBoolean getPrivacy() {
		return ((FBoolean) getAttrVal("Privacy"));
	}	
	/**
	 * 隐私
	 * @param Privacy
	 */
	public void setPrivacy(FBoolean Privacy) {
		setAttrVal("Privacy", Privacy);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_privacy() {
		return ((String) getAttrVal("Name_privacy"));
	}	
	/**
	 * 名称
	 * @param Name_privacy
	 */
	public void setName_privacy(String Name_privacy) {
		setAttrVal("Name_privacy", Name_privacy);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_privacy() {
		return ((String) getAttrVal("Code_privacy"));
	}	
	/**
	 * 编码
	 * @param Code_privacy
	 */
	public void setCode_privacy(String Code_privacy) {
		setAttrVal("Code_privacy", Code_privacy);
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
		return "Id_pepsnbinfopri";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_or_pepsnbinfopri";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PePsnBInfoPriDODesc.class);
	}
	
}