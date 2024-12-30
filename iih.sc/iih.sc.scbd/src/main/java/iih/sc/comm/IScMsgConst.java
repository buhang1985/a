package iih.sc.comm;

/**
 * 预约错误信息、提示信息常量
 * 
 * @author Administrator
 *
 */
public interface IScMsgConst {

	/**
	 * 通用区域
	 */
	public static final String SC_SELECT_DELETE = "请选择要删除的数据！"; // 删除通用提示信息
	public static final String SC_DELETE_SUCCESS = "删除成功！"; // 删除成功后提示
	public static final String SC_SELECTED = "请选择一行数据！"; // 选择通用提示信息
	public static final String SC_QUERY_FAIL = "没有查询到相关记录，请重新操作!"; // 没有查询到相关记录提示信息，查询通用提示信息
	public static final String SC_CANCEL = "是否取消"; // 取消按钮都要有确认提示信息
	public static final String SC_SAVE = "保存成功！"; // 保存成功后提示
	public static final String SC_BEGTIME_ISNULL = "请选择开始时间！"; // 没有选择开始时间
	public static final String SC_ENDTIME_ISNULL = "请选择结束时间！"; // 没有选择结束时间
	public static final String SC_ENDTIME_OVER_BEGINTIME = "结束日期不能小于开始日期，请重新选择!";
	public static final String SC_DELETE = "确定要删除吗?";
	public static final String SC_BREAK = "是否爽约?";
	public static final String SC_CONFIRM = "确认";// 提示对话框标题
	public static final String SC_CFM_MSG_TITLE = "提示信息";// 提示对话框标题
	public static final String SC_INPUT_ALL_REQUIRED = "带*号的为必填项，请维护所有带*号的数据!";// 必填项为空提示
	public static final String SC_D_NEXT_APPT = "建议复诊时间必须大于当前时间";// 建议复诊时间必须大于当前时间
	public static final String SC_OP_SCTP_UNDEFINED = "门诊排班分类未定义";
	public static final String SC_SCTP_UNDEFINED = "排班分类未定义";
	public static final String SC_BD_LOG_NEW_AND_OLD_NOT_EXISTS = "参数:新数据、旧数据都为空！";
	public static final String SC_PAT_NOT_EXISTS = "该患者不存在！";
	public static final String SC_CHL_PERIOD_NOT_DEFINED = "该类型预约期限未定义，请到渠道维护页面进行设置！";
	public static final String DATA_EXCEPTION = "数据异常，请重新操作!";
	public static final String SC_CHL_IN_ROOM_NOT_DEFINED = "诊间渠道未定义";
	public static final String SC_CHL_IN_ROOM_DEPT_NOT_DEFINED = "诊间渠道(本科)未定义";
	public static final String SC_DEPT_PARAM_PERIOD_OVERLAP = "午别的时间区间重叠";
	public static final String SC_BD_ERROR_BEGIN_AFTER_END = "开始时间需小于结束时间";
	// 集成平台事件
	public static final String ERROR_LISTENER_NO_SOURCE = "事件源数据不能为空！";
	public static final String ERROR_ENOPQUE_EVENT_TYPE = "事件类型错误";
	public static final String ERROR_LISTENER_NOT_MATCH_EVENT = "监听器与事件源不匹配！";
	/**
	 * 预约
	 */
	public static final String SC_APT_PAT = "未找到对应的患者信息，请先进行注册"; // 预约验证是否存在患者信息时使用
	public static final String SC_APT_SELECT_PAT = "请先选择患者！"; // 预约时判断是否先选中患者
	public static final String SC_APT_CANCEL_STATE = "非预约状态不能取消"; // 取消预约-只能取消预约状态为预约的预约的提示
	public static final String SC_APT_APPL_CANCEL = "取消状态的申请不能修改"; // 预约申请已经取消的不能修改
	public static final String SC_APT_CANCEL_SUCCESS = "取消预约成功!"; // 取消预约成功提示信息
	public static final String SC_APT_HOSPITAL_ALL = "请先维护医院全部渠道信息！"; // 预约打开判断是否存在对应渠道
	public static final String SC_APT_HOSPITAL_Triage = "请先维护分诊台渠道信息！"; // 预约打开判断是否存在对应渠道
	public static final String SC_APT_NULL_QUENO = "没有号可供预约!"; // 预约时没有号可供预约
	public static final String SC_APT_HAVE_APT = "已经预约，请重新操作"; // 患者在一个排班下已经有预约不能再次预约
	public static final String SC_APT_DATETIME_OVERDUE = "不能在过去时间内预约!"; // 预约时间过期
	public static final String SC_APT_NULL_OBS = "不存在对应申请单，请重新输入"; // 医技诊间预约-不存在对应申请单，请重新输入
	public static final String SC_APT_OVER_MAXDATE = "超过了渠道定义的最大可预约日期!"; // 判断预约时间,超过了渠道定义的最大可预约日期
	public static final String SC_APT_TICK_USD = "票号已被预约，请刷新页面重新操作"; // 预约时选的票号被他人预约时提示
	public static final String SC_APT_SDSCCHLTP_ISNULL = "渠道编码为空，请检查节点访问路径是否配置正确"; // 预约时
																					// 可能节点url
																					// 没有配置相关渠道编码
	public static final String SC_APT_APPL_NOT_FOUND = "未找到对应的申请单信息! ";			
	public static final String SC_APT_PERIOD_CANNOT = "预约的日期和午别在渠道期间内不可预约！";

