package iih.pmp.pay.ord.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface OrdStatusEnum {

    @DmEnumDesc(name="支付结果未知",description="订单记录创建后的初始状态")
	public static final Integer UNKNOWN=0; //支付结果未知
    @DmEnumDesc(name="支付成功",description="订单对应支付交易成功后状态")
	public static final Integer PAID=1; //支付成功
    @DmEnumDesc(name="等待支付",description="订单对应预下单二维码请求成功后状态")
	public static final Integer WAIT_TO_PAY=2; //等待支付
    @DmEnumDesc(name="支付失败",description="订单支付交易明确失败后状态")
	public static final Integer FAIL=3; //支付失败
    @DmEnumDesc(name="转入退款",description="订单转入退款")
	public static final Integer TURN_REFUND=4; //转入退款    
    @DmEnumDesc(name="撤回",description="撤回")
   	public static final Integer REVERSE=5; //撤回
}	
