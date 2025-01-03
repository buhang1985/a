package iih.ci.mr.pub.MrConst;

public class IMrSysParamConst {

	/**
	 *  编辑器参数
	 */
	
	public static final String SYS_PARAM_EDITOR_STARTBORDERCHAR="CIMR0005"; //元素边界起始字符
	
	public static final String SYS_PARAM_EDITOR_ENDBORDERCHAR="CIMR0010"; //元素边界结束字符
	
	public static final String SYS_PARAM_EDITOR_SHOWRULE="CIMR0015"; //默认是否显示标尺 true:显示；false:不显示
	
	public static final String SYS_PARAM_EDITOR_BORDERSTYLE="CIMR0020"; //控件边框样式 1:三维边框；2:单行边框；3:无边框
	
	public static final String SYS_PARAM_EDITOR_BACKCOLOR="CIMR0025"; //控件背景色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_CURRENTPAGEBORDERCOLOR="CIMR0030"; //当前页边框颜色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_PAGEBORDERCOLOR="CIMR0035"; //页边框颜色 可为空 value格式为：#ffffff 
	
	public static final String SYS_PARAM_EDITOR_SHOWPARAGRAPHFLAG="CIMR0040"; //默认是否显示段落标记 true:显示；false:不显示
	
	public static final String SYS_PARAM_EDITOR_FIELDBACKCOLOR="CIMR0045"; //输入域默认背景色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_FIELDHOVERBACKCOLOR="CIMR0050"; //输入域默认鼠标悬浮背景色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_FIELDFOCUSEDBACKCOLOR="CIMR0055"; //输入域默认获得焦点背景色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_FIELDINVALIDATEVALUEFORECOLOR="CIMR0060"; //输入域内容校验不通过时的文本颜色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_FIELDINVALIDATEVALUEBACKCOLOR="CIMR0065"; //输入域内容校验不通过时的背景色 可为空 value格式为：#ffffff 
	
	public static final String SYS_PARAM_EDITOR_READONLYFIELDBORDERCOLOR="CIMR0070"; //内容只读的输入域的边界元素颜色 可为空 value为#ffffff
	
	public static final String SYS_PARAM_EDITOR_UNEDITABLEFIELDBORDERCOLOR="CIMR0075"; //内容不能直接修改的边界元素颜色
	
	public static final String SYS_PARAM_EDITOR_NORMALFIELDBORDERCOLOR="CIMR0080"; //常规的输入域的边界元素颜色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_TAGCOLORFORMODIFIEDFIELD="CIMR0085"; //元素修改后状态标识颜色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_TAGCOLORFORNORMALFIELD="CIMR0090"; //元素未修改状态标识颜色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_TAGCOLORFORREADONLYFIELD="CIMR0095"; //元素只读状态标识颜色 可为空 value格式为：#ffffff 
	
	public static final String SYS_PARAM_EDITOR_TAGCOLORFORVALUEINVALIDATEFIELD="CIMR0100"; //元素验证错误状态标识颜色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_SHOWINPUTFIELDSTATETAG="CIMR0105"; //是否显示状态标识颜色 true：显示；false：不显示
	
	public static final String SYS_PARAM_EDITOR_COPYMODEL="CIMR0110"; //数据复制粘贴模式 0：系统范围复制粘贴；1：程序范围复制粘贴；2：编辑器控件范围复制粘贴
	
	public static final String SYS_PARAM_EDITOR_SHOWCELLNONEBORDER="CIMR0115"; //隐藏表格边框 true：显示；false：隐藏
	
	public static final String SYS_PARAM_EDITOR_SHOWFORMBUTTON="CIMR0120"; //是否显示表单控件 true：显示；false：不显示
	
	public static final String SYS_PARAM_EDITOR_PARAGRAPHFLAGFOLLOWTABLEORSECTION="CIMR0125"; //表格后是否紧跟段落符号 true：是；false：否
	
