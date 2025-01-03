package iih.ci.ord.i;

/**
 * 临床医嘱系统参数
 * 这是新整理后的参数常量
 * 暂时都先使用这里的参数值
 */
public class ICiOrdNSysParamConst {
	/**
	 * 临床医嘱参数常量
	 */
	public static final String SYS_PARAM_OrEarlyEntryMaxHours="CIOR0005"; //医嘱可提前录入最大小时数（医嘱生效时间）	OrEarlyEntryMaxHours"
	public static final String SYS_PARAM_TemporaryPrnOrValidTime="CIOR0010"; //临时备用医嘱有效时间（小时）	TemporaryPrnOrValidTime"
	public static final String SYS_PARAM_OpOrValidTime="CIOR0015"; //门诊医嘱有效时间范围（小时）	OpOrValidTime"
	public static final String SYS_PARAM_ORSRVSPLITDTENDMAXALLOWDAYS="CIOR0020"; //医嘱或服务拆分截止时间与当前时间最大允许的天数间隔	OrSrvSplitDtEndMaxAllowDays"
	public static final String SYS_PARAM_ClinicalDiagSysCfg="CIOR0025"; //临床诊断系统设置（组织）	ClinicalDiagSysCfg11  西医、12  中医、13  蒙医	11,12则页签显示   西医页签和中医页签                        空则无页签显示"
	public static final String SYS_PARAM_ClinicalDiagSysCfg_D="CIOR0025"; //临床诊断系统设置（部门）	ClinicalDiagSysCfg	11  西医、12  中医、13  蒙医	11,12则页签显示   西医页签和中医页签                        空则无页签显示"
	public static final String SYS_PARAM_OrSignChkMaxLeadTime="CIOR0030"; //护士医嘱签署确认时，医嘱签署确认最大可提前时间（分钟）	OrSignChkMaxLeadTime	空时不受限制"
	public static final String SYS_PARAM_OrStopChkMaxLeadTime="CIOR0035"; //护士医嘱停止确认时，医嘱停止确认最大可提前时间（分钟）	OrStopChkMaxLeadTime"
	public static final String SYS_PARAM_OrChkSrvScope4MakeupFee="CIOR0040"; //护士医嘱确认补录费用时，可录入服务范围设置（组织）	OrChkSrvScope4MakeupFee"
	public static final String SYS_PARAM_OrChkSrvScope4MakeupFee_D="CIOR0040"; //护士医嘱确认补录费用时，可录入服务范围设置（部门）	OrChkSrvScope4MakeupFee"
	public static final String SYS_PARAM_OrChkSrvFreqMd4MakeupFee= "CIOR0040"; // 护士医嘱确认补录费用时，可录入服务范围设置（组织）OrChkSrvScope4MakeupFee"
	public static final String SYS_PARAM_DtCalEffModeWithinNDays="CIOR0045"; //N天内有效业务表达时，时间计算的有效模式	DtCalEffModeWithinNDays	0 24小时模式	1 日开始时间模式"""
	public static final String SYS_PARAM_OrSignOrEffTimeTolerance="CIOR0050"; //医嘱签署与医嘱生效时间间的有效允差（分钟）	OrSignOrEffTimeTolerance"
	public static final String SYS_PARAM_AllergyQryYearLimit="CIOR0055"; //药品过敏史查询年限（皮试判断用）	AllergyQryYearLimit"
	public static final String SYS_PARAM_PharmAllergyHandleMode="CIOR0060"; //药物过敏的处理模式（皮试判断用）	PharmAllergyHandleMode	0 药品禁用	1 再皮试	2 强制使用"""
	public static final String SYS_PARAM_AllergicSkinTestValidPeriodStr="CIOR0065"; //过敏皮试效期字串（年龄月，效期天）	AllergicSkinTestValidPeriodStr	默认值：0~168,1;169~,3      0到168月效期1天（14岁以下含14岁效期1天 ）;169月以上效期3天（14岁以上效期3天）"	
	public static final String SYS_PARAM_OrConsPatVisDays="CIOR0070"; //会诊患者系统可见天数	OrConsPatVisDays"
	public static final String SYS_PARAM_OpDocBillOperationMode="CIOR0075";		//门诊医生费用操作模式	枚举	2	0 不需查看 1 可查看但不可编辑 2 可编辑费用"
	public static final String SYS_PARAM_OpSrvScope4DocMakeupFee="CIOR0080";	//门诊医生补录费用时，可录入服务范围设置（组织）	字符串	空	
	public static final String SYS_PARAM_OpSrvScope4DocMakeupFee_D="CIOR0080";	//门诊医生补录费用时，可录入服务范围设置（部门）	字符串	空	
	public static final String SYS_PARAM_OpListMarshalSequenceMode="CIOR0085";	//医嘱列表排列顺序模式	1 倒序  2 顺序
	public static final String SYS_PARAM_OpMrMgmtMode="CIOR0090";	//门诊病历管理模式	0医生打印	1病案统一打印	2无纸化模式  3医生手写
	public static final String SYS_PARAM_OpLisShareTubeRuleActive = "CIOR0095"; // 诊疗视图可预看天数 默认值0
	public static final String SYS_PARAM_CiViewCanPreDays = "CIOR0100"; // 诊疗视图可预看天数 默认值0
	public static final String SYS_PARAM_CiPharmMpInUsageScope = "CIOR0105"; // 常规在院执行药品给药途径范围设置 去掉参数CIOR0105 改为使用CIOR0115
	public static final String SYS_PARAM_CiOrFgMpInDefaultVPlugin = "CIOR0110"; // 临床医嘱在院执行标识默认值设置插件
	public static final String SYS_PARAM_CiPharmGrpableUsageScope = "CIOR0115"; // 药品可成组使用用法范围设置
	public static final String SYS_PARAM_CiOrSplit4PresTransPlugin = "CIOR0120"; // 临床医嘱分方业务插件设置
	public static final String SYS_PARAM_IsMedInsuranceCheckUse = "CIOR0125"; // 临床医嘱是否启用医保校验逻辑
	public static final String SYS_PARAM_IsRationalPharmUseCheck = "CIOR0130"; // 临床医嘱是否启用合理用药校验逻辑
	public static final String SYS_PARAM_OpThisPatVisitFinishMode = "CIOR0135"; // 门诊就诊诊毕的管理模式       0无诊毕   1仅诊毕   2诊毕与取消
	public static final String SYS_PARAM_OpOrSysncro2MrHandleMode = "CIOR0140"; // 门诊医嘱处置同步到病历操作模式   0自动  1手动
	public static final String SYS_PARAM_IsRemind4FgIndicFalseConfirmed = "CIOR0145"; // 确认为非适应症时是否提醒医生  默认值False
	public static final String SYS_PARAM_IsMedicalInsuranceEnable = "CIOR0150"; // 是否启用医保标识  默认值True
	public static final String SYS_PARAM_OpMedInsuranceAuditHandleMode = "CIOR0155"; // 门诊医保审核处理模式  0  实时交互模式	1  集中交互模式	2  医保部门审核模式 默认值 
	public static final String SYS_PARAM_IpMedInsuranceAuditHandleMode = "CIOR0160"; // 住院医保审核处理模式  0  实时交互模式	1  集中交互模式	2  医保部门审核模式 默认值
	public static final String SYS_PARAM_IsAutoGenSkinTestOrEnable = "CIOR0165"; // 是否开启皮试医嘱自动生成逻辑  默认值true
	public static final String SYS_PARAM_CiOrExFlowDeptHandleMode = "CIOR0170"; // 医嘱执行流向科室处理模式  默认值1 0 流向配置模式	1 流向配置+模式
	public static final String SYS_PARAM_CiOrExFlowDefaultDeptSet4Op = "CIOR0175"; // 门诊执行流向默认科室设置  默认值0   0 就诊科室	1 开单科室
	public static final String SYS_PARAM_CiOrExFlowDefaultDeptSet4Ip = "CIOR0180"; // 住院执行流向默认科室设置  默认值2   0 就诊科室	1 开单科室     2就诊病区
	public static final String SYS_PARAM_CiOrExFlowDefaultDeptSet4Er = "CIOR0185"; // 急诊执行流向默认科室设置  默认值0   0 就诊科室	1 开单科室     2就诊病区
	public static final String SYS_PARAM_CiOrExFlowDefaultDeptSet4Pe = "CIOR0190"; // 体检执行流向默认科室设置    科室选项待确定
	public static final String SYS_PARAM_CiOrExFlowDefaultDeptSet4Fm = "CIOR0195"; // 家床执行流向默认科室设置    科室选项待确定
	public static final String SYS_PARAM_IsAdmitDrugOrBeforeSkinTestRst = "CIOR0200"; // 无皮试结果是否可先开立用药医嘱 默认值  true
	public static final String SYS_PARAM_CiOrChargeListDataRangeSet = "CIOR0205"; // 医嘱费用清单数据范围设置参数 01 申请单模式下的临床项目费用	02  申请单模式下的治疗操作费用	03  治疗费用模式下的临床项目费用 04 治疗费用模式下的治疗操作费用
    public static final String SYS_PARAM_CiOrAssMultiEmsHandleMode = "CIOR0215";//住院多医疗单的0  仅生成医疗单UI数据（非自动生成医嘱模式）     1  后台自动生成医嘱模式
	
