package iih.pe.pitm.perstdidef.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.perstdidef.d.desc.PeDiagSuppDODesc;
import java.math.BigDecimal;

/**
 * 体检诊断补充 DO数据 
 * 
 */
public class PeDiagSuppDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检诊断补充关联主键标识
	public static final String ID_PEDIAGSUPP= "Id_pediagsupp";
	//体检诊断ID
	public static final String ID_PERSTDIDEF= "Id_perstdidef";
	//体检诊断补充主键
	public static final String ID_PERSTDISUPPDEF= "Id_perstdisuppdef";
	//序号
	public static final String SORTNO= "Sortno";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//诊断名称
	public static final String NAME_DIAG= "Name_diag";
	//名称
	public static final String NAME_SUPP= "Name_supp";
	//编码
	public static final String CODE_SUPP= "Code_supp";
	//计量单位
	public static final String UNIT_SUPP= "Unit_supp";
	//分组
	public static final String NO_GROUP_SUPP= "No_group_supp";
	//次序
	public static final String SORTNO_SUPP= "Sortno_supp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检诊断补充关联主键标识
	 * @return String
	 */
	public String getId_pediagsupp() {
		return ((String) getAttrVal("Id_pediagsupp"));
	}	
	/**
	 * 体检诊断补充关联主键标识
	 * @param Id_pediagsupp
	 */
	public void setId_pediagsupp(String Id_pediagsupp) {
		setAttrVal("Id_pediagsupp", Id_pediagsupp);
	}
	/**
	 * 体检诊断ID
	 * @return String
	 */
	public String getId_perstdidef() {
		return ((String) getAttrVal("Id_perstdidef"));
	}	
	/**
	 * 体检诊断ID
	 * @param Id_perstdidef
	 */
	public void setId_perstdidef(String Id_perstdidef) {
		setAttrVal("Id_perstdidef", Id_perstdidef);
	}
	/**
	 * 体检诊断补充主键
	 * @return String
	 */
	public String getId_perstdisuppdef() {
		return ((String) getAttrVal("Id_perstdisuppdef"));
	}	
	/**
	 * 体检诊断补充主键
	 * @param Id_perstdisuppdef
	 */
	public void setId_perstdisuppdef(String Id_perstdisuppdef) {
		setAttrVal("Id_perstdisuppdef", Id_perstdisuppdef);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
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
	 * 诊断名称
	 * @return String
	 */
	public String getName_diag() {
		return ((String) getAttrVal("Name_diag"));
	}	
	/**
	 * 诊断名称
	 * @param Name_diag
	 */
	public void setName_diag(String Name_diag) {
		setAttrVal("Name_diag", Name_diag);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_supp() {
		return ((String) getAttrVal("Name_supp"));
	}	
	/**
	 * 名称
	 * @param Name_supp
	 */
	public void setName_supp(String Name_supp) {
		setAttrVal("Name_supp", Name_supp);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_supp() {
		return ((String) getAttrVal("Code_supp"));
	}	
	/**
	 * 编码
	 * @param Code_supp
	 */
	public void setCode_supp(String Code_supp) {
		setAttrVal("Code_supp", Code_supp);
	}
	/**
	 * 计量单位
	 * @return String
	 */
	public String getUnit_supp() {
		return ((String) getAttrVal("Unit_supp"));
	}	
	/**
	 * 计量单位
	 * @param Unit_supp
	 */
	public void setUnit_supp(String Unit_supp) {
		setAttrVal("Unit_supp", Unit_supp);
	}
	/**
	 * 分组
	 * @return String
	 */
	public String getNo_group_supp() {
		return ((String) getAttrVal("No_group_supp"));
	}	
	/**
	 * 分组
	 * @param No_group_supp
	 */
	public void setNo_group_supp(String No_group_supp) {
		setAttrVal("No_group_supp", No_group_supp);
	}
	/**
	 * 次序
	 * @return String
	 */
	public String getSortno_supp() {
		return ((String) getAttrVal("Sortno_supp"));
	}	
	/**
	 * 次序
	 * @param Sortno_supp
	 */
	public void setSortno_supp(String Sortno_supp) {
		setAttrVal("Sortno_supp", Sortno_supp);
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
		return "Id_pediagsupp";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_pediagsupp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeDiagSuppDODesc.class);
	}
	
}