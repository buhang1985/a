package iih.bd.bc.event.pub;

/**
 * 
 * 执行域事件
 * 
 * @author shaosq
 * @date 2016年9月5日 下午8:28:11
 */
public class IMpEventConst {

	// 自定义事件源
	public static final String EVENT_SOURCE_MP_AP_REQ = "MP_AP_REQ"; // 住院请求发药
	public static final String EVENT_SOURCE_MP_AP_PUT = "MP_AP_PUT"; // 住院发药确认
	public static final String EVENT_SOURCE_MP_OP_PUT = "MPOPPUT"; // 门急诊处方发药
	
	/**
	 * 医嘱状态变更
	 */
	public static final String EVENT_SOURCE_MP_OR_STATUS = "iih.mp.nr.msg.d.ExeInfoDTO";

	/**
	 * 标签打印获取标本号信息
	 */
	public static final String EVENT_SOURCE_MP_SAMPLEPRINT = "iih.mp.nr.event.d.SampleNoDTO";

	/**
	 * 生命体征信息事件源
	 */
	public static final String EVENT_SOURCE_MP_CIMRVSINFODTO = "iih.mp.nr.msg.cimrvsinfo.d.VitalSignInfoDTO";
	
	// 自定义事件类型
	public static final String EVENT_MP_AP_REQ = "4701"; // 住院请求发药

	/**
	 * 取消入科监听事件源
	 */
	public static final String EVENT_CANCEL_ENTER = "iih.en.pv.inpatient.dto.d.CancelEnterDept4EsDTO";
	
	/**
	 * BS315生命体征监听事件源
	 */
	public static final String EVENT_MP_VS_LISTENING = "MP_VS_LISTENING";
	
	/**
	 * BS450皮试结果监听事件源
	 */
	public static final String EVENT_MP_SKINTESTRSTTOIP = "iih.mp.nr.dto.sendskrsttoip.d.SendSkinTestRstToIPDTO";
	
	/**
	 * 生命体征信息事件类型
	 */
	public static final String EVENT_MP_NEW = "1"; // 生命体征新增
	public static final String EVENT_MP_UPDATE = "2"; // 生命体征修改
	public static final String EVENT_MP_SYN = "3"; // 同步第三方生命体征
	
	/**
	 * 检验医嘱执行状态
	 */
	public static final String ORDER_STATUS_CHECK_COLLECTION = "30"; // 标本采集
	public static final String ORDER_STATUS_CHECK_ACCEPT = "50"; // 标本签收
	public static final String ORDER_STATUS_CHECK_CONFIRM = "91"; // 检验报告已审核
	public static final String ORDER_STATUS_CHECK_REBACK = "78"; // 检验退检
	public static final String ORDER_STATUS_CANCEL = "79"; // 取消
	public static final String ORDER_STATUS_CHECK_CALLBACK = "100"; // 检验召回

	public static final String SD_THIRDPART_ORG = "001"; // 厂商（迅捷）
	public static final String SD_THIRDPART_ORG_PRODUCT = "00101"; // 厂商产品（LIS）

	public static final String SD_THIRDPART_CHK_ORG = "002"; // 检查厂商
	public static final String SD_THIRDPART_CHK_ORG_PRODUCT = "00201"; // 通用检查产品

	public static final String ORDER_REFUND_ENABLE = "3"; // 医嘱允许退费
	public static final String ORDER_REFUND_DISABLE = "1"; // 医嘱不允许退费

	public static final String CODE_FUNCCD_BS019 = "BS019"; // BS019
	public static final String CODE_FUNCCD_BS004 = "BS004"; // BS004
	public static final String CODE_FUNCCD_BS024 = "BS024"; // BS024
	public static final String ID_DOMAINID_BS004 = "04"; // BS004域ID
	/**
	 * 自定义事件源 （危机值警告通知）
	 */
	public static final String EVENT_SOURCE_MP_CRISISWARN = "iih.mp.nr.msg.warningnotice.d.WarnPatInfoDTO";

	/**
	 * 自定义事件类型（危机值警告通知）
	 */
	public static final String EVENT_SOURCETYPE_MP_CRISISWARN = "473001";

	/**
	 * 域ID
	 */
	public static final String DOMAIN_OP = "01";// 门诊
	public static final String DOMAIN_IP = "02";// 住院

	/**
	 * 门诊确费状态
	 */
	public static final String SD_FEE_COMFIRM = "1";// 确费
	public static final String SD_FEE_UNCOMFIRM = "0";// 退费

	/**
	 * 自定义事件类型(就诊域监听疼痛分变化)
	 */
	public static final String SD_PAIN_LEVEL = "4799"; // 疼痛等级事件类型

	/**
	 * 自定义事件类型(就诊域孕妇五色卡监听)
	 */
	public static final String SD_FIVE_COLOR = "4800"; // 孕妇五色卡等级事件类型
	
	/**
	 * 自定义事件类型(生命体征数据监听)
	 */
	public static final String SD_VS_DATA = "4888";
	
	/**
	 * 门诊药房窗口上线
	 */
	public static final String EVENTTP_PHARMWIN_ONLINE = "10";
	/**
	 * 门诊药房窗口下线
	 */
	public static final String EVENTTP_PHARMWIN_OFFLINE = "11";
	/**
	 * 门诊药房窗口暂停
	 */
	public static final String EVENTTP_PHARMWIN_PAUSE = "12";
	/**
	 * 门诊药房窗口叫号
	 */
	public static final String EVENTTP_PHARMWIN_CALLNUM = "20";
	/**
	 * 门诊药房窗口发药
	 */
	public static final String EVENTTP_PHARMWIN_DISP = "30";
	/**
	 * 门诊药房窗口获取到新处方
	 */
	public static final String EVENTTP_PHARMWIN_GETPRES = "40";
	
	/**
	 * 自定义事件源 （护理文书发送就诊状况值）
	 */
	public static final String EVENT_SOURCE_NMR_ENSTATUS = "iih.mp.mpbd.mpskdevent.d.NmrEventDTO";

	/**
	 * 检验报告信息保存
	 */
	public static final String EVENT_LISRPTINFO_SAVE = "iih.mp.nr.testreportinfo.d.TestReportInfoDTO";
	
	/**
	 * 皮试结果事件源
	 */
	public static final String EVENT_SKIN_TEST = "iih.ci.ord.skintest.d.CiSkinTestRstDO";
	
	/**
	 * 药物过敏事件源
	 */
	public static final String EVENT_DRUG_ALLERGY = "iih.pi.overview.overview.d.OverviewAggDO";
}