	public static final String SPLITRS_GRPRANGEMODE_BYBATCH="???????";   //医嘱拆解算法时，药品批次取整时归类范围模式
	public static final String SPLITRS_GRPRANGEMODE_REMAINS="???????";   //医嘱拆解算法时，余量法时归类范围模式
	
	//医保共享参数
	public static final String SYS_PARAM_IsOrgEnableOrDatumShared= "CIOR0220"; // 是否启用患者医保数据共享（组织及启用）默认是 true 启用
    public static final String SYS_PARAM_IsDeptEnableOrDatumShared = "CIOR0225";//是否启用患者医保数据共享（组织启用后科室是否启用） 默认是 true 启用
	//门诊医嘱助手内容拼接时，执行科室是否显示
    public static final String IsExecDeptShow4OpenHelper ="CIOR0230";//门诊医嘱助手内容拼接时，执行科室是否显示
    
    public static final String OrTmplTypeAndSeqSet4OPOrHelper = "CIOR0235";//门诊助手中，登录科室显示模板类型以及顺序设置
    public  static final String IsShowOphelperWhenOrOpen = "CIOR0240"; //门诊医嘱开立时，光标在输入区，是否弹出医嘱助手
    public static final String OPDiagTreatTmplOrOpenMode = "CIOR0245";//诊疗模板的开立方式  0 先开单后执行   1 先执行后开单   2  先开单后执行（无明确执行计划）
    public static final String SYS_PARAM_OpDocBillListOperationMode = "CIOR0250";//门诊费用清单操作模式：0,不可见；1,只读；2,可编辑
    public static final String SYS_PARAM_OrHelperOpenOrCountLimitSet = "CIOR0255";// 助手开立医嘱时开立的医嘱最大限制设置 默认值  10 ，取值区间 0--20；
    public static final String SYS_PARAM_OpSignedOrExecMode = "CIOR0260";//机构级别参数，参数值为00撤回模式-独立撤回功能、01撤回模式-操作合并到删除功能、10作废模式 – 独立作废功能、11作废模式 – 操作合并到删除功能，默认值为：11作废模式 – 操作合并到删除功能。
    public static final String SYS_PARAM_OpFefModelSqlBP = "CIOR0265";//TODO门诊参照创建sql
    public static final String SYS_PARAM_MedInsuranceIndicInfoModelSet = "CIOR0265"; //医保适应症提示信息模式设置   0  医保适应症医保限制条件提示信息 ，1 医保适应症 院内限制提示信息 ，2 医保适应症 医保限制+院内限制 信息
	public static final String SYS_PARAM_IsAdmintHpIndicJudgeFeeItemUnDrugOR ="CIOR0270";//d)	增加【非药品医嘱费用是否允许明细适应症选择】机构级别参数，默认赋值不允许，表示非药品医嘱只能批量设置适应和不适应。【允许】表示非药品医嘱下费用允许针对各条费用单独选择适应和不适应
	public  static final String SYS_PARAM_DosageRelUsageManModeOP="CIOR0275";  // 【门诊剂型关联用法管理模式】参数，参数到机构级别，默认值为1控制模式  ,	根据以上情况将剂型关联用法使用模式分为3种，1控制模式，2提醒模式，3不管理
	public  static final String SYS_PARAM_DosageRelUsageManModeIP="CIOR0280"; //  【住院剂型关联用法管理模式】参数，参数到机构级别，默认值为1控制模式, 	根据以上情况将剂型关联用法使用模式分为3种，1控制模式，2提醒模式，3不管理
	public static final String SYS_PARAM_HospitalHerbPresOpenORMode = "CIOR0295";//1)	增加【草药院内制剂开单模式】HospitalHerbPresOpenMode机构级别参数。	参数值：0常规草药处方模式，1虚拟草药处方模式 	参数默认值： 0常规草药处方模式	参数说明：0常规草药处方模式，医院按照普通草药处方进行开单；1虚拟草药处方模式，开立虚拟草药处方，后续根据院内制剂标志进行发药。
	public static final String SYS_PARAM_IsAllowDoctorTranHpSelfpay4Ip = "CIOR0300";//添加【住院是否允许医生进行自费操作】IsAllowSelfpayOp机构级别参数。	参数默认值：N 不允许 参数控制：当【住院是否允许医生进行自费操作】IsAllowSelfpayIp = Y时，则支持在医生站进行自费/保内切换操作
	public static final String SYS_PARAM_IsCiOpenControl = "CIOR0310";//增加【是否启用临床开单控制】机构级别参数。铜陵、兰陵默认为true。国际医院默认为false。
	// 【江苏省医】= 311
		//public static final String SYS_PARAM_CiOpOrderlistTabsParam = "CIOR0310"; // 门急诊医生站医嘱列表项目页签参数：1医嘱项目 2药品 3检查 4检验 5诊疗 6其他 7分方 8费用清单 @?? 江苏=311
		// 【国际医院】=312
		//public static final String SYS_PARAM_CiOpOrderlistTabsParam = "CIOR0310"; // 门急诊医生站医嘱列表项目页签参数：1医嘱项目 2药品 3检查 4检验 5诊疗 6其他 7分方 8费用清单 @?? 国际=312
	public static final String SYS_PARAM_OrderSheetIsShowCancEmp = "CIOR0315";//【住院医嘱单打印是否显示作废人信息OrderSheetIsShowCancEmp】参数:当是否显示作废人信息 =N时，不显示作废人信息。当是否显示作废人信息 =Y时，显示作废人信息，在医嘱内容右下角区域显示【作废+作废人】信息。
	
