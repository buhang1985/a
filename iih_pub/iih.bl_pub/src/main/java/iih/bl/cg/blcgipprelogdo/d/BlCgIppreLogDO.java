package iih.bl.cg.blcgipprelogdo.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.cg.blcgipprelogdo.d.desc.BlCgIppreLogDODesc;
import java.math.BigDecimal;

/**
 * 预住院费用转出日志 DO数据 
 * 
 */
public class BlCgIppreLogDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//预住院费用转出日志主键
	public static final String ID_BLCGIPPRELOG= "Id_blcgipprelog";
	//原预住院记账主键
	public static final String ID_CGIP_PRE= "Id_cgip_pre";
	//转入的就诊类型编码
	public static final String CODE_ENTP= "Code_entp";
	//就诊id
	public static final String ID_ENT= "Id_ent";
	//转入的就诊类型ID
	public static final String ID_ENTP= "Id_entp";
	//转入的记账主键
	public static final String ID_CGIP_NEW= "Id_cgip_new";
	//转入数量
	public static final String QUAN= "Quan";
	//转入金额
	public static final String AMT= "Amt";
	//操作员
	public static final String ID_EMP_OPER= "Id_emp_oper";
	//操作时间
	public static final String DT_OPER= "Dt_oper";
	//备注
	public static final String NOTE= "Note";
	//有效标志
	public static final String FG_ACTIVE= "Fg_active";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 预住院费用转出日志主键
	 * @return String
	 */
	public String getId_blcgipprelog() {
		return ((String) getAttrVal("Id_blcgipprelog"));
	}	
	/**
	 * 预住院费用转出日志主键
	 * @param Id_blcgipprelog
	 */
	public void setId_blcgipprelog(String Id_blcgipprelog) {
		setAttrVal("Id_blcgipprelog", Id_blcgipprelog);
	}
	/**
	 * 原预住院记账主键
	 * @return String
	 */
	public String getId_cgip_pre() {
		return ((String) getAttrVal("Id_cgip_pre"));
	}	
	/**
	 * 原预住院记账主键
	 * @param Id_cgip_pre
	 */
	public void setId_cgip_pre(String Id_cgip_pre) {
		setAttrVal("Id_cgip_pre", Id_cgip_pre);
	}
	/**
	 * 转入的就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	/**
	 * 转入的就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
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
	 * 转入的就诊类型ID
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	/**
	 * 转入的就诊类型ID
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	/**
	 * 转入的记账主键
	 * @return String
	 */
	public String getId_cgip_new() {
		return ((String) getAttrVal("Id_cgip_new"));
	}	
	/**
	 * 转入的记账主键
	 * @param Id_cgip_new
	 */
	public void setId_cgip_new(String Id_cgip_new) {
		setAttrVal("Id_cgip_new", Id_cgip_new);
	}
	/**
	 * 转入数量
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}	
	/**
	 * 转入数量
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 转入金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	/**
	 * 转入金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 操作员
	 * @return String
	 */
	public String getId_emp_oper() {
		return ((String) getAttrVal("Id_emp_oper"));
	}	
	/**
	 * 操作员
	 * @param Id_emp_oper
	 */
	public void setId_emp_oper(String Id_emp_oper) {
		setAttrVal("Id_emp_oper", Id_emp_oper);
	}
	/**
	 * 操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_oper() {
		return ((FDateTime) getAttrVal("Dt_oper"));
	}	
	/**
	 * 操作时间
	 * @param Dt_oper
	 */
	public void setDt_oper(FDateTime Dt_oper) {
		setAttrVal("Dt_oper", Dt_oper);
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
	 * 有效标志
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 有效标志
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
		return "Id_blcgipprelog";
	}
	
	@Override
	public String getTableName() {	  
		return "Bl_cg_ippre_log";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlCgIppreLogDODesc.class);
	}
	
}