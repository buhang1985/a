package iih.ci.ord.s.ems.meta;

import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.pub.CiOrdUtils;

public class OrderSysParamUtils {
	private SysParamInfo SYS_PARAM_OrEarlyEntryMaxHours;// "CIOR0005";
														// //医嘱可提前录入最大小时数（医嘱生效时间）
														// OrEarlyEntryMaxHours"
	private SysParamInfo SYS_PARAM_TemporaryPrnOrValidTime;// "CIOR0010";
															// //临时备用医嘱有效时间（小时）
															// TemporaryPrnOrValidTime"
	private SysParamInfo SYS_PARAM_OpOrValidTime;// "CIOR0015"; //门诊医嘱有效时间范围（小时）
													// OpOrValidTime"
	private SysParamInfo SYS_PARAM_ORSRVSPLITDTENDMAXALLOWDAYS;// "CIOR0020";
																// //医嘱或服务拆分截止时间与当前时间最大允许的天数间隔
																// OrSrvSplitDtEndMaxAllowDays"
	private SysParamInfo SYS_PARAM_ClinicalDiagSysCfg;// "CIOR0025";
														// //临床诊断系统设置（组织）
														// ClinicalDiagSysCfg11
														// 西医、12 中医、13 蒙医
														// 11,12则页签显示 西医页签和中医页签
														// 空则无页签显示"
	private SysParamInfo SYS_PARAM_ClinicalDiagSysCfg_D;// "CIOR0025";
														// //临床诊断系统设置（部门）
														// ClinicalDiagSysCfg 11
														// 西医、12 中医、13 蒙医
														// 11,12则页签显示 西医页签和中医页签
														// 空则无页签显示"
	private SysParamInfo SYS_PARAM_OrSignChkMaxLeadTime;// "CIOR0030";
														// //护士医嘱签署确认时，医嘱签署确认最大可提前时间（分钟）
														// OrSignChkMaxLeadTime
														// 空时不受限制"
	private SysParamInfo SYS_PARAM_OrStopChkMaxLeadTime;// "CIOR0035";
														// //护士医嘱停止确认时，医嘱停止确认最大可提前时间（分钟）
														// OrStopChkMaxLeadTime"
	private SysParamInfo SYS_PARAM_OrChkSrvScope4MakeupFee;// "CIOR0040";
															// //护士医嘱确认补录费用时，可录入服务范围设置（组织）
															// OrChkSrvScope4MakeupFee"
	private SysParamInfo SYS_PARAM_OrChkSrvScope4MakeupFee_D;// "CIOR0040";
																// //护士医嘱确认补录费用时，可录入服务范围设置（部门）
																// OrChkSrvScope4MakeupFee"
	private SysParamInfo SYS_PARAM_DtCalEffModeWithinNDays;// "CIOR0045";
															// //N天内有效业务表达时，时间计算的有效模式
															// DtCalEffModeWithinNDays
															// 0 24小时模式 1
															// 日开始时间模式"""
	private SysParamInfo SYS_PARAM_OrSignOrEffTimeTolerance;// "CIOR0050";
															// //医嘱签署与医嘱生效时间间的有效允差（分钟）
															// OrSignOrEffTimeTolerance"
	private SysParamInfo SYS_PARAM_AllergyQryYearLimit;// "CIOR0055";
														// //药品过敏史查询年限（皮试判断用）
														// AllergyQryYearLimit"
	private SysParamInfo SYS_PARAM_PharmAllergyHandleMode;// "CIOR0060";
															// //药物过敏的处理模式（皮试判断用）
															// PharmAllergyHandleMode
															// 0 药品禁用 1 再皮试 2
															// 强制使用"""
	private SysParamInfo SYS_PARAM_AllergicSkinTestValidPeriodStr;// "CIOR0065";
																	// //过敏皮试效期字串（年龄月，效期天）
																	// AllergicSkinTestValidPeriodStr
																	// 默认值：0~168,1;169~,3
																	// 0到168月效期1天（14岁以下含14岁效期1天
																	// ）;169月以上效期3天（14岁以上效期3天）"
	private SysParamInfo SYS_PARAM_OrConsPatVisDays;// "CIOR0070"; //会诊患者系统可见天数
													// OrConsPatVisDays"
	private SysParamInfo SYS_PARAM_OpDocBillOperationMode;// "CIOR0075";
															// //门诊医生费用操作模式 枚举 2
															// 0 不需查看 1 可查看但不可编辑
															// 2 可编辑费用"
	private SysParamInfo SYS_PARAM_OpSrvScope4DocMakeupFee;// "CIOR0080";
															// //门诊医生补录费用时，可录入服务范围设置（组织）
															// 字符串 空
	private SysParamInfo SYS_PARAM_OpSrvScope4DocMakeupFee_D;// "CIOR0080";
																// //门诊医生补录费用时，可录入服务范围设置（部门）
																// 字符串 空
	private SysParamInfo SYS_PARAM_OpListMarshalSequenceMode;// "CIOR0085";
																// //医嘱列表排列顺序模式
																// 1 倒序 2 顺序
	private SysParamInfo SYS_PARAM_OpMrMgmtMode;// "CIOR0090"; //门诊病历管理模式 0医生打印
												// 1病案统一打印 2无纸化模式 3医生手写
	private SysParamInfo SYS_PARAM_OpLisShareTubeRuleActive;// "CIOR0095"; //
															// 诊疗视图可预看天数 默认值0
	private SysParamInfo SYS_PARAM_CiViewCanPreDays;// "CIOR0100"; // 诊疗视图可预看天数
													// 默认值0
	private SysParamInfo SYS_PARAM_CiPharmMpInUsageScope;// "CIOR0105"; //
															// 常规在院执行药品给药途径范围设置
															// 去掉参数CIOR0105
															// 改为使用CIOR0115
	private SysParamInfo SYS_PARAM_CiOrFgMpInDefaultVPlugin;// "CIOR0110"; //
															// 临床医嘱在院执行标识默认值设置插件
	private SysParamInfo SYS_PARAM_CiPharmGrpableUsageScope;// "CIOR0115"; //
															// 药品可成组使用用法范围设置
	private SysParamInfo SYS_PARAM_CiOrSplit4PresTransPlugin;// "CIOR0120"; //
																// 临床医嘱分方业务插件设置
	private SysParamInfo SYS_PARAM_IsMedInsuranceCheckUse;// "CIOR0125"; //
															// 临床医嘱是否启用医保校验逻辑
	private SysParamInfo SYS_PARAM_IsRationalPharmUseCheck;// "CIOR0130"; //
															// 临床医嘱是否启用合理用药校验逻辑
	private SysParamInfo SYS_PARAM_OpThisPatVisitFinishMode;// "CIOR0135"; //
															// 门诊就诊诊毕的管理模式 0无诊毕
															// 1仅诊毕 2诊毕与取消
	private SysParamInfo SYS_PARAM_OpOrSysncro2MrHandleMode;// "CIOR0140"; //
															// 门诊医嘱处置同步到病历操作模式
															// 0自动 1手动
	private SysParamInfo SYS_PARAM_IsRemind4FgIndicFalseConfirmed;// "CIOR0145";
																	// //
																	// 确认为非适应症时是否提醒医生
																	// 默认值False
	private SysParamInfo SYS_PARAM_IsMedicalInsuranceEnable;// "CIOR0150"; //
															// 是否启用医保标识 默认值True
	private SysParamInfo SYS_PARAM_OpMedInsuranceAuditHandleMode;// "CIOR0155";
																	// //
																	// 门诊医保审核处理模式
																	// 0 实时交互模式
																	// 1 集中交互模式
																	// 2
																	// 医保部门审核模式
																	// 默认值
	private SysParamInfo SYS_PARAM_IpMedInsuranceAuditHandleMode;// "CIOR0160";
																	// //
																	// 住院医保审核处理模式
																	// 0 实时交互模式
																	// 1 集中交互模式
																	// 2
																	// 医保部门审核模式
																	// 默认值
	private SysParamInfo SYS_PARAM_IsAutoGenSkinTestOrEnable;// "CIOR0165"; //
																// 是否开启皮试医嘱自动生成逻辑
																// 默认值true
	private SysParamInfo SYS_PARAM_CiOrExFlowDeptHandleMode;// "CIOR0170"; //
															// 医嘱执行流向科室处理模式 默认值1
															// 0 流向配置模式 1
															// 流向配置+模式
	private SysParamInfo SYS_PARAM_CiOrExFlowDefaultDeptSet4Op;// "CIOR0175"; //
																// 门诊执行流向默认科室设置
																// 默认值0 0 就诊科室 1
																// 开单科室
	private SysParamInfo SYS_PARAM_CiOrExFlowDefaultDeptSet4Ip;// "CIOR0180"; //
																// 住院执行流向默认科室设置
																// 默认值2 0 就诊科室 1
																// 开单科室 2就诊病区
	private SysParamInfo SYS_PARAM_CiOrExFlowDefaultDeptSet4Er;// "CIOR0185"; //
																// 急诊执行流向默认科室设置
																// 默认值0 0 就诊科室 1
																// 开单科室 2就诊病区
	private SysParamInfo SYS_PARAM_CiOrExFlowDefaultDeptSet4Pe;// "CIOR0190"; //
																// 体检执行流向默认科室设置
																// 科室选项待确定
	private SysParamInfo SYS_PARAM_CiOrExFlowDefaultDeptSet4Fm;// "CIOR0195"; //
																// 家床执行流向默认科室设置
																// 科室选项待确定
	private SysParamInfo SYS_PARAM_IsAdmitDrugOrBeforeSkinTestRst;// "CIOR0200";
																	// //
																	// 无皮试结果是否可先开立用药医嘱
																	// 默认值 true
	private SysParamInfo SYS_PARAM_CiOrChargeListDataRangeSet;// "CIOR0205"; //
																// 医嘱费用清单数据范围设置参数
																// 01
																// 申请单模式下的临床项目费用
																// 02
																// 申请单模式下的治疗操作费用
																// 03
																// 治疗费用模式下的临床项目费用
																// 04
																// 治疗费用模式下的治疗操作费用
	private SysParamInfo SYS_PARAM_CiOrAssMultiEmsHandleMode;// "CIOR0215";//住院多医疗单的0
																// 仅生成医疗单UI数据（非自动生成医嘱模式）
																// 1 后台自动生成医嘱模式
	private SysParamInfo SPLITRS_GRPRANGEMODE_BYBATCH;// "???????";
														// //医嘱拆解算法时，药品批次取整时归类范围模式
	private SysParamInfo SPLITRS_GRPRANGEMODE_REMAINS;// "???????";
														// //医嘱拆解算法时，余量法时归类范围模式
	// 医保共享参数
	private SysParamInfo SYS_PARAM_IsOrgEnableOrDatumShared;// "CIOR0220"; //
															// 是否启用患者医保数据共享（组织及启用）默认是
															// true 启用
	private SysParamInfo SYS_PARAM_IsDeptEnableOrDatumShared;// "CIOR0225";//是否启用患者医保数据共享（组织启用后科室是否启用）
																// 默认是 true 启用
	// 门诊医嘱助手内容拼接时，执行科室是否显示
	private SysParamInfo IsExecDeptShow4OpenHelper;// "CIOR0230";//门诊医嘱助手内容拼接时，执行科室是否显示
	private SysParamInfo OrTmplTypeAndSeqSet4OPOrHelper;// "CIOR0235";//门诊助手中，登录科室显示模板类型以及顺序设置
	private SysParamInfo IsShowOphelperWhenOrOpen;// "CIOR0240";
													// //门诊医嘱开立时，光标在输入区，是否弹出医嘱助手
	private SysParamInfo OPDiagTreatTmplOrOpenMode;// "CIOR0245";//诊疗模板的开立方式 0
													// 先开单后执行 1 先执行后开单 2
													// 先开单后执行（无明确执行计划）
	private SysParamInfo SYS_PARAM_OpDocBillListOperationMode;// "CIOR0250";//门诊费用清单操作模式：0,不可见；1,只读；2,可编辑
	private SysParamInfo SYS_PARAM_OrHelperOpenOrCountLimitSet;// "CIOR0255";//
																// 助手开立医嘱时开立的医嘱最大限制设置
																// 默认值 10 ，取值区间
																// 0--20；
	private SysParamInfo SYS_PARAM_OpSignedOrExecMode;// "CIOR0260";//机构级别参数，参数值为00撤回模式-独立撤回功能、01撤回模式-操作合并到删除功能、10作废模式
														// – 独立作废功能、11作废模式 –
														// 操作合并到删除功能，默认值为：11作废模式
														// – 操作合并到删除功能。
	private SysParamInfo SYS_PARAM_MedInsuranceIndicInfoModelSet; // CIOR0265
																	// 医保适应症提示信息模式设置
																	// 0
																	// 医保适应症医保限制条件提示信息
																	// ，1 医保适应症
																	// 院内限制提示信息
																	// ，2 医保适应症
																	// 医保限制+院内限制
																	// 信息
	public SysParamInfo SYS_PARAM_IsAdmintHpIndicJudgeFeeItemUnDrugOR; // "CIOR0270";
																		// 增加【非药品医嘱费用是否允许明细适应症选择】机构级别参数，默认赋值不允许，表示非药品医嘱只能批量设置适应和不适应。【允许】表示非药品医嘱下费用允许针对各条费用单独选择适应和不适应
	private  SysParamInfo SYS_PARAM_DosageRelUsageManModeIP; //CIOR0280 //【住院剂型关联用法管理模式】参数，参数到机构级别，默认值为1控制模式  ,	根据以上情况将剂型关联用法使用模式分为3种，1控制模式，2提醒模式，3不管理
    private  SysParamInfo SYS_PARAM_DosageRelUsageManModeOP;//CIOR0275   【门诊剂型关联用法管理模式】参数，参数到机构级别，默认值为1控制模式  ,	根据以上情况将剂型关联用法使用模式分为3种，1控制模式，2提醒模式，3不管理
    private SysParamInfo SYS_PARAM_OrderSheetIsShowCancEmp;//【住院医嘱单打印是否显示作废人信息OrderSheetIsShowCancEmp】参数:当是否显示作废人信息 =N时，不显示作废人信息。当是否显示作废人信息 =Y时，显示作废人信息，在医嘱内容右下角区域显示【作废+作废人】信息。
    
