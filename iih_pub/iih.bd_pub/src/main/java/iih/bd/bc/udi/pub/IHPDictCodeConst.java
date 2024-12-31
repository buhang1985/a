package iih.bd.bc.udi.pub;

public class IHPDictCodeConst {

	// 诊疗计划状态
	public static final String SD_HPCP_STATUS = "HP.CP.0505";

	// 规则包类型
	public static final String SD_RULE_TYPE = "HP.CP.0510";

	// 元素对照类型
	public static final String SD_ELEREF_TYPE = "HP.CP.0515";

	// 元素属性值检查类型
	public static final String SD_ELECHK_TYPE = "HP.CP.0520";

	// 元素值异常类型
	public static final String SD_ELEVALID_TYPE = "HP.CP.0525";

	// 计划模板状态
	public static final String SD_HPCPTEMP_STATUS = "HP.CP.1005";

	// 诊疗计划操作类型
	public static final String SD_OPR_TP = "HP.CP.2005";

	// 元素执行角色
	public static final String SD_ELEOPE_ROLE = "HP.CP.2008";

	// 诊疗计划接口类型
	public static final String SD_HPCPINFA_TYPE = "HP.CP.2010";

	// 变异类型
	public static final String SD_ALTER_TP = "HP.CP.2015";

	// 变异原因类型
	public static final String SD_VARIA_REA_TP = "HP.CP.2025";

	/**
	 * 诊疗规则符合状态
	 */
	// 待确认
	public static final String SD_TREAT_RULE_WAIT = "0";
	// 符合
	public static final String SD_TREAT_RULE_MEETS = "1";
	// 不符合
	public static final String SD_SU_PL_CONFIRM_INCOM = "2";

	/**
	 * HP.CP.0505诊疗计划状态
	 */
	// 待建
	public static final String SD_HPCP_STATUS_WAIT = "02";
	// 新建
	public static final String SD_HPCP_STATUS_NEW = "05";
	// 审核驳回
	public static final String SD_HPCP_STATUS_REJECT = "08";
	// 提交
	public static final String SD_HPCP_STATUS_SUBMIT = "10";
	// 审核中
	public static final String SD_HPCP_STATUS_EXAMING = "15";
	// 审核通过
	public static final String SD_HPCP_STATUS_EXAMCOM = "20";
	// 停用
	public static final String SD_HPCP_STATUS_STOP = "25";
	// 启用
	public static final String SD_HPCP_STATUS_ENABLE = "30";

	/**
	 * HP.CP.0510规则包类型
	 */
	// 普通规则包
	public static final String SD_RULE_TYPE_NORMAL = "0";
	// 准入规则
	public static final String SD_RULE_TYPE_ADMIN = "1";
	// 完成规则
	public static final String SD_RULE_TYPE_COMP = "2";
	// 退出规则
	public static final String SD_RULE_TYPE_EXIT = "3";
	// 阶段转移规则
	public static final String SD_RULE_TYPE_PHASE = "4";

	/**
	 * HP.CP.0515元素对照类型
	 */
	// 西药
	public static final String SD_ELEREF_TYPE_WEST = "01";
	// 草药
	public static final String SD_ELEREF_TYPE_HERB = "02";

	/**
	 * HP.CP.0520元素属性值检查类型
	 */
	// 医疗服务
	public static final String SD_ELECHK_TYPE_SRV = "srv";
	// 药品
	public static final String SD_ELECHK_TYPE_MM = "mm";	
	// 病历文书类型
	public static final String SD_ELECHK_TYPE_MRTH = "mrtp";
	// 诊断规则
	public static final String SD_ELECHK_TYPE_DIAG = "diag";
	
	/**
	 * HP.CP.0525元素值异常类型
	 */
	// 必填项为空
	public static final String SD_ELEVALID_TYPE_NULL = "05";
	// 不符合值域要求
	public static final String SD_ELEVALID_TYPE_RANGE = "10";
	// 内部参照无效
	public static final String SD_ELEVALID_TYPE_IIH = "15";
	// 外部对照无效
	public static final String SD_ELEVALID_TYPE_TGT = "20";