	public static final String SC_APT_MT_CURRENTDEPT_NOT_MT = "当前登录科室不为医技科室";
	public static final String SC_APT_OP_SCH_CHL_INROOM_NOT_EXISTS = "该排班的诊间预约渠道未定义，请定义后重试！";
	public static final String SC_APT_OP_SCH_CHL_INROOM_DEPT_NOT_EXISTS = "该排班的诊间预约渠道未定义，请定义后重试！";
	// public static final String SC_APT_MT_CHK_OBS_ITM =
	// "申请单中的医疗服务在该排班对应的医疗服务中不存在或系统参数医技预约检查项目类型设置为不可用";
	public static final String SC_APT_NOT_EXIST = "该预约不存在！";
	public static final String SC_APT_OP_NOT_EXIST = "该门诊预约不存在！";
	public static final String SC_APT_OP_CAN_RETAKE = "该预约已经取号，不能重复取号！";
	public static final String SC_APT_OP_HAS_TAKEN = "该预约已取号，无法取消!";
	public static final String SC_APT_OP_TAKEN_HAS_CANCELED = "该预约已经取消，不能取号!";
	public static final String SC_APT_TAKE_NO_PAY = "该预约未支付，不能取号!";
	public static final String SC_APT_OP_HAS_CANCELED = "该预约已经取消，不能重复取消!";
	public static final String SC_APT_OP_HAS_CANCELED_CANNOT_SETTLE = "该预约已经取消，不能进行支付!";
	public static final String SC_APT_OP_HAS_PAID = "该预约已经支付，不能重复支付！";
	public static final String SC_APT_RES_NOT_EXIST = "预约资源为空!";
	public static final String SC_APT_TAKE_HAS_NO_QUE = "计划未生成队列！";
	public static final String SC_APT_HAS_NO_EMP = "该预约没有记录操作员信息";
	public static final String SC_APT_CAN_CANCEL_BY_APT_DOC = "取消预约需挂号医生本人操作";
	public static final String SC_APT_SAVE_FAILED = "预约信息保存失败！";
	public static final String SC_APT_NOT_IN_ROOM_CHL = "此号并非在医院诊间预约，不能在此取消！";
	public static final String SC_APT_MT_SELECT_NOTAPT_PAT = "请选择待预约患者！";
	public static final String SC_APT_PLAN_SCSRV_EXISTS = "计划对应的服务不存在！";
	public static final String SC_APT_OP_CHL_ROOM_NOT_EXISTS = "该排班的诊间渠道未定义！";
	public static final String SC_APT_OP_ADD_NUM_TO_PAT_FAILED = "加号失败！";
	public static final String SC_APT_MT_WRITE_BACK_OBS = "申请单状态在别处修改，请重新操作！";
	public static final String SC_MAX_DAY_OBS_EXCLU_NOT_EXIST = "参数：检查互斥最大天数未定义！";
	public static final String SC_MAX_DAY_APTCFM_NOT_EXIST = "参数SC0230(医技预约最大确认天数)未定义！";

