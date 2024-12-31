package iih.bd.bc.udi.pub;

/**
 * 临床路径自定义档案常量
 * @author HUMS
 *
 */
public interface IHpCpDictCodeConst {

	/**
	 * PPE_GRP
	 */
	// 元素基本
    public static final String SD_PPE_GRP_ELEBAS = "ELEBAS";
    // 元素扩展
    public static final String SD_PPE_GRP_ELEEX = "ELEEX";
    // 包
    public static final String SD_PPE_GRP_PKG = "PKG";
    // 规则包
    public static final String SD_PPE_GRP_RULEPKG = "RULEPKG";
    // 诊断规则
    public static final String SD_PPE_GRP_DIAGRULE = "DIAGRULE";

    // 元素基本
    public static final String ID_PPE_GRP_ELEBAS = "@@@@AA1000000007BYBT";
    // 元素扩展
    public static final String ID_PPE_GRP_ELEEX = "@@@@AA1000000007BYBU";
    // 包
    public static final String ID_PPE_GRP_PKG = "@@@@AA1000000007BYBV";
    // 规则包
    public static final String ID_PPE_GRP_RULEPKG = "@@@@AA1000000007BYBW";
    // 诊断规则
    public static final String ID_PPE_GRP_DIAGRULE = "@@@@AA1000000007BYBX";

    /**
     * ELE_TP
     */
    // 长期医嘱包
    public static final String ID_ELETP_LONG_PKG = "@@@@0000000000000018";
    // 临时医嘱宝
    public static final String ID_ELETP_TEMP_PKG = "@@@@0000000000000019";

    /**
     * SDSTATUS
     */
    // 新增
    public static final String SD_SDSTATUS_CREATED = "01";
    // 停用
    public static final String SD_SDSTATUS_DISABLE = "02";
    // 启用
    public static final String SD_SDSTATUS_ENABLE = "03";
    // 删除
    public static final String SD_SDSTATUS_DELETED = "04";
    // 新增
    public static final String ID_SDSTATUS_CREATED = "@@@@AA1000000007BYBN";
    // 停用
    public static final String ID_SDSTATUS_DISABLE = "@@@@AA1000000007BYBO";
    // 启用
    public static final String ID_SDSTATUS_ENABLE = "@@@@AA1000000007BYBP";
    // 删除
    public static final String ID_SDSTATUS_DELETED = "@@@@AA1000000007BYBQ";

    /**
     * STATUS
     */
    // 待建
    public static final String SD_STATUS_WAIT = "02";
    // 新增
    public static final String SD_STATUS_CREATED = "05";
    // 审核驳回
    public static final String SD_STATUS_REJECT = "08";
    // 提交
    public static final String SD_STATUS_SUBMIT = "10";
    // 审核中
    public static final String SD_STATUS_EXAMING = "15";
    // 审核通过
    public static final String SD_STATUS_EXAMCOM = "20";
    // 停用
    public static final String SD_STATUS_DISABLE = "25";
    // 启用
    public static final String SD_STATUS_ENABLE = "30";
    // 新增
    public static final String ID_STATUS_CREATED = "@@@@AA1000000007BYBG";
    // 提交
    public static final String ID_STATUS_SUBMIT = "@@@@AA1000000008FO85";
    // 停用
    public static final String ID_STATUS_DISABLE = "@@@@AA1000000007BYBE";
    // 启用
    public static final String ID_STATUS_ENABLE = "@@@@AA1000000007BYBH";
    // 删除
    public static final String ID_STATUS_DELETED = "@@@@AA1000000007BYBI";
 
