package iih.bd.bc.udi.pub;

/**
 * @author 作者 :huang_junhao
 * @version 创建时间：2017年1月4日 上午11:17:08 类说明：护理管理常量类 Company: Copyright 2016 by PKU
 *          healthcare IT Co.Ltd.
 */
public interface INmNurDictCodeConst {

	/**
	 * 人员工作类型
	 */
	public static final String ID_EMPWKTP = "@@@@AA1000000000SMV6";// 护理
	public static final String SD_EMPWKTP = "02";// 护理编码

	/**
	 * 护士长手册书写类型
	 */
	public static final String ID_WBKTP = "@@@@LL1000000005Y1AU"; // 手册类型ID
	public static final String SD_WBKTP = "05"; // 手册类型编码

	/**
	 * 护士长手册书写状态
	 */
	public static final String ID_STATUS_NEW = "0001Z8100000000MUBFV"; // 手册状态ID
	public static final String SD_STATUS_NEW = "01"; // 手册状态编码

	/**
	 * 护理人员类别
	 */
	public static final String ID_NUR_ATTEN = "@@@@Z8100000000NXHWE"; // 护理人员
	public static final String SD_NUR_ATTEN = "01";
	public static final String NAME_NUR_ATTEN = "护理人员";
	public static final String ID_NUR_INTERNSHIP = "@@@@Z8100000000NXHWF"; // 护理实习生
	public static final String SD_NUR_INTERNSHIP = "02";
	public static final String NAME_NUR_INTERNSHIP = "实习生";
	public static final String ID_NUR_ADVANCE = "@@@@Z8100000000NXHWG"; // 护理进修生
	public static final String SD_NUR_ADVANCE = "03";
	public static final String NAME_NUR_ADVANCE = "进修生";

	/**
	 * 全院人员档案节点编码
	 */
	public static final String HOSPSNFUNCODE = "52100510";
	/**
	 * 科室人员档案节点编码
	 */
	public static final String DEPPSNFUNCODE = "52100512";
	/**
	 * 实习生档案节点编码
	 */
	public static final String INTERNFUNCODE = "52100514";
	/**
	 * 进修生档案节点编码
	 */
	public static final String ADVSTUFUNCODE = "52100516";
	/**
	 * 个人档案节点编码
	 */
	public static final String PERPSNFUNCODE = "52100518";
	/**
	 * 离职人员档案节点编码
	 */
	public static final String LVEPSNFUNCODE = "52100519";

	/**
	 * 人员调动审核状态编码
	 */
	public static final String SD_APPLY_STATUS_NEW = "01";// 新建
	public static final String SD_APPLY_STATUS_COMMIT = "02";// 提交
	public static final String SD_APPLY_STATUS_REJECT = "03";// 审核驳回
	public static final String SD_APPLY_STATUS_PASS = "04";// 审核通过
	public static final String SD_APPLY_STATUS_FINISH = "05";// 完成
	public static final String SD_APPLY_STATUS_AUDITREVOKE = "06";// 撤销

	/**
	 * 人员调动审核状态ID
	 */
	public static final String ID_APPLY_STATUS_NEW = "@@@@Z7100000000NBBES";// 新建
	public static final String ID_APPLY_STATUS_COMMIT = "@@@@Z7100000000NBBET";// 提交
	public static final String ID_APPLY_STATUS_REJECT = "@@@@Z7100000000NBBEU";// 审核驳回
	public static final String ID_APPLY_STATUS_PASS = "@@@@Z7100000000NBBEV";// 审核通过
	public static final String ID_APPLY_STATUS_FINISH = "@@@@Z7100000000NN3AD";// 完成
	public static final String ID_APPLY_STATUS_AUDITREVOKE = "@@@@Z8100000000I0UK7";// 撤销

	/**
	 * 模板元素类型
	 */
	public static final String SD_QCTPL_ELETP_ITM = "01";// 数据项
	public static final String SD_QCTPL_ELETP_GRP = "02";// 数据组

