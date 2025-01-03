package iih.bd.bs.ctmitfrel.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.bs.ctmitfrel.d.desc.CtmItfRelDODesc;
import java.math.BigDecimal;

/**
 * 客开接口实现关系 DO数据 
 * 
 */
public class CtmItfRelDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//客开接口实现关系主键
	public static final String ID_CTMITFREL= "Id_ctmitfrel";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//客开接口主键
	public static final String ID_CTMITF= "Id_ctmitf";
	//接口动态库名称
	public static final String DLLNAME_ITF= "Dllname_itf";
	//接口全类名
	public static final String CLASSNAME_ITF= "Classname_itf";
	//客开实现主键
	public static final String ID_CTMIMPL= "Id_ctmimpl";
	//实现类类型
	public static final String EU_IMPLTYPE= "Eu_impltype";
	//实现类动态库名称
	public static final String DLLNAME_IMPL= "Dllname_impl";
	//实现模块名称
	public static final String MODULENAME_IMPL= "Modulename_impl";
	//实现类全类名
	public static final String CLASSNAME_IMPL= "Classname_impl";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//接口备注
	public static final String NOTE_CTMITF= "Note_ctmitf";
	//接口名称
	public static final String NAME_ITF= "Name_itf";
	//接口编码
	public static final String CODE_ITF= "Code_itf";
	//实现类名称
	public static final String NAME_IMPL= "Name_impl";
	//实现类编码
	public static final String CODE_IMPL= "Code_impl";
	//实现类备注
	public static final String NOTE_IMPL= "Note_impl";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 客开接口实现关系主键
	 * @return String
	 */
	public String getId_ctmitfrel() {
		return ((String) getAttrVal("Id_ctmitfrel"));
	}	
	/**
	 * 客开接口实现关系主键
	 * @param Id_ctmitfrel
	 */
	public void setId_ctmitfrel(String Id_ctmitfrel) {
		setAttrVal("Id_ctmitfrel", Id_ctmitfrel);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 客开接口主键
	 * @return String
	 */
	public String getId_ctmitf() {
		return ((String) getAttrVal("Id_ctmitf"));
	}	
	/**
	 * 客开接口主键
	 * @param Id_ctmitf
	 */
	public void setId_ctmitf(String Id_ctmitf) {
		setAttrVal("Id_ctmitf", Id_ctmitf);
	}
	/**
	 * 接口动态库名称
	 * @return String
	 */
	public String getDllname_itf() {
		return ((String) getAttrVal("Dllname_itf"));
	}	
	/**
	 * 接口动态库名称
	 * @param Dllname_itf
	 */
	public void setDllname_itf(String Dllname_itf) {
		setAttrVal("Dllname_itf", Dllname_itf);
	}
	/**
	 * 接口全类名
	 * @return String
	 */
	public String getClassname_itf() {
		return ((String) getAttrVal("Classname_itf"));
	}	
	/**
	 * 接口全类名
	 * @param Classname_itf
	 */
	public void setClassname_itf(String Classname_itf) {
		setAttrVal("Classname_itf", Classname_itf);
	}
	/**
	 * 客开实现主键
	 * @return String
	 */
	public String getId_ctmimpl() {
		return ((String) getAttrVal("Id_ctmimpl"));
	}	
	/**
	 * 客开实现主键
	 * @param Id_ctmimpl
	 */
	public void setId_ctmimpl(String Id_ctmimpl) {
		setAttrVal("Id_ctmimpl", Id_ctmimpl);
	}
	/**
	 * 实现类类型
	 * @return String
	 */
	public String getEu_impltype() {
		return ((String) getAttrVal("Eu_impltype"));
	}	
	/**
	 * 实现类类型
	 * @param Eu_impltype
	 */
	public void setEu_impltype(String Eu_impltype) {
		setAttrVal("Eu_impltype", Eu_impltype);
	}
	/**
	 * 实现类动态库名称
	 * @return String
	 */
	public String getDllname_impl() {
		return ((String) getAttrVal("Dllname_impl"));
	}	
	/**
	 * 实现类动态库名称
	 * @param Dllname_impl
	 */
	public void setDllname_impl(String Dllname_impl) {
		setAttrVal("Dllname_impl", Dllname_impl);
	}
	/**
	 * 实现模块名称
	 * @return String
	 */
	public String getModulename_impl() {
		return ((String) getAttrVal("Modulename_impl"));
	}	
	/**
	 * 实现模块名称
	 * @param Modulename_impl
	 */
	public void setModulename_impl(String Modulename_impl) {
		setAttrVal("Modulename_impl", Modulename_impl);
	}
	/**
	 * 实现类全类名
	 * @return String
	 */
	public String getClassname_impl() {
		return ((String) getAttrVal("Classname_impl"));
	}	
	/**
	 * 实现类全类名
	 * @param Classname_impl
	 */
	public void setClassname_impl(String Classname_impl) {
		setAttrVal("Classname_impl", Classname_impl);
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
	 * 接口备注
	 * @return String
	 */
	public String getNote_ctmitf() {
		return ((String) getAttrVal("Note_ctmitf"));
	}	
	/**
	 * 接口备注
	 * @param Note_ctmitf
	 */
	public void setNote_ctmitf(String Note_ctmitf) {
		setAttrVal("Note_ctmitf", Note_ctmitf);
	}
	/**
	 * 接口名称
	 * @return String
	 */
	public String getName_itf() {
		return ((String) getAttrVal("Name_itf"));
	}	
	/**
	 * 接口名称
	 * @param Name_itf
	 */
	public void setName_itf(String Name_itf) {
		setAttrVal("Name_itf", Name_itf);
	}
	/**
	 * 接口编码
	 * @return String
	 */
	public String getCode_itf() {
		return ((String) getAttrVal("Code_itf"));
	}	
	/**
	 * 接口编码
	 * @param Code_itf
	 */
	public void setCode_itf(String Code_itf) {
		setAttrVal("Code_itf", Code_itf);
	}
	/**
	 * 实现类名称
	 * @return String
	 */
	public String getName_impl() {
		return ((String) getAttrVal("Name_impl"));
	}	
	/**
	 * 实现类名称
	 * @param Name_impl
	 */
	public void setName_impl(String Name_impl) {
		setAttrVal("Name_impl", Name_impl);
	}
	/**
	 * 实现类编码
	 * @return String
	 */
	public String getCode_impl() {
		return ((String) getAttrVal("Code_impl"));
	}	
	/**
	 * 实现类编码
	 * @param Code_impl
	 */
	public void setCode_impl(String Code_impl) {
		setAttrVal("Code_impl", Code_impl);
	}
	/**
	 * 实现类备注
	 * @return String
	 */
	public String getNote_impl() {
		return ((String) getAttrVal("Note_impl"));
	}	
	/**
	 * 实现类备注
	 * @param Note_impl
	 */
	public void setNote_impl(String Note_impl) {
		setAttrVal("Note_impl", Note_impl);
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
		return "Id_ctmitfrel";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_itf_ctm_rel";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CtmItfRelDODesc.class);
	}
	
}