	public static final String SYS_PARAM_NumberOfOrdersSavedFromAssi = "CIOR0325";//添加【助手启用多线程保存线程数】NumberOfOrdersSavedFromAssi 业务单远+部门参数。	小于等于1： 不启用多线程  ；大于1 时：1一个线程处理医嘱数量
	public static final String SYS_PARAM_IpOrderAutoSaveN = "CIOR0330";//添加【新住院医生站医嘱自动保存】IpOrderAutoSaveN 业务单远+部门参数。	默认是 true 启用
	public static final String SYS_PARAM_IpOrdEarlyEntryTipTp = "CIOR0335";//医嘱提前开立限制模式  	默认值：1禁止          参数值：0提醒，1禁止
	public static final String SYS_PARAM_IpOrdDtEentryDefaultSet = "CIOR0340";//开始时间默认赋值规则    默认值：2上条时间		参数值：0 当前时间，1配置时间，2上条时间
	public static final String SYS_PARAM_IpOrdDtEentryDefaultMinute = "CIOR0341";//当医生修改医嘱开始时间后，【开始时间默认值】=本次修改的开始时间，【开始时间默认值赋值时间】=当前系统时间。 新增医嘱时，若【当前系统时间】-【开始时间默认值赋值时间】 > 【开始时间默认值有效间隔时长】，则对【开始时间默认值】重新赋值，默认是30分钟
	public static final String SYS_PARAM_IpOrdDtEentryDefaultValue = "CIOR0342";//	true    默认逻辑     TL_CIOR0020日期格式化为整整点参数配置】	 false  设置医嘱时间逻辑       参数值【CIOR0340开始时间默认赋值规则
	public static final String SYS_PARAM_IpOrdSugDateLimitTime = "CIOR0345";//择期手术限开时间点        国际默认配值 14:00。
	public static final String SYS_PARAM_CiOrdConfirmMode = "CIOR0350";//CIOR0350 0多类型批量确认模式，1单类型确认模式。	默认值：1单类型确认模式。
	public static final String SYS_PARAM_IpOrdSugWorkCalendarId = "CIOR0355";//【手术开单时间限制使用日历】机构级别参数，参数值为工作日历主键
	public static final String SYS_PARAM_SpecantiConsMd = "CIOR0360";// 【特殊级抗菌药会诊模式】specantiConsMd 机构级别参数 0线下会诊模式，1线上会诊模式
	public static final String SYS_PARAM_SpecantiConsApproveMd = "CIOR0365";// 【特殊级抗菌药会诊审批模式】SpecantiConsApproveMd 机构级别参数  0无审批模式，1只需科室审批，2只需医务审批，3科室和医务都需审批
	public static final String SYS_PARAM_SpecantiConsRecordMd = "CIOR0370";// 【会诊记录方式specantiConsRecordMd】机构级别参数 0受邀人记录，1会议主持人记录
	public static final String SYS_PARAM_SpecantiConsRecordValue = "CIOR0371";//【会诊记录方式specantiConsRecordValue】手术不发送消息        0,    手术 勾选加急标志   1,    手术全部发送       2
	public static final String SYS_PARAM_IsEntryPoisAgent4Ip = "CIOR0375";//住院毒麻药是否录入代办人信息,参数默认值为N 参数说明：=Y时，在毒麻药签署时需要提醒医生录入代办人信息； =N时，在毒麻药签署时不需要提醒医生录入代办人信息
	public static final String SYS_PARAM_IntravenousDrugCreateMode = "CIOR0380";//CIOR0380 入壶类药品成组开单模式,参数值:0 用法开单,1用法要求开单;默认值:1
	public static final String SYS_PARAM_IpOrdDtEentryDefaultTime = "CIOR0385";//开始时间默认赋值配置时间    默认值：08:00:00		
	public static final String SYS_PARAM_BLOOD_WARNING = "CIOR0390";// 是否启用血液预警
	public static final String SYS_PARAM_IsOpenSugApt4IIH = "CIOR0400";//	是否启用IIH手术预约功能 IsOpenSugApt4IIH 	True 启用手术预约，False 不启用手术预约
	public static final String SYS_PARAM_IsOpenRisApt4IIH = "CIOR0405";//	是否启用IIH检查预约功能 IsOpenRisApt4IIH 	True启用检查预约，False 不启用检查预约
	public static final String SYS_PARAM_IsDisplayMkrMsApp4Op = "CIOR0410";//门急诊医生站是否启用门诊服务套 IsDisplayMkrMsApp4Op  ture 启用，false 不启用
	public static final String SYS_PARAM_WholepackOrderMpMode = "CIOR0415"; // 在院整领药品医嘱在院执行模式

