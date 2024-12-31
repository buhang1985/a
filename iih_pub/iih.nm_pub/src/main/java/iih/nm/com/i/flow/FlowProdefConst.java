package iih.nm.com.i.flow;

public interface FlowProdefConst {

	/**
	 * 单据待提交
	 */
	public static final String PROINS_STATUS_TODO = "Todo";
	/**
	 * 单据审核中
	 */
	public static final String PROINS_STATUS_RUN = "Run";
	/**
	 * 单据撤回
	 */
	public static final String PROINS_STATUS_BACK = "Back";
	/**
	 * 单据驳回
	 */
	public static final String PROINS_STATUS_REJECT = "Reject";
	/**
	 * 单据审批完成
	 */
	public static final String PROINS_STATUS_END = "End";

	/**
	 * 护理管理_人员替班流程类型
	 */
	public static final String TP_SCHEDRP = "@@@@Z8100000000AJJLQ";

	/**
	 * 护理管理_加班流程类型
	 */
	public static final String TP_OVERWORK = "@@@@Z8100000000B0PN0";

	/**
	 * 护理管理_请假流程类型
	 */
	public static final String TP_SCHEDLV = "@@@@Z8100000000BYCJ3";

	/**
	 * 人员替班主流程
	 */
	public static final String DEF_SCHEDRP = "@@@@Z8100000000AJJLR";

	/**
	 * 护理管理_人员加班主流程
	 */
	public static final String DEF_OVERWORK = "@@@@Z8100000000B0PN1";

	/**
	 * 护理管理_人员请假主流程
	 */
	public static final String DEF_SCHEDLV = "@@@@Z8100000000BYCJ6";

	/**
	 * 质量检查_持续改进流程
	 */
	public static final String PRODEF_IMPROV = "@@@@Z8100000000CT03I";
}
