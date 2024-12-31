package iih.bl.comm;

/**
 * 费用产生功能点常量
 * @author ly 2018/07/31
 *
 */
public interface IBlCgFuncConst {

	/*******费用域功能点*****/
	public static final String FUNC_IPBL_NURSE_ADDREFUNDCOST = "ipnurseaddrefundcost";//护士补退费
	public static final String FUNC_IPBL_COLLECTOR_ADDREFUNDCOST = "ipcollectoraddrefundcost";//住院补退费
	public static final String FUNC_IPBL_BACKKEEPACCOUNT = "ipbackkeepaccount";//后台记账
	public static final String FUNC_IPBL_REGISTER = "ipregister";//入院登记
	public static final String FUNC_OPBL_OPFEECOLLECT = "opfeecollectnew";//门诊收费

	/*******执行域功能点*****/
	public static final String FUNC_OPMP_MEDICINEDISPEND = "opmedicinedispend";//门诊发药
	public static final String FUNC_OPMP_OTCONFIRM = "opotconfirm";//医技执行确认(含取消)
	public static final String FUNC_OPMP_OTADDCOST = "opotaddcost";//医技补录(含退)
	
	public static final String FUNC_IPMP_MEDICINEDISPEND = "ipmedicinedispend";//住院发药
	public static final String FUNC_IPMP_OTCONFIRM = "ipotconfirm";//医技执行确认(含取消)
	public static final String FUNC_IPMP_OTADDCOST = "ipotaddcost";//医技补录(含退)
	public static final String FUNC_IPMP_SAMPLECOLLECT="ipsamplecollect";//床旁标本采集
	public static final String FUNC_IPMP_TRANSFUSION = "iptransfusion";//输血计费
	public static final String FUNC_IPMP_TRIRDCALLBS204 = "ipthirdcallBS204";//平台BS204消息消费
	public static final String FUNC_IPMP_MPCHARGING = "ipmpcharging";//执行记账
	public static final String FUNC_IPMP_NURWORKSTATION = "ipnurworkstation";//护士工作站
	public static final String FUNC_IPMP_OTSTATIONCONFIRM = "ipotstationconfirm";//医技工作站执行确认(含取消)
	
	/*******临床域功能点*****/
	public static final String FUNC_IPOR_DOCTORSTATION = "ipdoctorstation";//住院医生站
	public static final String FUNC_OPOR_DOCTORSTATION = "opdoctorstation";//门急诊医生站
	
	/*******就诊域功能点*****/
	public static final String FUNC_OPEN_OPREGISTER = "opregister";//门诊挂号
	
	/*******执行域功能点*******/
	public static final String FUNC_PI_PATREGISTER = "patregister";//患者注册
	
	/*******应急系统*******/
	public static final String FUNC_ESOE = "esoe";//应急系统
	
}