    /**
     * RULEPKG_TP
     */
    // 准入规则
    public static final String SD_RULEPKG_TP_ENTER = "1";
    // 完成规则
    public static final String SD_RULEPKG_TP_COMPELETE = "2";
    // 退出规则
    public static final String SD_RULEPKG_TP_LEAVE = "3";
    // 阶段转移规则
    public static final String SD_RULEPKG_TP_TRANS = "4";
    // 准入规则
    public static final String ID_RULEPKG_TP_ENTER = "@@@@AA1000000007BYBJ";
    // 完成规则
    public static final String ID_RULEPKG_TP_COMPELETE = "@@@@AA1000000007BYBK";
    // 退出规则
    public static final String ID_RULEPKG_TP_LEAVE = "@@@@AA1000000007BYBL";
    // 阶段转移规则
    public static final String ID_RULEPKG_TP_TRANS = "@@@@AA1000000007BYBM";
    // 准入规则
    public static final String NAME_RULEPKG_TP_ENTER = "准入规则";
    // 完成规则
    public static final String NAME_RULEPKG_TP_COMPELETE = "完成规则";
    // 退出规则
    public static final String NAME_RULEPKG_TP_LEAVE = "退出规则";
    // 阶段转移规则
    public static final String NAME_RULEPKG_TP_TRANS = "阶段转移规则";

    /**
     * ELE_MATCH_TP
     */
    // 西药
    public static final String SD_ELE_MATCH_TP_WESTENMED = "01";
    // 草药
    public static final String SD_ELE_MATCH_TP_HERBSMED = "02";
    // 西药
    public static final String ID_ELE_MATCH_TP_WESTENMED = "@@@@AA1000000007BYBR";
    // 草药
    public static final String ID_ELE_MATCH_TP_HERBSMED = "@@@@AA1000000007BYBS";

    /**
     * IF_TP
     */
    // 功能触发
    public static final String SD_IF_TP_TRIGGER = "01";
    // 结果判断
    public static final String SD_IF_TP_JUDGEMENT = "02";
    // 功能触发
    public static final String ID_IF_TP_TRIGGER = "@@@@AA1000000007M9NU";
    // 结果判断
    public static final String ID_IF_TP_JUDGEMENT = "@@@@AA1000000007M9NV";

    /**
     * OPER_TP
     */
    // 强制入径
    public static final String SD_OPER_TP_FORCE = "03";
    // 进入路径
    public static final String SD_OPER_TP_ENTER = "05";
    // 暂缓入径
    public static final String SD_OPER_TP_SUSPEND = "10";
    // 不进路径
    public static final String SD_OPER_TP_LEAVE = "15";
    // 变异出径
    public static final String SD_OPER_TP_EXPEXIT = "20";
    // 正常出径
    public static final String SD_OPER_TP_NOREXIT = "25";
    // 未定义
    public static final String SD_IF_TP_UNDEFINE = "30";
    // 进入路径
    public static final String ID_OPER_TP_ENTER = "@@@@AA1000000007M9MB";
    // 暂缓入径
    public static final String ID_OPER_TP_SUSPEND = "@@@@AA1000000007M9MC";
    // 不进路径
    public static final String ID_OPER_TP_LEAVE = "@@@@AA1000000007M9MD";
    // 变异出径
    public static final String ID_OPER_TP_EXPEXIT = "@@@@AA1000000007M9ME";
    // 正常出径
    public static final String ID_OPER_TP_NOREXIT = "@@@@AA1000000007M9MF";
    // 未定义
    public static final String ID_IF_TP_UNDEFINE = "@@@@AA1000000007M9MG";

    /**
     * 	诊疗规则符合状态
     */
    // 待确认
    public static final String SD_TREAT_RULE_WAIT = "0";
    // 确认
    public static final String SD_TREAT_RULE_MEETS = "1";
    // 不符合
    public static final String SD_SU_PL_CONFIRM_INCOM = "2";

    /**
     *	 诊疗计划操作类型
     */
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
	 * 	元素执行角色
	 */
    //医生
	public static final String ID_EXE_ROLE_DOCTOR = "@@@@Z7100000000GEGA1";
	public static final String SD_EXE_ROLE_DOCTOR = "05";
	//护士
	public static final String ID_EXE_ROLE_NURSE = "@@@@Z7100000000GEGA2";
	public static final String SD_EXE_ROLE_NURSE = "10";
	//患者及家属
	public static final String ID_EXE_ROLE_PATIENT = "@@@@Z7100000000GEGA3";
	public static final String SD_EXE_ROLE_PATIENT = "15";

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
	 * 	诊疗计划元素类型
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