	public static final String SYS_PARAM_EDITOR_AUTOASSISTINSERTSTRING="CIMR0130"; //是否输入联想 true：开启联想；false：关闭联想

	public static final String SYS_PARAM_EDITOR_AUTOSAVESECOND="CIMR0135"; //自动保存无操作时间，以秒为单位，若时间为0则不启用
	
	public static final String SYS_PARAM_EDITOR_REGISTERCODE="CIMR0140"; //注册码
	
	public static final String SYS_PARAM_EDITOR_SHOWTOOTH="CIMR0155";//科室病历工具条书否显示牙位图
	
	public static final String SYS_PARAM_EDITOR_CHINESECHILDDIAGINDENT="CIMR0180";//科室中医诊断子诊断是否缩进
	
	public static final String SYS_PARAM_EDITOR_CHINESEDIAGNUMBER="CIMR0185";//科室中医诊断是否带有序号
	
	public static final String SYS_PARAM_EDITOR_ENGLISHCHILDDIAGINDENT="CIMR0190";//科室西医诊断子诊断是否缩进
	
	public static final String SYS_PARAM_EDITOR_ENGLISHDIAGNUMBER="CIMR0195";//科室西医诊断是否带有序号
	
	public static final String SYS_PARAM_EDITOR_CHILD_DIAG_SPACE = "CIMR0200";//科室子诊断前空格
	
	public static final String SYS_PARAM_EDITOR_DIAG_SPACE = "CIMR0205";//科室诊断前空格
	
	public static final String SYS_PARAM_EDITOR_DIAG_SAME_LINE="CIMR0210";//科室诊断是否与标签同行
	
	public static final String SYS_PARAM_EDITOR_CHILD_DIAG_ISUSEORDER = "CIMR0485";//科室子诊断是否启用序号
	
	public static final String SYS_PARAM_EDITOR_CHILD_DIAG_SHOW_FormatStr ="CIMR0490";// 科室子诊断显示格式化字符串
	
	public static final String SYS_PARAM_EDITOR_MAIN_DIAG_SHOW_FormatStr = "CIMR0495"; //科室 主诊断 序号格式化
	
	public static final String SYS_PARAM_EDITOR_CONTINUE_PRINT_AUTO_ALIGN = "CIMR0465"; //续打是否启用自动对齐
	
	public static final String SYS_PARAM_EDITOR_ALLOW_USE_CELL_BORDERLINE= "CIMR0470";//允许使用表格的单元格边框线
	
	public static final String SYS_PARAM_EDITOR_Paper_Dir ="CIMR0550";//打印进纸方向
	
	public static final String SYS_PARAM_EDITOR_OutPatient_AutoZoom ="CIMR0570"; //门诊病历是否自动缩放
	
	/**
	 * 上报卡
	 */
	
	public static final String SYS_PARAM_CARD_CONTAGIONSENDMOBILE="CIMR0145";//传染病保存通知手机号集合，多个以逗号分隔
	
	
	/**
	 * 门诊召回
	 */
	public static final String SYS_PARAM_OP_RC_MAXDAYS="CIMR0150";//门诊病历召回最大申请天数
	
	public static final String SYS_PARAM_OP_RC_DEFAULTDAYS="CIMR0160";//门诊病历召回默认天数 
	
	/**
	 * 门诊病历自动归档标识
	 */
	public static final String SYS_PARAM_MRM_CI_AUTOPIGEONHOLE = "CIMRM0005";
	
	/**
	 * 门诊病历自动归档时间间隔（小时）
	 */
	public static final String SYS_PARAM_MRM_CI_PIGEONHOLEINTERVAL = "CIMRM0010";
	
	/**
	 * 住院病历自动归档标识
	 */
	public static final String SYS_PARAM_MRM_HO_AUTOPIGEONHOLE = "CIMRM0025";
	
	/**
	 * 住院病历自动归档时间间隔（天）
	 */
	public static final String SYS_PARAM_MRM_HO_PIGEONHOLEINTERVAL = "CIMRM0030";
	
