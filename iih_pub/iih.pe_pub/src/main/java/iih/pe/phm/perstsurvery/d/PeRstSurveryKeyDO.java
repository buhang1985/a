package iih.pe.phm.perstsurvery.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.perstsurvery.d.desc.PeRstSurveryKeyDODesc;
import java.math.BigDecimal;

/**
 * 体检问卷结果答案 DO数据 
 * 
 */
public class PeRstSurveryKeyDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检问卷结果主键标识
	public static final String ID_PERSTSURVERYKEY= "Id_perstsurverykey";
	//体检问卷ID
	public static final String ID_PERSTSURVERY= "Id_perstsurvery";
	//体检问卷问题库ID
	public static final String ID_PEQACONTENTDEF= "Id_peqacontentdef";
	//体检问卷选项ID
	public static final String ID_PEQAKEYDEF= "Id_peqakeydef";
	//开放问题答案
	public static final String NOTE= "Note";
	//体检问卷问题分组ID
	public static final String ID_PEQACATLOG= "Id_peqacatlog";
	//体检问卷问题编码
	public static final String CODE_QA= "Code_qa";
	//体检问卷问题
	public static final String NAME_QA= "Name_qa";
	//编码
	public static final String CODE_KEY= "Code_key";
	//名称
	public static final String NAME_KEY= "Name_key";
	//阳性标识
	public static final String FG_POSI= "Fg_posi";
	//问卷分组编码
	public static final String CODE_GROUP= "Code_group";
	//问卷分组名称
	public static final String NAME_GROUP= "Name_group";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检问卷结果主键标识
	 * @return String
	 */
	public String getId_perstsurverykey() {
		return ((String) getAttrVal("Id_perstsurverykey"));
	}	
	/**
	 * 体检问卷结果主键标识
	 * @param Id_perstsurverykey
	 */
	public void setId_perstsurverykey(String Id_perstsurverykey) {
		setAttrVal("Id_perstsurverykey", Id_perstsurverykey);
	}
	/**
	 * 体检问卷ID
	 * @return String
	 */
	public String getId_perstsurvery() {
		return ((String) getAttrVal("Id_perstsurvery"));
	}	
	/**
	 * 体检问卷ID
	 * @param Id_perstsurvery
	 */
	public void setId_perstsurvery(String Id_perstsurvery) {
		setAttrVal("Id_perstsurvery", Id_perstsurvery);
	}
	/**
	 * 体检问卷问题库ID
	 * @return String
	 */
	public String getId_peqacontentdef() {
		return ((String) getAttrVal("Id_peqacontentdef"));
	}	
	/**
	 * 体检问卷问题库ID
	 * @param Id_peqacontentdef
	 */
	public void setId_peqacontentdef(String Id_peqacontentdef) {
		setAttrVal("Id_peqacontentdef", Id_peqacontentdef);
	}
	/**
	 * 体检问卷选项ID
	 * @return String
	 */
	public String getId_peqakeydef() {
		return ((String) getAttrVal("Id_peqakeydef"));
	}	
	/**
	 * 体检问卷选项ID
	 * @param Id_peqakeydef
	 */
	public void setId_peqakeydef(String Id_peqakeydef) {
		setAttrVal("Id_peqakeydef", Id_peqakeydef);
	}
	/**
	 * 开放问题答案
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 开放问题答案
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 体检问卷问题分组ID
	 * @return String
	 */
	public String getId_peqacatlog() {
		return ((String) getAttrVal("Id_peqacatlog"));
	}	
	/**
	 * 体检问卷问题分组ID
	 * @param Id_peqacatlog
	 */
	public void setId_peqacatlog(String Id_peqacatlog) {
		setAttrVal("Id_peqacatlog", Id_peqacatlog);
	}
	/**
	 * 体检问卷问题编码
	 * @return String
	 */
	public String getCode_qa() {
		return ((String) getAttrVal("Code_qa"));
	}	
	/**
	 * 体检问卷问题编码
	 * @param Code_qa
	 */
	public void setCode_qa(String Code_qa) {
		setAttrVal("Code_qa", Code_qa);
	}
	/**
	 * 体检问卷问题
	 * @return String
	 */
	public String getName_qa() {
		return ((String) getAttrVal("Name_qa"));
	}	
	/**
	 * 体检问卷问题
	 * @param Name_qa
	 */
	public void setName_qa(String Name_qa) {
		setAttrVal("Name_qa", Name_qa);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_key() {
		return ((String) getAttrVal("Code_key"));
	}	
	/**
	 * 编码
	 * @param Code_key
	 */
	public void setCode_key(String Code_key) {
		setAttrVal("Code_key", Code_key);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_key() {
		return ((String) getAttrVal("Name_key"));
	}	
	/**
	 * 名称
	 * @param Name_key
	 */
	public void setName_key(String Name_key) {
		setAttrVal("Name_key", Name_key);
	}
	/**
	 * 阳性标识
	 * @return FBoolean
	 */
	public FBoolean getFg_posi() {
		return ((FBoolean) getAttrVal("Fg_posi"));
	}	
	/**
	 * 阳性标识
	 * @param Fg_posi
	 */
	public void setFg_posi(FBoolean Fg_posi) {
		setAttrVal("Fg_posi", Fg_posi);
	}
	/**
	 * 问卷分组编码
	 * @return String
	 */
	public String getCode_group() {
		return ((String) getAttrVal("Code_group"));
	}	
	/**
	 * 问卷分组编码
	 * @param Code_group
	 */
	public void setCode_group(String Code_group) {
		setAttrVal("Code_group", Code_group);
	}
	/**
	 * 问卷分组名称
	 * @return String
	 */
	public String getName_group() {
		return ((String) getAttrVal("Name_group"));
	}	
	/**
	 * 问卷分组名称
	 * @param Name_group
	 */
	public void setName_group(String Name_group) {
		setAttrVal("Name_group", Name_group);
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
		return "Id_perstsurverykey";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_perstsurverykey";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeRstSurveryKeyDODesc.class);
	}
	
}