	/**
	 * 质量模板状态编码
	 */
	public static final String SD_QCTPL_STATUS_NEW = "02";// 新建
	public static final String SD_QCTPL_STATUS_SUBMIT = "03";// 提交
	public static final String SD_QCTPL_STATUS_EXAMCOM = "04";// 审核通过
	public static final String SD_QCTPL_STATUS_REJECT = "05";// 审核驳回
	public static final String SD_QCTPL_STATUS_ENABLE = "06";// 启用
	public static final String SD_QCTPL_STATUS_DISENABLE = "07";// 停用

	/**
	 * 质量模板状态ID
	 */
	public static final String ID_QCTPL_STATUS_NEW = "@@@@Z8100000000O2YP6";// 新建
	public static final String ID_QCTPL_STATUS_SUBMIT = "@@@@Z8100000000O2YP7";// 提交
	public static final String ID_QCTPL_STATUS_EXAMCOM = "@@@@Z8100000000O2YP8";// 审核通过
	public static final String ID_QCTPL_STATUS_REJECT = "@@@@Z8100000000O2YP9";// 审核驳回
	public static final String ID_QCTPL_STATUS_ENABLE = "@@@@Z8100000000O2YPA";// 启用
	public static final String ID_QCTPL_STATUS_DISENABLE = "@@@@Z8100000000O2YPC";// 停用

	/**
	 * 试题类型 NM.NET.0615
	 */
	public static final String ID_QU_TP_SELECT = "@@@@Z71000000011HMY4";// 单选题
	public static final String ID_QU_TP_MULTIPLE = "@@@@Z71000000011HMY5";// 多选题
	// public static final String ID_QU_TP_DISPUTE = "03";// 是非判断题
	public static final String ID_QU_TP_SELECT_CASE = "@@@@Z71000000011HMY7";// 案例单选题
	public static final String ID_QU_TP_MULTIPLE_CASE = "@@@@Z71000000011HMY8";// 案例多选题
	public static final String ID_QU_TP_DISCUSS = "@@@@Z71000000011HMY9";// 简述题

	public static final String SD_QU_TP_SELECT = "01";// 单选题
	public static final String SD_QU_TP_MULTIPLE = "02";// 多选题
	public static final String SD_QU_TP_DISPUTE = "03";// 是非判断题
	public static final String SD_QU_TP_SELECT_CASE = "04";// 案例单选题
	public static final String SD_QU_TP_MULTIPLE_CASE = "05";// 案例多选题
	public static final String SD_QU_TP_DISCUSS = "06";// 简述题

	/**
	 * 人员考试状态ID
	 */
	public static final String ID_EXAM_TEST_BEFORE = "@@@@Z8100000000OVRR3";// 待考试
	public static final String ID_EXAM_TEST_DURING = "@@@@Z8100000000OVRR4";// 考试中
	public static final String ID_EXAM_TEST_AFTER = "@@@@Z8100000000OVRR5";// 已交卷

	/**
	 * 人员考试状态编码
	 */
	public static final String SD_EXAM_TEST_BEFORE = "01";// 待考试
	public static final String SD_EXAM_TEST_DURING = "02";// 考试中
	public static final String SD_EXAM_TEST_AFTER = "03";// 已交卷

	/**
	 * 考试状态ID
	 */
	public static final String ID_EXAM_STATUS_NEW = "@@@@Z8100000000OVRR6";// 新建
	public static final String ID_EXAM_STATUS_ENABLE = "@@@@Z8100000000OVRR7";// 启用
	public static final String ID_EXAM_STATUS_DISENABLE = "@@@@Z8100000000OVRR8";// 停用

	/**
	 * 考试状态编码
	 */
	public static final String SD_EXAM_STATUS_NEW = "01";// 新建
	public static final String SD_EXAM_STATUS_ENABLE = "02";// 启用
	public static final String SD_EXAM_STATUS_DISENABLE = "03";// 停用
	/**
	 * NM.NHR.0705 实习生请假流程
	 */
	// 新建
	public static final String CODE_NMNURLV_NEW_NUM = "01";
	// 提交
	public static final String CODE_NMNURLV_SUBMIT_NUM = "02";
	// 审核通过
	public static final String CODE_NMNURLV_PASS_NUM = "03";
	// 审核回退
	public static final String CODE_NMNURLV_BACK_NUM = "04";
	// 一级审核通过
	public static final String CODE_NMNURLV_ONE_NUM = "05";
	// 二级审核通过
	public static final String CODE_NMNURLV_SECOND_NUM = "06";