	public SysParamInfo SYS_PARAM_HospitalHerbPresOpenORMode;//"CIOR0295"
																//1)	增加【草药院内制剂开单模式】HospitalHerbPresOpenMode机构级别参数。	参数值：0常规草药处方模式，1虚拟草药处方模式 	参数默认值： 0常规草药处方模式
																//	参数说明：0常规草药处方模式，医院按照普通草药处方进行开单；1虚拟草药处方模式，开立虚拟草药处方，后续根据院内制剂标志进行发药。
	public SysParamInfo SYS_PARAM_IsAllowDoctorTranHpSelfpay4Ip;//"CIOR0300"\
																//2)	添加【住院是否允许医生进行自费操作】IsAllowSelfpayOp机构级别参数。	参数默认值：N 不允许 参数控制：当【住院是否允许医生进行自费操作】IsAllowSelfpayIp = Y时，则支持在医生站进行自费/保内切换操作
	
	private  SysParamInfo SYS_PARAM_IpOrdEarlyEntryTipTp ;// "CIOR0335";//医嘱提前开立限制模式  	默认值：1禁止          参数值：0提醒，1禁止
    private  SysParamInfo SYS_PARAM_IpOrdDtEentryDefaultSet;// "CIOR0340";//开始时间默认赋值规则    默认值：2上条时间		参数值：0 当前时间，1配置时间，2上条时间
    private SysParamInfo SYS_PARAM_IpOrdDtEentryDefaultMinute;// "CIOR0341";//当医生修改医嘱开始时间后，【开始时间默认值】=本次修改的开始时间，【开始时间默认值赋值时间】=当前系统时间。 新增医嘱时，若【当前系统时间】-【开始时间默认值赋值时间】 > 【开始时间默认值有效间隔时长】，则对【开始时间默认值】重新赋值，默认是30分钟
    private SysParamInfo SYS_PARAM_IpOrdDtEentryDefaultValue; //CIOR0342 rue    默认逻辑     TL_CIOR0020日期格式化为整整点参数配置】    false  设置医嘱时间逻辑       参数值【CIOR0340开始时间默认赋值规则
   
    
    private  SysParamInfo SYS_PARAM_IpOrdSugDateLimitTime;// "CIOR0345";//择期手术限开时间点        国际默认配值 14:00。
    private  SysParamInfo SYS_PARAM_IpOrdSugWorkCalendarId;// "CIOR0355";//择期手术限开时间点        国际默认配值 14:00。
    private  SysParamInfo SYS_PARAM_SpecantiConsMd;// CIOR0360【特殊级抗菌药会诊模式】specantiConsMd 机构级别参数 0线下会诊模式，1线上会诊模式
    private  SysParamInfo SYS_PARAM_SpecantiConsApproveMd;// CIOR0365【特殊级抗菌药会诊审批模式】SpecantiConsApproveMd 机构级别参数  0无审批模式，1只需科室审批，2只需医务审批，3科室和医务都需审批
    private  SysParamInfo SYS_PARAM_SpecantiConsRecordMd;// CIOR0370【会诊记录方式specantiConsRecordMd】机构级别参数 0受邀人记录，1会议主持人记录
    private  SysParamInfo SYS_PARAM_SpecantiConsRecordValue;// CIOR0371【会诊记录方式specantiConsRecordValue】手术不发送消息        0,    手术 勾选加急标志   1,    手术全部发送       2
    private  SysParamInfo SYS_PARAM_IsEntryPoisAgent4Ip;// CIOR0375 住院毒麻药是否录入代办人信息,参数默认值为N 参数说明：=Y时，在毒麻药签署时需要提醒医生录入代办人信息； =N时，在毒麻药签署时不需要提醒医生录入代办人信息
    private  SysParamInfo SYS_PARAM_IntravenousDrugCreateMode;//CIOR0380 入壶类药品成组开单模式,参数值:0 用法开单,1用法要求开单;默认值:1
    private  SysParamInfo SYS_PARAM_IpOrdDtEentryDefaultTime;//CIOR0385  开始时间默认赋值配置时间    默认值：08:00:00	
    private  SysParamInfo SYS_PARAM_REVERSEHANDLE_CIORDCONFIRM;//CIOR0605 非持续医嘱停止/作废确认逆流程处理
    private  SysParamInfo SYS_PARAM_ORDCONFIRMAXMAMOUNT;//CIOR0606护嘱批量保存最大数量
    /**
     * 添加【助手启用多线程保存线程数】NumberOfOrdersSavedFromAssi 业务单远+部门参数
     */
    private  SysParamInfo SYS_PARAM_NumberOfOrdersSavedFromAssi;////添加【助手启用多线程保存线程数】NumberOfOrdersSavedFromAssi 业务单远+部门参数。	小于等于1： 不启用多线程  ；大于1 时：1一个线程处理医嘱数量
    private  SysParamInfo SYS_PARAM_IpOrderAutoSaveN ;//添加【新住院医生站医嘱自动保存】IpOrderAutoSaveN 业务单远+部门参数。	默认是 true 启用
	public SysParamInfo SYS_PARAM_IsOpenRisApt4IIH;//	是否启用IIH检查预约功能 IsOpenRisApt4IIH 	True启用检查预约，False 不启用检查预约
	
