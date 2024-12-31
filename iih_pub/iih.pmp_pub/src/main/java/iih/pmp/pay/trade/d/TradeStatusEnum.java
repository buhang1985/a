package iih.pmp.pay.trade.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface TradeStatusEnum {

    @DmEnumDesc(name="交易结果未知",description="交易记录创建后初始状态")
	public static final Integer TRADE_UNKNOWN=0; //交易结果未知
    @DmEnumDesc(name="支付成功",description="支付交易明确成功后状态")
	public static final Integer PAY_SUCCESS=1; //支付成功
    @DmEnumDesc(name="等待支付",description="预下单支付成功返回二维码后状态")
	public static final Integer PAY_WAIT=2; //等待支付
    @DmEnumDesc(name="支付失败",description="支付交易明确失败后状态")
	public static final Integer PAY_FAIL=3; //支付失败
    @DmEnumDesc(name="退款成功",description="退款交易明确成功后状态")
	public static final Integer REFUND_SUCCESS=4; //退款成功
    @DmEnumDesc(name="退款失败",description="退款交易明确失败后状态")
	public static final Integer REFUND_FAIL=5; //退款失败
    @DmEnumDesc(name="转入退款",description="转入退款")
	public static final Integer TURN_REFUND=6; //转入退款
    @DmEnumDesc(name="已关闭",description="已关闭")
	public static final Integer CLOSED=7; //已关闭
    @DmEnumDesc(name="已撤销",description="已撤销")
	public static final Integer REVOKED=8; //已撤销
    @DmEnumDesc(name="未支付",description="未支付")
	public static final Integer NOTPAY=9; //未支付
    @DmEnumDesc(name="退款中",description="退款中")
	public static final Integer REFUNDING=10; //退款中
}	
