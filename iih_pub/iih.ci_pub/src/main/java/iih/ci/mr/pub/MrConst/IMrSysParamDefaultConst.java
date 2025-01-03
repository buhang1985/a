package iih.ci.mr.pub.MrConst;

public class IMrSysParamDefaultConst {

	/**
	 *  编辑器参数
	 */
	public static final String SYS_PARAM_EDITOR_STARTBORDERCHAR_DEFAULT="{"; //元素边界起始字符
	
	public static final String SYS_PARAM_EDITOR_ENDBORDERCHAR_DEFAULT="}"; //元素边界结束字符
	
	public static final String SYS_PARAM_EDITOR_SHOWRULE_DEFAULT="true"; //默认是否显示标尺 true:显示；false:不显示
	
	public static final String SYS_PARAM_EDITOR_BORDERSTYLE_DEFAULT="1"; //控件边框样式 1:三维边框；2:单行边框；3:无边框
	
	public static final String SYS_PARAM_EDITOR_BACKCOLOR_DEFAULT=""; //控件背景色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_CURRENTPAGEBORDERCOLOR_DEFAULT=""; //当前页边框颜色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_PAGEBORDERCOLOR_DEFAULT=""; //页边框颜色 可为空 value格式为：#ffffff 
	
	public static final String SYS_PARAM_EDITOR_SHOWPARAGRAPHFLAG_DEFAULT="true"; //默认是否显示段落标记 true:显示；false:不显示
	
	public static final String SYS_PARAM_EDITOR_FIELDBACKCOLOR_DEFAULT=""; //输入域默认背景色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_FIELDHOVERBACKCOLOR_DEFAULT=""; //输入域默认鼠标悬浮背景色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_FIELDFOCUSEDBACKCOLOR_DEFAULT=""; //输入域默认获得焦点背景色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_FIELDINVALIDATEVALUEFORECOLOR_DEFAULT=""; //输入域内容校验不通过时的文本颜色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_FIELDINVALIDATEVALUEBACKCOLOR_DEFAULT=""; //输入域内容校验不通过时的背景色 可为空 value格式为：#ffffff 
	
	public static final String SYS_PARAM_EDITOR_READONLYFIELDBORDERCOLOR_DEFAULT=""; //内容只读的输入域的边界元素颜色 可为空 value为#ffffff
	
	public static final String SYS_PARAM_EDITOR_UNEDITABLEFIELDBORDERCOLOR_DEFAULT=""; //内容不能直接修改的边界元素颜色  可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_NORMALFIELDBORDERCOLOR_DEFAULT=""; //常规的输入域的边界元素颜色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_TAGCOLORFORMODIFIEDFIELD_DEFAULT=""; //元素修改后状态标识颜色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_TAGCOLORFORNORMALFIELD_DEFAULT=""; //元素未修改状态标识颜色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_TAGCOLORFORREADONLYFIELD_DEFAULT=""; //元素只读状态标识颜色 可为空 value格式为：#ffffff 
	
	public static final String SYS_PARAM_EDITOR_TAGCOLORFORVALUEINVALIDATEFIELD_DEFAULT=""; //元素验证错误状态标识颜色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_SHOWINPUTFIELDSTATETAG_DEFAULT="true"; //是否显示状态标识颜色 true：显示；false：不显示
	
	public static final String SYS_PARAM_EDITOR_COPYMODEL_DEFAULT="0"; //数据复制粘贴模式 0：系统范围复制粘贴；1：程序范围复制粘贴；2：编辑器控件范围复制粘贴
	
	public static final String SYS_PARAM_EDITOR_SHOWCELLNONEBORDER_DEFAULT="true"; //隐藏表格边框 true：显示；false：隐藏
	
	public static final String SYS_PARAM_EDITOR_SHOWFORMBUTTON_DEFAULT="false"; //是否显示表单控件 true：显示；false：不显示
	
	public static final String SYS_PARAM_EDITOR_PARAGRAPHFLAGFOLLOWTABLEORSECTION_DEFAULT="true"; //表格后是否紧跟段落符号 true：是；false：否
	