	public SysParamInfo SYS_PARAM_IsOpenSugApt4IIH;//	是否启用IIH手术预约功能 IsOpenSugApt4IIH 	True 启用手术预约，False 不启用手术预约 
	public SysParamInfo SYS_PARAM_ChenckDrugOpen; //"CIOR0513";//增加【药品物资流向科室处理模式】机构级别参数，参数值：0严格物资流向模式；1非严格物资流向模式（当物资流程返回为空时，医生可手动选择）。
	
	public SysParamInfo getSYS_PARAM_IsAdmintHpIndicJudgeFeeItemUnDrugOR() {
		return getSysParam(SYS_PARAM_IsAdmintHpIndicJudgeFeeItemUnDrugOR,
				ICiOrdNSysParamConst.SYS_PARAM_IsAdmintHpIndicJudgeFeeItemUnDrugOR);
	}

	public SysParamInfo getSYS_PARAM_MedInsuranceIndicInfoModelSet() {
		return getSysParam(SYS_PARAM_MedInsuranceIndicInfoModelSet,
				ICiOrdNSysParamConst.SYS_PARAM_MedInsuranceIndicInfoModelSet);
	}

	public SysParamInfo getSYS_PARAM_OrEarlyEntryMaxHours() {
		return getSysParam(SYS_PARAM_OrEarlyEntryMaxHours, ICiOrdNSysParamConst.SYS_PARAM_OrEarlyEntryMaxHours);
	}