	/**
	 * 住院病历自动完成标识
	 */
	public static final String SYS_PARAM_MRM_HO_AUTOCOMPLETE = "CIMRM0015";
	
	/**
	 * 住院病历自动完成时间间隔（天）
	 */
	public static final String SYS_PARAM_MRM_HO_COMPLETEINTERVAL = "CIMRM0020";
	
	/**
	 * 病历归档节假日
	 */
	public static final String SYS_PARAM_MRM_HOLIDAYS = "CIMRM0110";
	
	/**
	 * 是否推送数据到第三方系统（如病案系统）
	 */
	public static final String SYS_PARAM_MRM_SEND2OTHSYS = "CIMRM0115";
	
	/**
	 * 病案首页中西医分类
	 */
	public static final String SYS_PARAM_MRM_FPTP = "CIMRM0090";
	
	/**
	 * 门诊病历保存是否判断必填项
	 */
	public static final String SYS_PARAM_MR_CIMR_REQUIREDFIELD = "CIMR0165";
	
	/**
	 * 门诊病历保存是否判断互斥
	 */
	public static final String SYS_PARAM_MR_CIMR_MUTEXFIELD = "CIMR0170";
	
	/**
	 * 门诊病历打印是否预览
	 */
	public static final String SYS_PARAM_MR_CIMR_PRINTPREVIEW = "CIMR0175";
	/**
	 * 是否启用自动质控
	 */
	public static final String SYS_PARAM_MR_CIMR_AUTOQC = "CIMR0230";
	/**
	 * 是否启用环节质控
	 */
	public static final String SYS_PARAM_MR_CIMR_INTERQC = "CIMR0215";
	/**
	 * 是否启用科室质控
	 */
	public static final String SYS_PARAM_MR_CIMR_DEPTQC = "CIMR0220";
	/**
	 * 是否启用终末质控
	 */
	public static final String SYS_PARAM_MR_CIMR_TERMINALQC = "CIMR0225";
	/**
	 * 是否显示签名菜单
	 */
	public static final String SYS_PARAM_MR_SHOWSIGN="CIMR0235";
	/**
	 * 编辑器粘贴格式
	 */
	public static final String SYS_PARAM_EDITOR_DATAFORMAT="CIMR0240";
	/**
	 * 是否启用个人模板
	 */
	public static final String SYS_PARAM_EDITOR_PERSONIMPL="CIMR0245";
	/**
	 * 是否启用段落追加
	 */
	public static final String SYS_PARAM_MR_CIMR_PARAGRAPHADD="CIMR0250";
	
	/**
	 * 传染病附卡艾滋病确认检测单位参数
	 */
	public static final String SYS_PARAM_CONTAGION_AIDS_UNIT="CIMR0255";
	
	/**
	 * 转科时间控制病历操作参数
	 */
	public static final String SYS_PARAM_TRANSFERTIME_CONTROL="CIMR0260";
	

	/**
	 * 定点刷新时间
	 */
	public static final String SYS_PARAM_CONPASS_FIXEDTIME="CIMR0270";
	
	/**
	 * 刷新间隔时间
	 */
	public static final String SYS_PARAM_CONPASS_INTERVALTIME="CIMR0275";
	
	/**
	 * 是否启用动刷新
	 */
	public static final String SYS_PARAM_CONPASS_REFRUSHACTIVE="CIMR0280";
	
	/**
	 * 是否校验数据正确性
	 */
	public static final String SYS_PARAM_MR_CIMR_CHECK_DATA = "CIMR0285";
	
	/**
	 * 是否校验内容互斥
	 */
	public static final String SYS_PARAM_MR_CIMR_CHECK_RULE = "CIMR0290";
	
	/**
	 * 住院病历保存是否生成电子文档
	 */
	public static final String SYS_PARAM_MR_CIMR_SAVE_ELE="CIMR0385";
	