	public static final String SYS_PARAM_EDITOR_AUTOASSISTINSERTSTRING_DEFAULT="false"; //是否输入联想 true：开启联想；false：关闭联想

	public static final String SYS_PARAM_EDITOR_AUTOSAVESECOND_DEFAULT="0"; //自动保存无操作时间，以秒为单位，若时间为0则不启用
	
	public static final String SYS_PARAM_EDITOR_REGISTERCODE_DEFAULT=""; //注册码
	
	public static final String SYS_PARAM_EDITOR_SHOWTOOTH_DEFAULT="false";//科室病历工具条书否显示牙位图
	
	public static final String SYS_PARAM_EDITOR_CHINESECHILDDIAGINDENT_DEFAULT="true";//科室中医诊断子诊断是否缩进
	
	public static final String SYS_PARAM_EDITOR_CHINESEDIAGNUMBER_DEFAULT="false";//科室中医诊断是否带有序号
	
	public static final String SYS_PARAM_EDITOR_ENGLISHCHILDDIAGINDENT_DEFAULT="true";//科室西医诊断子诊断是否缩进
	
	public static final String SYS_PARAM_EDITOR_ENGLISHDIAGNUMBER_DEFAULT="true";//科室西医诊断是否带有序号
	
	public static final String SYS_PARAM_EDITOR_CHILD_DIAG_SPACE_DEFAULT = "2";//科室子诊断前空格
	
	public static final String SYS_PARAM_EDITOR_DIAG_SPACE_DEFAULT = "2";//科室诊断前空格
	
	public static final String SYS_PARAM_EDITOR_DIAG_SAME_LINE_DEFAULT="false";//科室诊断是否与标签同行
	
	public static final String SYS_PARAM_EDITOR_CHILD_DIAG_ISUSEORDER_DEFAULT = "false"; //是否启用子诊断序号
	
	public static final String SYS_PARAM_EDITOR_CHILD_DIAG_SHOW_FormatStr_DEFAULT = "([子诊断序号])"; // 子诊断格式化字符串
	
	public static final String SYS_PARAM_EDITOR_MAIN_DIAG_SHOW_FormatStr_DEFAULT = "[主诊断序号]."; // 主诊断格式化字符串
	
	public static final String SYS_PARAM_EDITOR_CONTINUE_PRINT_AUTO_ALIGN_DEFAULT ="1"; //续打是否启用自动对齐
	
	public static final String SYS_PARAM_EDITOR_ALLOW_USE_CELL_BORDERLINE_DEFAULT= "0";//允许使用表格的单元格边框线
	
	public static final String SYS_PARAM_EDITOR_PAPER_DIR_DEFAULT = "2";//进纸方向默认值（默认跟随模板）
	
	public static final String SYS_PARAM_EDITOR_OutPatient_AutoZoom_DEFAULT ="true"; //门诊病历是否自动缩放
	
	public static final String SYS_PARAM_EDITOR_CAN_EDIT_ELEMENT_PROP_DEFAULT ="false"; //编辑器应用态是否可以修改属性(默认false)
	/**
	 * 上报卡
	 */
	public static final String SYS_PARAM_CARD_CONTAGIONSENDMOBILE_DEFAULT="";//传染病保存通知手机号集合，多个以逗号分隔
	
	/**
	 * 门诊召回最大天数
	 * 此数值需要不小于SYS_PARAM_OP_RC_DEFAULTDAYS_DEFAULT
	 */
	public static final String SYS_PARAM_OP_RC_MAXDAYS_DEFAULT="7";
	
	/**
	 * 病历召回默认天数
	 * 此数值需要不大于SYS_PARAM_OP_RC_MAXDAYS_DEFAULT
	 */
	public static final String SYS_PARAM_OP_RC_DEFAULTDAYS_DEFAULT="2";
	
	/**
	 * 门诊病历自动归档标识
	 */
	public static final Boolean SYS_PARAM_MRM_CI_AUTOPIGEONHOLE_DEFAULT = false;
	
	/**
	 * 门诊病历自动归档时间间隔（小时）
	 */
	public static final int SYS_PARAM_MRM_CI_PIGEONHOLEINTERVAL_DEFAULT = 3;
	