	public SysParamInfo getSYS_PARAM_TemporaryPrnOrValidTime() {
		return getSysParam(SYS_PARAM_TemporaryPrnOrValidTime, ICiOrdNSysParamConst.SYS_PARAM_TemporaryPrnOrValidTime);
	}

	public SysParamInfo getSYS_PARAM_OpOrValidTime() {
		return getSysParam(SYS_PARAM_OpOrValidTime, ICiOrdNSysParamConst.SYS_PARAM_OpOrValidTime);
	}

	public SysParamInfo getSYS_PARAM_ORSRVSPLITDTENDMAXALLOWDAYS() {
		return getSysParam(SYS_PARAM_ORSRVSPLITDTENDMAXALLOWDAYS,
				ICiOrdNSysParamConst.SYS_PARAM_ORSRVSPLITDTENDMAXALLOWDAYS);
	}

	public SysParamInfo getSYS_PARAM_ClinicalDiagSysCfg() {
		return getSysParam(SYS_PARAM_ClinicalDiagSysCfg, ICiOrdNSysParamConst.SYS_PARAM_ClinicalDiagSysCfg);
	}
	
	public SysParamInfo getSYS_PARAM_DosageFormAssociationUsageIP(){
		return getSysParam(SYS_PARAM_DosageRelUsageManModeIP,ICiOrdNSysParamConst.SYS_PARAM_DosageRelUsageManModeIP);
	}
	
	public SysParamInfo getSYS_PARAM_DosageFormAssociationUsageOP(){
		return getSysParam(SYS_PARAM_DosageRelUsageManModeOP,ICiOrdNSysParamConst.SYS_PARAM_DosageRelUsageManModeOP);
	}
	
