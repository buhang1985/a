package iih.ci.sdk.order.itf;

/**
 * 医嘱执行器接口
 * @author wangqingzhu
 *
 */
public interface IOrderAction extends IOrderLoadBP, IOrderDeleteBP, IOrderSignBP, IOrderRevertBP, IOrderCopyBP,
		IOrderSaveAsBP, IOrderCancelBP, IOrderStopBP,IOrderSaveFeeBP {

}