	/**
	 * 住院病历保存是否存源内容
	 */
	public static final String SYS_PARAM_MR_CIMR_SAVE_SOURCE="CIMR0390";
	
	/**
	 * 住院病历保存是否存引用内容
	 */
	public static final String SYS_PARAM_MR_CIMR_SAVE_REFDOC="CIMR0395";
	
	/**
	 * 住院病历提交是否生成电子文档
	 */
	public static final String SYS_PARAM_MR_CIMR_SUBMIT_ELE="CIMR0400";
	
	/**
	 * 住院病历提交是否存源内容
	 */
	public static final String SYS_PARAM_MR_CIMR_SUBMIT_SOURCE="CIMR0405";
	
	/**
	 * 住院病历提交是否存引用内容
	 */
	public static final String SYS_PARAM_MR_CIMR_SUBMIT_REFDOC="CIMR0410";
	/**
	 * 门诊病历保存是否生成电子文档
	 */
	public static final String SYS_PARAM_MR_CIMR_OUT_SAVE_ELE="CIMR0415";
	/**
	 * 门诊病历提交是否生成电子文档
	 */
	public static final String SYS_PARAM_MR_CIMR_OUT_SUBMIT_ELE="CIMR0420";
	/**
	 * 病案首页打印是否生成电子文档
	 */
	public static final String SYS_PARAM_MR_CIMRFP_PRINT_ISSAVEELEDOC="CIMR0425";
	/**
	 * 完成病历-病案首页是否生成电子文档
	 */
	public static final String SYS_PARAM_MR_CIMRFP_COMPLETE_ISSAVEELEDOC="CIMR0430";
	/**
	 * 是否开启病历超时申请
	 */
	public static final String SYS_PARAM_MR_OVERAPPLY="CIMR0295";
	/**
	 * 是否开启自动召回
	 */
	public static final String SYS_PARAM_MR_AUTORECALL="CIMR0300";
	/**
	 * 是否开启科室召回审核
	 */
	public static final String SYS_PARAM_MR_DEPRECALL="CIMR0305";
	/**
	 * 是否开启医务召回审核
	 */
	public static final String SYS_PARAM_MR_MEDRECALL="CIMR0310";
	/**
	 * 住院就诊查询是否展示新建病历
	 */
	public static final String SYS_PARAM_MR_SHOWNEWMR="CIMR0435";
	/**
	 * 电子病历浏览
	 */
	public static final String SYS_PARAM_MR_NOARCHIVE="CIMR0535";
	public static final String SYS_PARAM_MR_ARCHIVED="CIMR0540";
	/**
	 * 门诊自动签名方式
	 */
	public static final String SYS_PARAM_MR_OPAUTOSIGN="CIMR0545";

	/**
	 * 除常规编辑外其他的工作模式 输入域外
	 */
	public static final String SYS_PARAM_MR_READONLYLEVEL="CIMR0445";
	/**
	 * 制表符占位数
	 */
	public static final String SYS_PARAM_MR_TABCHARCOUNT="CIMR0450";
	
	/**
	 *是否启用病历多媒体
	 */
	public static final String SYS_PARAM_MR_MULMEDSTART="CIMR0460";
	
	/**
	 * 住院病历自动归档时间间隔（天）
	 */
	public static final String SYS_PARAM_MRM_RECALL_PIGEONHOLEINTERVAL = "CIMRM0120";
	
	/**
	 * 获取住院病历自动归档特殊设置
	 */
	public static final String SYS_PARAM_MRM_HO_COMPLETEINTERVAL_SPECIAL = "CIMRM0125";
	
	/**
	 * 获取是否开启审签
	 */
	public static final String SYS_PARAM_MR_SIGNLEVEL = "CIMR0455";
	
	/**
	 * 获取死亡报卡编码前缀
	 */
	public static final String SYS_PARAM_RCM_PREFIXCODE = "CIMRRCM0110";
	
	/**
	 * 获取死亡报卡医院邮编
	 */
	public static final String SYS_PARAM_RCM_ADMINCODE = "CIMRRCM0105";
	