	/**
	 * HP.CP.1005计划模板状态
	 */
	// 新建
	public static final String SD_HPCPTEMP_STATUS_NEW = "01";
	// 停用
	public static final String SD_HPCPTEMP_STATUS_STOP = "02";
	// 启用
	public static final String SD_HPCPTEMP_STATUS_ENABLE = "03";
	// 删除
	public static final String SD_HPCPTEMP_STATUS_DEL = "04";

	/**
	 * HP.CP.2005诊疗计划操作类型
	 */
	// 强制入径
	//public static final String ID_HPCPOPE_TYPE_FORCE = "03"; 数据库中没有这个值
	public static final String ID_HPCPOPE_TYPE_ENTRY = "@@@@Z7100000000GEIO8"; // 05 进入路径	
	public static final String ID_HPCPOPE_TYPE_SUSP = "@@@@Z7100000000GEIO9"; // 10 暂缓入径
	public static final String ID_HPCPOPE_TYPE_NO = "@@@@Z7100000000GEIOA"; // 15 不进路径
	public static final String ID_HPCPOPE_TYPE_MIGRA = "@@@@Z7100000000GEIOB"; // 17 阶段迁移
	public static final String ID_HPCPOPE_TYPE_ALTER = "@@@@Z7100000000GEIOC"; // 18 发生变异
	public static final String ID_HPCPOPE_TYPE_VARIA = "@@@@Z7100000000GEIOE"; // 20 变异出径
	public static final String ID_HPCPOPE_TYPE_NORMAL = "@@@@Z7100000000GEIOF"; // 25 正常出径
	public static final String ID_HPCPOPE_TYPE_BACK = "@@@@Z7100000000GEIOH"; // 30 返回路径
	
	// 强制入径
	public static final String SD_HPCPOPE_TYPE_FORCE = "03";
	// 进入路径
	public static final String SD_HPCPOPE_TYPE_ENTRY = "05";
	// 暂缓入径
	public static final String SD_HPCPOPE_TYPE_SUSP = "10";
	// 不进路径
	public static final String SD_HPCPOPE_TYPE_NO = "15";
	// 阶段迁移
	public static final String SD_HPCPOPE_TYPE_MIGRA = "17";
	// 发生变异
	public static final String SD_HPCPOPE_TYPE_ALTER = "18";
	// 变异出径
	public static final String SD_HPCPOPE_TYPE_VARIA = "20";
	// 正常出径
	public static final String SD_HPCPOPE_TYPE_NORMAL = "25";
	// 返回路径
	public static final String SD_HPCPOPE_TYPE_BACK = "30";

	/**
	 * HP.CP.2008元素执行角色
	 */
	// 医生
	public static final String SD_ELEOPE_ROLE_DOCTOR = "05";
	// 护士
	public static final String SD_ELEOPE_ROLE_NURSE = "10";
	// 患者及家属
	public static final String SD_ELEOPE_ROLE_PAT = "15";

	/**
	 * HP.CP.2010诊疗计划接口类型
	 */
	// 功能触发
	public static final String SD_HPCPINFA_TYPE_TRIGER = "01";
	// 结果判断
	public static final String SD_HPCPINFA_TYPE_JUGE = "02";

	/**
	 * HP.CP.2015变异类型
	 */
	// 强制入径
	public static final String SD_HPCPALTER_TYPE_FORCE = "03";
	// 开立计划外医嘱
	public static final String SD_HPCPALTER_TYPE_ORDER = "05";
	// 对于必须执行的诊疗活动确认不执行
	public static final String SD_HPCPALTER_TYPE_NO = "10";
	// 可选元素确认执行
	public static final String SD_HPCPALTER_TYPE_UNNESSEXE = "11";
	// 阶段提前
	public static final String SD_HPCPALTER_TYPE_ADVANCE = "12";
	// 阶段延期
	public static final String SD_HPCPALTER_TYPE_DELAY = "15";
	// 变异退出
	public static final String SD_HPCPALTER_TYPE_VARIA = "20";