	/**
	 * NM.NHR.0740 护理人员请假流程
	 */
	// 新建
	public static final String CODE_NMNHRSCHEDLV_NEW_NUM = "01";
	// 提交
	public static final String CODE_NMNHRSCHEDLV_SUBMIT_NUM = "02";
	// 审核通过
	public static final String CODE_NMNHRSCHEDLV_PASS_NUM = "03";
	// 审核回退
	public static final String CODE_NMNHRSCHEDLV_BACK_NUM = "04";
	// 一级审核通过
	public static final String CODE_NMNHRSCHEDLV_ONE_NUM = "05";
	// 二级审核通过
	public static final String CODE_NMNHRSCHEDLV_SECOND_NUM = "06";

	/**
	 * NM.NQM.0685 护理管理_质控会议审核状态
	 */
	public static final String CODE_QCMT_NEW_NUM = "01";

	public static final String CODE_QCMT_SUBMIT_NUM = "02";

	public static final String CODE_QCMT_PASS_NUM = "03";

	public static final String CODE_QCMT_BACK_NUM = "04";

	public static final String CODE_QCMT_ONE_NUM = "05";

	public static final String CODE_QCMT_SECOND_NUM = "06";

	/**
	 * 排班分组组员角色
	 */
	public static final String ID_SIGRP_ROLE_LEAD = "@@@@Z8100000000MWKGL";// 组长
	public static final String ID_SIGRP_ROLE_LEAD_VICE = "@@@@Z8100000000MWKGM";// 副组长
	public static final String ID_SIGRP_ROLE_CREW = "@@@@Z8100000000MWKGN";// 组员

	public static final String SD_SIGRP_ROLE_LEAD = "01";// 组长
	public static final String SD_SIGRP_ROLE_LEAD_VICE = "02";// 副组长
	public static final String SD_SIGRP_ROLE_CREW = "03";// 组员

	/**
	 * 排班状态
	 */
	public static final String ID_SCHED_STATES_NEW = "@@@@Z8100000000MVOSQ";// 新建
	public static final String ID_SCHED_STATES_REPORT = "@@@@Z8100000000MVOSR";// 上报
	public static final String ID_SCHED_STATES_BACKOUT = "@@@@Z8100000000MVOSS";// 撤回
	public static final String ID_SCHED_STATES_AGREE = "@@@@Z81000000010O2EE";// 同意
	public static final String ID_SCHED_STATES_REPUlSE = "@@@@Z81000000010O2EF";// 打回
	public static final String ID_SCHED_STATES_ABOLISH = "@@@@Z81000000010O2EG";// 废除

	public static final String SD_SCHED_STATES_NEW = "01";// 新建
	public static final String SD_SCHED_STATES_REPORT = "02";// 上报
	public static final String SD_SCHED_STATES_BACKOUT = "03";// 撤回
	public static final String SD_SCHED_STATES_AGREE = "04";// 同意
	public static final String SD_SCHED_STATES_REPUlSE = "05";// 打回
	public static final String SD_SCHED_STATES_ABOLISH = "06";// 废除

	// 命令类型
	public static final String CMD_REPORT = "report";// 上报
	public static final String CMD_BACKOUT = "backout";// 撤回
	public static final String CMD_AGREE = "agree";// 同意
	public static final String CMD_REPUlSE = "repulse";// 打回
	public static final String CMD_ABOLISH = "abolish";// 废除

	/**
	 * 护理管理——所属类型
	 */
	public static final String ID_OWNTP_ALL = "@@@@Z8100000000MRJ35";// 全院
	public static final String ID_OWNTP_DEP = "@@@@Z8100000000MRJ36";// 科室
	public static final String SD_OWNTP_ALL = "01";// 全院
	public static final String SD_OWNTP_DEP = "02";// 科室

