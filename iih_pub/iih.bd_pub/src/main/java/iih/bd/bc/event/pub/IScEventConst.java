package iih.bd.bc.event.pub;

/**
 * 预约域事件
 * @author yank
 *
 */
public class IScEventConst {
	//日志记录事件源
	public static final String EVENT_SOURCE_SC_LOG = "iih.sc.scbd.dto.d.ScLogEventDTO";
	
	//门诊预约事件源
	public static final String EVENT_SOURCE_SOURCE_SC_OP_APT = "iih.sc.apt.dto.d.OpApt4EsDTO";//门诊预约事件源
	
	//门诊排班停诊事件源
	public static final String EVENT_SOURCE_SOURCE_SC_OP_SCH_STOP = "iih.sc.apt.dto.d.OpSchStop4EsDTO";//门诊排班停诊事件源
		
	//医技预约事件源
	public static final String EVENT_SOURCE_SC_MT_APT = "iih.sc.apt.dto.d.MtApt4EsDTO";//医技预约事件源
	
	//手术预约事件源
	public static final String EVENT_SOURCE_SC_OPT_APT = "iih.sc.apt.dto.d.OptApt4OrmDTO";//手术预约事件源
	//住院预约事件源
	public static final String EVENT_SOURCE_SC_IP_APT = "sc_ip_apt";//住院预约事件源
	public static final String EVENT_SOURCE_SC_IP_CANC_APT = "sc_ip_canc_apt";//取消住院预约事件源
	public static final String EVENT_SOURCE_SC_IP_APT_APV = "sc_ip_apt_apv";//住院预约审核事件源
	public static final String EVENT_SOURCE_SC_IP_APT_CANC_APV = "sc_ip_apt_canc_apv";//住院预约取消审核事件源
	
	//事件类型,预约域43开头
	//门诊预约 4301-4320
	public static final String EVENT_SC_OP_APT= "4301";//门诊预约
	public static final String EVENT_SC_OP_APT_PAY= "4302";//门诊预约付费
	public static final String EVENT_SC_OP_APT_TAKE = "4303";//门诊预约取号
	public static final String EVENT_SC_OP_APT_AND_PAY = "4304";//门诊预约+收费
	public static final String EVENT_SC_OP_CANC_APT= "4306";//门诊预约取消
	public static final String EVENT_SC_OP_BREAK_APT= "4307";//门诊爽约
	
	//门诊排班 4381-4390
	public static final String EVENT_SC_OP_SCH_STOP = "4384";//门诊排班停诊
	//手术预约4321-4340
	public static final String EVENT_SC_OPT_APT= "4321";//手术预约
	//手术退约4321-4340
	public static final String EVENT_SC_OPT_CANC_APT= "4322";//手术预约
	//科室手术确认4321-4340
	public static final String EVENT_SC_OPT_APT_CONFIRM= "4323";//科室手术确认
	//科室手术取消确认4321-4340
	public static final String EVENT_SC_OPT_CANC_APT_CONFIRM= "4324";//科室手术取消确认
	
	//医技预约4321-4340
	public static final String EVENT_SC_MT_APT= "4341";//医技预约	
	public static final String EVENT_SC_MT_CAN_APT = "4342";//医技取消预约
	public static final String EVENT_SC_MT_AUTO_APT = "4343";// 医技自动预约
	
	
	//住院预约4361-4380
	public static final String EVENT_SC_IP_APT= "4361";//住院预约	
	
	//日志记录
	public static final String EVENT_SC_LOG_BASEDO = "4381";//记录do日志记录事件
	public static final String EVENT_SC_LOG_AGGDO = "4382";//记录aggdo日志记录事件
}