	public static final String SYS_PARAM_PresOutpOrderMpMode = "CIOR0420"; // 出院带药医嘱在院执行模式

	public static final String SYS_PARAM_DrugCheckDisplayMd4IP = "CIOR0421"; // 住院服务参照药品显示模式，参数值：10商品模式，11商品大小包装模式
	public static final String SYS_PARAM_CIOR0421 = "CIOR0421"; // 获得住院服务参照药品显示模式值 @?? 重复

	public static final String SYS_PARAM_PresOutpOpenMd = "CIOR0422"; // 出院带药开立模式，参数值：0在住院医嘱中开立，1出院带药独立开立
	public static final String SYS_PARAM_DrugCheckDisplayMd4OP = "CIOR0423"; // 门诊服务参照药品显示模式，参数值：10商品模式，11商品大小包装模式
	public static final String SYS_PARAM_ActiveOrderSearchMd = "CIOR0430"; // 活动医嘱查询方案  系统级别参数 0按医嘱状态检索,1按医嘱开始结束时间检索
	public static final String SYS_PARAM_DrugCanOpenTotalDays = "CIOR0435";// 药品可开总用药天数（门急诊用）
	public static final String SYS_PARAM_SkinTestRoutes = "CIOR0440"; // 药品皮试医嘱默认用法
	public static final String SYS_PARAM_RoutesSkinTest = "CIOR0440"; // 药品皮试医嘱默认用法@?? 重复
	public static final String SYS_PARAM_Admission2HospitalPsn = "CIOR0445"; // 入院医嘱开立人编码
	public static final String SYS_PARAM_EffectOrderExcluedeIdSrvtp = "CIOR0450"; // 住院有效医嘱不校验服务类型
	public static final String SYS_PARAM_PoisDrugCanCreateLongTimeOrder = "CIOR0455"; // 毒麻药是否允许开立长期医嘱
	public static final String SYS_PARAM_PoisDrugCanCreateGroupOrder = "CIOR0456"; // 毒麻药是否允许开成组医嘱
	public static final String SYS_PARAM_CiPrnRis4ChisFlagParam = "CIOR0457"; // 打印检查申请单是否调用HIS预约中心检查申请接口
	
	public static final String SYS_PARAM_MustFillOrdesDrugCa = "CIOR0460";// 必须填写用法要求的药品分类集合
	
	public static final String SYS_PARAM_SpecantiDrugMMCA = "CIOR0464";// 【需审批的特殊级抗菌药自定义分类】机构级别参数 参数值：药品自定义分类主键串，应对BD_MMCA_US，支持多选。
	public static final String SYS_PARAM_HasBiologyTest4Ent = "CIOR0465";//【特殊级抗菌药微生物送检医嘱判断条件】参数值：判读条件sql串。国际医院条件串：本次就诊是否存在已开立、未作废fg_cnc的微生物送检项目；江苏省人民条件串：本次就诊是否存在已开立、未作废fg_cnc、已执行的微生物送检项目
    public static final String SYS_PARAM_SpecantiBiologyTestGrade = "CIOR0466";//【特殊级抗菌药微生物送检医嘱校验等级】参数值：0提醒、1限制。
    public static final String SYS_PARAM_BiologyTest4TempSpecantiFlag = "CIOR0467";//【临时特殊抗菌药是否需要做微生物送检医嘱校验】参数值：Y/N。
    public static final String SYS_PARAM_cancelMicrobeOrMd = "CIOR0468";//参数值：0禁止删除，1提示后可删除
    // 470以后为江苏临时参数
 	public static final String SYS_PARAM_WsHisAccessUrl = "CIOR0470";// 老HIS提供临床医嘱诊断同步服务
 	public static final String SYS_PARAM_WsYuDaAccessurl = "CIOR0471"; // HIS通知移动护理更新某些医嘱状态（主要用于医嘱停用）
 	public static final String SYS_PARAM_SendMessageUrl = "CIOR0475"; // 江苏省人民医院发送短信
 	public static final String SYS_PARAM_CanUseHisItf = "CIOR0479"; // HIs接口是否可用
 	// 480 为皮试逻辑参数
    public static final String SYS_PARAM_SkinTestVerifyMode = "CIOR0480";//【皮试校验模式】参数值：0医生判断，1系统判断
    public static final String SYS_PARAM_SkinTestNoRstOrderPhyMode = "CIOR0481";//【皮试结果未归时，用药医嘱开立模式】参数值：00禁止开立；10允许医生强制用药；11允许授权医生强制用药；20允许开立，在执行环节进行控制
    public static final String SYS_PARAM_SkinTestOrderCreateMode = "CIOR0482";//【皮试自动生成模式】参数值：1自动生成，2提示模式
    public static final String SYS_PARAM_SkinTestRstValidHours = "CIOR0483";//(废弃了)【皮试结果有效期】参数值：有效期时间单位为小时，参数支持小数
    public static final String SYS_PARAM_SkinTestExceptionDrugCreateMode = "CIOR0484";//【异常情况皮试强制用药开立模式】参数值：0允许全部医生强制用药；1允许授权医生强制用药；2禁止医生强制用药
    public static final String SYS_PARAM_SkinTestDrugDefaultMedu = "CIOR0485";//【原液皮试医嘱默认剂量】
    public static final String SYS_PARAM_SkinTestModel = "CIOR0486";//【皮试逻辑使用的模式】0，旧的逻辑；1，新的逻辑;默认使用新的逻辑
    public static final String SYS_PARAM_ValidateContinueExcDrug = "CIOR0487";//【皮试是否校验连续用药】
    public static final String SYS_PARAM_IsDifHrbPeparationInsamepres = "CIOR0488";//不同草药制剂类型是否允许开在同一处方，默认为true
    public static final String SYS_PARAM_IsOrTmplFilteByDi_op = "CIOR0489";//门诊医嘱模板助手是否自动按诊断过滤,默认为false
    public static final String SYS_PARAM_MERGETBUSENDTOMP = "CIOR0490";//门诊检验合单数据是否同步到执行
    //
	// 【江苏省医】=700
	public static final String SYS_PARAM_PresOutOrderSrvtp = "CIOR0490";// 出院带药可开立医嘱类型 // @?? 江苏=700
	public static final String SYS_PARAM_ORDPRN_REFINVOKE = "CIOR0491";// 医嘱单打印设置拼接信息的处理插件
	public static final String SYS_PARAM_IsOrdPrnCancPreson = "CIOR0492";//医嘱单作废打印时，是否打印“【取消】 作废人”标识
	public static final String SYS_PARAM_SRVPOIS_CHECK = "CIOR0493";// 毒麻药品审核
	public static final String SYS_PARAM_SkinTestDosage = "CIOR0494";// 皮试剂量是否减少1
	