	/**
	 * 添加【助手启用多线程保存线程数】NumberOfOrdersSavedFromAssi 业务单远+部门参数
	 * @return
	 */
	public SysParamInfo getSYS_PARAM_NumberOfOrdersSavedFromAssi(){
		return getSysParam(SYS_PARAM_NumberOfOrdersSavedFromAssi,ICiOrdNSysParamConst.SYS_PARAM_NumberOfOrdersSavedFromAssi);
	}
	public SysParamInfo getSYS_PARAM_IpOrderAutoSaveN(){
		return getSysParam(SYS_PARAM_IpOrderAutoSaveN,ICiOrdNSysParamConst.SYS_PARAM_IpOrderAutoSaveN);
	}

	public SysParamInfo getSYS_PARAM_ClinicalDiagSysCfg_D() {
		return getSysParam(SYS_PARAM_ClinicalDiagSysCfg_D, ICiOrdNSysParamConst.SYS_PARAM_ClinicalDiagSysCfg_D);
	}

	public SysParamInfo getSYS_PARAM_OrSignChkMaxLeadTime() {
		return getSysParam(SYS_PARAM_OrSignChkMaxLeadTime, ICiOrdNSysParamConst.SYS_PARAM_OrSignChkMaxLeadTime);
	}

	public SysParamInfo getSYS_PARAM_OrStopChkMaxLeadTime() {
		return getSysParam(SYS_PARAM_OrStopChkMaxLeadTime, ICiOrdNSysParamConst.SYS_PARAM_OrStopChkMaxLeadTime);
	}

	public SysParamInfo getSYS_PARAM_OrChkSrvScope4MakeupFee() {
		return getSysParam(SYS_PARAM_OrChkSrvScope4MakeupFee, ICiOrdNSysParamConst.SYS_PARAM_OrChkSrvScope4MakeupFee);
	}

	public SysParamInfo getSYS_PARAM_OrChkSrvScope4MakeupFee_D() {
		return getSysParam(SYS_PARAM_OrChkSrvScope4MakeupFee_D,
				ICiOrdNSysParamConst.SYS_PARAM_OrChkSrvScope4MakeupFee_D);
	}

	public SysParamInfo getSYS_PARAM_DtCalEffModeWithinNDays() {
		return getSysParam(SYS_PARAM_DtCalEffModeWithinNDays, ICiOrdNSysParamConst.SYS_PARAM_DtCalEffModeWithinNDays);
	}

	public SysParamInfo getSYS_PARAM_OrSignOrEffTimeTolerance() {
		return getSysParam(SYS_PARAM_OrSignOrEffTimeTolerance, ICiOrdNSysParamConst.SYS_PARAM_OrSignOrEffTimeTolerance);
	}

	public SysParamInfo getSYS_PARAM_AllergyQryYearLimit() {
		return getSysParam(SYS_PARAM_AllergyQryYearLimit, ICiOrdNSysParamConst.SYS_PARAM_AllergyQryYearLimit);
	}

	public SysParamInfo getSYS_PARAM_PharmAllergyHandleMode() {
		return getSysParam(SYS_PARAM_PharmAllergyHandleMode, ICiOrdNSysParamConst.SYS_PARAM_PharmAllergyHandleMode);
	}
	
	public SysParamInfo getSYS_PARAM_AllergicSkinTestValidPeriodStr() {
		return getSysParam(SYS_PARAM_AllergicSkinTestValidPeriodStr,
				ICiOrdNSysParamConst.SYS_PARAM_AllergicSkinTestValidPeriodStr);
	}

	public SysParamInfo getSYS_PARAM_OrConsPatVisDays() {
		return getSysParam(SYS_PARAM_OrConsPatVisDays, ICiOrdNSysParamConst.SYS_PARAM_OrConsPatVisDays);
	}

	public SysParamInfo getSYS_PARAM_OpDocBillOperationMode() {
		return getSysParam(SYS_PARAM_OpDocBillOperationMode, ICiOrdNSysParamConst.SYS_PARAM_OpDocBillOperationMode);
	}

	public SysParamInfo getSYS_PARAM_OpSrvScope4DocMakeupFee() {
		return getSysParam(SYS_PARAM_OpSrvScope4DocMakeupFee, ICiOrdNSysParamConst.SYS_PARAM_OpSrvScope4DocMakeupFee);
	}

	public SysParamInfo getSYS_PARAM_OpSrvScope4DocMakeupFee_D() {
		return getSysParam(SYS_PARAM_OpSrvScope4DocMakeupFee_D,
				ICiOrdNSysParamConst.SYS_PARAM_OpSrvScope4DocMakeupFee_D);
	}

	public SysParamInfo getSYS_PARAM_OpListMarshalSequenceMode() {
		return getSysParam(SYS_PARAM_OpListMarshalSequenceMode,
				ICiOrdNSysParamConst.SYS_PARAM_OpListMarshalSequenceMode);
	}

	public SysParamInfo getSYS_PARAM_OpMrMgmtMode() {
		return getSysParam(SYS_PARAM_OpMrMgmtMode, ICiOrdNSysParamConst.SYS_PARAM_OpMrMgmtMode);
	}

	public SysParamInfo getSYS_PARAM_OpLisShareTubeRuleActive() {
		return getSysParam(SYS_PARAM_OpLisShareTubeRuleActive, ICiOrdNSysParamConst.SYS_PARAM_OpLisShareTubeRuleActive);
	}

	public SysParamInfo getSYS_PARAM_CiViewCanPreDays() {
		return getSysParam(SYS_PARAM_CiViewCanPreDays, ICiOrdNSysParamConst.SYS_PARAM_CiViewCanPreDays);
	}

	// public GetSysParamDTO getSYS_PARAM_CiPharmMpInUsageScope() {
	// return
	// getSysParam(SYS_PARAM_CiPharmMpInUsageScope,ICiOrdNSysParamConst.SYS_PARAM_CiPharmMpInUsageScope);
	// }
	public SysParamInfo getSYS_PARAM_CiOrFgMpInDefaultVPlugin() {
		return getSysParam(SYS_PARAM_CiOrFgMpInDefaultVPlugin, ICiOrdNSysParamConst.SYS_PARAM_CiOrFgMpInDefaultVPlugin);
	}