	/**
	 * 护理管理_患者分类
	 */
	public static final String ID_PATCA_DISE_CRITICALLY_ILL = "0001Z8100000000XUN8L";// 病危
	public static final String ID_PATCA_DISE_DISEASE_SEVERITY = "0001Z8100000000XUN8N";// 病重
	public static final String ID_PATCA_DISE_NURSING_SPECIAL = "0001Z8100000000XUN8O";// 特级护理
	public static final String ID_PATCA_DISE_NURSING_ONE = "0001Z8100000000XUN8P";// 一级护理
	public static final String ID_PATCA_DISE_NURSING_TWO = "0001Z8100000000XUN8Q";// 二级护理;
	public static final String ID_PAT_CA_DISE_NURSING_OPERATION = "0001Z8100000000XUN8R";// 手术

	public static final String SD_PATCA_DISE_CRITICALLY_ILL = "01";// 病危
	public static final String SD_PATCA_DISE_DISEASE_SEVERITY = "02";// 病重
	public static final String SD_PATCA_DISE_NURSING_SPECIAL = "03";// 特级护理
	public static final String SD_PATCA_DISE_NURSING_ONE = "04";// 一级护理
	public static final String SD_PATCA_DISE_NURSING_TWO = "05";// 二级护理;
	public static final String SD_PAT_CA_DISE_NURSING_OPERATION = "06";// 手术

	public static final String NAME_PATCA_DISE_CRITICALLY_ILL = "病危";// 病危
	public static final String NAME_PATCA_DISE_DISEASE_SEVERITY = "病重";// 病重
	public static final String NAME_PATCA_DISE_NURSING_SPECIAL = "特级护理";// 特级护理
	public static final String NAME_PATCA_DISE_NURSING_ONE = "一级护理";// 一级护理
	public static final String NAME_PATCA_DISE_NURSING_TWO = "二级护理";// 二级护理;
	public static final String NAME_PAT_CA_DISE_NURSING_OPERATION = "手术";// 手术

	/**
	 * 病情等级
	 */
	public static final String ID_LEVEL_DISE_CRITICALLY_ILL = "@@@@AA1000000DFJBKDJ";// 病危
	public static final String ID_LEVEL_DISE_DISEASE_SEVERITY = "@@@@AA10FDKJSBKJBKFD";// 病重
	public static final String ID_LEVEL_DISE_ORDINARY = "@@@@AA10FDKDGKDGHFFI";// 普通

	public static final String SD_LEVEL_DISE_CRITICALLY_ILL = "00";
	public static final String SD_LEVEL_DISE_DISEASE_SEVERITY = "01";
	public static final String SD_LEVEL_DISE_ORDINARY = "02";

	/**
	 * 护理等级
	 */
	public static final String ID_LEVEL_NUR_NURSING_SPECIAL = "@@@@AJKBFDHKJHKHKBHD";// 特级护理
	public static final String ID_LEVEL_NUR_NURSING_ONE = "@@@@BCNVCVKJHWIDFFSD";// 一级护理
	public static final String ID_LEVEL_NUR_NURSING_TWO = "@@@@BNCNPOWJROIOERWQ";// 二级护理
	public static final String ID_LEVEL_NUR_NURSING_THREE = "@@@@AA1000000009L6SP";// 三级护理

	public static final String SD_LEVEL_NUR_NURSING_SPECIAL = "00";// 特级护理
	public static final String SD_LEVEL_NUR_NURSING_ONE = "01";// 一级护理
	public static final String SD_LEVEL_NUR_NURSING_TWO = "02";// 二级护理
	public static final String SD_LEVEL_NUR_NURSING_THREE = "03";// 三级护理

	/**
	 * 性别
	 */
	public static final String NAME_SEX_UNKNOWN = "未知";
	public static final String NAME_SEX_BOY = "男";
	public static final String NAME_SEX_GIRL = "女";
	public static final String NAME_SEX_UNEXPLAINED = "未说明";