	/**
	 * 排班域
	 */
	public static final String ERROR_SC_APT_RES_NOT_ENOUGH = "没有可以使用的预约资源";
	public static final String ERROR_SC_SCH_RES_NOT_ENOUGH = "该排班没有可以使用的预约资源";
	public static final String ERROR_SC_SCH_TICKS_KINDITM = "该排班没有符合类别明细要求的号段";//预约时号段模式下校验号段的排班服务类别明细 未通过校验提示该信息
	public static final String ERROR_SC_SCH_TICK_KINDITM = "该排班没有符合类别明细要求的号位";//预约时最后一步校验排班服务类别明细 未通过校验提示该信息
	public static final String SC_SCH_DATE_IS_OVER = "排班过期，不能修改排班相关数据"; // 排班过期，不能修改排班相关数据
	public static final String SC_SCH_USED_STATE = "排班下号源池数被使用，不能操作!"; // 人员、渠道、排班修改
																		// 被使用时提示信息
	public static final String SC_SCH_TICK_ADD_MAX = "一次最多允许加减20个号"; // 号段或号位
																		// 一次最多允许加减20个号
	public static final String SC_SCH_SHOP = "对应排班已经停诊，不能预约"; // 排班停诊后，不能再次预约
	public static final String SC_SCH_CLOSE = "排班已经停诊，无法挂号";
	public static final String SC_SCH_ISNULl = "排班为空，存在脏数据；请重新操作"; // 排班为空，存在脏数据；请重新操作
	public static final String ERROR_SC_SCH_POLCN_OUT_OF_RANGE = "号源池polcn须介于0-9之间！";
	public static final String ERROR_SC_SCH_NOT_EXISTS = "对应排班不存在！";
	public static final String ERROR_SCH_SCHS_PLAN_NOT_EXISTS = "排班对应的计划不存在";
	public static final String ERROR_SCH_TICK_USEDUP = "排班号源已经用完";
	public static final String ERROR_SCH_TICK_NOT_ENOUGHT = "排班号源不足！";
	public static final String ERROR_SCH_RES_NOT_EXISTS = "排班对应的号源为空！";
	public static final String ERROR_SCH_TICKS_NOT_EXISTS = "号段信息不存在";
	public static final String ERROR_SCH_TICKS_USED_UP = "号段已经用完";
	public static final String ERROR_SCH_TICK_NOT_EXISTS = "号位信息不存在";
	public static final String ERROR_SCH_TICK_NOT_ENOUGH = "没有可用号位";
	public static final String ERROR_SCH_TICK_NOT_ENOUGH_4_SCSRV = "该项目没有可用的排班服务资源";
	public static final String ERROR_SCH_TICK_NOT_ENOUGH_4_SCSRV_TYPE = "预约的排班跟该项目的排班不符";
	public static final String ERROR_SCH_TICK_NOT_MATCH_CHL = "当前渠道不能使用该号位！";
	public static final String ERROR_SCH_TICK_USED = "该号位已经被占用，请选择其他号位！";
	public static final String ERROR_SCH_TICK_CANCED = "该号位已经被取消，请选择其他号位！";
	public static final String ERROR_SCH_TICK_NOT_ENOUGH_FOR_SUB = "号位不足，无法减号";
	public static final String ERROR_SCH_NOT_ENOUGH_FOR_SUB = "可用号源不足，无法减号";
	public static final String ERROR_SCH_MAX_FOR_ADD = "超过最大可加号数，无法加号";
	public static final String ERROR_SCH_POL_NOT_ENOUGH_FOR_SUB = "该号源池剩余数,不足减号！";
	public static final String ERROR_SCH_USED_IS_EMPTY_CANNOT_DRAWBACK = "已使用号源为0，不能退！";
	public static final String SC_SCH_SCPL_ISNULL = "请选择排班计划！"; // 在不是全院和一个科室只针对一个科室一个计划排班时
	public static final String SC_SCH_TOTAL_OVER_APPTTOTAL = "数量总数应大于等于可预约总数";
	public static final String SC_SCH_TOTAL_OVER_QUANTOTAL = "可预约总数应大于等于各号源池可预约数总和且小于等于数量总数！";
	public static final String SC_SCH_TOTAL_ISNULL = "请填写总数";
	public static final String SC_SCH_APPT_TOTAL_ISNULL = "请填写预约总数";
	public static final String ERROR_SCH_POL_NOT_MATCH_FOR_TICK = "该号位号源池号与可预约号源池号不符!";
	// TODO 排班选择出诊人员时 如果没有选人员时给出提示 也可以改为选择出诊医生
	public static final String SC_SCH_EMP_ISNULL = "请选择人员";
	public static final String SC_SCH_HAVE_EQUAL_EMP = "本次操作的存在相同的人员，请重新选择";
	public static final String SC_SCH_DATABASE_HAVE_EQUAL_EMP = "已存在相同人员请重新选择";
	public static final String SC_SCH_SCPLAN_ISEMPY = "排班不存在对应计划！";
	public static final String SC_SCH_ADJ_SUCCES = "调整成功！";
	public static final String SC_SCH_ADJ_SELECT_DEPT = "请选择对应科室！";
	public static final String SC_SCH_ADJ_DEPT_OR_ALL = "请选择全院或科室！";
	public static final String SC_SCH_ADJ_SELECT_TARGETDATE = "请选择调整到日期！";
	public static final String SC_SCH_ADJ_SELECT_OLDDATE = "请选择原日期！";
	public static final String SC_SCH_ADJ_SELECT_ADJTYPE = "请选择调整类型！";
	public static final String SC_SCH_ADJ_NULL_SCPL = "排除条件列表中存在未选择的排班计划";
	public static final String SC_SCH_ADJ_EFFECTIVE_DATA = "本次操作不存在有效数据，请重新操作";
	public static final String SC_MT_SCH_NOT_CALENDAR = "请先维护本时段内的工作日历!";
	public static final String SC_ORAL_SCH_HAS_USED_SCH = "目标已经含有已经使用的排班，不能覆盖！";
	public static final String SC_ORAL_SCH_HAS_SCH_ON_OTHER_QUESITE = "复制的排班中存在其他诊椅上的排班！";
	public static final String SC_SCH_EXIST_USED_SCH = "存在已使用的排班，无法覆盖！";
	public static final String SC_SCH_PL_HAS_SCH_IN_OTHERSITE = "其他诊椅有排班！";
	public static final String SC_SCH_INFO_INCOMPLETE = "存在信息不完整的排班";

