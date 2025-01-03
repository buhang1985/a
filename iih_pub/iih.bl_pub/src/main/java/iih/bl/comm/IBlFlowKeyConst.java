package iih.bl.comm;

/**
 * 费用域流程上下文key常量
 * @author ly 2018/07/23
 *
 */
public interface IBlFlowKeyConst {

	/**
	 * 流程上下文前缀
	 */
	public static final String BL_FLOW_KEY = "bl_flow_key_";
	
	/**
	 * 当前时间-->FDateTime
	 */
	public static final String BL_FLOW_KEY_NOW = "bl_flow_key_now";
	
	/**
	 * 记账来源
	 */
	public static final String BL_FLOW_KEY_SRCFUNC = "bl_flow_key_srcfunc";
	
	/**
	 * 终端类型
	 */
	public static final String BL_FLOW_KEY_SD_PTTP = "bl_flow_key_sd_pttp";
	
	/**
	 * 人员
	 */
	public static final String BL_FLOW_KEY_ID_EMP = "bl_flow_key_id_emp";
	
	/**
	 * 就诊数据
	 */
	public static final String BL_FLOW_KEY_EN_ENT = "bl_flow_key_en_ent";
	
	/**
	 * 医嘱数据
	 */
	public static final String BL_FLOW_KEY_CI_ORDER = "bl_flow_key_ci_order";
	
	/**
	 * 医嘱服务数据
	 */
	public static final String BL_FLOW_KEY_CI_OR_SRV = "bl_flow_key_ci_or_srv";
	
	/**
	 * 体检流水号
	 */
	public static final String BL_FLOW_KEY_PE_CODE = "bl_flow_key_pe_code";
	
	/**
	 * 门诊半退流程数据
	 */
	public static final String BL_FLOW_OPREFUND_EVENTDATA ="bl_flow_oprefund_eventdata";
	/**
	 * 结算编码前置,结算编码
	 */
	public static final String BL_FLOW_KEY_ST_CODE="bl_flow_key_st_code";
	
	/**
	 * 划价流程产生记账数据
	 */
	public static final String BL_FLOW_KEY_PRICING_CG = "bl_flow_key_pricing_cg";
	
	/**
	 * 划价流程产生结算数据
	 */
	public static final String BL_FLOW_KEY_PRICING_ST = "bl_flow_key_pricing_st";
	
	/**
	 * 结算结转
	 */
	public static final String BL_FLOW_KEY_TRANSFERPREPAY="bl_flow_key_transferprepay";

}
