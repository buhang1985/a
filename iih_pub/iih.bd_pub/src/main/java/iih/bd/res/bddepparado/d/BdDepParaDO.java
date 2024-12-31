package iih.bd.res.bddepparado.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.res.bddepparado.d.desc.BdDepParaDODesc;
import java.math.BigDecimal;

/**
 * 科室参数类型 DO数据 
 * 
 */
public class BdDepParaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//科室参数id
	public static final String ID_DEPPARA= "Id_deppara";
	//集团id
	public static final String ID_GRP= "Id_grp";
	//组织id
	public static final String ID_ORG= "Id_org";
	//科室id
	public static final String ID_DEP= "Id_dep";
	//参数类型id
	public static final String ID_DEPPARATP= "Id_depparatp";
	//参数类型编码
	public static final String SD_DEPPARATP= "Sd_depparatp";
	//参数数值
	public static final String VAL= "Val";
	//参数数值1
	public static final String VAL_1= "Val_1";
	//启用标志
	public static final String FG_ACTIVE= "Fg_active";
	//备注
	public static final String NOTE= "Note";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//科室编码
	public static final String CODE_DEP= "Code_dep";
	//科室名称
	public static final String NAME_DEP= "Name_dep";
	//参数类型名称
	public static final String NAME_DEPPARATP= "Name_depparatp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 科室参数id
	 * @return String
	 */
	public String getId_deppara() {
		return ((String) getAttrVal("Id_deppara"));
	}	
	/**
	 * 科室参数id
	 * @param Id_deppara
	 */
	public void setId_deppara(String Id_deppara) {
		setAttrVal("Id_deppara", Id_deppara);
	}
	/**
	 * 集团id
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团id
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 组织id
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织id
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 科室id
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 科室id
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 参数类型id
	 * @return String
	 */
	public String getId_depparatp() {
		return ((String) getAttrVal("Id_depparatp"));
	}	
	/**
	 * 参数类型id
	 * @param Id_depparatp
	 */
	public void setId_depparatp(String Id_depparatp) {
		setAttrVal("Id_depparatp", Id_depparatp);
	}
	/**
	 * 参数类型编码
	 * @return String
	 */
	public String getSd_depparatp() {
		return ((String) getAttrVal("Sd_depparatp"));
	}	
	/**
	 * 参数类型编码
	 * @param Sd_depparatp
	 */
	public void setSd_depparatp(String Sd_depparatp) {
		setAttrVal("Sd_depparatp", Sd_depparatp);
	}
	/**
	 * 参数数值
	 * @return String
	 */
	public String getVal() {
		return ((String) getAttrVal("Val"));
	}	
	/**
	 * 参数数值
	 * @param Val
	 */
	public void setVal(String Val) {
		setAttrVal("Val", Val);
	}
	/**
	 * 参数数值1
	 * @return String
	 */
	public String getVal_1() {
		return ((String) getAttrVal("Val_1"));
	}	
	/**
	 * 参数数值1
	 * @param Val_1
	 */
	public void setVal_1(String Val_1) {
		setAttrVal("Val_1", Val_1);
	}
	/**
	 * 启用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标志
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
	 * 科室编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	/**
	 * 科室编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 参数类型名称
	 * @return String
	 */
	public String getName_depparatp() {
		return ((String) getAttrVal("Name_depparatp"));
	}	
	/**
	 * 参数类型名称
	 * @param Name_depparatp
	 */
	public void setName_depparatp(String Name_depparatp) {
		setAttrVal("Name_depparatp", Name_depparatp);
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
		return "Id_deppara";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_DEP_PARA";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdDepParaDODesc.class);
	}
	
}