	/**
	 * 住院预约
	 */
	public static final String SC_APT_IP_CANCELAPT_FEEDBACK = "只能取消预约和确认状态的申请单！";// 除预约状态外其它状态的申请单不能取消预约
	public static final String SC_APT_IP_CANCELAPT = "只能取消预约状态的申请单！";// 除预约状态外其它状态的申请单不能取消预约
	public static final String SC_APT_IP_ISNULL = "申请单或床位信息不允许为空！";// 申请单或床位信息不允许为空
	public static final String SC_APT_IP_APPT = "申请单状态是申请或拒绝状态且所选床位是未预约状态才可预约！";// 申请单状态是申请状态且所选床位是未预约状态才可预约
	public static final String SC_APT_IP_MATCH = "申请单的必选床位特征与当前床位的特征不完全匹配,是否继续预约？";// 申请单状态是申请状态且所选床位是未预约状态才可预约
	public static final String SC_APT_IP_NURANDDEP = "申请科室与所选床位的所属病区不存在业务线关系， 请先维护上业务线关系!";// 申请单状态是申请状态且所选床位是未预约状态才可预约
	public static final String SC_APT_IP_CANC_IP_APP_SUCCESS = "住院申请，取消成功！";
	public static final String SC_APT_IP_CANC_IP_APP_CFM = "此住院申请，确定要取消吗？";
	public static final String SC_APT_IP_NOT_EXISTS = "住院申请不存在！";
	public static final String SC_APT_IP_HAS_CANCELED = "住院预约已经取消，不能 重复操作！";
	public static final String SC_APT_IP_NOT_APPLY_OR_REJECT = "住院预约非申请或拒绝状态，不能取消！";
	public static final String SC_APT_IP_SELECTED_SDSTATUS = "请选择申请单对应状态！";
	public static final String SC_APT_IP_IS_MODIFIED = "操作的申请单在别处被修改，请重新操作！";
	public static final String SC_APT_IP_BDBED_IS_MODIFIED = "申请单对应的床位预约标识在别处被修改，请重新操作！";
	public static final String SC_APT_IP_NO_EXIST_MATCHING = "不存在匹配成功记录！";
	public static final String SC_APT_IP_NO_EXIST_APTIP = "未查询到申请单记录，请重新操作！";
	public static final String SC_APT_IP_HAS_REVOKE = "该申请单已经撤销，请刷新后重试！";
	public static final String SC_APT_IP_NO_EXIST_BED = "未查询到床位记录，请重新操作！";
	public static final String SC_APT_IP_NO_EXIST_BEDORIP = "申请单或床位为空，请重新操作！";
	public static final String SC_APT_IP_NO_UNAPT_APP = "未查到可用的未预约申请单！";

	/**
	 * 考勤
	 */
	public static final String SC_ATT_EMP_SCTASKEXEC = "人员在执行下已经排班，是否要覆盖？";
	public static final String SC_ATT_SELECT_SCTASKEXEC_CODE = "请输入考勤编码！";
	public static final String SC_ATT_SELECT_SCTASKEXEC_NAME = "请输入考勤名称！";
	public static final String SC_ATT_SELECT_SCTASKEXEC_SCTASKPERI = "请选择考勤区间！";
	public static final String SC_ATT_EXIST_SCTASKEXEC_CODE = "考勤编码重复，请重新输入!";
	public static final String SC_ATT_EXIST_SCTASKEXEC_NAME = "考勤名称重复，请重新输入!";

	/**
	 * 考勤计划
	 */
	public static final String SC_ATT_TASKPL_REPEAT = "考勤计划编码或名称重复，请重新填写！";
	public static final String SC_ATT_TASKPL_DEP = "请选择所属科室！";
	public static final String SC_ATT_TASKPL_DELETE = "该计划已经排班，不允许删除！";
	public static final String SC_ATT_TASKPL_DATE = "考勤结束日期应大于开始日期！";
	public static final String SC_ATT_TASKPL_EMP = "考勤人员重复，请重新选择!";
	public static final String SC_ATT_TASKPL_DEPTP = "考勤计划科室权限值不存在，请重新加载！";
	public static final String SC_ATT_TASKPL_WORKCALENDAR = "未获取到日历参照";
	public static final String SC_ATT_TASKPL_GROUP = "从当前上下文获取不到集团和组织";

