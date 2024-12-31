package iih.en.pv.vt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.vt.d.desc.EnVtDODesc;
import java.math.BigDecimal;

/**
 * 就诊_体征 DO数据 
 * 
 */
public class EnVtDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//预检体征id
	public static final String ID_ENVT= "Id_envt";
	//预检id
	public static final String ID_ERPRE= "Id_erpre";
	//体征时间
	public static final String DT_VT= "Dt_vt";
	//记录人id
	public static final String ID_EMP_REC= "Id_emp_rec";
	//插入时间
	public static final String DT_INSERT= "Dt_insert";
	//最后一次标志
	public static final String FG_LAST= "Fg_last";
	//就诊id
	public static final String ID_ENT= "Id_ent";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//记录人编码
	public static final String CODE_EMP_REC= "Code_emp_rec";
	//记录人姓名
	public static final String NAME_EMP_REC= "Name_emp_rec";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 预检体征id
	 * @return String
	 */
	public String getId_envt() {
		return ((String) getAttrVal("Id_envt"));
	}	
	/**
	 * 预检体征id
	 * @param Id_envt
	 */
	public void setId_envt(String Id_envt) {
		setAttrVal("Id_envt", Id_envt);
	}
	/**
	 * 预检id
	 * @return String
	 */
	public String getId_erpre() {
		return ((String) getAttrVal("Id_erpre"));
	}	
	/**
	 * 预检id
	 * @param Id_erpre
	 */
	public void setId_erpre(String Id_erpre) {
		setAttrVal("Id_erpre", Id_erpre);
	}
	/**
	 * 体征时间
	 * @return FDateTime
	 */
	public FDateTime getDt_vt() {
		return ((FDateTime) getAttrVal("Dt_vt"));
	}	
	/**
	 * 体征时间
	 * @param Dt_vt
	 */
	public void setDt_vt(FDateTime Dt_vt) {
		setAttrVal("Dt_vt", Dt_vt);
	}
	/**
	 * 记录人id
	 * @return String
	 */
	public String getId_emp_rec() {
		return ((String) getAttrVal("Id_emp_rec"));
	}	
	/**
	 * 记录人id
	 * @param Id_emp_rec
	 */
	public void setId_emp_rec(String Id_emp_rec) {
		setAttrVal("Id_emp_rec", Id_emp_rec);
	}
	/**
	 * 插入时间
	 * @return FDateTime
	 */
	public FDateTime getDt_insert() {
		return ((FDateTime) getAttrVal("Dt_insert"));
	}	
	/**
	 * 插入时间
	 * @param Dt_insert
	 */
	public void setDt_insert(FDateTime Dt_insert) {
		setAttrVal("Dt_insert", Dt_insert);
	}
	/**
	 * 最后一次标志
	 * @return FBoolean
	 */
	public FBoolean getFg_last() {
		return ((FBoolean) getAttrVal("Fg_last"));
	}	
	/**
	 * 最后一次标志
	 * @param Fg_last
	 */
	public void setFg_last(FBoolean Fg_last) {
		setAttrVal("Fg_last", Fg_last);
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
	 * 记录人编码
	 * @return String
	 */
	public String getCode_emp_rec() {
		return ((String) getAttrVal("Code_emp_rec"));
	}	
	/**
	 * 记录人编码
	 * @param Code_emp_rec
	 */
	public void setCode_emp_rec(String Code_emp_rec) {
		setAttrVal("Code_emp_rec", Code_emp_rec);
	}
	/**
	 * 记录人姓名
	 * @return String
	 */
	public String getName_emp_rec() {
		return ((String) getAttrVal("Name_emp_rec"));
	}	
	/**
	 * 记录人姓名
	 * @param Name_emp_rec
	 */
	public void setName_emp_rec(String Name_emp_rec) {
		setAttrVal("Name_emp_rec", Name_emp_rec);
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
		return "Id_envt";
	}
	
	@Override
	public String getTableName() {	  
		return "EN_VT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EnVtDODesc.class);
	}
	
}