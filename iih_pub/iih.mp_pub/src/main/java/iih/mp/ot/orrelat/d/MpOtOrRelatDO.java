package iih.mp.ot.orrelat.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.ot.orrelat.d.desc.MpOtOrRelatDODesc;
import java.math.BigDecimal;

/**
 * 医技补费医嘱关系 DO数据 
 * 
 */
public class MpOtOrRelatDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医技补费医嘱关系主键
	public static final String ID_OTORRELAT= "Id_otorrelat";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//主医嘱
	public static final String ID_OR= "Id_or";
	//补医嘱
	public static final String ID_OR_ADD= "Id_or_add";
	//补医嘱项目
	public static final String ID_ORSRV_ADD= "Id_orsrv_add";
	//就诊id
	public static final String ID_ENT= "Id_ent";
	//操作员
	public static final String ID_EMP_CREA= "Id_emp_crea";
	//操作时间
	public static final String DT_CREA= "Dt_crea";
	//删除操作员
	public static final String ID_EMP_DEL= "Id_emp_del";
	//删除时间
	public static final String DT_DEL= "Dt_del";
	//预交金操作员
	public static final String ID_EMP_PPAY= "Id_emp_ppay";
	//预交金时间
	public static final String DT_PPAY= "Dt_ppay";
	//预交金退费操作员
	public static final String ID_EMP_RETURNS= "Id_emp_returns";
	//预交金退费时间
	public static final String DT_RETURNS= "Dt_returns";
	//补费科室
	public static final String ID_DEP_CG= "Id_dep_cg";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//唯一码
	public static final String ONLYCODE= "Onlycode";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医技补费医嘱关系主键
	 * @return String
	 */
	public String getId_otorrelat() {
		return ((String) getAttrVal("Id_otorrelat"));
	}	
	/**
	 * 医技补费医嘱关系主键
	 * @param Id_otorrelat
	 */
	public void setId_otorrelat(String Id_otorrelat) {
		setAttrVal("Id_otorrelat", Id_otorrelat);
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
	 * 机构
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 机构
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 主医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 主医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 补医嘱
	 * @return String
	 */
	public String getId_or_add() {
		return ((String) getAttrVal("Id_or_add"));
	}	
	/**
	 * 补医嘱
	 * @param Id_or_add
	 */
	public void setId_or_add(String Id_or_add) {
		setAttrVal("Id_or_add", Id_or_add);
	}
	/**
	 * 补医嘱项目
	 * @return String
	 */
	public String getId_orsrv_add() {
		return ((String) getAttrVal("Id_orsrv_add"));
	}	
	/**
	 * 补医嘱项目
	 * @param Id_orsrv_add
	 */
	public void setId_orsrv_add(String Id_orsrv_add) {
		setAttrVal("Id_orsrv_add", Id_orsrv_add);
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
	 * 操作员
	 * @return String
	 */
	public String getId_emp_crea() {
		return ((String) getAttrVal("Id_emp_crea"));
	}	
	/**
	 * 操作员
	 * @param Id_emp_crea
	 */
	public void setId_emp_crea(String Id_emp_crea) {
		setAttrVal("Id_emp_crea", Id_emp_crea);
	}
	/**
	 * 操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_crea() {
		return ((FDateTime) getAttrVal("Dt_crea"));
	}	
	/**
	 * 操作时间
	 * @param Dt_crea
	 */
	public void setDt_crea(FDateTime Dt_crea) {
		setAttrVal("Dt_crea", Dt_crea);
	}
	/**
	 * 删除操作员
	 * @return String
	 */
	public String getId_emp_del() {
		return ((String) getAttrVal("Id_emp_del"));
	}	
	/**
	 * 删除操作员
	 * @param Id_emp_del
	 */
	public void setId_emp_del(String Id_emp_del) {
		setAttrVal("Id_emp_del", Id_emp_del);
	}
	/**
	 * 删除时间
	 * @return FDateTime
	 */
	public FDateTime getDt_del() {
		return ((FDateTime) getAttrVal("Dt_del"));
	}	
	/**
	 * 删除时间
	 * @param Dt_del
	 */
	public void setDt_del(FDateTime Dt_del) {
		setAttrVal("Dt_del", Dt_del);
	}
	/**
	 * 预交金操作员
	 * @return String
	 */
	public String getId_emp_ppay() {
		return ((String) getAttrVal("Id_emp_ppay"));
	}	
	/**
	 * 预交金操作员
	 * @param Id_emp_ppay
	 */
	public void setId_emp_ppay(String Id_emp_ppay) {
		setAttrVal("Id_emp_ppay", Id_emp_ppay);
	}
	/**
	 * 预交金时间
	 * @return FDateTime
	 */
	public FDateTime getDt_ppay() {
		return ((FDateTime) getAttrVal("Dt_ppay"));
	}	
	/**
	 * 预交金时间
	 * @param Dt_ppay
	 */
	public void setDt_ppay(FDateTime Dt_ppay) {
		setAttrVal("Dt_ppay", Dt_ppay);
	}
	/**
	 * 预交金退费操作员
	 * @return String
	 */
	public String getId_emp_returns() {
		return ((String) getAttrVal("Id_emp_returns"));
	}	
	/**
	 * 预交金退费操作员
	 * @param Id_emp_returns
	 */
	public void setId_emp_returns(String Id_emp_returns) {
		setAttrVal("Id_emp_returns", Id_emp_returns);
	}
	/**
	 * 预交金退费时间
	 * @return FDateTime
	 */
	public FDateTime getDt_returns() {
		return ((FDateTime) getAttrVal("Dt_returns"));
	}	
	/**
	 * 预交金退费时间
	 * @param Dt_returns
	 */
	public void setDt_returns(FDateTime Dt_returns) {
		setAttrVal("Dt_returns", Dt_returns);
	}
	/**
	 * 补费科室
	 * @return String
	 */
	public String getId_dep_cg() {
		return ((String) getAttrVal("Id_dep_cg"));
	}	
	/**
	 * 补费科室
	 * @param Id_dep_cg
	 */
	public void setId_dep_cg(String Id_dep_cg) {
		setAttrVal("Id_dep_cg", Id_dep_cg);
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
	 * 唯一码
	 * @return String
	 */
	public String getOnlycode() {
		return ((String) getAttrVal("Onlycode"));
	}	
	/**
	 * 唯一码
	 * @param Onlycode
	 */
	public void setOnlycode(String Onlycode) {
		setAttrVal("Onlycode", Onlycode);
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
		return "Id_otorrelat";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_ot_or_relat";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpOtOrRelatDODesc.class);
	}
	
}