	/**
	 * 住院病历自动归档标识
	 */
	public static final Boolean SYS_PARAM_MRM_HO_AUTOPIGEONHOLE_DEFAULT = false;
	
	/**
	 * 住院病历自动归档时间间隔（天）
	 */
	public static final int SYS_PARAM_MRM_HO_PIGEONHOLEINTERVAL_DEFAULT = 7;
	
	/**
	 * 住院病历自动完成标识
	 */
	public static final Boolean SYS_PARAM_MRM_HO_AUTOCOMPLETE_DEFAULT = false;
	
	/**
	 * 住院病历节假日
	 */
	public static final String SYS_PARAM_MRM_HOLIDAYS_DEFAULT = "";
	
	/**
	 * 是否推送数据到第三方系统（如病案系统）
	 */
	public static final Boolean SYS_PARAM_MRM_SEND2OTHSYS_DEFAULT = true;
	
	/**
	 * 病案首页中西医分类
	 */
	public static final int SYS_PARAM_MRM_FPTP_DEFAULT = 1;
	
	/**
	 * 住院病历自动完成时间间隔（天）
	 */
	public static final int SYS_PARAM_MRM_HO_COMPLETEINTERVAL_DEFAULT = 3;
	
	/**
	 * 门诊病历保存是否判断必填项
	 */
	public static final Boolean SYS_PARAM_MR_CIMR_REQUIREDFIELD_DEFAULT =false;
	
	/**
	 * 门诊病历保存是否判断互斥
	 */
	public static final Boolean SYS_PARAM_MR_CIMR_MUTEXFIELD_DEFAULT = false;
	
	/**
	 * 门诊病历打印是否预览
	 */
	public static final Boolean SYS_PARAM_MR_CIMR_PRINTPREVIEW_DEFAULT = false;
	/**
	 * 是否启用自动质控
	 */
	public static final Boolean SYS_PARAM_MR_CIMR_AUTOQC_DEFAULT = true;
	/**
	 * 是否启用环节质控
	 */
	public static final Boolean SYS_PARAM_MR_CIMR_INTERQC_DEFAULT = true;
	/**
	 * 是否启用科室质控
	 */
	public static final Boolean SYS_PARAM_MR_CIMR_DEPTQC_DEFAULT = true;
	/**
	 * 是否启用终末质控
	 */
	public static final Boolean SYS_PARAM_MR_CIMR_TERMINALQC_DEFAULT = true;
	/**
	 * 是否显示签名菜单
	 */
	public static final Boolean SYS_PARAM_MR_SHOWSIGN_DEFAULT = true;
	/**
	 * 编辑器粘贴格式
	 */
	public static final String SYS_PARAM_EDITOR_DATAFORMAT_DEFAULT="0";
	/**
	 * 是否启用个人模板
	 */
	public static final Boolean SYS_PARAM_EDITOR_PERSONIMPL_DEFAULT=true;
	/**
	 * 是否启用段落追加
	 */
	public static final Boolean SYS_PARAM_MR_CIMR_PARAGRAPHADD_DEFAULT=true;
	/**
	 * 传染病附卡艾滋病确认检测单位参数
	 */
	public static final String SYS_PARAM_CONTAGION_AIDS_UNIT_DEFAULT="";
	
	/**
	 * 转科时间控制病历操作参数
	 */
	public static final String SYS_PARAM_TRANSFERTIME_CONTROL_DEFAULT="72";
	

	/**
	 * 定点刷新时间
	 */
	public static final String SYS_PARAM_CONPASS_FIXEDTIME_DEFAULT="11:30:00";
	
	/**
	 * 刷新间隔时间
	 */
	public static final String SYS_PARAM_CONPASS_INTERVALTIME_DEFAULT="30";
	
	/**
	 * 是否启用动刷新
	 */
	public static final Boolean SYS_PARAM_CONPASS_REFRUSHACTIVE_DEFAULT= Boolean.TRUE;
	
	/**
	 * 是否校验数据正确性
	 */
	public static final Boolean SYS_PARAM_MR_CIMR_CHECK_DATA_DEFAULT = Boolean.TRUE;
	
