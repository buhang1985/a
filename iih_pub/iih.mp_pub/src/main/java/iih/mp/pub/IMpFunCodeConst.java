package iih.mp.pub;

/**
 * @author 作者 :huang_junhao
 * @version 创建时间：2016年8月24日 上午9:16:24 类说明 FunCode
 */

public interface IMpFunCodeConst {

	/**
	 * 医技辅护士执行
	 */
	public static final String FUN_CODE_BEDSAMPCOLLECT = "472005"; // 床旁标本采集
	public static final String FUN_CODE_NURSENDSAMPLE = "472010"; // 标本送检

	/**
	 * 护理执行
	 */
	public static final String FUN_CODE_NURWORKSTATION = "473005"; // 护士工作站
	public static final String FUN_CODE_NURWORKMRSTATION = "473008"; // 病历护士工作站

	public static final String FUN_CODE_VSIGNCOLLECTSINGLE = "47301015"; // 体温单录入
	public static final String FUN_CODE_SIGNCOLLECT = "47301010"; // 体温单批量录入
	public static final String FUN_CODE_OPUVSINCOLLECT = "47301025"; // 门急诊体征采集
	public static final String FUN_CODE_PARTOGRAMCOLLECT = "47301028"; // 产程数据采集

	public static final String FUN_CODE_NSORDERCONFIRM = "47302005"; // 医嘱确认
	public static final String FUN_CODE_CAEXESHEETPRN = "47302010"; // 分类执行单打印
	public static final String FUN_CODE_NSMPLABELPRNT = "47302020"; // 标签打印
	public static final String FUN_CODE_FETCHBLOODPRINT = "47302023"; // 取血单打印
	public static final String FUN_CODE_BLOODTRANSEXEC = "47302025"; // 输血执行
	public static final String FUN_CODE_ORDEXECCONFIRM = "47302030"; // 医嘱执行确认
	public static final String FUN_CODE_SKINTESTRESULT = "47302033"; // 门急诊皮试结果录入

	public static final String FUN_CODE_EVAL4TOHOSP = "47303010"; // 入院评估
	public static final String FUN_CODE_TEMPERATURECHART = "47303010"; // 体温单
	
	public static final String FUN_CODE_TEMPCHART ="47303020";
	
	public static final String FUN_CODE_GENNERALNURSINGREC = "47303025"; // 一般护理记录
	public static final String FUN_CODE_HEALTHYEDUNSREG = "47303027"; // 健康教育记录
	public static final String FUN_CODE_EVERYDAYEVAL = "47303030"; // 疼痛评估
	public static final String FUN_CODE_CRITICALILLREC = "47303033"; // 危重症记录单
	public static final String FUN_CODE_ADLINDEXEVAL = "47303042"; // ADL指数评定
	public static final String FUN_CODE_NURDOC = "47304005"; // 护理文书
	public static final String FUN_CODE_NSRECORDTYPE = "47304005"; // 护理记录类型维护
	public static final String FUN_CODE_VITALSIGNTPL = "47304020"; // 生命体征模板维护
	public static final String FUN_CODE_NSRECCONTENTTMPL = "47304025"; // 护理记录内容模板维护

	/**
	 * 通用医技执行
	 */
	public static final String FUN_CODE_MTRISRSTENTER = "47409005"; // 检查结果录入
	public static final String FUN_CODE_MTLISRSTENTER = "47409010"; // 检验结果录入
	public static final String FUN_CODE_MTPATHGYRSTENTER = "47409020"; // 病理报告录入

	public static final String FUN_CODE_MTCROSSBTRSTENTER = "47409210"; // 交叉备血结果录入
	public static final String FUN_CODE_MTSENDBLOODOUTINV = "47409220"; // 发血出库

	public static final String FUN_CODE_EXECCONGIRM = "474005"; // 执行确认
	public static final String FUN_CODE_COMPENSATIONFEE = "474010"; // 医技补录项目
	public static final String FUN_CODE_EXECCANCEL = "474015"; // 执行取消
	public static final String FUN_CODE_COMPENSATIONFEEREFUND = "474020"; // 医技补录项目退费

	/**
	 * 药品服务
	 */
	public static final String FUN_CODE_WARDUNITAKESHEET = "47100520"; // 病区统领单
	public static final String FUN_CODE_WARDUNITAKEHERBSHEET = "47100525"; // 病区草药单
	public static final String FUN_CODE_WARDUNITAKESHEETQRY = "47100530"; // 病区统领单查询
	public static final String FUN_CODE_WARDUNITAKEHERBSHEETQRY = "47100535"; // 病区草药单查询
	public static final String FUN_CODE_SPECIALRETURNSHEET = "47100540"; // 特殊退药单

	public static final String FUN_CODE_BACKDRUGDISP = "47101010"; // 人工后台摆药
	public static final String FUN_CODE_CHERBBOIL = "47101020"; // 草药煎药登记
	public static final String FUN_CODE_CHERBBOILGIVE = "47101025"; // 草药煎药发放

	public static final String FUN_CODE_OPPRESAUDIT = "47102005"; // 门诊处方审核
	public static final String FUN_CODE_OPURGPRESDISP = "47102010"; // 门急诊处方发药
	public static final String FUN_CODE_OPURGHERBDISP = "47102015"; // 门急诊草药发药
	public static final String FUN_CODE_OPURGPRESRTN = "47102020"; // 门急诊处方退药
	public static final String FUN_CODE_OPURGDISPSEARCH = "47102025"; // 门急诊发药查询

	public static final String FUN_CODE_IPORDPHARMAUDIT = "47103005"; // 住院医嘱审核
	public static final String FUN_CODE_IPORDDISPEND = "47103010"; // 住院医嘱摆药
	public static final String FUN_CODE_WARDUNITAKEDISPEND = "47103015"; // 病区统领单西成药摆药
	public static final String FUN_CODE_WARDUNITAKEDISPENDHERB = "47103020"; // 病区统领单草药摆药
	public static final String FUN_CODE_IPDISPENDQRY = "47103025"; // 住院摆药查询
	public static final String FUN_CODE_WARDUNITAKEDISPENDBAT = "47103030"; // 病区统领单西成药批量摆药

	public static final String FUN_CODE_TRANSFUSIONMAN = "47104010"; // 输液登记
	public static final String FUN_CODE_TRANSFUSIONIMPL = "47104015"; // 输液执行

	public static final String FUN_CODE_SHEETTYPEMAINTAIN = "47109005"; // 药单类型维护

	/**
	 * 移动护理
	 */
	public static final String FUN_CODE_INFUEXEC = "58101000";// 输液执行
	public static final String FUN_CODE_INFUPATROL = "58103006";// 输液巡视
	public static final String FUN_CODE_SKIN = "58101006";// 皮试
	
	public static final String FUN_CODE_CONS_END = "46106035";//完成会诊
}