	public SysParamInfo getSYS_PARAM_CiPharmGrpableUsageScope() {
		return getSysParam(SYS_PARAM_CiPharmGrpableUsageScope, ICiOrdNSysParamConst.SYS_PARAM_CiPharmGrpableUsageScope);
	}

	public SysParamInfo getSYS_PARAM_CiOrSplit4PresTransPlugin() {
		return getSysParam(SYS_PARAM_CiOrSplit4PresTransPlugin,
				ICiOrdNSysParamConst.SYS_PARAM_CiOrSplit4PresTransPlugin);
	}

	public SysParamInfo getSYS_PARAM_IsMedInsuranceCheckUse() {
		return getSysParam(SYS_PARAM_IsMedInsuranceCheckUse, ICiOrdNSysParamConst.SYS_PARAM_IsMedInsuranceCheckUse);
	}

	public SysParamInfo getSYS_PARAM_IsRationalPharmUseCheck() {
		return getSysParam(SYS_PARAM_IsRationalPharmUseCheck, ICiOrdNSysParamConst.SYS_PARAM_IsRationalPharmUseCheck);
	}

	public SysParamInfo getSYS_PARAM_OpThisPatVisitFinishMode() {
		return getSysParam(SYS_PARAM_OpThisPatVisitFinishMode, ICiOrdNSysParamConst.SYS_PARAM_OpThisPatVisitFinishMode);
	}

	public SysParamInfo getSYS_PARAM_OpOrSysncro2MrHandleMode() {
		return getSysParam(SYS_PARAM_OpOrSysncro2MrHandleMode, ICiOrdNSysParamConst.SYS_PARAM_OpOrSysncro2MrHandleMode);
	}

	public SysParamInfo getSYS_PARAM_IsRemind4FgIndicFalseConfirmed() {
		return getSysParam(SYS_PARAM_IsRemind4FgIndicFalseConfirmed,
				ICiOrdNSysParamConst.SYS_PARAM_IsRemind4FgIndicFalseConfirmed);
	}

	public SysParamInfo getSYS_PARAM_IsMedicalInsuranceEnable() {
		return getSysParam(SYS_PARAM_IsMedicalInsuranceEnable, ICiOrdNSysParamConst.SYS_PARAM_IsMedicalInsuranceEnable);
	}

	public SysParamInfo getSYS_PARAM_OpMedInsuranceAuditHandleMode() {
		return getSysParam(SYS_PARAM_OpMedInsuranceAuditHandleMode,
				ICiOrdNSysParamConst.SYS_PARAM_OpMedInsuranceAuditHandleMode);
	}

	public SysParamInfo getSYS_PARAM_IpMedInsuranceAuditHandleMode() {
		return getSysParam(SYS_PARAM_IpMedInsuranceAuditHandleMode,
				ICiOrdNSysParamConst.SYS_PARAM_IpMedInsuranceAuditHandleMode);
	}

	public SysParamInfo getSYS_PARAM_IsAutoGenSkinTestOrEnable() {
		return getSysParam(SYS_PARAM_IsAutoGenSkinTestOrEnable,
				ICiOrdNSysParamConst.SYS_PARAM_IsAutoGenSkinTestOrEnable);
	}

	public SysParamInfo getSYS_PARAM_CiOrExFlowDeptHandleMode() {
		return getSysParam(SYS_PARAM_CiOrExFlowDeptHandleMode, ICiOrdNSysParamConst.SYS_PARAM_CiOrExFlowDeptHandleMode);
	}

	public SysParamInfo getSYS_PARAM_CiOrExFlowDefaultDeptSet4Op() {
		return getSysParam(SYS_PARAM_CiOrExFlowDefaultDeptSet4Op,
				ICiOrdNSysParamConst.SYS_PARAM_CiOrExFlowDefaultDeptSet4Op);
	}

	public SysParamInfo getSYS_PARAM_CiOrExFlowDefaultDeptSet4Ip() {
		return getSysParam(SYS_PARAM_CiOrExFlowDefaultDeptSet4Ip,
				ICiOrdNSysParamConst.SYS_PARAM_CiOrExFlowDefaultDeptSet4Ip);
	}

	public SysParamInfo getSYS_PARAM_CiOrExFlowDefaultDeptSet4Er() {
		return getSysParam(SYS_PARAM_CiOrExFlowDefaultDeptSet4Er,
				ICiOrdNSysParamConst.SYS_PARAM_CiOrExFlowDefaultDeptSet4Er);
	}

	public SysParamInfo getSYS_PARAM_CiOrExFlowDefaultDeptSet4Pe() {
		return getSysParam(SYS_PARAM_CiOrExFlowDefaultDeptSet4Pe,
				ICiOrdNSysParamConst.SYS_PARAM_CiOrExFlowDefaultDeptSet4Pe);
	}

	public SysParamInfo getSYS_PARAM_CiOrExFlowDefaultDeptSet4Fm() {
		return getSysParam(SYS_PARAM_CiOrExFlowDefaultDeptSet4Fm,
				ICiOrdNSysParamConst.SYS_PARAM_CiOrExFlowDefaultDeptSet4Fm);
	}

	public SysParamInfo getSYS_PARAM_IsAdmitDrugOrBeforeSkinTestRst() {
		return getSysParam(SYS_PARAM_IsAdmitDrugOrBeforeSkinTestRst,
				ICiOrdNSysParamConst.SYS_PARAM_IsAdmitDrugOrBeforeSkinTestRst);
	}