	public static final String SYS_PARAM_OpenItemMaintainer = "CIOR0495";// 不可开立提示信息联系维护人
	// 【江苏省医】=702
	public static final String SYS_PARAM_PresOutOrderMaxPri = "CIOR0495";// 出院带药最大可开立金额 // @?? 江苏=702

	public static final String SYS_PARAM_ClinicalInfo_OP = "CIOR0496";// 门诊临床症状及体征默认提取规则
	// 【国际医院】=703
	//public static final String SYS_PARAM_ChenckDrugOpen = "CIOR0496";// @?? 国际 增加【药品物资流向科室处理模式】机构级别参数，参数值：0严格物资流向模式；1非严格物资流向模式（当物资流程返回为空时，医生可手动选择）。
	
	public static final String SYS_PARAM_CARBAPENEM = "CIOR0498";// 碳青霉烯类抗菌药及替加环素分类是由医院自定义的，因此想要确定此分类，需要将编码在这里维护，如果有多个，就用逗号隔开（不区分大小写）。
	public static final String SYS_PARAM_CONS_TO_CHECK = "CIOR0499";// 护士是否进行会诊确认操作,默认为false

	public static final String SYS_PARAM_AddExtra_Fgprn = "CIOR0500";// 医嘱单是否默认打印加顿药品医嘱
	// 【江苏省医】=704
	public static final String SYS_PARAM_CanOpenBloodOrderTitles = "CIOR0500";// 能够开输血项目的医师职称 @?? 江苏=704

	public static final String SYS_PARAM_IfShowDepWh = "CIOR0502";// 医嘱内容中是否拼接药房信息
	public static final String SYS_PARAM_FGWHOLEPACK_PRN = "CIOR0503";// 在院整领医嘱是否默认进行医嘱单打印
	public static final String SYS_PARAM_CLINICAL_VALIDATE = "CIOR0504";// 模板开立检查 的临床症状及体征信息是否校验

	public static final String SYS_PARAM_TSKJY_DEPT = "CIOR0505";// 特殊级抗菌药是否允许同科室医生会诊
	// 【国际医院】=706
	//public static final String SYS_PARAM_FromMr2CiDes_sympsign="CIOR0505";// @?? 国际=706 病历回写到病情描述  默认值：1主诉		参数值：2体格检查  3现病史   12主诉+体格检查  13主诉+现病史 23体格检查+现病史  0不回写
	
	// 【国际医院】=708
	public static final String SYS_PARAM_NeedOpenLisItemsBeforeBlood = "CIOR0505";// 输血前需开立的检验项目 @?? 江苏=708

	public static final String SYS_PARAM_FgLong_cancel = "CIOR0506";// 长期医嘱是否允许作废
	// 【国际医院】=710
	//public static final String SYS_PARAM_HerbOrderMpMode = "CIOR0506";  // @?? 国际=710 Mantis0144750: 1.	增加【草药医嘱在院执行模式HerbOrderMpMode】机构级别参数    1)参数值：00不在院用药执行；11全部在院用药执行    2)默认值：00不在院执行.
	
	public static final String SYS_PARAM_IsPrnBtnShow = "CIOR0507"; //历史就诊病历是否支持打印
	// 【国际医院】=712
	//public static final String SYS_PARAM_OPAPPDES="CIOR0507";  //添加【门诊申请单打印备注】机构级别参数。@?? 国际=712
	
	public static final String SYS_PARAM_OP_LIS_CREATEBLORDER = "CIOR0508";// 门诊检验合单是否生成采集费医嘱
	// 【国际医院】=714
	//public static final String SYS_PARAM_SpecialDrugMMCA_UnLimitTypeCode="CIOR0508";  //门诊不受30天开药限制药品分类编号 @?? 国际=714
	
	public static final String SYS_PARAM_ORDPRN_DRUG_MARK = "CIOR0509";// 医嘱单成组药品中间连接符配置
	// 【国际医院】=703
	//public static final String SYS_PARAM_OPAPPDES_DRUG="CIOR0509";  //添加【门诊申请单打印备注】机构级别参数 @?? 国际=716

	public static final String HERB_NOTEOR_PIINJIE = "CIOR0510";// 草药备注默认拼接规则
	// 【国际医院】=703
	//public static final String SYS_PARAM_ORDER_BACK_DRUG="CIOR0510";  //1，关联医嘱，2 不关联原医嘱 @?? 国际=718
	
	public static final String SIMPLE_ORDERTMPMODE = "CIOR0511";// 简易门诊医生站医嘱模板默认打开模式
	// 【国际医院】=720
	//public static final String SYS_PARAM_FromMr2OPClinicalzztzInfo="CIOR0511";// @?? 国际=720 门诊获取临床症状和体征  默认值：0 主诉+现病史+体格检查+既往史 		参数值:1主诉 2体格检查  3现病史 4既往史   12主诉+体格检查  13主诉+现病史 23体格检查+现病史 14主诉+既往史 24体格检查+既往史 34现病史+既往史 234体格检查+现病史+既往史
	
	public static final String CLINICAL_NOTICE = "CIOR0512";// 临床项目注意事项是否提醒住院医生
	// 【国际医院】=722
	//public static final String SYS_PARAM_OPRISIDSRVS="CIOR0512";// 门诊消化科指定检查服务ID串 @?? 国际=722
	
	public static final String SYS_PARAM_ChenckDrugOpen = "CIOR0513";// 药品物资流向科室处理模式
	// 【国际医院】=724
	//public static final String SYS_PARAM_PUHUA="CIOR0513";//  合理用药使用V2还是V3版本 @?? 国际=724
	
