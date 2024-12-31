package iih.bd.srv.mrtaskrule.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.mrtaskrule.d.desc.MrTaskRuleExcludeDODesc;
import java.math.BigDecimal;

/**
 * 病历书写任务排斥 DO数据 
 * 
 */
public class MrTaskRuleExcludeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//排斥表主键
	public static final String ID_MR_TR_EC= "Id_mr_tr_ec";
	//主表主键
	public static final String ID_MR_TASK_RULE= "Id_mr_task_rule";
	//医疗服务
	public static final String ID_SRV= "Id_srv";
	//服务编码
	public static final String EXCLUDE_CODE= "Exclude_code";
	//服务名称
	public static final String EXCLUDE_NAME= "Exclude_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 排斥表主键
	 * @return String
	 */
	public String getId_mr_tr_ec() {
		return ((String) getAttrVal("Id_mr_tr_ec"));
	}	
	/**
	 * 排斥表主键
	 * @param Id_mr_tr_ec
	 */
	public void setId_mr_tr_ec(String Id_mr_tr_ec) {
		setAttrVal("Id_mr_tr_ec", Id_mr_tr_ec);
	}
	/**
	 * 主表主键
	 * @return String
	 */
	public String getId_mr_task_rule() {
		return ((String) getAttrVal("Id_mr_task_rule"));
	}	
	/**
	 * 主表主键
	 * @param Id_mr_task_rule
	 */
	public void setId_mr_task_rule(String Id_mr_task_rule) {
		setAttrVal("Id_mr_task_rule", Id_mr_task_rule);
	}
	/**
	 * 医疗服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 医疗服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getExclude_code() {
		return ((String) getAttrVal("Exclude_code"));
	}	
	/**
	 * 服务编码
	 * @param Exclude_code
	 */
	public void setExclude_code(String Exclude_code) {
		setAttrVal("Exclude_code", Exclude_code);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getExclude_name() {
		return ((String) getAttrVal("Exclude_name"));
	}	
	/**
	 * 服务名称
	 * @param Exclude_name
	 */
	public void setExclude_name(String Exclude_name) {
		setAttrVal("Exclude_name", Exclude_name);
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
		return "Id_mr_tr_ec";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mr_tr_ec";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MrTaskRuleExcludeDODesc.class);
	}
	
}