	/**
	 * 考勤分类
	 */
	public static final String SC_ATT_TASKCA_TASKCAREPEAT = "考勤分类编码或名称不允许重复，请重新填写!";
	public static final String SC_ATT_TASKCA_TASKTPREPEAT = "项目类型不允许重复，请重新选择!";
	public static final String SC_ATT_TASKCA_PERIYEAR = "期间年度和对应会计年都要大于1900!";
	public static final String SC_ATT_TASKCA_BEGINTIME = "开始日期与期间年度应前后相差一年以内!";
	public static final String SC_ATT_TASKCA_ENDTIME = "结束日期与期间年度应前后相差一年以内且大于开始日期!";
	public static final String SC_ATT_TASKCA_PERIDATE = "对应会计年+月与期间年度应前后相差一个月以内!";
	public static final String SC_ATT_TASKCA_NAMEREPEAT = "期间名称不允许重复，请重新填写!";

	/**
	 * 排班基础数据
	 */
	public static final String SC_SCBD_SCCA_NAMEREPEAT = "排班分类编码或名称不允许重复，请重新填写!";
	public static final String SC_SCBD_SCCA_SCTPREPEAT = "排班类型不允许重复，请重新选择!";
	public static final String SC_SCBD_SCRULE_FUNC = "请填写外挂函数！";
	public static final String SC_SCBD_SCRULE_NUMBER = "开始号码应小于等于结束号码！";
	public static final String SC_SCBD_SCRULE_NAMEREPEAT = "预约规则编码和名称不允许重复，请重新填写！";
	public static final String SC_SCBD_SCRULE_RULETPREPEAT = "同一个排班分类下除外挂函数外的预约规则类型不允许重复，请重新选择！";
	public static final String SC_SCBD_SCCHL_BEGINTIME = "开始时间点应大于等于0且小于24！";
	public static final String SC_SCBD_SCCHL_NAMEREPEAT = "渠道编码或名称重复，请重新修改！";
	public static final String SC_SCBD_SCCHL_CHLTPNULL = "请选择一个渠道类型！";
	public static final String SC_SCBD_SCCHL_SCTPREPEAT = "排班分类不允许重复，请选择其它分类！";
	public static final String SC_SCBD_SCRES_SCCANULL = "排班分类为空!";
	public static final String SC_SCBD_SCRES_EMPREPEAT = "当前科室已经维护过该人员，请选择其他人员！";
	public static final String SC_SCBD_SCRES_NAMEREPEAT = "资源名称或编码重复，请重新填写!";
	public static final String SC_SCBD_SCRES_DEPREPEAT = "该科室已经维护过部门资源类型，请选择人员!";
	public static final String SC_SCBD_SCRES_RESNULL = "当前选中的资源数据不存在！";
	public static final String SC_SCBD_SCSRV_SCTPNULL = "没有可用的排班类型,请维护排班类型！";
	public static final String SC_SCBD_SCSRV_SELECTSRV = "请选择服务！";
	public static final String SC_SCBD_SCSRV_ADDMAINSRV = "排班服务必须维护对应的主医疗服务！";
	public static final String SC_SCBD_SCSRV_NAMEREPEAT = "服务编码或名称重复，请重新修改！";
	public static final String SC_SCBD_SCSRV_SRVREPEAT = "医疗服务重复，请重新选择医疗服务！";
	public static final String SC_SCBD_SCSRV_SCPOLCN = "默认对应号源池号应小于默认号源池总数，请重新填写！";
	public static final String SC_SCBD_SCSRV_CHLORSCPOLCN = "预约渠道或默认对应号源池号重复，请重新填写！";
	public static final String SC_SCBD_SCCHL_NOT_EXIST = "该类型渠道不存在！";
	public static final String SC_SCBD_TOTAL_CANNOT_NULL = "号源总数不能为空";
	public static final String SC_SCBD_ADD_NUM_CANNOT_NULL = "加号数量不能为空";
	public static final String SC_SCBD_ADD_NUM_CANNOT_OVER_TOTAL = "加号数量不能超过号源总数";