	public static final String HERBCARD_SIZEINFO = "CIOR0514";// 0171123: 门急诊医生，业务增加参数，可以设置草药卡大小，字号大小
    
	
	// 【国际医院】=550
		//public static final String SYS_PARAM_CdssTipsCtrl = "CIOR0514"; //cdss质控提示开关 @?? 国际=550
		public static final String PSN_PRES_RT           = "CIOR0515";//医师执业信息提示
		// 【国际医院】=726
		//public static final String SYS_PARAM_OPERATION_SEND_OUT ="CIOR0515";// 0，不发送，1微信，2短信，9全部 @?? 国际=726
		
		public static final String SYS_PARAM_ClinicalInfo_IP = "CIOR0516";// 住院临床症状及体征默认提取规则
		// 【国际医院】=728
		public static final String SYS_PARAM_PivasWhs = "CIOR0516";// 静配药房集合@?? 江苏=728
		// 【国际医院】=730
		//public static final String SYS_PARAM_OPERATION_SEND_WEIXIN ="CIOR0516";//  1微信 @?? 国际=730

		public static final String SYS_PARAM_ORDERQUANLIMIT = "CIOR0517";// 持有量校验
		// 【国际医院】=732
		//public static final String SYS_PARAM_OPERATION_SEND_SMS ="CIOR0517";// 2短信， @?? 国际=732
		
		public static final String SYS_PARAM_IP_LIS_CREATEBLORDER = "CIOR0518";// 住院检验合单是否生成采集费医嘱
		// 【国际医院】=734
		//public static final String SYS_PARAM_OPTREAT_EFFEDATE_DESC="CIOR0518";	// 门诊诊疗有效期提示内容 @?? 国际=734
		
		public static final String SYS_PARAM_IP_MERGETBUSENDTOMP = "CIOR0519";// 住院检验合单数据是否同步到执行
		// 【国际医院】=736
		//public static final String SYS_PARAM_OPPERB_EFFEDATE_DESC="CIOR0519";	// 门诊草药有效期提示内容 @?? 国际=736

		public static final String SYS_PARAM_CIOR0520 = "CIOR0520"; // 非药品医嘱首日执行次数是否默认加
		// 【江苏省医】=738
		public static final String SYS_PARAM_PivasBatchTime = "CIOR0520";// 静配中心配送时间点 @?? 江苏=738
		// 【国际医院】=740
		//public static final String SYS_PARAM_OPCOMDRUG_EFFEDATE_DESC="CIOR0520";// 门诊普通有效期提示内容 @?? 国际=740

		public static final String SYS_PARAM_ACTIVEORDERSEARCHMD = "CIOR0521";// 活动医嘱
		// 【国际医院】=742
		//public static final String SYS_PARAM_OPINJECT_EFFEDATE_DESC="CIOR0521";	// 门诊注射类药品有效期提示内容 @?? 国际=742
		
		public static final String SYS_PARAM_SEARCH_ORDER = "CIOR0522";// 医嘱查询接口回传的最大数量
		// 【国际医院】=746
		//public static final String SYS_PARAM_OPOP_EFFEDATE_DESC="CIOR0522";		// 门诊手术有效期提示内容 @?? 国际=746
		
		public static final String SYS_PARAM_OPBLOOD_EFFEDATE_DESC="CIOR0523";	// 门诊输血有效期提示内容

		public static final String SYS_PARAM_OUTORDERVALIDATETIME = "CIOR0524";// 是否校验今日出院医嘱签署必须是在所有医嘱开立或者停止时间以后
		// 【国际医院】=748
		//public static final String SYS_PARAM_OPRIS_EFFEDATE_DESC="CIOR0524";	// 门诊检查有效期提示内容 @?? 国际=748
		
		public static final String SYS_PARAM_IfChecked_CancOrStop  = "CIOR0525"; // 作废、停止操作成功后是否取消医嘱勾选
		// 【国际医院】=750
		//public static final String SYS_PARAM_OPLIS_EFFEDATE_DESC="CIOR0525";	// 门诊检验有效期提示内容 @?? 国际=750
		
		public static final String SYS_PARAM_PivasRoutes = "CIOR0526";// 静配中心配液用法集合 
		// 【国际医院】=752
		//public static final String SYS_PARAM_OPERATION_WEIXIN_ID ="CIOR0526";// 获取患者微信ID @?? 国际=752
		
		public static final String SYS_PARAM_NEWCONFIRMORD = "CIOR0527"; // 护嘱界面新确认医嘱标识配置
		// 【江苏省医】=754
		public static final String SYS_PARAM_IpCanActiveFirstDayMp = "CIOR0527";// 住院是否启用首日执行次数 @?? 江苏=754
		// 【国际医院】=756
		//public static final String SYS_PARAM_CHEMOTHERAPY_STOPVOMIT = "CIOR0527"; //启用止吐方案推荐科室集合 @?? 国际=756
		
		public static final String SYS_PARAM_IpDrugCycleCanSetDtEffe = "CIOR0528";// 住院是否按药品配送周期计算医嘱生效时间
		// 【国际医院】=750
		//public static final String SYS_PARAM_VOMITING_FOLLOW_UP = "CIOR0528";//调阅随访 @?? 国际=758
		 
		public static final String SYS_PARAM_indicationVerifyEnType = "CIOR0529";// 启用医保适应症校验就诊类型类型
		// 【国际医院】=760
		//public static final String SYS_PARAM_VOMITING_SEND_WECHATFWH = "CIOR0529";//呕吐医嘱发送微信给你患者 ，患者评估 @?? 国际=760
		
		public static final String SYS_PARAM_miRuleVerifyEnType = "CIOR0530";// 启用医保适规则校验就诊类型类型
		// 【国际医院】=762
		//public static final String SYS_PARAM_VOMITING_ASSESSMENT= "CIOR0530";//呕吐 ，患者评估记录 @?? 国际=762
		
		public static final String SYS_PARAM_ORDER_CANC= "CIOR0531";//医嘱单显示作废医生和时间
		
		// 【江苏省医】=764
		public static final String SYS_PARAM_IpAroundSugAfterTime = "CIOR0540";// 围手术期术后时间范围 @?? 江苏=764
		public static final String SYS_PARAM_CIOR0540 = "CIOR0540";
		