	/**
	 * 是否校验内容互斥
	 */
	public static final Boolean SYS_PARAM_MR_CIMR_CHECK_RULE_DEFAULT = Boolean.TRUE;
	
	/**
	 * 住院病历保存是否生成电子文档
	 */
	public static final Boolean SYS_PARAM_MR_CIMR_SAVE_ELE_DEFAULT=Boolean.FALSE;
	
	/**
	 * 住院病历保存是否存源内容
	 */
	public static final Boolean SYS_PARAM_MR_CIMR_SAVE_SOURCE_DEFAULT=Boolean.FALSE;
	
	/**
	 * 住院病历保存是否存引用内容
	 */
	public static final Boolean SYS_PARAM_MR_CIMR_SAVE_REFDOC_DEFAULT=Boolean.TRUE;
	
	/**
	 * 住院病历提交是否生成电子文档
	 */
	public static final Boolean SYS_PARAM_MR_CIMR_SUBMIT_ELE_DEFAULT=Boolean.TRUE;
	
	/**
	 * 住院病历提交是否存源内容
	 */
	public static final Boolean SYS_PARAM_MR_CIMR_SUBMIT_SOURCE_DEFAULT=Boolean.TRUE;
	
	/**
	 * 住院病历提交是否存引用内容
	 */
	public static final Boolean SYS_PARAM_MR_CIMR_SUBMIT_REFDOC_DEFAULT=Boolean.TRUE;
	/**
	 * 门诊病历保存是否生成电子文档
	 */
	public static final Boolean SYS_PARAM_MR_CIMR_SAVE_OUT_ELE_DEFAULT=Boolean.FALSE;
	/**
	 * 门诊病历提交是否生成电子文档
	 */
	public static final Boolean SYS_PARAM_MR_CIMR_SUBMIT_OUT_ELE_DEFAULT=Boolean.FALSE;
	/**
	 * 病案首页打印是否生成电子文档
	 */
	public static final Boolean SYS_PARAM_MR_CIMRFP_PRINT_ISSAVEELEDOC_DEFAULT=Boolean.FALSE;
	/**
	 * 完成病历-病案首页是否生成电子文档
	 */
	public static final Boolean SYS_PARAM_MR_CIMRFP_COMPLETE_ISSAVEELEDOC_DEFAULT=Boolean.TRUE;
	/**
	 * 是否开启病历超时申请
	 */
	public static final Boolean SYS_PARAM_MR_OVERAPPLY = false;
	/**
	 * 是否开启自动召回
	 */
	public static final Boolean SYS_PARAM_MR_AUTORECALL = false;
	/**
	 * 是否开启科室召回审核
	 */
	public static final Boolean SYS_PARAM_MR_DEPRECALL = false;
	/**
	 * 是否开启医务召回审核
	 */
	public static final Boolean SYS_PARAM_MR_MEDRECALL = false;
     /**
	 * 住院就诊查询是否展示新建病历
	 */
	public static final Boolean SYS_PARAM_MR_SHOWNEWMR = false;
	/**
	 * 电子病历浏览
	 */
	public static final String SYS_PARAM_MR_NOARCHIVE_DEFAULT = "2|3|4";
	public static final String SYS_PARAM_MR_ARCHIVED_DEFAULT="0";
	/**
	 * 门诊自动签名方式
	 */
	public static final String SYS_PARAM_MR_OPAUTOSIGN_DEFAULT = "0";

	/**
	 * 除常规编辑外其他的工作模式 输入域外
	 */
	public static final Integer SYS_PARAM_MR_READONLYLEVEL = 0;
	/**
	 * 制表符占位数
	 */
	public static final Integer SYS_PARAM_MR_TABCHARCOUNT = 4;
	/**
	 *是否启用病历多媒体
	 */
	public static final Boolean SYS_PARAM_MR_MULMEDSTART_DEFAULT=false;
	
	/**
	 * 住院病历自动归档时间间隔（天）
	 */
	public static final int SYS_PARAM_MRM_RECALL_PIGEONHOLEINTERVAL_DEFAULT = 1;
	
	/**
	 * 获取住院病历自动归档特殊设置
	 */
	public static final String SYS_PARAM_MRM_HO_COMPLETEINTERVAL_SPECIAL_DEFAILT = "";
	