	public SysParamInfo getSYS_PARAM_CiOrChargeListDataRangeSet() {
		return getSysParam(SYS_PARAM_CiOrChargeListDataRangeSet,
				ICiOrdNSysParamConst.SYS_PARAM_CiOrChargeListDataRangeSet);
	}

	public SysParamInfo getSYS_PARAM_CiOrAssMultiEmsHandleMode() {
		return getSysParam(SYS_PARAM_CiOrAssMultiEmsHandleMode,
				ICiOrdNSysParamConst.SYS_PARAM_CiOrAssMultiEmsHandleMode);
	}

	public SysParamInfo getSPLITRS_GRPRANGEMODE_BYBATCH() {
		return getSysParam(SPLITRS_GRPRANGEMODE_BYBATCH, ICiOrdNSysParamConst.SPLITRS_GRPRANGEMODE_BYBATCH);
	}

	public SysParamInfo getSPLITRS_GRPRANGEMODE_REMAINS() {
		return getSysParam(SPLITRS_GRPRANGEMODE_REMAINS, ICiOrdNSysParamConst.SPLITRS_GRPRANGEMODE_REMAINS);
	}

	public SysParamInfo getSYS_PARAM_IsOrgEnableOrDatumShared() {
		return getSysParam(SYS_PARAM_IsOrgEnableOrDatumShared, ICiOrdNSysParamConst.SYS_PARAM_IsOrgEnableOrDatumShared);
	}

	public SysParamInfo getSYS_PARAM_IsDeptEnableOrDatumShared() {
		return getSysParam(SYS_PARAM_IsDeptEnableOrDatumShared,
				ICiOrdNSysParamConst.SYS_PARAM_IsDeptEnableOrDatumShared);
	}

	public SysParamInfo getIsExecDeptShow4OpenHelper() {
		return getSysParam(IsExecDeptShow4OpenHelper, ICiOrdNSysParamConst.IsExecDeptShow4OpenHelper);
	}

	public SysParamInfo getOrTmplTypeAndSeqSet4OPOrHelper() {
		return getSysParam(OrTmplTypeAndSeqSet4OPOrHelper, ICiOrdNSysParamConst.OrTmplTypeAndSeqSet4OPOrHelper);
	}

	public SysParamInfo getIsShowOphelperWhenOrOpen() {
		return getSysParam(IsShowOphelperWhenOrOpen, ICiOrdNSysParamConst.IsShowOphelperWhenOrOpen);
	}

	public SysParamInfo getOPDiagTreatTmplOrOpenMode() {
		return getSysParam(OPDiagTreatTmplOrOpenMode, ICiOrdNSysParamConst.OPDiagTreatTmplOrOpenMode);
	}

	public SysParamInfo getSYS_PARAM_OpDocBillListOperationMode() {
		return getSysParam(SYS_PARAM_OpDocBillListOperationMode,
				ICiOrdNSysParamConst.SYS_PARAM_OpDocBillListOperationMode);
	}

	public SysParamInfo getSYS_PARAM_OrHelperOpenOrCountLimitSet() {
		return getSysParam(SYS_PARAM_OrHelperOpenOrCountLimitSet,
				ICiOrdNSysParamConst.SYS_PARAM_OrHelperOpenOrCountLimitSet);
	}

	public SysParamInfo getSYS_PARAM_OpSignedOrExecMode() {
		return getSysParam(SYS_PARAM_OpSignedOrExecMode, ICiOrdNSysParamConst.SYS_PARAM_OpSignedOrExecMode);
	}
	
	public SysParamInfo getSYS_PARAM_HospitalHerbPresOpenORMode(){
		return getSysParam(SYS_PARAM_HospitalHerbPresOpenORMode, ICiOrdNSysParamConst.SYS_PARAM_HospitalHerbPresOpenORMode);
	}
	
	public SysParamInfo getSYS_PARAM_IsAllowDoctorTranHpSelfpay4Ip(){
		return getSysParam(SYS_PARAM_IsAllowDoctorTranHpSelfpay4Ip, ICiOrdNSysParamConst.SYS_PARAM_IsAllowDoctorTranHpSelfpay4Ip);
	}
	
	public SysParamInfo getSYS_PARAM_IsOpenRisApt4IIH(){
		return getSysParam(SYS_PARAM_IsOpenRisApt4IIH, ICiOrdNSysParamConst.SYS_PARAM_IsOpenRisApt4IIH);
	}
	
	public SysParamInfo getSYS_PARAM_IsOpenSugApt4IIH(){
		return getSysParam(SYS_PARAM_IsOpenSugApt4IIH, ICiOrdNSysParamConst.SYS_PARAM_IsOpenSugApt4IIH);
	}
	
	public SysParamInfo getSYS_PARAM_IpOrdEarlyEntryTipTp(){
		return getSysParam(SYS_PARAM_IpOrdEarlyEntryTipTp,ICiOrdNSysParamConst.SYS_PARAM_IpOrdEarlyEntryTipTp);
	}
	public SysParamInfo getSYS_PARAM_IpOrdDtEentryDefaultSet(){
		return getSysParam(SYS_PARAM_IpOrdDtEentryDefaultSet,ICiOrdNSysParamConst.SYS_PARAM_IpOrdDtEentryDefaultSet);
	}
	
