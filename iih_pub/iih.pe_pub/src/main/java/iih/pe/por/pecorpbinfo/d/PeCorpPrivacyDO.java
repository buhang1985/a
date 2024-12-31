package iih.pe.por.pecorpbinfo.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.por.pecorpbinfo.d.desc.PeCorpPrivacyDODesc;
import java.math.BigDecimal;

/**
 * 体检团体隐私项 DO数据 
 * 
 */
public class PeCorpPrivacyDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检团体隐私主键标识
	public static final String ID_PECORPPRIVACY= "Id_pecorpprivacy";
	//体检团体ID
	public static final String ID_PECORPBINFO= "Id_pecorpbinfo";
	//体检隐私ID
	public static final String ID_PEPRIVACY= "Id_peprivacy";
	//隐私
	public static final String PRIVACY= "Privacy";
	//备注
	public static final String NOTE= "Note";
	//编码
	public static final String CODE_PRIVACY= "Code_privacy";
	//名称
	public static final String NAME_PRIVACY= "Name_privacy";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检团体隐私主键标识
	 * @return String
	 */
	public String getId_pecorpprivacy() {
		return ((String) getAttrVal("Id_pecorpprivacy"));
	}	
	/**
	 * 体检团体隐私主键标识
	 * @param Id_pecorpprivacy
	 */
	public void setId_pecorpprivacy(String Id_pecorpprivacy) {
		setAttrVal("Id_pecorpprivacy", Id_pecorpprivacy);
	}
	/**
	 * 体检团体ID
	 * @return String
	 */
	public String getId_pecorpbinfo() {
		return ((String) getAttrVal("Id_pecorpbinfo"));
	}	
	/**
	 * 体检团体ID
	 * @param Id_pecorpbinfo
	 */
	public void setId_pecorpbinfo(String Id_pecorpbinfo) {
		setAttrVal("Id_pecorpbinfo", Id_pecorpbinfo);
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
		return "Id_pecorpprivacy";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_or_pecorpprivacy";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeCorpPrivacyDODesc.class);
	}
	
}