	/**
	 * 病案首页中医打印
	 */
	public static final String CIMRFP_ZY_PRINT= "CIMR0555";
	
	
	/**
	 * 连续打印时多文档之间的间隔
	 */
	public static final String SYS_PARAM_MR_PRINTDOCSPACE="CIMR0440";


	/**
	 * 病案首页是否需要提交
	 */
	public static final String CIMRFP_IS_SUBMIT="CIMR0560";
	
	/**
	 * 上报数据来源
	 */
	public static final String SYS_PARAM_CIMRFP_REPORT_DATA_SRC = "CIMRFP0015";
	

	/**
	 * 病案文件名称
	 */
	public static final String CIMR_NAME="CIMR0565";

	/**
	 * 病案首页报表地址
	 */
	public static final String SYS_PARAM_MR_MRFP_REP_ADDR = "CIMR0360";
	
	/**
	 * CDSSdll路径
	 */
	public static final String SYS_PARAM_MR_CDSSDLLWAY = "CIMR0515";
	/**
	 * CDSS地址
	 */
	public static final String SYS_PARAM_MR_CDSSADDR = "CIMR0525";
	/**
	 * CDSSclass路径
	 */
	public static final String SYS_PARAM_MR_CDSSCLASSWAY = "CIMR0520";
	/**
	 * CDSS秘钥
	 */
	public static final String SYS_PARAM_MR_CDSSKEY = "CIMR0530";
	
	/**
	 * 病案签收规则包编码
	 */
	public static final String MR_MRSIGN_RULEPKG_CONST = "MR.MRSIGN.RULEPKG";
	
	/**
	 * 质控树显示病历文书状态
	 */
	public static final String SYS_PARAM_MRQC_MRTREECONTROL = "CIMRQC0030";
	
	/**
	 * 病案召回审批后自动提交时间（小时）
	 */
	public static final String SYS_PARAM_MRM_COMPLETEEDIT = "CIMRM0120";
	
	/**
	 * 是否使用监听发生病案接口数据
	 */
	public static final String SYS_PARAM_PUSHMR_BYMONITOR = "CIMR0685";
	
	/**
	 * 病案首页模式（中医/西医）
	 */
	public static final String MR_FP_TYPE = "CIMR0325";
	
	/**
	 *住院病案自动提交预警时限
	 */
	public static final String SYS_PARAM_MR_EARLY_WARNING_TIME = "CIMR0705";
	
	/**
	 *质控整改消息发送病历创建人诊疗组(默认false)
	 */
	public static final String SYS_PARAM_MRQC_MSG_TO_PSNS = "CIMRQC0050";
	/**
	 *编辑器应用态是否可以修改属性(默认false)
	 */
	public static final String SYS_PARAM_EDITOR_CAN_EDIT_ELEMENT_PROP = "CIMR0720";
	
	/**
	 * 死亡病例自动完成书写起始时间(默认 01：死亡时间)
	 */
	public static final String SYS_PARAM_MRM_DEATH_HO_COMPLETETIME = "CIMRM0155";
	
	/**
	 *死亡病例自动完成书写时间间隔(默认7天) 
	 */
	public static final String SYS_PARAM_MRM_DEATH_HO_COMPLETEINTERVAL = "CIMRM0160";
	
	/**
	 *死亡病例自动归档启始时间(默认 01：死亡时间) 
	 */
	public static final String SYS_PARAM_MRM_DEATH_HO_PIGEONHOLETIME = "CIMRM0165";
	
	/**
	 *死亡病例自动归档时间间隔(默认7天) 
	 */
	public static final String SYS_PARAM_MRM_DEATH_HO_PIGEONHOLEINTERVAL = "CIMRM0170";
	
	/**
	 * 死亡患者自动完成和归档是否单独任务(默认false)
	 */
	public static final String SYS_PARAM_DEATH_COMPLETE_PIGEONHOLE_ALONE = "CIMRM0175";
	
}
