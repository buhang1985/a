package iih.ci.ord.s.ems.ip.order;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ip.order.ICiIpOrderMainService;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.s.ems.base.BaseOrderMainService;
import iih.ci.ord.s.ems.itf.bp.IOrderCancelRevertBP;
import iih.ci.ord.s.ems.itf.bp.IOrderResearchBP;
import iih.ci.ord.s.ems.itf.bp.IOrderStopBP;
import iih.ci.ord.s.ems.itf.bp.IOrderStopRevertBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 
 * @author wangqingzhu
 *
 */
@Service(serviceInterfaces = { ICiIpOrderMainService.class }, binding = Binding.JSONRPC)
public class CiIpOrderMainServiceImpl extends BaseOrderMainService implements ICiIpOrderMainService {

	public CiIpOrderMainServiceImpl(){
		setOrderLoadAction(new OrderLoadAction());
		setOrderDeleteAction(new OrderDeleteAction());
		setOrderSignAction(new OrderSignAction());
		setOrderRevertAction(new OrderRevertAction());
		setOrderCancelAction(new OrderCancelAction());
		setOrderCancelRevertAction(new OrderCancelRevertAction());
		setOrderStopAction(new OrderStopAction());
		setOrderStopRevertAction(new OrderStopRevertAction());
		setOrderCopyAction(new OrderCopyAction());
		setOrderResearchAction(new OrderResearchAction());
	}
	
	
	
	@Override
	public OrderRstDTO load(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
	
		return super.load(ctx, arg);
	}
	


	@Override
	public OrderRstDTO stop(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		return orderStopAction.stop(ctx, arg);
	}



	private IOrderCancelRevertBP orderCancelRevertAction ;
	public IOrderCancelRevertBP getOrderCancelRevertAction() {
		return orderCancelRevertAction;
	}
	public void setOrderCancelRevertAction(IOrderCancelRevertBP orderCancelRevertAction) {
		this.orderCancelRevertAction = orderCancelRevertAction;
	}
	
	private IOrderStopBP orderStopAction ;
	public IOrderStopBP getOrderStopAction() {
		return orderStopAction;
	}
	public void setOrderStopAction(IOrderStopBP orderStopAction) {
		this.orderStopAction = orderStopAction;
	}

	private IOrderStopRevertBP orderStopRevertAction ;
	public IOrderStopRevertBP getOrderStopRevertAction() {
		return orderStopRevertAction;
	}
	public void setOrderStopRevertAction(IOrderStopRevertBP orderStopRevertAction) {
		this.orderStopRevertAction = orderStopRevertAction;
	}
	
	private IOrderResearchBP orderResearchAction ;
	public IOrderResearchBP getOrderResearchAction() {
		return orderResearchAction;
	}
	public void setOrderResearchAction(IOrderResearchBP orderResearchAction) {
		this.orderResearchAction = orderResearchAction;
	}
}