	public static final String SD_SEX_UNKNOWN = "0";
	public static final String SD_SEX_BOY = "1";
	public static final String SD_SEX_GIRL = "2";
	public static final String SD_SEX_UNEXPLAINED = "9";

	public static final String ID_SEX_BOY = "@@@@AA1000000000MNSZ";
	public static final String ID_SEX_GIRL = "@@@@AA1000000000MNT0";
	/**
	 * 科室启用标识
	 */
	public static final Integer DEPT_ACTIVESTATE = 2;

	/**
	 * 科室类型
	 */
	public static final String SD_DEPT_TYPE_CLINICAL = "01";// 临床
	public static final String SD_DEPT_TYPE_TEST1 = "0101";// 测试1
	public static final String SD_DEPT_TYPE_NURSING = "02";// 护理
	public static final String SD_DEPT_TYPE_MEDICAL_TECHNOLOGY = "03";// 医技
	public static final String SD_DEPT_TYPE_MEDICAMENT = "04";// 药剂
	public static final String SD_DEPT_TYPE_PHARMACY = "0402";// 药房
	public static final String SD_DEPT_TYPE_GENERAL_AFFAIRS = "05";// 总务
	public static final String SD_DEPT_TYPE_FINANCE = "06";// 财务
	public static final String SD_DEPT_TYPE_PERSONNEL_MATTERS = "07";// 人事
	public static final String SD_DEPT_TYPE_ADMINISTRATION = "08";// 行政
	public static final String SD_DEPT_TYPE_OTHER = "09";// 其他
	public static final String SD_DEPT_TYPE_TEST = "10";// 测试

	public static final String ID_DEPT_TYPE_CLINICAL = "@@@@AA1000000000T6XG";// 临床
	public static final String ID_DEPT_TYPE_TEST1 = "1001Z8100000000GUXJF";// 测试1
	public static final String ID_DEPT_TYPE_NURSING = "@@@@AA1000000000T6XH";// 护理
	public static final String ID_DEPT_TYPE_MEDICAL_TECHNOLOGY = "@@@@AA1000000000T6XI";// 医技
	public static final String ID_DEPT_TYPE_MEDICAMENT = "@@@@AA1000000000T6XJ";// 药剂
	public static final String ID_DEPT_TYPE_PHARMACY = "@@@@Z7100000000GCV8S";// 药房
	public static final String ID_DEPT_TYPE_GENERAL_AFFAIRS = "@@@@AA1000000000U6XM";// 总务
	public static final String ID_DEPT_TYPE_FINANCE = "@@@@AA1000000000U6XN";// 财务
	public static final String ID_DEPT_TYPE_PERSONNEL_MATTERS = "@@@@AA1000000000U6XO";// 人事
	public static final String ID_DEPT_TYPE_ADMINISTRATION = "@@@@AA10000000081EAF";// 行政
	public static final String ID_DEPT_TYPE_OTHER = "@@@@AA10000000081EAI";// 其他
	public static final String ID_DEPT_TYPE_TEST = "1001Z8100000000GUXJI";// 测试

	public static final String NAME_DEPT_TYPE_CLINICAL = "临床";// 临床
	public static final String NAME_DEPT_TYPE_TEST1 = "测试1";// 测试1
	public static final String NAME_DEPT_TYPE_NURSING = "护理";// 护理
	public static final String NAME_DEPT_TYPE_MEDICAL_TECHNOLOGY = "医技";// 医技
	public static final String NAME_DEPT_TYPE_MEDICAMENT = "药剂";// 药剂
	public static final String NAME_DEPT_TYPE_PHARMACY = "药房";// 药房
	public static final String NAME_DEPT_TYPE_GENERAL_AFFAIRS = "总务";// 总务
	public static final String NAME_DEPT_TYPE_FINANCE = "财务";// 财务
	public static final String NAME_DEPT_TYPE_PERSONNEL_MATTERS = "人事";// 人事
	public static final String NAME_DEPT_TYPE_ADMINISTRATION = "行政";// 行政
	public static final String NAME_DEPT_TYPE_OTHER = "其他";// 其他
	public static final String NAME_DEPT_TYPE_TEST = "测试";// 测试