		public static final String SYS_PARAM_EMSITEM_CONFIG = "CIOR0541";//医疗单批量录入元素
	    public static final String SYS_PARAM_DRUGNAME_CONFIG = "CIOR0542";//护嘱药品显示属性配置
		public static final String SYS_PARAM_InvitedDepartment = "CIOR0545";// 受邀科室是否可操作会诊患者
		public static final String SYS_PARAM_CdssTipsCtrl = "CIOR0550";//CDSS惠每智能提示开关控制
		public static final String SYS_PARAM_HpConsent = "CIOR0555";//医保知情同意书提示开关
		
		public static final String SYS_PARAM_MaxCopyCount = "CIOR0560";// 医嘱可复制最大条数
		public static final String SYS_PARAM_StopValidateTime = "CIOR0570"; // 停止医嘱时是否校验停止时间
		public static final String SYS_PARAM_ModifyAuthPatOrder = "CIOR0575";//是否允许修改授权科室开立的授权患者的医嘱
		public static final String SYS_PARAM_MaxSrvRefQryNum = "CIOR0580"; // 服务参照查询结果集最大数量限制
		public static final String SYS_PARAM_ValidateAppendSpec = "CIOR0595";//是否校验补临时产生的特殊使用级抗菌药医嘱

		public static final String SYS_PARAM_CanUseBizEventMode = "CIOR0600"; // 是否启用业务插件模式处理后台业务
		
		
		public static final String SYS_PARAM_IsUseImportOldTmplData = "CIOR9910";//是否启用导入旧模板数据
		public static final String SYS_PARAM_ActivateNewOrTpl = "CIOR9911";//是否启用新模板

 

    
	public static final String SYS_PARAM_REVERSEHANDLE_CIORDCONFIRM="CIOR0605";//非持续医嘱停止/作废确认逆流程处理
	public static final String SYS_PARAM_ORDCONFIRMAXMAMOUNT="CIOR0606";//护嘱批量保存最大数量
	public static final String SYS_PARAM_REVERSEHANDLE_ALWAYSORDSCIORDCONFIRM="CIOR0605";//持续医嘱停止/作废确认逆流程处理
	public static final String SYS_PARAM_MODIFYINTERVAL="CIOR0543";//医嘱查询接口修改间隔时间
	
	public static final String SYS_PARAM_IsNeedCheckPatInfo ="CIOR0817";//需进行患者信息核对的毒麻分类
	
	/*******************************************
	 * 项目化参数定义
	 **********************************************************************/
	/**
	 * 获得参照药品分组显示集合模式值
	 */
	

	public static final String SYS_PARAM_IsErenMd = "LL_CIOR0315";// 添加【是否急诊就诊判断方式】IsErenMd ① 参数值：0就诊类型
	// 根据就诊类型判断是否是急诊就诊。，1就诊科室 根据就诊科室来判断是否是急诊就诊。
	public static final String SYS_PARAM_IsErenDeps = "LL_CIOR0320";// 添加【是否急诊就诊科室】 参数值为就诊科室，取【部门类型】= 01 临床的末级部门
	public static final String SYS_PARAM_IS_PRINT_RIS_PART = "LL_CIOR0410";//医嘱单打印上是否显示检查项目的身体部位
	public static final String NurOrderSaveSignVisuableParam = "LL_CIOR0415";//护嘱界面控制保存发送按钮是否合并
    public static final String SYS_PARAM_IS_PRINT_PRES_OUTP = "LL_CIOR0430";//出院带药是否在医嘱单打印中打印
    public static final String SYS_PARAM_LL_CIOR0436 = "LL_CIOR0436";//加开关，默认判定处方权，一个月后删除
	
    public static final String SYS_PARAM_IS_PRINT_CANC_CHK = "NX_CIOR0001";//医嘱单打印续打已作废医确认的医嘱不打印
    public static final String SYS_PARAM_NX_CIOR0002 = "NX_CIOR0002"; // 确认停止医嘱时，确认停止时间是否可以修改
    public static final String SYS_PARAM_NX_CIOR0003 = "NX_CIOR0003";//病历未完成是否允许诊毕

	public static final String SYS_PARAM_IS_PRINT_NURSE_CHK = "UL_CIOR0001";//医嘱单打印是否未护士确认后的医嘱
	
	public static final String SYS_PARAM_IS_PRINT_EXEC_SRC = "WW_CIOR0001";//住院临时医嘱单_执行人和执行时间的取值来源
	public static final String SYS_PARAM_WW_CIOR0005 = "WW_CIOR0005";// 接诊患者时是否进行欠费提醒

	public static final String SYS_PARAM_XH_CIOR0004 = "XH_CIOR0004";//住院病历完成是否允许修改诊断
	
	public static final String SYS_PARAM_YX_CIOR0001 = "YX_CIOR0001";//医保转自费是否校验医嘱状态
	
	public static final String SYS_PARAM_ZB_CIOR0002 = "ZB_CIOR0002";//住院医嘱模板默认适用范围
	
	public static final String SYS_PARAM_IsFirstDayMp = "ZZ_CIOR0002";// 是否首日执行
	public static final String SYS_PARAM_ZZ_CIOR0003 = "ZZ_CIOR0003";//医保转自费是否校验医嘱状态
	public static final String SYS_PARAM_XH_CIOR0015 = "XH_CIOR0015";// 检验条码规则自定义
	public static final String SYS_PARAM_XH_CIOR0020 = "XH_CIOR0020";// 检验条码规则是否启用 默认不启用
	/*****************************************************************************************************************/

	/**
	 * CIOR0005
	 * 医嘱或服务拆分截止时间与当前时间最大允许的天数间隔
	 */
	public static final Integer PARAMV_ORSRVSPLITDTENDMAXALLOWDAYS_DefaultV=15;
	
	/**
	 * 护士医嘱停止确认时，医嘱停止确认最大可提前时间（分钟）
	 */
	public static final Integer PARAMV_OrStopChkMaxLeadTime_DefaultV=1440;
	
	/**
	 * CIOR0165
	 * 是否开启皮试医嘱自动生成逻辑 
	 */
	public static final boolean PARAMV_IsAutoGenSkinTestOrEnable_DefaultV = true;//默认值常量
	
	/**
	 * CIOR0170
	 * 医嘱执行流向科室处理模式枚举值及默认值常量设置
	 */
	public static final String PARAMV_CiOrExFlowDeptHandleMode_DeptFlowCfg = "0"; // 0 流向配置模式
	public static final String PARAMV_CiOrExFlowDeptHandleMode_DeptFlowCfgPlus = "1"; //1 流向配置+模式  默认值
	public static final String PARAMV_CiOrExFlowDeptHandleMode_DefaultV = "1"; //默认值常量
	
