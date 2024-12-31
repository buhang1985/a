package iih.sfda.aeh.evrptflow;

public interface FlowProdefConst {

	/**
	 * 流程状态_未开始
	 */
	public static final String PROINS_STATUS_TODO = "Todo";
	/**
	 * 流程状态_进行中
	 */
	public static final String PROINS_STATUS_RUN = "Run";
	/**
	 * 流程状态_结束
	 */
	public static final String PROINS_STATUS_END = "End";

	/**
	 * 流程节点_第一级(事件发现者)
	 */
	public static final String NODEINS_STATUS_FIRST = "01";

	/**
	 * 流程节点_第二级(第2级)主任、护士长)
	 */
	public static final String NODEINS_STATUS_SECOND = "02";

	/**
	 * 流程节点_第三级((第3级)业务主管部门)
	 */
	public static final String NODEINS_STATUS_THIRD = "03";

	/**
	 * 流程节点_流程结束
	 */
	public static final String NODEINS_STATUS_END = "09";

	/**
	 * 不良事件管理_事件处理流程类型
	 */
	public static final String TP_EVENTHANDLE = "@@@@Z8100000000CJMI5";

	/**
	 * 不良事件处理流程_当事科室任务分发类全路径
	 */
	public static final String AER_EV_AFFAIRS_FULL_CLASS = "iih.sfda.aeh.evrptflow.listener.flowconfig.AffairsDeptActorListener";

	/**
	 * 不良事件处理流程_归口部门任务分发类全路径
	 */
	public static final String AER_EV_CENTRALIZED_FULL_CLASS = "iih.sfda.aeh.evrptflow.listener.flowconfig.CentralizedDeptActorListener";

	/**
	 * 任务状态_待办
	 */
	public static final String TASK_STATUS_TODO = "Todo";
	/**
	 * 任务状态_已办
	 */
	public static final String TASK_STATUS_COMPLETED = "Completed";

	/**
	 * 任务创建类型_常规创建
	 */
	public static final String TASK_CREATETTPE_NORMAL = "Normal";

	/**
	 * 任务创建类型_驳回创建
	 */
	public static final String TASK_CREATETTPE_REJECT = "Reject";

}
