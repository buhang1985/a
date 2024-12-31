package iih.bd.srv.mrtaskrule.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.mrtaskrule.d.desc.MrTaskRuleSupportDODesc;
import java.math.BigDecimal;

/**
 * 病历书写任务支持 DO数据 
 * 
 */
public class MrTaskRuleSupportDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//支持表主键
	public static final String ID_MR_TR_SU= "Id_mr_tr_su";
	//主表主键
	public static final String ID_MR_TASK_RULE= "Id_mr_task_rule";
	//医疗服务
	public static final String ID_SRV= "Id_srv";
	//服务名称
	public static final String SUPPORT_NAME= "Support_name";
	//服务编码
	public static final String SUPPORT_CODE= "Support_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 支持表主键
	 * @return String
	 */
	public String getId_mr_tr_su() {
		return ((String) getAttrVal("Id_mr_tr_su"));
	}	
	/**
	 * 支持表主键
	 * @param Id_mr_tr_su
	 */
	public void setId_mr_tr_su(String Id_mr_tr_su) {
		setAttrVal("Id_mr_tr_su", Id_mr_tr_su);
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
	 * 服务名称
	 * @return String
	 */
	public String getSupport_name() {
		return ((String) getAttrVal("Support_name"));
	}	
	/**
	 * 服务名称
	 * @param Support_name
	 */
	public void setSupport_name(String Support_name) {
		setAttrVal("Support_name", Support_name);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getSupport_code() {
		return ((String) getAttrVal("Support_code"));
	}	
	/**
	 * 服务编码
	 * @param Support_code
	 */
	public void setSupport_code(String Support_code) {
		setAttrVal("Support_code", Support_code);
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
		return "Id_mr_tr_su";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mr_tr_su";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MrTaskRuleSupportDODesc.class);
	}
	
}