	/**
	 * CIOR0175~CIOR0195
	 * 公共科室设置枚举值
	 */
	public static final String PARAMV_CiOrExFlowDefaultDeptSet_PvDept = "0"; // 0 就诊科室
	public static final String PARAMV_CiOrExFlowDefaultDeptSet_OrDept = "1"; // 1 开单科室
	public static final String PARAMV_CiOrExFlowDefaultDeptSet_NsDept = "2"; // 2 就诊病区
	
	/**
	 * CIOR0175
	 * 门诊执行流向默认科室设置
	 */
	public static final String PARAMV_CiOrExFlowDefaultDeptSet4Op_PvDept = "0"; // 0 就诊科室
	public static final String PARAMV_CiOrExFlowDefaultDeptSet4Op_OrDept = "1"; // 1 开单科室
	public static final String PARAMV_CiOrExFlowDefaultDeptSet4Op_DefaultV = "0"; // 0 就诊科室

	/**
	 * CIOR0180
	 * 住院诊执行流向默认科室设置
	 */
	public static final String PARAMV_CiOrExFlowDefaultDeptSet4Ip_PvDept = "0"; // 0 就诊科室
	public static final String PARAMV_CiOrExFlowDefaultDeptSet4Ip_OrDept = "1"; // 1 开单科室
	public static final String PARAMV_CiOrExFlowDefaultDeptSet4Ip_NsDept = "2"; // 2 就诊病区
	public static final String PARAMV_CiOrExFlowDefaultDeptSet4Ip_DefaultV = "2"; // 默认值常量
	
	/**
	 * CIOR0185
	 * 急诊诊执行流向默认科室设置
	 */
	public static final String PARAMV_CiOrExFlowDefaultDeptSet4Er_PvDept = "0"; // 0 就诊科室
	public static final String PARAMV_CiOrExFlowDefaultDeptSet4Er_OrDept = "1"; // 1 开单科室
	public static final String PARAMV_CiOrExFlowDefaultDeptSet4Er_NsDept = "2"; // 2 就诊病区
	public static final String PARAMV_CiOrExFlowDefaultDeptSet4Er_DefaultV = "0"; // 默认值常量
	
	/**
	 * CIOR0200
	 * 无皮试结果是否可先开立用药医嘱 
	 */
	public static final boolean PARAMV_IsAdmitDrugOrBeforeSkinTestRst_DefaultV = true;//默认值常量
	
	/**
	 * CIOR0205
	 * 医嘱费用清单数据范围设置参数
	 */
	public static final String PARAMV_CiOrChargeListDataRangeSet_AppMdCiFee = "01"; // 01 申请单模式下的临床项目费用
	public static final String PARAMV_CiOrChargeListDataRangeSet_AppMdTreatFee = "02"; // 02  申请单模式下的治疗操作费用
	public static final String PARAMV_CiOrChargeListDataRangeSet_TreatMdCiFee = "03"; // 03  治疗费用模式下的临床项目费用
	public static final String PARAMV_CiOrChargeListDataRangeSet_TreatMdTreatFee = "04"; // 04 治疗费用模式下的治疗操作费用
	public static final String PARAMV_CiOrChargeListDataRangeSet_DefaultV = ""; // 默认值常量
	
	/**
	 * 医嘱单签字模式
	 */
    public static final String PARAM_POSSIGNMODE_ALLPAGE_AUTO = "01";//整页手签（系统生成干系人信息）
    public static final String PARAM_POSSIGNMODE_ALLPAGE_MANU = "02";//整页手签（护士人工确认干系人）
    public static final String PARAM_POSSIGNMODE_EVERY_AUTO = "11";//逐条手签（系统批量处理相同干系人信息）
    public static final String PARAM_POSSIGNMODE_EVERY_MANU = "12";//逐条手签（系统不处理）
    public static final String PARAM_POSSIGNMODE_ELEC = "21";//电子签章

    /**
     * 医嘱单执行信息取值模式
     */
    public static final String PARAM_POSEXECUTINFOMODE_CHECK = "01";//医嘱确认信息
    public static final String PARAM_POSEXECUTINFOMODE_EXEC = "02";//实际执行信息
	
  //医生站金额取整模式
  	public static final String PARAM_OP_AMOUNT_ROUNDING ="CIOR00326";// 1 iih,2 其他
  	/**
  	 * CIOR0335    医嘱提前开立限制模式  	默认值：1禁止          参数值：0提醒，1禁止
  	 */
  	public static final String PARAM_IPORDEARLYENTRYTIPTP_ALLOW= "0";//0提醒
  	public static final String PARAM_IPORDEARLYENTRYTIPTP_UN= "1";//1禁止
  	/**
  	 * CIOR0340  开始时间默认赋值规则    默认值：2上条时间		参数值：0 当前时间，1配置时间，2上条时间
  	 */
  	public static final String PARAM_IPORDDTEENTRYDEFAULTSET_CUR = "0";//当前时间
  	public static final String PARAM_IPORDDTEENTRYDEFAULTSET_SET = "1";//配置时间
  	public static final String PARAM_IPORDDTEENTRYDEFAULTSET_FRONT = "2";//上条时间
  	/**
  	 * 入壶类药品成组开单模式
  	 */
  	public static final String SYS_PARAM_IntravenousDrugCreateMode_Route="0";//用法开单
  	public static final String SYS_PARAM_IntravenousDrugCreateMode_Routedes="1";//用法要求开单
	
  	
  	/**
  	 * CIOR0513 药品物资流向科室处理模式;0严格物资流向模式；1非严格物资流向模式（当物资流程返回为空时，医生可手动选
  	 */
    public static final String SYS_PARAM_ChenckDrugOpen_0 = "0"; // 0严格物资流向模式
    public static final String SYS_PARAM_ChenckDrugOpen_1 = "1"; // 1非严格物资流向模式（当物资流程返回为空时，医生可手动选
    
    /**
     * 非持续医嘱停止/作废确认逆流程处理
     */
    public static final String SYS_PARAM_REVERSEHANDLE_CIORDCONFIRM_0="0"; //系统不自动处理
    public static final String SYS_PARAM_REVERSEHANDLE_CIORDCONFIRM_1="1"; //用户判断系统处理
    public static final String SYS_PARAM_REVERSEHANDLE_CIORDCONFIRM_2="2"; //系统自动处理
    
}