	/**
	 * 排班计划
	 */
	public static final String SC_SCP_SCPLAN_UNDELETE = "该计划已排班不能删除！";
	public static final String SC_SCP_SCPLAN_TOTAL = "请填写总数！";
	public static final String SC_SCP_SCPLAN_NAMEREPEAT = "排班计划编码或名称重复，请重新填写!";
	public static final String SC_SCP_SCPLAN_SRVREPEAT = "同一个科室下资源和服务不能同时重复!";
	public static final String SC_SCP_SCPLAN_QUANTOTAL = "请填写挂号总数！";
	public static final String SC_SCP_SCPLAN_APPTTOTAL = "请先填写预约总数！";
	public static final String SC_SCP_SCPLAN_SUMAPPTTOTAL = "数量总数应大于等于可预约总数！";
	public static final String SC_SCP_SCPLAN_APPTCNTOTAL = "可预约总数应大于等于号源池可预约总数且小于等于数量总数！";
	public static final String SC_SCP_SCPLAN_FIELDFALSE = "的数据不正确，请重新填写！";
	public static final String SC_SCP_SCPLAN_CHLSELECT = "请选择渠道！";
	public static final String SC_SCP_SCPLAN_SCPOLCN = "请填写对应号源池编号！";
	public static final String SC_SCP_SCPLAN_CHLREPEAT = "渠道不能重复，请选择其他渠道！";
	public static final String SC_SCP_SCPLAN_SCPOLCNTOTAL = "号源池编号的值要小于排班计划中的号源池总数";
	public static final String SC_SCP_SCPLAN_EMPSPEC = "已选中授权医生，请维护授权科室！";
	public static final String SC_SCP_SCPLAN_EMPSELECT = "请选择人员！";
	public static final String SC_SCP_SCPLAN_EMPREPEAT = "该人员已存在，请选择其他人员！";
	public static final String SC_SCP_SCPLAN_TIMEBEGIN = "当前行的预计开始时间应大于等于上一行的开始时间小于等于自己的结束时间！";
	public static final String SC_SCP_SCPLAN_QUECN = "票号张数数据输入不合理，请重新输入！";
	public static final String SC_SCP_SCPLAN_SCPLANNULL = "排班计划不存在！";
	public static final String SC_SCP_SCPLAN_SCRULENULL = "预约规则不存在！";
	public static final String SC_SCP_SCPLAN_SCRULE_CODENULL = "未获取到预约规则编码，请检查数据数据是否完整！";
	public static final String SC_SCP_DAYSLOST_NULL = "医技排班分类对应的日期分组分类不存在日期分组数据!";
	public static final String SC_SCP_SCPLAN_SCCANULL = "排班分类不存在！";
	public static final String SC_SCP_SCPLAN_SCPLWEEKNULL = "周计划不存在！";
	public static final String SC_SCP_SCPLAN_DAYSLOTNULL = "未获取到午别数据，请重新操作！";

	/**
	 * 医技排班计划
	 */
	public static final String SC_SCP_SCPLAN_MT_CHLREPEAT = "预约渠道重复，请选择其它渠道！";
	public static final String SC_SCP_SCPLAN_MT_NUMBER = "号源池对应号源数总和应等于可预约数！";
	public static final String SC_SCP_SCPLAN_MT_FTIMEMIXED = "该号段的开始时间、结束时间与其它时间段有交集，请重新修改！";
	public static final String SC_SCP_SCPLAN_MT_FTIME = "开始时间应小于结束时间，请重新修改！";
	public static final String SC_SCP_SCPLAN_MT_QUECN = "票号张数总和应等于总号源数，请重新修改！";
	public static final String SC_SCP_SCPLAN_MT_APPT = "可预约数总和应等于可预约数，请重新修改！";
	public static final String SC_SCP_SCPLAN_MT_NOTCONTAIN = "该号段的开始时间和结束时间不在诊疗时间内，请重新修改！";
	public static final String SC_SCP_SCPLAN_MT_SCPOLCN = "号源池数已达到最大值10个，不能新增！";
	public static final String SC_SCP_SCPLAN_MT_TICKTIME = "编辑行的开始时间应大于上一行的开始时间小于下一行的开始时间且在诊疗时间之内！";
	public static final String SC_SCP_SCPLAN_MT_TICKAPPT = "号位可预约数之和与可预约号源总数不一致，请重新修改！";
	public static final String SC_SCP_SCPLAN_MT_TICKSCSRV = "排班服务重复，请重新修改！";
	public static final String SC_SCP_SCPLAN_MT_TICKSRVSLOT = "单服务时间不能为空！";
	public static final String SC_SCP_SCPLAN_MT_TICKFTIME = "开始时间应小于结束时间！";
	public static final String SC_SCP_SCPLAN_MT_SRVSLOT = "单服务时间*总号源数应小于等于诊疗时间！";
	public static final String SC_SCP_SCPLAN_MT_WEEKNO = "最多可排5周，不能继续新增！";
	public static final String SC_SCP_SCPLAN_MT_COPYWEEK = "请选择要复制到的星期数和周数！";
	public static final String SC_SCP_SCPLAN_MT_SAVEWEEK = "请先保存周计划！";
	public static final String SC_SCP_SCPLAN_MT_COVER = "选中日期中含有已经维护周计划的数据，是否覆盖？";
	public static final String SC_SCP_SCPLAN_MT_SCCADO = "请先维护医技排班分类！";
	public static final String ERROR_SCBDSRV_NOT_ASSIST = "未检索到医疗服务信息！";
	public static final String ERROR_SCBDSRV_NOT_CONFIG = "申请单：%s未在【医技排班医疗项目维护】中配置！";