	/**
	 * HP.CP.2025变异原因类型
	 */
	// 不执行原因
	public static final String SD_NOEXC_REA = "10";
	// 门诊或外院已查
	public static final String SD_NOEXC_REA_CHECKED = "1005";
	// 患方不同意
	public static final String SD_NOEXC_REA_NOAGREE = "1010";
	// 患者原因(病情需要)
	public static final String SD_NOEXC_REA_NEEDED = "1015";
	// 患者原因(患方要求)
	public static final String SD_NOEXC_REA_PATIENT = "1020";
	// 医护原因
	public static final String SD_NOEXC_REA_MEDICAL = "1025";
	// 医院客观原因
	public static final String SD_NOEXC_REA_HOSPITAL = "1030";
	// 其他
	public static final String SD_NOEXC_REA_OTHER = "1035";
	// 变异出径原因
	public static final String SD_OUTPATH_REA = "20";
	// 有变异
	public static final String SD_OUTPATH_REA_VARIA = "2005";
	// 不需入径
	public static final String SD_OUTPATH_REA_NO = "2010";
	// 非路径病种
	public static final String SD_OUTPATH_REA_WRONG = "2015";

	/**
	 * 诊疗计划元素类型
	 */
	// 文本资料
	public static final String _Text = "WBZL";

	// 文本元素
	public static final String _TextEle = "WBYS";

	// 规则包
	public static final String _RulePkg = "GZB";

	// 诊断规则
	public static final String _DiagRule = "ZDGZ";

	// 手术规则
	public static final String _SugRule = "SSGZ";

	// 范式规则
	public static final String _NFormRule = "FSGZ";

	// 患者状态包
	public static final String _PStatePkg = "HZZTB";

	// 患者生物属性
	public static final String _PBiol = "HZSWSX";

	// 患者生命体征
	public static final String _PVital = "HZSMTZ";

	// 患者关键指标
	public static final String _PIndex = "HZGJZB";

	// 计划边界
	public static final String _Boundary = "JHBJ";

	// 计划阶段
	public static final String _Stage = "JHJD";

	// 诊疗活动包
	public static final String _DiagActPkg = "ZLHDB";
	
	// 重点医嘱
	public static final String _MasterOrder = "ZDYZ";

	// 医嘱
	public static final String _Order = "YZ";

	// 病历
	public static final String _MedRecord = "BL";

	// 其他诊疗活动
	public static final String _OtherAct = "QTZLHD";

	// 医嘱包
	public static final String _OrderPkg = "YZB";

	// 长期医嘱包
	public static final String _LongOrderPkg = "CQYZB";

	// 临时医嘱包
	public static final String _TempOrderPkg = "LSYZB";
	
	// 成组医嘱包
	public static final String _GroupPkg = "CZYZB";

	// 护理工作包
	public static final String _NurWorkPkg = "HLGZB";

	// 参考资料容器
	public static final String _RefContainer = "CKZLRQ";

	// 计划阶段顶层容器
	public static final String _StageTopContainer = "JHJDDCRQ";

	// 是否启用临床路径
	public static final String SD_HP_USING_ENABLE = "HPCP0502";
	// 是否限制为单路径
	public static final String SD_HP_LIMIT_SINGLE = "HPCP0510";
	// 是否要求全路径
	public static final String SD_HP_USING_WHOLE = "HPCP0505";

	//阶段迁移提醒消息ID
	public static final String ID_STAGE_MIGRATION = "@@@@Z7100000000NC3HX";
	
	//路径审核流程定义ID
	public static final String HPCP_FLOW_TYPE_PK = "@@@@AA1000000008FO6T";
}
