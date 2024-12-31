package iih.pe.pwf.pewfdep.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pwf.pewfdep.d.desc.PeWfDepDODesc;
import java.math.BigDecimal;

/**
 * 体检登记科室 DO数据 
 * 
 */
public class PeWfDepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检流程科室主键标识
	public static final String ID_PEWFDEP= "Id_pewfdep";
	//体检预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//体检科室设置ID
	public static final String ID_PEDEPTSET= "Id_pedeptset";
	//体检科室状态
	public static final String DEPST= "Depst";
	//检查项目数量
	public static final String ITM_COUNT= "Itm_count";
	//体检备注
	public static final String NOTE= "Note";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//预计检查时长
	public static final String DU_CHK= "Du_chk";
	//检查次序
	public static final String SORTNO= "Sortno";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//科室问诊
	public static final String INQUIRY= "Inquiry";
	//客诉
	public static final String COMPLAIN= "Complain";
	//科室小结
	public static final String DEP_RST= "Dep_rst";
	//体检科室编码
	public static final String CODE_DEP= "Code_dep";
	//体检科室名称
	public static final String NAME_DEP= "Name_dep";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检流程科室主键标识
	 * @return String
	 */
	public String getId_pewfdep() {
		return ((String) getAttrVal("Id_pewfdep"));
	}	
	/**
	 * 体检流程科室主键标识
	 * @param Id_pewfdep
	 */
	public void setId_pewfdep(String Id_pewfdep) {
		setAttrVal("Id_pewfdep", Id_pewfdep);
	}
	/**
	 * 体检预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	/**
	 * 体检预约单ID
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	/**
	 * 体检科室设置ID
	 * @return String
	 */
	public String getId_pedeptset() {
		return ((String) getAttrVal("Id_pedeptset"));
	}	
	/**
	 * 体检科室设置ID
	 * @param Id_pedeptset
	 */
	public void setId_pedeptset(String Id_pedeptset) {
		setAttrVal("Id_pedeptset", Id_pedeptset);
	}
	/**
	 * 体检科室状态
	 * @return Integer
	 */
	public Integer getDepst() {
		return ((Integer) getAttrVal("Depst"));
	}	
	/**
	 * 体检科室状态
	 * @param Depst
	 */
	public void setDepst(Integer Depst) {
		setAttrVal("Depst", Depst);
	}
	/**
	 * 检查项目数量
	 * @return Integer
	 */
	public Integer getItm_count() {
		return ((Integer) getAttrVal("Itm_count"));
	}	
	/**
	 * 检查项目数量
	 * @param Itm_count
	 */
	public void setItm_count(Integer Itm_count) {
		setAttrVal("Itm_count", Itm_count);
	}
	/**
	 * 体检备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 体检备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
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
	 * 预计检查时长
	 * @return Integer
	 */
	public Integer getDu_chk() {
		return ((Integer) getAttrVal("Du_chk"));
	}	
	/**
	 * 预计检查时长
	 * @param Du_chk
	 */
	public void setDu_chk(Integer Du_chk) {
		setAttrVal("Du_chk", Du_chk);
	}
	/**
	 * 检查次序
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 检查次序
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
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
	 * 科室问诊
	 * @return String
	 */
	public String getInquiry() {
		return ((String) getAttrVal("Inquiry"));
	}	
	/**
	 * 科室问诊
	 * @param Inquiry
	 */
	public void setInquiry(String Inquiry) {
		setAttrVal("Inquiry", Inquiry);
	}
	/**
	 * 客诉
	 * @return String
	 */
	public String getComplain() {
		return ((String) getAttrVal("Complain"));
	}	
	/**
	 * 客诉
	 * @param Complain
	 */
	public void setComplain(String Complain) {
		setAttrVal("Complain", Complain);
	}
	/**
	 * 科室小结
	 * @return String
	 */
	public String getDep_rst() {
		return ((String) getAttrVal("Dep_rst"));
	}	
	/**
	 * 科室小结
	 * @param Dep_rst
	 */
	public void setDep_rst(String Dep_rst) {
		setAttrVal("Dep_rst", Dep_rst);
	}
	/**
	 * 体检科室编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	/**
	 * 体检科室编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 体检科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 体检科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
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
		return "Id_pewfdep";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_wf_pewfdep";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeWfDepDODesc.class);
	}
	
}