	/**
	 * 实习计划状态
	 */
	public static final String ID_PLAN_NEW = "@@@@Z8100000000MPZDG";// 新建
	public static final String ID_PLAN_COMMIT = "@@@@Z8100000000MPZDH";// 提交
	public static final String ID_PLAN_THROUGH = "@@@@Z8100000000MPZDI";// 审核通过
	public static final String ID_PLAN_DISTHROUGH = "@@@@Z8100000000MPZDJ";// 驳回

	public static final String SD_PLAN_NEW = "01";// 新建
	public static final String SD_PLAN_COMMIT = "02";// 提交
	public static final String SD_PLAN_THROUGH = "03";// 审核通过
	public static final String SD_PLAN_DISTHROUGH = "04";// 驳回

	/**
	 * 科室轮转状态
	 */
	public static final String ID_STATUS_PEND = "0001Z8100000000ZROHU";// 待轮转
	public static final String ID_STATUS_CONFIRM = "0001Z8100000000ZROHV";// 已轮转
	public static final String ID_STATUS_ASSESS = "0001Z8100000000ZROHW";// 已评定

	public static final String SD_STATUS_PEND = "01";// 待轮转
	public static final String SD_STATUS_CONFIRM = "02";// 已轮转
	public static final String SD_STATUS_ASSESS = "03";// 已评定

	/**
	 * 人员在岗状态
	 */
	// public static final String SD_WORK_NOTIN = "e";// 离职
	public static final String ID_WORK_NOTIN = "@@@@Z81000000006HNBL";// 离职
	
	/**
	 * 护理管理_考勤状态
	 */
	public static final String ID_STATUS_ATTENDANCE = "@@@@Z8100000000MVOSL";
	public static final String SD_STATUS_ATTENDANCE = "02";

	/**
	 * 护理管理_人员请假审核状态
	 */
	public static final String ID_SCHEDLV_APPROVE = "@@@@Z8100000000MVP9M"; // 审核通过
	public static final String SD_SCHEDLV_APPROVE = "03"; // 审核通过
	public static final String ID_SCHEDLV_ABOLISH = "@@@@Z81000000006OS8X"; // 作废
	public static final String SD_SCHEDLV_ABOLISH = "99"; // 作废
	/**
	 * 护理管理_护士长手册书写状态
	 */
	public static final String ID_NOM_WBKAPP_WRITE = "@@@@Z8100000000MUBFV";// 已书写
	public static final String ID_NOM_WBKAPP_SUBMIT = "@@@@Z8100000000N061V";// 已提交
	public static final String ID_NOM_WBKAPP_BACK = "@@@@Z81000000005Y19B";// 驳回"
	public static final String ID_NOM_WBKAPP_PASS = "@@@@Z81000000005Y19C";// 完成
	public static final String ID_NOM_WBKAPP_WAIT = "@@@@LL1000000005Y1AU";// 待书写

	public static final String SD_NOM_WBKAPP_WRITE = "01";// 已书写
	public static final String SD_NOM_WBKAPP_SUBMIT = "02";// 已提交
	public static final String SD_NOM_WBKAPP_BACK = "03";// 驳回"
	public static final String SD_NOM_WBKAPP_PASS = "04";// 完成
	public static final String SD_NOM_WBKAPP_WAIT = "05";// 待书写

	public static final String NAME_NOM_WBKAPP_WAIT = "待书写";
	public static final String NAME_NOM_WBKAPP_WRITE = "已书写";
	public static final String NAME_NOM_WBKAPP_SUBMIT = "已提交";
	public static final String NAME_NOM_WBKAPP_BACK = "驳回";
	public static final String NAME_NOM_WBKAPP_PASS = "完成";

