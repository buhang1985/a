package iih.ci.mrm.cimrmoperate.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrm.cimrmoperate.d.desc.CiMrmOperateDODesc;
import java.math.BigDecimal;

/**
 * 病案操作 DO数据 
 * 
 */
public class CiMrmOperateDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//主键
	public static final String ID_CI_MRM_OP= "Id_ci_mrm_op";
	//病案表主键
	public static final String ID_AMR= "Id_amr";
	//(操作)人员表主键
	public static final String ID_PSN_OP= "Id_psn_op";
	//操作类型表主键
	public static final String ID_BD_MRM_OT= "Id_bd_mrm_ot";
	//操作类型表编码
	public static final String SD_BD_MRM_OT= "Sd_bd_mrm_ot";
	//操作时间
	public static final String DT_OP= "Dt_op";
	//操作流程定义（前进、回退等）
	public static final String ID_OPTP= "Id_optp";
	//操作流程定义编码
	public static final String SD_OPTP= "Sd_optp";
	//修改原因
	public static final String UPDATEREASON= "Updatereason";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//客户扩展字段1
	public static final String DEF1= "Def1";
	//客户扩展字段2
	public static final String DEF2= "Def2";
	//客户扩展字段3
	public static final String DEF3= "Def3";
	//客户扩展字段4
	public static final String DEF4= "Def4";
	//客户扩展字段5
	public static final String DEF5= "Def5";
	//姓名
	public static final String PSN_OP_NAME= "Psn_op_name";
	//名称
	public static final String NAME= "Name";
	//编码
	public static final String CODE= "Code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_ci_mrm_op() {
		return ((String) getAttrVal("Id_ci_mrm_op"));
	}	
	/**
	 * 主键
	 * @param Id_ci_mrm_op
	 */
	public void setId_ci_mrm_op(String Id_ci_mrm_op) {
		setAttrVal("Id_ci_mrm_op", Id_ci_mrm_op);
	}
	/**
	 * 病案表主键
	 * @return String
	 */
	public String getId_amr() {
		return ((String) getAttrVal("Id_amr"));
	}	
	/**
	 * 病案表主键
	 * @param Id_amr
	 */
	public void setId_amr(String Id_amr) {
		setAttrVal("Id_amr", Id_amr);
	}
	/**
	 * (操作)人员表主键
	 * @return String
	 */
	public String getId_psn_op() {
		return ((String) getAttrVal("Id_psn_op"));
	}	
	/**
	 * (操作)人员表主键
	 * @param Id_psn_op
	 */
	public void setId_psn_op(String Id_psn_op) {
		setAttrVal("Id_psn_op", Id_psn_op);
	}
	/**
	 * 操作类型表主键
	 * @return String
	 */
	public String getId_bd_mrm_ot() {
		return ((String) getAttrVal("Id_bd_mrm_ot"));
	}	
	/**
	 * 操作类型表主键
	 * @param Id_bd_mrm_ot
	 */
	public void setId_bd_mrm_ot(String Id_bd_mrm_ot) {
		setAttrVal("Id_bd_mrm_ot", Id_bd_mrm_ot);
	}
	/**
	 * 操作类型表编码
	 * @return String
	 */
	public String getSd_bd_mrm_ot() {
		return ((String) getAttrVal("Sd_bd_mrm_ot"));
	}	
	/**
	 * 操作类型表编码
	 * @param Sd_bd_mrm_ot
	 */
	public void setSd_bd_mrm_ot(String Sd_bd_mrm_ot) {
		setAttrVal("Sd_bd_mrm_ot", Sd_bd_mrm_ot);
	}
	/**
	 * 操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_op() {
		return ((FDateTime) getAttrVal("Dt_op"));
	}	
	/**
	 * 操作时间
	 * @param Dt_op
	 */
	public void setDt_op(FDateTime Dt_op) {
		setAttrVal("Dt_op", Dt_op);
	}
	/**
	 * 操作流程定义（前进、回退等）
	 * @return String
	 */
	public String getId_optp() {
		return ((String) getAttrVal("Id_optp"));
	}	
	/**
	 * 操作流程定义（前进、回退等）
	 * @param Id_optp
	 */
	public void setId_optp(String Id_optp) {
		setAttrVal("Id_optp", Id_optp);
	}
	/**
	 * 操作流程定义编码
	 * @return String
	 */
	public String getSd_optp() {
		return ((String) getAttrVal("Sd_optp"));
	}	
	/**
	 * 操作流程定义编码
	 * @param Sd_optp
	 */
	public void setSd_optp(String Sd_optp) {
		setAttrVal("Sd_optp", Sd_optp);
	}
	/**
	 * 修改原因
	 * @return String
	 */
	public String getUpdatereason() {
		return ((String) getAttrVal("Updatereason"));
	}	
	/**
	 * 修改原因
	 * @param Updatereason
	 */
	public void setUpdatereason(String Updatereason) {
		setAttrVal("Updatereason", Updatereason);
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
	 * 客户扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 客户扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 客户扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 客户扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 客户扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 客户扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 客户扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	/**
	 * 客户扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 客户扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	/**
	 * 客户扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getPsn_op_name() {
		return ((String) getAttrVal("Psn_op_name"));
	}	
	/**
	 * 姓名
	 * @param Psn_op_name
	 */
	public void setPsn_op_name(String Psn_op_name) {
		setAttrVal("Psn_op_name", Psn_op_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
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
		return "Id_ci_mrm_op";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mrm_op";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrmOperateDODesc.class);
	}
	
}