	/**
	 * 口腔排班计划
	 */
	public static final String SC_SCP_SCPLAN_DD_SCCHLNULL = "渠道不存在，请维护渠道！";
	public static final String SC_SCP_SCPLAN_DD_NUMBER = "号源池对应号源数总和应等于可用号源总数！";

	/**
	 * 医技排班
	 */
	public static final String SC_SCHMT_CHL_APPT_AFTER_TOTAL = "各号源池开放号源总数大于总号源数！请重新输入";
	public static final String SC_SCHMT_CHL_APPT_LESS_USED = "存在号源池开放号源数小于使用数情况,请重新调整!";
	public static final String SC_SCHMT_TICKS_APPT_AFTER_TOTAL = "号段开放总数大于总号源数！请重新输入";
	public static final String SC_SCHMT_TICKS_APPT_LESS_USED = "号段存在开放数小于使用数情况,请重新调整!";
	public static final String SC_SCHMT_TICK_USED_SHOP = "号位已经被使用或者取消使用,不允许修改";
	public static final String SC_SCHMT_OVERTIME_NOTADD = "排班过期，不能加号";
	public static final String SC_SCHMT_SUMMATION_APPT_NOTEQUALS_TOTAL_APPT = "各号源池、号段、号位中开放数总和不等于总开放数!";
	public static final String SC_SCHMT_TICKS_QUECN_LESS_APPT = "号段开放数大于票号数,请重新输入!";

	/**
	 * 医技服务项目互斥
	 */
	public static final String SC_SCBD_SCSRVEXCL_REPEAT = "当前项目A和项目B已维护过间隔时间！";

	/**
	 * 排班科室参数设置
	 */
	public static final String SC_DEPPARAM_DAYSLOT_NULL = "日期分组分类不存在门诊类型，请先维护！";
	public static final String SC_DEPPARAM_SUGESTNOTMAX = "单服务时间超过诊疗时间的时间间隔，请重新修改！";
	public static final String SC_DEPPARAM_TIMEBEGINMAX = "开始时间应小于结束时间！";

	/**
	 * 口腔专科排班
	 */
	public static final String SC_SCH_ORAL_NO_WARD = "没找到科室x对应的护理单位, 先维护好护理单元才能对护士排班!";
	public static final String SC_SCH_ORAL_NO_NURS = "没找到科室x对应护理单位的护士信息！";
	public static final String SC_SCH_CACHE_SAVE = "当前操作会重新绘制表格是否继续？";
	public static final String SC_SCH_DAYSLOT_EMPTY = "日期分组对应的天计划不存在！请先维护";
	public static final String SC_SCH_CHL_USED_NOT_DELETE = "号源有使用，不能删除渠道!";
	public static final String SC_SCH_CHL_EXIST_EMPTY = "排班渠道数据存在号源池可预约数为空，请检查！";
	public static final String SC_SCH_NOT_EXIST_COPY_DATA = "不存在复制数据，请先复制!";
	public static final String SC_SCH_IS_USED = "%s的排班已被使用，不允许删除！";

	/**
	 * 口腔专科计划
	 */
	public static final String SC_SCP_SCPLANDD_SCCANULL = "请先维护门诊排班分类！";
	public static final String SC_SCP_SCPLANDD_RULENULL = "请先维护全部可用排班规则类型的预约规则！";
	public static final String SC_SCP_SCPLANDD_DEPPARAMNULL = "科室参数未设置，请先维护当前科室的科室参数！";
	public static final String SC_SCP_SCPLANDD_ADDTICKCOUT = "已达到最大加号数，不能继续加号！";
	public static final String SC_SCP_SCPLANDD_MINSCPOLCN = "号源池数不能小于科室参数设置中的最小号源池数！";
	public static final String SC_SCP_SCPLANDD_DEPIDNULL = "未获取到当前科室的值，请重新加载！";

	/**
	 * 口腔预约
	 */
	public static final String SC_APT_SCORAL_IDENTITY = "身份证验证失败！";
	public static final String SC_APT_SCORAL_MOBILE = "手机号格式错误！";
	public static final String SC_APT_SCORAL_DTBIRTH = "出生日期不能大于当前日期！";
	public static final String SC_APT_SCORAL_NOTENOUGH = "排班对应的号源池剩余数量不足, 不允许预约!";
	public static final String SC_APT_SELECT_DOCTOR = "请选择对应医生!";
	public static final String SC_APT_SELECT_ROOM = "请选择对应诊间!";
	public static final String SC_APT_SELECT_DAY = "请选择医生、诊间、全科三个查询条件中的一个";
	public static final String SC_APT_SCORAL_SELECT_PAT = "请先选择患者！";
	public static final String SC_APT_SCORAL_NOTCANCEL = "已经取号，不能退约!";
	public static final String SC_APT_SCORAL_NOTBREAK = "已经取号，不能爽约!";
	public static final String SC_APT_HAVA_TAKE_TICKET = "已取号，不能修改!";