	/**
	 * 护理人员查询条件
	 */
	public static final String NAME_NURCOND_DEP = "01";// 科室
	public static final String NAME_NURCOND_LVL = "02";// 护士层级
	public static final String NAME_NURCOND_ATTR = "03";// 护士属性
	public static final String NAME_NURCOND_CSGRP = "04";// 质控组

	/**
	 * 护理人员替班申请状态
	 */
	public static final String ID_SCHEDRP_NEW = "@@@@Z8100000000MYH35"; // 新建
	public static final String ID_SCHEDRP_SUBMIT = "@@@@Z8100000000MYH36";// 已提交
	public static final String ID_SCHEDRP_PASS = "@@@@Z8100000000MYH37";// 审核通过
	public static final String ID_SCHEDRP_BACK = "@@@@Z8100000000MYH38";// 驳回

	public static final String SD_SCHEDRP_NEW = "01"; // 新建
	public static final String SD_SCHEDRP_SUBMIT = "02";// 已提交
	public static final String SD_SCHEDRP_PASS = "03";// 审核通过
	public static final String SD_SCHEDRP_BACK = "04";// 审核通过

	// 护理管理班次分类
	public static final String SD_NHRSICA = "01";// 假别

	/**
	 * 护理管理人员请假申请状态
	 */

	public static final String ID_SCHEDLV_NEW = "@@@@Z8100000000MYNBJ";// 已申请
	public static final String ID_SCHEDLV_SUBMIT = "@@@@Z8100000000MYNBK";// 已提交
	public static final String ID_SCHEDLV_RECALL = "@@@@Z81000000006OS8W";// 已撤回
	public static final String ID_SCHEDLV_REJECT = "@@@@Z8100000000MYNBM";// 已驳回
	public static final String ID_SCHEDLV_CONSENT = "@@@@Z8100000000MYNBL";// 已同意
	public static final String ID_SCHEDLV_ABOLITION = "@@@@Z81000000006OS8X";// 已作废

	public static final String SD_SCHEDLV_NEW = "01";// 已申请
	public static final String SD_SCHEDLV_SUBMIT = "02";// 已提交
	public static final String SD_SCHEDLV_RECALL = "0201";// 已撤回
	public static final String SD_SCHEDLV_REJECT = "04";// 已驳回
	public static final String SD_SCHEDLV_CONSENT = "03";// 已同意
	public static final String SD_SCHEDLV_ABOLITION = "99";// 已作废

	/**
	 * 试题状态 NM.NET.0625
	 */
	public static final String ID_EXAMQU_STATUS_NEW = "@@@@Z8100000000L6CN2";// 新建
	public static final String ID_EXAMQU_STATUS_ENABLE = "@@@@Z8100000000L6CN6";// 启用
	public static final String ID_EXAMQU_STATUS_DISENABLE = "@@@@Z8100000000L6CN7";// 停用

	public static final String SD_EXAMQU_STATUS_NEW = "01";// 新建
	public static final String SD_EXAMQU_STATUS_ENABLE = "02";// 启用
	public static final String SD_EXAMQU_STATUS_DISENABLE = "03";// 停用

	/**
	 * 试题难度 NM.NET.0610
	 */
	public static final String ID_EXAMQU_LEVEL_UNLIMIT = "@@@@Z71000000011HMXY";// 不限
	public static final String ID_EXAMQU_LEVEL_EASY = "@@@@Z71000000011HMXZ";// 容易
	public static final String ID_EXAMQU_LEVEL_EASIER = "@@@@Z71000000011HMY0";// 比较容易
	public static final String ID_EXAMQU_LEVEL_MEDIUM = "@@@@Z71000000011HMY1";// 中等
	public static final String ID_EXAMQU_LEVEL_BITHARD = "@@@@Z71000000011HMY2";// 比较困难
	public static final String ID_EXAMQU_LEVEL_HARD = "@@@@Z71000000011HMY3";// 困难