	/**
	 * "CIOR0341";//当医生修改医嘱开始时间后，【开始时间默认值】=本次修改的开始时间，【开始时间默认值赋值时间】=当前系统时间。 新增医嘱时，若【当前系统时间】-【开始时间默认值赋值时间】 > 【开始时间默认值有效间隔时长】，则对【开始时间默认值】重新赋值，默认是30分钟
	 * @return
	 */
	public SysParamInfo getSYS_PARAM_IpOrdDtEentryDefaultMinute() {
		return getSysParam(SYS_PARAM_IpOrdDtEentryDefaultMinute, ICiOrdNSysParamConst.SYS_PARAM_IpOrdDtEentryDefaultMinute);
		}
	
	 
	/**
	 * "CIOR0342";//
       true    默认逻辑     TL_CIOR0020日期格式化为整整点参数配置】
        false  设置医嘱时间逻辑       参数值【CIOR0340开始时间默认赋值规则
	 * @return
	 */
	public SysParamInfo getSYS_PARAM_IpOrdDtEentryDefaultValue() {
		return getSysParam(SYS_PARAM_IpOrdDtEentryDefaultValue, ICiOrdNSysParamConst.SYS_PARAM_IpOrdDtEentryDefaultValue);
		}
	
	public SysParamInfo getSYS_PARAM_IpOrdSugDateLimitTime(){
		return getSysParam(SYS_PARAM_IpOrdSugDateLimitTime,ICiOrdNSysParamConst.SYS_PARAM_IpOrdSugDateLimitTime);
	}
	public SysParamInfo getSYS_PARAM_IpOrdSugWorkCalendarId(){
		return getSysParam(SYS_PARAM_IpOrdSugWorkCalendarId,ICiOrdNSysParamConst.SYS_PARAM_IpOrdSugWorkCalendarId);
	}
	/**
	 * 【特殊级抗菌药会诊模式】specantiConsMd 机构级别参数 0线下会诊模式，1线上会诊模式
	 * @return
	 */
	public SysParamInfo getSYS_PARAM_SpecantiConsMd(){
		return getSysParam(SYS_PARAM_SpecantiConsMd,ICiOrdNSysParamConst.SYS_PARAM_SpecantiConsMd);
	}
	/**
	 * 【特殊级抗菌药会诊审批模式】SpecantiConsApproveMd 机构级别参数  0无审批模式，1只需科室审批，2只需医务审批，3科室和医务都需审批
	 * @return
	 */
	public SysParamInfo getSYS_PARAM_SpecantiConsApproveMd(){
		return getSysParam(SYS_PARAM_SpecantiConsApproveMd,ICiOrdNSysParamConst.SYS_PARAM_SpecantiConsApproveMd);
	}
	/**
	 * 【会诊记录方式specantiConsRecordMd】机构级别参数 0受邀人记录，1会议主持人记录
	 * @return
	 */
	public SysParamInfo getSYS_PARAM_SpecantiConsRecordMd(){
		return getSysParam(SYS_PARAM_SpecantiConsRecordMd,ICiOrdNSysParamConst.SYS_PARAM_SpecantiConsRecordMd);
	}
	/**
	 * CIOR0371【会诊记录方式specantiConsRecordValue】手术不发送消息        0,    手术 勾选加急标志   1,    手术全部发送       2
	 * @return
	 */
	public SysParamInfo getSYS_PARAM_SpecantiConsRecordValue(){
		return getSysParam(SYS_PARAM_SpecantiConsRecordValue,ICiOrdNSysParamConst.SYS_PARAM_SpecantiConsRecordValue);
	}
	
	
	public SysParamInfo getSYS_PARAM_IsEntryPoisAgent4Ip() {
		return getSysParam(SYS_PARAM_IsEntryPoisAgent4Ip,ICiOrdNSysParamConst.SYS_PARAM_IsEntryPoisAgent4Ip);
	}
	public SysParamInfo getSYS_PARAM_IntravenousDrugCreateMode(){
		return getSysParam(SYS_PARAM_IntravenousDrugCreateMode,ICiOrdNSysParamConst.SYS_PARAM_IntravenousDrugCreateMode);
	}
	public SysParamInfo getSYS_PARAM_IpOrdDtEentryDefaultTime(){
		return getSysParam(SYS_PARAM_IpOrdDtEentryDefaultTime,ICiOrdNSysParamConst.SYS_PARAM_IpOrdDtEentryDefaultTime);
	}
	/**
	 * 【住院医嘱单打印是否显示作废人信息OrderSheetIsShowCancEmp】参数
	 * @return
	 */
	public SysParamInfo getSYS_PARAM_OrderSheetIsShowCancEmp(){
		return getSysParam(SYS_PARAM_OrderSheetIsShowCancEmp,ICiOrdNSysParamConst.SYS_PARAM_OrderSheetIsShowCancEmp);
	}
   
	/**
	 * 0严格物资流向模式；1非严格物资流向模式（当物资流程返回为空时，医生可手动选择）
	 * @return
	 */
	public SysParamInfo getSYS_PARAM_ChenckDrugOpen(){
		return getSysParam(SYS_PARAM_ChenckDrugOpen,ICiOrdNSysParamConst.SYS_PARAM_ChenckDrugOpen);
	}
	/**
	 * 非持续医嘱停止/作废确认逆流程处理
	 * @return
	 */
	public SysParamInfo getSYS_PARAM_REVERSEHANDLE_CIORDCONFIRM(){
    	return getSysParam(SYS_PARAM_REVERSEHANDLE_CIORDCONFIRM,ICiOrdNSysParamConst.SYS_PARAM_REVERSEHANDLE_CIORDCONFIRM);
    }
	/**
	 * CIOR0606护嘱批量保存最大数量
	 * @return
	 */
	public SysParamInfo getSYS_PARAM_ORDCONFIRMAXMAMOUNT(){
		return getSysParam(SYS_PARAM_ORDCONFIRMAXMAMOUNT,ICiOrdNSysParamConst.SYS_PARAM_ORDCONFIRMAXMAMOUNT);
	}
	
	
	
	
	private SysParamInfo getSysParam(SysParamInfo getsyspara, String syscode) {
		if (CiOrdUtils.isEmpty(getsyspara)) {
			return new SysParamInfo(syscode);
		} else {
			return getsyspara;
		}
	}

}