	public static final String SC_APT_SCORAL_BREAK_NOTE = "爽约";

	public static final String SC_APT_ORAL_CANCEL_OR＿BREAK = "当前预约数据已被退约或爽约，请重新加载数据！";
	public static final String SC_APT_ORAL_NOT_CHL = "没有找到排班对应的预约渠道！";
	public static final String SC_APT_ORAL_NOT_FROM = "请检查当前数据是否来自口腔预约！";
	public static final String SC_APT_ORAL_DONOT_REPEAT = "已经有预约%s的号, 不允许重复预约!";
	public static final String SC_APT_ORAL_UNACTIVE = "%s的号未启用, 请换别的号重预约！";
	public static final String SC_APT_ORAL_HAS_USED_OR_OCCUPY = "%s的号已经使用或占用, 请换别的号重预约！";
	public static final String SC_APT_ORAL_NOT_APPT = "%s的号不开放, 请换别的号重预约！";
	public static final String SC_APT_ORAL_QUAN_NUM = "号源池剩余数量不足！剩余数量为：%d";
	public static final String SC_APT_ORAL_CANCEL_CANCELED = "号位已经取消，不能退约！";
	public static final String SC_APT_ORAL_BREAK_CANCELED = "号位已经取消，不能爽约！";
	public static final String SC_APT_ORAL_ALREADY_REALNAME = "当前预约患者已实名认证，不允许更换患者！";
	public static final String SC_APT_ORAL_NOT_REALNAME = "当前所选更换患者未实名认证，请检查！";
	public static final String SC_APT_ORAL_CANNOT_CHANGE_PAT = "当前预约状态不允许更换患者，请检查！";
	public static final String SC_APT_ORAL_SCH_UNACTIVE = "当前排班已停诊，不允许操作！";
	public static final String SC_APT_ORAL_SCCHL_ERR = "当前预约为非医院诊间(本科)渠道预约，不允许该操作！";
	public static final String SC_APT_ORAL_SCSRV_ERR = "预约的号别与计划号别不一致!";

	/**
	 * 门诊预约、医技预约
	 */
	public static final String SC_APT_NOT_FIND_PERIOD_SCH = "没有找到通过排班渠道期间检查的排班数据！";
	public static final String SC_APT_NOT_FIND_EXCL_SCH = "没有找到符合互斥记录的排班数据！";
	public static final String SC_APT_NOT_FIND_PLAN = "没有找到排班计划数据！";
	public static final String SC_APT_NOT_FIND_SCH = "没有找到排班数据！";
	public static final String SC_APT_NOT_FIND_MATCH_SCH = "没有找到符合的排班数据！";
	public static final String SC_APT_SCH_UNACTIVE = "当前排班已停诊！";
	public static final String SC_APT_NOT_FIND_CHL = "没有找到排班渠道数据！";
	public static final String SC_APT_NOT_FIND_ENTP_CHL = "没有找到符合就诊类型的排班渠道数据！";
	public static final String SC_APT_MT_GET_APP_FEE_FAILURE = "获取申请单记账状态失败！";
	public static final String SC_APT_MT_APP_HAS_CANCEL_FEE = "申请单已退费，不能预约！";
	public static final String SC_APT_MT_GET_PARAM_FAILURE = "获取医技预约费用检查参数失败，请检查！";
	public static final String SC_APT_MT_NOT_FEE = "未记账";
	public static final String SC_APT_MT_HAS_FEE = "已记账";
	public static final String SC_APT_MT_NOT_SUIT_FEE_STATUS = "申请单记账状态为：%s,根据医技预约费用检查参数，不能预约！";
	public static final String SC_APT_OT_NOT_SUIT_FEE_STATUS = "申请单记账状态为：%s,根据手术预约费用检查参数，不能预约！";
	public static final String SC_APT_MT_OBSAPT_SRVTPS_EMPTY = "医技可预约医嘱类型参数为空，请检查！";
	public static final String SC_APT_MT_CHK_FEE = "该申请单未缴费，是否继续预约?";
	public static final String SC_APT_MT_NEED_CFM = "需确认";
	public static final String SC_APT_MT_NOT_NEED_CFM = "不需确认";
	public static final String SC_SCH_TICK_NO_CHL = "该号源需指定渠道后使用!";
}