	public static final String SD_EXAMQU_LEVLE_UNLIMIT = "01";// 不限
	public static final String SD_EXAMQU_LEVEL_EASY = "02";// 容易
	public static final String SD_EXAMQU_LEVEL_EASIER = "03";// 比较容易
	public static final String SD_EXAMQU_LEVEL_MEDIUM = "04";// 中等
	public static final String SD_EXAMQU_LEVEL_BITHARD = "05";// 比较困难
	public static final String SD_EXAMQU_LEVEL_HARD = "06";// 困难

	/**
	 * 护理管理_检查对象 NM.NQM.0701
	 */
	public static final String ID_CHKOBJ_PERSON = "@@@@Z8100000000NA6EX"; // 人
	public static final String ID_CHKOBJ_THING = "@@@@Z8100000000NA6EY"; // 事
	public static final String ID_CHKOBJ_TIME = "@@@@Z8100000000NA6EZ"; // 时
	public static final String ID_CHKOBJ_GROUND = "@@@@Z8100000000NA6FI"; // 地
	public static final String ID_CHKOBJ_OBJ = "@@@@Z8100000000NA6FJ"; // 物

	public static final String SD_CHKOBJ_PERSON = "01"; // 人
	public static final String SD_CHKOBJ_THING = "02"; // 事
	public static final String SD_CHKOBJ_TIME = "03"; // 时
	public static final String SD_CHKOBJ_GROUND = "04"; // 地
	public static final String SD_CHKOBJ_OBJ = "05"; // 物

	/**
	 * 护理管理_显示样式 NM.NQM.0698
	 */
	public static final String ID_STYLE_SCORE = "@@@@Z8100000000HYWMW"; // PC分值式
	public static final String ID_STYLE_OPTION = "@@@@Z8100000000HYWMX"; // PC选项式

	public static final String SD_STYLE_SCORE = "0101"; // PC分值式
	public static final String SD_STYLE_OPTION = "0102"; // PC选项式
	
	//民族
	public static final String ID_UDIDOC_NATION = "@@@@ZZ2000000000002G";
	
	/**
	 * 护士层级  NM.NHR.0505 
	 */
	public static final String SD_NURLVL_N0 = "01";
	public static final String SD_NURLVL_N1 = "02";
	public static final String SD_NURLVL_N2 = "03";
	public static final String SD_NURLVL_N3 = "04";
	public static final String SD_NURLVL_N4 = "05";
	
	public static final String ID_NURLVL_N0 = "@@@@Z7100000000NB94F";
	public static final String ID_NURLVL_N1 = "@@@@Z7100000000NC3D7";
	public static final String ID_NURLVL_N2 = "@@@@Z7100000000NC3D8";
	public static final String ID_NURLVL_N3 = "@@@@Z7100000000NC3D8";
	public static final String ID_NURLVL_N4 = "@@@@Z7100000000NC3DA";
	
	
	/**
	 * 护理管理_检查状态_检查中
	 */
	public static final String ID_TASKPL_CHKSTATE_CHKING = "@@@@Z8100000000NE0IS";
	/**
	 * 护理管理_检查状态_已提交
	 */
	public static final String ID_TASKPL_CHKSTATE_SUBMIT = "@@@@Z8100000000NE0IT";
	/**
	 * 护理管理_检查状态_已撤回
	 */
	public static final String ID_TASKPL_CHKSTATE_CANCEL = "@@@@Z8100000000NE0IU";
	/**
	 * 护理管理_检查状态_检查中
	 */
	public static final String SD_TASKPL_CHKSTATE_CHKING = "01";
	/**
	 * 护理管理_检查状态_已提交
	 */
	public static final String SD_TASKPL_CHKSTATE_SUBMIT = "02";
	/**
	 * 护理管理_检查状态_已撤回
	 */
	public static final String SD_TASKPL_CHKSTATE_CANCEL = "03";
	
	/**
	 *  /一级质控
	 */
    public static String ID_QC_LVL_ONE = "@@@@Z8100000000HEHFX";
    /**
	 *  /二级质控
	 */
    public static String ID_QC_LVL_TWO = "@@@@Z8100000000HEHG2";
    /**
	 *  /三级质控
	 */
    public static String ID_QC_LVL_THREE = "@@@@Z8100000000HEHG7";
}
