package iih.bd.bc.event.pub;

/**
 * 费用域事件常量
 * @author yankan
 *
 */
public interface IBlEventConst {
	//门诊事件源
	public static final String EVENT_SOURCE_OP_CHARGE = "iih.bl.cg.dto.d.OpCharge4EsDTO";//门诊收费事件源
	public static final String EVENT_SOURCE_OP_REFUND = "iih.bl.cg.dto.d.OpRefund4EsDTO";//门诊退费事件源
	public static final String EVENT_SOURCE_OP_REFUND_FOR_IP = "iih.bl.cg.dto.d.OpRefund4IpEsDTO";//门诊退费集成平台事件源
	public static final String EVENT_SOURCE_OP_ACC = "iih.bl.cg.dto.d.OpAcc4EsDTO";//门诊记账事件源
	public static final String EVENT_SOURCE_OP_CANC_ACC = "iih.bl.cg.dto.d.OpCancAcc4EsDTO";//门诊取消记账事件源	
	public static final String EVENT_SOURCE_OP_CC = "iih.bl.cc.dto.d.OpCc4EsDTO";//门诊结账事件源
	public static final String EVENT_SOURCE_OP_CANC_CC = "iih.bl.cc.dto.d.OpCancCc4EsDTO";//门诊取消结账事件源
	public static final String EVENT_SOURCE_OP_RECEIVE_PREPAY = "iih.bl.pay.dto.d.OpRcvPrepay4EsDTO";//门诊收取预交金事件源
	public static final String EVENT_SOURCE_OP_REFUND_PREPAY = "iih.bl.pay.dto.d.OpRefundPrepay4EsDTO";//门诊退预交金事件源
	public static final String EVENT_SOURCE_PREPAY = "iih.bl.pay.blpaypat.d.BlPrePayPatDO";//预交金收款事件
	public static final String EVENT_SOURCE_OEP_CHARGE = "iih.bl.st.dto.blpayoep.d.BlPayOepEventDTO";//门诊收费事件源(新)
	public static final String EVENT_SOURCE_OEP_REFUND = "iih.bl.st.dto.blpayoep.d.BlPayOepRefundEventDTO";//门诊退费事件源(新)
	public static final String EVENT_SOURCE_IPCG = "iih.bl.cg.blcgquery.d.BlCgIpDO";//住院记账事件
	public static final String EVENT_SOURCE_OP_CG = "iih.bl.cg.dto.cglogic.d.BlCgOepEventDTO";//门诊记账事件源(新)
	public static final String EVENT_SOURCE_ET_REFUND = "iih.bl.cg.blcgoep.d.BlCgItmOepDO";// 留观退记账事件
	/**
	 *以下属因迭代 已经不在事件中注册
	 */
	@Deprecated
	public static final String EVENT_IE_BL_OEP_CHARGE = "bl_oep_charge";    //门诊收费——收款确认
	@Deprecated
	public static final String EVENT_IE_BL_OEP_CHARGE_REFUND = "bl_oep_charge_refund";    //门诊退费——退款确认
	@Deprecated
	public static final String EVENT_SOURCE_BL_OEP_SETTLEMENT = "iih.bl.pub.dto.d.BlEventInfoDTO";    //事件源
	
	
	public static final String EVENT_TYPE_BL_OP_CHARGE = "4800";//门诊收费事件
	public static final String EVENT_TYPE_BL_OP_REFUND = "4805";//门诊退费事件
	
	public static final String EVENT_TYPE_OEP_CHARGE = "482001";//门诊收费事件(新)
	public static final String EVENT_TYPE_OEP_REFUND = "482002";//门诊退费事件(新)
	
	
	public static final String EVENT_TYPE_PREPAY_CHARGE = "483001";//预交金充值
	public static final String EVENT_TYPE_PREPAY_REFUND = "483002";//预交金退充值
	
	public static final String EVENT_TYPE_IPCG_CHARGE = "481001";//住院记账
	public static final String EVENT_TYPE_IPCG_REFUND = "481002";//住院退记账
	
	public static final String EVENT_TYPE_OPCG_CHARGE = "481003";//门诊记账新
	public static final String EVENT_TYPE_OPCG_CANC_CHARGE = "481004";//门诊退记账新
	
	public static final String EVENT_TYPE_ST_IP_PAY = "1002";//住院收付款
	
	public static final String EVENT_TYPE_ETCG_REFUND = "481005";//留观退记账
	
	
	/**
	 * 住院事件
	 */
	public static final String EVENT_BL_ST_IP_REF= "bl_st_ip_ref";//住院结算
	public static final String EVENT_BL_ST_IP_PAY = "bl_st_ip_pay";//住院结算收付款	
	public static final String EVENT_BL_CC_REF = "bl_cc_ref";//住院结账
	
	public static final String EVENT_BL_ST_IP_PAY_CLASS = "iih.bl.pub.dto.d.BlIihIeDTO";//住院结算收付款
}