	/**
	 * 获取死亡报卡编码前缀
	 */
	public static final String SYS_PARAM_RCM_PREFIXCODE_DEFAULT = "";
	
	/**
	 * 获取死亡报卡医院邮编
	 */
	public static final String SYS_PARAM_RCM_ADMINCODE_DEFAULT = "";
	
	/**
	 * 获取是否开启审签
	 */
	public static final Boolean  SYS_PARAM_MR_SIGNLEVEL_DEFAULT = false;
	/**
	 * 连续打印时多文档之间的间隔
	 */
	public static final Integer SYS_PARAM_MR_PRINTDOCSPACE = 8;
	/**
	 * 病案首页中医打印
	 */         
	public static final Boolean  CIMRFP_ZY_PRINT_DEFAULT = false;
	 /**
	 * 病案首页是否提交
	 */         
	public static final Boolean  CIMRFP_IS_SUBMIT = true;
	/**
	 * 上报数据来源
	 */
	public static final int  SYS_PARAM_CIMRFP_REPORT_DATA_SRC_DEFAULT = 2;
	
	/**
	 * 病案文件显示名称
	 */         
	public static final String  CIMR_NAME_DEFAULT = "1003";

	/**
	 * 病案首页报表地址
	 */
	public static final String  SYS_PARAM_MR_MRFP_REP_ADDR_DEFAILT = "iih_report//46401005_cimrfp//ci_mrfp_index(lanling).xml";
	
	/**
	 * CDSSdll路径
	 */
	public static final String SYS_PARAM_MR_CDSSDLLWAY_DEFAILT = "";
	/**
	 * CDSS地址
	 */
	public static final String SYS_PARAM_MR_CDSSADDR_DEFAILT = "";
	/**
	 * CDSSclass路径
	 */
	public static final String SYS_PARAM_MR_CDSSCLASSWAY_DEFAILT = "";
	/**
	 * CDSS秘钥
	 */
	public static final String SYS_PARAM_MR_CDSSKEY_DEFAILT = "";
	
	/**
	 * 质控树显示病历文书状态
	 */
	public static final String SYS_PARAM_MRQC_MRTREECONTROL = "";
	
	/**
	 * 病案召回审批后自动提交时间(小时)
	 */
	public static final int SYS_PARAM_MRM_COMPLETEEDIT = 0;
	
	/**
	 * 是否使用监听发生病案接口数据
	 */
	public static final Boolean SYS_PARAM_PUSHMR_BYMONITOR_DEFAULT = false;
	
	/**
	 * 病案首页模式（中医/西医）
	 */
	public static final String MR_FP_TYPE_DEFAULT = "2";
	
	/**
	 * 住院病案自动提交预警时限(默认8小时)
	 */
	public static final int SYS_PARAM_MR_EARLY_WARNING_TIME_DEFAULT = 8;
	
	/**
	 * 质控整改消息发送病历创建人诊疗组(默认false)
	 */
	public static final Boolean SYS_PARAM_MRQC_MSG_TO_PSNS = false;
	
	/**
	 * 死亡病例自动完成书写起始时间(默认 01：死亡时间)
	 */
	public static final String SYS_PARAM_MRM_DEATH_HO_COMPLETETIME = "01";
	
	/**
	 *死亡病例自动完成书写时间间隔(默认7天) 
	 */
	public static final int SYS_PARAM_MRM_DEATH_HO_COMPLETEINTERVAL = 7;
	
	/**
	 *死亡病例自动归档启始时间(默认 01：死亡时间) 
	 */
	public static final String SYS_PARAM_MRM_DEATH_HO_PIGEONHOLETIME = "01";
	
	/**
	 *死亡病例自动归档时间间隔(默认7天) 
	 */
	public static final int SYS_PARAM_MRM_DEATH_HO_PIGEONHOLEINTERVAL = 7;
	
	/**
	 * 死亡患者自动完成和归档是否单独任务
	 */
	public static final Boolean SYS_PARAM_DEATH_COMPLETE_PIGEONHOLE_ALONE = false;
	
}
